package com.zhaopf.allsimpleproject.ui.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.zhaopf.allsimpleproject.BaseFragment;
import com.zhaopf.allsimpleproject.InitApp;

import java.util.ArrayList;


public class E_BarChat_fragment extends BaseFragment {

    public E_BarChat_fragment(int imageRsc) {
        super(imageRsc);
    }

    @Override
    protected String setAbout() {
        return "barChart.setDrawHoleEnabled(false); // 关闭中间洞\n" +
                "barChart.setDrawEntryLabels(false); //关闭介绍文字\n" +
                "barChart.setUsePercentValues(true); // 设置为百分比\n" +
                "barData.setValueFormatter(new PercentFormatter());\n" +
                "\n" +
                "pieDataSet.setValueLinePart1OffsetPercentage(80f); // 设置横线和中心的距离\n" +
                "pieDataSet.setValueLinePart1Length(0.5f); // 设置第一条横线的长短\n" +
                "pieDataSet.setValueLinePart2Length(0.5f);\n" +
                "pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE); //设置值在外面";
    }

    @Override
    protected void setView(LinearLayout main) {

    }


    @Override
    public BarChart createView() {
        BarChart barChart = new BarChart(InitApp.getContext());
        barChart.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,800));

        return barChart;
    }

}