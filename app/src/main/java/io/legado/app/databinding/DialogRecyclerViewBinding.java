package io.legado.app.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;
import io.legado.app.ui.widget.text.AccentTextView;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogRecyclerViewBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FastScrollRecyclerView f6671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Toolbar f6672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AccentTextView f6673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final AccentTextView f6674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AccentTextView f6675f;

    public DialogRecyclerViewBinding(@NonNull LinearLayout linearLayout, @NonNull FastScrollRecyclerView fastScrollRecyclerView, @NonNull Toolbar toolbar, @NonNull AccentTextView accentTextView, @NonNull AccentTextView accentTextView2, @NonNull AccentTextView accentTextView3) {
        this.a = linearLayout;
        this.f6671b = fastScrollRecyclerView;
        this.f6672c = toolbar;
        this.f6673d = accentTextView;
        this.f6674e = accentTextView2;
        this.f6675f = accentTextView3;
    }

    @NonNull
    public static DialogRecyclerViewBinding a(@NonNull View view) {
        int i2 = R.id.recycler_view;
        FastScrollRecyclerView fastScrollRecyclerView = (FastScrollRecyclerView) view.findViewById(R.id.recycler_view);
        if (fastScrollRecyclerView != null) {
            i2 = R.id.tool_bar;
            Toolbar toolbar = (Toolbar) view.findViewById(R.id.tool_bar);
            if (toolbar != null) {
                i2 = R.id.tv_cancel;
                AccentTextView accentTextView = (AccentTextView) view.findViewById(R.id.tv_cancel);
                if (accentTextView != null) {
                    i2 = R.id.tv_footer_left;
                    AccentTextView accentTextView2 = (AccentTextView) view.findViewById(R.id.tv_footer_left);
                    if (accentTextView2 != null) {
                        i2 = R.id.tv_ok;
                        AccentTextView accentTextView3 = (AccentTextView) view.findViewById(R.id.tv_ok);
                        if (accentTextView3 != null) {
                            return new DialogRecyclerViewBinding((LinearLayout) view, fastScrollRecyclerView, toolbar, accentTextView, accentTextView2, accentTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
