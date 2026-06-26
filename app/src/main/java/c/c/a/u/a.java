package c.c.a.u;

import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import c.b.a.m.f;
import c.c.a.x.c;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static Map<String, Integer> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedHashMap<String, Integer> f790b;

    static {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e2) {
            ZeusLogger.e(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e2);
            assetManager = null;
        }
        ArrayList arrayList = (ArrayList) c.a(assetManager);
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a.put((String) it.next(), 0);
            }
        }
    }

    public a() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        this.f790b = linkedHashMap;
        linkedHashMap.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    public static AssetManager b(AssetManager assetManager, String str, boolean z) {
        String str2 = "addAssetPath";
        String str3 = z ? "addAssetPathAsSharedLibrary" : "addAssetPath";
        Method accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, str3, String.class);
        if (accessibleMethod == null && z) {
            accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", String.class);
            ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
        } else {
            str2 = str3;
        }
        if (accessibleMethod != null) {
            int i2 = 3;
            while (true) {
                int i3 = i2 - 1;
                if (i2 < 0) {
                    break;
                }
                try {
                    int iIntValue = ((Integer) accessibleMethod.invoke(assetManager, str)).intValue();
                    if (iIntValue != 0) {
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + iIntValue + ", path = " + str);
                        break;
                    }
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = ".concat(String.valueOf(iIntValue)));
                } catch (Exception e2) {
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + z + ", methodName = " + str2, e2);
                }
                i2 = i3;
            }
        } else {
            ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = ".concat(String.valueOf(z)));
        }
        return assetManager;
    }

    public final AssetManager a(AssetManager assetManager, String str, boolean z) {
        boolean z2;
        int iIntValue;
        int i2 = 25;
        int i3 = 1;
        if (Build.VERSION.SDK_INT <= 25) {
            Throwable th = null;
            int i4 = 3;
            int i5 = 3;
            loop0: while (true) {
                int i6 = i5 - 1;
                if (i5 < 0) {
                    break;
                }
                try {
                    synchronized (assetManager) {
                        iIntValue = 0;
                        for (int i7 = 0; i7 < i4; i7++) {
                            try {
                                int i8 = Build.VERSION.SDK_INT;
                                if (i8 <= 23) {
                                    Object[] objArr = new Object[i3];
                                    objArr[0] = str;
                                    Class[] clsArr = new Class[i3];
                                    clsArr[0] = String.class;
                                    iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", objArr, clsArr)).intValue();
                                } else if (i8 >= 24 && i8 <= i2) {
                                    Object[] objArr2 = new Object[2];
                                    objArr2[0] = str;
                                    objArr2[i3] = Boolean.valueOf(z);
                                    Class[] clsArr2 = new Class[2];
                                    clsArr2[0] = String.class;
                                    clsArr2[i3] = Boolean.TYPE;
                                    iIntValue = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", objArr2, clsArr2)).intValue();
                                }
                                if (iIntValue != 0) {
                                    break loop0;
                                }
                            } finally {
                            }
                        }
                        break loop0;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i5 = i6;
                    i2 = 25;
                    i3 = 1;
                    i4 = 3;
                }
            }
            if (iIntValue != 0) {
                Object field = FieldUtils.readField(assetManager, "mStringBlocks");
                int length = field != null ? Array.getLength(field) : 0;
                int iIntValue2 = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                Object objNewInstance = Array.newInstance(field.getClass().getComponentType(), iIntValue2);
                int i9 = 0;
                while (i9 < iIntValue2) {
                    if (i9 < length) {
                        Array.set(objNewInstance, i9, Array.get(field, i9));
                    } else {
                        Object[] objArr3 = new Object[i3];
                        objArr3[0] = Integer.valueOf(i9);
                        Class[] clsArr3 = new Class[i3];
                        clsArr3[0] = Integer.TYPE;
                        long jLongValue = ((Long) MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", objArr3, clsArr3)).longValue();
                        Class<?> componentType = field.getClass().getComponentType();
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = Long.valueOf(jLongValue);
                        objArr4[i3] = Boolean.TRUE;
                        Array.set(objNewInstance, i9, MethodUtils.invokeConstructor(componentType, objArr4, new Class[]{Long.TYPE, Boolean.TYPE}));
                    }
                    i9++;
                    i3 = 1;
                }
                FieldUtils.writeField(assetManager, "mStringBlocks", objNewInstance);
                ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(String.valueOf(str)));
            }
            if (th != null) {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            try {
            } catch (Throwable th3) {
                ZeusLogger.e(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th3);
            }
            if (f.o1()) {
                Object[] objArr5 = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr5 != null && objArr5.length > 0) {
                    for (Object obj : objArr5) {
                        if (TextUtils.equals((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]), str)) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
            } else {
                int iIntValue3 = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                int i10 = 0;
                while (i10 < iIntValue3) {
                    i10++;
                    if (TextUtils.equals((String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i10)), str)) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            if (!z2) {
                b(assetManager, str, z);
            }
        } else {
            b(assetManager, str, z);
        }
        synchronized (this.f790b) {
            this.f790b.put(str, 0);
        }
        StringBuilder sb = new StringBuilder("AssetManagerProcessor updateAssetManager, newAssetManager=");
        sb.append(assetManager);
        sb.append(", assets=");
        List<String> listA = c.a(assetManager);
        StringBuilder sb2 = new StringBuilder("[");
        ArrayList arrayList = (ArrayList) listA;
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb2.append((String) it.next());
                sb2.append(" , ");
            }
            sb2.delete(sb2.lastIndexOf(" , "), sb2.length());
        }
        sb2.append("]");
        sb.append(sb2.toString());
        ZeusLogger.i(ZeusLogger.TAG_LOAD, sb.toString());
        return assetManager;
    }
}
