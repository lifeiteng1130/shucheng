package com.qq.e.comm.net;

import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;

/* JADX INFO: loaded from: classes.dex */
public interface NetworkCallBack {
    void onException(Exception exc);

    void onResponse(Request request, Response response);
}
