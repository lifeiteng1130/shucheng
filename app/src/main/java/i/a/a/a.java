package i.a.a;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: Accessor.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public Field a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f6331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f6332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Class<?> f6334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Type f6335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6336g;

    public a(Class<?> cls, Field field, h hVar) {
        String strU2;
        this.f6336g = field.getName();
        int modifiers = field.getModifiers();
        if ((modifiers & Token.JSR) > 0) {
            return;
        }
        if ((modifiers & 1) > 0) {
            this.a = field;
        }
        String name = field.getName();
        int length = name.length();
        char[] cArr = new char[length + 3];
        cArr[0] = 's';
        cArr[1] = 'e';
        cArr[2] = 't';
        char cCharAt = name.charAt(0);
        if (cCharAt >= 'a' && cCharAt <= 'z') {
            cCharAt = (char) (cCharAt - ' ');
        }
        cArr[3] = cCharAt;
        for (int i2 = 1; i2 < length; i2++) {
            cArr[i2 + 3] = name.charAt(i2);
        }
        try {
            this.f6331b = cls.getDeclaredMethod(new String(cArr), field.getType());
        } catch (Exception unused) {
        }
        boolean zEquals = field.getType().equals(Boolean.TYPE);
        if (zEquals) {
            String name2 = field.getName();
            int length2 = name2.length();
            char[] cArr2 = new char[length2 + 2];
            cArr2[0] = 'i';
            cArr2[1] = 's';
            char cCharAt2 = name2.charAt(0);
            if (cCharAt2 >= 'a' && cCharAt2 <= 'z') {
                cCharAt2 = (char) (cCharAt2 - ' ');
            }
            cArr2[2] = cCharAt2;
            for (int i3 = 1; i3 < length2; i3++) {
                cArr2[i3 + 2] = name2.charAt(i3);
            }
            strU2 = new String(cArr2);
        } else {
            strU2 = c.b.a.m.f.u2(field.getName());
        }
        try {
            this.f6332c = cls.getDeclaredMethod(strU2, new Class[0]);
        } catch (Exception unused2) {
        }
        if (this.f6332c == null && zEquals) {
            try {
                this.f6332c = cls.getDeclaredMethod(c.b.a.m.f.u2(field.getName()), new Class[0]);
            } catch (Exception unused3) {
            }
        }
        if (this.a == null && this.f6332c == null && this.f6331b == null) {
            return;
        }
        Method method = this.f6332c;
        if (method != null && !hVar.a(field, method)) {
            this.f6332c = null;
        }
        Method method2 = this.f6331b;
        if (method2 != null && !hVar.a(field, method2)) {
            this.f6331b = null;
        }
        if (this.f6332c == null && this.f6331b == null && this.a == null) {
            return;
        }
        this.f6334e = field.getType();
        this.f6335f = field.getGenericType();
    }

    public boolean a() {
        return this.f6331b == null;
    }
}
