package org.mozilla.javascript;

import c.a.a.a.a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IdScriptableObject extends ScriptableObject implements IdFunctionCall {
    private static final long serialVersionUID = -3744239272168621609L;
    private transient PrototypeValues prototypeValues;

    public static final class PrototypeValues implements Serializable {
        private static final int NAME_SLOT = 1;
        private static final int SLOT_SPAN = 2;
        private static final long serialVersionUID = 3038645279153854371L;
        private short[] attributeArray;
        private IdFunctionObject constructor;
        private short constructorAttrs;
        public int constructorId;
        private int maxId;
        private IdScriptableObject obj;
        private Object[] valueArray;

        public PrototypeValues(IdScriptableObject idScriptableObject, int i2) {
            if (idScriptableObject == null) {
                throw new IllegalArgumentException();
            }
            if (i2 < 1) {
                throw new IllegalArgumentException();
            }
            this.obj = idScriptableObject;
            this.maxId = i2;
        }

        private Object ensureId(int i2) {
            Object[] objArr = this.valueArray;
            if (objArr == null) {
                synchronized (this) {
                    objArr = this.valueArray;
                    if (objArr == null) {
                        int i3 = this.maxId;
                        Object[] objArr2 = new Object[i3 * 2];
                        this.valueArray = objArr2;
                        this.attributeArray = new short[i3];
                        objArr = objArr2;
                    }
                }
            }
            int i4 = (i2 - 1) * 2;
            Object obj = objArr[i4];
            if (obj == null) {
                int i5 = this.constructorId;
                if (i2 == i5) {
                    initSlot(i5, "constructor", this.constructor, this.constructorAttrs);
                    this.constructor = null;
                } else {
                    this.obj.initPrototypeId(i2);
                }
                obj = objArr[i4];
                if (obj == null) {
                    throw new IllegalStateException(this.obj.getClass().getName() + ".initPrototypeId(int id) did not initialize id=" + i2);
                }
            }
            return obj;
        }

        private void initSlot(int i2, Object obj, Object obj2, int i3) {
            Object[] objArr = this.valueArray;
            if (objArr == null) {
                throw new IllegalStateException();
            }
            if (obj2 == null) {
                obj2 = UniqueTag.NULL_VALUE;
            }
            int i4 = i2 - 1;
            int i5 = i4 * 2;
            synchronized (this) {
                if (objArr[i5] == null) {
                    objArr[i5] = obj2;
                    objArr[i5 + 1] = obj;
                    this.attributeArray[i4] = (short) i3;
                } else if (!obj.equals(objArr[i5 + 1])) {
                    throw new IllegalStateException();
                }
            }
        }

        public final IdFunctionObject createPrecachedConstructor() {
            if (this.constructorId != 0) {
                throw new IllegalStateException();
            }
            int iFindPrototypeId = this.obj.findPrototypeId("constructor");
            this.constructorId = iFindPrototypeId;
            if (iFindPrototypeId == 0) {
                throw new IllegalStateException("No id for constructor property");
            }
            this.obj.initPrototypeId(iFindPrototypeId);
            IdFunctionObject idFunctionObject = this.constructor;
            if (idFunctionObject != null) {
                idFunctionObject.initFunction(this.obj.getClassName(), ScriptableObject.getTopLevelScope(this.obj));
                this.constructor.markAsConstructor(this.obj);
                return this.constructor;
            }
            throw new IllegalStateException(this.obj.getClass().getName() + ".initPrototypeId() did not initialize id=" + this.constructorId);
        }

        public final void delete(int i2) {
            ensureId(i2);
            int i3 = i2 - 1;
            if ((this.attributeArray[i3] & 4) != 0) {
                if (Context.getContext().isStrictMode()) {
                    throw ScriptRuntime.typeError1("msg.delete.property.with.configurable.false", (String) this.valueArray[(i3 * 2) + 1]);
                }
            } else {
                int i4 = i3 * 2;
                synchronized (this) {
                    this.valueArray[i4] = Scriptable.NOT_FOUND;
                    this.attributeArray[i3] = 0;
                }
            }
        }

        public final int findId(String str) {
            return this.obj.findPrototypeId(str);
        }

        public final Object get(int i2) {
            Object objEnsureId = ensureId(i2);
            if (objEnsureId == UniqueTag.NULL_VALUE) {
                return null;
            }
            return objEnsureId;
        }

        public final int getAttributes(int i2) {
            ensureId(i2);
            return this.attributeArray[i2 - 1];
        }

        public final int getMaxId() {
            return this.maxId;
        }

        public final Object[] getNames(boolean z, boolean z2, Object[] objArr) {
            int i2;
            Object[] objArr2 = null;
            int i3 = 0;
            for (int i4 = 1; i4 <= this.maxId; i4++) {
                Object objEnsureId = ensureId(i4);
                if ((z || (this.attributeArray[i4 - 1] & 2) == 0) && objEnsureId != Scriptable.NOT_FOUND) {
                    Object obj = this.valueArray[((i4 - 1) * 2) + 1];
                    if (obj instanceof String) {
                        if (objArr2 == null) {
                            objArr2 = new Object[this.maxId];
                        }
                        i2 = i3 + 1;
                        objArr2[i3] = obj;
                    } else if (z2 && (obj instanceof Symbol)) {
                        if (objArr2 == null) {
                            objArr2 = new Object[this.maxId];
                        }
                        i2 = i3 + 1;
                        objArr2[i3] = obj.toString();
                    }
                    i3 = i2;
                }
            }
            if (i3 == 0) {
                return objArr;
            }
            if (objArr == null || objArr.length == 0) {
                if (i3 == objArr2.length) {
                    return objArr2;
                }
                Object[] objArr3 = new Object[i3];
                System.arraycopy(objArr2, 0, objArr3, 0, i3);
                return objArr3;
            }
            int length = objArr.length;
            Object[] objArr4 = new Object[length + i3];
            System.arraycopy(objArr, 0, objArr4, 0, length);
            System.arraycopy(objArr2, 0, objArr4, length, i3);
            return objArr4;
        }

        public final boolean has(int i2) {
            Object obj;
            Object[] objArr = this.valueArray;
            return objArr == null || (obj = objArr[(i2 - 1) * 2]) == null || obj != Scriptable.NOT_FOUND;
        }

        public final void initValue(int i2, String str, Object obj, int i3) {
            if (1 > i2 || i2 > this.maxId) {
                throw new IllegalArgumentException();
            }
            if (str == null) {
                throw new IllegalArgumentException();
            }
            if (obj == Scriptable.NOT_FOUND) {
                throw new IllegalArgumentException();
            }
            ScriptableObject.checkValidAttributes(i3);
            if (this.obj.findPrototypeId(str) != i2) {
                throw new IllegalArgumentException(str);
            }
            if (i2 != this.constructorId) {
                initSlot(i2, str, obj, i3);
            } else {
                if (!(obj instanceof IdFunctionObject)) {
                    throw new IllegalArgumentException("consructor should be initialized with IdFunctionObject");
                }
                this.constructor = (IdFunctionObject) obj;
                this.constructorAttrs = (short) i3;
            }
        }

        public final void set(int i2, Scriptable scriptable, Object obj) {
            if (obj == Scriptable.NOT_FOUND) {
                throw new IllegalArgumentException();
            }
            ensureId(i2);
            int i3 = i2 - 1;
            if ((this.attributeArray[i3] & 1) == 0) {
                if (scriptable == this.obj) {
                    if (obj == null) {
                        obj = UniqueTag.NULL_VALUE;
                    }
                    int i4 = i3 * 2;
                    synchronized (this) {
                        this.valueArray[i4] = obj;
                    }
                    return;
                }
                Object obj2 = this.valueArray[(i3 * 2) + 1];
                if (!(obj2 instanceof Symbol)) {
                    scriptable.put((String) obj2, scriptable, obj);
                } else if (scriptable instanceof SymbolScriptable) {
                    ((SymbolScriptable) scriptable).put((Symbol) obj2, scriptable, obj);
                }
            }
        }

        public final void setAttributes(int i2, int i3) {
            ScriptableObject.checkValidAttributes(i3);
            ensureId(i2);
            synchronized (this) {
                this.attributeArray[i2 - 1] = (short) i3;
            }
        }

        public final int findId(Symbol symbol) {
            return this.obj.findPrototypeId(symbol);
        }

        public final void initValue(int i2, Symbol symbol, Object obj, int i3) {
            if (1 > i2 || i2 > this.maxId) {
                throw new IllegalArgumentException();
            }
            if (symbol != null) {
                if (obj != Scriptable.NOT_FOUND) {
                    ScriptableObject.checkValidAttributes(i3);
                    if (this.obj.findPrototypeId(symbol) == i2) {
                        if (i2 == this.constructorId) {
                            if (obj instanceof IdFunctionObject) {
                                this.constructor = (IdFunctionObject) obj;
                                this.constructorAttrs = (short) i3;
                                return;
                            }
                            throw new IllegalArgumentException("consructor should be initialized with IdFunctionObject");
                        }
                        initSlot(i2, symbol, obj, i3);
                        return;
                    }
                    throw new IllegalArgumentException(symbol.toString());
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
    }

    public IdScriptableObject() {
    }

    private ScriptableObject getBuiltInDescriptor(String str) {
        int iFindId;
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        int iFindInstanceIdInfo = findInstanceIdInfo(str);
        if (iFindInstanceIdInfo != 0) {
            return ScriptableObject.buildDataDescriptor(parentScope, getInstanceIdValue(65535 & iFindInstanceIdInfo), iFindInstanceIdInfo >>> 16);
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues == null || (iFindId = prototypeValues.findId(str)) == 0) {
            return null;
        }
        return ScriptableObject.buildDataDescriptor(parentScope, this.prototypeValues.get(iFindId), this.prototypeValues.getAttributes(iFindId));
    }

    public static EcmaError incompatibleCallError(IdFunctionObject idFunctionObject) {
        throw ScriptRuntime.typeError1("msg.incompat.call", idFunctionObject.getFunctionName());
    }

    public static int instanceIdInfo(int i2, int i3) {
        return (i2 << 16) | i3;
    }

    private IdFunctionObject newIdFunction(Object obj, int i2, String str, int i3, Scriptable scriptable) {
        IdFunctionObject idFunctionObject = Context.getContext().getLanguageVersion() < 200 ? new IdFunctionObject(this, obj, i2, str, i3, scriptable) : new IdFunctionObjectES6(this, obj, i2, str, i3, scriptable);
        if (isSealed()) {
            idFunctionObject.sealObject();
        }
        return idFunctionObject;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i2 = objectInputStream.readInt();
        if (i2 != 0) {
            activatePrototypeMap(i2);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        PrototypeValues prototypeValues = this.prototypeValues;
        objectOutputStream.writeInt(prototypeValues != null ? prototypeValues.getMaxId() : 0);
    }

    public final void activatePrototypeMap(int i2) {
        PrototypeValues prototypeValues = new PrototypeValues(this, i2);
        synchronized (this) {
            if (this.prototypeValues != null) {
                throw new IllegalStateException();
            }
            this.prototypeValues = prototypeValues;
        }
    }

    public void addIdFunctionProperty(Scriptable scriptable, Object obj, int i2, String str, int i3) {
        newIdFunction(obj, i2, str, i3, ScriptableObject.getTopLevelScope(scriptable)).addAsProperty(scriptable);
    }

    public final Object defaultGet(String str) {
        return super.get(str, this);
    }

    public final boolean defaultHas(String str) {
        return super.has(str, this);
    }

    public final void defaultPut(String str, Object obj) {
        super.put(str, this, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject) {
        int iFindId;
        if (obj instanceof String) {
            String str = (String) obj;
            int iFindInstanceIdInfo = findInstanceIdInfo(str);
            if (iFindInstanceIdInfo != 0) {
                int i2 = 65535 & iFindInstanceIdInfo;
                if (!isAccessorDescriptor(scriptableObject)) {
                    checkPropertyDefinition(scriptableObject);
                    checkPropertyChange(str, getOwnPropertyDescriptor(context, obj), scriptableObject);
                    int i3 = iFindInstanceIdInfo >>> 16;
                    Object property = ScriptableObject.getProperty(scriptableObject, ES6Iterator.VALUE_PROPERTY);
                    if (property != Scriptable.NOT_FOUND && (i3 & 1) == 0 && !sameValue(property, getInstanceIdValue(i2))) {
                        setInstanceIdValue(i2, property);
                    }
                    setAttributes(str, applyDescriptorToAttributeBitset(i3, scriptableObject));
                    return;
                }
                delete(i2);
            }
            PrototypeValues prototypeValues = this.prototypeValues;
            if (prototypeValues != null && (iFindId = prototypeValues.findId(str)) != 0) {
                if (!isAccessorDescriptor(scriptableObject)) {
                    checkPropertyDefinition(scriptableObject);
                    checkPropertyChange(str, getOwnPropertyDescriptor(context, obj), scriptableObject);
                    int attributes = this.prototypeValues.getAttributes(iFindId);
                    Object property2 = ScriptableObject.getProperty(scriptableObject, ES6Iterator.VALUE_PROPERTY);
                    if (property2 != Scriptable.NOT_FOUND && (attributes & 1) == 0 && !sameValue(property2, this.prototypeValues.get(iFindId))) {
                        this.prototypeValues.set(iFindId, this, property2);
                    }
                    this.prototypeValues.setAttributes(iFindId, applyDescriptorToAttributeBitset(attributes, scriptableObject));
                    if (super.has(str, this)) {
                        super.delete(str);
                        return;
                    }
                    return;
                }
                this.prototypeValues.delete(iFindId);
            }
        }
        super.defineOwnProperty(context, obj, scriptableObject);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(String str) {
        int iFindId;
        int iFindInstanceIdInfo = findInstanceIdInfo(str);
        if (iFindInstanceIdInfo != 0 && !isSealed()) {
            if (((iFindInstanceIdInfo >>> 16) & 4) == 0) {
                setInstanceIdValue(65535 & iFindInstanceIdInfo, Scriptable.NOT_FOUND);
                return;
            } else {
                if (Context.getContext().isStrictMode()) {
                    throw ScriptRuntime.typeError1("msg.delete.property.with.configurable.false", str);
                }
                return;
            }
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues == null || (iFindId = prototypeValues.findId(str)) == 0) {
            super.delete(str);
        } else {
            if (isSealed()) {
                return;
            }
            this.prototypeValues.delete(iFindId);
        }
    }

    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        throw idFunctionObject.unknown();
    }

    public final IdFunctionObject exportAsJSClass(int i2, Scriptable scriptable, boolean z) {
        if (scriptable != this && scriptable != null) {
            setParentScope(scriptable);
            setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        }
        activatePrototypeMap(i2);
        IdFunctionObject idFunctionObjectCreatePrecachedConstructor = this.prototypeValues.createPrecachedConstructor();
        if (z) {
            sealObject();
        }
        fillConstructorProperties(idFunctionObjectCreatePrecachedConstructor);
        if (z) {
            idFunctionObjectCreatePrecachedConstructor.sealObject();
        }
        idFunctionObjectCreatePrecachedConstructor.exportAsScopeProperty();
        return idFunctionObjectCreatePrecachedConstructor;
    }

    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
    }

    public int findInstanceIdInfo(String str) {
        return 0;
    }

    public int findInstanceIdInfo(Symbol symbol) {
        return 0;
    }

    public int findPrototypeId(String str) {
        throw new IllegalStateException(str);
    }

    public int findPrototypeId(Symbol symbol) {
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        int iFindId;
        Object obj;
        Object instanceIdValue;
        Object obj2 = super.get(str, scriptable);
        Object obj3 = Scriptable.NOT_FOUND;
        if (obj2 != obj3) {
            return obj2;
        }
        int iFindInstanceIdInfo = findInstanceIdInfo(str);
        if (iFindInstanceIdInfo != 0 && (instanceIdValue = getInstanceIdValue(iFindInstanceIdInfo & 65535)) != obj3) {
            return instanceIdValue;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        return (prototypeValues == null || (iFindId = prototypeValues.findId(str)) == 0 || (obj = this.prototypeValues.get(iFindId)) == obj3) ? obj3 : obj;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public int getAttributes(String str) {
        int iFindId;
        int iFindInstanceIdInfo = findInstanceIdInfo(str);
        if (iFindInstanceIdInfo != 0) {
            return iFindInstanceIdInfo >>> 16;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        return (prototypeValues == null || (iFindId = prototypeValues.findId(str)) == 0) ? super.getAttributes(str) : this.prototypeValues.getAttributes(iFindId);
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public Object[] getIds(boolean z, boolean z2) {
        Object[] ids = super.getIds(z, z2);
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null) {
            ids = prototypeValues.getNames(z, z2, ids);
        }
        int maxInstanceId = getMaxInstanceId();
        if (maxInstanceId == 0) {
            return ids;
        }
        Object[] objArr = null;
        int i2 = 0;
        while (maxInstanceId != 0) {
            String instanceIdName = getInstanceIdName(maxInstanceId);
            int iFindInstanceIdInfo = findInstanceIdInfo(instanceIdName);
            if (iFindInstanceIdInfo != 0) {
                int i3 = iFindInstanceIdInfo >>> 16;
                if (((i3 & 4) != 0 || Scriptable.NOT_FOUND != getInstanceIdValue(maxInstanceId)) && (z || (i3 & 2) == 0)) {
                    if (i2 == 0) {
                        objArr = new Object[maxInstanceId];
                    }
                    objArr[i2] = instanceIdName;
                    i2++;
                }
            }
            maxInstanceId--;
        }
        if (i2 == 0) {
            return ids;
        }
        if (ids.length == 0 && objArr.length == i2) {
            return objArr;
        }
        Object[] objArr2 = new Object[ids.length + i2];
        System.arraycopy(ids, 0, objArr2, 0, ids.length);
        System.arraycopy(objArr, 0, objArr2, ids.length, i2);
        return objArr2;
    }

    public String getInstanceIdName(int i2) {
        throw new IllegalArgumentException(String.valueOf(i2));
    }

    public Object getInstanceIdValue(int i2) {
        throw new IllegalStateException(String.valueOf(i2));
    }

    public int getMaxInstanceId() {
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        ScriptableObject ownPropertyDescriptor = super.getOwnPropertyDescriptor(context, obj);
        return ownPropertyDescriptor == null ? obj instanceof String ? getBuiltInDescriptor((String) obj) : ScriptRuntime.isSymbol(obj) ? getBuiltInDescriptor(((NativeSymbol) obj).getKey()) : ownPropertyDescriptor : ownPropertyDescriptor;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        int iFindId;
        int iFindInstanceIdInfo = findInstanceIdInfo(str);
        if (iFindInstanceIdInfo == 0) {
            PrototypeValues prototypeValues = this.prototypeValues;
            return (prototypeValues == null || (iFindId = prototypeValues.findId(str)) == 0) ? super.has(str, scriptable) : this.prototypeValues.has(iFindId);
        }
        if (((iFindInstanceIdInfo >>> 16) & 4) != 0) {
            return true;
        }
        return Scriptable.NOT_FOUND != getInstanceIdValue(65535 & iFindInstanceIdInfo);
    }

    public final boolean hasPrototypeMap() {
        return this.prototypeValues != null;
    }

    public final void initPrototypeConstructor(IdFunctionObject idFunctionObject) {
        int i2 = this.prototypeValues.constructorId;
        if (i2 == 0) {
            throw new IllegalStateException();
        }
        if (idFunctionObject.methodId() != i2) {
            throw new IllegalArgumentException();
        }
        if (isSealed()) {
            idFunctionObject.sealObject();
        }
        this.prototypeValues.initValue(i2, "constructor", idFunctionObject, 2);
    }

    public void initPrototypeId(int i2) {
        throw new IllegalStateException(String.valueOf(i2));
    }

    public final IdFunctionObject initPrototypeMethod(Object obj, int i2, String str, int i3) {
        return initPrototypeMethod(obj, i2, str, str, i3);
    }

    public final void initPrototypeValue(int i2, String str, Object obj, int i3) {
        this.prototypeValues.initValue(i2, str, obj, i3);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        int iFindId;
        int iFindInstanceIdInfo = findInstanceIdInfo(str);
        if (iFindInstanceIdInfo != 0) {
            if (scriptable == this && isSealed()) {
                throw Context.reportRuntimeError1("msg.modify.sealed", str);
            }
            if (((iFindInstanceIdInfo >>> 16) & 1) == 0) {
                if (scriptable == this) {
                    setInstanceIdValue(65535 & iFindInstanceIdInfo, obj);
                    return;
                } else {
                    scriptable.put(str, scriptable, obj);
                    return;
                }
            }
            return;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues == null || (iFindId = prototypeValues.findId(str)) == 0) {
            super.put(str, scriptable, obj);
        } else {
            if (scriptable == this && isSealed()) {
                throw Context.reportRuntimeError1("msg.modify.sealed", str);
            }
            this.prototypeValues.set(iFindId, scriptable, obj);
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public void setAttributes(String str, int i2) {
        int iFindId;
        ScriptableObject.checkValidAttributes(i2);
        int iFindInstanceIdInfo = findInstanceIdInfo(str);
        if (iFindInstanceIdInfo != 0) {
            int i3 = 65535 & iFindInstanceIdInfo;
            if (i2 != (iFindInstanceIdInfo >>> 16)) {
                setInstanceIdAttributes(i3, i2);
                return;
            }
            return;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues == null || (iFindId = prototypeValues.findId(str)) == 0) {
            super.setAttributes(str, i2);
        } else {
            this.prototypeValues.setAttributes(iFindId, i2);
        }
    }

    public void setInstanceIdAttributes(int i2, int i3) {
        StringBuilder sbR = a.r("Changing attributes not supported for ");
        sbR.append(getClassName());
        sbR.append(" ");
        sbR.append(getInstanceIdName(i2));
        sbR.append(" property");
        throw ScriptRuntime.constructError("InternalError", sbR.toString());
    }

    public void setInstanceIdValue(int i2, Object obj) {
        throw new IllegalStateException(String.valueOf(i2));
    }

    public IdScriptableObject(Scriptable scriptable, Scriptable scriptable2) {
        super(scriptable, scriptable2);
    }

    public final IdFunctionObject initPrototypeMethod(Object obj, int i2, String str, String str2, int i3) {
        IdFunctionObject idFunctionObjectNewIdFunction = newIdFunction(obj, i2, str2 != null ? str2 : str, i3, ScriptableObject.getTopLevelScope(this));
        this.prototypeValues.initValue(i2, str, idFunctionObjectNewIdFunction, 2);
        return idFunctionObjectNewIdFunction;
    }

    public final void initPrototypeValue(int i2, Symbol symbol, Object obj, int i3) {
        this.prototypeValues.initValue(i2, symbol, obj, i3);
    }

    public final IdFunctionObject initPrototypeMethod(Object obj, int i2, Symbol symbol, String str, int i3) {
        IdFunctionObject idFunctionObjectNewIdFunction = newIdFunction(obj, i2, str, i3, ScriptableObject.getTopLevelScope(this));
        this.prototypeValues.initValue(i2, symbol, idFunctionObjectNewIdFunction, 2);
        return idFunctionObjectNewIdFunction;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public int getAttributes(Symbol symbol) {
        int iFindId;
        int iFindInstanceIdInfo = findInstanceIdInfo(symbol);
        if (iFindInstanceIdInfo != 0) {
            return iFindInstanceIdInfo >>> 16;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null && (iFindId = prototypeValues.findId(symbol)) != 0) {
            return this.prototypeValues.getAttributes(iFindId);
        }
        return super.getAttributes(symbol);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.SymbolScriptable
    public boolean has(Symbol symbol, Scriptable scriptable) {
        int iFindId;
        int iFindInstanceIdInfo = findInstanceIdInfo(symbol);
        if (iFindInstanceIdInfo != 0) {
            if (((iFindInstanceIdInfo >>> 16) & 4) != 0) {
                return true;
            }
            return Scriptable.NOT_FOUND != getInstanceIdValue(65535 & iFindInstanceIdInfo);
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null && (iFindId = prototypeValues.findId(symbol)) != 0) {
            return this.prototypeValues.has(iFindId);
        }
        return super.has(symbol, scriptable);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.SymbolScriptable
    public Object get(Symbol symbol, Scriptable scriptable) {
        int iFindId;
        Object obj;
        Object instanceIdValue;
        Object obj2 = super.get(symbol, scriptable);
        Object obj3 = Scriptable.NOT_FOUND;
        if (obj2 != obj3) {
            return obj2;
        }
        int iFindInstanceIdInfo = findInstanceIdInfo(symbol);
        if (iFindInstanceIdInfo != 0 && (instanceIdValue = getInstanceIdValue(iFindInstanceIdInfo & 65535)) != obj3) {
            return instanceIdValue;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        return (prototypeValues == null || (iFindId = prototypeValues.findId(symbol)) == 0 || (obj = this.prototypeValues.get(iFindId)) == obj3) ? obj3 : obj;
    }

    private ScriptableObject getBuiltInDescriptor(Symbol symbol) {
        int iFindId;
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues == null || (iFindId = prototypeValues.findId(symbol)) == 0) {
            return null;
        }
        return ScriptableObject.buildDataDescriptor(parentScope, this.prototypeValues.get(iFindId), this.prototypeValues.getAttributes(iFindId));
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.SymbolScriptable
    public void delete(Symbol symbol) {
        int iFindId;
        int iFindInstanceIdInfo = findInstanceIdInfo(symbol);
        if (iFindInstanceIdInfo != 0 && !isSealed()) {
            if (((iFindInstanceIdInfo >>> 16) & 4) != 0) {
                if (Context.getContext().isStrictMode()) {
                    throw ScriptRuntime.typeError0("msg.delete.property.with.configurable.false");
                }
                return;
            } else {
                setInstanceIdValue(65535 & iFindInstanceIdInfo, Scriptable.NOT_FOUND);
                return;
            }
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null && (iFindId = prototypeValues.findId(symbol)) != 0) {
            if (isSealed()) {
                return;
            }
            this.prototypeValues.delete(iFindId);
            return;
        }
        super.delete(symbol);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.SymbolScriptable
    public void put(Symbol symbol, Scriptable scriptable, Object obj) {
        int iFindId;
        int iFindInstanceIdInfo = findInstanceIdInfo(symbol);
        if (iFindInstanceIdInfo != 0) {
            if (scriptable == this && isSealed()) {
                throw Context.reportRuntimeError0("msg.modify.sealed");
            }
            if (((iFindInstanceIdInfo >>> 16) & 1) == 0) {
                if (scriptable == this) {
                    setInstanceIdValue(65535 & iFindInstanceIdInfo, obj);
                    return;
                } else {
                    ScriptableObject.ensureSymbolScriptable(scriptable).put(symbol, scriptable, obj);
                    return;
                }
            }
            return;
        }
        PrototypeValues prototypeValues = this.prototypeValues;
        if (prototypeValues != null && (iFindId = prototypeValues.findId(symbol)) != 0) {
            if (scriptable == this && isSealed()) {
                throw Context.reportRuntimeError0("msg.modify.sealed");
            }
            this.prototypeValues.set(iFindId, scriptable, obj);
            return;
        }
        super.put(symbol, scriptable, obj);
    }
}
