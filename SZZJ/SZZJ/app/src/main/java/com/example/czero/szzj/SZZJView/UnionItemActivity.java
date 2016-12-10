package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.Course;
import com.example.czero.szzj.SZZJModel.Shop;
import com.example.czero.szzj.SZZJModel.Union;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;

public class UnionItemActivity extends BaseActivity {


    private Union union;
    private String unionID;
    private TextView uniontime,unionslogan,unionactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unionitem);
        union = (Union) getIntent().getSerializableExtra("union");
        unionID = getIntent().getStringExtra("unionID");
        SupperTitle supperTitle;
        supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
        supperTitle.setTitle(union.getName());
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
        supperTitle.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        uniontime= (TextView) findViewById(R.id.uniontime);
        unionslogan= (TextView) findViewById(R.id.unionslogan);
        unionactivity= (TextView) findViewById(R.id.unionactivity);
        uniontime.setText(union.getTime());
        unionslogan.setText(union.getSlogan());
        unionactivity.setText(union.getActivity());

    }

    private void toast(String toast){
        Toast.makeText(UnionItemActivity.this,toast,Toast.LENGTH_SHORT).show();
    }
}
