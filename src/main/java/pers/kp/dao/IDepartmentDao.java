package pers.kp.dao;

import java.util.List;

import pers.kp.pojo.TDepartment;

public interface IDepartmentDao {
	void save(TDepartment department) throws RuntimeException;
	void update(TDepartment department)throws RuntimeException;
	void delete(TDepartment department)throws RuntimeException;
	List<TDepartment> query(TDepartment department);
	TDepartment queryById(int id);
}
