package cn.yvenxx.auth.service.impl;

import cn.yvenxx.auth.entity.TUser;
import cn.yvenxx.auth.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private TUserMapper mapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TUser tUser = mapper.getUserInfoByUsername(username);
        if (tUser == null) {
            throw new UsernameNotFoundException("This username didn't exist.");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+"admin"));
        return new User(tUser.getUsername(), tUser.getPassword(),authorities);
    }
}
