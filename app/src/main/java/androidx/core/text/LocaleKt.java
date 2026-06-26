package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import f.c0.c.j;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Locale.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ljava/util/Locale;", "", "getLayoutDirection", "(Ljava/util/Locale;)I", "layoutDirection", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(@NotNull Locale locale) {
        j.f(locale, "$this$layoutDirection");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
