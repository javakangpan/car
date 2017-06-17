package pers.kp.service;

import java.util.List;

import pers.kp.pojo.TRole;

public interface IRoleService {
	void save(TRole role) throws RuntimeException;
	void update(TRole role)throws RuntimeException;
	void delete(TRole role)throws RuntimeException;
	List<TRole> query(TRole role);
	TRole queryById(int id);
}
