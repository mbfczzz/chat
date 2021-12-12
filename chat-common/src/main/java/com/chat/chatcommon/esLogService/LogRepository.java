package com.chat.chatcommon.esLogService;


import com.chat.chatcommon.model.EsLog;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<EsLog,String> {

}
