package com.example.itc298assignment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {
	final int NUM_TAB = 4; // number of tabs
	// I could not figure out a way to access the string array in values so I
	// set up an array
	// for tab titles
	private String titles[] = new String[] { "Rahman", "Max", "Sage", "Mike" };

	public TabAdapter(FragmentManager fm) {
		super(fm);

	}

	@Override
	public Fragment getItem(int position) {
		// getItem is called to instantiate the fragment for the given section.

		if (position == 0) {
			//I cannot seem to make the schedulefragment work
			Fragment schule = new scheduleFragment();

			return schule;
		} else {

			Fragment fragment = new myTabFragment();
			Bundle args = new Bundle();
			args.putInt(myTabFragment.OBJECT, position);

			fragment.setArguments(args);

			return fragment;
		}
	}

	@Override
	public int getCount() {
		// returns the number of tabs
		return NUM_TAB;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		/**
		 * I could not figure out a way to access the string array that I set up
		 * I kept getting an error for getString method so I had to setup string
		 * title array and use that for the page title
		 */
		return titles[position]; // returns the title of the page
	}
}
