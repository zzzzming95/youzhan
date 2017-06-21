package pers.szm.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.json.JSONArray;
import pers.szm.network.hotel.impl.Qunaer;
import pers.szm.network.hotel.impl.XieCheng;
import pers.szm.system.entities.HotelEntity;
import pers.szm.system.service.impl.HotelServiceImpl;

@Controller
@RequestMapping("/hotel")  
public class HotelController {
	
	@Resource
	private HotelServiceImpl hotelService;
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("search") String search,Model model) {
		
		System.out.println("test");
		List<HotelEntity> searchList = new ArrayList<HotelEntity>();
		searchList = hotelService.searchHotel(search);
		model.addAttribute("searchList",searchList); 
		
        return "hotel";
    }
	
	@RequestMapping(value = "/getdetail", method = RequestMethod.POST)
	public void getDetail(@RequestParam("hotelName")String hotelName,@RequestParam("city")String city,ServletResponse response) throws IOException{
		Qunaer qne = new Qunaer();
		XieCheng xc = new XieCheng();
		if(city == "深圳"){
			System.out.println(city);
		}
		List<HashMap<String,String>> hotelDetail = new ArrayList<HashMap<String,String>>();
		
		HashMap<String,String> qneDeatil = qne.getInfo(city, hotelName, "");
		HashMap<String,String> xcDeatil = xc.getInfo(city, hotelName, "");
		hotelDetail.add(qneDeatil);
		hotelDetail.add(xcDeatil);
		
		JSONArray detail = JSONArray.fromObject(hotelDetail);
		System.out.println(detail.toString());
		PrintWriter out = response.getWriter();
		out.print(detail);
	
	}
	

}
