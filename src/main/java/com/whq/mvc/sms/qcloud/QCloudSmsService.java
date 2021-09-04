package com.whq.mvc.sms.qcloud;

import com.whq.mvc.sms.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description: 运营商手机发送短信
 * @Author: whq
 * @Date: 2021/9/4 15:39
 */
@Slf4j
@Service
public class QCloudSmsService implements SmsService {
    @Override
    public void send(String mobile, String code, int effectiveTime) {
        //运营商发送短信实现
    }

    @Override
    public void sendOnConsole(String mobile, String code, int effectiveTime) {
        //控制台打印
        log.info("给手机号：{},发送验证码：{},有效时间为：{},请尽快输入！", mobile, code,effectiveTime);
    }
}
