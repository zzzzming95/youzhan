package pers.szm.system.dao;

import java.util.List;

import pers.szm.common.base.BaseDao;
import pers.szm.system.entities.HotelEntity;

public interface HotelDao extends BaseDao<HotelEntity> {
	
	public List<HotelEntity> searchHotel(String city);
	

}
