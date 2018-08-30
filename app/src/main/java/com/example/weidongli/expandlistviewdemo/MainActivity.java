package com.example.weidongli.expandlistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String[] groupData = {"第一组", "第二组", "第三组", "第四组"};

    public String[][] childData = {
            {"第一组——01", "第一组——02", "第一组——03", "第一组——04"},
            {"第二组——01", "第二组——02", "第二组——03", "第一组——04"},
            {"第三组——01", "第三组——02", "第三组——03", "第三组——04"},
            {"第四组——01", "第四组——02", "第四组——03", "第四组——04"}
    };

    private ExpandableListView expandableListView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.expand_list);
        adapter = new MyAdapter(MainActivity.this, groupData, childData);
        expandableListView.setAdapter(adapter);
        //默认两级列表全部展示
//        for (int i = 0; i <groupData.length ; i++) {
//
//            expandableListView.expandGroup(i);
//        }
        initListener();

    }

    private void initListener() {
        /**
         *  设置分组项的点击监听事件
         */
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long id) {

                boolean expanded = expandableListView.isGroupExpanded(groupPosition);
                if (expanded) {
                    expandableListView.collapseGroup(groupPosition);
                } else {
                    expandableListView.expandGroup(groupPosition);
                }

                // 请务必返回 false，否则分组不会展开
                return true;
            }
        });

        /**
         *  设置子选项点击监听事件
         */
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), childData[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        /**
         * 分组展开的监听事件
         */
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
            }
        });

        /**
         * 分组合并的监听事件
         */
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {


            }
        });
    }


}
