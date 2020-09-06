package com.stan.tool.model.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @program: tool
 * @description: request vo
 * @author: largebear229@gmail.com
 * @create: 2020-09-05 21:50
 **/
@Data
public class JsonCompareReq {

    @NotBlank(message = "cannot be blank")
    private String oldJson;

    @NotBlank(message = "cannot be blank")
    private String newJson;

}