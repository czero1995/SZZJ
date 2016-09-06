package com.example.czero.szzj.SZZJModel;

import cn.bmob.v3.BmobObject;

/**
 * 首页校内新闻实体类
 * 
 * @date 2014-5-3
 * @author Stone
 */
@SuppressWarnings("serial")
public class ActivityNew extends BmobObject {


	private String name;
	private String title;
	private String content;
	private String itemcontern;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}
	public String getItemcontent() {
		return itemcontern;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public void setItemcontent(String itemcontent) {
		this.itemcontern = itemcontent;
	}



}
