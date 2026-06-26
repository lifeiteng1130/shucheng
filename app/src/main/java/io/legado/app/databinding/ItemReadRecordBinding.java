package io.legado.app.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.wenyuange.app.release.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemReadRecordBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f6812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f6813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f6814d;

    public ItemReadRecordBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = constraintLayout;
        this.f6812b = textView;
        this.f6813c = textView2;
        this.f6814d = textView3;
    }

    @NonNull
    public static ItemReadRecordBinding a(@NonNull View view) {
        int i2 = R.id.tv_book_name;
        TextView textView = (TextView) view.findViewById(R.id.tv_book_name);
        if (textView != null) {
            i2 = R.id.tv_read_time;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_read_time);
            if (textView2 != null) {
                i2 = R.id.tv_remove;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_remove);
                if (textView3 != null) {
                    return new ItemReadRecordBinding((ConstraintLayout) view, textView, textView2, textView3);
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
