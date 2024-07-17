/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.config;

import com.example.dao.userRepository;
import com.example.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Ashish Katare
 */
public class userdetailsserv implements UserDetailsService{
    
    @Autowired
    private userRepository userrepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        user u = userrepo.getUserByName(username);
        
        if(u==null){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    custumuserdetail cstmusrdtl = new custumuserdetail(u);
    
    return cstmusrdtl;
}
}
