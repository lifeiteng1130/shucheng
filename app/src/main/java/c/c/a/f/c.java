package c.c.a.f;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final Set<File> a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f696b;

    static {
        String property = System.getProperty("java.vm.version");
        boolean z = false;
        if (property != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(property);
            if (matcher.matches()) {
                try {
                    int i2 = Integer.parseInt(matcher.group(1));
                    int i3 = Integer.parseInt(matcher.group(2));
                    if (i2 > 2 || (i2 == 2 && i3 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder("PluginMultiDex VM with version ");
        sb.append(property);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        ZeusLogger.i(ZeusLogger.TAG_LOAD, sb.toString());
        f696b = z;
    }

    public static void a(@NonNull ApplicationInfo applicationInfo, PluginContext pluginContext, File file, String str, String str2) {
        Set<File> set = a;
        synchronized (set) {
            if (!set.contains(file)) {
                set.add(file);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex MultiDex is not guaranteed to work in SDK version " + Build.VERSION.SDK_INT + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
                try {
                    PluginClassLoader pluginClassLoader = pluginContext.mPlugin.mClassLoader;
                    if (pluginClassLoader == null) {
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Context class loader is null. Must be running in test mode. Skip patching.");
                    } else {
                        try {
                            f(pluginContext);
                        } catch (Throwable th) {
                            ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", th);
                        }
                        File file2 = new File(pluginContext.getDataDir(), "code_cache");
                        try {
                            b(file2);
                        } catch (IOException unused) {
                            file2 = new File(pluginContext.getFilesDir(), "code_cache");
                            b(file2);
                        }
                        File file3 = new File(file2, str);
                        b(file3);
                        b bVar = new b(file, file3);
                        IOException e2 = null;
                        try {
                            try {
                                c(pluginClassLoader, file3, bVar.b(pluginContext, str2, false));
                            } catch (IOException e3) {
                                ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDexFailed to install extracted secondary dex files, retrying with forced extraction", e3);
                                c(pluginClassLoader, file3, bVar.b(pluginContext, str2, true));
                            }
                            try {
                            } catch (IOException e4) {
                                e2 = e4;
                            }
                            if (e2 != null) {
                                throw e2;
                            }
                        } finally {
                            try {
                                bVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                } catch (RuntimeException e5) {
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e5);
                }
            }
        }
    }

    public static void b(File file) throws IOException {
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to create dir " + file.getPath() + ". Parent file is null.");
        } else {
            ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
        }
        throw new IOException("Failed to create directory " + file.getPath());
    }

    public static void c(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, IOException {
        IOException[] iOExceptionArr;
        if (list.isEmpty()) {
            return;
        }
        Object obj = e(classLoader, "pathList").get(classLoader);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        Class<?>[] clsArr = {ArrayList.class, File.class, ArrayList.class};
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod("makeDexElements", clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                d(obj, "dexElements", (Object[]) declaredMethod.invoke(obj, arrayList2, file, arrayList));
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginMultiDex Exception in makeDexElement", (IOException) it.next());
                    }
                    Field fieldE = e(obj, "dexElementsSuppressedExceptions");
                    IOException[] iOExceptionArr2 = (IOException[]) fieldE.get(obj);
                    if (iOExceptionArr2 == null) {
                        iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                    } else {
                        IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                        arrayList.toArray(iOExceptionArr3);
                        System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                        iOExceptionArr = iOExceptionArr3;
                    }
                    fieldE.set(obj, iOExceptionArr);
                    IOException iOException = new IOException("I/O exception during makeDexElement");
                    iOException.initCause((Throwable) arrayList.get(0));
                    throw iOException;
                }
                return;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method makeDexElements with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    public static /* synthetic */ void d(Object obj, String str, Object[] objArr) throws IllegalAccessException, NoSuchFieldException {
        Field fieldE = e(obj, str);
        Object[] objArr2 = (Object[]) fieldE.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        fieldE.set(obj, objArr3);
    }

    public static Field e(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    public static void f(PluginContext pluginContext) {
        File file = new File(pluginContext.getDataDir().getAbsolutePath() + "/files/secondary-dexes");
        if (file.isDirectory()) {
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : fileArrListFiles) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (file2.delete()) {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Deleted old file " + file2.getPath());
                } else {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to delete old file " + file2.getPath());
                }
            }
            if (file.delete()) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginMultiDex Deleted old secondary dex dir " + file.getPath());
            } else {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginMultiDex Failed to delete secondary dex dir " + file.getPath());
            }
        }
    }
}
