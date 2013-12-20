package com.zig.lottery.ssq.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zig.lottery.ssq.R;

public class TitleView extends RelativeLayout {

	private final String titleStr;
	private final String textLeftBtn;
	private final String textRightBtn;

	private TextView tvTitle;
	private Button btnLeft;
	private Button btnRight;

	public TitleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.titleView);
		titleStr = typedArray.getString(R.styleable.titleView_text);
		textLeftBtn = typedArray.getString(R.styleable.titleView_text_leftBtn);
		textRightBtn = typedArray.getString(R.styleable.titleView_text_rightBtn);
		typedArray.recycle();
		initUI(context);
		setUI();
	}

	private void setUI() {
		tvTitle.setText(titleStr == null ? "Title" : titleStr);
		btnLeft.setVisibility(textLeftBtn == null ? GONE : VISIBLE);
		btnRight.setVisibility(textRightBtn == null ? GONE : VISIBLE);
		if (textLeftBtn != null) btnLeft.setText(textLeftBtn);
		if (textRightBtn != null) btnRight.setText(textRightBtn);
	}

	private void initUI(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.view_title, this);
		tvTitle = (TextView) view.findViewById(R.id.tv_title);
		btnLeft = (Button) view.findViewById(R.id.btn_title_left);
		btnRight = (Button) view.findViewById(R.id.btn_title_right);
	}

	public void setLeftText(String str) {
		btnLeft.setText(str);
	}

	public void setRifhtText(String str) {
		btnRight.setText(str);
	}

	public void setTitleText(String str) {
		tvTitle.setText(str);
	}

}
