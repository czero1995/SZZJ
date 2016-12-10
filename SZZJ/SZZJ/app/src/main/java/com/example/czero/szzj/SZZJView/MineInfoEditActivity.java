package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.User;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by zake on 5/21/16.
 */
public class MineInfoEditActivity extends BaseActivity {
    private EditText etUsername;
    private Button btnsave;
    private EditText etPhone;
    private User curUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_info_edit);
        curUser = BmobUser.getCurrentUser(getBaseContext(), User.class);
        SupperTitle supperTitle;
        supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
        supperTitle.setTitle("修改资料");
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
        supperTitle.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnsave= (Button) findViewById(R.id.btnsave);

        etUsername = (EditText) findViewById(R.id.et_mineinfo_username);
        etPhone = (EditText) findViewById(R.id.et_mineinfo_phone);
        if(curUser==null){
            toast("请先登陆");
        }else {
            etUsername.setText(curUser.getUsername());
            etPhone.setText(curUser.getPhone());
        }
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInfo();
            }
        });
    }

    private void saveUserInfo(){
        if(curUser ==null){
            toast("请先登陆");
            Intent toLogin = new Intent(MineInfoEditActivity.this,LoginActivity.class);
            startActivity(toLogin);
        }else{
            curUser.setUsername(etUsername.getText().toString());
            curUser.setPhone(etPhone.getText().toString());
            curUser.update(this, curUser.getObjectId(), new UpdateListener() {
                @Override
                public void onSuccess() {
                    Intent back = new Intent(MineInfoEditActivity.this,MineInfoActivity.class);
                    setResult(200,back);
                    finish();
                    toast("个人资料修改成功");
                }

                @Override
                public void onFailure(int i, String s) {
                    toast("修改失败,用户昵称已存在！");
                }
            });
        }
    }



    private void toast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
}
