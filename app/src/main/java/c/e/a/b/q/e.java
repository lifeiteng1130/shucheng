package c.e.a.b.q;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TextDrawableHelper.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1121c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public WeakReference<b> f1123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public c.e.a.b.t.b f1124f;
    public final TextPaint a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.e.a.b.t.d f1120b = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1122d = true;

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    public class a extends c.e.a.b.t.d {
        public a() {
        }

        @Override // c.e.a.b.t.d
        public void a(int i2) {
            e eVar = e.this;
            eVar.f1122d = true;
            b bVar = eVar.f1123e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // c.e.a.b.t.d
        public void b(@NonNull Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            e eVar = e.this;
            eVar.f1122d = true;
            b bVar = eVar.f1123e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    public interface b {
        void a();

        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public e(@Nullable b bVar) {
        this.f1123e = new WeakReference<>(null);
        this.f1123e = new WeakReference<>(bVar);
    }

    public float a(String str) {
        if (!this.f1122d) {
            return this.f1121c;
        }
        float fMeasureText = str == null ? 0.0f : this.a.measureText((CharSequence) str, 0, str.length());
        this.f1121c = fMeasureText;
        this.f1122d = false;
        return fMeasureText;
    }

    public void b(@Nullable c.e.a.b.t.b bVar, Context context) {
        if (this.f1124f != bVar) {
            this.f1124f = bVar;
            if (bVar != null) {
                TextPaint textPaint = this.a;
                c.e.a.b.t.d dVar = this.f1120b;
                bVar.a();
                bVar.d(textPaint, bVar.n);
                bVar.b(context, new c.e.a.b.t.c(bVar, textPaint, dVar));
                b bVar2 = this.f1123e.get();
                if (bVar2 != null) {
                    this.a.drawableState = bVar2.getState();
                }
                bVar.c(context, this.a, this.f1120b);
                this.f1122d = true;
            }
            b bVar3 = this.f1123e.get();
            if (bVar3 != null) {
                bVar3.a();
                bVar3.onStateChange(bVar3.getState());
            }
        }
    }
}
