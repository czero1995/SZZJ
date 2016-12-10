package com.example.czero.szzj.SZZJModel;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * 二手交易实体类
 * @date 2014-9-15
 * @author Stone
 */
@SuppressWarnings("serial")
public class Love extends BmobObject {
	private String name="";
	private String description = ""; // 描述

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {

		return name;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
