package cn.yvenxx.system.controller;


import cn.yvenxx.common.util.R;
import cn.yvenxx.system.entity.TUser;
import cn.yvenxx.system.service.ITUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class SysUserController
{
    @Autowired
    private ITUserService userService;
    /**
     * 获取当前用户信息
     * 需要验证权限
     */

    @GetMapping("/info/{username}")
    public R info(@PathVariable("username") String username){
        QueryWrapper<TUser> qw = new QueryWrapper<>();
        qw.eq("username",username);
        TUser user = userService.getOne(qw);
        return R.succ(user);
    }
}
