package cn.yvenxx.system.service;

import cn.yvenxx.common.entity.TArticle;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yven
 * @since 2024-04-17
 */
public interface ITArticleService extends IService<TArticle> {

    List<String> getYears();

    List<String> getCategories();
}
