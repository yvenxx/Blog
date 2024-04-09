package cn.yvenxx.system.service;

import cn.yvenxx.common.vo.UserVO;
import cn.yvenxx.system.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yven
 * @since 2024-04-02
 */
public interface ITUserService extends IService<TUser> {
    UserVO getUserInfoByUsername(String username);
}
