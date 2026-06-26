package e.a.a.d;

import android.content.res.AssetManager;
import e.a.a.h.y;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.HttpTTSDao;
import io.legado.app.data.dao.RssSourceDao;
import io.legado.app.data.dao.TxtTocRuleDao;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.HttpTTS;
import io.legado.app.data.entities.RssSource;
import io.legado.app.data.entities.TxtTocRule;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.help.ThemeConfig;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    @NotNull
    public static final m a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f.e f5545b = c.b.a.m.f.N3(b.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final f.e f5546c = c.b.a.m.f.N3(c.INSTANCE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final f.e f5547d = c.b.a.m.f.N3(f.INSTANCE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final f.e f5548e = c.b.a.m.f.N3(e.INSTANCE);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final f.e f5549f = c.b.a.m.f.N3(d.INSTANCE);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final f.e f5550g = c.b.a.m.f.N3(a.INSTANCE);

    /* JADX INFO: compiled from: DefaultData.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<List<? extends BookSource>> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final List<? extends BookSource> invoke() throws IOException {
            Object objM11constructorimpl;
            AssetManager assets = k.d.a.h.g().getAssets();
            StringBuilder sbR = c.a.a.a.a.r("defaultData");
            sbR.append((Object) File.separator);
            sbR.append("dataSource.json");
            InputStream inputStreamOpen = assets.open(sbR.toString());
            f.c0.c.j.d(inputStreamOpen, "appCtx.assets.open(\"defaultData${File.separator}$dataSourceFileName\")");
            try {
                Object objFromJson = e.a.a.h.n.a().fromJson(new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a), new y(BookSource.class));
                objM11constructorimpl = f.h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
            } catch (Throwable th) {
                objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            List<? extends BookSource> list = (List) (f.h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
            f.c0.c.j.c(list);
            return list;
        }
    }

    /* JADX INFO: compiled from: DefaultData.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.a<List<? extends HttpTTS>> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final List<? extends HttpTTS> invoke() throws IOException {
            Object objM11constructorimpl;
            AssetManager assets = k.d.a.h.g().getAssets();
            StringBuilder sbR = c.a.a.a.a.r("defaultData");
            sbR.append((Object) File.separator);
            sbR.append("httpTTS.json");
            InputStream inputStreamOpen = assets.open(sbR.toString());
            f.c0.c.j.d(inputStreamOpen, "appCtx.assets.open(\"defaultData${File.separator}$httpTtsFileName\")");
            try {
                Object objFromJson = e.a.a.h.n.a().fromJson(new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a), new y(HttpTTS.class));
                objM11constructorimpl = f.h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
            } catch (Throwable th) {
                objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            List<? extends HttpTTS> list = (List) (f.h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
            f.c0.c.j.c(list);
            return list;
        }
    }

    /* JADX INFO: compiled from: DefaultData.kt */
    public static final class c extends f.c0.c.k implements f.c0.b.a<List<? extends ReadBookConfig.Config>> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final List<? extends ReadBookConfig.Config> invoke() throws IOException {
            Object objM11constructorimpl;
            AssetManager assets = k.d.a.h.g().getAssets();
            StringBuilder sbR = c.a.a.a.a.r("defaultData");
            sbR.append((Object) File.separator);
            sbR.append(ReadBookConfig.configFileName);
            InputStream inputStreamOpen = assets.open(sbR.toString());
            f.c0.c.j.d(inputStreamOpen, "appCtx.assets.open(\"defaultData${File.separator}${ReadBookConfig.configFileName}\")");
            try {
                Object objFromJson = e.a.a.h.n.a().fromJson(new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a), new y(ReadBookConfig.Config.class));
                objM11constructorimpl = f.h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
            } catch (Throwable th) {
                objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            List<? extends ReadBookConfig.Config> list = (List) (f.h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
            f.c0.c.j.c(list);
            return list;
        }
    }

    /* JADX INFO: compiled from: DefaultData.kt */
    public static final class d extends f.c0.c.k implements f.c0.b.a<List<? extends RssSource>> {
        public static final d INSTANCE = new d();

        public d() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final List<? extends RssSource> invoke() throws IOException {
            Object objM11constructorimpl;
            AssetManager assets = k.d.a.h.g().getAssets();
            StringBuilder sbR = c.a.a.a.a.r("defaultData");
            sbR.append((Object) File.separator);
            sbR.append("rssSources.json");
            InputStream inputStreamOpen = assets.open(sbR.toString());
            f.c0.c.j.d(inputStreamOpen, "appCtx.assets.open(\"defaultData${File.separator}rssSources.json\")");
            try {
                Object objFromJson = e.a.a.h.n.a().fromJson(new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a), new y(RssSource.class));
                objM11constructorimpl = f.h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
            } catch (Throwable th) {
                objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            List<? extends RssSource> list = (List) (f.h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
            f.c0.c.j.c(list);
            return list;
        }
    }

    /* JADX INFO: compiled from: DefaultData.kt */
    public static final class e extends f.c0.c.k implements f.c0.b.a<List<? extends ThemeConfig.Config>> {
        public static final e INSTANCE = new e();

        public e() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final List<? extends ThemeConfig.Config> invoke() throws IOException {
            Object objM11constructorimpl;
            AssetManager assets = k.d.a.h.g().getAssets();
            StringBuilder sbR = c.a.a.a.a.r("defaultData");
            sbR.append((Object) File.separator);
            sbR.append("themeConfig.json");
            InputStream inputStreamOpen = assets.open(sbR.toString());
            f.c0.c.j.d(inputStreamOpen, "appCtx.assets.open(\"defaultData${File.separator}${ThemeConfig.configFileName}\")");
            try {
                Object objFromJson = e.a.a.h.n.a().fromJson(new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a), new y(ThemeConfig.Config.class));
                objM11constructorimpl = f.h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
            } catch (Throwable th) {
                objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            List<? extends ThemeConfig.Config> list = (List) (f.h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
            f.c0.c.j.c(list);
            return list;
        }
    }

    /* JADX INFO: compiled from: DefaultData.kt */
    public static final class f extends f.c0.c.k implements f.c0.b.a<List<? extends TxtTocRule>> {
        public static final f INSTANCE = new f();

        public f() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final List<? extends TxtTocRule> invoke() throws IOException {
            Object objM11constructorimpl;
            AssetManager assets = k.d.a.h.g().getAssets();
            StringBuilder sbR = c.a.a.a.a.r("defaultData");
            sbR.append((Object) File.separator);
            sbR.append("txtTocRule.json");
            InputStream inputStreamOpen = assets.open(sbR.toString());
            f.c0.c.j.d(inputStreamOpen, "appCtx.assets.open(\"defaultData${File.separator}$txtTocRuleFileName\")");
            try {
                Object objFromJson = e.a.a.h.n.a().fromJson(new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a), new y(TxtTocRule.class));
                objM11constructorimpl = f.h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
            } catch (Throwable th) {
                objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            List<? extends TxtTocRule> list = (List) (f.h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
            f.c0.c.j.c(list);
            return list;
        }
    }

    @NotNull
    public static final List<ReadBookConfig.Config> a() {
        return (List) f5546c.getValue();
    }

    public static final void b() {
        AppDatabaseKt.getAppDb().getHttpTTSDao().deleteDefault();
        HttpTTSDao httpTTSDao = AppDatabaseKt.getAppDb().getHttpTTSDao();
        Object[] array = ((List) f5545b.getValue()).toArray(new HttpTTS[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        HttpTTS[] httpTTSArr = (HttpTTS[]) array;
        httpTTSDao.insert((HttpTTS[]) Arrays.copyOf(httpTTSArr, httpTTSArr.length));
    }

    public static final void c() {
        RssSourceDao rssSourceDao = AppDatabaseKt.getAppDb().getRssSourceDao();
        Object[] array = ((List) f5549f.getValue()).toArray(new RssSource[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        RssSource[] rssSourceArr = (RssSource[]) array;
        rssSourceDao.insert((RssSource[]) Arrays.copyOf(rssSourceArr, rssSourceArr.length));
    }

    public static final void d() {
        AppDatabaseKt.getAppDb().getTxtTocRuleDao().deleteDefault();
        TxtTocRuleDao txtTocRuleDao = AppDatabaseKt.getAppDb().getTxtTocRuleDao();
        Object[] array = ((List) f5547d.getValue()).toArray(new TxtTocRule[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        TxtTocRule[] txtTocRuleArr = (TxtTocRule[]) array;
        txtTocRuleDao.insert((TxtTocRule[]) Arrays.copyOf(txtTocRuleArr, txtTocRuleArr.length));
    }
}
