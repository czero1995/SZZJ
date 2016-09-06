package com.example.czero.szzj.SZZJModel;

import java.io.File;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * 二手交易实体类
 *
 * @author Stone
 * @date 2014-9-15
 */
@SuppressWarnings("serial")
public class ShanZhiQuan extends BmobObject {

    private String username;
    private BmobFile userimage;
    private String device;
    private String content;
	private Integer lovenumber;
    private Boolean islove;

    public Boolean getIslove() {
        return islove;
    }

    public void setIslove(Boolean islove) {
        this.islove = islove;
    }

    public BmobFile getUserimage() {
        return userimage;
    }

    public void setUserimage(BmobFile userimage) {
        this.userimage = userimage;
    }

    public Integer getLovenumber() {
        return lovenumber;
    }

    public void setLovenumber(Integer lovenumber) {
        this.lovenumber = lovenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
