package k.a.a.a;

import java.io.Serializable;

/* JADX INFO: compiled from: CommonToken.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements j0, Serializable {
    public static final k.a.a.a.m0.k<f0, g> EMPTY_SOURCE = new k.a.a.a.m0.k<>(null, null);
    public int channel;
    public int charPositionInLine;
    public int index;
    public int line;
    public k.a.a.a.m0.k<f0, g> source;
    public int start;
    public int stop;
    public String text;
    public int type;

    public j(int i2) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.type = i2;
        this.source = EMPTY_SOURCE;
    }

    @Override // k.a.a.a.d0
    public int getChannel() {
        return this.channel;
    }

    @Override // k.a.a.a.d0
    public int getCharPositionInLine() {
        return this.charPositionInLine;
    }

    @Override // k.a.a.a.d0
    public g getInputStream() {
        return this.source.f8516b;
    }

    @Override // k.a.a.a.d0
    public int getLine() {
        return this.line;
    }

    @Override // k.a.a.a.d0
    public int getStartIndex() {
        return this.start;
    }

    @Override // k.a.a.a.d0
    public int getStopIndex() {
        return this.stop;
    }

    @Override // k.a.a.a.d0
    public String getText() {
        int i2;
        String str = this.text;
        if (str != null) {
            return str;
        }
        g inputStream = getInputStream();
        if (inputStream == null) {
            return null;
        }
        int size = inputStream.size();
        int i3 = this.start;
        return (i3 >= size || (i2 = this.stop) >= size) ? "<EOF>" : inputStream.f(k.a.a.a.m0.h.c(i3, i2));
    }

    @Override // k.a.a.a.d0
    public int getTokenIndex() {
        return this.index;
    }

    @Override // k.a.a.a.d0
    public f0 getTokenSource() {
        return this.source.a;
    }

    @Override // k.a.a.a.d0
    public int getType() {
        return this.type;
    }

    public void setChannel(int i2) {
        this.channel = i2;
    }

    public void setCharPositionInLine(int i2) {
        this.charPositionInLine = i2;
    }

    public void setLine(int i2) {
        this.line = i2;
    }

    public void setStartIndex(int i2) {
        this.start = i2;
    }

    public void setStopIndex(int i2) {
        this.stop = i2;
    }

    public void setText(String str) {
        this.text = str;
    }

    @Override // k.a.a.a.j0
    public void setTokenIndex(int i2) {
        this.index = i2;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public String toString() {
        return toString(null);
    }

    public String toString(b0 b0Var) {
        String string;
        if (this.channel > 0) {
            StringBuilder sbR = c.a.a.a.a.r(",channel=");
            sbR.append(this.channel);
            string = sbR.toString();
        } else {
            string = "";
        }
        String text = getText();
        String strReplace = text != null ? text.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t") : "<no text>";
        String strValueOf = String.valueOf(this.type);
        if (b0Var != null) {
            strValueOf = ((i0) b0Var.getVocabulary()).a(this.type);
        }
        StringBuilder sbR2 = c.a.a.a.a.r("[@");
        sbR2.append(getTokenIndex());
        sbR2.append(",");
        sbR2.append(this.start);
        sbR2.append(":");
        sbR2.append(this.stop);
        sbR2.append("='");
        sbR2.append(strReplace);
        sbR2.append("',<");
        c.a.a.a.a.z(sbR2, strValueOf, ">", string, ",");
        sbR2.append(this.line);
        sbR2.append(":");
        sbR2.append(getCharPositionInLine());
        sbR2.append("]");
        return sbR2.toString();
    }

    public j(k.a.a.a.m0.k<f0, g> kVar, int i2, int i3, int i4, int i5) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.source = kVar;
        this.type = i2;
        this.channel = i3;
        this.start = i4;
        this.stop = i5;
        f0 f0Var = kVar.a;
        if (f0Var != null) {
            this.line = f0Var.getLine();
            this.charPositionInLine = kVar.a.getCharPositionInLine();
        }
    }

    public j(int i2, String str) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.type = i2;
        this.channel = 0;
        this.text = str;
        this.source = EMPTY_SOURCE;
    }

    public j(d0 d0Var) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.type = d0Var.getType();
        this.line = d0Var.getLine();
        this.index = d0Var.getTokenIndex();
        this.charPositionInLine = d0Var.getCharPositionInLine();
        this.channel = d0Var.getChannel();
        this.start = d0Var.getStartIndex();
        this.stop = d0Var.getStopIndex();
        if (d0Var instanceof j) {
            j jVar = (j) d0Var;
            this.text = jVar.text;
            this.source = jVar.source;
        } else {
            this.text = d0Var.getText();
            this.source = new k.a.a.a.m0.k<>(d0Var.getTokenSource(), d0Var.getInputStream());
        }
    }
}
