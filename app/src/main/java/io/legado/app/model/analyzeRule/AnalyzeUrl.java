package io.legado.app.model.analyzeRule;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.Keep;
import c.a.a.a.a;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.uc.crashsdk.export.LogType;
import e.a.a.d.e;
import e.a.a.d.i;
import e.a.a.d.v.j;
import e.a.a.h.n;
import e.a.a.h.x;
import f.c0.b.l;
import f.c0.c.f;
import f.c0.c.k;
import f.h;
import f.h0.g;
import f.v;
import f.z.d;
import f.z.j.a.c;
import io.legado.app.data.entities.BaseBook;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.help.JsExtensions;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.SimpleBindings;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Connection;
import org.jsoup.helper.DataUtil;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: AnalyzeUrl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0006\b\u0007\u0018\u0000 f2\u00020\u0001:\u0002fgB\u008f\u0001\u0012\u0006\u0010*\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u0010V\u001a\u00020\u0007\u0012\b\b\u0002\u0010?\u001a\u00020>\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0016\b\u0002\u0010c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010b¢\u0006\u0004\bd\u0010eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u001d\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010&\u001a\u0004\b+\u0010,\"\u0004\b-\u0010\nR\u001b\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\"\u00103\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010&\u001a\u0004\b4\u0010,\"\u0004\b5\u0010\nR\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u00109\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010&R$\u0010:\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010&\u001a\u0004\b;\u0010,\"\u0004\b<\u0010\nR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b=\u0010,R\"\u0010?\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001b\u0010E\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010&\u001a\u0004\bF\u0010,R\u001b\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001b\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR%\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070Q8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\"\u0010V\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010&\u001a\u0004\bW\u0010,\"\u0004\bX\u0010\nR\u0016\u0010Y\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bY\u0010&R$\u0010Z\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010&\u001a\u0004\b[\u0010,\"\u0004\b\\\u0010\nR\u001b\u0010]\u001a\u0004\u0018\u00010.8\u0006@\u0006¢\u0006\f\n\u0004\b]\u00100\u001a\u0004\b^\u00102R\u0018\u0010_\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010&R\u0016\u0010`\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006h"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeUrl;", "Lio/legado/app/help/JsExtensions;", "Lf/v;", "analyzeJs", "()V", "replaceKeyPageJs", "initUrl", "", "fieldsTxt", "analyzeFields", "(Ljava/lang/String;)V", "jsStr", "", "result", "evalJS", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "tag", "setCookie", "key", ES6Iterator.VALUE_PROPERTY, "put", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "get", "(Ljava/lang/String;)Ljava/lang/String;", "sourceRegex", "Le/a/a/d/v/l;", "getStrResponse", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lf/z/d;)Ljava/lang/Object;", "", "getByteArray", "(Ljava/lang/String;Lf/z/d;)Ljava/lang/Object;", "Lcom/bumptech/glide/load/model/GlideUrl;", "getGlideUrl", "()Lcom/bumptech/glide/load/model/GlideUrl;", "Lio/legado/app/model/analyzeRule/RuleDataInterface;", "ruleData", "Lio/legado/app/model/analyzeRule/RuleDataInterface;", "queryStr", "Ljava/lang/String;", "Ljava/util/LinkedHashMap;", "fieldMap", "Ljava/util/LinkedHashMap;", "ruleUrl", "getRuleUrl", "()Ljava/lang/String;", "setRuleUrl", "", "speakSpeed", "Ljava/lang/Integer;", "getSpeakSpeed", "()Ljava/lang/Integer;", "url", "getUrl", "setUrl", "Le/a/a/d/v/j;", "method", "Le/a/a/d/v/j;", "proxy", "type", "getType", "setType", "getKey", "", "useWebView", "Z", "getUseWebView", "()Z", "setUseWebView", "(Z)V", "speakText", "getSpeakText", "Lio/legado/app/data/entities/BookChapter;", "chapter", "Lio/legado/app/data/entities/BookChapter;", "getChapter", "()Lio/legado/app/data/entities/BookChapter;", "Lio/legado/app/data/entities/BaseBook;", "book", "Lio/legado/app/data/entities/BaseBook;", "getBook", "()Lio/legado/app/data/entities/BaseBook;", "Ljava/util/HashMap;", "headerMap", "Ljava/util/HashMap;", "getHeaderMap", "()Ljava/util/HashMap;", "baseUrl", "getBaseUrl", "setBaseUrl", "urlHasQuery", "body", "getBody", "setBody", "page", "getPage", "charset", "retry", OptRuntime.GeneratorState.resumptionPoint_TYPE, "", "headerMapF", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLio/legado/app/data/entities/BaseBook;Lio/legado/app/data/entities/BookChapter;Lio/legado/app/model/analyzeRule/RuleDataInterface;Ljava/util/Map;)V", "Companion", "UrlOption", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
@SuppressLint({"DefaultLocale"})
public final class AnalyzeUrl implements JsExtensions {

    @NotNull
    private String baseUrl;

    @Nullable
    private String body;

    @Nullable
    private final BaseBook book;

    @Nullable
    private final BookChapter chapter;

    @Nullable
    private String charset;

    @NotNull
    private final LinkedHashMap<String, String> fieldMap;

    @NotNull
    private final HashMap<String, String> headerMap;

    @Nullable
    private final String key;

    @NotNull
    private j method;

    @Nullable
    private final Integer page;

    @Nullable
    private String proxy;

    @Nullable
    private String queryStr;
    private int retry;

    @Nullable
    private final RuleDataInterface ruleData;

    @NotNull
    private String ruleUrl;

    @Nullable
    private final Integer speakSpeed;

    @Nullable
    private final String speakText;

    @Nullable
    private String type;

    @NotNull
    private String url;
    private String urlHasQuery;
    private boolean useWebView;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final g splitUrlRegex = new g(",\\s*(?=\\{)");
    private static final Pattern pagePattern = Pattern.compile("<(.*?)>");

    /* JADX INFO: compiled from: AnalyzeUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeUrl$Companion;", "", "Lf/h0/g;", "splitUrlRegex", "Lf/h0/g;", "getSplitUrlRegex", "()Lf/h0/g;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "pagePattern", "Ljava/util/regex/Pattern;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        @NotNull
        public final g getSplitUrlRegex() {
            return AnalyzeUrl.splitUrlRegex;
        }
    }

    /* JADX INFO: compiled from: AnalyzeUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            j.valuesCustom();
            int[] iArr = new int[2];
            iArr[j.GET.ordinal()] = 1;
            iArr[j.POST.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.analyzeRule.AnalyzeUrl$getByteArray$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnalyzeUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.analyzeRule.AnalyzeUrl", f = "AnalyzeUrl.kt", i = {}, l = {329}, m = "getByteArray", n = {}, s = {})
    public static final class AnonymousClass1 extends c {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnalyzeUrl.this.getByteArray(null, this);
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.analyzeRule.AnalyzeUrl$getByteArray$2, reason: invalid class name */
    /* JADX INFO: compiled from: AnalyzeUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lokhttp3/Request$Builder;", "Lf/v;", "<anonymous>", "(Lokhttp3/Request$Builder;)V"}, k = 3, mv = {1, 5, 1})
    public static final class AnonymousClass2 extends k implements l<Request.Builder, v> {

        /* JADX INFO: renamed from: io.legado.app.model.analyzeRule.AnalyzeUrl$getByteArray$2$WhenMappings */
        /* JADX INFO: compiled from: AnalyzeUrl.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                j.valuesCustom();
                int[] iArr = new int[2];
                iArr[j.POST.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Request.Builder builder) {
            invoke2(builder);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Request.Builder builder) {
            f.c0.c.j.e(builder, "$this$newCall");
            builder.removeHeader("User-Agent");
            c.b.a.m.f.U(builder, AnalyzeUrl.this.getHeaderMap());
            if (WhenMappings.$EnumSwitchMapping$0[AnalyzeUrl.this.method.ordinal()] != 1) {
                c.b.a.m.f.L1(builder, AnalyzeUrl.this.getUrl(), AnalyzeUrl.this.fieldMap, true);
                return;
            }
            builder.url(AnalyzeUrl.this.getUrl());
            if (!(!AnalyzeUrl.this.fieldMap.isEmpty())) {
                String body = AnalyzeUrl.this.getBody();
                if (!(body == null || f.h0.k.s(body))) {
                    c.b.a.m.f.n4(builder, AnalyzeUrl.this.getBody());
                    return;
                }
            }
            c.b.a.m.f.m4(builder, AnalyzeUrl.this.fieldMap, true);
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.analyzeRule.AnalyzeUrl$getStrResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnalyzeUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.analyzeRule.AnalyzeUrl", f = "AnalyzeUrl.kt", i = {}, l = {296, 307, TinkerReport.KEY_LOADED_INFO_CORRUPTED}, m = "getStrResponse", n = {}, s = {})
    public static final class C03361 extends c {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public C03361(d<? super C03361> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnalyzeUrl.this.getStrResponse(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.analyzeRule.AnalyzeUrl$getStrResponse$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnalyzeUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lokhttp3/Request$Builder;", "Lf/v;", "<anonymous>", "(Lokhttp3/Request$Builder;)V"}, k = 3, mv = {1, 5, 1})
    public static final class C03372 extends k implements l<Request.Builder, v> {

        /* JADX INFO: renamed from: io.legado.app.model.analyzeRule.AnalyzeUrl$getStrResponse$2$WhenMappings */
        /* JADX INFO: compiled from: AnalyzeUrl.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                j.valuesCustom();
                int[] iArr = new int[2];
                iArr[j.POST.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public C03372() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Request.Builder builder) {
            invoke2(builder);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Request.Builder builder) {
            f.c0.c.j.e(builder, "$this$newCallStrResponse");
            builder.removeHeader("User-Agent");
            c.b.a.m.f.U(builder, AnalyzeUrl.this.getHeaderMap());
            if (WhenMappings.$EnumSwitchMapping$0[AnalyzeUrl.this.method.ordinal()] != 1) {
                c.b.a.m.f.L1(builder, AnalyzeUrl.this.getUrl(), AnalyzeUrl.this.fieldMap, true);
                return;
            }
            builder.url(AnalyzeUrl.this.getUrl());
            if (!(!AnalyzeUrl.this.fieldMap.isEmpty())) {
                String body = AnalyzeUrl.this.getBody();
                if (!(body == null || f.h0.k.s(body))) {
                    c.b.a.m.f.n4(builder, AnalyzeUrl.this.getBody());
                    return;
                }
            }
            c.b.a.m.f.m4(builder, AnalyzeUrl.this.fieldMap, true);
        }
    }

    public AnalyzeUrl(@NotNull String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable Integer num2, @NotNull String str4, boolean z, @Nullable BaseBook baseBook, @Nullable BookChapter bookChapter, @Nullable RuleDataInterface ruleDataInterface, @Nullable Map<String, String> map) throws UnsupportedEncodingException {
        f.c0.c.j.e(str, "ruleUrl");
        f.c0.c.j.e(str4, "baseUrl");
        this.ruleUrl = str;
        this.key = str2;
        this.page = num;
        this.speakText = str3;
        this.speakSpeed = num2;
        this.baseUrl = str4;
        this.useWebView = z;
        this.book = baseBook;
        this.chapter = bookChapter;
        this.ruleData = ruleDataInterface;
        this.url = "";
        this.headerMap = new HashMap<>();
        this.fieldMap = new LinkedHashMap<>();
        this.method = j.GET;
        this.baseUrl = splitUrlRegex.split(this.baseUrl, 1).get(0);
        if (map != null) {
            getHeaderMap().putAll(map);
            if (map.containsKey("proxy")) {
                this.proxy = map.get("proxy");
                getHeaderMap().remove("proxy");
            }
        }
        analyzeJs();
        replaceKeyPageJs();
        initUrl();
    }

    private final void analyzeFields(String fieldsTxt) throws UnsupportedEncodingException {
        boolean z;
        this.queryStr = fieldsTxt;
        String[] strArrN5 = c.b.a.m.f.n5(fieldsTxt, "&");
        int length = strArrN5.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArrN5[i2];
            i2++;
            String[] strArrN52 = c.b.a.m.f.n5(str, "=");
            String str2 = strArrN52.length > 1 ? strArrN52[1] : "";
            if (TextUtils.isEmpty(this.charset)) {
                x xVar = x.a;
                f.c0.c.j.e(str2, "str");
                int i3 = 0;
                while (i3 < str2.length()) {
                    char cCharAt = str2.charAt(i3);
                    if (!((BitSet) x.f5967b.getValue()).get(cCharAt)) {
                        if (cCharAt == '%' && i3 + 2 < str2.length()) {
                            int i4 = i3 + 1;
                            char cCharAt2 = str2.charAt(i4);
                            i3 = i4 + 1;
                            char cCharAt3 = str2.charAt(i3);
                            if (!x.e(cCharAt2) || !x.e(cCharAt3)) {
                            }
                        }
                        z = true;
                        break;
                    }
                    i3++;
                }
                z = false;
                if (true ^ z) {
                    this.fieldMap.put(strArrN52[0], str2);
                } else {
                    LinkedHashMap<String, String> linkedHashMap = this.fieldMap;
                    String str3 = strArrN52[0];
                    String strEncode = URLEncoder.encode(str2, DataUtil.defaultCharset);
                    f.c0.c.j.d(strEncode, "encode(value, \"UTF-8\")");
                    linkedHashMap.put(str3, strEncode);
                }
            } else if (f.c0.c.j.a(this.charset, "escape")) {
                this.fieldMap.put(strArrN52[0], e.a.a.h.k.a.c(str2));
            } else {
                LinkedHashMap<String, String> linkedHashMap2 = this.fieldMap;
                String str4 = strArrN52[0];
                String strEncode2 = URLEncoder.encode(str2, this.charset);
                f.c0.c.j.d(strEncode2, "encode(value, charset)");
                linkedHashMap2.put(str4, strEncode2);
            }
        }
    }

    private final void analyzeJs() {
        ArrayList<String> arrayList = new ArrayList();
        e.a.a.c.d dVar = e.a.a.c.d.a;
        Matcher matcher = e.a.a.c.d.f5508b.matcher(this.ruleUrl);
        int iEnd = 0;
        while (matcher.find()) {
            if (matcher.start() > iEnd) {
                String str = this.ruleUrl;
                int iStart = matcher.start();
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String strSubstring = str.substring(iEnd, iStart);
                f.c0.c.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strC = f.h0.k.C(strSubstring, "\n", "", false, 4);
                int length = strC.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length) {
                    boolean z2 = f.c0.c.j.g(strC.charAt(!z ? i2 : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i2++;
                    } else {
                        z = true;
                    }
                }
                String string = strC.subSequence(i2, length + 1).toString();
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(string);
                }
            }
            arrayList.add(matcher.group());
            iEnd = matcher.end();
        }
        if (this.ruleUrl.length() > iEnd) {
            String str2 = this.ruleUrl;
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            String strSubstring2 = str2.substring(iEnd);
            f.c0.c.j.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            String strC2 = f.h0.k.C(strSubstring2, "\n", "", false, 4);
            int length2 = strC2.length() - 1;
            int i3 = 0;
            boolean z3 = false;
            while (i3 <= length2) {
                boolean z4 = f.c0.c.j.g(strC2.charAt(!z3 ? i3 : length2), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    } else {
                        length2--;
                    }
                } else if (z4) {
                    i3++;
                } else {
                    z3 = true;
                }
            }
            String string2 = strC2.subSequence(i3, length2 + 1).toString();
            if (!TextUtils.isEmpty(string2)) {
                arrayList.add(string2);
            }
        }
        for (String str3 : arrayList) {
            f.c0.c.j.d(str3, "rule");
            if (f.h0.k.K(str3, "<js>", false, 2)) {
                String strSubstring3 = str3.substring(4, f.h0.k.u(str3, "<", 0, false, 6));
                f.c0.c.j.d(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Object objEvalJS = evalJS(strSubstring3, this.ruleUrl);
                Objects.requireNonNull(objEvalJS, "null cannot be cast to non-null type kotlin.String");
                this.ruleUrl = (String) objEvalJS;
            } else if (f.h0.k.H(str3, "@js", true)) {
                String strSubstring4 = str3.substring(4);
                f.c0.c.j.d(strSubstring4, "(this as java.lang.String).substring(startIndex)");
                Object objEvalJS2 = evalJS(strSubstring4, this.ruleUrl);
                Objects.requireNonNull(objEvalJS2, "null cannot be cast to non-null type kotlin.String");
                this.ruleUrl = (String) objEvalJS2;
            } else {
                this.ruleUrl = f.h0.k.C(str3, "@result", this.ruleUrl, false, 4);
            }
        }
    }

    private final Object evalJS(String jsStr, Object result) {
        SimpleBindings simpleBindings = new SimpleBindings();
        simpleBindings.put(LogType.JAVA_TYPE, this);
        simpleBindings.put("cookie", e.a.a.d.v.f.a);
        simpleBindings.put("cache", i.a);
        simpleBindings.put("page", this.page);
        simpleBindings.put("key", this.key);
        simpleBindings.put("speakText", this.speakText);
        simpleBindings.put("speakSpeed", this.speakSpeed);
        simpleBindings.put("book", this.book);
        simpleBindings.put("result", result);
        simpleBindings.put("baseUrl", this.baseUrl);
        e.a.a.c.c cVar = e.a.a.c.c.a;
        return e.a.a.c.c.c().eval(jsStr, simpleBindings);
    }

    public static /* synthetic */ Object evalJS$default(AnalyzeUrl analyzeUrl, String str, Object obj, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        return analyzeUrl.evalJS(str, obj);
    }

    public static /* synthetic */ Object getByteArray$default(AnalyzeUrl analyzeUrl, String str, d dVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return analyzeUrl.getByteArray(str, dVar);
    }

    public static /* synthetic */ Object getStrResponse$default(AnalyzeUrl analyzeUrl, String str, String str2, String str3, d dVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        return analyzeUrl.getStrResponse(str, str2, str3, dVar);
    }

    private final void initUrl() throws UnsupportedEncodingException {
        String str;
        Object objM11constructorimpl;
        Object objM11constructorimpl2;
        List<String> listSplit = splitUrlRegex.split(this.ruleUrl, 2);
        x xVar = x.a;
        this.url = x.a(this.baseUrl, listSplit.get(0));
        this.urlHasQuery = listSplit.get(0);
        String strC = x.c(this.url);
        if (strC != null) {
            setBaseUrl(strC);
        }
        if (listSplit.size() > 1) {
            Gson gsonA = n.a();
            String str2 = listSplit.get(1);
            try {
                Type type = new TypeToken<UrlOption>() { // from class: io.legado.app.model.analyzeRule.AnalyzeUrl$initUrl$$inlined$fromJsonObject$1
                }.getType();
                f.c0.c.j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(str2, type);
                if (!(objFromJson instanceof UrlOption)) {
                    objFromJson = null;
                }
                objM11constructorimpl = h.m11constructorimpl((UrlOption) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            if (h.m16isFailureimpl(objM11constructorimpl)) {
                objM11constructorimpl = null;
            }
            UrlOption urlOption = (UrlOption) objM11constructorimpl;
            if (urlOption != null) {
                String method = urlOption.getMethod();
                if (method != null && f.h0.k.i(method, "POST", true)) {
                    this.method = j.POST;
                }
                String type2 = urlOption.getType();
                if (type2 != null) {
                    setType(type2);
                }
                Object headers = urlOption.getHeaders();
                if (headers != null) {
                    if (headers instanceof Map) {
                        for (Map.Entry entry : ((Map) headers).entrySet()) {
                            getHeaderMap().put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                        }
                    } else if (headers instanceof String) {
                        Gson gsonA2 = n.a();
                        String str3 = (String) headers;
                        try {
                            Type type3 = new TypeToken<Map<String, ? extends String>>() { // from class: io.legado.app.model.analyzeRule.AnalyzeUrl$initUrl$lambda-17$lambda-12$$inlined$fromJsonObject$1
                            }.getType();
                            f.c0.c.j.d(type3, "object : TypeToken<T>() {}.type");
                            Object objFromJson2 = gsonA2.fromJson(str3, type3);
                            if (!(objFromJson2 instanceof Map)) {
                                objFromJson2 = null;
                            }
                            objM11constructorimpl2 = h.m11constructorimpl((Map) objFromJson2);
                        } catch (Throwable th2) {
                            objM11constructorimpl2 = h.m11constructorimpl(c.b.a.m.f.m1(th2));
                        }
                        if (h.m16isFailureimpl(objM11constructorimpl2)) {
                            objM11constructorimpl2 = null;
                        }
                        Map<? extends String, ? extends String> map = (Map) objM11constructorimpl2;
                        if (map != null) {
                            getHeaderMap().putAll(map);
                        }
                    }
                }
                String charset = urlOption.getCharset();
                if (charset != null) {
                    this.charset = charset;
                }
                Object body = urlOption.getBody();
                if (body != null) {
                    setBody(body instanceof String ? (String) body : n.a().toJson(body));
                }
                Object webView = urlOption.getWebView();
                if (webView != null) {
                    if (webView.toString().length() > 0) {
                        setUseWebView(true);
                    }
                }
                String js = urlOption.getJs();
                if (js != null) {
                    evalJS$default(this, js, null, 2, null);
                }
                this.retry = urlOption.getRetry();
            }
        }
        if (this.headerMap.get("User-Agent") == null) {
            HashMap<String, String> headerMap = getHeaderMap();
            e eVar = e.a;
            headerMap.put("User-Agent", e.f5518c);
        }
        int iOrdinal = this.method.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1 || (str = this.body) == null || c.b.a.m.f.z3(str)) {
                return;
            }
            analyzeFields(str);
            return;
        }
        if (this.useWebView) {
            return;
        }
        List listF = f.h0.k.F(this.url, new String[]{"?"}, false, 0, 6);
        this.url = (String) listF.get(0);
        if (listF.size() > 1) {
            analyzeFields((String) listF.get(1));
        }
    }

    private final void replaceKeyPageJs() {
        String strC;
        Integer num = this.page;
        if (num != null) {
            num.intValue();
            Matcher matcher = pagePattern.matcher(getRuleUrl());
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                f.c0.c.j.c(strGroup);
                List listF = f.h0.k.F(strGroup, new String[]{","}, false, 0, 6);
                if (getPage().intValue() <= listF.size()) {
                    String ruleUrl = getRuleUrl();
                    String strGroup2 = matcher.group();
                    f.c0.c.j.d(strGroup2, "matcher.group()");
                    String str = (String) listF.get(getPage().intValue() - 1);
                    int length = str.length() - 1;
                    int i2 = 0;
                    boolean z = false;
                    while (i2 <= length) {
                        boolean z2 = f.c0.c.j.g(str.charAt(!z ? i2 : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            } else {
                                length--;
                            }
                        } else if (z2) {
                            i2++;
                        } else {
                            z = true;
                        }
                    }
                    strC = f.h0.k.C(ruleUrl, strGroup2, str.subSequence(i2, length + 1).toString(), false, 4);
                } else {
                    String ruleUrl2 = getRuleUrl();
                    String strGroup3 = matcher.group();
                    f.c0.c.j.d(strGroup3, "matcher.group()");
                    String str2 = (String) f.x.e.r(listF);
                    int length2 = str2.length() - 1;
                    int i3 = 0;
                    boolean z3 = false;
                    while (i3 <= length2) {
                        boolean z4 = f.c0.c.j.g(str2.charAt(!z3 ? i3 : length2), 32) <= 0;
                        if (z3) {
                            if (!z4) {
                                break;
                            } else {
                                length2--;
                            }
                        } else if (z4) {
                            i3++;
                        } else {
                            z3 = true;
                        }
                    }
                    strC = f.h0.k.C(ruleUrl2, strGroup3, str2.subSequence(i3, length2 + 1).toString(), false, 4);
                }
                setRuleUrl(strC);
            }
        }
        if (f.h0.k.d(this.ruleUrl, "{{", false, 2) && f.h0.k.d(this.ruleUrl, "}}", false, 2)) {
            StringBuffer stringBuffer = new StringBuffer();
            SimpleBindings simpleBindings = new SimpleBindings();
            simpleBindings.put(LogType.JAVA_TYPE, this);
            simpleBindings.put("cookie", e.a.a.d.v.f.a);
            simpleBindings.put("cache", i.a);
            simpleBindings.put("baseUrl", this.baseUrl);
            simpleBindings.put("page", this.page);
            simpleBindings.put("key", this.key);
            simpleBindings.put("speakText", this.speakText);
            simpleBindings.put("speakSpeed", this.speakSpeed);
            simpleBindings.put("book", this.book);
            e.a.a.c.d dVar = e.a.a.c.d.a;
            Matcher matcher2 = e.a.a.c.d.f5509c.matcher(this.ruleUrl);
            while (matcher2.find()) {
                String strGroup4 = matcher2.group(1);
                Object obj = "";
                if (strGroup4 != null) {
                    e.a.a.c.c cVar = e.a.a.c.c.a;
                    Object objEval = e.a.a.c.c.c().eval(strGroup4, simpleBindings);
                    if (objEval != null) {
                        obj = objEval;
                    }
                }
                if (obj instanceof String) {
                    matcher2.appendReplacement(stringBuffer, (String) obj);
                } else {
                    if (obj instanceof Double) {
                        if (((Number) obj).doubleValue() % 1.0d == 0.0d) {
                            String str3 = String.format("%.0f", Arrays.copyOf(new Object[]{obj}, 1));
                            f.c0.c.j.d(str3, "java.lang.String.format(format, *args)");
                            matcher2.appendReplacement(stringBuffer, str3);
                        }
                    }
                    matcher2.appendReplacement(stringBuffer, obj.toString());
                }
            }
            matcher2.appendTail(stringBuffer);
            String string = stringBuffer.toString();
            f.c0.c.j.d(string, "sb.toString()");
            this.ruleUrl = string;
        }
    }

    private final void setCookie(String tag) {
        if (tag != null) {
            e.a.a.d.v.f fVar = e.a.a.d.v.f.a;
            String strB = fVar.b(tag);
            if (strB.length() > 0) {
                Map<String, String> mapA = fVar.a(strB);
                String str = this.headerMap.get("Cookie");
                if (str == null) {
                    str = "";
                }
                mapA.putAll(fVar.a(str));
                String string = null;
                if (!mapA.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    LinkedHashMap linkedHashMap = (LinkedHashMap) mapA;
                    for (String str2 : linkedHashMap.keySet()) {
                        String str3 = (String) linkedHashMap.get(str2);
                        if (f.c0.c.j.a(str3 == null ? null : Boolean.valueOf(!f.h0.k.s(str3)), Boolean.TRUE)) {
                            a.z(sb, str2, "=", str3, ";");
                        }
                    }
                    string = sb.deleteCharAt(sb.lastIndexOf(";")).toString();
                }
                if (string == null) {
                    return;
                }
                getHeaderMap().put("Cookie", string);
            }
        }
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesBase64DecodeToByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.W(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesBase64DecodeToString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.X(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesDecodeToByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.Y(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesDecodeToString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.Z(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesEncodeToBase64ByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.a0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesEncodeToBase64String(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.b0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesEncodeToByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.c0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesEncodeToString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.d0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String ajax(@NotNull String str) {
        return c.b.a.m.f.e0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public e.a.a.d.v.l[] ajaxAll(@NotNull String[] strArr) {
        return c.b.a.m.f.f0(this, strArr);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String base64Decode(@NotNull String str) {
        return c.b.a.m.f.x0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] base64DecodeToByteArray(@Nullable String str) {
        return c.b.a.m.f.z0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String base64Encode(@NotNull String str) {
        return c.b.a.m.f.B0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public Object connect(@NotNull String str) {
        return c.b.a.m.f.X0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String downloadFile(@NotNull String str, @NotNull String str2) {
        return c.b.a.m.f.v1(this, str, str2);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String encodeURI(@NotNull String str) {
        return c.b.a.m.f.z1(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public Connection.Response get(@NotNull String str, @NotNull Map<String, String> map) {
        return c.b.a.m.f.K1(this, str, map);
    }

    @NotNull
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @Nullable
    public final String getBody() {
        return this.body;
    }

    @Nullable
    public final BaseBook getBook() {
        return this.book;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getByteArray(@org.jetbrains.annotations.Nullable java.lang.String r5, @org.jetbrains.annotations.NotNull f.z.d<? super byte[]> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.legado.app.model.analyzeRule.AnalyzeUrl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            io.legado.app.model.analyzeRule.AnalyzeUrl$getByteArray$1 r0 = (io.legado.app.model.analyzeRule.AnalyzeUrl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.legado.app.model.analyzeRule.AnalyzeUrl$getByteArray$1 r0 = new io.legado.app.model.analyzeRule.AnalyzeUrl$getByteArray$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            c.b.a.m.f.E5(r6)
            goto L4b
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            c.b.a.m.f.E5(r6)
            r4.setCookie(r5)
            java.lang.String r5 = r4.proxy
            okhttp3.OkHttpClient r5 = e.a.a.d.v.i.b(r5)
            int r6 = r4.retry
            io.legado.app.model.analyzeRule.AnalyzeUrl$getByteArray$2 r2 = new io.legado.app.model.analyzeRule.AnalyzeUrl$getByteArray$2
            r2.<init>()
            r0.label = r3
            java.lang.Object r6 = c.b.a.m.f.Y3(r5, r6, r2, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            okhttp3.ResponseBody r6 = (okhttp3.ResponseBody) r6
            byte[] r5 = r6.bytes()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.analyzeRule.AnalyzeUrl.getByteArray(java.lang.String, f.z.d):java.lang.Object");
    }

    @Nullable
    public final BookChapter getChapter() {
        return this.chapter;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String getCookie(@NotNull String str, @Nullable String str2) {
        return c.b.a.m.f.f2(this, str, str2);
    }

    @NotNull
    public final GlideUrl getGlideUrl() {
        LazyHeaders.Builder builder = new LazyHeaders.Builder();
        for (Map.Entry<String, String> entry : this.headerMap.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
        String str = this.urlHasQuery;
        if (str != null) {
            return new GlideUrl(str, builder.build());
        }
        f.c0.c.j.m("urlHasQuery");
        throw null;
    }

    @NotNull
    public final HashMap<String, String> getHeaderMap() {
        return this.headerMap;
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final Integer getPage() {
        return this.page;
    }

    @NotNull
    public final String getRuleUrl() {
        return this.ruleUrl;
    }

    @Nullable
    public final Integer getSpeakSpeed() {
        return this.speakSpeed;
    }

    @Nullable
    public final String getSpeakText() {
        return this.speakText;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getStrResponse(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.Nullable java.lang.String r10, @org.jetbrains.annotations.Nullable java.lang.String r11, @org.jetbrains.annotations.NotNull f.z.d<? super e.a.a.d.v.l> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.analyzeRule.AnalyzeUrl.getStrResponse(java.lang.String, java.lang.String, java.lang.String, f.z.d):java.lang.Object");
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String getTxtInFolder(@NotNull String str) {
        return c.b.a.m.f.a3(this, str);
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final boolean getUseWebView() {
        return this.useWebView;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String htmlFormat(@NotNull String str) {
        return c.b.a.m.f.i3(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String log(@NotNull String str) {
        c.b.a.m.f.Q3(this, str);
        return str;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String md5Encode(@NotNull String str) {
        return c.b.a.m.f.V3(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String md5Encode16(@NotNull String str) {
        return c.b.a.m.f.W3(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public Connection.Response post(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        return c.b.a.m.f.l4(this, str, str2, map);
    }

    @NotNull
    public final String put(@NotNull String key, @NotNull String value) {
        v vVar;
        RuleDataInterface ruleDataInterface;
        f.c0.c.j.e(key, "key");
        f.c0.c.j.e(value, ES6Iterator.VALUE_PROPERTY);
        BookChapter bookChapter = this.chapter;
        v vVar2 = null;
        if (bookChapter == null) {
            vVar = null;
        } else {
            bookChapter.putVariable(key, value);
            vVar = v.a;
        }
        if (vVar == null) {
            BaseBook baseBook = this.book;
            if (baseBook != null) {
                baseBook.putVariable(key, value);
                vVar2 = v.a;
            }
            if (vVar2 == null && (ruleDataInterface = this.ruleData) != null) {
                ruleDataInterface.putVariable(key, value);
            }
        }
        return value;
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public QueryTTF queryBase64TTF(@Nullable String str) {
        return c.b.a.m.f.s4(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public QueryTTF queryTTF(@Nullable String str) {
        return c.b.a.m.f.t4(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public byte[] readFile(@NotNull String str) {
        return c.b.a.m.f.x4(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String readTxtFile(@NotNull String str) {
        return c.b.a.m.f.D4(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String replaceFont(@NotNull String str, @Nullable QueryTTF queryTTF, @Nullable QueryTTF queryTTF2) {
        return c.b.a.m.f.I4(this, str, queryTTF, queryTTF2);
    }

    public final void setBaseUrl(@NotNull String str) {
        f.c0.c.j.e(str, "<set-?>");
        this.baseUrl = str;
    }

    public final void setBody(@Nullable String str) {
        this.body = str;
    }

    public final void setRuleUrl(@NotNull String str) {
        f.c0.c.j.e(str, "<set-?>");
        this.ruleUrl = str;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    public final void setUrl(@NotNull String str) {
        f.c0.c.j.e(str, "<set-?>");
        this.url = str;
    }

    public final void setUseWebView(boolean z) {
        this.useWebView = z;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String timeFormat(long j2) {
        return c.b.a.m.f.F5(this, j2);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String unzipFile(@NotNull String str) {
        return c.b.a.m.f.U5(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String utf8ToGbk(@NotNull String str) {
        return c.b.a.m.f.a6(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String base64Decode(@NotNull String str, int i2) {
        return c.b.a.m.f.y0(this, str, i2);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] base64DecodeToByteArray(@Nullable String str, int i2) {
        return c.b.a.m.f.A0(this, str, i2);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String base64Encode(@NotNull String str, int i2) {
        return c.b.a.m.f.C0(this, str, i2);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String encodeURI(@NotNull String str, @NotNull String str2) {
        return c.b.a.m.f.A1(this, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0068 A[PHI: r0
  0x0068: PHI (r0v11 java.lang.String) = (r0v10 java.lang.String), (r0v16 java.lang.String) binds: [B:23:0x003d, B:31:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String get(@org.jetbrains.annotations.NotNull java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            f.c0.c.j.e(r3, r0)
            java.lang.String r0 = "bookName"
            boolean r0 = f.c0.c.j.a(r3, r0)
            if (r0 == 0) goto L17
            io.legado.app.data.entities.BaseBook r0 = r2.book
            if (r0 != 0) goto L12
            goto L29
        L12:
            java.lang.String r3 = r0.getName()
            return r3
        L17:
            java.lang.String r0 = "title"
            boolean r0 = f.c0.c.j.a(r3, r0)
            if (r0 == 0) goto L29
            io.legado.app.data.entities.BookChapter r0 = r2.chapter
            if (r0 != 0) goto L24
            goto L29
        L24:
            java.lang.String r3 = r0.getTitle()
            return r3
        L29:
            io.legado.app.data.entities.BookChapter r0 = r2.chapter
            r1 = 0
            if (r0 != 0) goto L30
        L2e:
            r0 = r1
            goto L3d
        L30:
            java.util.HashMap r0 = r0.getVariableMap()
            if (r0 != 0) goto L37
            goto L2e
        L37:
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
        L3d:
            if (r0 != 0) goto L68
            io.legado.app.data.entities.BaseBook r0 = r2.book
            if (r0 != 0) goto L45
        L43:
            r0 = r1
            goto L52
        L45:
            java.util.HashMap r0 = r0.getVariableMap()
            if (r0 != 0) goto L4c
            goto L43
        L4c:
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
        L52:
            if (r0 != 0) goto L68
            io.legado.app.model.analyzeRule.RuleDataInterface r0 = r2.ruleData
            if (r0 != 0) goto L59
            goto L69
        L59:
            java.util.HashMap r0 = r0.getVariableMap()
            if (r0 != 0) goto L60
            goto L69
        L60:
            java.lang.Object r3 = r0.get(r3)
            r1 = r3
            java.lang.String r1 = (java.lang.String) r1
            goto L69
        L68:
            r1 = r0
        L69:
            if (r1 != 0) goto L6d
            java.lang.String r1 = ""
        L6d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.analyzeRule.AnalyzeUrl.get(java.lang.String):java.lang.String");
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String readTxtFile(@NotNull String str, @NotNull String str2) {
        return c.b.a.m.f.E4(this, str, str2);
    }

    /* JADX INFO: compiled from: AnalyzeUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJn\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u000eJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b$\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b%\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010\u000eR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b)\u0010\u0007¨\u0006,"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeUrl$UrlOption;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/lang/Object;", "component4", "component5", "component6", "component7", "", "component8", "()I", "method", "charset", "webView", "headers", "body", "type", "js", "retry", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;I)Lio/legado/app/model/analyzeRule/AnalyzeUrl$UrlOption;", "toString", TTDownloadField.TT_HASHCODE, "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getWebView", "Ljava/lang/String;", "getMethod", "getJs", "getHeaders", "getCharset", "getType", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getRetry", "getBody", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;I)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final /* data */ class UrlOption {

        @Nullable
        private final Object body;

        @Nullable
        private final String charset;

        @Nullable
        private final Object headers;

        @Nullable
        private final String js;

        @Nullable
        private final String method;
        private final int retry;

        @Nullable
        private final String type;

        @Nullable
        private final Object webView;

        public UrlOption(@Nullable String str, @Nullable String str2, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable String str3, @Nullable String str4, int i2) {
            this.method = str;
            this.charset = str2;
            this.webView = obj;
            this.headers = obj2;
            this.body = obj3;
            this.type = str3;
            this.js = str4;
            this.retry = i2;
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMethod() {
            return this.method;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCharset() {
            return this.charset;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Object getWebView() {
            return this.webView;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Object getHeaders() {
            return this.headers;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Object getBody() {
            return this.body;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getJs() {
            return this.js;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getRetry() {
            return this.retry;
        }

        @NotNull
        public final UrlOption copy(@Nullable String method, @Nullable String charset, @Nullable Object webView, @Nullable Object headers, @Nullable Object body, @Nullable String type, @Nullable String js, int retry) {
            return new UrlOption(method, charset, webView, headers, body, type, js, retry);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UrlOption)) {
                return false;
            }
            UrlOption urlOption = (UrlOption) other;
            return f.c0.c.j.a(this.method, urlOption.method) && f.c0.c.j.a(this.charset, urlOption.charset) && f.c0.c.j.a(this.webView, urlOption.webView) && f.c0.c.j.a(this.headers, urlOption.headers) && f.c0.c.j.a(this.body, urlOption.body) && f.c0.c.j.a(this.type, urlOption.type) && f.c0.c.j.a(this.js, urlOption.js) && this.retry == urlOption.retry;
        }

        @Nullable
        public final Object getBody() {
            return this.body;
        }

        @Nullable
        public final String getCharset() {
            return this.charset;
        }

        @Nullable
        public final Object getHeaders() {
            return this.headers;
        }

        @Nullable
        public final String getJs() {
            return this.js;
        }

        @Nullable
        public final String getMethod() {
            return this.method;
        }

        public final int getRetry() {
            return this.retry;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Object getWebView() {
            return this.webView;
        }

        public int hashCode() {
            String str = this.method;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.charset;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Object obj = this.webView;
            int iHashCode3 = (iHashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.headers;
            int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
            Object obj3 = this.body;
            int iHashCode5 = (iHashCode4 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
            String str3 = this.type;
            int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.js;
            return ((iHashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.retry;
        }

        @NotNull
        public String toString() {
            StringBuilder sbR = a.r("UrlOption(method=");
            sbR.append((Object) this.method);
            sbR.append(", charset=");
            sbR.append((Object) this.charset);
            sbR.append(", webView=");
            sbR.append(this.webView);
            sbR.append(", headers=");
            sbR.append(this.headers);
            sbR.append(", body=");
            sbR.append(this.body);
            sbR.append(", type=");
            sbR.append((Object) this.type);
            sbR.append(", js=");
            sbR.append((Object) this.js);
            sbR.append(", retry=");
            return a.n(sbR, this.retry, ')');
        }

        public /* synthetic */ UrlOption(String str, String str2, Object obj, Object obj2, Object obj3, String str3, String str4, int i2, int i3, f fVar) {
            this(str, str2, obj, obj2, obj3, str3, str4, (i3 & 128) != 0 ? 0 : i2);
        }
    }

    public /* synthetic */ AnalyzeUrl(String str, String str2, Integer num, String str3, Integer num2, String str4, boolean z, BaseBook baseBook, BookChapter bookChapter, RuleDataInterface ruleDataInterface, Map map, int i2, f fVar) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : num2, (i2 & 32) != 0 ? "" : str4, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? null : baseBook, (i2 & 256) != 0 ? null : bookChapter, (i2 & 512) != 0 ? null : ruleDataInterface, (i2 & 1024) == 0 ? map : null);
    }
}
