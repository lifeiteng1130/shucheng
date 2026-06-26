package e.a.a.d.w;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.documentfile.provider.DocumentFile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.ParseContext;
import f.v;
import g.b.a0;
import g.b.k0;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.help.ThemeConfig;
import io.legado.app.utils.FileUtils;
import io.wenyuange.app.release.R;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: Restore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    @NotNull
    public static final q a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final String f5593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final f.e f5594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final String[] f5595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final String[] f5596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final String[] f5597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final String[] f5598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final f.e f5599h;

    /* JADX INFO: compiled from: Restore.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<HashMap<String, Boolean>> {
        public static final a INSTANCE = new a();

        /* JADX INFO: renamed from: e.a.a.d.w.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GsonExtensions.kt */
        public static final class C0151a extends TypeToken<HashMap<String, Boolean>> {
        }

        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final HashMap<String, Boolean> invoke() {
            Object objM11constructorimpl;
            String strD = f.b0.d.d(FileUtils.a.b(q.f5593b), null, 1);
            Gson gsonA = e.a.a.h.n.a();
            try {
                Type type = new C0151a().getType();
                f.c0.c.j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(strD, type);
                if (!(objFromJson instanceof HashMap)) {
                    objFromJson = null;
                }
                objM11constructorimpl = f.h.m11constructorimpl((HashMap) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            HashMap<String, Boolean> map = (HashMap) (f.h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
            return map == null ? new HashMap<>() : map;
        }
    }

    /* JADX INFO: compiled from: Restore.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.a<ParseContext> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        public final ParseContext invoke() {
            return JsonPath.using(Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS).build());
        }
    }

    /* JADX INFO: compiled from: Restore.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.Restore", f = "Restore.kt", i = {0, 1}, l = {80, 110, 111}, m = "restore", n = {"this", "this"}, s = {"L$0", "L$0"})
    public static final class c extends f.z.j.a.c {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public c(f.z.d<? super c> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.this.c(null, null, this);
        }
    }

    /* JADX INFO: compiled from: Restore.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.Restore$restore$2", f = "Restore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $path;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Context context, f.z.d<? super d> dVar) {
            super(2, dVar);
            this.$path = str;
            this.$context = context;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new d(this.$path, this.$context, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            DocumentFile[] documentFileArrListFiles;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            if (!c.b.a.m.f.t3(this.$path)) {
                try {
                    File file = new File(this.$path);
                    String[] strArrE = i.a.e();
                    int length = strArrE.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String str = strArrE[i2];
                        i2++;
                        FileUtils fileUtils = FileUtils.a;
                        File fileM = fileUtils.m(file, str);
                        if (fileM.exists()) {
                            f.b0.d.a(fileM, fileUtils.b(i.a.f() + ((Object) File.separator) + str), true, 0, 4);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return v.a;
            }
            DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this.$context, Uri.parse(this.$path));
            if (documentFileFromTreeUri == null || (documentFileArrListFiles = documentFileFromTreeUri.listFiles()) == null) {
                return null;
            }
            Context context = this.$context;
            for (DocumentFile documentFile : documentFileArrListFiles) {
                String[] strArrE2 = i.a.e();
                int length2 = strArrE2.length;
                int i3 = 0;
                while (i3 < length2) {
                    String str2 = strArrE2[i3];
                    i3++;
                    if (f.c0.c.j.a(documentFile.getName(), str2)) {
                        Uri uri = documentFile.getUri();
                        f.c0.c.j.d(uri, "doc.uri");
                        String strF = e.a.a.h.j.f(context, uri);
                        if (strF != null) {
                            f.b0.d.f(FileUtils.a.b(i.a.f() + ((Object) File.separator) + str2), strF, null, 2);
                        }
                    }
                }
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: Restore.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.Restore", f = "Restore.kt", i = {}, l = {Token.LAST_TOKEN, 227}, m = "restoreConfig", n = {}, s = {})
    public static final class e extends f.z.j.a.c {
        public int label;
        public /* synthetic */ Object result;

        public e(f.z.d<? super e> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.this.d(null, this);
        }
    }

    /* JADX INFO: compiled from: Restore.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.Restore$restoreConfig$2", f = "Restore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super ReadBookConfig>, Object> {
        public final /* synthetic */ String $path;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, f.z.d<? super f> dVar) {
            super(2, dVar);
            this.$path = str;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new f(this.$path, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super ReadBookConfig> dVar) {
            return ((f) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            SharedPreferences sharedPreferences;
            Map<String, ?> all;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            try {
                FileUtils fileUtils = FileUtils.a;
                File fileB = fileUtils.b(this.$path + ((Object) File.separator) + "themeConfig.json");
                if (fileB.exists()) {
                    ThemeConfig themeConfig = ThemeConfig.a;
                    String str = ThemeConfig.f6899b;
                    fileUtils.h(str);
                    f.b0.d.a(fileB, new File(str), false, 0, 6);
                    List<ThemeConfig.Config> listE = themeConfig.e();
                    if (listE != null) {
                        Iterator<T> it = listE.iterator();
                        while (it.hasNext()) {
                            ThemeConfig.a.a((ThemeConfig.Config) it.next());
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!f.c0.c.j.a(q.a.a().get("readConfig"), Boolean.TRUE)) {
                try {
                    FileUtils fileUtils2 = FileUtils.a;
                    File fileB2 = fileUtils2.b(this.$path + ((Object) File.separator) + ReadBookConfig.configFileName);
                    if (fileB2.exists()) {
                        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
                        fileUtils2.h(readBookConfig.getConfigFilePath());
                        f.b0.d.a(fileB2, new File(readBookConfig.getConfigFilePath()), false, 0, 6);
                        readBookConfig.initConfigs();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                try {
                    FileUtils fileUtils3 = FileUtils.a;
                    File fileB3 = fileUtils3.b(this.$path + ((Object) File.separator) + ReadBookConfig.shareConfigFileName);
                    if (fileB3.exists()) {
                        ReadBookConfig readBookConfig2 = ReadBookConfig.INSTANCE;
                        fileUtils3.h(readBookConfig2.getShareConfigFilePath());
                        f.b0.d.a(fileB3, new File(readBookConfig2.getShareConfigFilePath()), false, 0, 6);
                        readBookConfig2.initShareConfig();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            Context contextG = k.d.a.h.g();
            String str2 = this.$path;
            f.c0.c.j.e(contextG, com.umeng.analytics.pro.c.R);
            f.c0.c.j.e(str2, "dir");
            f.c0.c.j.e("config", "fileName");
            try {
                Field declaredField = ContextWrapper.class.getDeclaredField("mBase");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(contextG);
                Field declaredField2 = obj2.getClass().getDeclaredField("mPreferencesDir");
                declaredField2.setAccessible(true);
                declaredField2.set(obj2, new File(str2));
                sharedPreferences = contextG.getSharedPreferences("config", 0);
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
                sharedPreferences = null;
            } catch (IllegalArgumentException e6) {
                e6.printStackTrace();
                sharedPreferences = null;
            } catch (NoSuchFieldException e7) {
                e7.printStackTrace();
                sharedPreferences = null;
            }
            if (sharedPreferences != null && (all = sharedPreferences.getAll()) != null) {
                SharedPreferences.Editor editorEdit = c.b.a.m.f.i2(k.d.a.h.g()).edit();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    q qVar = q.a;
                    String key = entry.getKey();
                    f.c0.c.j.d(key, "it.key");
                    String str3 = key;
                    if ((c.b.a.m.f.b1(q.f5597f, str3) || (c.b.a.m.f.b1(q.f5598g, str3) && f.c0.c.j.a(qVar.a().get("readConfig"), Boolean.TRUE)) || ((f.c0.c.j.a("themeMode", str3) && f.c0.c.j.a(qVar.a().get("themeMode"), Boolean.TRUE)) || ((f.c0.c.j.a("bookshelfLayout", str3) && f.c0.c.j.a(qVar.a().get("bookshelfLayout"), Boolean.TRUE)) || ((f.c0.c.j.a("showRss", str3) && f.c0.c.j.a(qVar.a().get("showRss"), Boolean.TRUE)) || (f.c0.c.j.a("threadCount", str3) && f.c0.c.j.a(qVar.a().get("threadCount"), Boolean.TRUE)))))) ? false : true) {
                        Object value = entry.getValue();
                        if (value instanceof Integer) {
                            editorEdit.putInt(entry.getKey(), ((Number) value).intValue());
                        } else if (value instanceof Boolean) {
                            editorEdit.putBoolean(entry.getKey(), ((Boolean) value).booleanValue());
                        } else if (value instanceof Long) {
                            editorEdit.putLong(entry.getKey(), ((Number) value).longValue());
                        } else if (value instanceof Float) {
                            editorEdit.putFloat(entry.getKey(), ((Number) value).floatValue());
                        } else if (value instanceof String) {
                            editorEdit.putString(entry.getKey(), (String) value);
                        }
                    }
                }
                editorEdit.apply();
            }
            ReadBookConfig readBookConfig3 = ReadBookConfig.INSTANCE;
            readBookConfig3.setStyleSelect(c.b.a.m.f.M2(k.d.a.h.g(), "readStyleSelect", 0, 2));
            readBookConfig3.setShareLayout(c.b.a.m.f.K2(k.d.a.h.g(), "shareLayout", false, 2));
            readBookConfig3.setHideStatusBar(c.b.a.m.f.K2(k.d.a.h.g(), "hideStatusBar", false, 2));
            readBookConfig3.setHideNavigationBar(c.b.a.m.f.K2(k.d.a.h.g(), "hideNavigationBar", false, 2));
            readBookConfig3.setAutoReadSpeed(c.b.a.m.f.L2(k.d.a.h.g(), "autoReadSpeed", 46));
            return readBookConfig3;
        }
    }

    /* JADX INFO: compiled from: Restore.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.Restore$restoreConfig$3", f = "Restore.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d, Object> {
        public int label;

        public g(f.z.d<? super g> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new g(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d dVar) {
            return ((g) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                c.b.a.m.f.E5(obj);
                this.label = 1;
                if (c.b.a.m.f.p1(100L, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
            }
            e.a.a.d.p pVar = e.a.a.d.p.a;
            e.a.a.d.p.a(c.b.a.m.f.O2(k.d.a.h.g(), "launcherIcon", null, 2));
            Intent launchIntentForPackage = k.d.a.h.g().getPackageManager().getLaunchIntentForPackage(k.d.a.h.g().getPackageName());
            if (launchIntentForPackage == null) {
                return v.a;
            }
            PendingIntent activity = PendingIntent.getActivity(k.d.a.h.g(), 0, launchIntentForPackage, BasicMeasure.EXACTLY);
            f.c0.c.j.f(NotificationCompat.CATEGORY_ALARM, "name");
            ((AlarmManager) k.d.a.h.g().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + ((long) 300), activity);
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    static {
        File filesDir = k.d.a.h.g().getFilesDir();
        f.c0.c.j.d(filesDir, "appCtx.filesDir");
        String[] strArr = {"restoreIgnore.json"};
        f.c0.c.j.e(filesDir, "root");
        f.c0.c.j.e(strArr, "subDirFiles");
        StringBuilder sb = new StringBuilder(filesDir.getAbsolutePath());
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                String string = sb.toString();
                f.c0.c.j.d(string, "path.toString()");
                f5593b = string;
                f5594c = c.b.a.m.f.N3(a.INSTANCE);
                f5595d = new String[]{"readConfig", "themeMode", "bookshelfLayout", "showRss", "threadCount"};
                f5596e = new String[]{k.d.a.h.g().getString(R.string.read_config), k.d.a.h.g().getString(R.string.theme_mode), k.d.a.h.g().getString(R.string.bookshelf_layout), k.d.a.h.g().getString(R.string.show_rss), k.d.a.h.g().getString(R.string.thread_count)};
                f5597f = new String[]{"defaultCover"};
                f5598g = new String[]{"readStyleSelect", "shareLayout", "hideStatusBar", "hideNavigationBar", "autoReadSpeed"};
                f5599h = c.b.a.m.f.N3(b.INSTANCE);
                return;
            }
            String str = strArr[i2];
            if (str.length() > 0) {
                sb.append(File.separator);
                sb.append(str);
            }
            i2++;
        }
    }

    public static Object e(q qVar, String str, f.z.d dVar, int i2) {
        String strF = (i2 & 1) != 0 ? i.a.f() : null;
        Objects.requireNonNull(qVar);
        k0 k0Var = k0.f6264c;
        return c.b.a.m.f.f6(k0.f6263b, new r(strF, null), dVar);
    }

    @NotNull
    public final HashMap<String, Boolean> a() {
        return (HashMap) f5594c.getValue();
    }

    @NotNull
    public final ParseContext b() {
        Object value = f5599h.getValue();
        f.c0.c.j.d(value, "<get-jsonPath>(...)");
        return (ParseContext) value;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(@org.jetbrains.annotations.NotNull android.content.Context r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull f.z.d<? super f.v> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof e.a.a.d.w.q.c
            if (r0 == 0) goto L13
            r0 = r10
            e.a.a.d.w.q$c r0 = (e.a.a.d.w.q.c) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            e.a.a.d.w.q$c r0 = new e.a.a.d.w.q$c
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L46
            if (r2 == r6) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            c.b.a.m.f.E5(r10)
            goto L7a
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            java.lang.Object r8 = r0.L$0
            e.a.a.d.w.q r8 = (e.a.a.d.w.q) r8
            c.b.a.m.f.E5(r10)
            goto L69
        L3e:
            java.lang.Object r8 = r0.L$0
            e.a.a.d.w.q r8 = (e.a.a.d.w.q) r8
            c.b.a.m.f.E5(r10)
            goto L5e
        L46:
            c.b.a.m.f.E5(r10)
            g.b.k0 r10 = g.b.k0.f6264c
            g.b.y r10 = g.b.k0.f6263b
            e.a.a.d.w.q$d r2 = new e.a.a.d.w.q$d
            r2.<init>(r9, r8, r5)
            r0.L$0 = r7
            r0.label = r6
            java.lang.Object r8 = c.b.a.m.f.f6(r10, r2, r0)
            if (r8 != r1) goto L5d
            return r1
        L5d:
            r8 = r7
        L5e:
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = e(r8, r5, r0, r6)
            if (r9 != r1) goto L69
            return r1
        L69:
            r0.L$0 = r5
            r0.label = r3
            e.a.a.d.w.i r9 = e.a.a.d.w.i.a
            java.lang.String r9 = r9.f()
            java.lang.Object r8 = r8.d(r9, r0)
            if (r8 != r1) goto L7a
            return r1
        L7a:
            f.v r8 = f.v.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.w.q.c(android.content.Context, java.lang.String, f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull f.z.d<? super f.v> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof e.a.a.d.w.q.e
            if (r0 == 0) goto L13
            r0 = r8
            e.a.a.d.w.q$e r0 = (e.a.a.d.w.q.e) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            e.a.a.d.w.q$e r0 = new e.a.a.d.w.q$e
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L37
            if (r2 == r5) goto L33
            if (r2 != r4) goto L2b
            c.b.a.m.f.E5(r8)
            goto L68
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            c.b.a.m.f.E5(r8)
            goto L4c
        L37:
            c.b.a.m.f.E5(r8)
            g.b.k0 r8 = g.b.k0.f6264c
            g.b.y r8 = g.b.k0.f6263b
            e.a.a.d.w.q$f r2 = new e.a.a.d.w.q$f
            r2.<init>(r7, r3)
            r0.label = r5
            java.lang.Object r7 = c.b.a.m.f.f6(r8, r2, r0)
            if (r7 != r1) goto L4c
            return r1
        L4c:
            android.content.Context r7 = k.d.a.h.g()
            r8 = 2131821253(0x7f1102c5, float:1.9275244E38)
            c.b.a.m.f.Q5(r7, r8)
            g.b.k0 r7 = g.b.k0.f6264c
            g.b.o1 r7 = g.b.g2.m.f6207b
            e.a.a.d.w.q$g r8 = new e.a.a.d.w.q$g
            r8.<init>(r3)
            r0.label = r4
            java.lang.Object r8 = c.b.a.m.f.f6(r7, r8, r0)
            if (r8 != r1) goto L68
            return r1
        L68:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.w.q.d(java.lang.String, f.z.d):java.lang.Object");
    }
}
