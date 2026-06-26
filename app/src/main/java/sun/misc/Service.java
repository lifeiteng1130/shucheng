package sun.misc;

import c.a.a.a.a;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public final class Service {
    private static final String prefix = "META-INF/services/";

    public static class LazyIterator implements Iterator, j$.util.Iterator {
        public Enumeration configs;
        public ClassLoader loader;
        public String nextName;
        public Iterator pending;
        public Set returned;
        public Class service;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0034 -> B:14:0x004a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x004a -> B:14:0x004a). Please report as a decompilation issue!!! */
        @Override // java.util.Iterator, j$.util.Iterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean hasNext() {
            /*
                r5 = this;
                java.lang.String r0 = r5.nextName
                r1 = 1
                if (r0 == 0) goto L6
                return r1
            L6:
                java.util.Enumeration r0 = r5.configs
                if (r0 != 0) goto L4a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L33
                r0.<init>()     // Catch: java.io.IOException -> L33
                java.lang.String r2 = "META-INF/services/"
                r0.append(r2)     // Catch: java.io.IOException -> L33
                java.lang.Class r2 = r5.service     // Catch: java.io.IOException -> L33
                java.lang.String r2 = r2.getName()     // Catch: java.io.IOException -> L33
                r0.append(r2)     // Catch: java.io.IOException -> L33
                java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L33
                java.lang.ClassLoader r2 = r5.loader     // Catch: java.io.IOException -> L33
                if (r2 != 0) goto L2c
                java.util.Enumeration r0 = java.lang.ClassLoader.getSystemResources(r0)     // Catch: java.io.IOException -> L33
                r5.configs = r0     // Catch: java.io.IOException -> L33
                goto L4a
            L2c:
                java.util.Enumeration r0 = r2.getResources(r0)     // Catch: java.io.IOException -> L33
                r5.configs = r0     // Catch: java.io.IOException -> L33
                goto L4a
            L33:
                r0 = move-exception
                java.lang.Class r2 = r5.service
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = ": "
                r3.append(r4)
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                sun.misc.Service.access$000(r2, r0)
            L4a:
                java.util.Iterator r0 = r5.pending
                if (r0 == 0) goto L60
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto L55
                goto L60
            L55:
                java.util.Iterator r0 = r5.pending
                java.lang.Object r0 = r0.next()
                java.lang.String r0 = (java.lang.String) r0
                r5.nextName = r0
                return r1
            L60:
                java.util.Enumeration r0 = r5.configs
                boolean r0 = r0.hasMoreElements()
                if (r0 != 0) goto L6a
                r0 = 0
                return r0
            L6a:
                java.lang.Class r0 = r5.service
                java.util.Enumeration r2 = r5.configs
                java.lang.Object r2 = r2.nextElement()
                java.net.URL r2 = (java.net.URL) r2
                java.util.Set r3 = r5.returned
                java.util.Iterator r0 = sun.misc.Service.access$100(r0, r2, r3)
                r5.pending = r0
                goto L4a
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.Service.LazyIterator.hasNext():boolean");
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Object next() {
            Class<?> cls;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.nextName;
            this.nextName = null;
            try {
                cls = Class.forName(str, false, this.loader);
            } catch (ClassNotFoundException unused) {
                Service.fail(this.service, "Provider " + str + " not found");
                cls = null;
            }
            if (!this.service.isAssignableFrom(cls)) {
                Service.fail(this.service, "Provider " + str + " not a subtype");
            }
            try {
                return this.service.cast(cls.newInstance());
            } catch (Throwable th) {
                Service.fail(this.service, "Provider " + str + " could not be instantiated: " + th, th);
                return null;
            }
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private LazyIterator(Class cls, ClassLoader classLoader) {
            this.configs = null;
            this.pending = null;
            this.returned = new TreeSet();
            this.nextName = null;
            this.service = cls;
            this.loader = classLoader;
        }
    }

    private Service() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fail(Class cls, String str, Throwable th) {
        ServiceConfigurationError serviceConfigurationError = new ServiceConfigurationError(cls.getName() + ": " + str);
        serviceConfigurationError.initCause(th);
        throw serviceConfigurationError;
    }

    public static java.util.Iterator installedProviders(Class cls) {
        ClassLoader classLoader = null;
        for (ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader(); systemClassLoader != null; systemClassLoader = systemClassLoader.getParent()) {
            classLoader = systemClassLoader;
        }
        return providers(cls, classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        r11 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        r12 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089 A[Catch: IOException -> 0x0085, TRY_LEAVE, TryCatch #2 {IOException -> 0x0085, blocks: (B:45:0x0081, B:49:0x0089), top: B:53:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Iterator parse(java.lang.Class r10, java.net.URL r11, java.util.Set r12) throws java.lang.Throwable {
        /*
            java.lang.String r0 = ": "
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r1 = 0
            java.io.InputStream r8 = r11.openStream()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c
            java.lang.String r3 = "utf-8"
            r2.<init>(r8, r3)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c
            r9.<init>(r2)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c
            r1 = 1
            r4 = 1
        L1a:
            r1 = r10
            r2 = r11
            r3 = r9
            r5 = r7
            r6 = r12
            int r4 = parseLine(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            if (r4 < 0) goto L26
            goto L1a
        L26:
            r9.close()     // Catch: java.io.IOException -> L2f
            if (r8 == 0) goto L77
            r8.close()     // Catch: java.io.IOException -> L2f
            goto L77
        L2f:
            r11 = move-exception
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            goto L6a
        L36:
            r11 = move-exception
            goto L7e
        L38:
            r11 = move-exception
            goto L3e
        L3a:
            r11 = move-exception
            goto L7f
        L3c:
            r11 = move-exception
            r9 = r1
        L3e:
            r1 = r8
            goto L45
        L40:
            r11 = move-exception
            r8 = r1
            goto L7f
        L43:
            r11 = move-exception
            r9 = r1
        L45:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r12.<init>()     // Catch: java.lang.Throwable -> L7c
            r12.append(r0)     // Catch: java.lang.Throwable -> L7c
            r12.append(r11)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r11 = r12.toString()     // Catch: java.lang.Throwable -> L7c
            fail(r10, r11)     // Catch: java.lang.Throwable -> L7c
            if (r9 == 0) goto L5f
            r9.close()     // Catch: java.io.IOException -> L5d
            goto L5f
        L5d:
            r11 = move-exception
            goto L65
        L5f:
            if (r1 == 0) goto L77
            r1.close()     // Catch: java.io.IOException -> L5d
            goto L77
        L65:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
        L6a:
            r12.append(r0)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            fail(r10, r11)
        L77:
            java.util.Iterator r10 = r7.iterator()
            return r10
        L7c:
            r11 = move-exception
            r8 = r1
        L7e:
            r1 = r9
        L7f:
            if (r1 == 0) goto L87
            r1.close()     // Catch: java.io.IOException -> L85
            goto L87
        L85:
            r12 = move-exception
            goto L8d
        L87:
            if (r8 == 0) goto L9f
            r8.close()     // Catch: java.io.IOException -> L85
            goto L9f
        L8d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            fail(r10, r12)
        L9f:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.Service.parse(java.lang.Class, java.net.URL, java.util.Set):java.util.Iterator");
    }

    private static int parseLine(Class cls, URL url, BufferedReader bufferedReader, int i2, List list, Set set) throws IOException {
        String line = bufferedReader.readLine();
        if (line == null) {
            return -1;
        }
        int iIndexOf = line.indexOf(35);
        if (iIndexOf >= 0) {
            line = line.substring(0, iIndexOf);
        }
        String strTrim = line.trim();
        int length = strTrim.length();
        if (length != 0) {
            if (strTrim.indexOf(32) >= 0 || strTrim.indexOf(9) >= 0) {
                fail(cls, url, i2, "Illegal configuration-file syntax");
            }
            int iCodePointAt = strTrim.codePointAt(0);
            if (!Character.isJavaIdentifierStart(iCodePointAt)) {
                fail(cls, url, i2, a.i("Illegal provider-class name: ", strTrim));
            }
            int iCharCount = Character.charCount(iCodePointAt);
            while (iCharCount < length) {
                int iCodePointAt2 = strTrim.codePointAt(iCharCount);
                if (!Character.isJavaIdentifierPart(iCodePointAt2) && iCodePointAt2 != 46) {
                    fail(cls, url, i2, a.i("Illegal provider-class name: ", strTrim));
                }
                iCharCount += Character.charCount(iCodePointAt2);
            }
            if (!set.contains(strTrim)) {
                list.add(strTrim);
                set.add(strTrim);
            }
        }
        return i2 + 1;
    }

    public static java.util.Iterator providers(Class cls, ClassLoader classLoader) {
        return new LazyIterator(cls, classLoader);
    }

    public static java.util.Iterator providers(Class cls) {
        return providers(cls, Thread.currentThread().getContextClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fail(Class cls, String str) {
        throw new ServiceConfigurationError(cls.getName() + ": " + str);
    }

    private static void fail(Class cls, URL url, int i2, String str) {
        fail(cls, url + ":" + i2 + ": " + str);
    }
}
