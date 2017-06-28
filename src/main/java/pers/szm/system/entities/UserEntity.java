package pers.szm.system.entities;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
	private int id;
	private String username;
	private String password;
	private boolean admin; 
	
	public UserEntity(){}
	
	@Id
	@Column(name = "id", unique = true, length = 4, nullable = false)
	public int getId() {
	   return id;
	}
	public void setId( int id ) {
	   this.id = id;
	}
	@Column(name = "username", length = 20)
	public void setUsername(String Username){
		this.username = Username;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	@Column(name = "password", length = 40)
	public void setPassword(String Password){
		this.password = Password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	@Column(name = "admin", length = 40)
	public void setAdmin(boolean Admin){
		this.admin = Admin;
	}
	
	public boolean getAdmin(){
		return this.admin;
	}
}
