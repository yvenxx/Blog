package cn.yvenxx.auth.entity;

import cn.yvenxx.common.entity.TAuthority;
import cn.yvenxx.common.entity.TRole;
import cn.yvenxx.common.model.BaseModel;
import cn.yvenxx.common.vo.RoleVO;
import cn.yvenxx.common.vo.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author yven
 * @since 2024-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@ApiModel(value="TUser对象", description="")
public class LoginUser extends BaseModel implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "是否启用")
    private Integer enable;

    @ApiModelProperty(value = "角色")
    private List<SimpleGrantedAuthority> roles = new ArrayList<>();

    public LoginUser(String username, String password) {
        this.name = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setRoles(List<RoleVO> roles){
        for (RoleVO role : roles) {
            this.roles.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
    }
    public void setUser(UserVO userVO){
        this.password = userVO.getPassword();
        this.name = userVO.getName();
        this.enable = userVO.getEnable();
        setRoles(userVO.getRoles());
    }
}
