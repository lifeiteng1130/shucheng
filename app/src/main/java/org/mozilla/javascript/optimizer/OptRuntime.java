package org.mozilla.javascript.optimizer;

import org.mozilla.javascript.ArrowFunction;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.ConsString;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.ES6Generator;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.JavaScriptException;
import org.mozilla.javascript.NativeFunction;
import org.mozilla.javascript.NativeGenerator;
import org.mozilla.javascript.NativeIterator;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: loaded from: classes3.dex */
public final class OptRuntime extends ScriptRuntime {
    public static final Double oneObj = Double.valueOf(1.0d);
    public static final Double minusOneObj = Double.valueOf(-1.0d);

    public static class GeneratorState {
        public static final String CLASS_NAME = "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState";
        public static final String resumptionPoint_NAME = "resumptionPoint";
        public static final String resumptionPoint_TYPE = "I";
        public static final String thisObj_NAME = "thisObj";
        public static final String thisObj_TYPE = "Lorg/mozilla/javascript/Scriptable;";
        public Object[] localsState;
        public int maxLocals;
        public int maxStack;
        public int resumptionPoint;
        public Object returnValue;
        public Object[] stackState;
        public Scriptable thisObj;

        public GeneratorState(Scriptable scriptable, int i2, int i3) {
            this.thisObj = scriptable;
            this.maxLocals = i2;
            this.maxStack = i3;
        }
    }

    public static Object add(Object obj, double d2) {
        if (obj instanceof Scriptable) {
            obj = ((Scriptable) obj).getDefaultValue(null);
        }
        return !(obj instanceof CharSequence) ? wrapDouble(ScriptRuntime.toNumber(obj) + d2) : new ConsString((CharSequence) obj, ScriptRuntime.toString(d2));
    }

    public static Function bindThis(NativeFunction nativeFunction, Context context, Scriptable scriptable, Scriptable scriptable2) {
        return new ArrowFunction(context, scriptable, nativeFunction, scriptable2);
    }

    public static Object call0(Callable callable, Scriptable scriptable, Context context, Scriptable scriptable2) {
        return callable.call(context, scriptable2, scriptable, ScriptRuntime.emptyArgs);
    }

    public static Object call1(Callable callable, Scriptable scriptable, Object obj, Context context, Scriptable scriptable2) {
        return callable.call(context, scriptable2, scriptable, new Object[]{obj});
    }

    public static Object call2(Callable callable, Scriptable scriptable, Object obj, Object obj2, Context context, Scriptable scriptable2) {
        return callable.call(context, scriptable2, scriptable, new Object[]{obj, obj2});
    }

    public static Object callN(Callable callable, Scriptable scriptable, Object[] objArr, Context context, Scriptable scriptable2) {
        return callable.call(context, scriptable2, scriptable, objArr);
    }

    public static Object callName(Object[] objArr, String str, Context context, Scriptable scriptable) {
        return ScriptRuntime.getNameFunctionAndThis(str, context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), objArr);
    }

    public static Object callName0(String str, Context context, Scriptable scriptable) {
        return ScriptRuntime.getNameFunctionAndThis(str, context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), ScriptRuntime.emptyArgs);
    }

    public static Object callProp0(Object obj, String str, Context context, Scriptable scriptable) {
        return ScriptRuntime.getPropFunctionAndThis(obj, str, context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), ScriptRuntime.emptyArgs);
    }

    public static Object callSpecial(Context context, Callable callable, Scriptable scriptable, Object[] objArr, Scriptable scriptable2, Scriptable scriptable3, int i2, String str, int i3) {
        return ScriptRuntime.callSpecial(context, callable, scriptable, objArr, scriptable2, scriptable3, i2, str, i3);
    }

    public static Scriptable createNativeGenerator(NativeFunction nativeFunction, Scriptable scriptable, Scriptable scriptable2, int i2, int i3) {
        GeneratorState generatorState = new GeneratorState(scriptable2, i2, i3);
        return Context.getCurrentContext().getLanguageVersion() >= 200 ? new ES6Generator(scriptable, nativeFunction, generatorState) : new NativeGenerator(scriptable, nativeFunction, generatorState);
    }

    private static int[] decodeIntArray(String str, int i2) {
        if (i2 == 0) {
            if (str == null) {
                return null;
            }
            throw new IllegalArgumentException();
        }
        if (str.length() != (i2 * 2) + 1 && str.charAt(0) != 1) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 != i2; i3++) {
            int i4 = (i3 * 2) + 1;
            iArr[i3] = str.charAt(i4 + 1) | (str.charAt(i4) << 16);
        }
        return iArr;
    }

    @Deprecated
    public static Object elemIncrDecr(Object obj, double d2, Context context, int i2) {
        return elemIncrDecr(obj, d2, context, ScriptRuntime.getTopCallScope(context), i2);
    }

    public static String encodeIntArray(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        char[] cArr = new char[(length * 2) + 1];
        cArr[0] = 1;
        for (int i2 = 0; i2 != length; i2++) {
            int i3 = iArr[i2];
            int i4 = (i2 * 2) + 1;
            cArr[i4] = (char) (i3 >>> 16);
            cArr[i4 + 1] = (char) i3;
        }
        return new String(cArr);
    }

    public static Object[] getGeneratorLocalsState(Object obj) {
        GeneratorState generatorState = (GeneratorState) obj;
        if (generatorState.localsState == null) {
            generatorState.localsState = new Object[generatorState.maxLocals];
        }
        return generatorState.localsState;
    }

    public static Object getGeneratorReturnValue(Object obj) {
        Object obj2 = ((GeneratorState) obj).returnValue;
        return obj2 == null ? Undefined.instance : obj2;
    }

    public static Object[] getGeneratorStackState(Object obj) {
        GeneratorState generatorState = (GeneratorState) obj;
        if (generatorState.stackState == null) {
            generatorState.stackState = new Object[generatorState.maxStack];
        }
        return generatorState.stackState;
    }

    public static void initFunction(NativeFunction nativeFunction, int i2, Scriptable scriptable, Context context) {
        ScriptRuntime.initFunction(context, scriptable, nativeFunction, i2, false);
    }

    public static void main(final Script script, final String[] strArr) {
        ContextFactory.getGlobal().call(new ContextAction() { // from class: k.d.b.i.a
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                String[] strArr2 = strArr;
                Script script2 = script;
                Double d2 = OptRuntime.oneObj;
                ScriptableObject global = ScriptRuntime.getGlobal(context);
                Object[] objArr = new Object[strArr2.length];
                System.arraycopy(strArr2, 0, objArr, 0, strArr2.length);
                global.defineProperty("arguments", context.newArray(global, objArr), 2);
                script2.exec(context, global);
                return null;
            }
        });
    }

    public static Scriptable newArrayLiteral(Object[] objArr, String str, int i2, Context context, Scriptable scriptable) {
        return ScriptRuntime.newArrayLiteral(objArr, decodeIntArray(str, i2), context, scriptable);
    }

    public static Object newObjectSpecial(Context context, Object obj, Object[] objArr, Scriptable scriptable, Scriptable scriptable2, int i2) {
        return ScriptRuntime.newSpecial(context, obj, objArr, scriptable, i2);
    }

    public static Object[] padStart(Object[] objArr, int i2) {
        Object[] objArr2 = new Object[objArr.length + i2];
        System.arraycopy(objArr, 0, objArr2, i2, objArr.length);
        return objArr2;
    }

    public static void setGeneratorReturnValue(Object obj, Object obj2) {
        ((GeneratorState) obj).returnValue = obj2;
    }

    public static void throwStopIteration(Object obj, Object obj2) {
        Object generatorReturnValue = getGeneratorReturnValue(obj2);
        throw new JavaScriptException(generatorReturnValue == Undefined.instance ? NativeIterator.getStopIterationObject((Scriptable) obj) : new NativeIterator.StopIteration(generatorReturnValue), "", 0);
    }

    public static Double wrapDouble(double d2) {
        if (d2 == 0.0d) {
            if (1.0d / d2 > 0.0d) {
                return ScriptRuntime.zeroObj;
            }
        } else {
            if (d2 == 1.0d) {
                return oneObj;
            }
            if (d2 == -1.0d) {
                return minusOneObj;
            }
            if (Double.isNaN(d2)) {
                return ScriptRuntime.NaNobj;
            }
        }
        return Double.valueOf(d2);
    }

    public static Object elemIncrDecr(Object obj, double d2, Context context, Scriptable scriptable, int i2) {
        return ScriptRuntime.elemIncrDecr(obj, Double.valueOf(d2), context, scriptable, i2);
    }

    public static Object add(double d2, Object obj) {
        if (obj instanceof Scriptable) {
            obj = ((Scriptable) obj).getDefaultValue(null);
        }
        if (!(obj instanceof CharSequence)) {
            return wrapDouble(ScriptRuntime.toNumber(obj) + d2);
        }
        return new ConsString(ScriptRuntime.toString(d2), (CharSequence) obj);
    }
}
