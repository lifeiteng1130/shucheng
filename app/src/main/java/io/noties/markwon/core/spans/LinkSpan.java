package io.noties.markwon.core.spans;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import androidx.annotation.NonNull;
import e.b.a.c;
import e.b.a.d;
import e.b.a.p.r;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class LinkSpan extends URLSpan {
    public final r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f7805c;

    public LinkSpan(@NonNull r rVar, @NonNull String str, @NonNull c cVar) {
        super(str);
        this.a = rVar;
        this.f7804b = str;
        this.f7805c = cVar;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        c cVar = this.f7805c;
        String str = this.f7804b;
        Objects.requireNonNull((d) cVar);
        Uri uriBuild = Uri.parse(str);
        if (TextUtils.isEmpty(uriBuild.getScheme())) {
            uriBuild = uriBuild.buildUpon().scheme("https").build();
        }
        Context context = view.getContext();
        Intent intent = new Intent("android.intent.action.VIEW", uriBuild);
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        textPaint.setUnderlineText(this.a.f5997b);
        textPaint.setColor(textPaint.linkColor);
    }
}
