package dao;

import java.sql.*;

import util.DBHelper;
import entity.Users;
/**
 * 用户实际操作类
 * @author Wys
 *
 */
public class UsersDao {
	/**
	 * 查询用户
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
	 * 注册用户
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
            flag = result == 1 ? true : false;      // 如果受影响行数等于 1 则成功，否则失败
        } catch (SQLException e) {
            System.out.println("已有此用户请直接登录！");
        }
        return flag;
    }
	/**
	 * 修改密码
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
    		System.out.println("数据库抽风，请重试！");
    	}
		return false;
	}
}
