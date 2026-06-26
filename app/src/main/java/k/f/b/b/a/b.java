package k.f.b.b.a;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: IdentifierIdClient.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends Handler {
    public b(Looper looper) {
        super(looper);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handleMessage(android.os.Message r10) {
        /*
            r9 = this;
            int r0 = r10.what
            r1 = 11
            if (r0 != r1) goto L9c
            android.os.Bundle r0 = r10.getData()
            java.lang.String r1 = "type"
            int r0 = r0.getInt(r1)
            android.os.Bundle r10 = r10.getData()
            java.lang.String r1 = "appid"
            java.lang.String r10 = r10.getString(r1)
            k.f.b.b.a.a r1 = k.f.b.b.a.c.f8935j
            java.util.Objects.requireNonNull(r1)
            r2 = 0
            if (r0 == 0) goto L60
            r3 = 1
            if (r0 == r3) goto L4a
            r3 = 2
            if (r0 == r3) goto L34
            r10 = 4
            if (r0 == r10) goto L2d
            r4 = r2
            goto L67
        L2d:
            java.lang.String r10 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS"
            android.net.Uri r10 = android.net.Uri.parse(r10)
            goto L66
        L34:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r0.append(r3)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            android.net.Uri r10 = android.net.Uri.parse(r10)
            goto L66
        L4a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r0.append(r3)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            android.net.Uri r10 = android.net.Uri.parse(r10)
            goto L66
        L60:
            java.lang.String r10 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r10 = android.net.Uri.parse(r10)
        L66:
            r4 = r10
        L67:
            android.content.Context r10 = r1.a
            android.content.ContentResolver r3 = r10.getContentResolver()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)
            if (r10 == 0) goto L8b
            boolean r0 = r10.moveToNext()
            if (r0 == 0) goto L88
            java.lang.String r0 = "value"
            int r0 = r10.getColumnIndex(r0)
            java.lang.String r0 = r10.getString(r0)
            r2 = r0
        L88:
            r10.close()
        L8b:
            k.f.b.b.a.c.f8932g = r2
            android.content.Context r10 = k.f.b.b.a.c.a
            java.lang.Object r10 = k.f.b.b.a.c.f8929d
            monitor-enter(r10)
            java.lang.Object r0 = k.f.b.b.a.c.f8929d     // Catch: java.lang.Throwable -> L99
            r0.notify()     // Catch: java.lang.Throwable -> L99
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L99
            goto L9c
        L99:
            r0 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L99
            throw r0
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k.f.b.b.a.b.handleMessage(android.os.Message):void");
    }
}
