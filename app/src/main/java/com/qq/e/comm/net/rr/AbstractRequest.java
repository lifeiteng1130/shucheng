package com.qq.e.comm.net.rr;

import android.net.Uri;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.HttpConnection;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractRequest implements Request {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2855e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Request.Method f2860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f2861k;
    private boolean a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f2856f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, String> f2857g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, String> f2858h = Collections.unmodifiableMap(this.f2856f);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, String> f2859i = Collections.unmodifiableMap(this.f2857g);

    public AbstractRequest(String str, Request.Method method, byte[] bArr) {
        this.f2855e = str;
        this.f2860j = method;
        if (bArr == null) {
            this.f2861k = null;
        } else {
            this.f2861k = (byte[]) bArr.clone();
        }
    }

    public AbstractRequest(String str, Map<String, String> map, Request.Method method) {
        this.f2855e = str;
        this.f2860j = method;
        if (Request.Method.POST == method) {
            StringBuilder sb = new StringBuilder();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String strEncode = URLEncoder.encode(entry.getKey(), "utf-8");
                    String strEncode2 = URLEncoder.encode(entry.getValue(), "utf-8");
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(strEncode);
                    sb.append("=");
                    sb.append(strEncode2);
                }
                if (sb.length() > 0) {
                    this.f2861k = sb.toString().getBytes("utf-8");
                    addHeader(HttpConnection.CONTENT_TYPE, HttpConnection.FORM_URL_ENCODED);
                }
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void addHeader(String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        this.f2856f.put(str, str2);
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void addQuery(String str, String str2) {
        this.f2857g.put(str, str2);
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getConnectionTimeOut() {
        return this.f2853c;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Map<String, String> getHeaders() {
        return this.f2858h;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Request.Method getMethod() {
        return this.f2860j;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public byte[] getPostData() {
        return this.f2861k;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getPriority() {
        return this.f2852b;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Map<String, String> getQuerys() {
        return this.f2859i;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getSocketTimeOut() {
        return this.f2854d;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public String getUrl() {
        return this.f2855e;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public String getUrlWithParas() {
        if (getQuerys().isEmpty()) {
            return getUrl();
        }
        Uri.Builder builderBuildUpon = Uri.parse(getUrl()).buildUpon();
        for (Map.Entry<String, String> entry : getQuerys().entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return builderBuildUpon.build().toString();
    }

    @Override // com.qq.e.comm.net.rr.Request
    public boolean isAutoClose() {
        return this.a;
    }

    public void setAutoClose(boolean z) {
        this.a = z;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void setConnectionTimeOut(int i2) {
        this.f2853c = i2;
    }

    public void setPriority(int i2) {
        this.f2852b = i2;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void setSocketTimeOut(int i2) {
        this.f2854d = i2;
    }
}
