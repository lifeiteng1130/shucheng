package org.mozilla.javascript.commonjs.module.provider;

import java.net.URLConnection;

/* JADX INFO: loaded from: classes3.dex */
public interface UrlConnectionSecurityDomainProvider {
    Object getSecurityDomain(URLConnection uRLConnection);
}
