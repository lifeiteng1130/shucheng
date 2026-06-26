package javax.script;

import java.io.PrintStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import l.a.b.a;
import sun.misc.Service;
import sun.misc.ServiceConfigurationError;
import sun.reflect.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public class ScriptEngineManager {
    private static final boolean DEBUG = false;
    private HashSet<ScriptEngineFactory> engineSpis;
    private HashMap<String, ScriptEngineFactory> extensionAssociations;
    private Bindings globalScope;
    private HashMap<String, ScriptEngineFactory> mimeTypeAssociations;
    private HashMap<String, ScriptEngineFactory> nameAssociations;

    public ScriptEngineManager() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (canCallerAccessLoader(contextClassLoader)) {
            init(contextClassLoader);
        } else {
            init(null);
        }
    }

    private boolean canCallerAccessLoader(ClassLoader classLoader) {
        ClassLoader callerClassLoader;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null || (callerClassLoader = getCallerClassLoader()) == null) {
            return true;
        }
        if (classLoader == callerClassLoader && isAncestor(classLoader, callerClassLoader)) {
            return true;
        }
        try {
            securityManager.checkPermission(a.a);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    private ClassLoader getCallerClassLoader() {
        Class callerClass = Reflection.getCallerClass(3);
        if (callerClass == null) {
            return null;
        }
        return callerClass.getClassLoader();
    }

    private void init(final ClassLoader classLoader) {
        this.globalScope = new SimpleBindings();
        this.engineSpis = new HashSet<>();
        this.nameAssociations = new HashMap<>();
        this.extensionAssociations = new HashMap<>();
        this.mimeTypeAssociations = new HashMap<>();
        AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.script.ScriptEngineManager.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                ScriptEngineManager.this.initEngines(classLoader);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEngines(ClassLoader classLoader) {
        try {
            Iterator itProviders = classLoader != null ? Service.providers(ScriptEngineFactory.class, classLoader) : Service.installedProviders(ScriptEngineFactory.class);
            while (itProviders.hasNext()) {
                try {
                    try {
                        this.engineSpis.add((ScriptEngineFactory) itProviders.next());
                    } catch (ServiceConfigurationError e2) {
                        System.err.println("ScriptEngineManager providers.next(): " + e2.getMessage());
                    }
                } catch (ServiceConfigurationError e3) {
                    PrintStream printStream = System.err;
                    StringBuilder sbR = c.a.a.a.a.r("ScriptEngineManager providers.hasNext(): ");
                    sbR.append(e3.getMessage());
                    printStream.println(sbR.toString());
                    return;
                }
            }
        } catch (ServiceConfigurationError e4) {
            PrintStream printStream2 = System.err;
            StringBuilder sbR2 = c.a.a.a.a.r("Can't find ScriptEngineFactory providers: ");
            sbR2.append(e4.getMessage());
            printStream2.println(sbR2.toString());
        }
    }

    private boolean isAncestor(ClassLoader classLoader, ClassLoader classLoader2) {
        do {
            classLoader2 = classLoader2.getParent();
            if (classLoader == classLoader2) {
                return true;
            }
        } while (classLoader2 != null);
        return false;
    }

    public Object get(String str) {
        return this.globalScope.get(str);
    }

    public Bindings getBindings() {
        return this.globalScope;
    }

    public ScriptEngine getEngineByExtension(String str) {
        Objects.requireNonNull(str);
        ScriptEngineFactory scriptEngineFactory = this.extensionAssociations.get(str);
        if (scriptEngineFactory != null) {
            try {
                ScriptEngine scriptEngine = scriptEngineFactory.getScriptEngine();
                scriptEngine.setBindings(getBindings(), 200);
                return scriptEngine;
            } catch (Exception unused) {
            }
        }
        Iterator<ScriptEngineFactory> it = this.engineSpis.iterator();
        while (true) {
            List<String> extensions = null;
            if (!it.hasNext()) {
                return null;
            }
            ScriptEngineFactory next = it.next();
            try {
                extensions = next.getExtensions();
            } catch (Exception unused2) {
            }
            if (extensions != null) {
                Iterator<String> it2 = extensions.iterator();
                while (it2.hasNext()) {
                    if (str.equals(it2.next())) {
                        try {
                            ScriptEngine scriptEngine2 = next.getScriptEngine();
                            scriptEngine2.setBindings(getBindings(), 200);
                            return scriptEngine2;
                        } catch (Exception unused3) {
                        }
                    }
                }
            }
        }
    }

    public ScriptEngine getEngineByMimeType(String str) {
        Objects.requireNonNull(str);
        ScriptEngineFactory scriptEngineFactory = this.mimeTypeAssociations.get(str);
        if (scriptEngineFactory != null) {
            try {
                ScriptEngine scriptEngine = scriptEngineFactory.getScriptEngine();
                scriptEngine.setBindings(getBindings(), 200);
                return scriptEngine;
            } catch (Exception unused) {
            }
        }
        Iterator<ScriptEngineFactory> it = this.engineSpis.iterator();
        while (true) {
            List<String> mimeTypes = null;
            if (!it.hasNext()) {
                return null;
            }
            ScriptEngineFactory next = it.next();
            try {
                mimeTypes = next.getMimeTypes();
            } catch (Exception unused2) {
            }
            if (mimeTypes != null) {
                Iterator<String> it2 = mimeTypes.iterator();
                while (it2.hasNext()) {
                    if (str.equals(it2.next())) {
                        try {
                            ScriptEngine scriptEngine2 = next.getScriptEngine();
                            scriptEngine2.setBindings(getBindings(), 200);
                            return scriptEngine2;
                        } catch (Exception unused3) {
                        }
                    }
                }
            }
        }
    }

    public ScriptEngine getEngineByName(String str) {
        Objects.requireNonNull(str);
        ScriptEngineFactory scriptEngineFactory = this.nameAssociations.get(str);
        if (scriptEngineFactory != null) {
            try {
                ScriptEngine scriptEngine = scriptEngineFactory.getScriptEngine();
                scriptEngine.setBindings(getBindings(), 200);
                return scriptEngine;
            } catch (Exception unused) {
            }
        }
        Iterator<ScriptEngineFactory> it = this.engineSpis.iterator();
        while (true) {
            List<String> names = null;
            if (!it.hasNext()) {
                return null;
            }
            ScriptEngineFactory next = it.next();
            try {
                names = next.getNames();
            } catch (Exception unused2) {
            }
            if (names != null) {
                Iterator<String> it2 = names.iterator();
                while (it2.hasNext()) {
                    if (str.equals(it2.next())) {
                        try {
                            ScriptEngine scriptEngine2 = next.getScriptEngine();
                            scriptEngine2.setBindings(getBindings(), 200);
                            return scriptEngine2;
                        } catch (Exception unused3) {
                        }
                    }
                }
            }
        }
    }

    public List<ScriptEngineFactory> getEngineFactories() {
        ArrayList arrayList = new ArrayList(this.engineSpis.size());
        Iterator<ScriptEngineFactory> it = this.engineSpis.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void put(String str, Object obj) {
        this.globalScope.put(str, obj);
    }

    public void registerEngineExtension(String str, ScriptEngineFactory scriptEngineFactory) {
        if (str == null || scriptEngineFactory == null) {
            throw null;
        }
        this.extensionAssociations.put(str, scriptEngineFactory);
    }

    public void registerEngineMimeType(String str, ScriptEngineFactory scriptEngineFactory) {
        if (str == null || scriptEngineFactory == null) {
            throw null;
        }
        this.mimeTypeAssociations.put(str, scriptEngineFactory);
    }

    public void registerEngineName(String str, ScriptEngineFactory scriptEngineFactory) {
        if (str == null || scriptEngineFactory == null) {
            throw null;
        }
        this.nameAssociations.put(str, scriptEngineFactory);
    }

    public void setBindings(Bindings bindings) {
        if (bindings == null) {
            throw new IllegalArgumentException("Global scope cannot be null.");
        }
        this.globalScope = bindings;
    }

    public ScriptEngineManager(ClassLoader classLoader) {
        init(classLoader);
    }
}
