package com.chat.chatauth.model;

import com.chat.chatcommon.model.UserDto;
import com.chat.chatcommon.pojo.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ActiveUser implements UserDetails {

    private String clientId;
    private Integer uid;
    private String userName;
    private String password;
    private Collection<SimpleGrantedAuthority> authorities;

    public ActiveUser(UserDto userDto){
        this.clientId = userDto.getClientId();
        this.userName = userDto.getUserName();
        this.password = userDto.getPassword();
        this.uid = userDto.getId();
        if (userDto.getAuthorities() != null) {
            authorities = new ArrayList<>();
            userDto.getAuthorities().forEach(item -> authorities.add(new SimpleGrantedAuthority(item)));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
        return true;
    }
}
