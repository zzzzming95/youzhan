package pers.szm.system.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class HotelEntity {
	
	private int id;
	private String address;
	private String feature;
	private String name;
	private int star;
	
	@Id
	@Column(name = "id", unique = true, length = 4, nullable = false)
	public int getId() {
		return id;
	}
	public void setId( int id ) {
		this.id = id;
	}
	
	@Column(name = "feature", length = 60)
	public void setFeature(String Feature){
		this.feature = Feature;
	}
		
	public String getFeature(){
		return this.feature;
	}
		
	@Column(name = "address", length = 60)
	public void setAddress(String Address){
		this.address = Address;
	}
		
	public String getAddress(){
		return this.address;
	}
	
	@Column(name = "name", length = 30)
	public void setName(String Name){
		this.name = Name;
	}
		
	public String getName(){
		return this.name;
	}
	
	@Column(name = "star", length = 11)
	public int getStar() {
		return star;
	}
	public void setStar( int Star ) {
		this.star = Star;
	}
			

}
