package com.example.testviewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MainActivity extends Activity{

	private ViewPager viewPager;
	private int[] images = { R.drawable.guide_image1, R.drawable.guide_image2,
			R.drawable.guide_image3 };
	private List<ImageView> mImages = new ArrayList<ImageView>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		viewPager.setPageTransformer(false, new UpRightPageTransformer());
		viewPager.setAdapter(new PagerAdapter() {

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				ImageView imageView = new ImageView(MainActivity.this);
				imageView.setImageResource(images[position]);
				imageView.setScaleType(ScaleType.CENTER_CROP);
				container.addView(imageView);
				mImages.add(imageView);
				return imageView;
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(mImages.get(position));
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return images.length;
			}
		});
	}

}
