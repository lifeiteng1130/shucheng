package javax.script;

import c.a.a.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class ScriptException extends Exception {
    private int columnNumber;
    private String fileName;
    private int lineNumber;

    public ScriptException(String str) {
        super(str);
        this.fileName = null;
        this.lineNumber = -1;
        this.columnNumber = -1;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (this.fileName == null) {
            return message;
        }
        StringBuilder sbT = a.t(message, " in ");
        sbT.append(this.fileName);
        String string = sbT.toString();
        if (this.lineNumber != -1) {
            StringBuilder sbT2 = a.t(string, " at line number ");
            sbT2.append(this.lineNumber);
            string = sbT2.toString();
        }
        if (this.columnNumber == -1) {
            return string;
        }
        StringBuilder sbT3 = a.t(string, " at column number ");
        sbT3.append(this.columnNumber);
        return sbT3.toString();
    }

    public ScriptException(Exception exc) {
        super(exc);
        this.fileName = null;
        this.lineNumber = -1;
        this.columnNumber = -1;
    }

    public ScriptException(String str, String str2, int i2) {
        super(str);
        this.fileName = str2;
        this.lineNumber = i2;
        this.columnNumber = -1;
    }

    public ScriptException(String str, String str2, int i2, int i3) {
        super(str);
        this.fileName = str2;
        this.lineNumber = i2;
        this.columnNumber = i3;
    }
}
