package com.zhaopf.allsimpleproject.ui.fragment.Chart.makerview;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.zhaopf.allsimpleproject.R;


/**
 * @创建者 赵鹏飞
 * @文件介绍 TODO
 * @创建日期 2021/4/25 17:55
 * @Github https://github.com/zhao-pf
 */
public class CustomMakerView extends MarkerView {

    private final TextView mTextView;
    private MPPointF mMpPointF;

    /**
     * Constructor. Sets up the MarkerView with chart_a custom layout resource.
     *
     * @param context
     * @param layoutResource the layout resource to use for the MarkerView
     */
    public CustomMakerView(Context context, int layoutResource) {
        super(context, layoutResource);
        mTextView = findViewById(R.id.tvContent);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        mTextView.setText(e.getY() + "");
        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        if (mMpPointF==null){
            mMpPointF = new MPPointF(-(getWidth() / 2), -getHeight());
        }
        return mMpPointF;
    }
}
