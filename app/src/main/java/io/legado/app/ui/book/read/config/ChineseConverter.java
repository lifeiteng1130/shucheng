package io.legado.app.ui.book.read.config;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import c.b.a.m.f;
import com.umeng.analytics.pro.c;
import e.a.a.d.e;
import f.c0.b.a;
import f.c0.c.j;
import f.v;
import io.legado.app.ui.book.read.config.ChineseConverter;
import io.legado.app.ui.widget.text.StrokeTextView;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChineseConverter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lio/legado/app/ui/book/read/config/ChineseConverter;", "Lio/legado/app/ui/widget/text/StrokeTextView;", "", "type", "Lf/v;", "b", "(I)V", "Landroid/text/style/ForegroundColorSpan;", "e", "Landroid/text/style/ForegroundColorSpan;", "enabledSpan", "Landroid/text/SpannableString;", "d", "Landroid/text/SpannableString;", "spannableString", "Lkotlin/Function0;", "f", "Lf/c0/b/a;", "onChanged", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ChineseConverter extends StrokeTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f7179c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SpannableString spannableString;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public ForegroundColorSpan enabledSpan;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a<v> onChanged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChineseConverter(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        SpannableString spannableString = new SpannableString("简/繁");
        this.spannableString = spannableString;
        this.enabledSpan = new ForegroundColorSpan(f.M1(context));
        setText(spannableString);
        if (!isInEditMode()) {
            b(e.a.b());
        }
        setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChineseConverter chineseConverter = this.a;
                int i2 = ChineseConverter.f7179c;
                f.c0.c.j.e(chineseConverter, "this$0");
                Context context2 = chineseConverter.getContext();
                f.c0.c.j.d(context2, com.umeng.analytics.pro.c.R);
                ((e.a.a.e.a.i) c.b.a.m.f.j0(context2, Integer.valueOf(R.string.chinese_converter), null, new l2(chineseConverter), 2)).p();
            }
        });
    }

    public final void b(int type) {
        this.spannableString.removeSpan(this.enabledSpan);
        if (type == 1) {
            this.spannableString.setSpan(this.enabledSpan, 0, 1, 17);
        } else if (type == 2) {
            this.spannableString.setSpan(this.enabledSpan, 2, 3, 17);
        }
        setText(this.spannableString);
    }
}
