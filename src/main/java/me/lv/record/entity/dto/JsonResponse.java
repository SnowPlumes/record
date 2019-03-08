package me.lv.record.entity.dto;

import me.lv.record.constant.ResponseStatus;

/**
 * @author lv
 */
public class JsonResponse {
    private Integer code;
    private String msg;
    private Object results;

    public JsonResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    public static JsonResponse success(Object result) {
        JsonResponse json = new JsonResponse();
        json.setCode(ResponseStatus.SUCCESS);
        json.setResults(result);
        return json;
    }

    public static JsonResponse fail() {
        return fail(null);
    }

    public static JsonResponse fail(String msg) {
        JsonResponse json = new JsonResponse();
        json.setCode(ResponseStatus.FAIL);
        json.setMsg(msg);
        return json;
    }

    public static JsonResponse success() {
        return success(null);
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", results=" + results +
                '}';
    }
}
