package cn.yvenxx.system.controller;

import cn.yvenxx.common.entity.TUser;
import cn.yvenxx.common.util.R;
import cn.yvenxx.common.vo.UserVO;
import cn.yvenxx.system.service.ITUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/userinfo")
public class UserInfoController
{
    @Autowired
    private ITUserService userService;
    /**
     * 获取当前用户信息
     */
    @GetMapping("/info")
    public R info(){
        return R.succ(userService.getUserInfoById(2));
    }
//    @GetMapping("/info/{username}")
//    public R info(@PathVariable("username") String username){
//        QueryWrapper<TUser> qw = new QueryWrapper<>();
//        qw.eq("name",username);
//        TUser user = userService.getOne(qw);
//        return R.succ(user);
//    }
    @PostMapping("/oauth")
    public UserVO getUserInfoByUsername(String username){
        if (username!=null){
            return userService.getUserInfoByUsername(username);
        }
        return null;
    }

}
