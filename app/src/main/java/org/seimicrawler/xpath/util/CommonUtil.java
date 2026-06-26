package org.seimicrawler.xpath.util;

import java.util.Objects;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.core.Scope;

/* JADX INFO: loaded from: classes3.dex */
public class CommonUtil {
    public static Elements followingSibling(Element element) {
        Elements elements = new Elements();
        for (Element elementNextElementSibling = element.nextElementSibling(); elementNextElementSibling != null; elementNextElementSibling = elementNextElementSibling.nextElementSibling()) {
            elements.add(elementNextElementSibling);
        }
        if (elements.size() > 0) {
            return elements;
        }
        return null;
    }

    public static int getElIndexInSameTags(Element element, Scope scope) {
        int i2 = 1;
        for (Element element2 : element.parent().children()) {
            if (element.tagName().equals(element2.tagName()) && scope.context().contains(element2)) {
                if (element.equals(element2)) {
                    break;
                }
                i2++;
            }
        }
        return i2;
    }

    public static int getIndexInContext(Scope scope, Element element) {
        for (int i2 = 0; i2 < scope.context().size(); i2++) {
            if (Objects.equals(scope.context().get(i2), element)) {
                return i2 + 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static Elements precedingSibling(Element element) {
        Elements elements = new Elements();
        for (Element elementPreviousElementSibling = element.previousElementSibling(); elementPreviousElementSibling != null; elementPreviousElementSibling = elementPreviousElementSibling.previousElementSibling()) {
            elements.add(elementPreviousElementSibling);
        }
        if (elements.size() > 0) {
            return elements;
        }
        return null;
    }

    public static int sameTagElNums(Element element, Scope scope) {
        Elements elements = new Elements();
        for (Element element2 : element.parent().getElementsByTag(element.tagName())) {
            if (scope.context().contains(element2)) {
                elements.add(element2);
            }
        }
        return elements.size();
    }
}
