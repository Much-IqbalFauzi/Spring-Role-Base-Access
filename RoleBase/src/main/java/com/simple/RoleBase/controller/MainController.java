package com.simple.RoleBase.controller;

import com.simple.RoleBase.entitas.rest.LoginInput;
import com.simple.RoleBase.service.LoginRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    
    @GetMapping("/user")
    public String user() {
        
        return "user";
    }
    
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    
    
    @GetMapping("/keuangan")
    public String keuangan() {
        return "keuagan";
    }

    
    
}
