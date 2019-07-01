package services;

import java.util.Map;

import dao.ProductDao;
import entity.*;
/**
 * ��Ʒҵ���߼���
 * @author Wys
 *
 */
public class ProductServices {
	/**
	 * ��ʾ������Ʒ
	 */
	public Map<String, Product> showAllGoods() {
		ProductDao pd = new ProductDao();
		return pd.queryAll();
	}
	/**
	 * �����Ʒ�����ﳵ
	 */
	public boolean addCart(String ID , int num ,Object name){
		ProductDao pd = new ProductDao();
		Shopping s = pd.selectShop(pd.selectGoods(ID) , name);
		String table = "Shopping";
		if(s==null){
			boolean flag = pd.add(pd.selectGoods(ID), num ,name,table);
			return flag;
		}else{
			boolean flag = pd.updateShop(s , num ,name);
			return flag;
		}
	}
	/**
	 * ��ѯ��Ʒ
	 */
	public Map<String, Shopping> selectShop(Object name, String table){
		ProductDao pd = new ProductDao();
		return pd.selectShop_1(name,table);
	}
	/**
	 * �ύ����
	 */
	public boolean buyGoods(String id, int x, Object name) {
		ProductDao pd = new ProductDao();
		boolean flag;
		String table = "Indent";
		Shopping s = pd.Indent(pd.selectShop(pd.selectGoods(id) , name), name);
		if(s==null){
			flag = pd.add(pd.selectGoods(id), x ,name , table);
			if(flag==true){
				table = "Shopping";
				flag = pd.del(id , name ,table);
			}
		}else{
			flag = pd.updateIndent(id, x, name , s);
			if(flag==true){
				flag = pd.del(id , name ,table);
			}
		}
		return flag;
	}
	/**
	 * ɾ����Ʒ
	 */
	public boolean del(String id, Object name, String table) {
		ProductDao pd = new ProductDao();
		return pd.del(id, name ,table);
	}
	/**
	 * �����ղ�
	 */
	public boolean collect(String id, Object name) {
		ProductDao pd = new ProductDao();
		boolean flag = pd.showCollect_1(id , name);
		if(flag==false){
			flag = pd.collect(pd.selectGoods(id), name);
		}else{
			return false ;
		}	
		return flag;
	}
	/**
	 * ��ѯ�ղ�
	 */
	public Map<String, Shopping> showCollect(Object name) {
		ProductDao pd = new ProductDao();
		return pd.showCollect(name);
	}
	
	/**
	 * �޸Ĺ��ﳵ����
	 */
	public boolean update(String iD, Object name, int num) {
		ProductDao pd = new ProductDao();
		return pd.update(iD, num, name);
	}
}
