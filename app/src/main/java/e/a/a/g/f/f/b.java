package e.a.a.g.f.f;

import f.c0.c.f;
import f.c0.c.j;
import f.h;
import f.x.e;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JavaBean.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b implements Serializable {

    @NotNull
    public static final a Companion = new a(null);
    private static final long serialVersionUID = -6111323241670458039L;

    /* JADX INFO: compiled from: JavaBean.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    @NotNull
    public String toString() {
        int i2;
        ArrayList arrayList = new ArrayList();
        Class<?> superclass = getClass();
        j.c(superclass);
        Field[] declaredFields = superclass.getDeclaredFields();
        j.d(declaredFields, "!!.declaredFields");
        arrayList.addAll(e.u(Arrays.copyOf(declaredFields, declaredFields.length)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            i2 = 0;
            if (j.a(superclass, Object.class)) {
                break;
            }
            superclass = superclass.getSuperclass();
            j.c(superclass);
            Field[] declaredFields2 = superclass.getDeclaredFields();
            j.d(declaredFields2, "fields");
            int length = declaredFields2.length;
            while (i2 < length) {
                Field field = declaredFields2[i2];
                i2++;
                int modifiers = field.getModifiers();
                if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                    arrayList.add(field);
                }
            }
        }
        Object[] array = arrayList.toArray(new Field[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Field[] fieldArr = (Field[]) array;
        int length2 = fieldArr.length;
        while (i2 < length2) {
            Field field2 = fieldArr[i2];
            i2++;
            String name = field2.getName();
            try {
                Object obj = field2.get(this);
                sb.append(name);
                sb.append("=");
                sb.append(obj);
                sb.append("\n");
                h.m11constructorimpl(sb);
            } catch (Throwable th) {
                h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
        }
        String string = sb.toString();
        j.d(string, "sb.toString()");
        return string;
    }
}
