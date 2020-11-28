/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.RoleBase.security;

import com.simple.RoleBase.entitas.LoginInput;
import com.simple.RoleBase.entitas.LoginOutput;
import com.simple.RoleBase.service.LoginRestService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Much. Iqbal Fauzi
 */
@Component
public class ComponentProvider implements AuthenticationProvider{
    @Autowired LoginRestService service;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("begin auth");
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        LoginInput input = new LoginInput();
        input.setEmail(email);
        input.setPassword(password);
        LoginOutput output = service.login(input);
        
        System.out.println(output);
        if(output.getUser()!=null){
            
        }
        
        if (output.getStatus().equals("Verified")) {
            return new UsernamePasswordAuthenticationToken(output, email, new ArrayList<>());
        } else {
            return null;
        }
    }
    
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
