/*
package com.argusfox.dataanalysis.moudles.grabinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

*/
/**
 * @author Fang Hao
 * @create 2018-06-20 15:03
 *//*

@Component
public class GrabRemote {
    private static final Logger logger = LoggerFactory.getLogger(GrabRemote.class);

    */
/**
     *
     *//*

    private static final String UPDATE_TREE_TYPE = "http://hd.chinatax.gov.cn/guoshui/action/updateTreeType.do";

    private static final String INIT_NEW_ARTICLE = "http://hd.chinatax.gov.cn/guoshui/action/InitNewArticle.do";

    private static final String CHANNEL_ID = "channelId";

    private static final String NAME = "name";

    private static final String RTOKEN = "rtoken";

    private static final String GET_ARTICLE_VIEW1 = "http://hd.chinatax.gov.cn/action/GetArticleView1.do";


    @Resource
    private RestTemplate restTemplate;

    public String updateTreeType() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, APPLICATION_FORM_URLENCODED_VALUE);
//        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("Host", "hd.chinatax.gov.cn");
        headers.set("Referer", "http://hd.chinatax.gov.cn/guoshui/main.jsp");
        headers.set("Origin", "http://hd.chinatax.gov.cn");
        headers.set("User-Agent", " Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.62 Safari/537.36");
//        Upgrade-Insecure-Requests: 1
//        User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.62 Safari/537.36



        MultiValueMap<String, String> map = new LinkedMultiValueMap<>(1);
        map.add("type", "349");
//        map.add("nevel", "");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(UPDATE_TREE_TYPE, request, String.class);
        return responseEntity.getBody();
    }

    public String nitNewArticle(String channelId, String name, String rtoken) {
        Map<String, String> map = new HashMap<>(3);
        map.put(CHANNEL_ID, channelId);
        map.put(NAME, name);
        map.put(RTOKEN, rtoken);
        return restTemplate.getForObject(getUrl(INIT_NEW_ARTICLE,map ), String.class);
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
        buffer.append(url).append("?");
        map.forEach((key, value) -> buffer.append(key).append("=").append(value).append("&"));
        buffer.deleteCharAt(buffer.length() - 1);
        logger.info("请求链接:{}", buffer.toString());
        return buffer.toString();
    }
}
*/
