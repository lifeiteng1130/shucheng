package c.b.a;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.c;
import c.b.a.e;
import c.b.a.m.n;
import c.b.a.m.q.d0.j;
import c.b.a.m.q.e0.a;
import c.b.a.m.q.l;
import c.b.a.m.r.c.a0;
import c.b.a.m.r.c.b0;
import c.b.a.m.r.c.k;
import c.b.a.m.r.c.m;
import c.b.a.m.r.c.t;
import c.b.a.m.r.c.v;
import c.b.a.m.r.c.x;
import c.b.a.m.r.c.y;
import c.b.a.m.r.d.a;
import c.b.a.n.p;
import com.bumptech.glide.GeneratedAppGlideModule;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Glide.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements ComponentCallbacks2 {

    @GuardedBy("Glide.class")
    public static volatile b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b.a.m.q.c0.d f196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.b.a.m.q.d0.i f197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c.b.a.m.q.c0.b f200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c.b.a.n.d f202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @GuardedBy("managers")
    public final List<i> f203j = new ArrayList();

    /* JADX INFO: compiled from: Glide.java */
    public interface a {
    }

    public b(@NonNull Context context, @NonNull l lVar, @NonNull c.b.a.m.q.d0.i iVar, @NonNull c.b.a.m.q.c0.d dVar, @NonNull c.b.a.m.q.c0.b bVar, @NonNull p pVar, @NonNull c.b.a.n.d dVar2, int i2, @NonNull a aVar, @NonNull Map<Class<?>, j<?, ?>> map, @NonNull List<c.b.a.q.e<Object>> list, e eVar) {
        n gVar;
        n yVar;
        c.b.a.m.r.e.e eVar2;
        this.f196c = dVar;
        this.f200g = bVar;
        this.f197d = iVar;
        this.f201h = pVar;
        this.f202i = dVar2;
        Resources resources = context.getResources();
        g gVar2 = new g();
        this.f199f = gVar2;
        k kVar = new k();
        c.b.a.p.b bVar2 = gVar2.f230g;
        synchronized (bVar2) {
            bVar2.a.add(kVar);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 27) {
            c.b.a.m.r.c.p pVar2 = new c.b.a.m.r.c.p();
            c.b.a.p.b bVar3 = gVar2.f230g;
            synchronized (bVar3) {
                bVar3.a.add(pVar2);
            }
        }
        List<ImageHeaderParser> listD = gVar2.d();
        c.b.a.m.r.g.a aVar2 = new c.b.a.m.r.g.a(context, listD, dVar, bVar);
        b0 b0Var = new b0(dVar, new b0.g());
        m mVar = new m(gVar2.d(), resources.getDisplayMetrics(), dVar, bVar);
        if (!eVar.a.containsKey(c.b.class) || i3 < 28) {
            gVar = new c.b.a.m.r.c.g(mVar);
            yVar = new y(mVar, bVar);
        } else {
            yVar = new t();
            gVar = new c.b.a.m.r.c.h();
        }
        c.b.a.m.r.e.e eVar3 = new c.b.a.m.r.e.e(context);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        c.b.a.m.r.c.c cVar = new c.b.a.m.r.c.c(bVar);
        c.b.a.m.r.h.a aVar3 = new c.b.a.m.r.h.a();
        c.b.a.m.r.h.d dVar3 = new c.b.a.m.r.h.d();
        ContentResolver contentResolver = context.getContentResolver();
        gVar2.a(ByteBuffer.class, new ByteBufferEncoder());
        gVar2.a(InputStream.class, new StreamEncoder(bVar));
        gVar2.c("Bitmap", ByteBuffer.class, Bitmap.class, gVar);
        gVar2.c("Bitmap", InputStream.class, Bitmap.class, yVar);
        if (ParcelFileDescriptorRewinder.isSupported()) {
            eVar2 = eVar3;
            gVar2.c("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new v(mVar));
        } else {
            eVar2 = eVar3;
        }
        gVar2.c("Bitmap", ParcelFileDescriptor.class, Bitmap.class, b0Var);
        gVar2.c("Bitmap", AssetFileDescriptor.class, Bitmap.class, new b0(dVar, new b0.c(null)));
        gVar2.a.append(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.getInstance());
        gVar2.c("Bitmap", Bitmap.class, Bitmap.class, new a0());
        gVar2.b(Bitmap.class, cVar);
        gVar2.c("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new c.b.a.m.r.c.a(resources, gVar));
        gVar2.c("BitmapDrawable", InputStream.class, BitmapDrawable.class, new c.b.a.m.r.c.a(resources, yVar));
        gVar2.c("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new c.b.a.m.r.c.a(resources, b0Var));
        gVar2.b(BitmapDrawable.class, new c.b.a.m.r.c.b(dVar, cVar));
        gVar2.c("Gif", InputStream.class, GifDrawable.class, new c.b.a.m.r.g.i(listD, aVar2, bVar));
        gVar2.c("Gif", ByteBuffer.class, GifDrawable.class, aVar2);
        gVar2.b(GifDrawable.class, new c.b.a.m.r.g.c());
        gVar2.a.append(GifDecoder.class, GifDecoder.class, UnitModelLoader.Factory.getInstance());
        gVar2.c("Bitmap", GifDecoder.class, Bitmap.class, new c.b.a.m.r.g.g(dVar));
        c.b.a.m.r.e.e eVar4 = eVar2;
        gVar2.c("legacy_append", Uri.class, Drawable.class, eVar4);
        gVar2.c("legacy_append", Uri.class, Bitmap.class, new x(eVar4, dVar));
        gVar2.f228e.register(new a.C0023a());
        gVar2.a.append(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory());
        gVar2.a.append(File.class, InputStream.class, new FileLoader.StreamFactory());
        gVar2.c("legacy_append", File.class, File.class, new c.b.a.m.r.f.a());
        gVar2.a.append(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory());
        gVar2.a.append(File.class, File.class, UnitModelLoader.Factory.getInstance());
        gVar2.f228e.register(new InputStreamRewinder.Factory(bVar));
        if (ParcelFileDescriptorRewinder.isSupported()) {
            gVar2.f228e.register(new ParcelFileDescriptorRewinder.Factory());
        }
        Class cls = Integer.TYPE;
        gVar2.a.append(cls, InputStream.class, streamFactory);
        gVar2.a.append(cls, ParcelFileDescriptor.class, fileDescriptorFactory);
        gVar2.a.append(Integer.class, InputStream.class, streamFactory);
        gVar2.a.append(Integer.class, ParcelFileDescriptor.class, fileDescriptorFactory);
        gVar2.a.append(Integer.class, Uri.class, uriFactory);
        gVar2.a.append(cls, AssetFileDescriptor.class, assetFileDescriptorFactory);
        gVar2.a.append(Integer.class, AssetFileDescriptor.class, assetFileDescriptorFactory);
        gVar2.a.append(cls, Uri.class, uriFactory);
        gVar2.a.append(String.class, InputStream.class, new DataUrlLoader.StreamFactory());
        gVar2.a.append(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory());
        gVar2.a.append(String.class, InputStream.class, new StringLoader.StreamFactory());
        gVar2.a.append(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory());
        gVar2.a.append(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory());
        gVar2.a.append(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets()));
        gVar2.a.append(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets()));
        gVar2.a.append(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context));
        gVar2.a.append(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context));
        if (i3 >= 29) {
            gVar2.a.append(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(context));
            gVar2.a.append(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(context));
        }
        gVar2.a.append(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver));
        gVar2.a.append(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver));
        gVar2.a.append(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver));
        gVar2.a.append(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory());
        gVar2.a.append(URL.class, InputStream.class, new UrlLoader.StreamFactory());
        gVar2.a.append(Uri.class, File.class, new MediaStoreFileLoader.Factory(context));
        gVar2.a.append(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory());
        gVar2.a.append(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory());
        gVar2.a.append(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory());
        gVar2.a.append(Uri.class, Uri.class, UnitModelLoader.Factory.getInstance());
        gVar2.a.append(Drawable.class, Drawable.class, UnitModelLoader.Factory.getInstance());
        gVar2.c("legacy_append", Drawable.class, Drawable.class, new c.b.a.m.r.e.f());
        gVar2.e(Bitmap.class, BitmapDrawable.class, new c.b.a.m.r.h.b(resources));
        gVar2.e(Bitmap.class, byte[].class, aVar3);
        gVar2.e(Drawable.class, byte[].class, new c.b.a.m.r.h.c(dVar, aVar3, dVar3));
        gVar2.e(GifDrawable.class, byte[].class, dVar3);
        if (i3 >= 23) {
            b0 b0Var2 = new b0(dVar, new b0.d());
            gVar2.c("legacy_append", ByteBuffer.class, Bitmap.class, b0Var2);
            gVar2.c("legacy_append", ByteBuffer.class, BitmapDrawable.class, new c.b.a.m.r.c.a(resources, b0Var2));
        }
        this.f198e = new d(context, bVar, gVar2, new c.b.a.q.j.f(), aVar, map, list, lVar, eVar, i2);
    }

    @GuardedBy("Glide.class")
    public static void a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (f195b) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f195b = true;
        c cVar = new c();
        Context applicationContext = context.getApplicationContext();
        Collections.emptyList();
        Log.isLoggable("ManifestParser", 3);
        ArrayList<c.b.a.o.c> arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                Log.isLoggable("ManifestParser", 3);
            } else {
                if (Log.isLoggable("ManifestParser", 2)) {
                    String str = "Got app info metadata: " + applicationInfo.metaData;
                }
                for (String str2 : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str2))) {
                        arrayList.add(c.b.a.o.e.a(str2));
                        Log.isLoggable("ManifestParser", 3);
                    }
                }
                Log.isLoggable("ManifestParser", 3);
            }
            if (generatedAppGlideModule != null && !generatedAppGlideModule.c().isEmpty()) {
                Set<Class<?>> setC = generatedAppGlideModule.c();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c.b.a.o.c cVar2 = (c.b.a.o.c) it.next();
                    if (setC.contains(cVar2.getClass())) {
                        if (Log.isLoggable("Glide", 3)) {
                            String str3 = "AppGlideModule excludes manifest GlideModule: " + cVar2;
                        }
                        it.remove();
                    }
                }
            }
            if (Log.isLoggable("Glide", 3)) {
                for (c.b.a.o.c cVar3 : arrayList) {
                    StringBuilder sbR = c.a.a.a.a.r("Discovered GlideModule from manifest: ");
                    sbR.append(cVar3.getClass());
                    sbR.toString();
                }
            }
            cVar.n = null;
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((c.b.a.o.c) it2.next()).a(applicationContext, cVar);
            }
            if (cVar.f209g == null) {
                int iA = c.b.a.m.q.e0.a.a();
                if (TextUtils.isEmpty("source")) {
                    throw new IllegalArgumentException(c.a.a.a.a.i("Name must be non-null and non-empty, but given: ", "source"));
                }
                cVar.f209g = new c.b.a.m.q.e0.a(new ThreadPoolExecutor(iA, iA, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a.ThreadFactoryC0017a("source", a.b.f386b, false)));
            }
            if (cVar.f210h == null) {
                int i2 = c.b.a.m.q.e0.a.f382b;
                if (TextUtils.isEmpty("disk-cache")) {
                    throw new IllegalArgumentException(c.a.a.a.a.i("Name must be non-null and non-empty, but given: ", "disk-cache"));
                }
                cVar.f210h = new c.b.a.m.q.e0.a(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a.ThreadFactoryC0017a("disk-cache", a.b.f386b, true)));
            }
            if (cVar.o == null) {
                int i3 = c.b.a.m.q.e0.a.a() >= 4 ? 2 : 1;
                if (TextUtils.isEmpty("animation")) {
                    throw new IllegalArgumentException(c.a.a.a.a.i("Name must be non-null and non-empty, but given: ", "animation"));
                }
                cVar.o = new c.b.a.m.q.e0.a(new ThreadPoolExecutor(i3, i3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a.ThreadFactoryC0017a("animation", a.b.f386b, true)));
            }
            if (cVar.f212j == null) {
                cVar.f212j = new c.b.a.m.q.d0.j(new j.a(applicationContext));
            }
            if (cVar.f213k == null) {
                cVar.f213k = new c.b.a.n.f();
            }
            if (cVar.f206d == null) {
                int i4 = cVar.f212j.a;
                if (i4 > 0) {
                    cVar.f206d = new c.b.a.m.q.c0.j(i4);
                } else {
                    cVar.f206d = new c.b.a.m.q.c0.e();
                }
            }
            if (cVar.f207e == null) {
                cVar.f207e = new c.b.a.m.q.c0.i(cVar.f212j.f373d);
            }
            if (cVar.f208f == null) {
                cVar.f208f = new c.b.a.m.q.d0.h(cVar.f212j.f371b);
            }
            if (cVar.f211i == null) {
                cVar.f211i = new c.b.a.m.q.d0.g(applicationContext);
            }
            if (cVar.f205c == null) {
                cVar.f205c = new l(cVar.f208f, cVar.f211i, cVar.f210h, cVar.f209g, new c.b.a.m.q.e0.a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, c.b.a.m.q.e0.a.a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new a.ThreadFactoryC0017a("source-unlimited", a.b.f386b, false))), cVar.o, false);
            }
            List<c.b.a.q.e<Object>> list = cVar.p;
            if (list == null) {
                cVar.p = Collections.emptyList();
            } else {
                cVar.p = Collections.unmodifiableList(list);
            }
            e.a aVar = cVar.f204b;
            Objects.requireNonNull(aVar);
            e eVar = new e(aVar);
            b bVar = new b(applicationContext, cVar.f205c, cVar.f208f, cVar.f206d, cVar.f207e, new p(cVar.n, eVar), cVar.f213k, cVar.f214l, cVar.m, cVar.a, cVar.p, eVar);
            for (c.b.a.o.c cVar4 : arrayList) {
                try {
                    cVar4.b(applicationContext, bVar, bVar.f199f);
                } catch (AbstractMethodError e2) {
                    StringBuilder sbR2 = c.a.a.a.a.r("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                    sbR2.append(cVar4.getClass().getName());
                    throw new IllegalStateException(sbR2.toString(), e2);
                }
            }
            applicationContext.registerComponentCallbacks(bVar);
            a = bVar;
            f195b = false;
        } catch (PackageManager.NameNotFoundException e3) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e3);
        }
    }

    @NonNull
    public static b b(@NonNull Context context) {
        if (a == null) {
            GeneratedAppGlideModule generatedAppGlideModule = null;
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                Log.isLoggable("Glide", 5);
            } catch (IllegalAccessException e2) {
                c(e2);
                throw null;
            } catch (InstantiationException e3) {
                c(e3);
                throw null;
            } catch (NoSuchMethodException e4) {
                c(e4);
                throw null;
            } catch (InvocationTargetException e5) {
                c(e5);
                throw null;
            }
            synchronized (b.class) {
                if (a == null) {
                    a(context, generatedAppGlideModule);
                }
            }
        }
        return a;
    }

    public static void c(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public static i d(@NonNull Context context) {
        Objects.requireNonNull(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return b(context).f201h.b(context);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        c.b.a.s.i.a();
        ((c.b.a.s.f) this.f197d).clearMemory();
        this.f196c.b();
        this.f200g.b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        c.b.a.s.i.a();
        synchronized (this.f203j) {
            Iterator<i> it = this.f203j.iterator();
            while (it.hasNext()) {
                Objects.requireNonNull(it.next());
            }
        }
        c.b.a.m.q.d0.h hVar = (c.b.a.m.q.d0.h) this.f197d;
        Objects.requireNonNull(hVar);
        if (i2 >= 40) {
            hVar.clearMemory();
        } else if (i2 >= 20 || i2 == 15) {
            hVar.trimToSize(hVar.getMaxSize() / 2);
        }
        this.f196c.a(i2);
        this.f200g.a(i2);
    }
}
