package com.umeng.analytics.pro;

import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.ax;
import java.io.Serializable;

/* JADX INFO: compiled from: TBase.java */
/* JADX INFO: loaded from: classes.dex */
public interface aq<T extends aq<?, ?>, F extends ax> extends Serializable {
    void clear();

    aq<T, F> deepCopy();

    F fieldForId(int i2);

    void read(bp bpVar);

    void write(bp bpVar);
}
