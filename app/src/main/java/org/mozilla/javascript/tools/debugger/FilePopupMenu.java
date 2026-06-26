package org.mozilla.javascript.tools.debugger;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/* JADX INFO: compiled from: SwingGui.java */
/* JADX INFO: loaded from: classes3.dex */
public class FilePopupMenu extends JPopupMenu {
    private static final long serialVersionUID = 3589525009546013565L;
    public int x;
    public int y;

    public FilePopupMenu(FileTextArea fileTextArea) {
        JMenuItem jMenuItem = new JMenuItem("Set Breakpoint");
        add(jMenuItem);
        jMenuItem.addActionListener(fileTextArea);
        JMenuItem jMenuItem2 = new JMenuItem("Clear Breakpoint");
        add(jMenuItem2);
        jMenuItem2.addActionListener(fileTextArea);
        JMenuItem jMenuItem3 = new JMenuItem("Run");
        add(jMenuItem3);
        jMenuItem3.addActionListener(fileTextArea);
    }

    public void show(JComponent jComponent, int i2, int i3) {
        this.x = i2;
        this.y = i3;
        super.show(jComponent, i2, i3);
    }
}
