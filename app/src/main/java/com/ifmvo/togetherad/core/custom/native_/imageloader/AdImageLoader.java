package com.ifmvo.togetherad.core.custom.native_.imageloader;

import android.content.Context;
import android.widget.ImageView;
import com.umeng.analytics.pro.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AdImageLoader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ifmvo/togetherad/core/custom/native_/imageloader/AdImageLoader;", "", "Landroid/content/Context;", c.R, "Landroid/widget/ImageView;", "imageView", "", "imgUrl", "Lf/v;", "loadImage", "(Landroid/content/Context;Landroid/widget/ImageView;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 0})
public interface AdImageLoader {
    void loadImage(@NotNull Context context, @NotNull ImageView imageView, @NotNull String imgUrl);
}
