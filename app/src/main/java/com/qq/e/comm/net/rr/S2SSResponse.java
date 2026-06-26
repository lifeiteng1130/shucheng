package com.qq.e.comm.net.rr;

import com.qq.e.comm.net.rr.a;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class S2SSResponse extends AbstractResponse {
    public S2SSResponse(HttpURLConnection httpURLConnection) {
        super(httpURLConnection);
    }

    @Override // com.qq.e.comm.net.rr.AbstractResponse, com.qq.e.comm.net.rr.Response
    public byte[] getBytesContent() {
        try {
            return a.d(super.getBytesContent());
        } catch (a.b e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
