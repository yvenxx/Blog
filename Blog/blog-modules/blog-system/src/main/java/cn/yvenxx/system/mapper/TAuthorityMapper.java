package cn.yvenxx.system.mapper;

import cn.yvenxx.common.entity.TAuthority;
import cn.yvenxx.common.vo.AuthorityVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yven
 * @since 2024-04-02
 */
public interface TAuthorityMapper extends BaseMapper<TAuthority> {

    List<AuthorityVO> selectAllAuthority();

}
