package org.mozilla.javascript.regexp;

/* JADX INFO: compiled from: NativeRegExp.java */
/* JADX INFO: loaded from: classes3.dex */
public class RENode {
    public int bmsize;
    public char chr;
    public int flatIndex;
    public boolean greedy;
    public int index;
    public RENode kid;
    public RENode kid2;
    public int kidlen;
    public int length;
    public int max;
    public int min;
    public RENode next;
    public byte op;
    public int parenCount;
    public int parenIndex;
    public boolean sense;
    public int startIndex;

    public RENode(byte b2) {
        this.op = b2;
    }
}
