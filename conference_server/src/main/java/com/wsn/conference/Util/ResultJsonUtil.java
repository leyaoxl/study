package com.wsn.conference.Util;

import com.alibaba.fastjson.JSONObject;

public class ResultJsonUtil {
    public static JSONObject ResultJson(int code, boolean success, String message, Object data) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", code);
        resultJson.put("success", success);
        resultJson.put("message", message);
        resultJson.put("data", data);
        return resultJson;
    }

    public static JSONObject ResultJson(int code, boolean success, String message) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", code);
        resultJson.put("success", success);
        resultJson.put("message", message);
        return resultJson;
    }
}
