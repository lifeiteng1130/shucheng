package com.jayway.jsonpath;

import com.jayway.jsonpath.internal.EvaluationContext;
import com.jayway.jsonpath.internal.ParseContextImpl;
import com.jayway.jsonpath.internal.Path;
import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.internal.Utils;
import com.jayway.jsonpath.internal.path.PathCompiler;
import com.jayway.jsonpath.spi.json.JsonProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import org.jsoup.helper.DataUtil;

/* JADX INFO: loaded from: classes.dex */
public class JsonPath {
    private final Path path;

    private JsonPath(String str, Predicate[] predicateArr) {
        Utils.notNull(str, "path can not be null", new Object[0]);
        this.path = PathCompiler.compile(str, predicateArr);
    }

    public static JsonPath compile(String str, Predicate... predicateArr) {
        Utils.notEmpty(str, "json can not be null or empty", new Object[0]);
        return new JsonPath(str, predicateArr);
    }

    public static boolean isPathDefinite(String str) {
        return compile(str, new Predicate[0]).isDefinite();
    }

    public static DocumentContext parse(Object obj) {
        return new ParseContextImpl().parse(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T resultByConfiguration(Object obj, Configuration configuration, EvaluationContext evaluationContext) {
        return configuration.containsOption(Option.AS_PATH_LIST) ? (T) evaluationContext.getPathList() : obj;
    }

    public static ParseContext using(Configuration configuration) {
        return new ParseContextImpl(configuration);
    }

    public <T> T add(Object obj, Object obj2, Configuration configuration) {
        Utils.notNull(obj, "json can not be null", new Object[0]);
        Utils.notNull(configuration, "configuration can not be null", new Object[0]);
        EvaluationContext evaluationContextEvaluate = this.path.evaluate(obj, obj, configuration, true);
        Iterator<PathRef> it = evaluationContextEvaluate.updateOperations().iterator();
        while (it.hasNext()) {
            it.next().add(obj2, configuration);
        }
        return (T) resultByConfiguration(obj, configuration, evaluationContextEvaluate);
    }

    public <T> T delete(Object obj, Configuration configuration) {
        Utils.notNull(obj, "json can not be null", new Object[0]);
        Utils.notNull(configuration, "configuration can not be null", new Object[0]);
        EvaluationContext evaluationContextEvaluate = this.path.evaluate(obj, obj, configuration, true);
        Iterator<PathRef> it = evaluationContextEvaluate.updateOperations().iterator();
        while (it.hasNext()) {
            it.next().delete(configuration);
        }
        return (T) resultByConfiguration(obj, configuration, evaluationContextEvaluate);
    }

    public String getPath() {
        return this.path.toString();
    }

    public boolean isDefinite() {
        return this.path.isDefinite();
    }

    public <T> T map(Object obj, MapFunction mapFunction, Configuration configuration) {
        Utils.notNull(obj, "json can not be null", new Object[0]);
        Utils.notNull(configuration, "configuration can not be null", new Object[0]);
        Utils.notNull(mapFunction, "mapFunction can not be null", new Object[0]);
        EvaluationContext evaluationContextEvaluate = this.path.evaluate(obj, obj, configuration, true);
        Iterator<PathRef> it = evaluationContextEvaluate.updateOperations().iterator();
        while (it.hasNext()) {
            it.next().convert(mapFunction, configuration);
        }
        return (T) resultByConfiguration(obj, configuration, evaluationContextEvaluate);
    }

    public <T> T put(Object obj, String str, Object obj2, Configuration configuration) {
        Utils.notNull(obj, "json can not be null", new Object[0]);
        Utils.notEmpty(str, "key can not be null or empty", new Object[0]);
        Utils.notNull(configuration, "configuration can not be null", new Object[0]);
        EvaluationContext evaluationContextEvaluate = this.path.evaluate(obj, obj, configuration, true);
        Iterator<PathRef> it = evaluationContextEvaluate.updateOperations().iterator();
        while (it.hasNext()) {
            it.next().put(str, obj2, configuration);
        }
        return (T) resultByConfiguration(obj, configuration, evaluationContextEvaluate);
    }

    public <T> T read(Object obj) {
        return (T) read(obj, Configuration.defaultConfiguration());
    }

    public <T> T renameKey(Object obj, String str, String str2, Configuration configuration) {
        Utils.notNull(obj, "json can not be null", new Object[0]);
        Utils.notEmpty(str2, "newKeyName can not be null or empty", new Object[0]);
        Utils.notNull(configuration, "configuration can not be null", new Object[0]);
        EvaluationContext evaluationContextEvaluate = this.path.evaluate(obj, obj, configuration, true);
        Iterator<PathRef> it = evaluationContextEvaluate.updateOperations().iterator();
        while (it.hasNext()) {
            it.next().renameKey(str, str2, configuration);
        }
        return (T) resultByConfiguration(obj, configuration, evaluationContextEvaluate);
    }

    public <T> T set(Object obj, Object obj2, Configuration configuration) {
        Utils.notNull(obj, "json can not be null", new Object[0]);
        Utils.notNull(configuration, "configuration can not be null", new Object[0]);
        EvaluationContext evaluationContextEvaluate = this.path.evaluate(obj, obj, configuration, true);
        Iterator<PathRef> it = evaluationContextEvaluate.updateOperations().iterator();
        while (it.hasNext()) {
            it.next().set(obj2, configuration);
        }
        return (T) resultByConfiguration(obj, configuration, evaluationContextEvaluate);
    }

    public static DocumentContext parse(String str) {
        return new ParseContextImpl().parse(str);
    }

    @Deprecated
    public static ParseContext using(JsonProvider jsonProvider) {
        return new ParseContextImpl(Configuration.builder().jsonProvider(jsonProvider).build());
    }

    public <T> T read(Object obj, Configuration configuration) {
        Option option = Option.AS_PATH_LIST;
        boolean zContainsOption = configuration.containsOption(option);
        Option option2 = Option.ALWAYS_RETURN_LIST;
        boolean zContainsOption2 = configuration.containsOption(option2);
        boolean zContainsOption3 = configuration.containsOption(Option.SUPPRESS_EXCEPTIONS);
        try {
            if (!this.path.isFunctionPath()) {
                if (zContainsOption) {
                    return (T) this.path.evaluate(obj, obj, configuration).getPath();
                }
                T t = (T) this.path.evaluate(obj, obj, configuration).getValue(false);
                if (!zContainsOption2 || !this.path.isDefinite()) {
                    return t;
                }
                T t2 = (T) configuration.jsonProvider().createArray();
                configuration.jsonProvider().setArrayIndex(t2, 0, t);
                return t2;
            }
            if (!zContainsOption && !zContainsOption2) {
                return (T) this.path.evaluate(obj, obj, configuration).getValue(true);
            }
            throw new JsonPathException("Options " + option + " and " + option2 + " are not allowed when using path functions!");
        } catch (RuntimeException e2) {
            if (!zContainsOption3) {
                throw e2;
            }
            if (zContainsOption) {
                return (T) configuration.jsonProvider().createArray();
            }
            if (zContainsOption2) {
                return (T) configuration.jsonProvider().createArray();
            }
            if (this.path.isDefinite()) {
                return null;
            }
            return (T) configuration.jsonProvider().createArray();
        }
    }

    public static DocumentContext parse(InputStream inputStream) {
        return new ParseContextImpl().parse(inputStream);
    }

    public static DocumentContext parse(File file) {
        return new ParseContextImpl().parse(file);
    }

    @Deprecated
    public static DocumentContext parse(URL url) {
        return new ParseContextImpl().parse(url);
    }

    public static DocumentContext parse(Object obj, Configuration configuration) {
        return new ParseContextImpl(configuration).parse(obj);
    }

    public static DocumentContext parse(String str, Configuration configuration) {
        return new ParseContextImpl(configuration).parse(str);
    }

    public static DocumentContext parse(InputStream inputStream, Configuration configuration) {
        return new ParseContextImpl(configuration).parse(inputStream);
    }

    public static DocumentContext parse(File file, Configuration configuration) {
        return new ParseContextImpl(configuration).parse(file);
    }

    @Deprecated
    public static DocumentContext parse(URL url, Configuration configuration) {
        return new ParseContextImpl(configuration).parse(url);
    }

    public <T> T read(String str) {
        return (T) read(str, Configuration.defaultConfiguration());
    }

    public <T> T read(String str, Configuration configuration) {
        Utils.notEmpty(str, "json can not be null or empty", new Object[0]);
        Utils.notNull(configuration, "jsonProvider can not be null", new Object[0]);
        return (T) read(configuration.jsonProvider().parse(str), configuration);
    }

    public <T> T read(URL url) {
        return (T) read(url, Configuration.defaultConfiguration());
    }

    public <T> T read(File file) {
        return (T) read(file, Configuration.defaultConfiguration());
    }

    public <T> T read(File file, Configuration configuration) throws Throwable {
        Utils.notNull(file, "json file can not be null", new Object[0]);
        Utils.isTrue(file.exists(), "json file does not exist");
        Utils.notNull(configuration, "jsonProvider can not be null", new Object[0]);
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                T t = (T) read((InputStream) fileInputStream2, configuration);
                Utils.closeQuietly(fileInputStream2);
                return t;
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

    public <T> T read(InputStream inputStream) {
        return (T) read(inputStream, Configuration.defaultConfiguration());
    }

    public <T> T read(InputStream inputStream, Configuration configuration) {
        Utils.notNull(inputStream, "json input stream can not be null", new Object[0]);
        Utils.notNull(configuration, "configuration can not be null", new Object[0]);
        return (T) read(inputStream, DataUtil.defaultCharset, configuration);
    }

    public <T> T read(InputStream inputStream, String str, Configuration configuration) {
        Utils.notNull(inputStream, "json input stream can not be null", new Object[0]);
        Utils.notNull(str, "charset can not be null", new Object[0]);
        Utils.notNull(configuration, "configuration can not be null", new Object[0]);
        try {
            return (T) read(configuration.jsonProvider().parse(inputStream, str), configuration);
        } finally {
            Utils.closeQuietly(inputStream);
        }
    }

    public static <T> T read(Object obj, String str, Predicate... predicateArr) {
        return (T) parse(obj).read(str, predicateArr);
    }

    public static <T> T read(String str, String str2, Predicate... predicateArr) {
        return (T) new ParseContextImpl().parse(str).read(str2, predicateArr);
    }

    @Deprecated
    public static <T> T read(URL url, String str, Predicate... predicateArr) {
        return (T) new ParseContextImpl().parse(url).read(str, predicateArr);
    }

    public static <T> T read(File file, String str, Predicate... predicateArr) {
        return (T) new ParseContextImpl().parse(file).read(str, predicateArr);
    }

    public static <T> T read(InputStream inputStream, String str, Predicate... predicateArr) {
        return (T) new ParseContextImpl().parse(inputStream).read(str, predicateArr);
    }
}
