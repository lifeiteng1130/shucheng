package e.a.a.e.a;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.v;
import io.legado.app.lib.theme.ATH;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidAlertBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements h<AlertDialog> {

    @NotNull
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final AlertDialog.Builder f5600b;

    public i(@NotNull Context context) {
        j.e(context, "ctx");
        this.a = context;
        this.f5600b = new AlertDialog.Builder(context);
    }

    @Override // e.a.a.e.a.h
    public void a(int i2, @Nullable final l<? super DialogInterface, v> lVar) {
        this.f5600b.setNeutralButton(i2, new DialogInterface.OnClickListener() { // from class: e.a.a.e.a.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                l lVar2 = lVar;
                if (lVar2 == null) {
                    return;
                }
                j.d(dialogInterface, "dialog");
                lVar2.invoke(dialogInterface);
            }
        });
    }

    @Override // e.a.a.e.a.h
    public void b(@NotNull List<? extends CharSequence> list, @NotNull p<? super DialogInterface, ? super Integer, v> pVar) {
        j.e(list, "items");
        j.e(pVar, "onItemSelected");
        AlertDialog.Builder builder = this.f5600b;
        int size = list.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2).toString();
        }
        builder.setItems(strArr, new d(pVar));
    }

    @Override // e.a.a.e.a.h
    public void c(int i2, @Nullable final l<? super DialogInterface, v> lVar) {
        this.f5600b.setPositiveButton(i2, new DialogInterface.OnClickListener() { // from class: e.a.a.e.a.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                l lVar2 = lVar;
                if (lVar2 == null) {
                    return;
                }
                j.d(dialogInterface, "dialog");
                lVar2.invoke(dialogInterface);
            }
        });
    }

    @Override // e.a.a.e.a.h
    public void d(@NotNull f.c0.b.a<? extends View> aVar) {
        j.e(this, "this");
        j.e(aVar, "view");
        o(aVar.invoke());
    }

    @Override // e.a.a.e.a.h
    public void e(int i2, @Nullable final l<? super DialogInterface, v> lVar) {
        this.f5600b.setNegativeButton(i2, new DialogInterface.OnClickListener() { // from class: e.a.a.e.a.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                l lVar2 = lVar;
                if (lVar2 == null) {
                    return;
                }
                j.d(dialogInterface, "dialog");
                lVar2.invoke(dialogInterface);
            }
        });
    }

    @Override // e.a.a.e.a.h
    public void f(@Nullable l<? super DialogInterface, v> lVar) {
        j.e(this, "this");
        e(R.string.cancel, lVar);
    }

    @Override // e.a.a.e.a.h
    public void g(int i2) {
        this.f5600b.setMessage(i2);
    }

    @Override // e.a.a.e.a.h
    public void h(@NotNull CharSequence charSequence) {
        j.e(charSequence, "message");
        this.f5600b.setMessage(charSequence);
    }

    @Override // e.a.a.e.a.h
    public void i(@Nullable l<? super DialogInterface, v> lVar) {
        j.e(this, "this");
        c(io.wenyuange.app.release.R.string.yes, lVar);
    }

    @Override // e.a.a.e.a.h
    public void j(@NotNull final l<? super DialogInterface, v> lVar) {
        j.e(lVar, "handler");
        this.f5600b.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: e.a.a.e.a.g
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                l lVar2 = lVar;
                j.e(lVar2, "$tmp0");
                lVar2.invoke(dialogInterface);
            }
        });
    }

    @Override // e.a.a.e.a.h
    public void k(@Nullable l<? super DialogInterface, v> lVar) {
        j.e(this, "this");
        e(io.wenyuange.app.release.R.string.no, lVar);
    }

    @Override // e.a.a.e.a.h
    public void l(@NotNull final l<? super DialogInterface, v> lVar) {
        j.e(lVar, "handler");
        this.f5600b.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: e.a.a.e.a.e
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                l lVar2 = lVar;
                j.e(lVar2, "$tmp0");
                lVar2.invoke(dialogInterface);
            }
        });
    }

    @Override // e.a.a.e.a.h
    public void m(@Nullable l<? super DialogInterface, v> lVar) {
        j.e(this, "this");
        c(R.string.ok, lVar);
    }

    @Override // e.a.a.e.a.h
    public void n(@NotNull String[] strArr, @NotNull boolean[] zArr, @NotNull final q<? super DialogInterface, ? super Integer, ? super Boolean, v> qVar) {
        j.e(strArr, "items");
        j.e(zArr, "checkedItems");
        j.e(qVar, "onClick");
        this.f5600b.setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: e.a.a.e.a.b
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                q qVar2 = qVar;
                j.e(qVar2, "$onClick");
                j.d(dialogInterface, "dialog");
                qVar2.invoke(dialogInterface, Integer.valueOf(i2), Boolean.valueOf(z));
            }
        });
    }

    public void o(@NotNull View view) {
        j.e(view, "customView");
        this.f5600b.setView(view);
    }

    @NotNull
    public AlertDialog p() {
        AlertDialog alertDialogShow = this.f5600b.show();
        j.d(alertDialogShow, "builder.show()");
        j.e(alertDialogShow, "<this>");
        ATH.a.d(alertDialogShow);
        return alertDialogShow;
    }
}
