package com.wangzhu.utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestHttpClientUtils {

    private static final Logger logger = LoggerFactory
            .getLogger(TestHttpClientUtils.class);

    @Test
    public void testGetHttpResult() {
        final String url = "http://m.weather.com.cn/data/101110101.xml";
        String result = HttpClientUtils.getHttpResult(url);
        logger.info("TestHttpClientUtils testGetHttpResult url={},result={}", url, result);
    }

    @Test
    public void testGetFromJson() {
        final String url = "http://m.weather.com.cn/data/101110101.html";
        String result = HttpClientUtils.getHttpResult(url);
//		logger.info("TestHttpClientUtils testGetHttpResult jsonValue[title]={}", JSONUtils.getFromJson(result, "weatherinfo"));
//		logger.info("TestHttpClientUtils testGetHttpResult jsonValue[title]={}", JSONUtils.getFromJson(result, "weatherinfo", "city"));

    }

    @Test
    public void testCreateXML() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "名称");
        map.put("rank", "2");
        map.put("value", "82");
        logger.info("testCreateXML xmlStr:{}", XMLUtils.createXML("root", map));
    }

    @Test
    public void testReadFromXml() {
        final String url = "http://api.uihoo.com/mobile/mobile.http.php";
        String result = HttpClientUtils.postData(url,
                "mobile=13612907536&format=xml", "UTF-8");
        logger.info("testCreateXML xmlStr:{}", XMLUtils.readFromXml(result, "city"));
    }
}