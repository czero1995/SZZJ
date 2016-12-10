package com.example.czero.szzj.SZZJModel;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;


public class Union extends BmobObject {


	private String name = ""; //
	private String type = "";
	private String bannar = "";
	private BmobFile picUnion = null;
	private String time;
	private String slogan;
	private String activity;

	public String getSlogan() {
		return slogan;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getBannar() {
		return bannar;
	}



	public void setBannar(String bannar) {
		this.bannar = bannar;
	}






	public void setPicUnion(BmobFile picUnion) {
		this.picUnion = picUnion;
	}

	public BmobFile getPicUnion() {

		return picUnion;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {

		return time;
	}







	public String getType() {
		return type;
	}





	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;

	}

	public void setType(String type) {
		this.type = type;
	}



}
