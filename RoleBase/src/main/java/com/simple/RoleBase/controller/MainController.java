package com.simple.RoleBase.controller;

import com.simple.RoleBase.entitas.LoginInput;
import com.simple.RoleBase.service.LoginRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Much. Iqbal Fauzi
 */
@Controller
public class MainController {
    @Autowired LoginRestService login;
            
    @GetMapping("login")
    public String index(Model model) {
        model.addAttribute("user", new LoginInput());
        return "login";
    }
    
    @GetMapping("user")
    public String user() {
        
        return "uer";
    }
    
    @GetMapping("admin")
    public String admin() {
        return "admin";
    }
    
//    
//    @GetMapping("/admin")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public String helloAdmin() {
//        return "admin";
//    }
//
//    @GetMapping("/user")
//    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
//    public String helloUser() {
//        return "uer";
//    }
    
    
}
