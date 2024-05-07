package cn.yvenxx.system.listener;

import cn.yvenxx.common.service.RedisService;
import cn.yvenxx.common.vo.AuthorityVO;
import cn.yvenxx.system.service.ITAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@WebListener
@Component
public class PermissionListener implements ServletContextListener {

    @Autowired
    private RedisService redisService;

    @Autowired
    private ITAuthorityService authorityService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<AuthorityVO> list = authorityService.getRoleAuthority();
        // stream 流，根据role字段聚合list
        Map<String, List<AuthorityVO>> collect = list.stream().collect(Collectors.groupingBy(AuthorityVO::getRole));
        Iterator<Map.Entry<String, List<AuthorityVO>>> iterator = collect.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<AuthorityVO>> item = iterator.next();
            List<AuthorityVO> authorities = item.getValue();
            String key = item.getKey();
            redisService.deleteObject(key+":permission");
            for (AuthorityVO authority : authorities) {
                redisService.setCacheMapValue(key+":permission",authority.getResource(),authority.getType());
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}