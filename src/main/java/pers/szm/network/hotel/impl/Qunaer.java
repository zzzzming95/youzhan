package pers.szm.network.hotel.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pers.szm.network.hotel.GetData;

public class Qunaer implements GetData {

	@Override
	public HashMap<String,String> getInfo(String city, String hotelName, String url) {
		HashMap<String,String> hm = new HashMap<String,String>();
		try{
			city = new String(city.getBytes("utf-8"),"gbk");
			String urlHotal = new String(hotelName.getBytes("utf-8"),"gbk");
			Document doc = Jsoup.connect("https://touch.qunar.com/hotel/hotellist?city="+city+"&checkInDate=2017-06-18&checkOutDate=2017-06-19&keywords="+urlHotal+"&sort=0").get();
			//System.out.println("https://touch.qunar.com/hotel/hotellist?city="+city+"&checkInDate=2017-06-08&checkOutDate=2017-06-09&keywords="+hotelName+"&sort=0");
			
			//System.out.println(doc.baseUri());
			System.out.println(doc.toString());
			Elements marks = doc.select("p:contains("+hotelName+")");
			Element mark = marks.first();
			Element markPar = mark.parent().parent();  
			Elements p3 = markPar.select(".right"); 
			String dataId = markPar.attr("data-id");
			//System.out.println(dataId.toString());
			String[] dataIds = dataId.split("_");
			//System.out.println(dataIds.length);
			String hotelUrl = null;
			String id = null;
			if(dataIds.length == 2){
				hotelUrl = "http://hotel.qunar.com/city/"+dataIds[0]+"/dt-"+dataIds[1]+"";
				id = dataIds[1]; 
			}else if(dataIds.length == 3){
				hotelUrl = "http://hotel.qunar.com/city/"+dataIds[0]+"_"+dataIds[1]+"/dt-"+dataIds[2]+"";
				id = dataIds[2]; 
			}
			 
			//url:http://hotel.qunar.com/city/huizhou_guangdong/dt-3698/
			
			//System.out.println(dataId);
			Element p4 = p3.first();
			String price = p4.text();
			//System.out.println(p4.text());
			hm.put("hotelname", hotelName);
            hm.put("price",price);
            hm.put("source","去哪儿");
            hm.put("url",hotelUrl);
		
		
		}catch(Exception e){
			 throw new RuntimeException(e);
		}
		
		
		
		return hm;
	}

}
