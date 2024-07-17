/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.dao;

import com.example.entity.user;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Ashish Katare
 */
public interface userRepository extends JpaRepository<user , Integer>{
    @Query("select u from user u where u.email = :email")
    public user getUserByName(@Param("email") String email);
}
