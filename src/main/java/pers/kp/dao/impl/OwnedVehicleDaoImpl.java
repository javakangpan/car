package pers.kp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import pers.kp.dao.IOwnedVehicleDao;
import pers.kp.pojo.OwnedVehicle;
import pers.kp.utils.BaseDao;
@Repository
public class OwnedVehicleDaoImpl extends BaseDao implements IOwnedVehicleDao {

	
	
	@Override
	public List<OwnedVehicle> query(OwnedVehicle car) {
		
		Query query = getSession().createQuery("from OwnedVehicle");
		return query.list();
	}

	@Override
	public void save(OwnedVehicle own) throws RuntimeException {
		super.save(own);
		
	}

	@Override
	public void update(OwnedVehicle own) throws RuntimeException {
		super.update(own);
		
	}

	@Override
	public void delete(OwnedVehicle own) throws RuntimeException {
		super.delete(own);
		
	}

	@Override
	public OwnedVehicle queryById(Integer id) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from OwnedVehicle where id = :id");
		query.setParameter(":id", id);
		return (OwnedVehicle) query.uniqueResult();
	}
	
	@Override
	public void readSaveExcel(List<OwnedVehicle> list) {
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			for (OwnedVehicle ow : list) {
				session.save(ow);
			}
			tx.commit();
		} catch (Exception e) {
		
			e.printStackTrace();
			tx.rollback();
		} finally{
			session.close();
		}
		
		
	}


}
