package cj.springboot2.template.web.basic.controller;

import cn.com.ns.cj.cjuniversalspringbootstarter.returnData.CJAjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/web/basic")
public class CJHelloWorld {

    @GetMapping(value = "/helloworld")
    public CJAjaxResult helloWorld(){
        log.info("cj.springboot2.template.web.basic.controller.CJHelloWorld.helloWorld()....");
       return CJAjaxResult.success("hello world , this is a new start !!!");
    }

}
