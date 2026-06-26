package org.mozilla.javascript.tools.shell;

import c.a.a.a.a;
import h.a.a.a.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Synchronizer;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.Wrapper;
import org.mozilla.javascript.commonjs.module.Require;
import org.mozilla.javascript.commonjs.module.RequireBuilder;
import org.mozilla.javascript.commonjs.module.provider.SoftCachingModuleScriptProvider;
import org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider;
import org.mozilla.javascript.serialize.ScriptableInputStream;
import org.mozilla.javascript.serialize.ScriptableOutputStream;
import org.mozilla.javascript.tools.ToolErrorReporter;

/* JADX INFO: loaded from: classes3.dex */
public class Global extends ImporterTopLevel {
    public static final long serialVersionUID = 4029130780977538005L;
    public boolean attemptedJLineLoad;
    private ShellConsole console;
    private HashMap<String, String> doctestCanonicalizations;
    private PrintStream errStream;
    public NativeArray history;
    private InputStream inStream;
    public boolean initialized;
    private PrintStream outStream;
    private QuitAction quitAction;
    private boolean sealedStdLib = false;
    private String[] prompts = {"js> ", "  > "};

    public Global() {
    }

    public static void defineClass(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IllegalAccessException, InvocationTargetException {
        Class<?> cls = getClass(objArr);
        if (!Scriptable.class.isAssignableFrom(cls)) {
            throw reportRuntimeError("msg.must.implement.Scriptable");
        }
        ScriptableObject.defineClass(scriptable, cls);
    }

    public static Object deserialize(Context context, Scriptable scriptable, Object[] objArr, Function function) throws ClassNotFoundException, IOException {
        if (objArr.length < 1) {
            throw Context.reportRuntimeError("Expected a filename to read the serialization from");
        }
        FileInputStream fileInputStream = new FileInputStream(Context.toString(objArr[0]));
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        ScriptableInputStream scriptableInputStream = new ScriptableInputStream(fileInputStream, topLevelScope);
        Object object = scriptableInputStream.readObject();
        scriptableInputStream.close();
        return Context.toObject(object, topLevelScope);
    }

    private static Object doPrint(Object[] objArr, Function function, boolean z) {
        PrintStream out = getInstance(function).getOut();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (i2 > 0) {
                out.print(" ");
            }
            out.print(Context.toString(objArr[i2]));
        }
        if (z) {
            out.println();
        }
        return Context.getUndefinedValue();
    }

    public static Object doctest(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length == 0) {
            return Boolean.FALSE;
        }
        String string = Context.toString(objArr[0]);
        Global global = getInstance(function);
        return Integer.valueOf(global.runDoctest(context, global, string, null, 0));
    }

    private boolean doctestOutputMatches(String str, String str2) {
        String strTrim = str.trim();
        String strReplace = str2.trim().replace("\r\n", "\n");
        if (strTrim.equals(strReplace)) {
            return true;
        }
        for (Map.Entry<String, String> entry : this.doctestCanonicalizations.entrySet()) {
            strTrim = strTrim.replace(entry.getKey(), entry.getValue());
        }
        if (strTrim.equals(strReplace)) {
            return true;
        }
        Pattern patternCompile = Pattern.compile("@[0-9a-fA-F]+");
        Matcher matcher = patternCompile.matcher(strTrim);
        Matcher matcher2 = patternCompile.matcher(strReplace);
        while (matcher.find() && matcher2.find() && matcher2.start() == matcher.start()) {
            int iStart = matcher.start();
            if (!strTrim.substring(0, iStart).equals(strReplace.substring(0, iStart))) {
                return false;
            }
            String strGroup = matcher.group();
            String strGroup2 = matcher2.group();
            String str3 = this.doctestCanonicalizations.get(strGroup);
            if (str3 == null) {
                this.doctestCanonicalizations.put(strGroup, strGroup2);
                strTrim = strTrim.replace(strGroup, strGroup2);
            } else if (!strGroup2.equals(str3)) {
                return false;
            }
            if (strTrim.equals(strReplace)) {
                return true;
            }
        }
        return false;
    }

    public static void gc(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        System.gc();
    }

    private static String getCharCodingFromType(String str) {
        int iIndexOf = str.indexOf(59);
        if (iIndexOf < 0) {
            return null;
        }
        int length = str.length();
        do {
            iIndexOf++;
            if (iIndexOf == length) {
                break;
            }
        } while (str.charAt(iIndexOf) <= ' ');
        if (!"charset".regionMatches(true, 0, str, iIndexOf, 7)) {
            return null;
        }
        int i2 = iIndexOf + 7;
        while (i2 != length && str.charAt(i2) <= ' ') {
            i2++;
        }
        if (i2 == length || str.charAt(i2) != '=') {
            return null;
        }
        do {
            i2++;
            if (i2 == length) {
                break;
            }
        } while (str.charAt(i2) <= ' ');
        if (i2 == length) {
            return null;
        }
        while (str.charAt(length - 1) <= ' ') {
            length--;
        }
        return str.substring(i2, length);
    }

    private static Class<?> getClass(Object[] objArr) {
        if (objArr.length == 0) {
            throw reportRuntimeError("msg.expected.string.arg");
        }
        Object obj = objArr[0];
        if (obj instanceof Wrapper) {
            Object objUnwrap = ((Wrapper) obj).unwrap();
            if (objUnwrap instanceof Class) {
                return (Class) objUnwrap;
            }
        }
        String string = Context.toString(objArr[0]);
        try {
            return Class.forName(string);
        } catch (ClassNotFoundException unused) {
            throw reportRuntimeError("msg.class.not.found", string);
        }
    }

    private static Global getInstance(Function function) {
        Scriptable parentScope = function.getParentScope();
        if (parentScope instanceof Global) {
            return (Global) parentScope;
        }
        throw reportRuntimeError("msg.bad.shell.function.scope", String.valueOf(parentScope));
    }

    public static void help(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        getInstance(function).getOut().println(ToolErrorReporter.getMessage("msg.help"));
    }

    public static void load(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        for (Object obj : objArr) {
            String string = Context.toString(obj);
            try {
                Main.processFile(context, scriptable, string);
            } catch (IOException e2) {
                throw Context.reportRuntimeError(ToolErrorReporter.getMessage("msg.couldnt.read.source", string, e2.getMessage()));
            } catch (VirtualMachineError e3) {
                e3.printStackTrace();
                throw Context.reportRuntimeError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e3.toString()));
            }
        }
    }

    public static void loadClass(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Class<?> cls = getClass(objArr);
        if (!Script.class.isAssignableFrom(cls)) {
            throw reportRuntimeError("msg.must.implement.Script");
        }
        ((Script) cls.newInstance()).exec(context, scriptable);
    }

    private boolean loadJLine(Charset charset) {
        if (!this.attemptedJLineLoad) {
            this.attemptedJLineLoad = true;
            this.console = ShellConsole.getConsole(this, charset);
        }
        return this.console != null;
    }

    public static void pipe(boolean z, InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = !z ? inputStream.read(bArr, 0, 4096) : inputStream.read(bArr, 0, 4096);
                if (i2 >= 0) {
                    if (z) {
                        outputStream.write(bArr, 0, i2);
                        outputStream.flush();
                    } else {
                        try {
                            outputStream.write(bArr, 0, i2);
                            outputStream.flush();
                        } catch (IOException unused) {
                        }
                    }
                }
                try {
                    break;
                } catch (IOException unused2) {
                    return;
                }
            }
        } finally {
            try {
                if (z) {
                    inputStream.close();
                } else {
                    outputStream.close();
                }
            } catch (IOException unused3) {
            }
        }
    }

    public static Object print(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        return doPrint(objArr, function, true);
    }

    public static void quit(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Global global = getInstance(function);
        if (global.quitAction != null) {
            global.quitAction.quit(context, objArr.length != 0 ? ScriptRuntime.toInt32(objArr[0]) : 0);
        }
    }

    public static Object readFile(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length != 0) {
            return readUrl(ScriptRuntime.toString(objArr[0]), objArr.length >= 2 ? ScriptRuntime.toString(objArr[1]) : null, true);
        }
        throw reportRuntimeError("msg.shell.readFile.bad.args");
    }

    private static String readReader(Reader reader) {
        return readReader(reader, 4096);
    }

    public static Object readUrl(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length != 0) {
            return readUrl(ScriptRuntime.toString(objArr[0]), objArr.length >= 2 ? ScriptRuntime.toString(objArr[1]) : null, false);
        }
        throw reportRuntimeError("msg.shell.readUrl.bad.args");
    }

    public static Object readline(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Global global = getInstance(function);
        return objArr.length > 0 ? global.console.readLine(Context.toString(objArr[0])) : global.console.readLine();
    }

    public static RuntimeException reportRuntimeError(String str) {
        return Context.reportRuntimeError(ToolErrorReporter.getMessage(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e8  */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object runCommand(org.mozilla.javascript.Context r20, org.mozilla.javascript.Scriptable r21, java.lang.Object[] r22, org.mozilla.javascript.Function r23) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.shell.Global.runCommand(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.Object[], org.mozilla.javascript.Function):java.lang.Object");
    }

    private static int runProcess(String[] strArr, String[] strArr2, File file, InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) {
        PipeThread pipeThread;
        PipeThread pipeThread2;
        PipeThread pipeThread3 = null;
        Process processExec = strArr2 == null ? Runtime.getRuntime().exec(strArr, (String[]) null, file) : Runtime.getRuntime().exec(strArr, strArr2, file);
        try {
            if (inputStream != null) {
                pipeThread = new PipeThread(false, inputStream, processExec.getOutputStream());
                pipeThread.start();
            } else {
                processExec.getOutputStream().close();
                pipeThread = null;
            }
            if (outputStream != null) {
                pipeThread2 = new PipeThread(true, processExec.getInputStream(), outputStream);
                pipeThread2.start();
            } else {
                processExec.getInputStream().close();
                pipeThread2 = null;
            }
            if (outputStream2 != null) {
                pipeThread3 = new PipeThread(true, processExec.getErrorStream(), outputStream2);
                pipeThread3.start();
            } else {
                processExec.getErrorStream().close();
            }
            while (true) {
                try {
                    processExec.waitFor();
                    if (pipeThread2 != null) {
                        pipeThread2.join();
                    }
                    if (pipeThread != null) {
                        pipeThread.join();
                    }
                    if (pipeThread3 == null) {
                        break;
                    }
                    pipeThread3.join();
                    break;
                } catch (InterruptedException unused) {
                }
            }
            return processExec.exitValue();
        } finally {
            processExec.destroy();
        }
    }

    public static void seal(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        for (int i2 = 0; i2 != objArr.length; i2++) {
            Object obj = objArr[i2];
            if (!(obj instanceof ScriptableObject) || obj == Undefined.instance) {
                if ((obj instanceof Scriptable) && obj != Undefined.instance) {
                    throw reportRuntimeError("msg.shell.seal.not.scriptable");
                }
                throw reportRuntimeError("msg.shell.seal.not.object");
            }
        }
        for (int i3 = 0; i3 != objArr.length; i3++) {
            ((ScriptableObject) objArr[i3]).sealObject();
        }
    }

    public static void serialize(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        if (objArr.length < 2) {
            throw Context.reportRuntimeError("Expected an object to serialize and a filename to write the serialization to");
        }
        Object obj = objArr[0];
        ScriptableOutputStream scriptableOutputStream = new ScriptableOutputStream(new FileOutputStream(Context.toString(objArr[1])), ScriptableObject.getTopLevelScope(scriptable));
        scriptableOutputStream.writeObject(obj);
        scriptableOutputStream.close();
    }

    public static Object spawn(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Runner runner;
        Scriptable parentScope = function.getParentScope();
        if (objArr.length != 0 && (objArr[0] instanceof Function)) {
            Object[] elements = null;
            if (objArr.length > 1 && (objArr[1] instanceof Scriptable)) {
                elements = context.getElements((Scriptable) objArr[1]);
            }
            if (elements == null) {
                elements = ScriptRuntime.emptyArgs;
            }
            runner = new Runner(parentScope, (Function) objArr[0], elements);
        } else {
            if (objArr.length == 0 || !(objArr[0] instanceof Script)) {
                throw reportRuntimeError("msg.spawn.args");
            }
            runner = new Runner(parentScope, (Script) objArr[0]);
        }
        runner.factory = context.getFactory();
        Thread thread = new Thread(runner);
        thread.start();
        return thread;
    }

    public static Object sync(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length < 1 || objArr.length > 2 || !(objArr[0] instanceof Function)) {
            throw reportRuntimeError("msg.sync.args");
        }
        Object obj = null;
        if (objArr.length == 2 && objArr[1] != Undefined.instance) {
            obj = objArr[1];
        }
        return new Synchronizer((Function) objArr[0], obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.io.InputStream toInputStream(java.lang.Object r4) {
        /*
            boolean r0 = r4 instanceof org.mozilla.javascript.Wrapper
            r1 = 0
            if (r0 == 0) goto L3c
            r0 = r4
            org.mozilla.javascript.Wrapper r0 = (org.mozilla.javascript.Wrapper) r0
            java.lang.Object r0 = r0.unwrap()
            boolean r2 = r0 instanceof java.io.InputStream
            if (r2 == 0) goto L16
            java.io.InputStream r0 = (java.io.InputStream) r0
            r3 = r1
            r1 = r0
            r0 = r3
            goto L3d
        L16:
            boolean r2 = r0 instanceof byte[]
            if (r2 == 0) goto L24
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            byte[] r0 = (byte[]) r0
            r2.<init>(r0)
            r0 = r1
            r1 = r2
            goto L3d
        L24:
            boolean r2 = r0 instanceof java.io.Reader
            if (r2 == 0) goto L2f
            java.io.Reader r0 = (java.io.Reader) r0
            java.lang.String r0 = readReader(r0)
            goto L3d
        L2f:
            boolean r2 = r0 instanceof char[]
            if (r2 == 0) goto L3c
            java.lang.String r2 = new java.lang.String
            char[] r0 = (char[]) r0
            r2.<init>(r0)
            r0 = r2
            goto L3d
        L3c:
            r0 = r1
        L3d:
            if (r1 != 0) goto L4e
            if (r0 != 0) goto L45
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString(r4)
        L45:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            byte[] r4 = r0.getBytes()
            r1.<init>(r4)
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.shell.Global.toInputStream(java.lang.Object):java.io.InputStream");
    }

    private static OutputStream toOutputStream(Object obj) {
        if (obj instanceof Wrapper) {
            Object objUnwrap = ((Wrapper) obj).unwrap();
            if (objUnwrap instanceof OutputStream) {
                return (OutputStream) objUnwrap;
            }
        }
        return null;
    }

    public static Object toint32(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Object obj = objArr.length != 0 ? objArr[0] : Undefined.instance;
        return obj instanceof Integer ? obj : ScriptRuntime.wrapInt(ScriptRuntime.toInt32(obj));
    }

    public static double version(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length > 0) {
            context.setLanguageVersion((int) Context.toNumber(objArr[0]));
        }
        return context.getLanguageVersion();
    }

    public static Object write(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        return doPrint(objArr, function, false);
    }

    public ShellConsole getConsole(Charset charset) {
        if (!loadJLine(charset)) {
            this.console = ShellConsole.getConsole(getIn(), getErr(), charset);
        }
        return this.console;
    }

    public PrintStream getErr() {
        PrintStream printStream = this.errStream;
        return printStream == null ? System.err : printStream;
    }

    public InputStream getIn() {
        if (this.inStream == null && !this.attemptedJLineLoad && loadJLine(Charset.defaultCharset())) {
            this.inStream = this.console.getIn();
        }
        InputStream inputStream = this.inStream;
        return inputStream == null ? System.in : inputStream;
    }

    public PrintStream getOut() {
        PrintStream printStream = this.outStream;
        return printStream == null ? System.out : printStream;
    }

    public String[] getPrompts(Context context) {
        if (ScriptableObject.hasProperty(this, "prompts")) {
            Object property = ScriptableObject.getProperty(this, "prompts");
            if (property instanceof Scriptable) {
                Scriptable scriptable = (Scriptable) property;
                if (ScriptableObject.hasProperty(scriptable, 0) && ScriptableObject.hasProperty(scriptable, 1)) {
                    Object property2 = ScriptableObject.getProperty(scriptable, 0);
                    if (property2 instanceof Function) {
                        property2 = ((Function) property2).call(context, this, scriptable, new Object[0]);
                    }
                    this.prompts[0] = Context.toString(property2);
                    Object property3 = ScriptableObject.getProperty(scriptable, 1);
                    if (property3 instanceof Function) {
                        property3 = ((Function) property3).call(context, this, scriptable, new Object[0]);
                    }
                    this.prompts[1] = Context.toString(property3);
                }
            }
        }
        return this.prompts;
    }

    public void init(ContextFactory contextFactory) {
        contextFactory.call(new ContextAction() { // from class: k.d.b.j.a.a
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                this.a.init(context);
                return null;
            }
        });
    }

    public void initQuitAction(QuitAction quitAction) {
        if (quitAction == null) {
            throw new IllegalArgumentException("quitAction is null");
        }
        if (this.quitAction != null) {
            throw new IllegalArgumentException("The method is once-call.");
        }
        this.quitAction = quitAction;
    }

    public Require installRequire(Context context, List<String> list, boolean z) {
        RequireBuilder requireBuilder = new RequireBuilder();
        requireBuilder.setSandboxed(z);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str : list) {
                try {
                    URI uri = new URI(str);
                    if (!uri.isAbsolute()) {
                        uri = new File(str).toURI().resolve("");
                    }
                    if (!uri.toString().endsWith(w.DEFAULT_PATH_SEPARATOR)) {
                        uri = new URI(uri + w.DEFAULT_PATH_SEPARATOR);
                    }
                    arrayList.add(uri);
                } catch (URISyntaxException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        requireBuilder.setModuleScriptProvider(new SoftCachingModuleScriptProvider(new UrlModuleSourceProvider(arrayList, null)));
        Require requireCreateRequire = requireBuilder.createRequire(context, this);
        requireCreateRequire.install(this);
        return requireCreateRequire;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public int runDoctest(Context context, Scriptable scriptable, String str, String str2, int i2) throws Throwable {
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        PrintStream printStream2;
        ErrorReporter errorReporter;
        String[] strArr;
        String str3;
        String str4;
        int i3;
        String str5;
        StringBuilder sb;
        this.doctestCanonicalizations = new HashMap<>();
        String[] strArrSplit = str.split("\r\n?|\n");
        boolean z = false;
        String strTrim = this.prompts[0].trim();
        String strTrim2 = this.prompts[1].trim();
        int i4 = 0;
        while (i4 < strArrSplit.length && !strArrSplit[i4].trim().startsWith(strTrim)) {
            i4++;
        }
        int i5 = 0;
        while (i4 < strArrSplit.length) {
            StringBuilder sb2 = new StringBuilder(strArrSplit[i4].trim().substring(strTrim.length()));
            sb2.append('\n');
            while (true) {
                i4++;
                if (i4 >= strArrSplit.length || !strArrSplit[i4].trim().startsWith(strTrim2)) {
                    break;
                }
                sb2.append(strArrSplit[i4].trim().substring(strTrim2.length()));
                sb2.append('\n');
            }
            StringBuilder sb3 = new StringBuilder();
            int i6 = i4;
            while (i6 < strArrSplit.length && !strArrSplit[i6].trim().startsWith(strTrim)) {
                sb3.append(strArrSplit[i6]);
                sb3.append('\n');
                i6++;
            }
            PrintStream out = getOut();
            PrintStream err = getErr();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            setOut(new PrintStream(byteArrayOutputStream2));
            setErr(new PrintStream(byteArrayOutputStream3));
            ErrorReporter errorReporter2 = context.getErrorReporter();
            context.setErrorReporter(new ToolErrorReporter(z, getErr()));
            int i7 = i5 + 1;
            try {
                String string = sb2.toString();
                byteArrayOutputStream = byteArrayOutputStream2;
                strArr = strArrSplit;
                printStream2 = err;
                str3 = strTrim;
                str4 = "";
                i3 = i6;
                errorReporter = errorReporter2;
                String str6 = strTrim2;
                printStream = out;
                str5 = str6;
                try {
                    try {
                        Object objEvaluateString = context.evaluateString(scriptable, string, "doctest input", 1, null);
                        String string2 = (objEvaluateString == Context.getUndefinedValue() || ((objEvaluateString instanceof Function) && string.trim().startsWith("function"))) ? str4 : Context.toString(objEvaluateString);
                        setOut(printStream);
                        setErr(printStream2);
                        context.setErrorReporter(errorReporter);
                        sb = new StringBuilder();
                        sb.append(string2);
                    } catch (Throwable th) {
                        th = th;
                        setOut(printStream);
                        setErr(printStream2);
                        context.setErrorReporter(errorReporter);
                        byteArrayOutputStream3.toString();
                        byteArrayOutputStream.toString();
                        throw th;
                    }
                } catch (RhinoException e2) {
                    e = e2;
                    ToolErrorReporter.reportException(context.getErrorReporter(), e);
                    setOut(printStream);
                    setErr(printStream2);
                    context.setErrorReporter(errorReporter);
                    sb = new StringBuilder();
                    sb.append(str4);
                }
            } catch (RhinoException e3) {
                e = e3;
                byteArrayOutputStream = byteArrayOutputStream2;
                strArr = strArrSplit;
                str3 = strTrim;
                str4 = "";
                printStream2 = err;
                i3 = i6;
                errorReporter = errorReporter2;
                String str7 = strTrim2;
                printStream = out;
                str5 = str7;
            } catch (Throwable th2) {
                th = th2;
                printStream = out;
                byteArrayOutputStream = byteArrayOutputStream2;
                printStream2 = err;
                errorReporter = errorReporter2;
            }
            sb.append(byteArrayOutputStream3.toString());
            sb.append(byteArrayOutputStream.toString());
            String string3 = sb.toString();
            if (!doctestOutputMatches(sb3.toString(), string3)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("doctest failure running:\n");
                sb4.append((Object) sb2);
                sb4.append("expected: ");
                sb4.append((Object) sb3);
                sb4.append("actual: ");
                String strP = a.p(sb4, string3, "\n");
                if (str2 != null) {
                    throw Context.reportRuntimeError(strP, str2, (i2 + i3) - 1, null, 0);
                }
                throw Context.reportRuntimeError(strP);
            }
            z = false;
            strTrim2 = str5;
            i4 = i3;
            i5 = i7;
            strArrSplit = strArr;
            strTrim = str3;
        }
        return i5;
    }

    public void setErr(PrintStream printStream) {
        this.errStream = printStream;
    }

    public void setIn(InputStream inputStream) {
        this.inStream = inputStream;
    }

    public void setOut(PrintStream printStream) {
        this.outStream = printStream;
    }

    public void setSealedStdLib(boolean z) {
        this.sealedStdLib = z;
    }

    private static String readReader(Reader reader, int i2) throws IOException {
        char[] cArr = new char[i2];
        int i3 = 0;
        while (true) {
            int i4 = reader.read(cArr, i3, cArr.length - i3);
            if (i4 < 0) {
                return new String(cArr, 0, i3);
            }
            i3 += i4;
            if (i3 == cArr.length) {
                char[] cArr2 = new char[cArr.length * 2];
                System.arraycopy(cArr, 0, cArr2, 0, i3);
                cArr = cArr2;
            }
        }
    }

    public void init(Context context) {
        initStandardObjects(context, this.sealedStdLib);
        defineFunctionProperties(new String[]{"defineClass", "deserialize", "doctest", "gc", "help", "load", "loadClass", "print", "quit", "readline", "readFile", "readUrl", "runCommand", "seal", "serialize", "spawn", "sync", "toint32", "version", "write"}, Global.class, 2);
        Environment.defineClass(this);
        defineProperty("environment", new Environment(this), 2);
        NativeArray nativeArray = (NativeArray) context.newArray(this, 0);
        this.history = nativeArray;
        defineProperty("history", nativeArray, 2);
        this.initialized = true;
    }

    public static RuntimeException reportRuntimeError(String str, String str2) {
        return Context.reportRuntimeError(ToolErrorReporter.getMessage(str, str2));
    }

    public Global(Context context) {
        init(context);
    }

    private static String readUrl(String str, String str2, boolean z) throws IOException {
        int contentLength;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        String contentType;
        InputStream inputStream2 = null;
        try {
            if (!z) {
                URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
                inputStream = uRLConnectionOpenConnection.getInputStream();
                contentLength = uRLConnectionOpenConnection.getContentLength();
                if (contentLength <= 0) {
                    contentLength = 1024;
                }
                if (str2 == null && (contentType = uRLConnectionOpenConnection.getContentType()) != null) {
                    str2 = getCharCodingFromType(contentType);
                }
            } else {
                File file = new File(str);
                if (file.exists()) {
                    if (file.canRead()) {
                        long length = file.length();
                        int i2 = (int) length;
                        if (i2 != length) {
                            throw new IOException("Too big file size: " + length);
                        }
                        if (i2 == 0) {
                            return "";
                        }
                        FileInputStream fileInputStream = new FileInputStream(file);
                        contentLength = i2;
                        inputStream = fileInputStream;
                    } else {
                        throw new IOException("Cannot read file: " + str);
                    }
                } else {
                    throw new FileNotFoundException("File not found: " + str);
                }
            }
            if (str2 == null) {
                inputStreamReader = new InputStreamReader(inputStream);
            } else {
                inputStreamReader = new InputStreamReader(inputStream, str2);
            }
            String reader = readReader(inputStreamReader, contentLength);
            if (inputStream != null) {
                inputStream.close();
            }
            return reader;
        } catch (Throwable th) {
            if (0 != 0) {
                inputStream2.close();
            }
            throw th;
        }
    }
}
