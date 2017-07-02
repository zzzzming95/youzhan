package pers.szm.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.szm.system.dao.UserDao;
import pers.szm.system.entities.UserEntity;
import pers.szm.system.entities.XcCityEntity;
import pers.szm.system.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao; 
	
	public UserEntity login(String userName){
		List<UserEntity> userEntityList = userDao.getPassword(userName);
		if(userEntityList.size() == 0){
			return null;
		}else{
			UserEntity user = userEntityList.get(0);
			return user;
		}
		
	}

}
