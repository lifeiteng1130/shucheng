package com.jayway.jsonpath.internal.path;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.internal.EvaluationAbortException;
import com.jayway.jsonpath.internal.EvaluationContext;
import com.jayway.jsonpath.internal.Path;
import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.internal.function.ParamType;
import com.jayway.jsonpath.internal.function.Parameter;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class CompiledPath implements Path {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) CompiledPath.class);
    private final boolean isRootPath;
    private final RootPathToken root;

    public CompiledPath(RootPathToken rootPathToken, boolean z) {
        this.root = invertScannerFunctionRelationship(rootPathToken);
        this.isRootPath = z;
    }

    private RootPathToken invertScannerFunctionRelationship(RootPathToken rootPathToken) {
        if (!rootPathToken.isFunctionPath() || !(rootPathToken.next() instanceof ScanPathToken)) {
            return rootPathToken;
        }
        PathToken next = rootPathToken;
        PathToken pathToken = null;
        while (true) {
            next = next.next();
            if (next == null || (next instanceof FunctionPathToken)) {
                break;
            }
            pathToken = next;
        }
        if (!(next instanceof FunctionPathToken)) {
            return rootPathToken;
        }
        pathToken.setNext(null);
        rootPathToken.setTail(pathToken);
        Parameter parameter = new Parameter();
        parameter.setPath(new CompiledPath(rootPathToken, true));
        parameter.setType(ParamType.PATH);
        ((FunctionPathToken) next).setParameters(Arrays.asList(parameter));
        RootPathToken rootPathToken2 = new RootPathToken('$');
        rootPathToken2.setTail(next);
        rootPathToken2.setNext(next);
        return rootPathToken2;
    }

    @Override // com.jayway.jsonpath.internal.Path
    public EvaluationContext evaluate(Object obj, Object obj2, Configuration configuration, boolean z) {
        Logger logger2 = logger;
        if (logger2.isDebugEnabled()) {
            logger2.debug("Evaluating path: {}", toString());
        }
        EvaluationContextImpl evaluationContextImpl = new EvaluationContextImpl(this, obj2, configuration, z);
        try {
            this.root.evaluate("", evaluationContextImpl.forUpdate() ? PathRef.createRoot(obj2) : PathRef.NO_OP, obj, evaluationContextImpl);
        } catch (EvaluationAbortException unused) {
        }
        return evaluationContextImpl;
    }

    @Override // com.jayway.jsonpath.internal.Path
    public boolean isDefinite() {
        return this.root.isPathDefinite();
    }

    @Override // com.jayway.jsonpath.internal.Path
    public boolean isFunctionPath() {
        return this.root.isFunctionPath();
    }

    @Override // com.jayway.jsonpath.internal.Path
    public boolean isRootPath() {
        return this.isRootPath;
    }

    public String toString() {
        return this.root.toString();
    }

    @Override // com.jayway.jsonpath.internal.Path
    public EvaluationContext evaluate(Object obj, Object obj2, Configuration configuration) {
        return evaluate(obj, obj2, configuration, false);
    }
}
