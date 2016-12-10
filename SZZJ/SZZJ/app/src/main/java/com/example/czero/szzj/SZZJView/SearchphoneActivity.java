package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.czero.szzj.R;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;


/**
 * Created by zake on 5/27/16.
 */
public class SearchphoneActivity extends BaseActivity {
    private Button searchshortphone,searchlongphone,searchyue,searchliuliang;
    private EditText etsearchlongphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchphone);
        SupperTitle supperTitle;
        supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
        supperTitle.setTitle("号码查询");
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
       etsearchlongphone= (EditText) findViewById(R.id.etsearchlongphone);
        searchlongphone= (Button) findViewById(R.id.searchlongphone);
        searchshortphone= (Button) findViewById(R.id.searchshortphone);
        searchyue= (Button) findViewById(R.id.searchyue);
        searchliuliang= (Button) findViewById(R.id.searchliuliang);
;
        searchlongphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etsearchlongphone.equals("")) {

                    String shortphonenumber = etsearchlongphone.getText().toString();
                    SmsManager.getDefault().sendTextMessage("10657000",
                            null, shortphonenumber, null, null);
                    Toast.makeText(SearchphoneActivity.this,"正在查询,留意短信通知",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(SearchphoneActivity.this,"请输入正确的号码",Toast.LENGTH_SHORT).show();
                }
            }
        });
        searchshortphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    SmsManager.getDefault().sendTextMessage("10086",
                            null, "cxdh", null, null);
                Toast.makeText(SearchphoneActivity.this,"正在查询,留意短信通知",Toast.LENGTH_SHORT).show();

            }
        });
        searchyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("10086",
                        null, "ye", null, null);
                Toast.makeText(SearchphoneActivity.this,"正在查询,留意短信通知",Toast.LENGTH_SHORT).show();

            }
        });
        searchliuliang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("10086",
                        null, "cxll", null, null);
                Toast.makeText(SearchphoneActivity.this,"正在查询,留意短信通知",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
