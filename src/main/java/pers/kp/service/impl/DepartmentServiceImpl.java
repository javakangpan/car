package pers.kp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.kp.dao.IDepartmentDao;
import pers.kp.pojo.TDepartment;
import pers.kp.service.IDepartmentService;
@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Resource
	private IDepartmentDao dao;
	
	@Override
	public void save(TDepartment department) throws RuntimeException {
		dao.save(department);

	}

	@Override
	public void update(TDepartment department) throws RuntimeException {
	
		dao.update(department);
	}

	@Override
	public void delete(TDepartment department) throws RuntimeException {
		dao.delete(department);

	}

	@Override
	public List<TDepartment> query(TDepartment department) {
		
		return dao.query(department);
	}

	@Override
	public TDepartment queryById(int id) {
		
		return dao.queryById(id);
	}

}
