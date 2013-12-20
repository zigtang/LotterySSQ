package com.zig.lottery.ssq.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zig.lottery.ssq.R;
import com.zig.lottery.ssq.consts.Value;
import com.zig.lottery.ssq.utils.AnaliseNumUtil;

public class InputNumberActivity extends BaseActivity {
	EditText etNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);
		initAds(Value.InlinePPID_Input);
		etNum = (EditText) findViewById(R.id.et_input);
		initText();
	}

	private void initText() {
		String str = getResources().getString(R.string.tv_input_description);
		SpannableString ss = new SpannableString(str);

		ss.setSpan(new AbsoluteSizeSpan(18, true), 68, 79, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ss.setSpan(new ForegroundColorSpan(Color.RED), 68, 79, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		ss.setSpan(new AbsoluteSizeSpan(18, true), 97, 115, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ss.setSpan(new ForegroundColorSpan(Color.RED), 97, 115, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		ss.setSpan(new AbsoluteSizeSpan(18, true), 117, 119, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ss.setSpan(new ForegroundColorSpan(Color.GREEN), 117, 119, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		ss.setSpan(new AbsoluteSizeSpan(18, true), 120, 138, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ss.setSpan(new ForegroundColorSpan(Color.RED), 120, 138, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		ss.setSpan(new AbsoluteSizeSpan(18, true), 140, 142, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ss.setSpan(new ForegroundColorSpan(Color.GREEN), 140, 142, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		ss.setSpan(new AbsoluteSizeSpan(18, true), 195, 226, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ss.setSpan(new ForegroundColorSpan(Color.MAGENTA), 195, 226, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		TextView tvIndroduce = (TextView) findViewById(R.id.tv_input);
		tvIndroduce.setText(ss);
	}

	@Override
	public void onTitleRight(View v) {
		String num = etNum.getText().toString();
		if (!TextUtils.isEmpty(num)) {
			spHelper.clear();
			spHelper.setNum(num);
			AnaliseNumUtil.analiseNum(this);
			setResult(RESULT_OK);
		}

		this.finish();
	}

}
