package com.whq.mvc.handler;

import com.whq.mvc.generator.NumberVerificationCodeGenerator;
import com.whq.mvc.generator.UUIDVerificationKeyGenerator;
import com.whq.mvc.generator.VerificationCodeGenerator;
import com.whq.mvc.generator.VerificationKeyGenerator;
import com.whq.mvc.sms.SmsService;
import com.whq.mvc.store.VerificationStore;

import java.util.Map;

public class SmsNumberVerificationHandler extends AbstractVerificationHandler {


    private String name;
    private int len;
    private VerificationStore verificationStore;
    private VerificationKeyGenerator verificationKeyGenerator;
    private VerificationCodeGenerator verificationCodeGenerator;
    private SmsService smsService;

    public SmsNumberVerificationHandler(String name, int len) {
        this.name = name;
        this.len = len;
        this.verificationKeyGenerator = new UUIDVerificationKeyGenerator();
        this.verificationCodeGenerator = new NumberVerificationCodeGenerator(len);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public VerificationStore getVerificationStore() {
        return this.verificationStore;
    }

    @Override
    public VerificationKeyGenerator getVerificationKeyGenerator() {
        return this.verificationKeyGenerator;
    }

    @Override
    public VerificationCodeGenerator getVerificationCodeGenerator() {
        return this.verificationCodeGenerator;
    }

    @Override
    public int getEffectiveTime() {
        return 300;
    }

    @Override
    public String confusion(Map<String, Object> payload, String key, String code) {
        String mobile = (String) payload.get("mobile");
        //测试代码，控制台输出即可
        smsService.sendOnConsole(mobile, code, getEffectiveTime());
        return null;
    }

    public void setVerificationStore(VerificationStore verificationStore) {
        this.verificationStore = verificationStore;
    }

    public void setSmsService(SmsService smsService) {
        this.smsService = smsService;
    }
}
