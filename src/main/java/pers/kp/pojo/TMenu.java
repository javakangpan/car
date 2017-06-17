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

import org.hibernate.annotations.GenericGenerator; 

/**
 * TMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MENU", schema = "CAR")
public class TMenu implements java.io.Serializable {

	// Fields

	private Integer id;
	private String menuname;
	private String menulink;
	private Integer pid;
	private String securyname;
	private String memo;
	private Long isdel;
    
	
	// Constructors

	/** default constructor */
	public TMenu() {
	}

	/** minimal constructor */
	public TMenu(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TMenu(Integer id, String menuname, String menulink, Integer pid,
			String securyname, String memo, Long isdel) {
		this.id = id;
		this.menuname = menuname;
		this.menulink = menulink;
		this.pid = pid;
		this.securyname = securyname;
		this.memo = memo;
		this.isdel = isdel;
	}

	// Property accessors
	@Id
	// 指定主键的生成方式 strategy 指定主键的生成方式  generator 自定义名称
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_menu")
	@SequenceGenerator(name="seq_menu",sequenceName="seq_t_menu",initialValue=10,allocationSize=1,schema="CAR")

	@Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "MENUNAME", length = 40)
	public String getMenuname() {
		return this.menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	@Column(name = "MENULINK", length = 100)
	public String getMenulink() {
		return this.menulink;
	}

	public void setMenulink(String menulink) {
		this.menulink = menulink;
	}

	@Column(name = "PID", precision = 5, scale = 0)
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "SECURYNAME", length = 100)
	public String getSecuryname() {
		return this.securyname;
	}

	public void setSecuryname(String securyname) {
		this.securyname = securyname;
	}

	@Column(name = "MEMO", length = 100)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "ISDEL", precision = 10, scale = 0)
	public Long getIsdel() {
		return this.isdel;
	}

	public void setIsdel(Long isdel) {
		this.isdel = isdel;
	}


}