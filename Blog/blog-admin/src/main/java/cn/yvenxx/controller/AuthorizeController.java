package cn.yvenxx.controller;

import cn.yvenxx.HttpStatusEnum;
import cn.yvenxx.R;
import cn.yvenxx.model.SysUser;
import cn.yvenxx.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;

@Api(tags = "认证")
@RequestMapping("/auth")
@RestController
public class AuthorizeController {
    @Autowired
    private UserService userService;
    @GetMapping("doLogin")
    @ResponseBody
    public R doLogin(SysUser user){
        String token = userService.doLogin(user.getUsername(),user.getPassword());
        if(token!=null){
            return R.ok(new Cookie("token",token),"登录成功");
        }
        return R.error(401,"登录失败，账号密码错误");
    }
}
