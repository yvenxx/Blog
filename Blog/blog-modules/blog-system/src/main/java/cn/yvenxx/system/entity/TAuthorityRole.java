package cn.yvenxx.system.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@ApiModel(value="TAuthorityRole对象", description="")
public class TAuthorityRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    private Long rid;

    @ApiModelProperty(value = "权限id")
    private Long aid;


}
