package com.efs.sdk.base.protocol.file.section;

import c.a.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public class JSONSection extends AbsSection {
    private String body;

    public JSONSection(String str) {
        super("json");
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
