package pers.kp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pers.kp.dao.IUserDao;
import pers.kp.pojo.TMenu;
import pers.kp.pojo.TUser;
import pers.kp.utils.BaseDao;
import pers.kp.utils.PageModel;
@Repository
public class UserDaoImpl extends BaseDao implements IUserDao {
	
	

	private String hql;

	@Override
	public void save(TUser user) throws RuntimeException {
		
		super.save(user);
	}

	@Override
	public void update(TUser user) throws RuntimeException {
		super.update(user);
		
	}

	@Override
	public void delete(TUser user) throws RuntimeException {
		
		super.delete(user);
	}

	@Override
	public List<TUser> query(TUser user) {
		
		hql = "from TUser";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public TUser queryById(int id) {
		
//		return (TUser) getSession().get(TUser.class, id);
		return (TUser) getSession().load(TUser.class, id);
	}

	@Override
	public PageModel queryByPage(int currentPage, int pageSize, TUser user) {
		
		
		StringBuilder queryHql = new StringBuilder(" from TUser where 1=1 ");
		StringBuilder countHql= new StringBuilder(" select count(*) from TUser where 1=1 ");
		StringBuilder whereHql= new StringBuilder();
		Map<String, Object> params = new HashMap<String, Object>();
		if(user != null){
			if(!"".equals(user.getUsername()) && user.getUsername()!= null){
				// 根据姓名查询数据
				whereHql.append(" and username like :username");
				params.put("username", "%"+user.getUsername()+"%");
			}
		}
		
		return super.queryPageModel(queryHql, countHql, whereHql, currentPage, pageSize, params);
	}

	/**
	 * 同步用户数据
	 */
	@Override
	public void saveSynUser() throws RuntimeException {
		String sql = "insert into t_user(id,username,pwd,realname,sex,depid,phone) select id,username,pwd,realname,sex,depid,phone from t_user@dbms_others t1 where t1.id not in (select id from t_user) ";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.executeUpdate();
	}

	@Override
	public Object login(String userName, String password) {
		Query query=getSession().createQuery("from TUser where username=:username and pwd=:pwd");
		query.setParameter("username", userName);
		query.setParameter("pwd", password);
		List list=query.list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
		
	}

	@Override
	public List<String> queryMenuById(int id) {
		String sql = "select menulink from t_menu where id in ( select menuid from t_role_menu where roleid in ( select roleid from t_user_role where userid = :id )) and menulink is not null";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter("id", id);
		return  query.list();
	}
}
