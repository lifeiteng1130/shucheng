package i.a.b.m;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

/* JADX INFO: compiled from: BeansMapper.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> extends k<T> {
    public static k<Date> a = new a(null);

    /* JADX INFO: compiled from: BeansMapper.java */
    public class a extends i.a.b.m.a<Date> {
        public a(j jVar) {
            super(null);
        }

        @Override // i.a.b.m.k
        public Object convert(Object obj) {
            Date time;
            TreeMap<String, Integer> treeMap = i.a.a.e.a;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Date) {
                return (Date) obj;
            }
            if (obj instanceof Number) {
                return new Date(((Number) obj).longValue());
            }
            if (!(obj instanceof String)) {
                throw new RuntimeException("Primitive: Can not convert " + obj.getClass().getName() + " to int");
            }
            StringTokenizer stringTokenizer = new StringTokenizer((String) obj, " -/:,.+");
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            String strNextToken = stringTokenizer.nextToken();
            if (strNextToken.length() == 4 && Character.isDigit(strNextToken.charAt(0))) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(RecyclerView.MAX_SCROLL_DURATION, 0, 0, 0, 0, 0);
                gregorianCalendar.setTimeInMillis(0L);
                gregorianCalendar.set(1, Integer.parseInt(strNextToken));
                if (stringTokenizer.hasMoreTokens()) {
                    gregorianCalendar.set(2, i.a.a.e.e(stringTokenizer.nextToken()).intValue());
                    if (stringTokenizer.hasMoreTokens()) {
                        String strNextToken2 = stringTokenizer.nextToken();
                        if (!Character.isDigit(strNextToken2.charAt(0))) {
                            time = gregorianCalendar.getTime();
                        } else if (strNextToken2.length() == 5 && strNextToken2.charAt(2) == 'T') {
                            gregorianCalendar.set(5, Integer.parseInt(strNextToken2.substring(0, 2)));
                            time = i.a.a.e.a(stringTokenizer, gregorianCalendar, strNextToken2.substring(3));
                        } else {
                            gregorianCalendar.set(5, Integer.parseInt(strNextToken2));
                            time = i.a.a.e.a(stringTokenizer, gregorianCalendar, null);
                        }
                    } else {
                        time = gregorianCalendar.getTime();
                    }
                } else {
                    time = gregorianCalendar.getTime();
                }
                return time;
            }
            if (i.a.a.e.f6348b.containsKey(strNextToken)) {
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                strNextToken = stringTokenizer.nextToken();
            }
            if (!i.a.a.e.a.containsKey(strNextToken)) {
                if (!Character.isDigit(strNextToken.charAt(0))) {
                    return null;
                }
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(RecyclerView.MAX_SCROLL_DURATION, 0, 0, 0, 0, 0);
                gregorianCalendar2.set(5, Integer.parseInt(strNextToken));
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                gregorianCalendar2.set(2, i.a.a.e.e(stringTokenizer.nextToken()).intValue());
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                gregorianCalendar2.set(1, i.a.a.e.d(stringTokenizer.nextToken()));
                return i.a.a.e.a(stringTokenizer, gregorianCalendar2, null);
            }
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar(RecyclerView.MAX_SCROLL_DURATION, 0, 0, 0, 0, 0);
            Integer num = i.a.a.e.a.get(strNextToken);
            if (num == null) {
                throw new NullPointerException("can not parse " + strNextToken + " as month");
            }
            gregorianCalendar3.set(2, num.intValue());
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            gregorianCalendar3.set(5, Integer.parseInt(stringTokenizer.nextToken()));
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            String strNextToken3 = stringTokenizer.nextToken();
            if (Character.isLetter(strNextToken3.charAt(0))) {
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                strNextToken3 = stringTokenizer.nextToken();
            }
            if (strNextToken3.length() == 4) {
                gregorianCalendar3.set(1, i.a.a.e.d(strNextToken3));
            } else if (strNextToken3.length() == 2) {
                return i.a.a.e.b(stringTokenizer, gregorianCalendar3, strNextToken3);
            }
            return i.a.a.e.a(stringTokenizer, gregorianCalendar3, null);
        }
    }

    /* JADX INFO: renamed from: i.a.b.m.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BeansMapper.java */
    public static class C0187b<T> extends k<T> {
        public final Class<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i.a.a.b<T> f6404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HashMap<String, i.a.a.a> f6405c;

        public C0187b(j jVar, Class<T> cls) {
            super(jVar);
            this.a = cls;
            i.a.a.b<T> bVarC = i.a.a.b.c(cls, i.a.b.h.a);
            this.f6404b = bVarC;
            this.f6405c = bVarC.f6337b;
        }

        @Override // i.a.b.m.k
        public Object createObject() {
            return this.f6404b.d();
        }

        @Override // i.a.b.m.k
        public Type getType(String str) {
            return this.f6405c.get(str).f6335f;
        }

        @Override // i.a.b.m.k
        public Object getValue(Object obj, String str) {
            i.a.a.b<T> bVar = this.f6404b;
            i.a.a.a aVar = bVar.f6337b.get(str);
            return bVar.b(obj, aVar == null ? -1 : aVar.f6333d);
        }

        @Override // i.a.b.m.k
        public void setValue(Object obj, String str, Object obj2) {
            i.a.a.b<T> bVar = this.f6404b;
            i.a.a.a aVar = bVar.f6337b.get(str);
            int i2 = aVar == null ? -1 : aVar.f6333d;
            if (i2 != -1) {
                bVar.e(obj, i2, obj2);
                return;
            }
            throw new i.a.a.i.a(String.valueOf(str) + " in " + obj.getClass() + " to put value : " + obj2);
        }

        @Override // i.a.b.m.k
        public k<?> startArray(String str) {
            i.a.a.a aVar = this.f6405c.get(str);
            if (aVar != null) {
                return this.base.b(aVar.f6335f);
            }
            throw new RuntimeException("Can not find Array '" + str + "' field in " + this.a);
        }

        @Override // i.a.b.m.k
        public k<?> startObject(String str) {
            i.a.a.a aVar = this.f6405c.get(str);
            if (aVar != null) {
                return this.base.b(aVar.f6335f);
            }
            throw new RuntimeException("Can not find Object '" + str + "' field in " + this.a);
        }
    }
}
