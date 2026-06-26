package org.mozilla.javascript;

import c.a.a.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class NativeJavaConstructor extends BaseFunction {
    private static final long serialVersionUID = -8149253217482668463L;
    public MemberBox ctor;

    public NativeJavaConstructor(MemberBox memberBox) {
        this.ctor = memberBox;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return NativeJavaClass.constructSpecific(context, scriptable, objArr, this.ctor);
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        return "<init>".concat(JavaMembers.liveConnectSignature(this.ctor.argTypes));
    }

    public String toString() {
        StringBuilder sbR = a.r("[JavaConstructor ");
        sbR.append(this.ctor.getName());
        sbR.append("]");
        return sbR.toString();
    }
}
