package cn.yvenxx.system.service.impl;

import cn.yvenxx.common.entity.TUser;
import cn.yvenxx.common.vo.UserInfoVO;
import cn.yvenxx.common.vo.UserVO;
import cn.yvenxx.system.mapper.TUserMapper;
import cn.yvenxx.system.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yven
 * @since 2024-04-02
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {
    @Autowired
    private TUserMapper userMapper;

    public UserVO getUserInfoByUsername(String username){
        return userMapper.getUserInfoByUsername(username);
    }

    @Override
    public UserInfoVO getUserInfoById(int id) {
        return baseMapper.getUserInfoById(id);
    }
}
