package io.legado.app.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.databinding.DialogRecyclerViewBinding;
import io.legado.app.databinding.ItemLogBinding;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextListDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010$\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010\u001fj\n\u0012\u0004\u0012\u00020 \u0018\u0001`!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lio/legado/app/ui/widget/dialog/TextListDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lio/legado/app/databinding/DialogRecyclerViewBinding;", "d", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "getBinding", "()Lio/legado/app/databinding/DialogRecyclerViewBinding;", "binding", "Lio/legado/app/ui/widget/dialog/TextListDialog$TextAdapter;", "e", "Lio/legado/app/ui/widget/dialog/TextListDialog$TextAdapter;", "getAdapter", "()Lio/legado/app/ui/widget/dialog/TextListDialog$TextAdapter;", "setAdapter", "(Lio/legado/app/ui/widget/dialog/TextListDialog$TextAdapter;)V", "adapter", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "values", "<init>", "b", ai.at, "TextAdapter", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class TextListDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new b());

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextAdapter adapter;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public ArrayList<String> values;

    /* JADX INFO: compiled from: TextListDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/legado/app/ui/widget/dialog/TextListDialog$TextAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "", "Lio/legado/app/databinding/ItemLogBinding;", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class TextAdapter extends RecyclerAdapter<String, ItemLogBinding> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextAdapter(@NotNull Context context) {
            super(context);
            j.e(context, c.R);
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, String str, List list, int i2) {
            ItemLogBinding itemLogBinding = (ItemLogBinding) viewBinding;
            String str2 = str;
            j.e(itemViewHolder, "holder");
            j.e(itemLogBinding, "binding");
            j.e(str2, "item");
            j.e(list, "payloads");
            if (itemLogBinding.f6809b.getTag(R.id.tag1) == null) {
                e.a.a.g.m.k.j jVar = new e.a.a.g.m.k.j(itemLogBinding);
                itemLogBinding.f6809b.addOnAttachStateChangeListener(jVar);
                itemLogBinding.f6809b.setTag(R.id.tag1, jVar);
            }
            itemLogBinding.f6809b.setText(str2);
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public ViewBinding q(ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            ItemLogBinding itemLogBindingA = ItemLogBinding.a(this.inflater, viewGroup, false);
            j.d(itemLogBindingA, "inflate(inflater, parent, false)");
            return itemLogBindingA;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void w(ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
            j.e(itemViewHolder, "holder");
            j.e((ItemLogBinding) viewBinding, "binding");
        }
    }

    /* JADX INFO: renamed from: io.legado.app.ui.widget.dialog.TextListDialog$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: TextListDialog.kt */
    public static final class Companion {
        public Companion(f.c0.c.f fVar) {
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class b extends k implements l<TextListDialog, DialogRecyclerViewBinding> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogRecyclerViewBinding invoke(@NotNull TextListDialog textListDialog) {
            j.e(textListDialog, "fragment");
            return DialogRecyclerViewBinding.a(textListDialog.requireView());
        }
    }

    static {
        q qVar = new q(v.a(TextListDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogRecyclerViewBinding;");
        Objects.requireNonNull(v.a);
        f7661c = new h[]{qVar};
        INSTANCE = new Companion(null);
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        DialogRecyclerViewBinding dialogRecyclerViewBinding = (DialogRecyclerViewBinding) this.binding.b(this, f7661c[0]);
        Bundle arguments = getArguments();
        if (arguments != null) {
            dialogRecyclerViewBinding.f6672c.setTitle(arguments.getString("title"));
            this.values = arguments.getStringArrayList("values");
        }
        dialogRecyclerViewBinding.f6671b.setLayoutManager(new LinearLayoutManager(requireContext()));
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        TextAdapter textAdapter = new TextAdapter(contextRequireContext);
        j.e(textAdapter, "<set-?>");
        this.adapter = textAdapter;
        dialogRecyclerViewBinding.f6671b.setAdapter(textAdapter);
        TextAdapter textAdapter2 = this.adapter;
        if (textAdapter2 != null) {
            textAdapter2.x(this.values);
        } else {
            j.m("adapter");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_recycler_view, container);
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
        window.setLayout((int) (((double) displayMetricsV2.widthPixels) * 0.9d), (int) (((double) displayMetricsV2.heightPixels) * 0.9d));
    }
}
