package com.qq.e.comm.net.rr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import org.jsoup.helper.DataUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractResponse implements Response {
    private final HttpURLConnection a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2862b;

    public AbstractResponse(HttpURLConnection httpURLConnection) {
        this.f2862b = 0;
        if (httpURLConnection == null) {
            throw new AssertionError("AbstractResponse parameter is null");
        }
        this.a = httpURLConnection;
        try {
            this.f2862b = httpURLConnection.getResponseCode();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.qq.e.comm.net.rr.Response
    public void close() {
        this.a.disconnect();
    }

    @Override // com.qq.e.comm.net.rr.Response
    public byte[] getBytesContent() throws IOException {
        if (200 != getStatusCode()) {
            return null;
        }
        InputStream streamContent = getStreamContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = streamContent.read(bArr);
            if (i2 <= 0) {
                streamContent.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    @Override // com.qq.e.comm.net.rr.Response
    public int getStatusCode() {
        return this.f2862b;
    }

    @Override // com.qq.e.comm.net.rr.Response
    public InputStream getStreamContent() {
        return this.a.getInputStream();
    }

    @Override // com.qq.e.comm.net.rr.Response
    public String getStringContent() {
        return getStringContent(DataUtil.defaultCharset);
    }

    @Override // com.qq.e.comm.net.rr.Response
    public String getStringContent(String str) throws IOException {
        byte[] bytesContent = getBytesContent();
        String contentEncoding = null;
        if (bytesContent == null) {
            return null;
        }
        if (bytesContent.length == 0) {
            return "";
        }
        try {
            contentEncoding = this.a.getContentEncoding();
        } catch (Throwable unused) {
        }
        if (contentEncoding != null) {
            str = contentEncoding;
        }
        return new String(bytesContent, str);
    }
}
