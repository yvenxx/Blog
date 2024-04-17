package cn.yvenxx.system.service;

import cn.yvenxx.common.entity.TAuthority;
import cn.yvenxx.common.vo.AuthorityVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yven
 * @since 2024-04-02
 */
public interface ITAuthorityService extends IService<TAuthority> {
    void insert(TAuthority tAuthority);

    List<AuthorityVO> getRoleAuthority();
}
