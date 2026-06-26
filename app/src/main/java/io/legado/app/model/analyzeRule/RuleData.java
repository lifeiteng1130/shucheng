package io.legado.app.model.analyzeRule;

import c.b.a.m.f;
import f.c0.c.j;
import f.e;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: RuleData.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R9\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\t8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lio/legado/app/model/analyzeRule/RuleData;", "Lio/legado/app/model/analyzeRule/RuleDataInterface;", "", "key", ES6Iterator.VALUE_PROPERTY, "Lf/v;", "putVariable", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "variableMap$delegate", "Lf/e;", "getVariableMap", "()Ljava/util/HashMap;", "variableMap", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RuleData implements RuleDataInterface {

    /* JADX INFO: renamed from: variableMap$delegate, reason: from kotlin metadata */
    @NotNull
    private final e variableMap = f.N3(RuleData$variableMap$2.INSTANCE);

    @Override // io.legado.app.model.analyzeRule.RuleDataInterface
    @NotNull
    public HashMap<String, String> getVariableMap() {
        return (HashMap) this.variableMap.getValue();
    }

    @Override // io.legado.app.model.analyzeRule.RuleDataInterface
    public void putVariable(@NotNull String key, @NotNull String value) {
        j.e(key, "key");
        j.e(value, ES6Iterator.VALUE_PROPERTY);
        getVariableMap().put(key, value);
    }
}
