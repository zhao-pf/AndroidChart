package com.zhaopf.allsimpleproject.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Button;

import androidx.annotation.Nullable;

/**
 * @创建者 赵鹏飞
 * @文件介绍 TODO
 * @创建日期 2021/4/22 13:46
 * @Github https://github.com/zhao-pf
 */
@SuppressLint({"AppCompatCustomView", "ViewConstructor"})
public class CustomButton extends Button {
    public CustomButton(Context context, String content) {
        super(context);
        setText(content);
        setAllCaps(false);
    }
}
