package e.a.a.h;

import org.jetbrains.annotations.NotNull;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.CDataNode;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeVisitor;

/* JADX INFO: compiled from: JsoupExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements NodeVisitor {
    public final /* synthetic */ StringBuilder a;

    public s(StringBuilder sb) {
        this.a = sb;
    }

    @Override // org.jsoup.select.NodeVisitor
    public void head(@NotNull Node node, int i2) {
        f.c0.c.j.e(node, "node");
        if (!(node instanceof TextNode)) {
            if (node instanceof Element) {
                StringBuilder sb = this.a;
                f.c0.c.j.d(sb, "sb");
                if (sb.length() > 0) {
                    Element element = (Element) node;
                    if (element.isBlock() || f.c0.c.j.a(element.tag().getName(), "br")) {
                        StringBuilder sb2 = this.a;
                        f.c0.c.j.d(sb2, "sb");
                        if (c.b.a.m.f.K3(sb2)) {
                            return;
                        }
                        this.a.append("\n");
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        StringBuilder sb3 = this.a;
        f.c0.c.j.d(sb3, "sb");
        TextNode textNode = (TextNode) node;
        String wholeText = textNode.getWholeText();
        Node nodeParentNode = textNode.parentNode();
        if (nodeParentNode instanceof Element) {
            Element elementParent = (Element) nodeParentNode;
            int i3 = 0;
            while (true) {
                if (elementParent.tag().preserveWhitespace()) {
                    z = true;
                    break;
                }
                elementParent = elementParent.parent();
                i3++;
                if (i3 >= 6 || elementParent == null) {
                    break;
                }
            }
        }
        if (z || (textNode instanceof CDataNode)) {
            sb3.append(wholeText);
        } else {
            StringUtil.appendNormalisedWhitespace(sb3, wholeText, c.b.a.m.f.K3(sb3));
        }
    }

    @Override // org.jsoup.select.NodeVisitor
    public void tail(@NotNull Node node, int i2) {
        f.c0.c.j.e(node, "node");
        if ((node instanceof Element) && ((Element) node).isBlock() && (node.nextSibling() instanceof TextNode)) {
            StringBuilder sb = this.a;
            f.c0.c.j.d(sb, "sb");
            if (c.b.a.m.f.K3(sb)) {
                return;
            }
            this.a.append("\n");
        }
    }
}
