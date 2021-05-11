package com.zhaopf.allsimpleproject;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.zhaopf.allsimpleproject.bean.ImageBean;
import com.zhaopf.allsimpleproject.ui.adapter.ItemMainAdapter;
import com.zhaopf.allsimpleproject.ui.fragment.Chart.A_PieChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.Chart.C_ComBined_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.Chart.B_PieChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.Chart.D_PieChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.Chart.E_BarChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.Chart.F_PieChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.Chart.G_BarChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.Chart.H_LineChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.Chart.I_BarChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.MyView.A_Circle_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.MyView.B_Girl_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.MyView.C_Speed_fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemMainAdapter.OnClickChangeFragmentListener {


    private RecyclerView mRecyclerView;
    private List<ImageBean> items = new ArrayList();
    private LinearLayout mMain;
    private ItemMainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initView();
        initRecyclerView();
        test();
    }

    /**
     * 初始化 Toolbar 居中标题
     */
    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View childAt = toolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView at = (TextView) childAt;
                at.setLayoutParams(new Toolbar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT,Gravity.CENTER));
            }
        }
    }

    private void test() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main, new C_Speed_fragment(R.drawable.view_c)).commit();
        mMain.setVisibility(mMain.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
    }

    private void initRecyclerView() {
        mAdapter = new ItemMainAdapter(this, items);
//        addChartData(); // 添加图表数据
        addViewData(); // 添加图表数据
        int LIST_COUNT = 2;
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(LIST_COUNT, 1));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setListener(this);
    }

    private void addViewData() {
        mAdapter.addFragment(new ImageBean(new A_Circle_fragment(R.drawable.view_a), "熟悉"));
        mAdapter.addFragment(new ImageBean(new B_Girl_fragment(R.drawable.view_b), "小女孩(填充规则)"));
        mAdapter.addFragment(new ImageBean(new C_Speed_fragment(R.drawable.view_c), "速度表"));
    }

    private void addChartData() {
        mAdapter.addFragment(new ImageBean(new A_PieChat_fragment(R.drawable.chart_a), "饼图1 PieChat"));
        mAdapter.addFragment(new ImageBean(new B_PieChat_fragment(R.drawable.chart_b), "饼图2 PieChat"));
        mAdapter.addFragment(new ImageBean(new C_ComBined_fragment(R.drawable.chart_c), "组合图表(折线柱形) ComBined"));
        mAdapter.addFragment(new ImageBean(new D_PieChat_fragment(R.drawable.chart_d), "饼图3 PieChat"));
        mAdapter.addFragment(new ImageBean(new E_BarChat_fragment(R.drawable.chart_e), "柱形图 BarChat"));
        mAdapter.addFragment(new ImageBean(new F_PieChat_fragment(R.drawable.chart_f), "饼图4 PieChat"));
        mAdapter.addFragment(new ImageBean(new G_BarChat_fragment(R.drawable.chart_g), "柱形图(横向排列) PieChat"));
        mAdapter.addFragment(new ImageBean(new H_LineChat_fragment(R.drawable.chart_h), "折线图 LineChat"));
        mAdapter.addFragment(new ImageBean(new I_BarChat_fragment(R.drawable.chart_i), "柱形图(动态更新点击显示数据) BarChat"));
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mMain = findViewById(R.id.main);

    }

    @Override
    public void onBackPressed() {
        setTitle("图表列表");
        if (mMain.getVisibility() == View.GONE) {
            super.onBackPressed();
            return;
        }
        setAnimator(mMain, mRecyclerView);
    }

    @Override
    public void onChangeFragment(ImageBean bean, ImageView imageView, RelativeLayout clMain) {
        imageView.setImageResource(bean.getImageRes());
        clMain.setOnClickListener((view) -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.main, bean.getFragment()).commit();
            setTitle(bean.getName());
            setAnimator(mRecyclerView, mMain);//设置动画
        });
    }

    private void setAnimator(View start, View end) {
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(start, "alpha", 1f, 0f).setDuration(500);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(end, "alpha", 0f, 1f).setDuration(500);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator1).with(objectAnimator2);
        animatorSet.start();
        mMain.setVisibility(mMain.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        mRecyclerView.setVisibility(mMain.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
    }
}