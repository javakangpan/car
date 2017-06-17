package pers.kp.pojo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_USER", schema = "CAR")
public class TUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String pwd;
	private String realname;
	private String sex;
	private Integer depid;
	private String phone;
	
	// 配置用户和角色多对多的关联关系
	private List<TRole> roles = new ArrayList<TRole>();
	
	// 保存用户具有的菜单  临时属性
	private List<String> menus = new ArrayList<String>();
	
	
	
	/**
	 * Transient 表示该字段为临时字段,不是表结构中的字段
	 * @return
	 */
	// 临时字段的标志
	@Transient  //javax.persistence.Transient
	public List<String> getMenus() {
		return menus;
	}

	public void setMenus(List<String> menus) {
		this.menus = menus;
	}

	// Constructors
	//配置多对多
	@ManyToMany
	@JoinTable(name="t_user_role",schema="car"
	,joinColumns=@JoinColumn(name="userid")
	,inverseJoinColumns=@JoinColumn(name="roleid"))
	public List<TRole> getRoles() {
		return roles;
	}

	public void setRoles(List<TRole> roles) {
		this.roles = roles;
	}

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TUser(Integer id, String username, String pwd, String realname,
			String sex, Integer depid, String phone) {
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.realname = realname;
		this.sex = sex;
		this.depid = depid;
		this.phone = phone;
	}

	// Property accessors
	@Id
	// 指定主键的生成方式 strategy 指定主键的生成方式  generator 自定义名称
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_user")
	@SequenceGenerator(name="seq_user",sequenceName="seq_t_user",initialValue=10,allocationSize=1,schema="CAR")
	@Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "USERNAME", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PWD", length = 20)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "REALNAME", length = 20)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "SEX", length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "DEPID", precision = 5, scale = 0)
	public Integer getDepid() {
		return this.depid;
	}

	public void setDepid(Integer depid) {
		this.depid = depid;
	}

	@Column(name = "PHONE", length = 22)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "TUser [username=" + username + ", pwd=" + pwd + "]";
	}

}