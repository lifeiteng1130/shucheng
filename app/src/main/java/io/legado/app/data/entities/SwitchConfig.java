package io.legado.app.data.entities;

import kotlin.Metadata;

/* JADX INFO: compiled from: SwitchConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lio/legado/app/data/entities/SwitchConfig;", "", "", "feedBack", "Z", "getFeedBack", "()Z", "setFeedBack", "(Z)V", "sourceGroup", "getSourceGroup", "setSourceGroup", "bookRecomand", "getBookRecomand", "setBookRecomand", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SwitchConfig {
    private boolean bookRecomand;
    private boolean feedBack;
    private boolean sourceGroup;

    public final boolean getBookRecomand() {
        return this.bookRecomand;
    }

    public final boolean getFeedBack() {
        return this.feedBack;
    }

    public final boolean getSourceGroup() {
        return this.sourceGroup;
    }

    public final void setBookRecomand(boolean z) {
        this.bookRecomand = z;
    }

    public final void setFeedBack(boolean z) {
        this.feedBack = z;
    }

    public final void setSourceGroup(boolean z) {
        this.sourceGroup = z;
    }
}
