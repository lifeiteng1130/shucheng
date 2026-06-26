package com.sun.script.javascript;

import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.JavaScriptException;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;

/* JADX INFO: loaded from: classes.dex */
public final class RhinoCompiledScript extends CompiledScript {
    private RhinoScriptEngine engine;
    private Script script;

    public RhinoCompiledScript(RhinoScriptEngine rhinoScriptEngine, Script script) {
        this.engine = rhinoScriptEngine;
        this.script = script;
    }

    @Override // javax.script.CompiledScript
    public Object eval(ScriptContext scriptContext) {
        try {
            try {
                return this.engine.unwrapReturnValue(this.script.exec(RhinoScriptEngine.enterContext(), this.engine.getRuntimeScope(scriptContext)));
            } catch (RhinoException e2) {
                int iLineNumber = e2.lineNumber();
                if (iLineNumber == 0) {
                    iLineNumber = -1;
                }
                ScriptException scriptException = new ScriptException(e2 instanceof JavaScriptException ? String.valueOf(((JavaScriptException) e2).getValue()) : e2.toString(), e2.sourceName(), iLineNumber);
                scriptException.initCause(e2);
                throw scriptException;
            }
        } finally {
            Context.exit();
        }
    }

    @Override // javax.script.CompiledScript
    public ScriptEngine getEngine() {
        return this.engine;
    }
}
