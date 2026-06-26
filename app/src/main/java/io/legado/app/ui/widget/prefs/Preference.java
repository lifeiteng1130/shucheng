package io.legado.app.ui.widget.prefs;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.PreferenceViewHolder;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.b.a;
import f.c0.c.f;
import f.c0.c.j;
import f.v;
import io.legado.app.R$styleable;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Preference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lio/legado/app/ui/widget/prefs/Preference;", "Landroidx/preference/Preference;", "Landroidx/preference/PreferenceViewHolder;", "holder", "Lf/v;", "onBindViewHolder", "(Landroidx/preference/PreferenceViewHolder;)V", "Lkotlin/Function0;", "b", "Lf/c0/b/a;", "getOnLongClick", "()Lf/c0/b/a;", "setOnLongClick", "(Lf/c0/b/a;)V", "onLongClick", "", ai.aD, "Z", "isBottomBackground", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class Preference extends androidx.preference.Preference {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a<v> onLongClick;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean isBottomBackground;

    /* JADX INFO: renamed from: io.legado.app.ui.widget.prefs.Preference$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Preference.kt */
    public static final class Companion {
        public Companion(f fVar) {
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static android.view.View a(io.legado.app.ui.widget.prefs.Preference.Companion r20, android.content.Context r21, androidx.preference.PreferenceViewHolder r22, android.graphics.drawable.Drawable r23, java.lang.CharSequence r24, java.lang.CharSequence r25, java.lang.Integer r26, java.lang.Integer r27, int r28, int r29, boolean r30, int r31) {
            /*
                Method dump skipped, instruction units count: 429
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.widget.prefs.Preference.Companion.a(io.legado.app.ui.widget.prefs.Preference$a, android.content.Context, androidx.preference.PreferenceViewHolder, android.graphics.drawable.Drawable, java.lang.CharSequence, java.lang.CharSequence, java.lang.Integer, java.lang.Integer, int, int, boolean, int):android.view.View");
        }
    }

    /* JADX INFO: compiled from: Click.kt */
    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ Preference a;

        public b(boolean z, Preference preference) {
            this.a = preference;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            a<v> aVar = this.a.onLongClick;
            if (aVar == null) {
                return true;
            }
            aVar.invoke();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Preference(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        j.e(attributeSet, "attrs");
        setLayoutResource(R.layout.view_preference);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Preference);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.Preference)");
        this.isBottomBackground = typedArrayObtainStyledAttributes.getBoolean(25, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@Nullable PreferenceViewHolder holder) {
        View view;
        Companion companion = INSTANCE;
        Context context = getContext();
        j.d(context, c.R);
        Companion.a(companion, context, holder, getIcon(), getTitle(), getSummary(), null, null, 0, 0, this.isBottomBackground, 480);
        super.onBindViewHolder(holder);
        if (holder == null || (view = holder.itemView) == null) {
            return;
        }
        view.setOnLongClickListener(new b(true, this));
    }
}
