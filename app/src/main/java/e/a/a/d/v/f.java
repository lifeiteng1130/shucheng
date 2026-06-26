package e.a.a.d.v;

import e.a.a.h.x;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.CookieDao;
import io.legado.app.data.entities.Cookie;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CookieStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    @NotNull
    public static final f a = new f();

    @NotNull
    public Map<String, String> a(@NotNull String str) {
        Collection collectionC;
        Collection collectionC2;
        f.c0.c.j.e(str, "cookie");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (f.h0.k.s(str)) {
            return linkedHashMap;
        }
        List<String> listSplit = new f.h0.g(";").split(str, 0);
        if (listSplit.isEmpty()) {
            collectionC = f.x.i.INSTANCE;
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    collectionC = f.x.e.C(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            collectionC = f.x.i.INSTANCE;
        }
        Object[] array = collectionC.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str2 = strArr[i2];
            i2++;
            List<String> listSplit2 = new f.h0.g("=").split(str2, 0);
            if (listSplit2.isEmpty()) {
                collectionC2 = f.x.i.INSTANCE;
            } else {
                ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                while (listIterator2.hasPrevious()) {
                    if (!(listIterator2.previous().length() == 0)) {
                        collectionC2 = f.x.e.C(listSplit2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
                collectionC2 = f.x.i.INSTANCE;
            }
            Object[] array2 = collectionC2.toArray(new String[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr2 = (String[]) array2;
            if (strArr2.length != 1) {
                String str3 = strArr2[0];
                int length2 = str3.length() - 1;
                int i3 = 0;
                boolean z = false;
                while (i3 <= length2) {
                    boolean z2 = f.c0.c.j.g(str3.charAt(!z ? i3 : length2), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length2--;
                    } else if (z2) {
                        i3++;
                    } else {
                        z = true;
                    }
                }
                String string = str3.subSequence(i3, length2 + 1).toString();
                String str4 = strArr2[1];
                if (!(!f.h0.k.s(str4))) {
                    int length3 = str4.length() - 1;
                    int i4 = 0;
                    boolean z3 = false;
                    while (i4 <= length3) {
                        boolean z4 = f.c0.c.j.g(str4.charAt(!z3 ? i4 : length3), 32) <= 0;
                        if (z3) {
                            if (!z4) {
                                break;
                            }
                            length3--;
                        } else if (z4) {
                            i4++;
                        } else {
                            z3 = true;
                        }
                    }
                    if (f.c0.c.j.a(str4.subSequence(i4, length3 + 1).toString(), "null")) {
                    }
                }
                int length4 = str4.length() - 1;
                int i5 = 0;
                boolean z5 = false;
                while (i5 <= length4) {
                    boolean z6 = f.c0.c.j.g(str4.charAt(!z5 ? i5 : length4), 32) <= 0;
                    if (z5) {
                        if (!z6) {
                            break;
                        }
                        length4--;
                    } else if (z6) {
                        i5++;
                    } else {
                        z5 = true;
                    }
                }
                linkedHashMap.put(string, str4.subSequence(i5, length4 + 1).toString());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public String b(@NotNull String str) {
        String cookie;
        f.c0.c.j.e(str, "url");
        CookieDao cookieDao = AppDatabaseKt.getAppDb().getCookieDao();
        x xVar = x.a;
        Cookie cookie2 = cookieDao.get(x.d(str));
        return (cookie2 == null || (cookie = cookie2.getCookie()) == null) ? "" : cookie;
    }
}
