package com.stan.tool.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.flipkart.zjsonpatch.JsonDiff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @program: tool
 * @description: compare the diff between the given two yaml file
 * @author: xxx@gmail.com
 * @create: 2021-06-17 17:55
 **/
public class YamlCompareUtil {

    private static final Logger logger = LoggerFactory.getLogger(ResponseUtil.class);

    public static String compareYamls(String sourceFile, String targetFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        JsonNode file1 = objectMapper.readTree(new File(sourceFile));
        JsonNode file2 = objectMapper.readTree(new File(targetFile));
        JsonNode patch = JsonDiff.asJson(file1, file2);
        String diffs = patch.toString();
        System.out.println(diffs);
        return diffs;
    }

    public static void main(String[] args) throws IOException {
        compareYamls("/Users/admin/Downloads/ccd-percy.yml","/Users/admin/Downloads/env.yml.txt");
    }
}