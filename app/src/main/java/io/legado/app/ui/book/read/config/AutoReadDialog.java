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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.g.d.i.r1.v1;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.databinding.DialogAutoReadBinding;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.lib.theme.view.ATESeekBar;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.book.read.config.AutoReadDialog;
import io.legado.app.ui.book.read.config.ReadAloudConfigDialog;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AutoReadDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lio/legado/app/ui/book/read/config/AutoReadDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Lf/v;", "onStart", "()V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lio/legado/app/ui/book/read/config/AutoReadDialog$a;", ai.aD, "Lio/legado/app/ui/book/read/config/AutoReadDialog$a;", "getCallBack", "()Lio/legado/app/ui/book/read/config/AutoReadDialog$a;", "setCallBack", "(Lio/legado/app/ui/book/read/config/AutoReadDialog$a;)V", "callBack", "Lio/legado/app/databinding/DialogAutoReadBinding;", "d", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "Q", "()Lio/legado/app/databinding/DialogAutoReadBinding;", "binding", "<init>", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AutoReadDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a callBack;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new b());

    /* JADX INFO: compiled from: AutoReadDialog.kt */
    public interface a {
        void c();

        void i();

        void m();
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class b extends k implements l<AutoReadDialog, DialogAutoReadBinding> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogAutoReadBinding invoke(@NotNull AutoReadDialog autoReadDialog) {
            j.e(autoReadDialog, "fragment");
            View viewRequireView = autoReadDialog.requireView();
            int i2 = R.id.iv_auto_page_stop;
            AppCompatImageView appCompatImageView = (AppCompatImageView) viewRequireView.findViewById(R.id.iv_auto_page_stop);
            if (appCompatImageView != null) {
                i2 = R.id.iv_catalog;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewRequireView.findViewById(R.id.iv_catalog);
                if (appCompatImageView2 != null) {
                    i2 = R.id.iv_main_menu;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) viewRequireView.findViewById(R.id.iv_main_menu);
                    if (appCompatImageView3 != null) {
                        i2 = R.id.iv_setting;
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) viewRequireView.findViewById(R.id.iv_setting);
                        if (appCompatImageView4 != null) {
                            i2 = R.id.ll_auto_page_stop;
                            LinearLayout linearLayout = (LinearLayout) viewRequireView.findViewById(R.id.ll_auto_page_stop);
                            if (linearLayout != null) {
                                i2 = R.id.ll_catalog;
                                LinearLayout linearLayout2 = (LinearLayout) viewRequireView.findViewById(R.id.ll_catalog);
                                if (linearLayout2 != null) {
                                    i2 = R.id.ll_main_menu;
                                    LinearLayout linearLayout3 = (LinearLayout) viewRequireView.findViewById(R.id.ll_main_menu);
                                    if (linearLayout3 != null) {
                                        i2 = R.id.ll_setting;
                                        LinearLayout linearLayout4 = (LinearLayout) viewRequireView.findViewById(R.id.ll_setting);
                                        if (linearLayout4 != null) {
                                            i2 = R.id.ll_tts_SpeechRate;
                                            LinearLayout linearLayout5 = (LinearLayout) viewRequireView.findViewById(R.id.ll_tts_SpeechRate);
                                            if (linearLayout5 != null) {
                                                i2 = R.id.seek_auto_read;
                                                ATESeekBar aTESeekBar = (ATESeekBar) viewRequireView.findViewById(R.id.seek_auto_read);
                                                if (aTESeekBar != null) {
                                                    i2 = R.id.tv_auto_page_stop;
                                                    TextView textView = (TextView) viewRequireView.findViewById(R.id.tv_auto_page_stop);
                                                    if (textView != null) {
                                                        i2 = R.id.tv_catalog;
                                                        TextView textView2 = (TextView) viewRequireView.findViewById(R.id.tv_catalog);
                                                        if (textView2 != null) {
                                                            i2 = R.id.tv_main_menu;
                                                            TextView textView3 = (TextView) viewRequireView.findViewById(R.id.tv_main_menu);
                                                            if (textView3 != null) {
                                                                i2 = R.id.tv_read_speed;
                                                                TextView textView4 = (TextView) viewRequireView.findViewById(R.id.tv_read_speed);
                                                                if (textView4 != null) {
                                                                    i2 = R.id.tv_read_speed_title;
                                                                    TextView textView5 = (TextView) viewRequireView.findViewById(R.id.tv_read_speed_title);
                                                                    if (textView5 != null) {
                                                                        i2 = R.id.tv_setting;
                                                                        TextView textView6 = (TextView) viewRequireView.findViewById(R.id.tv_setting);
                                                                        if (textView6 != null) {
                                                                            return new DialogAutoReadBinding((LinearLayout) viewRequireView, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, aTESeekBar, textView, textView2, textView3, textView4, textView5, textView6);
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
        q qVar = new q(v.a(AutoReadDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogAutoReadBinding;");
        Objects.requireNonNull(v.a);
        f7165b = new h[]{qVar};
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
        Q().a.setBackgroundColor(iT1);
        Q().o.setTextColor(iS2);
        Q().n.setTextColor(iS2);
        Q().f6573c.setColorFilter(iS2);
        Q().f6582l.setTextColor(iS2);
        Q().f6574d.setColorFilter(iS2);
        Q().m.setTextColor(iS2);
        Q().f6572b.setColorFilter(iS2);
        Q().f6581k.setTextColor(iS2);
        Q().f6575e.setColorFilter(iS2);
        Q().p.setTextColor(iS2);
        Q().f6580j.setOnSeekBarChangeListener(new v1(this));
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        int autoReadSpeed = readBookConfig.getAutoReadSpeed() >= 10 ? readBookConfig.getAutoReadSpeed() : 10;
        TextView textView = Q().n;
        String str = String.format("%ds", Arrays.copyOf(new Object[]{Integer.valueOf(autoReadSpeed)}, 1));
        j.d(str, "java.lang.String.format(format, *args)");
        textView.setText(str);
        Q().f6580j.setProgress(autoReadSpeed);
        Q().f6578h.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AutoReadDialog autoReadDialog = this.a;
                f.f0.h<Object>[] hVarArr = AutoReadDialog.f7165b;
                f.c0.c.j.e(autoReadDialog, "this$0");
                AutoReadDialog.a aVar = autoReadDialog.callBack;
                if (aVar != null) {
                    aVar.m();
                }
                autoReadDialog.dismissAllowingStateLoss();
            }
        });
        Q().f6579i.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AutoReadDialog autoReadDialog = this.a;
                f.f0.h<Object>[] hVarArr = AutoReadDialog.f7165b;
                f.c0.c.j.e(autoReadDialog, "this$0");
                new ReadAloudConfigDialog().show(autoReadDialog.getChildFragmentManager(), "readAloudConfigDialog");
            }
        });
        Q().f6577g.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AutoReadDialog autoReadDialog = this.a;
                f.f0.h<Object>[] hVarArr = AutoReadDialog.f7165b;
                f.c0.c.j.e(autoReadDialog, "this$0");
                AutoReadDialog.a aVar = autoReadDialog.callBack;
                if (aVar == null) {
                    return;
                }
                aVar.c();
            }
        });
        Q().f6576f.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AutoReadDialog autoReadDialog = this.a;
                f.f0.h<Object>[] hVarArr = AutoReadDialog.f7165b;
                f.c0.c.j.e(autoReadDialog, "this$0");
                AutoReadDialog.a aVar = autoReadDialog.callBack;
                if (aVar != null) {
                    aVar.i();
                }
                autoReadDialog.dismissAllowingStateLoss();
            }
        });
    }

    public final DialogAutoReadBinding Q() {
        return (DialogAutoReadBinding) this.binding.b(this, f7165b[0]);
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
        return inflater.inflate(R.layout.dialog_auto_read, container);
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
