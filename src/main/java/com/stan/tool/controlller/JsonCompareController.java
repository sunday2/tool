package com.stan.tool.controlller;

import com.stan.tool.model.req.JsonCompareReq;
import com.stan.tool.model.resp.RespVO;
import com.stan.tool.util.ResponseUtil;
import com.stan.tool.validator.JSONValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: tool
 * @description: compare the json
 * @author: largebear229@gmail.com
 * @create: 2020-09-05 16:37
 **/
@RestController
@RequestMapping("/api/json")
public class JsonCompareController {

    private static final Logger logger = LoggerFactory.getLogger(JsonCompareController.class);

    @Autowired
    protected JSONValidator jsonValidator;

    @PostMapping("/compare")
    public RespVO compare(@RequestBody @Validated JsonCompareReq req, BindingResult result, HttpServletRequest httpRequest) {
        logger.debug("come.......");
//        if (!result.hasErrors()) {
//            this.jsonValidator.validate(req.getOldStr(),result);
//            this.jsonValidator.validate(req.getOldStr(),result);
//        }
        if (result.hasErrors()) {
            logger.error("validate error.");
            StringBuilder sb = new StringBuilder();
            result.getAllErrors().stream().forEach(o->{
                sb.append(o.getCodes()[1]).append(";");
            });
            return ResponseUtil.error(sb.toString());
        } else {
            return ResponseUtil.success();
        }
    }



}