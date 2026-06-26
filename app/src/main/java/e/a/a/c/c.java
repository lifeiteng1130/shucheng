package e.a.a.c;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import f.c0.c.k;
import io.wenyuange.app.release.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import org.antlr.v4.runtime.tree.xpath.XPath;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.helper.DataUtil;
import org.slf4j.Marker;

/* JADX INFO: compiled from: AppConst.kt */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"SimpleDateFormat"})
public final class c {

    @NotNull
    public static final c a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f.e f5496b = c.b.a.m.f.N3(b.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final f.e f5497c = c.b.a.m.f.N3(i.INSTANCE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final f.e f5498d = c.b.a.m.f.N3(f.INSTANCE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final f.e f5499e = c.b.a.m.f.N3(g.INSTANCE);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final f.e f5500f = c.b.a.m.f.N3(h.INSTANCE);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final f.e f5501g = c.b.a.m.f.N3(j.INSTANCE);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final String[] f5502h = {"com.android.internal.view.menu.ListMenuItemView", "androidx.appcompat.view.menu.ListMenuItemView"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5503i = (int) k.d.a.h.g().getResources().getDimension(R.dimen.design_appbar_elevation);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public static final f.e f5504j = c.b.a.m.f.N3(e.INSTANCE);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public static final f.e f5505k = c.b.a.m.f.N3(C0146c.INSTANCE);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public static final f.e f5506l = c.b.a.m.f.N3(d.INSTANCE);

    @NotNull
    public static final ArrayList<String> m = f.x.e.a(DataUtil.defaultCharset, "GB2312", "GB18030", "GBK", "Unicode", "UTF-16", "UTF-16LE", "ASCII");

    /* JADX INFO: compiled from: AppConst.kt */
    public static final class a {
        public long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public String f5507b;

        public a() {
            this(0L, null, 3);
        }

        public a(long j2, String str, int i2) {
            j2 = (i2 & 1) != 0 ? 0L : j2;
            String str2 = (i2 & 2) != 0 ? "" : null;
            f.c0.c.j.e(str2, "versionName");
            this.a = j2;
            this.f5507b = str2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && f.c0.c.j.a(this.f5507b, aVar.f5507b);
        }

        public int hashCode() {
            return this.f5507b.hashCode() + (e.a.a.c.b.a(this.a) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("AppInfo(versionCode=");
            sbR.append(this.a);
            sbR.append(", versionName=");
            sbR.append(this.f5507b);
            sbR.append(')');
            return sbR.toString();
        }
    }

    /* JADX INFO: compiled from: AppConst.kt */
    public static final class b extends k implements f.c0.b.a<ScriptEngine> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        @Override // f.c0.b.a
        public final ScriptEngine invoke() {
            return new ScriptEngineManager().getEngineByName("rhino");
        }
    }

    /* JADX INFO: renamed from: e.a.a.c.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppConst.kt */
    public static final class C0146c extends k implements f.c0.b.a<String> {
        public static final C0146c INSTANCE = new C0146c();

        public C0146c() {
            super(0);
        }

        @Override // f.c0.b.a
        public final String invoke() {
            return Settings.System.getString(k.d.a.h.g().getContentResolver(), "android_id");
        }
    }

    /* JADX INFO: compiled from: AppConst.kt */
    public static final class d extends k implements f.c0.b.a<a> {
        public static final d INSTANCE = new d();

        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final a invoke() throws PackageManager.NameNotFoundException {
            a aVar = new a(0L, null, 3);
            PackageInfo packageInfo = k.d.a.h.g().getPackageManager().getPackageInfo(k.d.a.h.g().getPackageName(), 0);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                f.c0.c.j.d(str, "it.versionName");
                f.c0.c.j.e(str, "<set-?>");
                aVar.f5507b = str;
                if (Build.VERSION.SDK_INT >= 28) {
                    aVar.a = packageInfo.getLongVersionCode();
                } else {
                    aVar.a = packageInfo.versionCode;
                }
            }
            return aVar;
        }
    }

    /* JADX INFO: compiled from: AppConst.kt */
    public static final class e extends k implements f.c0.b.a<String> {
        public static final e INSTANCE = new e();

        public e() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final String invoke() {
            return "document.body.style.backgroundColor = \"#222222\";\ndocument.getElementsByTagName('body')[0].style.webkitTextFillColor = '#8a8a8a';";
        }
    }

    /* JADX INFO: compiled from: AppConst.kt */
    public static final class f extends k implements f.c0.b.a<SimpleDateFormat> {
        public static final f INSTANCE = new f();

        public f() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final SimpleDateFormat invoke() {
            return new SimpleDateFormat("yyyy/MM/dd HH:mm");
        }
    }

    /* JADX INFO: compiled from: AppConst.kt */
    public static final class g extends k implements f.c0.b.a<SimpleDateFormat> {
        public static final g INSTANCE = new g();

        public g() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final SimpleDateFormat invoke() {
            return new SimpleDateFormat("yy-MM-dd-HH-mm-ss");
        }
    }

    /* JADX INFO: compiled from: AppConst.kt */
    public static final class h extends k implements f.c0.b.a<ArrayList<String>> {
        public static final h INSTANCE = new h();

        public h() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final ArrayList<String> invoke() {
            return f.x.e.a("❓", "@css:", "<js></js>", "{{}}", "&&", "%%", "||", "//", "$.", "@", "\\", ":", "class", "id", "href", "textNodes", "ownText", "all", "html", "[", "]", "<", ">", "#", XPath.NOT, ".", Marker.ANY_NON_NULL_MARKER, "-", "*", "=");
        }
    }

    /* JADX INFO: compiled from: AppConst.kt */
    public static final class i extends k implements f.c0.b.a<SimpleDateFormat> {
        public static final i INSTANCE = new i();

        public i() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final SimpleDateFormat invoke() {
            return new SimpleDateFormat("HH:mm");
        }
    }

    /* JADX INFO: compiled from: AppConst.kt */
    public static final class j extends k implements f.c0.b.a<String> {
        public static final j INSTANCE = new j();

        public j() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final String invoke() {
            return ",{\n\"charset\": \"\",\n\"method\": \"POST\",\n\"body\": \"\",\n\"headers\": {\"User-Agent\": \"\"}\n}";
        }
    }

    @NotNull
    public static final a a() {
        return (a) f5506l.getValue();
    }

    @NotNull
    public static final List<String> b() {
        return (List) f5500f.getValue();
    }

    @NotNull
    public static final ScriptEngine c() {
        Object value = f5496b.getValue();
        f.c0.c.j.d(value, "<get-SCRIPT_ENGINE>(...)");
        return (ScriptEngine) value;
    }
}
