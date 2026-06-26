package c.b.a.m.r.g;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import c.b.a.m.p;
import c.b.a.m.q.k;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: GifFrameLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public final GifDecoder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.b.a.i f574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c.b.a.m.q.c0.d f575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c.b.a.h<Bitmap> f578h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f579i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f580j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f581k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bitmap f582l;
    public p<Bitmap> m;
    public a n;

    @Nullable
    public d o;
    public int p;
    public int q;
    public int r;

    /* JADX INFO: compiled from: GifFrameLoader.java */
    @VisibleForTesting
    public static class a extends c.b.a.q.j.c<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Handler f583d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f584e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f585f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bitmap f586g;

        public a(Handler handler, int i2, long j2) {
            this.f583d = handler;
            this.f584e = i2;
            this.f585f = j2;
        }

        @Override // c.b.a.q.j.h
        public void b(@NonNull Object obj, @Nullable c.b.a.q.k.d dVar) {
            this.f586g = (Bitmap) obj;
            this.f583d.sendMessageAtTime(this.f583d.obtainMessage(1, this), this.f585f);
        }

        @Override // c.b.a.q.j.h
        public void g(@Nullable Drawable drawable) {
            this.f586g = null;
        }
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                f.this.b((a) message.obj);
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            f.this.f574d.j((a) message.obj);
            return false;
        }
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    @VisibleForTesting
    public interface d {
        void a();
    }

    public f(c.b.a.b bVar, GifDecoder gifDecoder, int i2, int i3, p<Bitmap> pVar, Bitmap bitmap) {
        c.b.a.m.q.c0.d dVar = bVar.f196c;
        c.b.a.i iVarD = c.b.a.b.d(bVar.f198e.getBaseContext());
        c.b.a.i iVarD2 = c.b.a.b.d(bVar.f198e.getBaseContext());
        Objects.requireNonNull(iVarD2);
        c.b.a.h<Bitmap> hVarA = new c.b.a.h(iVarD2.f235b, iVarD2, Bitmap.class, iVarD2.f236c).a(c.b.a.i.a).a(c.b.a.q.f.y(k.a).w(true).s(true).l(i2, i3));
        this.f573c = new ArrayList();
        this.f574d = iVarD;
        Handler handler = new Handler(Looper.getMainLooper(), new c());
        this.f575e = dVar;
        this.f572b = handler;
        this.f578h = hVarA;
        this.a = gifDecoder;
        c(pVar, bitmap);
    }

    public final void a() {
        if (!this.f576f || this.f577g) {
            return;
        }
        a aVar = this.n;
        if (aVar != null) {
            this.n = null;
            b(aVar);
            return;
        }
        this.f577g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.a.d());
        this.a.b();
        this.f581k = new a(this.f572b, this.a.e(), jUptimeMillis);
        this.f578h.a(new c.b.a.q.f().r(new c.b.a.r.b(Double.valueOf(Math.random())))).G(this.a).C(this.f581k);
    }

    @VisibleForTesting
    public void b(a aVar) {
        d dVar = this.o;
        if (dVar != null) {
            dVar.a();
        }
        this.f577g = false;
        if (this.f580j) {
            this.f572b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f576f) {
            this.n = aVar;
            return;
        }
        if (aVar.f586g != null) {
            Bitmap bitmap = this.f582l;
            if (bitmap != null) {
                this.f575e.d(bitmap);
                this.f582l = null;
            }
            a aVar2 = this.f579i;
            this.f579i = aVar;
            int size = this.f573c.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else {
                    this.f573c.get(size).a();
                }
            }
            if (aVar2 != null) {
                this.f572b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        a();
    }

    public void c(p<Bitmap> pVar, Bitmap bitmap) {
        Objects.requireNonNull(pVar, "Argument must not be null");
        this.m = pVar;
        Objects.requireNonNull(bitmap, "Argument must not be null");
        this.f582l = bitmap;
        this.f578h = this.f578h.a(new c.b.a.q.f().t(pVar, true));
        this.p = c.b.a.s.i.d(bitmap);
        this.q = bitmap.getWidth();
        this.r = bitmap.getHeight();
    }

    @VisibleForTesting
    public void setOnEveryFrameReadyListener(@Nullable d dVar) {
        this.o = dVar;
    }
}
