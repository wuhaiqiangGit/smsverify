package com.whq.mvc.generator;

import java.util.UUID;

/**
 * @Description: uuid生成key方式
 * @Author: whq
 * @Date: 2021/9/4 13:00
 */
public class UUIDVerificationKeyGenerator implements VerificationKeyGenerator {
    @Override
    public String generate(String prefix) {
        String uuid = UUID.randomUUID().toString();
        return prefix + uuid.replaceAll("-", "");
    }
}
