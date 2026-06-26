package javax.script;

import java.io.Reader;
import java.io.Writer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ScriptContext {
    public static final int ENGINE_SCOPE = 100;
    public static final int GLOBAL_SCOPE = 200;

    Object getAttribute(String str);

    Object getAttribute(String str, int i2);

    int getAttributesScope(String str);

    Bindings getBindings(int i2);

    Writer getErrorWriter();

    Reader getReader();

    List<Integer> getScopes();

    Writer getWriter();

    Object removeAttribute(String str, int i2);

    void setAttribute(String str, Object obj, int i2);

    void setBindings(Bindings bindings, int i2);

    void setErrorWriter(Writer writer);

    void setReader(Reader reader);

    void setWriter(Writer writer);
}
