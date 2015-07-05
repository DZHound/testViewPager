package com.example.testviewpager;

import com.nineoldandroids.view.ViewHelper;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * ·½¿éÐý×ªÇÐ»»¶¯»­
 */
public class DiamondsPageTransformer implements ViewPager.PageTransformer {

	public void transformPage(View view, float position) {
		int pageWidth = view.getWidth();
		int pageHeight = view.getHeight();

		if (position < -1) { // [-Infinity,-1)
			// This page is way off-screen to the left.
			view.setAlpha(0);

		} else if (position <= 0) { // [0,-1]
			// Use the default slide transition when moving to the left page
			ViewHelper.setPivotX(view, pageWidth);
			ViewHelper.setPivotY(view, pageHeight/2);
			ViewHelper.setRotationY(view, position*90f);
		} else if (position <= 1) { // (1,0]
			// Fade the page out.
			ViewHelper.setPivotX(view, 0);
			ViewHelper.setPivotY(view, pageHeight/2);
			ViewHelper.setRotationY(view, position*90f);

		} else { // (1,+Infinity]
			// This page is way off-screen to the right.
			view.setAlpha(0);
		}
	}
}