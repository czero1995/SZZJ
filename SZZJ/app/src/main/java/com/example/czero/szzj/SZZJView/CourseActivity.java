package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJData.CourseItemListAdapter;
import com.example.czero.szzj.SZZJData.LoveItemListAdapter;
import com.example.czero.szzj.SZZJModel.Course;
import com.example.czero.szzj.SZZJModel.Love;
import com.example.czero.szzj.SZZJModel.Shop;
import com.example.czero.szzj.SZZJModel.Union;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;

public class CourseActivity extends BaseActivity {


    private Course course;

    private EditText et_type;
    private Button btn_course;
    private ListView lvcourse;
    private CourseItemListAdapter courseItemListAdapter;
    private List<Course> courses = new ArrayList<Course>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        SupperTitle supperTitle;
        supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
        supperTitle.setTitle("汕职课表通");
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
        supperTitle.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        et_type= (EditText) findViewById(R.id.et_type);
        lvcourse = (ListView) findViewById(R.id.lv_course);
        courseItemListAdapter = new CourseItemListAdapter(CourseActivity.this, (ArrayList<Course>) courses);
        lvcourse.setAdapter(courseItemListAdapter);

        btn_course= (Button) findViewById(R.id.btn_course);
        btn_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCourseData();
            }
        });

    }

    private void getCourseData() {
        final String s = et_type.getText().toString();
        final BmobQuery<Course> query = new BmobQuery<Course>();
        query.order("-createdAt");
        query.addWhereEqualTo("type",s);
        query.setCachePolicy(BmobQuery.CachePolicy.NETWORK_ELSE_CACHE);
        query.findObjects(this, new FindListener<Course>() {
            @Override
            public void onSuccess(List<Course> list) {

                courses = list;
                    courseItemListAdapter.refresh((ArrayList<Course>) courses);

            }

            @Override
            public void onError(int i, String s) {
                toast(s);
            }
        });
        query.addWhereNotEqualTo("type",s);
        query.findObjects(this, new FindListener<Course>() {
            @Override
            public void onSuccess(List<Course> list) {

            }
            @Override
            public void onError(int i, String s) {
                TastyToast.makeText(getBaseContext(), "亲！请检查网络连接", TastyToast.LENGTH_LONG, TastyToast.WARNING);
            }
        });
    }

    private void toast(String toast){
        Toast.makeText(CourseActivity.this,toast,Toast.LENGTH_SHORT).show();
    }

}