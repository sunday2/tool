package com.stan.tool.model.resp;

import lombok.Data;

/**
 * @program: tool
 * @description: response model
 * @author: largebear229@gmail.com
 * @create: 2020-09-05 16:41
 **/
@Data
public class RespVO {
    /**
     * error code
     */
    private String errCode;
    /**
     * response message
     */
    private String errMsg;
    /**
     * total count for query resule
     */
    private Long totalCount;
    /**
     * data
     */
    private Object data;

}