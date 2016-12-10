package com.example.czero.szzj.SZZJView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.czero.szzj.R;
import com.example.czero.szzj.SZZJModel.ShanZhiQuan;
import com.example.czero.szzj.SZZJModel.User;

import com.example.czero.szzj.SZZJUtil.TextUtil;
import com.example.czero.szzj.View.SupperTitle;
import com.example.czero.szzj.View.backactivity.BaseActivity;


import cn.bmob.v3.BmobUser;


/**
 * 个人资料卡
 * @date 2014-5-21 
 * @author Stone
 */
public class MineInfoActivity extends BaseActivity {
	private final int REQUEST_CODE_GALLERY = 1001;
	private TextView tvUsername;
	private TextView tvPhone;
	//	private TextView tvUserimg;
	public static final int MINE_INFO_FINISH_FIND_USER = 100;
	private User curUser;
	private ShanZhiQuan shanZhiQuan;
	//	private TextView changeuserimg;
//	private List<PhotoInfo> mPhotoList;
	//	private ImageView userimg;
	private TextView bianjiziliao;
	private TextView xiugaimima;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mine_info);
		getCurUser();

		bianjiziliao = (TextView) findViewById(R.id.bianjiziliao);
		bianjiziliao.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent toEditMineInfo = new Intent(MineInfoActivity.this, MineInfoEditActivity.class);
				startActivity(toEditMineInfo);
			}
		});
		xiugaimima = (TextView) findViewById(R.id.xiugaimima);
		xiugaimima.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(getBaseContext(), XiuGaiMiMaActivity.class);
				startActivity(i);
			}
		});
		tvUsername = (TextView) findViewById(R.id.tv_mineinfo_username);

		tvPhone = (TextView) findViewById(R.id.tv_mineinfo_phone);
//		userimg= (ImageView) findViewById(R.id.userimg);
//		changeuserimg= (TextView) findViewById(R.id.changeuseimg);
//		changeuserimg.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, mOnHanlderResultCallback);
//			}
//		});
	}

	private void initView() {


		tvUsername.setText(curUser.getUsername());

		tvPhone.setText(curUser.getMobilePhoneNumber());
//		initConfig();
//		mPhotoList = new ArrayList<>();
//		Glide.with(getBaseContext()).load(curUser.getUserimage()).error(R.drawable.ic_app).transform(new GlideCircleTransform(this)).into(userimg);

	}

	private void getCurUser() {
		curUser = BmobUser.getCurrentUser(this, User.class);

		if (curUser != null) {
			Message msg = new Message();
			msg.what = MINE_INFO_FINISH_FIND_USER;
			mHandler.sendMessage(msg);
		}
	}

	private void refresh() {
		getCurUser();
		initView();
	}

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case MINE_INFO_FINISH_FIND_USER:
					initView();
					break;
				default:
					break;
			}
		}
	};


	private void postPic(String path) {
		if (!TextUtil.isValidate(path)) {
			Toast.makeText(getBaseContext(), "手机内存不足", Toast.LENGTH_SHORT).show();
			return;
		}
	}

//	private void initConfig() {
//
//		ThemeConfig theme = new ThemeConfig.Builder()
//				.setTitleBarBgColor(Color.rgb(16, 125, 207))
//				.setTitleBarTextColor(Color.WHITE)
//				.setTitleBarIconColor(Color.WHITE)
//				.setFabNornalColor(Color.rgb(16, 125, 207))
//				.setFabPressedColor(Color.BLUE)
//				.setCheckNornalColor(Color.WHITE)
//				.setCheckSelectedColor(Color.rgb(16, 125, 207))
//				.build();
//		//配置功能
//		FunctionConfig functionConfig = new FunctionConfig.Builder()
//				.setEnableCamera(false)
//				.setEnableEdit(true)
//				.setEnableCrop(true)
//				.setEnableRotate(true)
//				.setCropSquare(true)
//				.setEnablePreview(false)
//				.setCropReplaceSource(true)//配置裁剪图片时是否替换原始图片，默认不替换
//				.setForceCrop(true)//启动强制裁剪功能,一进入编辑页面就开启图片裁剪，不需要用户手动点击裁剪，此功能只针对单选操作
//				.build();
//		CoreConfig coreConfig = new CoreConfig.Builder(this, new GlideImageLoader(), theme)
//				.setFunctionConfig(functionConfig)
//				.setPauseOnScrollListener(new GlidePauseOnScrollListener(false, true))
//				.build();
//		GalleryFinal.init(coreConfig);
//	}
//
//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		if (requestCode == 200) {
//			refresh();
//		}
	}
//	private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {
//		@Override
//		public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
//			if (resultList != null) {
//				mPhotoList.clear();
//				mPhotoList.addAll(resultList);
//				final String smallImg = PhotoUtil.getBitmapThumbnailPath(mPhotoList.get(0).getPhotoPath());
////				Bitmap imageBitmap = BitmapFactory.decodeFile(smallImg);
//				BmobFile bmobFiles = new BmobFile(new File(smallImg));
//
//				curUser.setUserimage(bmobFiles);
//
//				curUser.update(getBaseContext(), new UpdateListener() {
//					@Override
//					public void onSuccess() {
//						Toast.makeText(getBaseContext(),"更新成功",Toast.LENGTH_LONG).show();
//					}
//
//					@Override
//					public void onFailure(int i, String s) {
//						Toast.makeText(getBaseContext(),s,Toast.LENGTH_LONG).show();
//					}
//				});
//				BmobFile bmobFile = new BmobFile(new File(smallImg));
//				curUser.setUserimage(bmobFile);
//				bmobFile.uploadblock(getBaseContext(), new UploadFileListener() {
//					@Override
//					public void onSuccess() {
//						Toast.makeText(getBaseContext(),"上传成功",Toast.LENGTH_LONG).show();
//					}
//
//					@Override
//					public void onFailure(int i, String s) {
//						Toast.makeText(getBaseContext(),s,Toast.LENGTH_LONG).show();
//					}
//				});
//
//
//				postPic(smallImg);
//				userimg.setImageURI(Uri.parse(smallImg));
//
//			}
//		}

//		@Override
//		public void onHanlderFailure(int requestCode, String errorMsg) {
//			Toast.makeText(getBaseContext(), errorMsg, Toast.LENGTH_SHORT).show();
//		}
//	};


