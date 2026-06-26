package org.mozilla.javascript;

import org.mozilla.javascript.ContextFactory;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface ContextListener extends ContextFactory.Listener {
    @Deprecated
    void contextEntered(Context context);

    @Deprecated
    void contextExited(Context context);
}
