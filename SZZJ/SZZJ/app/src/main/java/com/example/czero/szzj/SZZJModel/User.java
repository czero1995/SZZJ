package com.example.czero.szzj.SZZJModel;

import android.text.Editable;

import java.io.File;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * 用户实体类
 * @date 2014-4-24
 * @author Stone
 */
@SuppressWarnings("serial")
public class User extends BmobUser {

	// 父类中已经存在的属性
	// private String id;
	// private String username;
	// private String password;
	// private String email;
	// private String regTime;
		// 性别
	private String phone; 		// 电话
	private String qq; 			// QQ
	private String device; 			// QQ
	private String type = "普通用户";
	private String passwd;// 用户类型(普通用户、黑名单、中奖者)
	private BmobFile userimage = null;

	public BmobFile getUserimage() {
		return userimage;
	}

	public void setUserimage(BmobFile userimage) {
		this.userimage = userimage;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQQ() {
		return qq;
	}

	public void setQQ(String qq) {
		this.qq = qq;
	}



}
