package com.applet.controller;


import com.applet.common.JsonWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@ApiOperation("测试类api")
@RestController
@RequestMapping("api")
public class TestController {
    @ApiOperation("翻转字符串")
    @ApiImplicitParam(name = "str", value = "原始字符串", paramType = "query", dataType = "string")
    @GetMapping("reverse")
    public JsonWrapper<String> reverse(@NotBlank(message = "输入字符串不能为空") String str) {
        return new JsonWrapper<>(new StringBuilder(str).reverse().toString());
    }

    @ApiOperation(value = "加法运算", notes = "两个整数相加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "x", value = "被加数", dataType = "int"),
            @ApiImplicitParam(name = "y", value = "加数", dataType = "int")
    })
    @GetMapping("add")
    public JsonWrapper<Integer> add(int x, int y) {
        return new JsonWrapper<>(x + y);
    }
}
