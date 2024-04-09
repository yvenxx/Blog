package cn.yvenxx.common.entity;

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
public class TUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long uid;

    private Long rid;


}
