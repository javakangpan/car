package pers.kp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import pers.kp.dao.IMenuDao;
import pers.kp.pojo.TMenu;
import pers.kp.utils.BaseDao;
@Repository
public class MenuDaoImpl extends BaseDao implements IMenuDao {

	@Override
	public void save(TMenu menu) throws RuntimeException {
		
		super.save(menu);

	}

	@Override
	public void update(TMenu menu) throws RuntimeException {
		
		super.update(menu);
	}

	@Override
	public void delete(TMenu menu) throws RuntimeException {
		
		String hql = "update TMenu set isdel = 1 where id = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, menu.getId());
		query.executeUpdate();

	}

	@Override
	public List<TMenu> query(TMenu menu) {
	
			Query query=super.getSession().createQuery("from TMenu where isdel != 1 or isdel is null");
			return query.list();
	}

	@Override
	public TMenu queryById(int id) {
		
		return (TMenu) super.getSession().get(TMenu.class, id);
	}

}
