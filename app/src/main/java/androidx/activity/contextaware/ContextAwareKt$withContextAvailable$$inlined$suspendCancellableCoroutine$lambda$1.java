package androidx.activity.contextaware;

import android.content.Context;
import c.b.a.m.f;
import com.umeng.analytics.pro.c;
import f.c0.b.l;
import f.c0.c.j;
import g.b.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"androidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1", "Landroidx/activity/contextaware/OnContextAvailableListener;", "Landroid/content/Context;", c.R, "Lf/v;", "onContextAvailable", "(Landroid/content/Context;)V", "activity-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1 implements OnContextAvailableListener {
    public final /* synthetic */ h $co;
    public final /* synthetic */ l $onContextAvailable$inlined;
    public final /* synthetic */ ContextAware $this_withContextAvailable$inlined;

    public ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1(h hVar, ContextAware contextAware, l lVar) {
        this.$co = hVar;
        this.$this_withContextAvailable$inlined = contextAware;
        this.$onContextAvailable$inlined = lVar;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(@NotNull Context context) {
        Object objM11constructorimpl;
        j.e(context, c.R);
        h hVar = this.$co;
        try {
            objM11constructorimpl = f.h.m11constructorimpl(this.$onContextAvailable$inlined.invoke(context));
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(f.m1(th));
        }
        hVar.resumeWith(objM11constructorimpl);
    }
}
