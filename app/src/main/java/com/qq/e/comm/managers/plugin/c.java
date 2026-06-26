package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f2800d = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f2801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Executor f2802c;

    public class a implements NetworkCallBack {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2803b;

        public a(String str, int i2) {
            this.a = str;
            this.f2803b = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 3, insn: 0x005a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:35:0x005a */
        /* JADX WARN: Type inference failed for: r7v0, types: [com.qq.e.comm.net.rr.Response] */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v10, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r7v9, types: [java.io.InputStream] */
        private String a(Response response, File file) throws Throwable {
            Throwable e2;
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            MessageDigest messageDigest;
            OutputStream outputStream2 = null;
            try {
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                    response = response.getStreamContent();
                } catch (Throwable th) {
                    th = th;
                    outputStream2 = outputStream;
                }
            } catch (IOException e3) {
                e2 = e3;
                response = 0;
            } catch (NoSuchAlgorithmException e4) {
                e2 = e4;
                response = 0;
            } catch (Throwable th2) {
                th = th2;
                response = 0;
            }
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = response.read(bArr);
                        if (i2 <= 0) {
                            FileUtil.tryClose((InputStream) response);
                            FileUtil.tryClose(fileOutputStream);
                            String strByteArrayToHexString = Md5Util.byteArrayToHexString(messageDigest.digest());
                            FileUtil.tryClose((InputStream) response);
                            FileUtil.tryClose(fileOutputStream);
                            return strByteArrayToHexString;
                        }
                        messageDigest.update(bArr, 0, i2);
                        fileOutputStream.write(bArr, 0, i2);
                    }
                } catch (IOException e5) {
                    e2 = e5;
                    GDTLogger.e("更新插件出现异常", e2);
                    FileUtil.tryClose((InputStream) response);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                } catch (NoSuchAlgorithmException e6) {
                    e2 = e6;
                    GDTLogger.e("更新插件出现异常", e2);
                    FileUtil.tryClose((InputStream) response);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                }
            } catch (IOException e7) {
                e2 = e7;
                fileOutputStream = null;
                GDTLogger.e("更新插件出现异常", e2);
                FileUtil.tryClose((InputStream) response);
                FileUtil.tryClose(fileOutputStream);
                return null;
            } catch (NoSuchAlgorithmException e8) {
                e2 = e8;
                fileOutputStream = null;
                GDTLogger.e("更新插件出现异常", e2);
                FileUtil.tryClose((InputStream) response);
                FileUtil.tryClose(fileOutputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                FileUtil.tryClose((InputStream) response);
                FileUtil.tryClose(outputStream2);
                throw th;
            }
        }

        private void a(String str) {
            if (c.this.f2801b != null) {
                PM.this.a();
                com.qq.e.comm.managers.plugin.a.a(new Exception(str), str);
            }
        }

        @Override // com.qq.e.comm.net.NetworkCallBack
        public void onException(Exception exc) {
            GDTLogger.w("更新插件出现异常", exc);
            a(exc.getMessage());
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009c A[Catch: all -> 0x00d2, TryCatch #0 {all -> 0x00d2, blocks: (B:4:0x000e, B:6:0x0034, B:7:0x004c, B:11:0x0059, B:13:0x0069, B:20:0x0080, B:22:0x009c, B:9:0x0051, B:23:0x00aa), top: B:34:0x000e, inners: #1 }] */
        @Override // com.qq.e.comm.net.NetworkCallBack
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onResponse(com.qq.e.comm.net.rr.Request r8, com.qq.e.comm.net.rr.Response r9) {
            /*
                Method dump skipped, instruction units count: 325
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.c.a.onResponse(com.qq.e.comm.net.rr.Request, com.qq.e.comm.net.rr.Response):void");
        }
    }

    public c(Context context, Executor executor) {
        this.a = context.getApplicationContext();
        this.f2802c = executor;
    }

    public void a(f fVar) {
        this.f2801b = fVar;
    }

    public void a(String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        Matcher matcher = f2800d.matcher(str2);
        boolean z = true;
        int integer = StringUtil.parseInteger(matcher.matches() ? matcher.group(1) : "0", 0);
        if (integer < 1292) {
            GDTLogger.i("online plugin version is smaller than asset plugin version" + integer + "," + Constants.PLUGIN.ASSET_PLUGIN_VERSION + ".download give up");
            z = false;
        }
        if (z) {
            StringBuilder sbR = c.a.a.a.a.r("TIMESTAP_BEFORE_OWN_PLUGIN:");
            sbR.append(System.nanoTime());
            GDTLogger.d(sbR.toString());
            NetworkClientImpl.getInstance().submit(new PlainRequest(str2, Request.Method.GET, (byte[]) null), NetworkClient.Priority.High, new a(str, integer), this.f2802c);
        }
    }
}
