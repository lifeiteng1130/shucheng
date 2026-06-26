package org.seimicrawler.xpath.core;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface Function {
    XValue call(Scope scope, List<XValue> list);

    String name();
}
