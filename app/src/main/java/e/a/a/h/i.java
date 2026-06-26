package e.a.a.h;

import android.net.Uri;
import java.util.Date;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DocumentUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    @NotNull
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f5954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final Date f5956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final Uri f5957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final f.e f5958f;

    /* JADX INFO: compiled from: DocumentUtils.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.a<Boolean> {
        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return f.c0.c.j.a("vnd.android.document/directory", i.this.f5954b);
        }
    }

    public i(@NotNull String str, @NotNull String str2, long j2, @NotNull Date date, @NotNull Uri uri) {
        f.c0.c.j.e(str, "name");
        f.c0.c.j.e(str2, "attr");
        f.c0.c.j.e(date, "date");
        f.c0.c.j.e(uri, "uri");
        this.a = str;
        this.f5954b = str2;
        this.f5955c = j2;
        this.f5956d = date;
        this.f5957e = uri;
        this.f5958f = c.b.a.m.f.N3(new a());
    }

    public final boolean a() {
        return ((Boolean) this.f5958f.getValue()).booleanValue();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return f.c0.c.j.a(this.a, iVar.a) && f.c0.c.j.a(this.f5954b, iVar.f5954b) && this.f5955c == iVar.f5955c && f.c0.c.j.a(this.f5956d, iVar.f5956d) && f.c0.c.j.a(this.f5957e, iVar.f5957e);
    }

    public int hashCode() {
        return this.f5957e.hashCode() + ((this.f5956d.hashCode() + ((e.a.a.c.b.a(this.f5955c) + c.a.a.a.a.m(this.f5954b, this.a.hashCode() * 31, 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("DocItem(name=");
        sbR.append(this.a);
        sbR.append(", attr=");
        sbR.append(this.f5954b);
        sbR.append(", size=");
        sbR.append(this.f5955c);
        sbR.append(", date=");
        sbR.append(this.f5956d);
        sbR.append(", uri=");
        sbR.append(this.f5957e);
        sbR.append(')');
        return sbR.toString();
    }
}
