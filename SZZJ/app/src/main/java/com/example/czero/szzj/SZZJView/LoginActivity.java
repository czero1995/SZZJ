package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.ShanZhiQuan;
import com.example.czero.szzj.SZZJModel.User;
import com.example.czero.szzj.SZZJUtil.Util;
import com.example.czero.szzj.Tab.MainActivity;
import com.sdsmdg.tastytoast.TastyToast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.BmobUpdateListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.update.BmobUpdateAgent;
import cn.bmob.v3.update.UpdateResponse;


/**
 * Created by zake on 5/20/16.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private Button btnLogin;
    private TextView forgetpasswd, register;
    private EditText etPhone, etPassword;
    private String phone;
    private String password;
    private String device;
    private LinearLayout common_loading;
    private ImageView img_welcome;
    ProgressBar mProgressBar;
    private ShanZhiQuan shanZhiQuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏目
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_login);
        BmobUpdateAgent.setUpdateOnlyWifi(false);
        BmobUpdateAgent.update(this);
        BmobUpdateAgent.setUpdateListener(new BmobUpdateListener() {

            @Override
            public void onUpdateReturned(int updateStatus, UpdateResponse updateInfo) {
                // TODO Auto-generated method stub
                //根据updateStatus来判断更新是否成功

            }
        });
        btnLogin = (Button) findViewById(R.id.btn_login);
        forgetpasswd = (TextView) findViewById(R.id.forgetpasswd);
        register = (TextView) findViewById(R.id.register);
        common_loading = (LinearLayout) findViewById(R.id.common_loading);
        common_loading.setVisibility(View.GONE);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etPassword = (EditText) findViewById(R.id.et_password);
        img_welcome = (ImageView) findViewById(R.id.img_welcome);

        btnLogin.setOnClickListener(this);
        forgetpasswd.setOnClickListener(this);
        register.setOnClickListener(this);
        getUserInfo();
        String text = "还没账号？快速 注 册 ";
        SpannableString ss = new SpannableString(text);
//        ss.setSpan(new ForegroundColorSpan(Color.WHITE),7,9,SpannableString.SPAN_INCLUSIVE_EXCLUSIVE);
        ss.setSpan(new ClickableSpan() {

            public void onClick(View widget) {
                Intent toRegister = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(toRegister);
            }
        }, 7, 12, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        register.setMovementMethod(LinkMovementMethod.getInstance());
        register.setText(ss);

    }

    private void getUserInfo() {
        SharedPreferences sp = getSharedPreferences("UserInfo", 0);
        etPhone.setText(sp.getString("username", null));
        etPassword.setText(sp.getString("password", null));
    }

    private void saveUserInfo(String username, String password) {
        SharedPreferences sp = getSharedPreferences("UserInfo", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
    }

    @Override
    public void onClick(final View v) {
        Context context = v.getContext();
        Animation shake = AnimationUtils.loadAnimation(context,
                R.anim.shake);
        switch (v.getId()) {
            case R.id.btn_login:
                phone = etPhone.getText().toString();
                password = etPassword.getText().toString();
                if (!Util.isNetworkConnected(this)) {
                    toast("亲,木有网络");
                    v.startAnimation(shake);
                } else if (phone.equals("") || password.equals("")) {
                    toast("请输入手机号和密码");
                    v.startAnimation(shake);
                    break;
                } else {
                    common_loading.setVisibility(View.VISIBLE);
                    User bu2 = new User();
                    bu2.setPhone(phone);
                    bu2.setPassword(password);
                    bu2.setDevice(device);
                    BmobUser.loginByAccount(getBaseContext(), phone, password, new LogInListener<User>() {
                        @Override
                        public void done(User user, BmobException e) {
                            if (e == null) {

                                TastyToast.makeText(getBaseContext(), "登陆成功", TastyToast.LENGTH_LONG, TastyToast.INFO);
                                common_loading.setVisibility(View.GONE);
                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(i);
                                saveUserInfo(phone, password);

                            } else {
                                TastyToast.makeText(getBaseContext(), "账号或密码输入错误，请重试", TastyToast.LENGTH_LONG, TastyToast.WARNING);
                                common_loading.setVisibility(View.GONE);
                            }
                        }
                    });


                }
                    break;
            case R.id.forgetpasswd:
                Intent contact = new Intent(LoginActivity.this, ForgetActivity.class);
                startActivity(contact);
                break;
            case R.id.register:
                Intent toReg = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(toReg);
                finish();
                break;

        }
    }

    public void toast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
}

