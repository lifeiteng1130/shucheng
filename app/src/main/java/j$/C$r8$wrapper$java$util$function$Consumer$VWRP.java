package j$;

import j$.util.function.Consumer;

/* JADX INFO: renamed from: j$.$r8$wrapper$java$util$function$Consumer$-V-WRP, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C$r8$wrapper$java$util$function$Consumer$VWRP implements Consumer {
    final /* synthetic */ java.util.function.Consumer a;

    private /* synthetic */ C$r8$wrapper$java$util$function$Consumer$VWRP(java.util.function.Consumer consumer) {
        this.a = consumer;
    }

    public static /* synthetic */ Consumer convert(java.util.function.Consumer consumer) {
        if (consumer == null) {
            return null;
        }
        return consumer instanceof C$r8$wrapper$java$util$function$Consumer$WRP ? ((C$r8$wrapper$java$util$function$Consumer$WRP) consumer).a : new C$r8$wrapper$java$util$function$Consumer$VWRP(consumer);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ void accept(Object obj) {
        this.a.accept(obj);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return convert(this.a.andThen(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer)));
    }
}
