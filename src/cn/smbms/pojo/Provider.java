package cn.smbms.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Provider {
	private int id;
	private String proCode;
	private String proName;
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	private String proDesc;
	private String proContact;
	private String proPhone;
	private String proAddress;
	private String proFax;
	private int createdBy;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date creationDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modifyDate;
	private int modifyBy;
	private String businessPath;
	private String organPath;
	
	
	
	public String getOrganPath() {
		return organPath;
	}
	public void setOrganPath(String organPath) {
		this.organPath = organPath;
	}
	public String getBusinessPath() {
		return businessPath;
	}
	public void setBusinessPath(String businessPath) {
		this.businessPath = businessPath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	public String getProContact() {
		return proContact;
	}
	public void setProContact(String proContact) {
		this.proContact = proContact;
	}
	public String getProPhone() {
		return proPhone;
	}
	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}
	public String getProAddress() {
		return proAddress;
	}
	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}
	public String getProFax() {
		return proFax;
	}
	public void setProFax(String proFax) {
		this.proFax = proFax;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
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
	public int getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}
	
	
}
