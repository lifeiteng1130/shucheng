package com.qq.e.comm.net.rr;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public interface Response {
    public static final int HTTP_NO_CONTENT = 204;
    public static final int HTTP_OK = 200;
    public static final int HTTP_UNKNOWN = 0;

    void close();

    byte[] getBytesContent();

    int getStatusCode();

    InputStream getStreamContent();

    String getStringContent();

    String getStringContent(String str);
}
