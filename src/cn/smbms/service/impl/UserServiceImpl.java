package cn.smbms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.UserDao;
import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Page;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;


	public User LoginUser(String UserCode, String UserPassword) {
		
		return userDao.LoginUser(UserCode, UserPassword);
	}

	public List<User> getUserList(String userName, Integer userRole,
			Integer from, Integer pageSize) {
		// TODO Auto-generated method stub
		return userDao.getUserList(userName, userRole, from, pageSize);
	}


	public Integer getCount(String userName, Integer userRole) {
		// TODO Auto-generated method stub
		return userDao.getCount(userName, userRole);
	}

	public List<Role> getRole() {
		// TODO Auto-generated method stub
		return userDao.getRole();
	}

	public List<Provider> getProLimit(String proCode, String proName,
			Integer from, Integer pageSize) {
		// TODO Auto-generated method stub
		return userDao.getProLimit(proCode, proName, from, pageSize);
	}

	public Integer getProCount(String proCode, String proName) {
		// TODO Auto-generated method stub
		return userDao.getProCount(proCode, proName);
	}

	public List<Role> getRoleList(Integer from, Integer pageSize) {
		// TODO Auto-generated method stub
		return userDao.getRoleList(from, pageSize);
	}

	public Integer getRoleCount() {
		// TODO Auto-generated method stub
		return userDao.getRoleCount();
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		if (userDao.addUser(user) > 0) {
			return true;
		}
		return false;
	}

	public boolean Proadd(Provider pro) {
		if (userDao.Proadd(pro) > 0) {
			return true;
		}
		return false;
	}

	public Provider ByIdPro(Integer proId) {
		// TODO Auto-generated method stub
		return userDao.ByIdPro(proId);
	}

	public User ByIdUser(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.ByIdUser(userId);
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		if (userDao.updateUser(user) > 0) {
			return true;
		}
		return false;
	}

	public boolean Proupdate(Provider pro) {
		if (userDao.Proupdate(pro) > 0) {
			return true;
		}
		return false;
		
	}

	public Role RoleById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.RoleById(id);
	}

	public boolean updateRole(Role role) {
	if (userDao.updateRole(role) > 0) {
		return true;
	}
		return false;
	}

	public boolean selectUserCode(String userCode) {
		if (userDao.selectUserCode(userCode) > 0) {
			return true;
		}
		return false;
	}

	public boolean updatePassword(Integer id, String userPassword) {
		if (userDao.updatePassword(id, userPassword) > 0) {
			return true;
		}
		return false;
	}

	public List<Bill> getBillLimit(String productName, Integer providerId,
			Integer isPayment, Integer form, Integer pageSize) {
		// TODO Auto-generated method stub
		return userDao.getBillLimit(productName, providerId, isPayment, form, pageSize);
	}

	public Integer getBillCount(String productName, Integer providerId,
			Integer isPayment) {
		// TODO Auto-generated method stub
		return userDao.getBillCount(productName, providerId, isPayment);
	}

	public List<Provider> getProName() {
		// TODO Auto-generated method stub
		return userDao.getProName();
	}

	public boolean addBill(Bill bill) {
		if (userDao.addBill(bill) > 0) {
			return true;
		}
		return false;
	}

	public Bill getByBillId(Integer id) {
		// TODO Auto-generated method stub
		return userDao.getByBillId(id);
	}

	public boolean updateBill(Bill bill) {
		if (userDao.updateBill(bill)>0) {
			return true;
		}
		return false;
	}

	public boolean delUser(Integer id) {
		if (userDao.delUser(id) > 0) {
			return true;
		}
		return false;
	}

	public boolean delBill(Integer id) {
		if (userDao.delBill(id) > 0) {
			return true;
		}
		return false;
	}

	public boolean delProVider(Integer proId) {
		if (userDao.delProVider(proId) >0) {
			return true;
		}
		return false;
	}

	public Integer getBillPro(Integer id) {
		
		return userDao.getBillPro(id);
	}

	public boolean delRole(Integer id) {
		if (userDao.delRole(id) > 0) {
			return true;
		}
		return false;
	}

	public Integer RoleByUser(Integer id) {
		// TODO Auto-generated method stub
		return userDao.RoleByUser(id);
	}

	public boolean RoleAdd(Role role) {
		if (userDao.RoleAdd(role) > 0) {
			return true;
		}
		return false;
	}

	public Integer RoleByCode(String roleCode) {
		// TODO Auto-generated method stub
		return userDao.RoleByCode(roleCode);
	}

	
	

}
