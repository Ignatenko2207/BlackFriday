package org.itstep;

public class Good {

	private String name;
	private String code;
	private int price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Good(String name, String code, int price) {
		this.name = name;
		this.code = code;
		this.price = price;
	}
	
	public Good() {
	}
}
