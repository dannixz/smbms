package cn.smbms.dao.impl;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import cn.smbms.dao.UserDao;
import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;

public class UserDaoImpl implements UserDao{
	private SqlSessionTemplate session;
	
	public User LoginUser(String UserCode, String UserPassword) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).LoginUser(UserCode, UserPassword);
	}

	public Integer getCount(String userName, Integer userRole) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).getCount(userName, userRole);
	}

	public List<User> getUserList(String userName, Integer userRole,
			Integer from, Integer pageSize) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).getUserList(userName, userRole, from, pageSize);
	}

	public List<Role> getRole() {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).getRole();
	}

	public List<Provider> getProLimit(String proCode, String proName,
			Integer from, Integer pageSize) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).getProLimit(proCode, proName, from, pageSize);
	}

	public Integer getProCount(String proCode, String proName) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).getProCount(proCode, proName);
	}

	public List<Role> getRoleList(Integer from, Integer pageSize) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).getRoleList(from, pageSize);
	}

	public Integer getRoleCount() {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).getRoleCount();
	}

	public Integer addUser(User user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).addUser(user);
	}

	public Integer Proadd(Provider pro) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).Proadd(pro);
	}

	public Provider ByIdPro(Integer proId) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).ByIdPro(proId);
	}

	public User ByIdUser(Integer userId) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).ByIdUser(userId);
	}

	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).updateUser(user);
	}

	public Integer Proupdate(Provider pro) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).Proupdate(pro);
	}

	public Role RoleById(Integer id) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).RoleById(id);
	}

	public Integer updateRole(Role role) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).updateRole(role);
	}

	public Integer selectUserCode(String userCode) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).selectUserCode(userCode);
	}

	public Integer updatePassword(Integer id, String userPassword) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).updatePassword(id, userPassword);
	}

	public List<Bill> getBillLimit(String productName, Integer providerId,
			Integer isPayment, Integer form, Integer pageSize) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).getBillLimit(productName, providerId, isPayment, form, pageSize);
	}

	public Integer getBillCount(String productName, Integer providerId,
			Integer isPayment) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).getBillCount(productName, providerId, isPayment);
	}

	public List<Provider> getProName() {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).getProName();
	}

	public Integer addBill(Bill bill) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).addBill(bill);
	}

	public Bill getByBillId(Integer id) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).getByBillId(id);
	}

	public Integer updateBill(Bill bill) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).updateBill(bill);
	}

	public Integer delUser(Integer id) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).delUser(id);
	}

	public Integer delProVider(Integer proId) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).delProVider(proId);
	}

	public Integer delBill(Integer id) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).delBill(id);
	}

	public Integer getBillPro(Integer id) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).getBillPro(id);
	}

	public Integer delRole(Integer id) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).delRole(id);
	}

	public Integer RoleByUser(Integer id) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).RoleByUser(id);
	}

	public Integer RoleAdd(Role role) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).RoleAdd(role);
	}

	public Integer RoleByCode(String roleCode) {
		// TODO Auto-generated method stub
		return session.getMapper(UserDao.class).RoleByCode(roleCode);
	}

}
