/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.RoleBase.security;

import com.simple.RoleBase.entitas.LoginOutput;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 *
 * @author Much. Iqbal Fauzi
 */
@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
                    throws IOException
    {

            String targetUrl = determineTargetUrl(authentication);
            System.out.println(targetUrl);
            if (response.isCommitted()) {
                    return;
            }
            RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
            redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        
            authentication = SecurityContextHolder.getContext().getAuthentication();
            LoginOutput data = (LoginOutput)authentication.getPrincipal();
            String url = "/login?error=true";

            if(data.getUser().getRoles().contains("ROLE_ADMIN")) {
                url = "/admin";
            } else if(data.getUser().getRoles().contains("ROLE_USER")) {
                url = "/user";
            }
            return url;
    }
}
