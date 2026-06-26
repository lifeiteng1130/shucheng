package io.legado.app.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.b.a.m.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.x.e;
import io.legado.app.ui.widget.text.AccentBgTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LabelsBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\u0006\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R&\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lio/legado/app/ui/widget/LabelsBar;", "Landroid/widget/LinearLayout;", "", "", "labels", "Lf/v;", "setLabels", "([Ljava/lang/String;)V", "", "(Ljava/util/List;)V", TTDownloadField.TT_LABEL, ai.at, "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Landroid/widget/TextView;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "unUsedViews", "b", "usedViews", "", ai.aD, "F", "getTextSize", "()F", "setTextSize", "(F)V", "textSize", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class LabelsBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final ArrayList<TextView> unUsedViews;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<TextView> usedViews;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public float textSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LabelsBar(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    public final void a(@NotNull String label) {
        TextView textView;
        j.e(label, TTDownloadField.TT_LABEL);
        if (this.unUsedViews.isEmpty()) {
            Context context = getContext();
            j.d(context, c.R);
            AccentBgTextView accentBgTextView = new AccentBgTextView(context, null);
            accentBgTextView.setPadding(f.m2(5), 0, f.m2(5), 0);
            accentBgTextView.setRadius(5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, f.m2(5), 0);
            accentBgTextView.setLayoutParams(layoutParams);
            accentBgTextView.setText(label);
            accentBgTextView.setMaxLines(1);
            this.usedViews.add(accentBgTextView);
            textView = accentBgTextView;
        } else {
            TextView textView2 = (TextView) e.r(this.unUsedViews);
            this.usedViews.add(textView2);
            ArrayList<TextView> arrayList = this.unUsedViews;
            arrayList.remove(e.m(arrayList));
            textView = textView2;
        }
        textView.setTextSize(this.textSize);
        textView.setText(label);
        addView(textView);
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final void setLabels(@NotNull List<String> labels) {
        j.e(labels, "labels");
        this.unUsedViews.addAll(this.usedViews);
        this.usedViews.clear();
        removeAllViews();
        Iterator<T> it = labels.iterator();
        while (it.hasNext()) {
            a((String) it.next());
        }
    }

    public final void setTextSize(float f2) {
        this.textSize = f2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LabelsBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.unUsedViews = new ArrayList<>();
        this.usedViews = new ArrayList<>();
        this.textSize = 12.0f;
    }

    public final void setLabels(@NotNull String[] labels) {
        j.e(labels, "labels");
        this.unUsedViews.addAll(this.usedViews);
        this.usedViews.clear();
        removeAllViews();
        for (String str : labels) {
            a(str);
        }
    }
}
