package j$.util.stream;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes2.dex */
final class i3 {
    static final boolean a = ((Boolean) AccessController.doPrivileged(new PrivilegedAction() { // from class: j$.util.stream.I0
        @Override // java.security.PrivilegedAction
        public final Object run() {
            boolean z = i3.a;
            return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
        }
    })).booleanValue();

    static void a(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
