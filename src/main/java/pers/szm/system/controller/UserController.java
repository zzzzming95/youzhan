package pers.szm.system.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
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
    public String loginData(@ModelAttribute UserEntity user,Model model,HttpServletRequest request) {
        UserEntity userInfo = userService.login(user.getUsername());
        UserEntity sessionUser = new UserEntity();
        if(userInfo == null){
        	
        	return "user/error";
        }else if(userInfo.getPassword().equals(user.getPassword())){
        	boolean isAdmin = userInfo.getAdmin();
        	sessionUser.setAdmin(userInfo.getAdmin());
        	sessionUser.setUsername(userInfo.getUsername());
        	sessionUser.setId(userInfo.getId());
        	request.getSession().setAttribute("sessionUser", sessionUser);
        	System.out.println(isAdmin);
        	return isAdmin ? "admin/success" : "user/success"; 
        }
        else return "user/error";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        System.out.println("register");
        

        return "user/register";
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request){
		HttpSession session = request.getSession(false);//防止创建Session
		if(session == null){
			return "/index";
		}
		session.removeAttribute("sessionUser");
		return "/index";
		
	}
	
	

}