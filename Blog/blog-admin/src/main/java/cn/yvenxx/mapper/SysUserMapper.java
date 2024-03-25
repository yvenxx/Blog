package cn.yvenxx.mapper;

import cn.yvenxx.model.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser getUserInfoByUsername(String username);
}
