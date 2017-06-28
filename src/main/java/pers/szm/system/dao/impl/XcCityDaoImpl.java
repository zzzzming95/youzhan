package pers.szm.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pers.szm.common.base.impl.BaseDaoHibernate;
import pers.szm.system.dao.XcCityDao;
import pers.szm.system.entities.XcCityEntity;
			 
@Repository("xcCityDao")
@Transactional
public class XcCityDaoImpl extends BaseDaoHibernate<XcCityEntity> implements XcCityDao {
	
	public List<XcCityEntity> findByCityName(String cityName){
		String query = "from XcCityEntity where city_name = '"+cityName+"'";
		//System.out.println(query);
		List<XcCityEntity> xcCityList = this.find(query); 
		System.out.println(xcCityList.get(0).getId());
		return xcCityList; 
	}

}
