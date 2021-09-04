package com.whq.mvc.domain;

public enum CommonErrorCode implements ErrorCode {

    SUCCESS(0, "成功"),
    CUSTOM(999998, "自定义异常"),
    UNKNOWN(999999, "未知异常");

    private int code;
    private String desc;

    CommonErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /** 
     * @Description: 根据code获取error 
     * @Author: whq
     * @Date: 2021/9/4 10:25
     */
    public static CommonErrorCode getErrorByCode(int code){
        CommonErrorCode[] values = CommonErrorCode.values();
        for (int i = 0; i < values.length; i++) {
            CommonErrorCode errorCode = values[i];
            if (errorCode.getCode() == code){
                return errorCode;
            }
        }
        return null;
    }
    
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
