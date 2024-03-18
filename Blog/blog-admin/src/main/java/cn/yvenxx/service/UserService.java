package cn.yvenxx.service;

import cn.yvenxx.model.SysUser;
import org.springframework.stereotype.Service;

public interface UserService {
    SysUser getUserByUsername(String username);

    String doLogin(String username, String password);
}
