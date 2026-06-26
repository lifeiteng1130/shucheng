package io.legado.app.ui.widget.recycler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.databinding.ViewLoadMoreBinding;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LoadMoreView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lio/legado/app/ui/widget/recycler/LoadMoreView;", "Landroid/widget/FrameLayout;", "Lf/v;", "onAttachedToWindow", "()V", "d", "b", "", NotificationCompat.CATEGORY_MESSAGE, ai.aD, "(Ljava/lang/String;)V", "Landroid/view/View$OnClickListener;", "clickListener", ai.at, "(Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "Lio/legado/app/databinding/ViewLoadMoreBinding;", "Lio/legado/app/databinding/ViewLoadMoreBinding;", "binding", "", "<set-?>", "Z", "getHasMore", "()Z", "hasMore", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class LoadMoreView extends FrameLayout {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewLoadMoreBinding binding;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean hasMore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadMoreView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        LayoutInflater.from(context).inflate(R.layout.view_load_more, this);
        ViewLoadMoreBinding viewLoadMoreBindingA = ViewLoadMoreBinding.a(this);
        j.d(viewLoadMoreBindingA, "inflate(LayoutInflater.from(context), this)");
        this.binding = viewLoadMoreBindingA;
        this.hasMore = true;
    }

    public final void a(@NotNull String msg, @Nullable View.OnClickListener clickListener) {
        j.e(msg, NotificationCompat.CATEGORY_MESSAGE);
        this.hasMore = false;
        this.binding.f6882b.a();
        this.binding.f6883c.setText(msg);
        TextView textView = this.binding.f6883c;
        j.d(textView, "binding.tvText");
        f.c6(textView);
        this.binding.f6883c.setClickable(true);
        if (clickListener != null) {
            this.binding.f6883c.setOnClickListener(clickListener);
        }
    }

    public final void b() {
        this.hasMore = true;
        TextView textView = this.binding.f6883c;
        j.d(textView, "binding.tvText");
        f.l3(textView);
        this.binding.f6882b.b();
    }

    public final void c(@Nullable String msg) {
        this.hasMore = false;
        this.binding.f6882b.a();
        if (msg != null) {
            this.binding.f6883c.setText(msg);
        } else {
            this.binding.f6883c.setText(R.string.bottom_line);
        }
        this.binding.f6883c.setClickable(false);
        TextView textView = this.binding.f6883c;
        j.d(textView, "binding.tvText");
        f.c6(textView);
    }

    public final void d() {
        TextView textView = this.binding.f6883c;
        j.d(textView, "binding.tvText");
        f.l3(textView);
        this.binding.f6882b.b();
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLayoutParams().width = -1;
    }
}
