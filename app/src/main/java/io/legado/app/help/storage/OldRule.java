package io.legado.app.help.storage;

import androidx.annotation.Keep;
import androidx.appcompat.widget.ActivityChooserModel;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.jsonpath.DocumentContext;
import e.a.a.d.w.q;
import e.a.a.h.n;
import h.a.a.a.w;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.rule.BookInfoRule;
import io.legado.app.data.entities.rule.ContentRule;
import io.legado.app.data.entities.rule.ExploreRule;
import io.legado.app.data.entities.rule.SearchRule;
import io.legado.app.data.entities.rule.TocRule;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;
import org.slf4j.Marker;

/* JADX INFO: compiled from: OldRule.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OldRule {

    @NotNull
    public static final OldRule a = new OldRule();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f6901b = Pattern.compile("@Header:\\{.+?\\}", 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f6902c = Pattern.compile("\\{\\{.+?\\}\\}", 2);

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<ContentRule> {
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class b extends TypeToken<ContentRule> {
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class c extends TypeToken<BookSourceAny> {
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class d extends TypeToken<ExploreRule> {
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class e extends TypeToken<ExploreRule> {
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class f extends TypeToken<SearchRule> {
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class g extends TypeToken<SearchRule> {
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class h extends TypeToken<BookInfoRule> {
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class i extends TypeToken<BookInfoRule> {
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class j extends TypeToken<TocRule> {
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class k extends TypeToken<TocRule> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v164, types: [com.google.gson.Gson] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [io.legado.app.data.entities.BookSource] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [io.legado.app.data.entities.BookSource] */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Nullable
    public final BookSource a(@NotNull String str) {
        BookSourceAny bookSourceAny;
        ?? r5;
        Object ruleToc;
        Exception e2;
        ?? r52;
        Object objM11constructorimpl;
        ExploreRule exploreRule;
        Object objM11constructorimpl2;
        SearchRule searchRule;
        Object objM11constructorimpl3;
        BookInfoRule bookInfoRule;
        Object objM11constructorimpl4;
        TocRule tocRule;
        Object objM11constructorimpl5;
        ContentRule contentRule;
        Object objM11constructorimpl6;
        Object objM11constructorimpl7;
        Object objM11constructorimpl8;
        Object objM11constructorimpl9;
        Object objM11constructorimpl10;
        Object objM11constructorimpl11;
        f.c0.c.j.e(str, "json");
        ?? type = 0;
        type = 0;
        type = 0;
        BookSource bookSource = new BookSource(null, type, null, 0, null, 0, false, false, null, null, null, 0L, 0, null, null, null, null, null, null, null, 1048575, null);
        Object obj = null;
        try {
            ?? A = n.a();
            String string = f.h0.k.R(str).toString();
            try {
                type = new c().getType();
                f.c0.c.j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = A.fromJson(string, type);
                if (!(objFromJson instanceof BookSourceAny)) {
                    objFromJson = null;
                }
                objM11constructorimpl11 = f.h.m11constructorimpl((BookSourceAny) objFromJson);
                type = type;
            } catch (Throwable th) {
                objM11constructorimpl11 = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
                type = type;
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl11)) {
                objM11constructorimpl11 = null;
            }
            bookSourceAny = (BookSourceAny) objM11constructorimpl11;
            r5 = type;
        } catch (Exception unused) {
            bookSourceAny = null;
            r5 = type;
        }
        if (bookSourceAny == null) {
            ruleToc = null;
        } else {
            try {
                ruleToc = bookSourceAny.getRuleToc();
            } catch (Exception e3) {
                e2 = e3;
                r5 = bookSource;
                e2.printStackTrace();
                r52 = r5;
                return r52;
            }
        }
        try {
            if (ruleToc == null) {
                DocumentContext documentContext = q.a.b().parse(f.h0.k.R(str).toString());
                f.c0.c.j.d(documentContext, "jsonItem");
                String strA4 = c.b.a.m.f.A4(documentContext, "bookSourceUrl");
                String strSubstring = "";
                if (strA4 == null) {
                    strA4 = "";
                }
                BookSource bookSource2 = bookSource;
                bookSource2.setBookSourceUrl(strA4);
                String strA42 = c.b.a.m.f.A4(documentContext, "bookSourceName");
                if (strA42 == null) {
                    strA42 = "";
                }
                bookSource2.setBookSourceName(strA42);
                bookSource2.setBookSourceGroup(c.b.a.m.f.A4(documentContext, "bookSourceGroup"));
                bookSource2.setLoginUrl(c.b.a.m.f.A4(documentContext, "loginUrl"));
                String strA43 = c.b.a.m.f.A4(documentContext, "bookSourceComment");
                if (strA43 == null) {
                    strA43 = "";
                }
                bookSource2.setBookSourceComment(strA43);
                bookSource2.setBookUrlPattern(c.b.a.m.f.A4(documentContext, "ruleBookUrlPattern"));
                Integer numY4 = c.b.a.m.f.y4(documentContext, "serialNumber");
                bookSource2.setCustomOrder(numY4 == null ? 0 : numY4.intValue());
                OldRule oldRule = a;
                bookSource2.setHeader(oldRule.e(c.b.a.m.f.A4(documentContext, "httpUserAgent")));
                bookSource2.setSearchUrl(oldRule.c(c.b.a.m.f.A4(documentContext, "ruleSearchUrl")));
                bookSource2.setExploreUrl(oldRule.d(c.b.a.m.f.A4(documentContext, "ruleFindUrl")));
                bookSource2.setBookSourceType(f.c0.c.j.a(c.b.a.m.f.A4(documentContext, "bookSourceType"), "AUDIO") ? 1 : 0);
                Boolean boolU4 = c.b.a.m.f.u4(documentContext, "enable");
                bookSource2.setEnabled(boolU4 == null ? true : boolU4.booleanValue());
                String exploreUrl = bookSource2.getExploreUrl();
                if (exploreUrl == null || f.h0.k.s(exploreUrl)) {
                    bookSource2.setEnabledExplore(false);
                }
                bookSource2.setRuleSearch(new SearchRule(oldRule.b(c.b.a.m.f.A4(documentContext, "ruleSearchList")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleSearchName")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleSearchAuthor")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleSearchIntroduce")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleSearchKind")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleSearchLastChapter")), null, oldRule.b(c.b.a.m.f.A4(documentContext, "ruleSearchNoteUrl")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleSearchCoverUrl")), null, 576, null));
                bookSource2.setRuleExplore(new ExploreRule(oldRule.b(c.b.a.m.f.A4(documentContext, "ruleFindList")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleFindName")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleFindAuthor")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleFindIntroduce")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleFindKind")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleFindLastChapter")), null, oldRule.b(c.b.a.m.f.A4(documentContext, "ruleFindNoteUrl")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleFindCoverUrl")), null, 576, null));
                bookSource2.setRuleBookInfo(new BookInfoRule(oldRule.b(c.b.a.m.f.A4(documentContext, "ruleBookInfoInit")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleBookName")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleBookAuthor")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleIntroduce")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleBookKind")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleBookLastChapter")), null, oldRule.b(c.b.a.m.f.A4(documentContext, "ruleCoverUrl")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleChapterUrl")), null, null, 1600, null));
                bookSource2.setRuleToc(new TocRule(oldRule.b(c.b.a.m.f.A4(documentContext, "ruleChapterList")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleChapterName")), oldRule.b(c.b.a.m.f.A4(documentContext, "ruleContentUrl")), null, null, oldRule.b(c.b.a.m.f.A4(documentContext, "ruleChapterUrlNext")), 24, null));
                String strB = oldRule.b(c.b.a.m.f.A4(documentContext, "ruleBookContent"));
                if (strB != null) {
                    strSubstring = strB;
                }
                if (f.h0.k.K(strSubstring, "$", false, 2) && !f.h0.k.K(strSubstring, "$.", false, 2)) {
                    strSubstring = strSubstring.substring(1);
                    f.c0.c.j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                }
                bookSource2.setRuleContent(new ContentRule(strSubstring, oldRule.b(c.b.a.m.f.A4(documentContext, "ruleContentUrlNext")), null, null, oldRule.b(c.b.a.m.f.A4(documentContext, "ruleBookContentReplace")), null, 44, null));
                r52 = bookSource2;
            } else {
                r5 = bookSource;
                r5.setBookSourceUrl(bookSourceAny.getBookSourceUrl());
                r5.setBookSourceName(bookSourceAny.getBookSourceName());
                r5.setBookSourceGroup(bookSourceAny.getBookSourceGroup());
                r5.setBookSourceType(bookSourceAny.getBookSourceType());
                r5.setBookUrlPattern(bookSourceAny.getBookUrlPattern());
                r5.setCustomOrder(bookSourceAny.getCustomOrder());
                r5.setEnabled(bookSourceAny.getEnabled());
                r5.setEnabledExplore(bookSourceAny.getEnabledExplore());
                r5.setHeader(bookSourceAny.getHeader());
                r5.setLoginUrl(bookSourceAny.getLoginUrl());
                r5.setBookSourceComment(bookSourceAny.getBookSourceComment());
                r5.setLastUpdateTime(bookSourceAny.getLastUpdateTime());
                r5.setWeight(bookSourceAny.getWeight());
                r5.setExploreUrl(bookSourceAny.getExploreUrl());
                if (bookSourceAny.getRuleExplore() instanceof String) {
                    Gson gsonA = n.a();
                    Object ruleExplore = bookSourceAny.getRuleExplore();
                    String str2 = ruleExplore instanceof String ? (String) ruleExplore : null;
                    try {
                        Type type2 = new d().getType();
                        f.c0.c.j.d(type2, "object : TypeToken<T>() {}.type");
                        Object objFromJson2 = gsonA.fromJson(str2, type2);
                        if (!(objFromJson2 instanceof ExploreRule)) {
                            objFromJson2 = null;
                        }
                        objM11constructorimpl10 = f.h.m11constructorimpl((ExploreRule) objFromJson2);
                    } catch (Throwable th2) {
                        objM11constructorimpl10 = f.h.m11constructorimpl(c.b.a.m.f.m1(th2));
                    }
                    if (f.h.m16isFailureimpl(objM11constructorimpl10)) {
                        objM11constructorimpl10 = null;
                    }
                    exploreRule = (ExploreRule) objM11constructorimpl10;
                } else {
                    Gson gsonA2 = n.a();
                    String json = n.a().toJson(bookSourceAny.getRuleExplore());
                    try {
                        Type type3 = new e().getType();
                        f.c0.c.j.d(type3, "object : TypeToken<T>() {}.type");
                        Object objFromJson3 = gsonA2.fromJson(json, type3);
                        if (!(objFromJson3 instanceof ExploreRule)) {
                            objFromJson3 = null;
                        }
                        objM11constructorimpl = f.h.m11constructorimpl((ExploreRule) objFromJson3);
                    } catch (Throwable th3) {
                        objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th3));
                    }
                    if (f.h.m16isFailureimpl(objM11constructorimpl)) {
                        objM11constructorimpl = null;
                    }
                    exploreRule = (ExploreRule) objM11constructorimpl;
                }
                r5.setRuleExplore(exploreRule);
                r5.setSearchUrl(bookSourceAny.getSearchUrl());
                if (bookSourceAny.getRuleSearch() instanceof String) {
                    Gson gsonA3 = n.a();
                    Object ruleSearch = bookSourceAny.getRuleSearch();
                    String str3 = ruleSearch instanceof String ? (String) ruleSearch : null;
                    try {
                        Type type4 = new f().getType();
                        f.c0.c.j.d(type4, "object : TypeToken<T>() {}.type");
                        Object objFromJson4 = gsonA3.fromJson(str3, type4);
                        if (!(objFromJson4 instanceof SearchRule)) {
                            objFromJson4 = null;
                        }
                        objM11constructorimpl9 = f.h.m11constructorimpl((SearchRule) objFromJson4);
                    } catch (Throwable th4) {
                        objM11constructorimpl9 = f.h.m11constructorimpl(c.b.a.m.f.m1(th4));
                    }
                    if (f.h.m16isFailureimpl(objM11constructorimpl9)) {
                        objM11constructorimpl9 = null;
                    }
                    searchRule = (SearchRule) objM11constructorimpl9;
                } else {
                    Gson gsonA4 = n.a();
                    String json2 = n.a().toJson(bookSourceAny.getRuleSearch());
                    try {
                        Type type5 = new g().getType();
                        f.c0.c.j.d(type5, "object : TypeToken<T>() {}.type");
                        Object objFromJson5 = gsonA4.fromJson(json2, type5);
                        if (!(objFromJson5 instanceof SearchRule)) {
                            objFromJson5 = null;
                        }
                        objM11constructorimpl2 = f.h.m11constructorimpl((SearchRule) objFromJson5);
                    } catch (Throwable th5) {
                        objM11constructorimpl2 = f.h.m11constructorimpl(c.b.a.m.f.m1(th5));
                    }
                    if (f.h.m16isFailureimpl(objM11constructorimpl2)) {
                        objM11constructorimpl2 = null;
                    }
                    searchRule = (SearchRule) objM11constructorimpl2;
                }
                r5.setRuleSearch(searchRule);
                if (bookSourceAny.getRuleBookInfo() instanceof String) {
                    Gson gsonA5 = n.a();
                    Object ruleBookInfo = bookSourceAny.getRuleBookInfo();
                    String str4 = ruleBookInfo instanceof String ? (String) ruleBookInfo : null;
                    try {
                        Type type6 = new h().getType();
                        f.c0.c.j.d(type6, "object : TypeToken<T>() {}.type");
                        Object objFromJson6 = gsonA5.fromJson(str4, type6);
                        if (!(objFromJson6 instanceof BookInfoRule)) {
                            objFromJson6 = null;
                        }
                        objM11constructorimpl8 = f.h.m11constructorimpl((BookInfoRule) objFromJson6);
                    } catch (Throwable th6) {
                        objM11constructorimpl8 = f.h.m11constructorimpl(c.b.a.m.f.m1(th6));
                    }
                    if (f.h.m16isFailureimpl(objM11constructorimpl8)) {
                        objM11constructorimpl8 = null;
                    }
                    bookInfoRule = (BookInfoRule) objM11constructorimpl8;
                } else {
                    Gson gsonA6 = n.a();
                    String json3 = n.a().toJson(bookSourceAny.getRuleBookInfo());
                    try {
                        Type type7 = new i().getType();
                        f.c0.c.j.d(type7, "object : TypeToken<T>() {}.type");
                        Object objFromJson7 = gsonA6.fromJson(json3, type7);
                        if (!(objFromJson7 instanceof BookInfoRule)) {
                            objFromJson7 = null;
                        }
                        objM11constructorimpl3 = f.h.m11constructorimpl((BookInfoRule) objFromJson7);
                    } catch (Throwable th7) {
                        objM11constructorimpl3 = f.h.m11constructorimpl(c.b.a.m.f.m1(th7));
                    }
                    if (f.h.m16isFailureimpl(objM11constructorimpl3)) {
                        objM11constructorimpl3 = null;
                    }
                    bookInfoRule = (BookInfoRule) objM11constructorimpl3;
                }
                r5.setRuleBookInfo(bookInfoRule);
                if (bookSourceAny.getRuleToc() instanceof String) {
                    Gson gsonA7 = n.a();
                    Object ruleToc2 = bookSourceAny.getRuleToc();
                    String str5 = ruleToc2 instanceof String ? (String) ruleToc2 : null;
                    try {
                        Type type8 = new j().getType();
                        f.c0.c.j.d(type8, "object : TypeToken<T>() {}.type");
                        Object objFromJson8 = gsonA7.fromJson(str5, type8);
                        if (!(objFromJson8 instanceof TocRule)) {
                            objFromJson8 = null;
                        }
                        objM11constructorimpl7 = f.h.m11constructorimpl((TocRule) objFromJson8);
                    } catch (Throwable th8) {
                        objM11constructorimpl7 = f.h.m11constructorimpl(c.b.a.m.f.m1(th8));
                    }
                    if (f.h.m16isFailureimpl(objM11constructorimpl7)) {
                        objM11constructorimpl7 = null;
                    }
                    tocRule = (TocRule) objM11constructorimpl7;
                } else {
                    Gson gsonA8 = n.a();
                    String json4 = n.a().toJson(bookSourceAny.getRuleToc());
                    try {
                        Type type9 = new k().getType();
                        f.c0.c.j.d(type9, "object : TypeToken<T>() {}.type");
                        Object objFromJson9 = gsonA8.fromJson(json4, type9);
                        if (!(objFromJson9 instanceof TocRule)) {
                            objFromJson9 = null;
                        }
                        objM11constructorimpl4 = f.h.m11constructorimpl((TocRule) objFromJson9);
                    } catch (Throwable th9) {
                        objM11constructorimpl4 = f.h.m11constructorimpl(c.b.a.m.f.m1(th9));
                    }
                    if (f.h.m16isFailureimpl(objM11constructorimpl4)) {
                        objM11constructorimpl4 = null;
                    }
                    tocRule = (TocRule) objM11constructorimpl4;
                }
                r5.setRuleToc(tocRule);
                if (bookSourceAny.getRuleContent() instanceof String) {
                    Gson gsonA9 = n.a();
                    Object ruleContent = bookSourceAny.getRuleContent();
                    String str6 = ruleContent instanceof String ? (String) ruleContent : null;
                    try {
                        Type type10 = new a().getType();
                        f.c0.c.j.d(type10, "object : TypeToken<T>() {}.type");
                        Object objFromJson10 = gsonA9.fromJson(str6, type10);
                        if (!(objFromJson10 instanceof ContentRule)) {
                            objFromJson10 = null;
                        }
                        objM11constructorimpl6 = f.h.m11constructorimpl((ContentRule) objFromJson10);
                    } catch (Throwable th10) {
                        objM11constructorimpl6 = f.h.m11constructorimpl(c.b.a.m.f.m1(th10));
                    }
                    if (!f.h.m16isFailureimpl(objM11constructorimpl6)) {
                        obj = objM11constructorimpl6;
                    }
                    contentRule = (ContentRule) obj;
                } else {
                    Gson gsonA10 = n.a();
                    String json5 = n.a().toJson(bookSourceAny.getRuleContent());
                    try {
                        Type type11 = new b().getType();
                        f.c0.c.j.d(type11, "object : TypeToken<T>() {}.type");
                        Object objFromJson11 = gsonA10.fromJson(json5, type11);
                        if (!(objFromJson11 instanceof ContentRule)) {
                            objFromJson11 = null;
                        }
                        objM11constructorimpl5 = f.h.m11constructorimpl((ContentRule) objFromJson11);
                    } catch (Throwable th11) {
                        objM11constructorimpl5 = f.h.m11constructorimpl(c.b.a.m.f.m1(th11));
                    }
                    if (!f.h.m16isFailureimpl(objM11constructorimpl5)) {
                        obj = objM11constructorimpl5;
                    }
                    contentRule = (ContentRule) obj;
                }
                r5.setRuleContent(contentRule);
                r52 = r5;
            }
        } catch (Exception e4) {
            e2 = e4;
            e2.printStackTrace();
            r52 = r5;
        }
        return r52;
    }

    public final String b(String str) {
        String strK;
        boolean z;
        boolean z2;
        String strC;
        int i2 = 1;
        if (str == null || f.h0.k.s(str)) {
            return null;
        }
        if (f.h0.k.K(str, "-", false, 2)) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            strK = str.substring(1);
            f.c0.c.j.d(strK, "(this as java.lang.String).substring(startIndex)");
            z = true;
        } else {
            strK = str;
            z = false;
        }
        if (f.h0.k.K(strK, Marker.ANY_NON_NULL_MARKER, false, 2)) {
            Objects.requireNonNull(strK, "null cannot be cast to non-null type java.lang.String");
            strK = strK.substring(1);
            f.c0.c.j.d(strK, "(this as java.lang.String).substring(startIndex)");
            z2 = true;
        } else {
            z2 = false;
        }
        if (!f.h0.k.H(strK, "@CSS:", true) && !f.h0.k.H(strK, "@XPath:", true) && !f.h0.k.K(strK, "//", false, 2) && !f.h0.k.K(strK, "##", false, 2) && !f.h0.k.K(strK, ":", false, 2) && !f.h0.k.b(strK, "@js:", true) && !f.h0.k.b(strK, "<js>", true)) {
            if (f.h0.k.d(strK, "#", false, 2) && !f.h0.k.d(strK, "##", false, 2)) {
                strK = f.h0.k.C(str, "#", "##", false, 4);
            }
            if (f.h0.k.d(strK, "|", false, 2) && !f.h0.k.d(strK, "||", false, 2)) {
                if (f.h0.k.d(strK, "##", false, 2)) {
                    List listF = f.h0.k.F(strK, new String[]{"##"}, false, 0, 6);
                    if (f.h0.k.d((CharSequence) listF.get(0), "|", false, 2)) {
                        strC = f.h0.k.C((String) listF.get(0), "|", "||", false, 4);
                        int size = listF.size();
                        if (1 < size) {
                            while (true) {
                                int i3 = i2 + 1;
                                strC = ((Object) strC) + "##" + ((String) listF.get(i2));
                                if (i3 >= size) {
                                    break;
                                }
                                i2 = i3;
                            }
                        }
                    }
                } else {
                    strC = f.h0.k.C(strK, "|", "||", false, 4);
                }
                strK = strC;
            }
            if (f.h0.k.d(strK, "&", false, 2) && !f.h0.k.d(strK, "&&", false, 2) && !f.h0.k.d(strK, "http", false, 2) && !f.h0.k.K(strK, w.DEFAULT_PATH_SEPARATOR, false, 2)) {
                strK = f.h0.k.C(strK, "&", "&&", false, 4);
            }
        }
        if (z2) {
            strK = f.c0.c.j.k(Marker.ANY_NON_NULL_MARKER, strK);
        }
        return z ? f.c0.c.j.k("-", strK) : strK;
    }

    public final String c(String str) {
        if (str == null || f.h0.k.s(str)) {
            return null;
        }
        if (f.h0.k.H(str, "<js>", true)) {
            return f.h0.k.C(f.h0.k.C(str, "=searchKey", "={{key}}", false, 4), "=searchPage", "={{page}}", false, 4);
        }
        HashMap map = new HashMap();
        Matcher matcher = f6901b.matcher(str);
        if (matcher.find()) {
            String strGroup = matcher.group();
            f.c0.c.j.d(strGroup, "header");
            str = f.h0.k.C(str, strGroup, "", false, 4);
            String strSubstring = strGroup.substring(8);
            f.c0.c.j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
            map.put("headers", strSubstring);
        }
        List listF = f.h0.k.F(str, new String[]{"|"}, false, 0, 6);
        String strC = (String) listF.get(0);
        if (listF.size() > 1) {
            map.put("charset", f.h0.k.F((CharSequence) listF.get(1), new String[]{"="}, false, 0, 6).get(1));
        }
        Matcher matcher2 = f6902c.matcher(strC);
        ArrayList arrayList = new ArrayList();
        while (matcher2.find()) {
            arrayList.add(matcher2.group());
            strC = f.h0.k.C(strC, (String) f.x.e.r(arrayList), f.c0.c.j.k("$", Integer.valueOf(arrayList.size() - 1)), false, 4);
        }
        String strC2 = f.h0.k.C(c.a.a.a.a.j("searchPage([-+]1)", c.a.a.a.a.j("<searchPage([-+]1)>", f.h0.k.C(f.h0.k.C(f.h0.k.C(strC, "{", "<", false, 4), "}", ">", false, 4), "searchKey", "{{key}}", false, 4), "{{page$1}}"), "{{page$1}}"), "searchPage", "{{page}}", false, 4);
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            strC2 = f.h0.k.C(strC2, f.c0.c.j.k("$", Integer.valueOf(i2)), f.h0.k.C(f.h0.k.C((String) it.next(), "searchKey", "key", false, 4), "searchPage", "page", false, 4), false, 4);
            i2++;
        }
        List listF2 = f.h0.k.F(strC2, new String[]{"@"}, false, 0, 6);
        String str2 = (String) listF2.get(0);
        if (listF2.size() > 1) {
            map.put("method", "POST");
            map.put("body", listF2.get(1));
        }
        if (map.size() <= 0) {
            return str2;
        }
        return str2 + ',' + ((Object) n.a().toJson(map));
    }

    public final String d(String str) {
        if (str == null || f.h0.k.s(str)) {
            return null;
        }
        if (!f.h0.k.d(str, "\n", false, 2) && !f.h0.k.d(str, "&&", false, 2)) {
            return c(str);
        }
        List<String> listSplit = new f.h0.g("(&&|\r?\n)+").split(str, 0);
        ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(listSplit, 10));
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            String strC = a.c((String) it.next());
            arrayList.add(strC == null ? null : c.a.a.a.a.j("\n\\s*", strC, ""));
        }
        return f.x.e.q(arrayList, "\n", null, null, 0, null, null, 62);
    }

    public final String e(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return n.a().toJson(c.b.a.m.f.U3(new f.g("User-Agent", str)));
    }

    /* JADX INFO: compiled from: OldRule.kt */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b[\b\u0087\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\b\b\u0002\u0010%\u001a\u00020\f\u0012\b\b\u0002\u0010&\u001a\u00020\f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0013\u0012\b\b\u0002\u0010+\u001a\u00020\u0007\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bl\u0010mJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0016\u0010\tJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0019J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0019J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0019J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0019Jð\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010$\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\f2\b\b\u0002\u0010&\u001a\u00020\f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010*\u001a\u00020\u00132\b\b\u0002\u0010+\u001a\u00020\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b5\u0010\u0004J\u0010\u00106\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b6\u0010\tJ\u001a\u00108\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b8\u00109R$\u00102\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010:\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010=R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010>\u001a\u0004\b?\u0010\u0004\"\u0004\b@\u0010AR\"\u0010%\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010B\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010ER$\u00100\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010:\u001a\u0004\bF\u0010\u0019\"\u0004\bG\u0010=R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010>\u001a\u0004\bH\u0010\u0004\"\u0004\bI\u0010AR\"\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010J\u001a\u0004\bK\u0010\t\"\u0004\bL\u0010MR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010>\u001a\u0004\bN\u0010\u0004\"\u0004\bO\u0010AR$\u0010/\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010:\u001a\u0004\bP\u0010\u0019\"\u0004\bQ\u0010=R$\u00101\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010:\u001a\u0004\bR\u0010\u0019\"\u0004\bS\u0010=R\"\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010J\u001a\u0004\bT\u0010\t\"\u0004\bU\u0010MR\"\u0010*\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010V\u001a\u0004\bW\u0010\u0015\"\u0004\bX\u0010YR\"\u0010&\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010B\u001a\u0004\bZ\u0010\u000e\"\u0004\b[\u0010ER$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010>\u001a\u0004\b\\\u0010\u0004\"\u0004\b]\u0010AR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010>\u001a\u0004\b^\u0010\u0004\"\u0004\b_\u0010AR$\u0010-\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010:\u001a\u0004\b`\u0010\u0019\"\u0004\ba\u0010=R$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010>\u001a\u0004\bb\u0010\u0004\"\u0004\bc\u0010AR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010>\u001a\u0004\bd\u0010\u0004\"\u0004\be\u0010AR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010>\u001a\u0004\bf\u0010\u0004\"\u0004\bg\u0010AR$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010>\u001a\u0004\bh\u0010\u0004\"\u0004\bi\u0010AR\"\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010J\u001a\u0004\bj\u0010\t\"\u0004\bk\u0010M¨\u0006n"}, d2 = {"Lio/legado/app/help/storage/OldRule$BookSourceAny;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()I", "component5", "component6", "", "component7", "()Z", "component8", "component9", "component10", "component11", "", "component12", "()J", "component13", "component14", "component15", "()Ljava/lang/Object;", "component16", "component17", "component18", "component19", "component20", "bookSourceName", "bookSourceGroup", "bookSourceUrl", "bookSourceType", "bookUrlPattern", "customOrder", "enabled", "enabledExplore", "header", "loginUrl", "bookSourceComment", "lastUpdateTime", ActivityChooserModel.ATTRIBUTE_WEIGHT, "exploreUrl", "ruleExplore", "searchUrl", "ruleSearch", "ruleBookInfo", "ruleToc", "ruleContent", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lio/legado/app/help/storage/OldRule$BookSourceAny;", "toString", TTDownloadField.TT_HASHCODE, "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getRuleContent", "setRuleContent", "(Ljava/lang/Object;)V", "Ljava/lang/String;", "getBookSourceUrl", "setBookSourceUrl", "(Ljava/lang/String;)V", "Z", "getEnabled", "setEnabled", "(Z)V", "getRuleBookInfo", "setRuleBookInfo", "getBookSourceName", "setBookSourceName", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getWeight", "setWeight", "(I)V", "getExploreUrl", "setExploreUrl", "getRuleSearch", "setRuleSearch", "getRuleToc", "setRuleToc", "getBookSourceType", "setBookSourceType", "J", "getLastUpdateTime", "setLastUpdateTime", "(J)V", "getEnabledExplore", "setEnabledExplore", "getBookUrlPattern", "setBookUrlPattern", "getLoginUrl", "setLoginUrl", "getRuleExplore", "setRuleExplore", "getSearchUrl", "setSearchUrl", "getBookSourceComment", "setBookSourceComment", "getBookSourceGroup", "setBookSourceGroup", "getHeader", "setHeader", "getCustomOrder", "setCustomOrder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final /* data */ class BookSourceAny {

        @Nullable
        private String bookSourceComment;

        @Nullable
        private String bookSourceGroup;

        @NotNull
        private String bookSourceName;
        private int bookSourceType;

        @NotNull
        private String bookSourceUrl;

        @Nullable
        private String bookUrlPattern;
        private int customOrder;
        private boolean enabled;
        private boolean enabledExplore;

        @Nullable
        private String exploreUrl;

        @Nullable
        private String header;
        private long lastUpdateTime;

        @Nullable
        private String loginUrl;

        @Nullable
        private Object ruleBookInfo;

        @Nullable
        private Object ruleContent;

        @Nullable
        private Object ruleExplore;

        @Nullable
        private Object ruleSearch;

        @Nullable
        private Object ruleToc;

        @Nullable
        private String searchUrl;
        private int weight;

        public BookSourceAny() {
            this(null, null, null, 0, null, 0, false, false, null, null, null, 0L, 0, null, null, null, null, null, null, null, 1048575, null);
        }

        public BookSourceAny(@NotNull String str, @Nullable String str2, @NotNull String str3, int i2, @Nullable String str4, int i3, boolean z, boolean z2, @Nullable String str5, @Nullable String str6, @Nullable String str7, long j2, int i4, @Nullable String str8, @Nullable Object obj, @Nullable String str9, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5) {
            f.c0.c.j.e(str, "bookSourceName");
            f.c0.c.j.e(str3, "bookSourceUrl");
            this.bookSourceName = str;
            this.bookSourceGroup = str2;
            this.bookSourceUrl = str3;
            this.bookSourceType = i2;
            this.bookUrlPattern = str4;
            this.customOrder = i3;
            this.enabled = z;
            this.enabledExplore = z2;
            this.header = str5;
            this.loginUrl = str6;
            this.bookSourceComment = str7;
            this.lastUpdateTime = j2;
            this.weight = i4;
            this.exploreUrl = str8;
            this.ruleExplore = obj;
            this.searchUrl = str9;
            this.ruleSearch = obj2;
            this.ruleBookInfo = obj3;
            this.ruleToc = obj4;
            this.ruleContent = obj5;
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getBookSourceName() {
            return this.bookSourceName;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getLoginUrl() {
            return this.loginUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getBookSourceComment() {
            return this.bookSourceComment;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final long getLastUpdateTime() {
            return this.lastUpdateTime;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final int getWeight() {
            return this.weight;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getExploreUrl() {
            return this.exploreUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Object getRuleExplore() {
            return this.ruleExplore;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getSearchUrl() {
            return this.searchUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Object getRuleSearch() {
            return this.ruleSearch;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Object getRuleBookInfo() {
            return this.ruleBookInfo;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Object getRuleToc() {
            return this.ruleToc;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getBookSourceGroup() {
            return this.bookSourceGroup;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final Object getRuleContent() {
            return this.ruleContent;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getBookSourceUrl() {
            return this.bookSourceUrl;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getBookSourceType() {
            return this.bookSourceType;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getBookUrlPattern() {
            return this.bookUrlPattern;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getCustomOrder() {
            return this.customOrder;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getEnabledExplore() {
            return this.enabledExplore;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getHeader() {
            return this.header;
        }

        @NotNull
        public final BookSourceAny copy(@NotNull String bookSourceName, @Nullable String bookSourceGroup, @NotNull String bookSourceUrl, int bookSourceType, @Nullable String bookUrlPattern, int customOrder, boolean enabled, boolean enabledExplore, @Nullable String header, @Nullable String loginUrl, @Nullable String bookSourceComment, long lastUpdateTime, int weight, @Nullable String exploreUrl, @Nullable Object ruleExplore, @Nullable String searchUrl, @Nullable Object ruleSearch, @Nullable Object ruleBookInfo, @Nullable Object ruleToc, @Nullable Object ruleContent) {
            f.c0.c.j.e(bookSourceName, "bookSourceName");
            f.c0.c.j.e(bookSourceUrl, "bookSourceUrl");
            return new BookSourceAny(bookSourceName, bookSourceGroup, bookSourceUrl, bookSourceType, bookUrlPattern, customOrder, enabled, enabledExplore, header, loginUrl, bookSourceComment, lastUpdateTime, weight, exploreUrl, ruleExplore, searchUrl, ruleSearch, ruleBookInfo, ruleToc, ruleContent);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BookSourceAny)) {
                return false;
            }
            BookSourceAny bookSourceAny = (BookSourceAny) other;
            return f.c0.c.j.a(this.bookSourceName, bookSourceAny.bookSourceName) && f.c0.c.j.a(this.bookSourceGroup, bookSourceAny.bookSourceGroup) && f.c0.c.j.a(this.bookSourceUrl, bookSourceAny.bookSourceUrl) && this.bookSourceType == bookSourceAny.bookSourceType && f.c0.c.j.a(this.bookUrlPattern, bookSourceAny.bookUrlPattern) && this.customOrder == bookSourceAny.customOrder && this.enabled == bookSourceAny.enabled && this.enabledExplore == bookSourceAny.enabledExplore && f.c0.c.j.a(this.header, bookSourceAny.header) && f.c0.c.j.a(this.loginUrl, bookSourceAny.loginUrl) && f.c0.c.j.a(this.bookSourceComment, bookSourceAny.bookSourceComment) && this.lastUpdateTime == bookSourceAny.lastUpdateTime && this.weight == bookSourceAny.weight && f.c0.c.j.a(this.exploreUrl, bookSourceAny.exploreUrl) && f.c0.c.j.a(this.ruleExplore, bookSourceAny.ruleExplore) && f.c0.c.j.a(this.searchUrl, bookSourceAny.searchUrl) && f.c0.c.j.a(this.ruleSearch, bookSourceAny.ruleSearch) && f.c0.c.j.a(this.ruleBookInfo, bookSourceAny.ruleBookInfo) && f.c0.c.j.a(this.ruleToc, bookSourceAny.ruleToc) && f.c0.c.j.a(this.ruleContent, bookSourceAny.ruleContent);
        }

        @Nullable
        public final String getBookSourceComment() {
            return this.bookSourceComment;
        }

        @Nullable
        public final String getBookSourceGroup() {
            return this.bookSourceGroup;
        }

        @NotNull
        public final String getBookSourceName() {
            return this.bookSourceName;
        }

        public final int getBookSourceType() {
            return this.bookSourceType;
        }

        @NotNull
        public final String getBookSourceUrl() {
            return this.bookSourceUrl;
        }

        @Nullable
        public final String getBookUrlPattern() {
            return this.bookUrlPattern;
        }

        public final int getCustomOrder() {
            return this.customOrder;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final boolean getEnabledExplore() {
            return this.enabledExplore;
        }

        @Nullable
        public final String getExploreUrl() {
            return this.exploreUrl;
        }

        @Nullable
        public final String getHeader() {
            return this.header;
        }

        public final long getLastUpdateTime() {
            return this.lastUpdateTime;
        }

        @Nullable
        public final String getLoginUrl() {
            return this.loginUrl;
        }

        @Nullable
        public final Object getRuleBookInfo() {
            return this.ruleBookInfo;
        }

        @Nullable
        public final Object getRuleContent() {
            return this.ruleContent;
        }

        @Nullable
        public final Object getRuleExplore() {
            return this.ruleExplore;
        }

        @Nullable
        public final Object getRuleSearch() {
            return this.ruleSearch;
        }

        @Nullable
        public final Object getRuleToc() {
            return this.ruleToc;
        }

        @Nullable
        public final String getSearchUrl() {
            return this.searchUrl;
        }

        public final int getWeight() {
            return this.weight;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v10, types: [int] */
        /* JADX WARN: Type inference failed for: r1v42 */
        /* JADX WARN: Type inference failed for: r1v45 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [int] */
        /* JADX WARN: Type inference failed for: r3v4 */
        public int hashCode() {
            int iHashCode = this.bookSourceName.hashCode() * 31;
            String str = this.bookSourceGroup;
            int iM = (c.a.a.a.a.m(this.bookSourceUrl, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31) + this.bookSourceType) * 31;
            String str2 = this.bookUrlPattern;
            int iHashCode2 = (((iM + (str2 == null ? 0 : str2.hashCode())) * 31) + this.customOrder) * 31;
            boolean z = this.enabled;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            int i2 = (iHashCode2 + r1) * 31;
            boolean z2 = this.enabledExplore;
            int i3 = (i2 + (z2 ? 1 : z2)) * 31;
            String str3 = this.header;
            int iHashCode3 = (i3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.loginUrl;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.bookSourceComment;
            int iA = (((e.a.a.c.b.a(this.lastUpdateTime) + ((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31)) * 31) + this.weight) * 31;
            String str6 = this.exploreUrl;
            int iHashCode5 = (iA + (str6 == null ? 0 : str6.hashCode())) * 31;
            Object obj = this.ruleExplore;
            int iHashCode6 = (iHashCode5 + (obj == null ? 0 : obj.hashCode())) * 31;
            String str7 = this.searchUrl;
            int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Object obj2 = this.ruleSearch;
            int iHashCode8 = (iHashCode7 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
            Object obj3 = this.ruleBookInfo;
            int iHashCode9 = (iHashCode8 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
            Object obj4 = this.ruleToc;
            int iHashCode10 = (iHashCode9 + (obj4 == null ? 0 : obj4.hashCode())) * 31;
            Object obj5 = this.ruleContent;
            return iHashCode10 + (obj5 != null ? obj5.hashCode() : 0);
        }

        public final void setBookSourceComment(@Nullable String str) {
            this.bookSourceComment = str;
        }

        public final void setBookSourceGroup(@Nullable String str) {
            this.bookSourceGroup = str;
        }

        public final void setBookSourceName(@NotNull String str) {
            f.c0.c.j.e(str, "<set-?>");
            this.bookSourceName = str;
        }

        public final void setBookSourceType(int i2) {
            this.bookSourceType = i2;
        }

        public final void setBookSourceUrl(@NotNull String str) {
            f.c0.c.j.e(str, "<set-?>");
            this.bookSourceUrl = str;
        }

        public final void setBookUrlPattern(@Nullable String str) {
            this.bookUrlPattern = str;
        }

        public final void setCustomOrder(int i2) {
            this.customOrder = i2;
        }

        public final void setEnabled(boolean z) {
            this.enabled = z;
        }

        public final void setEnabledExplore(boolean z) {
            this.enabledExplore = z;
        }

        public final void setExploreUrl(@Nullable String str) {
            this.exploreUrl = str;
        }

        public final void setHeader(@Nullable String str) {
            this.header = str;
        }

        public final void setLastUpdateTime(long j2) {
            this.lastUpdateTime = j2;
        }

        public final void setLoginUrl(@Nullable String str) {
            this.loginUrl = str;
        }

        public final void setRuleBookInfo(@Nullable Object obj) {
            this.ruleBookInfo = obj;
        }

        public final void setRuleContent(@Nullable Object obj) {
            this.ruleContent = obj;
        }

        public final void setRuleExplore(@Nullable Object obj) {
            this.ruleExplore = obj;
        }

        public final void setRuleSearch(@Nullable Object obj) {
            this.ruleSearch = obj;
        }

        public final void setRuleToc(@Nullable Object obj) {
            this.ruleToc = obj;
        }

        public final void setSearchUrl(@Nullable String str) {
            this.searchUrl = str;
        }

        public final void setWeight(int i2) {
            this.weight = i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("BookSourceAny(bookSourceName=");
            sbR.append(this.bookSourceName);
            sbR.append(", bookSourceGroup=");
            sbR.append((Object) this.bookSourceGroup);
            sbR.append(", bookSourceUrl=");
            sbR.append(this.bookSourceUrl);
            sbR.append(", bookSourceType=");
            sbR.append(this.bookSourceType);
            sbR.append(", bookUrlPattern=");
            sbR.append((Object) this.bookUrlPattern);
            sbR.append(", customOrder=");
            sbR.append(this.customOrder);
            sbR.append(", enabled=");
            sbR.append(this.enabled);
            sbR.append(", enabledExplore=");
            sbR.append(this.enabledExplore);
            sbR.append(", header=");
            sbR.append((Object) this.header);
            sbR.append(", loginUrl=");
            sbR.append((Object) this.loginUrl);
            sbR.append(", bookSourceComment=");
            sbR.append((Object) this.bookSourceComment);
            sbR.append(", lastUpdateTime=");
            sbR.append(this.lastUpdateTime);
            sbR.append(", weight=");
            sbR.append(this.weight);
            sbR.append(", exploreUrl=");
            sbR.append((Object) this.exploreUrl);
            sbR.append(", ruleExplore=");
            sbR.append(this.ruleExplore);
            sbR.append(", searchUrl=");
            sbR.append((Object) this.searchUrl);
            sbR.append(", ruleSearch=");
            sbR.append(this.ruleSearch);
            sbR.append(", ruleBookInfo=");
            sbR.append(this.ruleBookInfo);
            sbR.append(", ruleToc=");
            sbR.append(this.ruleToc);
            sbR.append(", ruleContent=");
            sbR.append(this.ruleContent);
            sbR.append(')');
            return sbR.toString();
        }

        public /* synthetic */ BookSourceAny(String str, String str2, String str3, int i2, String str4, int i3, boolean z, boolean z2, String str5, String str6, String str7, long j2, int i4, String str8, Object obj, String str9, Object obj2, Object obj3, Object obj4, Object obj5, int i5, f.c0.c.f fVar) {
            this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? null : str2, (i5 & 4) != 0 ? "" : str3, (i5 & 8) != 0 ? 0 : i2, (i5 & 16) != 0 ? null : str4, (i5 & 32) != 0 ? 0 : i3, (i5 & 64) != 0 ? true : z, (i5 & 128) == 0 ? z2 : true, (i5 & 256) != 0 ? null : str5, (i5 & 512) != 0 ? null : str6, (i5 & 1024) == 0 ? str7 : "", (i5 & 2048) != 0 ? 0L : j2, (i5 & 4096) == 0 ? i4 : 0, (i5 & 8192) != 0 ? null : str8, (i5 & 16384) != 0 ? null : obj, (i5 & 32768) != 0 ? null : str9, (i5 & 65536) != 0 ? null : obj2, (i5 & 131072) != 0 ? null : obj3, (i5 & 262144) != 0 ? null : obj4, (i5 & 524288) != 0 ? null : obj5);
        }
    }
}
