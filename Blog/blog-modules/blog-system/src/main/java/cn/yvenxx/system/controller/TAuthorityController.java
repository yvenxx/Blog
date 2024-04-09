package cn.yvenxx.system.controller;


import cn.yvenxx.common.util.R;
import cn.yvenxx.system.entity.TAuthority;
import cn.yvenxx.system.service.ITAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yven
 * @since 2024-04-02
 */
@RestController
@RequestMapping("/system/authority")
public class TAuthorityController {

    @Autowired
    private ITAuthorityService authorityService;

    /**
     * 获取权限列表
     * @return
     */
    @GetMapping("/list")
    public R list(){
        List<TAuthority> list = authorityService.list();
        return R.succ(list);
    }
}
