package com.jayway.jsonpath;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public interface ParseContext {
    DocumentContext parse(File file);

    DocumentContext parse(InputStream inputStream);

    DocumentContext parse(InputStream inputStream, String str);

    DocumentContext parse(Object obj);

    DocumentContext parse(String str);

    @Deprecated
    DocumentContext parse(URL url);
}
