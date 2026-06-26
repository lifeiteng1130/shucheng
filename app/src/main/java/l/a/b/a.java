package l.a.b;

import java.net.NetPermission;
import java.net.SocketPermission;
import java.security.AllPermission;
import java.security.SecurityPermission;

/* JADX INFO: compiled from: SecurityConstants.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final RuntimePermission a;

    static {
        new AllPermission();
        new NetPermission("specifyStreamHandler");
        new NetPermission("setProxySelector");
        new NetPermission("getProxySelector");
        new NetPermission("setCookieHandler");
        new NetPermission("getCookieHandler");
        new NetPermission("setResponseCache");
        new NetPermission("getResponseCache");
        new RuntimePermission("createClassLoader");
        new RuntimePermission("accessDeclaredMembers");
        new RuntimePermission("modifyThread");
        new RuntimePermission("modifyThreadGroup");
        new RuntimePermission("getProtectionDomain");
        a = new RuntimePermission("getClassLoader");
        new RuntimePermission("stopThread");
        new RuntimePermission("getStackTrace");
        new SecurityPermission("createAccessControlContext");
        new SecurityPermission("getDomainCombiner");
        new SecurityPermission("getPolicy");
        new SocketPermission("localhost:1024-", "listen");
    }
}
