package com.upload.server.controller;

import com.upload.server.logger.CustomLogger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    @Autowired
    private CustomLogger cLogger;

    Logger logger = LoggerFactory.getLogger(CustomLogger.class);

    @GetMapping("/")
    public String hello() {
        logger.info(cLogger.info("logs1"));
        return "hello";
    }
}
