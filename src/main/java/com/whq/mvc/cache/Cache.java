package com.whq.mvc.cache;

import java.util.Set;

public interface Cache {

    Set<String> getKeys();

    boolean exists(String key);

    void del(String key);

    void set(String key, String value);

    void set(String key,String value,Integer expire);

    String get(String key);

    void expire(String key, int expire);

    void append(String key, String value);

    String getSet(String key, String newValue);

    boolean setnx(String key, String value);

    Long incrBy(String key, Long delta);

}
