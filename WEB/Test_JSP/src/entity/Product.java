package entity;

import java.io.Serializable;
/**
 * …Ã∆∑¿‡
 * @author Wys
 *
 */
public class Product implements Serializable{
	private String id;
	private String name;
	private int number;
	private String describe;
	private String img;
	private int money;

	public Product(String id, String name, int number, String describe,
			String img, int money) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.describe = describe;
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

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getId() {
		return id;
	}

	public void setid(String id){
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public Product() {
	}

}
