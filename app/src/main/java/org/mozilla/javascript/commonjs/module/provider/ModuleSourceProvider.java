package org.mozilla.javascript.commonjs.module.provider;

import java.net.URI;
import org.mozilla.javascript.Scriptable;

/* JADX INFO: loaded from: classes3.dex */
public interface ModuleSourceProvider {
    public static final ModuleSource NOT_MODIFIED = new ModuleSource(null, null, null, null, null);

    ModuleSource loadSource(String str, Scriptable scriptable, Object obj);

    ModuleSource loadSource(URI uri, URI uri2, Object obj);
}
