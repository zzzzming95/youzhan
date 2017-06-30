package pers.szm.common.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;

/**

* 时间辅助函数

* @author szm

* @Time 2017-6-29

*

*/
@Component("dateHelper")
public class DateHelper {
	
	
	public String getDate(String format){
		Date date=new Date();
	    SimpleDateFormat matter=new SimpleDateFormat(format);
	    String dateString = matter.format(date);
	    return dateString;
		
	}
	
	public String getDate(){
		Date date=new Date();
	    SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");
	    String dateString = matter.format(date);
	    return dateString;
		
	}
	
	/**
     * 根据day参数，获取指定向前或向后推进的日期，比如day为1，则获取当前时间加1天的日期
     *
     * @param day,表示要获取向前或向后多少天的日期
     *           
     * @return null
     */
	public String getSpecialDate(int day){
		Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		 
		return dateString;
	}
	

}
