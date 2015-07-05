package com.example.testviewpager;

import com.nineoldandroids.view.ViewHelper;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 淡入淡出切换效果
 */
public class FadInOutPageTransformer implements ViewPager.PageTransformer {

	public void transformPage(View view, float position) {

		if (position < -1) { // [-Infinity,-1)
			// This page is way off-screen to the left.
			view.setAlpha(0);

		} else if (position <= 0) { // [0,-1]
			// Use the default slide transition when moving to the left page
			ViewHelper.setAlpha(view, 1 + position);

		} else if (position <= 1) { // (1,0]
			// Fade the page out.
			ViewHelper.setAlpha(view, 1 - position);

		} else { // (1,+Infinity]
			// This page is way off-screen to the right.
			view.setAlpha(0);
		}
	}
}