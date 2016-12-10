package com.example.czero.szzj.Tab;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.bumptech.glide.Glide;
import com.example.czero.szzj.R;

import com.example.czero.szzj.SZZJModel.Union;
import com.example.czero.szzj.SZZJModel.User;
import com.example.czero.szzj.SZZJUtil.GlideCircleTransform;
import com.example.czero.szzj.SZZJView.ContactActivity;
import com.example.czero.szzj.SZZJView.FeedbackActivity;
import com.example.czero.szzj.SZZJView.LoginActivity;
import com.example.czero.szzj.SZZJView.MineInfoActivity;
import com.example.czero.szzj.View.SupperTitle;
import com.squareup.picasso.Picasso;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import cn.bmob.v3.BmobUser;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.czero.szzj.R.id.imageView;


public class MeActivity extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private Button menu_sendwuchat;
    private CheckBox checkBox;
    private IWXAPI api;
    private TextView username;
    private ImageView userbackground;
    private TextView bianjiziliao,contact,feedback;
    private RelativeLayout me_heard;
    private static final String APP_ID = "wx9d0c2adb4dad845a";
    private User curUser;
    private TextView tvmore;



    public static MeActivity newInstance(String param1) {
        MeActivity fragment = new MeActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    public MeActivity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.activity_tabme, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//沉浸色
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
        }
        curUser = BmobUser.getCurrentUser(getActivity(), User.class);

        me_heard = (RelativeLayout) myview.findViewById(R.id.me_heard);
//        Glide.with(getActivity()).load(curUser.getUserImage()).error(R.drawable.ic_app).transform(new GlideCircleTransform(getActivity())).into(userface);
        tvmore= (TextView) myview.findViewById(R.id.tvmore);

        bianjiziliao = (TextView) myview.findViewById(R.id.bianjiziliao);
        contact = (TextView) myview.findViewById(R.id.contact);
        feedback = (TextView) myview.findViewById(R.id.feedback);
        username = (TextView) myview.findViewById(R.id.username);
        tvmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getActivity(),tvmore);
                popupMenu.getMenuInflater().inflate(R.menu.pop_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.pop_share:
                                Intent intent3 = new Intent(Intent.ACTION_SEND);
                                intent3.setType("text/plain");
                                intent3.putExtra(Intent.EXTRA_SUBJECT, "分享");
                                intent3.putExtra(Intent.EXTRA_TEXT, "汕职之家" + "\n" + "赶快下载体验吧!!!" + "http://www.wandoujia.com/apps/com.example.czero.szzj");
                                startActivity(Intent.createChooser(intent3, "分享到"));
                                break;
                            case R.id.pop_logout:
                                BmobUser.logOut(getActivity());
                                Intent toLogin = new Intent(getActivity(), LoginActivity.class);
                                startActivity(toLogin);
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();

            }
        });


        userbackground = (ImageView) myview.findViewById(R.id.user_background);
        Glide.with(this).load("http://119.29.121.145/me.png").placeholder(R.drawable.ic_bg_me).into(userbackground);


        bianjiziliao.setOnClickListener(this);
        contact.setOnClickListener(this);
        feedback.setOnClickListener(this);

        if (curUser == null) {

            me_heard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            });
            username.setText("点击登陆");

        } else {

            me_heard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), MineInfoActivity.class);
                    startActivity(intent);
                }
            });
            username.setText(curUser.getUsername());

        }
            api = WXAPIFactory.createWXAPI(getActivity(), APP_ID);
            api.registerApp(APP_ID);
            menu_sendwuchat = (Button) myview.findViewById(R.id.menu_sendwechat);
            checkBox = (CheckBox) myview.findViewById(R.id.checkbox);
        menu_sendwuchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editor = new EditText(getActivity());
                editor.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setTitle("汕职之家");
                builder.setIcon(R.drawable.ic_app);
                builder.setView(editor);
                builder.setMessage("请输入要分享的文本");
                builder.setPositiveButton("分享", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        获取要分享的文本
                        String text = editor.getText().toString();
                        if (text == null || text.length() == 0) {
                            return;
                        }
                        //第一步:创建一个用于封装文本的WXTextObject对象
                        WXTextObject textObj = new WXTextObject();
                        textObj.text = text;
                        //第三部创建WXMediaMessage对象,用于向微信传送数据
                        WXMediaMessage msg = new WXMediaMessage();
                        msg.mediaObject = textObj;
                        msg.description = text;
                        //第三步:创建一个用于请求微信客户端的SendMessageTowx对象
                        SendMessageToWX.Req req = new SendMessageToWX.Req();
                        req.message = msg;
                        //设置请求的唯一标识
                        req.transaction = buildTransaction("text");
                        //表示发送给朋友还是朋友圈
                        req.scene = checkBox.isChecked() ? SendMessageToWX.Req.WXSceneTimeline : SendMessageToWX.Req.WXSceneSession;
                        Toast.makeText(getActivity(), String.valueOf(api.sendReq(req)), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", null);
                final AlertDialog alert = builder.create();
                alert.show();


            }
        });

        return myview;
        }



    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bianjiziliao:
                Intent toMineInfo = new Intent(getActivity(), MineInfoActivity.class);
                startActivity(toMineInfo);
                break;
            case R.id.contact:
                Intent toContact = new Intent(getActivity(), ContactActivity.class);
                startActivity(toContact);
                break;
            case R.id.feedback:
                Intent toFeedback = new Intent(getActivity(), FeedbackActivity.class);
                startActivity(toFeedback);
                break;

        }
    }
}
