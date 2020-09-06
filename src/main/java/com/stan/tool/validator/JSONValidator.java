package com.stan.tool.validator;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @program: tool
 * @description: validate json string.
 * @author: largebear229@gmail.com
 * @create: 2020-09-05 21:01
 **/
@Component
public class JSONValidator implements Validator {
    private static final Logger logger = LoggerFactory.getLogger(JSONValidator.class);

    @Override
    public boolean supports(Class<?> aClass) {
        return String.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        String str = (String) o;
        try {
            new Gson().fromJson(str, JsonObject.class);
        } catch (Exception e) {
            logger.error("the str:{} is not a json str.",str);
            errors.reject("not a json string");
        }
    }
}