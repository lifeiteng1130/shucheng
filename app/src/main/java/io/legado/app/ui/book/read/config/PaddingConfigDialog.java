package io.legado.app.ui.book.read.config;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.g.d.i.r1.a3;
import e.a.a.g.d.i.r1.b3;
import e.a.a.g.d.i.r1.c3;
import e.a.a.g.d.i.r1.d3;
import e.a.a.g.d.i.r1.e3;
import e.a.a.g.d.i.r1.f3;
import e.a.a.g.d.i.r1.g3;
import e.a.a.g.d.i.r1.h3;
import e.a.a.g.d.i.r1.u2;
import e.a.a.g.d.i.r1.v2;
import e.a.a.g.d.i.r1.w2;
import e.a.a.g.d.i.r1.x2;
import e.a.a.g.d.i.r1.y2;
import e.a.a.g.d.i.r1.z2;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.databinding.DialogReadPaddingBinding;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.ui.widget.DetailSeekBar;
import io.legado.app.ui.widget.checkbox.SmoothCheckBox;
import io.legado.app.ui.widget.text.AccentTextView;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PaddingConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lio/legado/app/ui/book/read/config/PaddingConfigDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lio/legado/app/databinding/DialogReadPaddingBinding;", ai.aD, "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "Q", "()Lio/legado/app/databinding/DialogReadPaddingBinding;", "binding", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class PaddingConfigDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new a());

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class a extends k implements l<PaddingConfigDialog, DialogReadPaddingBinding> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogReadPaddingBinding invoke(@NotNull PaddingConfigDialog paddingConfigDialog) {
            j.e(paddingConfigDialog, "fragment");
            View viewRequireView = paddingConfigDialog.requireView();
            int i2 = R.id.cb_show_bottom_line;
            SmoothCheckBox smoothCheckBox = (SmoothCheckBox) viewRequireView.findViewById(R.id.cb_show_bottom_line);
            if (smoothCheckBox != null) {
                i2 = R.id.cb_show_top_line;
                SmoothCheckBox smoothCheckBox2 = (SmoothCheckBox) viewRequireView.findViewById(R.id.cb_show_top_line);
                if (smoothCheckBox2 != null) {
                    i2 = R.id.dsb_footer_padding_bottom;
                    DetailSeekBar detailSeekBar = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_footer_padding_bottom);
                    if (detailSeekBar != null) {
                        i2 = R.id.dsb_footer_padding_left;
                        DetailSeekBar detailSeekBar2 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_footer_padding_left);
                        if (detailSeekBar2 != null) {
                            i2 = R.id.dsb_footer_padding_right;
                            DetailSeekBar detailSeekBar3 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_footer_padding_right);
                            if (detailSeekBar3 != null) {
                                i2 = R.id.dsb_footer_padding_top;
                                DetailSeekBar detailSeekBar4 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_footer_padding_top);
                                if (detailSeekBar4 != null) {
                                    i2 = R.id.dsb_header_padding_bottom;
                                    DetailSeekBar detailSeekBar5 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_header_padding_bottom);
                                    if (detailSeekBar5 != null) {
                                        i2 = R.id.dsb_header_padding_left;
                                        DetailSeekBar detailSeekBar6 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_header_padding_left);
                                        if (detailSeekBar6 != null) {
                                            i2 = R.id.dsb_header_padding_right;
                                            DetailSeekBar detailSeekBar7 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_header_padding_right);
                                            if (detailSeekBar7 != null) {
                                                i2 = R.id.dsb_header_padding_top;
                                                DetailSeekBar detailSeekBar8 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_header_padding_top);
                                                if (detailSeekBar8 != null) {
                                                    i2 = R.id.dsb_padding_bottom;
                                                    DetailSeekBar detailSeekBar9 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_padding_bottom);
                                                    if (detailSeekBar9 != null) {
                                                        i2 = R.id.dsb_padding_left;
                                                        DetailSeekBar detailSeekBar10 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_padding_left);
                                                        if (detailSeekBar10 != null) {
                                                            i2 = R.id.dsb_padding_right;
                                                            DetailSeekBar detailSeekBar11 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_padding_right);
                                                            if (detailSeekBar11 != null) {
                                                                i2 = R.id.dsb_padding_top;
                                                                DetailSeekBar detailSeekBar12 = (DetailSeekBar) viewRequireView.findViewById(R.id.dsb_padding_top);
                                                                if (detailSeekBar12 != null) {
                                                                    i2 = R.id.ll_header_padding;
                                                                    LinearLayout linearLayout = (LinearLayout) viewRequireView.findViewById(R.id.ll_header_padding);
                                                                    if (linearLayout != null) {
                                                                        i2 = R.id.tv_body_padding;
                                                                        AccentTextView accentTextView = (AccentTextView) viewRequireView.findViewById(R.id.tv_body_padding);
                                                                        if (accentTextView != null) {
                                                                            i2 = R.id.tv_header_padding;
                                                                            AccentTextView accentTextView2 = (AccentTextView) viewRequireView.findViewById(R.id.tv_header_padding);
                                                                            if (accentTextView2 != null) {
                                                                                return new DialogReadPaddingBinding((LinearLayout) viewRequireView, smoothCheckBox, smoothCheckBox2, detailSeekBar, detailSeekBar2, detailSeekBar3, detailSeekBar4, detailSeekBar5, detailSeekBar6, detailSeekBar7, detailSeekBar8, detailSeekBar9, detailSeekBar10, detailSeekBar11, detailSeekBar12, linearLayout, accentTextView, accentTextView2);
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
        q qVar = new q(v.a(PaddingConfigDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogReadPaddingBinding;");
        Objects.requireNonNull(v.a);
        f7186b = new h[]{qVar};
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        Q().o.setProgress(readBookConfig.getPaddingTop());
        Q().f6670l.setProgress(readBookConfig.getPaddingBottom());
        Q().m.setProgress(readBookConfig.getPaddingLeft());
        Q().n.setProgress(readBookConfig.getPaddingRight());
        Q().f6669k.setProgress(readBookConfig.getHeaderPaddingTop());
        Q().f6666h.setProgress(readBookConfig.getHeaderPaddingBottom());
        Q().f6667i.setProgress(readBookConfig.getHeaderPaddingLeft());
        Q().f6668j.setProgress(readBookConfig.getHeaderPaddingRight());
        Q().f6665g.setProgress(readBookConfig.getFooterPaddingTop());
        Q().f6662d.setProgress(readBookConfig.getFooterPaddingBottom());
        Q().f6663e.setProgress(readBookConfig.getFooterPaddingLeft());
        Q().f6664f.setProgress(readBookConfig.getFooterPaddingRight());
        Q().f6661c.setChecked(readBookConfig.getShowHeaderLine());
        Q().f6660b.setChecked(readBookConfig.getShowFooterLine());
        Q().o.setOnChanged(new z2(readBookConfig));
        Q().f6670l.setOnChanged(new a3(readBookConfig));
        Q().m.setOnChanged(new b3(readBookConfig));
        Q().n.setOnChanged(new c3(readBookConfig));
        Q().f6669k.setOnChanged(new d3(readBookConfig));
        Q().f6666h.setOnChanged(new e3(readBookConfig));
        Q().f6667i.setOnChanged(new f3(readBookConfig));
        Q().f6668j.setOnChanged(new g3(readBookConfig));
        Q().f6665g.setOnChanged(new h3(readBookConfig));
        Q().f6662d.setOnChanged(new u2(readBookConfig));
        Q().f6663e.setOnChanged(new v2(readBookConfig));
        Q().f6664f.setOnChanged(new w2(readBookConfig));
        Q().f6661c.setOnCheckedChangeListener(new x2(readBookConfig));
        Q().f6660b.setOnCheckedChangeListener(new y2(readBookConfig));
    }

    public final DialogReadPaddingBinding Q() {
        return (DialogReadPaddingBinding) this.binding.b(this, f7186b[0]);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_read_padding, container);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        j.e(dialog, "dialog");
        super.onDismiss(dialog);
        ReadBookConfig.INSTANCE.save();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        j.d(fragmentActivityRequireActivity, "requireActivity()");
        DisplayMetrics displayMetricsV2 = f.V2(fragmentActivityRequireActivity);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.clearFlags(2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        window.setAttributes(attributes);
        window.setLayout((int) (((double) displayMetricsV2.widthPixels) * 0.9d), -2);
    }
}
