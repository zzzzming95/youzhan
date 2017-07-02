package pers.szm.system.dao;

import java.util.List;

import pers.szm.system.entities.UserEntity;

public interface UserDao {
	
	public List<UserEntity> getPassword(String userName);

}
