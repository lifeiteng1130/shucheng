package e.b.a.r;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.v;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: CssInlineStyleParser.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: compiled from: CssInlineStyleParser.java */
    public static class b extends a {

        /* JADX INFO: renamed from: e.b.a.r.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CssInlineStyleParser.java */
        public static class C0168a implements Iterable<e.b.a.r.b>, Iterable {
            public final String a;

            /* JADX INFO: renamed from: e.b.a.r.a$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: CssInlineStyleParser.java */
            public class C0169a implements Iterator<e.b.a.r.b>, j$.util.Iterator {
                public final e.b.a.r.b a = new e.b.a.r.b();

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final StringBuilder f6034b = new StringBuilder();

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final int f6035c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public int f6036d;

                public C0169a(C0167a c0167a) {
                    this.f6035c = C0168a.this.a.length();
                }

                public final boolean a() {
                    e.b.a.r.b bVar = this.a;
                    return (TextUtils.isEmpty(bVar.a) || TextUtils.isEmpty(bVar.f6038b)) ? false : true;
                }

                @Override // j$.util.Iterator
                public /* synthetic */ void forEachRemaining(Consumer consumer) {
                    Iterator.CC.$default$forEachRemaining(this, consumer);
                }

                @Override // java.util.Iterator, j$.util.Iterator
                public boolean hasNext() {
                    e.b.a.r.b bVar = this.a;
                    bVar.a = "";
                    bVar.f6038b = "";
                    this.f6034b.setLength(0);
                    int i2 = this.f6036d;
                    String strTrim = null;
                    String strTrim2 = null;
                    boolean z = false;
                    while (true) {
                        if (i2 < this.f6035c) {
                            char cCharAt = C0168a.this.a.charAt(i2);
                            if (strTrim == null) {
                                if (':' == cCharAt) {
                                    if (this.f6034b.length() > 0) {
                                        strTrim = this.f6034b.toString().trim();
                                    }
                                    this.f6034b.setLength(0);
                                } else if (';' == cCharAt) {
                                    this.f6034b.setLength(0);
                                } else if (Character.isWhitespace(cCharAt)) {
                                    if (this.f6034b.length() > 0) {
                                        z = true;
                                    }
                                } else if (z) {
                                    this.f6034b.setLength(0);
                                    this.f6034b.append(cCharAt);
                                    z = false;
                                } else {
                                    this.f6034b.append(cCharAt);
                                }
                            } else if (strTrim2 != null) {
                                continue;
                            } else if (Character.isWhitespace(cCharAt)) {
                                if (this.f6034b.length() > 0) {
                                    this.f6034b.append(cCharAt);
                                }
                            } else if (';' == cCharAt) {
                                strTrim2 = this.f6034b.toString().trim();
                                this.f6034b.setLength(0);
                                if ((TextUtils.isEmpty(strTrim) || TextUtils.isEmpty(strTrim2)) ? false : true) {
                                    this.f6036d = i2 + 1;
                                    e.b.a.r.b bVar2 = this.a;
                                    bVar2.a = strTrim;
                                    bVar2.f6038b = strTrim2;
                                    break;
                                }
                            } else {
                                this.f6034b.append(cCharAt);
                            }
                            i2++;
                        } else if (strTrim != null && this.f6034b.length() > 0) {
                            String strTrim3 = this.f6034b.toString().trim();
                            e.b.a.r.b bVar3 = this.a;
                            bVar3.a = strTrim;
                            bVar3.f6038b = strTrim3;
                            this.f6036d = this.f6035c;
                        }
                    }
                    return a();
                }

                @Override // java.util.Iterator, j$.util.Iterator
                public Object next() {
                    if (a()) {
                        return this.a;
                    }
                    throw new NoSuchElementException();
                }
            }

            public C0168a(@NonNull String str) {
                this.a = str;
            }

            @Override // j$.lang.Iterable
            public /* synthetic */ void forEach(Consumer consumer) {
                Iterable.CC.$default$forEach(this, consumer);
            }

            @Override // java.lang.Iterable, j$.lang.Iterable
            @NonNull
            public java.util.Iterator<e.b.a.r.b> iterator() {
                return new C0169a(null);
            }

            @Override // java.lang.Iterable, j$.lang.Iterable
            public /* synthetic */ Spliterator spliterator() {
                return v.o(iterator(), 0);
            }
        }
    }
}
