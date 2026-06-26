package c.d.a.a.a.c;

import java.util.Map;

/* JADX INFO: compiled from: SecondParserDictionary.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f821d;

    public d(a aVar, Map<Character, Character> map, c.d.a.a.a.a<String> aVar2, int i2) {
        super(map, aVar2, i2);
        this.f821d = aVar;
    }

    @Override // c.d.a.a.a.c.a
    public String a(String str) {
        return super.a(this.f821d.a(str));
    }
}
