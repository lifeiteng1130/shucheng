package j$;

import java.util.function.Supplier;

/* JADX INFO: renamed from: j$.$r8$wrapper$java$util$function$Supplier$-WRP, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C$r8$wrapper$java$util$function$Supplier$WRP implements Supplier {
    final /* synthetic */ j$.util.function.Supplier a;

    private /* synthetic */ C$r8$wrapper$java$util$function$Supplier$WRP(j$.util.function.Supplier supplier) {
        this.a = supplier;
    }

    public static /* synthetic */ Supplier convert(j$.util.function.Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        return supplier instanceof y0 ? ((y0) supplier).a : new C$r8$wrapper$java$util$function$Supplier$WRP(supplier);
    }

    @Override // java.util.function.Supplier
    public /* synthetic */ Object get() {
        return this.a.get();
    }
}
