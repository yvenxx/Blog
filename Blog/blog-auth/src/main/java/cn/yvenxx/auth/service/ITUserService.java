package cn.yvenxx.auth.service;

import cn.yvenxx.auth.entity.LoginUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yven
 * @since 2024-03-28
 */
public interface ITUserService extends IService<LoginUser> {
    LoginUser getUserByUsername(String username);

    LoginUser doLogin(String username, String password);
}
