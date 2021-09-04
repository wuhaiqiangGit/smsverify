package com.whq.mvc.generator;

import java.util.Random;

/**
 * @Description: 验证code生成方式
 * @Author: whq
 * @Date: 2021/9/4 13:05
 */
public class NumberVerificationCodeGenerator implements VerificationCodeGenerator {

    private int len;

    public NumberVerificationCodeGenerator(int len) {
        this.len = len;
    }

    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder(len);
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(String.valueOf(random.nextInt(10)));
        }
        return sb.toString();
    }
}
