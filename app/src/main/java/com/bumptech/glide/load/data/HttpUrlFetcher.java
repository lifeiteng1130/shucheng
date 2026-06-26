package com.bumptech.glide.load.data;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import c.a.a.a.a;
import c.b.a.f;
import c.b.a.m.e;
import c.b.a.s.b;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {

    @VisibleForTesting
    public static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();

    @VisibleForTesting
    public static final int INVALID_STATUS_CODE = -1;
    private static final int MAXIMUM_REDIRECTS = 5;

    @VisibleForTesting
    public static final String REDIRECT_HEADER_FIELD = "Location";
    private static final String TAG = "HttpUrlFetcher";
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private final int timeout;
    private HttpURLConnection urlConnection;

    public static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection build(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    public interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL url);
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i2) {
        this(glideUrl, i2, DEFAULT_CONNECTION_FACTORY);
    }

    private HttpURLConnection buildAndConfigureConnection(URL url, Map<String, String> map) throws e {
        try {
            HttpURLConnection httpURLConnectionBuild = this.connectionFactory.build(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnectionBuild.addRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnectionBuild.setConnectTimeout(this.timeout);
            httpURLConnectionBuild.setReadTimeout(this.timeout);
            httpURLConnectionBuild.setUseCaches(false);
            httpURLConnectionBuild.setDoInput(true);
            httpURLConnectionBuild.setInstanceFollowRedirects(false);
            return httpURLConnectionBuild;
        } catch (IOException e2) {
            throw new e("URL.openConnection threw", 0, e2);
        }
    }

    private static int getHttpStatusCodeOrInvalid(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException unused) {
            Log.isLoggable(TAG, 3);
            return -1;
        }
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws e {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.stream = new b(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable(TAG, 3)) {
                    httpURLConnection.getContentEncoding();
                }
                this.stream = httpURLConnection.getInputStream();
            }
            return this.stream;
        } catch (IOException e2) {
            throw new e("Failed to obtain InputStream", getHttpStatusCodeOrInvalid(httpURLConnection), e2);
        }
    }

    private static boolean isHttpOk(int i2) {
        return i2 / 100 == 2;
    }

    private static boolean isHttpRedirect(int i2) {
        return i2 / 100 == 3;
    }

    private InputStream loadDataWithRedirects(URL url, int i2, URL url2, Map<String, String> map) throws e {
        if (i2 >= 5) {
            throw new e("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new e("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionBuildAndConfigureConnection = buildAndConfigureConnection(url, map);
        this.urlConnection = httpURLConnectionBuildAndConfigureConnection;
        try {
            httpURLConnectionBuildAndConfigureConnection.connect();
            this.stream = this.urlConnection.getInputStream();
            if (this.isCancelled) {
                return null;
            }
            int httpStatusCodeOrInvalid = getHttpStatusCodeOrInvalid(this.urlConnection);
            if (isHttpOk(httpStatusCodeOrInvalid)) {
                return getStreamForSuccessfulRequest(this.urlConnection);
            }
            if (!isHttpRedirect(httpStatusCodeOrInvalid)) {
                if (httpStatusCodeOrInvalid == -1) {
                    throw new e(httpStatusCodeOrInvalid);
                }
                try {
                    throw new e(this.urlConnection.getResponseMessage(), httpStatusCodeOrInvalid);
                } catch (IOException e2) {
                    throw new e("Failed to get a response message", httpStatusCodeOrInvalid, e2);
                }
            }
            String headerField = this.urlConnection.getHeaderField(REDIRECT_HEADER_FIELD);
            if (TextUtils.isEmpty(headerField)) {
                throw new e("Received empty or null redirect url", httpStatusCodeOrInvalid);
            }
            try {
                URL url3 = new URL(url, headerField);
                cleanup();
                return loadDataWithRedirects(url3, i2 + 1, url, map);
            } catch (MalformedURLException e3) {
                throw new e(a.i("Bad redirect url: ", headerField), httpStatusCodeOrInvalid, e3);
            }
        } catch (IOException e4) {
            throw new e("Failed to connect or obtain data", getHttpStatusCodeOrInvalid(this.urlConnection), e4);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.isCancelled = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.stream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.urlConnection = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public c.b.a.m.a getDataSource() {
        return c.b.a.m.a.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull f fVar, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        int i2 = c.b.a.s.e.f675b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            try {
                dataCallback.onDataReady(loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));
                if (!Log.isLoggable(TAG, 2)) {
                    return;
                }
            } catch (IOException e2) {
                Log.isLoggable(TAG, 3);
                dataCallback.onLoadFailed(e2);
                if (!Log.isLoggable(TAG, 2)) {
                    return;
                }
            }
            c.b.a.s.e.a(jElapsedRealtimeNanos);
        } catch (Throwable th) {
            if (Log.isLoggable(TAG, 2)) {
                c.b.a.s.e.a(jElapsedRealtimeNanos);
            }
            throw th;
        }
    }

    @VisibleForTesting
    public HttpUrlFetcher(GlideUrl glideUrl, int i2, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.glideUrl = glideUrl;
        this.timeout = i2;
        this.connectionFactory = httpUrlConnectionFactory;
    }
}
