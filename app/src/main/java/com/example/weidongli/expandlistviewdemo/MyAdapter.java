package com.example.weidongli.expandlistviewdemo;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import android.widget.TextView;

/**
 * Created by liangzheng123456 on 2018/8/28.
 */

public class MyAdapter extends BaseExpandableListAdapter {
    private Context context;
    private String[] groups;
    private  String[][] childs;


    public MyAdapter(Context context, String[] groups, String[][] childs) {
        this.context = context;
        this.groups = groups;
        this.childs = childs;
    }




    @Override
    public int getGroupCount() {
        return groups.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups[groupPosition].length();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childs[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder1 viewHolder1=null;
        if(convertView==null)
        {
            viewHolder1=new ViewHolder1();
            convertView=convertView.inflate(context,R.layout.group_item,null);
            viewHolder1.tv_group= (TextView) convertView.findViewById(R.id.tv_group);
            convertView.setTag(viewHolder1);
        }
        else
        {
            viewHolder1= (ViewHolder1) convertView.getTag();
        }
        viewHolder1.tv_group.setText(groups[groupPosition]);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder2 viewHolder2=null;
        if(convertView==null)
        {

            convertView=convertView.inflate(context,R.layout.child_item,null);
            viewHolder2=new ViewHolder2();
            viewHolder2.textView2= (TextView) convertView.findViewById(R.id.tv_child);
            convertView.setTag(viewHolder2);
        }
        else
        {
            viewHolder2= (ViewHolder2) convertView.getTag();
        }
        viewHolder2.textView2.setText(childs[groupPosition][childPosition]);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
    static class ViewHolder1
    {
        private  TextView   tv_group;
    }
    static class ViewHolder2
    {
        private  TextView  textView2;
    }
}
