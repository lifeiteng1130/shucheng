package org.mozilla.javascript;

import c.a.a.a.a;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import k.d.a.c;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.debug.DebuggableScript;
import org.mozilla.javascript.debug.Debugger;
import org.mozilla.javascript.xml.XMLLib;

/* JADX INFO: loaded from: classes3.dex */
public class Context {
    public static final int FEATURE_DYNAMIC_SCOPE = 7;
    public static final int FEATURE_E4X = 6;
    public static final int FEATURE_ENABLE_XML_SECURE_PARSING = 20;
    public static final int FEATURE_ENHANCED_JAVA_ACCESS = 13;
    public static final int FEATURE_ENUMERATE_IDS_FIRST = 16;
    public static final int FEATURE_INTEGER_WITHOUT_DECIMAL_PLACE = 18;
    public static final int FEATURE_LITTLE_ENDIAN = 19;
    public static final int FEATURE_LOCATION_INFORMATION_IN_ERROR = 10;
    public static final int FEATURE_MEMBER_EXPR_AS_FUNCTION_NAME = 2;
    public static final int FEATURE_NON_ECMA_GET_YEAR = 1;
    public static final int FEATURE_OLD_UNDEF_NULL_THIS = 15;
    public static final int FEATURE_PARENT_PROTO_PROPERTIES = 5;

    @Deprecated
    public static final int FEATURE_PARENT_PROTO_PROPRTIES = 5;
    public static final int FEATURE_RESERVED_KEYWORD_AS_IDENTIFIER = 3;
    public static final int FEATURE_STRICT_EVAL = 9;
    public static final int FEATURE_STRICT_MODE = 11;
    public static final int FEATURE_STRICT_VARS = 8;
    public static final int FEATURE_THREAD_SAFE_OBJECTS = 17;
    public static final int FEATURE_TO_STRING_AS_SOURCE = 4;
    public static final int FEATURE_V8_EXTENSIONS = 14;
    public static final int FEATURE_WARNING_AS_ERROR = 12;
    public static final int VERSION_1_0 = 100;
    public static final int VERSION_1_1 = 110;
    public static final int VERSION_1_2 = 120;
    public static final int VERSION_1_3 = 130;
    public static final int VERSION_1_4 = 140;
    public static final int VERSION_1_5 = 150;
    public static final int VERSION_1_6 = 160;
    public static final int VERSION_1_7 = 170;
    public static final int VERSION_1_8 = 180;
    public static final int VERSION_DEFAULT = 0;
    public static final int VERSION_ES6 = 200;
    public static final int VERSION_UNKNOWN = -1;
    public static final String errorReporterProperty = "error reporter";
    public static final String languageVersionProperty = "language version";
    public Set<String> activationNames;
    private ClassLoader applicationClassLoader;
    public XMLLib cachedXMLLib;
    private ClassShutter classShutter;
    public NativeCall currentActivationCall;
    public Debugger debugger;
    private Object debuggerData;
    private int enterCount;
    private ErrorReporter errorReporter;
    private final ContextFactory factory;
    public boolean generateObserverCount;
    private boolean generatingDebug;
    private boolean generatingDebugChanged;
    private boolean generatingSource;
    private boolean hasClassShutter;
    public int instructionCount;
    public int instructionThreshold;
    public Object interpreterSecurityDomain;
    public boolean isContinuationsTopCall;
    public boolean isTopLevelStrict;
    public ObjToIntMap iterating;
    public Object lastInterpreterFrame;
    private Locale locale;
    private int maximumInterpreterStackDepth;
    private int optimizationLevel;
    public ObjArray previousInterpreterInvocations;
    private Object propertyListeners;
    public RegExpProxy regExpProxy;
    public Scriptable scratchScriptable;
    public long scratchUint32;
    private Object sealKey;
    private boolean sealed;
    private SecurityController securityController;
    private Map<Object, Object> threadLocalMap;
    public Scriptable topCallScope;
    public BaseFunction typeErrorThrower;
    public boolean useDynamicScope;
    public int version;
    private WrapFactory wrapFactory;
    public static final Object[] emptyArgs = ScriptRuntime.emptyArgs;
    private static Class<?> codegenClass = Kit.classOrNull("org.mozilla.javascript.optimizer.Codegen");
    private static Class<?> interpreterClass = Kit.classOrNull("org.mozilla.javascript.Interpreter");

    public interface ClassShutterSetter {
        ClassShutter getClassShutter();

        void setClassShutter(ClassShutter classShutter);
    }

    @Deprecated
    public Context() {
        this(ContextFactory.getGlobal());
    }

    @Deprecated
    public static void addContextListener(ContextListener contextListener) {
        if (!"org.mozilla.javascript.tools.debugger.Main".equals(contextListener.getClass().getName())) {
            ContextFactory.getGlobal().addListener(contextListener);
            return;
        }
        try {
            contextListener.getClass().getMethod("attachTo", Kit.classOrNull("org.mozilla.javascript.ContextFactory")).invoke(contextListener, ContextFactory.getGlobal());
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Deprecated
    public static <T> T call(ContextAction<T> contextAction) {
        return (T) call(ContextFactory.getGlobal(), contextAction);
    }

    public static void checkLanguageVersion(int i2) {
        if (!isValidLanguageVersion(i2)) {
            throw new IllegalArgumentException(a.G("Bad language version: ", i2));
        }
    }

    public static void checkOptimizationLevel(int i2) {
        if (!isValidOptimizationLevel(i2)) {
            throw new IllegalArgumentException(a.G("Optimization level outside [-1..9]: ", i2));
        }
    }

    private Object compileImpl(Scriptable scriptable, String str, String str2, int i2, Object obj, boolean z, Evaluator evaluator, ErrorReporter errorReporter) {
        Evaluator evaluatorCreateCompiler;
        Object objCompile;
        String str3 = str2 == null ? "unnamed script" : str2;
        if (obj != null && getSecurityController() == null) {
            throw new IllegalArgumentException("securityDomain should be null if setSecurityController() was never called");
        }
        if (!((scriptable == null) ^ z)) {
            Kit.codeBug();
        }
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        compilerEnvirons.initFromContext(this);
        ErrorReporter errorReporter2 = errorReporter == null ? compilerEnvirons.getErrorReporter() : errorReporter;
        ScriptNode scriptNode = parse(str, str3, i2, compilerEnvirons, errorReporter2, z);
        if (evaluator == null) {
            try {
                evaluatorCreateCompiler = createCompiler();
            } catch (c.a unused) {
                ScriptNode scriptNode2 = parse(str, str3, i2, compilerEnvirons, errorReporter2, z);
                evaluatorCreateCompiler = createInterpreter();
                objCompile = evaluatorCreateCompiler.compile(compilerEnvirons, scriptNode2, scriptNode2.getEncodedSource(), z);
            }
        } else {
            evaluatorCreateCompiler = evaluator;
        }
        objCompile = evaluatorCreateCompiler.compile(compilerEnvirons, scriptNode, scriptNode.getEncodedSource(), z);
        if (this.debugger != null) {
            if (str == null) {
                Kit.codeBug();
            }
            if (!(objCompile instanceof DebuggableScript)) {
                throw new RuntimeException("NOT SUPPORTED");
            }
            notifyDebugger_r(this, (DebuggableScript) objCompile, str);
        }
        return z ? evaluatorCreateCompiler.createFunctionObject(this, scriptable, objCompile, obj) : evaluatorCreateCompiler.createScriptObject(objCompile, obj);
    }

    private Evaluator createCompiler() {
        Class<?> cls;
        Evaluator evaluator = (this.optimizationLevel < 0 || (cls = codegenClass) == null) ? null : (Evaluator) Kit.newInstanceOrNull(cls);
        return evaluator == null ? createInterpreter() : evaluator;
    }

    public static Evaluator createInterpreter() {
        return (Evaluator) Kit.newInstanceOrNull(interpreterClass);
    }

    public static Context enter() {
        return enter(null, ContextFactory.getGlobal());
    }

    public static void exit() {
        VMBridge vMBridge = VMBridge.instance;
        Object threadContextHelper = vMBridge.getThreadContextHelper();
        Context context = vMBridge.getContext(threadContextHelper);
        if (context == null) {
            throw new IllegalStateException("Calling Context.exit without previous Context.enter");
        }
        if (context.enterCount < 1) {
            Kit.codeBug();
        }
        int i2 = context.enterCount - 1;
        context.enterCount = i2;
        if (i2 == 0) {
            vMBridge.setContext(threadContextHelper, null);
            context.factory.onContextReleased(context);
        }
    }

    private void firePropertyChangeImpl(Object obj, String str, Object obj2, Object obj3) {
        int i2 = 0;
        while (true) {
            Object listener = Kit.getListener(obj, i2);
            if (listener == null) {
                return;
            }
            if (listener instanceof PropertyChangeListener) {
                ((PropertyChangeListener) listener).propertyChange(new PropertyChangeEvent(this, str, obj2, obj3));
            }
            i2++;
        }
    }

    public static Context getContext() {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            return currentContext;
        }
        throw new RuntimeException("No Context associated with current Thread");
    }

    public static Context getCurrentContext() {
        VMBridge vMBridge = VMBridge.instance;
        return vMBridge.getContext(vMBridge.getThreadContextHelper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static DebuggableScript getDebuggableView(Script script) {
        if (script instanceof NativeFunction) {
            return ((NativeFunction) script).getDebuggableView();
        }
        return null;
    }

    public static String getSourcePositionFromStack(int[] iArr) {
        int lineNumber;
        Evaluator evaluatorCreateInterpreter;
        Context currentContext = getCurrentContext();
        if (currentContext == null) {
            return null;
        }
        if (currentContext.lastInterpreterFrame != null && (evaluatorCreateInterpreter = createInterpreter()) != null) {
            return evaluatorCreateInterpreter.getSourcePositionFromStack(currentContext, iArr);
        }
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            String fileName = stackTraceElement.getFileName();
            if (fileName != null && !fileName.endsWith(".java") && (lineNumber = stackTraceElement.getLineNumber()) >= 0) {
                iArr[0] = lineNumber;
                return fileName;
            }
        }
        return null;
    }

    public static Object getUndefinedValue() {
        return Undefined.instance;
    }

    public static boolean isValidLanguageVersion(int i2) {
        switch (i2) {
            case 0:
            case 100:
            case 110:
            case 120:
            case 130:
            case 140:
            case 150:
            case 160:
            case VERSION_1_7 /* 170 */:
            case 180:
            case 200:
                return true;
            default:
                return false;
        }
    }

    public static boolean isValidOptimizationLevel(int i2) {
        return -1 <= i2 && i2 <= 9;
    }

    public static Object javaToJS(Object obj, Scriptable scriptable) {
        if ((obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Scriptable)) {
            return obj;
        }
        if (obj instanceof Character) {
            return String.valueOf(((Character) obj).charValue());
        }
        Context context = getContext();
        return context.getWrapFactory().wrap(context, scriptable, obj, null);
    }

    public static Object jsToJava(Object obj, Class<?> cls) {
        return NativeJavaObject.coerceTypeImpl(cls, obj);
    }

    private static void notifyDebugger_r(Context context, DebuggableScript debuggableScript, String str) {
        context.debugger.handleCompilationDone(context, debuggableScript, str);
        for (int i2 = 0; i2 != debuggableScript.getFunctionCount(); i2++) {
            notifyDebugger_r(context, debuggableScript.getFunction(i2), str);
        }
    }

    public static void onSealedMutation() {
        throw new IllegalStateException();
    }

    private ScriptNode parse(String str, String str2, int i2, CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter, boolean z) {
        Parser parser = new Parser(compilerEnvirons, errorReporter);
        if (z) {
            parser.calledByCompileFunction = true;
        }
        if (isStrictMode()) {
            parser.setDefaultUseStrictDirective(true);
        }
        AstRoot astRoot = parser.parse(str, str2, i2);
        if (!z || (astRoot.getFirstChild() != null && astRoot.getFirstChild().getType() == 110)) {
            return new IRFactory(compilerEnvirons, errorReporter).transformTree(astRoot);
        }
        throw new IllegalArgumentException(a.i("compileFunction only accepts source with single JS function: ", str));
    }

    @Deprecated
    public static void removeContextListener(ContextListener contextListener) {
        ContextFactory.getGlobal().addListener(contextListener);
    }

    public static void reportError(String str, String str2, int i2, String str3, int i3) {
        Context currentContext = getCurrentContext();
        if (currentContext == null) {
            throw new EvaluatorException(str, str2, i2, str3, i3);
        }
        currentContext.getErrorReporter().error(str, str2, i2, str3, i3);
    }

    public static EvaluatorException reportRuntimeError(String str, String str2, int i2, String str3, int i3) {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            return currentContext.getErrorReporter().runtimeError(str, str2, i2, str3, i3);
        }
        throw new EvaluatorException(str, str2, i2, str3, i3);
    }

    public static EvaluatorException reportRuntimeError0(String str) {
        return reportRuntimeError(ScriptRuntime.getMessage0(str));
    }

    public static EvaluatorException reportRuntimeError1(String str, Object obj) {
        return reportRuntimeError(ScriptRuntime.getMessage1(str, obj));
    }

    public static EvaluatorException reportRuntimeError2(String str, Object obj, Object obj2) {
        return reportRuntimeError(ScriptRuntime.getMessage2(str, obj, obj2));
    }

    public static EvaluatorException reportRuntimeError3(String str, Object obj, Object obj2, Object obj3) {
        return reportRuntimeError(ScriptRuntime.getMessage3(str, obj, obj2, obj3));
    }

    public static EvaluatorException reportRuntimeError4(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return reportRuntimeError(ScriptRuntime.getMessage4(str, obj, obj2, obj3, obj4));
    }

    public static void reportWarning(String str, String str2, int i2, String str3, int i3) {
        Context context = getContext();
        if (context.hasFeature(12)) {
            reportError(str, str2, i2, str3, i3);
        } else {
            context.getErrorReporter().warning(str, str2, i2, str3, i3);
        }
    }

    @Deprecated
    public static void setCachingEnabled(boolean z) {
    }

    public static RuntimeException throwAsScriptRuntimeEx(Throwable th) {
        Context context;
        while (th instanceof InvocationTargetException) {
            th = ((InvocationTargetException) th).getTargetException();
        }
        if ((th instanceof Error) && ((context = getContext()) == null || !context.hasFeature(13))) {
            throw ((Error) th);
        }
        if (th instanceof RhinoException) {
            throw ((RhinoException) th);
        }
        throw new WrappedException(th);
    }

    public static boolean toBoolean(Object obj) {
        return ScriptRuntime.toBoolean(obj);
    }

    public static double toNumber(Object obj) {
        return ScriptRuntime.toNumber(obj);
    }

    public static Scriptable toObject(Object obj, Scriptable scriptable) {
        return ScriptRuntime.toObject(scriptable, obj);
    }

    public static String toString(Object obj) {
        return ScriptRuntime.toString(obj);
    }

    @Deprecated
    public static Object toType(Object obj, Class<?> cls) {
        try {
            return jsToJava(obj, cls);
        } catch (EvaluatorException e2) {
            throw new IllegalArgumentException(e2.getMessage(), e2);
        }
    }

    public void addActivationName(String str) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.activationNames == null) {
            this.activationNames = new HashSet();
        }
        this.activationNames.add(str);
    }

    public final void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.propertyListeners = Kit.addListener(this.propertyListeners, propertyChangeListener);
    }

    public Object callFunctionWithContinuations(Callable callable, Scriptable scriptable, Object[] objArr) {
        if (!(callable instanceof InterpretedFunction)) {
            throw new IllegalArgumentException("Function argument was not created by interpreted mode ");
        }
        if (ScriptRuntime.hasTopCall(this)) {
            throw new IllegalStateException("Cannot have any pending top calls when executing a script with continuations");
        }
        this.isContinuationsTopCall = true;
        return ScriptRuntime.doTopCall(callable, this, scriptable, scriptable, objArr, this.isTopLevelStrict);
    }

    public ContinuationPending captureContinuation() {
        return new ContinuationPending(Interpreter.captureContinuation(this));
    }

    public final Function compileFunction(Scriptable scriptable, String str, String str2, int i2, Object obj) {
        return compileFunction(scriptable, str, null, null, str2, i2, obj);
    }

    @Deprecated
    public final Script compileReader(Scriptable scriptable, Reader reader, String str, int i2, Object obj) {
        return compileReader(reader, str, i2, obj);
    }

    public final Script compileString(String str, String str2, int i2, Object obj) {
        return compileString(str, null, null, str2, i2 < 0 ? 0 : i2, obj);
    }

    public GeneratedClassLoader createClassLoader(ClassLoader classLoader) {
        return getFactory().createClassLoader(classLoader);
    }

    public final String decompileFunction(Function function, int i2) {
        if (function instanceof BaseFunction) {
            return ((BaseFunction) function).decompile(i2, 0);
        }
        StringBuilder sbR = a.r("function ");
        sbR.append(function.getClassName());
        sbR.append("() {\n\t[native code]\n}\n");
        return sbR.toString();
    }

    public final String decompileFunctionBody(Function function, int i2) {
        return function instanceof BaseFunction ? ((BaseFunction) function).decompile(i2, 1) : "[native code]\n";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String decompileScript(Script script, int i2) {
        return ((NativeFunction) script).decompile(i2, 0);
    }

    public final Object evaluateReader(Scriptable scriptable, Reader reader, String str, int i2, Object obj) {
        Script scriptCompileReader = compileReader(scriptable, reader, str, i2, obj);
        if (scriptCompileReader != null) {
            return scriptCompileReader.exec(this, scriptable);
        }
        return null;
    }

    public final Object evaluateString(Scriptable scriptable, String str, String str2, int i2, Object obj) {
        Script scriptCompileString = compileString(str, str2, i2, obj);
        if (scriptCompileString != null) {
            return scriptCompileString.exec(this, scriptable);
        }
        return null;
    }

    public Object executeScriptWithContinuations(Script script, Scriptable scriptable) {
        if (script instanceof InterpretedFunction) {
            InterpretedFunction interpretedFunction = (InterpretedFunction) script;
            if (interpretedFunction.isScript()) {
                return callFunctionWithContinuations(interpretedFunction, scriptable, ScriptRuntime.emptyArgs);
            }
        }
        throw new IllegalArgumentException("Script argument was not a script or was not created by interpreted mode ");
    }

    public final void firePropertyChange(String str, Object obj, Object obj2) {
        Object obj3 = this.propertyListeners;
        if (obj3 != null) {
            firePropertyChangeImpl(obj3, str, obj, obj2);
        }
    }

    public final ClassLoader getApplicationClassLoader() {
        if (this.applicationClassLoader == null) {
            ContextFactory factory = getFactory();
            ClassLoader applicationClassLoader = factory.getApplicationClassLoader();
            if (applicationClassLoader == null) {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null && Kit.testIfCanLoadRhinoClasses(contextClassLoader)) {
                    return contextClassLoader;
                }
                Class<?> cls = factory.getClass();
                applicationClassLoader = cls != ScriptRuntime.ContextFactoryClass ? cls.getClassLoader() : getClass().getClassLoader();
            }
            this.applicationClassLoader = applicationClassLoader;
        }
        return this.applicationClassLoader;
    }

    public final synchronized ClassShutter getClassShutter() {
        return this.classShutter;
    }

    public final synchronized ClassShutterSetter getClassShutterSetter() {
        if (this.hasClassShutter) {
            return null;
        }
        this.hasClassShutter = true;
        return new ClassShutterSetter() { // from class: org.mozilla.javascript.Context.1
            @Override // org.mozilla.javascript.Context.ClassShutterSetter
            public ClassShutter getClassShutter() {
                return Context.this.classShutter;
            }

            @Override // org.mozilla.javascript.Context.ClassShutterSetter
            public void setClassShutter(ClassShutter classShutter) {
                Context.this.classShutter = classShutter;
            }
        };
    }

    public final Debugger getDebugger() {
        return this.debugger;
    }

    public final Object getDebuggerContextData() {
        return this.debuggerData;
    }

    public XMLLib.Factory getE4xImplementationFactory() {
        return getFactory().getE4xImplementationFactory();
    }

    public final Object[] getElements(Scriptable scriptable) {
        return ScriptRuntime.getArrayElements(scriptable);
    }

    public final ErrorReporter getErrorReporter() {
        ErrorReporter errorReporter = this.errorReporter;
        return errorReporter == null ? DefaultErrorReporter.instance : errorReporter;
    }

    public final ContextFactory getFactory() {
        return this.factory;
    }

    public final String getImplementationVersion() {
        return ImplementationVersion.get();
    }

    public final int getInstructionObserverThreshold() {
        return this.instructionThreshold;
    }

    public final int getLanguageVersion() {
        return this.version;
    }

    public final Locale getLocale() {
        if (this.locale == null) {
            this.locale = Locale.getDefault();
        }
        return this.locale;
    }

    public final int getMaximumInterpreterStackDepth() {
        return this.maximumInterpreterStackDepth;
    }

    public final int getOptimizationLevel() {
        return this.optimizationLevel;
    }

    public RegExpProxy getRegExpProxy() {
        Class<?> clsClassOrNull;
        if (this.regExpProxy == null && (clsClassOrNull = Kit.classOrNull("org.mozilla.javascript.regexp.RegExpImpl")) != null) {
            this.regExpProxy = (RegExpProxy) Kit.newInstanceOrNull(clsClassOrNull);
        }
        return this.regExpProxy;
    }

    public SecurityController getSecurityController() {
        SecurityController securityControllerGlobal = SecurityController.global();
        return securityControllerGlobal != null ? securityControllerGlobal : this.securityController;
    }

    public final Object getThreadLocal(Object obj) {
        Map<Object, Object> map = this.threadLocalMap;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    public final WrapFactory getWrapFactory() {
        if (this.wrapFactory == null) {
            this.wrapFactory = new WrapFactory();
        }
        return this.wrapFactory;
    }

    public boolean hasFeature(int i2) {
        return getFactory().hasFeature(this, i2);
    }

    public final ScriptableObject initSafeStandardObjects() {
        return initSafeStandardObjects(null, false);
    }

    public final ScriptableObject initStandardObjects() {
        return initStandardObjects(null, false);
    }

    public final boolean isActivationNeeded(String str) {
        Set<String> set = this.activationNames;
        return set != null && set.contains(str);
    }

    public final boolean isGeneratingDebug() {
        return this.generatingDebug;
    }

    public final boolean isGeneratingDebugChanged() {
        return this.generatingDebugChanged;
    }

    public final boolean isGeneratingSource() {
        return this.generatingSource;
    }

    public final boolean isSealed() {
        return this.sealed;
    }

    public final boolean isStrictMode() {
        NativeCall nativeCall;
        return this.isTopLevelStrict || ((nativeCall = this.currentActivationCall) != null && nativeCall.isStrict);
    }

    public final boolean isVersionECMA1() {
        int i2 = this.version;
        return i2 == 0 || i2 >= 130;
    }

    public Scriptable newArray(Scriptable scriptable, int i2) {
        NativeArray nativeArray = new NativeArray(i2);
        ScriptRuntime.setBuiltinProtoAndParent(nativeArray, scriptable, TopLevel.Builtins.Array);
        return nativeArray;
    }

    public Scriptable newObject(Scriptable scriptable) {
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, scriptable, TopLevel.Builtins.Object);
        return nativeObject;
    }

    public void observeInstructionCount(int i2) {
        getFactory().observeInstructionCount(this, i2);
    }

    public final synchronized void putThreadLocal(Object obj, Object obj2) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.threadLocalMap == null) {
            this.threadLocalMap = new HashMap();
        }
        this.threadLocalMap.put(obj, obj2);
    }

    public void removeActivationName(String str) {
        if (this.sealed) {
            onSealedMutation();
        }
        Set<String> set = this.activationNames;
        if (set != null) {
            set.remove(str);
        }
    }

    public final void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.propertyListeners = Kit.removeListener(this.propertyListeners, propertyChangeListener);
    }

    public final void removeThreadLocal(Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        Map<Object, Object> map = this.threadLocalMap;
        if (map == null) {
            return;
        }
        map.remove(obj);
    }

    public Object resumeContinuation(Object obj, Scriptable scriptable, Object obj2) {
        return Interpreter.restartContinuation((NativeContinuation) obj, this, scriptable, new Object[]{obj2});
    }

    public final void seal(Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.sealed = true;
        this.sealKey = obj;
    }

    public final void setApplicationClassLoader(ClassLoader classLoader) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (classLoader == null) {
            this.applicationClassLoader = null;
        } else {
            if (!Kit.testIfCanLoadRhinoClasses(classLoader)) {
                throw new IllegalArgumentException("Loader can not resolve Rhino classes");
            }
            this.applicationClassLoader = classLoader;
        }
    }

    public final synchronized void setClassShutter(ClassShutter classShutter) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (classShutter == null) {
            throw new IllegalArgumentException();
        }
        if (this.hasClassShutter) {
            throw new SecurityException("Cannot overwrite existing ClassShutter object");
        }
        this.classShutter = classShutter;
        this.hasClassShutter = true;
    }

    public final void setDebugger(Debugger debugger, Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.debugger = debugger;
        this.debuggerData = obj;
    }

    public final ErrorReporter setErrorReporter(ErrorReporter errorReporter) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (errorReporter == null) {
            throw new IllegalArgumentException();
        }
        ErrorReporter errorReporter2 = getErrorReporter();
        if (errorReporter == errorReporter2) {
            return errorReporter2;
        }
        Object obj = this.propertyListeners;
        if (obj != null) {
            firePropertyChangeImpl(obj, errorReporterProperty, errorReporter2, errorReporter);
        }
        this.errorReporter = errorReporter;
        return errorReporter2;
    }

    public void setGenerateObserverCount(boolean z) {
        this.generateObserverCount = z;
    }

    public final void setGeneratingDebug(boolean z) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.generatingDebugChanged = true;
        if (z && getOptimizationLevel() > 0) {
            setOptimizationLevel(0);
        }
        this.generatingDebug = z;
    }

    public final void setGeneratingSource(boolean z) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.generatingSource = z;
    }

    public final void setInstructionObserverThreshold(int i2) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.instructionThreshold = i2;
        setGenerateObserverCount(i2 > 0);
    }

    public void setLanguageVersion(int i2) {
        int i3;
        if (this.sealed) {
            onSealedMutation();
        }
        checkLanguageVersion(i2);
        Object obj = this.propertyListeners;
        if (obj != null && i2 != (i3 = this.version)) {
            firePropertyChangeImpl(obj, languageVersionProperty, Integer.valueOf(i3), Integer.valueOf(i2));
        }
        this.version = i2;
    }

    public final Locale setLocale(Locale locale) {
        if (this.sealed) {
            onSealedMutation();
        }
        Locale locale2 = this.locale;
        this.locale = locale;
        return locale2;
    }

    public final void setMaximumInterpreterStackDepth(int i2) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.optimizationLevel != -1) {
            throw new IllegalStateException("Cannot set maximumInterpreterStackDepth when optimizationLevel != -1");
        }
        if (i2 < 1) {
            throw new IllegalArgumentException("Cannot set maximumInterpreterStackDepth to less than 1");
        }
        this.maximumInterpreterStackDepth = i2;
    }

    public final void setOptimizationLevel(int i2) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (i2 == -2) {
            i2 = -1;
        }
        checkOptimizationLevel(i2);
        this.optimizationLevel = codegenClass != null ? i2 : -1;
    }

    public final void setSecurityController(SecurityController securityController) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (securityController == null) {
            throw new IllegalArgumentException();
        }
        if (this.securityController != null) {
            throw new SecurityException("Can not overwrite existing SecurityController object");
        }
        if (SecurityController.hasGlobal()) {
            throw new SecurityException("Can not overwrite existing global SecurityController object");
        }
        this.securityController = securityController;
    }

    public final void setWrapFactory(WrapFactory wrapFactory) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (wrapFactory == null) {
            throw new IllegalArgumentException();
        }
        this.wrapFactory = wrapFactory;
    }

    public final boolean stringIsCompilableUnit(String str) {
        boolean z;
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        compilerEnvirons.initFromContext(this);
        compilerEnvirons.setGeneratingSource(false);
        Parser parser = new Parser(compilerEnvirons, DefaultErrorReporter.instance);
        try {
            parser.parse(str, (String) null, 1);
            z = false;
        } catch (EvaluatorException unused) {
            z = true;
        }
        return (z && parser.eof()) ? false : true;
    }

    public final void unseal(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (this.sealKey != obj) {
            throw new IllegalArgumentException();
        }
        if (!this.sealed) {
            throw new IllegalStateException();
        }
        this.sealed = false;
        this.sealKey = null;
    }

    public Context(ContextFactory contextFactory) {
        this.generatingSource = true;
        this.generateObserverCount = false;
        if (contextFactory == null) {
            throw new IllegalArgumentException("factory == null");
        }
        this.factory = contextFactory;
        this.version = 0;
        this.optimizationLevel = codegenClass == null ? -1 : 0;
        this.maximumInterpreterStackDepth = Integer.MAX_VALUE;
    }

    public static Object call(ContextFactory contextFactory, final Callable callable, final Scriptable scriptable, final Scriptable scriptable2, final Object[] objArr) {
        if (contextFactory == null) {
            contextFactory = ContextFactory.getGlobal();
        }
        return call(contextFactory, new ContextAction() { // from class: k.d.b.a
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                Callable callable2 = callable;
                Scriptable scriptable3 = scriptable;
                Scriptable scriptable4 = scriptable2;
                Object[] objArr2 = objArr;
                int i2 = Context.VERSION_UNKNOWN;
                return callable2.call(context, scriptable3, scriptable4, objArr2);
            }
        });
    }

    @Deprecated
    public static Context enter(Context context) {
        return enter(context, ContextFactory.getGlobal());
    }

    @Deprecated
    public static Scriptable toObject(Object obj, Scriptable scriptable, Class<?> cls) {
        return ScriptRuntime.toObject(scriptable, obj);
    }

    public final Function compileFunction(Scriptable scriptable, String str, Evaluator evaluator, ErrorReporter errorReporter, String str2, int i2, Object obj) {
        try {
            return (Function) compileImpl(scriptable, str, str2, i2, obj, true, evaluator, errorReporter);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final Script compileReader(Reader reader, String str, int i2, Object obj) {
        return (Script) compileImpl(null, Kit.readReader(reader), str, i2 < 0 ? 0 : i2, obj, false, null, null);
    }

    public final Script compileString(String str, Evaluator evaluator, ErrorReporter errorReporter, String str2, int i2, Object obj) {
        try {
            return (Script) compileImpl(null, str, str2, i2, obj, false, evaluator, errorReporter);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final Scriptable initSafeStandardObjects(ScriptableObject scriptableObject) {
        return initSafeStandardObjects(scriptableObject, false);
    }

    public final Scriptable initStandardObjects(ScriptableObject scriptableObject) {
        return initStandardObjects(scriptableObject, false);
    }

    public static final Context enter(Context context, ContextFactory contextFactory) {
        VMBridge vMBridge = VMBridge.instance;
        Object threadContextHelper = vMBridge.getThreadContextHelper();
        Context context2 = vMBridge.getContext(threadContextHelper);
        if (context2 == null) {
            if (context == null) {
                context = contextFactory.makeContext();
                if (context.enterCount == 0) {
                    contextFactory.onContextCreated(context);
                    if (contextFactory.isSealed() && !context.isSealed()) {
                        context.seal(null);
                    }
                } else {
                    throw new IllegalStateException("factory.makeContext() returned Context instance already associated with some thread");
                }
            } else if (context.enterCount != 0) {
                throw new IllegalStateException("can not use Context instance already associated with some thread");
            }
            vMBridge.setContext(threadContextHelper, context);
            context2 = context;
        }
        context2.enterCount++;
        return context2;
    }

    public ScriptableObject initSafeStandardObjects(ScriptableObject scriptableObject, boolean z) {
        return ScriptRuntime.initSafeStandardObjects(this, scriptableObject, z);
    }

    public ScriptableObject initStandardObjects(ScriptableObject scriptableObject, boolean z) {
        return ScriptRuntime.initStandardObjects(this, scriptableObject, z);
    }

    public Scriptable newArray(Scriptable scriptable, Object[] objArr) {
        if (objArr.getClass().getComponentType() == ScriptRuntime.ObjectClass) {
            NativeArray nativeArray = new NativeArray(objArr);
            ScriptRuntime.setBuiltinProtoAndParent(nativeArray, scriptable, TopLevel.Builtins.Array);
            return nativeArray;
        }
        throw new IllegalArgumentException();
    }

    public Scriptable newObject(Scriptable scriptable, String str) {
        return newObject(scriptable, str, ScriptRuntime.emptyArgs);
    }

    public static <T> T call(ContextFactory contextFactory, ContextAction<T> contextAction) {
        try {
            return contextAction.run(enter(null, contextFactory));
        } finally {
            exit();
        }
    }

    public static void reportError(String str) {
        int[] iArr = {0};
        reportError(str, getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public Scriptable newObject(Scriptable scriptable, String str, Object[] objArr) {
        return ScriptRuntime.newObject(this, scriptable, str, objArr);
    }

    public static EvaluatorException reportRuntimeError(String str) {
        int[] iArr = {0};
        return reportRuntimeError(str, getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static void reportWarning(String str) {
        int[] iArr = {0};
        reportWarning(str, getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static void reportWarning(String str, Throwable th) {
        int[] iArr = {0};
        String sourcePositionFromStack = getSourcePositionFromStack(iArr);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println(str);
        th.printStackTrace(printWriter);
        printWriter.flush();
        reportWarning(stringWriter.toString(), sourcePositionFromStack, iArr[0], null, 0);
    }
}
