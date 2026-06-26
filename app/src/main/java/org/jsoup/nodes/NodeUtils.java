package org.jsoup.nodes;

import org.jsoup.nodes.Document;
import org.jsoup.parser.HtmlTreeBuilder;
import org.jsoup.parser.Parser;

/* JADX INFO: loaded from: classes3.dex */
public final class NodeUtils {
    public static Document.OutputSettings outputSettings(Node node) {
        Document documentOwnerDocument = node.ownerDocument();
        if (documentOwnerDocument == null) {
            documentOwnerDocument = new Document("");
        }
        return documentOwnerDocument.outputSettings();
    }

    public static Parser parser(Node node) {
        Document documentOwnerDocument = node.ownerDocument();
        return (documentOwnerDocument == null || documentOwnerDocument.parser() == null) ? new Parser(new HtmlTreeBuilder()) : documentOwnerDocument.parser();
    }
}
