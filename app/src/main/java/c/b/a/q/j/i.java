package c.b.a.q.j;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R$id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: ViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class i<T extends View, Z> extends c.b.a.q.j.a<Z> {
    public static int a = R$id.glide_custom_view_target_tag;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f659c;

    /* JADX INFO: compiled from: ViewTarget.java */
    @VisibleForTesting
    public static final class a {

        @Nullable
        @VisibleForTesting
        public static Integer a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<g> f661c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public ViewTreeObserverOnPreDrawListenerC0026a f662d;

        /* JADX INFO: renamed from: c.b.a.q.j.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ViewTarget.java */
        public static final class ViewTreeObserverOnPreDrawListenerC0026a implements ViewTreeObserver.OnPreDrawListener {
            public final WeakReference<a> a;

            public ViewTreeObserverOnPreDrawListenerC0026a(@NonNull a aVar) {
                this.a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    String str = "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                a aVar = this.a.get();
                if (aVar == null || aVar.f661c.isEmpty()) {
                    return true;
                }
                int iD = aVar.d();
                int iC = aVar.c();
                if (!aVar.e(iD, iC)) {
                    return true;
                }
                Iterator it = new ArrayList(aVar.f661c).iterator();
                while (it.hasNext()) {
                    ((g) it.next()).b(iD, iC);
                }
                aVar.a();
                return true;
            }
        }

        public a(@NonNull View view) {
            this.f660b = view;
        }

        public void a() {
            ViewTreeObserver viewTreeObserver = this.f660b.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f662d);
            }
            this.f662d = null;
            this.f661c.clear();
        }

        public final int b(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f660b.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            Log.isLoggable("ViewTarget", 4);
            Context context = this.f660b.getContext();
            if (a == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Objects.requireNonNull(windowManager, "Argument must not be null");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return a.intValue();
        }

        public final int c() {
            int paddingBottom = this.f660b.getPaddingBottom() + this.f660b.getPaddingTop();
            ViewGroup.LayoutParams layoutParams = this.f660b.getLayoutParams();
            return b(this.f660b.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingBottom);
        }

        public final int d() {
            int paddingRight = this.f660b.getPaddingRight() + this.f660b.getPaddingLeft();
            ViewGroup.LayoutParams layoutParams = this.f660b.getLayoutParams();
            return b(this.f660b.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        }

        public final boolean e(int i2, int i3) {
            if (i2 > 0 || i2 == Integer.MIN_VALUE) {
                if (i3 > 0 || i3 == Integer.MIN_VALUE) {
                    return true;
                }
            }
            return false;
        }
    }

    public i(@NonNull T t) {
        Objects.requireNonNull(t, "Argument must not be null");
        this.f658b = t;
        this.f659c = new a(t);
    }

    @Override // c.b.a.q.j.h
    @CallSuper
    public void a(@NonNull g gVar) {
        this.f659c.f661c.remove(gVar);
    }

    @Override // c.b.a.q.j.h
    public void c(@Nullable c.b.a.q.c cVar) {
        this.f658b.setTag(a, cVar);
    }

    @Override // c.b.a.q.j.h
    @Nullable
    public c.b.a.q.c f() {
        Object tag = this.f658b.getTag(a);
        if (tag == null) {
            return null;
        }
        if (tag instanceof c.b.a.q.c) {
            return (c.b.a.q.c) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // c.b.a.q.j.h
    @CallSuper
    public void h(@NonNull g gVar) {
        a aVar = this.f659c;
        int iD = aVar.d();
        int iC = aVar.c();
        if (aVar.e(iD, iC)) {
            ((c.b.a.q.h) gVar).b(iD, iC);
            return;
        }
        if (!aVar.f661c.contains(gVar)) {
            aVar.f661c.add(gVar);
        }
        if (aVar.f662d == null) {
            ViewTreeObserver viewTreeObserver = aVar.f660b.getViewTreeObserver();
            a.ViewTreeObserverOnPreDrawListenerC0026a viewTreeObserverOnPreDrawListenerC0026a = new a.ViewTreeObserverOnPreDrawListenerC0026a(aVar);
            aVar.f662d = viewTreeObserverOnPreDrawListenerC0026a;
            viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0026a);
        }
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("Target for: ");
        sbR.append(this.f658b);
        return sbR.toString();
    }
}
