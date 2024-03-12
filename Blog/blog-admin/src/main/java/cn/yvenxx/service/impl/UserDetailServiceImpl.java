package cn.yvenxx.service.impl;

import cn.yvenxx.model.SysUser;
import cn.yvenxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userService.getUserByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("This username didn't exist.");
        }
        return new User(sysUser.getUsername(), sysUser.getPassword(), sysUser.getRole());
    }
}
