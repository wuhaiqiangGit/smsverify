package com.whq.mvc.cache;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisCache implements Cache {

    private StringRedisTemplate stringRedisTemplate;

    public RedisCache(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public Set<String> getKeys() {
        return stringRedisTemplate.keys("*");
    }

    @Override
    public boolean exists(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    @Override
    public void del(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, String value, Integer expire) {
        stringRedisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void expire(String key, int expire) {
        stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public void append(String key, String value) {
        stringRedisTemplate.opsForValue().append(key, value);
    }

    @Override
    public String getSet(String key, String newValue) {
        return stringRedisTemplate.opsForValue().getAndSet(key, newValue);
    }

    @Override
    public boolean setnx(String key, String value) {
        return stringRedisTemplate.opsForValue().setIfAbsent(key, value);
    }

    @Override
    public Long incrBy(String key, Long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }
}
