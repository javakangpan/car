package pers.kp.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import pers.kp.pojo.OwnedVehicle;

public interface IOwnedVehicleService {
	List<OwnedVehicle> query(OwnedVehicle car);
	
	
	void save(OwnedVehicle own) throws RuntimeException;
	
	void update(OwnedVehicle own) throws RuntimeException;
	
	void delete(OwnedVehicle own) throws RuntimeException;
	
	OwnedVehicle queryById(Integer id);
	
	void readExcel(File file) throws Exception;
	
	public InputStream exportExcel() throws Exception;
}
