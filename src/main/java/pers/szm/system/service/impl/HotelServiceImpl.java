package pers.szm.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.szm.system.dao.HotelDao;
import pers.szm.system.entities.HotelEntity;
import pers.szm.system.service.HotelService;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {
	
	@Resource
	private HotelDao hotelDao; 
	
	public List<HotelEntity> searchHotel(String city){ 
		return hotelDao.searchHotel(city);
	}

}
