package cn.smbms.controller;

import java.io.File;
import java.lang.annotation.Retention;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

import cn.smbms.contants.Contants;
import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Page;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.UserService;

@Controller
@RequestMapping("/user")
public class SmbmsController {

	@Resource
	private UserService users;

	// ��ת����¼ҳ��
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	// ע��
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("Contants.USER_SESSION");
		return "login";

	}

	// ��¼��֤
	@RequestMapping("/dologin")
	public String doLogin(@RequestParam("userCode") String UserCode,
			@RequestParam("userPassword") String UserPassword,
			HttpSession session) {
		User user = users.LoginUser(UserCode, UserPassword);
		if (user != null) {

			// ����session
			session.setAttribute(Contants.USER_SESSION, user);
			// ҳ����ת(frame.jsp)
			return "redirect:/user/main";
		} else {
			// ҳ����ת(login.jsp)��������ʾ--ת��
			session.setAttribute("error", "�û��������벻��ȷ");
			return "login";
		}
	}

	@RequestMapping("/main")
	public String main(HttpSession session) {
		// System.out.println(Contants.USER_SESSION);
		if (session.getAttribute(Contants.USER_SESSION) == null) {
			return "redirect:/user/login";
		}
		return "frame";
	}

	/**
	 * �û���
	 * 
	 * @param userName
	 * @param userRole
	 * @param pageIndex
	 * @param session
	 * @return
	 */

	// �û����� ��ҳ��ѯ
	@RequestMapping("/userlist")
	public String userLimit(
			@RequestParam(value = "queryname", required = false) String userName,
			@RequestParam(value = "queryUserRole", required = false) String userRole,
			@RequestParam(value = "pageIndex", required = false) String pageIndex,
			HttpSession session) {

		// roleId
		Integer roleId = 0;
		if (!StringUtils.isNullOrEmpty(userRole)) {
			roleId = Integer.valueOf(userRole);
		}
		// ��ǰҳ
		int index = 1;
		if (!StringUtils.isNullOrEmpty(pageIndex)) {
			index = Integer.valueOf(pageIndex);
		}
		// ����������ֵ
		List<Role> roleList = users.getRole();
		session.setAttribute("roleList", roleList);

		// ��ҳ��
		Integer zongjilu = users.getCount(userName, roleId);

		// ��ҳ
		Page page = new Page(index, zongjilu);
		List<User> userList = users.getUserList(userName, roleId,
				page.getPageIndex(), page.getYedaxiao());
		page.setList(userList);
		session.setAttribute("queryname", userName);
		session.setAttribute("queryUserRole", userRole);
		session.setAttribute("page", page);

		return "userlist";

	}

	// �û����
	// ��ת�����ҳ��
	@RequestMapping("/addUser")
	public String addShow(Model model) {

		return "useradd";
	}

	// ��ת�����ҳ��
	@RequestMapping("/addShow")
	public String addShow2(Model model) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// ��ȡ�������ֵ
		List<Role> rolelist = users.getRole();
		// model.addAttribute("roleList", rolelist);
		map.put("rolelist", rolelist);
		return JSONArray.toJSONString(map);

	}

	// ��ӷ���
	// MultipartFile attach ���ļ��ϴ�����
	@RequestMapping("/SaveUser")
	public String addUser(
			User user,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs) {
		Integer userId = ((User) session.getAttribute(Contants.USER_SESSION))
				.getId();// �õ���ǰ��¼�û���ID
		// �ļ��ϴ�
		String idPicPath = "";// ֤���� �����ļ������·��
		String workPicPath = "";// ������

		// MultipartFile[] attachs ���ļ��ϴ�

		for (int i = 0; i < attachs.length; i++) {
			MultipartFile attach = attachs[i];

			if (i == 0) {
				// request.setAttribute("uploadFileError", "�ϴ��ļ�ʧ��");
				System.out.println("1");
			} else if (i == 1) {
				System.out.println("2");
			}
			// �жϵ�ǰ�ļ��Ƿ�Ϊ��
			if (!attach.isEmpty()) {
				// �����ϴ��ļ��ı����ַ
				// File.separatorȡ�����Ƿָ���\\
				String path = session.getServletContext().getRealPath(
						"statics" + File.separator + "uploadfile");
				String oldFileName = attach.getOriginalFilename();// �õ��ϴ��ļ���ԭ�ļ���
				String suffix = FilenameUtils.getExtension(oldFileName);// �õ��ļ�����ĺ�׺
				if (attach.getSize() > 5000000) {
					request.setAttribute("uploadFileError",
							"���ϴ����ļ��ߴ糬��500KB,�ϴ�ʧ��");
					return "useradd";
				} else if (suffix.equalsIgnoreCase("jpg")
						|| suffix.equalsIgnoreCase("jpeg")
						|| suffix.equalsIgnoreCase("pneg")) {
					// ˵���ļ��ߴ���ʣ���׺�Ϸ�

					// �ع��ļ���
					String fileName = System.currentTimeMillis()
							+ RandomUtils.nextInt(100000000) + "_Personal.jpg";
					// �����ļ������ļ��ı���·������һ��File����
					File tagetFile = new File(path, fileName);
					if (!tagetFile.exists()) {// �жϵ�ǰ�ļ��ı���·���Ƿ����
						tagetFile.mkdirs();// ������Ŀ¼
					}

					try {
						// ִ���ļ��ϴ�
						attach.transferTo(tagetFile);
					} catch (Exception e) {
						request.setAttribute("uploadFileError",
								"�ļ��ϴ�ʧ�ܣ�" + e.getMessage());

						return "useradd";
					}
					if (i == 0) {
						// �õ�������·������ǰ��Ŀ������
						idPicPath = request.getContextPath() + File.separator
								+ "statics" + File.separator + "uploadfile"
								+ File.separator + fileName;
					} else if (i == 1) {
						workPicPath = request.getContextPath() + File.separator
								+ "statics" + File.separator + "uploadfile"
								+ File.separator + fileName;
					}

				} else {
					request.setAttribute("uploadFileError", "���ϴ����ļ���ʽ����ȷ");
					return "useradd";
				}
			}
		}

		user.setCreatedBy(userId);
		user.setCreatetionDate(new Date());
		// �����ϴ�
		user.setIdPicPath(idPicPath);
		user.setWorkPicPath(workPicPath);
		boolean flag = users.addUser(user);
		if (flag) {
			return "redirect:/user/userlist";
		} else {
			return "useradd";
		}
	}

	// ��ʾ�û���Ϣ
	@RequestMapping("userView/{userId}")
	public String userView(@PathVariable Integer userId, HttpSession session) {
		User user = users.ByIdUser(userId);

		session.setAttribute("user", user);
		return "userview";
	}

	// ʹ��json�첽ˢ��
	// ���û�����ҳ����ʾ�û���Ϣ
	@RequestMapping("/userViews")
	@ResponseBody
	public User userViews(@RequestParam("id") Integer id) {

		User user = users.ByIdUser(id);

		return user;
	}

	// �û�������֤
	@RequestMapping("/ucExcits")
	@ResponseBody
	public Object userCodeExit(@RequestParam("userCode") String userCode) {

		HashMap<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNullOrEmpty(userCode)) {
			map.put("userCode", "exist");
		} else {
			boolean flag = users.selectUserCode(userCode);
			if (flag) {
				map.put("userCode", "exist");
			} else {
				map.put("userCode", "noexist");
			}
		}
		return JSONArray.toJSONString(map);

	}

	// ��ʾ+�޸�
	@RequestMapping("userShow/{userId}")
	public String userShow(@PathVariable Integer userId, HttpSession session) {
		List<Role> roleList = users.getRole();
		User user = users.ByIdUser(userId);
		session.setAttribute("roleList", roleList);
		session.setAttribute("user", user);
		return "usermodify";
	}

	// �޸�ҳ��
	@RequestMapping("userUpd")
	public String userUpdate(User user, HttpSession session) {
		Integer id = ((User) session.getAttribute(Contants.USER_SESSION))
				.getId();

		user.setCreatedBy(id);

		boolean flag = users.updateUser(user);
		if (flag) {
			return "redirect:/user/userlist";
		}
		return "usermodify";

	}

	// ��ת���޸�ҳ��
	@RequestMapping("/pwdmodify")
	public String pwdShow() {
		return "pwdmodify";
	}

	// ��֤����
	@RequestMapping("/pwd")
	@ResponseBody
	public String pwdShow(@RequestParam("oldpassword") String oldpassword,
			HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		String userCode = ((User) session.getAttribute(Contants.USER_SESSION))
				.getUserCode();

		User user = users.LoginUser(userCode, oldpassword);
		if (oldpassword == null) {
			map.put("result", "error");

		}
		if (user != null) {
			map.put("result", "true");
		} else {
			map.put("result", "false");
		}
		if (((User) session.getAttribute(Contants.USER_SESSION)) == null) {
			map.put("result", "sessionerror");
		}

		return JSONArray.toJSONString(map);
	}

	// �޸�����
	@RequestMapping("/updatePassword")
	public String updatPassword(
			@RequestParam("oldpassword") String oldpassword,
			@RequestParam("newpassword") String newpassword, HttpSession session) {
		Integer id = ((User) session.getAttribute(Contants.USER_SESSION))
				.getId();
		boolean flag = users.updatePassword(id, newpassword);
		System.out.println(flag);
		if (flag) {

			return "login";
		}
		session.setAttribute("message", "�޸�����ʧ��");
		return "pwdmodify";

	}

	@RequestMapping("/delUser")
	@ResponseBody
	public String delUser(@RequestParam("uid") Integer id, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// ɾ���ļ�
		String path = "D://Work//.metadata//.plugins//org.eclipse.wst.server.core//tmp0//wtpwebapps";
		User user = users.ByIdUser(id);
		if (user != null) {
			if (user.getIdPicPath() != null && user.getWorkPicPath() != null) {
				String idPicPath = path + user.getIdPicPath();
				String workPicPath = path + user.getWorkPicPath();
				deleteFile(idPicPath, workPicPath);
			}
			// ����ɾ��
			boolean flag = users.delUser(id);

			if (flag) {
				map.put("delResult", "true");
			} else {
				map.put("delResult", "false");
			}
		} else {
			map.put("delResult", "notexist");
		}

		return JSONArray.toJSONString(map);

	}

	// ɾ���û������ļ�����
	public boolean deleteFile(String idPicPath, String workPicPath) {

		boolean flag1 = false;
		boolean flag2 = false;
		File file1 = new File(idPicPath);
		File file2 = new File(workPicPath);
		if (file1.isFile() && file1.exists() || file2.isFile()
				&& file2.exists()) {
			flag1 = file1.delete();
			flag2 = file2.delete();
		}
		if (flag1 == true && flag2 == true) {
			return true;
		}
		return false;

	}

	/**
	 * ��Ӧ�̱�
	 * 
	 * @param queryProCode
	 * @param queryProName
	 * @param pageIndex
	 * @param session
	 * @return
	 */

	// ɾ����Ӧ��
	@RequestMapping("prodel")
	@ResponseBody
	public String delprovider(@RequestParam("proid") Integer id,
			HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// ɾ���ļ�
		String path = "D://Work//.metadata//.plugins//org.eclipse.wst.server.core//tmp0//wtpwebapps";
		Provider pro = users.ByIdPro(id);

		if (pro != null) {
			int count = users.getBillPro(id);
			if (count > 0) {
				map.put("delResult", count);
			} else {
				if (pro.getBusinessPath() != null && pro.getOrganPath() != null) {
					String businessPath = path + pro.getBusinessPath();
					String organPath = path + pro.getOrganPath();
					deleteFile(businessPath, organPath);
				}

				boolean flag = users.delProVider(id);

				if (flag) {
					map.put("delResult", "true");
				} else {
					map.put("delResult", "false");
				}
			}

		} else {
			map.put("delResult", "notexist");
		}
		return JSONArray.toJSONString(map);

	}

	// ��Ӧ�̹��� ��ҳ��ѯ
	@RequestMapping("prolist")
	public String prolist(
			@RequestParam(value = "queryProCode", required = false) String proCode,
			@RequestParam(value = "queryProName", required = false) String proName,
			@RequestParam(value = "pageIndex", required = false) String pageIndex,
			HttpSession session) {
		// �ܼ�¼
		Integer zongjilu = users.getProCount(proCode, proName);

		Integer index = 1;
		if (!StringUtils.isNullOrEmpty(pageIndex)) {
			index = Integer.valueOf(pageIndex);
		}

		Page page = new Page(index, zongjilu);
		List<Provider> providerList = users.getProLimit(proCode, proName,
				page.getPageIndex(), page.getYedaxiao());
		page.setProlist(providerList);
		session.setAttribute("providerList", page.getProlist());
		session.setAttribute("page", page);
		return "providerlist";

	}

	// ��ת��ӹ�Ӧ�̵�jsp
	@RequestMapping("showpro")
	public String Pro() {

		return "provideradd";
	}

	// ��ӹ�Ӧ�̼�¼
	@RequestMapping("proadd")
	public String Proadd(
			Provider pro,
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs,
			HttpSession session, HttpServletRequest request) {
		Integer userId = ((User) session.getAttribute(Contants.USER_SESSION))
				.getId();

		// �ļ��ϴ�
		String businessPath = "";// ��ҵӪҵִ�� �����ļ������·��
		String organPath = "";// ��֯��������֤
		for (int i = 0; i < attachs.length; i++) {
			MultipartFile attach = attachs[i];

			// �жϵ�ǰ�ļ��Ƿ�Ϊ��
			if (!attach.isEmpty()) {
				// �����ϴ��ļ��ı����ַ
				// File.separatorȡ�����Ƿָ���
				String path = session.getServletContext().getRealPath(
						"statics" + File.separator + "uploadfile");
				String oldFileName = attach.getOriginalFilename();// �õ��ϴ��ļ���ԭ�ļ���
				String suffix = FilenameUtils.getExtension(oldFileName);// �õ��ļ�����ĺ�׺
				if (attach.getSize() > 5000000) {
					request.setAttribute("uploadFileError",
							"���ϴ����ļ��ߴ糬��500KB,�ϴ�ʧ��");
					return "provideradd";
				} else if (suffix.equalsIgnoreCase("jpg")
						|| suffix.equalsIgnoreCase("jpeg")
						|| suffix.equalsIgnoreCase("pneg")) {
					// ˵���ļ��ߴ���ʣ���׺�Ϸ�

					// �ع��ļ���
					String fileName = System.currentTimeMillis()
							+ RandomUtils.nextInt(100000000) + "_Personal.jpg";
					// �����ļ������ļ��ı���·������һ��File����
					File tagetFile = new File(path, fileName);
					if (!tagetFile.exists()) {// �жϵ�ǰ�ļ��ı���·���Ƿ����
						tagetFile.mkdirs();// ������Ŀ¼
					}

					try {
						// ִ���ļ��ϴ�
						attach.transferTo(tagetFile);
					} catch (Exception e) {
						request.setAttribute("uploadFileError",
								"�ļ��ϴ�ʧ�ܣ�" + e.getMessage());
						return "provideradd";
					}
					if (i == 0) {
						// �õ�������·������ǰ��Ŀ������
						businessPath = request.getContextPath()
								+ File.separator + "statics" + File.separator
								+ "uploadfile" + File.separator + fileName;
					} else {
						organPath = request.getContextPath() + File.separator
								+ "statics" + File.separator + "uploadfile"
								+ File.separator + fileName;
					}

				} else {
					request.setAttribute("uploadFileError", "���ϴ����ļ���ʽ����ȷ");
					return "provideradd";
				}
			}
		}

		pro.setCreatedBy(userId);
		pro.setCreationDate(new Date());
		pro.setBusinessPath(businessPath);
		pro.setOrganPath(organPath);

		boolean flag = users.Proadd(pro);
		if (flag) {
			return "redirect:/user/prolist";
		}
		return "provideradd";

	}

	// ��ʾ��Ӧ�̼�¼ ��Ϣ�鿴
	@RequestMapping("proShow/{proid}")
	public String showPro(@PathVariable Integer proid, HttpSession session) {
		Provider provider = users.ByIdPro(proid);
		session.setAttribute("provider", provider);
		return "providerview";
	}

	// �޸�ҳ�� ��Ϣ��ʾ
	@RequestMapping("proModify/{proid}")
	public String proModify(@PathVariable Integer proid, HttpSession session) {
		Provider provider = users.ByIdPro(proid);
		session.setAttribute("provider", provider);
		return "providermodify";
	}

	// �޸ķ���
	@RequestMapping("proModifyUpdate")
	public String updateModify(Provider pro, HttpSession session) {
		Integer id = ((User) session.getAttribute(Contants.USER_SESSION))
				.getId();
		pro.setCreatedBy(id);
		// pro.setCreationDate(new Date());
		boolean flag = users.Proupdate(pro);
		// System.err.println(flag);
		// System.err.println(pro.getId());
		if (flag) {
			return "redirect:/user/prolist";
		}
		return "providermodify";
	}

	/**
	 * ��ɫ��
	 */
	@RequestMapping("/rolelist")
	public String rolelist(
			@RequestParam(value = "pageIndex", required = false) String pageIndex,
			HttpSession session) {
		Integer index = 1;
		if (!StringUtils.isNullOrEmpty(pageIndex)) {
			index = Integer.valueOf(pageIndex);
		}
		Integer zongjilu = users.getRoleCount();
		Page page = new Page(index, zongjilu);
		List<Role> rolelist = users.getRoleList(page.getPageIndex(),
				page.getYedaxiao());
		page.setRolelist(rolelist);
		session.setAttribute("rolelists", page.getRolelist());
		session.setAttribute("page", page);
		return "rolelist";
	}

	@RequestMapping("roleShow/{roleid}")
	public String roleView(@PathVariable Integer roleid, HttpSession session) {
		Role role = users.RoleById(roleid);
		System.out.println(role);
		session.setAttribute("role", role);
		return "roleview";

	}
	
	@RequestMapping(value="/roledel",method=RequestMethod.GET)
	@ResponseBody
	public String delrole(@RequestParam("roleid") Integer id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		Role role = users.RoleById(id);
		if (role!= null) {
			int count = users.RoleByUser(id);
			System.err.println(count);
			if (count > 0) {
				map.put("delResult", count);
			}else{
				boolean flag = users.delRole(id);
				if (flag) {
					map.put("delResult", "true");
				}else{
					map.put("delResult", "false");
				}
			}
			
		}else{
			map.put("delResult", "notexist");
		}
		return JSONArray.toJSONString(map);
		
		
	}
	
	@RequestMapping("/addRoleShow")
	public String addRoleShow(){
		return "roleadd";
		
	}
	
	@RequestMapping("/addRole")
	public String addRole(Role role,HttpSession session){
		int id = ((User)session.getAttribute(Contants.USER_SESSION)).getId();
		role.setCreatedBy(id);
		role.setCreationDate(new Date());
		
		boolean flag = users.RoleAdd(role);
		if (flag) {
			return "redirect:/user/rolelist";
		}
		return "roleadd";
	}
	
	@RequestMapping("/rcExcits")
	@ResponseBody
	public String RoleByCode(@RequestParam("roleCode") String roleCode,HttpSession session){
		HashMap< String, Object> map = new HashMap<String, Object>();
	 int count = 	users.RoleByCode(roleCode);
		if (count > 0) {
			map.put("roleCode","exist" );
		}
		return JSONArray.toJSONString(map);
		
	}
	@RequestMapping("updaterole/{roleid}")
	public String RoleUpd(@PathVariable Integer roleid,HttpSession session){
	Role role=users.RoleById(roleid);
		session.setAttribute("role", role);
		return "rolemodify";
	}
	@RequestMapping("rolemodify")
	public String RoleUpd(Role role,HttpSession session){
		int id = ((User)session.getAttribute(Contants.USER_SESSION)).getId();
		role.setModifyBy(id);
		role.setModifyDate(new Date());
		boolean flag=users.updateRole(role);
		if (flag) {
			return "redirect:/user/rolelist";
		}
		return "rolemodify";
	}
	
	
	
	
	
	
	

	/**
	 * ������
	 */

	// ������ѯ
	@RequestMapping("/billShow")
	public String billSelect(
			@RequestParam(value = "queryProductName", required = false) String queryProductName,
			@RequestParam(value = "queryProviderId", required = false) Integer queryProviderId,
			@RequestParam(value = "queryIsPayment", required = false) Integer queryIsPayment,
			@RequestParam(value = "pageIndex", required = false) String pageIndex,
			HttpSession session) {
		int zongjilu = users.getBillCount(queryProductName, queryProviderId,
				queryIsPayment);

		List<Provider> prolist = users.getProName();

		Integer index = 1;
		if (!StringUtils.isNullOrEmpty(pageIndex)) {
			index = Integer.parseInt(pageIndex);
		}

		Page page = new Page(index, zongjilu);
		List<Bill> billList = users.getBillLimit(queryProductName,
				queryProviderId, queryIsPayment, page.getPageIndex(),
				page.getYedaxiao());
		page.setBilllist(billList);
		session.setAttribute("providerList", prolist);
		session.setAttribute("billList", page.getBilllist());
		session.setAttribute("queryProductName", queryProductName);
		session.setAttribute("queryProviderId", queryProviderId);
		session.setAttribute("queryIsPayment", queryIsPayment);
		session.setAttribute("page", page);
		return "billlist";

	}

	// ��ת�����ҳ��
	@RequestMapping("/billadd")
	public String billaddShow(HttpSession session) {
		List<Provider> prolist = users.getProName();
		session.setAttribute("providerList", prolist);
		return "billadd";
	}

	// ���
	@RequestMapping("/billaddAll")
	public String billaddAll(Bill bill, HttpSession session) {
		Integer id = ((User) session.getAttribute(Contants.USER_SESSION))
				.getId();
		bill.setCreatedBy(id);
		bill.setCreationDate(new Date());

		boolean flag = users.addBill(bill);

		System.err.println(bill.getBillCode());
		System.err.println(flag);
		if (flag) {
			return "redirect:/user/billShow";
		}
		return "billadd";

	}

	// �鿴��ʾ
	@RequestMapping("/billView/{billid}")
	public String billView(@PathVariable Integer billid, HttpSession session) {

		Bill bill = users.getByBillId(billid);
		session.setAttribute("bill", bill);
		return "billview";

	}

	// ��ת���޸�ҳ��
	@RequestMapping("/billmodify/{billid}")
	public String billmodify(@PathVariable Integer billid, HttpSession session) {
		Bill bill = users.getByBillId(billid);
		List<Provider> prolist = users.getProName();
		session.setAttribute("providerList", prolist);
		session.setAttribute("bill", bill);
		return "billmodify";

	}

	// ִ���޸Ĳ���
	@RequestMapping("/billupdate")
	public String billupdate(Bill bill, HttpSession session) {
		
		Integer uid = ((User)session.getAttribute(Contants.USER_SESSION)).getId();
		bill.setModifyBy(uid);
		bill.setModifyDate(new Date());
		
		boolean flag = users.updateBill(bill);
		if (flag) {
			return "redirect:/user/billShow";
		}
		return "billmodify";

	}

	// �Զ�������ɾ��
	@RequestMapping("/billdel")
	@ResponseBody
	public String delbill(@RequestParam("billid") Integer id) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		Bill bill = users.getByBillId(id);
		if (bill != null) {
			boolean flag = users.delBill(id);
			if (flag) {
				map.put("delResult", "true");
			} else {
				map.put("delResult", "false");
			}
		} else {
			map.put("delResult", "notexist");
		}

		return JSONArray.toJSONString(map);

	}

}
