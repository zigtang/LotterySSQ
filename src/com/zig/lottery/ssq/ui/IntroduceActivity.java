package com.zig.lottery.ssq.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.widget.TextView;

import com.zig.lottery.ssq.R;
import com.zig.lottery.ssq.consts.Value;

public class IntroduceActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_introduce);
		initAds(Value.InlinePPID_Intro);
		intiText();
	}

	private void intiText() {

		String str = getResources().getString(R.string.tv_introduce_description);
		SpannableStringBuilder ssb = new SpannableStringBuilder(str);

		ssb.setSpan(new AbsoluteSizeSpan(18, true), 60, 72, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ForegroundColorSpan(Color.RED), 60, 72, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		ssb.setSpan(new AbsoluteSizeSpan(18, true), 79, 93, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ForegroundColorSpan(Color.RED), 79, 93, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		ssb.setSpan(new AbsoluteSizeSpan(18, true), 126, 186, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ForegroundColorSpan(Color.RED), 126, 186, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		ssb.setSpan(new AbsoluteSizeSpan(18, true), 192, 226, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ForegroundColorSpan(Color.BLUE), 192, 226, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		ssb.setSpan(new AbsoluteSizeSpan(18, true), 295, 309, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ForegroundColorSpan(Color.RED), 295, 309, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		TextView tvIndroduce = (TextView) findViewById(R.id.tv_introduce);
		tvIndroduce.setText(ssb);

		String strTks = getResources().getString(R.string.tv_introduce_tks);
		ssb = new SpannableStringBuilder(strTks);
		ssb.setSpan(new AbsoluteSizeSpan(18, true), 25, 30, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ForegroundColorSpan(Color.YELLOW), 25, 30, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new URLSpan("mailto:zigtang@gmail.com"), 25, 30, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		TextView tvTks = (TextView) findViewById(R.id.tv_introduce_tks);
		tvTks.setMovementMethod(LinkMovementMethod.getInstance());
		tvTks.setText(ssb);
	}
}
