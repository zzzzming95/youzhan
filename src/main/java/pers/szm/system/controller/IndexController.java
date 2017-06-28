package pers.szm.system.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pers.szm.system.dao.XcCityDao;

@Controller
public class IndexController {
	
	@Resource
	public XcCityDao xcCityDao; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
		
		System.out.println(xcCityDao.findByCityName("深圳").toString());
		
		System.out.println("indextest");
        return "index";
    }
}
