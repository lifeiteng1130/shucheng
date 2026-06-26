package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;

/* JADX INFO: compiled from: DefaultAlertDialogBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.ss.android.socialbase.appdownloader.c.b {
    private AlertDialog.Builder a;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultAlertDialogBuilder.java */
    public static class C0090a implements k {
        private AlertDialog a;

        public C0090a(AlertDialog.Builder builder) {
            if (builder != null) {
                this.a = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            AlertDialog alertDialog = this.a;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            AlertDialog alertDialog = this.a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }

    public a(Context context) {
        this.a = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(int i2) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setTitle(i2);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l b(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setNegativeButton(i2, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(String str) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setPositiveButton(i2, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public k a() {
        return new C0090a(this.a);
    }
}
