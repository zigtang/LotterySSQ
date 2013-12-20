package com.zig.lottery.ssq.ui;

import java.util.ArrayList;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zig.lottery.ssq.R;
import com.zig.lottery.ssq.consts.ReqCode;
import com.zig.lottery.ssq.consts.Value;

public class MainActivity extends BaseActivity {
	LinearLayout layoutConent;
	ScrollView sv;
	int numCount = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sv = (ScrollView) findViewById(R.id.sv_main);
		layoutConent = (LinearLayout) findViewById(R.id.layout_main_content);
		initAds(Value.InlinePPID_Main);
		if (TextUtils.isEmpty(spHelper.getNum())) {
			Intent intent = new Intent(this, InputNumberActivity.class);
			startActivityForResult(intent, ReqCode.INPUT_NUM);
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (ReqCode.INPUT_NUM == requestCode && resultCode == RESULT_OK) {
			layoutConent.removeAllViews();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		String numStr = spHelper.getNum();
		boolean isExist = !TextUtils.isEmpty(numStr);
		String hint = isExist ? "数据源：" + spHelper.getNum() : "您还没有输入原始数据，请点右上角的设置进行输入";
		((TextView) findViewById(R.id.tv_main_num)).setText(hint);
		findViewById(R.id.tv_main_function).setVisibility(isExist ? View.GONE : View.VISIBLE);
	}

	private String genLetteryNum() {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> redNumList = spHelper.getRedNum();
		if (redNumList == null || redNumList.size() == 0) return null;
		Random random = new Random();
		int randomIndex = 0;
		for (int i = 0; i < 6; i++) {
			randomIndex = random.nextInt(redNumList.size() - 1);
			sb.append(redNumList.get(randomIndex));
			sb.append(Value.SPLITE_SYMBOL);
			redNumList.remove(randomIndex);
		}
		ArrayList<String> blueNumList = spHelper.getBlueNum();
		if (blueNumList == null || blueNumList.size() == 0) return null;
		randomIndex = random.nextInt(blueNumList.size() - 1);
		sb.append(blueNumList.get(randomIndex));

		// ZLog.d("letteryNum:" + sb.toString());
		return sb.toString();
	}

	private void addNumToLayout(String lotteryNum) {
		if (lotteryNum == null) {
			showToast("您还没有设置原始的号码");
		}
		String[] strs = lotteryNum.split(Value.SPLITE_SYMBOL);
		if (strs.length != 7) return;
		LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.layout_lottery, layoutConent, false);
		TextView tvNum;
		for (int i = 0; i < 7; i++) {
			int bgId = i == 6 ? R.drawable.bg_blue : R.drawable.bg_red;
			tvNum = (TextView) getLayoutInflater().inflate(R.layout.tv_ssq, layout, false);
			tvNum.setBackgroundResource(bgId);
			tvNum.setText(strs[i]);
			layout.addView(tvNum);
		}
		layoutConent.addView(layout);
	}

	@Override
	public void onTitleRight(View v) {
		Intent intent = new Intent(this, InputNumberActivity.class);
		startActivityForResult(intent, ReqCode.INPUT_NUM);
	}

	@Override
	public void onTitleLeft(View v) {
		startActivity(new Intent(this, IntroduceActivity.class));
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_main_genNum) {
			if (TextUtils.isEmpty(spHelper.getNum())) {
				showToast("您还没有输入原始数据，请点右上角的设置进行输入");
				return;
			}
			addNumToLayout(genLetteryNum());
			sv.scrollTo(0, sv.getHeight());
			numCount++;
			if (numCount > 20) showToast("老妹儿啊，你再这么点下去，程序崩溃了，可别怨我程序烂哦~");
		}

	}

}
