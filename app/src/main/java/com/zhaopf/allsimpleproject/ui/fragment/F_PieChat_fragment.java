package com.zhaopf.allsimpleproject.ui.fragment;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.zhaopf.allsimpleproject.BaseFragment;
import com.zhaopf.allsimpleproject.InitApp;

import java.util.ArrayList;


public class F_PieChat_fragment extends BaseFragment {

    public F_PieChat_fragment(int imageRsc) {
        super(imageRsc);
    }

    @Override
    protected String setAbout() {
        return "设置值的时候是15.2%的话不需要设置为0.152，直接设置为15.2\n" +
                "居中图例: legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);\n" +
                "pieDataSet.setSliceSpace(2); // 每个格之间的间隙\n" +
                "barChart.setHoleRadius(75f); // 设置圆的大小粗细";
    }

    @Override
    protected void setView(LinearLayout main) {

    }


    @Override
    public PieChart createView() {
        PieChart barChart = new PieChart(InitApp.getContext());
        barChart.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400));

        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        pieEntries.add(new PieEntry(17.9f, "应用层企业"));
        pieEntries.add(new PieEntry(77.7f, "技术层企业"));
        pieEntries.add(new PieEntry(5.4f, "基础层企业"));


        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(0xff5B9BD5);
        colors.add(0xffED7D31);
        colors.add(0xffA5A5A5);


        pieDataSet.setColors(colors);


        pieDataSet.setValueTextColor(Color.BLACK); // 文字颜色
        pieDataSet.setValueFormatter(new PercentFormatter());
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE); // 设置值在外面

        pieDataSet.setValueLinePart1OffsetPercentage(80f); // 设置横线和中心的距离
        pieDataSet.setValueLinePart1Length(0.2f); // 设置第一条横线的长短
        pieDataSet.setValueLinePart2Length(0.3f);
        pieDataSet.setSliceSpace(2); // 每个格之间的间隙

        PieData barData = new PieData(pieDataSet);


        barChart.getDescription().setEnabled(false); // 设置右下角介绍关闭
//        barChart.setDrawHoleEnabled(false); // 关闭中间洞
        barChart.setDrawEntryLabels(false); // 关闭介绍文字

        barChart.setUsePercentValues(true); // 设置为百分比
        barChart.setExtraLeftOffset(50);
        barChart.setExtraRightOffset(40);

        barChart.setHoleRadius(75f); // 设置圆的大小粗细

        Legend legend = barChart.getLegend();
//        legend.setWordWrapEnabled(true); // 设置图例自动换行
//        legend.setXEntrySpace(50);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

        barChart.setData(barData);

        return barChart;
    }

}