package com.zhaopf.allsimpleproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.Chart;

/**
 * @创建者 赵鹏飞
 * @文件介绍 TODO
 * @创建日期 2021/4/21 20:41
 * @Github https://github.com/zhao-pf
 */
abstract public class BaseFragment extends Fragment {
    private int imageRsc;

    public BaseFragment(int imageRsc) {
        this.imageRsc = imageRsc;
    }

    public int getImageRsc() {
        return imageRsc;
    }

    public abstract View createView();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_fragment, container, false);
        ImageView ivMain = view.findViewById(R.id.iv_main);
        LinearLayout llMain = view.findViewById(R.id.ll_main);
        TextView tvAbout = view.findViewById(R.id.tv_about);

        ivMain.setImageResource(imageRsc);

        View view1 = createView();
        view.invalidate();
        llMain.addView(view1);
        if (setAbout()!=null){
            tvAbout.setText(setAbout());
        }
        setView(llMain);
        return view;
    }

    protected abstract String setAbout();

    protected abstract void setView(LinearLayout main);

}
