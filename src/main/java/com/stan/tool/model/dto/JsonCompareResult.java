package com.stan.tool.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @program: tool
 * @description: compare result
 * @author: largebear229@gmail.com
 * @create: 2020-09-06 11:49
 **/
@Data
public class JsonCompareResult {

    private String  aOnly;

    private String  bOnly;

    private List<ValueDiff> valueDiffs;

    @Data
    public static class ValueDiff{
        String key;
        String aValue;
        String bValue;
    }

}