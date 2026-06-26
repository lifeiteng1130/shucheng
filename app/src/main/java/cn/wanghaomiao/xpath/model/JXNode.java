package cn.wanghaomiao.xpath.model;

import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class JXNode {
    private Element element;
    private boolean isText;
    private String textVal;

    public static JXNode e(Element element) {
        JXNode jXNode = new JXNode();
        jXNode.setElement(element).setText(false);
        return jXNode;
    }

    public static JXNode t(String str) {
        JXNode jXNode = new JXNode();
        jXNode.setTextVal(str).setText(true);
        return jXNode;
    }

    public Element getElement() {
        return this.element;
    }

    public String getTextVal() {
        return this.textVal;
    }

    public boolean isText() {
        return this.isText;
    }

    public List<JXNode> sel(String str) {
        if (this.element == null) {
            return null;
        }
        return new JXDocument(new Elements(this.element)).selN(str);
    }

    public JXNode setElement(Element element) {
        this.element = element;
        return this;
    }

    public JXNode setText(boolean z) {
        this.isText = z;
        return this;
    }

    public JXNode setTextVal(String str) {
        this.textVal = str;
        return this;
    }

    public String toString() {
        return this.isText ? this.textVal : this.element.toString();
    }
}
