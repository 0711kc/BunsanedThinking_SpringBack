package com.example.bunsanedthinking_springback.entity.product;


/**
 * @author ����ȯ
 * @version 1.0
 * @created 20-5-2024 ���� 7:52:27
 */

//2024-05-29 김대현
//2024-05-31 김대현
public abstract class Product implements Cloneable {

	public static final int PRODUCT_SERIAL_NUMBER = 700;
	
	private int id;
	private int maximumMoney;
	private String name;
	

	public Product() {
	}

	public abstract Product clone();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaximumMoney() {
		return maximumMoney;
	}

	public void setMaximumMoney(int maximumMoney) {
		this.maximumMoney = maximumMoney;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}