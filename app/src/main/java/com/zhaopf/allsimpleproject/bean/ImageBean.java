package com.zhaopf.allsimpleproject.bean;

import com.zhaopf.allsimpleproject.base.BaseFragment;

/**
 * @创建者 赵鹏飞
 * @文件介绍 TODO
 * @创建日期 2021/4/21 20:15
 * @Github https://github.com/zhao-pf
 */
public class ImageBean {
    private int imageRes;
    private String name;
    private BaseFragment fragment;

    public ImageBean( BaseFragment fragment,String name) {
        this.imageRes = fragment.getImageRsc();
        this.name = name.replace(" ","\n");
        this.fragment = fragment;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseFragment getFragment() {
        return fragment;
    }

    public void setFragment(BaseFragment fragment) {
        this.fragment = fragment;
    }
}
