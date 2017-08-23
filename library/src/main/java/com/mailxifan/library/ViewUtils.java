package com.mailxifan.library;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhangqilin
 * email:mailxifan@126.com
 * date:2017/8/23
 * 视图工具类
 */

public class ViewUtils {
    /**
     * 设置视图的高度
     *
     * @param v
     * @param height
     */
    public static void setViewHeight(View v, int height) {
        ViewGroup.LayoutParams P = v.getLayoutParams();
        P.height = height;
        v.setLayoutParams(P);
    }

    /**
     * 设置视图的宽度
     *
     * @param v
     * @param width
     */
    public static void setViewWidth(View v, int width) {
        ViewGroup.LayoutParams P = v.getLayoutParams();
        P.width = width;
        v.setLayoutParams(P);
    }

    /**
     * 设置视图的宽高
     *
     * @param v
     * @param width
     * @param height
     */
    public static void setViewWidthHeight(View v, int width, int height) {
        ViewGroup.LayoutParams P = v.getLayoutParams();
        P.width = width;
        P.height = height;
        v.setLayoutParams(P);
    }

    /**
     * 通过倍率设置视图
     *
     * @param activity
     * @param v
     * @param HRatio 如：1920/120 （1920设计图高度除以实际图120的高度）
     * @param WRatio 如同上
     */
    public static void setRatioView(Activity activity, View v, double HRatio,
                                    double WRatio) {

        DisplayMetrics metric = getDisplayMetri(activity);
        int width = metric.widthPixels; // 屏幕宽度（像素）
        int height = metric.heightPixels; // 屏幕高度（像素）

        int h = (int) (height / HRatio);
        int w = (int) (width / WRatio);
        ViewGroup.LayoutParams P = v.getLayoutParams();
        P.height = h;
        P.width = w;
        v.setLayoutParams(P);
    }

    /**
     * 获取屏幕
     *
     * @param activity
     * @return
     */
    public static DisplayMetrics getDisplayMetri(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric;
    }

    /**
     * 获取视图的高的倍率
     *
     * @param activity
     * @param height
     * @return
     */
    public static double getHeigtRatio(Activity activity, int height) {
        DisplayMetrics metric = getDisplayMetri(activity);
        int h = metric.heightPixels;
        return h / height;
    }

    /**
     * 获取视图的宽的倍率
     *
     * @param activity
     * @param width
     * @return
     */
    public static double getWidthRatio(Activity activity, int width) {
        DisplayMetrics metric = getDisplayMetri(activity);
        int w = metric.widthPixels;
        return w / width;
    }
}
