package cn.yvenxx.auth.controller;


import cn.yvenxx.auth.dto.UserDTO;
import cn.yvenxx.auth.service.ITUserService;
import cn.yvenxx.auth.vo.UserVO;

import cn.yvenxx.common.util.R;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Api(tags = "用户管理")
//@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    @Autowired
    ITUserService userService;
    @PostMapping("/login")
    public R login(@RequestBody UserDTO userDTO){
        // 从请求体中获取用户名密码
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        UserVO userVO = userService.doLogin(username, password);
        return R.succ(null);
    }
}
