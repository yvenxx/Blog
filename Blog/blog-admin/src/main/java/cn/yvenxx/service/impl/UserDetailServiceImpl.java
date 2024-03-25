package cn.yvenxx.service.impl;

import cn.yvenxx.mapper.SysUserMapper;
import cn.yvenxx.model.SysUser;
import cn.yvenxx.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl  extends ServiceImpl<SysUserMapper,SysUser> implements UserDetailsService,UserService{
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = getUserByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("This username didn't exist.");
        }
        return new User(sysUser.getUsername(), sysUser.getPassword(), sysUser.getRole());
    }
    @Override
    public SysUser getUserByUsername(String username) {
        return null;
    }

    @Override
    public String doLogin(String username, String password) {
        return null;
    }
}
