package io.legado.app.web;

import com.google.gson.Gson;
import com.ifmvo.togetherad.gdt.other.NetworkRequestAsyncTask;
import com.umeng.analytics.pro.c;
import d.a.a.a;
import e.a.a.a.b.b;
import e.a.a.a.b.d;
import e.a.a.a.b.f;
import f.c0.c.j;
import f.h0.k;
import f.x.e;
import h.a.a.a.w;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookSource;
import io.legado.app.web.utils.AssetsWeb;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpServer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lio/legado/app/web/HttpServer;", "Ld/a/a/a;", "Ld/a/a/a$m;", c.aw, "Ld/a/a/a$o;", "serve", "(Ld/a/a/a$m;)Ld/a/a/a$o;", "Lio/legado/app/web/utils/AssetsWeb;", "assetsWeb", "Lio/legado/app/web/utils/AssetsWeb;", "", "port", "<init>", "(I)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class HttpServer extends a {

    @NotNull
    private final AssetsWeb assetsWeb;

    public HttpServer(int i2) {
        super(i2);
        this.assetsWeb = new AssetsWeb("web");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // d.a.a.a
    @NotNull
    public a.o serve(@NotNull a.m session) throws Throwable {
        e.a.a.a.a aVarA;
        e.a.a.a.a aVar;
        j.e(session, c.aw);
        String strK = ((a.l) session).f5467f;
        try {
            String strName = ((a.l) session).f5468g.name();
            int iHashCode = strName.hashCode();
            Object obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            String str = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            String str2 = null;
            obj = null;
            obj = null;
            obj = null;
            try {
                if (iHashCode != -531492226) {
                    if (iHashCode != 70454) {
                        if (iHashCode == 2461856 && strName.equals("POST")) {
                            HashMap map = new HashMap();
                            ((a.l) session).g(map);
                            String str3 = (String) map.get("postData");
                            if (strK != null) {
                                switch (strK.hashCode()) {
                                    case -1786899097:
                                        if (strK.equals("/saveSource")) {
                                            aVarA = f.b(str3);
                                            obj = aVarA;
                                        }
                                        break;
                                    case -1124152523:
                                        if (strK.equals("/saveBook")) {
                                            aVarA = b.c(str3);
                                            obj = aVarA;
                                        }
                                        break;
                                    case -218100802:
                                        if (strK.equals("/deleteSources")) {
                                            aVarA = f.a(str3);
                                            obj = aVarA;
                                        }
                                        break;
                                    case 440702956:
                                        if (strK.equals("/saveSources")) {
                                            aVarA = f.c(str3);
                                            obj = aVarA;
                                        }
                                        break;
                                }
                            }
                        }
                    } else if (strName.equals(NetworkRequestAsyncTask.REQUEST_METHOD)) {
                        Map<String, List<String>> map2 = ((a.l) session).f5469h;
                        if (strK != null) {
                            boolean z = true;
                            switch (strK.hashCode()) {
                                case -1791167991:
                                    if (strK.equals("/getBookContent")) {
                                        j.d(map2, "parameters");
                                        aVarA = b.a(map2);
                                        obj = aVarA;
                                    }
                                    break;
                                case 153309122:
                                    if (strK.equals("/getSource")) {
                                        j.d(map2, "parameters");
                                        j.e(map2, "parameters");
                                        List<String> list = map2.get("url");
                                        if (list != null) {
                                            str2 = (String) e.n(list, 0);
                                        }
                                        aVarA = new e.a.a.a.a();
                                        if (str2 != null && str2.length() != 0) {
                                            z = false;
                                        }
                                        if (z) {
                                            j.e("参数url不能为空，请指定书源地址", "errorMsg");
                                        } else {
                                            BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(str2);
                                            if (bookSource == null) {
                                                j.e("未找到书源，请检查书源地址", "errorMsg");
                                            } else {
                                                aVarA.a(bookSource);
                                            }
                                        }
                                        obj = aVarA;
                                    }
                                    break;
                                case 457615601:
                                    if (strK.equals("/getSources")) {
                                        List<BookSource> all = AppDatabaseKt.getAppDb().getBookSourceDao().getAll();
                                        aVar = new e.a.a.a.a();
                                        if (all.isEmpty()) {
                                            j.e("设备书源列表为空", "errorMsg");
                                        } else {
                                            aVar.a(all);
                                        }
                                        obj = aVar;
                                    }
                                    break;
                                case 1120785884:
                                    if (strK.equals("/refreshToc")) {
                                        j.d(map2, "parameters");
                                        aVarA = b.b(map2);
                                        obj = aVarA;
                                    }
                                    break;
                                case 1128280026:
                                    if (strK.equals("/getBookshelf")) {
                                        List<Book> all2 = AppDatabaseKt.getAppDb().getBookDao().getAll();
                                        aVar = new e.a.a.a.a();
                                        if (all2.isEmpty()) {
                                            j.e("还没有添加小说", "errorMsg");
                                        } else {
                                            int iM2 = c.b.a.m.f.M2(h.g(), "bookshelfSort", 0, 2);
                                            aVar.a(iM2 != 1 ? iM2 != 2 ? iM2 != 3 ? e.B(all2, new e.a.a.a.b.e()) : e.B(all2, new e.a.a.a.b.c()) : e.B(all2, e.a.a.a.b.a.a) : e.B(all2, new d()));
                                        }
                                        obj = aVar;
                                    }
                                    break;
                                case 1995340612:
                                    if (strK.equals("/getChapterList")) {
                                        j.d(map2, "parameters");
                                        j.e(map2, "parameters");
                                        List<String> list2 = map2.get("url");
                                        if (list2 != null) {
                                            str = (String) e.n(list2, 0);
                                        }
                                        aVarA = new e.a.a.a.a();
                                        if (str != null && str.length() != 0) {
                                            z = false;
                                        }
                                        if (z) {
                                            j.e("参数url不能为空，请指定书籍地址", "errorMsg");
                                        } else {
                                            aVarA.a(AppDatabaseKt.getAppDb().getBookChapterDao().getChapterList(str));
                                        }
                                        obj = aVarA;
                                    }
                                    break;
                            }
                        }
                    }
                } else if (strName.equals("OPTIONS")) {
                    a.o oVarNewFixedLengthResponse = a.newFixedLengthResponse("");
                    oVarNewFixedLengthResponse.f5477e.put("Access-Control-Allow-Methods", "POST");
                    oVarNewFixedLengthResponse.f5477e.put("Access-Control-Allow-Headers", "content-type");
                    oVarNewFixedLengthResponse.f5477e.put("Access-Control-Allow-Origin", ((a.l) session).f5470i.get("origin"));
                    j.d(oVarNewFixedLengthResponse, "response");
                    return oVarNewFixedLengthResponse;
                }
                if (obj != null) {
                    a.o oVarNewFixedLengthResponse2 = a.newFixedLengthResponse(new Gson().toJson(obj));
                    oVarNewFixedLengthResponse2.f5477e.put("Access-Control-Allow-Methods", "GET, POST");
                    oVarNewFixedLengthResponse2.f5477e.put("Access-Control-Allow-Origin", ((a.l) session).f5470i.get("origin"));
                    j.d(oVarNewFixedLengthResponse2, "response");
                    return oVarNewFixedLengthResponse2;
                }
                j.d(strK, "uri");
                if (k.h(strK, w.DEFAULT_PATH_SEPARATOR, false, 2)) {
                    strK = j.k(strK, "index.html");
                }
                AssetsWeb assetsWeb = this.assetsWeb;
                j.d(strK, "uri");
                return assetsWeb.getResponse(strK);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        a.o oVarNewFixedLengthResponse3 = a.newFixedLengthResponse(e.getMessage());
        j.d(oVarNewFixedLengthResponse3, "newFixedLengthResponse(e.message)");
        return oVarNewFixedLengthResponse3;
    }
}
