package cn.yvenxx.auth.service;

import cn.hutool.system.UserInfo;
import cn.yvenxx.auth.entity.TUser;
import cn.yvenxx.auth.vo.UserVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yven
 * @since 2024-03-28
 */
public interface ITUserService extends IService<TUser> {
    TUser getUserByUsername(String username);

    UserVO doLogin(String username, String password);
}
