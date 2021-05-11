package com.zhaopf.allsimpleproject.ui.fragment.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.LinearLayout;

import com.zhaopf.allsimpleproject.base.BaseFragment;
import com.zhaopf.allsimpleproject.base.BaseView;
import com.zhaopf.allsimpleproject.InitApp;

/**
 * @创建者 赵鹏飞
 * @文件介绍 TODO
 * @创建日期 2021/4/28 16:56
 * @Github https://github.com/zhao-pf
 */
public class A_Circle_fragment extends BaseFragment {

    public A_Circle_fragment(int imageRsc) {
        super(imageRsc);
    }

    @Override
    protected String setAbout() {
        return "新建画笔，抗锯齿：Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);\n" +
                "设置画笔宽度：paint.setStrokeWidth(dp2px(2f));\n" +
                "设置样式为中空：paint.setStyle(Paint.Style.STROKE);\n" +
                "画圆：drawCircle\n" +
                "画背景颜色：drawARGB\n" +
                "画横线：drawLine\n" +
                "画矩形：drawRect\n" +
                "DP转PX：TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,px,Resources.getSystem().getDisplayMetrics())";
    }

    @Override
    protected void setView(LinearLayout main) {

    }


    @Override
    public MyView createView() {
        return new MyView(InitApp.getContext());
    }


    static class MyView extends BaseView {

        public MyView(Context context) {
            super(context);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setStrokeWidth(dp2px(2f));
            paint.setStyle(Paint.Style.STROKE);


            Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            circlePaint.setColor(Color.RED);
            circlePaint.setStrokeWidth(dp2px(2f));
            circlePaint.setStyle(Paint.Style.STROKE);
            //画圆
            canvas.drawCircle(getCenterWidth(), getCenterHeight(), dp2px(100f), circlePaint);

            // 画背景颜色
            //canvas.drawARGB(100,79,195,247);

            canvas.drawRect(getCenterWidth() - 100, getCenterHeight() - 100, getCenterWidth() + 100, getCenterHeight() + 100, paint);


            //画横
            canvas.drawLine(getCenterWidth() - 300, getCenterHeight(), getCenterWidth() + 300, getCenterHeight(), paint);

            //画竖
            canvas.drawLine(getCenterWidth(), getCenterHeight() - 300, getCenterWidth(), getCenterHeight() + 300, paint);


            Paint circlePaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
            circlePaint1.setColor(Color.RED);
            circlePaint1.setStyle(Paint.Style.STROKE);
            circlePaint1.setStrokeWidth(dp2px(2f));
            //画圆
            canvas.drawCircle(getCenterWidth(), getCenterHeight(), dp2px(120f), circlePaint1);

        }
    }
}





