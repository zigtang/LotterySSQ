package com.zig.lottery.ssq.utils;

import java.util.HashMap;
import java.util.Set;

import android.util.Log;

public class ZLog {
	private static boolean isCloseLog = false;
	private static String TAG = "ZLog";

	public static void i(String tag, String msg) {
		if (isCloseLog) return;
		Log.i(tag, "" + msg);
	}

	public static void i(String msg) {
		if (isCloseLog) return;
		Log.i(TAG, "" + msg);
	}

	public static void d(String tag, String msg) {
		if (isCloseLog) return;
		Log.d(tag, "" + msg);

	}

	public static void d(String msg) {
		if (isCloseLog) return;
		Log.d(TAG, "" + msg);

	}

	public static void w(String tag, String msg) {
		if (isCloseLog) return;
		Log.w(tag, "" + msg);

	}

	public static void w(String msg) {
		if (isCloseLog) return;
		Log.w(TAG, "" + msg);

	}

	public static void e(String tag, String msg) {
		if (isCloseLog) return;
		Log.e(tag, "" + msg);

	}

	public static void e(String msg) {
		if (isCloseLog) return;
		Log.e(TAG, "" + msg);

	}

	public static void v(String tag, String msg) {
		if (isCloseLog) return;
		Log.v(tag, "" + msg);

	}

	public static void v(String msg) {
		if (isCloseLog) return;
		Log.d(TAG, "" + msg);

	}

	public static void printMap(HashMap<String, Object> map) {
		if (isCloseLog) return;
		i("--------------printMap-begin----------------");
		Set<String> keySet = map.keySet();
		for (String str : keySet) {
			i("key:" + str + " value:" + map.get(str));
		}
		i("--------------printMap-end----------------");
	}

	public static void printXml(String tag, String xml) {
		i("----------------------" + tag + " xml start---------------------------");
		d(xml);
		i("----------------------" + tag + " xml end---------------------------");
	}

	public static void printBigString(String str) {
		while (str.length() > 4000) {
			d(str.substring(0, 3000));
			str = str.substring(3000);
		}
		d(str);
	}

}
