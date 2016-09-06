package com.example.czero.szzj.SZZJModel;

import cn.bmob.v3.BmobObject;

public class Lost extends BmobObject {

	private String title;
	private String describe;
	private String phone;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
