package c.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.q.k;
import c.b.a.m.r.c.l;
import c.b.a.m.r.c.q;
import c.b.a.n.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class h<TranscodeType> extends c.b.a.q.a<h<TranscodeType>> implements Cloneable {
    public final Context A;
    public final i B;
    public final Class<TranscodeType> C;
    public final d D;

    @NonNull
    public j<?, ? super TranscodeType> E;

    @Nullable
    public Object F;

    @Nullable
    public List<c.b.a.q.e<TranscodeType>> G;

    @Nullable
    public h<TranscodeType> H;

    @Nullable
    public h<TranscodeType> I;
    public boolean J = true;
    public boolean K;
    public boolean O;

    /* JADX INFO: compiled from: RequestBuilder.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f234b;

        static {
            f.values();
            int[] iArr = new int[4];
            f234b = iArr;
            try {
                iArr[f.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f234b[f.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f234b[f.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f234b[f.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        new c.b.a.q.f().f(k.f420b).o(f.LOW).s(true);
    }

    @SuppressLint({"CheckResult"})
    public h(@NonNull b bVar, i iVar, Class<TranscodeType> cls, Context context) {
        c.b.a.q.f fVar;
        this.B = iVar;
        this.C = cls;
        this.A = context;
        d dVar = iVar.f235b.f198e;
        j jVar = dVar.f220g.get(cls);
        if (jVar == null) {
            for (Map.Entry<Class<?>, j<?, ?>> entry : dVar.f220g.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    jVar = (j) entry.getValue();
                }
            }
        }
        this.E = jVar == null ? d.a : jVar;
        this.D = bVar.f198e;
        Iterator<c.b.a.q.e<Object>> it = iVar.f243j.iterator();
        while (it.hasNext()) {
            x((c.b.a.q.e) it.next());
        }
        synchronized (iVar) {
            fVar = iVar.f244k;
        }
        a(fVar);
    }

    @Override // c.b.a.q.a
    @CheckResult
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h<TranscodeType> d() {
        h<TranscodeType> hVar = (h) super.d();
        hVar.E = hVar.E.a();
        if (hVar.G != null) {
            hVar.G = new ArrayList(hVar.G);
        }
        h<TranscodeType> hVar2 = hVar.H;
        if (hVar2 != null) {
            hVar.H = hVar2.clone();
        }
        h<TranscodeType> hVar3 = hVar.I;
        if (hVar3 != null) {
            hVar.I = hVar3.clone();
        }
        return hVar;
    }

    @NonNull
    public final f B(@NonNull f fVar) {
        int iOrdinal = fVar.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return f.IMMEDIATE;
        }
        if (iOrdinal == 2) {
            return f.HIGH;
        }
        if (iOrdinal == 3) {
            return f.NORMAL;
        }
        StringBuilder sbR = c.a.a.a.a.r("unknown priority: ");
        sbR.append(this.f624d);
        throw new IllegalArgumentException(sbR.toString());
    }

    @NonNull
    public <Y extends c.b.a.q.j.h<TranscodeType>> Y C(@NonNull Y y) {
        D(y, null, this, c.b.a.s.d.a);
        return y;
    }

    public final <Y extends c.b.a.q.j.h<TranscodeType>> Y D(@NonNull Y y, @Nullable c.b.a.q.e<TranscodeType> eVar, c.b.a.q.a<?> aVar, Executor executor) {
        Objects.requireNonNull(y, "Argument must not be null");
        if (!this.K) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        c.b.a.q.c cVarZ = z(new Object(), y, eVar, null, this.E, aVar.f624d, aVar.f631k, aVar.f630j, aVar, executor);
        c.b.a.q.c cVarF = y.f();
        if (cVarZ.c(cVarF)) {
            if (!(!aVar.f629i && cVarF.i())) {
                Objects.requireNonNull(cVarF, "Argument must not be null");
                if (!cVarF.isRunning()) {
                    cVarF.g();
                }
                return y;
            }
        }
        this.B.j(y);
        y.c(cVarZ);
        i iVar = this.B;
        synchronized (iVar) {
            iVar.f240g.a.add(y);
            r rVar = iVar.f238e;
            rVar.a.add(cVarZ);
            if (rVar.f613c) {
                cVarZ.clear();
                Log.isLoggable("RequestTracker", 2);
                rVar.f612b.add(cVarZ);
            } else {
                cVarZ.g();
            }
        }
        return y;
    }

    @NonNull
    public c.b.a.q.j.i<ImageView, TranscodeType> E(@NonNull ImageView imageView) {
        h<TranscodeType> hVarK;
        c.b.a.q.j.i<ImageView, TranscodeType> dVar;
        c.b.a.s.i.a();
        Objects.requireNonNull(imageView, "Argument must not be null");
        if (!i(2048) && this.n && imageView.getScaleType() != null) {
            switch (a.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    hVarK = clone().k(l.f519c, new c.b.a.m.r.c.i());
                    break;
                case 2:
                    hVarK = clone().k(l.f518b, new c.b.a.m.r.c.j());
                    hVarK.y = true;
                    break;
                case 3:
                case 4:
                case 5:
                    hVarK = clone().k(l.a, new q());
                    hVarK.y = true;
                    break;
                case 6:
                    hVarK = clone().k(l.f518b, new c.b.a.m.r.c.j());
                    hVarK.y = true;
                    break;
                default:
                    hVarK = this;
                    break;
            }
        } else {
            hVarK = this;
        }
        d dVar2 = this.D;
        Class<TranscodeType> cls = this.C;
        Objects.requireNonNull(dVar2.f217d);
        if (Bitmap.class.equals(cls)) {
            dVar = new c.b.a.q.j.b(imageView);
        } else {
            if (!Drawable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
            }
            dVar = new c.b.a.q.j.d(imageView);
        }
        D(dVar, null, hVarK, c.b.a.s.d.a);
        return dVar;
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> F(@Nullable c.b.a.q.e<TranscodeType> eVar) {
        if (this.v) {
            return clone().F(eVar);
        }
        this.G = null;
        return x(eVar);
    }

    @NonNull
    public final h<TranscodeType> G(@Nullable Object obj) {
        if (this.v) {
            return clone().G(obj);
        }
        this.F = obj;
        this.K = true;
        p();
        return this;
    }

    public final c.b.a.q.c H(Object obj, c.b.a.q.j.h<TranscodeType> hVar, c.b.a.q.e<TranscodeType> eVar, c.b.a.q.a<?> aVar, c.b.a.q.d dVar, j<?, ? super TranscodeType> jVar, f fVar, int i2, int i3, Executor executor) {
        Context context = this.A;
        d dVar2 = this.D;
        return new c.b.a.q.h(context, dVar2, obj, this.F, this.C, aVar, i2, i3, fVar, hVar, eVar, this.G, dVar, dVar2.f221h, jVar.a, executor);
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> I(@Nullable h<TranscodeType> hVar) {
        if (this.v) {
            return clone().I(hVar);
        }
        this.H = hVar;
        p();
        return this;
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> J(@NonNull j<?, ? super TranscodeType> jVar) {
        if (this.v) {
            return clone().J(jVar);
        }
        Objects.requireNonNull(jVar, "Argument must not be null");
        this.E = jVar;
        this.J = false;
        p();
        return this;
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> x(@Nullable c.b.a.q.e<TranscodeType> eVar) {
        if (this.v) {
            return clone().x(eVar);
        }
        if (eVar != null) {
            if (this.G == null) {
                this.G = new ArrayList();
            }
            this.G.add(eVar);
        }
        p();
        return this;
    }

    @Override // c.b.a.q.a
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> a(@NonNull c.b.a.q.a<?> aVar) {
        Objects.requireNonNull(aVar, "Argument must not be null");
        return (h) super.a(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c.b.a.q.c z(java.lang.Object r20, c.b.a.q.j.h<TranscodeType> r21, @androidx.annotation.Nullable c.b.a.q.e<TranscodeType> r22, @androidx.annotation.Nullable c.b.a.q.d r23, c.b.a.j<?, ? super TranscodeType> r24, c.b.a.f r25, int r26, int r27, c.b.a.q.a<?> r28, java.util.concurrent.Executor r29) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.h.z(java.lang.Object, c.b.a.q.j.h, c.b.a.q.e, c.b.a.q.d, c.b.a.j, c.b.a.f, int, int, c.b.a.q.a, java.util.concurrent.Executor):c.b.a.q.c");
    }
}
