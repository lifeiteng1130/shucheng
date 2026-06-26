package org.mozilla.javascript.regexp;

/* JADX INFO: compiled from: NativeRegExp.java */
/* JADX INFO: loaded from: classes3.dex */
public class REBackTrackData {
    public final int continuationOp;
    public final int continuationPc;
    public final int cp;
    public final int op;
    public final long[] parens;
    public final int pc;
    public final REBackTrackData previous;
    public final REProgState stateStackTop;

    public REBackTrackData(REGlobalData rEGlobalData, int i2, int i3, int i4, int i5, int i6) {
        this.previous = rEGlobalData.backTrackStackTop;
        this.op = i2;
        this.pc = i3;
        this.cp = i4;
        this.continuationOp = i5;
        this.continuationPc = i6;
        this.parens = rEGlobalData.parens;
        this.stateStackTop = rEGlobalData.stateStackTop;
    }
}
