package com.wsn.conference.submission.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @author leyao
 * @version 2018-7-12
 */
public class ReturnUtil {
    /**
     * without data
     *
     * @param code 状态码
     * @param success 成功标志
     * @param message 处理信息
     * @return result
     */
    public static JSONObject returnUtil(int code, boolean success, String message) {
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("success", success);
        result.put("message", message);
        return result;
    }

    /**
     * with data
     *
     * @param code 状态码
     * @param success 成功标志
     * @param message 处理信息
     * @param data 返回数据
     * @return result
     */
    public static JSONObject returnUtil(int code, boolean success, String message, Object data) {
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("success", success);
        result.put("message", message);
        result.put("data", data);
        return result;
    }
}
