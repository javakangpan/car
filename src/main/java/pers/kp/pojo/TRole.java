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

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ROLE", schema = "CAR")
public class TRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String rolename;
	private String demo;
	
	private List<TMenu> menus=new ArrayList<TMenu>();

	// Constructors



	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TRole(Integer id, String rolename, String demo) {
		this.id = id;
		this.rolename = rolename;
		this.demo = demo;
	}

	// Property accessor
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_role")
	@SequenceGenerator(name="seq_role",sequenceName="seq_t_role",initialValue=10,allocationSize=1,schema="CAR")
	@Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ROLENAME", length = 40)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Column(name = "DEMO", length = 100)
	public String getDemo() {
		return this.demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}
	
	@ManyToMany
	@JoinTable(name="t_role_menu",schema="CAR",
			joinColumns=@JoinColumn(name="roleid")
			,inverseJoinColumns=@JoinColumn(name="menuid"))
	public List<TMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<TMenu> menus) {
		this.menus = menus;
	}

}