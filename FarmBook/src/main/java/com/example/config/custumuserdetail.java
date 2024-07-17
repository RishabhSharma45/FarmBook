/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.config;

import com.example.entity.user;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Ashish Katare
 */
public class custumuserdetail implements UserDetails {
    
    private user u;

    public custumuserdetail(user u) {
        this.u = u;
    }    
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simple = new SimpleGrantedAuthority(u.getRole());
        return List.of(simple);
        }

    @Override
    public String getPassword() {
        return u.getPassword();
        }

    @Override
    public String getUsername() {
        return u.getEmail();
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
