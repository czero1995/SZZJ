package com.example.czero.szzj.SZZJModel;

import cn.bmob.v3.BmobObject;

/** ����
  * @ClassName: Found
  * @Description: TODO
  * @author smile
  * @date 2014-5-21 ����2:16:08
  */
public class Found extends BmobObject {

	private String title;//����
	private String describe;//����
	private String phone;//��ϵ�ֻ�
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
