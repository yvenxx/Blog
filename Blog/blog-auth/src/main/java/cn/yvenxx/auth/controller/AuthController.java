package cn.yvenxx.auth.controller;

import cn.yvenxx.auth.service.ITUserService;
import cn.yvenxx.common.service.RedisService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户管理")
@AllArgsConstructor
public class AuthController {

    @Autowired
    private RedisService redisService;
    @Autowired
    ITUserService userService;

}
