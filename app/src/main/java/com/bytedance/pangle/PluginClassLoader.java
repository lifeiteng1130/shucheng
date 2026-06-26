package com.bytedance.pangle;

import androidx.annotation.Keep;
import c.a.a.a.a;
import dalvik.system.DexClassLoader;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class PluginClassLoader extends DexClassLoader {
    private static final String TAG = "PluginClassLoader";
    private final ClassLoader hostClassLoader;
    private final List<ClassLoader> otherPluginClassLoader;

    public PluginClassLoader(String str, String str2, String str3, List<ClassLoader> list) {
        super(str, str2, str3, DexClassLoader.getSystemClassLoader().getParent());
        this.hostClassLoader = PluginClassLoader.class.getClassLoader();
        this.otherPluginClassLoader = list;
    }

    private ClassNotFoundException handleException(StringBuilder sb, ClassNotFoundException classNotFoundException, ClassNotFoundException classNotFoundException2) {
        if (classNotFoundException == null) {
            return classNotFoundException2;
        }
        classNotFoundException.addSuppressed(classNotFoundException2);
        return classNotFoundException;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        List<ClassLoader> list;
        Class<?> clsLoadClass = null;
        try {
            e = null;
            clsLoadClass = super.findClass(str);
        } catch (ClassNotFoundException e2) {
            e = e2;
        }
        StringBuilder sb = new StringBuilder("loadClass from :\n");
        if (clsLoadClass == null && (list = this.otherPluginClassLoader) != null) {
            Iterator<ClassLoader> it = list.iterator();
            while (it.hasNext()) {
                try {
                    clsLoadClass = it.next().loadClass(str);
                } catch (ClassNotFoundException e3) {
                    e = handleException(sb, e, e3);
                }
            }
        }
        if (clsLoadClass == null) {
            try {
                clsLoadClass = this.hostClassLoader.loadClass(str);
            } catch (ClassNotFoundException e4) {
                e = handleException(sb, e, e4);
            }
        }
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        if (e == null) {
            throw new ClassNotFoundException(a.i(str, " class not found in PluginClassLoader"));
        }
        throw e;
    }
}
