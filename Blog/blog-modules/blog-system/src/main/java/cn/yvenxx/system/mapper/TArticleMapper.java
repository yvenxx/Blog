package cn.yvenxx.system.mapper;

import cn.yvenxx.common.entity.TArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yven
 * @since 2024-04-17
 */
public interface TArticleMapper extends BaseMapper<TArticle> {
    List<String> getYears();

    List<String> getCategories();
}
