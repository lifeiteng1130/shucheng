package e.a.a.d;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import e.a.a.h.x;
import java.io.InputStream;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SourceHelp.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {

    @NotNull
    public static final s a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Handler f5556b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final f.e f5557c = c.b.a.m.f.N3(a.INSTANCE);

    /* JADX INFO: compiled from: SourceHelp.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<String[]> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final String[] invoke() {
            try {
                InputStream inputStreamOpen = k.d.a.h.g().getAssets().open("18PlusList.txt");
                f.c0.c.j.d(inputStreamOpen, "appCtx.assets.open(\"18PlusList.txt\")");
                return c.b.a.m.f.n5(new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a), "\n");
            } catch (Exception unused) {
                return new String[0];
            }
        }
    }

    public static final boolean a(String str) {
        if (str == null) {
            return false;
        }
        x xVar = x.a;
        String strC = x.c(str);
        if (strC == null) {
            return false;
        }
        e eVar = e.a;
        if (e.f5517b) {
            return false;
        }
        try {
            List listF = f.h0.k.F(strC, new String[]{"//", "."}, false, 0, 6);
            String str2 = ((String) listF.get(f.x.e.m(listF) - 1)) + '.' + ((String) f.x.e.r(listF));
            f.c0.c.j.e(str2, "str");
            byte[] bytes = str2.getBytes(f.h0.a.a);
            f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            for (String str3 : (String[]) f5557c.getValue()) {
                if (f.c0.c.j.a(strEncodeToString, str3)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
