package h.a.a.a;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: MediaType.java */
/* JADX INFO: loaded from: classes3.dex */
public class l implements Serializable {
    private static final long serialVersionUID = -7256091153727506788L;
    private final String defaultExtension;
    private final Collection<String> extensions;
    private final String name;

    public l(String str, String str2) {
        this(str, str2, new String[]{str2});
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            return this.name.equals(((l) obj).getName());
        }
        return false;
    }

    public String getDefaultExtension() {
        return this.defaultExtension;
    }

    public Collection<String> getExtensions() {
        return this.extensions;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return this.name;
    }

    public l(String str, String str2, String[] strArr) {
        this(str, str2, Arrays.asList(strArr));
    }

    public l(String str, String str2, Collection<String> collection) {
        this.name = str;
        this.defaultExtension = str2;
        this.extensions = collection;
    }
}
