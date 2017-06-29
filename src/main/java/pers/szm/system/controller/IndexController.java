package pers.szm.system.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pers.szm.common.helper.NetworkHelper;

@Controller
public class IndexController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
		
		
		System.out.println("indextest");
        return "index";
    }
}
