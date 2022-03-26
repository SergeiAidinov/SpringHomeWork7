package ru.yandex.incoming34.SpringHomeWork7.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@GetMapping("/login")
	public void login(String userName, String password) {
		System.out.println("Login: " + userName + " " + password);
	}
	
	@GetMapping(value = "/logout" )
    public String logout(){
        //request.getSession(true).invalidate();
        SecurityContextHolder.getContext().setAuthentication(null);
        System.out.println("logout user page shown--------------------");
        return "/login/logout";       
   }
	

}
