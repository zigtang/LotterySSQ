package com.zig.lottery.ssq.utils;

import java.util.ArrayList;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;

import com.zig.lottery.ssq.R;
import com.zig.lottery.ssq.consts.Key;

public class SharedPreferencesHelper {
	private static SharedPreferencesHelper helper;
	private static SharedPreferences sp;
	private static SharedPreferences.Editor editor;

	private SharedPreferencesHelper(Context context) {
		sp = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
		editor = sp.edit();
	}

	public static synchronized SharedPreferencesHelper getInstance(Context context) {
		if (helper == null) {
			helper = new SharedPreferencesHelper(context);
		}
		return helper;
	}

	public String getNum() {
		return sp.getString(Key.NUM, "");
	}

	public void setNum(String Num) {
		editor.putString(Key.NUM, Num);
		editor.commit();
	}

	// ----------------------Red Num-------------------------
	public ArrayList<String> getRedNum() {
		Set<String> redSet = sp.getStringSet(Key.RED_NUM, null);
		if (redSet == null) return null;
		ArrayList<String> redList = new ArrayList<String>();
		for (String str : redSet) {
			redList.add(str);
		}
		return redList;
	}

	public void setRedNum(Set<String> redNumSet) {
		editor.putStringSet(Key.RED_NUM, redNumSet);
		editor.commit();
	}

	// ----------------------Blue Num-------------------------
	public ArrayList<String> getBlueNum() {
		Set<String> blueSet = sp.getStringSet(Key.BLUE_NUM, null);
		if (blueSet == null) return null;
		ArrayList<String> blueList = new ArrayList<String>();
		for (String str : blueSet) {
			blueList.add(str);
		}
		return blueList;

	}

	public void setBlueNum(Set<String> blueNumSet) {
		editor.putStringSet(Key.BLUE_NUM, blueNumSet);
		editor.commit();
	}

	public void clear() {
		editor.clear().commit();
	}

}
