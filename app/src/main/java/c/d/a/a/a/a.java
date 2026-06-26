package c.d.a.a.a;

/* JADX INFO: compiled from: Trie.java */
/* JADX INFO: loaded from: classes.dex */
public class a<T> {
    public b<T> a = new b<>(' ');

    public void a(String str, T t) {
        if (str == null) {
            return;
        }
        char[] charArray = str.toCharArray();
        if (charArray.length < 1) {
            return;
        }
        b<T> bVar = this.a;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            b<T> bVar2 = bVar.f815c.get(Character.valueOf(charArray[i2]));
            if (bVar2 == null) {
                char c2 = charArray[i2];
                b<T> bVar3 = new b<>(c2);
                bVar3.a = bVar.a + 1;
                bVar.f815c.put(Character.valueOf(c2), bVar3);
                bVar = bVar3;
            } else {
                bVar = bVar2;
            }
        }
        bVar.f816d = true;
        bVar.f817e = t;
    }
}
