package cn.yvenxx.auth.service.impl;

import cn.yvenxx.auth.entity.LoginUser;
import cn.yvenxx.auth.mapper.TUserMapper;
import cn.yvenxx.auth.service.ITUserService;
import cn.yvenxx.common.exception.ServiceException;
import com.alibaba.nacos.common.utils.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, LoginUser> implements ITUserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public LoginUser getUserByUsername(String username) {
        return baseMapper.getUserInfoByUsername(username);
    }

    @Override
    public LoginUser doLogin(String username, String password) {
        if (StringUtils.isAnyBlank(username, password)){
            throw new ServiceException("用户/密码必须填写");
        }
        return userMapper.getUserInfoByUsername(username);
    }
}
