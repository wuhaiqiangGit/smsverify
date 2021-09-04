package com.whq.mvc.domain;

public class RestResponse<T> {

    private int code;
    private String msg;
    private T result;


    /**
     * @Description: 成功消息 ，无结果
     * @Author: whq
     * @Date: 2021/9/4 9:24
     */
    public static <T> RestResponse<T> success(){
        return new RestResponse<T>();
    }

    /**
     * @Description: 成功消息，有结果
     * @Author: whq
     * @Date: 2021/9/4 9:25
     */
    public static <T> RestResponse<T> success(T result){
        RestResponse<T> response = success();
        response.setMsg("正常");
        response.setResult(result);
        return response;
    }

    /**
     * @Description: 失败消息 code -1，无提示
     * @Author: whq
     * @Date: 2021/9/4 9:25
     */
    public static <T> RestResponse<T> fail(){
        RestResponse<T> response = fail("");
        return response;
    }

    /**
     * @Description: 失败消息 code -1，有提示
     * @Author: whq
     * @Date: 2021/9/4 9:26
     */
    public static <T> RestResponse<T> fail(String msg){
        RestResponse<T> response = fail(-1,msg);
        return response;
    }

    /**
     * @Description: 失败消息
     * @Author: whq
     * @Date: 2021/9/4 10:16
     */
    public static <T> RestResponse<T> fail(int code,String msg){
        RestResponse<T> response = new RestResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public RestResponse() {
        this(0,"");
    }

    public RestResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
