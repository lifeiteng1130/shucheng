package io.legado.app.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.databinding.ItemFilletTextBinding;
import io.legado.app.databinding.PopupKeyboardToolBinding;
import io.legado.app.ui.widget.KeyboardToolPop;
import io.wenyuange.app.release.R;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KeyboardToolPop.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KeyboardToolPop extends PopupWindow {

    @NotNull
    public final List<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final a f7591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final PopupKeyboardToolBinding f7592c;

    /* JADX INFO: compiled from: KeyboardToolPop.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/legado/app/ui/widget/KeyboardToolPop$Adapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "", "Lio/legado/app/databinding/ItemFilletTextBinding;", "Landroid/content/Context;", c.R, "<init>", "(Lio/legado/app/ui/widget/KeyboardToolPop;Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public final class Adapter extends RecyclerAdapter<String, ItemFilletTextBinding> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ KeyboardToolPop f7593f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(@NotNull KeyboardToolPop keyboardToolPop, Context context) {
            super(context);
            j.e(keyboardToolPop, "this$0");
            j.e(context, c.R);
            this.f7593f = keyboardToolPop;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, String str, List list, int i2) {
            ItemFilletTextBinding itemFilletTextBinding = (ItemFilletTextBinding) viewBinding;
            String str2 = str;
            j.e(itemViewHolder, "holder");
            j.e(itemFilletTextBinding, "binding");
            j.e(str2, "item");
            j.e(list, "payloads");
            itemFilletTextBinding.f6784b.setText(str2);
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public ViewBinding q(ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            ItemFilletTextBinding itemFilletTextBindingA = ItemFilletTextBinding.a(this.inflater, viewGroup, false);
            j.d(itemFilletTextBindingA, "inflate(inflater, parent, false)");
            return itemFilletTextBindingA;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
            j.e(itemViewHolder, "holder");
            j.e((ItemFilletTextBinding) viewBinding, "binding");
            View view = itemViewHolder.itemView;
            final KeyboardToolPop keyboardToolPop = this.f7593f;
            view.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    KeyboardToolPop.a aVar;
                    KeyboardToolPop.Adapter adapter = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    KeyboardToolPop keyboardToolPop2 = keyboardToolPop;
                    j.e(adapter, "this$0");
                    j.e(itemViewHolder2, "$holder");
                    j.e(keyboardToolPop2, "this$1");
                    String item = adapter.getItem(itemViewHolder2.getLayoutPosition());
                    if (item == null || (aVar = keyboardToolPop2.f7591b) == null) {
                        return;
                    }
                    aVar.B(item);
                }
            });
        }
    }

    /* JADX INFO: compiled from: KeyboardToolPop.kt */
    public interface a {
        void B(@NotNull String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardToolPop(@NotNull Context context, @NotNull List<String> list, @Nullable a aVar) {
        super(-1, -2);
        j.e(context, c.R);
        j.e(list, "chars");
        this.a = list;
        this.f7591b = aVar;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.popup_keyboard_tool, (ViewGroup) null, false);
        Objects.requireNonNull(viewInflate, "rootView");
        RecyclerView recyclerView = (RecyclerView) viewInflate;
        PopupKeyboardToolBinding popupKeyboardToolBinding = new PopupKeyboardToolBinding(recyclerView, recyclerView);
        j.d(popupKeyboardToolBinding, "inflate(LayoutInflater.from(context))");
        this.f7592c = popupKeyboardToolBinding;
        setContentView(recyclerView);
        setTouchable(true);
        setOutsideTouchable(false);
        setFocusable(false);
        setInputMethodMode(1);
        View contentView = getContentView();
        Context context2 = contentView.getContext();
        j.d(context2, c.R);
        Adapter adapter = new Adapter(this, context2);
        recyclerView.setLayoutManager(new LinearLayoutManager(contentView.getContext(), 0, false));
        recyclerView.setAdapter(adapter);
        adapter.x(list);
    }
}
