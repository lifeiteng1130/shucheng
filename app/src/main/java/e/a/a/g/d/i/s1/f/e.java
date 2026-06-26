package e.a.a.g.d.i.s1.f;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import androidx.annotation.CallSuper;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import e.a.a.h.n;
import f.c0.c.j;
import f.c0.c.k;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.SwitchConfig;
import io.legado.app.ui.book.info.BookEndActivity;
import io.legado.app.ui.book.read.page.PageView;
import io.legado.app.ui.book.read.page.ReadView;
import io.wenyuange.app.release.R;
import java.lang.reflect.Type;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PageDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    @NotNull
    public final ReadView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Context f5755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final f.e f5758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final f.e f5759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public e.a.a.g.d.i.s1.g.a f5761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5764k;

    /* JADX INFO: compiled from: PageDelegate.kt */
    public static final class a extends k implements f.c0.b.a<Scroller> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final Scroller invoke() {
            return new Scroller(e.this.a.getContext(), new LinearInterpolator());
        }
    }

    /* JADX INFO: compiled from: PageDelegate.kt */
    public static final class b extends k implements f.c0.b.a<Snackbar> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final Snackbar invoke() {
            Snackbar snackbarL = Snackbar.l(e.this.a, "", -1);
            j.d(snackbarL, "make(readView, \"\", Snackbar.LENGTH_SHORT)");
            return snackbarL;
        }
    }

    public e(@NotNull ReadView readView) {
        j.e(readView, "readView");
        this.a = readView;
        Context context = readView.getContext();
        j.d(context, "readView.context");
        this.f5755b = context;
        this.f5756c = readView.getWidth();
        this.f5757d = readView.getHeight();
        this.f5758e = c.b.a.m.f.N3(new a());
        this.f5759f = c.b.a.m.f.N3(new b());
        this.f5761h = e.a.a.g.d.i.s1.g.a.NONE;
        a().d();
    }

    @NotNull
    public final PageView a() {
        return this.a.getCurPage();
    }

    @NotNull
    public final Scroller b() {
        return (Scroller) this.f5758e.getValue();
    }

    public final Snackbar c() {
        return (Snackbar) this.f5759f.getValue();
    }

    public final float d() {
        return this.a.getStartX();
    }

    public final float e() {
        return this.a.getStartY();
    }

    public final float f() {
        return this.a.getTouchX();
    }

    public final float g() {
        return this.a.getTouchY();
    }

    public final boolean h() {
        SwitchConfig switchConfig;
        boolean zBooleanValue;
        Object objM11constructorimpl;
        boolean zD = this.a.getPageFactory().d();
        if (!zD) {
            this.a.getCallBack().i();
            Context context = this.f5755b;
            if (context == null) {
                zBooleanValue = false;
            } else {
                j.e(context, com.umeng.analytics.pro.c.R);
                try {
                    String strO2 = c.b.a.m.f.O2(context, "switchConfig", null, 2);
                    if (strO2 == null) {
                        switchConfig = new SwitchConfig();
                    } else {
                        Gson gsonA = n.a();
                        try {
                            Type type = new e.a.a.d.w.e().getType();
                            j.d(type, "object : TypeToken<T>() {}.type");
                            Object objFromJson = gsonA.fromJson(strO2, type);
                            if (!(objFromJson instanceof SwitchConfig)) {
                                objFromJson = null;
                            }
                            objM11constructorimpl = f.h.m11constructorimpl((SwitchConfig) objFromJson);
                        } catch (Throwable th) {
                            objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
                        }
                        if (f.h.m16isFailureimpl(objM11constructorimpl)) {
                            objM11constructorimpl = null;
                        }
                        switchConfig = (SwitchConfig) objM11constructorimpl;
                        if (switchConfig == null) {
                            switchConfig = new SwitchConfig();
                        }
                    }
                } catch (Exception unused) {
                    switchConfig = new SwitchConfig();
                }
                zBooleanValue = Boolean.valueOf(switchConfig.getBookRecomand()).booleanValue();
            }
            if (zBooleanValue) {
                ReadView readView = this.a;
                Context context2 = readView.getContext();
                j.d(context2, com.umeng.analytics.pro.c.R);
                Intent intent = new Intent(context2, (Class<?>) BookEndActivity.class);
                intent.addFlags(268435456);
                e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
                Book book = e.a.a.f.s.k.f5677c;
                intent.putExtra("key", book == null ? null : book.getAuthor());
                Book book2 = e.a.a.f.s.k.f5677c;
                intent.putExtra("name", book2 == null ? null : book2.getName());
                Book book3 = e.a.a.f.s.k.f5677c;
                intent.putExtra("author", book3 != null ? book3.getAuthor() : null);
                context2.startActivity(intent);
                AppCompatActivity appCompatActivityO1 = c.b.a.m.f.O1(readView);
                if (appCompatActivityO1 != null) {
                    appCompatActivityO1.overridePendingTransition(R.anim.anim_readbook_left_in, R.anim.anim_readbook_left_out);
                }
            }
            if (!c().j()) {
                Snackbar snackbarC = c();
                snackbarC.n(snackbarC.f2377e.getText(R.string.no_next_page));
                c().o();
            }
        }
        return zD;
    }

    public final boolean i() {
        boolean zE = this.a.getPageFactory().e();
        if (!zE && !c().j()) {
            Snackbar snackbarC = c();
            snackbarC.n(snackbarC.f2377e.getText(R.string.no_prev_page));
            c().o();
        }
        return zE;
    }

    public void j(@NotNull e.a.a.g.d.i.s1.g.a aVar) {
        j.e(aVar, "direction");
        if (this.f5763j) {
            return;
        }
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            r(100);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            k(100);
        }
    }

    public abstract void k(int i2);

    public abstract void l(int i2);

    public abstract void m();

    public abstract void n();

    public abstract void o(@NotNull Canvas canvas);

    public void p() {
    }

    public abstract void q(@NotNull MotionEvent motionEvent);

    public abstract void r(int i2);

    @CallSuper
    public void s(@NotNull e.a.a.g.d.i.s1.g.a aVar) {
        j.e(aVar, "direction");
        this.f5761h = aVar;
    }

    public void t(int i2, int i3) {
        this.f5756c = i2;
        this.f5757d = i3;
    }

    public final void u(int i2, int i3, int i4, int i5, int i6) {
        b().startScroll(i2, i3, i4, i5, i4 != 0 ? (Math.abs(i4) * i6) / this.f5756c : (Math.abs(i5) * i6) / this.f5757d);
        this.f5763j = true;
        this.f5764k = true;
        this.a.invalidate();
    }
}
