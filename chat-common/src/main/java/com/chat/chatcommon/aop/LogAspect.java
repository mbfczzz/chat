package com.chat.chatcommon.aop;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.chat.chatcommon.annotion.WebLog;
import com.chat.chatcommon.constant.AuthConstant;
import com.chat.chatcommon.constant.StatusCode;
import com.chat.chatcommon.exception.ParamException;
import com.chat.chatcommon.model.EsLog;
import com.chat.chatcommon.model.UserDto;
import com.chat.chatcommon.pojo.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Pointcut("@annotation(com.chat.chatcommon.annotion.WebLog)")
    public void logCut(){

    }

    @Around(value = "logCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("开始记录日志信息");
        EsLog es = new EsLog();
        Object result = proceedingJoinPoint.proceed();
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if(method.isAnnotationPresent(WebLog.class)){
            WebLog webLog = method.getAnnotation(WebLog.class);
            es.setOperatorModel(webLog.OperationModule());
            es.setOperatorTarget(webLog.OperationTarget());
        }
        ArrayList arrayList = new ArrayList();
        Object[] objects = proceedingJoinPoint.getArgs();
        for(int i=0;i<objects.length;i++){
            arrayList.add(objects[i]);
        }
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if(StrUtil.isEmpty(userStr)){
            arrayList.forEach(s->{
                if(s instanceof UserModel){
                    es.setOperator(((UserModel) s).getUsername());
                }
                else {
                    throw new ParamException(StatusCode.UN_LOGIN.getMessage());
                }
            });
        }
        else {
            UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
            es.setOperator(userDto.getUserName());
        }
        es.setRequestUrl(request.getRequestURL().toString());
        es.setRequestUri(request.getRequestURI());
        es.setOperatorIp(request.getRemoteAddr());
        es.setOperatorMethod(request.getMethod());
        es.setOperatorTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        es.setResult(result);
        es.setParameter(arrayList);
        rabbitTemplate.convertAndSend("admin-log-exchange","admin-log-key",es);
        log.info("{}",es);
        return result;
    }
}
