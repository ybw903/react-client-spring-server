package com.upload.server.logger;

import com.upload.server.domain.Logs;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomLogger {
   @Autowired
    MongoTemplate mongoTemplate;

   public String info(String message) {
       Logs logs = new Logs();
       logs.setLevel("INFO");
       logs.setMessage(message);
       logs.setDate(new Date());
       mongoTemplate.insert(logs);
       return message;
   }
}
