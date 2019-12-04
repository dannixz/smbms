package cn.smbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;

public interface UserDao {
	/**
	 * �û���
	 * @param UserCode
	 * @param UserPassword
	 * @return
	 */
	//��¼��֤
	public User LoginUser(@Param("UserCode") String UserCode,@Param("UserPassword") String UserPassword);
	
	//��������ѯ
	public List<User> getUserList(@Param("userName")String userName,@Param("userRole") Integer userRole
			,@Param("from") Integer from,@Param("pageSize") Integer pageSize);  

	//�ܼ�¼
	public Integer getCount(@Param("userName")String userName,@Param("userRole")Integer userRole );
	
	//���
	public Integer addUser(User user);

	//����id��ѯ�û���Ϣ
	public User ByIdUser(@Param("userId") Integer userId);
	
	//�޸��û���Ϣ
	public Integer updateUser(User user);
	
	//��ѯ�û������Ƿ�Ψһ
	public Integer selectUserCode(@Param("userCode") String userCode);
	
	//�޸�����
	public Integer updatePassword(@Param("id") Integer id,@Param("userPassword") String userPassword);
	
	//ɾ���û�
	public Integer delUser(@Param("id") Integer id);
	/**
	 * ��Ӧ�̱�
	 * @param proCode
	 * @param proName
	 * @param from
	 * @param pageSize
	 * @return
	 */
	//���ݹ�Ӧ�̱���͹�Ӧ������ģ����ѯ�������з�ҳ
	public List<Provider> getProLimit(@Param("proCode") String proCode,@Param("proName") String proName,@Param("from") Integer from,@Param("pageSize") Integer pageSize);

	//���
	public Integer getProCount(@Param("proCode") String proCode,@Param("proName") String proName);

	//���
	public Integer Proadd(Provider pro);
	
	//����id��ѯ
	public Provider ByIdPro(@Param("proId") Integer proId);
	
	//�޸�
	public Integer Proupdate(Provider pro);
	
	//��ѯ��Ӧ������
	public List<Provider> getProName();
	
	//����idɾ����Ӧ��
	public Integer delProVider(@Param("id") Integer proId);
	
	//��ѯ��Ӧ���µĶ�����Ϣ
	public Integer getBillPro(@Param("id") Integer id);
	/**
	 * 
	 * ��ɫ��
	 */

	//��ѯRoleName
	public List<Role> getRole();
	
	//��ҳ��ѯ
	public List<Role> getRoleList(@Param("from") Integer from,@Param("pageSize") Integer pageSize);

	//��ѯ�ܼ�¼
	public Integer getRoleCount();
	
	//����id��ѯ
	public Role RoleById(@Param("id") Integer id);
	
	//�޸�
	public Integer updateRole(Role role);
	
	//ɾ����ɫ��Ϣ
	public Integer delRole(@Param("id") Integer id);
	
	//�жϽ�ɫ�����Ƿ����Ա��
	public Integer RoleByUser(@Param("id") Integer id);
	
	//��ӽ�ɫ
	public Integer RoleAdd(Role role);
	
	//�û�������֤�Ƿ����
	public Integer RoleByCode(@Param("roleCode") String roleCode);

	/**
	 * ������  
	 */
	//��ҳ��ѯ
	public List<Bill> getBillLimit(@Param("productName") String productName,@Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment,@Param("form") Integer form,@Param("pageSize") Integer pageSize);

	//�ܼ�¼
	public Integer getBillCount(@Param("productName") String productName,@Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment);
	
	//���
	public Integer addBill(Bill bill);
	
	//����id��ʾ
	public Bill getByBillId(@Param("Id") Integer id);
	
	//�޸�
	public Integer updateBill(Bill bill);
	
	//����idɾ��������Ϣ
	public Integer delBill(@Param("id") Integer id);
	
	
}
