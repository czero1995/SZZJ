package com.example.czero.szzj.SZZJView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.ActivityNew;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;

/**
 * Created by zake on 6/12/16.
 */
public class ActivityNewItemActivity extends BaseActivity {

    private ActivityNew activityNew;
    private String activitynewID;
    private TextView activitynewcontent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitynewitem);
        activityNew = (ActivityNew) getIntent().getSerializableExtra("activitynew");
        activitynewID = getIntent().getStringExtra("activitynewID");
        SupperTitle supperTitle;
        supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
        supperTitle.setTitle(activityNew.getName());
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
        supperTitle.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        activitynewcontent = (TextView) findViewById(R.id.activitynewcontent);
        activitynewcontent.setText(activityNew.getItemcontent());

    }
}
