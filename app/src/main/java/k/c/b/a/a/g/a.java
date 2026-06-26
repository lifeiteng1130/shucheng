package k.c.b.a.a.g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.c.b.a.a.c;
import k.c.b.a.a.d;
import k.c.b.a.a.e;
import k.c.c.h;
import k.c.c.n;
import k.c.e.g.f;

/* JADX INFO: compiled from: TableBlockParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends k.c.e.g.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c.a> f8636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f8637d;
    public final k.c.b.a.a.a a = new k.c.b.a.a.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CharSequence> f8635b = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8638e = true;

    /* JADX INFO: compiled from: TableBlockParser.java */
    public static class b extends k.c.e.g.b {
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
        
            if (r7 != 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
        
            if (r2.isEmpty() != false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
        
            if (r8 != ':') goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
        
            r4 = r4 + 1;
            r7 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
        
            r7 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0072, code lost:
        
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
        
            if (r4 >= r0.length()) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
        
            if (r0.charAt(r4) != '-') goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x007f, code lost:
        
            r4 = r4 + 1;
            r8 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0083, code lost:
        
            if (r8 != false) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x008a, code lost:
        
            if (r4 >= r0.length()) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0090, code lost:
        
            if (r0.charAt(r4) != ':') goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0092, code lost:
        
            r4 = r4 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0095, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0096, code lost:
        
            if (r7 == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0098, code lost:
        
            if (r6 == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x009a, code lost:
        
            r6 = k.c.b.a.a.c.a.CENTER;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x009d, code lost:
        
            if (r7 == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x009f, code lost:
        
            r6 = k.c.b.a.a.c.a.LEFT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a2, code lost:
        
            if (r6 == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a4, code lost:
        
            r6 = k.c.b.a.a.c.a.RIGHT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a7, code lost:
        
            r6 = null;
         */
        @Override // k.c.e.g.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public k.c.c.d a(k.c.e.g.f r13, k.c.e.g.e r14) {
            /*
                Method dump skipped, instruction units count: 225
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: k.c.b.a.a.g.a.b.a(k.c.e.g.f, k.c.e.g.e):k.c.c.d");
        }
    }

    public a(List list, List list2, C0229a c0229a) {
        this.f8636c = list;
        this.f8637d = list2;
    }

    public static List<String> j(CharSequence charSequence) {
        String strTrim = charSequence.toString().trim();
        if (strTrim.startsWith("|")) {
            strTrim = strTrim.substring(1);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < strTrim.length()) {
            char cCharAt = strTrim.charAt(i2);
            if (cCharAt == '\\') {
                int i3 = i2 + 1;
                if (i3 >= strTrim.length() || strTrim.charAt(i3) != '|') {
                    sb.append('\\');
                } else {
                    sb.append('|');
                    i2 = i3;
                }
            } else if (cCharAt != '|') {
                sb.append(cCharAt);
            } else {
                arrayList.add(sb.toString());
                sb.setLength(0);
            }
            i2++;
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public void a(k.c.e.a aVar) {
        int size = this.f8637d.size();
        d dVar = new d();
        this.a.b(dVar);
        e eVar = new e();
        dVar.b(eVar);
        for (int i2 = 0; i2 < size; i2++) {
            c cVarI = i(this.f8637d.get(i2), i2, aVar);
            cVarI.f8633f = true;
            eVar.b(cVarI);
        }
        k.c.b.a.a.b bVar = null;
        Iterator<CharSequence> it = this.f8635b.iterator();
        while (it.hasNext()) {
            List<String> listJ = j(it.next());
            e eVar2 = new e();
            int i3 = 0;
            while (i3 < size) {
                ArrayList arrayList = (ArrayList) listJ;
                eVar2.b(i(i3 < arrayList.size() ? (String) arrayList.get(i3) : "", i3, aVar));
                i3++;
            }
            if (bVar == null) {
                bVar = new k.c.b.a.a.b();
                this.a.b(bVar);
            }
            bVar.b(eVar2);
        }
    }

    @Override // k.c.e.g.c
    public k.c.c.b c(f fVar) {
        if (((h) fVar).f8659c.toString().contains("|")) {
            return k.c.c.b.b(((h) fVar).f8660d);
        }
        return null;
    }

    @Override // k.c.e.g.c
    public k.c.d.a g() {
        return this.a;
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public void h(CharSequence charSequence) {
        if (this.f8638e) {
            this.f8638e = false;
        } else {
            this.f8635b.add(charSequence);
        }
    }

    public final c i(String str, int i2, k.c.e.a aVar) {
        c cVar = new c();
        if (i2 < this.f8636c.size()) {
            cVar.f8634g = this.f8636c.get(i2);
        }
        ((n) aVar).f(str.trim(), cVar);
        return cVar;
    }
}
