package com.ss.android.download.api.a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.b;

/* JADX INFO: compiled from: DefaultDownloadUIFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements k {
    @Override // com.ss.android.download.api.config.k
    public void a(int i2, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i3) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.download.api.config.k
    public Dialog b(@NonNull com.ss.android.download.api.model.b bVar) {
        return a(bVar);
    }

    private static Dialog a(final com.ss.android.download.api.model.b bVar) {
        if (bVar == null) {
            return null;
        }
        AlertDialog alertDialogShow = new AlertDialog.Builder(bVar.a).setTitle(bVar.f2904b).setMessage(bVar.f2905c).setPositiveButton(bVar.f2906d, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.a.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                b.InterfaceC0074b interfaceC0074b = bVar.f2910h;
                if (interfaceC0074b != null) {
                    interfaceC0074b.a(dialogInterface);
                }
            }
        }).setNegativeButton(bVar.f2907e, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.a.a.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                b.InterfaceC0074b interfaceC0074b = bVar.f2910h;
                if (interfaceC0074b != null) {
                    interfaceC0074b.b(dialogInterface);
                }
            }
        }).show();
        alertDialogShow.setCanceledOnTouchOutside(bVar.f2908f);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.a.a.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                b.InterfaceC0074b interfaceC0074b = bVar.f2910h;
                if (interfaceC0074b != null) {
                    interfaceC0074b.c(dialogInterface);
                }
            }
        });
        Drawable drawable = bVar.f2909g;
        if (drawable != null) {
            alertDialogShow.setIcon(drawable);
        }
        return alertDialogShow;
    }
}
