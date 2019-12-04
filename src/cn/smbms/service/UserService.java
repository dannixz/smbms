package cn.smbms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Page;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;

public interface UserService {
		//登录验证
		public User LoginUser(@Param("UserCode") String UserCode,@Param("UserPassword") String UserPassword);
		
		//多条件查询
		public List<User> getUserList(@Param("userName")String userName,@Param("userRole") Integer userRole
				,@Param("from") Integer from,@Param("pageSize") Integer pageSize);  

		//总记录
		public Integer getCount(@Param("userName")String userName,@Param("userRole")Integer userRole );

		//查询RoleName
		public List<Role> getRole();
		
		//根据供应商编码和供应商名称模糊查询，并进行分页
		public List<Provider> getProLimit(@Param("proCode") String proCode,@Param("proName") String proName,@Param("form") Integer from,@Param("pageSize") Integer pageSize);

		//求和
		public Integer getProCount(@Param("proCode") String proCode,@Param("proName") String proName);

		//分页查询
		public List<Role> getRoleList(@Param("from") Integer from,@Param("pageSize") Integer pageSize);

		//查询总记录
		public Integer getRoleCount();
		
		//添加用户
		public boolean addUser(User user);
		
		//添加供应商
		public boolean Proadd(Provider pro);
		
		//根据id查询供应商
		public Provider ByIdPro(@Param("proId") Integer proId);
		

		//根据id查询用户信息
		public User ByIdUser(@Param("userId") Integer userId);
		
		//修改用户信息
		public  boolean updateUser(User user);	
		//修改供应商
		public  boolean Proupdate(Provider pro);
		
		//查询供应商名字
		public List<Provider> getProName();
		
		//根据id查询
		public Role RoleById(@Param("id") Integer id);
		
		//修改
		public boolean updateRole(Role role);
		
		//查询用户编码是否唯一
		public boolean selectUserCode(@Param("userCode") String userCode);
		//修改密码
		public boolean updatePassword(@Param("id") Integer id,@Param("userPassword") String userPassword);
		
		//分页查询
		public List<Bill> getBillLimit(@Param("productName") String productName,@Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment,@Param("form") Integer form,@Param("pageSize") Integer pageSize);


		//总记录
		public Integer getBillCount(@Param("productName") String productName,@Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment);


		//添加
		public boolean addBill(Bill bill);
		
		//根据id显示
		public Bill getByBillId(@Param("Id") Integer id);
		
		
		//修改
		public boolean updateBill(Bill bill);
		
		//删除用户
		public boolean delUser(@Param("id") Integer id);
		
		//根据id删除订单信息
		public boolean delBill(@Param("id") Integer id);
		
		
		//根据id删除供应商
		public boolean delProVider(@Param("id") Integer proId);
		
		//查询供应商下的订单信息
		public Integer getBillPro(@Param("id") Integer id);
		
		//删除角色信息
		public boolean delRole(@Param("id") Integer id);
		
		//判断角色下面是否存在员工
		public Integer RoleByUser(@Param("id") Integer id);

		//添加角色
		public boolean RoleAdd(Role role);
		
		//用户编码验证是否存在
		public Integer RoleByCode(@Param("roleCode") String roleCode);
}
