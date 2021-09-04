package com.whq.mvc.handler;

import com.whq.mvc.dto.VerificationInfo;
import com.whq.mvc.generator.VerificationCodeGenerator;
import com.whq.mvc.generator.VerificationKeyGenerator;
import com.whq.mvc.store.VerificationStore;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @Description: 验证处理抽象接口
 * @Author: whq
 * @Date: 2021/9/4 10:27
 */
public abstract class AbstractVerificationHandler {

    //业务名称
    public abstract String getName();

    //获取存储介质
    public abstract VerificationStore getVerificationStore();

    //验证生成key方式
    public abstract VerificationKeyGenerator getVerificationKeyGenerator();

    //验证生成code方式
    public abstract VerificationCodeGenerator getVerificationCodeGenerator();

    //key保留时间
    public abstract int getEffectiveTime();

    //业务执行流程
    public abstract String confusion(Map<String, Object> payload, String key, String code);

    //生成验证信息
    public final VerificationInfo generateVerificationInfo(Map<String, Object> payload, int effectiveTime) {
        effectiveTime = effectiveTime > 0 ? effectiveTime : getEffectiveTime();
        String key = getVerificationKeyGenerator().generate(getName() + ":");
        String code = getVerificationCodeGenerator().generate();
        String content = confusion(payload, key, code);
        getVerificationStore().set(key,code,effectiveTime);
        return new VerificationInfo(key,content);
    }

    //验证
    public final boolean verify(String verificationKey,String verificationCode){
        if (!StringUtils.hasLength(verificationKey) || !StringUtils.hasLength(verificationCode)){
            return false;
        }
        String code = getVerificationStore().get(verificationKey);
        if (StringUtils.hasLength(code) && code.equals(verificationCode)){
            getVerificationStore().del(verificationKey);
            return true;
        }
        return false;
    }
}
