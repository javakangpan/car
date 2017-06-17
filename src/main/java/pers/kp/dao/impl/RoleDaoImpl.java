package pers.kp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import pers.kp.dao.IRoleDao;
import pers.kp.pojo.TRole;
import pers.kp.utils.BaseDao;
@Repository
public class RoleDaoImpl extends BaseDao implements IRoleDao {

	@Override
	public void save(TRole role) throws RuntimeException {
		super.save(role);

	}

	@Override
	public void update(TRole role) throws RuntimeException {
		
		super.update(role);
	}

	@Override
	public void delete(TRole role) throws RuntimeException {
		
		super.delete(role);

	}

	@Override
	public List<TRole> query(TRole role) {
	
		Query query=super.getSession().createQuery("from TRole");
		return query.list();
	}

	@Override
	public TRole queryById(int id) {
		
		return (TRole) super.getSession().get(TRole.class, id);
	}

}
