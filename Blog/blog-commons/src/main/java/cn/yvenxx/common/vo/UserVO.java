package cn.yvenxx.common.vo;

import cn.yvenxx.common.entity.TRole;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public  class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String password;

    private Integer enable;

    List<RoleVO> roles;
}
