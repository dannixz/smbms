package cn.smbms.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private Integer id;
	private String userCode;
	private String userName;
	private String userPassword;
	private Integer gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private String phone;
	private String address;
	private Integer userRole;
	private Integer createdBy;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date creationDate;
	private Integer modifyBy;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modifyDate;
	private String userRoleName;
	private Integer age;
	private Role role;
	
	private String idPicPath;  //证件照路径
	private String workPicPath;//工作证照片
	
	
	
	public String getWorkPicPath() {
		return workPicPath;
	}
	public void setWorkPicPath(String workPicPath) {
		this.workPicPath = workPicPath;
	}
	public String getIdPicPath() {
		return idPicPath;
	}
	public void setIdPicPath(String idPicPath) {
		this.idPicPath = idPicPath;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatetionDate() {
		return creationDate;
	}
	public void setCreatetionDate(Date createtionDate) {
		this.creationDate = createtionDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getNodifyDate() {
		return modifyDate;
	}
	public void setNodifyDate(Date nodifyDate) {
		this.modifyDate = nodifyDate;
	}
	public User(Integer id, String userCode, String userName) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String userCode, String userName,
			String userPassword, Integer gender, Date birthday, String phone,
			String address, Integer userRole, Integer createdBy,
			Date creationDate, Integer modifyBy, Date modifyDate,
			String userRoleName, Integer age, Role role) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userRole = userRole;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.userRoleName = userRoleName;
		this.age = age;
		this.role = role;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
