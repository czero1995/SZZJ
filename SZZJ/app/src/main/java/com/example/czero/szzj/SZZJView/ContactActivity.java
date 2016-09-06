package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.czero.szzj.R;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;


/**
 * Created by zake on 5/22/16.
 */
public class ContactActivity extends BaseActivity {
    private TextView dianhualianxi,zaixiankefu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        SupperTitle supperTitle;
        supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
        supperTitle.setTitle("联系C橙");
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
        supperTitle.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        dianhualianxi= (TextView) findViewById(R.id.dianhualianxi);
        zaixiankefu= (TextView) findViewById(R.id.zaixiankefu);
        dianhualianxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "13417020636"));
                if (intent.resolveActivity(getBaseContext().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        zaixiankefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlqq = "mqqwpa://im/chat?chat_type=wpa&uin="+"374139613"+"&version=1";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlqq)));
            }
        });

    }
}
