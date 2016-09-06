package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.czero.szzj.R;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by zake on 5/22/16.
 */
public class FeedbackActivity extends BaseActivity {
    private EditText etfeedbackcontent;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        SupperTitle supperTitle;
        supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
        supperTitle.setTitle("用户反馈");
        supperTitle.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
        etfeedbackcontent = (EditText) findViewById(R.id.feedback_content);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = etfeedbackcontent.getText().toString();
                if (content.equals("")) {
                    toast("写点建议吧!!!,我们将进行改善");
                } else {
                    BmobUser user = BmobUser.getCurrentUser(FeedbackActivity.this);
                    Feedback fb  = new Feedback();
                    fb.setUsername(user.getUsername());
                    fb.setEmail(user.getEmail());
                    fb.setContent(content);
                    fb.save(FeedbackActivity.this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            toast("提交成功,工作人员会尽快回复");
                            finish();
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            toast("提交失败");
                        }
                    });

                }
            }
        });
    }

    private void toast(String toast) {
        Toast.makeText(FeedbackActivity.this, toast, Toast.LENGTH_SHORT).show();
    }

    class Feedback extends BmobObject {

        private String username;
        private String phone;
        private String email;
        private String content;

        public String getUsername() {
            return username;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }

        public String getContent() {
            return content;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    }
