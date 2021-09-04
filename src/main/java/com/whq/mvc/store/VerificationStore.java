package com.whq.mvc.store;

/**
 * @Description: 存储介质
 * @Author: whq
 * @Date: 2021/9/4 10:59
 */
public interface VerificationStore {

    void set(String key,String value,Integer expire);

    String get(String key);

    void del(String key);
}
