package org.mozilla.javascript;

import java.util.EnumMap;

/* JADX INFO: loaded from: classes3.dex */
public class TopLevel extends IdScriptableObject {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -4648046356662472260L;
    private EnumMap<Builtins, BaseFunction> ctors;
    private EnumMap<NativeErrors, BaseFunction> errors;

    public enum Builtins {
        Object,
        Array,
        Function,
        String,
        Number,
        Boolean,
        RegExp,
        Error,
        Symbol,
        GeneratorFunction
    }

    public enum NativeErrors {
        Error,
        EvalError,
        RangeError,
        ReferenceError,
        SyntaxError,
        TypeError,
        URIError,
        InternalError,
        JavaException
    }

    public static Function getBuiltinCtor(Context context, Scriptable scriptable, Builtins builtins) {
        BaseFunction builtinCtor;
        if (!(scriptable instanceof TopLevel) || (builtinCtor = ((TopLevel) scriptable).getBuiltinCtor(builtins)) == null) {
            return ScriptRuntime.getExistingCtor(context, scriptable, builtins == Builtins.GeneratorFunction ? BaseFunction.GENERATOR_FUNCTION_CLASS : builtins.name());
        }
        return builtinCtor;
    }

    public static Scriptable getBuiltinPrototype(Scriptable scriptable, Builtins builtins) {
        Scriptable builtinPrototype;
        if (!(scriptable instanceof TopLevel) || (builtinPrototype = ((TopLevel) scriptable).getBuiltinPrototype(builtins)) == null) {
            return ScriptableObject.getClassPrototype(scriptable, builtins == Builtins.GeneratorFunction ? BaseFunction.GENERATOR_FUNCTION_CLASS : builtins.name());
        }
        return builtinPrototype;
    }

    public static Function getNativeErrorCtor(Context context, Scriptable scriptable, NativeErrors nativeErrors) {
        BaseFunction nativeErrorCtor;
        return (!(scriptable instanceof TopLevel) || (nativeErrorCtor = ((TopLevel) scriptable).getNativeErrorCtor(nativeErrors)) == null) ? ScriptRuntime.getExistingCtor(context, scriptable, nativeErrors.name()) : nativeErrorCtor;
    }

    public void cacheBuiltins(Scriptable scriptable, boolean z) {
        this.ctors = new EnumMap<>(Builtins.class);
        Builtins[] builtinsArrValues = Builtins.values();
        for (int i2 = 0; i2 < 10; i2++) {
            Builtins builtins = builtinsArrValues[i2];
            Object property = ScriptableObject.getProperty(this, builtins.name());
            if (property instanceof BaseFunction) {
                this.ctors.put(builtins, (BaseFunction) property);
            } else if (builtins == Builtins.GeneratorFunction) {
                this.ctors.put(builtins, (BaseFunction) BaseFunction.initAsGeneratorFunction(scriptable, z));
            }
        }
        this.errors = new EnumMap<>(NativeErrors.class);
        NativeErrors[] nativeErrorsArrValues = NativeErrors.values();
        for (int i3 = 0; i3 < 9; i3++) {
            NativeErrors nativeErrors = nativeErrorsArrValues[i3];
            Object property2 = ScriptableObject.getProperty(this, nativeErrors.name());
            if (property2 instanceof BaseFunction) {
                this.errors.put(nativeErrors, (BaseFunction) property2);
            }
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "global";
    }

    public BaseFunction getNativeErrorCtor(NativeErrors nativeErrors) {
        EnumMap<NativeErrors, BaseFunction> enumMap = this.errors;
        if (enumMap != null) {
            return enumMap.get(nativeErrors);
        }
        return null;
    }

    public BaseFunction getBuiltinCtor(Builtins builtins) {
        EnumMap<Builtins, BaseFunction> enumMap = this.ctors;
        if (enumMap != null) {
            return enumMap.get(builtins);
        }
        return null;
    }

    public Scriptable getBuiltinPrototype(Builtins builtins) {
        BaseFunction builtinCtor = getBuiltinCtor(builtins);
        Object prototypeProperty = builtinCtor != null ? builtinCtor.getPrototypeProperty() : null;
        if (prototypeProperty instanceof Scriptable) {
            return (Scriptable) prototypeProperty;
        }
        return null;
    }
}
