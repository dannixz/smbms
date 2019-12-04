package cn.smbms.pojo;

import java.util.List;

public class Page {
	private int danqianye;
	private int yedaxiao = 5;
	private int pageIndex ;
	private int zongjilu;
	private int zongyeshu;
	private List<User> list;
	private List<Provider> prolist;
	private List<Role> rolelist;
	private List<Bill> billlist;
	
	
	
	public List<Bill> getBilllist() {
		return billlist;
	}
	public void setBilllist(List<Bill> billlist) {
		this.billlist = billlist;
	}
	public List<Role> getRolelist() {
		return rolelist;
	}
	public void setRolelist(List<Role> rolelist) {
		this.rolelist = rolelist;
	}
	public List<Provider> getProlist() {
		return prolist;
	}
	public void setProlist(List<Provider> prolist) {
		this.prolist = prolist;
	}
	public int getDanqianye() {
		return danqianye;
	}
	public void setDanqianye(int danqianye) {
		this.danqianye = danqianye;
	}
	public int getYedaxiao() {
		return yedaxiao;
	}
	public void setYedaxiao(int yedaxiao) {
		this.yedaxiao = yedaxiao;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getZongjilu() {
		return zongjilu;
	}
	public void setZongjilu(int zongjilu) {
		this.zongjilu = zongjilu;
	}
	public int getZongyeshu() {
		return zongyeshu;
	}
	public void setZongyeshu(int zongyeshu) {
//		if (zongyeshu > 0) {
//			this.zongyeshu = zongyeshu;
//			this.zongyeshu = this.zongjilu%this.yedaxiao==0 ? this.zongjilu/this.yedaxiao : this.zongjilu/this.yedaxiao+1;	
//		}
		this.zongyeshu = zongyeshu;
		
	}
	public List<User> getList() {
		return list;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public Page(int danqianye, int zongjilu) {
		super();
		this.danqianye = danqianye;
		this.zongjilu = zongjilu;
		zongyeshu = zongjilu%yedaxiao==0 ? zongjilu/yedaxiao : zongjilu/yedaxiao+1;
		pageIndex = (danqianye-1)*yedaxiao;
	}
	
}
	
	
	
