package com.example.czero.szzj.SZZJModel;

import cn.bmob.v3.BmobObject;

/**
 * 二手交易实体类
 * @date 2014-9-15
 * @author Stone
 */
@SuppressWarnings("serial")
public class Tour extends BmobObject {


	private String name = "";
	private String content = "";
	private String time ="";
	private String tourname="";
	private String tourcontact="";
	private String tourcontent="";

	public void setTourname(String tourname) {
		this.tourname = tourname;
	}

	public void setTourcontent(String tourcontent) {
		this.tourcontent = tourcontent;
	}

	public void setTourcontact(String tourcontact) {
		this.tourcontact = tourcontact;
	}

	public String getTourname() {
		return tourname;
	}

	public String getTourcontent() {
		return tourcontent;
	}

	public String getTourcontact() {
		return tourcontact;
	}





	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {

		return time;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;

	}




}
