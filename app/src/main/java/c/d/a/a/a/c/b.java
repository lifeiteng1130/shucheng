package c.d.a.a.a.c;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: DictionaryContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, a> f820b = new HashMap(8, 1.0f);

    public static b b() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public a a(String str) {
        a aVarA;
        a aVar = this.f820b.get(str);
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            a aVar2 = this.f820b.get(str);
            if (aVar2 != null) {
                return aVar2;
            }
            byte b2 = -1;
            switch (str.hashCode()) {
                case 112181:
                    if (str.equals("s2t")) {
                        b2 = 0;
                    }
                    break;
                case 113141:
                    if (str.equals("t2s")) {
                        b2 = 3;
                    }
                    break;
                case 3202756:
                    if (str.equals("hk2s")) {
                        b2 = 4;
                    }
                    break;
                case 3477346:
                    if (str.equals("s2hk")) {
                        b2 = 1;
                    }
                    break;
                case 3477730:
                    if (str.equals("s2tw")) {
                        b2 = 2;
                    }
                    break;
                case 3571780:
                    if (str.equals("tw2s")) {
                        b2 = 5;
                    }
                    break;
            }
            if (b2 == 0) {
                aVarA = c.a("tc/s2t.txt", false);
            } else if (b2 == 1) {
                aVarA = c.b(a("s2t"), "tc/t2hk.txt", false);
            } else if (b2 == 2) {
                aVarA = c.b(a("s2t"), "tc/t2tw.txt", false);
            } else if (b2 == 3) {
                aVarA = c.a("tc/t2s.txt", false);
            } else if (b2 == 4) {
                aVarA = c.b(a("t2s"), "tc/t2hk.txt", true);
            } else {
                if (b2 != 5) {
                    throw new IllegalArgumentException("暂不支持转化方式" + str);
                }
                aVarA = c.b(a("t2s"), "tc/t2tw.txt", true);
            }
            this.f820b.put(str, aVarA);
            return aVarA;
        }
    }
}
