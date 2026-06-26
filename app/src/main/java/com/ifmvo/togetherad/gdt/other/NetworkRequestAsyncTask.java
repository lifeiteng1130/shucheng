package com.ifmvo.togetherad.gdt.other;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class NetworkRequestAsyncTask extends AsyncTask<String, Void, String> {
    public static final int CONNECTION_TIMEOUT = 15000;
    public static final int READ_TIMEOUT = 15000;
    public static final String REQUEST_METHOD = "GET";
    public static final String TAG = "NetworkRequestAsyncTask";

    @Override // android.os.AsyncTask
    public String doInBackground(String... strArr) {
        String str = strArr[0];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod(REQUEST_METHOD);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.connect();
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
                sb.append(line);
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
