package com.zhaopf.allsimpleproject.ui.fragment.Chart;

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


public class A_PieChat_fragment extends BaseFragment {

    public A_PieChat_fragment(int imageRsc) {
        super(imageRsc);
    }

    @Override
    protected String setAbout() {
        return "legend.setOrientation(Legend.LegendOrientation.VERTICAL); // 设置图例为垂直\n" +
                "legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT); // 设置图例水平位置 右\n" +
                "legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP); // 设置图例垂直位置 顶部\n" +
                "legend.setTextSize(15); // 设置图例字体大小\n" +
                "legend.setFormSize(9); // 设置图例方块大小\n" +
                "legend.setTextColor(0xffA3A3A3); //设置图例字体颜色\n" +
                "barChart.setExtraOffsets(0,0,60,0); // 设置图标边距";
    }

    @Override
    protected void setView(LinearLayout main) {

    }


    @Override
    public PieChart createView() {
        PieChart barChart = new PieChart(InitApp.getContext());
        barChart.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500));

        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        pieEntries.add(new PieEntry(1f, "汉族"));
        pieEntries.add(new PieEntry(1.5f, "回族"));
        pieEntries.add(new PieEntry(2f, "壮族"));
        pieEntries.add(new PieEntry(2.5f, "维吾尔族"));
        pieEntries.add(new PieEntry(3f, "土家族"));


        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");


        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(0xff6685F1);
        colors.add(0xff675DF2);
        colors.add(0xff466DF0);
        colors.add(0xffA963F9);
        colors.add(0xff57A9F3);


        pieDataSet.setColors(colors);


        pieDataSet.setValueTextColor(Color.BLACK); // 文字颜色

        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE); // 设置值在外面

        pieDataSet.setValueLinePart1OffsetPercentage(80f); // 设置横线和中心的距离
        pieDataSet.setValueLinePart1Length(0.4f); // 设置第一条横线的长短
        pieDataSet.setValueLinePart2Length(0.3f);
        pieDataSet.setValueLineColor(0xffA898BD);

        pieDataSet.setValueLineVariableLength(false);

        pieDataSet.setValueTextColor(Color.RED);
        pieDataSet.setValueTextSize(18);

        PieData barData = new PieData(pieDataSet);
        barData.setValueFormatter(new PercentFormatter());

        barChart.getDescription().setEnabled(false); // 设置右下角介绍关闭
        barChart.setDrawHoleEnabled(false); // 关闭中间洞
        barChart.setDrawEntryLabels(false); //关闭介绍文字

        barChart.setUsePercentValues(true); // 设置为百分比
        barChart.setExtraLeftOffset(50);
        barChart.setExtraRightOffset(40);
        Legend legend = barChart.getLegend();
//        legend.setXEntrySpace(50);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL); // 设置图例为垂直
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT); // 设置图例水平位置 右
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP); // 设置图例垂直位置 顶部

        legend.setYEntrySpace(12);
        legend.setXOffset(10);

        legend.setTextSize(15); // 设置图例字体大小
        legend.setFormSize(9); // 设置图例方块大小
        legend.setTextColor(0xffA3A3A3); //设置图例字体颜色

        barChart.setData(barData);
        barChart.setExtraOffsets(0,0,60,0);
        return barChart;
    }

}