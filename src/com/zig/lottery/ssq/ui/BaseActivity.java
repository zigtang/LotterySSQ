package com.zig.lottery.ssq.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;
import cn.domob.android.ads.DomobAdView;

import com.zig.lottery.ssq.R;
import com.zig.lottery.ssq.consts.Value;
import com.zig.lottery.ssq.utils.SharedPreferencesHelper;

public class BaseActivity extends Activity implements OnClickListener {
	protected SharedPreferencesHelper spHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		spHelper = SharedPreferencesHelper.getInstance(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	public void onTitleLeft(View v) {
		this.finish();
	}

	public void onTitleRight(View v) {

	}

	protected void showToast(String str) {
		Toast.makeText(this, str, Toast.LENGTH_LONG).show();
	}

	@Override
	public void finish() {
		super.finish();
		this.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}

	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}

	protected void initAds(String ppid) {
		RelativeLayout mAdContainer = (RelativeLayout) findViewById(R.id.layout_adv);
		DomobAdView adView = new DomobAdView(this, Value.PublisherID, ppid, DomobAdView.INLINE_SIZE_FLEXIBLE);
		mAdContainer.addView(adView);
	}

}
