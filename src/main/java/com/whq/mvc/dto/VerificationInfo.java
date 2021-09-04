package com.whq.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/** 
 * @Description: 验证信息 
 * @Author: whq
 * @Date: 2021/9/4 13:02
 */
@Data
@AllArgsConstructor
public class VerificationInfo {
    
    private String key;
    private String content;
}
