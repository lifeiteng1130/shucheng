package org.mozilla.javascript.tools.shell;

import c.a.a.a.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* JADX INFO: compiled from: ShellConsole.java */
/* JADX INFO: loaded from: classes3.dex */
public class FlexibleCompletor implements InvocationHandler {
    private Method completeMethod;
    private Scriptable global;

    public FlexibleCompletor(Class<?> cls, Scriptable scriptable) {
        this.global = scriptable;
        this.completeMethod = cls.getMethod("complete", String.class, Integer.TYPE, List.class);
    }

    public int complete(String str, int i2, List<String> list) {
        int i3 = i2 - 1;
        while (i3 >= 0) {
            char cCharAt = str.charAt(i3);
            if (!Character.isJavaIdentifierPart(cCharAt) && cCharAt != '.') {
                break;
            }
            i3--;
        }
        String[] strArrSplit = str.substring(i3 + 1, i2).split("\\.", -1);
        Scriptable scriptable = this.global;
        for (int i4 = 0; i4 < strArrSplit.length - 1; i4++) {
            Object obj = scriptable.get(strArrSplit[i4], this.global);
            if (!(obj instanceof Scriptable)) {
                return str.length();
            }
            scriptable = (Scriptable) obj;
        }
        Object[] allIds = scriptable instanceof ScriptableObject ? ((ScriptableObject) scriptable).getAllIds() : scriptable.getIds();
        String str2 = strArrSplit[strArrSplit.length - 1];
        for (int i5 = 0; i5 < allIds.length; i5++) {
            if (allIds[i5] instanceof String) {
                String strI = (String) allIds[i5];
                if (strI.startsWith(str2)) {
                    if (scriptable.get(strI, scriptable) instanceof Function) {
                        strI = a.i(strI, "(");
                    }
                    list.add(strI);
                }
            }
        }
        return str.length() - str2.length();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.equals(this.completeMethod)) {
            return Integer.valueOf(complete((String) objArr[0], ((Integer) objArr[1]).intValue(), (List) objArr[2]));
        }
        throw new NoSuchMethodError(method.toString());
    }
}
