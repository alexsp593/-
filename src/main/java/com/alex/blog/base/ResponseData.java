package com.alex.blog.base;

import com.alex.blog.util.BigDecimalValueFilter;
import com.alex.blog.util.CollectionsUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 统一返回接口规范
 *
 * @author alex
 * @date 2019-09-11
 */
public class ResponseData<T> {

    public static final Integer SUCCESS_CODE = 200;
    public static final Integer DEFAULT_FAIL_CODE = 500;

    public ResponseData() {
    }

    public ResponseData(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
        this.result = SUCCESS_CODE.equals(code);
    }

    public ResponseData(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.result = SUCCESS_CODE.equals(code);
    }

    public ResponseData(Boolean result, Integer code, String message) {
        this.result = result;
        this.code = code;
        this.message = message;
    }

    public ResponseData(Boolean result, Integer code, String message, T data) {
        this.result = result;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseData(T data) {
        this.code = SUCCESS_CODE;
        this.message = "";
        this.data = data;
        this.result = true;
    }

    public ResponseData(Boolean result, Integer code, T data) {
        this.result = result;
        this.message = "";
        this.code = code;
        this.data = data;
    }

    public static <T> ResponseData<T> successResponse() {
        return valueOf(true, "", null, ResponseData.SUCCESS_CODE);
    }

    public static <T> ResponseData<T> successResponse(T data) {
        return valueOf(true, null, data, SUCCESS_CODE);
    }

    public static <T> ResponseData<T> successResponse(T data, String msg) {
        return valueOf(true, msg, data, SUCCESS_CODE);
    }

    public static <T> ResponseData<T> failResponse(String msg) {
        return valueOf(false, msg, null, ResponseData.DEFAULT_FAIL_CODE);
    }

    public static <T> ResponseData<T> failResponse(Integer code, String message) {
        return valueOf(false, message, null, code);
    }

    public static <T> ResponseData<T> failResponse(Integer code, T data) {
        return valueOf(false, "", data, code);
    }

    public static ResponseData failResponse(Integer code, String message, String... strings) {
        String msg = parseMessage(message, strings);
        return valueOf(false, msg, null, code);
    }

    public static String successResponseJson() {
        return successResponseJson(null);
    }

    public static <T> String successResponseJson(T data) {
        return valueOfJson(true, null, data, SUCCESS_CODE);
    }

    public static String failResponseJson(String message, String... strings) {
        return failResponseJson(DEFAULT_FAIL_CODE, parseMessage(message, strings));
    }

    public static String failResponseJson(Integer code, String message, String... strings) {
        return valueOfJson(false, parseMessage(message, strings), null, code);
    }

    private Integer code;
    private String message;
    private T data;
    private Boolean result;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 替换字符串中的参数
     *
     * @param message 需要解析的字符串
     * @param strings 用于替换message中的{0},{1}等
     * @return 解析后的字符串
     */
    private static String parseMessage(String message, String... strings) {
        for (int i = 0; i < strings.length; i++) {
            message = message.replaceAll("\\{" + i + "\\}", strings[i]);
        }
        return message;
    }

    private static final SerializeConfig CONFIG;

    static {
        CONFIG = new SerializeConfig();
        // 使用和json-lib兼容的日期输出格式
        CONFIG.put(java.util.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        // 使用和json-lib兼容的日期输出格式
        CONFIG.put(java.sql.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
    }

    private static final SerializerFeature[] FEATURES = {SerializerFeature.WriteMapNullValue,
            // 输出空置字段
            SerializerFeature.WriteNullListAsEmpty,
            // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero,
            // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse,
            // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty,
            // 字符类型字段如果为null，输出为""，而不是null
            SerializerFeature.DisableCircularReferenceDetect
    };

    public static String renderToJson(Object obj) {
        return JSON.toJSONString(obj, CONFIG, new BigDecimalValueFilter(), FEATURES);
    }

    public static String renderToJson(Object obj, Map<String, Class> clazzMap, Map<String, String> filterFiledMap) {
        List<SerializeFilter> filters = new ArrayList<>();
        filters.add(new BigDecimalValueFilter());
        if (!CollectionsUtil.isEmpty(clazzMap) && !CollectionsUtil.isEmpty(filterFiledMap)) {
            Set<String> keySet = clazzMap.keySet();
            for (String key : keySet) {
                String[] filterFields = filterFiledMap.get(key).split(",");
                SimplePropertyPreFilter filter = new SimplePropertyPreFilter(clazzMap.get(key), filterFields);
                filters.add(filter);
            }
        }
        SerializeFilter[] filterArray = new SerializeFilter[filters.size()];
        filters.toArray(filterArray);
        return JSON.toJSONString(obj, CONFIG, filterArray, FEATURES);
    }

    private static <T> ResponseData<T> valueOf(Boolean result, String msg, T data, Integer code) {
        ResponseData<T> cr = new ResponseData<>();
        cr.result = result;
        cr.message = msg;
        cr.data = data;
        cr.code = code;
        return cr;
    }

    private static <T> String valueOfJson(Boolean result, String message, T data, Integer code) {
        return JSONObject.toJSONString(valueOf(result, message, data, code));
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, CONFIG, new BigDecimalValueFilter(), FEATURES);
    }
}
