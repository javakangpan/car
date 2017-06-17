package pers.kp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.kp.dao.IRoleDao;
import pers.kp.pojo.TRole;
import pers.kp.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {
	@Resource
	private IRoleDao dao;
	
	@Override
	public void save(TRole role) throws RuntimeException {
		
		dao.save(role);
	}

	@Override
	public void update(TRole role) throws RuntimeException {
		dao.update(role);

	}

	@Override
	public void delete(TRole role) throws RuntimeException {
		
		dao.delete(role);
	}

	@Override
	public List<TRole> query(TRole role) {
		
		return dao.query(role);
	}

	@Override
	public TRole queryById(int id) {
		
		return dao.queryById(id);
	}

}
