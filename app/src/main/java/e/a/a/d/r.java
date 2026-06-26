package e.a.a.d;

import android.content.Context;
import io.legado.app.help.ReadBookConfig;
import io.wenyuange.app.release.R;
import java.util.LinkedHashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadTipConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    @NotNull
    public static final r a = new r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f.e f5555b = c.b.a.m.f.N3(a.INSTANCE);

    /* JADX INFO: compiled from: ReadTipConfig.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<List<? extends String>> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final List<? extends String> invoke() {
            String[] stringArray = k.d.a.h.g().getResources().getStringArray(R.array.read_tip);
            f.c0.c.j.d(stringArray, "appCtx.resources.getStringArray(R.array.read_tip)");
            return c.b.a.m.f.K5(stringArray);
        }
    }

    public final int a() {
        return ReadBookConfig.INSTANCE.getConfig().getFooterMode();
    }

    @NotNull
    public final LinkedHashMap<Integer, String> b(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        String string = context.getString(R.string.show);
        f.c0.c.j.d(string, "context.getString(R.string.show)");
        String string2 = context.getString(R.string.hide);
        f.c0.c.j.d(string2, "context.getString(R.string.hide)");
        return f.x.e.t(new f.g(0, string), new f.g(1, string2));
    }

    public final int c() {
        return ReadBookConfig.INSTANCE.getConfig().getHeaderMode();
    }

    @NotNull
    public final LinkedHashMap<Integer, String> d(@NotNull Context context) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        String string = context.getString(R.string.hide_when_status_bar_show);
        f.c0.c.j.d(string, "context.getString(R.string.hide_when_status_bar_show)");
        String string2 = context.getString(R.string.show);
        f.c0.c.j.d(string2, "context.getString(R.string.show)");
        String string3 = context.getString(R.string.hide);
        f.c0.c.j.d(string3, "context.getString(R.string.hide)");
        return f.x.e.t(new f.g(0, string), new f.g(1, string2), new f.g(2, string3));
    }

    public final int e() {
        return ReadBookConfig.INSTANCE.getConfig().getTipColor();
    }

    public final int f() {
        return ReadBookConfig.INSTANCE.getConfig().getTipFooterLeft();
    }

    public final int g() {
        return ReadBookConfig.INSTANCE.getConfig().getTipFooterMiddle();
    }

    public final int h() {
        return ReadBookConfig.INSTANCE.getConfig().getTipFooterRight();
    }

    public final int i() {
        return ReadBookConfig.INSTANCE.getConfig().getTipHeaderLeft();
    }

    public final int j() {
        return ReadBookConfig.INSTANCE.getConfig().getTipHeaderMiddle();
    }

    public final int k() {
        return ReadBookConfig.INSTANCE.getConfig().getTipHeaderRight();
    }

    @NotNull
    public final List<String> l() {
        return (List) f5555b.getValue();
    }
}
