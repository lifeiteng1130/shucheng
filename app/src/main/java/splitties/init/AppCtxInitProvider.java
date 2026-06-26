package splitties.init;

import android.content.Context;
import androidx.annotation.CallSuper;
import f.c0.c.j;
import k.d.a.h;
import kotlin.Metadata;
import splitties.initprovider.InitProvider;

/* JADX INFO: compiled from: AppCtxInitProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lsplitties/init/AppCtxInitProvider;", "Lsplitties/initprovider/InitProvider;", "", "onCreate", "()Z", "<init>", "()V", "splitties-appctx_release"}, k = 1, mv = {1, 4, 0})
public class AppCtxInitProvider extends InitProvider {
    @Override // android.content.ContentProvider
    @CallSuper
    public boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            j.l();
            throw null;
        }
        j.f(context, "receiver$0");
        if (!h.e(context)) {
            h.f8793c = context;
            return true;
        }
        throw new IllegalArgumentException(("The passed Context(" + context + ") would leak memory!").toString());
    }
}
