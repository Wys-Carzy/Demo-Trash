package services;

import java.util.Map;

import dao.ProductDao;
import entity.*;
/**
 * 商品业务逻辑类
 * @author Wys
 *
 */
public class ProductServices {
	/**
	 * 显示所有商品
	 */
	public Map<String, Product> showAllGoods() {
		ProductDao pd = new ProductDao();
		return pd.queryAll();
	}
	/**
	 * 添加商品至购物车
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
	 * 查询商品
	 */
	public Map<String, Shopping> selectShop(Object name, String table){
		ProductDao pd = new ProductDao();
		return pd.selectShop_1(name,table);
	}
	/**
	 * 提交订单
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
	 * 删除商品
	 */
	public boolean del(String id, Object name, String table) {
		ProductDao pd = new ProductDao();
		return pd.del(id, name ,table);
	}
	/**
	 * 加入收藏
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
	 * 查询收藏
	 */
	public Map<String, Shopping> showCollect(Object name) {
		ProductDao pd = new ProductDao();
		return pd.showCollect(name);
	}
	
	/**
	 * 修改购物车数量
	 */
	public boolean update(String iD, Object name, int num) {
		ProductDao pd = new ProductDao();
		return pd.update(iD, num, name);
	}
}
