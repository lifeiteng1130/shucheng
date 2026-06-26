package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

/* JADX INFO: compiled from: Global.java */
/* JADX INFO: loaded from: classes3.dex */
public class Runner implements Runnable, ContextAction<Object> {
    private Object[] args;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function f8940f;
    public ContextFactory factory;
    private Script s;
    private Scriptable scope;

    public Runner(Scriptable scriptable, Function function, Object[] objArr) {
        this.scope = scriptable;
        this.f8940f = function;
        this.args = objArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.factory.call(this);
    }

    @Override // org.mozilla.javascript.ContextAction
    public Object run(Context context) {
        Function function = this.f8940f;
        if (function == null) {
            return this.s.exec(context, this.scope);
        }
        Scriptable scriptable = this.scope;
        return function.call(context, scriptable, scriptable, this.args);
    }

    public Runner(Scriptable scriptable, Script script) {
        this.scope = scriptable;
        this.s = script;
    }
}
