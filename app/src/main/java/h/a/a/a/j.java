package h.a.a.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: LazyResource.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends p {
    private static final long serialVersionUID = 5089400472352002866L;
    private final String TAG;
    private final long cachedSize;
    private final k resourceProvider;

    public j(k kVar, String str) {
        this(kVar, -1L, str);
    }

    @Override // h.a.a.a.p
    public void close() {
        if (this.resourceProvider != null) {
            this.data = null;
        }
    }

    @Override // h.a.a.a.p
    public byte[] getData() throws IOException {
        byte[] byteArray;
        if (this.data == null) {
            getHref();
            InputStream inputStreamA = this.resourceProvider.a(this.originalHref);
            int i2 = (int) this.cachedSize;
            try {
                ByteArrayOutputStream byteArrayOutputStream = i2 > 0 ? new ByteArrayOutputStream(i2) : new ByteArrayOutputStream();
                h.a.a.c.a.a(inputStreamA, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (OutOfMemoryError unused) {
                byteArray = null;
            }
            if (byteArray == null) {
                StringBuilder sbR = c.a.a.a.a.r("Could not load the contents of resource: ");
                sbR.append(getHref());
                throw new IOException(sbR.toString());
            }
            this.data = byteArray;
            inputStreamA.close();
        }
        return this.data;
    }

    @Override // h.a.a.a.p
    public InputStream getInputStream() {
        return isInitialized() ? new ByteArrayInputStream(getData()) : this.resourceProvider.a(this.originalHref);
    }

    @Override // h.a.a.a.p
    public long getSize() {
        return this.data != null ? r0.length : this.cachedSize;
    }

    public void initialize() throws IOException {
        getData();
    }

    public boolean isInitialized() {
        return this.data != null;
    }

    public j(k kVar, long j2, String str) {
        super(null, null, str, m.a(str));
        this.TAG = j.class.getName();
        this.resourceProvider = kVar;
        this.cachedSize = j2;
    }
}
