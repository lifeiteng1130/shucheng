package io.legado.app.web.utils;

import android.content.res.AssetManager;
import android.text.TextUtils;
import d.a.a.a;
import f.c0.c.j;
import f.h0.g;
import f.h0.k;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AssetsWeb.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lio/legado/app/web/utils/AssetsWeb;", "", "", "path", "getMimeType", "(Ljava/lang/String;)Ljava/lang/String;", "Ld/a/a/a$o;", "getResponse", "(Ljava/lang/String;)Ld/a/a/a$o;", "Landroid/content/res/AssetManager;", "assetManager", "Landroid/content/res/AssetManager;", "rootPath", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AssetsWeb {

    @NotNull
    private final AssetManager assetManager;

    @NotNull
    private String rootPath;

    public AssetsWeb(@NotNull String str) {
        j.e(str, "rootPath");
        AssetManager assets = h.g().getAssets();
        j.d(assets, "appCtx.assets");
        this.assetManager = assets;
        this.rootPath = "web";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.rootPath = str;
    }

    private final String getMimeType(String path) {
        int iU = k.u(path, ".", 0, false, 6);
        Objects.requireNonNull(path, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = path.substring(iU);
        j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return (k.i(strSubstring, ".html", true) || k.i(strSubstring, ".htm", true)) ? a.MIME_HTML : k.i(strSubstring, ".js", true) ? "text/javascript" : k.i(strSubstring, ".css", true) ? "text/css" : k.i(strSubstring, ".ico", true) ? "image/x-icon" : a.MIME_HTML;
    }

    @NotNull
    public final a.o getResponse(@NotNull String path) throws IOException {
        j.e(path, "path");
        String strK = j.k(this.rootPath, path);
        g gVar = new g("/+");
        String str = File.separator;
        j.d(str, "separator");
        String strReplace = gVar.replace(strK, str);
        InputStream inputStreamOpen = this.assetManager.open(strReplace);
        j.d(inputStreamOpen, "assetManager.open(path1)");
        a.o oVarNewChunkedResponse = a.newChunkedResponse(a.o.d.OK, getMimeType(strReplace), inputStreamOpen);
        j.d(oVarNewChunkedResponse, "newChunkedResponse(\n            NanoHTTPD.Response.Status.OK,\n            getMimeType(path1),\n            inputStream\n        )");
        return oVarNewChunkedResponse;
    }
}
