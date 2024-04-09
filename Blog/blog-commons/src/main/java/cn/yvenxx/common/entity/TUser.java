package cn.yvenxx.common.entity;

import cn.yvenxx.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class TUser extends BaseModel implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;

    private String password;

    private Integer enable;

}
