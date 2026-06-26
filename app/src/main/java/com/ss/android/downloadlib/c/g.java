package com.ss.android.downloadlib.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;

/* JADX INFO: compiled from: NewDownloadDepend.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends com.ss.android.socialbase.appdownloader.c.a {
    private static String a = "g";

    /* JADX INFO: compiled from: NewDownloadDepend.java */
    public static class a implements k {
        private Dialog a;

        public a(Dialog dialog) {
            if (dialog != null) {
                this.a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            Dialog dialog = this.a;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            Dialog dialog = this.a;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public l a(Context context) {
        return new l(context) { // from class: com.ss.android.downloadlib.c.g.1
            public final /* synthetic */ Context a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private b.a f3201c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private DialogInterface.OnClickListener f3202d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private DialogInterface.OnClickListener f3203e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private DialogInterface.OnCancelListener f3204f;

            {
                this.a = context;
                this.f3201c = new b.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i2) {
                this.f3201c.a(this.a.getResources().getString(i2));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l b(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f3201c.d(this.a.getResources().getString(i2));
                this.f3203e = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(String str) {
                this.f3201c.b(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f3201c.c(this.a.getResources().getString(i2));
                this.f3202d = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(DialogInterface.OnCancelListener onCancelListener) {
                this.f3204f = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(boolean z) {
                this.f3201c.a(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public k a() {
                this.f3201c.a(new b.InterfaceC0074b() { // from class: com.ss.android.downloadlib.c.g.1.1
                    @Override // com.ss.android.download.api.model.b.InterfaceC0074b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f3202d != null) {
                            AnonymousClass1.this.f3202d.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC0074b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f3203e != null) {
                            AnonymousClass1.this.f3203e.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC0074b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f3204f == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.f3204f.onCancel(dialogInterface);
                    }
                });
                com.ss.android.downloadlib.g.k.a(g.a, "getThemedAlertDlgBuilder", null);
                this.f3201c.a(3);
                return new a(j.c().b(this.f3201c.a()));
            }
        };
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }
}
