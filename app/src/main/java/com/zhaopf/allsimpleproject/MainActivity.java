package com.zhaopf.allsimpleproject;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.zhaopf.allsimpleproject.bean.ImageBean;
import com.zhaopf.allsimpleproject.ui.adapter.ItemMainAdapter;
import com.zhaopf.allsimpleproject.ui.fragment.A_PieChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.C_ComBined_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.B_PieChat_fragment;
import com.zhaopf.allsimpleproject.ui.fragment.D_PieChat_fragment;

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
        initView();
        addListData();
        test();
    }

    private void test() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main, new D_PieChat_fragment(R.drawable.d)).commit();
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
    public void onChangeFragment(ImageBean bean, ImageView imageView, ConstraintLayout clMain) {
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