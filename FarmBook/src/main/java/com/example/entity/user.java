/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class user {
    
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotBlank(message = "Name is required")
    @Size(min = 2 , max = 20 , message="name should be min of 2 or max of 20 length")
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    private boolean enabled;
    @Column(length = 500)
    private String about;
    
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY,mappedBy="u")
    private List<contact> contacts = new ArrayList<>();


    public user() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role + ", enabled=" + enabled + ", about=" + about + ", contacts=" + contacts + '}';
    }
    
}
