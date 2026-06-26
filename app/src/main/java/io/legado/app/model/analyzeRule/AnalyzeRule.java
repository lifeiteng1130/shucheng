package io.legado.app.model.analyzeRule;

import android.text.TextUtils;
import androidx.annotation.Keep;
import c.b.a.m.f;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.ai;
import e.a.a.c.c;
import e.a.a.d.i;
import e.a.a.d.v.l;
import e.a.a.h.b0;
import e.a.a.h.n;
import f.c0.b.p;
import f.c0.c.j;
import f.h;
import f.h0.k;
import f.v;
import f.z.d;
import f.z.i.a;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.entities.BaseBook;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.help.JsExtensions;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.SimpleBindings;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Connection;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: AnalyzeRule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 x2\u00020\u0001:\u0003xyzB\u000f\u0012\u0006\u0010d\u001a\u00020c¢\u0006\u0004\bv\u0010wJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0014j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\n\u0010\u001b\u001a\u00060\u001aR\u00020\u0000H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010 \u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010$\u001a\u00020\u000e¢\u0006\u0004\b&\u0010'J+\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010*2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b+\u0010,J3\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010*2\u0010\u0010-\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u00000*2\b\b\u0002\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b+\u0010.J/\u00100\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010)\u001a\u00020(2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b0\u00101J7\u00100\u001a\u00020\u000e2\u0010\u0010-\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u00000*2\b\b\u0002\u0010)\u001a\u00020(2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b0\u00102J\u0017\u00103\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b3\u00104J\u001b\u00105\u001a\b\u0012\u0004\u0012\u00020\u00020*2\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b5\u00106J+\u00109\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u00000*2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\u001d\u0010<\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e¢\u0006\u0004\b<\u0010=J\u0015\u0010>\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e¢\u0006\u0004\b>\u0010?J!\u0010A\u001a\u0004\u0018\u00010\u00022\u0006\u0010@\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bA\u0010BJ\u0019\u0010D\u001a\u0004\u0018\u00010\u000e2\u0006\u0010C\u001a\u00020\u000eH\u0016¢\u0006\u0004\bD\u0010?J\u0019\u0010F\u001a\u0004\u0018\u00010\u000e2\b\u0010E\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\bF\u0010?R\u0016\u0010G\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010L\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\b&\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010HR$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010[\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0018\u0010a\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0019\u0010d\u001a\u00020c8\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR$\u0010i\u001a\u0004\u0018\u00010h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0016\u0010o\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010HR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010p\u001a\u0004\bq\u0010r\"\u0004\b \u0010sR$\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\\\u001a\u0004\bt\u0010^\"\u0004\b\"\u0010`R\u0016\u0010u\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010H¨\u0006{"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeRule;", "Lio/legado/app/help/JsExtensions;", "", "o", "Lio/legado/app/model/analyzeRule/AnalyzeByXPath;", "getAnalyzeByXPath", "(Ljava/lang/Object;)Lio/legado/app/model/analyzeRule/AnalyzeByXPath;", "Lio/legado/app/model/analyzeRule/AnalyzeByJSoup;", "getAnalyzeByJSoup", "(Ljava/lang/Object;)Lio/legado/app/model/analyzeRule/AnalyzeByJSoup;", "Lio/legado/app/model/analyzeRule/AnalyzeByJSonPath;", "getAnalyzeByJSonPath", "(Ljava/lang/Object;)Lio/legado/app/model/analyzeRule/AnalyzeByJSonPath;", "", "", "map", "Lf/v;", "putRule", "(Ljava/util/Map;)V", "ruleStr", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "putMap", "splitPutRule", "(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;", "result", "Lio/legado/app/model/analyzeRule/AnalyzeRule$SourceRule;", "rule", "replaceRegex", "(Ljava/lang/String;Lio/legado/app/model/analyzeRule/AnalyzeRule$SourceRule;)Ljava/lang/String;", "content", "baseUrl", "setContent", "(Ljava/lang/Object;Ljava/lang/String;)Lio/legado/app/model/analyzeRule/AnalyzeRule;", "setBaseUrl", "(Ljava/lang/String;)Lio/legado/app/model/analyzeRule/AnalyzeRule;", "url", "Ljava/net/URL;", "setRedirectUrl", "(Ljava/lang/String;)Ljava/net/URL;", "", "isUrl", "", "getStringList", "(Ljava/lang/String;Z)Ljava/util/List;", "ruleList", "(Ljava/util/List;Z)Ljava/util/List;", ES6Iterator.VALUE_PROPERTY, "getString", "(Ljava/lang/String;ZLjava/lang/String;)Ljava/lang/String;", "(Ljava/util/List;ZLjava/lang/String;)Ljava/lang/String;", "getElement", "(Ljava/lang/String;)Ljava/lang/Object;", "getElements", "(Ljava/lang/String;)Ljava/util/List;", "Lio/legado/app/model/analyzeRule/AnalyzeRule$Mode;", "mode", "splitSourceRule", "(Ljava/lang/String;Lio/legado/app/model/analyzeRule/AnalyzeRule$Mode;)Ljava/util/List;", "key", "put", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "get", "(Ljava/lang/String;)Ljava/lang/String;", "jsStr", "evalJS", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "urlStr", "ajax", ai.az, "toNumChapter", "isJSON", "Z", "isRegex", "analyzeByJSoup", "Lio/legado/app/model/analyzeRule/AnalyzeByJSoup;", "redirectUrl", "Ljava/net/URL;", "getRedirectUrl", "()Ljava/net/URL;", "(Ljava/net/URL;)V", "analyzeByJSonPath", "Lio/legado/app/model/analyzeRule/AnalyzeByJSonPath;", "objectChangedXP", "Lio/legado/app/data/entities/BaseBook;", "book", "Lio/legado/app/data/entities/BaseBook;", "getBook", "()Lio/legado/app/data/entities/BaseBook;", "setBook", "(Lio/legado/app/data/entities/BaseBook;)V", "nextChapterUrl", "Ljava/lang/String;", "getNextChapterUrl", "()Ljava/lang/String;", "setNextChapterUrl", "(Ljava/lang/String;)V", "analyzeByXPath", "Lio/legado/app/model/analyzeRule/AnalyzeByXPath;", "Lio/legado/app/model/analyzeRule/RuleDataInterface;", "ruleData", "Lio/legado/app/model/analyzeRule/RuleDataInterface;", "getRuleData", "()Lio/legado/app/model/analyzeRule/RuleDataInterface;", "Lio/legado/app/data/entities/BookChapter;", "chapter", "Lio/legado/app/data/entities/BookChapter;", "getChapter", "()Lio/legado/app/data/entities/BookChapter;", "setChapter", "(Lio/legado/app/data/entities/BookChapter;)V", "objectChangedJS", "Ljava/lang/Object;", "getContent", "()Ljava/lang/Object;", "(Ljava/lang/Object;)V", "getBaseUrl", "objectChangedJP", "<init>", "(Lio/legado/app/model/analyzeRule/RuleDataInterface;)V", "Companion", "Mode", "SourceRule", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class AnalyzeRule implements JsExtensions {

    @Nullable
    private AnalyzeByJSonPath analyzeByJSonPath;

    @Nullable
    private AnalyzeByJSoup analyzeByJSoup;

    @Nullable
    private AnalyzeByXPath analyzeByXPath;

    @Nullable
    private String baseUrl;

    @Nullable
    private BaseBook book;

    @Nullable
    private BookChapter chapter;

    @Nullable
    private Object content;
    private boolean isJSON;
    private boolean isRegex;

    @Nullable
    private String nextChapterUrl;
    private boolean objectChangedJP;
    private boolean objectChangedJS;
    private boolean objectChangedXP;

    @Nullable
    private URL redirectUrl;

    @NotNull
    private final RuleDataInterface ruleData;
    private static final Pattern putPattern = Pattern.compile("@put:(\\{[^}]+?\\})", 2);
    private static final Pattern getPattern = Pattern.compile("@get:\\{([^}]+?)\\}", 2);
    private static final Pattern evalPattern = Pattern.compile("@get:\\{[^}]+?\\}|\\{\\{[\\w\\W]*?\\}\\}", 2);
    private static final Pattern regexPattern = Pattern.compile("\\$\\d{1,2}");
    private static final Pattern titleNumPattern = Pattern.compile("(第)(.+?)(章)");

    /* JADX INFO: compiled from: AnalyzeRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeRule$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "XPath", "Json", "Default", "Js", "Regex", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public enum Mode {
        XPath,
        Json,
        Default,
        Js,
        Regex;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Mode[] valuesCustom() {
            Mode[] modeArrValuesCustom = values();
            return (Mode[]) Arrays.copyOf(modeArrValuesCustom, modeArrValuesCustom.length);
        }
    }

    /* JADX INFO: compiled from: AnalyzeRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Mode.valuesCustom();
            int[] iArr = new int[5];
            iArr[Mode.Js.ordinal()] = 1;
            iArr[Mode.Json.ordinal()] = 2;
            iArr[Mode.XPath.ordinal()] = 3;
            iArr[Mode.Default.ordinal()] = 4;
            iArr[Mode.Regex.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.analyzeRule.AnalyzeRule$ajax$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnalyzeRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "", "<anonymous>", "(Lg/b/a0;)Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.analyzeRule.AnalyzeRule$ajax$1", f = "AnalyzeRule.kt", i = {}, l = {665}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends g implements p<a0, d<? super String>, Object> {
        public final /* synthetic */ String $urlStr;
        public int label;
        public final /* synthetic */ AnalyzeRule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, AnalyzeRule analyzeRule, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$urlStr = str;
            this.this$0 = analyzeRule;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$urlStr, this.this$0, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super String> dVar) {
            return ((AnonymousClass1) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Object objM11constructorimpl;
            Object strResponse$default;
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    f.E5(obj);
                    String str = this.$urlStr;
                    AnalyzeUrl analyzeUrl = new AnalyzeUrl(str, null, null, null, null, null, false, this.this$0.getBook(), null, null, null, 1918, null);
                    this.label = 1;
                    strResponse$default = AnalyzeUrl.getStrResponse$default(analyzeUrl, str, null, null, this, 6, null);
                    if (strResponse$default == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f.E5(obj);
                    strResponse$default = obj;
                }
                objM11constructorimpl = h.m11constructorimpl(((l) strResponse$default).f5588b);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(f.m1(th));
            }
            Throwable thM14exceptionOrNullimpl = h.m14exceptionOrNullimpl(objM11constructorimpl);
            if (thM14exceptionOrNullimpl != null) {
                thM14exceptionOrNullimpl.printStackTrace();
            }
            Throwable thM14exceptionOrNullimpl2 = h.m14exceptionOrNullimpl(objM11constructorimpl);
            return thM14exceptionOrNullimpl2 == null ? objM11constructorimpl : f.C2(thM14exceptionOrNullimpl2);
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.analyzeRule.AnalyzeRule$evalJS$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnalyzeRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lg/b/a0;", "", "kotlin.jvm.PlatformType", "<anonymous>", "(Lg/b/a0;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.analyzeRule.AnalyzeRule$evalJS$1", f = "AnalyzeRule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03351 extends g implements p<a0, d<? super Object>, Object> {
        public final /* synthetic */ SimpleBindings $bindings;
        public final /* synthetic */ String $jsStr;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03351(String str, SimpleBindings simpleBindings, d<? super C03351> dVar) {
            super(2, dVar);
            this.$jsStr = str;
            this.$bindings = simpleBindings;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C03351(this.$jsStr, this.$bindings, dVar);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @Nullable d<Object> dVar) {
            return ((C03351) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, d<? super Object> dVar) {
            return invoke2(a0Var, (d<Object>) dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            c cVar = c.a;
            return c.c().eval(this.$jsStr, this.$bindings);
        }
    }

    public AnalyzeRule(@NotNull RuleDataInterface ruleDataInterface) {
        j.e(ruleDataInterface, "ruleData");
        this.ruleData = ruleDataInterface;
        if (ruleDataInterface instanceof BaseBook) {
            this.book = (BaseBook) ruleDataInterface;
        }
    }

    private final AnalyzeByJSonPath getAnalyzeByJSonPath(Object o) {
        if (!j.a(o, this.content)) {
            return new AnalyzeByJSonPath(o);
        }
        if (this.analyzeByJSonPath == null || this.objectChangedJP) {
            Object obj = this.content;
            j.c(obj);
            this.analyzeByJSonPath = new AnalyzeByJSonPath(obj);
            this.objectChangedJP = false;
        }
        AnalyzeByJSonPath analyzeByJSonPath = this.analyzeByJSonPath;
        j.c(analyzeByJSonPath);
        return analyzeByJSonPath;
    }

    private final AnalyzeByJSoup getAnalyzeByJSoup(Object o) {
        if (!j.a(o, this.content)) {
            return new AnalyzeByJSoup(o);
        }
        if (this.analyzeByJSoup == null || this.objectChangedJS) {
            Object obj = this.content;
            j.c(obj);
            this.analyzeByJSoup = new AnalyzeByJSoup(obj);
            this.objectChangedJS = false;
        }
        AnalyzeByJSoup analyzeByJSoup = this.analyzeByJSoup;
        j.c(analyzeByJSoup);
        return analyzeByJSoup;
    }

    private final AnalyzeByXPath getAnalyzeByXPath(Object o) {
        if (!j.a(o, this.content)) {
            return new AnalyzeByXPath(o);
        }
        if (this.analyzeByXPath == null || this.objectChangedXP) {
            Object obj = this.content;
            j.c(obj);
            this.analyzeByXPath = new AnalyzeByXPath(obj);
            this.objectChangedXP = false;
        }
        AnalyzeByXPath analyzeByXPath = this.analyzeByXPath;
        j.c(analyzeByXPath);
        return analyzeByXPath;
    }

    public static /* synthetic */ String getString$default(AnalyzeRule analyzeRule, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return analyzeRule.getString(str, z, str2);
    }

    public static /* synthetic */ List getStringList$default(AnalyzeRule analyzeRule, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return analyzeRule.getStringList(str, z);
    }

    private final void putRule(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            put(entry.getKey(), getString$default(this, entry.getValue(), false, (String) null, 6, (Object) null));
        }
    }

    private final String replaceRegex(String result, SourceRule rule) {
        if (!(rule.getReplaceRegex().length() > 0)) {
            return result;
        }
        if (!rule.getReplaceFirst()) {
            return new f.h0.g(rule.getReplaceRegex()).replace(result, rule.getReplacement());
        }
        Matcher matcher = Pattern.compile(rule.getReplaceRegex()).matcher(result);
        if (!matcher.find()) {
            return "";
        }
        String strGroup = matcher.group(0);
        j.c(strGroup);
        return new f.h0.g(rule.getReplaceRegex()).replaceFirst(strGroup, rule.getReplacement());
    }

    public static /* synthetic */ AnalyzeRule setContent$default(AnalyzeRule analyzeRule, Object obj, String str, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return analyzeRule.setContent(obj, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String splitPutRule(String ruleStr, HashMap<String, String> putMap) {
        Object objM11constructorimpl;
        Matcher matcher = putPattern.matcher(ruleStr);
        while (matcher.find()) {
            String strGroup = matcher.group();
            j.d(strGroup, "putMatcher.group()");
            ruleStr = k.C(ruleStr, strGroup, "", false, 4);
            Gson gsonA = n.a();
            String strGroup2 = matcher.group(1);
            try {
                Type type = new TypeToken<Map<String, ? extends String>>() { // from class: io.legado.app.model.analyzeRule.AnalyzeRule$splitPutRule$$inlined$fromJsonObject$1
                }.getType();
                j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(strGroup2, type);
                if (!(objFromJson instanceof Map)) {
                    objFromJson = null;
                }
                objM11constructorimpl = h.m11constructorimpl((Map) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(f.m1(th));
            }
            Map<? extends String, ? extends String> map = (Map) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
            if (map != null) {
                putMap.putAll(map);
            }
        }
        return ruleStr;
    }

    public static /* synthetic */ List splitSourceRule$default(AnalyzeRule analyzeRule, String str, Mode mode, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            mode = Mode.Default;
        }
        return analyzeRule.splitSourceRule(str, mode);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesBase64DecodeToByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.W(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesBase64DecodeToString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.X(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesDecodeToByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.Y(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesDecodeToString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.Z(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesEncodeToBase64ByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.a0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesEncodeToBase64String(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.b0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesEncodeToByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.c0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesEncodeToString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.d0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String ajax(@NotNull String urlStr) {
        j.e(urlStr, "urlStr");
        return (String) f.T4(null, new AnonymousClass1(urlStr, this, null), 1, null);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public l[] ajaxAll(@NotNull String[] strArr) {
        return f.f0(this, strArr);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String base64Decode(@NotNull String str) {
        return f.x0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] base64DecodeToByteArray(@Nullable String str) {
        return f.z0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String base64Encode(@NotNull String str) {
        return f.B0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public Object connect(@NotNull String str) {
        return f.X0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String downloadFile(@NotNull String str, @NotNull String str2) {
        return f.v1(this, str, str2);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String encodeURI(@NotNull String str) {
        return f.z1(this, str);
    }

    @Nullable
    public final Object evalJS(@NotNull String jsStr, @Nullable Object result) {
        j.e(jsStr, "jsStr");
        SimpleBindings simpleBindings = new SimpleBindings();
        simpleBindings.put(LogType.JAVA_TYPE, this);
        simpleBindings.put("cookie", e.a.a.d.v.f.a);
        simpleBindings.put("cache", i.a);
        simpleBindings.put("book", this.book);
        simpleBindings.put("result", result);
        simpleBindings.put("baseUrl", this.baseUrl);
        simpleBindings.put("chapter", this.chapter);
        BookChapter bookChapter = this.chapter;
        simpleBindings.put("title", bookChapter == null ? null : bookChapter.getTitle());
        simpleBindings.put("src", this.content);
        simpleBindings.put("nextChapterUrl", this.nextChapterUrl);
        return f.T4(null, new C03351(jsStr, simpleBindings, null), 1, null);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public Connection.Response get(@NotNull String str, @NotNull Map<String, String> map) {
        return f.K1(this, str, map);
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @Nullable
    public final BaseBook getBook() {
        return this.book;
    }

    @Nullable
    public final BookChapter getChapter() {
        return this.chapter;
    }

    @Nullable
    public final Object getContent() {
        return this.content;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String getCookie(@NotNull String str, @Nullable String str2) {
        return f.f2(this, str, str2);
    }

    @Nullable
    public final Object getElement(@NotNull String ruleStr) {
        j.e(ruleStr, "ruleStr");
        if (TextUtils.isEmpty(ruleStr)) {
            return null;
        }
        List<SourceRule> listSplitSourceRule$default = splitSourceRule$default(this, ruleStr, null, 2, null);
        Object obj = this.content;
        if (obj != null) {
            elements$app_adsRelease = listSplitSourceRule$default.isEmpty() ^ true ? obj : null;
            for (SourceRule sourceRule : listSplitSourceRule$default) {
                putRule(sourceRule.getPutMap$app_adsRelease());
                sourceRule.makeUpRule(elements$app_adsRelease);
                if (elements$app_adsRelease != null) {
                    int iOrdinal = sourceRule.getMode().ordinal();
                    elements$app_adsRelease = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 3 ? iOrdinal != 4 ? getAnalyzeByJSoup(elements$app_adsRelease).getElements$app_adsRelease(sourceRule.getRule()) : AnalyzeByRegex.getElement$default(AnalyzeByRegex.INSTANCE, String.valueOf(elements$app_adsRelease), f.n5(sourceRule.getRule(), "&&"), 0, 4, null) : evalJS(sourceRule.getRule(), elements$app_adsRelease) : getAnalyzeByJSonPath(elements$app_adsRelease).getObject$app_adsRelease(sourceRule.getRule()) : getAnalyzeByXPath(elements$app_adsRelease).getElements$app_adsRelease(sourceRule.getRule());
                    if (sourceRule.getReplaceRegex().length() > 0) {
                        elements$app_adsRelease = replaceRegex(String.valueOf(elements$app_adsRelease), sourceRule);
                    }
                }
            }
        }
        return elements$app_adsRelease;
    }

    @NotNull
    public final List<Object> getElements(@NotNull String ruleStr) {
        j.e(ruleStr, "ruleStr");
        List<SourceRule> listSplitSourceRule$default = splitSourceRule$default(this, ruleStr, null, 2, null);
        Object obj = this.content;
        if (obj != null) {
            elements$app_adsRelease = listSplitSourceRule$default.isEmpty() ^ true ? obj : null;
            for (SourceRule sourceRule : listSplitSourceRule$default) {
                putRule(sourceRule.getPutMap$app_adsRelease());
                if (elements$app_adsRelease != null) {
                    int iOrdinal = sourceRule.getMode().ordinal();
                    elements$app_adsRelease = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 3 ? iOrdinal != 4 ? getAnalyzeByJSoup(elements$app_adsRelease).getElements$app_adsRelease(sourceRule.getRule()) : AnalyzeByRegex.getElements$default(AnalyzeByRegex.INSTANCE, String.valueOf(elements$app_adsRelease), f.n5(sourceRule.getRule(), "&&"), 0, 4, null) : evalJS(sourceRule.getRule(), elements$app_adsRelease) : getAnalyzeByJSonPath(elements$app_adsRelease).getList$app_adsRelease(sourceRule.getRule()) : getAnalyzeByXPath(elements$app_adsRelease).getElements$app_adsRelease(sourceRule.getRule());
                    if (sourceRule.getReplaceRegex().length() > 0) {
                        elements$app_adsRelease = replaceRegex(String.valueOf(elements$app_adsRelease), sourceRule);
                    }
                }
            }
        }
        return elements$app_adsRelease == null ? new ArrayList() : (List) elements$app_adsRelease;
    }

    @Nullable
    public final String getNextChapterUrl() {
        return this.nextChapterUrl;
    }

    @Nullable
    public final URL getRedirectUrl() {
        return this.redirectUrl;
    }

    @NotNull
    public final RuleDataInterface getRuleData() {
        return this.ruleData;
    }

    @JvmOverloads
    @NotNull
    public final String getString(@Nullable String str) {
        return getString$default(this, str, false, (String) null, 6, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public final String getString(@Nullable String str, boolean z) {
        return getString$default(this, str, z, (String) null, 4, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public final String getString(@Nullable String ruleStr, boolean isUrl, @Nullable String value) {
        return TextUtils.isEmpty(ruleStr) ? "" : getString(splitSourceRule$default(this, ruleStr, null, 2, null), isUrl, value);
    }

    @JvmOverloads
    @NotNull
    public final String getString(@NotNull List<SourceRule> list) {
        j.e(list, "ruleList");
        return getString$default(this, (List) list, false, (String) null, 6, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public final String getString(@NotNull List<SourceRule> list, boolean z) {
        j.e(list, "ruleList");
        return getString$default(this, list, z, (String) null, 4, (Object) null);
    }

    @JvmOverloads
    @Nullable
    public final List<String> getStringList(@Nullable String str) {
        return getStringList$default(this, str, false, 2, (Object) null);
    }

    @JvmOverloads
    @Nullable
    public final List<String> getStringList(@Nullable String rule, boolean isUrl) {
        if (rule == null || rule.length() == 0) {
            return null;
        }
        return getStringList(splitSourceRule$default(this, rule, null, 2, null), isUrl);
    }

    @JvmOverloads
    @Nullable
    public final List<String> getStringList(@NotNull List<SourceRule> list) {
        j.e(list, "ruleList");
        return getStringList$default(this, (List) list, false, 2, (Object) null);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String getTxtInFolder(@NotNull String str) {
        return f.a3(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String htmlFormat(@NotNull String str) {
        return f.i3(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String log(@NotNull String str) {
        f.Q3(this, str);
        return str;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String md5Encode(@NotNull String str) {
        return f.V3(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String md5Encode16(@NotNull String str) {
        return f.W3(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public Connection.Response post(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        return f.l4(this, str, str2, map);
    }

    @NotNull
    public final String put(@NotNull String key, @NotNull String value) {
        v vVar;
        j.e(key, "key");
        j.e(value, ES6Iterator.VALUE_PROPERTY);
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
        } else {
            vVar2 = vVar;
        }
        if (vVar2 == null) {
            this.ruleData.putVariable(key, value);
        }
        return value;
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public QueryTTF queryBase64TTF(@Nullable String str) {
        return f.s4(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public QueryTTF queryTTF(@Nullable String str) {
        return f.t4(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public byte[] readFile(@NotNull String str) {
        return f.x4(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String readTxtFile(@NotNull String str) {
        return f.D4(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String replaceFont(@NotNull String str, @Nullable QueryTTF queryTTF, @Nullable QueryTTF queryTTF2) {
        return f.I4(this, str, queryTTF, queryTTF2);
    }

    /* JADX INFO: renamed from: setBaseUrl, reason: collision with other method in class */
    public final void m22setBaseUrl(@Nullable String str) {
        this.baseUrl = str;
    }

    public final void setBook(@Nullable BaseBook baseBook) {
        this.book = baseBook;
    }

    public final void setChapter(@Nullable BookChapter bookChapter) {
        this.chapter = bookChapter;
    }

    @JvmOverloads
    @NotNull
    public final AnalyzeRule setContent(@Nullable Object obj) {
        return setContent$default(this, obj, null, 2, null);
    }

    /* JADX INFO: renamed from: setContent, reason: collision with other method in class */
    public final void m23setContent(@Nullable Object obj) {
        this.content = obj;
    }

    public final void setNextChapterUrl(@Nullable String str) {
        this.nextChapterUrl = str;
    }

    public final void setRedirectUrl(@Nullable URL url) {
        this.redirectUrl = url;
    }

    @NotNull
    public final List<SourceRule> splitSourceRule(@Nullable String ruleStr, @NotNull Mode mode) {
        j.e(mode, "mode");
        ArrayList arrayList = new ArrayList();
        if (ruleStr == null || ruleStr.length() == 0) {
            return arrayList;
        }
        if (k.K(ruleStr, "@@", false, 2)) {
            Objects.requireNonNull(ruleStr, "null cannot be cast to non-null type java.lang.String");
            ruleStr = ruleStr.substring(2);
            j.d(ruleStr, "(this as java.lang.String).substring(startIndex)");
        } else if (k.H(ruleStr, "@XPath:", true)) {
            mode = Mode.XPath;
            ruleStr = ruleStr.substring(7);
            j.d(ruleStr, "(this as java.lang.String).substring(startIndex)");
        } else if (k.H(ruleStr, "@Json:", true)) {
            mode = Mode.Json;
            ruleStr = ruleStr.substring(6);
            j.d(ruleStr, "(this as java.lang.String).substring(startIndex)");
        } else if (k.K(ruleStr, ":", false, 2)) {
            mode = Mode.Regex;
            this.isRegex = true;
            ruleStr = ruleStr.substring(1);
            j.d(ruleStr, "(this as java.lang.String).substring(startIndex)");
        } else if (this.isRegex) {
            mode = Mode.Regex;
        } else if (this.isJSON) {
            mode = Mode.Json;
        }
        e.a.a.c.d dVar = e.a.a.c.d.a;
        Matcher matcher = e.a.a.c.d.f5508b.matcher(ruleStr);
        int iEnd = 0;
        while (matcher.find()) {
            if (matcher.start() > iEnd) {
                String strSubstring = ruleStr.substring(iEnd, matcher.start());
                j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int length = strSubstring.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length) {
                    boolean z2 = j.g(strSubstring.charAt(!z ? i2 : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i2++;
                    } else {
                        z = true;
                    }
                }
                String string = strSubstring.subSequence(i2, length + 1).toString();
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(new SourceRule(this, string, mode));
                }
            }
            String strGroup = matcher.group();
            j.d(strGroup, "jsMatcher.group()");
            arrayList.add(new SourceRule(this, strGroup, Mode.Js));
            iEnd = matcher.end();
        }
        if (ruleStr.length() > iEnd) {
            String strSubstring2 = ruleStr.substring(iEnd);
            j.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            int length2 = strSubstring2.length() - 1;
            int i3 = 0;
            boolean z3 = false;
            while (i3 <= length2) {
                boolean z4 = j.g(strSubstring2.charAt(!z3 ? i3 : length2), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    }
                    length2--;
                } else if (z4) {
                    i3++;
                } else {
                    z3 = true;
                }
            }
            String string2 = strSubstring2.subSequence(i3, length2 + 1).toString();
            if (!TextUtils.isEmpty(string2)) {
                arrayList.add(new SourceRule(this, string2, mode));
            }
        }
        return arrayList;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String timeFormat(long j2) {
        return f.F5(this, j2);
    }

    @Nullable
    public final String toNumChapter(@Nullable String s) {
        if (s == null) {
            return null;
        }
        Matcher matcher = titleNumPattern.matcher(s);
        if (!matcher.find()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) matcher.group(1));
        sb.append(b0.a.b(matcher.group(2)));
        sb.append((Object) matcher.group(3));
        return sb.toString();
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String unzipFile(@NotNull String str) {
        return f.U5(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String utf8ToGbk(@NotNull String str) {
        return f.a6(this, str);
    }

    public static /* synthetic */ String getString$default(AnalyzeRule analyzeRule, List list, boolean z, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        return analyzeRule.getString((List<SourceRule>) list, z, str);
    }

    public static /* synthetic */ List getStringList$default(AnalyzeRule analyzeRule, List list, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return analyzeRule.getStringList((List<SourceRule>) list, z);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String base64Decode(@NotNull String str, int i2) {
        return f.y0(this, str, i2);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] base64DecodeToByteArray(@Nullable String str, int i2) {
        return f.A0(this, str, i2);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String base64Encode(@NotNull String str, int i2) {
        return f.C0(this, str, i2);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String encodeURI(@NotNull String str, @NotNull String str2) {
        return f.A1(this, str, str2);
    }

    @NotNull
    public final String get(@NotNull String key) {
        BookChapter bookChapter;
        HashMap<String, String> variableMap;
        HashMap<String, String> variableMap2;
        j.e(key, "key");
        if (j.a(key, "bookName")) {
            BaseBook baseBook = this.book;
            if (baseBook != null) {
                return baseBook.getName();
            }
        } else if (j.a(key, "title") && (bookChapter = this.chapter) != null) {
            return bookChapter.getTitle();
        }
        BookChapter bookChapter2 = this.chapter;
        String str = null;
        String str2 = (bookChapter2 == null || (variableMap = bookChapter2.getVariableMap()) == null) ? null : variableMap.get(key);
        if (str2 == null) {
            BaseBook baseBook2 = this.book;
            if (baseBook2 != null && (variableMap2 = baseBook2.getVariableMap()) != null) {
                str = variableMap2.get(key);
            }
            str2 = str == null ? this.ruleData.getVariableMap().get(key) : str;
        }
        return str2 == null ? "" : str2;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String readTxtFile(@NotNull String str, @NotNull String str2) {
        return f.E4(this, str, str2);
    }

    @NotNull
    public final AnalyzeRule setBaseUrl(@Nullable String baseUrl) {
        if (baseUrl != null) {
            m22setBaseUrl(baseUrl);
        }
        return this;
    }

    @JvmOverloads
    @NotNull
    public final AnalyzeRule setContent(@Nullable Object content, @Nullable String baseUrl) {
        if (content == null) {
            throw new AssertionError("Content cannot be null");
        }
        this.content = content;
        setBaseUrl(baseUrl);
        this.isJSON = f.z3(content.toString());
        this.objectChangedXP = true;
        this.objectChangedJS = true;
        this.objectChangedJP = true;
        return this;
    }

    @Nullable
    public final URL setRedirectUrl(@NotNull String url) {
        j.e(url, "url");
        try {
            setRedirectUrl(new URL(AnalyzeUrl.INSTANCE.getSplitUrlRegex().split(url, 1).get(0)));
            h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            h.m11constructorimpl(f.m1(th));
        }
        return this.redirectUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x003b A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v5, types: [io.legado.app.model.analyzeRule.AnalyzeRule$SourceRule] */
    /* JADX WARN: Type inference failed for: r4v0, types: [io.legado.app.model.analyzeRule.AnalyzeRule] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.String] */
    @kotlin.jvm.JvmOverloads
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getString(@org.jetbrains.annotations.NotNull java.util.List<io.legado.app.model.analyzeRule.AnalyzeRule.SourceRule> r5, boolean r6, @org.jetbrains.annotations.Nullable java.lang.String r7) {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.analyzeRule.AnalyzeRule.getString(java.util.List, boolean, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00f5  */
    @kotlin.jvm.JvmOverloads
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.String> getStringList(@org.jetbrains.annotations.NotNull java.util.List<io.legado.app.model.analyzeRule.AnalyzeRule.SourceRule> r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.analyzeRule.AnalyzeRule.getStringList(java.util.List, boolean):java.util.List");
    }

    /* JADX INFO: compiled from: AnalyzeRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u00104\u001a\u00020-¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000b\u0010\fR8\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\rj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u000e8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0006R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0006R\u0016\u0010\u001f\u001a\u00020\u00198\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00198\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010 R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0016\u0010#\u001a\u00020\u00198\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010 R\"\u0010$\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0006R\"\u0010'\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00067"}, d2 = {"Lio/legado/app/model/analyzeRule/AnalyzeRule$SourceRule;", "", "", "ruleStr", "Lf/v;", "splitRegex", "(Ljava/lang/String;)V", "", "isRule", "(Ljava/lang/String;)Z", "result", "makeUpRule", "(Ljava/lang/Object;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "putMap", "Ljava/util/HashMap;", "getPutMap$app_adsRelease", "()Ljava/util/HashMap;", "replaceRegex", "Ljava/lang/String;", "getReplaceRegex$app_adsRelease", "()Ljava/lang/String;", "setReplaceRegex$app_adsRelease", "Ljava/util/ArrayList;", "", "ruleType", "Ljava/util/ArrayList;", "rule", "getRule$app_adsRelease", "setRule$app_adsRelease", "jsRuleType", OptRuntime.GeneratorState.resumptionPoint_TYPE, "defaultRuleType", "ruleParam", "getRuleType", "replacement", "getReplacement$app_adsRelease", "setReplacement$app_adsRelease", "replaceFirst", "Z", "getReplaceFirst$app_adsRelease", "()Z", "setReplaceFirst$app_adsRelease", "(Z)V", "Lio/legado/app/model/analyzeRule/AnalyzeRule$Mode;", "mode", "Lio/legado/app/model/analyzeRule/AnalyzeRule$Mode;", "getMode$app_adsRelease", "()Lio/legado/app/model/analyzeRule/AnalyzeRule$Mode;", "setMode$app_adsRelease", "(Lio/legado/app/model/analyzeRule/AnalyzeRule$Mode;)V", "mainMode", "<init>", "(Lio/legado/app/model/analyzeRule/AnalyzeRule;Ljava/lang/String;Lio/legado/app/model/analyzeRule/AnalyzeRule$Mode;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public final class SourceRule {
        private final int defaultRuleType;
        private final int getRuleType;
        private final int jsRuleType;

        @NotNull
        private Mode mode;

        @NotNull
        private final HashMap<String, String> putMap;
        private boolean replaceFirst;

        @NotNull
        private String replaceRegex;

        @NotNull
        private String replacement;

        @NotNull
        private String rule;

        @NotNull
        private final ArrayList<String> ruleParam;

        @NotNull
        private final ArrayList<Integer> ruleType;

        public SourceRule(@NotNull AnalyzeRule analyzeRule, @NotNull String str, Mode mode) {
            Mode mode2;
            Mode mode3;
            String strSubstring;
            j.e(analyzeRule, "this$0");
            j.e(str, "ruleStr");
            j.e(mode, "mainMode");
            AnalyzeRule.this = analyzeRule;
            this.replaceRegex = "";
            this.replacement = "";
            HashMap<String, String> map = new HashMap<>();
            this.putMap = map;
            this.ruleParam = new ArrayList<>();
            this.ruleType = new ArrayList<>();
            this.getRuleType = -2;
            this.jsRuleType = -1;
            this.mode = mode;
            if (mode == Mode.Js) {
                if (k.K(str, "<js>", false, 2)) {
                    strSubstring = str.substring(4, k.u(str, "<", 0, false, 6));
                    j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    strSubstring = str.substring(4);
                    j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                }
                this.rule = strSubstring;
            } else if (k.H(str, "@CSS:", true)) {
                this.mode = Mode.Default;
                this.rule = str;
            } else if (k.K(str, "@@", false, 2)) {
                this.mode = Mode.Default;
                String strSubstring2 = str.substring(2);
                j.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                this.rule = strSubstring2;
            } else if (k.H(str, "@XPath:", true)) {
                this.mode = Mode.XPath;
                String strSubstring3 = str.substring(7);
                j.d(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                this.rule = strSubstring3;
            } else if (k.K(str, "//", false, 2)) {
                this.mode = Mode.XPath;
                this.rule = str;
            } else if (k.H(str, "@Json:", true)) {
                this.mode = Mode.Json;
                String strSubstring4 = str.substring(6);
                j.d(strSubstring4, "(this as java.lang.String).substring(startIndex)");
                this.rule = strSubstring4;
            } else if (k.K(str, "$.", false, 2)) {
                this.mode = Mode.Json;
                this.rule = str;
            } else {
                this.rule = str;
            }
            this.rule = analyzeRule.splitPutRule(this.rule, map);
            Matcher matcher = AnalyzeRule.evalPattern.matcher(this.rule);
            int iEnd = 0;
            while (matcher.find()) {
                if (matcher.start() > iEnd) {
                    String str2 = this.rule;
                    int iStart = matcher.start();
                    Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring5 = str2.substring(iEnd, iStart);
                    j.d(strSubstring5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Mode mode4 = this.mode;
                    if (mode4 != Mode.Js && mode4 != (mode3 = Mode.Regex) && iEnd == 0 && !k.d(strSubstring5, "##", false, 2)) {
                        this.mode = mode3;
                    }
                    splitRegex(strSubstring5);
                } else {
                    Mode mode5 = this.mode;
                    if (mode5 != Mode.Js && mode5 != (mode2 = Mode.Regex) && matcher.start() == 0) {
                        this.mode = mode2;
                    }
                }
                String strGroup = matcher.group();
                j.d(strGroup, "evalMatcher.group()");
                if (k.H(strGroup, "@get:", true)) {
                    this.ruleType.add(Integer.valueOf(this.getRuleType));
                    ArrayList<String> arrayList = this.ruleParam;
                    String strSubstring6 = strGroup.substring(6, k.l(strGroup));
                    j.d(strSubstring6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring6);
                } else if (k.K(strGroup, "{{", false, 2)) {
                    this.ruleType.add(Integer.valueOf(this.jsRuleType));
                    ArrayList<String> arrayList2 = this.ruleParam;
                    String strSubstring7 = strGroup.substring(2, strGroup.length() - 2);
                    j.d(strSubstring7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList2.add(strSubstring7);
                } else {
                    splitRegex(strGroup);
                }
                iEnd = matcher.end();
            }
            if (this.rule.length() > iEnd) {
                String str3 = this.rule;
                Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                String strSubstring8 = str3.substring(iEnd);
                j.d(strSubstring8, "(this as java.lang.String).substring(startIndex)");
                splitRegex(strSubstring8);
            }
        }

        private final boolean isRule(String ruleStr) {
            return k.K(ruleStr, "$.", false, 2) || k.H(ruleStr, "@Json:", true) || k.K(ruleStr, "//", false, 2) || k.H(ruleStr, "@XPath:", true) || k.H(ruleStr, "@CSS:", true) || k.K(ruleStr, "@@", false, 2);
        }

        private final void splitRegex(String ruleStr) {
            Mode mode;
            int iEnd = 0;
            Matcher matcher = AnalyzeRule.regexPattern.matcher((CharSequence) k.F(ruleStr, new String[]{"##"}, false, 0, 6).get(0));
            while (matcher.find()) {
                Mode mode2 = this.mode;
                if (mode2 != Mode.Js && mode2 != (mode = Mode.Regex)) {
                    this.mode = mode;
                }
                if (matcher.start() > iEnd) {
                    int iStart = matcher.start();
                    Objects.requireNonNull(ruleStr, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring = ruleStr.substring(iEnd, iStart);
                    j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    this.ruleType.add(Integer.valueOf(this.defaultRuleType));
                    this.ruleParam.add(strSubstring);
                }
                String strGroup = matcher.group();
                j.d(strGroup, "regexMatcher.group()");
                ArrayList<Integer> arrayList = this.ruleType;
                String strSubstring2 = strGroup.substring(1);
                j.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                arrayList.add(Integer.valueOf(Integer.parseInt(strSubstring2)));
                this.ruleParam.add(strGroup);
                iEnd = matcher.end();
            }
            if (ruleStr.length() > iEnd) {
                String strSubstring3 = ruleStr.substring(iEnd);
                j.d(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                this.ruleType.add(Integer.valueOf(this.defaultRuleType));
                this.ruleParam.add(strSubstring3);
            }
        }

        @NotNull
        /* JADX INFO: renamed from: getMode$app_adsRelease, reason: from getter */
        public final Mode getMode() {
            return this.mode;
        }

        @NotNull
        public final HashMap<String, String> getPutMap$app_adsRelease() {
            return this.putMap;
        }

        /* JADX INFO: renamed from: getReplaceFirst$app_adsRelease, reason: from getter */
        public final boolean getReplaceFirst() {
            return this.replaceFirst;
        }

        @NotNull
        /* JADX INFO: renamed from: getReplaceRegex$app_adsRelease, reason: from getter */
        public final String getReplaceRegex() {
            return this.replaceRegex;
        }

        @NotNull
        /* JADX INFO: renamed from: getReplacement$app_adsRelease, reason: from getter */
        public final String getReplacement() {
            return this.replacement;
        }

        @NotNull
        /* JADX INFO: renamed from: getRule$app_adsRelease, reason: from getter */
        public final String getRule() {
            return this.rule;
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x00f3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void makeUpRule(@org.jetbrains.annotations.Nullable java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 374
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.analyzeRule.AnalyzeRule.SourceRule.makeUpRule(java.lang.Object):void");
        }

        public final void setMode$app_adsRelease(@NotNull Mode mode) {
            j.e(mode, "<set-?>");
            this.mode = mode;
        }

        public final void setReplaceFirst$app_adsRelease(boolean z) {
            this.replaceFirst = z;
        }

        public final void setReplaceRegex$app_adsRelease(@NotNull String str) {
            j.e(str, "<set-?>");
            this.replaceRegex = str;
        }

        public final void setReplacement$app_adsRelease(@NotNull String str) {
            j.e(str, "<set-?>");
            this.replacement = str;
        }

        public final void setRule$app_adsRelease(@NotNull String str) {
            j.e(str, "<set-?>");
            this.rule = str;
        }

        public /* synthetic */ SourceRule(String str, Mode mode, int i2, f.c0.c.f fVar) {
            this(AnalyzeRule.this, str, (i2 & 2) != 0 ? Mode.Default : mode);
        }
    }
}
