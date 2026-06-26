package org.mozilla.javascript.optimizer;

import androidx.core.app.NotificationCompat;
import c.a.a.a.a;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.analytics.pro.ai;
import java.util.HashMap;
import java.util.List;
import k.d.a.c;
import org.jsoup.nodes.Attributes;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Evaluator;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.GeneratedClassLoader;
import org.mozilla.javascript.NativeFunction;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.SecurityController;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: loaded from: classes3.dex */
public class Codegen implements Evaluator {
    public static final String DEFAULT_MAIN_METHOD_CLASS = "org.mozilla.javascript.optimizer.OptRuntime";
    public static final String FUNCTION_CONSTRUCTOR_SIGNATURE = "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V";
    public static final String FUNCTION_INIT_SIGNATURE = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V";
    public static final String ID_FIELD_NAME = "_id";
    public static final String REGEXP_INIT_METHOD_NAME = "_reInit";
    public static final String REGEXP_INIT_METHOD_SIGNATURE = "(Lorg/mozilla/javascript/Context;)V";
    private static final String SUPER_CLASS_NAME = "org.mozilla.javascript.NativeFunction";
    private static final Object globalLock = new Object();
    private static int globalSerialClassCounter;
    private CompilerEnvirons compilerEnv;
    private ObjArray directCallTargets;
    private double[] itsConstantList;
    private int itsConstantListSize;
    public String mainClassName;
    public String mainClassSignature;
    private String mainMethodClass = DEFAULT_MAIN_METHOD_CLASS;
    private ObjToIntMap scriptOrFnIndexes;
    public ScriptNode[] scriptOrFnNodes;

    private static void addDoubleWrap(c cVar) {
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/optimizer/OptRuntime", "wrapDouble", "(D)Ljava/lang/Double;");
    }

    public static RuntimeException badTree() {
        throw new RuntimeException("Bad tree in codegen");
    }

    private static void collectScriptNodes_r(ScriptNode scriptNode, ObjArray objArray) {
        objArray.add(scriptNode);
        int functionCount = scriptNode.getFunctionCount();
        for (int i2 = 0; i2 != functionCount; i2++) {
            collectScriptNodes_r(scriptNode.getFunctionNode(i2), objArray);
        }
    }

    private Class<?> defineClass(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        String str = (String) objArr[0];
        byte[] bArr = (byte[]) objArr[1];
        GeneratedClassLoader generatedClassLoaderCreateLoader = SecurityController.createLoader(getClass().getClassLoader(), obj2);
        try {
            Class<?> clsDefineClass = generatedClassLoaderCreateLoader.defineClass(str, bArr);
            generatedClassLoaderCreateLoader.linkClass(clsDefineClass);
            return clsDefineClass;
        } catch (IllegalArgumentException | SecurityException e2) {
            throw new RuntimeException("Malformed optimizer package " + e2);
        }
    }

    private void emitConstantDudeInitializers(c cVar) {
        int i2 = this.itsConstantListSize;
        if (i2 == 0) {
            return;
        }
        cVar.Q("<clinit>", "()V", (short) 24);
        double[] dArr = this.itsConstantList;
        for (int i3 = 0; i3 != i2; i3++) {
            double d2 = dArr[i3];
            String strG = a.G("_k", i3);
            String staticConstantWrapperType = getStaticConstantWrapperType(d2);
            cVar.l(strG, staticConstantWrapperType, (short) 10);
            int i4 = (int) d2;
            if (i4 == d2) {
                cVar.t(i4);
                cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else {
                cVar.s(d2);
                addDoubleWrap(cVar);
            }
            cVar.f(179, this.mainClassName, strG, staticConstantWrapperType);
        }
        cVar.c(177);
        cVar.R((short) 0);
    }

    private void emitDirectConstructor(c cVar, OptFunctionNode optFunctionNode) {
        cVar.Q(getDirectCtorName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode), (short) 10);
        int paramCount = optFunctionNode.fnode.getParamCount();
        int i2 = (paramCount * 3) + 4;
        int i3 = i2 + 1;
        cVar.g(0);
        cVar.g(1);
        cVar.g(2);
        cVar.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "org/mozilla/javascript/BaseFunction", "createObject", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        cVar.h(i3);
        cVar.g(0);
        cVar.g(1);
        cVar.g(2);
        cVar.g(i3);
        for (int i4 = 0; i4 < paramCount; i4++) {
            int i5 = i4 * 3;
            cVar.g(i5 + 4);
            cVar.i(i5 + 5);
        }
        cVar.g(i2);
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, this.mainClassName, getBodyMethodName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode));
        int iB = cVar.b();
        cVar.c(89);
        cVar.e(193, "org/mozilla/javascript/Scriptable");
        cVar.d(153, iB);
        cVar.e(192, "org/mozilla/javascript/Scriptable");
        cVar.c(176);
        cVar.H(iB);
        cVar.g(i3);
        cVar.c(176);
        cVar.R((short) (i3 + 1));
    }

    private void emitRegExpInit(c cVar) {
        int i2 = 0;
        int i3 = 0;
        int regexpCount = 0;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i3 == scriptNodeArr.length) {
                break;
            }
            regexpCount += scriptNodeArr[i3].getRegexpCount();
            i3++;
        }
        if (regexpCount == 0) {
            return;
        }
        short s = 10;
        cVar.Q(REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE, (short) 10);
        cVar.l("_reInitDone", "Z", (short) 74);
        cVar.f(178, this.mainClassName, "_reInitDone", "Z");
        int iB = cVar.b();
        cVar.d(153, iB);
        cVar.c(177);
        cVar.H(iB);
        cVar.g(0);
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/ScriptRuntime", "checkRegExpProxy", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/RegExpProxy;");
        cVar.h(1);
        int i4 = 0;
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i4 == scriptNodeArr2.length) {
                cVar.t(1);
                cVar.f(179, this.mainClassName, "_reInitDone", "Z");
                cVar.c(177);
                cVar.R((short) 2);
                return;
            }
            ScriptNode scriptNode = scriptNodeArr2[i4];
            int regexpCount2 = scriptNode.getRegexpCount();
            int i5 = 0;
            while (i5 != regexpCount2) {
                String compiledRegexpName = getCompiledRegexpName(scriptNode, i5);
                String regexpString = scriptNode.getRegexpString(i5);
                String regexpFlags = scriptNode.getRegexpFlags(i5);
                cVar.l(compiledRegexpName, "Ljava/lang/Object;", s);
                cVar.g(1);
                cVar.g(i2);
                cVar.u(regexpString);
                if (regexpFlags == null) {
                    cVar.c(1);
                } else {
                    cVar.u(regexpFlags);
                }
                cVar.o(185, "org/mozilla/javascript/RegExpProxy", "compileRegExp", "(Lorg/mozilla/javascript/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;");
                cVar.f(179, this.mainClassName, compiledRegexpName, "Ljava/lang/Object;");
                i5++;
                i2 = 0;
                s = 10;
            }
            i4++;
            i2 = 0;
            s = 10;
        }
    }

    private void generateCallMethod(c cVar, boolean z) {
        int iY;
        int paramCount;
        cVar.Q(NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        int iB = cVar.b();
        cVar.g(1);
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/ScriptRuntime", "hasTopCall", "(Lorg/mozilla/javascript/Context;)Z");
        cVar.d(154, iB);
        cVar.g(0);
        cVar.g(1);
        cVar.g(2);
        cVar.g(3);
        cVar.g(4);
        cVar.c(z ? 4 : 3);
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "org/mozilla/javascript/ScriptRuntime", "doTopCall", "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Ljava/lang/Object;");
        cVar.c(176);
        cVar.H(iB);
        cVar.g(0);
        cVar.g(1);
        cVar.g(2);
        cVar.g(3);
        cVar.g(4);
        int length = this.scriptOrFnNodes.length;
        boolean z2 = 2 <= length;
        if (z2) {
            cVar.c(42);
            cVar.f(180, cVar.f8754g, "_id", OptRuntime.GeneratorState.resumptionPoint_TYPE);
            iY = cVar.y(1, length - 1);
        } else {
            iY = 0;
        }
        short s = 0;
        for (int i2 = 0; i2 != length; i2++) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i2];
            if (z2) {
                if (i2 == 0) {
                    cVar.K(iY);
                    s = cVar.p;
                } else {
                    cVar.J(iY, i2 - 1, s);
                }
            }
            if (scriptNode.getType() == 110) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                if (optFunctionNode.isTargetOfDirectCall() && (paramCount = optFunctionNode.fnode.getParamCount()) != 0) {
                    for (int i3 = 0; i3 != paramCount; i3++) {
                        cVar.c(190);
                        cVar.t(i3);
                        int iB2 = cVar.b();
                        int iB3 = cVar.b();
                        cVar.d(Token.METHOD, iB2);
                        cVar.g(4);
                        cVar.t(i3);
                        cVar.c(50);
                        cVar.d(Token.LAST_TOKEN, iB3);
                        cVar.H(iB2);
                        pushUndefined(cVar);
                        cVar.H(iB3);
                        cVar.C(-1);
                        cVar.s(0.0d);
                        cVar.g(4);
                    }
                }
            }
            cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, this.mainClassName, getBodyMethodName(scriptNode), getBodyMethodSignature(scriptNode));
            cVar.c(176);
        }
        cVar.R((short) 5);
    }

    private byte[] generateCode(String str) {
        boolean z = true;
        boolean z2 = this.scriptOrFnNodes[0].getType() == 137;
        ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
        if (scriptNodeArr.length <= 1 && z2) {
            z = false;
        }
        boolean zIsInStrictMode = scriptNodeArr[0].isInStrictMode();
        c cVar = new c(this.mainClassName, SUPER_CLASS_NAME, this.compilerEnv.isGenerateDebugInfo() ? this.scriptOrFnNodes[0].getSourceName() : null);
        cVar.l("_id", OptRuntime.GeneratorState.resumptionPoint_TYPE, (short) 2);
        if (z) {
            generateFunctionConstructor(cVar);
        }
        if (z2) {
            cVar.u.add(Short.valueOf(cVar.n.a("org/mozilla/javascript/Script")));
            generateScriptCtor(cVar);
            generateMain(cVar);
            generateExecute(cVar);
        }
        generateCallMethod(cVar, zIsInStrictMode);
        generateResumeGenerator(cVar);
        generateNativeFunctionOverrides(cVar, str);
        int length = this.scriptOrFnNodes.length;
        for (int i2 = 0; i2 != length; i2++) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i2];
            BodyCodegen bodyCodegen = new BodyCodegen();
            bodyCodegen.cfw = cVar;
            bodyCodegen.codegen = this;
            bodyCodegen.compilerEnv = this.compilerEnv;
            bodyCodegen.scriptOrFn = scriptNode;
            bodyCodegen.scriptOrFnIndex = i2;
            bodyCodegen.generateBodyCode();
            if (scriptNode.getType() == 110) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                generateFunctionInit(cVar, optFunctionNode);
                if (optFunctionNode.isTargetOfDirectCall()) {
                    emitDirectConstructor(cVar, optFunctionNode);
                }
            }
        }
        emitRegExpInit(cVar);
        emitConstantDudeInitializers(cVar);
        return cVar.S();
    }

    private static void generateExecute(c cVar) {
        cVar.Q("exec", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;", (short) 17);
        cVar.c(42);
        cVar.g(1);
        cVar.g(2);
        cVar.c(89);
        cVar.c(1);
        cVar.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, cVar.f8754g, NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        cVar.c(176);
        cVar.R((short) 3);
    }

    private void generateFunctionConstructor(c cVar) {
        int iY;
        cVar.Q("<init>", FUNCTION_CONSTRUCTOR_SIGNATURE, (short) 1);
        short s = 0;
        cVar.g(0);
        cVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, SUPER_CLASS_NAME, "<init>", "()V");
        cVar.c(42);
        cVar.m(3);
        cVar.f(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, cVar.f8754g, "_id", OptRuntime.GeneratorState.resumptionPoint_TYPE);
        cVar.c(42);
        cVar.g(2);
        cVar.g(1);
        int i2 = this.scriptOrFnNodes[0].getType() == 137 ? 1 : 0;
        int length = this.scriptOrFnNodes.length;
        if (i2 == length) {
            throw badTree();
        }
        boolean z = 2 <= length - i2;
        if (z) {
            cVar.m(3);
            iY = cVar.y(i2 + 1, length - 1);
        } else {
            iY = 0;
        }
        for (int i3 = i2; i3 != length; i3++) {
            if (z) {
                if (i3 == i2) {
                    cVar.K(iY);
                    s = cVar.p;
                } else {
                    cVar.J(iY, (i3 - 1) - i2, s);
                }
            }
            cVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, this.mainClassName, getFunctionInitMethodName(OptFunctionNode.get(this.scriptOrFnNodes[i3])), FUNCTION_INIT_SIGNATURE);
            cVar.c(177);
        }
        cVar.R((short) 4);
    }

    private void generateFunctionInit(c cVar, OptFunctionNode optFunctionNode) {
        cVar.Q(getFunctionInitMethodName(optFunctionNode), FUNCTION_INIT_SIGNATURE, (short) 18);
        cVar.c(42);
        cVar.g(1);
        cVar.g(2);
        cVar.o(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "org/mozilla/javascript/NativeFunction", "initScriptFunction", FUNCTION_INIT_SIGNATURE);
        if (optFunctionNode.fnode.getRegexpCount() != 0) {
            cVar.g(1);
            cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, this.mainClassName, REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE);
        }
        cVar.c(177);
        cVar.R((short) 3);
    }

    private void generateMain(c cVar) {
        cVar.Q("main", "([Ljava/lang/String;)V", (short) 9);
        cVar.e(187, cVar.f8754g);
        cVar.c(89);
        cVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, cVar.f8754g, "<init>", "()V");
        cVar.c(42);
        cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, this.mainMethodClass, "main", "(Lorg/mozilla/javascript/Script;[Ljava/lang/String;)V");
        cVar.c(177);
        cVar.R((short) 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void generateNativeFunctionOverrides(k.d.a.c r17, java.lang.String r18) {
        /*
            Method dump skipped, instruction units count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.Codegen.generateNativeFunctionOverrides(k.d.a.c, java.lang.String):void");
    }

    private void generateResumeGenerator(c cVar) {
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i3 >= scriptNodeArr.length) {
                break;
            }
            if (isGenerator(scriptNodeArr[i3])) {
                z = true;
            }
            i3++;
        }
        if (!z) {
            return;
        }
        cVar.Q("resumeGenerator", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        cVar.g(0);
        cVar.g(1);
        cVar.g(2);
        cVar.g(4);
        cVar.g(5);
        cVar.m(3);
        cVar.c(42);
        cVar.f(180, cVar.f8754g, "_id", OptRuntime.GeneratorState.resumptionPoint_TYPE);
        int iY = cVar.y(0, this.scriptOrFnNodes.length - 1);
        cVar.K(iY);
        int iB = cVar.b();
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i2 >= scriptNodeArr2.length) {
                cVar.H(iB);
                pushUndefined(cVar);
                cVar.c(176);
                cVar.R((short) 6);
                return;
            }
            ScriptNode scriptNode = scriptNodeArr2[i2];
            cVar.J(iY, i2, 6);
            if (isGenerator(scriptNode)) {
                String strP = a.p(a.r("("), this.mainClassSignature, "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;");
                cVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, this.mainClassName, getBodyMethodName(scriptNode) + "_gen", strP);
                cVar.c(176);
            } else {
                cVar.d(Token.LAST_TOKEN, iB);
            }
            i2++;
        }
    }

    private static void generateScriptCtor(c cVar) {
        cVar.Q("<init>", "()V", (short) 1);
        cVar.c(42);
        cVar.o(TinkerReport.KEY_APPLIED_LIB_EXTRACT, SUPER_CLASS_NAME, "<init>", "()V");
        cVar.c(42);
        cVar.t(0);
        cVar.f(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, cVar.f8754g, "_id", OptRuntime.GeneratorState.resumptionPoint_TYPE);
        cVar.c(177);
        cVar.R((short) 1);
    }

    private static String getStaticConstantWrapperType(double d2) {
        return ((double) ((int) d2)) == d2 ? "Ljava/lang/Integer;" : "Ljava/lang/Double;";
    }

    private static void initOptFunctions_r(ScriptNode scriptNode) {
        int functionCount = scriptNode.getFunctionCount();
        for (int i2 = 0; i2 != functionCount; i2++) {
            FunctionNode functionNode = scriptNode.getFunctionNode(i2);
            new OptFunctionNode(functionNode);
            initOptFunctions_r(functionNode);
        }
    }

    private void initScriptNodesData(ScriptNode scriptNode) {
        ObjArray objArray = new ObjArray();
        collectScriptNodes_r(scriptNode, objArray);
        int size = objArray.size();
        ScriptNode[] scriptNodeArr = new ScriptNode[size];
        this.scriptOrFnNodes = scriptNodeArr;
        objArray.toArray(scriptNodeArr);
        this.scriptOrFnIndexes = new ObjToIntMap(size);
        for (int i2 = 0; i2 != size; i2++) {
            this.scriptOrFnIndexes.put(this.scriptOrFnNodes[i2], i2);
        }
    }

    public static boolean isGenerator(ScriptNode scriptNode) {
        return scriptNode.getType() == 110 && ((FunctionNode) scriptNode).isGenerator();
    }

    public static void pushUndefined(c cVar) {
        cVar.f(178, "org/mozilla/javascript/Undefined", "instance", "Ljava/lang/Object;");
    }

    private void transform(ScriptNode scriptNode) {
        initOptFunctions_r(scriptNode);
        int optimizationLevel = this.compilerEnv.getOptimizationLevel();
        HashMap map = null;
        if (optimizationLevel > 0 && scriptNode.getType() == 137) {
            int functionCount = scriptNode.getFunctionCount();
            for (int i2 = 0; i2 != functionCount; i2++) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode, i2);
                if (optFunctionNode.fnode.getFunctionType() == 1) {
                    String name = optFunctionNode.fnode.getName();
                    if (name.length() != 0) {
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(name, optFunctionNode);
                    }
                }
            }
        }
        if (map != null) {
            this.directCallTargets = new ObjArray();
        }
        new OptTransformer(map, this.directCallTargets).transform(scriptNode, this.compilerEnv);
        if (optimizationLevel > 0) {
            new Optimizer().optimize(scriptNode);
        }
    }

    @Override // org.mozilla.javascript.Evaluator
    public void captureStackInfo(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    public String cleanName(ScriptNode scriptNode) {
        if (!(scriptNode instanceof FunctionNode)) {
            return "script";
        }
        Name functionName = ((FunctionNode) scriptNode).getFunctionName();
        return functionName == null ? "anonymous" : functionName.getIdentifier();
    }

    @Override // org.mozilla.javascript.Evaluator
    public Object compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        int i2;
        synchronized (globalLock) {
            i2 = globalSerialClassCounter + 1;
            globalSerialClassCounter = i2;
        }
        String strReplaceAll = ai.aD;
        if (scriptNode.getSourceName().length() > 0) {
            strReplaceAll = scriptNode.getSourceName().replaceAll("\\W", "_");
            if (!Character.isJavaIdentifierStart(strReplaceAll.charAt(0))) {
                strReplaceAll = a.i("_", strReplaceAll);
            }
        }
        String str2 = "org.mozilla.javascript.gen." + strReplaceAll + "_" + i2;
        return new Object[]{str2, compileToClassFile(compilerEnvirons, str2, scriptNode, str, z)};
    }

    public byte[] compileToClassFile(CompilerEnvirons compilerEnvirons, String str, ScriptNode scriptNode, String str2, boolean z) {
        this.compilerEnv = compilerEnvirons;
        transform(scriptNode);
        if (z) {
            scriptNode = scriptNode.getFunctionNode(0);
        }
        initScriptNodesData(scriptNode);
        this.mainClassName = str;
        int i2 = c.a;
        int length = str.length();
        int i3 = length + 1;
        int i4 = i3 + 1;
        char[] cArr = new char[i4];
        cArr[0] = 'L';
        cArr[i3] = ';';
        str.getChars(0, length, cArr, 1);
        for (int i5 = 1; i5 != i3; i5++) {
            if (cArr[i5] == '.') {
                cArr[i5] = Attributes.InternalPrefix;
            }
        }
        this.mainClassSignature = new String(cArr, 0, i4);
        return generateCode(str2);
    }

    @Override // org.mozilla.javascript.Evaluator
    public Function createFunctionObject(Context context, Scriptable scriptable, Object obj, Object obj2) {
        try {
            return (NativeFunction) defineClass(obj, obj2).getConstructors()[0].newInstance(scriptable, context, 0);
        } catch (Exception e2) {
            StringBuilder sbR = a.r("Unable to instantiate compiled class:");
            sbR.append(e2.toString());
            throw new RuntimeException(sbR.toString());
        }
    }

    @Override // org.mozilla.javascript.Evaluator
    public Script createScriptObject(Object obj, Object obj2) {
        try {
            return (Script) defineClass(obj, obj2).newInstance();
        } catch (Exception e2) {
            StringBuilder sbR = a.r("Unable to instantiate compiled class:");
            sbR.append(e2.toString());
            throw new RuntimeException(sbR.toString());
        }
    }

    public String getBodyMethodName(ScriptNode scriptNode) {
        StringBuilder sbR = a.r("_c_");
        sbR.append(cleanName(scriptNode));
        sbR.append("_");
        sbR.append(getIndex(scriptNode));
        return sbR.toString();
    }

    public String getBodyMethodSignature(ScriptNode scriptNode) {
        StringBuilder sbQ = a.q('(');
        sbQ.append(this.mainClassSignature);
        sbQ.append("Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;");
        if (scriptNode.getType() == 110) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
            if (optFunctionNode.isTargetOfDirectCall()) {
                int paramCount = optFunctionNode.fnode.getParamCount();
                for (int i2 = 0; i2 != paramCount; i2++) {
                    sbQ.append("Ljava/lang/Object;D");
                }
            }
        }
        sbQ.append("[Ljava/lang/Object;)Ljava/lang/Object;");
        return sbQ.toString();
    }

    public String getCompiledRegexpName(ScriptNode scriptNode, int i2) {
        StringBuilder sbR = a.r("_re");
        sbR.append(getIndex(scriptNode));
        sbR.append("_");
        sbR.append(i2);
        return sbR.toString();
    }

    public String getDirectCtorName(ScriptNode scriptNode) {
        StringBuilder sbR = a.r("_n");
        sbR.append(getIndex(scriptNode));
        return sbR.toString();
    }

    public String getFunctionInitMethodName(OptFunctionNode optFunctionNode) {
        StringBuilder sbR = a.r("_i");
        sbR.append(getIndex(optFunctionNode.fnode));
        return sbR.toString();
    }

    public int getIndex(ScriptNode scriptNode) {
        return this.scriptOrFnIndexes.getExisting(scriptNode);
    }

    @Override // org.mozilla.javascript.Evaluator
    public String getPatchedStack(RhinoException rhinoException, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public List<String> getScriptStack(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public String getSourcePositionFromStack(Context context, int[] iArr) {
        throw new UnsupportedOperationException();
    }

    public void pushNumberAsObject(c cVar, double d2) {
        if (d2 == 0.0d) {
            if (1.0d / d2 > 0.0d) {
                cVar.f(178, "org/mozilla/javascript/ScriptRuntime", "zeroObj", "Ljava/lang/Double;");
                return;
            } else {
                cVar.s(d2);
                addDoubleWrap(cVar);
                return;
            }
        }
        if (d2 == 1.0d) {
            cVar.f(178, "org/mozilla/javascript/optimizer/OptRuntime", "oneObj", "Ljava/lang/Double;");
            return;
        }
        if (d2 == -1.0d) {
            cVar.f(178, "org/mozilla/javascript/optimizer/OptRuntime", "minusOneObj", "Ljava/lang/Double;");
            return;
        }
        if (Double.isNaN(d2)) {
            cVar.f(178, "org/mozilla/javascript/ScriptRuntime", "NaNobj", "Ljava/lang/Double;");
            return;
        }
        int i2 = this.itsConstantListSize;
        if (i2 >= 2000) {
            cVar.s(d2);
            addDoubleWrap(cVar);
            return;
        }
        int i3 = 0;
        if (i2 == 0) {
            this.itsConstantList = new double[64];
        } else {
            double[] dArr = this.itsConstantList;
            int i4 = 0;
            while (i4 != i2 && dArr[i4] != d2) {
                i4++;
            }
            if (i2 == dArr.length) {
                double[] dArr2 = new double[i2 * 2];
                System.arraycopy(this.itsConstantList, 0, dArr2, 0, i2);
                this.itsConstantList = dArr2;
            }
            i3 = i4;
        }
        if (i3 == i2) {
            this.itsConstantList[i2] = d2;
            this.itsConstantListSize = i2 + 1;
        }
        cVar.f(178, this.mainClassName, a.G("_k", i3), getStaticConstantWrapperType(d2));
    }

    @Override // org.mozilla.javascript.Evaluator
    public void setEvalScriptFlag(Script script) {
        throw new UnsupportedOperationException();
    }

    public void setMainMethodClass(String str) {
        this.mainMethodClass = str;
    }
}
