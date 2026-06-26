package splitties.initprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InitProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJM\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lsplitties/initprovider/InitProvider;", "Landroid/content/ContentProvider;", "Landroid/net/Uri;", "uri", "Landroid/content/ContentValues;", "values", "", "b", "(Landroid/net/Uri;Landroid/content/ContentValues;)Ljava/lang/Void;", "", "", "projection", "selection", "selectionArgs", "sortOrder", ai.aD, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Void;", "d", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Void;", ai.at, "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Void;", "<init>", "()V", "splitties-initprovider_release"}, k = 1, mv = {1, 4, 0})
public abstract class InitProvider extends ContentProvider {
    @NotNull
    public final Void a(@NotNull Uri uri) {
        j.f(uri, "uri");
        h.l(null, 1);
        throw null;
    }

    @NotNull
    public final Void b(@NotNull Uri uri) {
        j.f(uri, "uri");
        h.l(null, 1);
        throw null;
    }

    @NotNull
    public final Void c(@NotNull Uri uri) {
        j.f(uri, "uri");
        h.l(null, 1);
        throw null;
    }

    @NotNull
    public final Void d(@NotNull Uri uri) {
        j.f(uri, "uri");
        h.l(null, 1);
        throw null;
    }

    @Override // android.content.ContentProvider
    public /* bridge */ /* synthetic */ int delete(Uri uri, String str, String[] strArr) {
        return ((Number) a(uri)).intValue();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        j.f(uri, "uri");
        h.l(null, 1);
        throw null;
    }

    @Override // android.content.ContentProvider
    public /* bridge */ /* synthetic */ Uri insert(Uri uri, ContentValues contentValues) {
        return (Uri) b(uri);
    }

    @Override // android.content.ContentProvider
    public /* bridge */ /* synthetic */ Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return (Cursor) c(uri);
    }

    @Override // android.content.ContentProvider
    public /* bridge */ /* synthetic */ int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return ((Number) d(uri)).intValue();
    }
}
