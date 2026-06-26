package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.i;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: NotificationIconCache.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static int a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f3356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a<Integer, Bitmap> f3357c;

    /* JADX INFO: compiled from: NotificationIconCache.java */
    public static class a<K, T> extends LinkedHashMap<K, T> implements Map {
        public final int a;

        public a(int i2, int i3) {
            super(i3, 0.75f, true);
            this.a = i2;
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

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map, j$.util.Map
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

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.a;
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

    private c() {
        this.f3357c = null;
        int i2 = a;
        this.f3357c = new a<>(i2, i2 / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 <= -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public static c a() {
        if (f3356b == null) {
            synchronized (c.class) {
                if (f3356b == null) {
                    f3356b = new c();
                }
            }
        }
        return f3356b;
    }

    public Bitmap a(int i2) {
        return this.f3357c.get(Integer.valueOf(i2));
    }

    public void a(final int i2, final String str) {
        if (TextUtils.isEmpty(str) || a(i2) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.m().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.c.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ByteArrayOutputStream byteArrayOutputStreamB;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStreamA;
                Exception e2;
                i iVarA;
                int i3 = 4;
                i3 = 4;
                i3 = 4;
                i3 = 4;
                i3 = 4;
                try {
                    try {
                        iVarA = com.ss.android.socialbase.downloader.downloader.c.a(true, 0, str, null);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e3) {
                    byteArrayOutputStreamB = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e2 = e3;
                    inputStreamA = null;
                } catch (Throwable th3) {
                    byteArrayOutputStreamB = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th = th3;
                    inputStreamA = null;
                }
                if (iVarA == null) {
                    f.a(null, null, null, null);
                    return;
                }
                inputStreamA = iVarA.a();
                try {
                    byteArrayOutputStreamB = c.b(inputStreamA);
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamB.toByteArray());
                    } catch (Exception e4) {
                        byteArrayInputStream2 = null;
                        e2 = e4;
                        byteArrayInputStream = null;
                    } catch (Throwable th4) {
                        byteArrayInputStream2 = null;
                        th = th4;
                        byteArrayInputStream = null;
                    }
                } catch (Exception e5) {
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e2 = e5;
                    byteArrayOutputStreamB = null;
                } catch (Throwable th5) {
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th = th5;
                    byteArrayOutputStreamB = null;
                }
                try {
                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStreamB.toByteArray());
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                        int iA = com.ss.android.socialbase.appdownloader.c.a(com.ss.android.socialbase.downloader.downloader.c.N(), 44.0f);
                        options.inSampleSize = c.a(iA, iA, options);
                        options.inJustDecodeBounds = false;
                        c.this.f3357c.put(Integer.valueOf(i2), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                        Closeable[] closeableArr = {inputStreamA, byteArrayOutputStreamB, byteArrayInputStream, byteArrayInputStream2};
                        f.a(closeableArr);
                        i3 = closeableArr;
                    } catch (Exception e6) {
                        e2 = e6;
                        e2.printStackTrace();
                        Closeable[] closeableArr2 = {inputStreamA, byteArrayOutputStreamB, byteArrayInputStream, byteArrayInputStream2};
                        f.a(closeableArr2);
                        i3 = closeableArr2;
                    }
                } catch (Exception e7) {
                    byteArrayInputStream2 = null;
                    e2 = e7;
                } catch (Throwable th6) {
                    byteArrayInputStream2 = null;
                    th = th6;
                    Closeable[] closeableArr3 = new Closeable[i3];
                    closeableArr3[0] = inputStreamA;
                    closeableArr3[1] = byteArrayOutputStreamB;
                    closeableArr3[2] = byteArrayInputStream;
                    closeableArr3[3] = byteArrayInputStream2;
                    f.a(closeableArr3);
                    throw th;
                }
                e2.printStackTrace();
                Closeable[] closeableArr22 = {inputStreamA, byteArrayOutputStreamB, byteArrayInputStream, byteArrayInputStream2};
                f.a(closeableArr22);
                i3 = closeableArr22;
            }
        });
    }

    public static int a(int i2, int i3, BitmapFactory.Options options) {
        int i4 = options.outWidth;
        if (i4 > i2 || options.outHeight > i3) {
            return Math.min(Math.round(i4 / i2), Math.round(options.outHeight / i3));
        }
        return 1;
    }
}
