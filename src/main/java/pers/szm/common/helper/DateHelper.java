package pers.szm.common.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**

* 时间辅助函数

* @author szm

* @Time 2017-6-29

*

*/
public class DateHelper {
	
	
	public void getDate(String format){
		Date dt=new Date();
	    SimpleDateFormat matter1=new SimpleDateFormat(format);
	    System.out.println(matter1.format(dt));
		
	}
	
	public void getDate(){
		Date dt=new Date();
	    SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
	    System.out.println(matter1.format(dt));
		
	}

}
