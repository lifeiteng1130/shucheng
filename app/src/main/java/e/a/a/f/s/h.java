package e.a.a.f.s;

import android.content.Context;
import android.content.Intent;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.service.CacheBookService;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CacheBook.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    @NotNull
    public static final h a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ArrayList<String> f5672b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final ConcurrentHashMap<String, CopyOnWriteArraySet<Integer>> f5673c = new ConcurrentHashMap<>();

    public static void b(h hVar, a0 a0Var, WebBook webBook, Book book, BookChapter bookChapter, boolean z, int i2) {
        if ((i2 & 16) != 0) {
            z = false;
        }
        f.c0.c.j.e(a0Var, "scope");
        f.c0.c.j.e(webBook, "webBook");
        f.c0.c.j.e(book, "book");
        f.c0.c.j.e(bookChapter, "chapter");
        ConcurrentHashMap<String, CopyOnWriteArraySet<Integer>> concurrentHashMap = f5673c;
        CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) concurrentHashMap.get(book.getBookUrl());
        if (f.c0.c.j.a(copyOnWriteArraySet == null ? null : Boolean.valueOf(copyOnWriteArraySet.contains(Integer.valueOf(bookChapter.getIndex()))), Boolean.TRUE)) {
            return;
        }
        if (concurrentHashMap.get(book.getBookUrl()) == null) {
            concurrentHashMap.put(book.getBookUrl(), new CopyOnWriteArraySet<>());
        }
        CopyOnWriteArraySet copyOnWriteArraySet2 = (CopyOnWriteArraySet) concurrentHashMap.get(book.getBookUrl());
        if (copyOnWriteArraySet2 != null) {
            copyOnWriteArraySet2.add(Integer.valueOf(bookChapter.getIndex()));
        }
        e.a.a.d.u.b content$default = WebBook.getContent$default(webBook, a0Var, book, bookChapter, null, null, 24, null);
        e.a.a.d.u.b.e(content$default, null, new e(book, bookChapter, z, null), 1);
        e.a.a.d.u.b.b(content$default, null, new f(book, bookChapter, z, null), 1);
        e.a.a.d.u.b.c(content$default, null, new g(book, bookChapter, null), 1);
    }

    public final void a(@Nullable String str) {
        if (str == null) {
            return;
        }
        synchronized (this) {
            ArrayList<String> arrayList = f5672b;
            if (arrayList.size() > 1000) {
                arrayList.remove(0);
            }
            arrayList.add(str);
        }
    }

    public final void c(@NotNull Context context, @NotNull String str, int i2, int i3) {
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(str, "bookUrl");
        Intent intent = new Intent(context, (Class<?>) CacheBookService.class);
        intent.setAction("start");
        intent.putExtra("bookUrl", str);
        intent.putExtra("start", i2);
        intent.putExtra("end", i3);
        context.startService(intent);
    }
}
