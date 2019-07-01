package entity;

import java.io.Serializable;

/**
 * 购物车类
 * @author Yusheng Wang
 *
 */
public class Shopping implements Serializable {
	private String SID;					//商品ID
	private String SName;				//商品名称
	private int SNumber;				//商品数量
	private String UName;				//用户名
	private String img;
	private int money;


	public Shopping(String sID, String sName, int sNumber, String uName,
			String img, int money) {
		SID = sID;
		SName = sName;
		SNumber = sNumber;
		UName = uName;
		this.img = img;
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Shopping(){}
	
	public String getSID() {
		return SID;
	}
	public void setSID(String sID) {
		this.SID = sID;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		this.SName = sName;
	}
	public int getSNumber() {
		return SNumber;
	}
	public void setSNumber(int sNumber) {
		this.SNumber = sNumber;
	}
	public String getUName() {
		return UName;
	}
	public void setUName(String uName) {
		this.UName = uName;
	}
	
	
}
