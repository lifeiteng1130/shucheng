package com.ifmvo.togetherad.core.utils;
import android.app.Activity;
import android.util.DisplayMetrics;
public class ScreenUtil {
    public static final ScreenUtil INSTANCE = new ScreenUtil();
    public int getDisplayMetricsWidth(Activity a) { return 1080; }
    public int getDisplayMetricsHeight(Activity a) { return 1920; }
}
