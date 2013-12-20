package com.zig.lottery.ssq.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import cn.domob.android.ads.DomobSplashAd;
import cn.domob.android.ads.DomobSplashAd.DomobSplashMode;
import cn.domob.android.ads.DomobSplashAdListener;

import com.zig.lottery.ssq.R;
import com.zig.lottery.ssq.consts.Value;

public class SplashActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		initAds();
	}

	private void initAds() {
		final DomobSplashAd splashAd = new DomobSplashAd(this, Value.PublisherID, Value.SplashPPID, DomobSplashMode.DomobSplashModeFullScreen);
		// setSplashTopMargin is available when you choose non-full-screen
		// splash mode.
		// splashAd.setSplashTopMargin(200);
		splashAd.setSplashAdListener(new DomobSplashAdListener() {
			@Override
			public void onSplashPresent() {
				Log.i("DomobSDKDemo", "onSplashStart");
			}

			@Override
			public void onSplashDismiss() {
				Log.i("DomobSDKDemo", "onSplashClosed");
				// 开屏回调被关闭时，立即进行界面跳转，从开屏界面到主界面。
				// When splash ad is closed, jump to the next(main) Activity
				// immediately.
				startActivity(new Intent(SplashActivity.this, MainActivity.class));
				// 如果应用没有单独的闪屏Activity，需要调用closeSplash方法去关闭开屏广告
				// If you do not carry a separate advertising activity, you need
				// to call closeRTSplash way to close the splash ad

				// splashAd.closeSplash();
			}

			@Override
			public void onSplashLoadFailed() {
				Log.i("DomobSDKDemo", "onSplashLoadFailed");
			}
		});

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				if (splashAd.isSplashAdReady()) {
					splashAd.splash(SplashActivity.this, SplashActivity.this.findViewById(R.id.layout_splash_ad));
				} else {
					showToast("Splash ad is NOT ready.");
					SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
				}
			}
		}, 1);
	}
}
