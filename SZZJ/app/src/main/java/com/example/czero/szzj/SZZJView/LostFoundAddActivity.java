package com.example.czero.szzj.SZZJView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.Found;
import com.example.czero.szzj.SZZJModel.Lost;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by zake on 5/23/16.
 */
public class LostFoundAddActivity extends BaseActivity implements View.OnClickListener{
    EditText edit_title, edit_photo, edit_describe;
    Button btn_true;
    Toast mToast;
    TextView tv_add;
    String from = "";
    SupperTitle supperTitle;
    String old_title = "";
    String old_describe = "";
    String old_phone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lostfoundadd);
        initViews();
        initListeners();
        initData();
    }

//    @Override
//    public void setContentView() {
//        setContentView(R.layout.activity_lostfoundadd);
//    }

//    @Override
    public void initViews() {


        supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
        supperTitle.setTitle("丢失物件");
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
        supperTitle.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_true = (Button) findViewById(R.id.btn_true);
        edit_photo = (EditText) findViewById(R.id.edit_photo);
        edit_describe = (EditText) findViewById(R.id.edit_describe);
        edit_title = (EditText) findViewById(R.id.edit_title);
    }


    public void initListeners() {
        btn_true.setOnClickListener(this);
    }


    public void initData() {
        from = getIntent().getStringExtra("from");
        old_title = getIntent().getStringExtra("title");
        old_phone = getIntent().getStringExtra("phone");
        old_describe = getIntent().getStringExtra("describe");

        edit_title.setText(old_title);
        edit_describe.setText(old_describe);
        edit_photo.setText(old_phone);

        if (from.equals("丢失物件")) {
//            tv_add.setText("丢失物件");
            supperTitle.setTitle("丢失物件");

        } else {
//            tv_add.setText("发现物件");
            supperTitle.setTitle("发现物件");
        }
    }

    public void onClick(View v) {
        if (v == btn_true) {
            addByType();
        }

    }
    String title = "";
    String describe = "";
    String photo="";

    private void addByType(){
        title = edit_title.getText().toString();
        describe = edit_describe.getText().toString();
        photo = edit_photo.getText().toString();

        if(TextUtils.isEmpty(title)){
            ShowToast("请输入标题");
            return;
        }
        if(TextUtils.isEmpty(describe)){
            ShowToast("请输入描述的内容");
            return;
        }
        if(TextUtils.isEmpty(photo)){
            ShowToast("请输入您的联系方式");
            return;
        }
        if(from.equals("丢失物件")){
            addLost();
        }else{
            addFound();
        }
    }

    private void addLost(){
        Lost lost = new Lost();
        lost.setDescribe(describe);
        lost.setPhone(photo);
        lost.setTitle(title);
        lost.save(this, new SaveListener() {

            @Override
            public void onSuccess() {
                // TODO Auto-generated method stub
                ShowToast("发布成功");
                setResult(RESULT_OK);
                finish();
            }

            @Override
            public void onFailure(int code, String arg0) {
                // TODO Auto-generated method stub
                ShowToast("发布失败"+arg0);
            }
        });
    }

    private void addFound(){
        Found found = new Found();
        found.setDescribe(describe);
        found.setPhone(photo);
        found.setTitle(title);
        found.save(this, new SaveListener() {

            @Override
            public void onSuccess() {
                // TODO Auto-generated method stub
                ShowToast("发布成功");
                setResult(RESULT_OK);
                finish();
            }

            @Override
            public void onFailure(int code, String arg0) {
                // TODO Auto-generated method stub
                ShowToast("发布失败:"+arg0);
            }
        });
    }
    public void ShowToast(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }
    }
}
