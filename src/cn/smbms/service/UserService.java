package cn.smbms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Page;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;

public interface UserService {
		//��¼��֤
		public User LoginUser(@Param("UserCode") String UserCode,@Param("UserPassword") String UserPassword);
		
		//��������ѯ
		public List<User> getUserList(@Param("userName")String userName,@Param("userRole") Integer userRole
				,@Param("from") Integer from,@Param("pageSize") Integer pageSize);  

		//�ܼ�¼
		public Integer getCount(@Param("userName")String userName,@Param("userRole")Integer userRole );

		//��ѯRoleName
		public List<Role> getRole();
		
		//���ݹ�Ӧ�̱���͹�Ӧ������ģ����ѯ�������з�ҳ
		public List<Provider> getProLimit(@Param("proCode") String proCode,@Param("proName") String proName,@Param("form") Integer from,@Param("pageSize") Integer pageSize);

		//���
		public Integer getProCount(@Param("proCode") String proCode,@Param("proName") String proName);

		//��ҳ��ѯ
		public List<Role> getRoleList(@Param("from") Integer from,@Param("pageSize") Integer pageSize);

		//��ѯ�ܼ�¼
		public Integer getRoleCount();
		
		//����û�
		public boolean addUser(User user);
		
		//��ӹ�Ӧ��
		public boolean Proadd(Provider pro);
		
		//����id��ѯ��Ӧ��
		public Provider ByIdPro(@Param("proId") Integer proId);
		

		//����id��ѯ�û���Ϣ
		public User ByIdUser(@Param("userId") Integer userId);
		
		//�޸��û���Ϣ
		public  boolean updateUser(User user);	
		//�޸Ĺ�Ӧ��
		public  boolean Proupdate(Provider pro);
		
		//��ѯ��Ӧ������
		public List<Provider> getProName();
		
		//����id��ѯ
		public Role RoleById(@Param("id") Integer id);
		
		//�޸�
		public boolean updateRole(Role role);
		
		//��ѯ�û������Ƿ�Ψһ
		public boolean selectUserCode(@Param("userCode") String userCode);
		//�޸�����
		public boolean updatePassword(@Param("id") Integer id,@Param("userPassword") String userPassword);
		
		//��ҳ��ѯ
		public List<Bill> getBillLimit(@Param("productName") String productName,@Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment,@Param("form") Integer form,@Param("pageSize") Integer pageSize);


		//�ܼ�¼
		public Integer getBillCount(@Param("productName") String productName,@Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment);


		//���
		public boolean addBill(Bill bill);
		
		//����id��ʾ
		public Bill getByBillId(@Param("Id") Integer id);
		
		
		//�޸�
		public boolean updateBill(Bill bill);
		
		//ɾ���û�
		public boolean delUser(@Param("id") Integer id);
		
		//����idɾ��������Ϣ
		public boolean delBill(@Param("id") Integer id);
		
		
		//����idɾ����Ӧ��
		public boolean delProVider(@Param("id") Integer proId);
		
		//��ѯ��Ӧ���µĶ�����Ϣ
		public Integer getBillPro(@Param("id") Integer id);
		
		//ɾ����ɫ��Ϣ
		public boolean delRole(@Param("id") Integer id);
		
		//�жϽ�ɫ�����Ƿ����Ա��
		public Integer RoleByUser(@Param("id") Integer id);

		//��ӽ�ɫ
		public boolean RoleAdd(Role role);
		
		//�û�������֤�Ƿ����
		public Integer RoleByCode(@Param("roleCode") String roleCode);
}
