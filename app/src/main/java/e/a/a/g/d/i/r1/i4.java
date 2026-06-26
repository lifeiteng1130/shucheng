package e.a.a.g.d.i.r1;

import android.content.DialogInterface;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.config.TextFontWeightConverter;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextFontWeightConverter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i4 extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
    public final /* synthetic */ TextFontWeightConverter this$0;

    /* JADX INFO: compiled from: TextFontWeightConverter.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.p<DialogInterface, Integer, f.v> {
        public final /* synthetic */ TextFontWeightConverter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TextFontWeightConverter textFontWeightConverter) {
            super(2);
            this.this$0 = textFontWeightConverter;
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface, Integer num) {
            invoke(dialogInterface, num.intValue());
            return f.v.a;
        }

        public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
            f.c0.c.j.e(dialogInterface, "$noName_0");
            ReadBookConfig.INSTANCE.setTextBold(i2);
            TextFontWeightConverter textFontWeightConverter = this.this$0;
            int i3 = TextFontWeightConverter.f7205c;
            textFontWeightConverter.b(i2);
            f.c0.b.a<f.v> aVar = this.this$0.onChanged;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i4(TextFontWeightConverter textFontWeightConverter) {
        super(1);
        this.this$0 = textFontWeightConverter;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
        invoke2(hVar);
        return f.v.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
        f.c0.c.j.e(hVar, "$this$alert");
        String[] stringArray = this.this$0.getContext().getResources().getStringArray(R.array.text_font_weight);
        f.c0.c.j.d(stringArray, "context.resources.getStringArray(R.array.text_font_weight)");
        hVar.b(c.b.a.m.f.K5(stringArray), new a(this.this$0));
    }
}
