package io.legado.app.ui.book.read.config;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.KeyEventDispatcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.umeng.analytics.pro.ai;
import e.a.a.d.e;
import e.a.a.g.d.i.r1.j3;
import e.a.a.g.d.i.r1.k3;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.f0.h;
import f.v;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.databinding.DialogReadAloudBinding;
import io.legado.app.lib.theme.view.ATESeekBar;
import io.legado.app.lib.theme.view.ATESwitch;
import io.legado.app.service.BaseReadAloudService;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.book.read.config.ReadAloudConfigDialog;
import io.legado.app.ui.book.read.config.ReadAloudDialog;
import io.legado.app.utils.EventBusExtensionsKt$observeEvent$o$2;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadAloudDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u0004R\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lio/legado/app/ui/book/read/config/ReadAloudDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Lf/v;", "onStart", "()V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "O", "R", "", "timeMinute", ExifInterface.LATITUDE_SOUTH, "(I)V", ExifInterface.GPS_DIRECTION_TRUE, "Lio/legado/app/databinding/DialogReadAloudBinding;", "d", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "Q", "()Lio/legado/app/databinding/DialogReadAloudBinding;", "binding", "Lio/legado/app/ui/book/read/config/ReadAloudDialog$a;", ai.aD, "Lio/legado/app/ui/book/read/config/ReadAloudDialog$a;", "callBack", "<init>", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReadAloudDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a callBack;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new d());

    /* JADX INFO: compiled from: ReadAloudDialog.kt */
    public interface a {
        void c();

        void f();

        void finish();

        void m();
    }

    /* JADX INFO: compiled from: ReadAloudDialog.kt */
    public static final class b extends k implements l<Integer, v> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            ReadAloudDialog readAloudDialog = ReadAloudDialog.this;
            h<Object>[] hVarArr = ReadAloudDialog.f7188b;
            readAloudDialog.R();
        }
    }

    /* JADX INFO: compiled from: ReadAloudDialog.kt */
    public static final class c extends k implements l<Integer, v> {
        public c() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            ReadAloudDialog readAloudDialog = ReadAloudDialog.this;
            h<Object>[] hVarArr = ReadAloudDialog.f7188b;
            readAloudDialog.Q().q.setProgress(i2);
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class d extends k implements l<ReadAloudDialog, DialogReadAloudBinding> {
        public d() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogReadAloudBinding invoke(@NotNull ReadAloudDialog readAloudDialog) {
            j.e(readAloudDialog, "fragment");
            View viewRequireView = readAloudDialog.requireView();
            int i2 = R.id.cb_tts_follow_sys;
            ATESwitch aTESwitch = (ATESwitch) viewRequireView.findViewById(R.id.cb_tts_follow_sys);
            if (aTESwitch != null) {
                i2 = R.id.iv_catalog;
                AppCompatImageView appCompatImageView = (AppCompatImageView) viewRequireView.findViewById(R.id.iv_catalog);
                if (appCompatImageView != null) {
                    i2 = R.id.iv_main_menu;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewRequireView.findViewById(R.id.iv_main_menu);
                    if (appCompatImageView2 != null) {
                        i2 = R.id.iv_play_next;
                        ImageView imageView = (ImageView) viewRequireView.findViewById(R.id.iv_play_next);
                        if (imageView != null) {
                            i2 = R.id.iv_play_pause;
                            ImageView imageView2 = (ImageView) viewRequireView.findViewById(R.id.iv_play_pause);
                            if (imageView2 != null) {
                                i2 = R.id.iv_play_prev;
                                ImageView imageView3 = (ImageView) viewRequireView.findViewById(R.id.iv_play_prev);
                                if (imageView3 != null) {
                                    i2 = R.id.iv_setting;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) viewRequireView.findViewById(R.id.iv_setting);
                                    if (appCompatImageView3 != null) {
                                        i2 = R.id.iv_stop;
                                        ImageView imageView4 = (ImageView) viewRequireView.findViewById(R.id.iv_stop);
                                        if (imageView4 != null) {
                                            i2 = R.id.iv_timer;
                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) viewRequireView.findViewById(R.id.iv_timer);
                                            if (appCompatImageView4 != null) {
                                                i2 = R.id.iv_to_backstage;
                                                AppCompatImageView appCompatImageView5 = (AppCompatImageView) viewRequireView.findViewById(R.id.iv_to_backstage);
                                                if (appCompatImageView5 != null) {
                                                    i2 = R.id.ll_catalog;
                                                    LinearLayout linearLayout = (LinearLayout) viewRequireView.findViewById(R.id.ll_catalog);
                                                    if (linearLayout != null) {
                                                        i2 = R.id.ll_main_menu;
                                                        LinearLayout linearLayout2 = (LinearLayout) viewRequireView.findViewById(R.id.ll_main_menu);
                                                        if (linearLayout2 != null) {
                                                            i2 = R.id.ll_setting;
                                                            LinearLayout linearLayout3 = (LinearLayout) viewRequireView.findViewById(R.id.ll_setting);
                                                            if (linearLayout3 != null) {
                                                                i2 = R.id.ll_to_backstage;
                                                                LinearLayout linearLayout4 = (LinearLayout) viewRequireView.findViewById(R.id.ll_to_backstage);
                                                                if (linearLayout4 != null) {
                                                                    i2 = R.id.ll_tts_SpeechRate;
                                                                    LinearLayout linearLayout5 = (LinearLayout) viewRequireView.findViewById(R.id.ll_tts_SpeechRate);
                                                                    if (linearLayout5 != null) {
                                                                        LinearLayout linearLayout6 = (LinearLayout) viewRequireView;
                                                                        i2 = R.id.seek_timer;
                                                                        ATESeekBar aTESeekBar = (ATESeekBar) viewRequireView.findViewById(R.id.seek_timer);
                                                                        if (aTESeekBar != null) {
                                                                            i2 = R.id.seek_tts_SpeechRate;
                                                                            ATESeekBar aTESeekBar2 = (ATESeekBar) viewRequireView.findViewById(R.id.seek_tts_SpeechRate);
                                                                            if (aTESeekBar2 != null) {
                                                                                i2 = R.id.tv_catalog;
                                                                                TextView textView = (TextView) viewRequireView.findViewById(R.id.tv_catalog);
                                                                                if (textView != null) {
                                                                                    i2 = R.id.tv_main_menu;
                                                                                    TextView textView2 = (TextView) viewRequireView.findViewById(R.id.tv_main_menu);
                                                                                    if (textView2 != null) {
                                                                                        i2 = R.id.tv_next;
                                                                                        TextView textView3 = (TextView) viewRequireView.findViewById(R.id.tv_next);
                                                                                        if (textView3 != null) {
                                                                                            i2 = R.id.tv_pre;
                                                                                            TextView textView4 = (TextView) viewRequireView.findViewById(R.id.tv_pre);
                                                                                            if (textView4 != null) {
                                                                                                i2 = R.id.tv_setting;
                                                                                                TextView textView5 = (TextView) viewRequireView.findViewById(R.id.tv_setting);
                                                                                                if (textView5 != null) {
                                                                                                    i2 = R.id.tv_timer;
                                                                                                    TextView textView6 = (TextView) viewRequireView.findViewById(R.id.tv_timer);
                                                                                                    if (textView6 != null) {
                                                                                                        i2 = R.id.tv_to_backstage;
                                                                                                        TextView textView7 = (TextView) viewRequireView.findViewById(R.id.tv_to_backstage);
                                                                                                        if (textView7 != null) {
                                                                                                            i2 = R.id.tv_tts_speed;
                                                                                                            TextView textView8 = (TextView) viewRequireView.findViewById(R.id.tv_tts_speed);
                                                                                                            if (textView8 != null) {
                                                                                                                return new DialogReadAloudBinding(linearLayout6, aTESwitch, appCompatImageView, appCompatImageView2, imageView, imageView2, imageView3, appCompatImageView3, imageView4, appCompatImageView4, appCompatImageView5, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, aTESeekBar, aTESeekBar2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    static {
        q qVar = new q(f.c0.c.v.a(ReadAloudDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogReadAloudBinding;");
        Objects.requireNonNull(f.c0.c.v.a);
        f7188b = new h[]{qVar};
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void O() {
        String[] strArr = {"aloud_state"};
        EventBusExtensionsKt$observeEvent$o$2 eventBusExtensionsKt$observeEvent$o$2 = new EventBusExtensionsKt$observeEvent$o$2(new b());
        for (int i2 = 0; i2 < 1; i2++) {
            Observable observable = LiveEventBus.get(strArr[i2], Integer.class);
            j.d(observable, "get(tag, EVENT::class.java)");
            observable.observe(this, eventBusExtensionsKt$observeEvent$o$2);
        }
        String[] strArr2 = {"ttsDs"};
        EventBusExtensionsKt$observeEvent$o$2 eventBusExtensionsKt$observeEvent$o$22 = new EventBusExtensionsKt$observeEvent$o$2(new c());
        for (int i3 = 0; i3 < 1; i3++) {
            Observable observable2 = LiveEventBus.get(strArr2[i3], Integer.class);
            j.d(observable2, "get(tag, EVENT::class.java)");
            observable2.observe(this, eventBusExtensionsKt$observeEvent$o$22);
        }
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        int iT1 = f.T1(contextRequireContext);
        boolean z = ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d;
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        int iS2 = f.S2(contextRequireContext2, z);
        DialogReadAloudBinding dialogReadAloudBindingQ = Q();
        dialogReadAloudBindingQ.p.setBackgroundColor(iT1);
        dialogReadAloudBindingQ.v.setTextColor(iS2);
        dialogReadAloudBindingQ.u.setTextColor(iS2);
        dialogReadAloudBindingQ.f6632g.setColorFilter(iS2);
        dialogReadAloudBindingQ.f6631f.setColorFilter(iS2);
        dialogReadAloudBindingQ.f6630e.setColorFilter(iS2);
        dialogReadAloudBindingQ.f6634i.setColorFilter(iS2);
        dialogReadAloudBindingQ.f6635j.setColorFilter(iS2);
        dialogReadAloudBindingQ.x.setTextColor(iS2);
        dialogReadAloudBindingQ.z.setTextColor(iS2);
        dialogReadAloudBindingQ.f6628c.setColorFilter(iS2);
        dialogReadAloudBindingQ.s.setTextColor(iS2);
        dialogReadAloudBindingQ.f6629d.setColorFilter(iS2);
        dialogReadAloudBindingQ.t.setTextColor(iS2);
        dialogReadAloudBindingQ.f6636k.setColorFilter(iS2);
        dialogReadAloudBindingQ.y.setTextColor(iS2);
        dialogReadAloudBindingQ.f6633h.setColorFilter(iS2);
        dialogReadAloudBindingQ.w.setTextColor(iS2);
        dialogReadAloudBindingQ.f6627b.setTextColor(iS2);
        DialogReadAloudBinding dialogReadAloudBindingQ2 = Q();
        R();
        S(BaseReadAloudService.f6928c);
        dialogReadAloudBindingQ2.q.setProgress(BaseReadAloudService.f6928c);
        ATESwitch aTESwitch = dialogReadAloudBindingQ2.f6627b;
        Context contextRequireContext3 = requireContext();
        j.d(contextRequireContext3, "requireContext()");
        aTESwitch.setChecked(f.J2(contextRequireContext3, "ttsFollowSys", true));
        dialogReadAloudBindingQ2.r.setEnabled(true ^ dialogReadAloudBindingQ2.f6627b.isChecked());
        dialogReadAloudBindingQ2.r.setProgress(e.a.l());
        final DialogReadAloudBinding dialogReadAloudBindingQ3 = Q();
        dialogReadAloudBindingQ3.m.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadAloudDialog readAloudDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
                f.c0.c.j.e(readAloudDialog, "this$0");
                ReadAloudDialog.a aVar = readAloudDialog.callBack;
                if (aVar != null) {
                    aVar.m();
                }
                readAloudDialog.dismissAllowingStateLoss();
            }
        });
        dialogReadAloudBindingQ3.n.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadAloudDialog readAloudDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
                f.c0.c.j.e(readAloudDialog, "this$0");
                new ReadAloudConfigDialog().show(readAloudDialog.getChildFragmentManager(), "readAloudConfigDialog");
            }
        });
        dialogReadAloudBindingQ3.v.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IllegalAccessException, InvocationTargetException {
                f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
                e.a.a.f.s.k.a.m(true, false);
            }
        });
        dialogReadAloudBindingQ3.u.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IllegalAccessException, InvocationTargetException {
                f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
                e.a.a.f.s.k.a.k(true);
            }
        });
        dialogReadAloudBindingQ3.f6634i.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadAloudDialog readAloudDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
                f.c0.c.j.e(readAloudDialog, "this$0");
                e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
                Context contextRequireContext4 = readAloudDialog.requireContext();
                f.c0.c.j.d(contextRequireContext4, "requireContext()");
                e.a.a.f.s.j.f(contextRequireContext4);
                readAloudDialog.dismissAllowingStateLoss();
            }
        });
        dialogReadAloudBindingQ3.f6631f.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadAloudDialog readAloudDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
                f.c0.c.j.e(readAloudDialog, "this$0");
                ReadAloudDialog.a aVar = readAloudDialog.callBack;
                if (aVar == null) {
                    return;
                }
                aVar.f();
            }
        });
        dialogReadAloudBindingQ3.f6632g.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadAloudDialog readAloudDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
                f.c0.c.j.e(readAloudDialog, "this$0");
                e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
                Context contextRequireContext4 = readAloudDialog.requireContext();
                f.c0.c.j.d(contextRequireContext4, "requireContext()");
                e.a.a.f.s.j.d(contextRequireContext4);
            }
        });
        dialogReadAloudBindingQ3.f6630e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadAloudDialog readAloudDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
                f.c0.c.j.e(readAloudDialog, "this$0");
                e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
                Context contextRequireContext4 = readAloudDialog.requireContext();
                f.c0.c.j.d(contextRequireContext4, "requireContext()");
                e.a.a.f.s.j.b(contextRequireContext4);
            }
        });
        dialogReadAloudBindingQ3.f6637l.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadAloudDialog readAloudDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
                f.c0.c.j.e(readAloudDialog, "this$0");
                ReadAloudDialog.a aVar = readAloudDialog.callBack;
                if (aVar == null) {
                    return;
                }
                aVar.c();
            }
        });
        dialogReadAloudBindingQ3.o.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReadAloudDialog readAloudDialog = this.a;
                f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
                f.c0.c.j.e(readAloudDialog, "this$0");
                ReadAloudDialog.a aVar = readAloudDialog.callBack;
                if (aVar == null) {
                    return;
                }
                aVar.finish();
            }
        });
        dialogReadAloudBindingQ3.f6627b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.d.i.r1.f0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                ReadAloudDialog readAloudDialog = this.a;
                DialogReadAloudBinding dialogReadAloudBinding = dialogReadAloudBindingQ3;
                f.f0.h<Object>[] hVarArr = ReadAloudDialog.f7188b;
                f.c0.c.j.e(readAloudDialog, "this$0");
                f.c0.c.j.e(dialogReadAloudBinding, "$this_with");
                Context contextRequireContext4 = readAloudDialog.requireContext();
                f.c0.c.j.d(contextRequireContext4, "requireContext()");
                c.b.a.m.f.o4(contextRequireContext4, "ttsFollowSys", z2);
                dialogReadAloudBinding.r.setEnabled(!z2);
                readAloudDialog.T();
            }
        });
        dialogReadAloudBindingQ3.r.setOnSeekBarChangeListener(new j3(this));
        dialogReadAloudBindingQ3.q.setOnSeekBarChangeListener(new k3(this, dialogReadAloudBindingQ3));
    }

    public final DialogReadAloudBinding Q() {
        return (DialogReadAloudBinding) this.binding.b(this, f7188b[0]);
    }

    public final void R() {
        if (BaseReadAloudService.f6929d) {
            Q().f6631f.setImageResource(R.drawable.ic_play_24dp);
        } else {
            Q().f6631f.setImageResource(R.drawable.ic_pause_24dp);
        }
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        int iT1 = f.T1(contextRequireContext);
        boolean z = ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d;
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        Q().f6631f.setColorFilter(f.S2(contextRequireContext2, z));
    }

    public final void S(int timeMinute) {
        Q().x.setText(requireContext().getString(R.string.timer_m, Integer.valueOf(timeMinute)));
    }

    public final void T() {
        e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        e.a.a.f.s.j.g(contextRequireContext);
        if (BaseReadAloudService.f6929d) {
            return;
        }
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        e.a.a.f.s.j.c(contextRequireContext2);
        Context contextRequireContext3 = requireContext();
        j.d(contextRequireContext3, "requireContext()");
        e.a.a.f.s.j.e(contextRequireContext3);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type io.legado.app.ui.book.read.ReadBookActivity");
        ((ReadBookActivity) activity).bottomDialog++;
        KeyEventDispatcher.Component activity2 = getActivity();
        this.callBack = activity2 instanceof a ? (a) activity2 : null;
        return inflater.inflate(R.layout.dialog_read_aloud, container);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        j.e(dialog, "dialog");
        super.onDismiss(dialog);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type io.legado.app.ui.book.read.ReadBookActivity");
        ReadBookActivity readBookActivity = (ReadBookActivity) activity;
        readBookActivity.bottomDialog--;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.clearFlags(2);
        window.setBackgroundDrawableResource(R.color.background);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        window.setLayout(-1, -2);
    }
}
