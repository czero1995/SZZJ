package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJData.LoveItemListAdapter;
import com.example.czero.szzj.SZZJModel.Love;
import com.example.czero.szzj.SZZJUtil.Util;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;
import com.sdsmdg.tastytoast.TastyToast;
import com.skyfishjy.library.RippleBackground;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;


/**
 * Created by zake on 5/28/16.
 */
public class LoveWallActivity extends BaseActivity {
    private String loveurl = "http://mp.weixin.qq.com/mp/homepage?__biz=MzAwMjE0ODc1OQ==&hid=4&sn=a082b8ccdb03e7c62ed2ca42a8548de7#wechat_redirect";
    private Button btn_love;
    private Button btn_tolove;
    private ListView lvlovewall;
    private LoveItemListAdapter loveItemListAdapter;
    private List<Love> love = new ArrayList<Love>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovewall);

         SupperTitle supperTitle;
        supperTitle = (SupperTitle) findViewById(R.id.suppertitle);
        supperTitle.setTitle("表白墙");
        supperTitle.setTitleBackground(getResources().getColor(R.color.white));
        supperTitle.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        rippleBackground.startRippleAnimation();
        lvlovewall = (ListView) findViewById(R.id.lv_lovewall);
        loveItemListAdapter = new LoveItemListAdapter(LoveWallActivity.this, (ArrayList<Love>) love);
        btn_love = (Button) findViewById(R.id.btn_love);
        btn_tolove = (Button) findViewById(R.id.btn_tolove);
        lvlovewall.setAdapter(loveItemListAdapter);
        btn_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_love= new Intent(LoveWallActivity.this,LoveWallURL.class);
                intent_love.putExtra("flag","1");
                Bundle bundle = new Bundle();
                bundle.putString("loveurl","https://jinshuju.net/f/Xpwy5B");
                bundle.putString("lovetitle","纵梦表白");
                intent_love.putExtras(bundle);
                startActivity(intent_love);
            }
        });
        btn_tolove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse(loveurl);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loveurl));
                startActivity(intent);
            }
        });
        getLoveData();
    }
    private void getLoveData() {
        BmobQuery<Love> query = new BmobQuery<Love>();
        query.order("-createdAt");
        query.setCachePolicy(BmobQuery.CachePolicy.NETWORK_ELSE_CACHE);
        query.findObjects(this, new FindListener<Love>() {

            @Override
            public void onSuccess(List<Love> object) {
                //toast("查询成功. 共计" + object.size());

                    love = object;
                    // 通知Adapter数据更新
                    loveItemListAdapter.refresh((ArrayList<Love>) love);
                    //tradeItemListAdapter.notifyDataSetChanged();

            }

            @Override
            public void onError(int arg0, String msg) {
                TastyToast.makeText(getBaseContext(), "亲！请检查网络连接", TastyToast.LENGTH_LONG, TastyToast.WARNING);
            }

        });
    }


    private void toast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }


}
