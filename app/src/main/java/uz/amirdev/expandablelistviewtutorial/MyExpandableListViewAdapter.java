package uz.amirdev.expandablelistviewtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {

    Context context;
    HashMap<String, ArrayList<String>> expandableListData;
    ArrayList<String> expandableListTitles;

    public MyExpandableListViewAdapter(
            Context context, HashMap<String,
            ArrayList<String>> expandableListData,
            ArrayList<String> expandableListTitles
    ) {
        this.context = context;
        this.expandableListData = expandableListData;
        this.expandableListTitles = expandableListTitles;
    }

    @Override
    public int getGroupCount() {
        return expandableListTitles.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return expandableListData.get(expandableListTitles.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return expandableListTitles.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return expandableListData.get(expandableListTitles.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String groupTitle = (String) getGroup(i);
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_group, null, false);
        }
        TextView textView = view.findViewById(R.id.listTitle);
        textView.setText(groupTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String expandedListText = (String) getChild(i, i1);
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, null, false);
        }

        TextView textView = view.findViewById(R.id.listItemText);
        textView.setText(expandedListText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
