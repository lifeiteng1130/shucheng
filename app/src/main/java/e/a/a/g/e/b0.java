package e.a.a.g.e;

import android.content.DialogInterface;
import io.legado.app.utils.FileUtils;
import java.io.File;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BackupConfigFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ boolean[] $checkedItems;

    /* JADX INFO: compiled from: BackupConfigFragment.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.q<DialogInterface, Integer, Boolean, f.v> {
        public static final a INSTANCE = new a();

        public a() {
            super(3);
        }

        @Override // f.c0.b.q
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface, Integer num, Boolean bool) {
            invoke(dialogInterface, num.intValue(), bool.booleanValue());
            return f.v.a;
        }

        public final void invoke(@NotNull DialogInterface dialogInterface, int i2, boolean z) {
            f.c0.c.j.e(dialogInterface, "$noName_0");
            e.a.a.d.w.q.a.a().put(e.a.a.d.w.q.f5595d[i2], Boolean.valueOf(z));
        }
    }

    /* JADX INFO: compiled from: BackupConfigFragment.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            String json = e.a.a.h.n.a().toJson(e.a.a.d.w.q.a.a());
            File fileB = FileUtils.a.b(e.a.a.d.w.q.f5593b);
            f.c0.c.j.d(json, "json");
            f.b0.d.f(fileB, json, null, 2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(boolean[] zArr) {
        super(1);
        this.$checkedItems = zArr;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        f.c0.c.j.e(hVar, "$this$alert");
        e.a.a.d.w.q qVar = e.a.a.d.w.q.a;
        hVar.n(e.a.a.d.w.q.f5596e, this.$checkedItems, a.INSTANCE);
        hVar.l(b.INSTANCE);
    }
}
