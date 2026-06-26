package c.a.a.a;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import androidx.fragment.app.Fragment;
import androidx.media2.session.IMediaController;
import androidx.recyclerview.widget.RecyclerView;
import c.b.a.m.f;
import com.tencent.bugly.proguard.C0318k;
import com.umeng.commonsdk.debug.UMLogUtils;
import f.c0.c.j;
import f.h0.g;
import java.util.List;

/* JADX INFO: compiled from: outline */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void A(Throwable th, String str, Context context) {
        f.R5(context, j.k(str, th.getLocalizedMessage()));
    }

    public static int B(k.e.a.a aVar, int i2, int i3) {
        return aVar.a() + i2 + i3;
    }

    public static IMediaController C(Parcel parcel, String str) {
        parcel.enforceInterface(str);
        return IMediaController.Stub.asInterface(parcel.readStrongBinder());
    }

    public static C0318k.a D(C0318k c0318k) {
        C0318k.a aVar = new C0318k.a();
        c0318k.a(aVar);
        return aVar;
    }

    public static Object E(List list, int i2) {
        return list.get(list.size() - i2);
    }

    public static String F(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String G(String str, int i2) {
        return str + i2;
    }

    public static float a(float f2, float f3, float f4, float f5) {
        return ((f2 - f3) * f4) + f5;
    }

    public static int b(int i2, int i3, int i4, int i5) {
        return (i2 * i3) + i4 + i5;
    }

    public static String c(String str, int i2, int i3) {
        return str.substring(i3, str.length() - i2);
    }

    public static String d(String str, int i2, String str2) {
        return str + i2 + str2;
    }

    public static String e(String str, int i2, String str2, int i3) {
        return str + i2 + str2 + i3;
    }

    public static String f(String str, long j2) {
        return str + j2;
    }

    public static String g(String str, Uri uri) {
        return str + uri;
    }

    public static String h(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String i(String str, String str2) {
        return str + str2;
    }

    public static String j(String str, String str2, String str3) {
        return new g(str).replace(str2, str3);
    }

    public static String k(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String l(String str, StringBuilder sb) {
        sb.append(UMLogUtils.makeUrl(str));
        return sb.toString();
    }

    public static int m(String str, int i2, int i3) {
        return (str.hashCode() + i2) * i3;
    }

    public static String n(StringBuilder sb, int i2, char c2) {
        sb.append(i2);
        sb.append(c2);
        return sb.toString();
    }

    public static String o(StringBuilder sb, int i2, String str) {
        sb.append(i2);
        sb.append(str);
        return sb.toString();
    }

    public static String p(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder q(char c2) {
        StringBuilder sb = new StringBuilder();
        sb.append(c2);
        return sb;
    }

    public static StringBuilder r(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder s(String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder t(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder u(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void v(String str, Exception exc) {
        String str2 = str + exc;
    }

    public static void w(String str, Throwable th) {
        String str2 = str + th;
    }

    public static int x(String str, String str2, String str3, String str4, String str5, String str6) {
        j.d(str, str2);
        j.d(str3, str4);
        return f.Q0(str5, str6);
    }

    public static void y(StringBuilder sb, String str, char c2, String str2) {
        sb.append(str);
        sb.append(c2);
        sb.append(str2);
    }

    public static void z(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }
}
