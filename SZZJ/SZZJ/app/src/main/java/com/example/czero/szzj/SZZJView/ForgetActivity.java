package com.example.czero.szzj.SZZJView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.User;
import com.example.czero.szzj.SZZJUtil.DeviceUtils;
import com.example.czero.szzj.SZZJUtil.Util;
import com.example.czero.szzj.View.backactivity.BaseActivity;

import java.util.List;

import cn.bmob.sms.BmobSMS;
import cn.bmob.sms.exception.BmobException;
import cn.bmob.sms.listener.RequestSMSCodeListener;
import cn.bmob.sms.listener.VerifySMSCodeListener;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;
import cn.bmob.v3.listener.ResetPasswordByCodeListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by czero on 8/10/16.
 */
public class ForgetActivity extends BaseActivity {
    private TextView kuaisudenglu;
    private EditText forphone, foryanzhengma, fornewpasswd, forinsurepasswd;
    private Button forbtnyanzheng, forbtninsure;
    private int mCount = 60;
    private boolean isClicked = false;
    private User curUser;
    private String newpasword = null;
    private String insurepasswork = null;
    private String yanzhengma = null;
    private String phone = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        forphone = (EditText) findViewById(R.id.for_phone);
        foryanzhengma = (EditText) findViewById(R.id.for_yanzhengma);
        fornewpasswd = (EditText) findViewById(R.id.for_newpasswd);
        forinsurepasswd = (EditText) findViewById(R.id.for_insure_passwd);
        forbtnyanzheng = (Button) findViewById(R.id.for_btn_yanzheng);
        forbtninsure = (Button) findViewById(R.id.for_btn_insure);
        kuaisudenglu = (TextView) findViewById(R.id.kuaisudenglu);
        curUser= BmobUser.getCurrentUser(getBaseContext(), User.class);
        newpasword = fornewpasswd.getText().toString();
        insurepasswork = forinsurepasswd.getText().toString();
        yanzhengma=foryanzhengma.getText().toString();
        phone = forphone.getText().toString();
        kuaisudenglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(I);
            }
        });
        forbtninsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newpasword = fornewpasswd.getText().toString();
                insurepasswork = forinsurepasswd.getText().toString();
                yanzhengma=foryanzhengma.getText().toString();
                phone = forphone.getText().toString();
                if (!Util.isNetworkConnected(getBaseContext())) {
                    toast("亲,木有网络");
                }if(yanzhengma.equals("")){
                    toast("验证码不能为空");
                }
                else if (phone.equals("") || phone.length() < 11) {
                    toast("请输入正确的11位手机号码"+phone);
                } else if (!newpasword.equals(insurepasswork)) {
                    toast("两次输入密码不一致");

                } else if (newpasword.length()<6 ||newpasword.length()>22) {
                    toast("请输入6-22位的密码");
                } else if(yanzhengma.equals("")){
                    toast("请输入验证码");
                }else {
                    BmobUser.resetPasswordBySMSCode(getBaseContext(), yanzhengma, newpasword, new ResetPasswordByCodeListener() {
                        @Override
                        public void done(cn.bmob.v3.exception.BmobException e) {
                            if (e == null) {
                                toast("更新成功,请重新登陆");
                                Intent i =new Intent(ForgetActivity.this,LoginActivity.class);
                                startActivity(i);
                            } else {
                                toast("验证失败" + e.toString());
                            }
                        }
                    });
                }
            }
        });

        forbtnyanzheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newpasword = fornewpasswd.getText().toString();
                insurepasswork = forinsurepasswd.getText().toString();

                phone = forphone.getText().toString();
                if (phone.equals("") || phone.length() < 11) {
                    toast("请输入正确的11位手机号码");}
                else if (newpasword.length()<6){
                    toast("密码个数小于6位"+newpasword);
                }else if(newpasword.equals("") ||insurepasswork.equals("")){
                    toast("请正确输入密码再验证");
                }else if(!newpasword.equals(insurepasswork)){
                    toast("两次密码输入不一致");
                }
                else {
                    BmobQuery<User> query = new BmobQuery<User>();
                    query.addWhereEqualTo("mobilePhoneNumber", phone);
                    query.findObjects(getBaseContext(), new FindListener<User>() {
                        @Override
                        public void onSuccess(List<User> list) {
                            forbtnyanzheng.setEnabled(false);
                            forbtnyanzheng.setBackgroundColor(getResources().getColor(R.color.characters));
                            new CountDownTimer(60000, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    --mCount;
                                    forbtnyanzheng.setText("还剩" + mCount + "秒");
                                }

                                @Override
                                public void onFinish() {
                                    isClicked = false;
                                    mCount = 60;
                                    forbtnyanzheng.setText("获取");
                                    forbtnyanzheng.setEnabled(true);
                                    forbtnyanzheng.setBackgroundColor(getResources().getColor(R.color.mainblue));
                                }
                            }.start();
                            BmobSMS.requestSMSCode(getBaseContext(), phone, "汕职之家", new RequestSMSCodeListener() {

                                @Override
                                public void done(Integer smsId, BmobException ex) {
                                    // TODO Auto-generated method stub
                                    if (ex == null) {//验证码发送成功
                                        toast("发送成功，留意短信通知");
                                    } else {
                                        toast("发送失败");
                                    }

                                }
                            });


                        }

                        @Override
                        public void onError(int i, String s) {
                            toast("该手机号未注册过");
                        }
                    });
                }
            }
        });

    }

                private void toast (String toast){
                    Toast.makeText(getBaseContext(), toast, Toast.LENGTH_SHORT).show();
                }
            }
