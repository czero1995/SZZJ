package com.example.czero.szzj.SZZJView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.User;
import com.example.czero.szzj.View.backactivity.BaseActivity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by czero on 8/14/16.
 */
public class XiuGaiMiMaActivity extends BaseActivity{
    private EditText dangqianmima,xinmima,quedingmima;
    private Button btnchange;
    private TextView forgetpasswd;
    private User curUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiugaimima);
        curUser= BmobUser.getCurrentUser(getBaseContext(), User.class);
        dangqianmima= (EditText) findViewById(R.id.dangqianmima);
        xinmima= (EditText) findViewById(R.id.xinmima);
        quedingmima= (EditText) findViewById(R.id.quedingmima);
        btnchange= (Button) findViewById(R.id.btn_change);
        forgetpasswd= (TextView) findViewById(R.id.forgetpasswd);
        forgetpasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(getBaseContext(),ForgetActivity.class);
                startActivity(i);
            }
        });
        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curUser ==null){
                    toast("请先登陆");
                }else if(dangqianmima.getText().toString().length()<6){
                    toast("当前密码出错");
                }
                else if(!xinmima.getText().toString().equals(quedingmima.getText().toString())){
                    toast("两次密码输入不一致");
                }else if(xinmima.getText().length()<6){
                    toast("密码必须大于六位数");

                }else {
                    BmobUser.updateCurrentUserPassword(getBaseContext(), dangqianmima.getText().toString(), xinmima.getText().toString(), new UpdateListener() {
                        @Override
                        public void onSuccess() {
                            curUser.setPasswd(xinmima.getText().toString());
                            toast("更新成功,重新登陆");
                            Intent i = new Intent(getBaseContext(), LoginActivity.class);
                            startActivity(i);
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            toast(s);
                        }
                    });
                }
            }
        });

    }
    private void toast(String toast){
        Toast.makeText(getBaseContext(),toast,Toast.LENGTH_SHORT).show();
    }
}
