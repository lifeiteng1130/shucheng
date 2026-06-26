package e.a.a.d.v;

import f.v;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends f.c0.c.k implements f.c0.b.l<Throwable, v> {
    public final /* synthetic */ e $webView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar) {
        super(1);
        this.$webView = eVar;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ v invoke(Throwable th) {
        invoke2(th);
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        this.$webView.f5569b.obtainMessage(4);
    }
}
