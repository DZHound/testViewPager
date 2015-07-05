package com.example.testviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * 类似于翻页效果
 */
public class FlipOverPageTransformer implements ViewPager.PageTransformer {

	public void transformPage(View view, float position) {
		int pageWidth = view.getWidth();
		int pagerHeight = view.getHeight();

		if (position < -1) { // [-Infinity,-1)
			// This page is way off-screen to the left.
			view.setAlpha(0);
			view.setRotation(0);

		} else if (position <= 0) { // [-1,0]
			// Use the default slide transition when moving to the left page
			ViewHelper.setAlpha(view, 1 + position);
			ViewHelper.setPivotX(view, 0);
			ViewHelper.setPivotY(view, pagerHeight / 2);
			ViewHelper.setRotationX(view, 0);
			ViewHelper.setRotationY(view, position * 90f);
		} else if (position <= 1) { // (0,1]
			// Fade the page out.
			ViewHelper.setAlpha(view, 1 - position);
			ViewHelper.setPivotX(view, 0);
			ViewHelper.setPivotY(view, pagerHeight / 2);
			ViewHelper.setTranslationX(view, pageWidth * -position);
			ViewHelper.setRotationX(view, 0);
			ViewHelper.setRotationY(view, position * 90f);
		} else { // (1,+Infinity]
			// This page is way off-screen to the right.
			view.setAlpha(0);
			view.setRotation(0);
		}
	}
}