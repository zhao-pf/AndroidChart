package com.zhaopf.allsimpleproject.ui.fragment.MyView;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
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


public class A_TestView_fragment extends BaseFragment {

    public A_TestView_fragment(int imageRsc) {
        super(imageRsc);
    }

    @Override
    protected String setAbout() {
        return "自定义View";
    }

    @Override
    protected void setView(LinearLayout main) {

    }


    @Override
    public A_TestView createView() {
        A_TestView a_testView = new A_TestView(InitApp.getContext());

        return a_testView;
    }

}

