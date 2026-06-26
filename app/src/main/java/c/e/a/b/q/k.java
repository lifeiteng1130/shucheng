package c.e.a.b.q;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements m {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f1127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m f1128d;

    public k(boolean z, boolean z2, boolean z3, m mVar) {
        this.a = z;
        this.f1126b = z2;
        this.f1127c = z3;
        this.f1128d = mVar;
    }

    @Override // c.e.a.b.q.m
    @NonNull
    public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull n nVar) {
        if (this.a) {
            nVar.f1131d = windowInsetsCompat.getSystemWindowInsetBottom() + nVar.f1131d;
        }
        boolean zC3 = c.b.a.m.f.C3(view);
        if (this.f1126b) {
            if (zC3) {
                nVar.f1130c = windowInsetsCompat.getSystemWindowInsetLeft() + nVar.f1130c;
            } else {
                nVar.a = windowInsetsCompat.getSystemWindowInsetLeft() + nVar.a;
            }
        }
        if (this.f1127c) {
            if (zC3) {
                nVar.a = windowInsetsCompat.getSystemWindowInsetRight() + nVar.a;
            } else {
                nVar.f1130c = windowInsetsCompat.getSystemWindowInsetRight() + nVar.f1130c;
            }
        }
        ViewCompat.setPaddingRelative(view, nVar.a, nVar.f1129b, nVar.f1130c, nVar.f1131d);
        m mVar = this.f1128d;
        return mVar != null ? mVar.a(view, windowInsetsCompat, nVar) : windowInsetsCompat;
    }
}
