package services;

import dao.UsersDao;
/**
 *�û�ҵ���߼�����
 * @author Wys
 *
 */
public class UserServices {
	/**
	 * ��¼
	 */
	public boolean doLogin(String uname, String upwd) {
		UsersDao ud = new UsersDao();
		return ud.queryUsersByLogin(uname, upwd);
	}
	/**
	 * ע��
	 */
	public boolean doAdd(String uname, String upwd) {
		UsersDao ud = new UsersDao();
		return ud.addUser(uname, upwd);
	}
	/**
	 * �޸�����
	 */
	 public boolean pass(String name , String password , String pass){
		 UsersDao ud = new UsersDao();
		 boolean flag = ud.queryUsersByLogin(name, password);
		 if(flag==true){
			 flag = ud.pass(name, pass);
			 return true;
		 }
		return false;
	 }
}
