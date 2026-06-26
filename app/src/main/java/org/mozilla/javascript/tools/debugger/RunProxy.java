package org.mozilla.javascript.tools.debugger;

import c.a.a.a.a;
import org.mozilla.javascript.tools.debugger.Dim;

/* JADX INFO: compiled from: SwingGui.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunProxy implements Runnable {
    public static final int ENTER_INTERRUPT = 4;
    public static final int LOAD_FILE = 2;
    public static final int OPEN_FILE = 1;
    public static final int UPDATE_SOURCE_TEXT = 3;
    public String alertMessage;
    private SwingGui debugGui;
    public String fileName;
    public Dim.StackFrame lastFrame;
    public Dim.SourceInfo sourceInfo;
    public String text;
    public String threadTitle;
    private int type;

    public RunProxy(SwingGui swingGui, int i2) {
        this.debugGui = swingGui;
        this.type = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = this.type;
        if (i2 == 1) {
            try {
                this.debugGui.dim.compileScript(this.fileName, this.text);
                return;
            } catch (RuntimeException e2) {
                SwingGui swingGui = this.debugGui;
                String message = e2.getMessage();
                StringBuilder sbR = a.r("Error Compiling ");
                sbR.append(this.fileName);
                MessageDialogWrapper.showMessageDialog(swingGui, message, sbR.toString(), 0);
                return;
            }
        }
        if (i2 == 2) {
            try {
                this.debugGui.dim.evalScript(this.fileName, this.text);
                return;
            } catch (RuntimeException e3) {
                SwingGui swingGui2 = this.debugGui;
                String message2 = e3.getMessage();
                StringBuilder sbR2 = a.r("Run error for ");
                sbR2.append(this.fileName);
                MessageDialogWrapper.showMessageDialog(swingGui2, message2, sbR2.toString(), 0);
                return;
            }
        }
        if (i2 != 3) {
            if (i2 != 4) {
                throw new IllegalArgumentException(String.valueOf(this.type));
            }
            this.debugGui.enterInterruptImpl(this.lastFrame, this.threadTitle, this.alertMessage);
        } else {
            String strUrl = this.sourceInfo.url();
            if (this.debugGui.updateFileWindow(this.sourceInfo) || strUrl.equals("<stdin>")) {
                return;
            }
            this.debugGui.createFileWindow(this.sourceInfo, -1);
        }
    }
}
