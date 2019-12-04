package cn.smbms.pojo;

import java.util.Date;
import java.util.List;

public class Bill {
	private int id;
	private String billCode;
	private String productName;
	private String productDesc;
	private String productUnit;
	private Double productCount;
	private Double totalPrice;
	private int isPayment;
	private int createdBy;
	private Date creationDate;
	private int modifyBy;
	private Date modifyDate;
	private int providerId;
	private String providerName;
	private Provider provider;//association映射
	private List<Provider> list;//collection映射
	private String businessPath;
	private String organPath;
	public List<Provider> getList() {
		return list;
	}
	
	
	public String getBusinessPath() {
		return businessPath;
	}


	public void setBusinessPath(String businessPath) {
		this.businessPath = businessPath;
	}


	public String getOrganPath() {
		return organPath;
	}


	public void setOrganPath(String organPath) {
		this.organPath = organPath;
	}


	public void setList(List<Provider> list) {
		this.list = list;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public Double getProductCount() {
		return productCount;
	}
	public void setProductCount(Double productCount) {
		this.productCount = productCount;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(int isPayment) {
		this.isPayment = isPayment;
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
	public int getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
}
