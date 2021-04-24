package com.zhaopf.allsimpleproject.ui.fragment;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.zhaopf.allsimpleproject.BaseFragment;
import com.zhaopf.allsimpleproject.InitApp;

import java.util.ArrayList;


public class C_ComBined_fragment extends BaseFragment implements CreateView {

    public C_ComBined_fragment(int imageRsc) {
        super(imageRsc);
    }

    @Override
    protected String setAbout() {
        return "x轴: 调用.getXAxis()获取\n" +
                "左边y轴: 调用.getAxisLeft()获取\n" +
                "右边y轴: 调用.getAxisRight()获取\n" +
                "获取两个轴: YAxis yAxis = radarChart.getYAxis();\n" +
                "设置用右Y轴描述: lineDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);" +
                "";
    }

    @Override
    protected void setView(LinearLayout main) {

    }


    @Override
    public CombinedChart createView() {
        CombinedChart mCombinedChart = new CombinedChart(InitApp.getContext());

        mCombinedChart.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 800));
        mCombinedChart.setTouchEnabled(false);
        mCombinedChart.setDragEnabled(false);

        mCombinedChart.getDescription().setEnabled(false);

        YAxis axisLeft = mCombinedChart.getAxisLeft();
        YAxis axisRight = mCombinedChart.getAxisRight();
        axisRight.setLabelCount(8, true);
        axisRight.setAxisMaximum(0.7f);
        axisRight.setAxisMinimum(0);
        axisRight.setDrawGridLines(false);
        axisRight.setDrawAxisLine(false);
        axisRight.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return ((int) (value * 100)) + "%";
            }
        });

        axisLeft.setLabelCount(6, true);
        axisLeft.setAxisMaximum(250);
        axisLeft.setAxisMinimum(0);
        axisLeft.setDrawAxisLine(false);


        XAxis xAxis = mCombinedChart.getXAxis();

        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularityEnabled(true);
        xAxis.setSpaceMax(0.5f);
        xAxis.setSpaceMin(0.5f);
        xAxis.setValueFormatter((value, axis) -> {
            Log.e("values", value + "");
            String[] strings = {"2015年", "2015年", "2016年", "2017年", "2018年", "2019年",};
            return strings[(int) (value % strings.length)];
        });

        //region 直线图
        ArrayList<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(1, 0.45f));
        entries.add(new Entry(2, 0.68f));
        entries.add(new Entry(3, 0.52f));
        entries.add(new Entry(4, 0.48f));
        entries.add(new Entry(5, 0.45f));
        entries.add(new Entry(6, 0.41f));

        LineDataSet lineDataSet = new LineDataSet(entries, "相较上一年增长率");
        lineDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
        lineDataSet.setDrawCircles(true);

        lineDataSet.setCircleColor(0xffED7D31);
        lineDataSet.setCircleColorHole(0xffED7D31);

        lineDataSet.setColor(0xffED7D31);
        lineDataSet.setLineWidth(2f);
        lineDataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return value + "";
            }
        });

        LineData lineData = new LineData(lineDataSet);
        //endregion


        //region 柱形图
        ArrayList<BarEntry> entries2 = new ArrayList<BarEntry>();
        entries2.add(new BarEntry(1, 30));
        entries2.add(new BarEntry(2, 48));
        entries2.add(new BarEntry(3, 70));
        entries2.add(new BarEntry(4, 105));
        entries2.add(new BarEntry(5, 150));
        entries2.add(new BarEntry(6, 210));

        BarDataSet barDataSet = new BarDataSet(entries2, "中国大数据产业规模(亿元)");
        barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        barDataSet.setFormLineWidth(5);
        barDataSet.setColor(0xff5B9BD5);

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.25f);

        //endregion


        CombinedData combinedData = new CombinedData();

        mCombinedChart.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        combinedData.setData(lineData);
        combinedData.setData(barData);
        mCombinedChart.setData(combinedData);

        return mCombinedChart;
    }

}