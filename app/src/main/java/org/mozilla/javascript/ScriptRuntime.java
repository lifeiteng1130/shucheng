package org.mozilla.javascript;

import c.a.a.a.a;
import com.uc.crashsdk.export.LogType;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.mozilla.javascript.NativeIterator;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.typedarrays.NativeArrayBuffer;
import org.mozilla.javascript.typedarrays.NativeDataView;
import org.mozilla.javascript.v8dtoa.DoubleConversion;
import org.mozilla.javascript.v8dtoa.FastDtoa;
import org.mozilla.javascript.xml.XMLLib;
import org.mozilla.javascript.xml.XMLObject;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: classes3.dex */
public class ScriptRuntime {
    private static final String DEFAULT_NS_TAG = "__default_namespace__";
    public static final int ENUMERATE_ARRAY = 2;
    public static final int ENUMERATE_ARRAY_NO_ITERATOR = 5;
    public static final int ENUMERATE_KEYS = 0;
    public static final int ENUMERATE_KEYS_NO_ITERATOR = 3;
    public static final int ENUMERATE_VALUES = 1;
    public static final int ENUMERATE_VALUES_IN_ORDER = 6;
    public static final int ENUMERATE_VALUES_NO_ITERATOR = 4;
    public static final double NaN = Double.NaN;
    public static final Class<?> BooleanClass = Kit.classOrNull("java.lang.Boolean");
    public static final Class<?> ByteClass = Kit.classOrNull("java.lang.Byte");
    public static final Class<?> CharacterClass = Kit.classOrNull("java.lang.Character");
    public static final Class<?> ClassClass = Kit.classOrNull("java.lang.Class");
    public static final Class<?> DoubleClass = Kit.classOrNull("java.lang.Double");
    public static final Class<?> FloatClass = Kit.classOrNull("java.lang.Float");
    public static final Class<?> IntegerClass = Kit.classOrNull("java.lang.Integer");
    public static final Class<?> LongClass = Kit.classOrNull("java.lang.Long");
    public static final Class<?> NumberClass = Kit.classOrNull("java.lang.Number");
    public static final Class<?> ObjectClass = Kit.classOrNull("java.lang.Object");
    public static final Class<?> ShortClass = Kit.classOrNull("java.lang.Short");
    public static final Class<?> StringClass = Kit.classOrNull("java.lang.String");
    public static final Class<?> DateClass = Kit.classOrNull("java.util.Date");
    public static final Class<?> ContextClass = Kit.classOrNull("org.mozilla.javascript.Context");
    public static final Class<?> ContextFactoryClass = Kit.classOrNull("org.mozilla.javascript.ContextFactory");
    public static final Class<?> FunctionClass = Kit.classOrNull("org.mozilla.javascript.Function");
    public static final Class<?> ScriptableObjectClass = Kit.classOrNull("org.mozilla.javascript.ScriptableObject");
    public static final Class<Scriptable> ScriptableClass = Scriptable.class;
    private static final Object LIBRARY_SCOPE_KEY = "LIBRARY_SCOPE";
    public static final Double NaNobj = Double.valueOf(Double.NaN);
    public static final double negativeZero = Double.longBitsToDouble(Long.MIN_VALUE);
    public static final Double zeroObj = Double.valueOf(0.0d);
    public static final Double negativeZeroObj = Double.valueOf(-0.0d);
    public static final MessageProvider messageProvider = new DefaultMessageProvider();
    public static final Object[] emptyArgs = new Object[0];
    public static final String[] emptyStrings = new String[0];

    public static class DefaultMessageProvider implements MessageProvider {
        private DefaultMessageProvider() {
        }

        @Override // org.mozilla.javascript.ScriptRuntime.MessageProvider
        public String getMessage(String str, Object[] objArr) {
            Context currentContext = Context.getCurrentContext();
            try {
                return new MessageFormat(ResourceBundle.getBundle("org.mozilla.javascript.resources.Messages", currentContext != null ? currentContext.getLocale() : Locale.getDefault()).getString(str)).format(objArr);
            } catch (MissingResourceException unused) {
                throw new RuntimeException(a.i("no message resource found for message property ", str));
            }
        }
    }

    public static class IdEnumeration implements Serializable {
        private static final long serialVersionUID = 1;
        public Object currentId;
        public boolean enumNumbers;
        public int enumType;
        public Object[] ids;
        public int index;
        public Scriptable iterator;
        public Scriptable obj;
        public ObjToIntMap used;

        private IdEnumeration() {
        }
    }

    public interface MessageProvider {
        String getMessage(String str, Object[] objArr);
    }

    public static class NoSuchMethodShim implements Callable {
        public String methodName;
        public Callable noSuchMethodMethod;

        public NoSuchMethodShim(Callable callable, String str) {
            this.noSuchMethodMethod = callable;
            this.methodName = str;
        }

        @Override // org.mozilla.javascript.Callable
        public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            return this.noSuchMethodMethod.call(context, scriptable, scriptable2, new Object[]{this.methodName, ScriptRuntime.newArrayLiteral(objArr, null, context, scriptable)});
        }
    }

    public static Object add(Object obj, Object obj2, Context context) {
        Object objAddValues;
        Object objAddValues2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return wrapNumber(((Number) obj2).doubleValue() + ((Number) obj).doubleValue());
        }
        if ((obj instanceof XMLObject) && (objAddValues2 = ((XMLObject) obj).addValues(context, true, obj2)) != Scriptable.NOT_FOUND) {
            return objAddValues2;
        }
        if ((obj2 instanceof XMLObject) && (objAddValues = ((XMLObject) obj2).addValues(context, false, obj)) != Scriptable.NOT_FOUND) {
            return objAddValues;
        }
        if ((obj instanceof Symbol) || (obj2 instanceof Symbol)) {
            throw typeError0("msg.not.a.number");
        }
        if (obj instanceof Scriptable) {
            obj = ((Scriptable) obj).getDefaultValue(null);
        }
        if (obj2 instanceof Scriptable) {
            obj2 = ((Scriptable) obj2).getDefaultValue(null);
        }
        return ((obj instanceof CharSequence) || (obj2 instanceof CharSequence)) ? new ConsString(toCharSequence(obj), toCharSequence(obj2)) : ((obj instanceof Number) && (obj2 instanceof Number)) ? wrapNumber(((Number) obj2).doubleValue() + ((Number) obj).doubleValue()) : wrapNumber(toNumber(obj2) + toNumber(obj));
    }

    public static void addInstructionCount(Context context, int i2) {
        int i3 = context.instructionCount + i2;
        context.instructionCount = i3;
        if (i3 > context.instructionThreshold) {
            context.observeInstructionCount(i3);
            context.instructionCount = 0;
        }
    }

    public static Object applyOrCall(boolean z, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object[] applyArguments;
        int length = objArr.length;
        Callable callable = getCallable(scriptable2);
        Scriptable topCallScope = length != 0 ? (!context.hasFeature(15) && objArr[0] == Undefined.instance) ? Undefined.SCRIPTABLE_UNDEFINED : toObjectOrNull(context, objArr[0], scriptable) : null;
        if (topCallScope == null && context.hasFeature(15)) {
            topCallScope = getTopCallScope(context);
        }
        if (z) {
            applyArguments = length <= 1 ? emptyArgs : getApplyArguments(context, objArr[1]);
        } else if (length <= 1) {
            applyArguments = emptyArgs;
        } else {
            int i2 = length - 1;
            applyArguments = new Object[i2];
            System.arraycopy(objArr, 1, applyArguments, 0, i2);
        }
        return callable.call(context, scriptable, topCallScope, applyArguments);
    }

    public static Scriptable bind(Context context, Scriptable scriptable, String str) {
        Scriptable parentScope = scriptable.getParentScope();
        XMLObject xMLObject = null;
        if (parentScope != null) {
            XMLObject xMLObject2 = null;
            while (true) {
                if (!(scriptable instanceof NativeWith)) {
                    while (!ScriptableObject.hasProperty(scriptable, str)) {
                        Scriptable parentScope2 = parentScope.getParentScope();
                        if (parentScope2 != null) {
                            Scriptable scriptable2 = parentScope;
                            parentScope = parentScope2;
                            scriptable = scriptable2;
                        }
                    }
                    return scriptable;
                }
                Scriptable prototype = scriptable.getPrototype();
                if (prototype instanceof XMLObject) {
                    XMLObject xMLObject3 = (XMLObject) prototype;
                    if (xMLObject3.has(context, str)) {
                        return xMLObject3;
                    }
                    if (xMLObject2 == null) {
                        xMLObject2 = xMLObject3;
                    }
                } else if (ScriptableObject.hasProperty(prototype, str)) {
                    return prototype;
                }
                Scriptable parentScope3 = parentScope.getParentScope();
                if (parentScope3 == null) {
                    break;
                }
                Scriptable scriptable3 = parentScope;
                parentScope = parentScope3;
                scriptable = scriptable3;
            }
            scriptable = parentScope;
            xMLObject = xMLObject2;
        }
        if (context.useDynamicScope) {
            scriptable = checkDynamicScope(context.topCallScope, scriptable);
        }
        return ScriptableObject.hasProperty(scriptable, str) ? scriptable : xMLObject;
    }

    @Deprecated
    public static Object call(Context context, Object obj, Object obj2, Object[] objArr, Scriptable scriptable) {
        if (!(obj instanceof Function)) {
            throw notFunctionError(toString(obj));
        }
        Function function = (Function) obj;
        Scriptable objectOrNull = toObjectOrNull(context, obj2, scriptable);
        if (objectOrNull != null) {
            return function.call(context, scriptable, objectOrNull, objArr);
        }
        throw undefCallError(null, "function");
    }

    public static Object callIterator(Object obj, Context context, Scriptable scriptable) {
        return getElemFunctionAndThis(obj, SymbolKey.ITERATOR, context, scriptable).call(context, scriptable, lastStoredScriptable(context), emptyArgs);
    }

    public static Ref callRef(Callable callable, Scriptable scriptable, Object[] objArr, Context context) {
        if (!(callable instanceof RefCallable)) {
            throw constructError("ReferenceError", getMessage1("msg.no.ref.from.function", toString(callable)));
        }
        RefCallable refCallable = (RefCallable) callable;
        Ref refRefCall = refCallable.refCall(context, scriptable, objArr);
        if (refRefCall != null) {
            return refRefCall;
        }
        throw new IllegalStateException(refCallable.getClass().getName() + ".refCall() returned null");
    }

    public static Object callSpecial(Context context, Callable callable, Scriptable scriptable, Object[] objArr, Scriptable scriptable2, Scriptable scriptable3, int i2, String str, int i3) {
        if (i2 == 1) {
            if (scriptable.getParentScope() == null && NativeGlobal.isEvalFunction(callable)) {
                return evalSpecial(context, scriptable2, scriptable3, objArr, str, i3);
            }
        } else {
            if (i2 != 2) {
                throw Kit.codeBug();
            }
            if (NativeWith.isWithFunction(callable)) {
                throw Context.reportRuntimeError1("msg.only.from.new", "With");
            }
        }
        return callable.call(context, scriptable2, scriptable, objArr);
    }

    public static void checkDeprecated(Context context, String str) {
        int languageVersion = context.getLanguageVersion();
        if (languageVersion >= 140 || languageVersion == 0) {
            String message1 = getMessage1("msg.deprec.ctor", str);
            if (languageVersion != 0) {
                throw Context.reportRuntimeError(message1);
            }
            Context.reportWarning(message1);
        }
    }

    public static Scriptable checkDynamicScope(Scriptable scriptable, Scriptable scriptable2) {
        if (scriptable == scriptable2) {
            return scriptable;
        }
        Scriptable prototype = scriptable;
        do {
            prototype = prototype.getPrototype();
            if (prototype == scriptable2) {
                return scriptable;
            }
        } while (prototype != null);
        return scriptable2;
    }

    public static RegExpProxy checkRegExpProxy(Context context) {
        RegExpProxy regExpProxy = getRegExpProxy(context);
        if (regExpProxy != null) {
            return regExpProxy;
        }
        throw Context.reportRuntimeError0("msg.no.regexp");
    }

    public static boolean cmp_LE(Object obj, Object obj2) {
        double number;
        double number2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            number = ((Number) obj).doubleValue();
            number2 = ((Number) obj2).doubleValue();
        } else {
            if ((obj instanceof Symbol) || (obj2 instanceof Symbol)) {
                throw typeError0("msg.compare.symbol");
            }
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(NumberClass);
            }
            if ((obj instanceof CharSequence) && (obj2 instanceof CharSequence)) {
                return obj.toString().compareTo(obj2.toString()) <= 0;
            }
            number = toNumber(obj);
            number2 = toNumber(obj2);
        }
        return number <= number2;
    }

    public static boolean cmp_LT(Object obj, Object obj2) {
        double number;
        double number2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            number = ((Number) obj).doubleValue();
            number2 = ((Number) obj2).doubleValue();
        } else {
            if ((obj instanceof Symbol) || (obj2 instanceof Symbol)) {
                throw typeError0("msg.compare.symbol");
            }
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(NumberClass);
            }
            if ((obj instanceof CharSequence) && (obj2 instanceof CharSequence)) {
                return obj.toString().compareTo(obj2.toString()) < 0;
            }
            number = toNumber(obj);
            number2 = toNumber(obj2);
        }
        return number < number2;
    }

    public static EcmaError constructError(String str, String str2) {
        int[] iArr = new int[1];
        return constructError(str, str2, Context.getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static Scriptable createArrowFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr, boolean z) {
        return new NativeCall(nativeFunction, scriptable, objArr, true, z);
    }

    @Deprecated
    public static Scriptable createFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr) {
        return createFunctionActivation(nativeFunction, scriptable, objArr, false);
    }

    private static XMLLib currentXMLLib(Context context) {
        Scriptable scriptable = context.topCallScope;
        if (scriptable == null) {
            throw new IllegalStateException();
        }
        XMLLib xMLLibExtractFromScope = context.cachedXMLLib;
        if (xMLLibExtractFromScope == null) {
            xMLLibExtractFromScope = XMLLib.extractFromScope(scriptable);
            if (xMLLibExtractFromScope == null) {
                throw new IllegalStateException();
            }
            context.cachedXMLLib = xMLLibExtractFromScope;
        }
        return xMLLibExtractFromScope;
    }

    public static String defaultObjectToSource(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        boolean zHas;
        boolean z;
        Object obj;
        ObjToIntMap objToIntMap = context.iterating;
        if (objToIntMap == null) {
            context.iterating = new ObjToIntMap(31);
            z = true;
            zHas = false;
        } else {
            zHas = objToIntMap.has(scriptable2);
            z = false;
        }
        StringBuilder sb = new StringBuilder(128);
        if (z) {
            sb.append("(");
        }
        sb.append(MessageFormatter.DELIM_START);
        if (!zHas) {
            try {
                context.iterating.intern(scriptable2);
                Object[] ids = scriptable2.getIds();
                for (int i2 = 0; i2 < ids.length; i2++) {
                    Object obj2 = ids[i2];
                    if (obj2 instanceof Integer) {
                        int iIntValue = ((Integer) obj2).intValue();
                        obj = scriptable2.get(iIntValue, scriptable2);
                        if (obj != Scriptable.NOT_FOUND) {
                            if (i2 > 0) {
                                sb.append(", ");
                            }
                            sb.append(iIntValue);
                            sb.append(':');
                            sb.append(uneval(context, scriptable, obj));
                        }
                    } else {
                        String str = (String) obj2;
                        obj = scriptable2.get(str, scriptable2);
                        if (obj != Scriptable.NOT_FOUND) {
                            if (i2 > 0) {
                                sb.append(", ");
                            }
                            if (isValidIdentifierName(str, context, context.isStrictMode())) {
                                sb.append(str);
                            } else {
                                sb.append('\'');
                                sb.append(escapeString(str, '\''));
                                sb.append('\'');
                            }
                            sb.append(':');
                            sb.append(uneval(context, scriptable, obj));
                        }
                    }
                }
            } finally {
                if (z) {
                    context.iterating = null;
                }
            }
        }
        sb.append(MessageFormatter.DELIM_STOP);
        if (z) {
            sb.append(')');
        }
        return sb.toString();
    }

    public static String defaultObjectToString(Scriptable scriptable) {
        if (scriptable == null) {
            return "[object Null]";
        }
        if (Undefined.isUndefined(scriptable)) {
            return "[object Undefined]";
        }
        StringBuilder sbR = a.r("[object ");
        sbR.append(scriptable.getClassName());
        sbR.append(']');
        return sbR.toString();
    }

    @Deprecated
    public static Object delete(Object obj, Object obj2, Context context) {
        return delete(obj, obj2, context, false);
    }

    public static boolean deleteObjectElem(Scriptable scriptable, Object obj, Context context) {
        if (isSymbol(obj)) {
            ScriptableObject.ensureSymbolScriptable(scriptable).delete((Symbol) obj);
            return !r3.has(r2, scriptable);
        }
        StringIdOrIndex stringIdOrIndex = toStringIdOrIndex(context, obj);
        String str = stringIdOrIndex.stringId;
        if (str == null) {
            scriptable.delete(stringIdOrIndex.index);
            return !scriptable.has(stringIdOrIndex.index, scriptable);
        }
        scriptable.delete(str);
        return !scriptable.has(stringIdOrIndex.stringId, scriptable);
    }

    private static Object doScriptableIncrDecr(Scriptable scriptable, String str, Scriptable scriptable2, Object obj, int i2) {
        double number;
        boolean z = (i2 & 2) != 0;
        if (obj instanceof Number) {
            number = ((Number) obj).doubleValue();
        } else {
            number = toNumber(obj);
            if (z) {
                obj = wrapNumber(number);
            }
        }
        Number numberWrapNumber = wrapNumber((i2 & 1) == 0 ? number + 1.0d : number - 1.0d);
        scriptable.put(str, scriptable2, numberWrapNumber);
        return z ? obj : numberWrapNumber;
    }

    @Deprecated
    public static Object doTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return doTopCall(callable, context, scriptable, scriptable2, objArr, context.isTopLevelStrict);
    }

    @Deprecated
    public static Object elemIncrDecr(Object obj, Object obj2, Context context, int i2) {
        return elemIncrDecr(obj, obj2, context, getTopCallScope(context), i2);
    }

    public static void enterActivationFunction(Context context, Scriptable scriptable) {
        if (context.topCallScope == null) {
            throw new IllegalStateException();
        }
        NativeCall nativeCall = (NativeCall) scriptable;
        nativeCall.parentActivationCall = context.currentActivationCall;
        context.currentActivationCall = nativeCall;
        nativeCall.defineAttributesForArguments();
    }

    public static Scriptable enterDotQuery(Object obj, Scriptable scriptable) {
        if (obj instanceof XMLObject) {
            return ((XMLObject) obj).enterDotQuery(scriptable);
        }
        throw notXmlError(obj);
    }

    public static Scriptable enterWith(Object obj, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return objectOrNull instanceof XMLObject ? ((XMLObject) objectOrNull).enterWith(scriptable) : new NativeWith(scriptable, objectOrNull);
        }
        throw typeError1("msg.undef.with", toString(obj));
    }

    private static void enumChangeObject(IdEnumeration idEnumeration) {
        Object[] objArr;
        Object[] ids = null;
        while (true) {
            Scriptable scriptable = idEnumeration.obj;
            if (scriptable == null) {
                break;
            }
            ids = scriptable.getIds();
            if (ids.length != 0) {
                break;
            } else {
                idEnumeration.obj = idEnumeration.obj.getPrototype();
            }
        }
        if (idEnumeration.obj != null && (objArr = idEnumeration.ids) != null) {
            int length = objArr.length;
            if (idEnumeration.used == null) {
                idEnumeration.used = new ObjToIntMap(length);
            }
            for (int i2 = 0; i2 != length; i2++) {
                idEnumeration.used.intern(objArr[i2]);
            }
        }
        idEnumeration.ids = ids;
        idEnumeration.index = 0;
    }

    public static Object enumId(Object obj, Context context) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        if (idEnumeration.iterator != null) {
            return idEnumeration.currentId;
        }
        int i2 = idEnumeration.enumType;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                throw Kit.codeBug();
                            }
                        }
                    }
                }
                return context.newArray(ScriptableObject.getTopLevelScope(idEnumeration.obj), new Object[]{idEnumeration.currentId, enumValue(obj, context)});
            }
            return enumValue(obj, context);
        }
        return idEnumeration.currentId;
    }

    @Deprecated
    public static Object enumInit(Object obj, Context context, boolean z) {
        return enumInit(obj, context, z ? 1 : 0);
    }

    private static Object enumInitInOrder(Context context, IdEnumeration idEnumeration) {
        Scriptable scriptable = idEnumeration.obj;
        if (scriptable instanceof SymbolScriptable) {
            SymbolKey symbolKey = SymbolKey.ITERATOR;
            if (ScriptableObject.hasProperty(scriptable, symbolKey)) {
                Object property = ScriptableObject.getProperty(idEnumeration.obj, symbolKey);
                if (!(property instanceof Callable)) {
                    throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
                }
                Object objCall = ((Callable) property).call(context, idEnumeration.obj.getParentScope(), idEnumeration.obj, new Object[0]);
                if (!(objCall instanceof Scriptable)) {
                    throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
                }
                idEnumeration.iterator = (Scriptable) objCall;
                return idEnumeration;
            }
        }
        throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
    }

    public static Boolean enumNext(Object obj) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        Scriptable scriptable = idEnumeration.iterator;
        if (scriptable != null) {
            if (idEnumeration.enumType == 6) {
                return enumNextInOrder(idEnumeration);
            }
            Object property = ScriptableObject.getProperty(scriptable, ES6Iterator.NEXT_METHOD);
            if (!(property instanceof Callable)) {
                return Boolean.FALSE;
            }
            try {
                idEnumeration.currentId = ((Callable) property).call(Context.getContext(), idEnumeration.iterator.getParentScope(), idEnumeration.iterator, emptyArgs);
                return Boolean.TRUE;
            } catch (JavaScriptException e2) {
                if (e2.getValue() instanceof NativeIterator.StopIteration) {
                    return Boolean.FALSE;
                }
                throw e2;
            }
        }
        while (true) {
            Scriptable scriptable2 = idEnumeration.obj;
            if (scriptable2 == null) {
                return Boolean.FALSE;
            }
            int i2 = idEnumeration.index;
            Object[] objArr = idEnumeration.ids;
            if (i2 == objArr.length) {
                idEnumeration.obj = scriptable2.getPrototype();
                enumChangeObject(idEnumeration);
            } else {
                idEnumeration.index = i2 + 1;
                Object obj2 = objArr[i2];
                ObjToIntMap objToIntMap = idEnumeration.used;
                if (objToIntMap == null || !objToIntMap.has(obj2)) {
                    if (obj2 instanceof Symbol) {
                        continue;
                    } else if (obj2 instanceof String) {
                        String str = (String) obj2;
                        Scriptable scriptable3 = idEnumeration.obj;
                        if (scriptable3.has(str, scriptable3)) {
                            idEnumeration.currentId = str;
                            break;
                        }
                    } else {
                        int iIntValue = ((Number) obj2).intValue();
                        Scriptable scriptable4 = idEnumeration.obj;
                        if (scriptable4.has(iIntValue, scriptable4)) {
                            idEnumeration.currentId = idEnumeration.enumNumbers ? Integer.valueOf(iIntValue) : String.valueOf(iIntValue);
                        }
                    }
                }
            }
        }
        return Boolean.TRUE;
    }

    private static Boolean enumNextInOrder(IdEnumeration idEnumeration) {
        Object property = ScriptableObject.getProperty(idEnumeration.iterator, ES6Iterator.NEXT_METHOD);
        if (!(property instanceof Callable)) {
            throw notFunctionError(idEnumeration.iterator, ES6Iterator.NEXT_METHOD);
        }
        Context context = Context.getContext();
        Scriptable parentScope = idEnumeration.iterator.getParentScope();
        Scriptable object = toObject(context, parentScope, ((Callable) property).call(context, parentScope, idEnumeration.iterator, emptyArgs));
        Object property2 = ScriptableObject.getProperty(object, ES6Iterator.DONE_PROPERTY);
        if (property2 != Scriptable.NOT_FOUND && toBoolean(property2)) {
            return Boolean.FALSE;
        }
        idEnumeration.currentId = ScriptableObject.getProperty(object, ES6Iterator.VALUE_PROPERTY);
        return Boolean.TRUE;
    }

    public static Object enumValue(Object obj, Context context) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        if (isSymbol(idEnumeration.currentId)) {
            return ScriptableObject.ensureSymbolScriptable(idEnumeration.obj).get((Symbol) idEnumeration.currentId, idEnumeration.obj);
        }
        StringIdOrIndex stringIdOrIndex = toStringIdOrIndex(context, idEnumeration.currentId);
        String str = stringIdOrIndex.stringId;
        if (str == null) {
            Scriptable scriptable = idEnumeration.obj;
            return scriptable.get(stringIdOrIndex.index, scriptable);
        }
        Scriptable scriptable2 = idEnumeration.obj;
        return scriptable2.get(str, scriptable2);
    }

    public static boolean eq(Object obj, Object obj2) {
        Object objEquivalentValues;
        Object objEquivalentValues2;
        Object objEquivalentValues3;
        Object objEquivalentValues4;
        Object objEquivalentValues5;
        if (obj == null || obj == Undefined.instance) {
            if (obj2 == null || obj2 == Undefined.instance) {
                return true;
            }
            if (!(obj2 instanceof ScriptableObject) || (objEquivalentValues = ((ScriptableObject) obj2).equivalentValues(obj)) == Scriptable.NOT_FOUND) {
                return false;
            }
            return ((Boolean) objEquivalentValues).booleanValue();
        }
        if (obj instanceof Number) {
            return eqNumber(((Number) obj).doubleValue(), obj2);
        }
        if (obj == obj2) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return eqString((CharSequence) obj, obj2);
        }
        if (obj instanceof Boolean) {
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            if (obj2 instanceof Boolean) {
                return zBooleanValue == ((Boolean) obj2).booleanValue();
            }
            if (!(obj2 instanceof ScriptableObject) || (objEquivalentValues5 = ((ScriptableObject) obj2).equivalentValues(obj)) == Scriptable.NOT_FOUND) {
                return eqNumber(zBooleanValue ? 1.0d : 0.0d, obj2);
            }
            return ((Boolean) objEquivalentValues5).booleanValue();
        }
        if (!(obj instanceof Scriptable)) {
            warnAboutNonJSObject(obj);
            return obj == obj2;
        }
        if (!(obj2 instanceof Scriptable)) {
            if (obj2 instanceof Boolean) {
                if (!(obj instanceof ScriptableObject) || (objEquivalentValues2 = ((ScriptableObject) obj).equivalentValues(obj2)) == Scriptable.NOT_FOUND) {
                    return eqNumber(((Boolean) obj2).booleanValue() ? 1.0d : 0.0d, obj);
                }
                return ((Boolean) objEquivalentValues2).booleanValue();
            }
            if (obj2 instanceof Number) {
                return eqNumber(((Number) obj2).doubleValue(), obj);
            }
            if (obj2 instanceof CharSequence) {
                return eqString((CharSequence) obj2, obj);
            }
            return false;
        }
        if ((obj instanceof ScriptableObject) && (objEquivalentValues4 = ((ScriptableObject) obj).equivalentValues(obj2)) != Scriptable.NOT_FOUND) {
            return ((Boolean) objEquivalentValues4).booleanValue();
        }
        if ((obj2 instanceof ScriptableObject) && (objEquivalentValues3 = ((ScriptableObject) obj2).equivalentValues(obj)) != Scriptable.NOT_FOUND) {
            return ((Boolean) objEquivalentValues3).booleanValue();
        }
        if (!(obj instanceof Wrapper) || !(obj2 instanceof Wrapper)) {
            return false;
        }
        Object objUnwrap = ((Wrapper) obj).unwrap();
        Object objUnwrap2 = ((Wrapper) obj2).unwrap();
        if (objUnwrap != objUnwrap2) {
            return isPrimitive(objUnwrap) && isPrimitive(objUnwrap2) && eq(objUnwrap, objUnwrap2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x006b, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean eqNumber(double r5, java.lang.Object r7) {
        /*
        L0:
            r0 = 0
            if (r7 == 0) goto L6b
            java.lang.Object r1 = org.mozilla.javascript.Undefined.instance
            if (r7 != r1) goto L8
            goto L6b
        L8:
            boolean r1 = r7 instanceof java.lang.Number
            r2 = 1
            if (r1 == 0) goto L19
            java.lang.Number r7 = (java.lang.Number) r7
            double r3 = r7.doubleValue()
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L18
            r0 = 1
        L18:
            return r0
        L19:
            boolean r1 = r7 instanceof java.lang.CharSequence
            if (r1 == 0) goto L27
            double r3 = toNumber(r7)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L26
            r0 = 1
        L26:
            return r0
        L27:
            boolean r1 = r7 instanceof java.lang.Boolean
            if (r1 == 0) goto L3e
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L36
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L38
        L36:
            r3 = 0
        L38:
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L3d
            r0 = 1
        L3d:
            return r0
        L3e:
            boolean r1 = isSymbol(r7)
            if (r1 == 0) goto L45
            return r0
        L45:
            boolean r1 = r7 instanceof org.mozilla.javascript.Scriptable
            if (r1 == 0) goto L68
            boolean r0 = r7 instanceof org.mozilla.javascript.ScriptableObject
            if (r0 == 0) goto L63
            java.lang.Number r0 = wrapNumber(r5)
            r1 = r7
            org.mozilla.javascript.ScriptableObject r1 = (org.mozilla.javascript.ScriptableObject) r1
            java.lang.Object r0 = r1.equivalentValues(r0)
            java.lang.Object r1 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r0 == r1) goto L63
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r5 = r0.booleanValue()
            return r5
        L63:
            java.lang.Object r7 = toPrimitive(r7)
            goto L0
        L68:
            warnAboutNonJSObject(r7)
        L6b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.eqNumber(double, java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008f, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean eqString(java.lang.CharSequence r5, java.lang.Object r6) {
        /*
        L0:
            r0 = 0
            if (r6 == 0) goto L8f
            java.lang.Object r1 = org.mozilla.javascript.Undefined.instance
            if (r6 != r1) goto L9
            goto L8f
        L9:
            boolean r1 = r6 instanceof java.lang.CharSequence
            r2 = 1
            if (r1 == 0) goto L2a
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r1 = r5.length()
            int r3 = r6.length()
            if (r1 != r3) goto L29
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = r6.toString()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L29
            r0 = 1
        L29:
            return r0
        L2a:
            boolean r1 = r6 instanceof java.lang.Number
            if (r1 == 0) goto L42
            java.lang.String r5 = r5.toString()
            double r3 = toNumber(r5)
            java.lang.Number r6 = (java.lang.Number) r6
            double r5 = r6.doubleValue()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L41
            r0 = 1
        L41:
            return r0
        L42:
            boolean r1 = r6 instanceof java.lang.Boolean
            if (r1 == 0) goto L61
            java.lang.String r5 = r5.toString()
            double r3 = toNumber(r5)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            if (r5 == 0) goto L59
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L5b
        L59:
            r5 = 0
        L5b:
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L60
            r0 = 1
        L60:
            return r0
        L61:
            boolean r1 = isSymbol(r6)
            if (r1 == 0) goto L68
            return r0
        L68:
            boolean r1 = r6 instanceof org.mozilla.javascript.Scriptable
            if (r1 == 0) goto L8c
            boolean r0 = r6 instanceof org.mozilla.javascript.ScriptableObject
            if (r0 == 0) goto L86
            r0 = r6
            org.mozilla.javascript.ScriptableObject r0 = (org.mozilla.javascript.ScriptableObject) r0
            java.lang.String r1 = r5.toString()
            java.lang.Object r0 = r0.equivalentValues(r1)
            java.lang.Object r1 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r0 == r1) goto L86
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r5 = r0.booleanValue()
            return r5
        L86:
            java.lang.Object r6 = toPrimitive(r6)
            goto L0
        L8c:
            warnAboutNonJSObject(r6)
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.eqString(java.lang.CharSequence, java.lang.Object):boolean");
    }

    private static RuntimeException errorWithClassName(String str, Object obj) {
        return Context.reportRuntimeError1(str, obj.getClass().getName());
    }

    public static String escapeAttributeValue(Object obj, Context context) {
        return currentXMLLib(context).escapeAttributeValue(obj);
    }

    public static String escapeString(String str) {
        return escapeString(str, '\"');
    }

    public static String escapeTextValue(Object obj, Context context) {
        return currentXMLLib(context).escapeTextValue(obj);
    }

    public static Object evalSpecial(Context context, Scriptable scriptable, Object obj, Object[] objArr, String str, int i2) {
        if (objArr.length < 1) {
            return Undefined.instance;
        }
        Object obj2 = objArr[0];
        if (!(obj2 instanceof CharSequence)) {
            if (context.hasFeature(11) || context.hasFeature(9)) {
                throw Context.reportRuntimeError0("msg.eval.nonstring.strict");
            }
            Context.reportWarning(getMessage0("msg.eval.nonstring"));
            return obj2;
        }
        if (str == null) {
            int[] iArr = new int[1];
            String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
            if (sourcePositionFromStack != null) {
                i2 = iArr[0];
                str = sourcePositionFromStack;
            } else {
                str = "";
            }
        }
        String strMakeUrlForGeneratedScript = makeUrlForGeneratedScript(true, str, i2);
        ErrorReporter errorReporterForEval = DefaultErrorReporter.forEval(context.getErrorReporter());
        Evaluator evaluatorCreateInterpreter = Context.createInterpreter();
        if (evaluatorCreateInterpreter == null) {
            throw new JavaScriptException("Interpreter not present", str, i2);
        }
        Script scriptCompileString = context.compileString(obj2.toString(), evaluatorCreateInterpreter, errorReporterForEval, strMakeUrlForGeneratedScript, 1, null);
        evaluatorCreateInterpreter.setEvalScriptFlag(scriptCompileString);
        return ((Callable) scriptCompileString).call(context, scriptable, (Scriptable) obj, emptyArgs);
    }

    public static void exitActivationFunction(Context context) {
        NativeCall nativeCall = context.currentActivationCall;
        context.currentActivationCall = nativeCall.parentActivationCall;
        nativeCall.parentActivationCall = null;
    }

    public static NativeCall findFunctionActivation(Context context, Function function) {
        for (NativeCall nativeCall = context.currentActivationCall; nativeCall != null; nativeCall = nativeCall.parentActivationCall) {
            if (nativeCall.function == function) {
                return nativeCall;
            }
        }
        return null;
    }

    public static Object[] getApplyArguments(Context context, Object obj) {
        if (obj == null || obj == Undefined.instance) {
            return emptyArgs;
        }
        if (obj instanceof Scriptable) {
            Scriptable scriptable = (Scriptable) obj;
            if (isArrayLike(scriptable)) {
                return context.getElements(scriptable);
            }
        }
        if (obj instanceof ScriptableObject) {
            return emptyArgs;
        }
        throw typeError0("msg.arg.isnt.array");
    }

    public static Object[] getArrayElements(Scriptable scriptable) {
        long lengthProperty = NativeArray.getLengthProperty(Context.getContext(), scriptable, false);
        if (lengthProperty > 2147483647L) {
            throw new IllegalArgumentException();
        }
        int i2 = (int) lengthProperty;
        if (i2 == 0) {
            return emptyArgs;
        }
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            Object property = ScriptableObject.getProperty(scriptable, i3);
            if (property == Scriptable.NOT_FOUND) {
                property = Undefined.instance;
            }
            objArr[i3] = property;
        }
        return objArr;
    }

    public static Callable getCallable(Scriptable scriptable) {
        if (scriptable instanceof Callable) {
            return (Callable) scriptable;
        }
        Object defaultValue = scriptable.getDefaultValue(FunctionClass);
        if (defaultValue instanceof Callable) {
            return (Callable) defaultValue;
        }
        throw notFunctionError(defaultValue, scriptable);
    }

    @Deprecated
    public static Callable getElemFunctionAndThis(Object obj, Object obj2, Context context) {
        return getElemFunctionAndThis(obj, obj2, context, getTopCallScope(context));
    }

    public static Function getExistingCtor(Context context, Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property instanceof Function) {
            return (Function) property;
        }
        if (property == Scriptable.NOT_FOUND) {
            throw Context.reportRuntimeError1("msg.ctor.not.found", str);
        }
        throw Context.reportRuntimeError1("msg.not.ctor", str);
    }

    public static ScriptableObject getGlobal(Context context) {
        Class<?> clsClassOrNull = Kit.classOrNull("org.mozilla.javascript.tools.shell.Global");
        if (clsClassOrNull != null) {
            try {
                return (ScriptableObject) clsClassOrNull.getConstructor(ContextClass).newInstance(context);
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
        return new ImporterTopLevel(context);
    }

    public static Object getIndexObject(String str) {
        long jIndexFromString = indexFromString(str);
        return jIndexFromString >= 0 ? Integer.valueOf((int) jIndexFromString) : str;
    }

    public static ScriptableObject getLibraryScopeOrNull(Scriptable scriptable) {
        return (ScriptableObject) ScriptableObject.getTopScopeValue(scriptable, LIBRARY_SCOPE_KEY);
    }

    public static String getMessage(String str, Object[] objArr) {
        return messageProvider.getMessage(str, objArr);
    }

    public static String getMessage0(String str) {
        return getMessage(str, null);
    }

    public static String getMessage1(String str, Object obj) {
        return getMessage(str, new Object[]{obj});
    }

    public static String getMessage2(String str, Object obj, Object obj2) {
        return getMessage(str, new Object[]{obj, obj2});
    }

    public static String getMessage3(String str, Object obj, Object obj2, Object obj3) {
        return getMessage(str, new Object[]{obj, obj2, obj3});
    }

    public static String getMessage4(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return getMessage(str, new Object[]{obj, obj2, obj3, obj4});
    }

    public static Callable getNameFunctionAndThis(String str, Context context, Scriptable scriptable) {
        Scriptable parentScope = scriptable.getParentScope();
        if (parentScope != null) {
            return (Callable) nameOrFunction(context, scriptable, parentScope, str, true);
        }
        Object obj = topScopeName(context, scriptable, str);
        if (obj instanceof Callable) {
            storeScriptable(context, scriptable);
            return (Callable) obj;
        }
        if (obj == Scriptable.NOT_FOUND) {
            throw notFoundError(scriptable, str);
        }
        throw notFunctionError(obj, str);
    }

    @Deprecated
    public static Object getObjectElem(Object obj, Object obj2, Context context) {
        return getObjectElem(obj, obj2, context, getTopCallScope(context));
    }

    @Deprecated
    public static Object getObjectIndex(Object obj, double d2, Context context) {
        return getObjectIndex(obj, d2, context, getTopCallScope(context));
    }

    @Deprecated
    public static Object getObjectProp(Object obj, String str, Context context) {
        return getObjectProp(obj, str, context, getTopCallScope(context));
    }

    @Deprecated
    public static Object getObjectPropNoWarn(Object obj, String str, Context context) {
        return getObjectPropNoWarn(obj, str, context, getTopCallScope(context));
    }

    @Deprecated
    public static Callable getPropFunctionAndThis(Object obj, String str, Context context) {
        return getPropFunctionAndThis(obj, str, context, getTopCallScope(context));
    }

    private static Callable getPropFunctionAndThisHelper(Object obj, String str, Context context, Scriptable scriptable) {
        if (scriptable == null) {
            throw undefCallError(obj, str);
        }
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (!(property instanceof Callable)) {
            Object property2 = ScriptableObject.getProperty(scriptable, "__noSuchMethod__");
            if (property2 instanceof Callable) {
                property = new NoSuchMethodShim((Callable) property2, str);
            }
        }
        if (!(property instanceof Callable)) {
            throw notFunctionError(scriptable, property, str);
        }
        storeScriptable(context, scriptable);
        return (Callable) property;
    }

    public static RegExpProxy getRegExpProxy(Context context) {
        return context.getRegExpProxy();
    }

    public static Scriptable getTopCallScope(Context context) {
        Scriptable scriptable = context.topCallScope;
        if (scriptable != null) {
            return scriptable;
        }
        throw new IllegalStateException();
    }

    public static Object getTopLevelProp(Scriptable scriptable, String str) {
        return ScriptableObject.getProperty(ScriptableObject.getTopLevelScope(scriptable), str);
    }

    public static String[] getTopPackageNames() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new String[]{LogType.JAVA_TYPE, "javax", "org", "com", "edu", "net", "android"} : new String[]{LogType.JAVA_TYPE, "javax", "org", "com", "edu", "net"};
    }

    public static Callable getValueFunctionAndThis(Object obj, Context context) {
        if (!(obj instanceof Callable)) {
            throw notFunctionError(obj);
        }
        Callable callable = (Callable) obj;
        Scriptable parentScope = callable instanceof Scriptable ? ((Scriptable) callable).getParentScope() : null;
        if (parentScope == null && (parentScope = context.topCallScope) == null) {
            throw new IllegalStateException();
        }
        if (parentScope.getParentScope() != null && !(parentScope instanceof NativeWith) && (parentScope instanceof NativeCall)) {
            parentScope = ScriptableObject.getTopLevelScope(parentScope);
        }
        storeScriptable(context, parentScope);
        return callable;
    }

    public static boolean hasObjectElem(Scriptable scriptable, Object obj, Context context) {
        if (isSymbol(obj)) {
            return ScriptableObject.hasProperty(scriptable, (Symbol) obj);
        }
        StringIdOrIndex stringIdOrIndex = toStringIdOrIndex(context, obj);
        String str = stringIdOrIndex.stringId;
        return str == null ? ScriptableObject.hasProperty(scriptable, stringIdOrIndex.index) : ScriptableObject.hasProperty(scriptable, str);
    }

    public static boolean hasTopCall(Context context) {
        return context.topCallScope != null;
    }

    public static boolean in(Object obj, Object obj2, Context context) {
        if (obj2 instanceof Scriptable) {
            return hasObjectElem((Scriptable) obj2, obj, context);
        }
        throw typeError0("msg.in.not.object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x005a, code lost:
    
        if (r4 <= (r5 ? 8 : 7)) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long indexFromString(java.lang.String r12) {
        /*
            int r0 = r12.length()
            r1 = -1
            if (r0 <= 0) goto L68
            r3 = 0
            char r4 = r12.charAt(r3)
            r5 = 45
            r6 = 48
            r7 = 1
            if (r4 != r5) goto L20
            if (r0 <= r7) goto L20
            char r4 = r12.charAt(r7)
            if (r4 != r6) goto L1d
            return r1
        L1d:
            r5 = 1
            r8 = 1
            goto L22
        L20:
            r5 = 0
            r8 = 0
        L22:
            int r4 = r4 + (-48)
            if (r4 < 0) goto L68
            r9 = 9
            if (r4 > r9) goto L68
            if (r5 == 0) goto L2f
            r10 = 11
            goto L31
        L2f:
            r10 = 10
        L31:
            if (r0 > r10) goto L68
            int r10 = -r4
            int r8 = r8 + r7
            if (r10 == 0) goto L4b
        L37:
            if (r8 == r0) goto L4b
            char r4 = r12.charAt(r8)
            int r4 = r4 - r6
            if (r4 < 0) goto L4b
            if (r4 > r9) goto L4b
            int r3 = r10 * 10
            int r3 = r3 - r4
            int r8 = r8 + 1
            r11 = r10
            r10 = r3
            r3 = r11
            goto L37
        L4b:
            if (r8 != r0) goto L68
            r12 = -214748364(0xfffffffff3333334, float:-1.4197688E31)
            if (r3 > r12) goto L5c
            if (r3 != r12) goto L68
            if (r5 == 0) goto L59
            r12 = 8
            goto L5a
        L59:
            r12 = 7
        L5a:
            if (r4 > r12) goto L68
        L5c:
            r0 = 4294967295(0xffffffff, double:2.1219957905E-314)
            if (r5 == 0) goto L64
            goto L65
        L64:
            int r10 = -r10
        L65:
            long r2 = (long) r10
            long r0 = r0 & r2
            return r0
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.indexFromString(java.lang.String):long");
    }

    public static void initFunction(Context context, Scriptable scriptable, NativeFunction nativeFunction, int i2, boolean z) {
        if (i2 == 1) {
            String functionName = nativeFunction.getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                return;
            }
            if (z) {
                scriptable.put(functionName, scriptable, nativeFunction);
                return;
            } else {
                ScriptableObject.defineProperty(scriptable, functionName, nativeFunction, 4);
                return;
            }
        }
        if (i2 != 3) {
            throw Kit.codeBug();
        }
        String functionName2 = nativeFunction.getFunctionName();
        if (functionName2 == null || functionName2.length() == 0) {
            return;
        }
        while (scriptable instanceof NativeWith) {
            scriptable = scriptable.getParentScope();
        }
        scriptable.put(functionName2, scriptable, nativeFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [org.mozilla.javascript.ClassCache] */
    /* JADX WARN: Type inference failed for: r1v3, types: [org.mozilla.javascript.ScriptableObject] */
    /* JADX WARN: Type inference failed for: r1v5, types: [org.mozilla.javascript.ScriptableObject] */
    /* JADX WARN: Type inference failed for: r1v6, types: [org.mozilla.javascript.ScriptableObject] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [org.mozilla.javascript.TopLevel] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, org.mozilla.javascript.Scriptable, org.mozilla.javascript.ScriptableObject] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    public static ScriptableObject initSafeStandardObjects(Context context, ScriptableObject scriptableObject, boolean z) {
        ?? nativeObject = scriptableObject;
        if (scriptableObject == null) {
            nativeObject = new NativeObject();
        }
        nativeObject.associateValue(LIBRARY_SCOPE_KEY, nativeObject);
        new ClassCache().associate(nativeObject);
        BaseFunction.init(nativeObject, z);
        NativeObject.init(nativeObject, z);
        Scriptable objectPrototype = ScriptableObject.getObjectPrototype(nativeObject);
        ScriptableObject.getClassPrototype(nativeObject, "Function").setPrototype(objectPrototype);
        if (nativeObject.getPrototype() == null) {
            nativeObject.setPrototype(objectPrototype);
        }
        NativeError.init(nativeObject, z);
        NativeGlobal.init(context, nativeObject, z);
        NativeArray.init(nativeObject, z);
        if (context.getOptimizationLevel() > 0) {
            NativeArray.setMaximumInitialCapacity(200000);
        }
        NativeString.init(nativeObject, z);
        NativeBoolean.init(nativeObject, z);
        NativeNumber.init(nativeObject, z);
        NativeDate.init(nativeObject, z);
        NativeMath.init(nativeObject, z);
        NativeJSON.init(nativeObject, z);
        NativeWith.init(nativeObject, z);
        NativeCall.init(nativeObject, z);
        NativeScript.init(nativeObject, z);
        NativeIterator.init(context, nativeObject, z);
        NativeArrayIterator.init(nativeObject, z);
        NativeStringIterator.init(nativeObject, z);
        boolean z2 = context.hasFeature(6) && context.getE4xImplementationFactory() != null;
        ?? r1 = nativeObject;
        new LazilyLoadedCtor(r1, "RegExp", "org.mozilla.javascript.regexp.NativeRegExp", z, true);
        new LazilyLoadedCtor(r1, "Continuation", "org.mozilla.javascript.NativeContinuation", z, true);
        if (z2) {
            String implementationClassName = context.getE4xImplementationFactory().getImplementationClassName();
            ?? r12 = nativeObject;
            new LazilyLoadedCtor(r12, "XML", implementationClassName, z, true);
            new LazilyLoadedCtor(r12, "XMLList", implementationClassName, z, true);
            new LazilyLoadedCtor(r12, "Namespace", implementationClassName, z, true);
            new LazilyLoadedCtor(r12, "QName", implementationClassName, z, true);
        }
        if ((context.getLanguageVersion() >= 180 && context.hasFeature(14)) || context.getLanguageVersion() >= 200) {
            ?? r13 = nativeObject;
            new LazilyLoadedCtor(r13, NativeArrayBuffer.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeArrayBuffer", z, true);
            new LazilyLoadedCtor(r13, "Int8Array", "org.mozilla.javascript.typedarrays.NativeInt8Array", z, true);
            new LazilyLoadedCtor(r13, "Uint8Array", "org.mozilla.javascript.typedarrays.NativeUint8Array", z, true);
            new LazilyLoadedCtor(r13, "Uint8ClampedArray", "org.mozilla.javascript.typedarrays.NativeUint8ClampedArray", z, true);
            new LazilyLoadedCtor(r13, "Int16Array", "org.mozilla.javascript.typedarrays.NativeInt16Array", z, true);
            new LazilyLoadedCtor(r13, "Uint16Array", "org.mozilla.javascript.typedarrays.NativeUint16Array", z, true);
            new LazilyLoadedCtor(r13, "Int32Array", "org.mozilla.javascript.typedarrays.NativeInt32Array", z, true);
            new LazilyLoadedCtor(r13, "Uint32Array", "org.mozilla.javascript.typedarrays.NativeUint32Array", z, true);
            new LazilyLoadedCtor(r13, "Float32Array", "org.mozilla.javascript.typedarrays.NativeFloat32Array", z, true);
            new LazilyLoadedCtor(r13, "Float64Array", "org.mozilla.javascript.typedarrays.NativeFloat64Array", z, true);
            new LazilyLoadedCtor(r13, NativeDataView.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeDataView", z, true);
        }
        if (context.getLanguageVersion() >= 200) {
            NativeSymbol.init(context, nativeObject, z);
            NativeCollectionIterator.init(nativeObject, NativeSet.ITERATOR_TAG, z);
            NativeCollectionIterator.init(nativeObject, NativeMap.ITERATOR_TAG, z);
            NativeMap.init(context, nativeObject, z);
            NativeSet.init(context, nativeObject, z);
            NativeWeakMap.init(nativeObject, z);
            NativeWeakSet.init(nativeObject, z);
        }
        if (nativeObject instanceof TopLevel) {
            ((TopLevel) nativeObject).cacheBuiltins(nativeObject, z);
        }
        return nativeObject;
    }

    public static void initScript(NativeFunction nativeFunction, Scriptable scriptable, Context context, Scriptable scriptable2, boolean z) {
        if (context.topCallScope == null) {
            throw new IllegalStateException();
        }
        int paramAndVarCount = nativeFunction.getParamAndVarCount();
        if (paramAndVarCount == 0) {
            return;
        }
        Scriptable parentScope = scriptable2;
        while (parentScope instanceof NativeWith) {
            parentScope = parentScope.getParentScope();
        }
        while (true) {
            int i2 = paramAndVarCount - 1;
            if (paramAndVarCount == 0) {
                return;
            }
            String paramOrVarName = nativeFunction.getParamOrVarName(i2);
            boolean paramOrVarConst = nativeFunction.getParamOrVarConst(i2);
            if (ScriptableObject.hasProperty(scriptable2, paramOrVarName)) {
                ScriptableObject.redefineProperty(scriptable2, paramOrVarName, paramOrVarConst);
            } else if (paramOrVarConst) {
                ScriptableObject.defineConstProperty(parentScope, paramOrVarName);
            } else if (z) {
                parentScope.put(paramOrVarName, parentScope, Undefined.instance);
            } else if (!(nativeFunction instanceof InterpretedFunction) || ((InterpretedFunction) nativeFunction).hasFunctionNamed(paramOrVarName)) {
                ScriptableObject.defineProperty(parentScope, paramOrVarName, Undefined.instance, 4);
            }
            paramAndVarCount = i2;
        }
    }

    public static ScriptableObject initStandardObjects(Context context, ScriptableObject scriptableObject, boolean z) {
        ScriptableObject scriptableObjectInitSafeStandardObjects = initSafeStandardObjects(context, scriptableObject, z);
        new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, "Packages", "org.mozilla.javascript.NativeJavaTopPackage", z, true);
        new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, "getClass", "org.mozilla.javascript.NativeJavaTopPackage", z, true);
        new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, "JavaAdapter", "org.mozilla.javascript.JavaAdapter", z, true);
        new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, "JavaImporter", "org.mozilla.javascript.ImporterTopLevel", z, true);
        for (String str : getTopPackageNames()) {
            new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, str, "org.mozilla.javascript.NativeJavaTopPackage", z, true);
        }
        return scriptableObjectInitSafeStandardObjects;
    }

    public static boolean instanceOf(Object obj, Object obj2, Context context) {
        if (!(obj2 instanceof Scriptable)) {
            throw typeError0("msg.instanceof.not.object");
        }
        if (obj instanceof Scriptable) {
            return ((Scriptable) obj2).hasInstance((Scriptable) obj);
        }
        return false;
    }

    private static boolean isArrayLike(Scriptable scriptable) {
        return scriptable != null && ((scriptable instanceof NativeArray) || (scriptable instanceof Arguments) || ScriptableObject.hasProperty(scriptable, "length"));
    }

    public static boolean isArrayObject(Object obj) {
        return (obj instanceof NativeArray) || (obj instanceof Arguments);
    }

    public static boolean isGeneratedScript(String str) {
        return str.indexOf("(eval)") >= 0 || str.indexOf("(Function)") >= 0;
    }

    public static boolean isIteratorDone(Context context, Object obj) {
        if (obj instanceof Scriptable) {
            return toBoolean(getObjectProp((Scriptable) obj, ES6Iterator.DONE_PROPERTY, context));
        }
        return false;
    }

    public static boolean isJSLineTerminator(int i2) {
        if ((57296 & i2) != 0) {
            return false;
        }
        return i2 == 10 || i2 == 13 || i2 == 8232 || i2 == 8233;
    }

    public static boolean isJSWhitespaceOrLineTerminator(int i2) {
        return isStrWhiteSpaceChar(i2) || isJSLineTerminator(i2);
    }

    public static boolean isNaN(Object obj) {
        if (obj instanceof Double) {
            return ((Double) obj).isNaN();
        }
        if (obj instanceof Float) {
            return ((Float) obj).isNaN();
        }
        return false;
    }

    public static boolean isObject(Object obj) {
        if (obj == null || Undefined.instance.equals(obj)) {
            return false;
        }
        if (obj instanceof ScriptableObject) {
            String typeOf = ((ScriptableObject) obj).getTypeOf();
            return "object".equals(typeOf) || "function".equals(typeOf);
        }
        if (obj instanceof Scriptable) {
            return !(obj instanceof Callable);
        }
        return false;
    }

    public static boolean isPrimitive(Object obj) {
        return obj == null || obj == Undefined.instance || (obj instanceof Number) || (obj instanceof String) || (obj instanceof Boolean);
    }

    public static boolean isRhinoRuntimeType(Class<?> cls) {
        return cls.isPrimitive() ? cls != Character.TYPE : cls == StringClass || cls == BooleanClass || NumberClass.isAssignableFrom(cls) || ScriptableClass.isAssignableFrom(cls);
    }

    public static boolean isSpecialProperty(String str) {
        return str.equals("__proto__") || str.equals("__parent__");
    }

    public static boolean isStrWhiteSpaceChar(int i2) {
        if (i2 == 32 || i2 == 160 || i2 == 65279 || i2 == 8232 || i2 == 8233) {
            return true;
        }
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                if (Character.getType(i2) == 12) {
                }
                break;
        }
        return true;
    }

    public static boolean isSymbol(Object obj) {
        return ((obj instanceof NativeSymbol) && ((NativeSymbol) obj).isSymbol()) || (obj instanceof SymbolKey);
    }

    public static boolean isValidIdentifierName(String str, Context context, boolean z) {
        int length = str.length();
        if (length == 0 || !Character.isJavaIdentifierStart(str.charAt(0))) {
            return false;
        }
        for (int i2 = 1; i2 != length; i2++) {
            if (!Character.isJavaIdentifierPart(str.charAt(i2))) {
                return false;
            }
        }
        return !TokenStream.isKeyword(str, context.getLanguageVersion(), z);
    }

    private static boolean isVisible(Context context, Object obj) {
        ClassShutter classShutter = context.getClassShutter();
        return classShutter == null || classShutter.visibleToScripts(obj.getClass().getName());
    }

    public static boolean jsDelegatesTo(Scriptable scriptable, Scriptable scriptable2) {
        for (Scriptable prototype = scriptable.getPrototype(); prototype != null; prototype = prototype.getPrototype()) {
            if (prototype.equals(scriptable2)) {
                return true;
            }
        }
        return false;
    }

    public static Scriptable lastStoredScriptable(Context context) {
        Scriptable scriptable = context.scratchScriptable;
        context.scratchScriptable = null;
        return scriptable;
    }

    public static long lastUint32Result(Context context) {
        long j2 = context.scratchUint32;
        if ((j2 >>> 32) == 0) {
            return j2;
        }
        throw new IllegalStateException();
    }

    public static Scriptable leaveDotQuery(Scriptable scriptable) {
        return ((NativeWith) scriptable).getParentScope();
    }

    public static Scriptable leaveWith(Scriptable scriptable) {
        return ((NativeWith) scriptable).getParentScope();
    }

    public static String makeUrlForGeneratedScript(boolean z, String str, int i2) {
        if (z) {
            return str + '#' + i2 + "(eval)";
        }
        return str + '#' + i2 + "(Function)";
    }

    public static Ref memberRef(Object obj, Object obj2, Context context, int i2) {
        if (obj instanceof XMLObject) {
            return ((XMLObject) obj).memberRef(context, obj2, i2);
        }
        throw notXmlError(obj);
    }

    public static Object name(Context context, Scriptable scriptable, String str) {
        Scriptable parentScope = scriptable.getParentScope();
        if (parentScope != null) {
            return nameOrFunction(context, scriptable, parentScope, str, false);
        }
        Object obj = topScopeName(context, scriptable, str);
        if (obj != Scriptable.NOT_FOUND) {
            return obj;
        }
        throw notFoundError(scriptable, str);
    }

    @Deprecated
    public static Object nameIncrDecr(Scriptable scriptable, String str, int i2) {
        return nameIncrDecr(scriptable, str, Context.getContext(), i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r6 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075 A[LOOP:0: B:3:0x0002->B:42:0x0075, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x004e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object nameOrFunction(org.mozilla.javascript.Context r5, org.mozilla.javascript.Scriptable r6, org.mozilla.javascript.Scriptable r7, java.lang.String r8, boolean r9) {
        /*
            r0 = 0
            r1 = r6
        L2:
            boolean r2 = r1 instanceof org.mozilla.javascript.NativeWith
            if (r2 == 0) goto L28
            org.mozilla.javascript.Scriptable r1 = r1.getPrototype()
            boolean r2 = r1 instanceof org.mozilla.javascript.xml.XMLObject
            if (r2 == 0) goto L1f
            org.mozilla.javascript.xml.XMLObject r1 = (org.mozilla.javascript.xml.XMLObject) r1
            boolean r2 = r1.has(r8, r1)
            if (r2 == 0) goto L1b
            java.lang.Object r6 = r1.get(r8, r1)
            goto L65
        L1b:
            if (r0 != 0) goto L48
            r0 = r1
            goto L48
        L1f:
            java.lang.Object r2 = org.mozilla.javascript.ScriptableObject.getProperty(r1, r8)
            java.lang.Object r3 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r2 == r3) goto L48
            goto L46
        L28:
            boolean r2 = r1 instanceof org.mozilla.javascript.NativeCall
            if (r2 == 0) goto L3e
            java.lang.Object r1 = r1.get(r8, r1)
            java.lang.Object r2 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r1 == r2) goto L48
            if (r9 == 0) goto L3a
            org.mozilla.javascript.Scriptable r6 = org.mozilla.javascript.ScriptableObject.getTopLevelScope(r7)
        L3a:
            r4 = r1
            r1 = r6
            r6 = r4
            goto L65
        L3e:
            java.lang.Object r2 = org.mozilla.javascript.ScriptableObject.getProperty(r1, r8)
            java.lang.Object r3 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r2 == r3) goto L48
        L46:
            r6 = r2
            goto L65
        L48:
            org.mozilla.javascript.Scriptable r1 = r7.getParentScope()
            if (r1 != 0) goto L75
            java.lang.Object r6 = topScopeName(r5, r7, r8)
            java.lang.Object r1 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r6 != r1) goto L64
            if (r0 == 0) goto L5f
            if (r9 != 0) goto L5f
            java.lang.Object r6 = r0.get(r8, r0)
            goto L64
        L5f:
            java.lang.RuntimeException r5 = notFoundError(r7, r8)
            throw r5
        L64:
            r1 = r7
        L65:
            if (r9 == 0) goto L74
            boolean r7 = r6 instanceof org.mozilla.javascript.Callable
            if (r7 == 0) goto L6f
            storeScriptable(r5, r1)
            goto L74
        L6f:
            java.lang.RuntimeException r5 = notFunctionError(r6, r8)
            throw r5
        L74:
            return r6
        L75:
            r4 = r1
            r1 = r7
            r7 = r4
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.nameOrFunction(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.String, boolean):java.lang.Object");
    }

    public static Ref nameRef(Object obj, Context context, Scriptable scriptable, int i2) {
        return currentXMLLib(context).nameRef(context, obj, scriptable, i2);
    }

    public static Scriptable newArrayLiteral(Object[] objArr, int[] iArr, Context context, Scriptable scriptable) {
        int length = objArr.length;
        int i2 = 0;
        int length2 = iArr != null ? iArr.length : 0;
        int i3 = length + length2;
        if (i3 <= 1 || length2 * 2 >= i3) {
            Scriptable scriptableNewArray = context.newArray(scriptable, i3);
            int i4 = 0;
            int i5 = 0;
            while (i2 != i3) {
                if (i4 == length2 || iArr[i4] != i2) {
                    scriptableNewArray.put(i2, scriptableNewArray, objArr[i5]);
                    i5++;
                } else {
                    i4++;
                }
                i2++;
            }
            return scriptableNewArray;
        }
        if (length2 != 0) {
            Object[] objArr2 = new Object[i3];
            int i6 = 0;
            int i7 = 0;
            while (i2 != i3) {
                if (i6 == length2 || iArr[i6] != i2) {
                    objArr2[i2] = objArr[i7];
                    i7++;
                } else {
                    objArr2[i2] = Scriptable.NOT_FOUND;
                    i6++;
                }
                i2++;
            }
            objArr = objArr2;
        }
        return context.newArray(scriptable, objArr);
    }

    public static Scriptable newBuiltinObject(Context context, Scriptable scriptable, TopLevel.Builtins builtins, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function builtinCtor = TopLevel.getBuiltinCtor(context, topLevelScope, builtins);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return builtinCtor.construct(context, topLevelScope, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.mozilla.javascript.Scriptable newCatchScope(java.lang.Throwable r11, org.mozilla.javascript.Scriptable r12, java.lang.String r13, org.mozilla.javascript.Context r14, org.mozilla.javascript.Scriptable r15) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.newCatchScope(java.lang.Throwable, org.mozilla.javascript.Scriptable, java.lang.String, org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable):org.mozilla.javascript.Scriptable");
    }

    public static Scriptable newNativeError(Context context, Scriptable scriptable, TopLevel.NativeErrors nativeErrors, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function nativeErrorCtor = TopLevel.getNativeErrorCtor(context, topLevelScope, nativeErrors);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return nativeErrorCtor.construct(context, topLevelScope, objArr);
    }

    public static Scriptable newObject(Context context, Scriptable scriptable, String str, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function existingCtor = getExistingCtor(context, topLevelScope, str);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return existingCtor.construct(context, topLevelScope, objArr);
    }

    @Deprecated
    public static Scriptable newObjectLiteral(Object[] objArr, Object[] objArr2, Context context, Scriptable scriptable) {
        return newObjectLiteral(objArr, objArr2, null, context, scriptable);
    }

    public static Object newSpecial(Context context, Object obj, Object[] objArr, Scriptable scriptable, int i2) {
        if (i2 == 1) {
            if (NativeGlobal.isEvalFunction(obj)) {
                throw typeError1("msg.not.ctor", "eval");
            }
        } else {
            if (i2 != 2) {
                throw Kit.codeBug();
            }
            if (NativeWith.isWithFunction(obj)) {
                return NativeWith.newWithSpecial(context, scriptable, objArr);
            }
        }
        return newObject(obj, context, scriptable, objArr);
    }

    public static RuntimeException notFoundError(Scriptable scriptable, String str) {
        throw constructError("ReferenceError", getMessage1("msg.is.not.defined", str));
    }

    public static RuntimeException notFunctionError(Object obj) {
        return notFunctionError(obj, obj);
    }

    private static RuntimeException notXmlError(Object obj) {
        throw typeError1("msg.isnt.xml.object", toString(obj));
    }

    public static String numberToString(double d2, int i2) {
        if (i2 < 2 || i2 > 36) {
            throw Context.reportRuntimeError1("msg.bad.radix", Integer.toString(i2));
        }
        if (Double.isNaN(d2)) {
            return "NaN";
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d2 == Double.NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        if (d2 == 0.0d) {
            return "0";
        }
        if (i2 != 10) {
            return DToA.JS_dtobasestr(i2, d2);
        }
        String strNumberToString = FastDtoa.numberToString(d2);
        if (strNumberToString != null) {
            return strNumberToString;
        }
        StringBuilder sb = new StringBuilder();
        DToA.JS_dtostr(sb, 0, 0, d2);
        return sb.toString();
    }

    public static Object[] padArguments(Object[] objArr, int i2) {
        if (i2 < objArr.length) {
            return objArr;
        }
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        if (objArr.length < i2) {
            Arrays.fill(objArr2, objArr.length, i2, Undefined.instance);
        }
        return objArr2;
    }

    @Deprecated
    public static Object propIncrDecr(Object obj, String str, Context context, int i2) {
        return propIncrDecr(obj, str, context, getTopCallScope(context), i2);
    }

    public static EcmaError rangeError(String str) {
        return constructError("RangeError", str);
    }

    public static Object refDel(Ref ref, Context context) {
        return wrapBoolean(ref.delete(context));
    }

    public static Object refGet(Ref ref, Context context) {
        return ref.get(context);
    }

    @Deprecated
    public static Object refIncrDecr(Ref ref, Context context, int i2) {
        return refIncrDecr(ref, context, getTopCallScope(context), i2);
    }

    @Deprecated
    public static Object refSet(Ref ref, Object obj, Context context) {
        return refSet(ref, obj, context, getTopCallScope(context));
    }

    public static boolean same(Object obj, Object obj2) {
        if (!typeof(obj).equals(typeof(obj2))) {
            return false;
        }
        if (!(obj instanceof Number)) {
            return eq(obj, obj2);
        }
        if (isNaN(obj) && isNaN(obj2)) {
            return true;
        }
        return obj.equals(obj2);
    }

    public static boolean sameZero(Object obj, Object obj2) {
        if (!typeof(obj).equals(typeof(obj2))) {
            return false;
        }
        if (!(obj instanceof Number)) {
            return eq(obj, obj2);
        }
        if (isNaN(obj) && isNaN(obj2)) {
            return true;
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        if (obj2 instanceof Number) {
            double dDoubleValue2 = ((Number) obj2).doubleValue();
            double d2 = negativeZero;
            if ((dDoubleValue == d2 && dDoubleValue2 == 0.0d) || (dDoubleValue == 0.0d && dDoubleValue2 == d2)) {
                return true;
            }
        }
        return eqNumber(dDoubleValue, obj2);
    }

    public static Object searchDefaultNamespace(Context context) {
        Scriptable topCallScope = context.currentActivationCall;
        if (topCallScope == null) {
            topCallScope = getTopCallScope(context);
        }
        while (true) {
            Scriptable parentScope = topCallScope.getParentScope();
            if (parentScope == null) {
                Object property = ScriptableObject.getProperty(topCallScope, DEFAULT_NS_TAG);
                if (property == Scriptable.NOT_FOUND) {
                    return null;
                }
                return property;
            }
            Object obj = topCallScope.get(DEFAULT_NS_TAG, topCallScope);
            if (obj != Scriptable.NOT_FOUND) {
                return obj;
            }
            topCallScope = parentScope;
        }
    }

    public static void setBuiltinProtoAndParent(ScriptableObject scriptableObject, Scriptable scriptable, TopLevel.Builtins builtins) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        scriptableObject.setParentScope(topLevelScope);
        scriptableObject.setPrototype(TopLevel.getBuiltinPrototype(topLevelScope, builtins));
    }

    public static Object setConst(Scriptable scriptable, Object obj, Context context, String str) {
        if (scriptable instanceof XMLObject) {
            scriptable.put(str, scriptable, obj);
        } else {
            ScriptableObject.putConstProperty(scriptable, str, obj);
        }
        return obj;
    }

    public static Object setDefaultNamespace(Object obj, Context context) {
        Scriptable topCallScope = context.currentActivationCall;
        if (topCallScope == null) {
            topCallScope = getTopCallScope(context);
        }
        Object defaultXmlNamespace = currentXMLLib(context).toDefaultXmlNamespace(context, obj);
        if (topCallScope.has(DEFAULT_NS_TAG, topCallScope)) {
            topCallScope.put(DEFAULT_NS_TAG, topCallScope, defaultXmlNamespace);
        } else {
            ScriptableObject.defineProperty(topCallScope, DEFAULT_NS_TAG, defaultXmlNamespace, 6);
        }
        return Undefined.instance;
    }

    public static void setEnumNumbers(Object obj, boolean z) {
        ((IdEnumeration) obj).enumNumbers = z;
    }

    public static void setFunctionProtoAndParent(BaseFunction baseFunction, Scriptable scriptable) {
        setFunctionProtoAndParent(baseFunction, scriptable, false);
    }

    public static Object setName(Scriptable scriptable, Object obj, Context context, Scriptable scriptable2, String str) {
        if (scriptable != null) {
            ScriptableObject.putProperty(scriptable, str, obj);
        } else {
            if (context.hasFeature(11) || context.hasFeature(8)) {
                Context.reportWarning(getMessage1("msg.assn.create.strict", str));
            }
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable2);
            if (context.useDynamicScope) {
                topLevelScope = checkDynamicScope(context.topCallScope, topLevelScope);
            }
            topLevelScope.put(str, topLevelScope, obj);
        }
        return obj;
    }

    @Deprecated
    public static Object setObjectElem(Object obj, Object obj2, Object obj3, Context context) {
        return setObjectElem(obj, obj2, obj3, context, getTopCallScope(context));
    }

    @Deprecated
    public static Object setObjectIndex(Object obj, double d2, Object obj2, Context context) {
        return setObjectIndex(obj, d2, obj2, context, getTopCallScope(context));
    }

    @Deprecated
    public static Object setObjectProp(Object obj, String str, Object obj2, Context context) {
        return setObjectProp(obj, str, obj2, context, getTopCallScope(context));
    }

    public static void setObjectProtoAndParent(ScriptableObject scriptableObject, Scriptable scriptable) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        scriptableObject.setParentScope(topLevelScope);
        scriptableObject.setPrototype(ScriptableObject.getClassPrototype(topLevelScope, scriptableObject.getClassName()));
    }

    public static void setRegExpProxy(Context context, RegExpProxy regExpProxy) {
        if (regExpProxy == null) {
            throw new IllegalArgumentException();
        }
        context.regExpProxy = regExpProxy;
    }

    public static boolean shallowEq(Object obj, Object obj2) {
        if (obj == obj2) {
            if (obj instanceof Number) {
                return !Double.isNaN(((Number) obj).doubleValue());
            }
            return true;
        }
        if (obj == null || obj == Undefined.instance || obj == Undefined.SCRIPTABLE_UNDEFINED) {
            Object obj3 = Undefined.instance;
            return (obj == obj3 && obj2 == Undefined.SCRIPTABLE_UNDEFINED) || (obj == Undefined.SCRIPTABLE_UNDEFINED && obj2 == obj3);
        }
        if (obj instanceof Number) {
            return (obj2 instanceof Number) && ((Number) obj).doubleValue() == ((Number) obj2).doubleValue();
        }
        if (obj instanceof CharSequence) {
            if (obj2 instanceof CharSequence) {
                return obj.toString().equals(obj2.toString());
            }
        } else {
            if (!(obj instanceof Boolean)) {
                if (obj instanceof Scriptable) {
                    return (obj instanceof Wrapper) && (obj2 instanceof Wrapper) && ((Wrapper) obj).unwrap() == ((Wrapper) obj2).unwrap();
                }
                warnAboutNonJSObject(obj);
                return obj == obj2;
            }
            if (obj2 instanceof Boolean) {
                return obj.equals(obj2);
            }
        }
        return false;
    }

    @Deprecated
    public static Ref specialRef(Object obj, String str, Context context) {
        return specialRef(obj, str, context, getTopCallScope(context));
    }

    private static void storeScriptable(Context context, Scriptable scriptable) {
        if (context.scratchScriptable != null) {
            throw new IllegalStateException();
        }
        context.scratchScriptable = scriptable;
    }

    public static void storeUint32Result(Context context, long j2) {
        if ((j2 >>> 32) != 0) {
            throw new IllegalArgumentException();
        }
        context.scratchUint32 = j2;
    }

    public static Object strictSetName(Scriptable scriptable, Object obj, Context context, Scriptable scriptable2, String str) {
        if (scriptable != null) {
            ScriptableObject.putProperty(scriptable, str, obj);
            return obj;
        }
        throw constructError("ReferenceError", "Assignment to undefined \"" + str + "\" in strict mode");
    }

    public static double stringPrefixToNumber(String str, int i2, int i3) {
        return stringToNumber(str, i2, str.length() - 1, i3, true);
    }

    public static double stringToNumber(String str, int i2, int i3, int i4) {
        return stringToNumber(str, i2, i3, i4, false);
    }

    public static long testUint32String(String str) {
        int length = str.length();
        if (1 <= length && length <= 10) {
            int iCharAt = str.charAt(0) - '0';
            if (iCharAt == 0) {
                return length == 1 ? 0L : -1L;
            }
            if (1 <= iCharAt && iCharAt <= 9) {
                long j2 = iCharAt;
                for (int i2 = 1; i2 != length; i2++) {
                    int iCharAt2 = str.charAt(i2) - '0';
                    if (iCharAt2 < 0 || iCharAt2 > 9) {
                        return -1L;
                    }
                    j2 = (j2 * 10) + ((long) iCharAt2);
                }
                if ((j2 >>> 32) == 0) {
                    return j2;
                }
            }
        }
        return -1L;
    }

    public static JavaScriptException throwCustomError(Context context, Scriptable scriptable, String str, String str2) {
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        return new JavaScriptException(context.newObject(scriptable, str, new Object[]{str2, sourcePositionFromStack, Integer.valueOf(iArr[0])}), sourcePositionFromStack, iArr[0]);
    }

    public static JavaScriptException throwError(Context context, Scriptable scriptable, String str) {
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        return new JavaScriptException(newBuiltinObject(context, scriptable, TopLevel.Builtins.Error, new Object[]{str, sourcePositionFromStack, Integer.valueOf(iArr[0])}), sourcePositionFromStack, iArr[0]);
    }

    public static boolean toBoolean(Object obj) {
        while (!(obj instanceof Boolean)) {
            if (obj == null || obj == Undefined.instance) {
                return false;
            }
            if (obj instanceof CharSequence) {
                return ((CharSequence) obj).length() != 0;
            }
            if (obj instanceof Number) {
                double dDoubleValue = ((Number) obj).doubleValue();
                return (Double.isNaN(dDoubleValue) || dDoubleValue == 0.0d) ? false : true;
            }
            if (!(obj instanceof Scriptable)) {
                warnAboutNonJSObject(obj);
                return true;
            }
            if ((obj instanceof ScriptableObject) && ((ScriptableObject) obj).avoidObjectDetection()) {
                return false;
            }
            if (Context.getContext().isVersionECMA1()) {
                return true;
            }
            obj = ((Scriptable) obj).getDefaultValue(BooleanClass);
            if ((obj instanceof Scriptable) && !isSymbol(obj)) {
                throw errorWithClassName("msg.primitive.expected", obj);
            }
        }
        return ((Boolean) obj).booleanValue();
    }

    public static CharSequence toCharSequence(Object obj) {
        return obj instanceof NativeString ? ((NativeString) obj).toCharSequence() : obj instanceof CharSequence ? (CharSequence) obj : toString(obj);
    }

    public static int toInt32(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : toInt32(toNumber(obj));
    }

    public static double toInteger(Object obj) {
        return toInteger(toNumber(obj));
    }

    public static Scriptable toIterator(Context context, Scriptable scriptable, Scriptable scriptable2, boolean z) {
        if (!ScriptableObject.hasProperty(scriptable2, NativeIterator.ITERATOR_PROPERTY_NAME)) {
            return null;
        }
        Object property = ScriptableObject.getProperty(scriptable2, NativeIterator.ITERATOR_PROPERTY_NAME);
        if (!(property instanceof Callable)) {
            throw typeError0("msg.invalid.iterator");
        }
        Callable callable = (Callable) property;
        Object[] objArr = new Object[1];
        objArr[0] = z ? Boolean.TRUE : Boolean.FALSE;
        Object objCall = callable.call(context, scriptable, scriptable2, objArr);
        if (objCall instanceof Scriptable) {
            return (Scriptable) objCall;
        }
        throw typeError0("msg.iterator.primitive");
    }

    public static long toLength(Object[] objArr, int i2) {
        double integer = toInteger(objArr, i2);
        if (integer <= 0.0d) {
            return 0L;
        }
        return (long) Math.min(integer, 9.007199254740991E15d);
    }

    public static double toNumber(Object obj) {
        while (!(obj instanceof Number)) {
            if (obj == null) {
                return 0.0d;
            }
            if (obj == Undefined.instance) {
                return Double.NaN;
            }
            if (obj instanceof String) {
                return toNumber((String) obj);
            }
            if (obj instanceof CharSequence) {
                return toNumber(obj.toString());
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue() ? 1.0d : 0.0d;
            }
            if (obj instanceof Symbol) {
                throw typeError0("msg.not.a.number");
            }
            if (!(obj instanceof Scriptable)) {
                warnAboutNonJSObject(obj);
                return Double.NaN;
            }
            obj = ((Scriptable) obj).getDefaultValue(NumberClass);
            if ((obj instanceof Scriptable) && !isSymbol(obj)) {
                throw errorWithClassName("msg.primitive.expected", obj);
            }
        }
        return ((Number) obj).doubleValue();
    }

    public static Scriptable toObject(Scriptable scriptable, Object obj) {
        return obj instanceof Scriptable ? (Scriptable) obj : toObject(Context.getContext(), scriptable, obj);
    }

    @Deprecated
    public static Scriptable toObjectOrNull(Context context, Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj == null || obj == Undefined.instance) {
            return null;
        }
        return toObject(context, getTopCallScope(context), obj);
    }

    public static Object toPrimitive(Object obj) {
        return toPrimitive(obj, null);
    }

    public static String toString(Object obj) {
        while (obj != null) {
            if (obj == Undefined.instance || obj == Undefined.SCRIPTABLE_UNDEFINED) {
                return "undefined";
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof Number) {
                return numberToString(((Number) obj).doubleValue(), 10);
            }
            if (obj instanceof Symbol) {
                throw typeError0("msg.not.a.string");
            }
            if (!(obj instanceof Scriptable)) {
                return obj.toString();
            }
            obj = ((Scriptable) obj).getDefaultValue(StringClass);
            if ((obj instanceof Scriptable) && !isSymbol(obj)) {
                throw errorWithClassName("msg.primitive.expected", obj);
            }
        }
        return "null";
    }

    public static StringIdOrIndex toStringIdOrIndex(Context context, Object obj) {
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            int i2 = (int) dDoubleValue;
            return ((double) i2) == dDoubleValue ? new StringIdOrIndex(i2) : new StringIdOrIndex(toString(obj));
        }
        String string = obj instanceof String ? (String) obj : toString(obj);
        long jIndexFromString = indexFromString(string);
        return jIndexFromString >= 0 ? new StringIdOrIndex((int) jIndexFromString) : new StringIdOrIndex(string);
    }

    public static char toUint16(Object obj) {
        return (char) DoubleConversion.doubleToInt32(toNumber(obj));
    }

    public static long toUint32(double d2) {
        return ((long) DoubleConversion.doubleToInt32(d2)) & 4294967295L;
    }

    private static Object topScopeName(Context context, Scriptable scriptable, String str) {
        if (context.useDynamicScope) {
            scriptable = checkDynamicScope(context.topCallScope, scriptable);
        }
        return ScriptableObject.getProperty(scriptable, str);
    }

    public static EcmaError typeError(String str) {
        return constructError("TypeError", str);
    }

    public static EcmaError typeError0(String str) {
        return typeError(getMessage0(str));
    }

    public static EcmaError typeError1(String str, Object obj) {
        return typeError(getMessage1(str, obj));
    }

    public static EcmaError typeError2(String str, Object obj, Object obj2) {
        return typeError(getMessage2(str, obj, obj2));
    }

    public static EcmaError typeError3(String str, String str2, String str3, String str4) {
        return typeError(getMessage3(str, str2, str3, str4));
    }

    @Deprecated
    public static BaseFunction typeErrorThrower() {
        return typeErrorThrower(Context.getCurrentContext());
    }

    public static String typeof(Object obj) {
        if (obj == null) {
            return "object";
        }
        if (obj == Undefined.instance) {
            return "undefined";
        }
        if (obj instanceof ScriptableObject) {
            return ((ScriptableObject) obj).getTypeOf();
        }
        if (obj instanceof Scriptable) {
            return obj instanceof Callable ? "function" : "object";
        }
        if (obj instanceof CharSequence) {
            return "string";
        }
        if (obj instanceof Number) {
            return "number";
        }
        if (obj instanceof Boolean) {
            return "boolean";
        }
        throw errorWithClassName("msg.invalid.type", obj);
    }

    public static String typeofName(Scriptable scriptable, String str) {
        Context context = Context.getContext();
        Scriptable scriptableBind = bind(context, scriptable, str);
        return scriptableBind == null ? "undefined" : typeof(getObjectProp(scriptableBind, str, context));
    }

    public static RuntimeException undefCallError(Object obj, Object obj2) {
        return typeError2("msg.undef.method.call", toString(obj), toString(obj2));
    }

    private static RuntimeException undefDeleteError(Object obj, Object obj2) {
        throw typeError2("msg.undef.prop.delete", toString(obj), toString(obj2));
    }

    public static RuntimeException undefReadError(Object obj, Object obj2) {
        return typeError2("msg.undef.prop.read", toString(obj), toString(obj2));
    }

    public static RuntimeException undefWriteError(Object obj, Object obj2, Object obj3) {
        return typeError3("msg.undef.prop.write", toString(obj), toString(obj2), toString(obj3));
    }

    public static String uneval(Context context, Scriptable scriptable, Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj == Undefined.instance) {
            return "undefined";
        }
        if (obj instanceof CharSequence) {
            String strEscapeString = escapeString(obj.toString());
            StringBuilder sb = new StringBuilder(strEscapeString.length() + 2);
            sb.append('\"');
            sb.append(strEscapeString);
            sb.append('\"');
            return sb.toString();
        }
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            return (dDoubleValue != 0.0d || 1.0d / dDoubleValue >= 0.0d) ? toString(dDoubleValue) : "-0";
        }
        if (obj instanceof Boolean) {
            return toString(obj);
        }
        if (!(obj instanceof Scriptable)) {
            warnAboutNonJSObject(obj);
            return obj.toString();
        }
        Scriptable scriptable2 = (Scriptable) obj;
        if (ScriptableObject.hasProperty(scriptable2, "toSource")) {
            Object property = ScriptableObject.getProperty(scriptable2, "toSource");
            if (property instanceof Function) {
                return toString(((Function) property).call(context, scriptable, scriptable2, emptyArgs));
            }
        }
        return toString(obj);
    }

    public static Object updateDotQuery(boolean z, Scriptable scriptable) {
        return ((NativeWith) scriptable).updateDotQuery(z);
    }

    private static void warnAboutNonJSObject(Object obj) {
        if ("true".equals(getMessage0("params.omit.non.js.object.warning"))) {
            return;
        }
        String message2 = getMessage2("msg.non.js.object.warning", obj, obj.getClass().getName());
        Context.reportWarning(message2);
        System.err.println(message2);
    }

    public static Boolean wrapBoolean(boolean z) {
        return Boolean.valueOf(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.mozilla.javascript.Scriptable wrapException(java.lang.Throwable r11, org.mozilla.javascript.Scriptable r12, org.mozilla.javascript.Context r13) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.wrapException(java.lang.Throwable, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Context):org.mozilla.javascript.Scriptable");
    }

    public static Integer wrapInt(int i2) {
        return Integer.valueOf(i2);
    }

    public static Number wrapNumber(double d2) {
        return Double.isNaN(d2) ? NaNobj : Double.valueOf(d2);
    }

    public static Scriptable wrapRegExp(Context context, Scriptable scriptable, Object obj) {
        return context.getRegExpProxy().wrapRegExp(context, scriptable, obj);
    }

    public static Scriptable createFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr, boolean z) {
        return new NativeCall(nativeFunction, scriptable, objArr, false, z);
    }

    @Deprecated
    public static Object delete(Object obj, Object obj2, Context context, boolean z) {
        return delete(obj, obj2, context, getTopCallScope(context), z);
    }

    public static Object doTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, boolean z) {
        if (scriptable == null) {
            throw new IllegalArgumentException();
        }
        if (context.topCallScope != null) {
            throw new IllegalStateException();
        }
        context.topCallScope = ScriptableObject.getTopLevelScope(scriptable);
        context.useDynamicScope = context.hasFeature(7);
        boolean z2 = context.isTopLevelStrict;
        context.isTopLevelStrict = z;
        try {
            Object objDoTopCall = context.getFactory().doTopCall(callable, context, scriptable, scriptable2, objArr);
            context.topCallScope = null;
            context.cachedXMLLib = null;
            context.isTopLevelStrict = z2;
            if (context.currentActivationCall == null) {
                return objDoTopCall;
            }
            throw new IllegalStateException();
        } catch (Throwable th) {
            context.topCallScope = null;
            context.cachedXMLLib = null;
            context.isTopLevelStrict = z2;
            if (context.currentActivationCall != null) {
                throw new IllegalStateException();
            }
            throw th;
        }
    }

    public static Object elemIncrDecr(Object obj, Object obj2, Context context, Scriptable scriptable, int i2) {
        double number;
        Object objectElem = getObjectElem(obj, obj2, context, scriptable);
        boolean z = (i2 & 2) != 0;
        if (objectElem instanceof Number) {
            number = ((Number) objectElem).doubleValue();
        } else {
            number = toNumber(objectElem);
            if (z) {
                objectElem = wrapNumber(number);
            }
        }
        Number numberWrapNumber = wrapNumber((i2 & 1) == 0 ? number + 1.0d : number - 1.0d);
        setObjectElem(obj, obj2, numberWrapNumber, context, scriptable);
        return z ? objectElem : numberWrapNumber;
    }

    @Deprecated
    public static Object enumInit(Object obj, Context context, int i2) {
        return enumInit(obj, context, getTopCallScope(context), i2);
    }

    public static String escapeString(String str, char c2) {
        int i2;
        if (c2 != '\"' && c2 != '\'' && c2 != '`') {
            Kit.codeBug();
        }
        StringBuilder sb = null;
        int length = str.length();
        for (int i3 = 0; i3 != length; i3++) {
            char cCharAt = str.charAt(i3);
            int i4 = 32;
            if (' ' > cCharAt || cCharAt > '~' || cCharAt == c2 || cCharAt == '\\') {
                if (sb == null) {
                    sb = new StringBuilder(length + 3);
                    sb.append(str);
                    sb.setLength(i3);
                }
                if (cCharAt != ' ') {
                    if (cCharAt != '\\') {
                        switch (cCharAt) {
                            case '\b':
                                i4 = 98;
                                break;
                            case '\t':
                                i4 = 116;
                                break;
                            case '\n':
                                i4 = 110;
                                break;
                            case 11:
                                i4 = 118;
                                break;
                            case '\f':
                                i4 = 102;
                                break;
                            case '\r':
                                i4 = 114;
                                break;
                            default:
                                i4 = -1;
                                break;
                        }
                    } else {
                        i4 = 92;
                    }
                }
                if (i4 >= 0) {
                    sb.append('\\');
                    sb.append((char) i4);
                } else if (cCharAt == c2) {
                    sb.append('\\');
                    sb.append(c2);
                } else {
                    if (cCharAt < 256) {
                        sb.append("\\x");
                        i2 = 2;
                    } else {
                        sb.append("\\u");
                        i2 = 4;
                    }
                    for (int i5 = (i2 - 1) * 4; i5 >= 0; i5 -= 4) {
                        int i6 = (cCharAt >> i5) & 15;
                        sb.append((char) (i6 < 10 ? i6 + 48 : i6 + 87));
                    }
                }
            } else if (sb != null) {
                sb.append(cCharAt);
            }
        }
        return sb == null ? str : sb.toString();
    }

    public static Callable getElemFunctionAndThis(Object obj, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull;
        Object property;
        if (isSymbol(obj2)) {
            objectOrNull = toObjectOrNull(context, obj, scriptable);
            if (objectOrNull == null) {
                throw undefCallError(obj, String.valueOf(obj2));
            }
            property = ScriptableObject.getProperty(objectOrNull, (Symbol) obj2);
        } else {
            StringIdOrIndex stringIdOrIndex = toStringIdOrIndex(context, obj2);
            String str = stringIdOrIndex.stringId;
            if (str != null) {
                return getPropFunctionAndThis(obj, str, context, scriptable);
            }
            objectOrNull = toObjectOrNull(context, obj, scriptable);
            if (objectOrNull == null) {
                throw undefCallError(obj, String.valueOf(obj2));
            }
            property = ScriptableObject.getProperty(objectOrNull, stringIdOrIndex.index);
        }
        if (!(property instanceof Callable)) {
            throw notFunctionError(property, obj2);
        }
        storeScriptable(context, objectOrNull);
        return (Callable) property;
    }

    public static Object getObjectElem(Object obj, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return getObjectElem(objectOrNull, obj2, context);
        }
        throw undefReadError(obj, obj2);
    }

    public static Object getObjectIndex(Object obj, double d2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, toString(d2));
        }
        int i2 = (int) d2;
        return ((double) i2) == d2 ? getObjectIndex(objectOrNull, i2, context) : getObjectProp(objectOrNull, toString(d2), context);
    }

    public static Object getObjectProp(Object obj, String str, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return getObjectProp(objectOrNull, str, context);
        }
        throw undefReadError(obj, str);
    }

    public static Object getObjectPropNoWarn(Object obj, String str, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, str);
        }
        Object property = ScriptableObject.getProperty(objectOrNull, str);
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    public static Callable getPropFunctionAndThis(Object obj, String str, Context context, Scriptable scriptable) {
        return getPropFunctionAndThisHelper(obj, str, context, toObjectOrNull(context, obj, scriptable));
    }

    public static Object nameIncrDecr(Scriptable scriptable, String str, Context context, int i2) {
        do {
            if (context.useDynamicScope && scriptable.getParentScope() == null) {
                scriptable = checkDynamicScope(context.topCallScope, scriptable);
            }
            Scriptable prototype = scriptable;
            do {
                if ((prototype instanceof NativeWith) && (prototype.getPrototype() instanceof XMLObject)) {
                    break;
                }
                Object obj = prototype.get(str, scriptable);
                if (obj != Scriptable.NOT_FOUND) {
                    return doScriptableIncrDecr(prototype, str, scriptable, obj, i2);
                }
                prototype = prototype.getPrototype();
            } while (prototype != null);
            scriptable = scriptable.getParentScope();
        } while (scriptable != null);
        throw notFoundError(null, str);
    }

    public static Scriptable newObjectLiteral(Object[] objArr, Object[] objArr2, int[] iArr, Context context, Scriptable scriptable) {
        Scriptable scriptableNewObject = context.newObject(scriptable);
        int length = objArr.length;
        for (int i2 = 0; i2 != length; i2++) {
            Object obj = objArr[i2];
            int i3 = iArr == null ? 0 : iArr[i2];
            Object obj2 = objArr2[i2];
            if (!(obj instanceof String)) {
                scriptableNewObject.put(((Integer) obj).intValue(), scriptableNewObject, obj2);
            } else if (i3 == 0) {
                String str = (String) obj;
                if (isSpecialProperty(str)) {
                    specialRef(scriptableNewObject, str, context, scriptable).set(context, scriptable, obj2);
                } else {
                    scriptableNewObject.put(str, scriptableNewObject, obj2);
                }
            } else {
                ((ScriptableObject) scriptableNewObject).setGetterOrSetter((String) obj, 0, (Callable) obj2, i3 == 1);
            }
        }
        return scriptableNewObject;
    }

    public static RuntimeException notFunctionError(Object obj, Object obj2) {
        String string = obj2 == null ? "null" : obj2.toString();
        return obj == Scriptable.NOT_FOUND ? typeError1("msg.function.not.found", string) : typeError2("msg.isnt.function", string, typeof(obj));
    }

    public static Object propIncrDecr(Object obj, String str, Context context, Scriptable scriptable, int i2) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, str);
        }
        Scriptable prototype = objectOrNull;
        do {
            Object obj2 = prototype.get(str, objectOrNull);
            if (obj2 != Scriptable.NOT_FOUND) {
                return doScriptableIncrDecr(prototype, str, objectOrNull, obj2, i2);
            }
            prototype = prototype.getPrototype();
        } while (prototype != null);
        Double d2 = NaNobj;
        objectOrNull.put(str, objectOrNull, d2);
        return d2;
    }

    public static Object refIncrDecr(Ref ref, Context context, Scriptable scriptable, int i2) {
        double number;
        Object objWrapNumber = ref.get(context);
        boolean z = (i2 & 2) != 0;
        if (objWrapNumber instanceof Number) {
            number = ((Number) objWrapNumber).doubleValue();
        } else {
            number = toNumber(objWrapNumber);
            if (z) {
                objWrapNumber = wrapNumber(number);
            }
        }
        Number numberWrapNumber = wrapNumber((i2 & 1) == 0 ? number + 1.0d : number - 1.0d);
        ref.set(context, scriptable, numberWrapNumber);
        return z ? objWrapNumber : numberWrapNumber;
    }

    public static Object refSet(Ref ref, Object obj, Context context, Scriptable scriptable) {
        return ref.set(context, scriptable, obj);
    }

    public static void setFunctionProtoAndParent(BaseFunction baseFunction, Scriptable scriptable, boolean z) {
        baseFunction.setParentScope(scriptable);
        if (z) {
            baseFunction.setPrototype(ScriptableObject.getGeneratorFunctionPrototype(scriptable));
        } else {
            baseFunction.setPrototype(ScriptableObject.getFunctionPrototype(scriptable));
        }
    }

    public static Object setObjectElem(Object obj, Object obj2, Object obj3, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return setObjectElem(objectOrNull, obj2, obj3, context);
        }
        throw undefWriteError(obj, obj2, obj3);
    }

    public static Object setObjectIndex(Object obj, double d2, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefWriteError(obj, String.valueOf(d2), obj2);
        }
        int i2 = (int) d2;
        return ((double) i2) == d2 ? setObjectIndex(objectOrNull, i2, obj2, context) : setObjectProp(objectOrNull, toString(d2), obj2, context);
    }

    public static Object setObjectProp(Object obj, String str, Object obj2, Context context, Scriptable scriptable) {
        if (!(obj instanceof Scriptable) && context.isStrictMode() && context.getLanguageVersion() >= 180) {
            throw undefWriteError(obj, str, obj2);
        }
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return setObjectProp(objectOrNull, str, obj2, context);
        }
        throw undefWriteError(obj, str, obj2);
    }

    public static Ref specialRef(Object obj, String str, Context context, Scriptable scriptable) {
        return SpecialRef.createSpecial(context, scriptable, obj, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static double stringToNumber(java.lang.String r23, int r24, int r25, int r26, boolean r27) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.stringToNumber(java.lang.String, int, int, int, boolean):double");
    }

    public static double toInteger(double d2) {
        if (Double.isNaN(d2)) {
            return 0.0d;
        }
        return (d2 == 0.0d || Double.isInfinite(d2)) ? d2 : d2 > 0.0d ? Math.floor(d2) : Math.ceil(d2);
    }

    public static Object toPrimitive(Object obj, Class<?> cls) {
        if (!(obj instanceof Scriptable)) {
            return obj;
        }
        Object defaultValue = ((Scriptable) obj).getDefaultValue(cls);
        if (!(defaultValue instanceof Scriptable) || isSymbol(defaultValue)) {
            return defaultValue;
        }
        throw typeError0("msg.bad.default.value");
    }

    public static long toUint32(Object obj) {
        return toUint32(toNumber(obj));
    }

    public static BaseFunction typeErrorThrower(Context context) {
        if (context.typeErrorThrower == null) {
            BaseFunction baseFunction = new BaseFunction() { // from class: org.mozilla.javascript.ScriptRuntime.1
                private static final long serialVersionUID = -5891740962154902286L;

                @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
                public Object call(Context context2, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
                    throw ScriptRuntime.typeError0("msg.op.not.allowed");
                }

                @Override // org.mozilla.javascript.BaseFunction
                public int getLength() {
                    return 0;
                }
            };
            setFunctionProtoAndParent(baseFunction, context.topCallScope);
            baseFunction.preventExtensions();
            context.typeErrorThrower = baseFunction;
        }
        return context.typeErrorThrower;
    }

    public static final class StringIdOrIndex {
        public final int index;
        public final String stringId;

        public StringIdOrIndex(String str) {
            this.stringId = str;
            this.index = -1;
        }

        public StringIdOrIndex(int i2) {
            this.stringId = null;
            this.index = i2;
        }
    }

    public static EcmaError constructError(String str, String str2, int i2) {
        int[] iArr = new int[1];
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        if (iArr[0] != 0) {
            iArr[0] = iArr[0] + i2;
        }
        return constructError(str, str2, sourcePositionFromStack, iArr[0], null, 0);
    }

    public static Object delete(Object obj, Object obj2, Context context, Scriptable scriptable, boolean z) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return wrapBoolean(deleteObjectElem(objectOrNull, obj2, context));
        }
        if (z) {
            return Boolean.TRUE;
        }
        throw undefDeleteError(obj, obj2);
    }

    public static Object enumInit(Object obj, Context context, Scriptable scriptable, int i2) {
        IdEnumeration idEnumeration = new IdEnumeration();
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        idEnumeration.obj = objectOrNull;
        if (i2 == 6) {
            idEnumeration.enumType = i2;
            idEnumeration.iterator = null;
            return enumInitInOrder(context, idEnumeration);
        }
        if (objectOrNull == null) {
            return idEnumeration;
        }
        idEnumeration.enumType = i2;
        idEnumeration.iterator = null;
        if (i2 != 3 && i2 != 4 && i2 != 5) {
            idEnumeration.iterator = toIterator(context, objectOrNull.getParentScope(), idEnumeration.obj, i2 == 0);
        }
        if (idEnumeration.iterator == null) {
            enumChangeObject(idEnumeration);
        }
        return idEnumeration;
    }

    public static Object getIndexObject(double d2) {
        int i2 = (int) d2;
        if (i2 == d2) {
            return Integer.valueOf(i2);
        }
        return toString(d2);
    }

    public static Ref nameRef(Object obj, Object obj2, Context context, Scriptable scriptable, int i2) {
        return currentXMLLib(context).nameRef(context, obj, obj2, scriptable, i2);
    }

    public static int toInt32(Object[] objArr, int i2) {
        if (i2 < objArr.length) {
            return toInt32(objArr[i2]);
        }
        return 0;
    }

    @Deprecated
    public static Scriptable toObject(Scriptable scriptable, Object obj, Class<?> cls) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        return toObject(Context.getContext(), scriptable, obj);
    }

    public static Object getObjectElem(Scriptable scriptable, Object obj, Context context) {
        Object property;
        if (scriptable instanceof XMLObject) {
            property = ((XMLObject) scriptable).get(context, obj);
        } else if (isSymbol(obj)) {
            property = ScriptableObject.getProperty(scriptable, (Symbol) obj);
        } else {
            StringIdOrIndex stringIdOrIndex = toStringIdOrIndex(context, obj);
            String str = stringIdOrIndex.stringId;
            if (str == null) {
                property = ScriptableObject.getProperty(scriptable, stringIdOrIndex.index);
            } else {
                property = ScriptableObject.getProperty(scriptable, str);
            }
        }
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    public static Object getObjectProp(Scriptable scriptable, String str, Context context) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property != Scriptable.NOT_FOUND) {
            return property;
        }
        if (context.hasFeature(11)) {
            Context.reportWarning(getMessage1("msg.ref.undefined.prop", str));
        }
        return Undefined.instance;
    }

    public static Ref memberRef(Object obj, Object obj2, Object obj3, Context context, int i2) {
        if (obj instanceof XMLObject) {
            return ((XMLObject) obj).memberRef(context, obj2, obj3, i2);
        }
        throw notXmlError(obj);
    }

    public static Scriptable newObject(Object obj, Context context, Scriptable scriptable, Object[] objArr) {
        if (obj instanceof Function) {
            return ((Function) obj).construct(context, scriptable, objArr);
        }
        throw notFunctionError(obj);
    }

    public static Object setObjectElem(Scriptable scriptable, Object obj, Object obj2, Context context) {
        if (scriptable instanceof XMLObject) {
            ((XMLObject) scriptable).put(context, obj, obj2);
        } else if (isSymbol(obj)) {
            ScriptableObject.putProperty(scriptable, (Symbol) obj, obj2);
        } else {
            StringIdOrIndex stringIdOrIndex = toStringIdOrIndex(context, obj);
            String str = stringIdOrIndex.stringId;
            if (str == null) {
                ScriptableObject.putProperty(scriptable, stringIdOrIndex.index, obj2);
            } else {
                ScriptableObject.putProperty(scriptable, str, obj2);
            }
        }
        return obj2;
    }

    public static int toInt32(double d2) {
        return DoubleConversion.doubleToInt32(d2);
    }

    public static Scriptable toObjectOrNull(Context context, Object obj, Scriptable scriptable) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj == null || obj == Undefined.instance) {
            return null;
        }
        return toObject(context, scriptable, obj);
    }

    public static RuntimeException notFunctionError(Object obj, Object obj2, String str) {
        int iIndexOf;
        String string = toString(obj);
        if ((obj instanceof NativeFunction) && (iIndexOf = string.indexOf(123, string.indexOf(41))) > -1) {
            string = string.substring(0, iIndexOf + 1) + "...}";
        }
        if (obj2 == Scriptable.NOT_FOUND) {
            return typeError2("msg.function.not.found.in", str, string);
        }
        return typeError3("msg.isnt.function.in", str, string, typeof(obj2));
    }

    public static double toInteger(Object[] objArr, int i2) {
        if (i2 < objArr.length) {
            return toInteger(objArr[i2]);
        }
        return 0.0d;
    }

    public static EcmaError constructError(String str, String str2, String str3, int i2, String str4, int i3) {
        return new EcmaError(str, str2, str3, i2, str4, i3);
    }

    public static Object getObjectIndex(Scriptable scriptable, int i2, Context context) {
        Object property = ScriptableObject.getProperty(scriptable, i2);
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    public static Object setObjectIndex(Scriptable scriptable, int i2, Object obj, Context context) {
        ScriptableObject.putProperty(scriptable, i2, obj);
        return obj;
    }

    public static Scriptable toObject(Context context, Scriptable scriptable, Object obj) {
        if (obj != null) {
            if (!Undefined.isUndefined(obj)) {
                if (isSymbol(obj)) {
                    NativeSymbol nativeSymbol = new NativeSymbol((NativeSymbol) obj);
                    setBuiltinProtoAndParent(nativeSymbol, scriptable, TopLevel.Builtins.Symbol);
                    return nativeSymbol;
                }
                if (obj instanceof Scriptable) {
                    return (Scriptable) obj;
                }
                if (obj instanceof CharSequence) {
                    NativeString nativeString = new NativeString((CharSequence) obj);
                    setBuiltinProtoAndParent(nativeString, scriptable, TopLevel.Builtins.String);
                    return nativeString;
                }
                if (obj instanceof Number) {
                    NativeNumber nativeNumber = new NativeNumber(((Number) obj).doubleValue());
                    setBuiltinProtoAndParent(nativeNumber, scriptable, TopLevel.Builtins.Number);
                    return nativeNumber;
                }
                if (obj instanceof Boolean) {
                    NativeBoolean nativeBoolean = new NativeBoolean(((Boolean) obj).booleanValue());
                    setBuiltinProtoAndParent(nativeBoolean, scriptable, TopLevel.Builtins.Boolean);
                    return nativeBoolean;
                }
                Object objWrap = context.getWrapFactory().wrap(context, scriptable, obj, null);
                if (objWrap instanceof Scriptable) {
                    return (Scriptable) objWrap;
                }
                throw errorWithClassName("msg.invalid.type", obj);
            }
            throw typeError0("msg.undef.to.object");
        }
        throw typeError0("msg.null.to.object");
    }

    public static Object setObjectProp(Scriptable scriptable, String str, Object obj, Context context) {
        ScriptableObject.putProperty(scriptable, str, obj);
        return obj;
    }

    public static String toString(Object[] objArr, int i2) {
        return i2 < objArr.length ? toString(objArr[i2]) : "undefined";
    }

    public static String toString(double d2) {
        return numberToString(d2, 10);
    }

    public static double toNumber(Object[] objArr, int i2) {
        if (i2 < objArr.length) {
            return toNumber(objArr[i2]);
        }
        return Double.NaN;
    }

    public static double toNumber(String str) {
        char cCharAt;
        int i2;
        char cCharAt2;
        int length = str.length();
        int i3 = 0;
        while (i3 != length) {
            char cCharAt3 = str.charAt(i3);
            if (!isStrWhiteSpaceChar(cCharAt3)) {
                int i4 = length - 1;
                while (true) {
                    cCharAt = str.charAt(i4);
                    if (!isStrWhiteSpaceChar(cCharAt)) {
                        break;
                    }
                    i4--;
                }
                Context currentContext = Context.getCurrentContext();
                boolean z = currentContext == null || currentContext.getLanguageVersion() < 200;
                int i5 = 16;
                if (cCharAt3 == '0') {
                    int i6 = i3 + 2;
                    if (i6 <= i4) {
                        char cCharAt4 = str.charAt(i3 + 1);
                        if (cCharAt4 != 'x' && cCharAt4 != 'X') {
                            i5 = (z || !(cCharAt4 == 'o' || cCharAt4 == 'O')) ? (z || !(cCharAt4 == 'b' || cCharAt4 == 'B')) ? -1 : 2 : 8;
                        }
                        if (i5 != -1) {
                            if (z) {
                                return stringPrefixToNumber(str, i6, i5);
                            }
                            return stringToNumber(str, i6, i4, i5);
                        }
                    }
                } else if (z && ((cCharAt3 == '+' || cCharAt3 == '-') && (i2 = i3 + 3) <= i4 && str.charAt(i3 + 1) == '0' && ((cCharAt2 = str.charAt(i3 + 2)) == 'x' || cCharAt2 == 'X'))) {
                    double dStringPrefixToNumber = stringPrefixToNumber(str, i2, 16);
                    return cCharAt3 == '-' ? -dStringPrefixToNumber : dStringPrefixToNumber;
                }
                if (cCharAt == 'y') {
                    if (cCharAt3 == '+' || cCharAt3 == '-') {
                        i3++;
                    }
                    if (i3 + 7 == i4 && str.regionMatches(i3, "Infinity", 0, 8)) {
                        return cCharAt3 == '-' ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                    }
                    return Double.NaN;
                }
                String strSubstring = str.substring(i3, i4 + 1);
                for (int length2 = strSubstring.length() - 1; length2 >= 0; length2--) {
                    char cCharAt5 = strSubstring.charAt(length2);
                    if (('0' > cCharAt5 || cCharAt5 > '9') && cCharAt5 != '.' && cCharAt5 != 'e' && cCharAt5 != 'E' && cCharAt5 != '+' && cCharAt5 != '-') {
                        return Double.NaN;
                    }
                }
                try {
                    return Double.parseDouble(strSubstring);
                } catch (NumberFormatException unused) {
                    return Double.NaN;
                }
            }
            i3++;
        }
        return 0.0d;
    }

    public static CharSequence add(CharSequence charSequence, Object obj) {
        return new ConsString(charSequence, toCharSequence(obj));
    }

    public static CharSequence add(Object obj, CharSequence charSequence) {
        return new ConsString(toCharSequence(obj), charSequence);
    }

    @Deprecated
    public static Scriptable toObject(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        return toObject(context, scriptable, obj);
    }
}
