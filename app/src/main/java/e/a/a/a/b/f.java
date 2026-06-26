package e.a.a.a.b;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import e.a.a.h.n;
import e.a.a.h.y;
import f.c0.c.j;
import f.h;
import f.h0.k;
import f.v;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SourceController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<BookSource> {
    }

    @NotNull
    public static final e.a.a.a.a a(@Nullable String str) {
        Object objM11constructorimpl;
        try {
            v vVar = null;
            try {
                Object objFromJson = n.a().fromJson(str, new y(BookSource.class));
                objM11constructorimpl = h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            if (h.m16isFailureimpl(objM11constructorimpl)) {
                objM11constructorimpl = null;
            }
            List list = (List) objM11constructorimpl;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    AppDatabaseKt.getAppDb().getBookSourceDao().delete((BookSource) it.next());
                }
                vVar = v.a;
            }
            h.m11constructorimpl(vVar);
        } catch (Throwable th2) {
            h.m11constructorimpl(c.b.a.m.f.m1(th2));
        }
        e.a.a.a.a aVar = new e.a.a.a.a();
        aVar.a("已执行");
        return aVar;
    }

    @NotNull
    public static final e.a.a.a.a b(@Nullable String str) {
        Object objM11constructorimpl;
        Object objM11constructorimpl2;
        e.a.a.a.a aVar = new e.a.a.a.a();
        try {
            Gson gsonA = n.a();
            Object obj = null;
            try {
                Type type = new a().getType();
                j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(str, type);
                if (!(objFromJson instanceof BookSource)) {
                    objFromJson = null;
                }
                objM11constructorimpl2 = h.m11constructorimpl((BookSource) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl2 = h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            if (!h.m16isFailureimpl(objM11constructorimpl2)) {
                obj = objM11constructorimpl2;
            }
            BookSource bookSource = (BookSource) obj;
            if (bookSource == null) {
                j.e("转换书源失败", "errorMsg");
            } else if (TextUtils.isEmpty(bookSource.getBookSourceName()) || TextUtils.isEmpty(bookSource.getBookSourceUrl())) {
                j.e("书源名称和URL不能为空", "errorMsg");
            } else {
                AppDatabaseKt.getAppDb().getBookSourceDao().insert(bookSource);
                aVar.a("");
            }
            objM11constructorimpl = h.m11constructorimpl(aVar);
        } catch (Throwable th2) {
            objM11constructorimpl = h.m11constructorimpl(c.b.a.m.f.m1(th2));
        }
        Throwable thM14exceptionOrNullimpl = h.m14exceptionOrNullimpl(objM11constructorimpl);
        if (thM14exceptionOrNullimpl != null) {
            j.e(c.b.a.m.f.C2(thM14exceptionOrNullimpl), "errorMsg");
        }
        return aVar;
    }

    @NotNull
    public static final e.a.a.a.a c(@Nullable String str) {
        Object objM11constructorimpl;
        ArrayList arrayList = new ArrayList();
        try {
            Object obj = null;
            try {
                Object objFromJson = n.a().fromJson(str, new y(BookSource.class));
                objM11constructorimpl = h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            if (!h.m16isFailureimpl(objM11constructorimpl)) {
                obj = objM11constructorimpl;
            }
            List<BookSource> list = (List) obj;
            if (list != null) {
                for (BookSource bookSource : list) {
                    if (!k.s(bookSource.getBookSourceName()) && !k.s(bookSource.getBookSourceUrl())) {
                        AppDatabaseKt.getAppDb().getBookSourceDao().insert(bookSource);
                        arrayList.add(bookSource);
                    }
                }
            }
            h.m11constructorimpl(v.a);
        } catch (Throwable th2) {
            h.m11constructorimpl(c.b.a.m.f.m1(th2));
        }
        e.a.a.a.a aVar = new e.a.a.a.a();
        aVar.a(arrayList);
        return aVar;
    }
}
