package pers.kp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.kp.dao.IMenuDao;
import pers.kp.pojo.TMenu;
import pers.kp.service.IMenuService;
@Service
public class MenuServiceImpl implements IMenuService {
	@Resource
	private IMenuDao dao;
	
	@Override
	public void save(TMenu menu) throws RuntimeException {
		dao.save(menu);

	}

	@Override
	public void update(TMenu menu) throws RuntimeException {
	
		dao.update(menu);
	}

	@Override
	public void delete(TMenu menu) throws RuntimeException {
		dao.delete(menu);

	}

	@Override
	public List<TMenu> query(TMenu menu) {
		
		return dao.query(menu);
	}

	@Override
	public TMenu queryById(int id) {
		
		return dao.queryById(id);
	}

}
