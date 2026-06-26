package e.a.a.d.w;

import android.content.Context;
import android.content.DialogInterface;
import com.google.gson.reflect.TypeToken;
import e.a.a.d.u.b;
import f.v;
import g.b.a0;
import h.a.a.a.w;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookProgress;
import io.wenyuange.app.release.R;
import java.io.File;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: BookWebDav.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    @NotNull
    public static final j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final String f5591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final String f5592c;

    /* JADX INFO: compiled from: BookWebDav.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.BookWebDav", f = "BookWebDav.kt", i = {0, 0, 1}, l = {105, 111, 115}, m = "backUpWebDav", n = {"this", "path", "this"}, s = {"L$0", "L$1", "L$0"})
    public static final class a extends f.z.j.a.c {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public a(f.z.d<? super a> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.c(null, this);
        }
    }

    /* JADX INFO: compiled from: BookWebDav.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.BookWebDav", f = "BookWebDav.kt", i = {0, 0, 0, 1, 1, 1}, l = {127, Token.LABEL, Token.EXPR_VOID}, m = "exportWebDav", n = {"this", "byteArray", "fileName", "byteArray", "fileName", "exportsWebDavUrl"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class b extends f.z.j.a.c {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public b(f.z.d<? super b> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.d(null, null, this);
        }
    }

    /* JADX INFO: compiled from: BookWebDav.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.BookWebDav", f = "BookWebDav.kt", i = {0, 0}, l = {Token.COMMENT, Token.METHOD}, m = "getBookProgress", n = {"this", "book"}, s = {"L$0", "L$1"})
    public static final class c extends f.z.j.a.c {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public c(f.z.d<? super c> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.e(null, this);
        }
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class d extends TypeToken<BookProgress> {
    }

    /* JADX INFO: compiled from: BookWebDav.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.BookWebDav", f = "BookWebDav.kt", i = {}, l = {46, 47}, m = "initWebDav", n = {}, s = {})
    public static final class e extends f.z.j.a.c {
        public int label;
        public /* synthetic */ Object result;

        public e(f.z.d<? super e> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            j jVar = j.this;
            j jVar2 = j.a;
            return jVar.h(this);
        }
    }

    /* JADX INFO: compiled from: BookWebDav.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.BookWebDav", f = "BookWebDav.kt", i = {0}, l = {71, 73}, m = "showRestoreDialog", n = {com.umeng.analytics.pro.c.R}, s = {"L$0"})
    public static final class f extends f.z.j.a.c {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public f(f.z.d<? super f> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.i(null, this);
        }
    }

    /* JADX INFO: compiled from: BookWebDav.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.BookWebDav$showRestoreDialog$2", f = "BookWebDav.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ ArrayList<String> $names;
        public int label;

        /* JADX INFO: compiled from: BookWebDav.kt */
        public static final class a extends f.c0.c.k implements f.c0.b.p<DialogInterface, Integer, v> {
            public final /* synthetic */ ArrayList<String> $names;

            /* JADX INFO: renamed from: e.a.a.d.w.j$g$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: BookWebDav.kt */
            @DebugMetadata(c = "io.legado.app.help.storage.BookWebDav$showRestoreDialog$2$1$1", f = "BookWebDav.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0150a extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
                public final /* synthetic */ int $index;
                public final /* synthetic */ ArrayList<String> $names;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0150a(ArrayList<String> arrayList, int i2, f.z.d<? super C0150a> dVar) {
                    super(2, dVar);
                    this.$names = arrayList;
                    this.$index = i2;
                }

                @Override // f.z.j.a.a
                @NotNull
                public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                    return new C0150a(this.$names, this.$index, dVar);
                }

                @Override // f.c0.b.p
                @Nullable
                public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
                    return ((C0150a) create(a0Var, dVar)).invokeSuspend(v.a);
                }

                @Override // f.z.j.a.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                    f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
                    int i2 = this.label;
                    if (i2 == 0) {
                        c.b.a.m.f.E5(obj);
                        j jVar = j.a;
                        String str = this.$names.get(this.$index);
                        f.c0.c.j.d(str, "names[index]");
                        this.label = 1;
                        if (j.b(jVar, str, this) == aVar) {
                            return aVar;
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

            /* JADX INFO: compiled from: BookWebDav.kt */
            @DebugMetadata(c = "io.legado.app.help.storage.BookWebDav$showRestoreDialog$2$1$2", f = "BookWebDav.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class b extends f.z.j.a.g implements f.c0.b.q<a0, Throwable, f.z.d<? super v>, Object> {
                public /* synthetic */ Object L$0;
                public int label;

                public b(f.z.d<? super b> dVar) {
                    super(3, dVar);
                }

                @Override // f.c0.b.q
                @Nullable
                public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
                    b bVar = new b(dVar);
                    bVar.L$0 = th;
                    return bVar.invokeSuspend(v.a);
                }

                @Override // f.z.j.a.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    c.b.a.m.f.E5(obj);
                    c.a.a.a.a.A((Throwable) this.L$0, "WebDavError:", k.d.a.h.g());
                    return v.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ArrayList<String> arrayList) {
                super(2);
                this.$names = arrayList;
            }

            @Override // f.c0.b.p
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) {
                invoke(dialogInterface, num.intValue());
                return v.a;
            }

            public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
                f.c0.c.j.e(dialogInterface, "$noName_0");
                boolean z = false;
                if (i2 >= 0 && i2 < this.$names.size()) {
                    z = true;
                }
                if (z) {
                    e.a.a.d.u.b.b(b.C0148b.b(e.a.a.d.u.b.a, null, null, new C0150a(this.$names, i2, null), 3), null, new b(null), 1);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Context context, ArrayList<String> arrayList, f.z.d<? super g> dVar) {
            super(2, dVar);
            this.$context = context;
            this.$names = arrayList;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new g(this.$context, this.$names, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((g) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            Context context = this.$context;
            String string = context.getString(R.string.select_restore_file);
            ArrayList<String> arrayList = this.$names;
            c.b.a.m.f.Z4(context, string, arrayList, new a(arrayList));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: BookWebDav.kt */
    @DebugMetadata(c = "io.legado.app.help.storage.BookWebDav$showRestoreDialog$names$1", f = "BookWebDav.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super ArrayList<String>>, Object> {
        public int label;

        public h(f.z.d<? super h> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new h(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super ArrayList<String>> dVar) {
            return ((h) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                c.b.a.m.f.E5(obj);
                j jVar = j.a;
                this.label = 1;
                obj = j.a(jVar, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
            }
            return obj;
        }
    }

    static {
        j jVar = new j();
        a = jVar;
        f5591b = f.c0.c.j.k(jVar.g(), "bookProgress/");
        StringBuilder sb = new StringBuilder();
        File externalCacheDir = k.d.a.h.g().getExternalCacheDir();
        String absolutePath = externalCacheDir == null ? null : externalCacheDir.getAbsolutePath();
        if (absolutePath == null) {
            absolutePath = k.d.a.h.g().getCacheDir().getAbsolutePath();
            f.c0.c.j.d(absolutePath, "appCtx.cacheDir.absolutePath");
        }
        sb.append(absolutePath);
        sb.append((Object) File.separator);
        sb.append("backup.zip");
        f5592c = sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(e.a.a.d.w.j r7, f.z.d r8) throws java.lang.Throwable {
        /*
            java.util.Objects.requireNonNull(r7)
            boolean r0 = r8 instanceof e.a.a.d.w.k
            if (r0 == 0) goto L16
            r0 = r8
            e.a.a.d.w.k r0 = (e.a.a.d.w.k) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.label = r1
            goto L1b
        L16:
            e.a.a.d.w.k r0 = new e.a.a.d.w.k
            r0.<init>(r7, r8)
        L1b:
            java.lang.Object r8 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            r5 = 2
            if (r2 == 0) goto L46
            if (r2 == r4) goto L3a
            if (r2 != r5) goto L32
            java.lang.Object r7 = r0.L$0
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            c.b.a.m.f.E5(r8)
            goto L7c
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            java.lang.Object r7 = r0.L$1
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            c.b.a.m.f.E5(r8)
            goto L62
        L46:
            c.b.a.m.f.E5(r8)
            java.lang.String r2 = r7.g()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r0.L$0 = r2
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r7 = r7.h(r0)
            if (r7 != r1) goto L5f
            goto Lb0
        L5f:
            r6 = r8
            r8 = r7
            r7 = r6
        L62:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto Laf
            e.a.a.e.e.b r8 = new e.a.a.e.e.b
            r8.<init>(r2)
            r0.L$0 = r7
            r0.L$1 = r3
            r0.label = r5
            java.lang.Object r8 = r8.e(r0)
            if (r8 != r1) goto L7c
            goto Lb0
        L7c:
            java.util.List r8 = (java.util.List) r8
            java.util.List r8 = f.x.e.z(r8)
            java.util.Iterator r8 = r8.iterator()
        L86:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto Laf
            java.lang.Object r0 = r8.next()
            e.a.a.e.e.b r0 = (e.a.a.e.e.b) r0
            java.lang.String r0 = r0.f5660c
            if (r0 != 0) goto L98
            r1 = r3
            goto La3
        L98:
            r1 = 0
            java.lang.String r2 = "backup"
            boolean r1 = f.h0.k.K(r0, r2, r1, r5)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
        La3:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r1 = f.c0.c.j.a(r1, r2)
            if (r1 == 0) goto L86
            r7.add(r0)
            goto L86
        Laf:
            r1 = r7
        Lb0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.w.j.a(e.a.a.d.w.j, f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(e.a.a.d.w.j r7, java.lang.String r8, f.z.d r9) throws java.lang.Throwable {
        /*
            java.util.Objects.requireNonNull(r7)
            boolean r0 = r9 instanceof e.a.a.d.w.l
            if (r0 == 0) goto L16
            r0 = r9
            e.a.a.d.w.l r0 = (e.a.a.d.w.l) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.label = r1
            goto L1b
        L16:
            e.a.a.d.w.l r0 = new e.a.a.d.w.l
            r0.<init>(r7, r9)
        L1b:
            java.lang.Object r9 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L40
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            c.b.a.m.f.E5(r9)
            goto L9d
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            c.b.a.m.f.E5(r9)
            goto L8c
        L3c:
            c.b.a.m.f.E5(r9)
            goto L5b
        L40:
            c.b.a.m.f.E5(r9)
            java.lang.String r7 = r7.g()
            e.a.a.e.e.b r9 = new e.a.a.e.e.b
            java.lang.String r7 = f.c0.c.j.k(r7, r8)
            r9.<init>(r7)
            java.lang.String r7 = e.a.a.d.w.j.f5592c
            r0.label = r5
            java.lang.Object r7 = r9.b(r7, r5, r0)
            if (r7 != r1) goto L5b
            goto L9f
        L5b:
            e.a.a.h.e0 r7 = e.a.a.h.e0.a
            java.lang.String r8 = e.a.a.d.w.j.f5592c
            e.a.a.d.w.i r9 = e.a.a.d.w.i.a
            java.lang.String r9 = r9.f()
            java.lang.String r2 = "zipFilePath"
            f.c0.c.j.e(r8, r2)
            java.lang.String r6 = "destDirPath"
            f.c0.c.j.e(r9, r6)
            f.c0.c.j.e(r8, r2)
            f.c0.c.j.e(r9, r6)
            java.io.File r8 = r7.b(r8)
            java.io.File r9 = r7.b(r9)
            r2 = 0
            r7.e(r8, r9, r2)
            e.a.a.d.w.q r7 = e.a.a.d.w.q.a
            r0.label = r4
            java.lang.Object r7 = e.a.a.d.w.q.e(r7, r2, r0, r5)
            if (r7 != r1) goto L8c
            goto L9f
        L8c:
            e.a.a.d.w.q r7 = e.a.a.d.w.q.a
            r0.label = r3
            e.a.a.d.w.i r8 = e.a.a.d.w.i.a
            java.lang.String r8 = r8.f()
            java.lang.Object r7 = r7.d(r8, r0)
            if (r7 != r1) goto L9d
            goto L9f
        L9d:
            f.v r1 = f.v.a
        L9f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.w.j.b(e.a.a.d.w.j, java.lang.String, f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c5 A[Catch: Exception -> 0x010c, TRY_LEAVE, TryCatch #0 {Exception -> 0x010c, blocks: (B:13:0x002a, B:18:0x003b, B:40:0x00bd, B:42:0x00c5, B:21:0x0048, B:28:0x005d, B:30:0x0065, B:32:0x007b, B:36:0x009f, B:24:0x004f), top: B:49:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(@org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull f.z.d<? super f.v> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.w.j.c(java.lang.String, f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(@org.jetbrains.annotations.NotNull byte[] r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull f.z.d<? super f.v> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.w.j.d(byte[], java.lang.String, f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(@org.jetbrains.annotations.NotNull io.legado.app.data.entities.Book r7, @org.jetbrains.annotations.NotNull f.z.d<? super io.legado.app.data.entities.BookProgress> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof e.a.a.d.w.j.c
            if (r0 == 0) goto L13
            r0 = r8
            e.a.a.d.w.j$c r0 = (e.a.a.d.w.j.c) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            e.a.a.d.w.j$c r0 = new e.a.a.d.w.j$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L33
            if (r2 != r3) goto L2b
            c.b.a.m.f.E5(r8)
            goto L6e
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            java.lang.Object r7 = r0.L$1
            io.legado.app.data.entities.Book r7 = (io.legado.app.data.entities.Book) r7
            java.lang.Object r2 = r0.L$0
            e.a.a.d.w.j r2 = (e.a.a.d.w.j) r2
            c.b.a.m.f.E5(r8)
            goto L50
        L3f:
            c.b.a.m.f.E5(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r6.h(r0)
            if (r8 != r1) goto L4f
            return r1
        L4f:
            r2 = r6
        L50:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto Lb2
            java.lang.String r7 = r2.f(r7)
            e.a.a.e.e.b r8 = new e.a.a.e.e.b
            r8.<init>(r7)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = r8.a(r0)
            if (r8 != r1) goto L6e
            return r1
        L6e:
            byte[] r8 = (byte[]) r8
            if (r8 != 0) goto L73
            goto Lb2
        L73:
            java.lang.String r7 = new java.lang.String
            java.nio.charset.Charset r0 = f.h0.a.a
            r7.<init>(r8, r0)
            com.google.gson.Gson r8 = e.a.a.h.n.a()
            e.a.a.d.w.j$d r0 = new e.a.a.d.w.j$d     // Catch: java.lang.Throwable -> L9c
            r0.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.reflect.Type r0 = r0.getType()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = "object : TypeToken<T>() {}.type"
            f.c0.c.j.d(r0, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r7 = r8.fromJson(r7, r0)     // Catch: java.lang.Throwable -> L9c
            boolean r8 = r7 instanceof io.legado.app.data.entities.BookProgress     // Catch: java.lang.Throwable -> L9c
            if (r8 != 0) goto L95
            r7 = r5
        L95:
            io.legado.app.data.entities.BookProgress r7 = (io.legado.app.data.entities.BookProgress) r7     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r7 = f.h.m11constructorimpl(r7)     // Catch: java.lang.Throwable -> L9c
            goto La5
        L9c:
            r7 = move-exception
            java.lang.Object r7 = c.b.a.m.f.m1(r7)
            java.lang.Object r7 = f.h.m11constructorimpl(r7)
        La5:
            boolean r8 = f.h.m16isFailureimpl(r7)
            if (r8 == 0) goto Lac
            r7 = r5
        Lac:
            io.legado.app.data.entities.BookProgress r7 = (io.legado.app.data.entities.BookProgress) r7
            if (r7 != 0) goto Lb1
            goto Lb2
        Lb1:
            return r7
        Lb2:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.w.j.e(io.legado.app.data.entities.Book, f.z.d):java.lang.Object");
    }

    public final String f(Book book) {
        return f5591b + book.getName() + '_' + book.getAuthor() + ".json";
    }

    public final String g() {
        String strO2 = c.b.a.m.f.O2(k.d.a.h.g(), "web_dav_url", null, 2);
        if (strO2 == null || strO2.length() == 0) {
            strO2 = "https://dav.jianguoyun.com/dav/";
        }
        if (!f.h0.k.h(strO2, w.DEFAULT_PATH_SEPARATOR, false, 2)) {
            strO2 = f.c0.c.j.k(strO2, w.DEFAULT_PATH_SEPARATOR);
        }
        return c.b.a.m.f.J2(k.d.a.h.g(), "webDavCreateDir", true) ? f.c0.c.j.k(strO2, "legado/") : strO2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(f.z.d<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof e.a.a.d.w.j.e
            if (r0 == 0) goto L13
            r0 = r8
            e.a.a.d.w.j$e r0 = (e.a.a.d.w.j.e) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            e.a.a.d.w.j$e r0 = new e.a.a.d.w.j$e
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            c.b.a.m.f.E5(r8)
            goto L91
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L32:
            c.b.a.m.f.E5(r8)
            goto L81
        L36:
            c.b.a.m.f.E5(r8)
            android.content.Context r8 = k.d.a.h.g()
            java.lang.String r2 = "web_dav_account"
            r5 = 0
            java.lang.String r8 = c.b.a.m.f.O2(r8, r2, r5, r3)
            android.content.Context r2 = k.d.a.h.g()
            java.lang.String r6 = "web_dav_password"
            java.lang.String r2 = c.b.a.m.f.O2(r2, r6, r5, r3)
            r5 = 0
            if (r8 == 0) goto L5a
            boolean r6 = f.h0.k.s(r8)
            if (r6 == 0) goto L58
            goto L5a
        L58:
            r6 = 0
            goto L5b
        L5a:
            r6 = 1
        L5b:
            if (r6 != 0) goto L94
            if (r2 == 0) goto L65
            boolean r6 = f.h0.k.s(r2)
            if (r6 == 0) goto L66
        L65:
            r5 = 1
        L66:
            if (r5 != 0) goto L94
            e.a.a.e.e.a$a r5 = new e.a.a.e.e.a$a
            r5.<init>(r8, r2)
            e.a.a.e.e.a.a = r5
            e.a.a.e.e.b r8 = new e.a.a.e.e.b
            java.lang.String r2 = r7.g()
            r8.<init>(r2)
            r0.label = r4
            java.lang.Object r8 = r8.f(r0)
            if (r8 != r1) goto L81
            return r1
        L81:
            e.a.a.e.e.b r8 = new e.a.a.e.e.b
            java.lang.String r2 = e.a.a.d.w.j.f5591b
            r8.<init>(r2)
            r0.label = r3
            java.lang.Object r8 = r8.f(r0)
            if (r8 != r1) goto L91
            return r1
        L91:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            return r8
        L94:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.w.j.h(f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(@org.jetbrains.annotations.NotNull android.content.Context r7, @org.jetbrains.annotations.NotNull f.z.d<? super f.v> r8) throws java.lang.Exception {
        /*
            r6 = this;
            boolean r0 = r8 instanceof e.a.a.d.w.j.f
            if (r0 == 0) goto L13
            r0 = r8
            e.a.a.d.w.j$f r0 = (e.a.a.d.w.j.f) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            e.a.a.d.w.j$f r0 = new e.a.a.d.w.j$f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3b
            if (r2 == r5) goto L33
            if (r2 != r3) goto L2b
            c.b.a.m.f.E5(r8)
            goto L6f
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            java.lang.Object r7 = r0.L$0
            android.content.Context r7 = (android.content.Context) r7
            c.b.a.m.f.E5(r8)
            goto L52
        L3b:
            c.b.a.m.f.E5(r8)
            g.b.k0 r8 = g.b.k0.f6264c
            g.b.y r8 = g.b.k0.f6263b
            e.a.a.d.w.j$h r2 = new e.a.a.d.w.j$h
            r2.<init>(r4)
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = c.b.a.m.f.f6(r8, r2, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            boolean r2 = r8.isEmpty()
            r2 = r2 ^ r5
            if (r2 == 0) goto L72
            g.b.k0 r2 = g.b.k0.f6264c
            g.b.o1 r2 = g.b.g2.m.f6207b
            e.a.a.d.w.j$g r5 = new e.a.a.d.w.j$g
            r5.<init>(r7, r8, r4)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = c.b.a.m.f.f6(r2, r5, r0)
            if (r7 != r1) goto L6f
            return r1
        L6f:
            f.v r7 = f.v.a
            return r7
        L72:
            java.lang.Exception r7 = new java.lang.Exception
            java.lang.String r8 = "Web dav no back up file"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.w.j.i(android.content.Context, f.z.d):java.lang.Object");
    }
}
