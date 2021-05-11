package com.zhaopf.allsimpleproject.ui.fragment.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
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
public class C_Speed_fragment extends BaseFragment {

    public C_Speed_fragment(int imageRsc) {
        super(imageRsc);
    }

    @Override
    protected String setAbout() {
        return "";
    }

    @Override
    protected void setView(LinearLayout main) {

    }


    @Override
    public MyView createView() {
        return new MyView(InitApp.getContext());
    }


    static class MyView extends BaseView {
        private final float DASH_WIDTH;
        private final float DASH_LENGTH;
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        float ANGLE = 120f;
        Path dash = new Path();
        Path path = new Path();
        PathDashPathEffect mDashPathEffect;
        private static int DASH_NUM = 25;

        public MyView(Context context) {
            super(context);
            paint.setStrokeWidth(dp2px(3f));
            paint.setStyle(Paint.Style.STROKE);
            DASH_WIDTH = dp2px(4);
            DASH_LENGTH = dp2px(10);
            dash.addRect(0, 0, DASH_WIDTH, DASH_LENGTH, Path.Direction.CCW);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            path.reset();
            RectF rectF = new RectF(getCenterWidth() - dp2px(180), getCenterHeight() - dp2px(180), getCenterWidth() + dp2px(180), getCenterHeight() + dp2px(180));
            path.addArc(rectF, ANGLE / 2 + 90, 360 - ANGLE);
            PathMeasure pathMeasure = new PathMeasure(path, false);
            float length = pathMeasure.getLength();

            mDashPathEffect=new PathDashPathEffect(dash, (length-DASH_WIDTH)/ DASH_NUM, 0f, PathDashPathEffect.Style.ROTATE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawPath(path, paint);

            paint.setPathEffect(mDashPathEffect);
            canvas.drawPath(path, paint);
            paint.setPathEffect(null);

            canvas.drawLine(getCenterWidth(),getCenterHeight(),100,100,paint);
        }
    }
}





