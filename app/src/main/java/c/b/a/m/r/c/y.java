package c.b.a.m.r.c;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import c.b.a.m.r.c.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: compiled from: StreamBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class y implements c.b.a.m.n<InputStream, Bitmap> {
    public final m a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b.a.m.q.c0.b f559b;

    /* JADX INFO: compiled from: StreamBitmapDecoder.java */
    public static class a implements m.b {
        public final w a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c.b.a.s.c f560b;

        public a(w wVar, c.b.a.s.c cVar) {
            this.a = wVar;
            this.f560b = cVar;
        }

        @Override // c.b.a.m.r.c.m.b
        public void a(c.b.a.m.q.c0.d dVar, Bitmap bitmap) throws IOException {
            IOException iOException = this.f560b.f673c;
            if (iOException != null) {
                if (bitmap == null) {
                    throw iOException;
                }
                dVar.d(bitmap);
                throw iOException;
            }
        }

        @Override // c.b.a.m.r.c.m.b
        public void b() {
            w wVar = this.a;
            synchronized (wVar) {
                wVar.f554c = wVar.a.length;
            }
        }
    }

    public y(m mVar, c.b.a.m.q.c0.b bVar) {
        this.a = mVar;
        this.f559b = bVar;
    }

    @Override // c.b.a.m.n
    public boolean a(@NonNull InputStream inputStream, @NonNull c.b.a.m.l lVar) {
        Objects.requireNonNull(this.a);
        return true;
    }

    @Override // c.b.a.m.n
    public c.b.a.m.q.w<Bitmap> b(@NonNull InputStream inputStream, int i2, int i3, @NonNull c.b.a.m.l lVar) {
        w wVar;
        boolean z;
        c.b.a.s.c cVarPoll;
        InputStream inputStream2 = inputStream;
        if (inputStream2 instanceof w) {
            wVar = (w) inputStream2;
            z = false;
        } else {
            wVar = new w(inputStream2, this.f559b);
            z = true;
        }
        Queue<c.b.a.s.c> queue = c.b.a.s.c.a;
        synchronized (queue) {
            cVarPoll = queue.poll();
        }
        if (cVarPoll == null) {
            cVarPoll = new c.b.a.s.c();
        }
        cVarPoll.f672b = wVar;
        try {
            return this.a.b(new c.b.a.s.g(cVarPoll), i2, i3, lVar, new a(wVar, cVarPoll));
        } finally {
            cVarPoll.a();
            if (z) {
                wVar.b();
            }
        }
    }
}
