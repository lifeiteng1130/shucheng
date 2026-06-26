package e.a.a.e.e;

import com.umeng.commonsdk.statistics.SdkVersion;
import e.a.a.e.e.a;
import f.v;
import h.a.a.a.w;
import java.net.URL;
import java.net.URLEncoder;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: WebDav.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    @NotNull
    public final URL a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final f.e f5659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public String f5660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public String f5661d;

    /* JADX INFO: compiled from: WebDav.kt */
    @DebugMetadata(c = "io.legado.app.lib.webdav.WebDav", f = "WebDav.kt", i = {}, l = {179}, m = "download", n = {}, s = {})
    public static final class a extends f.z.j.a.c {
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
            return b.this.a(this);
        }
    }

    /* JADX INFO: renamed from: e.a.a.e.e.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: WebDav.kt */
    @DebugMetadata(c = "io.legado.app.lib.webdav.WebDav", f = "WebDav.kt", i = {}, l = {173}, m = "downloadTo", n = {}, s = {})
    public static final class C0159b extends f.z.j.a.c {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public C0159b(f.z.d<? super C0159b> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.b(null, false, this);
        }
    }

    /* JADX INFO: compiled from: WebDav.kt */
    @DebugMetadata(c = "io.legado.app.lib.webdav.WebDav", f = "WebDav.kt", i = {}, l = {227}, m = "getInputStream", n = {}, s = {})
    public static final class c extends f.z.j.a.c {
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
            return b.this.d(this);
        }
    }

    /* JADX INFO: compiled from: WebDav.kt */
    public static final class d extends f.c0.c.k implements f.c0.b.l<Request.Builder, v> {
        public final /* synthetic */ a.C0158a $auth;
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, a.C0158a c0158a) {
            super(1);
            this.$url = str;
            this.$auth = c0158a;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Request.Builder builder) {
            invoke2(builder);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Request.Builder builder) {
            f.c0.c.j.e(builder, "$this$newCall");
            builder.url(this.$url);
            Credentials credentials = Credentials.INSTANCE;
            a.C0158a c0158a = this.$auth;
            builder.addHeader("Authorization", Credentials.basic$default(c0158a.a, c0158a.f5658b, null, 4, null));
        }
    }

    /* JADX INFO: compiled from: WebDav.kt */
    public static final class e extends f.c0.c.k implements f.c0.b.a<String> {
        public e() {
            super(0);
        }

        @Override // f.c0.b.a
        @Nullable
        public final String invoke() {
            Object objM11constructorimpl;
            String string = b.this.a.toString();
            f.c0.c.j.d(string, "url.toString()");
            try {
                String strEncode = URLEncoder.encode(f.h0.k.C(f.h0.k.C(string, "davs://", "https://", false, 4), "dav://", "http://", false, 4), DataUtil.defaultCharset);
                f.c0.c.j.d(strEncode, "encode(raw, \"UTF-8\")");
                objM11constructorimpl = f.h.m11constructorimpl(new f.h0.g("%2F").replace(new f.h0.g("%3A").replace(new f.h0.g("\\+").replace(strEncode, "%20"), ":"), w.DEFAULT_PATH_SEPARATOR));
            } catch (Throwable th) {
                objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl)) {
                objM11constructorimpl = null;
            }
            return (String) objM11constructorimpl;
        }
    }

    /* JADX INFO: compiled from: WebDav.kt */
    @DebugMetadata(c = "io.legado.app.lib.webdav.WebDav", f = "WebDav.kt", i = {0}, l = {69}, m = "listFiles", n = {"this"}, s = {"L$0"})
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
            return b.this.e(this);
        }
    }

    /* JADX INFO: compiled from: WebDav.kt */
    @DebugMetadata(c = "io.legado.app.lib.webdav.WebDav", f = "WebDav.kt", i = {}, l = {152}, m = "makeAsDir", n = {}, s = {})
    public static final class g extends f.z.j.a.c {
        public int label;
        public /* synthetic */ Object result;

        public g(f.z.d<? super g> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.f(this);
        }
    }

    /* JADX INFO: compiled from: WebDav.kt */
    public static final class h extends f.c0.c.k implements f.c0.b.l<Request.Builder, v> {
        public final /* synthetic */ a.C0158a $auth;
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, a.C0158a c0158a) {
            super(1);
            this.$url = str;
            this.$auth = c0158a;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Request.Builder builder) {
            invoke2(builder);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Request.Builder builder) {
            f.c0.c.j.e(builder, "$this$newCall");
            builder.url(this.$url);
            builder.method("MKCOL", null);
            Credentials credentials = Credentials.INSTANCE;
            a.C0158a c0158a = this.$auth;
            builder.addHeader("Authorization", Credentials.basic$default(c0158a.a, c0158a.f5658b, null, 4, null));
        }
    }

    /* JADX INFO: compiled from: WebDav.kt */
    @DebugMetadata(c = "io.legado.app.lib.webdav.WebDav", f = "WebDav.kt", i = {}, l = {92}, m = "propFindResponse", n = {}, s = {})
    public static final class i extends f.z.j.a.c {
        public int label;
        public /* synthetic */ Object result;

        public i(f.z.d<? super i> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.g(null, this);
        }
    }

    /* JADX INFO: compiled from: WebDav.kt */
    public static final class j extends f.c0.c.k implements f.c0.b.l<Request.Builder, v> {
        public final /* synthetic */ a.C0158a $auth;
        public final /* synthetic */ String $requestPropsStr;
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, a.C0158a c0158a, String str2) {
            super(1);
            this.$url = str;
            this.$auth = c0158a;
            this.$requestPropsStr = str2;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Request.Builder builder) {
            invoke2(builder);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Request.Builder builder) {
            f.c0.c.j.e(builder, "$this$newCall");
            builder.url(this.$url);
            Credentials credentials = Credentials.INSTANCE;
            a.C0158a c0158a = this.$auth;
            builder.addHeader("Authorization", Credentials.basic$default(c0158a.a, c0158a.f5658b, null, 4, null));
            builder.addHeader("Depth", SdkVersion.MINI_VERSION);
            builder.method("PROPFIND", RequestBody.INSTANCE.create(this.$requestPropsStr, MediaType.INSTANCE.get(d.a.a.a.MIME_PLAINTEXT)));
        }
    }

    /* JADX INFO: compiled from: WebDav.kt */
    @DebugMetadata(c = "io.legado.app.lib.webdav.WebDav", f = "WebDav.kt", i = {}, l = {195}, m = "upload", n = {}, s = {})
    public static final class k extends f.z.j.a.c {
        public int label;
        public /* synthetic */ Object result;

        public k(f.z.d<? super k> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.h(null, null, this);
        }
    }

    /* JADX INFO: compiled from: WebDav.kt */
    public static final class l extends f.c0.c.k implements f.c0.b.l<Request.Builder, v> {
        public final /* synthetic */ a.C0158a $auth;
        public final /* synthetic */ RequestBody $fileBody;
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, RequestBody requestBody, a.C0158a c0158a) {
            super(1);
            this.$url = str;
            this.$fileBody = requestBody;
            this.$auth = c0158a;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Request.Builder builder) {
            invoke2(builder);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Request.Builder builder) {
            f.c0.c.j.e(builder, "$this$newCall");
            builder.url(this.$url);
            builder.put(this.$fileBody);
            Credentials credentials = Credentials.INSTANCE;
            a.C0158a c0158a = this.$auth;
            builder.addHeader("Authorization", Credentials.basic$default(c0158a.a, c0158a.f5658b, null, 4, null));
        }
    }

    /* JADX INFO: compiled from: WebDav.kt */
    @DebugMetadata(c = "io.legado.app.lib.webdav.WebDav", f = "WebDav.kt", i = {}, l = {212}, m = "upload", n = {}, s = {})
    public static final class m extends f.z.j.a.c {
        public int label;
        public /* synthetic */ Object result;

        public m(f.z.d<? super m> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.i(null, null, this);
        }
    }

    /* JADX INFO: compiled from: WebDav.kt */
    public static final class n extends f.c0.c.k implements f.c0.b.l<Request.Builder, v> {
        public final /* synthetic */ a.C0158a $auth;
        public final /* synthetic */ RequestBody $fileBody;
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(String str, RequestBody requestBody, a.C0158a c0158a) {
            super(1);
            this.$url = str;
            this.$fileBody = requestBody;
            this.$auth = c0158a;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Request.Builder builder) {
            invoke2(builder);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Request.Builder builder) {
            f.c0.c.j.e(builder, "$this$newCall");
            builder.url(this.$url);
            builder.put(this.$fileBody);
            Credentials credentials = Credentials.INSTANCE;
            a.C0158a c0158a = this.$auth;
            builder.addHeader("Authorization", Credentials.basic$default(c0158a.a, c0158a.f5658b, null, 4, null));
        }
    }

    public b(@NotNull String str) {
        f.c0.c.j.e(str, "urlStr");
        this.a = new URL(str);
        this.f5659b = c.b.a.m.f.N3(new e());
        this.f5661d = "";
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull f.z.d<? super byte[]> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof e.a.a.e.e.b.a
            if (r0 == 0) goto L13
            r0 = r5
            e.a.a.e.e.b$a r0 = (e.a.a.e.e.b.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            e.a.a.e.e.b$a r0 = new e.a.a.e.e.b$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            c.b.a.m.f.E5(r5)
            goto L3b
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            c.b.a.m.f.E5(r5)
            r0.label = r3
            java.lang.Object r5 = r4.d(r0)
            if (r5 != r1) goto L3b
            return r1
        L3b:
            java.io.InputStream r5 = (java.io.InputStream) r5
            if (r5 != 0) goto L41
            r5 = 0
            return r5
        L41:
            byte[] r5 = c.b.a.m.f.w4(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.e.e.b.a(f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull java.lang.String r5, boolean r6, @org.jetbrains.annotations.NotNull f.z.d<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof e.a.a.e.e.b.C0159b
            if (r0 == 0) goto L13
            r0 = r7
            e.a.a.e.e.b$b r0 = (e.a.a.e.e.b.C0159b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            e.a.a.e.e.b$b r0 = new e.a.a.e.e.b$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            c.b.a.m.f.E5(r7)
            goto L51
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            c.b.a.m.f.E5(r7)
            java.io.File r7 = new java.io.File
            r7.<init>(r5)
            boolean r7 = r7.exists()
            if (r7 == 0) goto L46
            if (r6 != 0) goto L46
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L46:
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = r4.d(r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            java.io.InputStream r7 = (java.io.InputStream) r7
            if (r7 != 0) goto L58
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L58:
            java.io.File r6 = new java.io.File
            r6.<init>(r5)
            byte[] r5 = c.b.a.m.f.w4(r7)
            f.b0.d.e(r6, r5)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.e.e.b.b(java.lang.String, boolean, f.z.d):java.lang.Object");
    }

    public final String c() {
        return (String) this.f5659b.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(f.z.d<? super java.io.InputStream> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof e.a.a.e.e.b.c
            if (r0 == 0) goto L13
            r0 = r9
            e.a.a.e.e.b$c r0 = (e.a.a.e.e.b.c) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            e.a.a.e.e.b$c r0 = new e.a.a.e.e.b$c
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            c.b.a.m.f.E5(r9)     // Catch: java.lang.Throwable -> L28
            goto L52
        L28:
            r9 = move-exception
            goto L5d
        L2a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L32:
            c.b.a.m.f.E5(r9)
            java.lang.String r9 = r8.c()
            e.a.a.e.e.a$a r2 = e.a.a.e.e.a.a
            if (r9 == 0) goto L6d
            if (r2 == 0) goto L6d
            okhttp3.OkHttpClient r5 = e.a.a.d.v.i.a()     // Catch: java.lang.Throwable -> L28
            r6 = 0
            e.a.a.e.e.b$d r7 = new e.a.a.e.e.b$d     // Catch: java.lang.Throwable -> L28
            r7.<init>(r9, r2)     // Catch: java.lang.Throwable -> L28
            r0.label = r4     // Catch: java.lang.Throwable -> L28
            java.lang.Object r9 = c.b.a.m.f.Z3(r5, r6, r7, r0, r4)     // Catch: java.lang.Throwable -> L28
            if (r9 != r1) goto L52
            return r1
        L52:
            okhttp3.ResponseBody r9 = (okhttp3.ResponseBody) r9     // Catch: java.lang.Throwable -> L28
            java.io.InputStream r9 = r9.byteStream()     // Catch: java.lang.Throwable -> L28
            java.lang.Object r9 = f.h.m11constructorimpl(r9)     // Catch: java.lang.Throwable -> L28
            goto L65
        L5d:
            java.lang.Object r9 = c.b.a.m.f.m1(r9)
            java.lang.Object r9 = f.h.m11constructorimpl(r9)
        L65:
            boolean r0 = f.h.m16isFailureimpl(r9)
            if (r0 == 0) goto L6c
            goto L6d
        L6c:
            r3 = r9
        L6d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.e.e.b.d(f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(@org.jetbrains.annotations.NotNull f.z.d<? super java.util.List<e.a.a.e.e.b>> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.e.e.b.e(f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(@org.jetbrains.annotations.NotNull f.z.d<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof e.a.a.e.e.b.g
            if (r0 == 0) goto L13
            r0 = r8
            e.a.a.e.e.b$g r0 = (e.a.a.e.e.b.g) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            e.a.a.e.e.b$g r0 = new e.a.a.e.e.b$g
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            c.b.a.m.f.E5(r8)     // Catch: java.lang.Throwable -> L27
            goto L51
        L27:
            r8 = move-exception
            goto L5d
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L31:
            c.b.a.m.f.E5(r8)
            java.lang.String r8 = r7.c()
            e.a.a.e.e.a$a r2 = e.a.a.e.e.a.a
            if (r8 == 0) goto L6e
            if (r2 == 0) goto L6e
            okhttp3.OkHttpClient r4 = e.a.a.d.v.i.a()     // Catch: java.lang.Throwable -> L27
            r5 = 0
            e.a.a.e.e.b$h r6 = new e.a.a.e.e.b$h     // Catch: java.lang.Throwable -> L27
            r6.<init>(r8, r2)     // Catch: java.lang.Throwable -> L27
            r0.label = r3     // Catch: java.lang.Throwable -> L27
            java.lang.Object r8 = c.b.a.m.f.Z3(r4, r5, r6, r0, r3)     // Catch: java.lang.Throwable -> L27
            if (r8 != r1) goto L51
            return r1
        L51:
            okhttp3.ResponseBody r8 = (okhttp3.ResponseBody) r8     // Catch: java.lang.Throwable -> L27
            r8.close()     // Catch: java.lang.Throwable -> L27
            f.v r8 = f.v.a     // Catch: java.lang.Throwable -> L27
            java.lang.Object r8 = f.h.m11constructorimpl(r8)     // Catch: java.lang.Throwable -> L27
            goto L65
        L5d:
            java.lang.Object r8 = c.b.a.m.f.m1(r8)
            java.lang.Object r8 = f.h.m11constructorimpl(r8)
        L65:
            boolean r8 = f.h.m17isSuccessimpl(r8)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            return r8
        L6e:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.e.e.b.f(f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.util.List<java.lang.String> r9, f.z.d<? super java.lang.String> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.e.e.b.g(java.util.List, f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.Nullable java.lang.String r8, @org.jetbrains.annotations.NotNull f.z.d<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof e.a.a.e.e.b.k
            if (r0 == 0) goto L13
            r0 = r9
            e.a.a.e.e.b$k r0 = (e.a.a.e.e.b.k) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            e.a.a.e.e.b$k r0 = new e.a.a.e.e.b$k
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            c.b.a.m.f.E5(r9)     // Catch: java.lang.Throwable -> L27
            goto L6f
        L27:
            r7 = move-exception
            goto L7b
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            c.b.a.m.f.E5(r9)
            java.io.File r9 = new java.io.File
            r9.<init>(r7)
            boolean r7 = r9.exists()
            if (r7 != 0) goto L42
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        L42:
            okhttp3.RequestBody$Companion r7 = okhttp3.RequestBody.INSTANCE
            if (r8 != 0) goto L48
            r8 = 0
            goto L4e
        L48:
            okhttp3.MediaType$Companion r2 = okhttp3.MediaType.INSTANCE
            okhttp3.MediaType r8 = r2.get(r8)
        L4e:
            okhttp3.RequestBody r7 = r7.create(r9, r8)
            java.lang.String r8 = r6.c()
            e.a.a.e.e.a$a r9 = e.a.a.e.e.a.a
            if (r8 == 0) goto L8c
            if (r9 == 0) goto L8c
            okhttp3.OkHttpClient r2 = e.a.a.d.v.i.a()     // Catch: java.lang.Throwable -> L27
            r4 = 0
            e.a.a.e.e.b$l r5 = new e.a.a.e.e.b$l     // Catch: java.lang.Throwable -> L27
            r5.<init>(r8, r7, r9)     // Catch: java.lang.Throwable -> L27
            r0.label = r3     // Catch: java.lang.Throwable -> L27
            java.lang.Object r9 = c.b.a.m.f.Z3(r2, r4, r5, r0, r3)     // Catch: java.lang.Throwable -> L27
            if (r9 != r1) goto L6f
            return r1
        L6f:
            okhttp3.ResponseBody r9 = (okhttp3.ResponseBody) r9     // Catch: java.lang.Throwable -> L27
            r9.close()     // Catch: java.lang.Throwable -> L27
            f.v r7 = f.v.a     // Catch: java.lang.Throwable -> L27
            java.lang.Object r7 = f.h.m11constructorimpl(r7)     // Catch: java.lang.Throwable -> L27
            goto L83
        L7b:
            java.lang.Object r7 = c.b.a.m.f.m1(r7)
            java.lang.Object r7 = f.h.m11constructorimpl(r7)
        L83:
            boolean r7 = f.h.m17isSuccessimpl(r7)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            return r7
        L8c:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.e.e.b.h(java.lang.String, java.lang.String, f.z.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(@org.jetbrains.annotations.NotNull byte[] r12, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.NotNull f.z.d<? super java.lang.Boolean> r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof e.a.a.e.e.b.m
            if (r0 == 0) goto L13
            r0 = r14
            e.a.a.e.e.b$m r0 = (e.a.a.e.e.b.m) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            e.a.a.e.e.b$m r0 = new e.a.a.e.e.b$m
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            c.b.a.m.f.E5(r14)     // Catch: java.lang.Throwable -> L27
            goto L67
        L27:
            r12 = move-exception
            goto L73
        L29:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L31:
            c.b.a.m.f.E5(r14)
            okhttp3.RequestBody$Companion r4 = okhttp3.RequestBody.INSTANCE
            if (r13 != 0) goto L3a
            r13 = 0
            goto L40
        L3a:
            okhttp3.MediaType$Companion r14 = okhttp3.MediaType.INSTANCE
            okhttp3.MediaType r13 = r14.get(r13)
        L40:
            r6 = r13
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            r5 = r12
            okhttp3.RequestBody r12 = okhttp3.RequestBody.Companion.create$default(r4, r5, r6, r7, r8, r9, r10)
            java.lang.String r13 = r11.c()
            e.a.a.e.e.a$a r14 = e.a.a.e.e.a.a
            if (r13 == 0) goto L84
            if (r14 == 0) goto L84
            okhttp3.OkHttpClient r2 = e.a.a.d.v.i.a()     // Catch: java.lang.Throwable -> L27
            r4 = 0
            e.a.a.e.e.b$n r5 = new e.a.a.e.e.b$n     // Catch: java.lang.Throwable -> L27
            r5.<init>(r13, r12, r14)     // Catch: java.lang.Throwable -> L27
            r0.label = r3     // Catch: java.lang.Throwable -> L27
            java.lang.Object r14 = c.b.a.m.f.Z3(r2, r4, r5, r0, r3)     // Catch: java.lang.Throwable -> L27
            if (r14 != r1) goto L67
            return r1
        L67:
            okhttp3.ResponseBody r14 = (okhttp3.ResponseBody) r14     // Catch: java.lang.Throwable -> L27
            r14.close()     // Catch: java.lang.Throwable -> L27
            f.v r12 = f.v.a     // Catch: java.lang.Throwable -> L27
            java.lang.Object r12 = f.h.m11constructorimpl(r12)     // Catch: java.lang.Throwable -> L27
            goto L7b
        L73:
            java.lang.Object r12 = c.b.a.m.f.m1(r12)
            java.lang.Object r12 = f.h.m11constructorimpl(r12)
        L7b:
            boolean r12 = f.h.m17isSuccessimpl(r12)
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            return r12
        L84:
            java.lang.Boolean r12 = java.lang.Boolean.FALSE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.e.e.b.i(byte[], java.lang.String, f.z.d):java.lang.Object");
    }
}
