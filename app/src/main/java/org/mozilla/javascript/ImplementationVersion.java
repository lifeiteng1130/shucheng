package org.mozilla.javascript;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/* JADX INFO: loaded from: classes3.dex */
public class ImplementationVersion {
    private static final ImplementationVersion version = new ImplementationVersion();
    private String versionString;

    private ImplementationVersion() {
        InputStream inputStreamOpenStream;
        Attributes mainAttributes;
        try {
            Enumeration<URL> resources = ImplementationVersion.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                try {
                    inputStreamOpenStream = resources.nextElement().openStream();
                    try {
                        mainAttributes = new Manifest(inputStreamOpenStream).getMainAttributes();
                    } finally {
                    }
                } catch (IOException unused) {
                }
                if ("Mozilla Rhino".equals(mainAttributes.getValue("Implementation-Title"))) {
                    this.versionString = "Rhino " + mainAttributes.getValue("Implementation-Version") + " " + mainAttributes.getValue("Built-Date").replaceAll("-", " ");
                    if (inputStreamOpenStream != null) {
                        inputStreamOpenStream.close();
                        return;
                    }
                    return;
                }
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
            }
        } catch (IOException unused2) {
        }
    }

    public static String get() {
        return version.versionString;
    }
}
