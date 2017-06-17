package pers.kp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.kp.dao.IUserDao;
import pers.kp.pojo.TMenu;
import pers.kp.pojo.TUser;
import pers.kp.service.IUserService;
import pers.kp.utils.PageModel;
@Service
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao dao;
	
	@Override
	public void save(TUser user) throws RuntimeException {
		dao.save(user);

	}

	@Override
	public void update(TUser user) throws RuntimeException {
		dao.update(user);

	}

	@Override
	public void delete(TUser user) throws RuntimeException {
		dao.delete(user);

	}

	@Override
	public List<TUser> query(TUser user) {
		
		return dao.query(user);
	}

	@Override
	public TUser queryById(int id) {
		
		return dao.queryById(id);
	}

	@Override
	public PageModel queryByPage(int currentPage, int pageSize, TUser user) {
	
		return dao.queryByPage(currentPage, pageSize, user);
	}

	@Override
	public void saveSynUser() throws RuntimeException {
		dao.saveSynUser();
		
	}

	@Override
	public Object login(String userName, String password) {
		return dao.login(userName, password);
	}

	@Override
	public List<String> queryMenuById(int id) {
	
		return dao.queryMenuById(id);
	}



}
