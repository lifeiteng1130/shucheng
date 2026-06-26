package e.a.a.e.a;

import android.content.DialogInterface;
import f.c0.b.p;
import f.c0.c.j;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ p a;

    public /* synthetic */ d(p pVar) {
        this.a = pVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        p pVar = this.a;
        j.e(pVar, "$onItemSelected");
        j.d(dialogInterface, "dialog");
        pVar.invoke(dialogInterface, Integer.valueOf(i2));
    }
}
