package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: compiled from: DownloadAlertDialogInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f2909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InterfaceC0074b f2910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f2911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2912j;

    /* JADX INFO: compiled from: DownloadAlertDialogInfo.java */
    public static final class a {
        public View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Context f2914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f2915d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f2916e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f2917f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f2918g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f2919h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Drawable f2920i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private InterfaceC0074b f2921j;

        public a(Context context) {
            this.f2914c = context;
        }

        public a a(String str) {
            this.f2915d = str;
            return this;
        }

        public a b(String str) {
            this.f2916e = str;
            return this;
        }

        public a c(String str) {
            this.f2917f = str;
            return this;
        }

        public a d(String str) {
            this.f2918g = str;
            return this;
        }

        public a a(boolean z) {
            this.f2919h = z;
            return this;
        }

        public a a(Drawable drawable) {
            this.f2920i = drawable;
            return this;
        }

        public a a(InterfaceC0074b interfaceC0074b) {
            this.f2921j = interfaceC0074b;
            return this;
        }

        public a a(int i2) {
            this.f2913b = i2;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.download.api.model.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadAlertDialogInfo.java */
    public interface InterfaceC0074b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    private b(a aVar) {
        this.f2908f = true;
        this.a = aVar.f2914c;
        this.f2904b = aVar.f2915d;
        this.f2905c = aVar.f2916e;
        this.f2906d = aVar.f2917f;
        this.f2907e = aVar.f2918g;
        this.f2908f = aVar.f2919h;
        this.f2909g = aVar.f2920i;
        this.f2910h = aVar.f2921j;
        this.f2911i = aVar.a;
        this.f2912j = aVar.f2913b;
    }
}
