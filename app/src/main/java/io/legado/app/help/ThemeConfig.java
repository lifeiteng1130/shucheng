package io.legado.app.help;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.ViewCompat;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.c;
import e.a.a.d.m;
import e.a.a.e.d.b;
import e.a.a.h.g;
import e.a.a.h.n;
import e.a.a.h.y;
import f.b0.d;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import io.legado.app.utils.FileUtils;
import io.wenyuange.app.release.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ThemeConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ThemeConfig {

    @NotNull
    public static final ThemeConfig a = new ThemeConfig();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final String f6899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final e f6900c;

    /* JADX INFO: compiled from: ThemeConfig.kt */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lio/legado/app/help/ThemeConfig$Config;", "", "", "backgroundColor", "Ljava/lang/String;", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "accentColor", "getAccentColor", "setAccentColor", "", "isNightTheme", "Z", "()Z", "setNightTheme", "(Z)V", "primaryColor", "getPrimaryColor", "setPrimaryColor", "bottomBackground", "getBottomBackground", "setBottomBackground", "themeName", "getThemeName", "setThemeName", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Config {

        @NotNull
        private String accentColor;

        @NotNull
        private String backgroundColor;

        @NotNull
        private String bottomBackground;
        private boolean isNightTheme;

        @NotNull
        private String primaryColor;

        @NotNull
        private String themeName;

        public Config(@NotNull String str, boolean z, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            j.e(str, "themeName");
            j.e(str2, "primaryColor");
            j.e(str3, "accentColor");
            j.e(str4, "backgroundColor");
            j.e(str5, "bottomBackground");
            this.themeName = str;
            this.isNightTheme = z;
            this.primaryColor = str2;
            this.accentColor = str3;
            this.backgroundColor = str4;
            this.bottomBackground = str5;
        }

        @NotNull
        public final String getAccentColor() {
            return this.accentColor;
        }

        @NotNull
        public final String getBackgroundColor() {
            return this.backgroundColor;
        }

        @NotNull
        public final String getBottomBackground() {
            return this.bottomBackground;
        }

        @NotNull
        public final String getPrimaryColor() {
            return this.primaryColor;
        }

        @NotNull
        public final String getThemeName() {
            return this.themeName;
        }

        /* JADX INFO: renamed from: isNightTheme, reason: from getter */
        public final boolean getIsNightTheme() {
            return this.isNightTheme;
        }

        public final void setAccentColor(@NotNull String str) {
            j.e(str, "<set-?>");
            this.accentColor = str;
        }

        public final void setBackgroundColor(@NotNull String str) {
            j.e(str, "<set-?>");
            this.backgroundColor = str;
        }

        public final void setBottomBackground(@NotNull String str) {
            j.e(str, "<set-?>");
            this.bottomBackground = str;
        }

        public final void setNightTheme(boolean z) {
            this.isNightTheme = z;
        }

        public final void setPrimaryColor(@NotNull String str) {
            j.e(str, "<set-?>");
            this.primaryColor = str;
        }

        public final void setThemeName(@NotNull String str) {
            j.e(str, "<set-?>");
            this.themeName = str;
        }
    }

    /* JADX INFO: compiled from: ThemeConfig.kt */
    public static final class a extends k implements f.c0.b.a<ArrayList<Config>> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final ArrayList<Config> invoke() {
            List<Config> listE = ThemeConfig.a.e();
            if (listE == null) {
                m mVar = m.a;
                listE = (List) m.f5548e.getValue();
            }
            return new ArrayList<>(listE);
        }
    }

    static {
        File filesDir = h.g().getFilesDir();
        j.d(filesDir, "appCtx.filesDir");
        String[] strArr = {"themeConfig.json"};
        j.e(filesDir, "root");
        j.e(strArr, "subDirFiles");
        StringBuilder sb = new StringBuilder(filesDir.getAbsolutePath());
        for (String str : strArr) {
            if (str.length() > 0) {
                sb.append(File.separator);
                sb.append(str);
            }
        }
        String string = sb.toString();
        j.d(string, "path.toString()");
        f6899b = string;
        f6900c = f.N3(a.INSTANCE);
    }

    public final void a(Config config) {
        int i2 = 0;
        for (Object obj : d()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                f.x.e.D();
                throw null;
            }
            if (j.a(config.getThemeName(), ((Config) obj).getThemeName())) {
                ((ArrayList) f6900c.getValue()).set(i2, config);
                return;
            }
            i2 = i3;
        }
        d().add(config);
        f();
    }

    public final void b(@NotNull Context context) {
        j.e(context, c.R);
        ReadBookConfig.INSTANCE.upBg();
        c(context);
        AppCompatDelegate.setDefaultNightMode(e.a.a.d.e.a.m() ? 2 : 1);
        LiveEventBus.get("RECREATE").post("");
    }

    public final void c(@NotNull Context context) {
        j.e(context, c.R);
        e.a.a.d.e eVar = e.a.a.d.e.a;
        if (e.a.a.d.e.f5519d) {
            j.e(context, c.R);
            b bVar = new b(context, null);
            bVar.e(true);
            bVar.f(-1);
            bVar.a(ViewCompat.MEASURED_STATE_MASK);
            bVar.c(-1);
            bVar.d(-1);
            bVar.b();
            return;
        }
        if (eVar.m()) {
            int iL2 = f.L2(context, "colorPrimaryNight", f.c2(context, R.color.md_blue_A200));
            int iL22 = f.L2(context, "colorAccentNight", f.c2(context, R.color.md_blue_A400));
            int iL23 = f.L2(context, "colorBackgroundNight", f.c2(context, R.color.md_grey_900));
            if (g.b(iL23)) {
                iL23 = f.c2(context, R.color.md_grey_900);
                f.p4(context, "colorBackgroundNight", iL23);
            }
            int iL24 = f.L2(context, "colorBottomBackgroundNight", f.c2(context, R.color.md_grey_850));
            j.e(context, c.R);
            b bVar2 = new b(context, null);
            bVar2.e(true);
            bVar2.f(g.d(iL2, 1.0f));
            bVar2.a(g.d(iL22, 1.0f));
            bVar2.c(g.d(iL23, 1.0f));
            bVar2.d(g.d(iL24, 1.0f));
            bVar2.b();
            return;
        }
        int iL25 = f.L2(context, "colorPrimary", f.c2(context, R.color.md_blue_A200));
        int iL26 = f.L2(context, "colorAccent", f.c2(context, R.color.md_blue_A400));
        int iL27 = f.L2(context, "colorBackground", f.c2(context, R.color.md_grey_100));
        if (!g.b(iL27)) {
            iL27 = f.c2(context, R.color.md_grey_100);
            f.p4(context, "colorBackground", iL27);
        }
        int iL28 = f.L2(context, "colorBottomBackground", f.c2(context, R.color.md_grey_200));
        j.e(context, c.R);
        b bVar3 = new b(context, null);
        bVar3.e(true);
        bVar3.f(g.d(iL25, 1.0f));
        bVar3.a(g.d(iL26, 1.0f));
        bVar3.c(g.d(iL27, 1.0f));
        bVar3.d(g.d(iL28, 1.0f));
        bVar3.b();
    }

    @NotNull
    public final ArrayList<Config> d() {
        return (ArrayList) f6900c.getValue();
    }

    public final List<Config> e() {
        Object objM11constructorimpl;
        File file = new File(f6899b);
        if (file.exists()) {
            try {
                try {
                    Object objFromJson = n.a().fromJson(d.d(file, null, 1), new y(Config.class));
                    objM11constructorimpl = f.h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
                } catch (Throwable th) {
                    objM11constructorimpl = f.h.m11constructorimpl(f.m1(th));
                }
                if (f.h.m16isFailureimpl(objM11constructorimpl)) {
                    objM11constructorimpl = null;
                }
                return (List) objM11constructorimpl;
            } catch (Throwable th2) {
                Throwable thM14exceptionOrNullimpl = f.h.m14exceptionOrNullimpl(f.h.m11constructorimpl(f.m1(th2)));
                if (thM14exceptionOrNullimpl != null) {
                    thM14exceptionOrNullimpl.printStackTrace();
                }
            }
        }
        return null;
    }

    public final void f() {
        String json = n.a().toJson(d());
        FileUtils fileUtils = FileUtils.a;
        String str = f6899b;
        fileUtils.h(str);
        File fileB = fileUtils.b(str);
        j.d(json, "json");
        d.f(fileB, json, null, 2);
    }
}
