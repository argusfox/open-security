/*
package com.argusfox.dataanalysis.moudles.remote;

import com.argusfox.dataanalysis.common.utils.MD5Utils;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

*/
/**
 * @author Fang Hao
 * @create 2018-06-01 15:30
 *//*

@Component
public class TaxApiRemote {
    private static final Logger logger = LoggerFactory.getLogger(TaxApiRemote.class);

//    private static final String baseUrl = "http://localhost:8080/api/tax/";
//    private static final String baseUrl = "http://test.igeshui.com/api/tax/";
//    private static final String baseUrl = "https://api.igeshui.com/api/tax/";
    private static final String baseUrl = "http://www.igeshui.com/api/tax/";
//    private static final String baseUrl = "http://192.168.100.68:29999/api/tax/";

    private static final String apiKey = "XW0101020000132165";
    private static final String apiSercret = "eb5b159b729e4fbcafc7a82e68b448dc";

    @Resource
    private RestTemplate restTemplate;

    */
/**
     * 2 获取城市信息
     *
     * @return
     *//*

    public String city() {
        Map<String, String> map = new HashMap<>();
        map.put("apiKey", apiKey);
        map.put("timestamp", System.currentTimeMillis() + "");
        map.put("sign", getSign(map));

        String body = restTemplate.getForObject(getUrl("city", map), String.class);
        return body;
    }

    */
/**
     * 3 获取站点信息
     *
     * @param cityId
     * @return
     *//*

    public String info(String cityId) {
        Map<String, String> map = new HashMap<>();
        map.put("apiKey", apiKey);
        map.put("timestamp", System.currentTimeMillis() + "");
        map.put("cityId", cityId);
        map.put("sign", getSign(map));

        String body = restTemplate.getForObject(getUrl("info", map), String.class);
        return body;
    }

    */
/**
     * 4 获取验证码
     *
     * @param orderNo
     * @param formId
     * @param refresh
     * @return
     *//*

    public String imgCode(String orderNo, String formId, String refresh) {
        Map<String, String> map = new HashMap<>();
        map.put("apiKey", apiKey);
        map.put("timestamp", System.currentTimeMillis() + "");
        map.put("sign", getSign(map));

        Map<String, String> map1 = new HashMap<>(3);
        map1.put("orderNo", orderNo);
        map1.put("formId", formId);
        map1.put("refresh", refresh);

        String body = getResult(getUrl("imgCode", map), map1);
        return body;
    }

    */
/**
     * 5 提交登陆请求
     *
     * @param orderNo
     * @param formId
     * @param cityId
     * @param loginParams
     * @return
     *//*

    public String submit(String orderNo, String formId, String cityId, Map<String, String> loginParams) {
        Map<String, String> map = new HashMap<>();
        map.put("apiKey", apiKey);
        map.put("timestamp", System.currentTimeMillis() + "");
        map.put("sign", getSign(map));

        Map<String, Object> map1 = new HashMap<>(4);
        map1.put("orderNo", orderNo);
        map1.put("formId", formId);
        map1.put("cityId", cityId);
        map1.put("loginParams", loginParams);
        String body = getResult(getUrl("submit", map), map1);
        return body;
    }

    */
/**
     * 6 轮询查询结果
     *
     * @param orderNo
     * @return
     *//*

    public String status(String orderNo) {
        Map<String, String> map = new HashMap<>();
        map.put("apiKey", apiKey);
        map.put("timestamp", System.currentTimeMillis() + "");
        map.put("orderNo", orderNo);
        map.put("sign", getSign(map));

        String body = restTemplate.getForObject(getUrl("status", map), String.class);
        return body;
    }

    */
/**
     * 7 获取纳税详情
     *
     * @param orderNo
     * @return
     *//*

    public String allDetail(String orderNo) {
        Map<String, String> map = new HashMap<>();
        map.put("apiKey", apiKey);
        map.put("timestamp", System.currentTimeMillis() + "");
        map.put("orderNo", orderNo);
        map.put("sign", getSign(map));

        String body = restTemplate.getForObject(getUrl("allDetail", map), String.class);
        return body;
    }

    */
/**
     * post请求 json
     *
     * @param url
     * @param map
     * @return
     *//*

    private String getResult(String url, Object map) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        String requestJson = new Gson().toJson(map, Map.class);
//        logger.info("请求体:{}", requestJson);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String result = restTemplate.postForObject(url, entity, String.class);
        return result;
    }

    */
/**
     * 请求url
     *
     * @param url
     * @param map
     * @return
     *//*

    private String getUrl(String url, Map<String, String> map) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(baseUrl).append(url).append("?");
        map.forEach((key, value) -> buffer.append(key).append("=").append(value).append("&"));
        buffer.deleteCharAt(buffer.length() - 1);
        logger.info("请求链接:{}", buffer.toString());
        return buffer.toString();
    }

    */
/**
     * 参数签名
     *
     * @param map
     * @return
     *//*

    private String getSign(Map<String, String> map) {
        Map<String, String> map1 = new TreeMap<>(Comparator.naturalOrder());
        map1.putAll(map);
        StringBuffer buffer = new StringBuffer();
        map1.forEach((key, value) -> buffer.append(key).append("=").append(value).append("&"));
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append(apiSercret);
        logger.info("签名参数:{}", buffer.toString());
        return MD5Utils.md5Encrypt(buffer.toString()).toUpperCase();
    }
}
*/
