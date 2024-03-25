package cn.yvenxx.controller;

import cn.yvenxx.R;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(tags = "用户管理")
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final RestTemplate restTemplate;
    @Operation(summary = "test")
    @GetMapping("info")
    public R info(String id){
       return R.ok("asdf");
    }

    @RequestMapping(value = "/echo")
    public String echo() {
        return restTemplate.getForObject("http://config-server/config/test", String.class);
    }
}
