package com.bytedance.pangle.servermanager;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Keep;
import c.c.a.i;

/* JADX INFO: loaded from: classes.dex */
@Keep
public abstract class AbsServerManager extends ContentProvider {
    public static final String ACTIVITY_QUERY_BINDER = "activity";
    public static final String BUNDLE_BINDER = "binder";
    public static final String METHOD_QUERY_BINDER = "query_binder";
    public static final String PACKAGE_QUERY_BINDER = "package";
    public static final String SERVICE_QUERY_BINDER = "service";

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        IBinder iBinderOnBind;
        if (!METHOD_QUERY_BINDER.equals(str) || (iBinderOnBind = onBind(str2)) == null) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(BUNDLE_BINDER, new a(iBinderOnBind));
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public IBinder onBind(String str) {
        str.hashCode();
        if (!str.equals(PACKAGE_QUERY_BINDER)) {
            if (str.equals("service")) {
                return c.c.a.w.a.a.m();
            }
            return null;
        }
        if (i.c.f756b == null) {
            synchronized (i.c.class) {
                if (i.c.f756b == null) {
                    i.c.f756b = new i.c();
                }
            }
        }
        return i.c.f756b;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
