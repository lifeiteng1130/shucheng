package io.legado.app.ui.widget;

import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001aB\u001d\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b%\u0010&J7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0015¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lio/legado/app/ui/widget/SearchView;", "Landroidx/appcompat/widget/SearchView;", "", "changed", "", "left", "top", "right", "bottom", "Lf/v;", "onLayout", "(ZIIII)V", "iconified", "setIconifiedByDefault", "(Z)V", "Landroid/app/SearchableInfo;", "searchable", "setSearchableInfo", "(Landroid/app/SearchableInfo;)V", "", "hint", "setQueryHint", "(Ljava/lang/CharSequence;)V", "updateQueryHint", "()V", "Landroid/graphics/drawable/Drawable;", ai.at, "Landroid/graphics/drawable/Drawable;", "mSearchHintIcon", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SearchView extends androidx.appcompat.widget.SearchView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @Nullable
    public Drawable mSearchHintIcon;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public TextView textView;

    /* JADX INFO: compiled from: SearchView.kt */
    public static final class a extends ImageSpan {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@Nullable Drawable drawable) {
            super(drawable);
            j.c(drawable);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NotNull Canvas canvas, @NotNull CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NotNull Paint paint) {
            j.e(canvas, "canvas");
            j.e(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            j.e(paint, "paint");
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i7 = ((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
            canvas.save();
            canvas.translate(f2, i7);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchView(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    @Override // androidx.appcompat.widget.SearchView, androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        try {
            if (this.textView == null) {
                this.textView = (TextView) findViewById(R.id.search_src_text);
                this.mSearchHintIcon = getContext().getDrawable(R.drawable.ic_search_hint);
                updateQueryHint();
            }
            TextView textView = this.textView;
            j.c(textView);
            textView.setTextSize(2, 14.0f);
            TextView textView2 = this.textView;
            j.c(textView2);
            textView2.setGravity(16);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.appcompat.widget.SearchView
    public void setIconifiedByDefault(boolean iconified) {
        super.setIconifiedByDefault(iconified);
        updateQueryHint();
    }

    @Override // androidx.appcompat.widget.SearchView
    public void setQueryHint(@Nullable CharSequence hint) {
        super.setQueryHint(hint);
        updateQueryHint();
    }

    @Override // androidx.appcompat.widget.SearchView
    public void setSearchableInfo(@Nullable SearchableInfo searchable) {
        super.setSearchableInfo(searchable);
        if (searchable == null) {
            return;
        }
        updateQueryHint();
    }

    public final void updateQueryHint() {
        TextView textView = this.textView;
        if (textView == null) {
            return;
        }
        CharSequence queryHint = getQueryHint();
        CharSequence charSequence = queryHint;
        if (queryHint == null) {
            charSequence = "";
        }
        CharSequence charSequence2 = charSequence;
        if (this.mSearchHintIcon != null) {
            TextView textView2 = this.textView;
            j.c(textView2);
            int textSize = (int) (((double) textView2.getTextSize()) * 0.8d);
            Drawable drawable = this.mSearchHintIcon;
            j.c(drawable);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new a(this.mSearchHintIcon), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            charSequence2 = spannableStringBuilder;
        }
        textView.setHint(charSequence2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
    }
}
