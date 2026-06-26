package e.a.a.g.m.n;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.NumberPicker;
import androidx.appcompat.app.AlertDialog;
import c.b.a.m.f;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import io.legado.app.lib.theme.ATH;
import io.wenyuange.app.release.R;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NumberPickerDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    @NotNull
    public final AlertDialog.Builder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public NumberPicker f5937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public Integer f5938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public Integer f5939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public Integer f5940e;

    public c(@NotNull Context context) {
        j.e(context, com.umeng.analytics.pro.c.R);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        this.a = builder;
        builder.setView(R.layout.dialog_number_picker);
    }

    @NotNull
    public final c a(int i2) {
        this.f5938c = Integer.valueOf(i2);
        return this;
    }

    @NotNull
    public final c b(int i2) {
        this.f5939d = Integer.valueOf(i2);
        return this;
    }

    @NotNull
    public final c c(@NotNull String str) {
        j.e(str, "title");
        this.a.setTitle(str);
        return this;
    }

    @NotNull
    public final c d(int i2) {
        this.f5940e = Integer.valueOf(i2);
        return this;
    }

    public final void e(@Nullable final l<? super Integer, v> lVar) {
        this.a.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: e.a.a.g.m.n.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                c cVar = this.a;
                l lVar2 = lVar;
                j.e(cVar, "this$0");
                NumberPicker numberPicker = cVar.f5937b;
                if (numberPicker == null) {
                    return;
                }
                numberPicker.clearFocus();
                f.h3(numberPicker);
                if (lVar2 == null) {
                    return;
                }
                lVar2.invoke(Integer.valueOf(numberPicker.getValue()));
            }
        });
        this.a.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogShow = this.a.show();
        j.d(alertDialogShow, "builder.show()");
        j.e(alertDialogShow, "<this>");
        ATH.a.d(alertDialogShow);
        NumberPicker numberPicker = (NumberPicker) alertDialogShow.findViewById(R.id.number_picker);
        this.f5937b = numberPicker;
        if (numberPicker == null) {
            return;
        }
        Integer num = this.f5939d;
        if (num != null) {
            numberPicker.setMinValue(num.intValue());
        }
        Integer num2 = this.f5938c;
        if (num2 != null) {
            numberPicker.setMaxValue(num2.intValue());
        }
        Integer num3 = this.f5940e;
        if (num3 == null) {
            return;
        }
        numberPicker.setValue(num3.intValue());
    }
}
