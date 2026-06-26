package org.mozilla.javascript.regexp;

/* JADX INFO: compiled from: NativeRegExp.java */
/* JADX INFO: loaded from: classes3.dex */
public class REProgState {
    public final REBackTrackData backTrack;
    public final int continuationOp;
    public final int continuationPc;
    public final int index;
    public final int max;
    public final int min;
    public final REProgState previous;

    public REProgState(REProgState rEProgState, int i2, int i3, int i4, REBackTrackData rEBackTrackData, int i5, int i6) {
        this.previous = rEProgState;
        this.min = i2;
        this.max = i3;
        this.index = i4;
        this.continuationOp = i5;
        this.continuationPc = i6;
        this.backTrack = rEBackTrackData;
    }
}
