package com.ifmvo.togetherad.core.utils;

import android.content.Context;
import android.content.res.Resources;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ScreenUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/ifmvo/togetherad/core/utils/ScreenUtil;", "", "Landroid/content/Context;", c.R, "", "getDisplayMetricsWidth", "(Landroid/content/Context;)I", "getDisplayMetricsHeight", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
public final class ScreenUtil {
    public static final ScreenUtil INSTANCE = new ScreenUtil();

    private ScreenUtil() {
    }

    public final int getDisplayMetricsHeight(@NotNull Context context) {
        j.f(context, c.R);
        Context applicationContext = context.getApplicationContext();
        j.b(applicationContext, "context.applicationContext");
        Resources resources = applicationContext.getResources();
        j.b(resources, "context.applicationContext.resources");
        return resources.getDisplayMetrics().heightPixels;
    }

    public final int getDisplayMetricsWidth(@NotNull Context context) {
        j.f(context, c.R);
        Context applicationContext = context.getApplicationContext();
        j.b(applicationContext, "context.applicationContext");
        Resources resources = applicationContext.getResources();
        j.b(resources, "context.applicationContext.resources");
        return resources.getDisplayMetrics().widthPixels;
    }
}
