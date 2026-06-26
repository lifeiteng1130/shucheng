package org.mozilla.javascript.ast;

import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes3.dex */
public abstract class XmlFragment extends AstNode {
    public XmlFragment() {
        this.type = Token.XML;
    }

    public XmlFragment(int i2) {
        super(i2);
        this.type = Token.XML;
    }

    public XmlFragment(int i2, int i3) {
        super(i2, i3);
        this.type = Token.XML;
    }
}
