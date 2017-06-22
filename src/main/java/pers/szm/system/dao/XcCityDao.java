package pers.szm.system.dao;

import java.util.List;

import pers.szm.common.base.BaseDao;
import pers.szm.system.entities.XcCityEntity;

public interface XcCityDao extends BaseDao<XcCityEntity>{
	public List<XcCityEntity> findByCityName(String cityName);

}
