package c.i.a.a;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;

/* JADX INFO: compiled from: ScriptEngineFactoryBase.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements ScriptEngineFactory {
    @Override // javax.script.ScriptEngineFactory
    public String getEngineName() {
        return (String) getParameter(ScriptEngine.ENGINE);
    }

    @Override // javax.script.ScriptEngineFactory
    public String getEngineVersion() {
        return (String) getParameter(ScriptEngine.ENGINE_VERSION);
    }

    @Override // javax.script.ScriptEngineFactory
    public String getLanguageName() {
        return (String) getParameter(ScriptEngine.LANGUAGE);
    }

    @Override // javax.script.ScriptEngineFactory
    public String getLanguageVersion() {
        return (String) getParameter(ScriptEngine.LANGUAGE_VERSION);
    }

    public String getName() {
        return (String) getParameter(ScriptEngine.NAME);
    }
}
