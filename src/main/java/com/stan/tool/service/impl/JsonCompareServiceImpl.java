package com.stan.tool.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.stan.tool.model.dto.JsonCompareResult;
import com.stan.tool.service.JsonCompareService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tool
 * @description:
 * @author: largebear229@gmail.com
 * @create: 2020-09-06 15:42
 **/
@Service
public class JsonCompareServiceImpl implements JsonCompareService {
    @Override
    public JsonCompareResult compare(JsonObject a, JsonObject b) {
        JsonCompareResult compareResult = new JsonCompareResult();
        JsonObject aOnly = new JsonObject();
        JsonObject bOnly = new JsonObject();
        List<JsonCompareResult.ValueDiff> valueDiffs = new ArrayList<>();
        a.keySet().stream().forEach(o -> {
            if (!b.keySet().contains(o)) {
                aOnly.addProperty(o, a.get(o).getAsString());
            } else if (!a.get(o).getAsString().equals(b.get(o).getAsString())) {
                JsonCompareResult.ValueDiff valueDiff = new JsonCompareResult.ValueDiff();
                valueDiff.setKey(o);
                valueDiff.setA(a.get(o).getAsString());
                valueDiff.setB(b.get(o).getAsString());
                valueDiffs.add(valueDiff);
            }
        });
        b.keySet().stream().forEach(o->{
            if (!a.keySet().contains(o)) {
                bOnly.addProperty(o,b.get(o).getAsString());
            }
        });
        compareResult.setAOnly(aOnly.toString());
        compareResult.setBOnly(bOnly.toString());
        compareResult.setValueDiffs(valueDiffs);
        return compareResult;
    }


    @Override
    public JsonCompareResult compare(String a,String b) {
        JsonCompareResult compareResult = new JsonCompareResult();
        JSONObject json1 = JSONObject.parseObject(a);
        JSONObject json2 = JSONObject.parseObject(b);
        JSONObject aOnly = new JSONObject();
        JSONObject bOnly = new JSONObject();
        List<JsonCompareResult.ValueDiff> valueDiffs = new ArrayList<>();
        json1.keySet().stream().forEach(o->{
            if (!json2.keySet().contains(o)){
                aOnly.put(o, json1.get(o).toString());
            } else if (!json1.get(o).toString().equals(json2.get(o).toString())) {
                JsonCompareResult.ValueDiff valueDiff = new JsonCompareResult.ValueDiff();
                valueDiff.setKey(o);
                valueDiff.setA(json1.get(o).toString());
                valueDiff.setB(json2.get(o).toString());
                valueDiffs.add(valueDiff);
            }
        });
        json2.keySet().stream().forEach(o->{
            if (!json1.keySet().contains(o)) {
                bOnly.put(o,json2.get(o).toString());
            }
        });
        compareResult.setAOnly(aOnly.toString());
        compareResult.setBOnly(bOnly.toString());
        compareResult.setValueDiffs(valueDiffs);
        return compareResult;

    }
}