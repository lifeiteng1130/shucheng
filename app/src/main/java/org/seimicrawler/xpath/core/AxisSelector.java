package org.seimicrawler.xpath.core;

import org.jsoup.select.Elements;

/* JADX INFO: loaded from: classes3.dex */
public interface AxisSelector {
    XValue apply(Elements elements);

    String name();
}
