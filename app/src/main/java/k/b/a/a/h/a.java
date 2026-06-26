package k.b.a.a.h;

import java.util.ArrayList;
import java.util.Map;
import k.b.a.a.b;
import k.b.a.a.f;

/* JADX INFO: compiled from: ExceptionUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static String a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        for (Throwable cause = th; cause != null && !arrayList.contains(cause); cause = cause.getCause()) {
            arrayList.add(cause);
        }
        Throwable th2 = arrayList.isEmpty() ? null : (Throwable) arrayList.get(arrayList.size() - 1);
        if (th2 != null) {
            th = th2;
        }
        Map<String, Class<?>> map = b.a;
        String strA = b.a(th.getClass());
        String message = th.getMessage();
        StringBuilder sbT = c.a.a.a.a.t(strA, ": ");
        int i2 = f.a;
        if (message == null) {
            message = "";
        }
        sbT.append(message);
        return sbT.toString();
    }
}
