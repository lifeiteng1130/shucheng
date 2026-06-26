package io.legado.app.model.rss;

import f.c0.c.j;
import f.h0.k;
import f.x.e;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.model.Debug;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: RssParserDefault.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\r¨\u0006\u001b"}, d2 = {"Lio/legado/app/model/rss/RssParserDefault;", "", "", "input", "getImageUrl", "(Ljava/lang/String;)Ljava/lang/String;", "sortName", "xml", "sourceUrl", "Lio/legado/app/model/rss/RssResult;", "parseXML", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/model/rss/RssResult;", "RSS_ITEM_ENCLOSURE", "Ljava/lang/String;", "RSS_ITEM_TITLE", "RSS_ITEM_LINK", "RSS_ITEM_PUB_DATE", "RSS_ITEM_CATEGORY", "RSS_ITEM_CONTENT", "RSS_ITEM_TIME", "RSS_ITEM_TYPE", "RSS_ITEM_DESCRIPTION", "RSS_ITEM", "RSS_ITEM_THUMBNAIL", "RSS_ITEM_URL", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssParserDefault {

    @NotNull
    public static final RssParserDefault INSTANCE = new RssParserDefault();

    @NotNull
    private static final String RSS_ITEM = "item";

    @NotNull
    private static final String RSS_ITEM_CATEGORY = "category";

    @NotNull
    private static final String RSS_ITEM_CONTENT = "content:encoded";

    @NotNull
    private static final String RSS_ITEM_DESCRIPTION = "description";

    @NotNull
    private static final String RSS_ITEM_ENCLOSURE = "enclosure";

    @NotNull
    private static final String RSS_ITEM_LINK = "link";

    @NotNull
    private static final String RSS_ITEM_PUB_DATE = "pubDate";

    @NotNull
    private static final String RSS_ITEM_THUMBNAIL = "media:thumbnail";

    @NotNull
    private static final String RSS_ITEM_TIME = "time";

    @NotNull
    private static final String RSS_ITEM_TITLE = "title";

    @NotNull
    private static final String RSS_ITEM_TYPE = "type";

    @NotNull
    private static final String RSS_ITEM_URL = "url";

    private RssParserDefault() {
    }

    private final String getImageUrl(String input) {
        Pattern patternCompile = Pattern.compile("(<img [^>]*>)", 0);
        j.d(patternCompile, "java.util.regex.Pattern.compile(this, flags)");
        Matcher matcher = patternCompile.matcher(input);
        if (matcher.find()) {
            String strGroup = matcher.group(1);
            Pattern patternCompile2 = Pattern.compile("src\\s*=\\s*\"([^\"]+)\"", 0);
            j.d(patternCompile2, "java.util.regex.Pattern.compile(this, flags)");
            j.c(strGroup);
            Matcher matcher2 = patternCompile2.matcher(strGroup);
            if (matcher2.find()) {
                String strGroup2 = matcher2.group(1);
                j.c(strGroup2);
                return k.R(strGroup2).toString();
            }
        }
        return null;
    }

    @NotNull
    public final RssResult parseXML(@NotNull String sortName, @NotNull String xml, @NotNull String sourceUrl) throws XmlPullParserException, IOException {
        String attributeValue;
        j.e(sortName, "sortName");
        j.e(xml, "xml");
        j.e(sourceUrl, "sourceUrl");
        ArrayList arrayList = new ArrayList();
        RssArticle rssArticle = new RssArticle(null, null, null, 0L, null, null, null, null, null, false, null, 2047, null);
        XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
        xmlPullParserFactoryNewInstance.setNamespaceAware(false);
        XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(xml));
        int eventType = xmlPullParserNewPullParser.getEventType();
        boolean z = false;
        while (eventType != 1) {
            if (eventType == 2) {
                if (k.i(xmlPullParserNewPullParser.getName(), RSS_ITEM, true)) {
                    z = true;
                } else if (k.i(xmlPullParserNewPullParser.getName(), RSS_ITEM_TITLE, true)) {
                    if (z) {
                        String strNextText = xmlPullParserNewPullParser.nextText();
                        j.d(strNextText, "xmlPullParser.nextText()");
                        rssArticle.setTitle(k.R(strNextText).toString());
                    }
                } else if (k.i(xmlPullParserNewPullParser.getName(), RSS_ITEM_LINK, true)) {
                    if (z) {
                        String strNextText2 = xmlPullParserNewPullParser.nextText();
                        j.d(strNextText2, "xmlPullParser.nextText()");
                        rssArticle.setLink(k.R(strNextText2).toString());
                    }
                } else if (k.i(xmlPullParserNewPullParser.getName(), RSS_ITEM_THUMBNAIL, true)) {
                    if (z) {
                        rssArticle.setImage(xmlPullParserNewPullParser.getAttributeValue(null, RSS_ITEM_URL));
                    }
                } else if (k.i(xmlPullParserNewPullParser.getName(), RSS_ITEM_ENCLOSURE, true)) {
                    if (z && (attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "type")) != null && k.d(attributeValue, "image/", false, 2)) {
                        rssArticle.setImage(xmlPullParserNewPullParser.getAttributeValue(null, RSS_ITEM_URL));
                    }
                } else if (k.i(xmlPullParserNewPullParser.getName(), RSS_ITEM_DESCRIPTION, true)) {
                    if (z) {
                        String strNextText3 = xmlPullParserNewPullParser.nextText();
                        j.d(strNextText3, RSS_ITEM_DESCRIPTION);
                        rssArticle.setDescription(k.R(strNextText3).toString());
                        if (rssArticle.getImage() == null) {
                            rssArticle.setImage(getImageUrl(strNextText3));
                        }
                    }
                } else if (k.i(xmlPullParserNewPullParser.getName(), RSS_ITEM_CONTENT, true)) {
                    if (z) {
                        String strNextText4 = xmlPullParserNewPullParser.nextText();
                        j.d(strNextText4, "xmlPullParser.nextText()");
                        String string = k.R(strNextText4).toString();
                        rssArticle.setContent(string);
                        if (rssArticle.getImage() == null) {
                            rssArticle.setImage(getImageUrl(string));
                        }
                    }
                } else if (k.i(xmlPullParserNewPullParser.getName(), RSS_ITEM_PUB_DATE, true)) {
                    if (z) {
                        if (xmlPullParserNewPullParser.next() == 4) {
                            String text = xmlPullParserNewPullParser.getText();
                            j.d(text, "xmlPullParser.text");
                            rssArticle.setPubDate(k.R(text).toString());
                        }
                    }
                } else if (k.i(xmlPullParserNewPullParser.getName(), "time", true) && z) {
                    rssArticle.setPubDate(xmlPullParserNewPullParser.nextText());
                }
            } else if (eventType == 3 && k.i(xmlPullParserNewPullParser.getName(), RSS_ITEM, true)) {
                rssArticle.setOrigin(sourceUrl);
                rssArticle.setSort(sortName);
                arrayList.add(rssArticle);
                rssArticle = new RssArticle(null, null, null, 0L, null, null, null, null, null, false, null, 2047, null);
                z = false;
            }
            eventType = xmlPullParserNewPullParser.next();
        }
        RssArticle rssArticle2 = (RssArticle) e.l(arrayList);
        if (rssArticle2 != null) {
            Debug debug = Debug.INSTANCE;
            Debug.log$default(debug, sourceUrl, "┌获取标题", false, false, false, 0, 60, null);
            Debug.log$default(debug, sourceUrl, j.k("└", rssArticle2.getTitle()), false, false, false, 0, 60, null);
            Debug.log$default(debug, sourceUrl, "┌获取时间", false, false, false, 0, 60, null);
            Debug.log$default(debug, sourceUrl, j.k("└", rssArticle2.getPubDate()), false, false, false, 0, 60, null);
            Debug.log$default(debug, sourceUrl, "┌获取描述", false, false, false, 0, 60, null);
            Debug.log$default(debug, sourceUrl, j.k("└", rssArticle2.getDescription()), false, false, false, 0, 60, null);
            Debug.log$default(debug, sourceUrl, "┌获取图片url", false, false, false, 0, 60, null);
            Debug.log$default(debug, sourceUrl, j.k("└", rssArticle2.getImage()), false, false, false, 0, 60, null);
            Debug.log$default(debug, sourceUrl, "┌获取文章链接", false, false, false, 0, 60, null);
            Debug.log$default(debug, sourceUrl, j.k("└", rssArticle2.getLink()), false, false, false, 0, 60, null);
        }
        return new RssResult(arrayList, null);
    }
}
