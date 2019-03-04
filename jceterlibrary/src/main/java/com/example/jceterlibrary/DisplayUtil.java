package com.example.jceterlibrary;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * 一些屏幕相关的工具
 * Created by 陈健宇 at 2018/11/12
 */
public class DisplayUtil {

    /**
     * 获取屏幕宽度
     *
     * @return 屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return windowManager.getDefaultDisplay().getWidth();
    }

    /**
     * 获取屏幕高度
     *
     * @return 屏幕高度
     */
    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return windowManager.getDefaultDisplay().getHeight();
    }

    /**
     * 获取系统状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

    /**
     * 改变背景透明度
     */
    public static void changeBackgoundAlpha(float alpha, Window window) {
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = alpha;
        window.setAttributes(lp);
    }

    /**
     * 获取控件的位置
     */
    public int[] getViewLocation(View view) {
        int[] location = new int[2]; //获取筛选按钮的x坐标
        view.getLocationOnScreen(location);
        return location;
    }

    /**
     * 将px转换为dip或dp，保证尺寸大小不变
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;//换算比例
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp转换为px，保证尺寸大小不变
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;//尺寸换算比例
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px转换为sp，保证文字大小不变
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;//文字尺寸换算比例
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp转换为px，保证文字大小不变
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int getScreenWidthPx(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        // float density = dm.density; // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        // int densityDPI = dm.densityDpi; // 屏幕密度（每寸像素：120/160/240/320）
        // float xdpi = dm.xdpi;
        // float ydpi = dm.ydpi;
        return dm.widthPixels; // 屏幕宽（像素，如：480px）
        // screenHeight = dm.heightPixels; // 屏幕高（像素，如：800px）
    }

    public static int getScreenHeightPx(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public static int dip2pxUniformScale720(Context context, float dpValue){
        int screenWidth = getScreenWidthPx(context);
        float realDpValue = dpValue;
        if(screenWidth > 0){
            realDpValue = dpValue * screenWidth/720;
        }
        return dip2px(context, realDpValue);
    }
}
