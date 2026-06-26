package io.legado.app.ui.book.read.config;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.f0.h;
import f.v;
import f.x.e;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.databinding.DialogClickActionConfigBinding;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.book.read.config.ClickActionConfigDialog;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ClickActionConfigDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u001b\u001a\u00020\u00022!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00020\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR2\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001e`\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010(\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lio/legado/app/ui/book/read/config/ClickActionConfigDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "action", "success", "R", "(Lf/c0/b/l;)V", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "d", "Ljava/util/LinkedHashMap;", "actions", "Lio/legado/app/databinding/DialogClickActionConfigBinding;", ai.aD, "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "Q", "()Lio/legado/app/databinding/DialogClickActionConfigBinding;", "binding", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ClickActionConfigDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new b());

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LinkedHashMap<Integer, String> actions = new LinkedHashMap<>();

    /* JADX INFO: compiled from: ClickActionConfigDialog.kt */
    public static final class a extends k implements p<DialogInterface, Integer, v> {
        public final /* synthetic */ l<Integer, v> $success;
        public final /* synthetic */ ClickActionConfigDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(l<? super Integer, v> lVar, ClickActionConfigDialog clickActionConfigDialog) {
            super(2);
            this.$success = lVar;
            this.this$0 = clickActionConfigDialog;
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) {
            invoke(dialogInterface, num.intValue());
            return v.a;
        }

        public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
            j.e(dialogInterface, "$noName_0");
            l<Integer, v> lVar = this.$success;
            Set<Integer> setKeySet = this.this$0.actions.keySet();
            j.d(setKeySet, "actions.keys");
            Object obj = e.F(setKeySet).get(i2);
            j.d(obj, "actions.keys.toList()[index]");
            lVar.invoke((Integer) obj);
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class b extends k implements l<ClickActionConfigDialog, DialogClickActionConfigBinding> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogClickActionConfigBinding invoke(@NotNull ClickActionConfigDialog clickActionConfigDialog) {
            j.e(clickActionConfigDialog, "fragment");
            View viewRequireView = clickActionConfigDialog.requireView();
            int i2 = R.id.iv_close;
            ImageView imageView = (ImageView) viewRequireView.findViewById(R.id.iv_close);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) viewRequireView;
                i2 = R.id.tv_bottom_center;
                TextView textView = (TextView) viewRequireView.findViewById(R.id.tv_bottom_center);
                if (textView != null) {
                    i2 = R.id.tv_bottom_left;
                    TextView textView2 = (TextView) viewRequireView.findViewById(R.id.tv_bottom_left);
                    if (textView2 != null) {
                        i2 = R.id.tv_bottom_right;
                        TextView textView3 = (TextView) viewRequireView.findViewById(R.id.tv_bottom_right);
                        if (textView3 != null) {
                            i2 = R.id.tv_middle_center;
                            TextView textView4 = (TextView) viewRequireView.findViewById(R.id.tv_middle_center);
                            if (textView4 != null) {
                                i2 = R.id.tv_middle_left;
                                TextView textView5 = (TextView) viewRequireView.findViewById(R.id.tv_middle_left);
                                if (textView5 != null) {
                                    i2 = R.id.tv_middle_right;
                                    TextView textView6 = (TextView) viewRequireView.findViewById(R.id.tv_middle_right);
                                    if (textView6 != null) {
                                        i2 = R.id.tv_top_center;
                                        TextView textView7 = (TextView) viewRequireView.findViewById(R.id.tv_top_center);
                                        if (textView7 != null) {
                                            i2 = R.id.tv_top_left;
                                            TextView textView8 = (TextView) viewRequireView.findViewById(R.id.tv_top_left);
                                            if (textView8 != null) {
                                                i2 = R.id.tv_top_right;
                                                TextView textView9 = (TextView) viewRequireView.findViewById(R.id.tv_top_right);
                                                if (textView9 != null) {
                                                    return new DialogClickActionConfigBinding(linearLayout, imageView, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
        q qVar = new q(f.c0.c.v.a(ClickActionConfigDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogClickActionConfigBinding;");
        Objects.requireNonNull(f.c0.c.v.a);
        f7183b = new h[]{qVar};
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        j.e(this, "<this>");
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        view.setBackgroundColor(f.c2(contextRequireContext, R.color.translucent));
        LinkedHashMap<Integer, String> linkedHashMap = this.actions;
        String string = getString(R.string.non_action);
        j.d(string, "getString(R.string.non_action)");
        linkedHashMap.put(-1, string);
        LinkedHashMap<Integer, String> linkedHashMap2 = this.actions;
        String string2 = getString(R.string.menu);
        j.d(string2, "getString(R.string.menu)");
        linkedHashMap2.put(0, string2);
        LinkedHashMap<Integer, String> linkedHashMap3 = this.actions;
        String string3 = getString(R.string.next_page);
        j.d(string3, "getString(R.string.next_page)");
        linkedHashMap3.put(1, string3);
        LinkedHashMap<Integer, String> linkedHashMap4 = this.actions;
        String string4 = getString(R.string.prev_page);
        j.d(string4, "getString(R.string.prev_page)");
        linkedHashMap4.put(2, string4);
        LinkedHashMap<Integer, String> linkedHashMap5 = this.actions;
        String string5 = getString(R.string.next_chapter);
        j.d(string5, "getString(R.string.next_chapter)");
        linkedHashMap5.put(3, string5);
        LinkedHashMap<Integer, String> linkedHashMap6 = this.actions;
        String string6 = getString(R.string.previous_chapter);
        j.d(string6, "getString(R.string.previous_chapter)");
        linkedHashMap6.put(4, string6);
        e.a.a.d.e eVar = e.a.a.d.e.a;
        Q().f6609i.setText(this.actions.get(Integer.valueOf(e.a.a.d.e.f5520e)));
        Q().f6608h.setText(this.actions.get(Integer.valueOf(e.a.a.d.e.f5521f)));
        Q().f6610j.setText(this.actions.get(Integer.valueOf(e.a.a.d.e.f5522g)));
        Q().f6606f.setText(this.actions.get(Integer.valueOf(e.a.a.d.e.f5523h)));
        Q().f6607g.setText(this.actions.get(Integer.valueOf(e.a.a.d.e.f5525j)));
        Q().f6604d.setText(this.actions.get(Integer.valueOf(e.a.a.d.e.f5526k)));
        Q().f6603c.setText(this.actions.get(Integer.valueOf(e.a.a.d.e.f5527l)));
        Q().f6605e.setText(this.actions.get(Integer.valueOf(e.a.a.d.e.m)));
        Q().f6602b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClickActionConfigDialog clickActionConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = ClickActionConfigDialog.f7183b;
                f.c0.c.j.e(clickActionConfigDialog, "this$0");
                clickActionConfigDialog.dismissAllowingStateLoss();
            }
        });
        Q().f6609i.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClickActionConfigDialog clickActionConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = ClickActionConfigDialog.f7183b;
                f.c0.c.j.e(clickActionConfigDialog, "this$0");
                clickActionConfigDialog.R(new m2(clickActionConfigDialog, view2));
            }
        });
        Q().f6608h.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClickActionConfigDialog clickActionConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = ClickActionConfigDialog.f7183b;
                f.c0.c.j.e(clickActionConfigDialog, "this$0");
                clickActionConfigDialog.R(new n2(clickActionConfigDialog, view2));
            }
        });
        Q().f6610j.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClickActionConfigDialog clickActionConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = ClickActionConfigDialog.f7183b;
                f.c0.c.j.e(clickActionConfigDialog, "this$0");
                clickActionConfigDialog.R(new o2(clickActionConfigDialog, view2));
            }
        });
        Q().f6606f.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClickActionConfigDialog clickActionConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = ClickActionConfigDialog.f7183b;
                f.c0.c.j.e(clickActionConfigDialog, "this$0");
                clickActionConfigDialog.R(new p2(clickActionConfigDialog, view2));
            }
        });
        Q().f6607g.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClickActionConfigDialog clickActionConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = ClickActionConfigDialog.f7183b;
                f.c0.c.j.e(clickActionConfigDialog, "this$0");
                clickActionConfigDialog.R(new q2(clickActionConfigDialog, view2));
            }
        });
        Q().f6604d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClickActionConfigDialog clickActionConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = ClickActionConfigDialog.f7183b;
                f.c0.c.j.e(clickActionConfigDialog, "this$0");
                clickActionConfigDialog.R(new r2(clickActionConfigDialog, view2));
            }
        });
        Q().f6603c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClickActionConfigDialog clickActionConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = ClickActionConfigDialog.f7183b;
                f.c0.c.j.e(clickActionConfigDialog, "this$0");
                clickActionConfigDialog.R(new s2(clickActionConfigDialog, view2));
            }
        });
        Q().f6605e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClickActionConfigDialog clickActionConfigDialog = this.a;
                f.f0.h<Object>[] hVarArr = ClickActionConfigDialog.f7183b;
                f.c0.c.j.e(clickActionConfigDialog, "this$0");
                clickActionConfigDialog.R(new t2(clickActionConfigDialog, view2));
            }
        });
    }

    public final DialogClickActionConfigBinding Q() {
        return (DialogClickActionConfigBinding) this.binding.b(this, f7183b[0]);
    }

    public final void R(l<? super Integer, v> success) {
        String string = getString(R.string.select_action);
        Collection<String> collectionValues = this.actions.values();
        j.d(collectionValues, "actions.values");
        List listF = e.F(collectionValues);
        a aVar = new a(success, this);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        f.Z4(activity, string, listF, aVar);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type io.legado.app.ui.book.read.ReadBookActivity");
        ((ReadBookActivity) activity).bottomDialog++;
        return inflater.inflate(R.layout.dialog_click_action_config, container);
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
        window.setBackgroundDrawableResource(R.color.transparent);
        window.setLayout(-1, -1);
    }
}
