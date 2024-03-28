package cn.yvenxx.auth.mapper;

import cn.yvenxx.auth.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yven
 * @since 2024-03-28
 */
public interface TUserMapper extends BaseMapper<TUser> {
    TUser getUserInfoByUsername(String username);

}
