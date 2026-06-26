package io.legado.app.ui.book.local;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import e.a.a.h.i;
import f.c0.b.a;
import f.c0.b.l;
import f.c0.c.j;
import f.h0.k;
import f.v;
import io.legado.app.base.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportBookViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018JR\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010JR\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lio/legado/app/ui/book/local/ImportBookViewModel;", "Lio/legado/app/base/BaseViewModel;", "Landroidx/documentfile/provider/DocumentFile;", "documentFile", "", "isRoot", "Lkotlin/Function1;", "Le/a/a/h/i;", "Lkotlin/ParameterName;", "name", "docItem", "Lf/v;", "find", "Lkotlin/Function0;", "finally", "e", "(Landroidx/documentfile/provider/DocumentFile;ZLf/c0/b/l;Lf/c0/b/a;)V", "Ljava/io/File;", "file", "f", "(Ljava/io/File;ZLf/c0/b/l;Lf/c0/b/a;)V", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ImportBookViewModel extends BaseViewModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportBookViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }

    public final void e(@NotNull DocumentFile documentFile, boolean isRoot, @NotNull l<? super i, v> find, @Nullable a<v> aVar) {
        j.e(documentFile, "documentFile");
        j.e(find, "find");
        e.a.a.h.j jVar = e.a.a.h.j.a;
        Context contextB = b();
        Uri uri = documentFile.getUri();
        j.d(uri, "documentFile.uri");
        for (i iVar : jVar.d(contextB, uri)) {
            if (iVar.a()) {
                DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(b(), iVar.f5957e);
                if (documentFileFromSingleUri != null) {
                    e(documentFileFromSingleUri, false, find, null);
                }
            } else if (k.f(iVar.a, ".txt", true) || k.f(iVar.a, ".epub", true)) {
                find.invoke(iVar);
            }
        }
        if (!isRoot || aVar == null) {
            return;
        }
        aVar.invoke();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(@org.jetbrains.annotations.NotNull java.io.File r18, boolean r19, @org.jetbrains.annotations.NotNull f.c0.b.l<? super e.a.a.h.i, f.v> r20, @org.jetbrains.annotations.Nullable f.c0.b.a<f.v> r21) {
        /*
            r17 = this;
            r0 = r20
            java.lang.String r1 = "file"
            r2 = r18
            f.c0.c.j.e(r2, r1)
            java.lang.String r1 = "find"
            f.c0.c.j.e(r0, r1)
            java.io.File[] r1 = r18.listFiles()
            if (r1 != 0) goto L18
        L14:
            r8 = r17
            goto L8a
        L18:
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L1b:
            if (r4 >= r2) goto L14
            r5 = r1[r4]
            boolean r6 = r5.isDirectory()
            java.lang.String r7 = "it"
            if (r6 == 0) goto L31
            f.c0.c.j.d(r5, r7)
            r6 = 0
            r8 = r17
            r8.f(r5, r3, r0, r6)
            goto L87
        L31:
            r8 = r17
            java.lang.String r6 = r5.getName()
            java.lang.String r9 = "it.name"
            f.c0.c.j.d(r6, r9)
            java.lang.String r10 = ".txt"
            r11 = 1
            boolean r6 = f.h0.k.f(r6, r10, r11)
            if (r6 != 0) goto L54
            java.lang.String r6 = r5.getName()
            f.c0.c.j.d(r6, r9)
            java.lang.String r10 = ".epub"
            boolean r6 = f.h0.k.f(r6, r10, r11)
            if (r6 == 0) goto L87
        L54:
            e.a.a.h.i r6 = new e.a.a.h.i
            java.lang.String r11 = r5.getName()
            f.c0.c.j.d(r11, r9)
            f.c0.c.j.d(r5, r7)
            java.lang.String r12 = f.b0.d.b(r5)
            long r13 = r5.length()
            java.util.Date r15 = new java.util.Date
            long r9 = r5.lastModified()
            r15.<init>(r9)
            java.lang.String r5 = r5.getAbsolutePath()
            android.net.Uri r5 = android.net.Uri.parse(r5)
            java.lang.String r7 = "parse(it.absolutePath)"
            f.c0.c.j.d(r5, r7)
            r10 = r6
            r16 = r5
            r10.<init>(r11, r12, r13, r15, r16)
            r0.invoke(r6)
        L87:
            int r4 = r4 + 1
            goto L1b
        L8a:
            if (r19 == 0) goto L92
            if (r21 != 0) goto L8f
            goto L92
        L8f:
            r21.invoke()
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.local.ImportBookViewModel.f(java.io.File, boolean, f.c0.b.l, f.c0.b.a):void");
    }
}
