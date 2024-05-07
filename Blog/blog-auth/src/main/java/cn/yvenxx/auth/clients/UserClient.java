package cn.yvenxx.auth.clients;

import cn.yvenxx.common.util.R;
import cn.yvenxx.common.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("blog-system")
public interface UserClient {
    @PostMapping("/userinfo/oauth")
    UserVO getUserinfoByUsername(@RequestParam("username")String username);
}
