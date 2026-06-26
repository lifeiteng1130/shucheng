package com.qq.e.comm.managers.plugin;

import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f2805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2807d;

    public g(File file, File file2) {
        this.a = file;
        this.f2805b = file2;
    }

    public boolean a() {
        try {
            if (this.f2805b.exists() && this.a.exists()) {
                String[] strArrSplit = StringUtil.readAll(this.f2805b).split("#####");
                if (strArrSplit.length == 2) {
                    String str = strArrSplit[1];
                    int integer = StringUtil.parseInteger(strArrSplit[0], 0);
                    com.qq.e.comm.util.a aVarA = com.qq.e.comm.util.a.a();
                    File file = this.a;
                    Objects.requireNonNull(aVarA);
                    if ((file == null || !file.exists()) ? false : aVarA.a(str, Md5Util.encode(file))) {
                        this.f2806c = str;
                        this.f2807d = integer;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable unused) {
            GDTLogger.d("Exception while checking plugin");
            return false;
        }
    }

    public boolean a(File file, File file2) {
        return (file.equals(this.a) || FileUtil.renameTo(this.a, file)) && (file2.equals(this.f2805b) || FileUtil.renameTo(this.f2805b, file2));
    }

    public String b() {
        return this.f2806c;
    }

    public int c() {
        return this.f2807d;
    }
}
