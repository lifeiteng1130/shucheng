package io.legado.app.model.rss;

import androidx.annotation.Keep;
import c.b.a.m.f;
import e.a.a.h.n;
import e.a.a.h.x;
import f.c0.c.j;
import f.h0.k;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.data.entities.RssSource;
import io.legado.app.model.Debug;
import io.legado.app.model.analyzeRule.AnalyzeRule;
import io.legado.app.model.analyzeRule.RuleDataInterface;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssParserByRule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u008b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00050\t2\u0010\u0010\f\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00050\t2\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00050\t2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00050\t2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\nR\u00020\u00050\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lio/legado/app/model/rss/RssParserByRule;", "", "", "sourceUrl", "item", "Lio/legado/app/model/analyzeRule/AnalyzeRule;", "analyzeRule", "", "log", "", "Lio/legado/app/model/analyzeRule/AnalyzeRule$SourceRule;", "ruleTitle", "rulePubDate", "ruleDescription", "ruleImage", "ruleLink", "Lio/legado/app/data/entities/RssArticle;", "getItem", "(Ljava/lang/String;Ljava/lang/Object;Lio/legado/app/model/analyzeRule/AnalyzeRule;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lio/legado/app/data/entities/RssArticle;", "sortName", "sortUrl", "body", "Lio/legado/app/data/entities/RssSource;", "rssSource", "Lio/legado/app/model/analyzeRule/RuleDataInterface;", "ruleData", "Lio/legado/app/model/rss/RssResult;", "parseXML", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/legado/app/data/entities/RssSource;Lio/legado/app/model/analyzeRule/RuleDataInterface;)Lio/legado/app/model/rss/RssResult;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssParserByRule {

    @NotNull
    public static final RssParserByRule INSTANCE = new RssParserByRule();

    private RssParserByRule() {
    }

    private final RssArticle getItem(String sourceUrl, Object item, AnalyzeRule analyzeRule, boolean log, List<AnalyzeRule.SourceRule> ruleTitle, List<AnalyzeRule.SourceRule> rulePubDate, List<AnalyzeRule.SourceRule> ruleDescription, List<AnalyzeRule.SourceRule> ruleImage, List<AnalyzeRule.SourceRule> ruleLink) {
        RssArticle rssArticle = new RssArticle(null, null, null, 0L, null, null, null, null, null, false, null, 2047, null);
        AnalyzeRule.setContent$default(analyzeRule, item, null, 2, null);
        Debug debug = Debug.INSTANCE;
        Debug.log$default(debug, sourceUrl, "┌获取标题", log, false, false, 0, 56, null);
        rssArticle.setTitle(AnalyzeRule.getString$default(analyzeRule, (List) ruleTitle, false, (String) null, 6, (Object) null));
        Debug.log$default(debug, sourceUrl, j.k("└", rssArticle.getTitle()), log, false, false, 0, 56, null);
        Debug.log$default(debug, sourceUrl, "┌获取时间", log, false, false, 0, 56, null);
        rssArticle.setPubDate(AnalyzeRule.getString$default(analyzeRule, (List) rulePubDate, false, (String) null, 6, (Object) null));
        Debug.log$default(debug, sourceUrl, j.k("└", rssArticle.getPubDate()), log, false, false, 0, 56, null);
        Debug.log$default(debug, sourceUrl, "┌获取描述", log, false, false, 0, 56, null);
        if (ruleDescription == null || ruleDescription.isEmpty()) {
            rssArticle.setDescription(null);
            Debug.log$default(debug, sourceUrl, "└描述规则为空，将会解析内容页", log, false, false, 0, 56, null);
        } else {
            rssArticle.setDescription(AnalyzeRule.getString$default(analyzeRule, (List) ruleDescription, false, (String) null, 6, (Object) null));
            Debug.log$default(debug, sourceUrl, j.k("└", rssArticle.getDescription()), log, false, false, 0, 56, null);
        }
        Debug.log$default(debug, sourceUrl, "┌获取图片url", log, false, false, 0, 56, null);
        rssArticle.setImage(AnalyzeRule.getString$default(analyzeRule, (List) ruleImage, true, (String) null, 4, (Object) null));
        Debug.log$default(debug, sourceUrl, j.k("└", rssArticle.getImage()), log, false, false, 0, 56, null);
        Debug.log$default(debug, sourceUrl, "┌获取文章链接", log, false, false, 0, 56, null);
        x xVar = x.a;
        rssArticle.setLink(x.a(sourceUrl, AnalyzeRule.getString$default(analyzeRule, (List) ruleLink, false, (String) null, 6, (Object) null)));
        Debug.log$default(debug, sourceUrl, j.k("└", rssArticle.getLink()), log, false, false, 0, 56, null);
        rssArticle.setVariable(n.a().toJson(analyzeRule.getRuleData().getVariableMap()));
        if (k.s(rssArticle.getTitle())) {
            return null;
        }
        return rssArticle;
    }

    @NotNull
    public final RssResult parseXML(@NotNull String sortName, @NotNull String sortUrl, @Nullable String body, @NotNull RssSource rssSource, @NotNull RuleDataInterface ruleData) throws Exception {
        boolean z;
        String strA = sortUrl;
        j.e(sortName, "sortName");
        j.e(strA, "sortUrl");
        j.e(rssSource, "rssSource");
        j.e(ruleData, "ruleData");
        String sourceUrl = rssSource.getSourceUrl();
        if (body == null || k.s(body)) {
            throw new Exception(h.g().getString(R.string.error_get_web_content, rssSource.getSourceUrl()));
        }
        Debug debug = Debug.INSTANCE;
        Debug.log$default(debug, sourceUrl, j.k("≡获取成功:", sourceUrl), false, false, false, 0, 60, null);
        Debug.log$default(debug, sourceUrl, body, false, false, false, 10, 28, null);
        String ruleArticles = rssSource.getRuleArticles();
        if (ruleArticles == null || k.s(ruleArticles)) {
            Debug.log$default(debug, sourceUrl, "⇒列表规则为空, 使用默认规则解析", false, false, false, 0, 60, null);
            return RssParserDefault.INSTANCE.parseXML(sortName, body, sourceUrl);
        }
        ArrayList arrayList = new ArrayList();
        AnalyzeRule analyzeRule = new AnalyzeRule(ruleData);
        AnalyzeRule.setContent$default(analyzeRule, body, null, 2, null).setBaseUrl(strA);
        analyzeRule.setRedirectUrl(strA);
        if (k.K(ruleArticles, "-", false, 2)) {
            Objects.requireNonNull(ruleArticles, "null cannot be cast to non-null type java.lang.String");
            ruleArticles = ruleArticles.substring(1);
            j.d(ruleArticles, "(this as java.lang.String).substring(startIndex)");
            z = true;
        } else {
            z = false;
        }
        AnalyzeRule analyzeRule2 = analyzeRule;
        Debug.log$default(debug, sourceUrl, "┌获取列表", false, false, false, 0, 60, null);
        List<Object> elements = analyzeRule2.getElements(ruleArticles);
        Debug.log$default(debug, sourceUrl, j.k("└列表大小:", Integer.valueOf(elements.size())), false, false, false, 0, 60, null);
        String ruleNextPage = rssSource.getRuleNextPage();
        if (ruleNextPage == null || ruleNextPage.length() == 0) {
            strA = null;
        } else {
            Debug.log$default(debug, sourceUrl, "┌获取下一页链接", false, false, false, 0, 60, null);
            String ruleNextPage2 = rssSource.getRuleNextPage();
            j.c(ruleNextPage2);
            Locale locale = Locale.getDefault();
            j.d(locale, "getDefault()");
            String upperCase = ruleNextPage2.toUpperCase(locale);
            j.d(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            if (!j.a(upperCase, "PAGE")) {
                String string$default = AnalyzeRule.getString$default(analyzeRule2, rssSource.getRuleNextPage(), false, (String) null, 6, (Object) null);
                if (string$default.length() > 0) {
                    x xVar = x.a;
                    strA = x.a(strA, string$default);
                } else {
                    strA = string$default;
                }
            }
            Debug.log$default(debug, sourceUrl, j.k("└", strA), false, false, false, 0, 60, null);
        }
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default = AnalyzeRule.splitSourceRule$default(analyzeRule2, rssSource.getRuleTitle(), null, 2, null);
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default2 = AnalyzeRule.splitSourceRule$default(analyzeRule2, rssSource.getRulePubDate(), null, 2, null);
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default3 = AnalyzeRule.splitSourceRule$default(analyzeRule2, rssSource.getRuleDescription(), null, 2, null);
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default4 = AnalyzeRule.splitSourceRule$default(analyzeRule2, rssSource.getRuleImage(), null, 2, null);
        List<AnalyzeRule.SourceRule> listSplitSourceRule$default5 = AnalyzeRule.splitSourceRule$default(analyzeRule2, rssSource.getRuleLink(), null, 2, null);
        Iterator<Object> it = elements.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            AnalyzeRule analyzeRule3 = analyzeRule2;
            RssArticle item = getItem(sourceUrl, it.next(), analyzeRule2, i2 == 0, listSplitSourceRule$default, listSplitSourceRule$default2, listSplitSourceRule$default3, listSplitSourceRule$default4, listSplitSourceRule$default5);
            if (item != null) {
                item.setSort(sortName);
                item.setOrigin(sourceUrl);
                arrayList.add(item);
            }
            i2 = i3;
            analyzeRule2 = analyzeRule3;
        }
        if (z) {
            f.P4(arrayList);
        }
        return new RssResult(arrayList, strA);
    }
}
