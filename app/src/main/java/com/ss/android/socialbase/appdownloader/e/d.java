package com.ss.android.socialbase.appdownloader.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.socialbase.appdownloader.c.n;
import com.ss.android.socialbase.appdownloader.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: NotificationPermissionHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<n> f3360b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.ss.android.socialbase.appdownloader.view.a f3361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AlertDialog f3362d;

    public static void b(@NonNull Activity activity, @NonNull n nVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = a;
                    com.ss.android.socialbase.appdownloader.view.a aVar = (com.ss.android.socialbase.appdownloader.view.a) fragmentManager.findFragmentByTag(str);
                    f3361c = aVar;
                    if (aVar == null) {
                        f3361c = new com.ss.android.socialbase.appdownloader.view.a();
                        fragmentManager.beginTransaction().add(f3361c, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    f3361c.a();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                    nVar.a();
                    return;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return;
                }
            }
        }
        nVar.a();
    }

    public static boolean a() {
        try {
            return NotificationManagerCompat.from(com.ss.android.socialbase.downloader.downloader.c.N()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static synchronized void a(boolean z) {
        try {
            AlertDialog alertDialog = f3362d;
            if (alertDialog != null) {
                alertDialog.cancel();
                f3362d = null;
            }
            for (n nVar : f3360b) {
                if (nVar != null) {
                    if (z) {
                        nVar.a();
                    } else {
                        nVar.b();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized void a(@NonNull final Activity activity, @NonNull final n nVar) {
        if (nVar == null) {
            return;
        }
        if (activity != null) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
                a(false);
            }
            if (!activity.isFinishing()) {
                int iA = i.a(com.ss.android.socialbase.downloader.downloader.c.N(), "tt_appdownloader_notification_request_title");
                int iA2 = i.a(com.ss.android.socialbase.downloader.downloader.c.N(), "tt_appdownloader_notification_request_message");
                int iA3 = i.a(com.ss.android.socialbase.downloader.downloader.c.N(), "tt_appdownloader_notification_request_btn_yes");
                int iA4 = i.a(com.ss.android.socialbase.downloader.downloader.c.N(), "tt_appdownloader_notification_request_btn_no");
                f3360b.add(nVar);
                AlertDialog alertDialog = f3362d;
                if (alertDialog == null || !alertDialog.isShowing()) {
                    f3362d = new AlertDialog.Builder(activity).setTitle(iA).setMessage(iA2).setPositiveButton(iA3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.b(activity, nVar);
                            dialogInterface.cancel();
                            AlertDialog unused = d.f3362d = null;
                        }
                    }).setNegativeButton(iA4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            d.a(false);
                        }
                    }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.e.d.1
                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                            if (i2 != 4) {
                                return false;
                            }
                            if (keyEvent.getAction() == 1) {
                                d.a(false);
                            }
                            return true;
                        }
                    }).setCancelable(false).show();
                }
                return;
            }
        }
        nVar.b();
    }
}
