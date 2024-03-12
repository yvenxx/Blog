package cn.yvenxx.mapper;

import cn.yvenxx.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {
    SysUser getUserInfoByUsername(String username);
}
