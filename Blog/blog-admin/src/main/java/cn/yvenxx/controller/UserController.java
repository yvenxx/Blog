package cn.yvenxx.controller;

import cn.yvenxx.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户管理")
@RequestMapping("/user")
public class UserController {
    @GetMapping("info")
    public R info(String id){
       return R.ok("asdf");
    }
}
