package cn.yvenxx.auth.service.impl;

import cn.yvenxx.auth.clients.UserClient;
import cn.yvenxx.auth.entity.LoginUser;
import cn.yvenxx.auth.mapper.TUserMapper;
import cn.yvenxx.common.util.R;
import cn.yvenxx.common.vo.UserVO;
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
    @Autowired
    private UserClient userClient;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userVO = userClient.getUserinfoByUsername(username);
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(userVO);

        if (loginUser == null) {
            throw new UsernameNotFoundException("This username didn't exist.");
        }
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_"+"admin"));

        return new User(loginUser.getUsername(), loginUser.getPassword(),loginUser.getRoles());
    }
}
