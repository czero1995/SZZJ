package com.example.czero.szzj.SZZJPush;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;


import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJView.ActivityNews;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import cn.bmob.push.PushConstants;

public class PushReceiver extends BroadcastReceiver {
    String message = "";
    private Context mcontext;
//    private String url = "http://www.stpt.edu.cn:8080/web/gxb/zsxx/";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PushConstants.ACTION_MESSAGE)) {
            String msg = intent.getStringExtra(PushConstants.EXTRA_PUSH_MESSAGE_STRING);
//            Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
            JSONTokener jsonTokener = new JSONTokener(msg);
            try {
                JSONObject object = (JSONObject) jsonTokener.nextValue();
                message = object.getString("alert");
            } catch (JSONException e) {
                e.printStackTrace();
            }
//            Uri uri = Uri.parse(url);
////            Intent pm = new Intent(Intent.ACTION_VIEW, uri);
//            Intent intent1 = new Intent(mcontext,LoginActivity.class);
//            PendingIntent pendingIntent = PendingIntent.getActivity(mcontext, 0, intent1, 0);

            NotificationManager manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
//            PendingIntent pintent = PendingIntent.getActivity(context, 0, pm, 0);
            Notification.Builder builder = new Notification.Builder(context);
            builder.setSmallIcon(R.drawable.ic_app);//设置图标
            builder.setTicker("汕职之家");//手机状态栏提示
            builder.setWhen(System.currentTimeMillis());//设置时间
            builder.setContentTitle("汕职之家");//设置标题
            builder.setContentText(message);//设置通知内容
            Intent intent1 = new Intent(context,ActivityNews.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent1, 0);
            builder.setContentIntent(pendingIntent);

            builder.setDefaults(Notification.DEFAULT_ALL);
            Notification notification = builder.build();
            manager.notify(R.drawable.ic_app, notification);
        }
    }
}



























