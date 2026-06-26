package javax.script;

import java.io.Reader;

/* JADX INFO: loaded from: classes3.dex */
public interface Compilable {
    CompiledScript compile(Reader reader);

    CompiledScript compile(String str);
}
