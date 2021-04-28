package com.zhaopf.allsimpleproject.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.zhaopf.allsimpleproject.MainActivity;

/**
 * @创建者 赵鹏飞
 * @文件介绍 TODO
 * @创建日期 2021/4/22 14:30
 * @Github https://github.com/zhao-pf
 */

@SuppressLint({"AppCompatCustomView", "ViewConstructor"})
public class CustomTextView extends TextView {
    @RequiresApi(api = Build.VERSION_CODES.M)
    public CustomTextView(Context context, String content) {
        super(context);
        setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setPadding(10,10,10,10);
        setGravity(TEXT_ALIGNMENT_CENTER);
        setText(content);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100f,getResources().getDisplayMetrics());
    }
}
