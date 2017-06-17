package pers.kp.service;

import java.util.List;

import pers.kp.pojo.TMenu;
import pers.kp.pojo.TUser;
import pers.kp.utils.PageModel;

public interface IUserService {

	void save(TUser user) throws RuntimeException;
	void update(TUser user)throws RuntimeException;
	void delete(TUser user)throws RuntimeException;
	List<TUser> query(TUser user);
	TUser queryById(int id);
	
	
	/**
	 * 查询分页数据
	 * @param currentPage
	 * @param pageSize
	 * @param user
	 * @return
	 */
	PageModel queryByPage(int currentPage,int pageSize,TUser user);
	
	void saveSynUser() throws RuntimeException;
	
	Object login(String userName,String password);
	
	List<String> queryMenuById(int id);
	
}
