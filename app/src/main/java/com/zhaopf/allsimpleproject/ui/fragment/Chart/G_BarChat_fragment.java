package com.zhaopf.allsimpleproject.ui.fragment.Chart;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.zhaopf.allsimpleproject.BaseFragment;
import com.zhaopf.allsimpleproject.InitApp;

import java.util.ArrayList;


public class G_BarChat_fragment extends BaseFragment {

    public G_BarChat_fragment(int imageRsc) {
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
    public HorizontalBarChart createView() {
        HorizontalBarChart barChart = new HorizontalBarChart(InitApp.getContext());
        barChart.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 750));


        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0, 11f));
        barEntries.add(new BarEntry(1, 7f));
        barEntries.add(new BarEntry(2, 6f));
        barEntries.add(new BarEntry(3, 17f));
        barEntries.add(new BarEntry(4, 15f));
        barEntries.add(new BarEntry(5, 16f));
        barEntries.add(new BarEntry(6, 3f));
        barEntries.add(new BarEntry(7, 12f));
        barEntries.add(new BarEntry(8, 10f));
        barEntries.add(new BarEntry(9, 3f));


        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setDrawGridLines(false);

        xAxis.setLabelCount(10,false);
//        xAxis.setTextSize(18);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                Log.e("value", value + "");
                String[] strings = {"云销售工程师", "云产品经理", "云计算数据分析工程师", "云计算系统运维工程师", "云软件工程师", "云交付工程师", "云咨询师", "云系统管理员", "云数据库开发工程师", "云计算架构师"};
                return strings[(int) (value)];
            }
        });

        YAxis axisLeft = barChart.getAxisLeft();
        YAxis axisRight = barChart.getAxisRight();
        axisRight.setAxisMaximum(18);
        axisRight.setLabelCount(10,false);
        axisRight.setValueFormatter(new PercentFormatter());

        axisLeft.setEnabled(false);








//        axisLeft.setDrawGridLines(false); // 设置线
//        axisLeft.setDrawLabels(false); // 设置标签
//        axisLeft.setDrawAxisLine(false);  // 设置线
//
//        axisRight.setDrawGridLines(false); // 设置线
//        axisRight.setDrawLabels(false); // 设置标签
//        axisRight.setDrawAxisLine(false);  // 设置线

        BarDataSet barDataSet = new BarDataSet(barEntries, "");

        barDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);

        barDataSet.setColor(0xff70AD47);
        barDataSet.setFormLineWidth(10);
        barDataSet.setColor(0xff5B9BD5);

        BarData barData = new BarData(barDataSet);
        barData.setValueTextSize(13);
        barData.setBarWidth(0.3f);
        barChart.setData(barData);

        barChart.getDescription().setEnabled(false);

        Legend legend = barChart.getLegend();
        legend.setEnabled(false);

        return barChart;
    }

}