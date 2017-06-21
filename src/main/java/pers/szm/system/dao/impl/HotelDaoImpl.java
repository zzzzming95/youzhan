package pers.szm.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pers.szm.common.base.impl.BaseDaoHibernate;
import pers.szm.system.dao.HotelDao;
import pers.szm.system.entities.HotelEntity;

@Repository("hotelDao")
@Transactional
public class HotelDaoImpl extends BaseDaoHibernate<HotelEntity> implements HotelDao {
	
	public List<HotelEntity> searchHotel(String city){
		List<HotelEntity> searchList = new ArrayList<HotelEntity>();
		String hql = "from HotelEntity as h where h.address like :param";
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		
		query.setString("param",city + "%%");  
		
		searchList = query.list();
		return searchList;
	}

}
