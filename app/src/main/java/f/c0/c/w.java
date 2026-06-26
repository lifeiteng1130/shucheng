package f.c0.c;

import kotlin.SinceKotlin;

/* JADX INFO: compiled from: ReflectionFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class w {
    @SinceKotlin(version = "1.3")
    public String a(g gVar) {
        String string = gVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
