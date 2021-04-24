package com.zhaopf.allsimpleproject.ui.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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


public class D_PieChat_fragment extends BaseFragment {

    public D_PieChat_fragment(int imageRsc) {
        super(imageRsc);
    }

    @Override
    protected String setAbout() {
        return "pieDataSet.setValueFormatter(new IValueFormatter() {\n" +
                "    int i = 0;\n" +
                "    @Override\n" +
                "    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {\n" +
                "        Log.e(\"dataSetIndex\", value + \"\");\n" +
                "        Log.e(\"dataSetIndex\", entry.toString() + \"\");\n" +
                "        String[] strings = {\"视觉\", \"语音\", \"自然语言\", \"硬件\", \"算法\"};\n" +
                "        if (i == strings.length) i = 0;\n" +
                "        return strings[i++] + \",\\n\" + (value * 100) + \"%\";\n" +
                "    }\n" +
                "});";
    }

    @Override
    protected void setView(LinearLayout main) {

    }


    @Override
    public PieChart createView() {
        PieChart barChart = new PieChart(InitApp.getContext());
        barChart.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 600));

        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        pieEntries.add(new PieEntry(0.349f, "视觉"));
        pieEntries.add(new PieEntry(0.248f, "语音"));
        pieEntries.add(new PieEntry(0.21f, "自然语言"));
        pieEntries.add(new PieEntry(0.113f, "硬件"));
        pieEntries.add(new PieEntry(0.08f, "算法"));


        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(0xffFFC000);
        colors.add(0xffA5A5A5);
        colors.add(0xff4472C4);
        colors.add(0xffED7D31);
        colors.add(0xff5B9BD5);

        pieDataSet.setColors(colors);


        pieDataSet.setValueTextColor(Color.BLACK); // 文字颜色

        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE); // 设置值在外面

        pieDataSet.setValueLinePart1OffsetPercentage(80f); // 设置横线和中心的距离
        pieDataSet.setValueLinePart1Length(0.5f); // 设置第一条横线的长短
        pieDataSet.setValueLinePart2Length(0.5f);
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(10);
        PieData barData = new PieData(pieDataSet);

        pieDataSet.setValueFormatter(new IValueFormatter() {
            int i = 0;
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                Log.e("dataSetIndex", value + "");
                Log.e("dataSetIndex", entry.toString() + "");
                String[] strings = {"视觉", "语音", "自然语言", "硬件", "算法"};
                if (i == strings.length) i = 0;
                return strings[i++] + ",\n" + (value * 100) + "%";
            }
        });

        barChart.getDescription().setEnabled(false); // 设置右下角介绍关闭
        barChart.setDrawHoleEnabled(false); // 关闭中间洞
        barChart.setDrawEntryLabels(false); //关闭介绍文字

//        barChart.setUsePercentValues(true); // 设置为百分比

        Legend legend = barChart.getLegend();
        legend.setEnabled(false);
//        legend.setXEntrySpace(50);


        barChart.setData(barData);

        return barChart;
    }

}