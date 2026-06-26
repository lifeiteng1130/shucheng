package io.legado.app.web;

import d.a.a.a;
import d.a.a.b;
import f.c0.c.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WebSocketServer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lio/legado/app/web/WebSocketServer;", "Ld/a/a/b;", "Ld/a/a/a$m;", "handshake", "Ld/a/a/b$c;", "openWebSocket", "(Ld/a/a/a$m;)Ld/a/a/b$c;", "", "port", "<init>", "(I)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class WebSocketServer extends b {
    public WebSocketServer(int i2) {
        super(i2);
    }

    @Override // d.a.a.b
    @Nullable
    public b.c openWebSocket(@NotNull a.m handshake) {
        j.e(handshake, "handshake");
        if (j.a(((a.l) handshake).f5467f, "/sourceDebug")) {
            return new SourceDebugWebSocket(handshake);
        }
        return null;
    }
}
