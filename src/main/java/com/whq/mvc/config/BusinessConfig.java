package com.whq.mvc.config;

import com.whq.mvc.handler.AbstractVerificationHandler;
import com.whq.mvc.handler.SmsNumberVerificationHandler;
import com.whq.mvc.sms.qcloud.QCloudSmsService;
import com.whq.mvc.store.VerificationStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BusinessConfig {

    @Autowired
    private VerificationStore verificationStore;

    @Autowired
    private QCloudSmsService qCloudSmsService;

    @Bean
    public SmsNumberVerificationHandler smsNumberVerificationHandler() {
        SmsNumberVerificationHandler smsNumberVerificationHandler = new SmsNumberVerificationHandler("sms", 6);
        smsNumberVerificationHandler.setSmsService(qCloudSmsService);
        smsNumberVerificationHandler.setVerificationStore(verificationStore);
        return smsNumberVerificationHandler;
    }

    @Bean
    public Map<String, AbstractVerificationHandler> verificationHandlerMap() {
        SmsNumberVerificationHandler smsNumberVerificationHandler = smsNumberVerificationHandler();
        HashMap<String, AbstractVerificationHandler> verificationHandlerHashMap = new HashMap<>();
        verificationHandlerHashMap.put(smsNumberVerificationHandler.getName(), smsNumberVerificationHandler);
        return verificationHandlerHashMap;
    }
}
