package c.b.a;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import c.b.a.b;
import c.b.a.m.q.l;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GlideContext.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends ContextWrapper {

    @VisibleForTesting
    public static final j<?, ?> a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b.a.m.q.c0.b f215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.b.a.q.j.f f217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b.a f218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<c.b.a.q.e<Object>> f219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Class<?>, j<?, ?>> f220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f223j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    public c.b.a.q.f f224k;

    public d(@NonNull Context context, @NonNull c.b.a.m.q.c0.b bVar, @NonNull g gVar, @NonNull c.b.a.q.j.f fVar, @NonNull b.a aVar, @NonNull Map<Class<?>, j<?, ?>> map, @NonNull List<c.b.a.q.e<Object>> list, @NonNull l lVar, @NonNull e eVar, int i2) {
        super(context.getApplicationContext());
        this.f215b = bVar;
        this.f216c = gVar;
        this.f217d = fVar;
        this.f218e = aVar;
        this.f219f = list;
        this.f220g = map;
        this.f221h = lVar;
        this.f222i = eVar;
        this.f223j = i2;
    }
}
