package org.mozilla.javascript.regexp;

/* JADX INFO: compiled from: NativeRegExp.java */
/* JADX INFO: loaded from: classes3.dex */
public class REGlobalData {
    public REBackTrackData backTrackStackTop;
    public int cp;
    public boolean multiline;
    public long[] parens;
    public RECompiled regexp;
    public int skipped;
    public REProgState stateStackTop;

    public int parensIndex(int i2) {
        return (int) this.parens[i2];
    }

    public int parensLength(int i2) {
        return (int) (this.parens[i2] >>> 32);
    }

    public void setParens(int i2, int i3, int i4) {
        REBackTrackData rEBackTrackData = this.backTrackStackTop;
        if (rEBackTrackData != null) {
            long[] jArr = rEBackTrackData.parens;
            long[] jArr2 = this.parens;
            if (jArr == jArr2) {
                this.parens = (long[]) jArr2.clone();
            }
        }
        this.parens[i2] = (((long) i4) << 32) | (((long) i3) & 4294967295L);
    }
}
