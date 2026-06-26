package com.jayway.jsonpath.internal.path;

import c.a.a.a.a;
import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.internal.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PropertyPathToken extends PathToken {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final List<String> properties;
    private final String stringDelimiter;

    public PropertyPathToken(List<String> list, char c2) {
        if (list.isEmpty()) {
            throw new InvalidPathException("Empty properties");
        }
        this.properties = list;
        this.stringDelimiter = Character.toString(c2);
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public void evaluate(String str, PathRef pathRef, Object obj, EvaluationContextImpl evaluationContextImpl) {
        if (!evaluationContextImpl.jsonProvider().isMap(obj)) {
            if (isUpstreamDefinite()) {
                throw new PathNotFoundException(String.format("Expected to find an object with property %s in path %s but found '%s'. This is not a json object according to the JsonProvider: '%s'.", getPathFragment(), str, obj == null ? "null" : obj.getClass().getName(), evaluationContextImpl.configuration().jsonProvider().getClass().getName()));
            }
        } else {
            if (singlePropertyCase() || multiPropertyMergeCase()) {
                handleObjectProperty(str, obj, evaluationContextImpl, this.properties);
                return;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(null);
            Iterator<String> it = this.properties.iterator();
            while (it.hasNext()) {
                arrayList.set(0, it.next());
                handleObjectProperty(str, obj, evaluationContextImpl, arrayList);
            }
        }
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public String getPathFragment() {
        StringBuilder sbR = a.r("[");
        sbR.append(Utils.join(",", this.stringDelimiter, this.properties));
        sbR.append("]");
        return sbR.toString();
    }

    public List<String> getProperties() {
        return this.properties;
    }

    @Override // com.jayway.jsonpath.internal.path.PathToken
    public boolean isTokenDefinite() {
        return singlePropertyCase() || multiPropertyMergeCase();
    }

    public boolean multiPropertyIterationCase() {
        return !isLeaf() && this.properties.size() > 1;
    }

    public boolean multiPropertyMergeCase() {
        return isLeaf() && this.properties.size() > 1;
    }

    public boolean singlePropertyCase() {
        return this.properties.size() == 1;
    }
}
