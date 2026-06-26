package javax.script;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CompiledScript {
    public Object eval(Bindings bindings) {
        ScriptContext context = getEngine().getContext();
        if (bindings != null) {
            SimpleScriptContext simpleScriptContext = new SimpleScriptContext();
            simpleScriptContext.setBindings(bindings, 100);
            simpleScriptContext.setBindings(context.getBindings(200), 200);
            simpleScriptContext.setWriter(context.getWriter());
            simpleScriptContext.setReader(context.getReader());
            simpleScriptContext.setErrorWriter(context.getErrorWriter());
            context = simpleScriptContext;
        }
        return eval(context);
    }

    public abstract Object eval(ScriptContext scriptContext);

    public abstract ScriptEngine getEngine();

    public Object eval() {
        return eval(getEngine().getContext());
    }
}
