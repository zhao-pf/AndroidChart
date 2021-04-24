package com.zhaopf.allsimpleproject.ui.fragment;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.zhaopf.allsimpleproject.BaseFragment;
import com.zhaopf.allsimpleproject.InitApp;

import java.util.ArrayList;


public class H_LineChat_fragment extends BaseFragment {

    public H_LineChat_fragment(int imageRsc) {
        super(imageRsc);
    }

    @Override
    protected String setAbout() {
        return "添加两个图表\n" +
                "ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();\n" +
                "iLineDataSets.add(lineDataSet);\n" +
                "iLineDataSets.add(lineDataSet1);";
    }

    @Override
    protected void setView(LinearLayout main) {

    }


    @Override
    public LineChart createView() {
        LineChart lineChart = new LineChart(InitApp.getContext());
        lineChart.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400));
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setTextSize(22);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(0xff4759B8);
        xAxis.setXOffset(50);
        xAxis.setXOffset(50);
        xAxis.setGranularityEnabled(true);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                String[] strings = {"昨天", "今天", "明天", "周五", "周六", "周日"};
                return strings[((int) value)];
            }
        });

        YAxis axisLeft = lineChart.getAxisLeft();
        axisLeft.setLabelCount(4, false);
        axisLeft.setAxisMaximum(26);
        axisLeft.setAxisMinimum(14);
        axisLeft.setDrawLabels(false);
        axisLeft.setDrawAxisLine(false);


        YAxis axisRight = lineChart.getAxisRight();
        axisRight.setLabelCount(4, false);
        axisRight.setAxisMaximum(25);
        axisRight.setAxisMinimum(14);
        axisRight.setDrawLabels(false);
        axisRight.setDrawAxisLine(false);

        ArrayList<Entry> barEntries1 = new ArrayList<>();
        barEntries1.add(new Entry(0, 22));
        barEntries1.add(new Entry(1, 24));
        barEntries1.add(new Entry(2, 25));
        barEntries1.add(new Entry(3, 25));
        barEntries1.add(new Entry(4, 25));
        barEntries1.add(new Entry(5, 22));
        LineDataSet lineDataSet = new LineDataSet(barEntries1, "1111");
        lineDataSet.setColor(0xffA94542);
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setCircleColorHole(0xffA94542);
        lineDataSet.setCircleColor(0xffA94542);


        ArrayList<Entry> barEntries2 = new ArrayList<>();
        barEntries2.add(new Entry(0, 14));
        barEntries2.add(new Entry(1, 15));
        barEntries2.add(new Entry(2, 16));
        barEntries2.add(new Entry(3, 17));
        barEntries2.add(new Entry(4, 16));
        barEntries2.add(new Entry(5, 16));
        LineDataSet lineDataSet1 = new LineDataSet(barEntries2, "2222");
        lineDataSet1.setColor(0xff4370A5);
        lineDataSet1.setCircleColorHole(0xff4370A5);
        lineDataSet1.setCircleColor(0xff4370A5);
        lineDataSet1.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
        iLineDataSets.add(lineDataSet);
        iLineDataSets.add(lineDataSet1);

        LineData lineData = new LineData(iLineDataSets);

        for (ILineDataSet iLineDataSet : iLineDataSets) {
            ((LineDataSet) iLineDataSet).setDrawCircles(true);
            ((LineDataSet) iLineDataSet).setLineWidth(3);
            ((LineDataSet) iLineDataSet).setValueFormatter(new IValueFormatter() {
                @Override
                public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                    return ((int) value) + "";
                }
            });

        }
        lineChart.setExtraOffsets(20, 20, 20, 20);
        lineChart.getDescription().setEnabled(false);
        lineChart.getLegend().setEnabled(false);
        lineChart.setData(lineData);

        return lineChart;
    }

}