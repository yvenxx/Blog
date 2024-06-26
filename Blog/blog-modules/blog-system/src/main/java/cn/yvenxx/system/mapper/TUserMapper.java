package cn.yvenxx.system.mapper;

import cn.yvenxx.common.entity.TUser;
import cn.yvenxx.common.vo.UserInfoVO;
import cn.yvenxx.common.vo.UserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yven
 * @since 2024-04-02
 */
public interface TUserMapper extends BaseMapper<TUser> {
    UserVO getUserInfoByUsername(String username);

    UserInfoVO getUserInfoById(int id);
}
