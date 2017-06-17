package pers.kp.dao;

import java.util.List;

import pers.kp.pojo.TMenu;

public interface IMenuDao {
	void save(TMenu menu) throws RuntimeException;
	void update(TMenu menu)throws RuntimeException;
	void delete(TMenu menu)throws RuntimeException;
	List<TMenu> query(TMenu menu);
	TMenu queryById(int id);
}
