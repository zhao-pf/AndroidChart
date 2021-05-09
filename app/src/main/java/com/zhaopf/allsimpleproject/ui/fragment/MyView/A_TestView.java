package com.zhaopf.allsimpleproject.ui.fragment.MyView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.util.TypedValue;
import android.view.View;

import retrofit2.http.PATCH;

/**
 * @创建者 赵鹏飞
 * @文件介绍 TODO
 * @创建日期 2021/4/28 16:56
 * @Github https://github.com/zhao-pf
 */
public class A_TestView extends View {

    public A_TestView(Context context) {
        super(context);

    }

    public static float dp2px(float px) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, Resources.getSystem().getDisplayMetrics());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }
}
