package dao;

import java.sql.*;

import util.DBHelper;
import entity.Users;
/**
 * �û�ʵ�ʲ�����
 * @author Wys
 *
 */
public class UsersDao {
	/**
	 * ��ѯ�û�
	 */
	public boolean queryUsersByLogin(String uname, String upwd){
		Users u = null;
		String sql = "SELECT * FROM users WHERE NAME=? and password=?";
		Connection conn = DBHelper.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, uname);
			pst.setString(2, upwd);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				u = new Users();
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ע���û�
	 */
	public boolean addUser(String username, String password) {
        boolean flag = false;
        String sql = "INSERT INTO USERS(name,Password) VALUES(?,?)";
        Connection conn = DBHelper.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            int result = pst.executeUpdate();
            flag = result == 1 ? true : false;      // �����Ӱ���������� 1 ��ɹ�������ʧ��
        } catch (SQLException e) {
            System.out.println("���д��û���ֱ�ӵ�¼��");
        }
        return flag;
    }
	/**
	 * �޸�����
	 */
	public boolean pass(String name , String password){
		Connection C = DBHelper.getConnection();
    	String sql = "update Users set Password='"+ password + "' where Name = '"+ name +"'";
    	PreparedStatement pst = null;
    	try{
    		pst = C.prepareStatement(sql);
    		int num = pst.executeUpdate();
    		return true;
    	}catch(SQLException e){
    		System.out.println("���ݿ��磬�����ԣ�");
    	}
		return false;
	}
}
