package l.a.a;

import java.security.PrivilegedAction;

/* JADX INFO: compiled from: GetPropertyAction.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements PrivilegedAction<String> {
    public a(String str) {
    }

    @Override // java.security.PrivilegedAction
    public String run() {
        String property = System.getProperty("rhino.js.version");
        if (property == null) {
            return null;
        }
        return property;
    }
}
