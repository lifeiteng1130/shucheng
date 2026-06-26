package e.a.a.d;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.ReplaceRule;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentProcessor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    @NotNull
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f5539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public ArrayList<ReplaceRule> f5540c;

    public k(@NotNull String str, @NotNull String str2) {
        f.c0.c.j.e(str, "bookName");
        f.c0.c.j.e(str2, "bookOrigin");
        this.a = str;
        this.f5539b = str2;
        this.f5540c = new ArrayList<>();
        c();
    }

    public static /* synthetic */ List b(k kVar, Book book, String str, String str2, boolean z, boolean z2, int i2) {
        boolean z3 = (i2 & 8) != 0 ? true : z;
        if ((i2 & 16) != 0) {
            z2 = book.getUseReplaceRule();
        }
        return kVar.a(book, str, str2, z3, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006f A[Catch: all -> 0x0127, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0014, B:6:0x001a, B:8:0x0020, B:13:0x0035, B:15:0x003b, B:16:0x004d, B:18:0x005b, B:20:0x006f, B:22:0x0075, B:23:0x007b, B:28:0x0087, B:29:0x0091, B:31:0x009c, B:32:0x00a5, B:33:0x00b9, B:35:0x00bf, B:37:0x00d4, B:39:0x00e2, B:41:0x00eb, B:46:0x00f6, B:47:0x0104, B:52:0x010f, B:53:0x011d, B:54:0x0124), top: B:63:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5 A[Catch: all -> 0x0127, PHI: r9
  0x00a5: PHI (r9v2 java.lang.String) = (r9v1 java.lang.String), (r9v5 java.lang.String), (r9v6 java.lang.String), (r9v5 java.lang.String) binds: [B:19:0x006d, B:31:0x009c, B:30:0x009a, B:27:0x0086] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0014, B:6:0x001a, B:8:0x0020, B:13:0x0035, B:15:0x003b, B:16:0x004d, B:18:0x005b, B:20:0x006f, B:22:0x0075, B:23:0x007b, B:28:0x0087, B:29:0x0091, B:31:0x009c, B:32:0x00a5, B:33:0x00b9, B:35:0x00bf, B:37:0x00d4, B:39:0x00e2, B:41:0x00eb, B:46:0x00f6, B:47:0x0104, B:52:0x010f, B:53:0x011d, B:54:0x0124), top: B:63:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf A[Catch: all -> 0x0127, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0014, B:6:0x001a, B:8:0x0020, B:13:0x0035, B:15:0x003b, B:16:0x004d, B:18:0x005b, B:20:0x006f, B:22:0x0075, B:23:0x007b, B:28:0x0087, B:29:0x0091, B:31:0x009c, B:32:0x00a5, B:33:0x00b9, B:35:0x00bf, B:37:0x00d4, B:39:0x00e2, B:41:0x00eb, B:46:0x00f6, B:47:0x0104, B:52:0x010f, B:53:0x011d, B:54:0x0124), top: B:63:0x0001, inners: #0, #1 }] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.util.List<java.lang.String> a(@org.jetbrains.annotations.NotNull io.legado.app.data.entities.Book r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.k.a(io.legado.app.data.entities.Book, java.lang.String, java.lang.String, boolean, boolean):java.util.List");
    }

    public final synchronized void c() {
        this.f5540c.clear();
        this.f5540c.addAll(AppDatabaseKt.getAppDb().getReplaceRuleDao().findEnabledByScope(this.a, this.f5539b));
    }
}
