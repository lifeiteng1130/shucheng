package e.b.a.r.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ai;
import e.b.a.n;
import e.b.a.p.q;
import java.util.Collection;
import java.util.Collections;
import k.c.d.o;

/* JADX INFO: compiled from: LinkHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends h {
    @Override // e.b.a.r.l
    @NonNull
    public Collection<String> b() {
        return Collections.singleton(ai.at);
    }

    @Override // e.b.a.r.p.h
    @Nullable
    public Object d(@NonNull e.b.a.e eVar, @NonNull e.b.a.m mVar, @NonNull e.b.a.r.e eVar2) {
        n nVar;
        String str = eVar2.d().get("href");
        if (TextUtils.isEmpty(str) || (nVar = ((e.b.a.h) eVar.f5974g).a.get(o.class)) == null) {
            return null;
        }
        q.f5994e.b(mVar, str);
        return nVar.a(eVar, mVar);
    }
}
