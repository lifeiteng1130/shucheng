package io.legado.app.data.entities;

import c.b.a.m.f;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import e.a.a.h.n;
import f.c0.b.a;
import f.c0.c.j;
import f.c0.c.k;
import f.h;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RssStar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/util/HashMap;", "", "<anonymous>", "()Ljava/util/HashMap;"}, k = 3, mv = {1, 5, 1})
public final class RssStar$variableMap$2 extends k implements a<HashMap<String, String>> {
    public final /* synthetic */ RssStar this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RssStar$variableMap$2(RssStar rssStar) {
        super(0);
        this.this$0 = rssStar;
    }

    @Override // f.c0.b.a
    @NotNull
    public final HashMap<String, String> invoke() {
        Object objM11constructorimpl;
        Gson gsonA = n.a();
        String variable = this.this$0.getVariable();
        try {
            Type type = new TypeToken<HashMap<String, String>>() { // from class: io.legado.app.data.entities.RssStar$variableMap$2$invoke$$inlined$fromJsonObject$1
            }.getType();
            j.d(type, "object : TypeToken<T>() {}.type");
            Object objFromJson = gsonA.fromJson(variable, type);
            if (!(objFromJson instanceof HashMap)) {
                objFromJson = null;
            }
            objM11constructorimpl = h.m11constructorimpl((HashMap) objFromJson);
        } catch (Throwable th) {
            objM11constructorimpl = h.m11constructorimpl(f.m1(th));
        }
        HashMap<String, String> map = (HashMap) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
        return map == null ? new HashMap<>() : map;
    }
}
