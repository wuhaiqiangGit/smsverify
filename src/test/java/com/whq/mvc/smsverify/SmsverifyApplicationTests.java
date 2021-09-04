package com.whq.mvc.smsverify;

import com.whq.mvc.dto.VerificationInfo;
import com.whq.mvc.handler.AbstractVerificationHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsverifyApplicationTests {

    @Resource
    private Map<String, AbstractVerificationHandler> verificationHandlerMap;

    @Test
    public void testGenerate() {
        AbstractVerificationHandler handler = verificationHandlerMap.get("sms");
        Map<String, Object> payload = new HashMap<>();
        payload.put("mobile","188201858**");
        VerificationInfo verificationInfo = handler.generateVerificationInfo(payload, 300);
        System.out.printf("verificationInfo: %s\n",verificationInfo.toString());
    }

    @Test
    public void testVerify(){
        AbstractVerificationHandler handler = verificationHandlerMap.get("sms");
        boolean verify = handler.verify("sms:0b4f93cfc45b4b8e8463b17bfa1c925b", "430891");
        System.out.printf("verify: %s\n",verify);
    }
}
