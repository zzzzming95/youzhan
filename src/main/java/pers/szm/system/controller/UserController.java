package pers.szm.system.controller;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
@RequestMapping("/user")  
public class UserController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        return "/user/index";
    }
	
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
    public String user() {
        System.out.println("test");
        

        return "index";
    }
	
	

}