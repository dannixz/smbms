package cn.smbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;

public interface UserDao {
	/**
	 * 用户表
	 * @param UserCode
	 * @param UserPassword
	 * @return
	 */
	//登录验证
	public User LoginUser(@Param("UserCode") String UserCode,@Param("UserPassword") String UserPassword);
	
	//多条件查询
	public List<User> getUserList(@Param("userName")String userName,@Param("userRole") Integer userRole
			,@Param("from") Integer from,@Param("pageSize") Integer pageSize);  

	//总记录
	public Integer getCount(@Param("userName")String userName,@Param("userRole")Integer userRole );
	
	//添加
	public Integer addUser(User user);

	//根据id查询用户信息
	public User ByIdUser(@Param("userId") Integer userId);
	
	//修改用户信息
	public Integer updateUser(User user);
	
	//查询用户编码是否唯一
	public Integer selectUserCode(@Param("userCode") String userCode);
	
	//修改密码
	public Integer updatePassword(@Param("id") Integer id,@Param("userPassword") String userPassword);
	
	//删除用户
	public Integer delUser(@Param("id") Integer id);
	/**
	 * 供应商表
	 * @param proCode
	 * @param proName
	 * @param from
	 * @param pageSize
	 * @return
	 */
	//根据供应商编码和供应商名称模糊查询，并进行分页
	public List<Provider> getProLimit(@Param("proCode") String proCode,@Param("proName") String proName,@Param("from") Integer from,@Param("pageSize") Integer pageSize);

	//求和
	public Integer getProCount(@Param("proCode") String proCode,@Param("proName") String proName);

	//添加
	public Integer Proadd(Provider pro);
	
	//根据id查询
	public Provider ByIdPro(@Param("proId") Integer proId);
	
	//修改
	public Integer Proupdate(Provider pro);
	
	//查询供应商名字
	public List<Provider> getProName();
	
	//根据id删除供应商
	public Integer delProVider(@Param("id") Integer proId);
	
	//查询供应商下的订单信息
	public Integer getBillPro(@Param("id") Integer id);
	/**
	 * 
	 * 角色表
	 */

	//查询RoleName
	public List<Role> getRole();
	
	//分页查询
	public List<Role> getRoleList(@Param("from") Integer from,@Param("pageSize") Integer pageSize);

	//查询总记录
	public Integer getRoleCount();
	
	//根据id查询
	public Role RoleById(@Param("id") Integer id);
	
	//修改
	public Integer updateRole(Role role);
	
	//删除角色信息
	public Integer delRole(@Param("id") Integer id);
	
	//判断角色下面是否存在员工
	public Integer RoleByUser(@Param("id") Integer id);
	
	//添加角色
	public Integer RoleAdd(Role role);
	
	//用户编码验证是否存在
	public Integer RoleByCode(@Param("roleCode") String roleCode);

	/**
	 * 订单表  
	 */
	//分页查询
	public List<Bill> getBillLimit(@Param("productName") String productName,@Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment,@Param("form") Integer form,@Param("pageSize") Integer pageSize);

	//总记录
	public Integer getBillCount(@Param("productName") String productName,@Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment);
	
	//添加
	public Integer addBill(Bill bill);
	
	//根据id显示
	public Bill getByBillId(@Param("Id") Integer id);
	
	//修改
	public Integer updateBill(Bill bill);
	
	//根据id删除订单信息
	public Integer delBill(@Param("id") Integer id);
	
	
}
