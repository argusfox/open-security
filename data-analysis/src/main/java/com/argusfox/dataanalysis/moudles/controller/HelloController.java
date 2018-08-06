package com.argusfox.dataanalysis.moudles.controller;

import com.argusfox.dataanalysis.moudles.TaxArticleService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;



@RestController
@RequestMapping("/argusfox/api")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private TaxArticleService taxArticleService;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/redis")
    public String redis() {
        stringRedisTemplate.opsForValue().set("123412423dsfjdsihgfhvgdsx", "hello world!", 1, TimeUnit.MINUTES);
        return stringRedisTemplate.opsForValue().get("123412423dsfjdsihgfhvgdsx");
    }

    @PostMapping("/taxInfo")
    public String redis(@RequestBody String body) {
        logger.info("taxInfo:{}", body);
        return body;
    }

    @GetMapping("/getTaxArticle")
    public String getTaxArticle() {
        taxArticleService.grabTaxArticle();
        return "success";
    }

}
