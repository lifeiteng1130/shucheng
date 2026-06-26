package e.b.a.r.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import e.b.a.r.p.d;
import e.b.a.s.i;

/* JADX INFO: compiled from: ImageSizeParserImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements d.a {
    public final e.b.a.r.a a;

    public e(@NonNull e.b.a.r.a aVar) {
        this.a = aVar;
    }

    @Nullable
    @VisibleForTesting
    public i.a a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        int i2 = length - 1;
        int i3 = i2;
        while (i3 > -1) {
            if (Character.isDigit(str.charAt(i3))) {
                int i4 = i3 + 1;
                try {
                    return new i.a(Float.parseFloat(str.substring(0, i4)), i3 == i2 ? null : str.substring(i4, length));
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            i3--;
        }
        return null;
    }
}
