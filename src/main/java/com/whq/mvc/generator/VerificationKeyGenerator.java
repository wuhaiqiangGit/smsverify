package com.whq.mvc.generator;

/**
 * @Description: 验证key生成接口
 * @Author: whq
 * @Date: 2021/9/4 11:01
 */
public interface VerificationKeyGenerator {

    //prefix key业务名称前缀
    String generate(String prefix);
}
