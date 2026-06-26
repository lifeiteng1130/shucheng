package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.j;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class GlideUrl implements j {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%;$";

    @Nullable
    private volatile byte[] cacheKeyBytes;
    private int hashCode;
    private final Headers headers;

    @Nullable
    private String safeStringUrl;

    @Nullable
    private URL safeUrl;

    @Nullable
    private final String stringUrl;

    @Nullable
    private final URL url;

    public GlideUrl(URL url) {
        this(url, Headers.DEFAULT);
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes == null) {
            this.cacheKeyBytes = getCacheKey().getBytes(j.a);
        }
        return this.cacheKeyBytes;
    }

    private String getSafeStringUrl() {
        if (TextUtils.isEmpty(this.safeStringUrl)) {
            String string = this.stringUrl;
            if (TextUtils.isEmpty(string)) {
                URL url = this.url;
                Objects.requireNonNull(url, "Argument must not be null");
                string = url.toString();
            }
            this.safeStringUrl = Uri.encode(string, ALLOWED_URI_CHARS);
        }
        return this.safeStringUrl;
    }

    private URL getSafeUrl() {
        if (this.safeUrl == null) {
            this.safeUrl = new URL(getSafeStringUrl());
        }
        return this.safeUrl;
    }

    @Override // c.b.a.m.j
    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        return getCacheKey().equals(glideUrl.getCacheKey()) && this.headers.equals(glideUrl.headers);
    }

    public String getCacheKey() {
        String str = this.stringUrl;
        if (str != null) {
            return str;
        }
        URL url = this.url;
        Objects.requireNonNull(url, "Argument must not be null");
        return url.toString();
    }

    public Map<String, String> getHeaders() {
        return this.headers.getHeaders();
    }

    @Override // c.b.a.m.j
    public int hashCode() {
        if (this.hashCode == 0) {
            int iHashCode = getCacheKey().hashCode();
            this.hashCode = iHashCode;
            this.hashCode = this.headers.hashCode() + (iHashCode * 31);
        }
        return this.hashCode;
    }

    public String toString() {
        return getCacheKey();
    }

    public String toStringUrl() {
        return getSafeStringUrl();
    }

    public URL toURL() {
        return getSafeUrl();
    }

    @Override // c.b.a.m.j
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(getCacheKeyBytes());
    }

    public GlideUrl(String str) {
        this(str, Headers.DEFAULT);
    }

    public GlideUrl(URL url, Headers headers) {
        Objects.requireNonNull(url, "Argument must not be null");
        this.url = url;
        this.stringUrl = null;
        Objects.requireNonNull(headers, "Argument must not be null");
        this.headers = headers;
    }

    public GlideUrl(String str, Headers headers) {
        this.url = null;
        if (!TextUtils.isEmpty(str)) {
            this.stringUrl = str;
            Objects.requireNonNull(headers, "Argument must not be null");
            this.headers = headers;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
