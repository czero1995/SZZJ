package com.example.czero.szzj.SZZJModel;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * 店铺实体类， 实现序列化, Activity之间实现传递
 *
 * @author Stone
 * @date 2014-4-24
 */
public class Shop extends BmobObject implements Serializable {

    private String userID;        // 主人
    private String type;        // 类型(11代表第一个GridView中的第一个)
    private String name;        // 店名
    private String location;    // 地理位置
    private String phone1;
    private String phone2;
    private String phone3;    // 联系电话
    private String info;        // 简介
    private String sale;
    private String waimaimenu1;// 促销信息
    private String waimaimenu2;
    private String waimaimenu3;
    private String waimaimenu4;
    private String waimaimenu5;
    private String waimaimenu6;
    private String waimaimenu7;
    private String waimaimenu8;
    private String waimaimenu9;
    private String waimaimenu10;
    private String waimaimenu11;
    private String waimaimenu12;
    private String waimaimenu13;
    private String waimaimenu14;
    private String waimaimenu15;
    private String waimaimenu16;
    private String waimaimenu17;
    private String waimaimenu18;
    private String waimaimenu19;
    private String waimaimenu20;
    private String waimaimenu21;
    private String waimaimenu22;
    private String waimaimenu23;
    private BmobFile picShop = null; // 物品主图

    public void setPicShop(BmobFile picShop) {
        this.picShop = picShop;
    }

    public BmobFile getPicShop() {
        return picShop;
    }


    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public void setWaimaimenu1(String waimaimenu1) {
        this.waimaimenu1 = waimaimenu1;
    }

    public void setWaimaimenu2(String waimaimenu2) {
        this.waimaimenu2 = waimaimenu2;
    }

    public void setWaimaimenu3(String waimaimenu3) {
        this.waimaimenu3 = waimaimenu3;
    }

    public void setWaimaimenu4(String waimaimenu4) {
        this.waimaimenu4 = waimaimenu4;
    }

    public void setWaimaimenu6(String waimaimenu6) {
        this.waimaimenu6 = waimaimenu6;
    }

    public void setWaimaimenu5(String waimaimenu5) {
        this.waimaimenu5 = waimaimenu5;
    }

    public void setWaimaimenu7(String waimaimenu7) {
        this.waimaimenu7 = waimaimenu7;
    }

    public void setWaimaimenu8(String waimaimenu8) {
        this.waimaimenu8 = waimaimenu8;
    }

    public void setWaimaimenu9(String waimaimenu9) {
        this.waimaimenu9 = waimaimenu9;
    }

    public void setWaimaimenu10(String waimaimenu10) {
        this.waimaimenu10 = waimaimenu10;
    }

    public void setWaimaimenu11(String waimaimenu11) {
        this.waimaimenu11 = waimaimenu11;
    }

    public void setWaimaimenu12(String waimaimenu12) {
        this.waimaimenu12 = waimaimenu12;
    }

    public void setWaimaimenu14(String waimaimenu14) {
        this.waimaimenu14 = waimaimenu14;
    }

    public void setWaimaimenu13(String waimaimenu13) {
        this.waimaimenu13 = waimaimenu13;
    }

    public void setWaimaimenu15(String waimaimenu15) {
        this.waimaimenu15 = waimaimenu15;
    }

    public void setWaimaimenu16(String waimaimenu16) {
        this.waimaimenu16 = waimaimenu16;
    }

    public void setWaimaimenu17(String waimaimenu17) {
        this.waimaimenu17 = waimaimenu17;
    }

    public void setWaimaimenu18(String waimaimenu18) {
        this.waimaimenu18 = waimaimenu18;
    }

    public void setWaimaimenu19(String waimaimenu19) {
        this.waimaimenu19 = waimaimenu19;
    }

    public void setWaimaimenu20(String waimaimenu20) {
        this.waimaimenu20 = waimaimenu20;
    }

    public void setWaimaimenu21(String waimaimenu21) {
        this.waimaimenu21 = waimaimenu21;
    }

    public void setWaimaimenu22(String waimaimenu22) {
        this.waimaimenu22 = waimaimenu22;
    }

    public void setWaimaimenu23(String waimaimenu23) {
        this.waimaimenu23 = waimaimenu23;
    }

    public void setWaimaimenu24(String waimaimenu24) {
        this.waimaimenu24 = waimaimenu24;
    }

    public void setWaimaimenu25(String waimaimenu25) {
        this.waimaimenu25 = waimaimenu25;
    }

    public void setWaimaimenu26(String waimaimenu26) {
        this.waimaimenu26 = waimaimenu26;
    }

    public void setWaimaimenu27(String waimaimenu27) {
        this.waimaimenu27 = waimaimenu27;
    }

    public void setWaimaimenu28(String waimaimenu28) {
        this.waimaimenu28 = waimaimenu28;
    }

    public void setWaimaimenu29(String waimaimenu29) {
        this.waimaimenu29 = waimaimenu29;
    }

    public void setWaimaimenu30(String waimaimenu30) {
        this.waimaimenu30 = waimaimenu30;
    }

    public void setWaimaiprice1(String waimaiprice1) {
        this.waimaiprice1 = waimaiprice1;
    }

    public void setWaimaiprice2(String waimaiprice2) {
        this.waimaiprice2 = waimaiprice2;
    }

    public void setWaimaiprice3(String waimaiprice3) {
        this.waimaiprice3 = waimaiprice3;
    }

    public void setWaimaiprice4(String waimaiprice4) {
        this.waimaiprice4 = waimaiprice4;
    }

    public void setWaimaiprice5(String waimaiprice5) {
        this.waimaiprice5 = waimaiprice5;
    }

    public void setWaimaiprice6(String waimaiprice6) {
        this.waimaiprice6 = waimaiprice6;
    }

    public void setWaimaiprice7(String waimaiprice7) {
        this.waimaiprice7 = waimaiprice7;
    }

    public void setWaimaiprice8(String waimaiprice8) {
        this.waimaiprice8 = waimaiprice8;
    }

    public void setWaimaiprice9(String waimaiprice9) {
        this.waimaiprice9 = waimaiprice9;
    }

    public void setWaimaiprice10(String waimaiprice10) {
        this.waimaiprice10 = waimaiprice10;
    }

    public void setWaimaiprice11(String waimaiprice11) {
        this.waimaiprice11 = waimaiprice11;
    }

    public void setWaimaiprice12(String waimaiprice12) {
        this.waimaiprice12 = waimaiprice12;
    }

    public void setWaimaiprice13(String waimaiprice13) {
        this.waimaiprice13 = waimaiprice13;
    }

    public void setWaimaiprice14(String waimaiprice14) {
        this.waimaiprice14 = waimaiprice14;
    }

    public void setWaimaiprice15(String waimaiprice15) {
        this.waimaiprice15 = waimaiprice15;
    }

    public void setWaimaiprice16(String waimaiprice16) {
        this.waimaiprice16 = waimaiprice16;
    }

    public void setWaimaiprice17(String waimaiprice17) {
        this.waimaiprice17 = waimaiprice17;
    }

    public void setWaimaiprice18(String waimaiprice18) {
        this.waimaiprice18 = waimaiprice18;
    }

    public void setWaimaiprice19(String waimaiprice19) {
        this.waimaiprice19 = waimaiprice19;
    }

    public void setWaimaiprice20(String waimaiprice20) {
        this.waimaiprice20 = waimaiprice20;
    }

    public void setWaimaiprice21(String waimaiprice21) {
        this.waimaiprice21 = waimaiprice21;
    }

    public void setWaimaiprice22(String waimaiprice22) {
        this.waimaiprice22 = waimaiprice22;
    }

    public void setWaimaiprice23(String waimaiprice23) {
        this.waimaiprice23 = waimaiprice23;
    }

    public void setWaimaiprice24(String waimaiprice24) {
        this.waimaiprice24 = waimaiprice24;
    }

    public void setWaimaiprice25(String waimaiprice25) {
        this.waimaiprice25 = waimaiprice25;
    }

    public void setWaimaiprice26(String waimaiprice26) {
        this.waimaiprice26 = waimaiprice26;
    }

    public void setWaimaiprice28(String waimaiprice28) {
        this.waimaiprice28 = waimaiprice28;
    }

    public void setWaimaiprice27(String waimaiprice27) {
        this.waimaiprice27 = waimaiprice27;
    }

    public void setWaimaiprice29(String waimaiprice29) {
        this.waimaiprice29 = waimaiprice29;
    }

    public void setWaimaiprice30(String waimaiprice30) {
        this.waimaiprice30 = waimaiprice30;
    }

    public String getWaimaimenu11() {

        return waimaimenu11;
    }

    public String getWaimaimenu14() {
        return waimaimenu14;
    }

    public String getWaimaimenu12() {
        return waimaimenu12;
    }

    public String getWaimaimenu13() {
        return waimaimenu13;
    }

    public String getWaimaimenu19() {
        return waimaimenu19;
    }

    public String getWaimaimenu18() {
        return waimaimenu18;
    }

    public String getWaimaimenu15() {
        return waimaimenu15;
    }

    public String getWaimaimenu16() {
        return waimaimenu16;
    }

    public String getWaimaimenu17() {
        return waimaimenu17;
    }

    public String getWaimaimenu20() {
        return waimaimenu20;
    }

    public String getWaimaimenu21() {
        return waimaimenu21;
    }

    public String getWaimaimenu22() {
        return waimaimenu22;
    }

    public String getWaimaimenu23() {
        return waimaimenu23;
    }

    public String getWaimaimenu25() {
        return waimaimenu25;
    }

    public String getWaimaimenu24() {
        return waimaimenu24;
    }

    public String getWaimaimenu26() {
        return waimaimenu26;
    }

    public String getWaimaimenu27() {
        return waimaimenu27;
    }

    public String getWaimaimenu28() {
        return waimaimenu28;
    }

    public String getWaimaimenu29() {
        return waimaimenu29;
    }

    public String getWaimaimenu30() {
        return waimaimenu30;
    }

    public String getWaimaiprice11() {
        return waimaiprice11;
    }

    public String getWaimaiprice12() {
        return waimaiprice12;
    }

    public String getWaimaiprice13() {
        return waimaiprice13;
    }

    public String getWaimaiprice14() {
        return waimaiprice14;
    }

    public String getWaimaiprice15() {
        return waimaiprice15;
    }

    public String getWaimaiprice16() {
        return waimaiprice16;
    }

    public String getWaimaiprice17() {
        return waimaiprice17;
    }

    public String getWaimaiprice18() {
        return waimaiprice18;
    }

    public String getWaimaiprice19() {
        return waimaiprice19;
    }

    public String getWaimaiprice20() {
        return waimaiprice20;
    }

    public String getWaimaiprice21() {
        return waimaiprice21;
    }

    public String getWaimaiprice22() {
        return waimaiprice22;
    }

    public String getWaimaiprice23() {
        return waimaiprice23;
    }

    public String getWaimaiprice24() {
        return waimaiprice24;
    }

    public String getWaimaiprice25() {
        return waimaiprice25;
    }

    public String getWaimaiprice26() {
        return waimaiprice26;
    }

    public String getWaimaiprice27() {
        return waimaiprice27;
    }

    public String getWaimaiprice28() {
        return waimaiprice28;
    }

    public String getWaimaiprice29() {
        return waimaiprice29;
    }

    public String getWaimaiprice30() {
        return waimaiprice30;
    }

    private String waimaimenu24;
    private String waimaimenu25;
    private String waimaimenu26;
    private String waimaimenu27;
    private String waimaimenu28;
    private String waimaimenu29;
    private String waimaimenu30;
    private String waimaimenu31;
    private String waimaimenu32;
    private String waimaimenu33;
    private String waimaimenu34;
    private String waimaimenu35;
    private String waimaimenu36;
    private String waimaimenu37;
    private String waimaimenu38;
    private String waimaimenu39;
    private String waimaimenu40;
    private String waimaimenu41;
    private String waimaimenu42;
    private String waimaimenu43;
    private String waimaimenu44;
    private String waimaimenu45;
    private String waimaimenu46;
    private String waimaimenu47;
    private String waimaimenu48;
    private String waimaimenu49;
    private String waimaimenu50;
    private String waimaiprice1;
    private String waimaiprice2;
    private String waimaiprice3;
    private String waimaiprice4;
    private String waimaiprice5;
    private String waimaiprice6;
    private String waimaiprice7;
    private String waimaiprice8;
    private String waimaiprice9;
    private String waimaiprice10;
    private String waimaiprice11;
    private String waimaiprice12;
    private String waimaiprice13;
    private String waimaiprice14;
    private String waimaiprice15;
    private String waimaiprice16;
    private String waimaiprice17;
    private String waimaiprice18;
    private String waimaiprice19;
    private String waimaiprice20;
    private String waimaiprice21;
    private String waimaiprice22;
    private String waimaiprice23;
    private String waimaiprice24;
    private String waimaiprice25;
    private String waimaiprice26;
    private String waimaiprice27;
    private String waimaiprice28;
    private String waimaiprice29;
    private String waimaiprice30;
    private String waimaiprice31;
    private String waimaiprice32;
    private String waimaiprice33;
    private String waimaiprice34;
    private String waimaiprice35;
    private String waimaiprice36;
    private String waimaiprice37;
    private String waimaiprice38;
    private String waimaiprice39;
    private String waimaiprice40;
    private String waimaiprice41;
    private String waimaiprice42;
    private String waimaiprice43;
    private String waimaiprice44;
    private String waimaiprice45;
    private String waimaiprice46;
    private String waimaiprice47;
    private String waimaiprice48;
    private String waimaiprice49;
    private String waimaiprice50;

    public String getWaimaimenu1() {
        return waimaimenu1;
    }

    public String getWaimaimenu2() {
        return waimaimenu2;
    }

    public String getWaimaimenu3() {
        return waimaimenu3;
    }

    public String getWaimaimenu4() {
        return waimaimenu4;
    }

    public String getWaimaimenu5() {
        return waimaimenu5;
    }

    public String getWaimaimenu6() {
        return waimaimenu6;
    }

    public String getWaimaimenu7() {
        return waimaimenu7;
    }

    public String getWaimaimenu8() {
        return waimaimenu8;
    }

    public String getWaimaimenu10() {
        return waimaimenu10;
    }

    public String getWaimaimenu9() {
        return waimaimenu9;
    }

    public String getWaimaiprice1() {
        return waimaiprice1;
    }

    public String getWaimaiprice5() {
        return waimaiprice5;
    }

    public String getWaimaiprice2() {
        return waimaiprice2;
    }

    public String getWaimaiprice3() {
        return waimaiprice3;
    }

    public String getWaimaiprice4() {
        return waimaiprice4;
    }

    public String getWaimaiprice6() {
        return waimaiprice6;
    }

    public String getWaimaiprice7() {
        return waimaiprice7;
    }

    public String getWaimaiprice8() {
        return waimaiprice8;
    }

    public String getWaimaiprice9() {
        return waimaiprice9;
    }

    public String getWaimaiprice10() {
        return waimaiprice10;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone(String phone) {
        this.phone1 = phone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setWaimaimenu31(String waimaimenu31) {
        this.waimaimenu31 = waimaimenu31;
    }

    public void setWaimaimenu32(String waimaimenu32) {
        this.waimaimenu32 = waimaimenu32;
    }

    public void setWaimaimenu33(String waimaimenu33) {
        this.waimaimenu33 = waimaimenu33;
    }

    public void setWaimaimenu34(String waimaimenu34) {
        this.waimaimenu34 = waimaimenu34;
    }

    public void setWaimaimenu35(String waimaimenu35) {
        this.waimaimenu35 = waimaimenu35;
    }

    public void setWaimaimenu36(String waimaimenu36) {
        this.waimaimenu36 = waimaimenu36;
    }

    public void setWaimaimenu37(String waimaimenu37) {
        this.waimaimenu37 = waimaimenu37;
    }

    public void setWaimaimenu38(String waimaimenu38) {
        this.waimaimenu38 = waimaimenu38;
    }

    public void setWaimaimenu39(String waimaimenu39) {
        this.waimaimenu39 = waimaimenu39;
    }

    public void setWaimaimenu40(String waimaimenu40) {
        this.waimaimenu40 = waimaimenu40;
    }

    public void setWaimaimenu41(String waimaimenu41) {
        this.waimaimenu41 = waimaimenu41;
    }

    public void setWaimaimenu42(String waimaimenu42) {
        this.waimaimenu42 = waimaimenu42;
    }

    public void setWaimaimenu43(String waimaimenu43) {
        this.waimaimenu43 = waimaimenu43;
    }

    public void setWaimaimenu44(String waimaimenu44) {
        this.waimaimenu44 = waimaimenu44;
    }

    public void setWaimaimenu45(String waimaimenu45) {
        this.waimaimenu45 = waimaimenu45;
    }

    public void setWaimaimenu46(String waimaimenu46) {
        this.waimaimenu46 = waimaimenu46;
    }

    public void setWaimaimenu47(String waimaimenu47) {
        this.waimaimenu47 = waimaimenu47;
    }

    public void setWaimaimenu48(String waimaimenu48) {
        this.waimaimenu48 = waimaimenu48;
    }

    public void setWaimaimenu49(String waimaimenu49) {
        this.waimaimenu49 = waimaimenu49;
    }

    public void setWaimaimenu50(String waimaimenu50) {
        this.waimaimenu50 = waimaimenu50;
    }

    public void setWaimaiprice31(String waimaiprice31) {
        this.waimaiprice31 = waimaiprice31;
    }

    public void setWaimaiprice32(String waimaiprice32) {
        this.waimaiprice32 = waimaiprice32;
    }

    public void setWaimaiprice33(String waimaiprice33) {
        this.waimaiprice33 = waimaiprice33;
    }

    public void setWaimaiprice34(String waimaiprice34) {
        this.waimaiprice34 = waimaiprice34;
    }

    public void setWaimaiprice35(String waimaiprice35) {
        this.waimaiprice35 = waimaiprice35;
    }

    public void setWaimaiprice36(String waimaiprice36) {
        this.waimaiprice36 = waimaiprice36;
    }

    public void setWaimaiprice37(String waimaiprice37) {
        this.waimaiprice37 = waimaiprice37;
    }

    public void setWaimaiprice38(String waimaiprice38) {
        this.waimaiprice38 = waimaiprice38;
    }

    public void setWaimaiprice39(String waimaiprice39) {
        this.waimaiprice39 = waimaiprice39;
    }

    public void setWaimaiprice40(String waimaiprice40) {
        this.waimaiprice40 = waimaiprice40;
    }

    public void setWaimaiprice41(String waimaiprice41) {
        this.waimaiprice41 = waimaiprice41;
    }

    public void setWaimaiprice42(String waimaiprice42) {
        this.waimaiprice42 = waimaiprice42;
    }

    public void setWaimaiprice43(String waimaiprice43) {
        this.waimaiprice43 = waimaiprice43;
    }

    public void setWaimaiprice44(String waimaiprice44) {
        this.waimaiprice44 = waimaiprice44;
    }

    public void setWaimaiprice45(String waimaiprice45) {
        this.waimaiprice45 = waimaiprice45;
    }

    public void setWaimaiprice46(String waimaiprice46) {
        this.waimaiprice46 = waimaiprice46;
    }

    public void setWaimaiprice47(String waimaiprice47) {
        this.waimaiprice47 = waimaiprice47;
    }

    public void setWaimaiprice48(String waimaiprice48) {
        this.waimaiprice48 = waimaiprice48;
    }

    public void setWaimaiprice49(String waimaiprice49) {
        this.waimaiprice49 = waimaiprice49;
    }

    public void setWaimaiprice50(String waimaiprice50) {
        this.waimaiprice50 = waimaiprice50;
    }

    public String getWaimaimenu38() {
        return waimaimenu38;
    }

    public String getWaimaimenu32() {
        return waimaimenu32;
    }

    public String getWaimaimenu33() {
        return waimaimenu33;
    }

    public String getWaimaimenu34() {
        return waimaimenu34;
    }

    public String getWaimaimenu35() {
        return waimaimenu35;
    }

    public String getWaimaimenu36() {
        return waimaimenu36;
    }

    public String getWaimaimenu37() {
        return waimaimenu37;
    }

    public String getWaimaimenu39() {
        return waimaimenu39;
    }

    public String getWaimaimenu40() {
        return waimaimenu40;
    }

    public String getWaimaimenu41() {
        return waimaimenu41;
    }

    public String getWaimaimenu42() {
        return waimaimenu42;
    }

    public String getWaimaimenu43() {
        return waimaimenu43;
    }

    public String getWaimaimenu44() {
        return waimaimenu44;
    }

    public String getWaimaimenu45() {
        return waimaimenu45;
    }

    public String getWaimaimenu46() {
        return waimaimenu46;
    }

    public String getWaimaimenu47() {
        return waimaimenu47;
    }

    public String getWaimaimenu48() {
        return waimaimenu48;
    }

    public String getWaimaimenu49() {
        return waimaimenu49;
    }

    public String getWaimaimenu50() {
        return waimaimenu50;
    }

    public String getWaimaiprice31() {
        return waimaiprice31;
    }

    public String getWaimaiprice32() {
        return waimaiprice32;
    }

    public String getWaimaiprice33() {
        return waimaiprice33;
    }

    public String getWaimaiprice34() {
        return waimaiprice34;
    }

    public String getWaimaiprice35() {
        return waimaiprice35;
    }

    public String getWaimaiprice36() {
        return waimaiprice36;
    }

    public String getWaimaiprice37() {
        return waimaiprice37;
    }

    public String getWaimaiprice38() {
        return waimaiprice38;
    }

    public String getWaimaiprice39() {
        return waimaiprice39;
    }

    public String getWaimaiprice40() {
        return waimaiprice40;
    }

    public String getWaimaiprice41() {
        return waimaiprice41;
    }

    public String getWaimaiprice42() {
        return waimaiprice42;
    }

    public String getWaimaiprice43() {
        return waimaiprice43;
    }

    public String getWaimaiprice44() {
        return waimaiprice44;
    }

    public String getWaimaiprice45() {
        return waimaiprice45;
    }

    public String getWaimaiprice46() {
        return waimaiprice46;
    }

    public String getWaimaiprice47() {
        return waimaiprice47;
    }

    public String getWaimaiprice48() {
        return waimaiprice48;
    }

    public String getWaimaiprice49() {
        return waimaiprice49;
    }

    public String getWaimaiprice50() {
        return waimaiprice50;
    }

    public String getWaimaimenu31() {
        return waimaimenu31;
    }
}
