package pers.szm.system.service;

import java.util.List;

import pers.szm.system.entities.HotelEntity;

public interface HotelService {
	public List<HotelEntity> searchHotel(String city);

}
