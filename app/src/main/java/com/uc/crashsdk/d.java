package com.uc.crashsdk;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.crashsdk.export.ICrashClient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static ICrashClient a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f4562b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f4563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f4564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f4565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f4566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f4567g = new Object();

    public static void a(ICrashClient iCrashClient) {
        a = iCrashClient;
    }

    public static boolean b(ValueCallback<Bundle> valueCallback) {
        if (f4564d == null) {
            synchronized (f4567g) {
                if (f4564d == null) {
                    f4564d = new ArrayList();
                }
            }
        }
        synchronized (f4564d) {
            if (f4564d.size() >= f4562b) {
                return false;
            }
            f4564d.add(valueCallback);
            return true;
        }
    }

    public static boolean c(ValueCallback<Bundle> valueCallback) {
        if (f4565e == null) {
            synchronized (f4567g) {
                if (f4565e == null) {
                    f4565e = new ArrayList();
                }
            }
        }
        synchronized (f4565e) {
            if (f4565e.size() >= f4562b) {
                return false;
            }
            f4565e.add(valueCallback);
            return true;
        }
    }

    public static boolean d(ValueCallback<Bundle> valueCallback) {
        if (f4566f == null) {
            synchronized (f4567g) {
                if (f4566f == null) {
                    f4566f = new ArrayList();
                }
            }
        }
        synchronized (f4566f) {
            if (f4566f.size() >= f4562b) {
                return false;
            }
            f4566f.add(valueCallback);
            return true;
        }
    }

    public static void a(String str, String str2, String str3) {
        if (com.uc.crashsdk.a.g.a(str)) {
            com.uc.crashsdk.a.a.a("crashsdk", "onLogGenerated file name is null!", null);
            return;
        }
        boolean zEquals = e.h().equals(str2);
        if (a != null) {
            File file = new File(str);
            try {
                if (zEquals) {
                    a.onLogGenerated(file, str3);
                } else {
                    a.onClientProcessLogGenerated(str2, file, str3);
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        List<ValueCallback<Bundle>> list = f4563c;
        if (!zEquals) {
            list = f4564d;
        }
        if (list != null) {
            synchronized (list) {
                for (ValueCallback<Bundle> valueCallback : list) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("filePathName", str);
                        if (!zEquals) {
                            bundle.putString("processName", str2);
                        }
                        bundle.putString("logType", str3);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                    }
                }
            }
        }
    }

    public static File a(File file) {
        ICrashClient iCrashClient = a;
        if (iCrashClient != null) {
            try {
                return iCrashClient.onBeforeUploadLog(file);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        return file;
    }

    public static void a(boolean z) {
        ICrashClient iCrashClient = a;
        if (iCrashClient != null) {
            try {
                iCrashClient.onCrashRestarting(z);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (f4565e != null) {
            synchronized (f4565e) {
                for (ValueCallback<Bundle> valueCallback : f4565e) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("isJava", z);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                    }
                }
            }
        }
    }

    public static void a(String str, int i2, int i3) {
        ICrashClient iCrashClient = a;
        if (iCrashClient != null) {
            iCrashClient.onAddCrashStats(str, i2, i3);
        }
        if (f4566f != null) {
            synchronized (f4566f) {
                for (ValueCallback<Bundle> valueCallback : f4566f) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("processName", str);
                        bundle.putInt("key", i2);
                        bundle.putInt("count", i3);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                }
            }
        }
    }

    public static String a(String str, boolean z) {
        ICrashClient iCrashClient = a;
        return iCrashClient != null ? iCrashClient.onGetCallbackInfo(str, z) : "";
    }

    public static boolean a(ValueCallback<Bundle> valueCallback) {
        if (f4563c == null) {
            synchronized (f4567g) {
                if (f4563c == null) {
                    f4563c = new ArrayList();
                }
            }
        }
        synchronized (f4563c) {
            if (f4563c.size() >= f4562b) {
                return false;
            }
            f4563c.add(valueCallback);
            return true;
        }
    }
}
