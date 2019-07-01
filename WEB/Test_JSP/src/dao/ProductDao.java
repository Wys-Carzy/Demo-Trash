package dao;

import java.sql.*;
import java.util.*;

import util.DBHelper;
import entity.*;
/**
 * ��Ʒʵ�ʲ�����
 * @author Wys
 *
 */
public class ProductDao {
	/**
	 * ��ѯ����
	 */
	public Map<String, Product> queryAll() {
		Map<String, Product> map = null;
		Connection conn = DBHelper.getConnection();
		String sql = "select * from goods";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			map = new HashMap<String, Product>();
			while ( rs.next() ) {
				Product pro = new Product();
				pro.setid(rs.getString(1));
				pro.setName(rs.getString(2));
				pro.setMoney(rs.getInt(3));
				pro.setDescribe(rs.getString(4));
				pro.setImg(rs.getString(5));
				map.put(pro.getId(), pro);
			}
		} catch (SQLException e) {
			System.out.println("���ݿ��磡");
		}
		
		return map;
	}
	/**
	 * ������Ʒ��Ų�ѯ��Ʒ�б�
	 */
	public Product selectGoods(String id) {
		Product pro = null;
		Connection conn = DBHelper.getConnection();
		String sql = "select * from goods where ID=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			if ( rs.next() ) {
				pro = new Product();
				pro.setid(rs.getString(1));
				pro.setName(rs.getString(2));
				pro.setImg(rs.getString(5));
				pro.setMoney(rs.getInt(3));
			}
		} catch (SQLException e) {
			System.out.println("���ݿ��磡");
		}
		return pro;
	}
	/**
	 * �����Ʒ
	 */
	public boolean add(Product P , int num ,Object name, String table){
        String sql = "INSERT INTO "+ table +" (Id, Name, USERNAME , NUMBER_ , MONEY,IMG) VALUES (?,?,?,?,?,?)";  
        Connection conn = DBHelper.getConnection();              									 
        PreparedStatement pst = null;                     								   
        try {
            pst = conn.prepareStatement(sql);   
            pst.setString(1, P.getId());   
            pst.setString(2, P.getName()); 
            pst.setObject(3, name);
            pst.setInt(4, num);
            pst.setInt(5,P.getMoney());
            pst.setString(6, P.getImg());
            int i = pst.executeUpdate();
            if(i>0){
            	return true;
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return false;
    }
    /**
     * �����û�������ƷID��ѯ���ﳵ
     */
    public Shopping selectShop(Product p,Object name) {
    	Shopping shopping = null;                                                     
        String sql = "SELECT * FROM Shopping WHERE ID=? AND UserName=?";	          
        Connection conn = DBHelper.getConnection();                                  
        PreparedStatement pst = null;                                     	 	 
        try {
            pst = conn.prepareStatement(sql);                                  
            pst.setString(1,p.getId());                                              
            pst.setObject(2,name);
            ResultSet rs = pst.executeQuery();								  
           if ( rs.next() ) {
                String SID = rs.getString(1);                            
                String SName = rs.getString(2);
                String UName = rs.getString(3);	 
                int money = rs.getInt(4);
                int number = rs.getInt(5);       
                String img = rs.getString(6);
                shopping = new Shopping(SID, SName, money , UName , img ,number );   
            }
        } catch (SQLException e) {
        	System.out.println("���ݿ��磬�����ԣ�");
       }
       return shopping;
   }
    /**
     * �����û�����ѯ���ﳵ
     */
    public Map<String, Shopping> selectShop_1(Object name , String table) {
    	Map<String, Shopping> map = new HashMap<String, Shopping>();                                                 
        String sql = "SELECT * FROM "+ table +" WHERE UserName=?";	        
        Connection conn = DBHelper.getConnection();                                        
        PreparedStatement pst = null;                                     	 	  
        try {
            pst = conn.prepareStatement(sql);  
            pst.setObject(1, name);
            ResultSet rs = pst.executeQuery();
            while ( rs.next() ) {
        	    Shopping pro = new Shopping();
				pro.setSID(rs.getString(1));
				pro.setSName(rs.getString(2));
				pro.setSNumber(rs.getInt(4));
				pro.setMoney(rs.getInt(5));
				pro.setImg(rs.getString(6));
				map.put(pro.getSID(), pro);
            }
        } catch (SQLException e) {
        	System.out.println("���ݿ��磬�����ԣ�");
       }
       return map;
   }
    /**
     * �޸Ķ�������
     */
	public boolean updateIndent(String id, int x, Object name, Shopping s) {                                          
        String sql = "UPDATE Indent SET NUMBER_=? WHERE ID=? and UserName = ?";	         
        Connection conn = DBHelper.getConnection();                                     
        PreparedStatement pst = null;                                     	
        try {
            pst = conn.prepareStatement(sql); 
            pst.setInt(1, (x+s.getMoney()));
            pst.setString(2, id);
            pst.setObject(3, name);
            int rs = pst.executeUpdate();
            if(rs>0){
            	return true;
            }
        } catch (SQLException e) {
        	System.out.println("���ݿ��磬�����ԣ�");
       }
       return false;
	}
	/**
	 * ɾ����Ʒ
	 */
	public boolean del(String id, Object name, String table) {
		String sql = "delete "+ table +" where ID=? and UserName=? ";	
        Connection conn = DBHelper.getConnection();     				
        PreparedStatement pst = null;                   		
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setObject(2, name);
            int result = pst.executeUpdate();   			
            if ( result > 0 ) {
                return true;
            }
        } catch (SQLException e) {
        	System.out.println("���ݿ��磬�����ԣ�");
        }
        return false;
	}
	/**
	 * �����û�������ƷID��ѯ����
	 */
	public Shopping Indent(Shopping s,Object name) {
    	Shopping shopping = null;                                                     
        String sql = "SELECT * FROM Indent WHERE ID=? AND UserName=?";	          
        Connection conn = DBHelper.getConnection();                                  
        PreparedStatement pst = null;                                     	 	 
        try {
            pst = conn.prepareStatement(sql);                                  
            pst.setString(1,s.getSID());                                              
            pst.setObject(2,name);
            ResultSet rs = pst.executeQuery();								  
           if ( rs.next() ) {
                String SID = rs.getString(1);                            
                String SName = rs.getString(2);          	       
                int money = rs.getInt(5);             	            
                String UName = rs.getString(3);					      
                String img = rs.getString(6);
                int number = rs.getInt(4);
                shopping = new Shopping(SID, SName, money , UName , img ,number );   
            }
        } catch (SQLException e) {
        	System.out.println("���ݿ��磬�����ԣ�");
       }
       return shopping;
   }
	/**
	 * �����ղ�
	 */
	public boolean collect(Product p, Object name) {
		String sql = "INSERT INTO collect (ID , Name , USERNAME , MONEY �� IMG) VALUES (?,?,?,?,?)";	      
        Connection conn = DBHelper.getConnection();                                      
        PreparedStatement pst = null;                                     	 	 
        try {
        	 pst = conn.prepareStatement(sql); 
             pst.setString(1, p.getId()); 
             pst.setString(2, p.getName()); 
             pst.setObject(3, name);
             pst.setInt(4,p.getMoney());
             pst.setString(5, p.getImg());
             int i = pst.executeUpdate();
             if(i>0){
             	return true;
             }
        } catch (SQLException e) {
        	e.printStackTrace();
        	System.out.println("���ݿ��磬�����ԣ�");
       }
       return false;
	}
	/**
	 * ��ѯ�ղؼ�
	 */
	public Map<String, Shopping> showCollect(Object name) {
		Map<String, Shopping> map = new HashMap<String, Shopping>();                                                 
        String sql = "SELECT * FROM collect WHERE UserName=?";	        
        Connection conn = DBHelper.getConnection();                                        
        PreparedStatement pst = null;                                     	 	  
        try {
            pst = conn.prepareStatement(sql);  
            pst.setObject(1, name);
            ResultSet rs = pst.executeQuery();
            while ( rs.next() ) {
        	    Shopping pro = new Shopping();
				pro.setSID(rs.getString(1));
				pro.setSName(rs.getString(2));
				pro.setMoney(rs.getInt(4));
				pro.setImg(rs.getString(5));
				map.put(pro.getSID(), pro);
            }
        } catch (SQLException e) {
        	System.out.println("���ݿ��磬�����ԣ�");
       }
       return map;
	}
	/**
	 * �����ղ�ǰ������Ʒ��Ų�ѯ
	 */
	public boolean showCollect_1(String id, Object name) {                       
        String sql = "SELECT * FROM Collect WHERE ID=? AND UserName=?";	          
        Connection conn = DBHelper.getConnection();                                  
        PreparedStatement pst = null;                                     	 	 
        try {
            pst = conn.prepareStatement(sql);                                  
            pst.setString(1,id);                                              
            pst.setObject(2,name);
            ResultSet rs = pst.executeQuery();								  
           if ( rs.next() ) {
        	   return true;
            }
        } catch (SQLException e) {
        	System.out.println("���ݿ��磬�����ԣ�");
       }
       return false;
	}
	/**
	 * ���ﳵ����ͬһ��ʱ�ڶ�������޸�����
	 */
	public boolean updateShop(Shopping s, int num, Object name) {                              
	        String sql = "UPDATE  shopping  SET NUMBER_=? WHERE ID=? and UserName = ?";	         
	        Connection conn = DBHelper.getConnection();                                     
	        PreparedStatement pst = null;                                     	
	        try {
	            pst = conn.prepareStatement(sql); 
	            int x = (num+s.getSNumber());
	            pst.setInt(1, x);
	            pst.setString(2, s.getSID());
	            pst.setObject(3, name);
	            int rs = pst.executeUpdate();
	            if(rs>0){
	            	return true;
	            }
	        } catch (SQLException e) {
	        	System.out.println("���ݿ��磬�����ԣ�");
	       }
	       return false;
	}
	/**
	 * �޸Ĺ��ﳵ��Ʒ
	 */
	public boolean update(String iD, int num, Object name) {
		String sql = "UPDATE  shopping  SET NUMBER_=? WHERE ID=? and UserName = ?";	         
        Connection conn = DBHelper.getConnection();                                     
        PreparedStatement pst = null;                                     	
        try {
            pst = conn.prepareStatement(sql); 
            pst.setInt(1, num);
            pst.setString(2, iD);
            pst.setObject(3, name);
            int rs = pst.executeUpdate();
            if(rs>0){
            	return true;
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        	System.out.println("���ݿ��磬�����ԣ�");
       }
       return false;
	}
}
