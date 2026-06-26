package com.qq.e.comm.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class ResourceUtil {
    public static int getColorId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "color", context.getPackageName());
    }

    public static int getDrawableId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "drawable", context.getPackageName());
    }

    public static int getId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "id", context.getPackageName());
    }

    public static int getLayoutId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "layout", context.getPackageName());
    }

    public static int getStringId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "string", context.getPackageName());
    }

    public static int getStyleId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "style", context.getPackageName());
    }

    public static int getStyleableFieldId(Context context, String str, String str2) {
        int i2;
        String str3 = context.getPackageName() + ".R";
        String strK = c.a.a.a.a.k(str, "_", str2);
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        for (Class<?> cls : Class.forName(str3).getClasses()) {
            if (cls.getSimpleName().equals("styleable")) {
                for (Field field : cls.getFields()) {
                    if (field.getName().equals(strK)) {
                        return ((Integer) field.get(null)).intValue();
                    }
                    return 0;
                }
            }
        }
        return 0;
    }

    public static int[] getStyleableIntArray(Context context, String str) {
        int i2;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        for (Field field : Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
            if (field.getName().equals(str)) {
                return (int[]) field.get(null);
            }
            return null;
        }
        return null;
    }
}
