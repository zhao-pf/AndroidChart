package com.zhaopf.allsimpleproject;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
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
import com.zhaopf.allsimpleproject.ui.fragment.A_PieChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.C_ComBined_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.B_PieChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.D_PieChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.E_BarChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.F_PieChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.G_BarChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.H_LineChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.I_BarChat_fragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemMainAdapter.OnClickChangeFragmentListener {


    private RecyclerView mRecyclerView;
    private List<ImageBean> items = new ArrayList();
    private LinearLayout mMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initView();
        addListData();
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
        getSupportFragmentManager().beginTransaction().replace(R.id.main, new I_BarChat_fragment(R.drawable.i)).commit();
        mMain.setVisibility(mMain.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
    }

    private void addListData() {
        final ItemMainAdapter adapter = new ItemMainAdapter(this, items);
        addListData(adapter);
        int LIST_COUNT = 2;
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(LIST_COUNT, 1));
        mRecyclerView.setAdapter(adapter);
        adapter.setListener(this);
    }

    private void addListData(ItemMainAdapter adapter) {
        adapter.addFragment(new ImageBean(new A_PieChat_fragment(R.drawable.a), "饼图1 PieChat"));
        adapter.addFragment(new ImageBean(new B_PieChat_fragment(R.drawable.b), "饼图2 PieChat"));
        adapter.addFragment(new ImageBean(new C_ComBined_fragment(R.drawable.c), "组合图表(折线柱形) ComBined"));
        adapter.addFragment(new ImageBean(new D_PieChat_fragment(R.drawable.d), "饼图3 PieChat"));
        adapter.addFragment(new ImageBean(new E_BarChat_fragment(R.drawable.e), "柱形图 BarChat"));
        adapter.addFragment(new ImageBean(new F_PieChat_fragment(R.drawable.f), "饼图4 PieChat"));
        adapter.addFragment(new ImageBean(new G_BarChat_fragment(R.drawable.g), "柱形图(横向排列) PieChat"));
        adapter.addFragment(new ImageBean(new H_LineChat_fragment(R.drawable.h), "折线图 LineChat"));
        adapter.addFragment(new ImageBean(new I_BarChat_fragment(R.drawable.i), "柱形图(动态更新点击显示数据) BarChat"));
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