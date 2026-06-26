package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Context;

/* JADX INFO: compiled from: NativeRegExp.java */
/* JADX INFO: loaded from: classes3.dex */
public class CompilerState {
    public char[] cpbegin;
    public int cpend;
    public Context cx;
    public int flags;
    public int parenNesting;
    public RENode result;
    public int cp = 0;
    public int backReferenceLimit = Integer.MAX_VALUE;
    public int maxBackReference = 0;
    public int parenCount = 0;
    public int classCount = 0;
    public int progLength = 0;

    public CompilerState(Context context, char[] cArr, int i2, int i3) {
        this.cx = context;
        this.cpbegin = cArr;
        this.cpend = i2;
        this.flags = i3;
    }
}
