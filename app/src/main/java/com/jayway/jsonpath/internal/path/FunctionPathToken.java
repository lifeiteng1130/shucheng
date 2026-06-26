package com.jayway.jsonpath.internal.path;

import c.a.a.a.a;
import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.internal.function.ParamType;
import com.jayway.jsonpath.internal.function.Parameter;
import com.jayway.jsonpath.internal.function.PathFunction;
import com.jayway.jsonpath.internal.function.PathFunctionFactory;
import com.jayway.jsonpath.internal.function.latebinding.JsonLateBindingValue;
import com.jayway.jsonpath.internal.function.latebinding.PathLateBindingValue;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FunctionPathToken extends PathToken {
    private final String functionName;
    private List<Parameter> functionParams;
    private final String pathFragment;

    /* JADX INFO: renamed from: com.jayway.jsonpath.internal.path.FunctionPathToken$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$jayway$jsonpath$internal$function$ParamType;

        static {
            ParamType.values();
            int[] iArr = new int[2];
            $SwitchMap$com$jayway$jsonpath$internal$function$ParamType = iArr;
            try {
                iArr[ParamType.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$jayway$jsonpath$internal$function$ParamType[ParamType.JSON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public FunctionPathToken(String str, List<Parameter> list) {
        StringBuilder sbR = a.r(str);
        sbR.append((list == null || list.size() <= 0) ? "()" : "(...)");
        this.pathFragment = sbR.toString();
        if (str != null) {
            this.functionName = str;
            this.functionParams = list;
        } else {
            this.functionName = null;
            this.functionParams = null;
        }
    }

    private void evaluateParameters(String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl) {
        List<Parameter> list = this.functionParams;
        if (list != null) {
            for (Parameter parameter : list) {
                if (!parameter.hasEvaluated()) {
                    int iOrdinal = parameter.getType().ordinal();
                    if (iOrdinal == 0) {
                        parameter.setLateBinding(new JsonLateBindingValue(evaluationContextImpl.configuration().jsonProvider(), parameter));
                        parameter.setEvaluated(Boolean.TRUE);
                    } else if (iOrdinal == 1) {
                        parameter.setLateBinding(new PathLateBindingValue(parameter.getPath(), evaluationContextImpl.rootDocument(), evaluationContextImpl.configuration()));
                        parameter.setEvaluated(Boolean.TRUE);
                    }
                }
            }
        }
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public void evaluate(String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl) {
        PathFunction pathFunctionNewFunction = PathFunctionFactory.newFunction(this.functionName);
        evaluateParameters(str, pathRef, obj, evaluationContextImpl);
        Object objInvoke = pathFunctionNewFunction.invoke(str, pathRef, obj, evaluationContextImpl, this.functionParams);
        StringBuilder sbT = a.t(str, ".");
        sbT.append(this.functionName);
        evaluationContextImpl.addResult(sbT.toString(), pathRef, objInvoke);
        if (isLeaf()) {
            return;
        }
        next().evaluate(str, pathRef, objInvoke, evaluationContextImpl);
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public String getPathFragment() {
        StringBuilder sbR = a.r(".");
        sbR.append(this.pathFragment);
        return sbR.toString();
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public boolean isTokenDefinite() {
        return true;
    }

    public void setParameters(List<Parameter> list) {
        this.functionParams = list;
    }
}
