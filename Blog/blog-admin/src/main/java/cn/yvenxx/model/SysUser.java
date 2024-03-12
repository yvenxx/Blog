package cn.yvenxx.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Data
@ApiModel("用户")
@Component
public class SysUser implements UserDetails {
    @ApiModelProperty(notes = "用户名")
    private String username;

    @ApiModelProperty(notes = "姓名")
    private String name;

    @ApiModelProperty(notes = "编码")
    private String code;

    @ApiModelProperty(notes = "密码")
    private String password;

    @ApiModelProperty(notes = "是否启用：true-启用，false-停用")
    private boolean enabled = true;

    private Collection<? extends GrantedAuthority> role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
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

}
