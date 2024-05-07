package cn.yvenxx.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpMethodsEnum {
    GET("GET",0),
    POST("POST",1),
    PUT("PUT",2),
    DELETE("DELETE",3)
    ;
    private String method;
    private int code;

    public static HttpMethodsEnum getEnumByCode(int code) {
        for (HttpMethodsEnum value : HttpMethodsEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }
}
