package com.zhaopf.allsimpleproject.ui.fragment.Chart;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.zhaopf.allsimpleproject.base.BaseFragment;
import com.zhaopf.allsimpleproject.InitApp;

import java.util.ArrayList;

/**
 * @创建者 赵鹏飞
 * @文件介绍 TODO
 * @创建日期 2021/4/28 16:56
 * @Github https://github.com/zhao-pf
 */
public class B_PieChat_fragment extends BaseFragment {

    public B_PieChat_fragment(int imageRsc) {
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
    public PieChart createView() {
        PieChart barChart = new PieChart(InitApp.getContext());
        barChart.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 550));

        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        pieEntries.add(new PieEntry(53.8f, "AI+安防"));
        pieEntries.add(new PieEntry(3.6f, "AI+零售"));
        pieEntries.add(new PieEntry(4.f, "AI+客服"));
        pieEntries.add(new PieEntry(4.2f, "AI+交通"));
        pieEntries.add(new PieEntry(15.8f, "AI+金融"));
        pieEntries.add(new PieEntry(0.4f, "AI+医疗"));
        pieEntries.add(new PieEntry(2.4f, "AI+教育"));
        pieEntries.add(new PieEntry(0.8f, "AI+农业"));
        pieEntries.add(new PieEntry(11.6f, "AI+营销"));
        pieEntries.add(new PieEntry(3.4f, "AI+制造"));



        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");


        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(0xff6FB242);
        colors.add(0xff598E35);
        colors.add(0xffFED129);
        colors.add(0xff648CD4);
        colors.add(0xff8AC564);
        colors.add(0xffA17808);
        colors.add(0xff27467E);
        colors.add(0xff547540);
        colors.add(0xffFFC609);
        colors.add(0xff4272CA);

        pieDataSet.setColors(colors);


        pieDataSet.setValueTextColor(Color.BLACK); // 文字颜色

        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE); // 设置值在外面

        pieDataSet.setValueLinePart1OffsetPercentage(80f); // 设置横线和中心的距离
        pieDataSet.setValueLinePart1Length(0.5f); // 设置第一条横线的长短
        pieDataSet.setValueLinePart2Length(0.5f);

        PieData barData = new PieData(pieDataSet);
        barData.setValueFormatter(new PercentFormatter());

//        barChart.getDescription().setEnabled(false); // 设置右下角介绍关闭
        barChart.setDrawHoleEnabled(false); // 关闭中间洞
        barChart.setDrawEntryLabels(false); //关闭介绍文字

        barChart.setUsePercentValues(true); // 设置为百分比
        barChart.setExtraLeftOffset(50);
        barChart.setExtraRightOffset(40);
        Legend legend = barChart.getLegend();
        legend.setWordWrapEnabled(true); // 设置图例自动换行
//        legend.setXEntrySpace(50);

        Description description = barChart.getDescription();
        description.setText("2018年中国人工智能赋能试题经纪各产业份额");
        description.setTextAlign(Paint.Align.CENTER);
        description.setTextSize(18);
        description.setPosition(getActivity().getResources().getDisplayMetrics().widthPixels/2,40);
        description.setTypeface(Typeface.DEFAULT_BOLD);


        barChart.setData(barData);
        barChart.setExtraTopOffset(20);
        return barChart;
    }

}