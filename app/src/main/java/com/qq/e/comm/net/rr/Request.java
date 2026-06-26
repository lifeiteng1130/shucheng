package com.qq.e.comm.net.rr;

import java.net.HttpURLConnection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface Request {

    public enum Method {
        GET,
        POST
    }

    void addHeader(String str, String str2);

    void addQuery(String str, String str2);

    int getConnectionTimeOut();

    Map<String, String> getHeaders();

    Method getMethod();

    byte[] getPostData();

    int getPriority();

    Map<String, String> getQuerys();

    int getSocketTimeOut();

    String getUrl();

    String getUrlWithParas();

    Response initResponse(HttpURLConnection httpURLConnection);

    boolean isAutoClose();

    void setConnectionTimeOut(int i2);

    void setSocketTimeOut(int i2);
}
