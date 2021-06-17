package com.stan.tool.service;

import com.google.gson.JsonObject;
import com.stan.tool.model.dto.JsonCompareResult;

public interface JsonCompareService {
    JsonCompareResult compare(JsonObject a,JsonObject b);

    JsonCompareResult compare(String a, String b);
}
