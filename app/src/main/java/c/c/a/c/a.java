package c.c.a.c;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class a implements View.OnClickListener {
    public final Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Method f689d;

    public a(@NonNull Activity activity, int i2, @NonNull String str) {
        this.a = activity;
        this.f687b = str;
        this.f688c = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(@NonNull View view) {
        if (this.f689d == null) {
            try {
                Method method = this.a.getClass().getMethod(this.f687b, View.class);
                if (method != null) {
                    this.f689d = method;
                }
            } catch (NoSuchMethodException unused) {
            }
            throw new IllegalStateException("Could not find method " + this.f687b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f688c);
        }
        try {
            this.f689d.invoke(this.a, view);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
        } catch (InvocationTargetException e3) {
            throw new IllegalStateException("Could not execute method for android:onClick", e3);
        }
    }
}
