package com.whq.mvc.store;

import com.whq.mvc.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: redis存储介质
 * @Author: whq
 * @Date: 2021/9/4 12:56
 */
@Component
public class RedisStore implements VerificationStore {

    @Autowired
    private Cache cache;

    @Override
    public void set(String key, String value, Integer expire) {
        cache.set(key, value, expire);
    }

    @Override
    public String get(String key) {
        return cache.get(key);
    }

    @Override
    public void del(String key) {
        cache.del(key);
    }
}
