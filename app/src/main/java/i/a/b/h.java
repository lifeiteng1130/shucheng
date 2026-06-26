package i.a.b;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.minidev.json.annotate.JsonIgnore;

/* JADX INFO: compiled from: JSONUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static final a a = new a();

    /* JADX INFO: compiled from: JSONUtil.java */
    public static class a implements i.a.a.h {
        @Override // i.a.a.h
        public boolean a(Field field, Method method) {
            JsonIgnore jsonIgnore = (JsonIgnore) method.getAnnotation(JsonIgnore.class);
            return jsonIgnore == null || !jsonIgnore.value();
        }
    }

    public static Object a(Object obj, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (!cls.isPrimitive()) {
            if (cls.isEnum()) {
                return Enum.valueOf(cls, obj.toString());
            }
            if (cls == Integer.class) {
                return obj instanceof Number ? Integer.valueOf(((Number) obj).intValue()) : Integer.valueOf(obj.toString());
            }
            if (cls == Long.class) {
                return obj instanceof Number ? Long.valueOf(((Number) obj).longValue()) : Long.valueOf(obj.toString());
            }
            if (cls == Short.class) {
                return obj instanceof Number ? Short.valueOf(((Number) obj).shortValue()) : Short.valueOf(obj.toString());
            }
            if (cls == Byte.class) {
                return obj instanceof Number ? Byte.valueOf(((Number) obj).byteValue()) : Byte.valueOf(obj.toString());
            }
            if (cls == Float.class) {
                return obj instanceof Number ? Float.valueOf(((Number) obj).floatValue()) : Float.valueOf(obj.toString());
            }
            if (cls == Double.class) {
                return obj instanceof Number ? Double.valueOf(((Number) obj).doubleValue()) : Double.valueOf(obj.toString());
            }
            if (cls == Character.class) {
                String string = cls.toString();
                if (string.length() > 0) {
                    return Character.valueOf(string.charAt(0));
                }
            }
            throw new RuntimeException("Object: Can not Convert " + obj.getClass().getName() + " to " + cls.getName());
        }
        if (obj instanceof Number) {
            return obj;
        }
        if (cls == Integer.TYPE) {
            return Integer.valueOf(obj.toString());
        }
        if (cls == Short.TYPE) {
            return Short.valueOf(obj.toString());
        }
        if (cls == Long.TYPE) {
            return Long.valueOf(obj.toString());
        }
        if (cls == Byte.TYPE) {
            return Byte.valueOf(obj.toString());
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(obj.toString());
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(obj.toString());
        }
        if (cls == Character.TYPE) {
            String string2 = cls.toString();
            if (string2.length() > 0) {
                return Character.valueOf(string2.charAt(0));
            }
        } else if (cls == Boolean.TYPE) {
            return (Boolean) obj;
        }
        throw new RuntimeException("Primitive: Can not convert " + obj.getClass().getName() + " to " + cls.getName());
    }
}
