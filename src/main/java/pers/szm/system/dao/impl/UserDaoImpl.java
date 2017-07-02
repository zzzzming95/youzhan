package pers.szm.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pers.szm.common.base.impl.BaseDaoHibernate;
import pers.szm.system.dao.UserDao;
import pers.szm.system.entities.UserEntity;
import pers.szm.system.entities.XcCityEntity;

@Repository("hotelDao")
@Transactional
public class UserDaoImpl extends BaseDaoHibernate<UserEntity> implements UserDao {

	public List<UserEntity> getPassword(String userName){
		String query = "from UserEntity where username = '"+userName+"'";
		//System.out.println(query);
		List<UserEntity> userEntityList = this.find(query); 
		return userEntityList;
	}
}
