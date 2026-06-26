package com.jayway.jsonpath.internal;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.ParseContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import org.jsoup.helper.DataUtil;

/* JADX INFO: loaded from: classes.dex */
public class ParseContextImpl implements ParseContext {
    private final Configuration configuration;

    public ParseContextImpl() {
        this(Configuration.defaultConfiguration());
    }

    @Override // com.jayway.jsonpath.ParseContext
    public DocumentContext parse(Object obj) {
        Utils.notNull(obj, "json object can not be null", new Object[0]);
        return new JsonContext(obj, this.configuration);
    }

    public ParseContextImpl(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override // com.jayway.jsonpath.ParseContext
    public DocumentContext parse(String str) {
        Utils.notEmpty(str, "json string can not be null or empty", new Object[0]);
        return new JsonContext(this.configuration.jsonProvider().parse(str), this.configuration);
    }

    @Override // com.jayway.jsonpath.ParseContext
    public DocumentContext parse(InputStream inputStream) {
        return parse(inputStream, DataUtil.defaultCharset);
    }

    @Override // com.jayway.jsonpath.ParseContext
    public DocumentContext parse(InputStream inputStream, String str) {
        Utils.notNull(inputStream, "json input stream can not be null", new Object[0]);
        Utils.notNull(str, "charset can not be null", new Object[0]);
        try {
            return new JsonContext(this.configuration.jsonProvider().parse(inputStream, str), this.configuration);
        } finally {
            Utils.closeQuietly(inputStream);
        }
    }

    @Override // com.jayway.jsonpath.ParseContext
    public DocumentContext parse(File file) throws Throwable {
        Utils.notNull(file, "json file can not be null", new Object[0]);
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                DocumentContext documentContext = parse((InputStream) fileInputStream2);
                Utils.closeQuietly(fileInputStream2);
                return documentContext;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                Utils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.jayway.jsonpath.ParseContext
    @Deprecated
    public DocumentContext parse(URL url) throws Throwable {
        InputStream inputStreamOpenStream;
        Utils.notNull(url, "url can not be null", new Object[0]);
        try {
            inputStreamOpenStream = url.openStream();
            try {
                DocumentContext documentContext = parse(inputStreamOpenStream);
                Utils.closeQuietly(inputStreamOpenStream);
                return documentContext;
            } catch (Throwable th) {
                th = th;
                Utils.closeQuietly(inputStreamOpenStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenStream = null;
        }
    }
}
