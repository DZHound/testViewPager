package com.example.testviewpager;

import com.nineoldandroids.view.ViewHelper;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 以View的中心为轴旋转
 */
public class RotatePageTransformer implements ViewPager.PageTransformer {

	public void transformPage(View view, float position) {
		int pageWidth = view.getWidth();
		int pageHeight = view.getHeight();

		if (position < -1) { // [-Infinity,-1)
			// This page is way off-screen to the left.
			ViewHelper.setAlpha(view, 0);

		} else if (position <= 0) { // [0,-1]
			// Use the default slide transition when moving to the left page
			ViewHelper.setAlpha(view, 1 + position * 0.5f);
			ViewHelper.setPivotX(view, pageWidth / 2);
			ViewHelper.setPivotY(view, pageHeight / 2);
			ViewHelper.setTranslationX(view, -position * pageWidth);
			ViewHelper.setRotationX(view, 0);
			ViewHelper.setRotationY(view, position * 90);

		} else if (position <= 1) { // (1,0]
			// Fade the page out.
			ViewHelper.setAlpha(view, 1 - position * 0.5f);
			ViewHelper.setPivotX(view, pageWidth / 2);
			ViewHelper.setPivotY(view, pageHeight / 2);
			ViewHelper.setTranslationX(view, -position * pageWidth);
			ViewHelper.setRotationX(view, 0);
			ViewHelper.setRotationY(view, position * 90);

		} else { // (1,+Infinity]
			// This page is way off-screen to the right.
			ViewHelper.setAlpha(view, 0);
		}
	}

}