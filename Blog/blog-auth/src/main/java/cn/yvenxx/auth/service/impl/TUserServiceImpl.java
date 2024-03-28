package cn.yvenxx.auth.service.impl;

import cn.yvenxx.auth.entity.TUser;
import cn.yvenxx.auth.mapper.TUserMapper;
import cn.yvenxx.auth.service.ITUserService;
import cn.yvenxx.auth.vo.UserVO;
import cn.yvenxx.common.exception.ServiceException;
import com.alibaba.nacos.common.utils.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yven
 * @since 2024-03-28
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService, UserDetailsService {

    @Autowired
    private TUserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TUser tUser = getUserByUsername(username);
        if (tUser == null) {
            throw new UsernameNotFoundException("This username didn't exist.");
        }
        return new User(tUser.getUsername(), tUser.getPassword(), tUser.getRole());
    }

    @Override
    public TUser getUserByUsername(String username) {
        return baseMapper.getUserInfoByUsername(username);
    }

    @Override
    public UserVO doLogin(String username, String password) {
        if (StringUtils.isAnyBlank(username, password)){
            throw new ServiceException("用户/密码必须填写");
        }
        TUser user = userMapper.getUserInfoByUsername(username);
        return null;
    }
}
