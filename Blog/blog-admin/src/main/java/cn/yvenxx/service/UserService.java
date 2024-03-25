package cn.yvenxx.service;

import cn.yvenxx.model.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<SysUser> {
    SysUser getUserByUsername(String username);

    String doLogin(String username, String password);
}
