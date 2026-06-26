package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.ai;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.File;

/* JADX INFO: compiled from: OldUMIDTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends a {
    private static final String a = "oldumid";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5310d;

    public j(Context context) {
        super(a);
        this.f5309c = null;
        this.f5310d = null;
        this.f5308b = context;
    }

    private void b(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private void j() {
        try {
            b("/data/local/tmp/.um");
            HelperUtils.writeFile(new File("/data/local/tmp/.um/sysid.dat"), this.f5310d);
        } catch (Throwable unused) {
        }
    }

    private void k() {
        try {
            b("/sdcard/Android/obj/.um");
            HelperUtils.writeFile(new File("/sdcard/Android/obj/.um/sysid.dat"), this.f5310d);
        } catch (Throwable unused) {
        }
    }

    private void l() {
        try {
            b("/sdcard/Android/data/.um");
            HelperUtils.writeFile(new File("/sdcard/Android/data/.um/sysid.dat"), this.f5310d);
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return this.f5309c;
    }

    public boolean g() {
        return h();
    }

    public boolean h() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f5308b, ai.f4653g, null);
        this.f5310d = strImprintProperty;
        if (TextUtils.isEmpty(strImprintProperty)) {
            return false;
        }
        this.f5310d = DataHelper.encryptBySHA1(this.f5310d);
        String file = HelperUtils.readFile(new File("/sdcard/Android/data/.um/sysid.dat"));
        String file2 = HelperUtils.readFile(new File("/sdcard/Android/obj/.um/sysid.dat"));
        String file3 = HelperUtils.readFile(new File("/data/local/tmp/.um/sysid.dat"));
        if (TextUtils.isEmpty(file)) {
            l();
        } else if (!this.f5310d.equals(file)) {
            this.f5309c = file;
            return true;
        }
        if (TextUtils.isEmpty(file2)) {
            k();
        } else if (!this.f5310d.equals(file2)) {
            this.f5309c = file2;
            return true;
        }
        if (TextUtils.isEmpty(file3)) {
            j();
            return false;
        }
        if (this.f5310d.equals(file3)) {
            return false;
        }
        this.f5309c = file3;
        return true;
    }

    public void i() {
        try {
            l();
            k();
            j();
        } catch (Exception unused) {
        }
    }
}
