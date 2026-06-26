package org.mozilla.javascript;

/* JADX INFO: loaded from: classes3.dex */
public class ImporterTopLevel extends TopLevel {
    private static final Object IMPORTER_TAG = "Importer";
    private static final int Id_constructor = 1;
    private static final int Id_importClass = 2;
    private static final int Id_importPackage = 3;
    private static final int MAX_PROTOTYPE_ID = 3;
    private static final long serialVersionUID = -9095380847465315412L;
    private ObjArray importedPackages;
    private boolean topScopeFlag;

    public ImporterTopLevel() {
        this.importedPackages = new ObjArray();
    }

    private Object getPackageProperty(String str, Scriptable scriptable) {
        Object[] array;
        Object obj = Scriptable.NOT_FOUND;
        synchronized (this.importedPackages) {
            array = this.importedPackages.toArray();
        }
        for (Object obj2 : array) {
            Object pkgProperty = ((NativeJavaPackage) obj2).getPkgProperty(str, scriptable, false);
            if (pkgProperty != null && !(pkgProperty instanceof NativeJavaPackage)) {
                if (obj != Scriptable.NOT_FOUND) {
                    throw Context.reportRuntimeError2("msg.ambig.import", obj.toString(), pkgProperty.toString());
                }
                obj = pkgProperty;
            }
        }
        return obj;
    }

    private void importClass(NativeJavaClass nativeJavaClass) {
        String name = nativeJavaClass.getClassObject().getName();
        String strSubstring = name.substring(name.lastIndexOf(46) + 1);
        Object obj = get(strSubstring, this);
        if (obj != Scriptable.NOT_FOUND && obj != nativeJavaClass) {
            throw Context.reportRuntimeError1("msg.prop.defined", strSubstring);
        }
        put(strSubstring, this, nativeJavaClass);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new ImporterTopLevel().exportAsJSClass(3, scriptable, z);
    }

    private Object js_construct(Scriptable scriptable, Object[] objArr) {
        ImporterTopLevel importerTopLevel = new ImporterTopLevel();
        for (int i2 = 0; i2 != objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj instanceof NativeJavaClass) {
                importerTopLevel.importClass((NativeJavaClass) obj);
            } else {
                if (!(obj instanceof NativeJavaPackage)) {
                    throw Context.reportRuntimeError1("msg.not.class.not.pkg", Context.toString(obj));
                }
                importerTopLevel.importPackage((NativeJavaPackage) obj);
            }
        }
        importerTopLevel.setParentScope(scriptable);
        importerTopLevel.setPrototype(this);
        return importerTopLevel;
    }

    private Object js_importClass(Object[] objArr) {
        for (int i2 = 0; i2 != objArr.length; i2++) {
            Object obj = objArr[i2];
            if (!(obj instanceof NativeJavaClass)) {
                throw Context.reportRuntimeError1("msg.not.class", Context.toString(obj));
            }
            importClass((NativeJavaClass) obj);
        }
        return Undefined.instance;
    }

    private Object js_importPackage(Object[] objArr) {
        for (int i2 = 0; i2 != objArr.length; i2++) {
            Object obj = objArr[i2];
            if (!(obj instanceof NativeJavaPackage)) {
                throw Context.reportRuntimeError1("msg.not.pkg", Context.toString(obj));
            }
            importPackage((NativeJavaPackage) obj);
        }
        return Undefined.instance;
    }

    private ImporterTopLevel realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (this.topScopeFlag) {
            return this;
        }
        if (scriptable instanceof ImporterTopLevel) {
            return (ImporterTopLevel) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(IMPORTER_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            return js_construct(scriptable, objArr);
        }
        if (iMethodId == 2) {
            return realThis(scriptable2, idFunctionObject).js_importClass(objArr);
        }
        if (iMethodId == 3) {
            return realThis(scriptable2, idFunctionObject).js_importPackage(objArr);
        }
        throw new IllegalArgumentException(String.valueOf(iMethodId));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findPrototypeId(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.length()
            r1 = 0
            r2 = 11
            if (r0 != r2) goto L1d
            char r0 = r4.charAt(r1)
            r2 = 99
            if (r0 != r2) goto L15
            r0 = 1
            java.lang.String r2 = "constructor"
            goto L27
        L15:
            r2 = 105(0x69, float:1.47E-43)
            if (r0 != r2) goto L25
            r0 = 2
            java.lang.String r2 = "importClass"
            goto L27
        L1d:
            r2 = 13
            if (r0 != r2) goto L25
            r0 = 3
            java.lang.String r2 = "importPackage"
            goto L27
        L25:
            r2 = 0
            r0 = 0
        L27:
            if (r2 == 0) goto L32
            if (r2 == r4) goto L32
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L32
            goto L33
        L32:
            r1 = r0
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ImporterTopLevel.findPrototypeId(java.lang.String):int");
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        Object obj = super.get(str, scriptable);
        return obj != Scriptable.NOT_FOUND ? obj : getPackageProperty(str, scriptable);
    }

    @Override // org.mozilla.javascript.TopLevel, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return this.topScopeFlag ? "global" : "JavaImporter";
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return super.has(str, scriptable) || getPackageProperty(str, scriptable) != Scriptable.NOT_FOUND;
    }

    @Deprecated
    public void importPackage(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        js_importPackage(objArr);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i2) {
        String str;
        int i3 = 1;
        if (i2 == 1) {
            i3 = 0;
            str = "constructor";
        } else if (i2 == 2) {
            str = "importClass";
        } else {
            if (i2 != 3) {
                throw new IllegalArgumentException(String.valueOf(i2));
            }
            str = "importPackage";
        }
        initPrototypeMethod(IMPORTER_TAG, i2, str, i3);
    }

    public void initStandardObjects(Context context, boolean z) {
        context.initStandardObjects(this, z);
        this.topScopeFlag = true;
        IdFunctionObject idFunctionObjectExportAsJSClass = exportAsJSClass(3, this, false);
        if (z) {
            idFunctionObjectExportAsJSClass.sealObject();
        }
        delete("constructor");
    }

    private void importPackage(NativeJavaPackage nativeJavaPackage) {
        if (nativeJavaPackage == null) {
            return;
        }
        synchronized (this.importedPackages) {
            for (int i2 = 0; i2 != this.importedPackages.size(); i2++) {
                if (nativeJavaPackage.equals(this.importedPackages.get(i2))) {
                    return;
                }
            }
            this.importedPackages.add(nativeJavaPackage);
        }
    }

    public ImporterTopLevel(Context context) {
        this(context, false);
    }

    public ImporterTopLevel(Context context, boolean z) {
        this.importedPackages = new ObjArray();
        initStandardObjects(context, z);
    }
}
