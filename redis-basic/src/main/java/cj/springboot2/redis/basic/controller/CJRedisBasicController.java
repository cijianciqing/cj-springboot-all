package cj.springboot2.redis.basic.controller;

import cj.springboot2.redis.basic.util.CJRedisCache;
import cn.com.ns.cj.cjuniversalspringbootstarter.returnData.CJAjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/redis")
public class CJRedisBasicController {

    @Autowired
    private CJRedisCache redisCache;

    @Value("${spring.application.name}")
    private String cjGlobalAppName;

    @GetMapping(value = "/{appValue}")
    public CJAjaxResult basicAdd(@PathVariable(value = "appValue",required = true) String appValue){
        redisCache.setCacheObject(cjGlobalAppName,appValue);
        return CJAjaxResult.success("成功保存到redis");
    }

    @GetMapping(value = "/getAppValue")
    public CJAjaxResult getAppValue(){
        String cacheObject = redisCache.getCacheObject(cjGlobalAppName);
        return CJAjaxResult.success("成功App Value", cacheObject);
    }

}
