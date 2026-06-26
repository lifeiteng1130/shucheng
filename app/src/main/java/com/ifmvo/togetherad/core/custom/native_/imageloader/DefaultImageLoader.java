package com.ifmvo.togetherad.core.custom.native_.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.ifmvo.togetherad.core.custom.native_.imageloader.DefaultImageLoader;
import com.ifmvo.togetherad.core.utils.LogExtKt;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.k;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultImageLoader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/ifmvo/togetherad/core/custom/native_/imageloader/DefaultImageLoader;", "Lcom/ifmvo/togetherad/core/custom/native_/imageloader/AdImageLoader;", "Landroid/content/Context;", c.R, "Landroid/widget/ImageView;", "imageView", "", "imgUrl", "Lf/v;", "loadImage", "(Landroid/content/Context;Landroid/widget/ImageView;Ljava/lang/String;)V", "<init>", "()V", "Async", "core_release"}, k = 1, mv = {1, 4, 0})
public final class DefaultImageLoader implements AdImageLoader {

    /* JADX INFO: compiled from: DefaultImageLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/ifmvo/togetherad/core/custom/native_/imageloader/DefaultImageLoader$Async;", "", "Ljava/util/concurrent/Executor;", "cache", "Ljava/util/concurrent/Executor;", "getCache$core_release", "()Ljava/util/concurrent/Executor;", "Landroid/os/Handler;", "HANDLER", "Landroid/os/Handler;", "main", "getMain$core_release", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 0})
    public static final class Async {
        private static final Handler HANDLER;
        public static final Async INSTANCE = new Async();

        @NotNull
        private static final Executor cache;

        @NotNull
        private static final Executor main;

        static {
            ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
            j.b(executorServiceNewCachedThreadPool, "Executors.newCachedThreadPool()");
            cache = executorServiceNewCachedThreadPool;
            HANDLER = new Handler(Looper.getMainLooper());
            main = new Executor() { // from class: com.ifmvo.togetherad.core.custom.native_.imageloader.DefaultImageLoader$Async$main$1
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    DefaultImageLoader.Async async = DefaultImageLoader.Async.INSTANCE;
                    DefaultImageLoader.Async.HANDLER.post(runnable);
                }
            };
        }

        private Async() {
        }

        @NotNull
        public final Executor getCache$core_release() {
            return cache;
        }

        @NotNull
        public final Executor getMain$core_release() {
            return main;
        }
    }

    @Override // com.ifmvo.togetherad.core.custom.native_.imageloader.AdImageLoader
    public void loadImage(@NotNull Context context, @NotNull final ImageView imageView, @NotNull final String imgUrl) {
        j.f(context, c.R);
        j.f(imageView, "imageView");
        j.f(imgUrl, "imgUrl");
        try {
            Async.INSTANCE.getCache$core_release().execute(new Runnable() { // from class: com.ifmvo.togetherad.core.custom.native_.imageloader.DefaultImageLoader.loadImage.1
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    URLConnection uRLConnectionOpenConnection = new URL(imgUrl).openConnection();
                    if (uRLConnectionOpenConnection == null) {
                        throw new k("null cannot be cast to non-null type java.net.HttpURLConnection");
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                    Async.INSTANCE.getMain$core_release().execute(new Runnable() { // from class: com.ifmvo.togetherad.core.custom.native_.imageloader.DefaultImageLoader.loadImage.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            imageView.setImageBitmap(bitmapDecodeStream);
                        }
                    });
                }
            });
        } catch (Exception e2) {
            LogExtKt.loge$default("\n    |-------------------------------------------------------------------------------------- \n    |  DefaultImageLoader 默认的图片加载器出现异常，请自行设置图片加载器\n    |  设置方式,在 Application 中添加如下：\n    |  TogetherAd.setCustomImageLoader(object : AdImageLoader {\n    |      override fun loadImage(context: Context, imageView: ImageView, imgUrl: String) {\n    |          //以 Glide 为例\n    |          Glide.with(context).load(imgUrl).into(imageView)\n    |      }\n    |  })\n    |--------------------------------------------------------------------------------------\n\n", null, 1, null);
            e2.printStackTrace();
        }
    }
}
