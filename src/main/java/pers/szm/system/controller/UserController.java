package pers.szm.system.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pers.szm.system.entities.UserEntity;
import pers.szm.system.service.UserService;





@Controller
@RequestMapping("/user")  
public class UserController {
	
	@Resource 
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        return "/user/index";
    }
	
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
    public String user() {
        System.out.println("test");
        

        return "index";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        System.out.println("login");
        

        return "user/login";   
    }
	
	@RequestMapping(value = "/loginData", method = RequestMethod.POST)
    public String loginData(@ModelAttribute UserEntity user) {
        System.out.println(user.getUsername());
        UserEntity userInfo = userService.login(user.getUsername());
        if(userInfo == null){
        	return "user/error";
        }else if(userInfo.getPassword().equals(user.getPassword())){
        	return "user/success";
        }
        else return "user/error";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        System.out.println("register");
        

        return "user/register";
    }
	
	

}