package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

/* JADX INFO: compiled from: RegExpImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GlobData {
    public Scriptable arrayobj;
    public StringBuilder charBuf;
    public int dollar = -1;
    public boolean global;
    public Function lambda;
    public int leftIndex;
    public int mode;
    public String repstr;
    public String str;
}
