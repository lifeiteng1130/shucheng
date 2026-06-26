package io.legado.app.ui.widget.text;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.app.NotificationCompat;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.d.e;
import f.c0.b.l;
import f.c0.c.j;
import f.v;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.widget.text.AutoCompleteTextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: AutoCompleteTextView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u001d\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\r\u001a\u00020\f2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000f\"\u00020\n¢\u0006\u0004\b\r\u0010\u0011R?\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lio/legado/app/ui/widget/text/AutoCompleteTextView;", "Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;", "", "enoughToFilter", "()Z", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "", "values", "Lf/v;", "setFilterValues", "(Ljava/util/List;)V", "", ES6Iterator.VALUE_PROPERTY, "([Ljava/lang/String;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ai.at, "Lf/c0/b/l;", "getDelCallBack", "()Lf/c0/b/l;", "setDelCallBack", "(Lf/c0/b/l;)V", "delCallBack", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @Nullable
    public l<? super String, v> delCallBack;

    /* JADX INFO: compiled from: AutoCompleteTextView.kt */
    public final class a extends ArrayAdapter<String> {
        public final /* synthetic */ AutoCompleteTextView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull AutoCompleteTextView autoCompleteTextView, @NotNull Context context, List<String> list) {
            super(context, R.layout.simple_dropdown_item_1line, list);
            j.e(autoCompleteTextView, "this$0");
            j.e(context, c.R);
            j.e(list, "values");
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NotNull
        public View getView(final int i2, @Nullable View view, @NotNull ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(io.wenyuange.app.release.R.layout.item_1line_text_and_del, viewGroup, false);
            }
            ((TextView) view.findViewById(io.wenyuange.app.release.R.id.text_view)).setText(getItem(i2));
            ImageView imageView = (ImageView) view.findViewById(io.wenyuange.app.release.R.id.iv_delete);
            l<String, v> delCallBack = this.a.getDelCallBack();
            j.d(imageView, "ivDelete");
            if (delCallBack != null) {
                f.c6(imageView);
            } else {
                f.e3(imageView);
            }
            final AutoCompleteTextView autoCompleteTextView = this.a;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.r.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AutoCompleteTextView.a aVar = this.a;
                    int i3 = i2;
                    AutoCompleteTextView autoCompleteTextView2 = autoCompleteTextView;
                    j.e(aVar, "this$0");
                    j.e(autoCompleteTextView2, "this$1");
                    String item = aVar.getItem(i3);
                    if (item == null) {
                        return;
                    }
                    aVar.remove(item);
                    l<String, v> delCallBack2 = autoCompleteTextView2.getDelCallBack();
                    if (delCallBack2 != null) {
                        delCallBack2.invoke(item);
                    }
                    autoCompleteTextView2.showDropDown();
                }
            });
            j.d(view, "view");
            return view;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutoCompleteTextView(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        return true;
    }

    @Nullable
    public final l<String, v> getDelCallBack() {
        return this.delCallBack;
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        Integer numValueOf = event == null ? null : Integer.valueOf(event.getAction());
        if (numValueOf != null && numValueOf.intValue() == 0) {
            showDropDown();
        }
        return super.onTouchEvent(event);
    }

    public final void setDelCallBack(@Nullable l<? super String, v> lVar) {
        this.delCallBack = lVar;
    }

    public final void setFilterValues(@Nullable List<String> values) {
        if (values == null) {
            return;
        }
        Context context = getContext();
        j.d(context, c.R);
        setAdapter(new a(this, context, values));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutoCompleteTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        ATH ath = ATH.a;
        Context context2 = getContext();
        j.d(context2, c.R);
        int iM1 = f.M1(context2);
        e eVar = e.a;
        Context context3 = getContext();
        j.d(context3, "fun setTint(\n        view: View,\n        @ColorInt color: Int,\n        isDark: Boolean = AppConfig.isNightTheme(view.context)\n    ) {\n        TintHelper.setTintAuto(view, color, false, isDark)\n    }");
        boolean zN = eVar.n(context3);
        j.e(this, "view");
        e.a.a.e.d.c.a.f(this, iM1, false, zN);
    }

    public final void setFilterValues(@NotNull String... value) {
        j.e(value, ES6Iterator.VALUE_PROPERTY);
        Context context = getContext();
        j.d(context, c.R);
        setAdapter(new a(this, context, f.L5(value)));
    }
}
