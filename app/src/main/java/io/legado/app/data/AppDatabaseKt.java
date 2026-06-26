package io.legado.app.data;

import c.b.a.m.f;
import f.e;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AppDatabase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001d\u0010\u0005\u001a\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lio/legado/app/data/AppDatabase;", "appDb$delegate", "Lf/e;", "getAppDb", "()Lio/legado/app/data/AppDatabase;", "appDb", "app_adsRelease"}, k = 2, mv = {1, 5, 1})
public final class AppDatabaseKt {

    @NotNull
    private static final e appDb$delegate = f.N3(AppDatabaseKt$appDb$2.INSTANCE);

    @NotNull
    public static final AppDatabase getAppDb() {
        return (AppDatabase) appDb$delegate.getValue();
    }
}
