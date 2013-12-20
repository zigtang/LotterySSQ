package com.zig.lottery.ssq.utils;

import java.util.HashSet;
import java.util.Set;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.zig.lottery.ssq.R;

public class AnaliseNumUtil {
	private static Set<Integer> splitNum(String qqNum) {
		HashSet<Integer> numSet = new HashSet<Integer>();
		char[] nums = qqNum.toCharArray();
		for (char c : nums) {
			numSet.add(Integer.parseInt("" + c));
		}
		return numSet;
	}

	public static void analiseNum(Context context) {
		SharedPreferencesHelper sphelper = SharedPreferencesHelper.getInstance(context);
		String num = sphelper.getNum();
		if (TextUtils.isEmpty(num)) { return; }
		Set<Integer> numSet = splitNum(num);
		Set<String> redNumSet = getRedSet(numSet);
		Set<String> blueNumSet = getBlueSet(numSet);
		if (redNumSet.size() < 7 || blueNumSet.size() == 0) {
			Toast.makeText(context, R.string.toast_input_wrongRedNum, Toast.LENGTH_LONG).show();
			return;
		}
		sphelper.setRedNum(redNumSet);
		sphelper.setBlueNum(blueNumSet);
	}

	private static Set<String> getHeadSet(Set<Integer> numSet) {
		Set<String> headSet = new HashSet<String>();
		for (Integer i : numSet) {
			if (i < 4 && i > 0) {
				headSet.add("" + i);
			}
		}
		return headSet;
	}

	private static Set<String> getBlueSet(Set<Integer> numSet) {
		Set<String> blueSet = new HashSet<String>();
		for (Integer i : numSet) {
			if (i < 10 && i > 0) {
				blueSet.add("" + i);
			}

			if (i < 7 && i > 0) {
				blueSet.add("1" + i);
			}
		}

		return blueSet;
	}

	private static Set<String> getRedSet(Set<Integer> numSet) {
		Set<String> redSet = new HashSet<String>();

		// add single Num
		Set<String> headSet = getHeadSet(numSet);
		for (Integer singleNum : numSet) {
			if (singleNum == 0) continue;
			redSet.add("" + singleNum);
		}

		for (String head : headSet) {
			for (Integer tail : numSet) {
				if (head.equals("3") && tail > 3) continue;
				redSet.add(head + tail);
			}
		}

		return redSet;
	}
}
