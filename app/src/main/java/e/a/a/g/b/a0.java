package e.a.a.g.b;

import android.content.DialogInterface;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.ReplaceRuleDao;
import io.legado.app.data.entities.ReplaceRule;
import io.legado.app.ui.association.ImportReplaceRuleActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImportReplaceRuleActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ ArrayList<ReplaceRule> $allSource;
    public final /* synthetic */ ImportReplaceRuleActivity this$0;

    /* JADX INFO: compiled from: ImportReplaceRuleActivity.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ ArrayList<ReplaceRule> $allSource;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ArrayList<ReplaceRule> arrayList) {
            super(1);
            this.$allSource = arrayList;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            ReplaceRuleDao replaceRuleDao = AppDatabaseKt.getAppDb().getReplaceRuleDao();
            Object[] array = this.$allSource.toArray(new ReplaceRule[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            ReplaceRule[] replaceRuleArr = (ReplaceRule[]) array;
            replaceRuleDao.insert((ReplaceRule[]) Arrays.copyOf(replaceRuleArr, replaceRuleArr.length));
        }
    }

    /* JADX INFO: compiled from: ImportReplaceRuleActivity.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, f.v> {
        public final /* synthetic */ ImportReplaceRuleActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImportReplaceRuleActivity importReplaceRuleActivity) {
            super(1);
            this.this$0 = importReplaceRuleActivity;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
            invoke2(dialogInterface);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DialogInterface dialogInterface) {
            f.c0.c.j.e(dialogInterface, "it");
            this.this$0.finish();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(ArrayList<ReplaceRule> arrayList, ImportReplaceRuleActivity importReplaceRuleActivity) {
        super(1);
        this.$allSource = arrayList;
        this.this$0 = importReplaceRuleActivity;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        f.c0.c.j.e(hVar, "$this$alert");
        hVar.m(new a(this.$allSource));
        c.b.a.m.f.d4(hVar, null, 1, null);
        hVar.l(new b(this.this$0));
    }
}
