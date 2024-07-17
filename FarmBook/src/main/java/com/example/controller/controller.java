/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.dao.userRepository;
import com.example.entity.contact;
import com.example.entity.user;
import com.example.helper.message;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ashish Katare
 */
@Controller
public class controller {
    
    @Autowired
    private BCryptPasswordEncoder PasswordEncoder;
    
    @Autowired
    private userRepository userRepo;
   
    @RequestMapping("/")
    public String home(Model model){
       model.addAttribute("title","Home - FarmBook");
        return "home";
    }
    
    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title","signup - FarmBook");
        model.addAttribute("u",new user());
        return "signup";
    }
    
    // handler for registering user
    @RequestMapping(value = "/do_register",method = RequestMethod.POST)
    public String registeruser(@Valid @ModelAttribute("u") user u , BindingResult res, @RequestParam(value = "check",defaultValue = "false")boolean check , Model model , HttpSession session){
        
        try{
        if(!check){
            System.out.println("You have not checked the terms and conditions");
            throw new Exception("You have not checked the terms and conditions");
        }
        
        if(res.hasErrors()){
            model.addAttribute("u",u);
            return "signup";
        }
        
        u.setRole("user");
        u.setEnabled(true);
        u.setPassword(PasswordEncoder.encode(u.getPassword()));
        
        System.out.println("aggreement" + check);
        System.out.println("user" + u);
        
        user result = this.userRepo.save(u);
        
         session.setAttribute("message", new message("registered successfully !!","alert-success"));
        
        model.addAttribute("u",new user());
        return "signup";
    }
    
    catch(Exception e){
        e.printStackTrace();
        session.setAttribute("message", new message("something went wrong !!"+e.getMessage(),"alert-danger"));
        model.addAttribute("u" , u);
        return "signup";
    
}
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
