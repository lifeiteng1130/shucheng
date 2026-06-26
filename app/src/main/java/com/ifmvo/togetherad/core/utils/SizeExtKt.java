package com.ifmvo.togetherad.core.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SizeExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u001a\u001f\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\t\"\u0017\u0010\u0007\u001a\u00020\u0004*\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/content/Context;", c.R, "", "px", "", "px2dp", "(Landroid/content/Context;I)F", "dp", "dpToPx", "(Landroid/content/Context;I)I", "getDp", "(F)F", "core_release"}, k = 2, mv = {1, 4, 0})
public final class SizeExtKt {
    public static final int dpToPx(@NotNull Context context, int i2) {
        j.f(context, c.R);
        Context applicationContext = context.getApplicationContext();
        j.b(applicationContext, "context.applicationContext");
        Resources resources = applicationContext.getResources();
        j.b(resources, "context.applicationContext.resources");
        return (int) TypedValue.applyDimension(1, i2, resources.getDisplayMetrics());
    }

    public static final float getDp(float f2) {
        Resources system = Resources.getSystem();
        j.b(system, "Resources.getSystem()");
        return TypedValue.applyDimension(1, f2, system.getDisplayMetrics());
    }

    public static final float px2dp(@NotNull Context context, int i2) {
        j.f(context, c.R);
        Context applicationContext = context.getApplicationContext();
        j.b(applicationContext, "context.applicationContext");
        Resources resources = applicationContext.getResources();
        j.b(resources, "context.applicationContext.resources");
        return (i2 / resources.getDisplayMetrics().density) + 0.5f;
    }
}
