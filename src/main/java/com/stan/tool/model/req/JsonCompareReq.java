package com.stan.tool.model.req;

import com.google.gson.JsonObject;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @program: tool
 * @description: request vo
 * @author: largebear229@gmail.com
 * @create: 2020-09-05 21:50
 **/
@Data
public class JsonCompareReq {

    @NotNull(message = "cannot be null")
    private JsonObject oldStr;

    @NotNull(message = "cannot be null")
    private JsonObject newStr;

}