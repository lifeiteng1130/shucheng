package io.legado.app.data.entities;

import c.b.a.m.f;
import f.c0.b.a;
import f.c0.c.j;
import f.c0.c.k;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SearchBook.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "<anonymous>", "()Ljava/util/LinkedHashSet;"}, k = 3, mv = {1, 5, 1})
public final class SearchBook$origins$2 extends k implements a<LinkedHashSet<String>> {
    public final /* synthetic */ SearchBook this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBook$origins$2(SearchBook searchBook) {
        super(0);
        this.this$0 = searchBook;
    }

    @Override // f.c0.b.a
    @NotNull
    public final LinkedHashSet<String> invoke() {
        String[] strArr = {this.this$0.getOrigin()};
        j.e(strArr, "elements");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(f.T3(1));
        f.G5(strArr, linkedHashSet);
        return linkedHashSet;
    }
}
