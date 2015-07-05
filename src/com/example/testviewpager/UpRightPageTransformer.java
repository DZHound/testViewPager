package com.example.testviewpager;

import com.nineoldandroids.view.ViewHelper;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 第二个View从右上角进入，第一个View从左下角退出
 */
public class UpRightPageTransformer implements ViewPager.PageTransformer {

	private static final float MIN_SCALE = 0.5f;
	private static final float MIN_TRANSLATION = 100f;

	public void transformPage(View view, float position) {
		int pageWidth = view.getWidth();
		int pageHeight = view.getHeight();

		if (position < -1) { // [-Infinity,-1)
			view.setAlpha(0);
		} else if (position <= 0) { // [0,-1]
			ViewHelper.setAlpha(view, 1 + position);
			ViewHelper.setScaleX(view, 1 + position * MIN_SCALE);// 1 ~ min
			ViewHelper.setScaleY(view, 1 + position * MIN_SCALE);
			ViewHelper.setPivotX(view, pageWidth);
			ViewHelper.setPivotY(view, -pageHeight);
			ViewHelper.setTranslationX(view, pageWidth * position);
			ViewHelper.setTranslationY(view, pageHeight * position);
		} else if (position <= 1) { // (1,0]
			ViewHelper.setAlpha(view, 1 - position);
			ViewHelper.setScaleX(view, 1 - position * MIN_SCALE);// min ~ 1
			ViewHelper.setScaleY(view, 1 - position * MIN_SCALE);
			ViewHelper.setPivotX(view, 0);
			ViewHelper.setPivotY(view, 0);
			ViewHelper.setTranslationX(view, (pageWidth-MIN_TRANSLATION) * position);//width-min ~ 0
			ViewHelper.setTranslationY(view, (pageHeight-MIN_TRANSLATION) * position);//height-min ~ 0
		} else { // (1,+Infinity]
			view.setAlpha(0);
		}
	}
}