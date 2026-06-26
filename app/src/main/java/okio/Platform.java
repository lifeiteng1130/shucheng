package okio;

import f.c0.c.j;
import f.h0.a;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-Platform, reason: invalid class name */
/* JADX INFO: compiled from: -Platform.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f*\n\u0010\u000e\"\u00020\r2\u00020\r*\n\u0010\u0010\"\u00020\u000f2\u00020\u000f*\n\u0010\u0012\"\u00020\u00112\u00020\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"", "", "toUtf8String", "([B)Ljava/lang/String;", "asUtf8ToByteArray", "(Ljava/lang/String;)[B", "R", "", "lock", "Lkotlin/Function0;", "block", "synchronized", "(Ljava/lang/Object;Lf/c0/b/a;)Ljava/lang/Object;", "Ljava/lang/ArrayIndexOutOfBoundsException;", "ArrayIndexOutOfBoundsException", "Ljava/io/EOFException;", "EOFException", "Ljava/io/IOException;", "IOException", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "-Platform")
public final class Platform {
    @NotNull
    public static final byte[] asUtf8ToByteArray(@NotNull String str) {
        j.e(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(a.a);
        j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m168synchronized(@NotNull Object obj, @NotNull f.c0.b.a<? extends R> aVar) {
        R rInvoke;
        j.e(obj, "lock");
        j.e(aVar, "block");
        synchronized (obj) {
            rInvoke = aVar.invoke();
        }
        return rInvoke;
    }

    @NotNull
    public static final String toUtf8String(@NotNull byte[] bArr) {
        j.e(bArr, "$this$toUtf8String");
        return new String(bArr, a.a);
    }
}
