package com.example.czero.szzj.SZZJModel;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * 二手交易实体类
 * @date 2014-9-15
 * @author Stone
 */
@SuppressWarnings("serial")
public class LiuYanBan extends BmobObject {

	private BmobFile imgamusetalk = null;
	public String getAmusecontent() {
		return amusecontent;
	}
	private String device;

	public void setAmusecontent(String amusecontent) {
		this.amusecontent = amusecontent;
	}

	private String amusecontent = ""; // 描述

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public BmobFile getImgamusetalk() {
		return imgamusetalk;
	}

	public void setImgamusetalk(BmobFile imgamusetalk) {
		this.imgamusetalk = imgamusetalk;
	}
}
