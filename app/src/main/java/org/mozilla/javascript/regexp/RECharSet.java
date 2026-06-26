package org.mozilla.javascript.regexp;

import java.io.Serializable;

/* JADX INFO: compiled from: NativeRegExp.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RECharSet implements Serializable {
    private static final long serialVersionUID = 7931787979395898394L;
    public volatile transient byte[] bits;
    public volatile transient boolean converted;
    public final int length;
    public final boolean sense;
    public final int startIndex;
    public final int strlength;

    public RECharSet(int i2, int i3, int i4, boolean z) {
        this.length = i2;
        this.startIndex = i3;
        this.strlength = i4;
        this.sense = z;
    }
}
