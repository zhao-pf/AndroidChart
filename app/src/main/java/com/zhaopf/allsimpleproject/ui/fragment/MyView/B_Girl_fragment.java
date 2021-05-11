package com.zhaopf.allsimpleproject.ui.fragment.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
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
public class B_Girl_fragment extends BaseFragment {

    public B_Girl_fragment(int imageRsc) {
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

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            float radius = dp2px(100);

            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            Path path = new Path();
            path.addCircle(getCenterWidth(),getCenterHeight(),radius, Path.Direction.CW);
            path.addRect(getCenterWidth()-radius,getCenterHeight(),getCenterWidth()+radius,getCenterHeight()+radius*2, Path.Direction.CW);
            path.setFillType(Path.FillType.EVEN_ODD);

            canvas.drawPath(path,paint);
        }
    }
}





