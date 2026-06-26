package com.jayway.jsonpath.internal.path;

import c.a.a.a.a;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.EvaluationListener;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.internal.EvaluationAbortException;
import com.jayway.jsonpath.internal.EvaluationContext;
import com.jayway.jsonpath.internal.Path;
import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.internal.Utils;
import com.jayway.jsonpath.spi.json.JsonProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class EvaluationContextImpl implements EvaluationContext {
    private static final EvaluationAbortException ABORT_EVALUATION = new EvaluationAbortException();
    private final Configuration configuration;
    private final boolean forUpdate;
    private final Path path;
    private final Object pathResult;
    private final Object rootDocument;
    private final List<PathRef> updateOperations;
    private final Object valueResult;
    private final HashMap<Path, Object> documentEvalCache = new HashMap<>();
    private int resultIndex = 0;

    public static class FoundResultImpl implements EvaluationListener.FoundResult {
        private final int index;
        private final String path;
        private final Object result;

        @Override // com.jayway.jsonpath.EvaluationListener.FoundResult
        public int index() {
            return this.index;
        }

        @Override // com.jayway.jsonpath.EvaluationListener.FoundResult
        public String path() {
            return this.path;
        }

        @Override // com.jayway.jsonpath.EvaluationListener.FoundResult
        public Object result() {
            return this.result;
        }

        private FoundResultImpl(int i2, String str, Object obj) {
            this.index = i2;
            this.path = str;
            this.result = obj;
        }
    }

    public EvaluationContextImpl(Path path, Object obj, Configuration configuration, boolean z) {
        Utils.notNull(path, "path can not be null", new Object[0]);
        Utils.notNull(obj, "root can not be null", new Object[0]);
        Utils.notNull(configuration, "configuration can not be null", new Object[0]);
        this.forUpdate = z;
        this.path = path;
        this.rootDocument = obj;
        this.configuration = configuration;
        this.valueResult = configuration.jsonProvider().createArray();
        this.pathResult = configuration.jsonProvider().createArray();
        this.updateOperations = new ArrayList();
    }

    public void addResult(String str, PathRef pathRef, Object obj) {
        if (this.forUpdate) {
            this.updateOperations.add(pathRef);
        }
        this.configuration.jsonProvider().setArrayIndex(this.valueResult, this.resultIndex, obj);
        this.configuration.jsonProvider().setArrayIndex(this.pathResult, this.resultIndex, str);
        this.resultIndex++;
        if (configuration().getEvaluationListeners().isEmpty()) {
            return;
        }
        int i2 = this.resultIndex - 1;
        Iterator<EvaluationListener> it = configuration().getEvaluationListeners().iterator();
        while (it.hasNext()) {
            if (EvaluationListener.EvaluationContinuation.ABORT == it.next().resultFound(new FoundResultImpl(i2, str, obj))) {
                throw ABORT_EVALUATION;
            }
        }
    }

    @Override // com.jayway.jsonpath.internal.EvaluationContext
    public Configuration configuration() {
        return this.configuration;
    }

    public HashMap<Path, Object> documentEvalCache() {
        return this.documentEvalCache;
    }

    public boolean forUpdate() {
        return this.forUpdate;
    }

    @Override // com.jayway.jsonpath.internal.EvaluationContext
    public <T> T getPath() {
        if (this.resultIndex != 0) {
            return (T) this.pathResult;
        }
        StringBuilder sbR = a.r("No results for path: ");
        sbR.append(this.path.toString());
        throw new PathNotFoundException(sbR.toString());
    }

    @Override // com.jayway.jsonpath.internal.EvaluationContext
    public List<String> getPathList() {
        ArrayList arrayList = new ArrayList();
        if (this.resultIndex > 0) {
            Iterator<?> it = this.configuration.jsonProvider().toIterable(this.pathResult).iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
        }
        return arrayList;
    }

    @Override // com.jayway.jsonpath.internal.EvaluationContext
    public <T> T getValue() {
        return (T) getValue(true);
    }

    public JsonProvider jsonProvider() {
        return this.configuration.jsonProvider();
    }

    public Set<Option> options() {
        return this.configuration.getOptions();
    }

    @Override // com.jayway.jsonpath.internal.EvaluationContext
    public Object rootDocument() {
        return this.rootDocument;
    }

    @Override // com.jayway.jsonpath.internal.EvaluationContext
    public Collection<PathRef> updateOperations() {
        Collections.sort(this.updateOperations);
        return Collections.unmodifiableCollection(this.updateOperations);
    }

    @Override // com.jayway.jsonpath.internal.EvaluationContext
    public <T> T getValue(boolean z) {
        if (!this.path.isDefinite()) {
            return (T) this.valueResult;
        }
        if (this.resultIndex != 0) {
            int length = jsonProvider().length(this.valueResult);
            T t = length > 0 ? (T) jsonProvider().getArrayIndex(this.valueResult, length - 1) : null;
            return (t == null || !z) ? t : (T) jsonProvider().unwrap(t);
        }
        StringBuilder sbR = a.r("No results for path: ");
        sbR.append(this.path.toString());
        throw new PathNotFoundException(sbR.toString());
    }
}
