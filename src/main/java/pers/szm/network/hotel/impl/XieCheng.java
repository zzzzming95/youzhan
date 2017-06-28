package pers.szm.network.hotel.impl;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pers.szm.network.hotel.GetData;
import pers.szm.system.dao.XcCityDao;
import pers.szm.system.entities.XcCityEntity;
 

@Service("xieCheng")
public class XieCheng implements GetData{
	
	@Resource
	public XcCityDao xcCityDao; 
	

	
	@Override
	public HashMap<String,String> getInfo(String city,String hotelName,String url){
		HashMap<String,String> hm = new HashMap<String,String>();
		DefaultHttpClient client = new DefaultHttpClient();
		
		List<XcCityEntity> xcCityList = this.xcCityDao.findByCityName(city);
		XcCityEntity xcCityEntity = xcCityList.get(0);
		
		//System.out.println(xcCityEntity.getCityName().toString());
		
		
		
        HttpPost post = new HttpPost("http://m.ctrip.com/restapi/soa2/10932/hotel/Product/domestichotelget?_fxpcqlniredt=09031137211999077688");
        JSONObject response = null;
        try {
        	String para = "{\"biz\":1,\"contrl\":3,\"facility\":0,\"faclist\":[],\"key\":\"\",\"keytp\":0,\"pay\":0,\"querys\":[{\"type\":8,\"qtype\":1,\"val\":\""+hotelName+"\"}],\"couponlist\":[],\"setInfo\":{\"cityId\":"+xcCityEntity.getCityId()+",\"dstId\":0,\"inDay\":\"2017-06-18\",\"outDay\":\"2017-06-19\"},\"sort\":{\"dir\":1,\"idx\":1,\"ordby\":0,\"size\":10},\"qbitmap\":0,\"alliance\":{\"ishybrid\":0},\"head\":{\"cid\":\"09031137211999077688\",\"ctok\":\"\",\"cver\":\"1.0\",\"lang\":\"01\",\"sid\":\"8888\",\"syscode\":\"09\",\"auth\":null,\"extension\":[{\"name\":\"pageid\",\"ue\":\"212093\"},{\"name\":\"webp\",\"ue\":1},{\"name\":\"referrer\",\"ue\":\"http://www.ctrip.com/\"},{\"name\":\"protocal\",\"ue\":\"http\"}]},\"contentType\":\"json\"}";

            StringEntity s = new StringEntity(para);
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
           
            post.setEntity(s);
            
            HttpResponse res = client.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                response = JSONObject.fromObject(result);
                
                //System.out.println("xiecheng test");
                JSONArray hotelInfos = response.getJSONArray("htlInfos");
                JSONObject hotelInfo = (JSONObject) hotelInfos.get(0);
                JSONObject baseInfo =  hotelInfo.getJSONObject("baseInfo");
                
                String id = baseInfo.getString("id");
                String baseName = baseInfo.getString("name");
                //System.out.println(id);
                //url:http://hotels.ctrip.com/hotel/2298288.html
                String hotelUrl = "http://hotels.ctrip.com/hotel/"+id+".html";
                
                JSONObject priceinfo =  hotelInfo.getJSONObject("priceinfo");
                JSONArray prices = priceinfo.getJSONArray("prices");
                
                float firPrice = Float.parseFloat(prices.getJSONObject(0).getString("pcny"));
                float secPrice = Float.parseFloat(prices.getJSONObject(1).getString("pcny"));
                float price = firPrice < secPrice ? firPrice : secPrice; 
                String sPrice = String.valueOf(price);
                hm.put("hotelname", hotelName);
                hm.put("price",sPrice);
                hm.put("url",hotelUrl);
                hm.put("source","携程");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
		
		return hm;
	}

}
