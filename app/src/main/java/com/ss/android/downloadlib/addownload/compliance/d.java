package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.c;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.i.h;
import com.ss.android.socialbase.downloader.network.i;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: BitmapCache.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends h<Long, Bitmap> {
    private final Map<Long, SoftReference<a>> a;

    /* JADX INFO: compiled from: BitmapCache.java */
    public interface a {
        void a(Bitmap bitmap);
    }

    /* JADX INFO: compiled from: BitmapCache.java */
    public static class b {
        private static d a = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i2, int i3, BitmapFactory.Options options) {
        int i4 = options.outWidth;
        if (i4 > i2 || options.outHeight > i3) {
            return Math.min(Math.round(i4 / i2), Math.round(options.outHeight / i3));
        }
        return 1;
    }

    private d() {
        super(8, 8);
        this.a = new HashMap();
    }

    public static d a() {
        return b.a;
    }

    public void a(long j2, @NonNull a aVar) {
        if (get(Long.valueOf(j2)) != null) {
            aVar.a(get(Long.valueOf(j2)));
        } else {
            this.a.put(Long.valueOf(j2), new SoftReference<>(aVar));
        }
    }

    public void a(final long j2, final long j3, final String str) {
        if (get(Long.valueOf(j2)) != null) {
            SoftReference<a> softReferenceRemove = this.a.remove(Long.valueOf(j2));
            if (softReferenceRemove == null || softReferenceRemove.get() == null) {
                return;
            }
            softReferenceRemove.get().a(get(Long.valueOf(j2)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            e.a(12, j3);
        } else {
            com.ss.android.downloadlib.g.c.a((c.a<Object, R>) new c.a<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.d.2
                @Override // com.ss.android.downloadlib.g.c.a
                public Object a(Object obj) throws Throwable {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    i iVarA;
                    try {
                        iVarA = com.ss.android.socialbase.downloader.downloader.c.a(true, 0, str, null);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        bufferedInputStream = null;
                        th = th2;
                        f.a(bufferedInputStream);
                        throw th;
                    }
                    if (iVarA == null) {
                        f.a(null);
                        return null;
                    }
                    bufferedInputStream = new BufferedInputStream(iVarA.a());
                    try {
                        try {
                            bufferedInputStream.mark(bufferedInputStream.available());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            int i2 = options.outWidth;
                            int i3 = options.outHeight;
                            int iA = l.a(j.getContext(), 60.0f);
                            options.inSampleSize = d.b(iA, iA, options);
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                jSONObject.putOpt("bm_original_w", Integer.valueOf(i2));
                                jSONObject.putOpt("bm_original_h", Integer.valueOf(i3));
                                jSONObject.putOpt("bm_bytes", Integer.valueOf(bitmapDecodeStream == null ? -1 : bitmapDecodeStream.getByteCount()));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            com.ss.android.downloadlib.d.a.a().a("ttd_pref_monitor", jSONObject, j3);
                            d.this.put(Long.valueOf(j2), bitmapDecodeStream);
                            f.a(bufferedInputStream);
                        } catch (Exception e4) {
                            e = e4;
                            com.ss.android.downloadlib.e.c.a().a(e, "BitmapCache loadBitmap");
                            f.a(bufferedInputStream);
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        f.a(bufferedInputStream);
                        throw th;
                    }
                    com.ss.android.downloadlib.e.c.a().a(e, "BitmapCache loadBitmap");
                    f.a(bufferedInputStream);
                    return null;
                }
            }, (Object) null).a(new c.a<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.d.1
                @Override // com.ss.android.downloadlib.g.c.a
                public Object a(Object obj) {
                    SoftReference softReference = (SoftReference) d.this.a.remove(Long.valueOf(j2));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((a) softReference.get()).a(d.this.get(Long.valueOf(j2)));
                    return null;
                }
            }).a();
        }
    }
}
