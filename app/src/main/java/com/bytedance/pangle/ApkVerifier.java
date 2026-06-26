package com.bytedance.pangle;

import androidx.annotation.Keep;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface ApkVerifier {
    boolean verify(File file);
}
