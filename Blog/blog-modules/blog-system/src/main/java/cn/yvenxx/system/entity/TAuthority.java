package cn.yvenxx.system.entity;

import java.time.LocalDateTime;
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
@ApiModel(value="TAuthority对象", description="")
public class TAuthority implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父权限id")
    private Long pid;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "权限描述")
    private String desc;

    @ApiModelProperty(value = "权限资源")
    private String resource;

    @ApiModelProperty(value = "权限类型。0：url")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建人")
    private Long createUser;

    @ApiModelProperty(value = "修改人")
    private Long updateUser;


}
