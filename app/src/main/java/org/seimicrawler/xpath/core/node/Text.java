package org.seimicrawler.xpath.core.node;

import androidx.core.app.NotificationCompat;
import java.util.LinkedList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.core.NodeTest;
import org.seimicrawler.xpath.core.Scope;
import org.seimicrawler.xpath.core.XValue;
import org.seimicrawler.xpath.util.Scanner;

/* JADX INFO: loaded from: classes3.dex */
public class Text implements NodeTest {
    @Override // org.seimicrawler.xpath.core.NodeTest
    public XValue call(Scope scope) {
        Elements elementsContext = scope.context();
        LinkedList linkedList = new LinkedList();
        if (elementsContext != null && elementsContext.size() > 0) {
            if (scope.isRecursion()) {
                return Scanner.findNodeTestByName("allText").call(scope);
            }
            for (Element element : elementsContext) {
                if ("script".equals(element.nodeName())) {
                    linkedList.add(element.data());
                } else {
                    linkedList.add(element.ownText());
                }
            }
        }
        return XValue.create(linkedList);
    }

    @Override // org.seimicrawler.xpath.core.NodeTest
    public String name() {
        return NotificationCompat.MessagingStyle.Message.KEY_TEXT;
    }
}
