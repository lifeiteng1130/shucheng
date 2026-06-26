package org.mozilla.javascript.tools.debugger;

import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.NativeCall;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.debug.DebugFrame;
import org.mozilla.javascript.debug.DebuggableObject;
import org.mozilla.javascript.debug.DebuggableScript;
import org.mozilla.javascript.debug.Debugger;

/* JADX INFO: loaded from: classes3.dex */
public class Dim {
    public static final int BREAK = 4;
    public static final int EXIT = 5;
    public static final int GO = 3;
    private static final int IPROXY_COMPILE_SCRIPT = 2;
    private static final int IPROXY_DEBUG = 0;
    private static final int IPROXY_EVAL_SCRIPT = 3;
    private static final int IPROXY_LISTEN = 1;
    private static final int IPROXY_OBJECT_IDS = 7;
    private static final int IPROXY_OBJECT_PROPERTY = 6;
    private static final int IPROXY_OBJECT_TO_STRING = 5;
    private static final int IPROXY_STRING_IS_COMPILABLE = 4;
    public static final int STEP_INTO = 1;
    public static final int STEP_OUT = 2;
    public static final int STEP_OVER = 0;
    private boolean breakFlag;
    private boolean breakOnEnter;
    private boolean breakOnExceptions;
    private boolean breakOnReturn;
    private GuiCallback callback;
    private ContextFactory contextFactory;
    private StackFrame evalFrame;
    private String evalRequest;
    private String evalResult;
    private boolean insideInterruptLoop;
    private volatile ContextData interruptedContextData;
    private DimIProxy listener;
    private ScopeProvider scopeProvider;
    private SourceProvider sourceProvider;
    private int frameIndex = -1;
    private Object monitor = new Object();
    private Object eventThreadMonitor = new Object();
    private volatile int returnValue = -1;
    private final Map<String, SourceInfo> urlToSourceInfo = DesugarCollections.synchronizedMap(new HashMap());
    private final Map<String, FunctionSource> functionNames = DesugarCollections.synchronizedMap(new HashMap());
    private final Map<DebuggableScript, FunctionSource> functionToSource = DesugarCollections.synchronizedMap(new HashMap());

    public static class ContextData {
        private boolean breakNextLine;
        private boolean eventThreadFlag;
        private Throwable lastProcessedException;
        private ObjArray frameStack = new ObjArray();
        private int stopAtFrameDepth = -1;

        public static ContextData get(Context context) {
            return (ContextData) context.getDebuggerContextData();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void popFrame() {
            this.frameStack.pop();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pushFrame(StackFrame stackFrame) {
            this.frameStack.push(stackFrame);
        }

        public int frameCount() {
            return this.frameStack.size();
        }

        public StackFrame getFrame(int i2) {
            return (StackFrame) this.frameStack.get((this.frameStack.size() - i2) - 1);
        }
    }

    public static class DimIProxy implements ContextAction, ContextFactory.Listener, Debugger {
        private boolean booleanResult;
        private Dim dim;
        private Object id;
        private Object object;
        private Object[] objectArrayResult;
        private Object objectResult;
        private String stringResult;
        private String text;
        private int type;
        private String url;

        /* JADX INFO: Access modifiers changed from: private */
        public void withContext() {
            this.dim.contextFactory.call(this);
        }

        @Override // org.mozilla.javascript.ContextFactory.Listener
        public void contextCreated(Context context) {
            if (this.type != 1) {
                Kit.codeBug();
            }
            context.setDebugger(new DimIProxy(this.dim, 0), new ContextData());
            context.setGeneratingDebug(true);
            context.setOptimizationLevel(-1);
        }

        @Override // org.mozilla.javascript.ContextFactory.Listener
        public void contextReleased(Context context) {
            if (this.type != 1) {
                Kit.codeBug();
            }
        }

        @Override // org.mozilla.javascript.debug.Debugger
        public DebugFrame getFrame(Context context, DebuggableScript debuggableScript) {
            if (this.type != 0) {
                Kit.codeBug();
            }
            FunctionSource functionSource = this.dim.getFunctionSource(debuggableScript);
            if (functionSource == null) {
                return null;
            }
            return new StackFrame(context, this.dim, functionSource);
        }

        @Override // org.mozilla.javascript.debug.Debugger
        public void handleCompilationDone(Context context, DebuggableScript debuggableScript, String str) {
            if (this.type != 0) {
                Kit.codeBug();
            }
            if (debuggableScript.isTopLevel()) {
                this.dim.registerTopScript(debuggableScript, str);
            }
        }

        @Override // org.mozilla.javascript.ContextAction
        public Object run(Context context) {
            switch (this.type) {
                case 2:
                    context.compileString(this.text, this.url, 1, null);
                    return null;
                case 3:
                    Scriptable scope = this.dim.scopeProvider != null ? this.dim.scopeProvider.getScope() : null;
                    if (scope == null) {
                        scope = new ImporterTopLevel(context);
                    }
                    context.evaluateString(scope, this.text, this.url, 1, null);
                    return null;
                case 4:
                    this.booleanResult = context.stringIsCompilableUnit(this.text);
                    return null;
                case 5:
                    Object obj = this.object;
                    if (obj == Undefined.instance) {
                        this.stringResult = "undefined";
                    } else if (obj == null) {
                        this.stringResult = "null";
                    } else if (obj instanceof NativeCall) {
                        this.stringResult = "[object Call]";
                    } else {
                        this.stringResult = Context.toString(obj);
                    }
                    return null;
                case 6:
                    this.objectResult = this.dim.getObjectPropertyImpl(context, this.object, this.id);
                    return null;
                case 7:
                    this.objectArrayResult = this.dim.getObjectIdsImpl(context, this.object);
                    return null;
                default:
                    throw Kit.codeBug();
            }
        }

        private DimIProxy(Dim dim, int i2) {
            this.dim = dim;
            this.type = i2;
        }
    }

    public static class FunctionSource {
        private int firstLine;
        private String name;
        private SourceInfo sourceInfo;

        public int firstLine() {
            return this.firstLine;
        }

        public String name() {
            return this.name;
        }

        public SourceInfo sourceInfo() {
            return this.sourceInfo;
        }

        private FunctionSource(SourceInfo sourceInfo, int i2, String str) {
            if (str == null) {
                throw new IllegalArgumentException();
            }
            this.sourceInfo = sourceInfo;
            this.firstLine = i2;
            this.name = str;
        }
    }

    public static class SourceInfo {
        private static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
        private boolean[] breakableLines;
        private boolean[] breakpoints;
        private FunctionSource[] functionSources;
        private String source;
        private String url;

        /* JADX INFO: Access modifiers changed from: private */
        public void copyBreakpointsFrom(SourceInfo sourceInfo) {
            int length = sourceInfo.breakpoints.length;
            boolean[] zArr = this.breakpoints;
            if (length > zArr.length) {
                length = zArr.length;
            }
            for (int i2 = 0; i2 != length; i2++) {
                if (sourceInfo.breakpoints[i2]) {
                    this.breakpoints[i2] = true;
                }
            }
        }

        public boolean breakableLine(int i2) {
            boolean[] zArr = this.breakableLines;
            return i2 < zArr.length && zArr[i2];
        }

        public boolean breakpoint(int i2) {
            if (!breakableLine(i2)) {
                throw new IllegalArgumentException(String.valueOf(i2));
            }
            boolean[] zArr = this.breakpoints;
            return i2 < zArr.length && zArr[i2];
        }

        public FunctionSource functionSource(int i2) {
            return this.functionSources[i2];
        }

        public int functionSourcesTop() {
            return this.functionSources.length;
        }

        public void removeAllBreakpoints() {
            synchronized (this.breakpoints) {
                int i2 = 0;
                while (true) {
                    boolean[] zArr = this.breakpoints;
                    if (i2 != zArr.length) {
                        zArr[i2] = false;
                        i2++;
                    }
                }
            }
        }

        public String source() {
            return this.source;
        }

        public String url() {
            return this.url;
        }

        private SourceInfo(String str, DebuggableScript[] debuggableScriptArr, String str2) {
            this.source = str;
            this.url = str2;
            int length = debuggableScriptArr.length;
            int[][] iArr = new int[length][];
            for (int i2 = 0; i2 != length; i2++) {
                iArr[i2] = debuggableScriptArr[i2].getLineNumbers();
            }
            int[] iArr2 = new int[length];
            int i3 = 0;
            int i4 = 0;
            int i5 = -1;
            while (true) {
                if (i3 == length) {
                    break;
                }
                int[] iArr3 = iArr[i3];
                if (iArr3 == null || iArr3.length == 0) {
                    iArr2[i3] = -1;
                } else {
                    int i6 = iArr3[0];
                    int i7 = i6;
                    for (int i8 = 1; i8 != iArr3.length; i8++) {
                        int i9 = iArr3[i8];
                        if (i9 < i6) {
                            i6 = i9;
                        } else if (i9 > i7) {
                            i7 = i9;
                        }
                    }
                    iArr2[i3] = i6;
                    if (i4 > i5) {
                        i4 = i6;
                    } else {
                        i4 = i6 < i4 ? i6 : i4;
                        if (i7 > i5) {
                        }
                    }
                    i5 = i7;
                }
                i3++;
            }
            if (i4 > i5) {
                boolean[] zArr = EMPTY_BOOLEAN_ARRAY;
                this.breakableLines = zArr;
                this.breakpoints = zArr;
            } else {
                if (i4 < 0) {
                    throw new IllegalStateException(String.valueOf(i4));
                }
                int i10 = i5 + 1;
                this.breakableLines = new boolean[i10];
                this.breakpoints = new boolean[i10];
                for (int i11 = 0; i11 != length; i11++) {
                    int[] iArr4 = iArr[i11];
                    if (iArr4 != null && iArr4.length != 0) {
                        for (int i12 = 0; i12 != iArr4.length; i12++) {
                            this.breakableLines[iArr4[i12]] = true;
                        }
                    }
                }
            }
            this.functionSources = new FunctionSource[length];
            for (int i13 = 0; i13 != length; i13++) {
                String functionName = debuggableScriptArr[i13].getFunctionName();
                if (functionName == null) {
                    functionName = "";
                }
                this.functionSources[i13] = new FunctionSource(this, iArr2[i13], functionName);
            }
        }

        public boolean breakpoint(int i2, boolean z) {
            boolean z2;
            if (breakableLine(i2)) {
                synchronized (this.breakpoints) {
                    boolean[] zArr = this.breakpoints;
                    if (zArr[i2] != z) {
                        zArr[i2] = z;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                return z2;
            }
            throw new IllegalArgumentException(String.valueOf(i2));
        }
    }

    public static class StackFrame implements DebugFrame {
        private boolean[] breakpoints;
        private ContextData contextData;
        private Dim dim;
        private FunctionSource fsource;
        private int lineNumber;
        private Scriptable scope;
        private Scriptable thisObj;

        public ContextData contextData() {
            return this.contextData;
        }

        public String getFunctionName() {
            return this.fsource.name();
        }

        public int getLineNumber() {
            return this.lineNumber;
        }

        public String getUrl() {
            return this.fsource.sourceInfo().url();
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onDebuggerStatement(Context context) {
            this.dim.handleBreakpointHit(this, context);
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onEnter(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            this.contextData.pushFrame(this);
            this.scope = scriptable;
            this.thisObj = scriptable2;
            if (this.dim.breakOnEnter) {
                this.dim.handleBreakpointHit(this, context);
            }
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onExceptionThrown(Context context, Throwable th) {
            this.dim.handleExceptionThrown(context, th, this);
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onExit(Context context, boolean z, Object obj) {
            if (this.dim.breakOnReturn && !z) {
                this.dim.handleBreakpointHit(this, context);
            }
            this.contextData.popFrame();
        }

        @Override // org.mozilla.javascript.debug.DebugFrame
        public void onLineChange(Context context, int i2) {
            this.lineNumber = i2;
            if (!this.breakpoints[i2] && !this.dim.breakFlag) {
                boolean z = this.contextData.breakNextLine;
                if (z && this.contextData.stopAtFrameDepth >= 0) {
                    z = this.contextData.frameCount() <= this.contextData.stopAtFrameDepth;
                }
                if (!z) {
                    return;
                }
                this.contextData.stopAtFrameDepth = -1;
                this.contextData.breakNextLine = false;
            }
            this.dim.handleBreakpointHit(this, context);
        }

        public Object scope() {
            return this.scope;
        }

        public SourceInfo sourceInfo() {
            return this.fsource.sourceInfo();
        }

        public Object thisObj() {
            return this.thisObj;
        }

        private StackFrame(Context context, Dim dim, FunctionSource functionSource) {
            this.dim = dim;
            this.contextData = ContextData.get(context);
            this.fsource = functionSource;
            this.breakpoints = functionSource.sourceInfo().breakpoints;
            this.lineNumber = functionSource.firstLine();
        }
    }

    private static void collectFunctions_r(DebuggableScript debuggableScript, ObjArray objArray) {
        objArray.add(debuggableScript);
        for (int i2 = 0; i2 != debuggableScript.getFunctionCount(); i2++) {
            collectFunctions_r(debuggableScript.getFunction(i2), objArray);
        }
    }

    private static String do_eval(Context context, StackFrame stackFrame, String str) {
        String message = "";
        Debugger debugger = context.getDebugger();
        Object debuggerContextData = context.getDebuggerContextData();
        int optimizationLevel = context.getOptimizationLevel();
        context.setDebugger(null, null);
        context.setOptimizationLevel(-1);
        context.setGeneratingDebug(false);
        try {
            try {
                Object objCall = ((Callable) context.compileString(str, "", 0, null)).call(context, stackFrame.scope, stackFrame.thisObj, ScriptRuntime.emptyArgs);
                if (objCall != Undefined.instance) {
                    message = ScriptRuntime.toString(objCall);
                }
            } catch (Exception e2) {
                message = e2.getMessage();
            }
            return message == null ? "null" : message;
        } finally {
            context.setGeneratingDebug(true);
            context.setOptimizationLevel(optimizationLevel);
            context.setDebugger(debugger, debuggerContextData);
        }
    }

    private FunctionSource functionSource(DebuggableScript debuggableScript) {
        return this.functionToSource.get(debuggableScript);
    }

    private static DebuggableScript[] getAllFunctions(DebuggableScript debuggableScript) {
        ObjArray objArray = new ObjArray();
        collectFunctions_r(debuggableScript, objArray);
        DebuggableScript[] debuggableScriptArr = new DebuggableScript[objArray.size()];
        objArray.toArray(debuggableScriptArr);
        return debuggableScriptArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FunctionSource getFunctionSource(DebuggableScript debuggableScript) {
        String strLoadSource;
        FunctionSource functionSource = functionSource(debuggableScript);
        if (functionSource != null) {
            return functionSource;
        }
        String normalizedUrl = getNormalizedUrl(debuggableScript);
        if (sourceInfo(normalizedUrl) != null || debuggableScript.isGeneratedScript() || (strLoadSource = loadSource(normalizedUrl)) == null) {
            return functionSource;
        }
        DebuggableScript debuggableScript2 = debuggableScript;
        while (true) {
            DebuggableScript parent = debuggableScript2.getParent();
            if (parent == null) {
                registerTopScript(debuggableScript2, strLoadSource);
                return functionSource(debuggableScript);
            }
            debuggableScript2 = parent;
        }
    }

    private String getNormalizedUrl(DebuggableScript debuggableScript) {
        String sourceName = debuggableScript.getSourceName();
        if (sourceName == null) {
            return "<stdin>";
        }
        int length = sourceName.length();
        StringBuilder sb = null;
        int i2 = 0;
        while (true) {
            int iIndexOf = sourceName.indexOf(35, i2);
            if (iIndexOf < 0) {
                break;
            }
            int i3 = iIndexOf + 1;
            int i4 = i3;
            while (i4 != length) {
                char cCharAt = sourceName.charAt(i4);
                if ('0' > cCharAt || cCharAt > '9') {
                    break;
                }
                i4++;
            }
            String str = "(eval)";
            if (i4 == i3 || !"(eval)".regionMatches(0, sourceName, i4, 6)) {
                str = null;
            } else {
                i2 = i4 + 6;
            }
            if (str == null) {
                break;
            }
            if (sb == null) {
                sb = new StringBuilder();
                sb.append(sourceName.substring(0, iIndexOf));
            }
            sb.append(str);
        }
        if (sb == null) {
            return sourceName;
        }
        if (i2 != length) {
            sb.append(sourceName.substring(i2));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] getObjectIdsImpl(Context context, Object obj) {
        if (!(obj instanceof Scriptable) || obj == Undefined.instance) {
            return Context.emptyArgs;
        }
        Scriptable scriptable = (Scriptable) obj;
        Object[] allIds = scriptable instanceof DebuggableObject ? ((DebuggableObject) scriptable).getAllIds() : scriptable.getIds();
        Scriptable prototype = scriptable.getPrototype();
        Scriptable parentScope = scriptable.getParentScope();
        char c2 = 1;
        int i2 = prototype != null ? 1 : 0;
        if (parentScope != null) {
            i2++;
        }
        if (i2 == 0) {
            return allIds;
        }
        Object[] objArr = new Object[allIds.length + i2];
        System.arraycopy(allIds, 0, objArr, i2, allIds.length);
        if (prototype != null) {
            objArr[0] = "__proto__";
        } else {
            c2 = 0;
        }
        if (parentScope != null) {
            objArr[c2] = "__parent__";
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getObjectPropertyImpl(Context context, Object obj, Object obj2) {
        Scriptable scriptable = (Scriptable) obj;
        if (!(obj2 instanceof String)) {
            Object property = ScriptableObject.getProperty(scriptable, ((Integer) obj2).intValue());
            return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
        }
        String str = (String) obj2;
        if (str.equals("this")) {
            return scriptable;
        }
        if (str.equals("__proto__")) {
            return scriptable.getPrototype();
        }
        if (str.equals("__parent__")) {
            return scriptable.getParentScope();
        }
        Object property2 = ScriptableObject.getProperty(scriptable, str);
        return property2 == Scriptable.NOT_FOUND ? Undefined.instance : property2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBreakpointHit(StackFrame stackFrame, Context context) {
        this.breakFlag = false;
        interrupted(context, stackFrame, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleExceptionThrown(Context context, Throwable th, StackFrame stackFrame) {
        if (this.breakOnExceptions) {
            ContextData contextData = stackFrame.contextData();
            if (contextData.lastProcessedException != th) {
                interrupted(context, stackFrame, th);
                contextData.lastProcessedException = th;
            }
        }
    }

    private void interrupted(Context context, StackFrame stackFrame, Throwable th) {
        boolean z;
        int i2;
        ContextData contextData = stackFrame.contextData();
        boolean zIsGuiEventThread = this.callback.isGuiEventThread();
        contextData.eventThreadFlag = zIsGuiEventThread;
        synchronized (this.eventThreadMonitor) {
            if (zIsGuiEventThread) {
                z = this.interruptedContextData != null;
            } else {
                while (this.interruptedContextData != null) {
                    try {
                        this.eventThreadMonitor.wait();
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
            }
            this.interruptedContextData = contextData;
        }
        if (z) {
            return;
        }
        if (this.interruptedContextData == null) {
            Kit.codeBug();
        }
        try {
            this.frameIndex = contextData.frameCount() - 1;
            String string = Thread.currentThread().toString();
            String string2 = th == null ? null : th.toString();
            if (zIsGuiEventThread) {
                this.returnValue = -1;
                this.callback.enterInterrupt(stackFrame, string, string2);
                while (this.returnValue == -1) {
                    try {
                        this.callback.dispatchNextGuiEvent();
                    } catch (InterruptedException unused2) {
                    }
                }
                i2 = this.returnValue;
            } else {
                synchronized (this.monitor) {
                    if (this.insideInterruptLoop) {
                        Kit.codeBug();
                    }
                    this.insideInterruptLoop = true;
                    this.evalRequest = null;
                    this.returnValue = -1;
                    this.callback.enterInterrupt(stackFrame, string, string2);
                    while (true) {
                        try {
                            try {
                                this.monitor.wait();
                                String str = this.evalRequest;
                                if (str != null) {
                                    this.evalResult = null;
                                    try {
                                        this.evalResult = do_eval(context, this.evalFrame, str);
                                        this.evalRequest = null;
                                        this.evalFrame = null;
                                        this.monitor.notify();
                                    } catch (Throwable th2) {
                                        this.evalRequest = null;
                                        this.evalFrame = null;
                                        this.monitor.notify();
                                        throw th2;
                                    }
                                } else if (this.returnValue != -1) {
                                    break;
                                }
                            } catch (InterruptedException unused3) {
                                Thread.currentThread().interrupt();
                                i2 = -1;
                            }
                        } catch (Throwable th3) {
                            this.insideInterruptLoop = false;
                            throw th3;
                        }
                    }
                    i2 = this.returnValue;
                    this.insideInterruptLoop = false;
                }
            }
            if (i2 == 0) {
                contextData.breakNextLine = true;
                contextData.stopAtFrameDepth = contextData.frameCount();
            } else if (i2 == 1) {
                contextData.breakNextLine = true;
                contextData.stopAtFrameDepth = -1;
            } else if (i2 == 2 && contextData.frameCount() > 1) {
                contextData.breakNextLine = true;
                contextData.stopAtFrameDepth = contextData.frameCount() - 1;
            }
            synchronized (this.eventThreadMonitor) {
                this.interruptedContextData = null;
                this.eventThreadMonitor.notifyAll();
            }
        } catch (Throwable th4) {
            synchronized (this.eventThreadMonitor) {
                this.interruptedContextData = null;
                this.eventThreadMonitor.notifyAll();
                throw th4;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[Catch: SecurityException -> 0x0053, IOException -> 0x00b3, TryCatch #0 {SecurityException -> 0x0053, blocks: (B:8:0x0016, B:10:0x001e, B:12:0x0026, B:14:0x003b, B:15:0x0041, B:17:0x004c), top: B:36:0x0016 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005b -> B:26:0x0098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0075 -> B:26:0x0098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0087 -> B:26:0x0098). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String loadSource(java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.debugger.Dim.loadSource(java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerTopScript(DebuggableScript debuggableScript, String str) {
        int i2;
        String source;
        if (!debuggableScript.isTopLevel()) {
            throw new IllegalArgumentException();
        }
        String normalizedUrl = getNormalizedUrl(debuggableScript);
        DebuggableScript[] allFunctions = getAllFunctions(debuggableScript);
        SourceProvider sourceProvider = this.sourceProvider;
        if (sourceProvider != null && (source = sourceProvider.getSource(debuggableScript)) != null) {
            str = source;
        }
        SourceInfo sourceInfo = new SourceInfo(str, allFunctions, normalizedUrl);
        synchronized (this.urlToSourceInfo) {
            SourceInfo sourceInfo2 = this.urlToSourceInfo.get(normalizedUrl);
            if (sourceInfo2 != null) {
                sourceInfo.copyBreakpointsFrom(sourceInfo2);
            }
            this.urlToSourceInfo.put(normalizedUrl, sourceInfo);
            for (int i3 = 0; i3 != sourceInfo.functionSourcesTop(); i3++) {
                FunctionSource functionSource = sourceInfo.functionSource(i3);
                String strName = functionSource.name();
                if (strName.length() != 0) {
                    this.functionNames.put(strName, functionSource);
                }
            }
        }
        synchronized (this.functionToSource) {
            for (i2 = 0; i2 != allFunctions.length; i2++) {
                this.functionToSource.put(allFunctions[i2], sourceInfo.functionSource(i2));
            }
        }
        this.callback.updateSourceText(sourceInfo);
    }

    public void attachTo(ContextFactory contextFactory) {
        detach();
        this.contextFactory = contextFactory;
        DimIProxy dimIProxy = new DimIProxy(1);
        this.listener = dimIProxy;
        contextFactory.addListener(dimIProxy);
    }

    public void clearAllBreakpoints() {
        Iterator<SourceInfo> it = this.urlToSourceInfo.values().iterator();
        while (it.hasNext()) {
            it.next().removeAllBreakpoints();
        }
    }

    public void compileScript(String str, String str2) {
        DimIProxy dimIProxy = new DimIProxy(2);
        dimIProxy.url = str;
        dimIProxy.text = str2;
        dimIProxy.withContext();
    }

    public void contextSwitch(int i2) {
        this.frameIndex = i2;
    }

    public ContextData currentContextData() {
        return this.interruptedContextData;
    }

    public void detach() {
        DimIProxy dimIProxy = this.listener;
        if (dimIProxy != null) {
            this.contextFactory.removeListener(dimIProxy);
            this.contextFactory = null;
            this.listener = null;
        }
    }

    public void dispose() {
        detach();
    }

    public String eval(String str) {
        ContextData contextDataCurrentContextData;
        String str2 = "undefined";
        if (str == null || (contextDataCurrentContextData = currentContextData()) == null || this.frameIndex >= contextDataCurrentContextData.frameCount()) {
            return "undefined";
        }
        StackFrame frame = contextDataCurrentContextData.getFrame(this.frameIndex);
        if (contextDataCurrentContextData.eventThreadFlag) {
            return do_eval(Context.getCurrentContext(), frame, str);
        }
        synchronized (this.monitor) {
            if (this.insideInterruptLoop) {
                this.evalRequest = str;
                this.evalFrame = frame;
                this.monitor.notify();
                do {
                    try {
                        this.monitor.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                } while (this.evalRequest != null);
                str2 = this.evalResult;
            }
        }
        return str2;
    }

    public void evalScript(String str, String str2) {
        DimIProxy dimIProxy = new DimIProxy(3);
        dimIProxy.url = str;
        dimIProxy.text = str2;
        dimIProxy.withContext();
    }

    public String[] functionNames() {
        String[] strArr;
        synchronized (this.urlToSourceInfo) {
            strArr = (String[]) this.functionNames.keySet().toArray(new String[this.functionNames.size()]);
        }
        return strArr;
    }

    public FunctionSource functionSourceByName(String str) {
        return this.functionNames.get(str);
    }

    public Object[] getObjectIds(Object obj) {
        DimIProxy dimIProxy = new DimIProxy(7);
        dimIProxy.object = obj;
        dimIProxy.withContext();
        return dimIProxy.objectArrayResult;
    }

    public Object getObjectProperty(Object obj, Object obj2) {
        DimIProxy dimIProxy = new DimIProxy(6);
        dimIProxy.object = obj;
        dimIProxy.id = obj2;
        dimIProxy.withContext();
        return dimIProxy.objectResult;
    }

    public void go() {
        synchronized (this.monitor) {
            this.returnValue = 3;
            this.monitor.notifyAll();
        }
    }

    public String objectToString(Object obj) {
        DimIProxy dimIProxy = new DimIProxy(5);
        dimIProxy.object = obj;
        dimIProxy.withContext();
        return dimIProxy.stringResult;
    }

    public void setBreak() {
        this.breakFlag = true;
    }

    public void setBreakOnEnter(boolean z) {
        this.breakOnEnter = z;
    }

    public void setBreakOnExceptions(boolean z) {
        this.breakOnExceptions = z;
    }

    public void setBreakOnReturn(boolean z) {
        this.breakOnReturn = z;
    }

    public void setGuiCallback(GuiCallback guiCallback) {
        this.callback = guiCallback;
    }

    public void setReturnValue(int i2) {
        synchronized (this.monitor) {
            this.returnValue = i2;
            this.monitor.notify();
        }
    }

    public void setScopeProvider(ScopeProvider scopeProvider) {
        this.scopeProvider = scopeProvider;
    }

    public void setSourceProvider(SourceProvider sourceProvider) {
        this.sourceProvider = sourceProvider;
    }

    public SourceInfo sourceInfo(String str) {
        return this.urlToSourceInfo.get(str);
    }

    public boolean stringIsCompilableUnit(String str) {
        DimIProxy dimIProxy = new DimIProxy(4);
        dimIProxy.text = str;
        dimIProxy.withContext();
        return dimIProxy.booleanResult;
    }
}
