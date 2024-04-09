package cn.yvenxx.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class BaseModel implements Serializable {
    private Date createTime;

    private Date updateTime;

    private Long createUser;

    private Long updateUser;
}
