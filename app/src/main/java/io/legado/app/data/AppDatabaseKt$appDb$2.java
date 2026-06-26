package io.legado.app.data;

import f.c0.b.a;
import f.c0.c.k;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AppDatabase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/legado/app/data/AppDatabase;", "<anonymous>", "()Lio/legado/app/data/AppDatabase;"}, k = 3, mv = {1, 5, 1})
public final class AppDatabaseKt$appDb$2 extends k implements a<AppDatabase> {
    public static final AppDatabaseKt$appDb$2 INSTANCE = new AppDatabaseKt$appDb$2();

    public AppDatabaseKt$appDb$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // f.c0.b.a
    @NotNull
    public final AppDatabase invoke() {
        return AppDatabase.INSTANCE.createDatabase(h.g());
    }
}
