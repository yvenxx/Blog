package cn.yvenxx.system.service.impl;

import cn.yvenxx.common.entity.TAuthority;
import cn.yvenxx.common.vo.AuthorityVO;
import cn.yvenxx.system.mapper.TAuthorityMapper;
import cn.yvenxx.system.service.ITAuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yven
 * @since 2024-04-02
 */
@Service
public class TAuthorityServiceImpl extends ServiceImpl<TAuthorityMapper, TAuthority> implements ITAuthorityService {

    @Autowired
    private TAuthorityMapper tAuthorityMapper;
    public void insert(TAuthority authority){
        tAuthorityMapper.insert(authority);
    }

    @Override
    public List<AuthorityVO> getRoleAuthority() {
        return baseMapper.selectAllAuthority();
    }
}
