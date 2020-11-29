/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.RoleBase.controller;

import com.simple.RoleBase.entitas.rest.LoginInput;
import com.simple.RoleBase.service.LoginRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author cnugr
 */
@Controller
public class LoginController {
    
    @Autowired LoginRestService login;
    
    @GetMapping("login")
    public String index(Model model) {
        model.addAttribute("user", new LoginInput());
        return "login";
    }
    
    @GetMapping("/logout")
    public String logout(Model model){
        login.logout();
        return "redirect:/";
    }
}
