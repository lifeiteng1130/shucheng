package com.jayway.jsonpath.internal.function;

import com.jayway.jsonpath.internal.EvaluationContext;
import com.jayway.jsonpath.internal.Path;
import com.jayway.jsonpath.internal.function.latebinding.ILateBindingValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Parameter {
    private Boolean evaluated;
    private String json;
    private ILateBindingValue lateBinding;
    private Path path;
    private ParamType type;

    public Parameter() {
        this.evaluated = Boolean.FALSE;
    }

    public static void consume(Class cls, EvaluationContext evaluationContext, Collection collection, Object obj) {
        if (!evaluationContext.configuration().jsonProvider().isArray(obj)) {
            if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
                return;
            }
            collection.add(obj);
            return;
        }
        for (Object obj2 : evaluationContext.configuration().jsonProvider().toIterable(obj)) {
            if (obj2 != null && cls.isAssignableFrom(obj2.getClass())) {
                collection.add(obj2);
            } else if (obj2 != null && cls == String.class) {
                collection.add(obj2.toString());
            }
        }
    }

    public static <T> List<T> toList(Class<T> cls, EvaluationContext evaluationContext, List<Parameter> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<Parameter> it = list.iterator();
            while (it.hasNext()) {
                consume(cls, evaluationContext, arrayList, it.next().getValue());
            }
        }
        return arrayList;
    }

    public String getJson() {
        return this.json;
    }

    public Path getPath() {
        return this.path;
    }

    public ParamType getType() {
        return this.type;
    }

    public Object getValue() {
        return this.lateBinding.get();
    }

    public boolean hasEvaluated() {
        return this.evaluated.booleanValue();
    }

    public void setEvaluated(Boolean bool) {
        this.evaluated = bool;
    }

    public void setJson(String str) {
        this.json = str;
    }

    public void setLateBinding(ILateBindingValue iLateBindingValue) {
        this.lateBinding = iLateBindingValue;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public void setType(ParamType paramType) {
        this.type = paramType;
    }

    public Parameter(String str) {
        this.evaluated = Boolean.FALSE;
        this.json = str;
        this.type = ParamType.JSON;
    }

    public Parameter(Path path) {
        this.evaluated = Boolean.FALSE;
        this.path = path;
        this.type = ParamType.PATH;
    }
}
