package com.zhaopf.allsimpleproject.ui.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.zhaopf.allsimpleproject.BaseFragment;
import com.zhaopf.allsimpleproject.InitApp;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class E_BarChat_fragment extends BaseFragment {

    public E_BarChat_fragment(int imageRsc) {
        super(imageRsc);
    }

    @Override
    protected String setAbout() {
        return "";
    }

    @Override
    protected void setView(LinearLayout main) {

    }


    @Override
    public BarChart createView() {
        BarChart barChart = new BarChart(InitApp.getContext());
        barChart.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,800));


        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0,251.1f));
        barEntries.add(new BarEntry(1,570.1f));
        barEntries.add(new BarEntry(2,819.8f));
        barEntries.add(new BarEntry(3,1157f));
        barEntries.add(new BarEntry(4,1573f));



        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularityEnabled(true);
        xAxis.setTextSize(18);

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                Log.e("value",value+"");
                String[] strings = {"2018", "2019e", "2020e", "2021e", "2022e"};
                return strings[(int) (value)];
            }
        });

        YAxis axisLeft = barChart.getAxisLeft();
        YAxis axisRight = barChart.getAxisRight();

        axisLeft.setDrawGridLines(false); // 设置线
        axisLeft.setDrawLabels(false); // 设置标签
        axisLeft.setDrawAxisLine(false);  // 设置线

        axisRight.setDrawGridLines(false); // 设置线
        axisRight.setDrawLabels(false); // 设置标签
        axisRight.setDrawAxisLine(false);  // 设置线

        BarDataSet barDataSet = new BarDataSet(barEntries, "人工智能赋能实体经济所产生的市场规模（亿元）");
        barDataSet.setColor(0xff70AD47);
        barDataSet.setFormLineWidth(50);

        BarData barData = new BarData(barDataSet);
        barData.setValueTextSize(13);
        barData.setBarWidth(0.6f);
        barChart.setData(barData);


        Legend legend = barChart.getLegend();
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setTextSize(12);
        Description description = barChart.getDescription();

        Resources resources = getActivity().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        description.setTypeface(Typeface.DEFAULT_BOLD);
        description.setPosition(displayMetrics.widthPixels/2,60);
        description.setText("2018-2022年中国人工智能赋能试题经纪市场规模");
        description.setTextAlign(Paint.Align.CENTER);
        description.setTextSize(16);
        barChart.setExtraTopOffset(50);
        return barChart;
    }

}