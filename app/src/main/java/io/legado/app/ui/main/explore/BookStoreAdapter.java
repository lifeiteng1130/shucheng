package io.legado.app.ui.main.explore;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import g.b.a0;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.BookSource;
import io.legado.app.databinding.LayoutSourceItemBinding;
import io.legado.app.ui.main.explore.BookStoreAdapter;
import io.wenyuange.app.release.R;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: BookStoreAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lio/legado/app/ui/main/explore/BookStoreAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/BookSource;", "Lio/legado/app/databinding/LayoutSourceItemBinding;", "", "h", OptRuntime.GeneratorState.resumptionPoint_TYPE, "currentPosition", "Lg/b/a0;", "f", "Lg/b/a0;", "scope", "Lio/legado/app/ui/main/explore/BookStoreAdapter$a;", "g", "Lio/legado/app/ui/main/explore/BookStoreAdapter$a;", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lg/b/a0;Lio/legado/app/ui/main/explore/BookStoreAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookStoreAdapter extends RecyclerAdapter<BookSource, LayoutSourceItemBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a0 scope;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int currentPosition;

    /* JADX INFO: compiled from: BookStoreAdapter.kt */
    public interface a {
        void a(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookStoreAdapter(@NotNull Context context, @NotNull a0 a0Var, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(a0Var, "scope");
        j.e(aVar, "callBack");
        this.scope = a0Var;
        this.callBack = aVar;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, BookSource bookSource, List list, int i2) {
        LayoutSourceItemBinding layoutSourceItemBinding = (LayoutSourceItemBinding) viewBinding;
        BookSource bookSource2 = bookSource;
        j.e(itemViewHolder, "holder");
        j.e(layoutSourceItemBinding, "binding");
        j.e(bookSource2, "bookSource");
        j.e(list, "payloads");
        layoutSourceItemBinding.f6861b.setText(bookSource2.getBookSourceName());
        int iT1 = f.T1(this.context);
        int iU2 = f.U2(this.context, ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d);
        e.a.a.e.d.a aVar = new e.a.a.e.d.a();
        aVar.b(iU2);
        Context context = this.context;
        j.e(context, c.R);
        j.e(context, c.R);
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        int color = Color.parseColor("#263238");
        j.e(context, c.R);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, color);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        aVar.e(sharedPreferences.getInt("accent_color", color));
        layoutSourceItemBinding.f6861b.setTextColor(aVar.a());
        if (this.currentPosition == i2) {
            layoutSourceItemBinding.f6861b.setSelected(true);
        } else {
            layoutSourceItemBinding.f6861b.setSelected(false);
        }
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.layout_source_item, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.sourceItem);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.sourceItem)));
        }
        LayoutSourceItemBinding layoutSourceItemBinding = new LayoutSourceItemBinding((LinearLayout) viewInflate, textView);
        j.d(layoutSourceItemBinding, "inflate(inflater, parent, false)");
        return layoutSourceItemBinding;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        LayoutSourceItemBinding layoutSourceItemBinding = (LayoutSourceItemBinding) viewBinding;
        j.e(itemViewHolder, "holder");
        j.e(layoutSourceItemBinding, "binding");
        layoutSourceItemBinding.f6861b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.h.h.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookStoreAdapter bookStoreAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(bookStoreAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                bookStoreAdapter.callBack.a(itemViewHolder2.getAdapterPosition());
            }
        });
    }
}
