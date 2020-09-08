package com.stan.tool.controlller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.stan.tool.model.resp.RespVO;
import com.stan.tool.service.JsonCompareService;
import com.stan.tool.util.ResponseUtil;
import com.stan.tool.validator.JSONValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: tool
 * @description: compare the json
 * @author: largebear229@gmail.com
 * @create: 2020-09-05 16:37
 **/
@Controller
@RequestMapping("/api/json")
public class JsonCompareController {

    private static final Logger logger = LoggerFactory.getLogger(JsonCompareController.class);

    @Autowired
    protected JSONValidator jsonValidator;

    @Autowired
    protected JsonCompareService jsonCompareService;

    @ResponseBody
    @PostMapping("/compare/result")
    public RespVO compare(@RequestBody String req, BindingResult result, HttpServletRequest httpRequest) {
        JsonObject reqJson = new Gson().fromJson(req,JsonObject.class);
//        this.jsonValidator.validate(reqJson.get("oldJson").getAsString(),result);
//        this.jsonValidator.validate(reqJson.get("newJson").getAsString(),result);
        if (result.hasErrors()) {
            logger.error("validate error.");
            StringBuilder sb = new StringBuilder();
            result.getAllErrors().stream().forEach(o->{
                sb.append(o.getCodes()[1]).append(";");
            });
            return ResponseUtil.error(sb.toString());
        } else {
            return ResponseUtil.success(jsonCompareService.compare(reqJson.getAsJsonObject("oldJson"),reqJson.getAsJsonObject("newJson")));
        }
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @GetMapping("compare")
    public String compare(){
        return "jsonCompare";
    }



}