package e.b.a.r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.r.e;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: HtmlTagImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements e {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f6043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6044d = -1;

    /* JADX INFO: compiled from: HtmlTagImpl.java */
    public static class a extends f implements e.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a f6045e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<a> f6046f;

        public a(@NonNull String str, int i2, @NonNull Map<String, String> map, @Nullable a aVar) {
            super(str, i2, map);
            this.f6045e = aVar;
        }

        @NonNull
        public static a h() {
            return new a("", 0, Collections.emptyMap(), null);
        }

        @Override // e.b.a.r.e.a
        @Nullable
        public e.a a() {
            return this.f6045e;
        }

        @Override // e.b.a.r.e
        @NonNull
        public e.a b() {
            return this;
        }

        @Override // e.b.a.r.e
        public boolean c() {
            return true;
        }

        @Override // e.b.a.r.f, e.b.a.r.e
        @NonNull
        public Map<String, String> d() {
            return this.f6043c;
        }

        @Override // e.b.a.r.e.a
        @NonNull
        public List<e.a> e() {
            List<a> list = this.f6046f;
            return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        }

        public void g(int i2) {
            if (isClosed()) {
                return;
            }
            this.f6044d = i2;
            List<a> list = this.f6046f;
            if (list != null) {
                Iterator<a> it = list.iterator();
                while (it.hasNext()) {
                    it.next().g(i2);
                }
            }
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("BlockImpl{name='");
            c.a.a.a.a.y(sbR, this.a, '\'', ", start=");
            sbR.append(this.f6042b);
            sbR.append(", end=");
            sbR.append(this.f6044d);
            sbR.append(", attributes=");
            sbR.append(this.f6043c);
            sbR.append(", parent=");
            a aVar = this.f6045e;
            sbR.append(aVar != null ? aVar.a : null);
            sbR.append(", children=");
            sbR.append(this.f6046f);
            sbR.append(MessageFormatter.DELIM_STOP);
            return sbR.toString();
        }
    }

    /* JADX INFO: compiled from: HtmlTagImpl.java */
    public static class b extends f implements e.b {
        public b(@NonNull String str, int i2, @NonNull Map<String, String> map) {
            super(str, i2, map);
        }

        @Override // e.b.a.r.e
        @NonNull
        public e.a b() {
            throw new ClassCastException("Cannot cast Inline instance to Block");
        }

        @Override // e.b.a.r.e
        public boolean c() {
            return false;
        }

        public void g(int i2) {
            if (isClosed()) {
                return;
            }
            this.f6044d = i2;
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("InlineImpl{name='");
            c.a.a.a.a.y(sbR, this.a, '\'', ", start=");
            sbR.append(this.f6042b);
            sbR.append(", end=");
            sbR.append(this.f6044d);
            sbR.append(", attributes=");
            sbR.append(this.f6043c);
            sbR.append(MessageFormatter.DELIM_STOP);
            return sbR.toString();
        }
    }

    public f(@NonNull String str, int i2, @NonNull Map<String, String> map) {
        this.a = str;
        this.f6042b = i2;
        this.f6043c = map;
    }

    @Override // e.b.a.r.e
    @NonNull
    public Map<String, String> d() {
        return this.f6043c;
    }

    @Override // e.b.a.r.e
    public int f() {
        return this.f6044d;
    }

    @Override // e.b.a.r.e
    public boolean isClosed() {
        return this.f6044d > -1;
    }

    @Override // e.b.a.r.e
    @NonNull
    public String name() {
        return this.a;
    }

    @Override // e.b.a.r.e
    public int start() {
        return this.f6042b;
    }
}
