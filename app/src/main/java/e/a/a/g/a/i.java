package e.a.a.g.a;

import android.content.DialogInterface;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.v;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.ui.about.ReadRecordActivity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadRecordActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends k implements l<e.a.a.e.a.h<? extends DialogInterface>, v> {
    public final /* synthetic */ ReadRecordActivity this$0;

    /* JADX INFO: compiled from: ReadRecordActivity.kt */
    public static final class a extends k implements l<DialogInterface, v> {
        public final /* synthetic */ ReadRecordActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ReadRecordActivity readRecordActivity) {
            super(1);
            this.this$0 = readRecordActivity;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            j.e(dialogInterface, "it");
            AppDatabaseKt.getAppDb().getReadRecordDao().clear();
            ReadRecordActivity readRecordActivity = this.this$0;
            int i2 = ReadRecordActivity.f6976g;
            readRecordActivity.U0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ReadRecordActivity readRecordActivity) {
        super(1);
        this.this$0 = readRecordActivity;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        j.e(hVar, "$this$alert");
        hVar.m(new a(this.this$0));
        c.b.a.m.f.d4(hVar, null, 1, null);
    }
}
