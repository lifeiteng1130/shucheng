package io.legado.app.ui.config;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.google.gson.Gson;
import com.umeng.analytics.pro.ai;
import e.a.a.d.t;
import e.a.a.h.m;
import e.a.a.h.n;
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
import io.legado.app.databinding.ItemThemeConfigBinding;
import io.legado.app.help.ThemeConfig;
import io.legado.app.ui.config.ThemeListDialog;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ThemeListDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\u00060\u001eR\u00020\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lio/legado/app/ui/config/ThemeListDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "R", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Lio/legado/app/databinding/DialogRecyclerViewBinding;", ai.aD, "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "Q", "()Lio/legado/app/databinding/DialogRecyclerViewBinding;", "binding", "Lio/legado/app/ui/config/ThemeListDialog$Adapter;", "d", "Lio/legado/app/ui/config/ThemeListDialog$Adapter;", "adapter", "<init>", "Adapter", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ThemeListDialog extends BaseDialogFragment implements Toolbar.OnMenuItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new a());

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Adapter adapter;

    /* JADX INFO: compiled from: ThemeListDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/legado/app/ui/config/ThemeListDialog$Adapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/help/ThemeConfig$Config;", "Lio/legado/app/databinding/ItemThemeConfigBinding;", "<init>", "(Lio/legado/app/ui/config/ThemeListDialog;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public final class Adapter extends RecyclerAdapter<ThemeConfig.Config, ItemThemeConfigBinding> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ThemeListDialog f7361f;

        /* JADX WARN: Illegal instructions before constructor call */
        public Adapter(ThemeListDialog themeListDialog) {
            j.e(themeListDialog, "this$0");
            this.f7361f = themeListDialog;
            Context contextRequireContext = themeListDialog.requireContext();
            j.d(contextRequireContext, "requireContext()");
            super(contextRequireContext);
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, ThemeConfig.Config config, List list, int i2) {
            ItemThemeConfigBinding itemThemeConfigBinding = (ItemThemeConfigBinding) viewBinding;
            ThemeConfig.Config config2 = config;
            j.e(itemViewHolder, "holder");
            j.e(itemThemeConfigBinding, "binding");
            j.e(config2, "item");
            j.e(list, "payloads");
            itemThemeConfigBinding.f6855d.setText(config2.getThemeName());
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public ViewBinding q(ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            View viewInflate = this.inflater.inflate(R.layout.item_theme_config, viewGroup, false);
            int i2 = R.id.iv_delete;
            AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_delete);
            if (appCompatImageView != null) {
                i2 = R.id.iv_share;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewInflate.findViewById(R.id.iv_share);
                if (appCompatImageView2 != null) {
                    i2 = R.id.tv_name;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.tv_name);
                    if (textView != null) {
                        ItemThemeConfigBinding itemThemeConfigBinding = new ItemThemeConfigBinding((LinearLayout) viewInflate, appCompatImageView, appCompatImageView2, textView);
                        j.d(itemThemeConfigBinding, "inflate(inflater, parent, false)");
                        return itemThemeConfigBinding;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
            ItemThemeConfigBinding itemThemeConfigBinding = (ItemThemeConfigBinding) viewBinding;
            j.e(itemViewHolder, "holder");
            j.e(itemThemeConfigBinding, "binding");
            final ThemeListDialog themeListDialog = this.f7361f;
            itemThemeConfigBinding.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.e.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ThemeListDialog.Adapter adapter = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    f.c0.c.j.e(adapter, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    ThemeConfig themeConfig = ThemeConfig.a;
                    Context context = adapter.context;
                    ThemeConfig.Config config = themeConfig.d().get(itemViewHolder2.getLayoutPosition());
                    f.c0.c.j.d(config, "ThemeConfig.configList[holder.layoutPosition]");
                    ThemeConfig.Config config2 = config;
                    f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
                    f.c0.c.j.e(config2, "config");
                    int color = Color.parseColor(config2.getPrimaryColor());
                    int color2 = Color.parseColor(config2.getAccentColor());
                    int color3 = Color.parseColor(config2.getBackgroundColor());
                    int color4 = Color.parseColor(config2.getBottomBackground());
                    if (config2.getIsNightTheme()) {
                        c.b.a.m.f.p4(context, "colorPrimaryNight", color);
                        c.b.a.m.f.p4(context, "colorAccentNight", color2);
                        c.b.a.m.f.p4(context, "colorBackgroundNight", color3);
                        c.b.a.m.f.p4(context, "colorBottomBackgroundNight", color4);
                    } else {
                        c.b.a.m.f.p4(context, "colorPrimary", color);
                        c.b.a.m.f.p4(context, "colorAccent", color2);
                        c.b.a.m.f.p4(context, "colorBackground", color3);
                        c.b.a.m.f.p4(context, "colorBottomBackground", color4);
                    }
                    e.a.a.d.e.a.p(config2.getIsNightTheme());
                    themeConfig.b(context);
                }
            });
            itemThemeConfigBinding.f6854c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.e.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ThemeListDialog themeListDialog2 = themeListDialog;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    f.c0.c.j.e(themeListDialog2, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    String json = e.a.a.h.n.a().toJson(ThemeConfig.a.d().get(itemViewHolder2.getLayoutPosition()));
                    Context contextRequireContext = themeListDialog2.requireContext();
                    f.c0.c.j.d(contextRequireContext, "requireContext()");
                    f.c0.c.j.d(json, "json");
                    c.b.a.m.f.f5(contextRequireContext, json, "主题分享");
                }
            });
            itemThemeConfigBinding.f6853b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.e.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ThemeListDialog themeListDialog2 = themeListDialog;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    f.c0.c.j.e(themeListDialog2, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    int layoutPosition = itemViewHolder2.getLayoutPosition();
                    Integer numValueOf = Integer.valueOf(R.string.delete);
                    Integer numValueOf2 = Integer.valueOf(R.string.sure_del);
                    j0 j0Var = new j0(layoutPosition, themeListDialog2);
                    FragmentActivity fragmentActivityRequireActivity = themeListDialog2.requireActivity();
                    f.c0.c.j.d(fragmentActivityRequireActivity, "requireActivity()");
                    ((e.a.a.e.a.i) c.b.a.m.f.h0(fragmentActivityRequireActivity, numValueOf, numValueOf2, j0Var)).p();
                }
            });
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class a extends k implements l<ThemeListDialog, DialogRecyclerViewBinding> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogRecyclerViewBinding invoke(@NotNull ThemeListDialog themeListDialog) {
            j.e(themeListDialog, "fragment");
            return DialogRecyclerViewBinding.a(themeListDialog.requireView());
        }
    }

    static {
        q qVar = new q(v.a(ThemeListDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogRecyclerViewBinding;");
        Objects.requireNonNull(v.a);
        f7358b = new h[]{qVar};
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        Q().f6672c.setBackgroundColor(f.Q2(this));
        Q().f6672c.setTitle(R.string.theme_list);
        DialogRecyclerViewBinding dialogRecyclerViewBindingQ = Q();
        this.adapter = new Adapter(this);
        dialogRecyclerViewBindingQ.f6671b.setLayoutManager(new LinearLayoutManager(requireContext()));
        FastScrollRecyclerView fastScrollRecyclerView = dialogRecyclerViewBindingQ.f6671b;
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        fastScrollRecyclerView.addItemDecoration(new VerticalDivider(contextRequireContext));
        FastScrollRecyclerView fastScrollRecyclerView2 = dialogRecyclerViewBindingQ.f6671b;
        Adapter adapter = this.adapter;
        if (adapter == null) {
            j.m("adapter");
            throw null;
        }
        fastScrollRecyclerView2.setAdapter(adapter);
        DialogRecyclerViewBinding dialogRecyclerViewBindingQ2 = Q();
        dialogRecyclerViewBindingQ2.f6672c.setOnMenuItemClickListener(this);
        dialogRecyclerViewBindingQ2.f6672c.inflateMenu(R.menu.theme_list);
        Menu menu = dialogRecyclerViewBindingQ2.f6672c.getMenu();
        j.d(menu, "toolBar.menu");
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        m.b(menu, contextRequireContext2, null, 2);
        R();
    }

    public final DialogRecyclerViewBinding Q() {
        return (DialogRecyclerViewBinding) this.binding.b(this, f7358b[0]);
    }

    public final void R() {
        Adapter adapter = this.adapter;
        if (adapter != null) {
            adapter.x(ThemeConfig.a.d());
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

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Object objM11constructorimpl;
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_import) {
            Context contextRequireContext = requireContext();
            j.d(contextRequireContext, "requireContext()");
            String strX1 = f.X1(contextRequireContext);
            if (strX1 != null) {
                ThemeConfig themeConfig = ThemeConfig.a;
                j.e(strX1, "json");
                Gson gsonA = n.a();
                int length = strX1.length() - 1;
                boolean z = false;
                int i2 = 0;
                boolean z2 = false;
                while (i2 <= length) {
                    boolean z3 = j.g(strX1.charAt(!z2 ? i2 : length), 32) < 0;
                    if (z2) {
                        if (!z3) {
                            break;
                        }
                        length--;
                    } else if (z3) {
                        i2++;
                    } else {
                        z2 = true;
                    }
                }
                String string = strX1.subSequence(i2, length + 1).toString();
                try {
                    Type type = new t().getType();
                    j.d(type, "object : TypeToken<T>() {}.type");
                    Object objFromJson = gsonA.fromJson(string, type);
                    if (!(objFromJson instanceof ThemeConfig.Config)) {
                        objFromJson = null;
                    }
                    objM11constructorimpl = f.h.m11constructorimpl((ThemeConfig.Config) objFromJson);
                } catch (Throwable th) {
                    objM11constructorimpl = f.h.m11constructorimpl(f.m1(th));
                }
                ThemeConfig.Config config = (ThemeConfig.Config) (f.h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
                if (config != null) {
                    ThemeConfig.a.a(config);
                    z = true;
                }
                if (z) {
                    R();
                } else {
                    m.m(this, "格式不对,添加失败");
                }
            }
        }
        return true;
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
