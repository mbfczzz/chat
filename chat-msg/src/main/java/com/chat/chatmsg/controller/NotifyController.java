package com.chat.chatmsg.controller;

import com.chat.chatcommon.annotion.WebLog;
import com.chat.chatcommon.api.CommonResult;
import com.chat.chatmsg.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author mbfczzz
 */
@RestController
@RequestMapping("/notify")
public class NotifyController {

    @Autowired NotifyService notifyService;
    @WebLog(OperationModule = "消息通知", OperationTarget = "主动发送邮件")
    @RequestMapping("/activeSendEmail")
    public CommonResult sendEmail(List<Integer> id, Integer messageId) throws MessagingException {
            return CommonResult.SUCCESS("发送消息成功!");
    }
}
