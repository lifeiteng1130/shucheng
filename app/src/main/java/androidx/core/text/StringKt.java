package androidx.core.text;

import android.text.TextUtils;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: String.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "htmlEncode", "(Ljava/lang/String;)Ljava/lang/String;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class StringKt {
    @NotNull
    public static final String htmlEncode(@NotNull String str) {
        j.f(str, "$this$htmlEncode");
        String strHtmlEncode = TextUtils.htmlEncode(str);
        j.b(strHtmlEncode, "TextUtils.htmlEncode(this)");
        return strHtmlEncode;
    }
}
