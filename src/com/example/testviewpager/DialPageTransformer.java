package com.example.testviewpager;

import com.nineoldandroids.view.ViewHelper;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 转盘旋转切换效果
 */
public class DialPageTransformer implements ViewPager.PageTransformer {
	private static final float MIN_SCALE = 0.75f;

	public void transformPage(View view, float position) {
		int pageWidth = view.getWidth();
		int pageHeight = view.getHeight();

		if (position < -1) { // [-Infinity,-1)
			// This page is way off-screen to the left.
			view.setAlpha(0);

		} else if (position <= 0) { // [0,-1]
			// Use the default slide transition when moving to the left page
			ViewHelper.setPivotX(view, pageWidth / 2);
			ViewHelper.setPivotY(view, pageHeight);
			ViewHelper.setRotation(view, position*90f);
		} else if (position <= 1) { // (1,0]
			// Fade the page out.
			ViewHelper.setPivotX(view, pageWidth / 2);
			ViewHelper.setPivotY(view, pageHeight);
			ViewHelper.setRotation(view, position*90f);
		} else { // (1,+Infinity]
			// This page is way off-screen to the right.
			view.setAlpha(0);
		}
	}
}