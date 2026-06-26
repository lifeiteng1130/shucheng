package io.legado.app.ui.widget.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.databinding.DialogBottomTipsBinding;
import io.legado.app.ui.widget.dialog.BottomTipsDialog;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BottomTipsDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0002%$B\u0007¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006&"}, d2 = {"Lio/legado/app/ui/widget/dialog/BottomTipsDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "e", "J", "time", "Lio/legado/app/ui/widget/dialog/BottomTipsDialog$b;", "g", "Lio/legado/app/ui/widget/dialog/BottomTipsDialog$b;", "callBack", "", "f", "Z", "showCancel", "Lio/legado/app/databinding/DialogBottomTipsBinding;", "d", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "Q", "()Lio/legado/app/databinding/DialogBottomTipsBinding;", "binding", "<init>", "b", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BottomTipsDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7647c;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public long time;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public b callBack;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new c());

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean showCancel = true;

    /* JADX INFO: renamed from: io.legado.app.ui.widget.dialog.BottomTipsDialog$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: BottomTipsDialog.kt */
    public static final class Companion {
        public Companion(f.c0.c.f fVar) {
        }
    }

    /* JADX INFO: compiled from: BottomTipsDialog.kt */
    public interface b {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class c extends k implements l<BottomTipsDialog, DialogBottomTipsBinding> {
        public c() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogBottomTipsBinding invoke(@NotNull BottomTipsDialog bottomTipsDialog) {
            j.e(bottomTipsDialog, "fragment");
            View viewRequireView = bottomTipsDialog.requireView();
            int i2 = R.id.content;
            TextView textView = (TextView) viewRequireView.findViewById(R.id.content);
            if (textView != null) {
                i2 = R.id.title;
                TextView textView2 = (TextView) viewRequireView.findViewById(R.id.title);
                if (textView2 != null) {
                    i2 = R.id.tv_cancel;
                    TextView textView3 = (TextView) viewRequireView.findViewById(R.id.tv_cancel);
                    if (textView3 != null) {
                        i2 = R.id.tv_ok;
                        TextView textView4 = (TextView) viewRequireView.findViewById(R.id.tv_ok);
                        if (textView4 != null) {
                            return new DialogBottomTipsBinding((LinearLayout) viewRequireView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    static {
        q qVar = new q(v.a(BottomTipsDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogBottomTipsBinding;");
        Objects.requireNonNull(v.a);
        f7647c = new h[]{qVar};
        INSTANCE = new Companion(null);
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("content");
            if (string == null) {
                string = "";
            }
            String string2 = arguments.getString("title");
            if (string2 == null) {
                string2 = "";
            }
            if (j.a(string2, "")) {
                Q().f6593c.setVisibility(8);
            } else {
                Q().f6593c.setText(string2);
                Q().f6593c.setVisibility(0);
            }
            if (j.a(string, "")) {
                Q().f6592b.setVisibility(8);
            } else {
                Q().f6592b.setText(string);
                Q().f6592b.setVisibility(0);
            }
            this.time = arguments.getLong("time", 0L);
        }
        view.post(new Runnable() { // from class: e.a.a.g.m.k.b
            @Override // java.lang.Runnable
            public final void run() {
                BottomTipsDialog bottomTipsDialog = this.a;
                BottomTipsDialog.Companion companion = BottomTipsDialog.INSTANCE;
                f.c0.c.j.e(bottomTipsDialog, "this$0");
                if (bottomTipsDialog.callBack == null) {
                    Dialog dialog = bottomTipsDialog.getDialog();
                    if (dialog == null) {
                        return;
                    }
                    dialog.setCancelable(true);
                    return;
                }
                Dialog dialog2 = bottomTipsDialog.getDialog();
                if (dialog2 == null) {
                    return;
                }
                dialog2.setCancelable(false);
            }
        });
        Q().f6595e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.k.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BottomTipsDialog bottomTipsDialog = this.a;
                BottomTipsDialog.Companion companion = BottomTipsDialog.INSTANCE;
                f.c0.c.j.e(bottomTipsDialog, "this$0");
                Dialog dialog = bottomTipsDialog.getDialog();
                if (dialog != null) {
                    dialog.dismiss();
                }
                BottomTipsDialog.b bVar = bottomTipsDialog.callBack;
                if (bVar != null) {
                    bVar.a();
                }
            }
        });
        if (this.showCancel) {
            Q().f6594d.setVisibility(0);
        } else {
            Q().f6594d.setVisibility(8);
        }
        Q().f6594d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.k.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BottomTipsDialog bottomTipsDialog = this.a;
                BottomTipsDialog.Companion companion = BottomTipsDialog.INSTANCE;
                f.c0.c.j.e(bottomTipsDialog, "this$0");
                Dialog dialog = bottomTipsDialog.getDialog();
                if (dialog != null) {
                    dialog.dismiss();
                }
                BottomTipsDialog.b bVar = bottomTipsDialog.callBack;
                if (bVar != null) {
                    bVar.b();
                }
            }
        });
    }

    public final DialogBottomTipsBinding Q() {
        return (DialogBottomTipsBinding) this.binding.b(this, f7647c[0]);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_bottom_tips, container);
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
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setGravity(17);
    }
}
