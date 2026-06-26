package e.b.a.r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: HtmlEmptyTagReplacement.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    @Nullable
    public String a(@NonNull e eVar) {
        String str = ((f) eVar).a;
        if ("br".equals(str)) {
            return "\n";
        }
        if ("img".equals(str)) {
            String str2 = eVar.d().get("alt");
            return (str2 == null || str2.length() == 0) ? "￼" : str2;
        }
        if ("iframe".equals(str)) {
            return " ";
        }
        return null;
    }
}
