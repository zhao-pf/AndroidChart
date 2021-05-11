package com.zhaopf.allsimpleproject.ui.fragment.Chart;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.zhaopf.allsimpleproject.base.BaseFragment;
import com.zhaopf.allsimpleproject.InitApp;
import com.zhaopf.allsimpleproject.R;
import com.zhaopf.allsimpleproject.ui.fragment.Chart.makerview.CustomMakerView;

import java.util.ArrayList;
import java.util.Random;

/**
 * @创建者 赵鹏飞
 * @文件介绍 TODO
 * @创建日期 2021/4/28 16:56
 * @Github https://github.com/zhao-pf
 */
public class I_BarChat_fragment extends BaseFragment {


    private BarChart mBarChart;

    public I_BarChat_fragment(int imageRsc) {
        super(imageRsc);
    }

    @Override
    protected String setAbout() {
        return "获取屏幕宽度：getActivity().getResources().getDisplayMetrics().widthPixels\n" +
                "Description description = mBarChart.getDescription();\n" +
                "description.setText(\"更新数据的图表\"); // 标题\n" +
                "description.setTextSize(22f); // 文字大小\n" +
                "description.setTypeface(Typeface.DEFAULT_BOLD); // 文字加粗\n" +
                "description.setTextAlign(Paint.Align.CENTER); // 文字居中\n" +
                "int widthPixels = getActivity().getResources().getDisplayMetrics().widthPixels; // 屏幕宽度\n" +
                "description.setPosition(widthPixels /2, 70); // 显示位置";
    }

    @Override
    protected void setView(LinearLayout main) {

    }

    @Override
    public BarChart createView() {
        mBarChart = new BarChart(InitApp.getContext());
        mBarChart.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500));
        new Thread(() -> {
            while (true) {
                getData();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(20);


        YAxis axisLeft = mBarChart.getAxisLeft();
        axisLeft.setAxisMaximum(108);
        axisLeft.setAxisMinimum(0);
        axisLeft.setLabelCount(7, true);
        YAxis axisRight = mBarChart.getAxisRight();
        axisRight.setEnabled(false);

        Description description = mBarChart.getDescription();
        description.setText("更新数据的图表"); // 标题
        description.setTextSize(22f); // 文字大小
        description.setTypeface(Typeface.DEFAULT_BOLD); // 文字加粗
        description.setTextAlign(Paint.Align.CENTER); // 文字居中
        int widthPixels = getActivity().getResources().getDisplayMetrics().widthPixels; // 屏幕宽度
        description.setPosition(widthPixels / 2, 70); // 显示位置
        mBarChart.setExtraTopOffset(40);
        mBarChart.getLegend().setEnabled(false);

        return mBarChart;
    }


    private void getData() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            barEntries.add(new BarEntry(i, new Random().nextInt(108)));
        }
        BarDataSet barDataSet = new BarDataSet(barEntries, "");
        barDataSet.setDrawValues(false);
        barDataSet.setColor(0xffBBBBBB);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.5f);

        mBarChart.setData(barData);
        mBarChart.postInvalidate();
        mBarChart.setMarker(new CustomMakerView(InitApp.getContext(), R.layout.custom_marker_view_layout));
    }

}