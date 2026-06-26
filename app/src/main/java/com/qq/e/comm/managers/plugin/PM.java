package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import dalvik.system.DexClassLoader;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class PM {
    private static final Map<Class<?>, String> p = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f2790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DexClassLoader f2792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RandomAccessFile f2793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FileLock f2794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2795i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private POFactory f2797k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f2798l;
    private Future<Boolean> m;
    private final f n;
    private f o;
    public final ExecutorService a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final e f2796j = null;

    public class a implements Callable<Boolean> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            PM pm = PM.this;
            pm.f2795i = PM.a(pm);
            if (PM.b(PM.this)) {
                PM.this.c();
            }
            PM.this.f2798l = (int) (System.currentTimeMillis() - jCurrentTimeMillis);
            return Boolean.TRUE;
        }
    }

    public class b implements f {
        public b() {
        }
    }

    public static class c extends HashMap<Class<?>, String> implements j$.util.Map {
        public c() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }

        @Override // j$.util.Map
        public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
            return Map.CC.$default$compute(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
            return Map.CC.$default$computeIfAbsent(this, obj, function);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
            return Map.CC.$default$computeIfPresent(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ void forEach(BiConsumer biConsumer) {
            Map.CC.$default$forEach(this, biConsumer);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return Map.CC.$default$getOrDefault(this, obj, obj2);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
            return Map.CC.$default$merge(this, obj, obj2, biFunction);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
            return Map.CC.$default$putIfAbsent(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ boolean remove(Object obj, Object obj2) {
            return Map.CC.$default$remove(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object replace(Object obj, Object obj2) {
            return Map.CC.$default$replace(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
            return Map.CC.$default$replace(this, obj, obj2, obj3);
        }

        @Override // j$.util.Map
        public /* synthetic */ void replaceAll(BiFunction biFunction) {
            Map.CC.$default$replaceAll(this, biFunction);
        }
    }

    public PM(Context context, e eVar) {
        b bVar = new b();
        this.n = bVar;
        this.o = bVar;
        this.f2788b = context.getApplicationContext();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        e eVar = this.f2796j;
        if (eVar != null) {
            eVar.onLoadFail();
        }
    }

    public static boolean a(PM pm) {
        Objects.requireNonNull(pm);
        try {
            File fileB = h.b(pm.f2788b);
            if (!fileB.exists()) {
                fileB.createNewFile();
                StringUtil.writeTo("lock", fileB);
            }
            if (fileB.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileB, "rw");
                pm.f2793g = randomAccessFile;
                FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
                pm.f2794h = fileLockTryLock;
                if (fileLockTryLock != null) {
                    pm.f2793g.writeByte(37);
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private boolean b() {
        if (!this.f2795i) {
            return false;
        }
        Context context = this.f2788b;
        if (!com.qq.e.comm.managers.plugin.b.a(context, h.e(context), h.f(this.f2788b))) {
            GDTLogger.e("插件初始化失败 ");
            com.qq.e.comm.managers.plugin.a.a(new Exception(), "initAssetPlugin failed");
            return false;
        }
        this.f2789c = Sig.ASSET_PLUGIN_SIG;
        this.f2790d = h.e(this.f2788b);
        this.f2791e = Constants.PLUGIN.ASSET_PLUGIN_VERSION;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(com.qq.e.comm.managers.plugin.PM r5) {
        /*
            java.lang.String r0 = "TimeStap_AFTER_PLUGIN_INIT:"
            java.util.Objects.requireNonNull(r5)
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "TimeStap_BEFORE_PLUGIN_INIT:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L32
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L32
            com.qq.e.comm.util.GDTLogger.d(r2)     // Catch: java.lang.Throwable -> L32
            boolean r2 = r5.d()     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L2a
            boolean r5 = r5.b()     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L2c
        L2a:
            r5 = 1
            r1 = 1
        L2c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L44
        L32:
            r5 = move-exception
            java.lang.String r2 = "插件加载出现异常"
            com.qq.e.comm.util.GDTLogger.e(r2, r5)     // Catch: java.lang.Throwable -> L56
            java.lang.String r2 = r5.getMessage()     // Catch: java.lang.Throwable -> L56
            com.qq.e.comm.managers.plugin.a.a(r5, r2)     // Catch: java.lang.Throwable -> L56
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L44:
            r5.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.qq.e.comm.util.GDTLogger.d(r5)
            return r1
        L56:
            r5 = move-exception
            java.lang.StringBuilder r0 = c.a.a.a.a.r(r0)
            long r1 = java.lang.System.currentTimeMillis()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.b(com.qq.e.comm.managers.plugin.PM):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        StringBuilder sbR = c.a.a.a.a.r("PluginFile:\t");
        File file = this.f2790d;
        sbR.append(file == null ? "null" : file.getAbsolutePath());
        GDTLogger.d(sbR.toString());
        if (this.f2789c == null || this.f2790d == null) {
            this.f2792f = null;
            return;
        }
        try {
            this.f2792f = new DexClassLoader(this.f2790d.getAbsolutePath(), h.a(this.f2788b).getAbsolutePath(), null, getClass().getClassLoader());
            e eVar = this.f2796j;
            if (eVar != null) {
                eVar.onLoadSuccess();
            }
        } catch (Throwable th) {
            GDTLogger.e("插件ClassLoader构造发生异常", th);
            a();
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
        }
    }

    public static void d(PM pm) {
        Objects.requireNonNull(pm);
        try {
            if (pm.f2792f == null && pm.d()) {
                pm.c();
            }
        } catch (Exception e2) {
            GDTLogger.e("插件更新失败: ", e2);
            pm.a();
        }
    }

    private boolean d() {
        if (this.f2795i) {
            g gVar = new g(h.c(this.f2788b), h.d(this.f2788b));
            if (gVar.a()) {
                GDTLogger.d("NextExist,Updated=" + gVar.a(h.e(this.f2788b), h.f(this.f2788b)));
            }
        }
        g gVar2 = new g(h.e(this.f2788b), h.f(this.f2788b));
        if (gVar2.a()) {
            if (gVar2.c() >= 1292 && gVar2.c() / 10 == 129) {
                this.f2789c = gVar2.b();
                this.f2791e = gVar2.c();
                this.f2790d = h.e(this.f2788b);
                return true;
            }
            StringBuilder sbR = c.a.a.a.a.r("last updated plugin version =");
            sbR.append(this.f2791e);
            sbR.append(";asset plugin version=");
            sbR.append(Constants.PLUGIN.ASSET_PLUGIN_VERSION);
            GDTLogger.d(sbR.toString());
        }
        return false;
    }

    private void e() {
        this.m = this.a.submit(new a());
    }

    private void f() {
        Future<Boolean> future = this.m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    public <T> T getFactory(Class<T> cls) throws d {
        f();
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f2792f;
        StringBuilder sbR = c.a.a.a.a.r("PluginClassLoader is parent");
        sbR.append(PM.class.getClassLoader() == classLoader);
        GDTLogger.d(sbR.toString());
        if (classLoader == null) {
            throw new d("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = p.get(cls);
            if (StringUtil.isEmpty(str)) {
                throw new d("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> clsLoadClass = classLoader.loadClass(str);
            T tCast = cls.cast(clsLoadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(clsLoadClass, new Object[0]));
            GDTLogger.d("ServiceDelegateFactory =" + tCast);
            return tCast;
        } catch (Throwable th) {
            StringBuilder sbR2 = c.a.a.a.a.r("Fail to getfactory implement instance for interface:");
            sbR2.append(cls.getName());
            throw new d(sbR2.toString(), th);
        }
    }

    public int getInitCostTime() {
        return this.f2798l;
    }

    public String getLocalSig() {
        f();
        return this.f2789c;
    }

    public POFactory getPOFactory() {
        if (this.f2797k == null) {
            this.f2797k = (POFactory) getFactory(POFactory.class);
        }
        return this.f2797k;
    }

    public int getPluginVersion() {
        f();
        return this.f2791e;
    }

    public void update(String str, String str2) {
        if (this.f2795i) {
            com.qq.e.comm.managers.plugin.c cVar = new com.qq.e.comm.managers.plugin.c(this.f2788b, this.a);
            cVar.a(this.o);
            cVar.a(str, str2);
        }
    }
}
