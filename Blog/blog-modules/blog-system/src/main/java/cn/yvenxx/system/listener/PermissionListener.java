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
        // stream 流，根据role字段聚合list，并将resource作为值
        Map<String, List<String>> collect = list.stream()
                .collect(Collectors.groupingBy(AuthorityVO::getRole, Collectors.mapping(AuthorityVO::getResource, Collectors.toList())));
        Iterator<Map.Entry<String, List<String>>> iterator = collect.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, List<String>> item = iterator.next();
            String key = item.getKey();
            redisService.deleteObject(key+":permission");
            List<String> value = item.getValue();
            redisService.setCacheList(key+":permission",value);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}