package com.whq.mvc.sms;

/**
 * @Description: 验证service
 * @Author: whq
 * @Date: 2021/9/4 15:43
 */
public interface SmsService {

    void send(String mobile,String code,int effectiveTime);

    void sendOnConsole(String mobile,String code,int effectiveTime);
}
