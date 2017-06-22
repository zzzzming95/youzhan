package pers.szm.system.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "xc_city")
public class XcCityEntity {
	private int id;
	private int cityId;
	private String cityName;
	private String headPinyYin;
	private String pinYin;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 4, nullable = false)
	public int getId() {
		return id;
	}
	public void setId( int id ) {
		this.id = id;
	}
	
	@Column(name = "city_id", unique = true, length = 4, nullable = false)
	public int getCityId() {
		return cityId;
	}
	public void setCityId( int cityId ) {
		this.cityId = cityId;
	}
	
	@Column(name = "city_name", length = 20)
	public void setCityName(String cityName){
		this.cityName = cityName;
	}
		
	public String getCityName(){
		return this.cityName;
	}
	
	@Column(name = "head_pinyin", length = 4)
	public void setHeadPinyYin(String headPinyYin){
		this.headPinyYin = headPinyYin;
	}
		
	public String getHeadPinyYin(){
		return this.headPinyYin;
	}
	
	@Column(name = "pinyin", length = 4)
	public void setPinyYin(String pinYin){
		this.pinYin = pinYin;
	}
		
	public String getPinyYin(){
		return this.pinYin;
	}

}
