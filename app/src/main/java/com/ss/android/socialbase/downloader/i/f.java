package com.ss.android.socialbase.downloader.i;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media.AudioAttributesCompat;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.l;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import h.a.a.a.w;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.ws.WebSocketProtocol;
import org.json.JSONObject;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: DownloadUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final String a = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f3724b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f3725c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile SparseArray<Boolean> f3726d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile SparseArray<List<ai>> f3727e = new SparseArray<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char[] f3728f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Pattern f3729g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Pattern f3730h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static ConnectivityManager f3731i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Boolean f3732j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Boolean f3733k;

    public static double a(long j2) {
        return j2 / 1048576.0d;
    }

    public static String a(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        return a(bArr, 0, bArr.length);
    }

    public static boolean a(int i2) {
        return i2 == 0 || i2 == 2;
    }

    public static long b(com.ss.android.socialbase.downloader.network.g gVar) {
        if (gVar == null) {
            return -1L;
        }
        String strB = b(gVar, "Content-Range");
        if (TextUtils.isEmpty(strB)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(strB);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e2) {
            com.ss.android.socialbase.downloader.c.a.d(a, "parse content-length from content-range failed " + e2);
        }
        return -1L;
    }

    public static boolean b(long j2) {
        return j2 == -1;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static boolean c(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 0;
    }

    public static boolean d(int i2) {
        return i2 == 206 || i2 == 200;
    }

    public static boolean d(DownloadInfo downloadInfo) {
        boolean z = false;
        if (downloadInfo.isDeleteCacheIfCheckFailed() || !TextUtils.isEmpty(downloadInfo.getLastModified())) {
            String str = a;
            StringBuilder sbR = c.a.a.a.a.r("dcache::curt=");
            sbR.append(System.currentTimeMillis());
            sbR.append(" expired=");
            sbR.append(downloadInfo.getCacheExpiredTime());
            com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        } else {
            com.ss.android.socialbase.downloader.c.a.b(a, "dcache::last modify is emtpy, so just return cache");
        }
        String str2 = a;
        StringBuilder sbR2 = c.a.a.a.a.r("cacheExpired::dcache::name=");
        sbR2.append(downloadInfo.getName());
        sbR2.append(" expired=");
        sbR2.append(z);
        com.ss.android.socialbase.downloader.c.a.b(str2, sbR2.toString());
        return z;
    }

    public static String e(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes(DataUtil.defaultCharset));
                    return a(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String strD = d(com.ss.android.socialbase.downloader.downloader.c.N());
        return strD != null && strD.equals(str);
    }

    public static String g(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static boolean h(Throwable th) {
        if (th == null) {
            return false;
        }
        if (!(th instanceof BaseException)) {
            if (!(th instanceof IOException)) {
                return false;
            }
            String strJ = j(th);
            return !TextUtils.isEmpty(strJ) && strJ.contains("ENOSPC");
        }
        BaseException baseException = (BaseException) th;
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1006) {
            return true;
        }
        if (!(errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064)) {
            return false;
        }
        String message = baseException.getMessage();
        return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
    }

    private static String i() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i2 = bufferedReader.read();
                if (i2 <= 0) {
                    break;
                }
                sb.append((char) i2);
            }
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b("Process", "get processName = " + sb.toString());
            }
            String string = sb.toString();
            a(bufferedReader);
            return string;
        } catch (Throwable unused2) {
            a(bufferedReader);
            return null;
        }
    }

    private static String j(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (f3729g == null) {
                f3729g = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = f3729g.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (f3730h == null) {
            f3730h = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = f3730h.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    private static boolean k(String str) {
        StringBuilder sbR = c.a.a.a.a.r("deleteDirIfEmpty on thread: ");
        sbR.append(Thread.currentThread());
        sbR.toString();
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            return file.isDirectory() && file.delete();
        }
        return false;
    }

    public static String a(byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr, "bytes is null");
        if (i2 >= 0 && i2 + i3 <= bArr.length) {
            int i4 = i3 * 2;
            char[] cArr = new char[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = bArr[i6 + i2] & ExifInterface.MARKER;
                int i8 = i5 + 1;
                char[] cArr2 = f3728f;
                cArr[i5] = cArr2[i7 >> 4];
                i5 = i8 + 1;
                cArr[i8] = cArr2[i7 & 15];
            }
            return new String(cArr, 0, i4);
        }
        throw new IndexOutOfBoundsException();
    }

    public static void c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean f(Throwable th) {
        if (th == null) {
            return false;
        }
        String strJ = j(th);
        return !TextUtils.isEmpty(strJ) && strJ.contains("Requested Range Not Satisfiable");
    }

    public static long d(String str) throws BaseException {
        try {
            return new StatFs(str).getAvailableBytes();
        } catch (IllegalArgumentException e2) {
            throw new BaseException(1050, e2);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    public static boolean e(Throwable th) {
        if (th == null) {
            return false;
        }
        String strJ = j(th);
        return !TextUtils.isEmpty(strJ) && strJ.contains("Precondition Failed");
    }

    public static long f(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<com.ss.android.socialbase.downloader.model.b> listC = com.ss.android.socialbase.downloader.downloader.c.x().c(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = chunkCount > 1;
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0L;
        }
        if (z) {
            if (listC == null || chunkCount != listC.size()) {
                return 0L;
            }
            return b(listC);
        }
        return downloadInfo.getCurBytes();
    }

    public static boolean c(DownloadInfo downloadInfo) {
        return a(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static boolean g(Throwable th) {
        return com.ss.android.socialbase.downloader.downloader.c.M().a(th);
    }

    public static boolean c(String str, String str2, String str3) {
        return a(b(str, str2, str3));
    }

    public static com.ss.android.socialbase.downloader.constants.f e(int i2) {
        com.ss.android.socialbase.downloader.constants.f fVar = com.ss.android.socialbase.downloader.constants.f.MAIN;
        com.ss.android.socialbase.downloader.constants.f fVar2 = com.ss.android.socialbase.downloader.constants.f.SUB;
        if (i2 != fVar2.ordinal()) {
            fVar2 = com.ss.android.socialbase.downloader.constants.f.NOTIFICATION;
            if (i2 != fVar2.ordinal()) {
                return fVar;
            }
        }
        return fVar2;
    }

    public static File g() {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception unused) {
            externalStorageState = "";
        }
        if ("mounted".equals(externalStorageState)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static long b(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split(w.DEFAULT_PATH_SEPARATOR);
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                com.ss.android.socialbase.downloader.c.a.d(a, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    public static boolean h(String str) {
        Context contextN;
        if (com.ss.android.socialbase.downloader.g.a.c().b("save_path_security") > 0 && (contextN = com.ss.android.socialbase.downloader.downloader.c.N()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            StringBuilder sbR = c.a.a.a.a.r("Android/data/");
            sbR.append(contextN.getPackageName());
            if (!str.contains(sbR.toString())) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(com.ss.android.socialbase.downloader.network.g gVar) {
        if (gVar == null) {
            return false;
        }
        return a.a(8) ? "chunked".equals(gVar.a("Transfer-Encoding")) || a(gVar) == -1 : a(gVar) == -1;
    }

    public static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static boolean i(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            try {
                bArr[i2] = (byte) (Integer.parseInt(str.substring(i3, i3 + 2), 16) & 255);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static long e(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<com.ss.android.socialbase.downloader.model.b> listC = com.ss.android.socialbase.downloader.downloader.c.x().c(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (listC == null || listC.size() <= 1) {
            return 0L;
        }
        long jD = d(listC);
        if (jD >= 0) {
            return jD;
        }
        return 0L;
    }

    public static String j(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "throwable getMsg error";
        }
    }

    public static String f() {
        return a(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getGlobalSaveTempDir(), false);
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerA = a(context);
            if (connectivityManagerA == null || (activeNetworkInfo = connectivityManagerA.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String d(Context context) {
        String str = f3725c;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (com.ss.android.socialbase.downloader.c.a.a()) {
                            com.ss.android.socialbase.downloader.c.a.b("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        String str2 = runningAppProcessInfo.processName;
                        f3725c = str2;
                        return str2;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String strI = i();
        f3725c = strI;
        return strI;
    }

    public static long i(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
        if (!matcher.find()) {
            return 0L;
        }
        try {
            return Long.parseLong(matcher.group(1));
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static boolean h() {
        Context contextN = com.ss.android.socialbase.downloader.downloader.c.N();
        return (contextN == null || b(contextN) || !c(contextN)) ? false : true;
    }

    public static long b(List<com.ss.android.socialbase.downloader.model.b> list) {
        Iterator<com.ss.android.socialbase.downloader.model.b> it = list.iterator();
        long jO = 0;
        while (it.hasNext()) {
            jO += it.next().o();
        }
        return jO;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c() {
        /*
            java.lang.Boolean r0 = com.ss.android.socialbase.downloader.i.f.f3733k
            if (r0 == 0) goto L9
            boolean r0 = r0.booleanValue()
            return r0
        L9:
            android.content.Context r0 = com.ss.android.socialbase.downloader.downloader.c.N()
            java.lang.String r0 = d(r0)
            if (r0 == 0) goto L37
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = com.ss.android.socialbase.downloader.downloader.c.N()
            java.lang.String r2 = r2.getPackageName()
            r1.append(r2)
            java.lang.String r2 = ":downloader"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            com.ss.android.socialbase.downloader.i.f.f3733k = r0
            goto L3b
        L37:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            com.ss.android.socialbase.downloader.i.f.f3733k = r0
        L3b:
            java.lang.Boolean r0 = com.ss.android.socialbase.downloader.i.f.f3733k
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.i.f.c():boolean");
    }

    public static String e() {
        return a(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getGlobalSaveDir(), true);
    }

    public static void b(DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.g.a aVarA;
        JSONObject jSONObjectD;
        if (downloadInfo == null || (jSONObjectD = (aVarA = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId())).d("download_dir")) == null) {
            return;
        }
        String strOptString = jSONObjectD.optString("ins_desc");
        if (!TextUtils.isEmpty(strOptString)) {
            c(downloadInfo.getSavePath(), strOptString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String strA = a(title, aVarA);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(strA);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            k(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static long a(com.ss.android.socialbase.downloader.network.g gVar) {
        if (gVar == null) {
            return -1L;
        }
        String strB = b(gVar, "Content-Length");
        if (TextUtils.isEmpty(strB) && a.a(1)) {
            return b(gVar);
        }
        try {
            return Long.parseLong(strB);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strE = e(str2);
        return (TextUtils.isEmpty(strE) || str.contains(strE)) ? str : new File(str, strE).getAbsolutePath();
    }

    public static String a(com.ss.android.socialbase.downloader.network.g gVar, String str) {
        String strJ = j(gVar.a("Content-Disposition"));
        return TextUtils.isEmpty(strJ) ? e(str) : strJ;
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        String strJ = j(th);
        return !TextUtils.isEmpty(strJ) && strJ.contains("network not available");
    }

    public static boolean d() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean c(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        return baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException));
    }

    public static boolean d(Throwable th) {
        if (th == null) {
            return false;
        }
        String strJ = j(th);
        return !TextUtils.isEmpty(strJ) && strJ.contains("Exception in connect");
    }

    public static com.ss.android.socialbase.downloader.model.e a(DownloadInfo downloadInfo, String str, String str2, int i2) throws BaseException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            boolean zMkdirs = false;
            if (file.exists() && file.isDirectory()) {
                throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
            }
            if (!file.exists()) {
                try {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (!file2.exists()) {
                            if (!file2.mkdirs() && !file2.exists()) {
                                if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo).a("opt_mkdir_failed", 0) != 1) {
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                                int i3 = 0;
                                while (!zMkdirs) {
                                    int i4 = i3 + 1;
                                    if (i3 >= 3) {
                                        break;
                                    }
                                    try {
                                        Thread.sleep(10L);
                                        zMkdirs = file2.mkdirs();
                                        i3 = i4;
                                    } catch (InterruptedException unused) {
                                    }
                                }
                                if (!zMkdirs) {
                                    if (d(downloadInfo.getSavePath()) < 16384) {
                                        throw new BaseException(PointerIconCompat.TYPE_CELL, "download savePath directory can not created:" + str);
                                    }
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                            }
                        } else {
                            file2.delete();
                            if (!file2.mkdirs() && !file2.exists()) {
                                throw new BaseException(1031, "download savePath is not directory:path=" + str);
                            }
                            throw new BaseException(1031, "download savePath is not directory:" + str);
                        }
                    }
                    file.createNewFile();
                } catch (IOException e2) {
                    throw new BaseException(1036, e2);
                }
            }
            return new com.ss.android.socialbase.downloader.model.e(file, i2);
        }
        throw new BaseException(PointerIconCompat.TYPE_GRABBING, new IOException("path must be not empty"));
    }

    private static void c(Throwable th, String str) throws com.ss.android.socialbase.downloader.exception.g {
        com.ss.android.socialbase.downloader.exception.g gVarA = com.ss.android.socialbase.downloader.downloader.c.M().a(th, null);
        if (gVarA == null) {
            gVarA = com.ss.android.socialbase.downloader.downloader.c.M().a(th.getCause(), null);
        }
        if (gVarA == null) {
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.g(gVarA.getErrorCode(), b(gVarA, str)).a(gVarA.a());
    }

    private static long d(List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long jN = -1;
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null && (bVar.n() <= bVar.p() || bVar.p() == 0)) {
                if (jN == -1 || jN > bVar.n()) {
                    jN = bVar.n();
                }
            }
        }
        return jN;
    }

    public static long c(long j2) {
        return System.currentTimeMillis() - j2;
    }

    public static boolean c(List<com.ss.android.socialbase.downloader.model.c> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.c cVar : list) {
            if (cVar != null && !TextUtils.isEmpty(cVar.a()) && !TextUtils.isEmpty(cVar.b()) && "download-tc21-1-15".equals(cVar.a()) && "download-tc21-1-15".equals(cVar.b())) {
                return true;
            }
        }
        return false;
    }

    public static int b(String str, String str2, String str3) {
        return com.ss.android.a.c.a(str3, new File(str, str2));
    }

    public static String b(int i2) {
        String strD = c.a.a.a.a.d("ttmd5 check code = ", i2, ", ");
        if (i2 != 99) {
            switch (i2) {
                case 0:
                    return c.a.a.a.a.i(strD, "md5 match");
                case 1:
                    return c.a.a.a.a.i(strD, "md5 not match");
                case 2:
                    return c.a.a.a.a.i(strD, "md5 empty");
                case 3:
                    return c.a.a.a.a.i(strD, "ttmd5 version not support");
                case 4:
                    return c.a.a.a.a.i(strD, "ttmd5 tag parser error");
                case 5:
                    return c.a.a.a.a.i(strD, "file not exist");
                case 6:
                    return c.a.a.a.a.i(strD, "get file md5 error");
                default:
                    return strD;
            }
        }
        return c.a.a.a.a.i(strD, "unknown error");
    }

    @TargetApi(19)
    private static void b(File file, File file2, boolean z) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j2 = 0;
                        while (j2 < size) {
                            long j3 = size - j2;
                            long jTransferFrom = channel2.transferFrom(channel, j2, j3 > 31457280 ? 31457280L : j3);
                            if (jTransferFrom == 0) {
                                break;
                            } else {
                                j2 += jTransferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        channel.close();
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static List<com.ss.android.socialbase.downloader.model.b> a(List<com.ss.android.socialbase.downloader.model.b> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                if (bVar.d()) {
                    sparseArray.put(bVar.s(), bVar);
                    List<com.ss.android.socialbase.downloader.model.b> list2 = (List) sparseArray2.get(bVar.s());
                    if (list2 != null) {
                        Iterator<com.ss.android.socialbase.downloader.model.b> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().a(bVar);
                        }
                        bVar.a(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.model.b bVar2 = (com.ss.android.socialbase.downloader.model.b) sparseArray.get(bVar.b());
                    if (bVar2 != null) {
                        List<com.ss.android.socialbase.downloader.model.b> listG = bVar2.g();
                        if (listG == null) {
                            listG = new ArrayList<>();
                            bVar2.a(listG);
                        }
                        bVar.a(bVar2);
                        listG.add(bVar);
                    } else {
                        List arrayList = (List) sparseArray2.get(bVar.b());
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            sparseArray2.put(bVar.b(), arrayList);
                        }
                        arrayList.add(bVar);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList2.add(sparseArray.get(sparseArray.keyAt(i2)));
        }
        return arrayList2.isEmpty() ? list : arrayList2;
    }

    public static boolean b(File file, File file2) {
        file.getPath();
        file2.getPath();
        boolean zRenameTo = file.renameTo(file2);
        if (!zRenameTo) {
            zRenameTo = a(file, file2);
            try {
                file.getPath();
                file2.getPath();
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return zRenameTo;
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerA = a(context);
            if (connectivityManagerA != null && (activeNetworkInfo = connectivityManagerA.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                return 1 == activeNetworkInfo.getType();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String a(String str, String str2, String str3) {
        String strA;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            strA = a(str2, str3);
        } else {
            strA = a(str, str3);
        }
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return String.format("%s.tp", strA);
    }

    public static boolean b() {
        return !c() && com.ss.android.socialbase.downloader.downloader.c.c() && l.a(true).g();
    }

    public static boolean b(Throwable th) {
        if (th == null) {
            return false;
        }
        String strJ = j(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.exception.b) || (((com.ss.android.socialbase.downloader.exception.b) th).a() != 403 && (TextUtils.isEmpty(strJ) || !strJ.contains("403")))) {
            return !TextUtils.isEmpty(strJ) && strJ.contains("Forbidden");
        }
        return true;
    }

    public static void a(DownloadInfo downloadInfo) {
        a(downloadInfo, true);
    }

    public static void a(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                c(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        c(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            b(downloadInfo);
        }
        if (z) {
            String strE = e(downloadInfo.getUrl());
            if (TextUtils.isEmpty(strE) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(strE)) {
                return;
            }
            k(downloadInfo.getSavePath());
        }
    }

    public static boolean b(BaseException baseException) {
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.b) {
            com.ss.android.socialbase.downloader.exception.b bVar = (com.ss.android.socialbase.downloader.exception.b) baseException;
            if (bVar.a() == 412 || bVar.a() == 416) {
                return true;
            }
        }
        return false;
    }

    public static String b(Throwable th, String str) {
        if (str == null) {
            return j(th);
        }
        StringBuilder sbT = c.a.a.a.a.t(str, "-");
        sbT.append(j(th));
        return sbT.toString();
    }

    public static void b(List<com.ss.android.socialbase.downloader.model.c> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new com.ss.android.socialbase.downloader.model.c("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static String b(com.ss.android.socialbase.downloader.network.g gVar, String str) {
        if (gVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String strA = gVar.a(str);
        if (!com.ss.android.socialbase.downloader.g.a.c().b("fix_get_http_resp_head_ignore_case", true)) {
            return strA;
        }
        if (TextUtils.isEmpty(strA)) {
            strA = gVar.a(str.toLowerCase());
        }
        return TextUtils.isEmpty(strA) ? gVar.a(str.toUpperCase()) : strA;
    }

    public static boolean a(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean a(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                    if (c(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean b(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && c(com.ss.android.socialbase.downloader.downloader.c.N());
    }

    public static int a(File file, String str) {
        return com.ss.android.a.c.a(str, file);
    }

    public static void a(DownloadInfo downloadInfo, x xVar, ai aiVar) {
        boolean z;
        BaseException baseException;
        boolean z2;
        String str = a;
        StringBuilder sbR = c.a.a.a.a.r("saveFileAsTargetName targetName is ");
        sbR.append(downloadInfo.getTargetFilePath());
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
        try {
            synchronized (f3726d) {
                Boolean bool = f3726d.get(downloadInfo.getId());
                Boolean bool2 = Boolean.TRUE;
                if (bool == bool2) {
                    com.ss.android.socialbase.downloader.c.a.b(str, "has another same task is saving temp file");
                    if (aiVar != null) {
                        List<ai> arrayList = f3727e.get(downloadInfo.getId());
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            f3727e.put(downloadInfo.getId(), arrayList);
                        }
                        arrayList.add(aiVar);
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.c.a.b(str, "saveTempFileStatusMap put id:" + downloadInfo.getId());
                f3726d.put(downloadInfo.getId(), bool2);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                boolean zH = h(downloadInfo.getSavePath());
                if (file2.exists()) {
                    com.ss.android.socialbase.downloader.c.a.b(str, "targetFile exist");
                    int iA = a(file2, downloadInfo.getMd5());
                    if (a(iA)) {
                        com.ss.android.socialbase.downloader.c.a.b(str, "tempFile not exist , targetFile exists and md5 check valid");
                        downloadInfo.setTTMd5CheckStatus(iA);
                        if (aiVar != null) {
                            aiVar.a();
                        }
                        a(downloadInfo.getId(), true, (BaseException) null);
                    } else {
                        if (file.exists()) {
                            z = true;
                        } else {
                            BaseException baseException2 = new BaseException(WebSocketProtocol.CLOSE_NO_STATUS_CODE, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), b(iA)));
                            if (aiVar != null) {
                                aiVar.a(baseException2);
                            }
                            a(downloadInfo.getId(), false, baseException2);
                            z = false;
                        }
                        if (zH && !file2.delete()) {
                            if (z) {
                                BaseException baseException3 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + b(iA));
                                if (aiVar != null) {
                                    aiVar.a(baseException3);
                                }
                                a(downloadInfo.getId(), false, baseException3);
                            } else if (xVar != null) {
                                com.ss.android.socialbase.downloader.d.a.a(xVar, downloadInfo, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                            }
                        }
                    }
                    z = false;
                } else if (file.exists()) {
                    z = true;
                } else {
                    BaseException baseException4 = new BaseException(WebSocketProtocol.CLOSE_NO_STATUS_CODE, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                    if (aiVar != null) {
                        aiVar.a(baseException4);
                    }
                    a(downloadInfo.getId(), false, baseException4);
                    z = false;
                }
                if (z) {
                    try {
                        int iA2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_finish_check_ttmd5", 2);
                        if (iA2 > 0) {
                            int iA3 = a(file, downloadInfo.getMd5());
                            downloadInfo.setTTMd5CheckStatus(iA3);
                            if (iA2 >= 2 && !a(iA3)) {
                                BaseException baseException5 = new BaseException(1034, b(iA3));
                                if (aiVar != null) {
                                    aiVar.a(baseException5);
                                }
                                a(downloadInfo.getId(), false, baseException5);
                                a(downloadInfo, zH);
                                return;
                            }
                        }
                        z2 = !b(file, file2);
                        baseException = null;
                    } catch (BaseException e2) {
                        baseException = e2;
                        z2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("fix_file_rename_failed");
                    }
                    if (z2) {
                        if (baseException == null) {
                            baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                        }
                        if (aiVar != null) {
                            aiVar.a(baseException);
                        }
                        a(downloadInfo.getId(), false, baseException);
                        return;
                    }
                    if (aiVar != null) {
                        aiVar.a();
                    }
                    a(downloadInfo.getId(), true, (BaseException) null);
                }
            }
        } catch (Throwable th) {
            String str2 = a;
            StringBuilder sbR2 = c.a.a.a.a.r("saveFileAsTargetName throwable ");
            sbR2.append(th.getMessage());
            com.ss.android.socialbase.downloader.c.a.b(str2, sbR2.toString());
            if (aiVar != null) {
                aiVar.a(new BaseException(1038, b(th, "saveFileAsTargetName")));
            }
        }
    }

    private static void a(int i2, boolean z, BaseException baseException) {
        synchronized (f3726d) {
            List<ai> list = f3727e.get(i2);
            if (list != null) {
                for (ai aiVar : list) {
                    if (aiVar != null) {
                        if (z) {
                            aiVar.a();
                        } else {
                            aiVar.a(baseException);
                        }
                    }
                }
            }
            com.ss.android.socialbase.downloader.c.a.b(a, "handleTempSaveCallback id:" + i2);
            f3726d.remove(i2);
        }
    }

    public static void a(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        file.getPath();
        file2.getPath();
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!a(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static boolean a(File file, File file2) {
        return a(file, file2, true);
    }

    public static boolean a(File file, File file2, boolean z) throws BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    file.getPath();
                    file2.getPath();
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    b(file, file2, z);
                    return true;
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                a(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    public static boolean a(int i2, String str) {
        if (a.a(16777216)) {
            return i2 == 206 || i2 == 1;
        }
        if (i2 >= 400) {
            return false;
        }
        return i2 == 206 || i2 == 1 || "bytes".equals(str);
    }

    public static List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list, String str, com.ss.android.socialbase.downloader.model.b bVar) {
        return a(list, str, bVar.m(), bVar.p());
    }

    public static List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list, String str, long j2, long j3) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                if (cVar != null) {
                    arrayList.add(cVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("If-Match", str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.model.c("Accept-Encoding", "identity"));
        String str2 = j3 <= 0 ? String.format("bytes=%s-", String.valueOf(j2)) : String.format("bytes=%s-%s", String.valueOf(j2), String.valueOf(j3));
        arrayList.add(new com.ss.android.socialbase.downloader.model.c("Range", str2));
        com.ss.android.socialbase.downloader.c.a.b(a, " range CurrentOffset:" + j2 + " EndOffset:" + j3 + ", range = " + str2);
        return arrayList;
    }

    public static boolean a(int i2, String str, String str2) {
        return i2 == -3 && !d(str, str2);
    }

    public static ConnectivityManager a(Context context) {
        ConnectivityManager connectivityManager = f3731i;
        if (connectivityManager != null) {
            return connectivityManager;
        }
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        f3731i = connectivityManager2;
        return connectivityManager2;
    }

    public static boolean a() {
        Boolean bool = f3732j;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strD = d(com.ss.android.socialbase.downloader.downloader.c.N());
        if (strD == null || !strD.contains(":")) {
            f3732j = Boolean.valueOf(strD != null && strD.equals(com.ss.android.socialbase.downloader.downloader.c.N().getPackageName()));
        } else {
            f3732j = Boolean.FALSE;
        }
        return f3732j.booleanValue();
    }

    public static boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        String strJ = j(th);
        if (!(th instanceof SocketTimeoutException)) {
            if (TextUtils.isEmpty(strJ)) {
                return false;
            }
            if (!strJ.contains("time out") && !strJ.contains("Time-out")) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static void a(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (!(th instanceof BaseException)) {
            if (!(th instanceof SSLHandshakeException)) {
                if (!a(th)) {
                    if (!e(th)) {
                        if (!f(th)) {
                            if (!b(th)) {
                                if (!c(th)) {
                                    if (!d(th)) {
                                        if (th instanceof IOException) {
                                            c(th, str);
                                            a((IOException) th, str);
                                            return;
                                        }
                                        throw new BaseException(1000, b(th, str2));
                                    }
                                    throw new BaseException(1041, b(th, str2));
                                }
                                throw new BaseException(1049, b(th, str2));
                            }
                            throw new BaseException(1047, b(th, str2));
                        }
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, 416, b(th, str2));
                    }
                    throw new com.ss.android.socialbase.downloader.exception.b(1004, 412, b(th, str2));
                }
                throw new BaseException(1048, b(th, str2));
            }
            throw new BaseException(PointerIconCompat.TYPE_COPY, b(th, str2));
        }
        BaseException baseException = (BaseException) th;
        StringBuilder sbT = c.a.a.a.a.t(str2, "-");
        sbT.append(baseException.getErrorMessage());
        baseException.setErrorMsg(sbT.toString());
        throw baseException;
    }

    public static void a(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String strB = b(iOException, str);
        if (!(iOException instanceof ConnectException)) {
            if (!(iOException instanceof UnknownHostException)) {
                if (!(iOException instanceof NoRouteToHostException)) {
                    if (!(iOException instanceof UnknownServiceException)) {
                        if (!(iOException instanceof PortUnreachableException)) {
                            if (!(iOException instanceof SocketTimeoutException)) {
                                if (!(iOException instanceof SocketException)) {
                                    if (!(iOException instanceof HttpRetryException)) {
                                        if (!(iOException instanceof ProtocolException)) {
                                            if (!(iOException instanceof MalformedURLException)) {
                                                if (!(iOException instanceof FileNotFoundException)) {
                                                    if (!(iOException instanceof InterruptedIOException)) {
                                                        if (!(iOException instanceof UnsupportedEncodingException)) {
                                                            if (!(iOException instanceof EOFException)) {
                                                                if (!(iOException instanceof StreamResetException)) {
                                                                    if (!(iOException instanceof SSLException)) {
                                                                        if (h(iOException)) {
                                                                            throw new BaseException(PointerIconCompat.TYPE_CELL, strB);
                                                                        }
                                                                        throw new BaseException(AudioAttributesCompat.FLAG_ALL, strB);
                                                                    }
                                                                    throw new BaseException(PointerIconCompat.TYPE_COPY, strB);
                                                                }
                                                                throw new BaseException(1067, strB);
                                                            }
                                                            throw new BaseException(1066, strB);
                                                        }
                                                        throw new BaseException(1065, strB);
                                                    }
                                                    throw new BaseException(1064, strB);
                                                }
                                                throw new BaseException(1063, strB);
                                            }
                                            throw new BaseException(1062, strB);
                                        }
                                        throw new BaseException(1061, strB);
                                    }
                                    throw new BaseException(1060, strB);
                                }
                                throw new BaseException(1059, strB);
                            }
                            throw new BaseException(1048, strB);
                        }
                        throw new BaseException(1058, strB);
                    }
                    throw new BaseException(1057, strB);
                }
                throw new BaseException(1056, strB);
            }
            throw new BaseException(1055, strB);
        }
        throw new BaseException(1041, strB);
    }

    public static boolean a(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static <K> HashMap<Integer, K> a(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> map = new HashMap<>();
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = sparseArray.keyAt(i2);
            map.put(Integer.valueOf(iKeyAt), sparseArray.valueAt(i2));
        }
        return map;
    }

    public static <K> void a(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static boolean a(List<com.ss.android.socialbase.downloader.model.c> list, List<com.ss.android.socialbase.downloader.model.c> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void a(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static String a(String str, int i2) {
        return i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static String a(String str, com.ss.android.socialbase.downloader.g.a aVar) {
        JSONObject jSONObjectD;
        String strI;
        if (aVar == null || (jSONObjectD = aVar.d("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectD.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith(w.DEFAULT_PATH_SEPARATOR)) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            strI = c.a.a.a.a.i(strOptString, str);
        } else {
            try {
                strI = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = strI;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    private static String a(File file, boolean z) {
        Context contextN = com.ss.android.socialbase.downloader.downloader.c.N();
        if (a(file)) {
            return file.getAbsolutePath();
        }
        int i2 = contextN.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
            File externalFilesDir = contextN.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (a(externalFilesDir)) {
                return externalFilesDir.getAbsolutePath();
            }
        } else {
            if (z) {
                File fileG = g();
                if (a(fileG)) {
                    return fileG.getAbsolutePath();
                }
            }
            File externalFilesDir2 = contextN.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (a(externalFilesDir2)) {
                return externalFilesDir2.getAbsolutePath();
            }
        }
        return contextN.getFilesDir().getAbsolutePath();
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(List<com.ss.android.socialbase.downloader.model.c> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new com.ss.android.socialbase.downloader.model.c("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    public static int a(Object obj, int i2) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i2;
        }
    }

    public static String a(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean a(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }
}
