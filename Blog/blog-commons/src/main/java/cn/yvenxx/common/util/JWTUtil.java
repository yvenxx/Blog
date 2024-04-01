package cn.yvenxx.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;

public class JWTUtil {
    // 过期时间七天
    private final static long EXPIRE_TIME = 7 * 60 * 60 * 1000;
    public static final String APPSECRET_KEY = "blog_yven";

    /**
     * 生成签名,过期时间七天
     * @param username 用户名
     * @param role 用户的角色
     * @return 加密的token
     */
    public static String sign(String username, String role) {
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        try {
            Algorithm algorithm = Algorithm.HMAC256(APPSECRET_KEY);
            return JWT.create()
                    .withClaim("username", username)
                    .withClaim("role",role)
                    .withExpiresAt(expireDate)
                    .sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 校验token是否正确
     * @param token 密钥
     * @return 是否正确
     */
    public static boolean verify(String token, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(APPSECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
