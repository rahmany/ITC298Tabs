package com.example.itc298assignment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class myTabFragment extends Fragment {

	public static final String OBJECT = "object";

	// @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,

	Bundle savedInstanceState) {
		// checks to see if  arguments have been supplied to the fragment during creation
		Bundle args = getArguments();
		//get the position number from the argument supplied to the fragment
		int position = args.getInt(OBJECT);

		int tabLayout = 0;
		//use position number, determine which layout to inflate
		switch (position) {

		case 0:

			tabLayout = R.layout.rahman_tab;

			break;

		case 1:

			tabLayout = R.layout.max_tab;

			break;

		case 2:

			tabLayout = R.layout.sage_tab;

			break;

		case 3:

			tabLayout = R.layout.mike_tab;

			break;

		}
		//inflate the layout that was passed down from the switch 
		View rootView = inflater.inflate(tabLayout, container, false);

		return rootView;

	}
 

}
