package com.efs.sdk.base.protocol.file.section;

import androidx.core.app.NotificationCompat;
import c.a.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public class TextSection extends AbsSection {
    private String body;

    public TextSection(String str) {
        super(NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.name = str;
    }

    @Override // com.efs.sdk.base.protocol.file.section.AbsSection
    public String changeToStr() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDeclarationLine());
        sb.append("\n");
        return a.p(sb, this.body, "\n");
    }

    public void setBody(String str) {
        this.body = str;
    }
}
