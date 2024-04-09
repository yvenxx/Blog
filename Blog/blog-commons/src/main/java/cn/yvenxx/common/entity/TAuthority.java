package cn.yvenxx.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author yven
 * @since 2024-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TAuthority implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long pid;

    private String name;

    private String desc;

    private String resource;

    private Integer type;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createUser;

    private Long updateUser;


}
