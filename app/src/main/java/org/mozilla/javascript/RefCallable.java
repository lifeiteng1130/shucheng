package org.mozilla.javascript;

/* JADX INFO: loaded from: classes3.dex */
public interface RefCallable extends Callable {
    Ref refCall(Context context, Scriptable scriptable, Object[] objArr);
}
