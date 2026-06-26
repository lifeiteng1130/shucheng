package io.legado.app.web;

import android.os.Looper;
import androidx.core.app.NotificationCompat;
import c.b.a.m.f;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import d.a.a.a;
import d.a.a.b;
import e.a.a.h.n;
import e.a.a.h.o;
import f.c0.b.p;
import f.c0.c.j;
import f.h;
import f.h0.k;
import f.v;
import f.z.d;
import f.z.i.a;
import f.z.j.a.g;
import g.b.a0;
import g.b.k0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import io.legado.app.model.Debug;
import io.legado.app.model.webBook.WebBook;
import io.wenyuange.app.release.R;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SourceDebugWebSocket.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lio/legado/app/web/SourceDebugWebSocket;", "Ld/a/a/b$c;", "Lg/b/a0;", "Lio/legado/app/model/Debug$Callback;", "Lf/v;", "onOpen", "()V", "Ld/a/a/b$e$a;", "code", "", "reason", "", "initiatedByRemote", "onClose", "(Ld/a/a/b$e$a;Ljava/lang/String;Z)V", "Ld/a/a/b$e;", "message", "onMessage", "(Ld/a/a/b$e;)V", "pong", "onPong", "Ljava/io/IOException;", "exception", "onException", "(Ljava/io/IOException;)V", "", "state", NotificationCompat.CATEGORY_MESSAGE, "printLog", "(ILjava/lang/String;)V", "Lf/z/f;", "getCoroutineContext", "()Lf/z/f;", "coroutineContext", "", "notPrintState", "[Ljava/lang/Integer;", "Ld/a/a/a$m;", "handshakeRequest", "<init>", "(Ld/a/a/a$m;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SourceDebugWebSocket extends b.c implements a0, Debug.Callback {
    private final /* synthetic */ a0 $$delegate_0;

    @NotNull
    private final Integer[] notPrintState;

    /* JADX INFO: renamed from: io.legado.app.web.SourceDebugWebSocket$onMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: SourceDebugWebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "Lf/v;", "<anonymous>", "(Lg/b/a0;)V"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.web.SourceDebugWebSocket$onMessage$1", f = "SourceDebugWebSocket.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ b.e $message;
        private /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ SourceDebugWebSocket this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(b.e eVar, SourceDebugWebSocket sourceDebugWebSocket, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$message = eVar;
            this.this$0 = sourceDebugWebSocket;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$message, this.this$0, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((AnonymousClass1) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Object objM11constructorimpl;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            a0 a0Var = (a0) this.L$0;
            b.e eVar = this.$message;
            SourceDebugWebSocket sourceDebugWebSocket = this.this$0;
            try {
                if (!f.z3(eVar.b())) {
                    sourceDebugWebSocket.send("数据必须为Json格式");
                    sourceDebugWebSocket.close(b.e.a.NormalClosure, "调试结束", false);
                    return v.a;
                }
                Gson gsonA = n.a();
                String strB = eVar.b();
                Object obj2 = null;
                try {
                    Type type = new TypeToken<Map<String, ? extends String>>() { // from class: io.legado.app.web.SourceDebugWebSocket$onMessage$1$invokeSuspend$lambda-1$$inlined$fromJsonObject$1
                    }.getType();
                    j.d(type, "object : TypeToken<T>() {}.type");
                    Object objFromJson = gsonA.fromJson(strB, type);
                    if (!(objFromJson instanceof Map)) {
                        objFromJson = null;
                    }
                    objM11constructorimpl = h.m11constructorimpl((Map) objFromJson);
                } catch (Throwable th) {
                    objM11constructorimpl = h.m11constructorimpl(f.m1(th));
                }
                if (!h.m16isFailureimpl(objM11constructorimpl)) {
                    obj2 = objM11constructorimpl;
                }
                Map map = (Map) obj2;
                if (map != null) {
                    String str = (String) map.get("tag");
                    String str2 = (String) map.get("key");
                    boolean z = true;
                    if (!(str == null || k.s(str))) {
                        if (str2 != null && !k.s(str2)) {
                            z = false;
                        }
                        if (!z) {
                            BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(str);
                            if (bookSource != null) {
                                Debug debug = Debug.INSTANCE;
                                debug.setCallback(sourceDebugWebSocket);
                                debug.startDebug(a0Var, new WebBook(bookSource), str2);
                            }
                        }
                    }
                    sourceDebugWebSocket.send(k.d.a.h.g().getString(R.string.cannot_empty));
                    sourceDebugWebSocket.close(b.e.a.NormalClosure, "调试结束", false);
                    return v.a;
                }
                h.m11constructorimpl(v.a);
            } catch (Throwable th2) {
                h.m11constructorimpl(f.m1(th2));
            }
            return v.a;
        }
    }

    /* JADX INFO: renamed from: io.legado.app.web.SourceDebugWebSocket$onOpen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SourceDebugWebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "Lf/v;", "<anonymous>", "(Lg/b/a0;)V"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.web.SourceDebugWebSocket$onOpen$1", f = "SourceDebugWebSocket.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03481 extends g implements p<a0, d<? super v>, Object> {
        public Object L$0;
        public int label;

        public C03481(d<? super C03481> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return SourceDebugWebSocket.this.new C03481(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((C03481) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            SourceDebugWebSocket sourceDebugWebSocket;
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                sourceDebugWebSocket = SourceDebugWebSocket.this;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sourceDebugWebSocket = (SourceDebugWebSocket) this.L$0;
                try {
                    f.E5(obj);
                } catch (Throwable th) {
                    h.m11constructorimpl(f.m1(th));
                }
            }
            while (sourceDebugWebSocket.isOpen()) {
                byte[] bytes = "ping".getBytes(f.h0.a.a);
                j.d(bytes, "(this as java.lang.String).getBytes(charset)");
                sourceDebugWebSocket.ping(bytes);
                this.L$0 = sourceDebugWebSocket;
                this.label = 1;
                if (f.p1(30000L, this) == aVar) {
                    return aVar;
                }
            }
            h.m11constructorimpl(v.a);
            return v.a;
        }
    }

    /* JADX INFO: renamed from: io.legado.app.web.SourceDebugWebSocket$printLog$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SourceDebugWebSocket.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lf/v;", "<anonymous>", "()V"}, k = 3, mv = {1, 5, 1})
    public static final class C03491 extends f.c0.c.k implements f.c0.b.a<v> {
        public final /* synthetic */ String $msg;
        public final /* synthetic */ int $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03491(String str, int i2) {
            super(0);
            this.$msg = str;
            this.$state = i2;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Object objM11constructorimpl;
            SourceDebugWebSocket sourceDebugWebSocket = SourceDebugWebSocket.this;
            String str = this.$msg;
            int i2 = this.$state;
            try {
                sourceDebugWebSocket.send(str);
                if (i2 == -1 || i2 == 1000) {
                    Debug.INSTANCE.cancelDebug(true);
                    sourceDebugWebSocket.close(b.e.a.NormalClosure, "调试结束", false);
                }
                objM11constructorimpl = h.m11constructorimpl(v.a);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(f.m1(th));
            }
            Throwable thM14exceptionOrNullimpl = h.m14exceptionOrNullimpl(objM11constructorimpl);
            if (thM14exceptionOrNullimpl != null) {
                thM14exceptionOrNullimpl.printStackTrace();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SourceDebugWebSocket(@NotNull a.m mVar) {
        super(mVar);
        j.e(mVar, "handshakeRequest");
        this.$$delegate_0 = f.a();
        this.notPrintState = new Integer[]{10, 20, 30, 40};
    }

    @Override // g.b.a0
    @NotNull
    public f.z.f getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // d.a.a.b.c
    public void onClose(@NotNull b.e.a code, @NotNull String reason, boolean initiatedByRemote) {
        j.e(code, "code");
        j.e(reason, "reason");
        f.I0(this, null, 1);
        Debug.INSTANCE.cancelDebug(true);
    }

    @Override // d.a.a.b.c
    public void onException(@NotNull IOException exception) {
        j.e(exception, "exception");
        Debug.INSTANCE.cancelDebug(true);
    }

    @Override // d.a.a.b.c
    public void onMessage(@NotNull b.e message) {
        j.e(message, "message");
        k0 k0Var = k0.f6264c;
        f.L3(this, k0.f6263b, null, new AnonymousClass1(message, this, null), 2, null);
    }

    @Override // d.a.a.b.c
    public void onOpen() {
        k0 k0Var = k0.f6264c;
        f.L3(this, k0.f6263b, null, new C03481(null), 2, null);
    }

    @Override // d.a.a.b.c
    public void onPong(@NotNull b.e pong) {
        j.e(pong, "pong");
    }

    @Override // io.legado.app.model.Debug.Callback
    public void printLog(int state, @NotNull String msg) {
        j.e(msg, NotificationCompat.CATEGORY_MESSAGE);
        if (f.b1(this.notPrintState, Integer.valueOf(state))) {
            return;
        }
        C03491 c03491 = new C03491(msg, state);
        Looper looper = e.a.a.h.p.a;
        j.e(this, "<this>");
        j.e(c03491, "function");
        if (!(e.a.a.h.p.f5959b == Thread.currentThread())) {
            c03491.invoke();
        } else {
            k0 k0Var = k0.f6264c;
            f.L3(this, k0.f6263b, null, new o(c03491, null), 2, null);
        }
    }
}
