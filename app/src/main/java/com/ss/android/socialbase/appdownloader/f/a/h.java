package com.ss.android.socialbase.appdownloader.f.a;

/* JADX INFO: compiled from: XmlPullParserException.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends Exception {
    public Throwable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3392c;

    public h(String str, g gVar, Throwable th) {
        String string;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        sb.append(str == null ? "" : c.a.a.a.a.i(str, " "));
        if (gVar == null) {
            string = "";
        } else {
            StringBuilder sbR = c.a.a.a.a.r("(position:");
            sbR.append(gVar.d());
            sbR.append(") ");
            string = sbR.toString();
        }
        sb.append(string);
        if (th != null) {
            str2 = "caused by: " + th;
        }
        sb.append(str2);
        super(sb.toString());
        this.f3391b = -1;
        this.f3392c = -1;
        if (gVar != null) {
            this.f3391b = gVar.c();
            this.f3392c = gVar.f();
        }
        this.a = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.a == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            this.a.printStackTrace();
        }
    }
}
