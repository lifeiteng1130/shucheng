package e.a.a.f;

import f.v;
import g.b.a0;
import g.b.k0;
import g.b.o1;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.service.AudioPlayService;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AudioPlayService.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.AudioPlayService$loadContent$1$1$1", f = "AudioPlayService.kt", i = {}, l = {301}, m = "invokeSuspend", n = {}, s = {})
public final class h extends f.z.j.a.g implements f.c0.b.q<a0, String, f.z.d<? super v>, Object> {
    public final /* synthetic */ BookChapter $chapter;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ AudioPlayService this$0;

    /* JADX INFO: compiled from: AudioPlayService.kt */
    @DebugMetadata(c = "io.legado.app.service.AudioPlayService$loadContent$1$1$1$1", f = "AudioPlayService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public int label;
        public final /* synthetic */ AudioPlayService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AudioPlayService audioPlayService, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.this$0 = audioPlayService;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.this$0, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            c.b.a.m.f.R5(this.this$0, "未获取到资源链接");
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(AudioPlayService audioPlayService, BookChapter bookChapter, f.z.d<? super h> dVar) {
        super(3, dVar);
        this.this$0 = audioPlayService;
        this.$chapter = bookChapter;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull String str, @Nullable f.z.d<? super v> dVar) {
        h hVar = new h(this.this$0, this.$chapter, dVar);
        hVar.L$0 = str;
        return hVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            String str = (String) this.L$0;
            if (str.length() == 0) {
                k0 k0Var = k0.f6264c;
                o1 o1Var = g.b.g2.m.f6207b;
                a aVar2 = new a(this.this$0, null);
                this.label = 1;
                if (c.b.a.m.f.f6(o1Var, aVar2, this) == aVar) {
                    return aVar;
                }
            } else {
                AudioPlayService.b(this.this$0, this.$chapter, str);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
        }
        return v.a;
    }
}
