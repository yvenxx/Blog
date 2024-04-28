package cn.yvenxx.system.service.impl;

import cn.yvenxx.common.entity.TArticle;
import cn.yvenxx.system.mapper.TArticleMapper;
import cn.yvenxx.system.service.ITArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yven
 * @since 2024-04-17
 */
@Service
public class TArticleServiceImpl extends ServiceImpl<TArticleMapper, TArticle> implements ITArticleService {
    @Override
    public List<String> getYears() {
        return baseMapper.getYears();
    }

    @Override
    public List<String> getCategories() {
        return baseMapper.getCategories();
    }
}
