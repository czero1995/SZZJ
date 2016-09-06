package com.example.czero.szzj.SZZJView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.ShanZhiQuan;
import com.example.czero.szzj.SZZJModel.User;
import com.example.czero.szzj.SZZJUtil.DeviceUtils;
import com.example.czero.szzj.Tab.MainActivity;
import com.example.czero.szzj.Tab.ShanZhiQuanActivity;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;
import com.sdsmdg.tastytoast.TastyToast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

/**
 * Created by czero on 8/6/16.
 */

public class DongTaiActivity extends BaseActivity {
    private Button btn_amusetalk, btn_addimg;
    private EditText etamusetalk;
    private ImageView showimg;
    private static int GALLERY_REQUEST_CODE = 2;
    private static int CROP_REQUEST_CODE = 3;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dongtai);
        SupperTitle supperTitle;
        supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
        supperTitle.setTitle("发布动态");
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
        supperTitle.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        etamusetalk = (EditText) findViewById(R.id.etamusetalk);
        showimg = (ImageView) findViewById(R.id.showimg);
        btn_amusetalk = (Button) findViewById(R.id.btn_amusetalk);
        user =  BmobUser.getCurrentUser(getBaseContext(), User.class);
        btn_amusetalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ShanZhiQuan shanZhiQuan = new ShanZhiQuan();
                String content = etamusetalk.getText().toString();
                String usernames = user.getUsername().toString();
                BmobFile userfaces = user.getUserimage();
                if (content.equals("")) {
                    TastyToast.makeText(getBaseContext(), "输入点什么吧", TastyToast.LENGTH_LONG, TastyToast.WARNING);

                }else if (content.length()<10){
                    TastyToast.makeText(getBaseContext(), "小于10个字符", TastyToast.LENGTH_LONG, TastyToast.WARNING);

                }
                else {
                    shanZhiQuan.setContent(content);
                    shanZhiQuan.setDevice(DeviceUtils.getManufacturer().toString() + " " + DeviceUtils.getModel());
                    shanZhiQuan.setUsername(usernames);
                    shanZhiQuan.setUserimage(userfaces);
                    shanZhiQuan.setLovenumber(0);
                    shanZhiQuan.save(DongTaiActivity.this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            etamusetalk.setText("");
                            ShanZhiQuanActivity shanZhiQuanActivity = new ShanZhiQuanActivity();
                            finish();
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Toast.makeText(DongTaiActivity.this, s, Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
    }

}

