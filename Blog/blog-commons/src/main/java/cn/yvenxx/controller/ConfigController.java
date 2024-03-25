package cn.yvenxx.controller;

import cn.yvenxx.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
@RequestMapping("/config")
public class ConfigController {

    private final RestTemplate restTemplate;

    @GetMapping("info")
    public R getConfig() {
        R forObject = restTemplate.getForObject("http://blog-admin/user/info", R.class);
        return forObject;
    }

    @GetMapping("test")
    public String getTest(){
        return "test";
    }
}
