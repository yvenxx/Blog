package cn.yvenxx.system.controller;


import cn.yvenxx.common.util.R;
import cn.yvenxx.system.service.ITFileService;
import cn.yvenxx.system.service.impl.TencentCosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yven
 * @since 2024-04-29
 */
@RestController
@RequestMapping("/system/file")
public class TFileController {
    @Autowired
    private ITFileService itFileService;
    @Autowired
    private TencentCosService tencentCosService;

    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file){
        String url = tencentCosService.uploadFile(file);
        if (url == null){
            return R.fail("上传失败");
        }
        return R.succ(url,null);
    }


}
