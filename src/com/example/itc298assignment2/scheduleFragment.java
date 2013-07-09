package com.example.itc298assignment2;

import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;

import android.widget.ExpandableListView;
import android.widget.TextView;

public class scheduleFragment extends Fragment {
	private String[] groupname;
	private String[][] categoryItems;


	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	  
		View v = inflater.inflate(R.layout.rahman_tab, null);
	    ExpandableListView ExlistView = (ExpandableListView) v.findViewById(R.id.list);
	    groupname = getResources().getStringArray(R.array.days);

	    String[] time = getResources().getStringArray(R.array.time);
	    String[] name = getResources().getStringArray(R.array.names);
	    categoryItems = new String[][]{time,name};
	    ExlistView.setAdapter(new ScheduleListAdapter(groupname, categoryItems));
	    ExlistView.setGroupIndicator(null); // no group indicator
	    return v;
	}
	 
	 public class ScheduleListAdapter extends BaseExpandableListAdapter{
		 private final LayoutInflater inflater;
		    private String[] groups;
		    private String[][] children;

		    public ScheduleListAdapter(String[] groups, String[][] children) {
		        this.groups = groups;
		        this.children = children;
		        inflater = LayoutInflater.from(getActivity());
		    }
		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return children[groupPosition][childPosition];
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {

			return childPosition;
		}

		@Override
		public View getChildView(int groupPosition, final int childPosition,
				boolean isLastChild, View view, ViewGroup parent) {
			 ViewHolder holder;
			if (view == null) {
				
				view = inflater.inflate(R.layout.activity_child, null);
				
				holder = new ViewHolder();
				
				holder.timetext = (TextView) view.findViewById(R.id.childeventtime);
				holder.nametext = (TextView) view.findViewById(R.id.childeventname);
			} else {
	            holder = (ViewHolder) view.getTag();
	        }

	        holder.timetext.setText(getChild(groupPosition, childPosition).toString());
	        holder.nametext.setText(getChild(groupPosition, childPosition).toString());
	       
			return view;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return children[groupPosition].length;
		}

		@Override
		public Object getGroup(int groupPosition) {
			return groups[groupPosition];
		}

		@Override
		public int getGroupCount() {
			return groups.length;
		}

		@Override
		public long getGroupId(int groupPosition) {

			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded, View view,
				ViewGroup parent) {
			ViewHolder holder;
			
			if (view == null) {
				
				view = inflater.inflate(R.layout.activity_group, null);
				
				holder = new ViewHolder();
				
				holder.groupname = (TextView) view.findViewById(R.id.groupheader);
			} else {
	            holder = (ViewHolder) view.getTag();
	        }

	        holder.groupname.setText(getGroup(groupPosition).toString());

			

			return view;
		}

		@Override
		public boolean hasStableIds() {

			return true;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {

			return true;
		}
		private class ViewHolder {
	        TextView timetext;
	        TextView nametext;
	        TextView groupname;
	        Button add;
	        
	    }
}
}