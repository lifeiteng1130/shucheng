package k.b.a.a;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ClassUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final Map<String, Class<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f8536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f8537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, String> f8538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, String> f8539e;

    static {
        String.valueOf('.');
        String.valueOf('$');
        HashMap map = new HashMap();
        a = map;
        Class cls = Boolean.TYPE;
        map.put("boolean", cls);
        map.put("byte", Byte.TYPE);
        map.put("char", Character.TYPE);
        map.put("short", Short.TYPE);
        Class cls2 = Integer.TYPE;
        map.put("int", cls2);
        Class cls3 = Long.TYPE;
        map.put("long", cls3);
        map.put("double", Double.TYPE);
        Class cls4 = Float.TYPE;
        map.put("float", cls4);
        map.put("void", Void.TYPE);
        HashMap map2 = new HashMap();
        f8536b = map2;
        map2.put(cls, Boolean.class);
        map2.put(Byte.TYPE, Byte.class);
        map2.put(Character.TYPE, Character.class);
        map2.put(Short.TYPE, Short.class);
        map2.put(cls2, Integer.class);
        map2.put(cls3, Long.class);
        map2.put(Double.TYPE, Double.class);
        map2.put(cls4, Float.class);
        Class cls5 = Void.TYPE;
        map2.put(cls5, cls5);
        f8537c = new HashMap();
        for (Map.Entry entry : map2.entrySet()) {
            Class<?> cls6 = (Class) entry.getKey();
            Class<?> cls7 = (Class) entry.getValue();
            if (!cls6.equals(cls7)) {
                f8537c.put(cls7, cls6);
            }
        }
        HashMap map3 = new HashMap();
        map3.put("int", OptRuntime.GeneratorState.resumptionPoint_TYPE);
        map3.put("boolean", "Z");
        map3.put("float", "F");
        map3.put("long", "J");
        map3.put("short", ExifInterface.LATITUDE_SOUTH);
        map3.put("byte", "B");
        map3.put("double", "D");
        map3.put("char", "C");
        HashMap map4 = new HashMap();
        for (Map.Entry entry2 : map3.entrySet()) {
            map4.put(entry2.getValue(), entry2.getKey());
        }
        f8538d = Collections.unmodifiableMap(map3);
        f8539e = Collections.unmodifiableMap(map4);
    }

    public static String a(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        String name = cls.getName();
        if (f.e(name)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (name.startsWith("[")) {
            while (name.charAt(0) == '[') {
                name = name.substring(1);
                sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            if (name.charAt(0) == 'L' && name.charAt(name.length() - 1) == ';') {
                name = c.a.a.a.a.c(name, 1, 1);
            }
            Map<String, String> map = f8539e;
            if (map.containsKey(name)) {
                name = map.get(name);
            }
        }
        int iLastIndexOf = name.lastIndexOf(46);
        int iIndexOf = name.indexOf(36, iLastIndexOf != -1 ? iLastIndexOf + 1 : 0);
        String strSubstring = name.substring(iLastIndexOf + 1);
        if (iIndexOf != -1) {
            strSubstring = strSubstring.replace('$', '.');
        }
        return strSubstring + ((Object) sb);
    }
}
