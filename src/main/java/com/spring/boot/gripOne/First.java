package com.spring.boot.gripOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class First {
	private String name;
	private String city;
	private int cell;
	@Autowired
	private Second secondParam;

	public Second getSecondParam() {
		return secondParam;
	}

	public void setSecondParam(Second secondParam) {
		this.secondParam = secondParam;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCell() {
		return cell;
	}
	public void setCell(int cell) {
		this.cell = cell;
	}
	public void display() {
		System.out.println("This is display in First");
		secondParam.myDisplay();
	}
}
