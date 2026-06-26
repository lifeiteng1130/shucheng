package io.legado.app.ui.book.read.config;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.umeng.analytics.pro.ai;
import e.a.a.d.r;
import e.a.a.g.d.i.r1.n4;
import e.a.a.g.d.i.r1.o4;
import e.a.a.g.d.i.r1.p4;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.f0.h;
import f.v;
import f.x.e;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.databinding.DialogTipConfigBinding;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.book.read.config.TipConfigDialog;
import io.legado.app.ui.widget.DetailSeekBar;
import io.legado.app.ui.widget.text.AccentTextView;
import io.legado.app.utils.EventBusExtensionsKt$observeEvent$o$2;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TipConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0004R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lio/legado/app/ui/book/read/config/TipConfigDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", ExifInterface.LATITUDE_SOUTH, "Lio/legado/app/databinding/DialogTipConfigBinding;", ai.aD, "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "R", "()Lio/legado/app/databinding/DialogTipConfigBinding;", "binding", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class TipConfigDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new b());

    /* JADX INFO: compiled from: TipConfigDialog.kt */
    public static final class a extends k implements l<String, v> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            j.e(str, "it");
            TipConfigDialog tipConfigDialog = TipConfigDialog.this;
            h<Object>[] hVarArr = TipConfigDialog.f7209b;
            tipConfigDialog.S();
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class b extends k implements l<TipConfigDialog, DialogTipConfigBinding> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogTipConfigBinding invoke(@NotNull TipConfigDialog tipConfigDialog) {
            j.e(tipConfigDialog, "fragment");
            View viewRequireView = tipConfigDialog.requireView();
            int i2 = R.id.dsb_title_bottom;
            DetailSeekBar detailSeekBar = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_title_bottom);
            if (detailSeekBar != null) {
                i2 = R.id.dsb_title_size;
                DetailSeekBar detailSeekBar2 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_title_size);
                if (detailSeekBar2 != null) {
                    i2 = R.id.dsb_title_top;
                    DetailSeekBar detailSeekBar3 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_title_top);
                    if (detailSeekBar3 != null) {
                        i2 = R.id.ll_footer_left;
                        LinearLayout linearLayout = (LinearLayout) viewRequireView.findViewById(R.id.ll_footer_left);
                        if (linearLayout != null) {
                            i2 = R.id.ll_footer_middle;
                            LinearLayout linearLayout2 = (LinearLayout) viewRequireView.findViewById(R.id.ll_footer_middle);
                            if (linearLayout2 != null) {
                                i2 = R.id.ll_footer_right;
                                LinearLayout linearLayout3 = (LinearLayout) viewRequireView.findViewById(R.id.ll_footer_right);
                                if (linearLayout3 != null) {
                                    i2 = R.id.ll_footer_show;
                                    LinearLayout linearLayout4 = (LinearLayout) viewRequireView.findViewById(R.id.ll_footer_show);
                                    if (linearLayout4 != null) {
                                        i2 = R.id.ll_header_left;
                                        LinearLayout linearLayout5 = (LinearLayout) viewRequireView.findViewById(R.id.ll_header_left);
                                        if (linearLayout5 != null) {
                                            i2 = R.id.ll_header_middle;
                                            LinearLayout linearLayout6 = (LinearLayout) viewRequireView.findViewById(R.id.ll_header_middle);
                                            if (linearLayout6 != null) {
                                                i2 = R.id.ll_header_right;
                                                LinearLayout linearLayout7 = (LinearLayout) viewRequireView.findViewById(R.id.ll_header_right);
                                                if (linearLayout7 != null) {
                                                    i2 = R.id.ll_header_show;
                                                    LinearLayout linearLayout8 = (LinearLayout) viewRequireView.findViewById(R.id.ll_header_show);
                                                    if (linearLayout8 != null) {
                                                        i2 = R.id.ll_tip_color;
                                                        LinearLayout linearLayout9 = (LinearLayout) viewRequireView.findViewById(R.id.ll_tip_color);
                                                        if (linearLayout9 != null) {
                                                            i2 = R.id.rb_title_mode1;
                                                            RadioButton radioButton = (RadioButton) viewRequireView.findViewById(R.id.rb_title_mode1);
                                                            if (radioButton != null) {
                                                                i2 = R.id.rb_title_mode2;
                                                                RadioButton radioButton2 = (RadioButton) viewRequireView.findViewById(R.id.rb_title_mode2);
                                                                if (radioButton2 != null) {
                                                                    i2 = R.id.rb_title_mode3;
                                                                    RadioButton radioButton3 = (RadioButton) viewRequireView.findViewById(R.id.rb_title_mode3);
                                                                    if (radioButton3 != null) {
                                                                        i2 = R.id.rg_title_mode;
                                                                        RadioGroup radioGroup = (RadioGroup) viewRequireView.findViewById(R.id.rg_title_mode);
                                                                        if (radioGroup != null) {
                                                                            i2 = R.id.tv_footer_left;
                                                                            TextView textView = (TextView) viewRequireView.findViewById(R.id.tv_footer_left);
                                                                            if (textView != null) {
                                                                                i2 = R.id.tv_footer_middle;
                                                                                TextView textView2 = (TextView) viewRequireView.findViewById(R.id.tv_footer_middle);
                                                                                if (textView2 != null) {
                                                                                    i2 = R.id.tv_footer_right;
                                                                                    TextView textView3 = (TextView) viewRequireView.findViewById(R.id.tv_footer_right);
                                                                                    if (textView3 != null) {
                                                                                        i2 = R.id.tv_footer_show;
                                                                                        TextView textView4 = (TextView) viewRequireView.findViewById(R.id.tv_footer_show);
                                                                                        if (textView4 != null) {
                                                                                            i2 = R.id.tv_header_left;
                                                                                            TextView textView5 = (TextView) viewRequireView.findViewById(R.id.tv_header_left);
                                                                                            if (textView5 != null) {
                                                                                                i2 = R.id.tv_header_middle;
                                                                                                TextView textView6 = (TextView) viewRequireView.findViewById(R.id.tv_header_middle);
                                                                                                if (textView6 != null) {
                                                                                                    i2 = R.id.tv_header_padding;
                                                                                                    AccentTextView accentTextView = (AccentTextView) viewRequireView.findViewById(R.id.tv_header_padding);
                                                                                                    if (accentTextView != null) {
                                                                                                        i2 = R.id.tv_header_right;
                                                                                                        TextView textView7 = (TextView) viewRequireView.findViewById(R.id.tv_header_right);
                                                                                                        if (textView7 != null) {
                                                                                                            i2 = R.id.tv_header_show;
                                                                                                            TextView textView8 = (TextView) viewRequireView.findViewById(R.id.tv_header_show);
                                                                                                            if (textView8 != null) {
                                                                                                                i2 = R.id.tv_tip_color;
                                                                                                                TextView textView9 = (TextView) viewRequireView.findViewById(R.id.tv_tip_color);
                                                                                                                if (textView9 != null) {
                                                                                                                    return new DialogTipConfigBinding((LinearLayout) viewRequireView, detailSeekBar, detailSeekBar2, detailSeekBar3, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, radioButton, radioButton2, radioButton3, radioGroup, textView, textView2, textView3, textView4, textView5, textView6, accentTextView, textView7, textView8, textView9);
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
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    static {
        q qVar = new q(f.c0.c.v.a(TipConfigDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogTipConfigBinding;");
        Objects.requireNonNull(f.c0.c.v.a);
        f7209b = new h[]{qVar};
    }

    public static final r Q(TipConfigDialog tipConfigDialog, int i2) {
        Objects.requireNonNull(tipConfigDialog);
        r rVar = r.a;
        if (i2 != 0) {
            if (rVar.i() == i2) {
                ReadBookConfig.INSTANCE.getConfig().setTipHeaderLeft(0);
                tipConfigDialog.R().s.setText(rVar.l().get(0));
            }
            if (rVar.j() == i2) {
                ReadBookConfig.INSTANCE.getConfig().setTipHeaderMiddle(0);
                tipConfigDialog.R().t.setText(rVar.l().get(0));
            }
            if (rVar.k() == i2) {
                ReadBookConfig.INSTANCE.getConfig().setTipHeaderRight(0);
                tipConfigDialog.R().u.setText(rVar.l().get(0));
            }
            if (rVar.f() == i2) {
                ReadBookConfig.INSTANCE.getConfig().setTipFooterLeft(0);
                tipConfigDialog.R().o.setText(rVar.l().get(0));
            }
            if (rVar.g() == i2) {
                ReadBookConfig.INSTANCE.getConfig().setTipFooterMiddle(0);
                tipConfigDialog.R().p.setText(rVar.l().get(0));
            }
            if (rVar.h() == i2) {
                ReadBookConfig.INSTANCE.getConfig().setTipFooterRight(0);
                tipConfigDialog.R().q.setText(rVar.l().get(0));
            }
        }
        return rVar;
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        DialogTipConfigBinding dialogTipConfigBindingR = R();
        RadioGroup radioGroup = dialogTipConfigBindingR.n;
        j.d(radioGroup, "rgTitleMode");
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        f.M0(radioGroup, readBookConfig.getTitleMode());
        dialogTipConfigBindingR.f6682c.setProgress(readBookConfig.getTitleSize());
        dialogTipConfigBindingR.f6683d.setProgress(readBookConfig.getTitleTopSpacing());
        dialogTipConfigBindingR.f6681b.setProgress(readBookConfig.getTitleBottomSpacing());
        TextView textView = dialogTipConfigBindingR.v;
        r rVar = r.a;
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        textView.setText(rVar.d(contextRequireContext).get(Integer.valueOf(rVar.c())));
        TextView textView2 = dialogTipConfigBindingR.r;
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        textView2.setText(rVar.b(contextRequireContext2).get(Integer.valueOf(rVar.a())));
        TextView textView3 = dialogTipConfigBindingR.s;
        List<String> listL = rVar.l();
        int i2 = rVar.i();
        String str = (i2 < 0 || i2 > e.m(listL)) ? (String) ((List) r.f5555b.getValue()).get(0) : listL.get(i2);
        j.d(str, "tips.getOrElse(tipHeaderLeft) { tips[none] }");
        textView3.setText(str);
        TextView textView4 = dialogTipConfigBindingR.t;
        List<String> listL2 = rVar.l();
        int iJ = rVar.j();
        String str2 = (iJ < 0 || iJ > e.m(listL2)) ? (String) ((List) r.f5555b.getValue()).get(0) : listL2.get(iJ);
        j.d(str2, "tips.getOrElse(tipHeaderMiddle) { tips[none] }");
        textView4.setText(str2);
        TextView textView5 = dialogTipConfigBindingR.u;
        List<String> listL3 = rVar.l();
        int iK = rVar.k();
        String str3 = (iK < 0 || iK > e.m(listL3)) ? (String) ((List) r.f5555b.getValue()).get(0) : listL3.get(iK);
        j.d(str3, "tips.getOrElse(tipHeaderRight) { tips[none] }");
        textView5.setText(str3);
        TextView textView6 = dialogTipConfigBindingR.o;
        List<String> listL4 = rVar.l();
        int iF = rVar.f();
        String str4 = (iF < 0 || iF > e.m(listL4)) ? (String) ((List) r.f5555b.getValue()).get(0) : listL4.get(iF);
        j.d(str4, "tips.getOrElse(tipFooterLeft) { tips[none] }");
        textView6.setText(str4);
        TextView textView7 = dialogTipConfigBindingR.p;
        List<String> listL5 = rVar.l();
        int iG = rVar.g();
        String str5 = (iG < 0 || iG > e.m(listL5)) ? (String) ((List) r.f5555b.getValue()).get(0) : listL5.get(iG);
        j.d(str5, "tips.getOrElse(tipFooterMiddle) { tips[none] }");
        textView7.setText(str5);
        TextView textView8 = dialogTipConfigBindingR.q;
        List<String> listL6 = rVar.l();
        int iH = rVar.h();
        String str6 = (iH < 0 || iH > e.m(listL6)) ? (String) ((List) r.f5555b.getValue()).get(0) : listL6.get(iH);
        j.d(str6, "tips.getOrElse(tipFooterRight) { tips[none] }");
        textView8.setText(str6);
        S();
        final DialogTipConfigBinding dialogTipConfigBindingR2 = R();
        dialogTipConfigBindingR2.n.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: e.a.a.g.d.i.r1.i1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i3) {
                DialogTipConfigBinding dialogTipConfigBinding = dialogTipConfigBindingR2;
                f.f0.h<Object>[] hVarArr = TipConfigDialog.f7209b;
                f.c0.c.j.e(dialogTipConfigBinding, "$this_with");
                ReadBookConfig readBookConfig2 = ReadBookConfig.INSTANCE;
                RadioGroup radioGroup3 = dialogTipConfigBinding.n;
                f.c0.c.j.d(radioGroup3, "rgTitleMode");
                readBookConfig2.setTitleMode(c.b.a.m.f.x2(radioGroup3, i3));
                LiveEventBus.get("upConfig").post(Boolean.TRUE);
            }
        });
        dialogTipConfigBindingR2.f6682c.setOnChanged(n4.INSTANCE);
        dialogTipConfigBindingR2.f6683d.setOnChanged(o4.INSTANCE);
        dialogTipConfigBindingR2.f6681b.setOnChanged(p4.INSTANCE);
        dialogTipConfigBindingR2.f6691l.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TipConfigDialog tipConfigDialog = this.a;
                DialogTipConfigBinding dialogTipConfigBinding = dialogTipConfigBindingR2;
                f.f0.h<Object>[] hVarArr = TipConfigDialog.f7209b;
                f.c0.c.j.e(tipConfigDialog, "this$0");
                f.c0.c.j.e(dialogTipConfigBinding, "$this_with");
                e.a.a.d.r rVar2 = e.a.a.d.r.a;
                Context contextRequireContext3 = tipConfigDialog.requireContext();
                f.c0.c.j.d(contextRequireContext3, "requireContext()");
                LinkedHashMap<Integer, String> linkedHashMapD = rVar2.d(contextRequireContext3);
                Collection<String> collectionValues = linkedHashMapD.values();
                f.c0.c.j.d(collectionValues, "headerModes.values");
                List listF = f.x.e.F(collectionValues);
                q4 q4Var = new q4(linkedHashMapD, dialogTipConfigBinding);
                FragmentActivity activity = tipConfigDialog.getActivity();
                if (activity == null) {
                    return;
                }
                c.b.a.m.f.Z4(activity, null, listF, q4Var);
            }
        });
        dialogTipConfigBindingR2.f6687h.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TipConfigDialog tipConfigDialog = this.a;
                DialogTipConfigBinding dialogTipConfigBinding = dialogTipConfigBindingR2;
                f.f0.h<Object>[] hVarArr = TipConfigDialog.f7209b;
                f.c0.c.j.e(tipConfigDialog, "this$0");
                f.c0.c.j.e(dialogTipConfigBinding, "$this_with");
                e.a.a.d.r rVar2 = e.a.a.d.r.a;
                Context contextRequireContext3 = tipConfigDialog.requireContext();
                f.c0.c.j.d(contextRequireContext3, "requireContext()");
                LinkedHashMap<Integer, String> linkedHashMapB = rVar2.b(contextRequireContext3);
                Collection<String> collectionValues = linkedHashMapB.values();
                f.c0.c.j.d(collectionValues, "footerModes.values");
                List listF = f.x.e.F(collectionValues);
                r4 r4Var = new r4(linkedHashMapB, dialogTipConfigBinding);
                FragmentActivity activity = tipConfigDialog.getActivity();
                if (activity == null) {
                    return;
                }
                c.b.a.m.f.Z4(activity, null, listF, r4Var);
            }
        });
        dialogTipConfigBindingR2.f6688i.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TipConfigDialog tipConfigDialog = this.a;
                DialogTipConfigBinding dialogTipConfigBinding = dialogTipConfigBindingR2;
                f.f0.h<Object>[] hVarArr = TipConfigDialog.f7209b;
                f.c0.c.j.e(tipConfigDialog, "this$0");
                f.c0.c.j.e(dialogTipConfigBinding, "$this_with");
                List<String> listL7 = e.a.a.d.r.a.l();
                s4 s4Var = new s4(tipConfigDialog, dialogTipConfigBinding);
                FragmentActivity activity = tipConfigDialog.getActivity();
                if (activity == null) {
                    return;
                }
                c.b.a.m.f.Z4(activity, null, listL7, s4Var);
            }
        });
        dialogTipConfigBindingR2.f6689j.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TipConfigDialog tipConfigDialog = this.a;
                DialogTipConfigBinding dialogTipConfigBinding = dialogTipConfigBindingR2;
                f.f0.h<Object>[] hVarArr = TipConfigDialog.f7209b;
                f.c0.c.j.e(tipConfigDialog, "this$0");
                f.c0.c.j.e(dialogTipConfigBinding, "$this_with");
                List<String> listL7 = e.a.a.d.r.a.l();
                t4 t4Var = new t4(tipConfigDialog, dialogTipConfigBinding);
                FragmentActivity activity = tipConfigDialog.getActivity();
                if (activity == null) {
                    return;
                }
                c.b.a.m.f.Z4(activity, null, listL7, t4Var);
            }
        });
        dialogTipConfigBindingR2.f6690k.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TipConfigDialog tipConfigDialog = this.a;
                DialogTipConfigBinding dialogTipConfigBinding = dialogTipConfigBindingR2;
                f.f0.h<Object>[] hVarArr = TipConfigDialog.f7209b;
                f.c0.c.j.e(tipConfigDialog, "this$0");
                f.c0.c.j.e(dialogTipConfigBinding, "$this_with");
                List<String> listL7 = e.a.a.d.r.a.l();
                u4 u4Var = new u4(tipConfigDialog, dialogTipConfigBinding);
                FragmentActivity activity = tipConfigDialog.getActivity();
                if (activity == null) {
                    return;
                }
                c.b.a.m.f.Z4(activity, null, listL7, u4Var);
            }
        });
        dialogTipConfigBindingR2.f6684e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TipConfigDialog tipConfigDialog = this.a;
                DialogTipConfigBinding dialogTipConfigBinding = dialogTipConfigBindingR2;
                f.f0.h<Object>[] hVarArr = TipConfigDialog.f7209b;
                f.c0.c.j.e(tipConfigDialog, "this$0");
                f.c0.c.j.e(dialogTipConfigBinding, "$this_with");
                List<String> listL7 = e.a.a.d.r.a.l();
                j4 j4Var = new j4(tipConfigDialog, dialogTipConfigBinding);
                FragmentActivity activity = tipConfigDialog.getActivity();
                if (activity == null) {
                    return;
                }
                c.b.a.m.f.Z4(activity, null, listL7, j4Var);
            }
        });
        dialogTipConfigBindingR2.f6685f.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TipConfigDialog tipConfigDialog = this.a;
                DialogTipConfigBinding dialogTipConfigBinding = dialogTipConfigBindingR2;
                f.f0.h<Object>[] hVarArr = TipConfigDialog.f7209b;
                f.c0.c.j.e(tipConfigDialog, "this$0");
                f.c0.c.j.e(dialogTipConfigBinding, "$this_with");
                List<String> listL7 = e.a.a.d.r.a.l();
                k4 k4Var = new k4(tipConfigDialog, dialogTipConfigBinding);
                FragmentActivity activity = tipConfigDialog.getActivity();
                if (activity == null) {
                    return;
                }
                c.b.a.m.f.Z4(activity, null, listL7, k4Var);
            }
        });
        dialogTipConfigBindingR2.f6686g.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TipConfigDialog tipConfigDialog = this.a;
                DialogTipConfigBinding dialogTipConfigBinding = dialogTipConfigBindingR2;
                f.f0.h<Object>[] hVarArr = TipConfigDialog.f7209b;
                f.c0.c.j.e(tipConfigDialog, "this$0");
                f.c0.c.j.e(dialogTipConfigBinding, "$this_with");
                List<String> listL7 = e.a.a.d.r.a.l();
                l4 l4Var = new l4(tipConfigDialog, dialogTipConfigBinding);
                FragmentActivity activity = tipConfigDialog.getActivity();
                if (activity == null) {
                    return;
                }
                c.b.a.m.f.Z4(activity, null, listL7, l4Var);
            }
        });
        dialogTipConfigBindingR2.m.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TipConfigDialog tipConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = TipConfigDialog.f7209b;
                f.c0.c.j.e(tipConfigDialog, "this$0");
                ArrayList arrayListA = f.x.e.a("跟随正文", "自定义");
                m4 m4Var = new m4(tipConfigDialog);
                FragmentActivity activity = tipConfigDialog.getActivity();
                if (activity == null) {
                    return;
                }
                c.b.a.m.f.Z4(activity, null, arrayListA, m4Var);
            }
        });
        String[] strArr = {"tipColor"};
        EventBusExtensionsKt$observeEvent$o$2 eventBusExtensionsKt$observeEvent$o$2 = new EventBusExtensionsKt$observeEvent$o$2(new a());
        for (int i3 = 0; i3 < 1; i3++) {
            Observable observable = LiveEventBus.get(strArr[i3], String.class);
            j.d(observable, "get(tag, EVENT::class.java)");
            observable.observe(this, eventBusExtensionsKt$observeEvent$o$2);
        }
    }

    public final DialogTipConfigBinding R() {
        return (DialogTipConfigBinding) this.binding.b(this, f7209b[0]);
    }

    public final void S() {
        TextView textView = R().w;
        r rVar = r.a;
        textView.setText(rVar.e() == 0 ? "跟随正文" : j.k("#", f.w2(rVar.e())));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_tip_config, container);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, -2);
    }
}
