package pers.kp.dao;

import java.util.List;

import pers.kp.pojo.OwnedVehicle;

public interface IOwnedVehicleDao {
	
	List<OwnedVehicle> query(OwnedVehicle car);
	
	
	void save(OwnedVehicle own) throws RuntimeException;
	
	void update(OwnedVehicle own) throws RuntimeException;
	
	void delete(OwnedVehicle own) throws RuntimeException;
	
	OwnedVehicle queryById(Integer id);
	
	void readSaveExcel(List<OwnedVehicle> list);

}
