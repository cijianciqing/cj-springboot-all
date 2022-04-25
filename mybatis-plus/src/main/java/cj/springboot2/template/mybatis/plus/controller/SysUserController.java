package cj.springboot2.template.mybatis.plus.controller;


import cj.springboot2.template.mybatis.plus.entity.SysUserEntity;
import cj.springboot2.template.mybatis.plus.service.SysUserService;
import cn.com.ns.cj.cjuniversalspringbootstarter.returnData.CJAjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cj
 * @since 2022-04-25
 */
@RestController
@RequestMapping("/mybatis/plus/user")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;


    @GetMapping("/{userId}")
    public CJAjaxResult getUsers(@PathVariable(value = "userId",required = true) Long userId){
        SysUserEntity byId = sysUserService.getById(userId);
        return CJAjaxResult.success("成功返回所需用户", byId);
    }
}
