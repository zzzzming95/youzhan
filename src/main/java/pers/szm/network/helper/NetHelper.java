package pers.szm.network.helper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pers.szm.system.dao.impl.XcCityDaoImpl;
import pers.szm.system.entities.XcCityEntity;

/**

* 提供一些爬取酒店数据的辅助方法

* @author szm

* @Time 2017-6-22

*

*/

public class NetHelper {
	
	@Resource
	XcCityDaoImpl xcCityDao;
	
	
	public void updateXcCity(){
		try {
			Document doc = Jsoup.connect("http://hotels.ctrip.com/domestic-city-hotel.html").get();
			
			Elements pinyinFilterElements = doc.getElementsByClass("pinyin_filter_detail layoutfix");

			//包含所有城市的Element
			Element pinyinFilter = pinyinFilterElements.first();
			
			//拼音首字符Elements
			Elements pinyins = pinyinFilter.getElementsByTag("dt");
			//所有dd的Elements
			Elements hotelsLinks = pinyinFilter.getElementsByTag("dd");
			

			String sql = "create table if not exists xc_city (id int(4) primary key auto_increment, city_id int(4) not null, city_name varchar(20) not null, head_pinyin  varchar(4) not null, pinyin varchar(20) not null)";
			xcCityDao.excuteSql(sql);
			
			
			//每次执行删除一下表，防止数据插入重复
			sql = "DROP TABLE IF EXISTS xc_city";
			xcCityDao.excuteSql(sql);
			
			for (int i = 0; i < pinyins.size(); i++) {
			    Element head_pinyin = pinyins.get(i);
			    Element head_hotelsLink = hotelsLinks.get(i);
			    Elements links = head_hotelsLink.children();
			    for (Element link : links) { 
			    	XcCityEntity xcCityEntity = new XcCityEntity();
			    	
			        String cityName = link.html();
			        String headPinYinStr = head_pinyin.html();
			        
			        String pinAndId = link.attr("href").replace("/hotel/", "");
			        //get cityId
			        String regEx="[^0-9]";   
					Pattern p = Pattern.compile(regEx);   
					Matcher m = p.matcher(pinAndId);   
					int cityId = Integer.parseInt(m.replaceAll("").trim());
					
					//get city pinying
					regEx="[^a-z]";   
					p = Pattern.compile(regEx);   
					m = p.matcher(pinAndId);   
					String cityPinYin = m.replaceAll("").trim();
					
					xcCityEntity.setCityId(cityId);
					xcCityEntity.setCityName(cityName);
					xcCityEntity.setHeadPinyYin(headPinYinStr);
					xcCityEntity.setPinyYin(cityPinYin);
					
					xcCityDao.save(xcCityEntity);
					
			        
			        
			    }
			}
			
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
