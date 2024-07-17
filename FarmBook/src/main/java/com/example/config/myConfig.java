/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class myConfig extends WebSecurityConfigurerAdapter{
    @Bean
    public UserDetailsService getUserDetailsService(){
        return new userdetailsserv();
    }
    
    @Bean
    public BCryptPasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider AuthenticationProvider(){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(this.getUserDetailsService());
        dao.setPasswordEncoder(PasswordEncoder());
        return dao;
    }
    
    
    protected void Configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.authenticationProvider(AuthenticationProvider());
    }
    
    
    protected void Configure(HttpSecurity http)throws Exception{
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER").antMatchers("/**").permitAll().and().formLogin().and().csrf().disable();
    }
}
