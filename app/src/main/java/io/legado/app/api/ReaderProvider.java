package io.legado.app.api;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.media2.session.MediaConstants;
import c.b.a.m.f;
import com.google.gson.Gson;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReaderProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u001a\u0018B\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011JM\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001a\u0010\u001d¨\u0006!"}, d2 = {"Lio/legado/app/api/ReaderProvider;", "Landroid/content/ContentProvider;", "", "onCreate", "()Z", "Landroid/net/Uri;", "uri", "", "selection", "", "selectionArgs", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "Landroid/content/ContentValues;", "values", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "projection", "sortOrder", "Landroid/database/Cursor;", MediaConstants.MEDIA_URI_QUERY_QUERY, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Landroid/content/UriMatcher;", "b", "Lf/e;", ai.at, "()Landroid/content/UriMatcher;", "sMatcher", "Ljava/lang/String;", "postBodyKey", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReaderProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final String postBodyKey = "json";

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e sMatcher = f.N3(new d());

    /* JADX INFO: compiled from: ReaderProvider.kt */
    public enum a {
        SaveSource,
        SaveSources,
        SaveBook,
        DeleteSources,
        GetSource,
        GetSources,
        GetBookshelf,
        RefreshToc,
        GetChapterList,
        GetBookContent;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            return (a[]) Arrays.copyOf(aVarArrValuesCustom, aVarArrValuesCustom.length);
        }
    }

    /* JADX INFO: compiled from: ReaderProvider.kt */
    public static final class b extends MatrixCursor {

        @NotNull
        public final String a;

        public b(@Nullable e.a.a.a.a aVar) {
            super(new String[]{"result"}, 1);
            String json = new Gson().toJson(aVar);
            j.d(json, "Gson().toJson(data)");
            this.a = json;
            addRow(new String[]{json});
        }
    }

    /* JADX INFO: compiled from: ReaderProvider.kt */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            a.valuesCustom();
            int[] iArr = new int[10];
            iArr[a.DeleteSources.ordinal()] = 1;
            iArr[a.SaveSource.ordinal()] = 2;
            iArr[a.SaveBook.ordinal()] = 3;
            iArr[a.SaveSources.ordinal()] = 4;
            iArr[a.GetSource.ordinal()] = 5;
            iArr[a.GetSources.ordinal()] = 6;
            iArr[a.GetBookshelf.ordinal()] = 7;
            iArr[a.GetBookContent.ordinal()] = 8;
            iArr[a.RefreshToc.ordinal()] = 9;
            iArr[a.GetChapterList.ordinal()] = 10;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: ReaderProvider.kt */
    public static final class d extends k implements f.c0.b.a<UriMatcher> {
        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final UriMatcher invoke() {
            ApplicationInfo applicationInfo;
            UriMatcher uriMatcher = new UriMatcher(-1);
            Context context = ReaderProvider.this.getContext();
            String str = null;
            if (context != null && (applicationInfo = context.getApplicationInfo()) != null) {
                str = applicationInfo.packageName;
            }
            String strK = j.k(str, ".readerProvider");
            uriMatcher.addURI(strK, "source/insert", a.SaveSource.ordinal());
            uriMatcher.addURI(strK, "sources/insert", a.SaveSources.ordinal());
            uriMatcher.addURI(strK, "book/insert", a.SaveBook.ordinal());
            uriMatcher.addURI(strK, "sources/delete", a.DeleteSources.ordinal());
            uriMatcher.addURI(strK, "source/query", a.GetSource.ordinal());
            uriMatcher.addURI(strK, "sources/query", a.GetSources.ordinal());
            uriMatcher.addURI(strK, "books/query", a.GetBookshelf.ordinal());
            uriMatcher.addURI(strK, "book/refreshToc/query", a.RefreshToc.ordinal());
            uriMatcher.addURI(strK, "book/chapter/query", a.GetChapterList.ordinal());
            uriMatcher.addURI(strK, "book/content/query", a.GetBookContent.ordinal());
            return uriMatcher;
        }
    }

    public final UriMatcher a() {
        return (UriMatcher) this.sMatcher.getValue();
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        j.e(uri, "uri");
        if (a().match(uri) < 0) {
            return -1;
        }
        if (c.a[a.valuesCustom()[a().match(uri)].ordinal()] != 1) {
            throw new IllegalStateException(j.k("Unexpected value: ", a.valuesCustom()[a().match(uri)].name()));
        }
        e.a.a.a.b.f.a(selection);
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        j.e(uri, "uri");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues values) {
        j.e(uri, "uri");
        if (a().match(uri) < 0) {
            return null;
        }
        int iOrdinal = a.valuesCustom()[a().match(uri)].ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    throw new IllegalStateException(j.k("Unexpected value: ", a.valuesCustom()[a().match(uri)].name()));
                }
                if (values != null) {
                    e.a.a.a.b.b.c(values.getAsString(this.postBodyKey));
                }
            } else if (values != null) {
                e.a.a.a.b.f.c(values.getAsString(this.postBodyKey));
            }
        } else if (values != null) {
            e.a.a.a.b.f.b(values.getAsString(this.postBodyKey));
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        b bVar;
        String str;
        j.e(uri, "uri");
        HashMap map = new HashMap();
        String queryParameter = uri.getQueryParameter("url");
        boolean z = true;
        if (queryParameter != null) {
            map.put("url", f.x.e.a(queryParameter));
        }
        String queryParameter2 = uri.getQueryParameter("index");
        if (queryParameter2 != null) {
            map.put("index", f.x.e.a(queryParameter2));
        }
        if (a().match(uri) < 0) {
            return null;
        }
        switch (a.valuesCustom()[a().match(uri)].ordinal()) {
            case 4:
                j.e(map, "parameters");
                List list = (List) map.get("url");
                str = list != null ? (String) f.x.e.n(list, 0) : null;
                e.a.a.a.a aVar = new e.a.a.a.a();
                if (str != null && str.length() != 0) {
                    z = false;
                }
                if (z) {
                    j.e("参数url不能为空，请指定书源地址", "errorMsg");
                } else {
                    BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(str);
                    if (bookSource == null) {
                        j.e("未找到书源，请检查书源地址", "errorMsg");
                    } else {
                        aVar.a(bookSource);
                    }
                }
                bVar = new b(aVar);
                break;
            case 5:
                List<BookSource> all = AppDatabaseKt.getAppDb().getBookSourceDao().getAll();
                e.a.a.a.a aVar2 = new e.a.a.a.a();
                if (all.isEmpty()) {
                    j.e("设备书源列表为空", "errorMsg");
                } else {
                    aVar2.a(all);
                }
                bVar = new b(aVar2);
                break;
            case 6:
                List<Book> all2 = AppDatabaseKt.getAppDb().getBookDao().getAll();
                e.a.a.a.a aVar3 = new e.a.a.a.a();
                if (all2.isEmpty()) {
                    j.e("还没有添加小说", "errorMsg");
                } else {
                    int iM2 = f.M2(h.g(), "bookshelfSort", 0, 2);
                    aVar3.a(iM2 != 1 ? iM2 != 2 ? iM2 != 3 ? f.x.e.B(all2, new e.a.a.a.b.e()) : f.x.e.B(all2, new e.a.a.a.b.c()) : f.x.e.B(all2, e.a.a.a.b.a.a) : f.x.e.B(all2, new e.a.a.a.b.d()));
                }
                bVar = new b(aVar3);
                break;
            case 7:
                bVar = new b(e.a.a.a.b.b.b(map));
                break;
            case 8:
                j.e(map, "parameters");
                List list2 = (List) map.get("url");
                str = list2 != null ? (String) f.x.e.n(list2, 0) : null;
                e.a.a.a.a aVar4 = new e.a.a.a.a();
                if (str != null && str.length() != 0) {
                    z = false;
                }
                if (z) {
                    j.e("参数url不能为空，请指定书籍地址", "errorMsg");
                } else {
                    aVar4.a(AppDatabaseKt.getAppDb().getBookChapterDao().getChapterList(str));
                }
                bVar = new b(aVar4);
                break;
            case 9:
                bVar = new b(e.a.a.a.b.b.a(map));
                break;
            default:
                throw new IllegalStateException(j.k("Unexpected value: ", a.valuesCustom()[a().match(uri)].name()));
        }
        return bVar;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        j.e(uri, "uri");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
