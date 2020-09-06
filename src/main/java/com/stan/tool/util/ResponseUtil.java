package com.stan.tool.util;

import com.stan.tool.common.Constant;
import com.stan.tool.model.resp.RespVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: tool
 * @description: generate response body
 * @author: largebear229@gmail.com
 * @create: 2020-09-05 22:34
 **/
public class ResponseUtil {

    private static final Logger logger = LoggerFactory.getLogger(ResponseUtil.class);

    public static RespVO success(Object data) {
        RespVO respVO = new RespVO();
        respVO.setErrCode(Constant.Api.SUCCESS_CODE);
        respVO.setData(data);
        return respVO;
    }

    public static RespVO success() {
        return success(null);
    }

    public static RespVO error(String errMsg) {
        RespVO respVO = new RespVO();
        respVO.setErrCode(Constant.Api.FAILURE_CODE );
        respVO.setErrMsg(errMsg);
        return respVO;
    }
}