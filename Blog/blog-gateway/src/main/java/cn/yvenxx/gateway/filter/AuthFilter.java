package cn.yvenxx.gateway.filter;

import cn.yvenxx.common.constant.TokenConstants;
import cn.yvenxx.common.entity.TAuthority;
import cn.yvenxx.common.service.RedisService;
import cn.yvenxx.common.util.JWTUtil;
import cn.yvenxx.common.util.R;
import cn.yvenxx.gateway.config.properties.IgnoreWhiteProperties;
import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Autowired
    private RedisService redisService;
    // 排除过滤的 uri 地址，nacos自行添加
    @Autowired
    private IgnoreWhiteProperties ignoreWhite;

    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest.Builder mutate = request.mutate();
        String url = request.getURI().getPath();
        HttpMethod method = request.getMethod();
        // 跳过不需要验证的路径
        if (isInWhitelist(url,ignoreWhite.getWhites()))
        {
            if (method.name().equals("GET")) {
                return chain.filter(exchange);
            }
        }
        String token = getToken(request);
        if (StringUtils.isEmpty(token)){
            return unauthorizedResponse(exchange, "令牌不能为空");
        }
        String username = JWTUtil.getUsername(token);
        if (StringUtils.isEmpty(username)){
            return unauthorizedResponse(exchange, "令牌验证失败");
        }
        // 鉴权
        // 获取 Redis里面的角色权限。根据角色权限判断
        String[] roles = JWTUtil.getRole(token).split(",");

        if (!hasPermission(url, roles)) {
            return unauthorizedResponse(exchange, "无访问权限");
        }

        // 设置用户信息到请求
        return chain.filter(exchange.mutate().request(mutate.build()).build());
    }

    private boolean hasPermission(String url , String[] roles){
        for (String role : roles) {
            List<String> permissionList = redisService.getCacheList(role+":permission");
            for (String permission : permissionList) {
                if (url.matches(permission+"/.*")){
                    return true;
                }
            }
        }
        return false;
    }

    private Mono<Void> unauthorizedResponse(ServerWebExchange exchange, String msg)
    {
        log.error("[鉴权异常处理]请求路径:{}", exchange.getRequest().getPath());

        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
        R result = R.fail(msg);
        DataBuffer dataBuffer = response.bufferFactory().wrap(JSON.toJSONString(result).getBytes());
        return response.writeWith(Mono.just(dataBuffer));
    }

    private boolean isInWhitelist(String url, List<String> whitelist) {
        for (String pattern : whitelist) {
            if (url.matches(pattern)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 获取缓存key
     */
    private String getToken(ServerHttpRequest request)
    {
        String token = request.getHeaders().getFirst(TokenConstants.TOKEN_HEADER);
        // 如果前端设置了令牌前缀，则裁剪掉前缀
        if (StringUtils.isNotEmpty(token) && token.startsWith(TokenConstants.TOKEN_PREFIX))
        {
            token = token.replaceFirst(TokenConstants.TOKEN_PREFIX, StringUtils.EMPTY);
        }
        return token;
    }
    @Override
    public int getOrder() {
        return -200;
    }
}
