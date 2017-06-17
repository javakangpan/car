package pers.kp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import pers.kp.dao.IDepartmentDao;
import pers.kp.pojo.TDepartment;
import pers.kp.utils.BaseDao;
@Repository
public class DepartmentDaoImpl extends BaseDao implements IDepartmentDao {

	@Override
	public void save(TDepartment department) throws RuntimeException {
		
		super.save(department);

	}

	@Override
	public void update(TDepartment department) throws RuntimeException {
		
		super.update(department);
	}

	@Override
	public void delete(TDepartment department) throws RuntimeException {
		
		super.delete(department);

	}

	@Override
	public List<TDepartment> query(TDepartment department) {
	
		Query query=super.getSession().createQuery("from TDepartment");
		return query.list();
	}

	@Override
	public TDepartment queryById(int id) {
		
		return (TDepartment) super.getSession().get(TDepartment.class, id);
	}

}
