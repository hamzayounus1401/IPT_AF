package com.example.ipt_aa;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.ipt_aa.data.Marks;

import java.util.HashMap;
import java.util.List;

public class MarksExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableListTitle;
    private HashMap<String, List<Marks>> expandableListDetail;

    public MarksExpandableListAdapter(Context context, List<String> expandableListTitle,
                                      HashMap<String, List<Marks>> expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final Marks expandedListText = (Marks) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.marks_list_item, null);
        }
        TextView expandedListTextView1 = (TextView) convertView
                .findViewById(R.id.expandableListItem1);
        TextView expandedListTextView2 = (TextView) convertView
                .findViewById(R.id.expandableListItem2);
        TextView expandedListTextView3 = (TextView) convertView
                .findViewById(R.id.expandableListItem3);
        TextView expandedListTextView4 = (TextView) convertView
                .findViewById(R.id.expandableListItem4);
        TextView expandedListTextView5 = (TextView) convertView
                .findViewById(R.id.expandableListItem5);
        TextView expandedListTextView6 = (TextView) convertView
                .findViewById(R.id.expandableListItem6);
        TextView expandedListTextView7 = (TextView) convertView
                .findViewById(R.id.expandableListItem7);
        TextView expandedListTextView8 = (TextView) convertView
                .findViewById(R.id.expandableListItem8);

        expandedListTextView1.setText(expandedListText.getTestName());
        expandedListTextView2.setText(expandedListText.getWeitage());
        expandedListTextView3.setText(expandedListText.getObtained());
        expandedListTextView4.setText(expandedListText.getTotal());
        expandedListTextView5.setText(expandedListText.getAverage());
        expandedListTextView6.setText(expandedListText.getStandardDeviation());
        expandedListTextView7.setText(expandedListText.getMin());
        expandedListTextView8.setText(expandedListText.getMax());
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.marks_list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}