package c.b.a.m;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.icu.text.Collator;
import android.icu.util.ULocale;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.Property;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.AttrRes;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.TintTypedArray;
import androidx.camera.core.CameraInfo;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.os.EnvironmentCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.r.c.w;
import c.c.a.g;
import c.e.a.b.k.b;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.flipped.FlippedV2Impl;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.snackbar.Snackbar;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.ReadContext;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.analytics.pro.ai;
import e.a.a.f.s.k;
import e.a.a.h.e0;
import e.a.a.h.f;
import f.c0.c.y;
import f.h;
import f.z.e;
import f.z.f;
import g.b.a0;
import g.b.a1;
import g.b.b0;
import g.b.c2;
import g.b.f0;
import g.b.f1;
import g.b.g0;
import g.b.h0;
import g.b.i0;
import g.b.j0;
import g.b.k0;
import g.b.k1;
import g.b.l1;
import g.b.m0;
import g.b.m1;
import g.b.n1;
import g.b.q0;
import g.b.v1;
import g.b.w1;
import g.b.y1;
import g.b.z;
import h.a.a.b.d;
import io.legado.app.help.JsExtensions;
import io.legado.app.lib.theme.ATH;
import io.legado.app.model.Debug;
import io.legado.app.model.analyzeRule.AnalyzeUrl;
import io.legado.app.model.analyzeRule.QueryTTF;
import io.legado.app.utils.FileUtils;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.noties.markwon.R$id;
import io.noties.markwon.ext.tables.TableRowSpan;
import io.wenyuange.app.release.R;
import j$.C$r8$wrapper$java$util$function$Supplier$WRP;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.charset.Charset;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import java.util.function.Supplier;
import java.util.zip.ZipException;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import k.a.a.a.c0;
import k.a.a.a.d0;
import k.a.a.a.h;
import k.a.a.a.i;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.internal.HidesMembers;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.InternalCoroutinesApi;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.antlr.v4.runtime.tree.xpath.XPath;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.DataUtil;
import org.jsoup.nodes.Attributes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static WeakReference<Signature[]> a;

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    public class a implements d {
        public final /* synthetic */ InputStream a;

        public a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // c.b.a.m.f.d
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.b(this.a);
            } finally {
                this.a.reset();
            }
        }
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    public class b implements c {
        public final /* synthetic */ InputStream a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c.b.a.m.q.c0.b f305b;

        public b(InputStream inputStream, c.b.a.m.q.c0.b bVar) {
            this.a = inputStream;
            this.f305b = bVar;
        }

        @Override // c.b.a.m.f.c
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.c(this.a, this.f305b);
            } finally {
                this.a.reset();
            }
        }
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    public interface c {
        int a(ImageHeaderParser imageHeaderParser);
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    public interface d {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public static class e implements OnApplyWindowInsetsListener {
        public final /* synthetic */ c.e.a.b.q.m a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c.e.a.b.q.n f306b;

        public e(c.e.a.b.q.m mVar, c.e.a.b.q.n nVar) {
            this.a = mVar;
            this.f306b = nVar;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return this.a.a(view, windowInsetsCompat, new c.e.a.b.q.n(this.f306b));
        }
    }

    /* JADX INFO: renamed from: c.b.a.m.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JsExtensions.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @DebugMetadata(c = "io.legado.app.help.JsExtensions$ajax$1", f = "JsExtensions.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0013f extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super String>, Object> {
        public final /* synthetic */ String $urlStr;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0013f(String str, f.z.d<? super C0013f> dVar) {
            super(2, dVar);
            this.$urlStr = str;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new C0013f(this.$urlStr, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super String> dVar) {
            return ((C0013f) create(a0Var, dVar)).invokeSuspend(f.v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Object objM11constructorimpl;
            Object strResponse$default;
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    f.E5(obj);
                    String str = this.$urlStr;
                    AnalyzeUrl analyzeUrl = new AnalyzeUrl(str, null, null, null, null, null, false, null, null, null, null, 2046, null);
                    this.label = 1;
                    strResponse$default = AnalyzeUrl.getStrResponse$default(analyzeUrl, str, null, null, this, 6, null);
                    if (strResponse$default == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f.E5(obj);
                    strResponse$default = obj;
                }
                objM11constructorimpl = f.h.m11constructorimpl(((e.a.a.d.v.l) strResponse$default).f5588b);
            } catch (Throwable th) {
                objM11constructorimpl = f.h.m11constructorimpl(f.m1(th));
            }
            Throwable thM14exceptionOrNullimpl = f.h.m14exceptionOrNullimpl(objM11constructorimpl);
            if (thM14exceptionOrNullimpl != null) {
                thM14exceptionOrNullimpl.printStackTrace();
            }
            Throwable thM14exceptionOrNullimpl2 = f.h.m14exceptionOrNullimpl(objM11constructorimpl);
            return thM14exceptionOrNullimpl2 == null ? objM11constructorimpl : f.C2(thM14exceptionOrNullimpl2);
        }
    }

    /* JADX INFO: compiled from: JsExtensions.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @DebugMetadata(c = "io.legado.app.help.JsExtensions$ajaxAll$1", f = "JsExtensions.kt", i = {0}, l = {55}, m = "invokeSuspend", n = {"asyncArray"}, s = {"L$0"})
    public static final class g extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super e.a.a.d.v.l[]>, Object> {
        public final /* synthetic */ String[] $urlList;
        public int I$0;
        public int I$1;
        public int I$2;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;

        /* JADX INFO: compiled from: JsExtensions.kt */
        @DebugMetadata(c = "io.legado.app.help.JsExtensions$ajaxAll$1$asyncArray$1$1", f = "JsExtensions.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super e.a.a.d.v.l>, Object> {
            public final /* synthetic */ int $tmp;
            public final /* synthetic */ String[] $urlList;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String[] strArr, int i2, f.z.d<? super a> dVar) {
                super(2, dVar);
                this.$urlList = strArr;
                this.$tmp = i2;
            }

            @Override // f.z.j.a.a
            @NotNull
            public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                return new a(this.$urlList, this.$tmp, dVar);
            }

            @Override // f.c0.b.p
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super e.a.a.d.v.l> dVar) {
                return ((a) create(a0Var, dVar)).invokeSuspend(f.v.a);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
                int i2 = this.label;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f.E5(obj);
                    return obj;
                }
                f.E5(obj);
                String str = this.$urlList[this.$tmp];
                AnalyzeUrl analyzeUrl = new AnalyzeUrl(str, null, null, null, null, null, false, null, null, null, null, 2046, null);
                this.label = 1;
                Object strResponse$default = AnalyzeUrl.getStrResponse$default(analyzeUrl, str, null, null, this, 6, null);
                return strResponse$default == aVar ? aVar : strResponse$default;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String[] strArr, f.z.d<? super g> dVar) {
            super(2, dVar);
            this.$urlList = strArr;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            g gVar = new g(this.$urlList, dVar);
            gVar.L$0 = obj;
            return gVar;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super e.a.a.d.v.l[]> dVar) {
            return ((g) create(a0Var, dVar)).invokeSuspend(f.v.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x008f A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0078 -> B:17:0x0081). Please report as a decompilation issue!!! */
        @Override // f.z.j.a.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) throws java.lang.Throwable {
            /*
                r13 = this;
                f.z.i.a r0 = f.z.i.a.COROUTINE_SUSPENDED
                int r1 = r13.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L2e
                if (r1 != r3) goto L26
                int r1 = r13.I$2
                int r2 = r13.I$1
                int r4 = r13.I$0
                java.lang.Object r5 = r13.L$2
                e.a.a.d.v.l[] r5 = (e.a.a.d.v.l[]) r5
                java.lang.Object r6 = r13.L$1
                e.a.a.d.v.l[] r6 = (e.a.a.d.v.l[]) r6
                java.lang.Object r7 = r13.L$0
                g.b.f0[] r7 = (g.b.f0[]) r7
                c.b.a.m.f.E5(r14)
                r3 = r13
                r8 = r7
                r7 = r6
                r6 = r5
                r5 = r4
                r4 = 1
                goto L81
            L26:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L2e:
                c.b.a.m.f.E5(r14)
                java.lang.Object r14 = r13.L$0
                g.b.a0 r14 = (g.b.a0) r14
                java.lang.String[] r1 = r13.$urlList
                int r1 = r1.length
                g.b.f0[] r10 = new g.b.f0[r1]
                r4 = 0
                r11 = 0
            L3c:
                if (r11 >= r1) goto L57
                g.b.k0 r4 = g.b.k0.f6264c
                g.b.y r5 = g.b.k0.f6263b
                r6 = 0
                c.b.a.m.f$g$a r7 = new c.b.a.m.f$g$a
                java.lang.String[] r4 = r13.$urlList
                r8 = 0
                r7.<init>(r4, r11, r8)
                r8 = 2
                r9 = 0
                r4 = r14
                g.b.f0 r4 = c.b.a.m.f.r0(r4, r5, r6, r7, r8, r9)
                r10[r11] = r4
                int r11 = r11 + 1
                goto L3c
            L57:
                java.lang.String[] r14 = r13.$urlList
                int r14 = r14.length
                e.a.a.d.v.l[] r1 = new e.a.a.d.v.l[r14]
                r5 = r1
                r7 = r10
                r1 = r13
            L5f:
                if (r2 >= r14) goto L8f
                r4 = r7[r2]
                r1.L$0 = r7
                r1.L$1 = r5
                r1.L$2 = r5
                r1.I$0 = r2
                r1.I$1 = r14
                r1.I$2 = r2
                r1.label = r3
                java.lang.Object r4 = r4.e(r1)
                if (r4 != r0) goto L78
                return r0
            L78:
                r6 = r5
                r8 = r7
                r5 = r2
                r7 = r6
                r2 = r14
                r14 = r4
                r4 = r3
                r3 = r1
                r1 = r5
            L81:
                e.a.a.d.v.l r14 = (e.a.a.d.v.l) r14
                r6[r1] = r14
                int r14 = r5 + 1
                r1 = r3
                r3 = r4
                r5 = r7
                r7 = r8
                r12 = r2
                r2 = r14
                r14 = r12
                goto L5f
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.f.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: JsExtensions.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @DebugMetadata(c = "io.legado.app.help.JsExtensions$connect$1", f = "JsExtensions.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super Object>, Object> {
        public final /* synthetic */ String $urlStr;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, f.z.d<? super h> dVar) {
            super(2, dVar);
            this.$urlStr = str;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new h(this.$urlStr, dVar);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @Nullable f.z.d<Object> dVar) {
            return ((h) create(a0Var, dVar)).invokeSuspend(f.v.a);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, f.z.d<? super Object> dVar) {
            return invoke2(a0Var, (f.z.d<Object>) dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Object objM11constructorimpl;
            Object strResponse$default;
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    f.E5(obj);
                    String str = this.$urlStr;
                    AnalyzeUrl analyzeUrl = new AnalyzeUrl(str, null, null, null, null, null, false, null, null, null, null, 2046, null);
                    this.label = 1;
                    strResponse$default = AnalyzeUrl.getStrResponse$default(analyzeUrl, str, null, null, this, 6, null);
                    if (strResponse$default == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f.E5(obj);
                    strResponse$default = obj;
                }
                objM11constructorimpl = f.h.m11constructorimpl((e.a.a.d.v.l) strResponse$default);
            } catch (Throwable th) {
                objM11constructorimpl = f.h.m11constructorimpl(f.m1(th));
            }
            Throwable thM14exceptionOrNullimpl = f.h.m14exceptionOrNullimpl(objM11constructorimpl);
            if (thM14exceptionOrNullimpl != null) {
                thM14exceptionOrNullimpl.printStackTrace();
            }
            Throwable thM14exceptionOrNullimpl2 = f.h.m14exceptionOrNullimpl(objM11constructorimpl);
            return thM14exceptionOrNullimpl2 == null ? objM11constructorimpl : f.C2(thM14exceptionOrNullimpl2);
        }
    }

    /* JADX INFO: compiled from: JsExtensions.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @DebugMetadata(c = "io.legado.app.help.JsExtensions$queryTTF$font$1", f = "JsExtensions.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
    public static final class i extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super byte[]>, Object> {
        public final /* synthetic */ String $key;
        public final /* synthetic */ String $str;
        public int label;

        /* JADX INFO: compiled from: JsExtensions.kt */
        public static final class a extends f.c0.c.k implements f.c0.b.l<Request.Builder, f.v> {
            public final /* synthetic */ String $str;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.$str = str;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ f.v invoke(Request.Builder builder) {
                invoke2(builder);
                return f.v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Request.Builder builder) {
                f.c0.c.j.e(builder, "$this$newCall");
                builder.url(this.$str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, String str2, f.z.d<? super i> dVar) {
            super(2, dVar);
            this.$key = str;
            this.$str = str2;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new i(this.$key, this.$str, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super byte[]> dVar) {
            return ((i) create(a0Var, dVar)).invokeSuspend(f.v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            boolean z;
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                e.a.a.d.i iVar = e.a.a.d.i.a;
                String str = this.$key;
                f.c0.c.j.e(str, "key");
                e.a.a.h.f fVarA = f.b.a(e.a.a.h.f.a, k.d.a.h.g(), null, 0L, 0, false, 30);
                f.c0.c.j.e(str, "key");
                f.a aVar2 = fVarA.f5948c;
                byte[] bArr = null;
                if (aVar2 != null) {
                    try {
                        File fileA = aVar2.a(str);
                        if (fileA.exists()) {
                            byte[] bArrC = f.b0.d.c(fileA);
                            if (f.c.e(bArrC)) {
                                z = true;
                            } else {
                                f.c0.c.j.e(bArrC, "data");
                                if (f.c.c(bArrC)) {
                                    bArrC = f.c.b(bArrC, f.c.d(bArrC, ' ') + 1, bArrC.length);
                                }
                                bArr = bArrC;
                                z = false;
                            }
                            if (z) {
                                fVarA.f(str);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (bArr != null) {
                    return bArr;
                }
                OkHttpClient okHttpClientA = e.a.a.d.v.i.a();
                a aVar3 = new a(this.$str);
                this.label = 1;
                obj = f.Z3(okHttpClientA, 0, aVar3, this, 1);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            byte[] bArrBytes = ((ResponseBody) obj).bytes();
            e.a.a.d.i.a(e.a.a.d.i.a, this.$key, bArrBytes, 0, 4);
            return bArrBytes;
        }
    }

    /* JADX INFO: compiled from: OkHttpUtils.kt */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class j extends f.c0.c.k implements f.c0.b.l<Throwable, f.v> {
        public final /* synthetic */ Call $this_await;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Call call) {
            super(1);
            this.$this_await = call;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(Throwable th) {
            invoke2(th);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            this.$this_await.cancel();
        }
    }

    /* JADX INFO: compiled from: OkHttpUtils.kt */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class k implements Callback {
        public final /* synthetic */ g.b.h<Response> a;

        /* JADX WARN: Multi-variable type inference failed */
        public k(g.b.h<? super Response> hVar) {
            this.a = hVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException iOException) {
            f.c0.c.j.e(call, NotificationCompat.CATEGORY_CALL);
            f.c0.c.j.e(iOException, "e");
            this.a.resumeWith(f.h.m11constructorimpl(f.m1(iOException)));
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            f.c0.c.j.e(call, NotificationCompat.CATEGORY_CALL);
            f.c0.c.j.e(response, "response");
            this.a.resumeWith(f.h.m11constructorimpl(response));
        }
    }

    /* JADX INFO: compiled from: OkHttpUtils.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @DebugMetadata(c = "io.legado.app.help.http.OkHttpUtilsKt", f = "OkHttpUtils.kt", i = {0}, l = {26}, m = "newCall", n = {ai.aA}, s = {"I$2"})
    public static final class l extends f.z.j.a.c {
        public int I$0;
        public int I$1;
        public int I$2;
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public l(f.z.d<? super l> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.Y3(null, 0, null, this);
        }
    }

    /* JADX INFO: compiled from: OkHttpUtils.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @DebugMetadata(c = "io.legado.app.help.http.OkHttpUtilsKt", f = "OkHttpUtils.kt", i = {0}, l = {43}, m = "newCallStrResponse", n = {ai.aA}, s = {"I$2"})
    public static final class m extends f.z.j.a.c {
        public int I$0;
        public int I$1;
        public int I$2;
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public m(f.z.d<? super m> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.a4(null, 0, null, this);
        }
    }

    /* JADX INFO: compiled from: ContextExtensions.kt */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class n extends f.c0.c.k implements f.c0.b.a<f.v> {
        public final /* synthetic */ CharSequence $message;
        public final /* synthetic */ Context $this_longToastOnUi;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Context context, CharSequence charSequence) {
            super(0);
            this.$this_longToastOnUi = context;
            this.$message = charSequence;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ f.v invoke() {
            invoke2();
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Toast.makeText(this.$this_longToastOnUi, this.$message, 1).show();
        }
    }

    /* JADX INFO: compiled from: ContextExtensions.kt */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class o extends f.c0.c.k implements f.c0.b.a<f.v> {
        public final /* synthetic */ int $message;
        public final /* synthetic */ Context $this_toastOnUi;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(Context context, int i2) {
            super(0);
            this.$this_toastOnUi = context;
            this.$message = i2;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ f.v invoke() {
            invoke2();
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Toast.makeText(this.$this_toastOnUi, this.$message, 0).show();
        }
    }

    /* JADX INFO: compiled from: ContextExtensions.kt */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class p extends f.c0.c.k implements f.c0.b.a<f.v> {
        public final /* synthetic */ CharSequence $message;
        public final /* synthetic */ Context $this_toastOnUi;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Context context, CharSequence charSequence) {
            super(0);
            this.$this_toastOnUi = context;
            this.$message = charSequence;
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ f.v invoke() {
            invoke2();
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Toast.makeText(this.$this_toastOnUi, this.$message, 0).show();
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class q<T> implements Comparator<T>, j$.util.Comparator {
        public final /* synthetic */ f.c0.b.l[] a;

        public q(f.c0.b.l[] lVarArr) {
            this.a = lVarArr;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public final int compare(T t, T t2) {
            for (f.c0.b.l lVar : this.a) {
                int iV0 = f.V0((Comparable) lVar.invoke(t), (Comparable) lVar.invoke(t2));
                if (iV0 != 0) {
                    return iV0;
                }
            }
            return 0;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class r extends f.z.j.a.f {
        public final /* synthetic */ f.z.d $completion;
        public final /* synthetic */ f.c0.b.l $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(f.z.d dVar, f.z.d dVar2, f.c0.b.l lVar) {
            super(dVar2);
            this.$completion = dVar;
            this.$this_createCoroutineUnintercepted$inlined = lVar;
        }

        @Override // f.z.j.a.a
        @Nullable
        public Object invokeSuspend(@NotNull Object obj) throws Throwable {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                f.E5(obj);
                return obj;
            }
            this.label = 1;
            f.E5(obj);
            f.c0.b.l lVar = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(lVar, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            y.d(lVar, 1);
            return lVar.invoke(this);
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class s extends f.z.j.a.c {
        public final /* synthetic */ f.z.d $completion;
        public final /* synthetic */ f.z.f $context;
        public final /* synthetic */ f.c0.b.l $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(f.z.d dVar, f.z.f fVar, f.z.d dVar2, f.z.f fVar2, f.c0.b.l lVar) {
            super(dVar2, fVar2);
            this.$completion = dVar;
            this.$context = fVar;
            this.$this_createCoroutineUnintercepted$inlined = lVar;
        }

        @Override // f.z.j.a.a
        @Nullable
        public Object invokeSuspend(@NotNull Object obj) throws Throwable {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                f.E5(obj);
                return obj;
            }
            this.label = 1;
            f.E5(obj);
            f.c0.b.l lVar = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(lVar, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            y.d(lVar, 1);
            return lVar.invoke(this);
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class t extends f.z.j.a.f {
        public final /* synthetic */ f.z.d $completion;
        public final /* synthetic */ Object $receiver$inlined;
        public final /* synthetic */ f.c0.b.p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(f.z.d dVar, f.z.d dVar2, f.c0.b.p pVar, Object obj) {
            super(dVar2);
            this.$completion = dVar;
            this.$this_createCoroutineUnintercepted$inlined = pVar;
            this.$receiver$inlined = obj;
        }

        @Override // f.z.j.a.a
        @Nullable
        public Object invokeSuspend(@NotNull Object obj) throws Throwable {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                f.E5(obj);
                return obj;
            }
            this.label = 1;
            f.E5(obj);
            f.c0.b.p pVar = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            y.d(pVar, 2);
            return pVar.invoke(this.$receiver$inlined, this);
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class u extends f.z.j.a.c {
        public final /* synthetic */ f.z.d $completion;
        public final /* synthetic */ f.z.f $context;
        public final /* synthetic */ Object $receiver$inlined;
        public final /* synthetic */ f.c0.b.p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(f.z.d dVar, f.z.f fVar, f.z.d dVar2, f.z.f fVar2, f.c0.b.p pVar, Object obj) {
            super(dVar2, fVar2);
            this.$completion = dVar;
            this.$context = fVar;
            this.$this_createCoroutineUnintercepted$inlined = pVar;
            this.$receiver$inlined = obj;
        }

        @Override // f.z.j.a.a
        @Nullable
        public Object invokeSuspend(@NotNull Object obj) throws Throwable {
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                f.E5(obj);
                return obj;
            }
            this.label = 1;
            f.E5(obj);
            f.c0.b.p pVar = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            y.d(pVar, 2);
            return pVar.invoke(this.$receiver$inlined, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class v<T> implements f.g0.e<T> {
        public final /* synthetic */ Iterator a;

        public v(Iterator it) {
            this.a = it;
        }

        @Override // f.g0.e
        @NotNull
        public Iterator<T> iterator() {
            return this.a;
        }
    }

    public static void A(IPluginActivity iPluginActivity, Activity activity) {
        try {
            FieldUtils.writeField(iPluginActivity, "mTheme", (Object) null);
            FieldUtils.writeField((Object) iPluginActivity, "mThemeResource", (Object) 0);
            int[] iArrP = P(activity);
            if (iArrP == null) {
                return;
            }
            for (int i2 : iArrP) {
                if (i2 != 0) {
                    iPluginActivity.setProxyTheme2Plugin(i2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Nullable
    public static byte[] A0(@NotNull JsExtensions jsExtensions, @Nullable String str, int i2) {
        f.c0.c.j.e(jsExtensions, "this");
        if (str == null || f.h0.k.s(str)) {
            return null;
        }
        return Base64.decode(str, i2);
    }

    @NotNull
    public static String A1(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull String str2) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        f.c0.c.j.e(str2, "enc");
        try {
            String strEncode = URLEncoder.encode(str, str2);
            f.c0.c.j.d(strEncode, "{\n            URLEncoder.encode(str, enc)\n        }");
            return strEncode;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String A2(String str) {
        int iIndexOf = str.indexOf(46);
        int iIndexOf2 = iIndexOf >= 0 ? str.indexOf(46, iIndexOf + 1) : -1;
        int iIndexOf3 = str.indexOf(45);
        int length = str.length();
        if (iIndexOf2 >= 0) {
            length = Math.min(length, iIndexOf2);
        }
        if (iIndexOf3 >= 0) {
            length = Math.min(length, iIndexOf3);
        }
        return str.substring(0, length);
    }

    public static final boolean A3(@Nullable String str) {
        if (str == null) {
            return false;
        }
        String string = f.h0.k.R(str).toString();
        return f.h0.k.K(string, "[", false, 2) && f.h0.k.h(string, "]", false, 2);
    }

    @Nullable
    public static final String A4(@NotNull ReadContext readContext, @NotNull String str) {
        f.c0.c.j.e(readContext, "<this>");
        f.c0.c.j.e(str, "path");
        return (String) readContext.read(str, String.class, new Predicate[0]);
    }

    public static /* synthetic */ long A5(String str, long j2, long j3, long j4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j3 = 1;
        }
        long j5 = j3;
        if ((i2 & 8) != 0) {
            j4 = RecyclerView.FOREVER_NS;
        }
        return x5(str, j2, j5, j4);
    }

    public static void B(c.c.a.c.b bVar, Context context) {
        if (!Zeus.hasInit()) {
            bVar.zeusSuperAttachBaseContext(context);
            return;
        }
        String pluginPkgName = bVar.getPluginPkgName();
        boolean zLoadPlugin = PluginManager.getInstance().loadPlugin(pluginPkgName);
        try {
            bVar.setPlugin(PluginManager.getInstance().getPlugin(pluginPkgName));
            if (zLoadPlugin) {
                bVar.zeusSuperAttachBaseContext(ZeusTransformUtils.wrapperContext(context, pluginPkgName));
            } else {
                bVar.zeusSuperAttachBaseContext(context);
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Nullable
    public static String B0(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        f.c0.c.j.e(str, "str");
        byte[] bytes = str.getBytes(f.h0.a.a);
        f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        return Base64.encodeToString(bytes, 2);
    }

    public static final void B1(@NotNull a0 a0Var) {
        f1 f1Var = (f1) a0Var.getCoroutineContext().get(f1.N);
        if (f1Var != null && !f1Var.isActive()) {
            throw f1Var.d();
        }
    }

    public static String B2(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return c.e.a.b.l.u.c("MMMd", locale).format(new Date(j2));
        }
        AtomicReference<c.e.a.b.l.t> atomicReference = c.e.a.b.l.u.a;
        DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
        dateInstance.setTimeZone(c.e.a.b.l.u.g());
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) dateInstance;
        String pattern = simpleDateFormat.toPattern();
        int iB = c.e.a.b.l.u.b(pattern, "yY", 1, 0);
        if (iB < pattern.length()) {
            int iB2 = c.e.a.b.l.u.b(pattern, "EMd", 1, iB);
            pattern = pattern.replace(pattern.substring(c.e.a.b.l.u.b(pattern, iB2 < pattern.length() ? "EMd," : "EMd", -1, iB) + 1, iB2), " ").trim();
        }
        simpleDateFormat.applyPattern(pattern);
        return simpleDateFormat.format(new Date(j2));
    }

    public static final boolean B3(@Nullable String str) {
        if (str == null) {
            return false;
        }
        String string = f.h0.k.R(str).toString();
        return f.h0.k.K(string, "{", false, 2) && f.h0.k.h(string, "}", false, 2);
    }

    @Nullable
    public static final String B4(@NotNull Uri uri, @NotNull Context context) {
        f.c0.c.j.e(uri, "<this>");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        byte[] bArrV4 = v4(uri, context);
        if (bArrV4 == null) {
            return null;
        }
        return new String(bArrV4, f.h0.a.a);
    }

    public static String B5(String str) {
        return c.d.a.a.a.c.b.b().a("t2s").a(str);
    }

    public static void C(c.c.a.c.b bVar, Bundle bundle) {
        if (!Zeus.hasInit()) {
            bVar.zeusSuperOnCreate(bundle);
            bVar.finish();
            return;
        }
        Intent intent = bVar.getIntent();
        String pluginPkgName = bVar.getPluginPkgName();
        Plugin plugin = bVar.getPlugin();
        intent.setExtrasClassLoader(plugin.mClassLoader);
        String stringExtra = intent.getStringExtra("targetPlugin");
        if (!plugin.isLoaded() || TextUtils.isEmpty(stringExtra)) {
            try {
                bVar.zeusSuperOnCreate(bundle);
                ZeusLogger.e(ZeusLogger.TAG_ACTIVITY, "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
                bVar.finish();
                return;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        ActivityInfo activityInfo = plugin.pluginActivities.get(stringExtra);
        if (activityInfo == null) {
            throw new RuntimeException("Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
        }
        try {
            IPluginActivity iPluginActivity = (IPluginActivity) plugin.mClassLoader.loadClass(stringExtra).newInstance();
            FieldUtils.writeField(iPluginActivity, "mApplication", bVar.getApplication());
            bVar.setTargetActivity(iPluginActivity);
            iPluginActivity.setPluginProxyActivity(bVar, plugin);
            bVar.zeusSuperSetTheme(activityInfo.theme);
            iPluginActivity.attachBaseContext(bVar.getBaseContext());
            iPluginActivity.onCreate(bundle);
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    @Nullable
    public static String C0(@NotNull JsExtensions jsExtensions, @NotNull String str, int i2) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        f.c0.c.j.e(str, "str");
        byte[] bytes = str.getBytes(f.h0.a.a);
        f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        return Base64.encodeToString(bytes, i2);
    }

    public static final boolean C1(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    @NotNull
    public static final String C2(@NotNull Throwable th) {
        f.c0.c.j.e(th, "<this>");
        String strP5 = p5(th);
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "noErrorMsg";
        }
        return strP5.length() > 0 ? strP5 : localizedMessage;
    }

    public static boolean C3(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    @NotNull
    public static final String C4(@NotNull Reader reader) throws IOException {
        f.c0.c.j.e(reader, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        f.c0.c.j.e(reader, "$this$copyTo");
        f.c0.c.j.e(stringWriter, "out");
        char[] cArr = new char[8192];
        int i2 = reader.read(cArr);
        while (i2 >= 0) {
            stringWriter.write(cArr, 0, i2);
            i2 = reader.read(cArr);
        }
        String string = stringWriter.toString();
        f.c0.c.j.d(string, "buffer.toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String C5(@org.jetbrains.annotations.NotNull okhttp3.ResponseBody r13, @org.jetbrains.annotations.Nullable java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.f.C5(okhttp3.ResponseBody, java.lang.String):java.lang.String");
    }

    public static final void D(c.c.a.i$b.b bVar, int i2) throws IOException {
        int iB = bVar.b();
        if (iB == i2) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i2) + ", read 0x" + Integer.toHexString(iB) + ".");
    }

    @NotNull
    public static final String D0(@NotNull Object obj, @NotNull Object obj2) {
        f.c0.c.j.e(obj, "from");
        f.c0.c.j.e(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static boolean D1(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static final int D2(@NotNull Activity activity) {
        boolean z;
        int childCount;
        f.c0.c.j.e(activity, "<this>");
        View decorView = activity.getWindow().getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null && (childCount = viewGroup.getChildCount()) > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                viewGroup.getChildAt(i2).getContext().getPackageName();
                if (viewGroup.getChildAt(i2).getId() != -1 && f.c0.c.j.a("navigationBarBackground", activity.getResources().getResourceEntryName(viewGroup.getChildAt(i2).getId()))) {
                    z = true;
                    break;
                }
                if (i3 >= childCount) {
                    break;
                }
                i2 = i3;
            }
        } else {
            z = false;
        }
        if (z) {
            return activity.getResources().getDimensionPixelSize(activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
        }
        return 0;
    }

    public static boolean D3(String str) {
        return !q3(str);
    }

    @NotNull
    public static String D4(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "path");
        File file = new File(str);
        String strA = e.a.a.h.l.a(file);
        byte[] bArrC = f.b0.d.c(file);
        Charset charsetForName = Charset.forName(strA);
        f.c0.c.j.d(charsetForName, "Charset.forName(charsetName)");
        return new String(bArrC, charsetForName);
    }

    public static /* synthetic */ String D5(ResponseBody responseBody, String str, int i2) {
        int i3 = i2 & 1;
        return C5(responseBody, null);
    }

    public static void E(c.c.a.y.a aVar, Activity activity) {
        try {
            FieldUtils.writeField(aVar, "mTheme", (Object) null);
            FieldUtils.writeField((Object) aVar, "mThemeResource", (Object) 0);
            int[] iArrP = P(activity);
            if (iArrP == null) {
                return;
            }
            for (int i2 : iArrP) {
                if (i2 != 0) {
                    aVar.setWrapperActivityTheme(i2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String E0(int i2) {
        if (i2 == 513 || i2 == 514) {
            return "EC";
        }
        if (i2 == 769) {
            return "DSA";
        }
        if (i2 == 1057) {
            return "RSA";
        }
        if (i2 == 1059) {
            return "EC";
        }
        if (i2 == 1061) {
            return "DSA";
        }
        switch (i2) {
            case 257:
            case 258:
            case 259:
            case 260:
                return "RSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
        }
    }

    public static String E1(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (char c2 : str.toCharArray()) {
            if (c2 == ' ' && z) {
                sb.append((char) 183);
            } else if (c2 == '\t') {
                sb.append("\\t");
            } else if (c2 == '\n') {
                sb.append("\\n");
            } else if (c2 == '\r') {
                sb.append("\\r");
            } else {
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    public static String E2(k.a.a.a.n0.j jVar, List<String> list) {
        d0 d0VarA;
        if (list != null) {
            if (jVar instanceof c0) {
                c0 c0Var = (c0) jVar;
                String str = list.get(c0Var.getRuleContext().getRuleIndex());
                int altNumber = c0Var.getAltNumber();
                if (altNumber == 0) {
                    return str;
                }
                return str + ":" + altNumber;
            }
            if (jVar instanceof k.a.a.a.n0.b) {
                return jVar.toString();
            }
            if ((jVar instanceof k.a.a.a.n0.h) && (d0VarA = ((k.a.a.a.n0.h) jVar).a()) != null) {
                return d0VarA.getText();
            }
        }
        Object payload = jVar.getPayload();
        return payload instanceof d0 ? ((d0) payload).getText() : jVar.getPayload().toString();
    }

    public static void E3(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @NotNull
    public static String E4(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull String str2) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "path");
        f.c0.c.j.e(str2, "charsetName");
        byte[] bArrC = f.b0.d.c(new File(str));
        Charset charsetForName = Charset.forName(str2);
        f.c0.c.j.d(charsetForName, "Charset.forName(charsetName)");
        return new String(bArrC, charsetForName);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final void E5(@NotNull Object obj) throws Throwable {
        if (obj instanceof h.b) {
            throw ((h.b) obj).exception;
        }
    }

    public static void F(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                F(file2);
            }
        }
        file.delete();
    }

    public static boolean F0() {
        return Build.VERSION.SDK_INT > 23;
    }

    @androidx.annotation.Nullable
    public static Object[] F1(@NonNull TextView textView) {
        CharSequence text = textView.getText();
        if (TextUtils.isEmpty(text) || !(text instanceof Spanned)) {
            return null;
        }
        return ((Spanned) text).getSpans(0, text.length(), TableRowSpan.class);
    }

    public static int F2(@NonNull List<ImageHeaderParser> list, @androidx.annotation.Nullable InputStream inputStream, @NonNull c.b.a.m.q.c0.b bVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new w(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return G2(list, new b(inputStream, bVar));
    }

    public static boolean F3(byte[] bArr, int i2, int i3) {
        int iMin = Math.min(i3, bArr.length);
        for (int iMax = Math.max(i2, 0); iMax < iMin; iMax++) {
            if (bArr[iMax] == 1) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <T> Object F4(@Nullable Object obj, @NotNull f.z.d<? super T> dVar) {
        return obj instanceof g.b.s ? f.h.m11constructorimpl(m1(((g.b.s) obj).f6298b)) : f.h.m11constructorimpl(obj);
    }

    @NotNull
    public static String F5(@NotNull JsExtensions jsExtensions, long j2) {
        f.c0.c.j.e(jsExtensions, "this");
        e.a.a.c.c cVar = e.a.a.c.c.a;
        String str = ((SimpleDateFormat) e.a.a.c.c.f5498d.getValue()).format(new Date(j2));
        f.c0.c.j.d(str, "dateFormat.format(Date(time))");
        return str;
    }

    public static void G(InputStream inputStream, OutputStream outputStream, long j2) throws IOException {
        if (inputStream == null) {
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        try {
            byte[] bArr = new byte[4096];
            int i2 = 0;
            while (true) {
                int i3 = bufferedInputStream.read(bArr);
                if (i3 == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, i3);
                i2 += i3;
            }
            bufferedOutputStream.flush();
            if (j2 > 0 && i2 != j2) {
                throw new IOException("copy is not completed");
            }
        } finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }

    public static void G0(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    @androidx.annotation.Nullable
    public static e.b.a.s.g[] G1(@NonNull TextView textView) {
        CharSequence text = textView.getText();
        int length = text != null ? text.length() : 0;
        if (length == 0 || !(text instanceof Spanned)) {
            return null;
        }
        return (e.b.a.s.g[]) ((Spanned) text).getSpans(0, length, e.b.a.s.g.class);
    }

    public static int G2(@NonNull List<ImageHeaderParser> list, c cVar) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iA = cVar.a(list.get(i2));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    public static boolean G3(byte[][] bArr, int i2, int i3, int i4) {
        int iMin = Math.min(i4, bArr.length);
        for (int iMax = Math.max(i3, 0); iMax < iMin; iMax++) {
            if (bArr[iMax][i2] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean G4(CharSequence charSequence, boolean z, int i2, CharSequence charSequence2, int i3, int i4) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z, i2, (String) charSequence2, i3, i4);
        }
        int length = charSequence.length() - i2;
        int length2 = charSequence2.length() - i3;
        if (i2 < 0 || i3 < 0 || i4 < 0 || length < i4 || length2 < i4) {
            return false;
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i2 + 1;
            char cCharAt = charSequence.charAt(i2);
            int i7 = i3 + 1;
            char cCharAt2 = charSequence2.charAt(i3);
            if (cCharAt != cCharAt2) {
                if (!z) {
                    return false;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                char upperCase2 = Character.toUpperCase(cCharAt2);
                if (upperCase != upperCase2 && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    return false;
                }
            }
            i2 = i6;
            i4 = i5;
            i3 = i7;
        }
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C G5(@NotNull T[] tArr, @NotNull C c2) {
        f.c0.c.j.e(tArr, "$this$toCollection");
        f.c0.c.j.e(c2, "destination");
        for (T t2 : tArr) {
            c2.add(t2);
        }
        return c2;
    }

    public static void H(String str) {
        F(new File(str));
    }

    public static void H0(f.z.f fVar, CancellationException cancellationException, int i2, Object obj) {
        int i3 = i2 & 1;
        f1 f1Var = (f1) fVar.get(f1.N);
        if (f1Var != null) {
            f1Var.k(null);
        }
    }

    public static final int H1(int i2) {
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    @androidx.annotation.Nullable
    public static c.e.a.b.q.i H2(@androidx.annotation.Nullable View view) {
        if (view == null) {
            return null;
        }
        return new c.e.a.b.q.h(view);
    }

    public static final boolean H3(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    public static final void H4(@NotNull Context context, @NotNull String str) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(str, "key");
        SharedPreferences.Editor editorEdit = i2(context).edit();
        f.c0.c.j.b(editorEdit, "editor");
        editorEdit.remove(str);
        editorEdit.apply();
    }

    @NotNull
    public static final String H5(@NotNull f.z.d<?> dVar) {
        Object objM11constructorimpl;
        if (dVar instanceof g.b.g2.f) {
            return dVar.toString();
        }
        try {
            objM11constructorimpl = f.h.m11constructorimpl(dVar + '@' + v2(dVar));
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(m1(th));
        }
        if (f.h.m14exceptionOrNullimpl(objM11constructorimpl) != null) {
            objM11constructorimpl = dVar.getClass().getName() + '@' + v2(dVar);
        }
        return (String) objM11constructorimpl;
    }

    public static void I(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
        }
        String strA = Zeus.getAppApplication() != null ? c.c.a.n.c.a(Zeus.getAppApplication()) : null;
        if (strA == null) {
            strA = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        try {
            jSONObject.putOpt("net_type", t(Integer.valueOf(c.c.a.h.d.a(Zeus.getAppApplication()).f723h)));
            jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, t(strA));
            Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""));
            jSONObject.putOpt("plugin_api_version", t(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
            jSONObject.putOpt("zeus_sdk_version", t("0.0.1-beta.53-bugfix.13-pangle"));
            ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
            IZeusReporter reporter = c.c.a.q.a().f779c.getReporter();
            if (reporter != null) {
                JSONObject jSONObject4 = new JSONObject();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject4.putOpt(next, jSONObject.opt(next));
                }
                Iterator<String> itKeys2 = jSONObject2.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    jSONObject4.putOpt(next2, jSONObject2.opt(next2));
                }
                Iterator<String> itKeys3 = jSONObject3.keys();
                while (itKeys3.hasNext()) {
                    String next3 = itKeys3.next();
                    jSONObject4.putOpt(next3, jSONObject3.opt(next3));
                }
                reporter.report(str, jSONObject4);
            }
            if (c.c.a.r.a.a == null) {
                synchronized (c.c.a.r.a.class) {
                    c.c.a.r.a.a = new c.c.a.r.a();
                }
            }
            c.c.a.r.a.a(str, jSONObject, jSONObject2, jSONObject3);
        } catch (JSONException e2) {
            ZeusLogger.e(ZeusLogger.TAG_REPORTER, e2.getMessage(), e2);
        }
    }

    public static void I0(a0 a0Var, CancellationException cancellationException, int i2) {
        int i3 = i2 & 1;
        f1 f1Var = (f1) a0Var.getCoroutineContext().get(f1.N);
        if (f1Var != null) {
            f1Var.k(null);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + a0Var).toString());
    }

    public static int I1(int i2, int i3) {
        int i4 = i2 ^ (i3 * 4);
        int i5 = (i4 ^ (i4 >>> 16)) * (-2048144789);
        int i6 = (i5 ^ (i5 >>> 13)) * (-1028477387);
        return i6 ^ (i6 >>> 16);
    }

    public static float I2(@NonNull View view) {
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ViewCompat.getElevation((View) parent);
        }
        return elevation;
    }

    @NotNull
    public static final <T> Iterator<T> I3(@NotNull T[] tArr) {
        f.c0.c.j.e(tArr, "array");
        return new f.c0.c.a(tArr);
    }

    @NotNull
    public static String I4(@NotNull JsExtensions jsExtensions, @NotNull String str, @Nullable QueryTTF queryTTF, @Nullable QueryTTF queryTTF2) {
        int codeByGlyf;
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        if (queryTTF == null || queryTTF2 == null) {
            return str;
        }
        char[] charArray = str.toCharArray();
        f.c0.c.j.d(charArray, "(this as java.lang.String).toCharArray()");
        int length = charArray.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char c2 = charArray[i2];
            int i4 = i3 + 1;
            if (queryTTF.inLimit(c2) && (codeByGlyf = queryTTF2.getCodeByGlyf(queryTTF.getGlyfByCode(c2))) != 0) {
                charArray[i3] = (char) codeByGlyf;
            }
            i2++;
            i3 = i4;
        }
        f.c0.c.j.e(charArray, "$this$joinToString");
        f.c0.c.j.e("", "separator");
        f.c0.c.j.e("", "prefix");
        f.c0.c.j.e("", "postfix");
        f.c0.c.j.e("...", "truncated");
        StringBuilder sb = new StringBuilder();
        f.c0.c.j.e(charArray, "$this$joinTo");
        f.c0.c.j.e(sb, "buffer");
        f.c0.c.j.e("", "separator");
        f.c0.c.j.e("", "prefix");
        f.c0.c.j.e("", "postfix");
        f.c0.c.j.e("...", "truncated");
        sb.append((CharSequence) "");
        int i5 = 0;
        for (char c3 : charArray) {
            i5++;
            if (i5 > 1) {
                sb.append((CharSequence) "");
            }
            sb.append(c3);
        }
        sb.append((CharSequence) "");
        String string = sb.toString();
        f.c0.c.j.d(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @NotNull
    public static final <T> HashSet<T> I5(@NotNull T[] tArr) {
        f.c0.c.j.e(tArr, "$this$toHashSet");
        HashSet<T> hashSet = new HashSet<>(T3(tArr.length));
        G5(tArr, hashSet);
        return hashSet;
    }

    public static void J(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, c.c.a.j.n nVar) {
        c.c.a.j.m mVar = new c.c.a.j.m(fileDescriptor, 0L, nVar.f766b);
        long j2 = nVar.f767c;
        c.c.a.j.m mVar2 = new c.c.a.j.m(fileDescriptor, j2, nVar.f768d - j2);
        ByteBuffer byteBufferDuplicate = nVar.f769e.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        long j3 = nVar.f766b;
        G0(byteBufferDuplicate);
        int iPosition = byteBufferDuplicate.position() + 16;
        if (j3 < 0 || j3 > 4294967295L) {
            throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j3)));
        }
        byteBufferDuplicate.putInt(byteBufferDuplicate.position() + iPosition, (int) j3);
        c.c.a.j.i iVar = new c.c.a.j.i(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = it.next().intValue();
            i2++;
        }
        try {
            byte[][] bArrR = R(iArr, new c.c.a.j.l[]{mVar, mVar2, iVar});
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = iArr[i3];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i4)), bArrR[i3])) {
                    throw new SecurityException(u0(i4) + " digest of contents did not verify");
                }
            }
        } catch (DigestException e2) {
            throw new SecurityException("Failed to compute digest(s) of contents", e2);
        }
    }

    public static /* synthetic */ void J0(f1 f1Var, CancellationException cancellationException, int i2, Object obj) {
        int i3 = i2 & 1;
        f1Var.k(null);
    }

    public static k.a.a.a.i J1(String str) {
        h.b bVar = new h.b(str.length(), null);
        CharBuffer charBufferAllocate = CharBuffer.allocate(str.length());
        charBufferAllocate.put(str);
        charBufferAllocate.flip();
        int iRemaining = charBufferAllocate.remaining();
        int iOrdinal = bVar.a.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal == 2 && bVar.f8364d.remaining() < iRemaining) {
                    IntBuffer intBufferAllocate = IntBuffer.allocate(h.b.c(bVar.f8364d.capacity() + iRemaining));
                    bVar.f8364d.flip();
                    intBufferAllocate.put(bVar.f8364d);
                    bVar.f8364d = intBufferAllocate;
                }
            } else if (bVar.f8363c.remaining() < iRemaining) {
                CharBuffer charBufferAllocate2 = CharBuffer.allocate(h.b.c(bVar.f8363c.capacity() + iRemaining));
                bVar.f8363c.flip();
                charBufferAllocate2.put(bVar.f8363c);
                bVar.f8363c = charBufferAllocate2;
            }
        } else if (bVar.f8362b.remaining() < iRemaining) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(h.b.c(bVar.f8362b.capacity() + iRemaining));
            bVar.f8362b.flip();
            byteBufferAllocate.put(bVar.f8362b);
            bVar.f8362b = byteBufferAllocate;
        }
        if (!charBufferAllocate.hasArray()) {
            throw new UnsupportedOperationException("TODO");
        }
        int iOrdinal2 = bVar.a.ordinal();
        if (iOrdinal2 == 0) {
            char[] cArrArray = charBufferAllocate.array();
            int iPosition = charBufferAllocate.position() + charBufferAllocate.arrayOffset();
            int iLimit = charBufferAllocate.limit() + charBufferAllocate.arrayOffset();
            byte[] bArrArray = bVar.f8362b.array();
            int iPosition2 = bVar.f8362b.position() + bVar.f8362b.arrayOffset();
            while (true) {
                if (iPosition >= iLimit) {
                    charBufferAllocate.position(iPosition - charBufferAllocate.arrayOffset());
                    ByteBuffer byteBuffer = bVar.f8362b;
                    byteBuffer.position(iPosition2 - byteBuffer.arrayOffset());
                    break;
                }
                char c2 = cArrArray[iPosition];
                if (c2 <= 255) {
                    bArrArray[iPosition2] = (byte) (c2 & 255);
                    iPosition++;
                    iPosition2++;
                } else {
                    charBufferAllocate.position(iPosition - charBufferAllocate.arrayOffset());
                    ByteBuffer byteBuffer2 = bVar.f8362b;
                    byteBuffer2.position(iPosition2 - byteBuffer2.arrayOffset());
                    if (Character.isHighSurrogate(c2)) {
                        int iRemaining2 = charBufferAllocate.remaining();
                        bVar.f8362b.flip();
                        IntBuffer intBufferAllocate2 = IntBuffer.allocate(Math.max(bVar.f8362b.remaining() + iRemaining2, bVar.f8362b.capacity() / 4));
                        while (bVar.f8362b.hasRemaining()) {
                            intBufferAllocate2.put(bVar.f8362b.get() & ExifInterface.MARKER);
                        }
                        bVar.a = h.c.INT;
                        bVar.f8362b = null;
                        bVar.f8364d = intBufferAllocate2;
                        bVar.b(charBufferAllocate);
                    } else {
                        int iRemaining3 = charBufferAllocate.remaining();
                        bVar.f8362b.flip();
                        CharBuffer charBufferAllocate3 = CharBuffer.allocate(Math.max(bVar.f8362b.remaining() + iRemaining3, bVar.f8362b.capacity() / 2));
                        while (bVar.f8362b.hasRemaining()) {
                            charBufferAllocate3.put((char) (bVar.f8362b.get() & ExifInterface.MARKER));
                        }
                        bVar.a = h.c.CHAR;
                        bVar.f8362b = null;
                        bVar.f8363c = charBufferAllocate3;
                        bVar.a(charBufferAllocate);
                    }
                }
            }
        } else if (iOrdinal2 == 1) {
            bVar.a(charBufferAllocate);
        } else if (iOrdinal2 == 2) {
            bVar.b(charBufferAllocate);
        }
        int iOrdinal3 = bVar.a.ordinal();
        if (iOrdinal3 == 0) {
            bVar.f8362b.flip();
        } else if (iOrdinal3 == 1) {
            bVar.f8363c.flip();
        } else if (iOrdinal3 == 2) {
            bVar.f8364d.flip();
        }
        h.c cVar = bVar.a;
        ByteBuffer byteBuffer3 = bVar.f8362b;
        CharBuffer charBuffer = bVar.f8363c;
        IntBuffer intBuffer = bVar.f8364d;
        k.a.a.a.h hVar = new k.a.a.a.h(cVar, byteBuffer3, charBuffer, intBuffer, null);
        int iOrdinal4 = cVar.ordinal();
        if (iOrdinal4 == 0) {
            return new i.d(hVar.b(), hVar.c(), CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN, byteBuffer3.array(), hVar.a(), null);
        }
        if (iOrdinal4 == 1) {
            return new i.b(hVar.b(), hVar.c(), CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN, charBuffer.array(), hVar.a(), null);
        }
        if (iOrdinal4 == 2) {
            return new i.c(hVar.b(), hVar.c(), CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN, intBuffer.array(), hVar.a(), null);
        }
        throw new UnsupportedOperationException("Not reached");
    }

    public static final boolean J2(@NotNull Context context, @NotNull String str, boolean z) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(str, "key");
        return i2(context).getBoolean(str, z);
    }

    public static <T> String J3(Iterator<T> it, String str) {
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static final void J4(@NotNull AlertDialog alertDialog) {
        f.c0.c.j.e(alertDialog, "<this>");
        Window window = alertDialog.getWindow();
        if (window == null) {
            return;
        }
        window.setSoftInputMode(5);
    }

    @NotNull
    public static final <T> List<T> J5(@NotNull f.g0.e<? extends T> eVar) {
        f.c0.c.j.e(eVar, "$this$toList");
        f.c0.c.j.e(eVar, "$this$toMutableList");
        ArrayList arrayList = new ArrayList();
        f.c0.c.j.e(eVar, "$this$toCollection");
        f.c0.c.j.e(arrayList, "destination");
        Iterator<? extends T> it = eVar.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return f.x.e.w(arrayList);
    }

    @RequiresApi(api = 21)
    public static void K(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, c.c.a.j.n nVar) {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        ArrayMap arrayMap = new ArrayMap();
        boolean z = true;
        if (map.containsKey(1)) {
            arrayMap.put(1, map.get(1));
        }
        if (map.containsKey(2)) {
            arrayMap.put(2, map.get(2));
        }
        boolean z2 = false;
        if (!arrayMap.isEmpty()) {
            try {
                J(arrayMap, randomAccessFile.getFD(), nVar);
                z = false;
            } catch (IOException e2) {
                throw new SecurityException("Cannot get FD", e2);
            }
        }
        if (map.containsKey(3)) {
            try {
                if (!Arrays.equals(O(map.get(3), randomAccessFile.length(), nVar), c.c.a.j.h.a(randomAccessFile, nVar, new c.c.a.j.f()).a)) {
                    throw new SecurityException("APK verity digest of contents did not verify");
                }
            } catch (IOException | DigestException | NoSuchAlgorithmException e3) {
                throw new SecurityException("Error during verification", e3);
            }
        } else {
            z2 = z;
        }
        if (z2) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    public static /* synthetic */ void K0(e.a.a.e.a.h hVar, f.c0.b.l lVar, int i2, Object obj) {
        int i3 = i2 & 1;
        hVar.f(null);
    }

    @NotNull
    public static Connection.Response K1(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull Map<String, String> map) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "urlStr");
        f.c0.c.j.e(map, "headers");
        Connection connectionConnect = Jsoup.connect(str);
        e.a.a.d.v.k kVar = e.a.a.d.v.k.a;
        Connection.Response responseExecute = connectionConnect.sslSocketFactory(e.a.a.d.v.k.a()).ignoreContentType(true).followRedirects(false).headers(map).method(Connection.Method.GET).execute();
        f.c0.c.j.d(responseExecute, "connect(urlStr)\n            .sslSocketFactory(SSLHelper.unsafeSSLSocketFactory)\n            .ignoreContentType(true)\n            .followRedirects(false)\n            .headers(headers)\n            .method(Connection.Method.GET)\n            .execute()");
        return responseExecute;
    }

    public static /* synthetic */ boolean K2(Context context, String str, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return J2(context, str, z);
    }

    public static final boolean K3(StringBuilder sb) {
        return (sb.length() > 0) && sb.charAt(sb.length() - 1) == ' ';
    }

    public static boolean K4(@NonNull String str, @NonNull String[] strArr, @NonNull int[] iArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(strArr[i2]) && iArr[i2] == 0) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <T> List<T> K5(@NotNull T[] tArr) {
        f.c0.c.j.e(tArr, "$this$toList");
        int length = tArr.length;
        return length != 0 ? length != 1 ? L5(tArr) : P3(tArr[0]) : f.x.i.INSTANCE;
    }

    public static boolean L(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Signature[] signatureArr = c.c.a.j.e.a(str).a;
            WeakReference<Signature[]> weakReference = a;
            Signature[] signatureArr2 = weakReference != null ? weakReference.get() : null;
            if (signatureArr2 == null || signatureArr2.length == 0) {
                try {
                    PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 64);
                    Signature[] signatureArr3 = packageInfo.signatures;
                    a = new WeakReference<>(packageInfo.signatures);
                    signatureArr2 = signatureArr3;
                } catch (PackageManager.NameNotFoundException unused) {
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get host signature error : ".concat(String.valueOf(str)));
                    return false;
                }
            }
            try {
                return c.c.a.j.p.c(signatureArr2, signatureArr);
            } catch (CertificateException unused2) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify host-plugin signature are effective match : ".concat(String.valueOf(str)));
                return false;
            }
        } catch (c.c.a.j.r unused3) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
            return false;
        }
    }

    public static void L0(boolean z, @NonNull String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static final void L1(@NotNull Request.Builder builder, @NotNull String str, @NotNull Map<String, String> map, boolean z) {
        f.c0.c.j.e(builder, "<this>");
        f.c0.c.j.e(str, "url");
        f.c0.c.j.e(map, "queryMap");
        HttpUrl.Builder builderNewBuilder = HttpUrl.INSTANCE.get(str).newBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z) {
                builderNewBuilder.addEncodedQueryParameter(entry.getKey(), entry.getValue());
            } else {
                builderNewBuilder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        builder.url(builderNewBuilder.build());
    }

    public static final int L2(@NotNull Context context, @NotNull String str, int i2) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(str, "key");
        return i2(context).getInt(str, i2);
    }

    public static f1 L3(a0 a0Var, f.z.f fVar, b0 b0Var, f.c0.b.p pVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fVar = f.z.h.INSTANCE;
        }
        b0 b0Var2 = (i2 & 2) != 0 ? b0.DEFAULT : null;
        f.z.f fVarA = g.b.w.a(a0Var, fVar);
        g.b.a n1Var = b0Var2.isLazy() ? new n1(fVarA, pVar) : new v1(fVarA, true);
        n1Var.U();
        b0Var2.invoke(pVar, n1Var, n1Var);
        return n1Var;
    }

    @androidx.annotation.Nullable
    public static TypedValue L4(@NonNull Context context, @AttrRes int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    @NotNull
    public static final <T> List<T> L5(@NotNull T[] tArr) {
        f.c0.c.j.e(tArr, "$this$toMutableList");
        f.c0.c.j.e(tArr, "$this$asCollection");
        return new ArrayList(new f.x.c(tArr, false));
    }

    public static <T> boolean M(@androidx.annotation.Nullable T[] tArr, T[] tArr2) {
        int length = tArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                return true;
            }
            Object obj = tArr2[i2];
            int i3 = 0;
            while (true) {
                if (i3 >= tArr.length) {
                    i3 = -1;
                    break;
                }
                if (tArr[i3] == obj || (tArr[i3] != null && tArr[i3].equals(obj))) {
                    break;
                }
                i3++;
            }
            if (!(i3 != -1)) {
                return false;
            }
            i2++;
        }
    }

    public static final void M0(@NotNull RadioGroup radioGroup, int i2) {
        f.c0.c.j.e(radioGroup, "<this>");
        radioGroup.check(ViewGroupKt.get(radioGroup, i2).getId());
    }

    public static final int M1(@NotNull Context context) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        f.c0.c.j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        int color = Color.parseColor("#263238");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        f.c0.c.j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, color);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        return sharedPreferences.getInt("accent_color", color);
    }

    public static /* synthetic */ int M2(Context context, String str, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return L2(context, str, i2);
    }

    @ColorInt
    public static int M3(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i3, Math.round(Color.alpha(i3) * f2)), i2);
    }

    public static boolean M4(@NonNull Context context, @AttrRes int i2, boolean z) {
        TypedValue typedValueL4 = L4(context, i2);
        return (typedValueL4 == null || typedValueL4.type != 18) ? z : typedValueL4.data != 0;
    }

    @NotNull
    public static final <K, V> Map<K, V> M5(@NotNull Map<? extends K, ? extends V> map) {
        f.c0.c.j.e(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        f.c0.c.j.d(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }

    public static boolean N(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process processExec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = processExec.getErrorStream();
            InputStream inputStream = processExec.getInputStream();
            c.c.a.n.f.a.execute(new g.b(errorStream));
            c.c.a.n.f.a.execute(new g.b(inputStream));
            if (processExec.waitFor() == 0) {
                return true;
            }
            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + strArr.toString());
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (InterruptedException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    @PublishedApi
    public static final int N0(int i2) {
        if (2 <= i2 && 36 >= i2) {
            return i2;
        }
        StringBuilder sbS = c.a.a.a.a.s("radix ", i2, " was not in valid range ");
        sbS.append(new f.e0.d(2, 36));
        throw new IllegalArgumentException(sbS.toString());
    }

    public static final int N1(@NotNull Fragment fragment) {
        f.c0.c.j.e(fragment, "<this>");
        Context contextRequireContext = fragment.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        f.c0.c.j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        SharedPreferences sharedPreferences = contextRequireContext.getSharedPreferences("app_themes", 0);
        f.c0.c.j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        int color = Color.parseColor("#263238");
        f.c0.c.j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        TypedArray typedArrayObtainStyledAttributes = contextRequireContext.getTheme().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        f.c0.c.j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, color);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        return sharedPreferences.getInt("accent_color", color);
    }

    public static long N2(Context context, String str, long j2, int i2) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(str, "key");
        return i2(context).getLong(str, j2);
    }

    @NotNull
    public static final <T> f.e<T> N3(@NotNull f.c0.b.a<? extends T> aVar) {
        f.c0.c.j.e(aVar, "initializer");
        f.c0.c.f fVar = null;
        return new f.i(aVar, fVar, 2, fVar);
    }

    public static int N4(@NonNull Context context, @AttrRes int i2, @NonNull String str) {
        TypedValue typedValueL4 = L4(context, i2);
        if (typedValueL4 != null) {
            return typedValueL4.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }

    @Nullable
    public static final <T> Object N5(@NotNull Object obj, @Nullable f.c0.b.l<? super Throwable, f.v> lVar) {
        Throwable thM14exceptionOrNullimpl = f.h.m14exceptionOrNullimpl(obj);
        return thM14exceptionOrNullimpl == null ? lVar != null ? new g.b.t(obj, lVar) : obj : new g.b.s(thM14exceptionOrNullimpl, false, 2);
    }

    public static byte[] O(byte[] bArr, long j2, c.c.a.j.n nVar) {
        if (bArr.length != 40) {
            throw new SecurityException("Verity digest size is wrong: " + bArr.length);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.position(32);
        if (byteBufferOrder.getLong() == j2 - (nVar.f767c - nVar.f766b)) {
            return Arrays.copyOfRange(bArr, 0, 32);
        }
        throw new SecurityException("APK content size did not verify");
    }

    public static void O0(String str, String str2) {
        boolean z = ("4.7".equals(str) || A2("4.7").equals(A2(str))) ? false : true;
        boolean z2 = ("4.7".equals(str2) || A2("4.7").equals(A2(str2))) ? false : true;
        if (z) {
            System.err.printf("ANTLR Tool version %s used for code generation does not match the current runtime version %s", str, "4.7");
        }
        if (z2) {
            System.err.printf("ANTLR Runtime version %s used for parser compilation does not match the current runtime version %s", str2, "4.7");
        }
    }

    @Nullable
    public static final AppCompatActivity O1(@NotNull View view) {
        f.c0.c.j.e(view, "<this>");
        Context context = view.getContext();
        while (!(context instanceof AppCompatActivity)) {
            if (context instanceof ContextThemeWrapper) {
                context = ((ContextThemeWrapper) context).getBaseContext();
            } else {
                if (!(context instanceof android.view.ContextThemeWrapper)) {
                    return null;
                }
                context = ((android.view.ContextThemeWrapper) context).getBaseContext();
            }
        }
        return (AppCompatActivity) context;
    }

    public static String O2(Context context, String str, String str2, int i2) {
        int i3 = i2 & 2;
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(str, "key");
        return i2(context).getString(str, null);
    }

    public static float O3(float f2, float f3, float f4) {
        return (f4 * f3) + ((1.0f - f4) * f2);
    }

    public static final <T> void O4(@NotNull j0<? super T> j0Var, @NotNull f.z.d<? super T> dVar, boolean z) {
        Object objJ = j0Var.j();
        Throwable thE = j0Var.e(objJ);
        Object objM11constructorimpl = f.h.m11constructorimpl(thE != null ? m1(thE) : j0Var.f(objJ));
        if (!z) {
            dVar.resumeWith(objM11constructorimpl);
            return;
        }
        Objects.requireNonNull(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        g.b.g2.f fVar = (g.b.g2.f) dVar;
        f.z.d<T> dVar2 = fVar.f6194h;
        Object obj = fVar.f6192f;
        f.z.f context = dVar2.getContext();
        Object objB = g.b.g2.s.b(context, obj);
        c2<?> c2VarB = objB != g.b.g2.s.a ? g.b.w.b(dVar2, context, objB) : null;
        try {
            fVar.f6194h.resumeWith(objM11constructorimpl);
        } finally {
            if (c2VarB == null || c2VarB.W()) {
                g.b.g2.s.a(context, objB);
            }
        }
    }

    @NotNull
    public static final String[] O5(@NotNull String str) {
        f.c0.c.j.e(str, "<this>");
        try {
            int iCodePointCount = str.codePointCount(0, str.length());
            String[] strArr = new String[iCodePointCount];
            int i2 = 0;
            int i3 = 0;
            while (i2 < iCodePointCount) {
                int iOffsetByCodePoints = str.offsetByCodePoints(i3, 1);
                String strSubstring = str.substring(i3, iOffsetByCodePoints);
                f.c0.c.j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                strArr[i2] = strSubstring;
                i2++;
                i3 = iOffsetByCodePoints;
            }
            return strArr;
        } catch (Exception unused) {
            Object[] array = f.h0.k.F(str, new String[]{""}, false, 0, 6).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (String[]) array;
        }
    }

    public static int[] P(Activity activity) {
        Resources.Theme theme = activity.getTheme();
        if (theme == null) {
            return null;
        }
        try {
            if (F0()) {
                Object field = FieldUtils.readField(theme, "mThemeImpl");
                if (field == null) {
                    return null;
                }
                try {
                    Object objInvokeMethod = MethodUtils.invokeMethod(field, "getKey", new Object[0]);
                    if (objInvokeMethod != null) {
                        return (int[]) FieldUtils.readField(objInvokeMethod, "mResId");
                    }
                } catch (Exception unused) {
                }
                Object objInvoke = c.c.a.a.b.a.b(field.getClass(), "getKey", new Class[0]).invoke(field, new Object[0]);
                if (objInvoke == null) {
                    ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey failed!");
                    return null;
                }
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey success by doubleReflector!");
                return (int[]) c.c.a.a.b.a.a(objInvoke.getClass(), "mResId").get(objInvoke);
            }
            if (Build.VERSION.SDK_INT > 22) {
                Object objInvokeMethod2 = MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
                if (objInvokeMethod2 == null) {
                    return null;
                }
                return (int[]) FieldUtils.readField(objInvokeMethod2, "mResId");
            }
            String str = (String) MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
            if (str == null) {
                return null;
            }
            String[] strArrSplit = str.trim().replace(XPath.NOT, "").split(" ");
            int[] iArr = new int[strArrSplit.length];
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                iArr[i2] = Integer.parseInt(strArrSplit[i2], 16);
            }
            return iArr;
        } catch (Throwable th) {
            ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey exception!" + th.getMessage());
            return null;
        }
    }

    @SinceKotlin(version = "1.1")
    @PublishedApi
    public static final void P0(@Nullable Closeable closeable, @Nullable Throwable th) throws IOException {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            V(th, th2);
        }
    }

    public static Document P1(h.a.a.a.p pVar) {
        DocumentBuilder documentBuilderNewDocumentBuilder;
        Reader reader;
        DocumentBuilderFactory documentBuilderFactory = h.a.a.b.d.a;
        try {
            documentBuilderNewDocumentBuilder = h.a.a.b.d.a.newDocumentBuilder();
        } catch (ParserConfigurationException e2) {
            e = e2;
            documentBuilderNewDocumentBuilder = null;
        }
        try {
            documentBuilderNewDocumentBuilder.setEntityResolver(new d.a());
        } catch (ParserConfigurationException e3) {
            e = e3;
            e.getMessage();
        }
        InputSource inputSource = (pVar == null || (reader = pVar.getReader()) == null) ? null : new InputSource(reader);
        if (inputSource == null) {
            return null;
        }
        return documentBuilderNewDocumentBuilder.parse(inputSource);
    }

    public static final int P2(@NotNull Context context) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        f.c0.c.j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        int color = Color.parseColor("#455A64");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorPrimary});
        f.c0.c.j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, color);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        return sharedPreferences.getInt("primary_color", color);
    }

    @NotNull
    public static final <T> List<T> P3(T t2) {
        List<T> listSingletonList = Collections.singletonList(t2);
        f.c0.c.j.d(listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }

    public static final <T> void P4(@NotNull List<T> list) {
        f.c0.c.j.e(list, "$this$reverse");
        Collections.reverse(list);
    }

    public static String P5(k.a.a.a.n0.j jVar, List<String> list) {
        String strE1 = E1(E2(jVar, list), false);
        if (jVar.getChildCount() == 0) {
            return strE1;
        }
        StringBuilder sbR = c.a.a.a.a.r("(");
        sbR.append(E1(E2(jVar, list), false));
        sbR.append(' ');
        for (int i2 = 0; i2 < jVar.getChildCount(); i2++) {
            if (i2 > 0) {
                sbR.append(' ');
            }
            sbR.append(P5(jVar.getChild(i2), list));
        }
        sbR.append(")");
        return sbR.toString();
    }

    public static X509Certificate[] Q(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException {
        ByteBuffer byteBufferV = v(byteBuffer);
        ByteBuffer byteBufferV2 = v(byteBuffer);
        byte[] bArrW0 = w0(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrW02 = null;
        int i2 = -1;
        int i3 = 0;
        byte[] bArrW03 = null;
        while (true) {
            boolean z = true;
            if (!byteBufferV2.hasRemaining()) {
                if (i2 == -1) {
                    if (i3 == 0) {
                        throw new SecurityException("No signatures found");
                    }
                    throw new SecurityException("No supported signatures found");
                }
                String strE0 = E0(i2);
                Pair<String, ? extends AlgorithmParameterSpec> pairN1 = n1(i2);
                String str = (String) pairN1.first;
                AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairN1.second;
                try {
                    PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(strE0).generatePublic(new X509EncodedKeySpec(bArrW0));
                    java.security.Signature signature = java.security.Signature.getInstance(str);
                    signature.initVerify(publicKeyGeneratePublic);
                    if (algorithmParameterSpec != null) {
                        signature.setParameter(algorithmParameterSpec);
                    }
                    signature.update(byteBufferV);
                    if (!signature.verify(bArrW03)) {
                        throw new SecurityException(c.a.a.a.a.i(str, " signature did not verify"));
                    }
                    byteBufferV.clear();
                    ByteBuffer byteBufferV3 = v(byteBufferV);
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    while (byteBufferV3.hasRemaining()) {
                        i4++;
                        try {
                            ByteBuffer byteBufferV4 = v(byteBufferV3);
                            if (byteBufferV4.remaining() < 8) {
                                throw new IOException("Record too short");
                            }
                            int i5 = byteBufferV4.getInt();
                            arrayList2.add(Integer.valueOf(i5));
                            if (i5 == i2) {
                                bArrW02 = w0(byteBufferV4);
                            }
                        } catch (IOException | BufferUnderflowException e2) {
                            throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e2);
                        }
                    }
                    if (!arrayList.equals(arrayList2)) {
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                    int iE = e(i2);
                    byte[] bArrPut = map.put(Integer.valueOf(iE), bArrW02);
                    if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrW02)) {
                        throw new SecurityException(u0(iE) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    ByteBuffer byteBufferV5 = v(byteBufferV);
                    ArrayList arrayList3 = new ArrayList();
                    int i6 = 0;
                    while (byteBufferV5.hasRemaining()) {
                        i6++;
                        byte[] bArrW04 = w0(byteBufferV5);
                        try {
                            arrayList3.add(new c.c.a.j.q((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrW04)), bArrW04));
                        } catch (CertificateException e3) {
                            throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i6)), e3);
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        throw new SecurityException("No certificates listed");
                    }
                    if (!Arrays.equals(bArrW0, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                        throw new SecurityException("Public key mismatch between certificate and signature record");
                    }
                    ByteBuffer byteBufferV6 = v(byteBufferV);
                    while (byteBufferV6.hasRemaining()) {
                        ByteBuffer byteBufferV7 = v(byteBufferV6);
                        if (byteBufferV7.remaining() < 4) {
                            throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferV7.remaining());
                        }
                        if (byteBufferV7.getInt() == -1091571699) {
                            if (byteBufferV7.remaining() < 4) {
                                throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + byteBufferV7.remaining());
                            }
                            if (byteBufferV7.getInt() == 3) {
                                throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                            }
                        }
                    }
                    return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
                    throw new SecurityException("Failed to verify " + str + " signature", e4);
                }
            }
            i3++;
            try {
                ByteBuffer byteBufferV8 = v(byteBufferV2);
                if (byteBufferV8.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i7 = byteBufferV8.getInt();
                arrayList.add(Integer.valueOf(i7));
                if (i7 != 513 && i7 != 514 && i7 != 769 && i7 != 1057 && i7 != 1059 && i7 != 1061) {
                    switch (i7) {
                        case 257:
                        case 258:
                        case 259:
                        case 260:
                            break;
                        default:
                            z = false;
                            break;
                    }
                }
                if (z && (i2 == -1 || f(i7, i2) > 0)) {
                    bArrW03 = w0(byteBufferV8);
                    i2 = i7;
                }
            } catch (IOException | BufferUnderflowException e5) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i3)), e5);
            }
        }
    }

    public static final int Q0(@NotNull String str, @NotNull String str2) {
        f.c0.c.j.e(str, "<this>");
        f.c0.c.j.e(str2, "other");
        return Build.VERSION.SDK_INT >= 24 ? Collator.getInstance(ULocale.SIMPLIFIED_CHINESE).compare(str, str2) : java.text.Collator.getInstance(Locale.CHINA).compare(str, str2);
    }

    public static String Q1(Element element, String str, String str2) {
        String attributeNS = element.getAttributeNS(str, str2);
        return w3(attributeNS) ? element.getAttribute(str2) : attributeNS;
    }

    public static final int Q2(@NotNull Fragment fragment) {
        f.c0.c.j.e(fragment, "<this>");
        Context contextRequireContext = fragment.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        f.c0.c.j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        SharedPreferences sharedPreferences = contextRequireContext.getSharedPreferences("app_themes", 0);
        f.c0.c.j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        int color = Color.parseColor("#455A64");
        f.c0.c.j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        TypedArray typedArrayObtainStyledAttributes = contextRequireContext.getTheme().obtainStyledAttributes(new int[]{R.attr.colorPrimary});
        f.c0.c.j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, color);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        return sharedPreferences.getInt("primary_color", color);
    }

    @NotNull
    public static String Q3(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, NotificationCompat.CATEGORY_MESSAGE);
        Debug.INSTANCE.log(str);
        return str;
    }

    @NotNull
    public static final CharSequence Q4(@NotNull CharSequence charSequence) {
        f.c0.c.j.e(charSequence, "$this$reversed");
        StringBuilder sbReverse = new StringBuilder(charSequence).reverse();
        f.c0.c.j.d(sbReverse, "StringBuilder(this).reverse()");
        return sbReverse;
    }

    public static final void Q5(@NotNull Context context, int i2) {
        f.c0.c.j.e(context, "<this>");
        e.a.a.h.p.a(new o(context, i2));
    }

    public static byte[][] R(int[] iArr, c.c.a.j.l[] lVarArr) throws DigestException {
        long j2;
        int i2;
        String str;
        long j3 = 0;
        int i3 = 0;
        int i4 = 0;
        long jA = 0;
        while (true) {
            j2 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            i2 = 3;
            if (i4 >= 3) {
                break;
            }
            jA += ((lVarArr[i4].a() + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - 1) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            i4++;
        }
        if (jA >= 2097151) {
            throw new DigestException("Too many chunks: ".concat(String.valueOf(jA)));
        }
        int i5 = (int) jA;
        byte[][] bArr = new byte[iArr.length][];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            byte[] bArr2 = new byte[(y1(iArr[i6]) * i5) + 5];
            bArr2[0] = 90;
            x(i5, bArr2);
            bArr[i6] = bArr2;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        int length = iArr.length;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        int i7 = 0;
        while (true) {
            str = " digest not supported";
            if (i7 >= iArr.length) {
                break;
            }
            String strU0 = u0(iArr[i7]);
            try {
                messageDigestArr[i7] = MessageDigest.getInstance(strU0);
                i7++;
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(c.a.a.a.a.i(strU0, " digest not supported"), e2);
            }
        }
        c.c.a.j.g gVar = new c.c.a.j.g(messageDigestArr);
        int i8 = 0;
        int i9 = 0;
        while (i8 < i2) {
            c.c.a.j.l lVar = lVarArr[i8];
            int i10 = i8;
            int i11 = i9;
            String str2 = str;
            long j4 = j2;
            long jA2 = lVar.a();
            long j5 = j3;
            while (jA2 > j3) {
                int iMin = (int) Math.min(jA2, j4);
                x(iMin, bArr3);
                for (int i12 = 0; i12 < length; i12++) {
                    messageDigestArr[i12].update(bArr3);
                }
                try {
                    lVar.a(gVar, j5, iMin);
                    int i13 = 0;
                    while (i13 < iArr.length) {
                        int i14 = iArr[i13];
                        byte[] bArr4 = bArr[i13];
                        int iY1 = y1(i14);
                        byte[] bArr5 = bArr3;
                        MessageDigest messageDigest = messageDigestArr[i13];
                        int i15 = length;
                        int iDigest = messageDigest.digest(bArr4, (i11 * iY1) + 5, iY1);
                        if (iDigest != iY1) {
                            throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                        }
                        i13++;
                        bArr3 = bArr5;
                        length = i15;
                    }
                    long j6 = iMin;
                    j5 += j6;
                    jA2 -= j6;
                    i11++;
                    j3 = 0;
                    j4 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                } catch (IOException e3) {
                    throw new DigestException("Failed to digest chunk #" + i11 + " of section #" + i3, e3);
                }
            }
            i9 = i11;
            i3++;
            i8 = i10 + 1;
            j3 = 0;
            j2 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            i2 = 3;
            str = str2;
        }
        String str3 = str;
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i16 = 0; i16 < iArr.length; i16++) {
            int i17 = iArr[i16];
            byte[] bArr7 = bArr[i16];
            String strU02 = u0(i17);
            try {
                bArr6[i16] = MessageDigest.getInstance(strU02).digest(bArr7);
            } catch (NoSuchAlgorithmException e4) {
                throw new RuntimeException(c.a.a.a.a.i(strU02, str3), e4);
            }
        }
        return bArr6;
    }

    public static String R0(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(str.split(h.a.a.a.w.DEFAULT_PATH_SEPARATOR)));
        int i2 = 0;
        while (i2 < arrayList.size() - 1) {
            String str2 = (String) arrayList.get(i2);
            if (str2.length() == 0 || str2.equals(".")) {
                arrayList.remove(i2);
                i2--;
            } else if (str2.equals("..")) {
                int i3 = i2 - 1;
                arrayList.remove(i3);
                arrayList.remove(i3);
                i2 -= 2;
            }
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        if (str.startsWith(h.a.a.a.w.DEFAULT_PATH_SEPARATOR)) {
            sb.append(Attributes.InternalPrefix);
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            sb.append((String) arrayList.get(i4));
            if (i4 < arrayList.size() - 1) {
                sb.append(Attributes.InternalPrefix);
            }
        }
        return sb.toString();
    }

    public static final int R1(@NotNull Context context) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        int color = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        f.c0.c.j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.colorBackground});
        f.c0.c.j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, 0);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        return sharedPreferences.getInt("backgroundColor", color);
    }

    public static final int R2(@NotNull Context context) {
        f.c0.c.j.e(context, "<this>");
        return S2(context, u3(context));
    }

    @JvmName(name = "longSnackbar2")
    @NotNull
    public static final Snackbar R3(@NotNull View view, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull final f.c0.b.l<? super View, f.v> lVar) {
        f.c0.c.j.e(view, "<this>");
        f.c0.c.j.e(charSequence, "message");
        f.c0.c.j.e(charSequence2, "actionText");
        f.c0.c.j.e(lVar, "action");
        Snackbar snackbarL = Snackbar.l(view, charSequence, 0);
        snackbarL.m(charSequence2, new View.OnClickListener() { // from class: e.a.a.h.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f.c0.b.l lVar2 = lVar;
                f.c0.c.j.e(lVar2, "$tmp0");
                lVar2.invoke(view2);
            }
        });
        snackbarL.o();
        f.c0.c.j.d(snackbarL, "make(this, message, Snackbar.LENGTH_LONG)\n    .setAction(actionText, action)\n    .apply { show() }");
        return snackbarL;
    }

    public static int R4(float f2) {
        return (int) (f2 + (f2 < 0.0f ? -0.5f : 0.5f));
    }

    public static final void R5(@NotNull Context context, @Nullable CharSequence charSequence) {
        f.c0.c.j.e(context, "<this>");
        e.a.a.h.p.a(new p(context, charSequence));
    }

    public static final <T> boolean S(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        f.c0.c.j.e(collection, "$this$addAll");
        f.c0.c.j.e(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @PublishedApi
    public static final <T> int S0(@NotNull Iterable<? extends T> iterable, int i2) {
        f.c0.c.j.e(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }

    public static final int S1(@NotNull Fragment fragment) {
        f.c0.c.j.e(fragment, "<this>");
        Context contextRequireContext = fragment.requireContext();
        f.c0.c.j.d(contextRequireContext, "requireContext()");
        f.c0.c.j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        int color = 0;
        SharedPreferences sharedPreferences = contextRequireContext.getSharedPreferences("app_themes", 0);
        f.c0.c.j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        f.c0.c.j.e(contextRequireContext, com.umeng.analytics.pro.c.R);
        TypedArray typedArrayObtainStyledAttributes = contextRequireContext.getTheme().obtainStyledAttributes(new int[]{android.R.attr.colorBackground});
        f.c0.c.j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, 0);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        return sharedPreferences.getInt("backgroundColor", color);
    }

    @ColorInt
    @SuppressLint({"PrivateResource"})
    public static final int S2(@NotNull Context context, boolean z) {
        f.c0.c.j.e(context, "<this>");
        return z ? ContextCompat.getColor(context, R.color.primary_text_default_material_light) : ContextCompat.getColor(context, R.color.primary_text_default_material_dark);
    }

    public static final void S3(@NotNull Context context, @Nullable CharSequence charSequence) {
        f.c0.c.j.e(context, "<this>");
        e.a.a.h.p.a(new n(context, charSequence));
    }

    @SinceKotlin(version = "1.2")
    public static final int S4(float f2) {
        if (Float.isNaN(f2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f2);
    }

    public static void S5(@NonNull TextView textView) {
        Object[] objArrF1 = F1(textView);
        if (objArrF1 == null || objArrF1.length <= 0) {
            return;
        }
        for (Object obj : objArrF1) {
            ((TableRowSpan) obj).f7815k = null;
        }
    }

    public static final <T> boolean T(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        f.c0.c.j.e(collection, "$this$addAll");
        f.c0.c.j.e(tArr, "elements");
        return collection.addAll(f.x.e.b(tArr));
    }

    public static int T0(int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 > i3) {
            i4 = i3;
            i3 = i4;
        }
        int i5 = 1;
        int i6 = 1;
        while (i2 > i3) {
            i5 *= i2;
            if (i6 <= i4) {
                i5 /= i6;
                i6++;
            }
            i2--;
        }
        while (i6 <= i4) {
            i5 /= i6;
            i6++;
        }
        return i5;
    }

    public static final int T1(@NotNull Context context) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        int color = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        f.c0.c.j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.colorBackground});
        f.c0.c.j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, 0);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        return sharedPreferences.getInt("bottomBackground", color);
    }

    public static int T2(int[] iArr, int i2, boolean z) {
        int[] iArr2 = iArr;
        int i3 = 0;
        for (int i4 : iArr2) {
            i3 += i4;
        }
        int length = iArr2.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = length - 1;
            if (i5 >= i8) {
                return i6;
            }
            int i9 = 1 << i5;
            i7 |= i9;
            int i10 = 1;
            while (i10 < iArr2[i5]) {
                int i11 = i3 - i10;
                int i12 = length - i5;
                int i13 = i12 - 2;
                int iT0 = T0(i11 - 1, i13);
                if (z && i7 == 0) {
                    int i14 = i12 - 1;
                    if (i11 - i14 >= i14) {
                        iT0 -= T0(i11 - i12, i13);
                    }
                }
                if (i12 - 1 > 1) {
                    int iT02 = 0;
                    for (int i15 = i11 - i13; i15 > i2; i15--) {
                        iT02 += T0((i11 - i15) - 1, i12 - 3);
                    }
                    iT0 -= (i8 - i5) * iT02;
                } else if (i11 > i2) {
                    iT0--;
                }
                i6 += iT0;
                i10++;
                i7 &= ~i9;
                iArr2 = iArr;
            }
            i3 -= i10;
            i5++;
            iArr2 = iArr;
        }
    }

    @PublishedApi
    public static final int T3(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Object T4(f.z.f fVar, f.c0.b.p pVar, int i2, Object obj) throws Throwable {
        q0 q0VarA;
        f.z.f fVarPlus;
        f.z.h hVar = (i2 & 1) != 0 ? f.z.h.INSTANCE : null;
        Thread threadCurrentThread = Thread.currentThread();
        e.a aVar = e.a.a;
        f.z.e eVar = (f.z.e) hVar.get(aVar);
        if (eVar == null) {
            y1 y1Var = y1.f6304b;
            q0VarA = y1.a();
            fVarPlus = f.z.h.INSTANCE.plus(hVar.plus(q0VarA));
            g.b.y yVar = k0.a;
            if (fVarPlus != yVar && fVarPlus.get(aVar) == null) {
                fVarPlus = fVarPlus.plus(yVar);
            }
        } else {
            if (!(eVar instanceof q0)) {
                eVar = null;
            }
            y1 y1Var2 = y1.f6304b;
            q0VarA = y1.a.get();
            fVarPlus = f.z.h.INSTANCE.plus(hVar);
            g.b.y yVar2 = k0.a;
            if (fVarPlus != yVar2 && fVarPlus.get(aVar) == null) {
                fVarPlus = fVarPlus.plus(yVar2);
            }
        }
        g.b.c cVar = new g.b.c(fVarPlus, threadCurrentThread, q0VarA);
        b0 b0Var = b0.DEFAULT;
        cVar.U();
        b0Var.invoke(pVar, cVar, cVar);
        q0 q0Var = cVar.f6174e;
        if (q0Var != null) {
            int i3 = q0.a;
            q0Var.q(false);
        }
        while (!Thread.interrupted()) {
            try {
                q0 q0Var2 = cVar.f6174e;
                long jS = q0Var2 != null ? q0Var2.s() : RecyclerView.FOREVER_NS;
                if (!(cVar.B() instanceof a1)) {
                    Object objA = l1.a(cVar.B());
                    g.b.s sVar = (g.b.s) (objA instanceof g.b.s ? objA : null);
                    if (sVar == null) {
                        return objA;
                    }
                    throw sVar.f6298b;
                }
                LockSupport.parkNanos(cVar, jS);
            } finally {
                q0 q0Var3 = cVar.f6174e;
                if (q0Var3 != null) {
                    int i4 = q0.a;
                    q0Var3.n(false);
                }
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        cVar.p(interruptedException);
        throw interruptedException;
    }

    public static void T5(@NonNull TextView textView) {
        int i2 = R$id.markwon_drawables_scheduler_last_text_hashcode;
        if (textView.getTag(i2) == null) {
            return;
        }
        textView.setTag(i2, null);
        e.b.a.s.g[] gVarArrG1 = G1(textView);
        if (gVarArrG1 == null || gVarArrG1.length <= 0) {
            return;
        }
        for (e.b.a.s.g gVar : gVarArrG1) {
            gVar.f6111b.d(null);
        }
    }

    public static final void U(@NotNull Request.Builder builder, @NotNull Map<String, String> map) {
        f.c0.c.j.e(builder, "<this>");
        f.c0.c.j.e(map, "headers");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
    }

    @NotNull
    public static final <T> java.util.Comparator<T> U0(@NotNull f.c0.b.l<? super T, ? extends Comparable<?>>... lVarArr) {
        f.c0.c.j.e(lVarArr, "selectors");
        if (lVarArr.length > 0) {
            return new q(lVarArr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final int U1(@NotNull RadioGroup radioGroup) {
        f.c0.c.j.e(radioGroup, "<this>");
        int childCount = radioGroup.getChildCount();
        if (childCount > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (radioGroup.getCheckedRadioButtonId() == ViewGroupKt.get(radioGroup, i2).getId()) {
                    return i2;
                }
                if (i3 >= childCount) {
                    break;
                }
                i2 = i3;
            }
        }
        return 0;
    }

    @ColorInt
    @SuppressLint({"PrivateResource"})
    public static final int U2(@NotNull Context context, boolean z) {
        f.c0.c.j.e(context, "<this>");
        return z ? ContextCompat.getColor(context, R.color.secondary_text_default_material_light) : ContextCompat.getColor(context, R.color.secondary_text_default_material_dark);
    }

    @NotNull
    public static final <K, V> Map<K, V> U3(@NotNull f.g<? extends K, ? extends V> gVar) {
        f.c0.c.j.e(gVar, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(gVar.getFirst(), gVar.getSecond());
        f.c0.c.j.d(mapSingletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return mapSingletonMap;
    }

    public static String U4(String str) {
        return c.d.a.a.a.c.b.b().a("s2t").a(str);
    }

    @NotNull
    public static String U5(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "zipPath");
        String str2 = "";
        if (str.length() == 0) {
            return "";
        }
        FileUtils fileUtils = FileUtils.a;
        File fileE = fileUtils.e(fileUtils.k());
        String[] strArr = new String[1];
        f.c0.c.j.e(str, "path");
        try {
            String name = new File(str).getName();
            f.c0.c.j.d(name, "fileName");
            int iU = f.h0.k.u(name, ".", 0, false, 6);
            if (iU != -1) {
                f.c0.c.j.d(name, "fileName");
                name = name.substring(0, iU);
                f.c0.c.j.d(name, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            f.c0.c.j.d(name, "{\n            var fileName = File(path).name\n            val lastIndexOf = fileName.lastIndexOf(\".\")\n            if (lastIndexOf != -1) {\n                fileName = fileName.substring(0, lastIndexOf)\n            }\n            fileName\n        }");
            str2 = name;
        } catch (Exception unused) {
        }
        strArr[0] = str2;
        String strO = fileUtils.o(fileE, strArr);
        FileUtils fileUtils2 = FileUtils.a;
        fileUtils2.h(strO);
        File fileB = fileUtils2.b(str);
        File fileE2 = fileUtils2.e(strO);
        e0 e0Var = e0.a;
        f.c0.c.j.e(fileB, "zipFile");
        f.c0.c.j.e(fileE2, "destDir");
        e0Var.e(fileB, fileE2, null);
        fileUtils2.h(str);
        return strO;
    }

    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static final void V(@NotNull Throwable th, @NotNull Throwable th2) {
        f.c0.c.j.e(th, "$this$addSuppressed");
        f.c0.c.j.e(th2, "exception");
        if (th != th2) {
            f.a0.b.a.a(th, th2);
        }
    }

    public static final <T extends Comparable<?>> int V0(@Nullable T t2, @Nullable T t3) {
        if (t2 == t3) {
            return 0;
        }
        if (t2 == null) {
            return -1;
        }
        if (t3 == null) {
            return 1;
        }
        return t2.compareTo(t3);
    }

    public static List<k.a.a.a.n0.j> V1(k.a.a.a.n0.j jVar) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jVar.getChildCount(); i2++) {
            arrayList.add(jVar.getChild(i2));
        }
        return arrayList;
    }

    @NotNull
    public static final DisplayMetrics V2(@NotNull Activity activity) {
        f.c0.c.j.e(activity, "<this>");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = activity.getWindowManager().getCurrentWindowMetrics();
            f.c0.c.j.d(currentWindowMetrics, "windowManager.currentWindowMetrics");
            Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            f.c0.c.j.d(insetsIgnoringVisibility, "windowMetrics.windowInsets\n            .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())");
            displayMetrics.widthPixels = (currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.left) - insetsIgnoringVisibility.right;
            displayMetrics.heightPixels = (currentWindowMetrics.getBounds().height() - insetsIgnoringVisibility.top) - insetsIgnoringVisibility.bottom;
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    @NotNull
    public static String V3(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            f.c0.c.j.d(messageDigest, "getInstance(\"MD5\")");
            byte[] bytes = str.getBytes(f.h0.a.a);
            f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] bArrDigest = messageDigest.digest(bytes);
            f.c0.c.j.d(bArrDigest, "md5.digest(str.toByteArray())");
            StringBuilder sb = new StringBuilder();
            int length = bArrDigest.length;
            int i2 = 0;
            while (i2 < length) {
                byte b2 = bArrDigest[i2];
                i2++;
                int i3 = b2 & ExifInterface.MARKER;
                if (i3 < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i3));
            }
            String string = sb.toString();
            f.c0.c.j.d(string, "stringBuffer.toString()");
            return string;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int V4(java.lang.CharSequence r7, int r8) {
        /*
            int r0 = r7.length()
            r1 = -1
            if (r8 < r0) goto L8
            return r1
        L8:
            char r0 = r7.charAt(r8)
            r2 = 92
            r3 = 60
            if (r0 != r3) goto L39
        L12:
            int r8 = r8 + 1
            int r0 = r7.length()
            if (r8 >= r0) goto L38
            char r0 = r7.charAt(r8)
            r4 = 10
            if (r0 == r4) goto L38
            if (r0 == r3) goto L38
            r4 = 62
            if (r0 == r4) goto L35
            if (r0 == r2) goto L2b
            goto L12
        L2b:
            int r0 = r8 + 1
            boolean r4 = k.c.c.v.c.a(r7, r0)
            if (r4 == 0) goto L12
            r8 = r0
            goto L12
        L35:
            int r8 = r8 + 1
            return r8
        L38:
            return r1
        L39:
            r0 = 0
            r3 = r8
        L3b:
            int r4 = r7.length()
            if (r3 >= r4) goto L79
            char r4 = r7.charAt(r3)
            if (r4 == 0) goto L76
            r5 = 32
            if (r4 == r5) goto L76
            if (r4 == r2) goto L6a
            r6 = 40
            if (r4 == r6) goto L65
            r5 = 41
            if (r4 == r5) goto L5f
            boolean r4 = java.lang.Character.isISOControl(r4)
            if (r4 == 0) goto L73
            if (r3 == r8) goto L7d
        L5d:
            r1 = r3
            goto L7d
        L5f:
            if (r0 != 0) goto L62
            goto L5d
        L62:
            int r0 = r0 + (-1)
            goto L73
        L65:
            int r0 = r0 + 1
            if (r0 <= r5) goto L73
            goto L7d
        L6a:
            int r4 = r3 + 1
            boolean r5 = k.c.c.v.c.a(r7, r4)
            if (r5 == 0) goto L73
            r3 = r4
        L73:
            int r3 = r3 + 1
            goto L3b
        L76:
            if (r3 == r8) goto L7d
            goto L5d
        L79:
            int r1 = r7.length()
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.f.V4(java.lang.CharSequence, int):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void V5(k.a aVar, int i2, boolean z, f.c0.b.a aVar2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            z = true;
        }
        if ((i3 & 4) != 0) {
            aVar2 = null;
        }
        aVar.u(i2, z, aVar2);
    }

    @Nullable
    public static byte[] W(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        f.c0.c.j.e(str2, "key");
        f.c0.c.j.e(str3, "transformation");
        f.c0.c.j.e(str4, "iv");
        e.a.a.h.k kVar = e.a.a.h.k.a;
        byte[] bArrE = f.h0.k.e(str);
        return kVar.a(Base64.decode(bArrE, 2), f.h0.k.e(str2), str3, f.h0.k.e(str4));
    }

    @ColorInt
    public static int W0(@ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        return ColorUtils.setAlphaComponent(i2, (Color.alpha(i2) * i3) / 255);
    }

    @NotNull
    public static final String W1(@NotNull Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final int W2(int i2) {
        return (int) TypedValue.applyDimension(2, i2, Resources.getSystem().getDisplayMetrics());
    }

    @NotNull
    public static String W3(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        return e.a.a.h.v.b(str);
    }

    public static int W4(CharSequence charSequence, int i2) {
        while (i2 < charSequence.length()) {
            switch (charSequence.charAt(i2)) {
                case '[':
                    return -1;
                case '\\':
                    int i3 = i2 + 1;
                    if (k.c.c.v.c.a(charSequence, i3)) {
                        i2 = i3;
                    }
                    break;
                case ']':
                    return i2;
            }
            i2++;
        }
        return charSequence.length();
    }

    public static /* synthetic */ void W5(e.a.a.g.d.i.s1.e.a aVar, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            z = true;
        }
        aVar.b(i2, z);
    }

    @Nullable
    public static String X(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        f.c0.c.j.e(str2, "key");
        f.c0.c.j.e(str3, "transformation");
        f.c0.c.j.e(str4, "iv");
        byte[] bArrAesBase64DecodeToByteArray = jsExtensions.aesBase64DecodeToByteArray(str, str2, str3, str4);
        if (bArrAesBase64DecodeToByteArray == null) {
            return null;
        }
        return new String(bArrAesBase64DecodeToByteArray, f.h0.a.a);
    }

    @NotNull
    public static Object X0(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "urlStr");
        return T4(null, new h(str, null), 1, null);
    }

    @Nullable
    public static final String X1(@NotNull Context context) {
        ClipData primaryClip;
        f.c0.c.j.e(context, "<this>");
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || primaryClip.getItemCount() <= 0) {
            return null;
        }
        String string = primaryClip.getItemAt(0).getText().toString();
        Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
        return f.h0.k.R(string).toString();
    }

    public static final int X2(@NotNull Context context) {
        f.c0.c.j.e(context, "<this>");
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static final int X3(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int X4(java.lang.CharSequence r3, int r4, char r5) {
        /*
        L0:
            int r0 = r3.length()
            if (r4 >= r0) goto L28
            char r0 = r3.charAt(r4)
            r1 = 92
            if (r0 != r1) goto L18
            int r1 = r4 + 1
            boolean r2 = k.c.c.v.c.a(r3, r1)
            if (r2 == 0) goto L18
            r4 = r1
            goto L25
        L18:
            if (r0 != r5) goto L1b
            return r4
        L1b:
            r1 = 41
            if (r5 != r1) goto L25
            r1 = 40
            if (r0 != r1) goto L25
            r3 = -1
            return r3
        L25:
            int r4 = r4 + 1
            goto L0
        L28:
            int r3 = r3.length()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.f.X4(java.lang.CharSequence, int, char):int");
    }

    public static int X5(int i2, int i3) {
        int i4 = i3 * (-862048943);
        int i5 = i2 ^ (((i4 >>> 17) | (i4 << 15)) * 461845907);
        return (((i5 >>> 19) | (i5 << 13)) * 5) - 430675100;
    }

    @Nullable
    public static byte[] Y(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        f.c0.c.j.e(str2, "key");
        f.c0.c.j.e(str3, "transformation");
        f.c0.c.j.e(str4, "iv");
        return e.a.a.h.k.a.a(f.h0.k.e(str), f.h0.k.e(str2), str3, f.h0.k.e(str4));
    }

    public static final boolean Y0(@NotNull byte[] bArr, byte b2) {
        f.c0.c.j.e(bArr, "$this$contains");
        f.c0.c.j.e(bArr, "$this$indexOf");
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (b2 == bArr[i2]) {
                break;
            }
            i2++;
        }
        return i2 >= 0;
    }

    @ColorInt
    public static int Y1(@NonNull Context context, @AttrRes int i2, @ColorInt int i3) {
        TypedValue typedValueL4 = L4(context, i2);
        return typedValueL4 != null ? typedValueL4.data : i3;
    }

    @androidx.annotation.Nullable
    public static c.e.a.b.t.b Y2(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return new c.e.a.b.t.b(context, resourceId);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0076 -> B:21:0x007a). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object Y3(@org.jetbrains.annotations.NotNull okhttp3.OkHttpClient r7, int r8, @org.jetbrains.annotations.NotNull f.c0.b.l<? super okhttp3.Request.Builder, f.v> r9, @org.jetbrains.annotations.NotNull f.z.d<? super okhttp3.ResponseBody> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof c.b.a.m.f.l
            if (r0 == 0) goto L13
            r0 = r10
            c.b.a.m.f$l r0 = (c.b.a.m.f.l) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            c.b.a.m.f$l r0 = new c.b.a.m.f$l
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r7 = r0.I$2
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$1
            okhttp3.Request$Builder r2 = (okhttp3.Request.Builder) r2
            java.lang.Object r4 = r0.L$0
            okhttp3.OkHttpClient r4 = (okhttp3.OkHttpClient) r4
            E5(r10)
            goto L7a
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            E5(r10)
            okhttp3.Request$Builder r10 = new okhttp3.Request$Builder
            r10.<init>()
            e.a.a.d.e r2 = e.a.a.d.e.a
            java.lang.String r2 = e.a.a.d.e.f5518c
            java.lang.String r4 = "User-Agent"
            r10.header(r4, r2)
            r9.invoke(r10)
            r9 = 0
            r2 = 0
            if (r8 < 0) goto L91
            r9 = r8
            r2 = r10
            r8 = r7
            r7 = 0
        L59:
            int r10 = r7 + 1
            okhttp3.Request r4 = r2.build()
            okhttp3.Call r4 = r8.newCall(r4)
            r0.L$0 = r8
            r0.L$1 = r2
            r0.I$0 = r9
            r0.I$1 = r10
            r0.I$2 = r7
            r0.label = r3
            java.lang.Object r4 = t0(r4, r0)
            if (r4 != r1) goto L76
            return r1
        L76:
            r6 = r4
            r4 = r8
            r8 = r10
            r10 = r6
        L7a:
            okhttp3.Response r10 = (okhttp3.Response) r10
            boolean r5 = r10.isSuccessful()
            if (r5 == 0) goto L8a
            okhttp3.ResponseBody r7 = r10.body()
            f.c0.c.j.c(r7)
            return r7
        L8a:
            if (r7 != r9) goto L8e
            r9 = r10
            goto L91
        L8e:
            r7 = r8
            r8 = r4
            goto L59
        L91:
            f.c0.c.j.c(r9)
            okhttp3.ResponseBody r7 = r9.body()
            if (r7 == 0) goto L9b
            return r7
        L9b:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = r9.message()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.f.Y3(okhttp3.OkHttpClient, int, f.c0.b.l, f.z.d):java.lang.Object");
    }

    @Nullable
    public static final Bitmap Y4(@NotNull View view) {
        Object objM11constructorimpl;
        f.c0.c.j.e(view, "<this>");
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.translate(-view.getScrollX(), -view.getScrollY());
            view.draw(canvas);
            objM11constructorimpl = f.h.m11constructorimpl(bitmapCreateBitmap);
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(m1(th));
        }
        if (f.h.m16isFailureimpl(objM11constructorimpl)) {
            objM11constructorimpl = null;
        }
        return (Bitmap) objM11constructorimpl;
    }

    public static int Y5(int i2, Object obj) {
        return X5(i2, obj != null ? obj.hashCode() : 0);
    }

    @Nullable
    public static String Z(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        f.c0.c.j.e(str2, "key");
        f.c0.c.j.e(str3, "transformation");
        f.c0.c.j.e(str4, "iv");
        byte[] bArrAesDecodeToByteArray = jsExtensions.aesDecodeToByteArray(str, str2, str3, str4);
        if (bArrAesDecodeToByteArray == null) {
            return null;
        }
        return new String(bArrAesDecodeToByteArray, f.h0.a.a);
    }

    public static final boolean Z0(@NotNull int[] iArr, int i2) {
        f.c0.c.j.e(iArr, "$this$contains");
        f.c0.c.j.e(iArr, "$this$indexOf");
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (i2 == iArr[i3]) {
                break;
            }
            i3++;
        }
        return i3 >= 0;
    }

    @ColorInt
    public static int Z1(@NonNull View view, @AttrRes int i2) {
        return N4(view.getContext(), i2, view.getClass().getCanonicalName());
    }

    public static String Z2(Element element) {
        if (element == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        NodeList childNodes = element.getChildNodes();
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node nodeItem = childNodes.item(i2);
            if (nodeItem != null && nodeItem.getNodeType() == 3) {
                sb.append(((Text) nodeItem).getData());
            }
        }
        return sb.toString().trim();
    }

    public static /* synthetic */ Object Z3(OkHttpClient okHttpClient, int i2, f.c0.b.l lVar, f.z.d dVar, int i3) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return Y3(okHttpClient, i2, lVar, dVar);
    }

    public static final void Z4(@NotNull Context context, @Nullable CharSequence charSequence, @NotNull List<? extends CharSequence> list, @NotNull f.c0.b.p<? super DialogInterface, ? super Integer, f.v> pVar) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(list, "items");
        f.c0.c.j.e(pVar, "onClick");
        f.c0.c.j.e(context, "ctx");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (charSequence != null) {
            f.c0.c.j.e(charSequence, "title");
            builder.setTitle(charSequence);
        }
        f.c0.c.j.e(list, "items");
        f.c0.c.j.e(pVar, "onItemSelected");
        int size = list.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2).toString();
        }
        builder.setItems(strArr, new e.a.a.e.a.d(pVar));
        AlertDialog alertDialogShow = builder.show();
        f.c0.c.j.d(alertDialogShow, "builder.show()");
        f.c0.c.j.e(alertDialogShow, "<this>");
        ATH.a.d(alertDialogShow);
    }

    @androidx.annotation.Nullable
    public static PorterDuffColorFilter Z5(@NonNull Drawable drawable, @androidx.annotation.Nullable ColorStateList colorStateList, @androidx.annotation.Nullable PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    @NotNull
    public static final a0 a() {
        f1 f1VarC = c(null, 1);
        g.b.y yVar = k0.a;
        return new g.b.g2.e(f.a.C0182a.d((k1) f1VarC, g.b.g2.m.f6207b));
    }

    @Nullable
    public static byte[] a0(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "data");
        f.c0.c.j.e(str2, "key");
        f.c0.c.j.e(str3, "transformation");
        f.c0.c.j.e(str4, "iv");
        return Base64.encode(e.a.a.h.k.a.b(f.h0.k.e(str), f.h0.k.e(str2), str3, f.h0.k.e(str4)), 2);
    }

    public static final boolean a1(@NotNull long[] jArr, long j2) {
        f.c0.c.j.e(jArr, "$this$contains");
        f.c0.c.j.e(jArr, "$this$indexOf");
        int length = jArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (j2 == jArr[i2]) {
                break;
            }
            i2++;
        }
        return i2 >= 0;
    }

    @androidx.annotation.Nullable
    public static ColorStateList a2(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        int resourceId;
        ColorStateList colorStateList;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) ? typedArray.getColorStateList(i2) : colorStateList;
    }

    @NotNull
    public static String a3(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "unzipPath");
        int i2 = 0;
        if (str.length() == 0) {
            return "";
        }
        f.c0.c.j.e(str, "filePath");
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            int length = fileArrListFiles.length;
            while (i2 < length) {
                File file2 = fileArrListFiles[i2];
                i2++;
                f.c0.c.j.d(file2, "f");
                String strA = e.a.a.h.l.a(file2);
                byte[] bArrC = f.b0.d.c(file2);
                Charset charsetForName = Charset.forName(strA);
                f.c0.c.j.d(charsetForName, "Charset.forName(charsetName)");
                sb.append(new String(bArrC, charsetForName));
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        FileUtils.a.h(str);
        String string = sb.toString();
        f.c0.c.j.d(string, "contents.toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0076 -> B:21:0x007a). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a4(@org.jetbrains.annotations.NotNull okhttp3.OkHttpClient r8, int r9, @org.jetbrains.annotations.NotNull f.c0.b.l<? super okhttp3.Request.Builder, f.v> r10, @org.jetbrains.annotations.NotNull f.z.d<? super e.a.a.d.v.l> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof c.b.a.m.f.m
            if (r0 == 0) goto L13
            r0 = r11
            c.b.a.m.f$m r0 = (c.b.a.m.f.m) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            c.b.a.m.f$m r0 = new c.b.a.m.f$m
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            f.z.i.a r1 = f.z.i.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            int r8 = r0.I$2
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            okhttp3.Request$Builder r2 = (okhttp3.Request.Builder) r2
            java.lang.Object r5 = r0.L$0
            okhttp3.OkHttpClient r5 = (okhttp3.OkHttpClient) r5
            E5(r11)
            goto L7a
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            E5(r11)
            okhttp3.Request$Builder r11 = new okhttp3.Request$Builder
            r11.<init>()
            e.a.a.d.e r2 = e.a.a.d.e.a
            java.lang.String r2 = e.a.a.d.e.f5518c
            java.lang.String r5 = "User-Agent"
            r11.header(r5, r2)
            r10.invoke(r11)
            if (r9 < 0) goto L99
            r10 = 0
            r10 = r9
            r2 = r11
            r9 = r8
            r8 = 0
        L59:
            int r11 = r8 + 1
            okhttp3.Request r5 = r2.build()
            okhttp3.Call r5 = r9.newCall(r5)
            r0.L$0 = r9
            r0.L$1 = r2
            r0.I$0 = r10
            r0.I$1 = r11
            r0.I$2 = r8
            r0.label = r4
            java.lang.Object r5 = t0(r5, r0)
            if (r5 != r1) goto L76
            return r1
        L76:
            r7 = r5
            r5 = r9
            r9 = r11
            r11 = r7
        L7a:
            okhttp3.Response r11 = (okhttp3.Response) r11
            boolean r6 = r11.isSuccessful()
            if (r6 == 0) goto L93
            e.a.a.d.v.l r8 = new e.a.a.d.v.l
            okhttp3.ResponseBody r9 = r11.body()
            f.c0.c.j.c(r9)
            java.lang.String r9 = D5(r9, r3, r4)
            r8.<init>(r11, r9)
            return r8
        L93:
            if (r8 != r10) goto L96
            goto L9a
        L96:
            r8 = r9
            r9 = r5
            goto L59
        L99:
            r11 = r3
        L9a:
            e.a.a.d.v.l r8 = new e.a.a.d.v.l
            f.c0.c.j.c(r11)
            okhttp3.ResponseBody r9 = r11.body()
            if (r9 != 0) goto Laa
            java.lang.String r9 = r11.message()
            goto Lae
        Laa:
            java.lang.String r9 = D5(r9, r3, r4)
        Lae:
            r8.<init>(r11, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.f.a4(okhttp3.OkHttpClient, int, f.c0.b.l, f.z.d):java.lang.Object");
    }

    public static final void a5(@NotNull Context context, @Nullable Integer num, @NotNull List<? extends CharSequence> list, @NotNull f.c0.b.p<? super DialogInterface, ? super Integer, f.v> pVar) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(list, "items");
        f.c0.c.j.e(pVar, "onClick");
        f.c0.c.j.e(context, "ctx");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (num != null) {
            builder.setTitle(num.intValue());
        }
        f.c0.c.j.e(list, "items");
        f.c0.c.j.e(pVar, "onItemSelected");
        int size = list.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2).toString();
        }
        builder.setItems(strArr, new e.a.a.e.a.d(pVar));
        AlertDialog alertDialogShow = builder.show();
        f.c0.c.j.d(alertDialogShow, "builder.show()");
        f.c0.c.j.e(alertDialogShow, "<this>");
        ATH.a.d(alertDialogShow);
    }

    @NotNull
    public static String a6(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        Charset charsetForName = Charset.forName(DataUtil.defaultCharset);
        f.c0.c.j.d(charsetForName, "Charset.forName(charsetName)");
        byte[] bytes = str.getBytes(charsetForName);
        f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        Charset charset = f.h0.a.a;
        byte[] bytes2 = new String(bytes, charset).getBytes(charset);
        f.c0.c.j.d(bytes2, "(this as java.lang.String).getBytes(charset)");
        Charset charsetForName2 = Charset.forName(DataUtil.defaultCharset);
        f.c0.c.j.d(charsetForName2, "Charset.forName(charsetName)");
        String str2 = new String(bytes2, charsetForName2);
        Charset charsetForName3 = Charset.forName("GBK");
        f.c0.c.j.d(charsetForName3, "Charset.forName(charsetName)");
        byte[] bytes3 = str2.getBytes(charsetForName3);
        f.c0.c.j.d(bytes3, "(this as java.lang.String).getBytes(charset)");
        return new String(bytes3, charset);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final f.d0.c b(int i2) {
        return new f.d0.d(i2, i2 >> 31);
    }

    @Nullable
    public static String b0(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "data");
        f.c0.c.j.e(str2, "key");
        f.c0.c.j.e(str3, "transformation");
        f.c0.c.j.e(str4, "iv");
        byte[] bArrAesEncodeToBase64ByteArray = jsExtensions.aesEncodeToBase64ByteArray(str, str2, str3, str4);
        if (bArrAesEncodeToBase64ByteArray == null) {
            return null;
        }
        return new String(bArrAesEncodeToBase64ByteArray, f.h0.a.a);
    }

    public static final <T> boolean b1(@NotNull T[] tArr, T t2) {
        int i2;
        f.c0.c.j.e(tArr, "$this$contains");
        f.c0.c.j.e(tArr, "$this$indexOf");
        if (t2 == null) {
            int length = tArr.length;
            i2 = 0;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    break;
                }
                i2++;
            }
            i2 = -1;
        } else {
            int length2 = tArr.length;
            for (int i3 = 0; i3 < length2; i3++) {
                if (f.c0.c.j.a(t2, tArr[i3])) {
                    i2 = i3;
                    break;
                }
            }
            i2 = -1;
        }
        return i2 >= 0;
    }

    @androidx.annotation.Nullable
    public static ColorStateList b2(@NonNull Context context, @NonNull TintTypedArray tintTypedArray, @StyleableRes int i2) {
        int resourceId;
        ColorStateList colorStateList;
        return (!tintTypedArray.hasValue(i2) || (resourceId = tintTypedArray.getResourceId(i2, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) ? tintTypedArray.getColorStateList(i2) : colorStateList;
    }

    @NonNull
    public static ImageHeaderParser.ImageType b3(@NonNull List<ImageHeaderParser> list, @androidx.annotation.Nullable InputStream inputStream, @NonNull c.b.a.m.q.c0.b bVar) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new w(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return c3(list, new a(inputStream));
    }

    public static k.e.a.n[] b4(int i2) {
        k.e.a.n[] nVarArr = new k.e.a.n[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            nVarArr[i3] = new k.e.a.n();
        }
        return nVarArr;
    }

    public static boolean b5(int i2, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(obj) == i2;
    }

    @JvmName(name = "viewBindingFragment")
    @NotNull
    public static final <F extends Fragment, T extends ViewBinding> ViewBindingProperty<F, T> b6(@NotNull Fragment fragment, @NotNull f.c0.b.l<? super F, ? extends T> lVar) {
        f.c0.c.j.e(fragment, "<this>");
        f.c0.c.j.e(lVar, "viewBinder");
        return new e.a.a.h.f0.c(lVar);
    }

    public static g.b.q c(f1 f1Var, int i2) {
        int i3 = i2 & 1;
        return new w1(null);
    }

    @Nullable
    public static byte[] c0(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "data");
        f.c0.c.j.e(str2, "key");
        f.c0.c.j.e(str3, "transformation");
        f.c0.c.j.e(str4, "iv");
        return e.a.a.h.k.a.b(f.h0.k.e(str), f.h0.k.e(str2), str3, f.h0.k.e(str4));
    }

    public static final boolean c1(@NotNull short[] sArr, short s2) {
        f.c0.c.j.e(sArr, "$this$contains");
        f.c0.c.j.e(sArr, "$this$indexOf");
        int length = sArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (s2 == sArr[i2]) {
                break;
            }
            i2++;
        }
        return i2 >= 0;
    }

    public static final int c2(@NotNull Context context, @ColorRes int i2) {
        f.c0.c.j.e(context, "<this>");
        return ContextCompat.getColor(context, i2);
    }

    @NonNull
    public static ImageHeaderParser.ImageType c3(@NonNull List<ImageHeaderParser> list, d dVar) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType imageTypeA = dVar.a(list.get(i2));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @SinceKotlin(version = "1.3")
    public static final int c4(@NotNull f.d0.c cVar, @NotNull f.e0.d dVar) {
        f.c0.c.j.e(cVar, "$this$nextInt");
        f.c0.c.j.e(dVar, "range");
        if (dVar.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + dVar);
        }
        int i2 = dVar.f6128b;
        if (i2 < Integer.MAX_VALUE) {
            return cVar.nextInt(dVar.a, i2 + 1);
        }
        int i3 = dVar.a;
        return i3 > Integer.MIN_VALUE ? cVar.nextInt(i3 - 1, i2) + 1 : cVar.nextInt();
    }

    public static final void c5(@NotNull Context context, @NotNull String str) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Object systemService = context.getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        ClipData clipDataNewPlainText = ClipData.newPlainText(null, str);
        if (clipboardManager == null) {
            return;
        }
        clipboardManager.setPrimaryClip(clipDataNewPlainText);
        f.c0.c.j.e(context, "<this>");
        e.a.a.h.p.a(new e.a.a.h.h(context, R.string.copy_complete));
    }

    public static final void c6(@NotNull View view) {
        f.c0.c.j.e(view, "<this>");
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }

    public static void d(k.a.a.a.n0.d dVar, int i2, boolean z, List<? super k.a.a.a.n0.d> list) {
        if (z && (dVar instanceof k.a.a.a.n0.h)) {
            if (((k.a.a.a.n0.h) dVar).a().getType() == i2) {
                list.add(dVar);
            }
        } else if (!z && (dVar instanceof k.a.a.a.y) && ((k.a.a.a.y) dVar).getRuleIndex() == i2) {
            list.add(dVar);
        }
        for (int i3 = 0; i3 < dVar.getChildCount(); i3++) {
            d(dVar.getChild(i3), i2, z, list);
        }
    }

    @Nullable
    public static String d0(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "data");
        f.c0.c.j.e(str2, "key");
        f.c0.c.j.e(str3, "transformation");
        f.c0.c.j.e(str4, "iv");
        byte[] bArrAesEncodeToByteArray = jsExtensions.aesEncodeToByteArray(str, str2, str3, str4);
        if (bArrAesEncodeToByteArray == null) {
            return null;
        }
        return new String(bArrAesEncodeToByteArray, f.h0.a.a);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "contentDeepToString")
    @NotNull
    @PublishedApi
    public static final <T> String d1(@Nullable T[] tArr) throws IOException {
        int length = tArr.length;
        if (length > 429496729) {
            length = 429496729;
        }
        StringBuilder sb = new StringBuilder((length * 5) + 2);
        e1(tArr, sb, new ArrayList());
        String string = sb.toString();
        f.c0.c.j.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @androidx.annotation.Nullable
    public static ViewGroup d2(@androidx.annotation.Nullable View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static String d3(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return c.e.a.b.l.u.c("yMMMd", locale).format(new Date(j2));
        }
        AtomicReference<c.e.a.b.l.t> atomicReference = c.e.a.b.l.u.a;
        DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
        dateInstance.setTimeZone(c.e.a.b.l.u.g());
        return dateInstance.format(new Date(j2));
    }

    public static /* synthetic */ void d4(e.a.a.e.a.h hVar, f.c0.b.l lVar, int i2, Object obj) {
        int i3 = i2 & 1;
        hVar.k(null);
    }

    public static void d5(@NonNull View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) background;
            MaterialShapeDrawable.b bVar = materialShapeDrawable.f2333c;
            if (bVar.o != f2) {
                bVar.o = f2;
                materialShapeDrawable.C();
            }
        }
    }

    public static final void d6(@NotNull View view, boolean z) {
        f.c0.c.j.e(view, "<this>");
        if (z && view.getVisibility() != 0) {
            view.setVisibility(0);
        } else {
            if (z || view.getVisibility() != 0) {
                return;
            }
            view.setVisibility(4);
        }
    }

    public static int e(int i2) {
        if (i2 == 513) {
            return 1;
        }
        if (i2 == 514) {
            return 2;
        }
        if (i2 == 769) {
            return 1;
        }
        if (i2 == 1057 || i2 == 1059 || i2 == 1061) {
            return 3;
        }
        switch (i2) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
        }
    }

    @Nullable
    public static String e0(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "urlStr");
        return (String) T4(null, new C0013f(str, null), 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void e1(T[] tArr, StringBuilder sb, List<Object[]> list) throws IOException {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(", ");
            }
            Object[] objArr = tArr[i2];
            String strQ = "null";
            if (objArr == 0) {
                sb.append("null");
            } else if (objArr instanceof Object[]) {
                e1(objArr, sb, list);
            } else if (objArr instanceof byte[]) {
                String string = Arrays.toString((byte[]) objArr);
                f.c0.c.j.d(string, "java.util.Arrays.toString(this)");
                sb.append(string);
            } else if (objArr instanceof short[]) {
                String string2 = Arrays.toString((short[]) objArr);
                f.c0.c.j.d(string2, "java.util.Arrays.toString(this)");
                sb.append(string2);
            } else if (objArr instanceof int[]) {
                String string3 = Arrays.toString((int[]) objArr);
                f.c0.c.j.d(string3, "java.util.Arrays.toString(this)");
                sb.append(string3);
            } else if (objArr instanceof long[]) {
                String string4 = Arrays.toString((long[]) objArr);
                f.c0.c.j.d(string4, "java.util.Arrays.toString(this)");
                sb.append(string4);
            } else if (objArr instanceof float[]) {
                String string5 = Arrays.toString((float[]) objArr);
                f.c0.c.j.d(string5, "java.util.Arrays.toString(this)");
                sb.append(string5);
            } else if (objArr instanceof double[]) {
                String string6 = Arrays.toString((double[]) objArr);
                f.c0.c.j.d(string6, "java.util.Arrays.toString(this)");
                sb.append(string6);
            } else if (objArr instanceof char[]) {
                String string7 = Arrays.toString((char[]) objArr);
                f.c0.c.j.d(string7, "java.util.Arrays.toString(this)");
                sb.append(string7);
            } else if (objArr instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) objArr);
                f.c0.c.j.d(string8, "java.util.Arrays.toString(this)");
                sb.append(string8);
            } else if (objArr instanceof f.m) {
                byte[] bArr = ((f.m) objArr).a;
                if (bArr != null) {
                    f.c0.c.j.e(bArr, ai.aC);
                    strQ = f.x.e.q(new f.m(bArr), ", ", "[", "]", 0, null, null, 56);
                }
                sb.append(strQ);
            } else if (objArr instanceof f.t) {
                short[] sArr = ((f.t) objArr).a;
                if (sArr != null) {
                    f.c0.c.j.e(sArr, ai.aC);
                    strQ = f.x.e.q(new f.t(sArr), ", ", "[", "]", 0, null, null, 56);
                }
                sb.append(strQ);
            } else if (objArr instanceof f.o) {
                int[] iArr = ((f.o) objArr).a;
                if (iArr != null) {
                    f.c0.c.j.e(iArr, ai.aC);
                    strQ = f.x.e.q(new f.o(iArr), ", ", "[", "]", 0, null, null, 56);
                }
                sb.append(strQ);
            } else if (objArr instanceof f.q) {
                long[] jArr = ((f.q) objArr).a;
                if (jArr != null) {
                    f.c0.c.j.e(jArr, ai.aC);
                    strQ = f.x.e.q(new f.q(jArr), ", ", "[", "]", 0, null, null, 56);
                }
                sb.append(strQ);
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(']');
        list.remove(f.x.e.m(list));
    }

    @androidx.annotation.Nullable
    public static c.e.a.b.q.i e2(@NonNull View view) {
        return H2(d2(view));
    }

    public static final void e3(@NotNull View view) {
        f.c0.c.j.e(view, "<this>");
        if (view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static <T> T e4(T t2, final String str, final Object... objArr) {
        Objects.requireNonNull(t2, (Supplier<String>) C$r8$wrapper$java$util$function$Supplier$WRP.convert(new j$.util.function.Supplier() { // from class: k.b.a.a.a
            @Override // j$.util.function.Supplier
            public final Object get() {
                return String.format(str, objArr);
            }
        }));
        return t2;
    }

    public static void e5(@NonNull View view, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        c.e.a.b.n.a aVar = materialShapeDrawable.f2333c.f2343b;
        if (aVar != null && aVar.a) {
            float fI2 = I2(view);
            MaterialShapeDrawable.b bVar = materialShapeDrawable.f2333c;
            if (bVar.n != fI2) {
                bVar.n = fI2;
                materialShapeDrawable.C();
            }
        }
    }

    public static int e6(@NonNull Canvas canvas, @NonNull CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            e.b.a.p.u.j[] jVarArr = (e.b.a.p.u.j[]) spanned.getSpans(0, spanned.length(), e.b.a.p.u.j.class);
            TextView textView = null;
            Layout layout = (jVarArr == null || jVarArr.length <= 0) ? null : jVarArr[0].a.get();
            if (layout != null) {
                return layout.getWidth();
            }
            e.b.a.p.u.k[] kVarArr = (e.b.a.p.u.k[]) spanned.getSpans(0, spanned.length(), e.b.a.p.u.k.class);
            if (kVarArr != null && kVarArr.length > 0) {
                textView = kVarArr[0].a.get();
            }
            if (textView != null) {
                return (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
            }
        }
        return canvas.getWidth();
    }

    public static int f(int i2, int i3) {
        int iE = e(i2);
        int iE2 = e(i3);
        if (iE != 1) {
            if (iE == 2) {
                if (iE2 != 1) {
                    if (iE2 != 2) {
                        if (iE2 != 3) {
                            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(iE2)));
                        }
                    }
                }
                return 1;
            }
            if (iE != 3) {
                throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(iE)));
            }
            if (iE2 != 1) {
                if (iE2 == 2) {
                    return -1;
                }
                if (iE2 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(iE2)));
                }
            }
            return 1;
        }
        if (iE2 != 1) {
            if (iE2 == 2 || iE2 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(iE2)));
        }
        return 0;
    }

    @NotNull
    public static e.a.a.d.v.l[] f0(@NotNull JsExtensions jsExtensions, @NotNull String[] strArr) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(strArr, "urlList");
        return (e.a.a.d.v.l[]) T4(null, new g(strArr, null), 1, null);
    }

    @SinceKotlin(version = "1.3")
    public static final void f1(int i2, int i3) {
        if (i2 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i3 + ").");
    }

    @NotNull
    public static String f2(@NotNull JsExtensions jsExtensions, @NotNull String str, @Nullable String str2) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "tag");
        e.a.a.d.v.f fVar = e.a.a.d.v.f.a;
        String strB = fVar.b(str);
        Map<String, String> mapA = fVar.a(strB);
        if (str2 == null) {
            return strB;
        }
        String str3 = (String) ((LinkedHashMap) mapA).get(str2);
        return str3 == null ? "" : str3;
    }

    @InternalCoroutinesApi
    public static final void f3(@NotNull f.z.f fVar, @NotNull Throwable th) {
        try {
            int i2 = CoroutineExceptionHandler.M;
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) fVar.get(CoroutineExceptionHandler.a.a);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(fVar, th);
            } else {
                z.a(fVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                V(runtimeException, th);
                th = runtimeException;
            }
            z.a(fVar, th);
        }
    }

    public static void f4(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object must not be null");
        }
    }

    public static final void f5(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        f.c0.c.j.e(str2, "title");
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.addFlags(268435456);
            intent.putExtra("android.intent.extra.SUBJECT", str2);
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.setType(d.a.a.a.MIME_PLAINTEXT);
            context.startActivity(Intent.createChooser(intent, str2));
            f.h.m11constructorimpl(f.v.a);
        } catch (Throwable th) {
            f.h.m11constructorimpl(m1(th));
        }
    }

    @Nullable
    public static final <T> Object f6(@NotNull f.z.f fVar, @NotNull f.c0.b.p<? super a0, ? super f.z.d<? super T>, ? extends Object> pVar, @NotNull f.z.d<? super T> dVar) throws Throwable {
        Object objW;
        f.z.f context = dVar.getContext();
        f.z.f fVarPlus = context.plus(fVar);
        f1 f1Var = (f1) fVarPlus.get(f1.N);
        if (f1Var != null && !f1Var.isActive()) {
            throw f1Var.d();
        }
        if (fVarPlus == context) {
            g.b.g2.p pVar2 = new g.b.g2.p(fVarPlus, dVar);
            objW = s5(pVar2, pVar2, pVar);
        } else {
            int i2 = f.z.e.L;
            e.a aVar = e.a.a;
            if (f.c0.c.j.a((f.z.e) fVarPlus.get(aVar), (f.z.e) context.get(aVar))) {
                c2 c2Var = new c2(fVarPlus, dVar);
                Object objB = g.b.g2.s.b(fVarPlus, null);
                try {
                    Object objS5 = s5(c2Var, c2Var, pVar);
                    g.b.g2.s.a(fVarPlus, objB);
                    objW = objS5;
                } catch (Throwable th) {
                    g.b.g2.s.a(fVarPlus, objB);
                    throw th;
                }
            } else {
                i0 i0Var = new i0(fVarPlus, dVar);
                i0Var.U();
                r5(pVar, i0Var, i0Var, null, 4);
                objW = i0Var.W();
            }
        }
        if (objW == f.z.i.a.COROUTINE_SUSPENDED) {
            f.c0.c.j.e(dVar, "frame");
        }
        return objW;
    }

    public static Uri g(Uri uri, String str) {
        if (!ContentProviderManager.getInstance().isPluginProvider(uri)) {
            return uri;
        }
        Uri uriH = h(str, uri, null);
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#buildProxyUri-->proxyUri=".concat(String.valueOf(uriH)));
        return uriH;
    }

    @NotNull
    public static final e.a.a.e.a.h<AlertDialog> g0(@NotNull Context context, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable f.c0.b.l<? super e.a.a.e.a.h<? extends DialogInterface>, f.v> lVar) {
        f.c0.c.j.e(context, "<this>");
        e.a.a.e.a.i iVar = new e.a.a.e.a.i(context);
        if (charSequence != null) {
            f.c0.c.j.e(charSequence, "title");
            iVar.f5600b.setTitle(charSequence);
        }
        if (charSequence2 != null) {
            iVar.h(charSequence2);
        }
        if (lVar != null) {
            lVar.invoke(iVar);
        }
        return iVar;
    }

    public static final long g1(@NotNull InputStream inputStream, @NotNull OutputStream outputStream, int i2) throws IOException {
        f.c0.c.j.e(inputStream, "$this$copyTo");
        f.c0.c.j.e(outputStream, "out");
        byte[] bArr = new byte[i2];
        int i3 = inputStream.read(bArr);
        long j2 = 0;
        while (i3 >= 0) {
            outputStream.write(bArr, 0, i3);
            j2 += (long) i3;
            i3 = inputStream.read(bArr);
        }
        return j2;
    }

    public static String g2(long j2) {
        return h2(j2, null);
    }

    public static <T> int g3(T[] tArr, int i2) {
        for (T t2 : tArr) {
            i2 = Y5(i2, t2);
        }
        return I1(i2, tArr.length);
    }

    public static void g4(@NotNull e.a.a.g.m.q.a aVar, @NotNull SeekBar seekBar) {
        f.c0.c.j.e(aVar, "this");
        f.c0.c.j.e(seekBar, "seekBar");
    }

    public static /* synthetic */ void g5(Context context, String str, String str2, int i2) {
        String string;
        if ((i2 & 2) != 0) {
            string = context.getString(R.string.share);
            f.c0.c.j.d(string, "fun Context.share(text: String, title: String = getString(R.string.share)) {\n    kotlin.runCatching {\n        val intent = Intent(Intent.ACTION_SEND)\n        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)\n        intent.putExtra(Intent.EXTRA_SUBJECT, title)\n        intent.putExtra(Intent.EXTRA_TEXT, text)\n        intent.type = \"text/plain\"\n        startActivity(Intent.createChooser(intent, title))\n    }\n}");
        } else {
            string = null;
        }
        f5(context, str, string);
    }

    public static final void g6(@NotNull DocumentFile documentFile, @NotNull Context context, @NotNull byte[] bArr) {
        f.c0.c.j.e(documentFile, "<this>");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(bArr, "data");
        Uri uri = documentFile.getUri();
        f.c0.c.j.d(uri, "this.uri");
        e.a.a.h.j.g(context, bArr, uri);
    }

    public static Uri h(String str, Uri uri, String str2) {
        ContentProviderManager contentProviderManager = ContentProviderManager.getInstance();
        if (uri != null) {
            str2 = uri.getAuthority();
        }
        String pluginProcessNameByAuthority = contentProviderManager.getPluginProcessNameByAuthority(str2);
        String string = null;
        if (str != null && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ContentProviderManager.PLUGIN_PROCESS_NAME, pluginProcessNameByAuthority);
                jSONObject.put(ContentProviderManager.PLUGIN_PKG_NAME, str);
                jSONObject.put("uri", uri != null ? uri.toString() : "");
            } catch (Throwable unused) {
            }
            string = jSONObject.toString();
        }
        String strEncodeToString = TextUtils.isEmpty(string) ? "" : Base64.encodeToString(string.getBytes(), 10);
        Uri uri2 = Uri.parse("content://" + ContentProviderManager.getInstance().getSystemProviderInfoMap().get(pluginProcessNameByAuthority).f1617b + File.separator + "proxy?provider_params=" + strEncodeToString);
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "进程[processName=" + pluginProcessNameByAuthority + "] build provider 【 uri:" + uri2 + " 】");
        return uri2;
    }

    @NotNull
    public static final e.a.a.e.a.h<AlertDialog> h0(@NotNull Context context, @Nullable Integer num, @Nullable Integer num2, @Nullable f.c0.b.l<? super e.a.a.e.a.h<? extends DialogInterface>, f.v> lVar) {
        f.c0.c.j.e(context, "<this>");
        e.a.a.e.a.i iVar = new e.a.a.e.a.i(context);
        if (num != null) {
            iVar.f5600b.setTitle(num.intValue());
        }
        if (num2 != null) {
            iVar.f5600b.setMessage(num2.intValue());
        }
        if (lVar != null) {
            lVar.invoke(iVar);
        }
        return iVar;
    }

    public static /* synthetic */ long h1(InputStream inputStream, OutputStream outputStream, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return g1(inputStream, outputStream, i2);
    }

    public static String h2(long j2, @androidx.annotation.Nullable SimpleDateFormat simpleDateFormat) {
        Calendar calendarH = c.e.a.b.l.u.h();
        Calendar calendarI = c.e.a.b.l.u.i();
        calendarI.setTimeInMillis(j2);
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j2)) : calendarH.get(1) == calendarI.get(1) ? B2(j2, Locale.getDefault()) : d3(j2, Locale.getDefault());
    }

    @Nullable
    public static final Boolean h3(@NotNull View view) {
        f.c0.c.j.e(view, "<this>");
        Object systemService = k.d.a.h.g().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager == null) {
            return null;
        }
        return Boolean.valueOf(inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0));
    }

    public static final void h4(@NotNull Context context, @NotNull Uri uri) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(uri, "uri");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            try {
                context.startActivity(intent);
                return;
            } catch (Exception e2) {
                String localizedMessage = e2.getLocalizedMessage();
                R5(context, localizedMessage != null ? localizedMessage : "open url error");
                return;
            }
        }
        try {
            context.startActivity(Intent.createChooser(intent, "请选择浏览器"));
        } catch (Exception e3) {
            String localizedMessage2 = e3.getLocalizedMessage();
            R5(context, localizedMessage2 != null ? localizedMessage2 : "open url error");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"SetWorldReadable"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h5(@org.jetbrains.annotations.NotNull android.content.Context r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.f.h5(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void h6(h.a.a.a.d dVar, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag("http://www.idpf.org/2007/opf", "metadata");
        xmlSerializer.setPrefix("dc", "http://purl.org/dc/elements/1.1/");
        xmlSerializer.setPrefix("", "http://www.idpf.org/2007/opf");
        List<h.a.a.a.i> identifiers = dVar.getMetadata().getIdentifiers();
        h.a.a.a.i bookIdIdentifier = h.a.a.a.i.getBookIdIdentifier(identifiers);
        if (bookIdIdentifier != null) {
            xmlSerializer.startTag("http://purl.org/dc/elements/1.1/", "identifier");
            xmlSerializer.attribute("", "id", "BookId");
            xmlSerializer.attribute("http://www.idpf.org/2007/opf", "scheme", bookIdIdentifier.getScheme());
            xmlSerializer.text(bookIdIdentifier.getValue());
            xmlSerializer.endTag("http://purl.org/dc/elements/1.1/", "identifier");
            for (h.a.a.a.i iVar : identifiers.subList(1, identifiers.size())) {
                if (iVar != bookIdIdentifier) {
                    xmlSerializer.startTag("http://purl.org/dc/elements/1.1/", "identifier");
                    xmlSerializer.attribute("http://www.idpf.org/2007/opf", "scheme", iVar.getScheme());
                    xmlSerializer.text(iVar.getValue());
                    xmlSerializer.endTag("http://purl.org/dc/elements/1.1/", "identifier");
                }
            }
        }
        i6("title", dVar.getMetadata().getTitles(), xmlSerializer);
        i6("subject", dVar.getMetadata().getSubjects(), xmlSerializer);
        i6("description", dVar.getMetadata().getDescriptions(), xmlSerializer);
        i6("publisher", dVar.getMetadata().getPublishers(), xmlSerializer);
        i6("type", dVar.getMetadata().getTypes(), xmlSerializer);
        i6("rights", dVar.getMetadata().getRights(), xmlSerializer);
        for (h.a.a.a.b bVar : dVar.getMetadata().getAuthors()) {
            xmlSerializer.startTag("http://purl.org/dc/elements/1.1/", "creator");
            xmlSerializer.attribute("http://www.idpf.org/2007/opf", "role", bVar.getRelator().getCode());
            xmlSerializer.attribute("http://www.idpf.org/2007/opf", "file-as", bVar.getLastname() + ", " + bVar.getFirstname());
            xmlSerializer.text(bVar.getFirstname() + " " + bVar.getLastname());
            xmlSerializer.endTag("http://purl.org/dc/elements/1.1/", "creator");
        }
        for (h.a.a.a.b bVar2 : dVar.getMetadata().getContributors()) {
            xmlSerializer.startTag("http://purl.org/dc/elements/1.1/", "contributor");
            xmlSerializer.attribute("http://www.idpf.org/2007/opf", "role", bVar2.getRelator().getCode());
            xmlSerializer.attribute("http://www.idpf.org/2007/opf", "file-as", bVar2.getLastname() + ", " + bVar2.getFirstname());
            xmlSerializer.text(bVar2.getFirstname() + " " + bVar2.getLastname());
            xmlSerializer.endTag("http://purl.org/dc/elements/1.1/", "contributor");
        }
        for (h.a.a.a.c cVar : dVar.getMetadata().getDates()) {
            xmlSerializer.startTag("http://purl.org/dc/elements/1.1/", "date");
            if (cVar.getEvent() != null) {
                xmlSerializer.attribute("http://www.idpf.org/2007/opf", NotificationCompat.CATEGORY_EVENT, cVar.getEvent().toString());
            }
            xmlSerializer.text(cVar.getValue());
            xmlSerializer.endTag("http://purl.org/dc/elements/1.1/", "date");
        }
        if (D3(dVar.getMetadata().getLanguage())) {
            xmlSerializer.startTag("http://purl.org/dc/elements/1.1/", ai.N);
            xmlSerializer.text(dVar.getMetadata().getLanguage());
            xmlSerializer.endTag("http://purl.org/dc/elements/1.1/", ai.N);
        }
        if (dVar.getMetadata().getOtherProperties() != null) {
            for (Map.Entry<QName, String> entry : dVar.getMetadata().getOtherProperties().entrySet()) {
                xmlSerializer.startTag(entry.getKey().getNamespaceURI(), TTDownloadField.TT_META);
                xmlSerializer.attribute("", "property", entry.getKey().getLocalPart());
                xmlSerializer.text(entry.getValue());
                xmlSerializer.endTag(entry.getKey().getNamespaceURI(), TTDownloadField.TT_META);
            }
        }
        if (dVar.getCoverImage() != null) {
            xmlSerializer.startTag("http://www.idpf.org/2007/opf", TTDownloadField.TT_META);
            xmlSerializer.attribute("", "name", "cover");
            xmlSerializer.attribute("", "content", dVar.getCoverImage().getId());
            xmlSerializer.endTag("http://www.idpf.org/2007/opf", TTDownloadField.TT_META);
        }
        xmlSerializer.startTag("http://www.idpf.org/2007/opf", TTDownloadField.TT_META);
        xmlSerializer.attribute("", "name", "generator");
        xmlSerializer.attribute("", "content", "Ag2S EpubLib");
        xmlSerializer.endTag("http://www.idpf.org/2007/opf", TTDownloadField.TT_META);
        xmlSerializer.endTag("http://www.idpf.org/2007/opf", "metadata");
    }

    public static Pair<ByteBuffer, Long> i(RandomAccessFile randomAccessFile, int i2) throws IOException {
        int i3;
        if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i2)));
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.min(i2, length - 22)) + 22);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jCapacity = length - ((long) byteBufferAllocate.capacity());
        randomAccessFile.seek(jCapacity);
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        G0(byteBufferAllocate);
        int iCapacity = byteBufferAllocate.capacity();
        if (iCapacity < 22) {
            i3 = -1;
        } else {
            int i4 = iCapacity - 22;
            int iMin = Math.min(i4, 65535);
            for (int i5 = 0; i5 <= iMin; i5++) {
                i3 = i4 - i5;
                if (byteBufferAllocate.getInt(i3) == 101010256 && (byteBufferAllocate.getShort(i3 + 20) & 65535) == i5) {
                    break;
                }
            }
            i3 = -1;
        }
        if (i3 == -1) {
            return null;
        }
        byteBufferAllocate.position(i3);
        ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(byteBufferSlice, Long.valueOf(jCapacity + ((long) i3)));
    }

    public static /* synthetic */ e.a.a.e.a.h i0(Context context, CharSequence charSequence, CharSequence charSequence2, f.c0.b.l lVar, int i2) {
        if ((i2 & 1) != 0) {
            charSequence = null;
        }
        int i3 = i2 & 2;
        if ((i2 & 4) != 0) {
            lVar = null;
        }
        return g0(context, charSequence, null, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator i1(@NonNull c.e.a.b.k.b bVar, float f2, float f3, float f4) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(bVar, (Property<c.e.a.b.k.b, V>) b.c.a, (TypeEvaluator) b.C0044b.a, (Object[]) new b.e[]{new b.e(f2, f3, f4)});
        b.e revealInfo = bVar.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) bVar, (int) f2, (int) f3, revealInfo.f1006c, f4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    @NotNull
    public static final SharedPreferences i2(@NotNull Context context) {
        f.c0.c.j.e(context, "<this>");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        f.c0.c.j.d(defaultSharedPreferences, "getDefaultSharedPreferences(this)");
        return defaultSharedPreferences;
    }

    @NotNull
    public static String i3(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        e.a.a.h.q qVar = e.a.a.h.q.a;
        return e.a.a.h.q.b(str);
    }

    public static final void i4(@NotNull Context context, @NotNull String str) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(str, "url");
        Uri uri = Uri.parse(str);
        f.c0.c.j.d(uri, "parse(url)");
        h4(context, uri);
    }

    public static final char i5(@NotNull char[] cArr) {
        f.c0.c.j.e(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static void i6(String str, List<String> list, XmlSerializer xmlSerializer) throws IOException {
        for (String str2 : list) {
            if (!q3(str2)) {
                xmlSerializer.startTag("http://purl.org/dc/elements/1.1/", str);
                xmlSerializer.text(str2);
                xmlSerializer.endTag("http://purl.org/dc/elements/1.1/", str);
            }
        }
    }

    public static c.c.a.j.b j(RandomAccessFile randomAccessFile, c.c.a.j.n nVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferV = v(nVar.a);
                int i2 = 0;
                while (byteBufferV.hasRemaining()) {
                    i2++;
                    try {
                        arrayList.add(Q(v(byteBufferV), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e2) {
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e2);
                    }
                }
                if (i2 <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                K(arrayMap, randomAccessFile, nVar);
                return new c.c.a.j.b((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]), arrayMap.containsKey(3) ? O((byte[]) arrayMap.get(3), randomAccessFile.length(), nVar) : null);
            } catch (IOException e3) {
                throw new SecurityException("Failed to read list of signers", e3);
            }
        } catch (CertificateException e4) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e4);
        }
    }

    public static /* synthetic */ e.a.a.e.a.h j0(Context context, Integer num, Integer num2, f.c0.b.l lVar, int i2) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        int i3 = i2 & 2;
        if ((i2 & 4) != 0) {
            lVar = null;
        }
        return h0(context, num, null, lVar);
    }

    @NonNull
    public static c.e.a.b.w.d j1(int i2) {
        return i2 != 0 ? i2 != 1 ? new c.e.a.b.w.k() : new c.e.a.b.w.e() : new c.e.a.b.w.k();
    }

    @NotNull
    public static final h0 j2(@NotNull f.z.f fVar) {
        int i2 = f.z.e.L;
        f.a aVar = fVar.get(e.a.a);
        if (!(aVar instanceof h0)) {
            aVar = null;
        }
        h0 h0Var = (h0) aVar;
        return h0Var != null ? h0Var : g.b.e0.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> f.z.d<T> j3(@NotNull f.z.d<? super T> dVar) {
        f.z.d<T> dVar2;
        f.c0.c.j.e(dVar, "$this$intercepted");
        f.z.j.a.c cVar = (f.z.j.a.c) (!(dVar instanceof f.z.j.a.c) ? null : dVar);
        return (cVar == null || (dVar2 = (f.z.d<T>) cVar.intercepted()) == null) ? dVar : dVar2;
    }

    public static PorterDuff.Mode j4(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    @JvmName(name = "snackbar2")
    @NotNull
    public static final Snackbar j5(@NotNull View view, @StringRes int i2) {
        f.c0.c.j.e(view, "<this>");
        int[] iArr = Snackbar.r;
        Snackbar snackbarL = Snackbar.l(view, view.getResources().getText(i2), -1);
        snackbarL.o();
        f.c0.c.j.d(snackbarL, "make(this, message, Snackbar.LENGTH_SHORT)\n    .apply { show() }");
        return snackbarL;
    }

    public static void j6(DocumentFile documentFile, Context context, String str, Charset charset, int i2) {
        Charset charset2 = (i2 & 4) != 0 ? f.h0.a.a : null;
        f.c0.c.j.e(documentFile, "<this>");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(str, "data");
        f.c0.c.j.e(charset2, "charset");
        Uri uri = documentFile.getUri();
        f.c0.c.j.d(uri, "this.uri");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(str, "data");
        f.c0.c.j.e(uri, "fileUri");
        f.c0.c.j.e(charset2, "charset");
        byte[] bytes = str.getBytes(charset2);
        f.c0.c.j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        e.a.a.h.j.g(context, bytes, uri);
    }

    public static c.c.a.j.b k(String str) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            c.c.a.j.b bVarJ = j(randomAccessFile, p(randomAccessFile, 1896449818));
            randomAccessFile.close();
            return bVarJ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void k0(@NotNull Appendable appendable, T t2, @Nullable f.c0.b.l<? super T, ? extends CharSequence> lVar) throws IOException {
        f.c0.c.j.e(appendable, "$this$appendElement");
        if (lVar != null) {
            appendable.append(lVar.invoke(t2));
            return;
        }
        if (t2 != 0 ? t2 instanceof CharSequence : true) {
            appendable.append((CharSequence) t2);
        } else if (t2 instanceof Character) {
            appendable.append(((Character) t2).charValue());
        } else {
            appendable.append(String.valueOf(t2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> f.z.d<f.v> k1(@NotNull f.c0.b.l<? super f.z.d<? super T>, ? extends Object> lVar, @NotNull f.z.d<? super T> dVar) {
        f.c0.c.j.e(lVar, "$this$createCoroutineUnintercepted");
        f.c0.c.j.e(dVar, "completion");
        f.c0.c.j.e(dVar, "completion");
        if (lVar instanceof f.z.j.a.a) {
            return ((f.z.j.a.a) lVar).create(dVar);
        }
        f.z.f context = dVar.getContext();
        return context == f.z.h.INSTANCE ? new r(dVar, dVar, lVar) : new s(dVar, context, dVar, context, lVar);
    }

    public static List<k.a.a.a.n0.d> k2(k.a.a.a.n0.d dVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        int childCount = dVar.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            arrayList.addAll(k2(dVar.getChild(i2)));
        }
        return arrayList;
    }

    @NonNull
    @CheckResult
    public static Rect k3(@NonNull Drawable drawable) {
        return new Rect(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    public static void k4(@NonNull AnimatorSet animatorSet, @NonNull List<Animator> list) {
        int size = list.size();
        long jMax = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = list.get(i2);
            jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        list.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(list);
    }

    @JvmName(name = "snackbar2")
    @NotNull
    public static final Snackbar k5(@NotNull View view, @NotNull CharSequence charSequence) {
        f.c0.c.j.e(view, "<this>");
        f.c0.c.j.e(charSequence, "message");
        Snackbar snackbarL = Snackbar.l(view, charSequence, -1);
        snackbarL.o();
        f.c0.c.j.d(snackbarL, "make(this, message, Snackbar.LENGTH_SHORT)\n    .apply { show() }");
        return snackbarL;
    }

    public static c.c.a.j.d l(RandomAccessFile randomAccessFile, c.c.a.j.n nVar) {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferV = v(nVar.a);
                int i2 = 0;
                c.c.a.j.d dVarO = null;
                while (byteBufferV.hasRemaining()) {
                    try {
                        dVarO = o(v(byteBufferV), arrayMap, certificateFactory);
                        i2++;
                    } catch (IOException | SecurityException | BufferUnderflowException e2) {
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e2);
                    }
                }
                if (i2 <= 0 || dVarO == null) {
                    throw new SecurityException("No signers found");
                }
                if (i2 != 1) {
                    throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                K(arrayMap, randomAccessFile, nVar);
                if (arrayMap.containsKey(3)) {
                    O((byte[]) arrayMap.get(3), randomAccessFile.length(), nVar);
                }
                return dVarO;
            } catch (IOException e3) {
                throw new SecurityException("Failed to read list of signers", e3);
            }
        } catch (CertificateException e4) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e4);
        }
    }

    public static void l0(@NonNull Appendable appendable, char c2) {
        try {
            appendable.append(c2);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <R, T> f.z.d<f.v> l1(@NotNull f.c0.b.p<? super R, ? super f.z.d<? super T>, ? extends Object> pVar, R r2, @NotNull f.z.d<? super T> dVar) {
        f.c0.c.j.e(pVar, "$this$createCoroutineUnintercepted");
        f.c0.c.j.e(dVar, "completion");
        f.c0.c.j.e(dVar, "completion");
        if (pVar instanceof f.z.j.a.a) {
            return ((f.z.j.a.a) pVar).create(r2, dVar);
        }
        f.z.f context = dVar.getContext();
        return context == f.z.h.INSTANCE ? new t(dVar, dVar, pVar, r2) : new u(dVar, context, dVar, context, pVar, r2);
    }

    public static int l2(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i2, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i2, i3);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i3);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static final void l3(@NotNull View view) {
        f.c0.c.j.e(view, "<this>");
        if (view.getVisibility() != 4) {
            view.setVisibility(4);
        }
    }

    @NotNull
    public static Connection.Response l4(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "urlStr");
        f.c0.c.j.e(str2, "body");
        f.c0.c.j.e(map, "headers");
        Connection connectionConnect = Jsoup.connect(str);
        e.a.a.d.v.k kVar = e.a.a.d.v.k.a;
        Connection.Response responseExecute = connectionConnect.sslSocketFactory(e.a.a.d.v.k.a()).ignoreContentType(true).followRedirects(false).requestBody(str2).headers(map).method(Connection.Method.POST).execute();
        f.c0.c.j.d(responseExecute, "connect(urlStr)\n            .sslSocketFactory(SSLHelper.unsafeSSLSocketFactory)\n            .ignoreContentType(true)\n            .followRedirects(false)\n            .requestBody(body)\n            .headers(headers)\n            .method(Connection.Method.POST)\n            .execute()");
        return responseExecute;
    }

    public static final <T extends Comparable<? super T>> void l5(@NotNull List<T> list) {
        f.c0.c.j.e(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static c.c.a.j.d m(String str) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            c.c.a.j.d dVarL = l(randomAccessFile, p(randomAccessFile, -262969152));
            randomAccessFile.close();
            return dVarL;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static void m0(@NonNull Appendable appendable, @NonNull CharSequence charSequence) {
        try {
            appendable.append(charSequence);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Object m1(@NotNull Throwable th) {
        f.c0.c.j.e(th, "exception");
        return new h.b(th);
    }

    public static final int m2(int i2) {
        return (int) TypedValue.applyDimension(1, i2, Resources.getSystem().getDisplayMetrics());
    }

    public static /* synthetic */ m0 m3(f1 f1Var, boolean z, boolean z2, f.c0.b.l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return f1Var.c(z, z2, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m4(@NotNull Request.Builder builder, @NotNull Map<String, String> map, boolean z) {
        f.c0.c.j.e(builder, "<this>");
        f.c0.c.j.e(map, "form");
        FormBody.Builder builder2 = new FormBody.Builder(null, 1, 0 == true ? 1 : 0);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z) {
                builder2.addEncoded(entry.getKey(), entry.getValue());
            } else {
                builder2.add(entry.getKey(), entry.getValue());
            }
        }
        builder.post(builder2.build());
    }

    public static final <T> void m5(@NotNull List<T> list, @NotNull java.util.Comparator<? super T> comparator) {
        f.c0.c.j.e(list, "$this$sortWith");
        f.c0.c.j.e(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    public static c.c.a.j.d n(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws IOException {
        int i2;
        int i3;
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        c.c.a.j.c cVar = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferV = v(byteBuffer);
            if (byteBufferV.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferV.remaining());
            }
            if (byteBufferV.getInt() == 1000370060) {
                if (cVar != null) {
                    throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                try {
                    try {
                        byteBufferV.getInt();
                        HashSet hashSet = new HashSet();
                        int i4 = 0;
                        c.c.a.j.q qVar = null;
                        int i5 = -1;
                        while (byteBufferV.hasRemaining()) {
                            try {
                                i4++;
                                ByteBuffer byteBufferV2 = v(byteBufferV);
                                ByteBuffer byteBufferV3 = v(byteBufferV2);
                                int i6 = byteBufferV2.getInt();
                                int i7 = byteBufferV2.getInt();
                                byte[] bArrW0 = w0(byteBufferV2);
                                if (qVar != null) {
                                    Pair<String, ? extends AlgorithmParameterSpec> pairN1 = n1(i5);
                                    PublicKey publicKey = qVar.getPublicKey();
                                    java.security.Signature signature = java.security.Signature.getInstance((String) pairN1.first);
                                    signature.initVerify(publicKey);
                                    Object obj = pairN1.second;
                                    if (obj != null) {
                                        signature.setParameter((AlgorithmParameterSpec) obj);
                                    }
                                    signature.update(byteBufferV3);
                                    if (!signature.verify(bArrW0)) {
                                        throw new SecurityException("Unable to verify signature of certificate #" + i4 + " using " + ((String) pairN1.first) + " when verifying Proof-of-rotation record");
                                    }
                                }
                                byteBufferV3.rewind();
                                byte[] bArrW02 = w0(byteBufferV3);
                                int i8 = byteBufferV3.getInt();
                                if (qVar != null && i5 != i8) {
                                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i4 + " when verifying Proof-of-rotation record");
                                }
                                qVar = new c.c.a.j.q((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrW02)), bArrW02);
                                if (hashSet.contains(qVar)) {
                                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i4 + ".  All signing certificates should be unique");
                                }
                                hashSet.add(qVar);
                                arrayList.add(qVar);
                                arrayList2.add(Integer.valueOf(i6));
                                i5 = i7;
                            } catch (InvalidAlgorithmParameterException e2) {
                                e = e2;
                                i3 = i4;
                                throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + " when verifying Proof-of-rotation record", e);
                            } catch (InvalidKeyException e3) {
                                e = e3;
                                i3 = i4;
                                throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + " when verifying Proof-of-rotation record", e);
                            } catch (NoSuchAlgorithmException e4) {
                                e = e4;
                                i3 = i4;
                                throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + " when verifying Proof-of-rotation record", e);
                            } catch (SignatureException e5) {
                                e = e5;
                                i3 = i4;
                                throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + " when verifying Proof-of-rotation record", e);
                            } catch (CertificateException e6) {
                                e = e6;
                                i2 = i4;
                                throw new SecurityException("Failed to decode certificate #" + i2 + " when verifying Proof-of-rotation record", e);
                            }
                        }
                        cVar = new c.c.a.j.c(arrayList, arrayList2);
                        try {
                            if (arrayList.size() > 0 && !Arrays.equals(((X509Certificate) arrayList.get(arrayList.size() - 1)).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                            }
                        } catch (CertificateEncodingException e7) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e7);
                        }
                    } catch (IOException | BufferUnderflowException e8) {
                        throw new IOException("Failed to parse Proof-of-rotation record", e8);
                    }
                } catch (InvalidAlgorithmParameterException e9) {
                    e = e9;
                    i3 = 0;
                    throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + " when verifying Proof-of-rotation record", e);
                } catch (InvalidKeyException e10) {
                    e = e10;
                    i3 = 0;
                    throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + " when verifying Proof-of-rotation record", e);
                } catch (NoSuchAlgorithmException e11) {
                    e = e11;
                    i3 = 0;
                    throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + " when verifying Proof-of-rotation record", e);
                } catch (SignatureException e12) {
                    e = e12;
                    i3 = 0;
                    throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + " when verifying Proof-of-rotation record", e);
                } catch (CertificateException e13) {
                    e = e13;
                    i2 = 0;
                }
            }
        }
        return new c.c.a.j.d(x509CertificateArr, cVar);
    }

    @ColorInt
    public static int n0(@ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        return (i2 & ViewCompat.MEASURED_SIZE_MASK) | (i3 << 24);
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> n1(int i2) {
        if (i2 != 513) {
            if (i2 == 514) {
                return Pair.create("SHA512withECDSA", null);
            }
            if (i2 != 769) {
                if (i2 != 1057) {
                    if (i2 != 1059) {
                        if (i2 != 1061) {
                            switch (i2) {
                                case 257:
                                    return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                case 258:
                                    return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                case 259:
                                    break;
                                case 260:
                                    return Pair.create("SHA512withRSA", null);
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
                            }
                        }
                    }
                }
                return Pair.create("SHA256withRSA", null);
            }
            return Pair.create("SHA256withDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    @androidx.annotation.Nullable
    public static Drawable n2(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        int resourceId;
        Drawable drawable;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (drawable = AppCompatResources.getDrawable(context, resourceId)) == null) ? typedArray.getDrawable(i2) : drawable;
    }

    @NotNull
    public static m0 n3(long j2, @NotNull Runnable runnable, @NotNull f.z.f fVar) {
        return g.b.e0.a.h(j2, runnable, fVar);
    }

    public static final void n4(@NotNull Request.Builder builder, @Nullable String str) {
        f.c0.c.j.e(builder, "<this>");
        if (str == null) {
            return;
        }
        builder.post(RequestBody.INSTANCE.create(str, MediaType.INSTANCE.get("application/json; charset=UTF-8")));
    }

    @NotNull
    public static final String[] n5(@NotNull String str, @NotNull String... strArr) {
        f.c0.c.j.e(str, "<this>");
        f.c0.c.j.e(strArr, "delimiter");
        List<String> listF = f.h0.k.F(str, (String[]) Arrays.copyOf(strArr, strArr.length), false, 0, 6);
        ArrayList arrayList = new ArrayList(S0(listF, 10));
        for (String str2 : listF) {
            Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
            arrayList.add(f.h0.k.R(str2).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!f.h0.k.s((String) obj)) {
                arrayList2.add(obj);
            }
        }
        Object[] array = arrayList2.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public static c.c.a.j.d o(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException {
        ByteBuffer byteBufferV = v(byteBuffer);
        int i2 = byteBuffer.getInt();
        int i3 = byteBuffer.getInt();
        ByteBuffer byteBufferV2 = v(byteBuffer);
        byte[] bArrW0 = w0(byteBuffer);
        ArrayList arrayList = new ArrayList();
        int i4 = -1;
        int i5 = 0;
        byte[] bArrW02 = null;
        while (true) {
            boolean z = true;
            int i6 = 8;
            if (!byteBufferV2.hasRemaining()) {
                if (i4 == -1) {
                    if (i5 == 0) {
                        throw new SecurityException("No signatures found");
                    }
                    throw new SecurityException("No supported signatures found");
                }
                String strE0 = E0(i4);
                Pair<String, ? extends AlgorithmParameterSpec> pairN1 = n1(i4);
                String str = (String) pairN1.first;
                AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairN1.second;
                try {
                    PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(strE0).generatePublic(new X509EncodedKeySpec(bArrW0));
                    java.security.Signature signature = java.security.Signature.getInstance(str);
                    signature.initVerify(publicKeyGeneratePublic);
                    if (algorithmParameterSpec != null) {
                        signature.setParameter(algorithmParameterSpec);
                    }
                    signature.update(byteBufferV);
                    if (!signature.verify(bArrW02)) {
                        throw new SecurityException(c.a.a.a.a.i(str, " signature did not verify"));
                    }
                    byteBufferV.clear();
                    ByteBuffer byteBufferV3 = v(byteBufferV);
                    ArrayList arrayList2 = new ArrayList();
                    byte[] bArrW03 = null;
                    int i7 = 0;
                    while (byteBufferV3.hasRemaining()) {
                        i7++;
                        try {
                            ByteBuffer byteBufferV4 = v(byteBufferV3);
                            if (byteBufferV4.remaining() < i6) {
                                throw new IOException("Record too short");
                            }
                            int i8 = byteBufferV4.getInt();
                            arrayList2.add(Integer.valueOf(i8));
                            if (i8 == i4) {
                                bArrW03 = w0(byteBufferV4);
                            }
                            i6 = 8;
                        } catch (IOException | BufferUnderflowException e2) {
                            throw new IOException("Failed to parse digest record #".concat(String.valueOf(i7)), e2);
                        }
                    }
                    if (!arrayList.equals(arrayList2)) {
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                    int iE = e(i4);
                    byte[] bArrPut = map.put(Integer.valueOf(iE), bArrW03);
                    if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrW03)) {
                        throw new SecurityException(u0(iE) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    ByteBuffer byteBufferV5 = v(byteBufferV);
                    ArrayList arrayList3 = new ArrayList();
                    int i9 = 0;
                    while (byteBufferV5.hasRemaining()) {
                        i9++;
                        byte[] bArrW04 = w0(byteBufferV5);
                        try {
                            arrayList3.add(new c.c.a.j.q((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrW04)), bArrW04));
                        } catch (CertificateException e3) {
                            throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i9)), e3);
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        throw new SecurityException("No certificates listed");
                    }
                    if (!Arrays.equals(bArrW0, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                        throw new SecurityException("Public key mismatch between certificate and signature record");
                    }
                    if (byteBufferV.getInt() != i2) {
                        throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
                    }
                    if (byteBufferV.getInt() == i3) {
                        return n(v(byteBufferV), arrayList3, certificateFactory);
                    }
                    throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
                    throw new SecurityException("Failed to verify " + str + " signature", e4);
                }
            }
            i5++;
            try {
                ByteBuffer byteBufferV6 = v(byteBufferV2);
                if (byteBufferV6.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i10 = byteBufferV6.getInt();
                arrayList.add(Integer.valueOf(i10));
                if (i10 != 513 && i10 != 514 && i10 != 769 && i10 != 1057 && i10 != 1059 && i10 != 1061) {
                    switch (i10) {
                        case 257:
                        case 258:
                        case 259:
                        case 260:
                            break;
                        default:
                            z = false;
                            break;
                    }
                }
                if (z && (i4 == -1 || f(i10, i4) > 0)) {
                    bArrW02 = w0(byteBufferV6);
                    i4 = i10;
                }
            } catch (IOException | BufferUnderflowException e5) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i5)), e5);
            }
        }
    }

    public static void o0(@NonNull Drawable drawable) {
        if (drawable.getBounds().isEmpty()) {
            drawable.setBounds(k3(drawable));
        }
    }

    public static boolean o1() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
            return i2 == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    @NotNull
    public static final File o2(@NotNull Context context) {
        f.c0.c.j.e(context, "<this>");
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        File cacheDir = context.getCacheDir();
        f.c0.c.j.d(cacheDir, "this.cacheDir");
        return cacheDir;
    }

    public static final boolean o3(@Nullable String str) {
        if (str == null) {
            return false;
        }
        return f.h0.k.H(str, "http://", true) || f.h0.k.H(str, "https://", true);
    }

    public static final void o4(@NotNull Context context, @NotNull String str, boolean z) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(str, "key");
        SharedPreferences.Editor editorEdit = i2(context).edit();
        f.c0.c.j.b(editorEdit, "editor");
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    public static String[] o5(String str, f.h0.g gVar, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        f.c0.c.j.e(str, "<this>");
        f.c0.c.j.e(gVar, "regex");
        List<String> listSplit = gVar.split(str, i2);
        ArrayList arrayList = new ArrayList(S0(listSplit, 10));
        for (String str2 : listSplit) {
            Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
            arrayList.add(f.h0.k.R(str2).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!f.h0.k.s((String) obj)) {
                arrayList2.add(obj);
            }
        }
        Object[] array = arrayList2.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static c.c.a.j.n p(java.io.RandomAccessFile r20, int r21) throws java.io.IOException, c.c.a.j.o {
        /*
            Method dump skipped, instruction units count: 723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.f.p(java.io.RandomAccessFile, int):c.c.a.j.n");
    }

    public static int p0(c.e.c.a0.e.b bVar, boolean z) {
        int i2 = z ? bVar.f1339c : bVar.f1338b;
        int i3 = z ? bVar.f1338b : bVar.f1339c;
        byte[][] bArr = bVar.a;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            byte b2 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                byte b3 = z ? bArr[i5][i7] : bArr[i7][i5];
                if (b3 == b2) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i4 += (i6 - 5) + 3;
                    }
                    b2 = b3;
                    i6 = 1;
                }
            }
            if (i6 >= 5) {
                i4 = (i6 - 5) + 3 + i4;
            }
        }
        return i4;
    }

    @Nullable
    public static final Object p1(long j2, @NotNull f.z.d<? super f.v> dVar) {
        if (j2 <= 0) {
            return f.v.a;
        }
        g.b.i iVar = new g.b.i(j3(dVar), 1);
        iVar.w();
        if (j2 < RecyclerView.FOREVER_NS) {
            j2(iVar.f6255f).a(j2, iVar);
        }
        Object objR = iVar.r();
        if (objR == f.z.i.a.COROUTINE_SUSPENDED) {
            f.c0.c.j.e(dVar, "frame");
        }
        return objR;
    }

    public static List<String> p2(Element element, String str, String str2) {
        NodeList elementsByTagNameNS = element.getElementsByTagNameNS(str, str2);
        ArrayList arrayList = new ArrayList(elementsByTagNameNS.getLength());
        for (int i2 = 0; i2 < elementsByTagNameNS.getLength(); i2++) {
            arrayList.add(Z2((Element) elementsByTagNameNS.item(i2)));
        }
        return arrayList;
    }

    public static final boolean p3(@NotNull a0 a0Var) {
        f1 f1Var = (f1) a0Var.getCoroutineContext().get(f1.N);
        if (f1Var != null) {
            return f1Var.isActive();
        }
        return true;
    }

    public static final void p4(@NotNull Context context, @NotNull String str, int i2) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(str, "key");
        SharedPreferences.Editor editorEdit = i2(context).edit();
        f.c0.c.j.b(editorEdit, "editor");
        editorEdit.putInt(str, i2);
        editorEdit.apply();
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final String p5(@NotNull Throwable th) {
        f.c0.c.j.e(th, "$this$stackTraceToString");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        f.c0.c.j.d(string, "sw.toString()");
        return string;
    }

    public static c.c.a.x.f q(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        long j3 = j2 >= 0 ? j2 : 0L;
        int iReverseBytes = Integer.reverseBytes(101010256);
        do {
            randomAccessFile.seek(length);
            if (randomAccessFile.readInt() == iReverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                c.c.a.x.f fVar = new c.c.a.x.f();
                fVar.f813b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                fVar.a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return fVar;
            }
            length--;
        } while (length >= j3);
        throw new ZipException("End Of Central Directory signature not found");
    }

    @NotNull
    public static final <T> f.g0.e<T> q0(@NotNull Iterator<? extends T> it) {
        f.c0.c.j.e(it, "$this$asSequence");
        v vVar = new v(it);
        f.c0.c.j.e(vVar, "$this$constrainOnce");
        return vVar instanceof f.g0.a ? vVar : new f.g0.a(vVar);
    }

    public static float q1(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot(f4 - f2, f5 - f3);
    }

    public static final float q2(@NotNull Context context) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        f.c0.c.j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        float dimension = context.getResources().getDimension(R.dimen.design_appbar_elevation);
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.elevation});
        f.c0.c.j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            dimension = typedArrayObtainStyledAttributes.getFloat(0, dimension);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        return sharedPreferences.getFloat(Key.ELEVATION, dimension);
    }

    public static boolean q3(String str) {
        if (w3(str)) {
            return true;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static final void q4(@NotNull Context context, @NotNull String str, long j2) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(str, "key");
        SharedPreferences.Editor editorEdit = i2(context).edit();
        f.c0.c.j.b(editorEdit, "editor");
        editorEdit.putLong(str, j2);
        editorEdit.apply();
    }

    public static final void q5(@NotNull f.z.d<? super f.v> dVar, @NotNull f.z.d<?> dVar2) {
        try {
            g.b.g2.g.b(j3(dVar), f.h.m11constructorimpl(f.v.a), null, 2);
        } catch (Throwable th) {
            ((g.b.a) dVar2).resumeWith(f.h.m11constructorimpl(m1(th)));
        }
    }

    public static String r() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static f0 r0(a0 a0Var, f.z.f fVar, b0 b0Var, f.c0.b.p pVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fVar = f.z.h.INSTANCE;
        }
        b0 b0Var2 = (i2 & 2) != 0 ? b0.DEFAULT : null;
        f.z.f fVarA = g.b.w.a(a0Var, fVar);
        g0 m1Var = b0Var2.isLazy() ? new m1(fVarA, pVar) : new g0(fVarA, true);
        m1Var.U();
        b0Var2.invoke(pVar, m1Var, m1Var);
        return m1Var;
    }

    public static float r1(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        return (float) Math.sqrt((f7 * f7) + (f6 * f6));
    }

    @NotNull
    public static final File r2(@NotNull Context context) {
        f.c0.c.j.e(context, "<this>");
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir;
        }
        File filesDir = context.getFilesDir();
        f.c0.c.j.d(filesDir, "this.filesDir");
        return filesDir;
    }

    public static final boolean r3(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final void r4(@NotNull Context context, @NotNull String str, @Nullable String str2) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(str, "key");
        SharedPreferences.Editor editorEdit = i2(context).edit();
        f.c0.c.j.b(editorEdit, "editor");
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public static void r5(f.c0.b.p pVar, Object obj, f.z.d dVar, f.c0.b.l lVar, int i2) {
        int i3 = i2 & 4;
        try {
            g.b.g2.g.a(j3(l1(pVar, obj, dVar)), f.h.m11constructorimpl(f.v.a), null);
        } catch (Throwable th) {
            dVar.resumeWith(f.h.m11constructorimpl(m1(th)));
        }
    }

    public static String s(c.c.a.i$b.a aVar, int i2) {
        int i3 = aVar.f749k[aVar.d(i2) + 3];
        int i4 = aVar.f749k[aVar.d(i2) + 4];
        if (i3 == 3) {
            return aVar.getAttributeValue(i2);
        }
        if (i3 != 2) {
            return (i3 < 16 || i3 > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(i4), Integer.valueOf(i3)) : String.valueOf(i4);
        }
        Object[] objArr = new Object[2];
        objArr[0] = (i4 >>> 24) == 1 ? "android:" : "";
        objArr[1] = Integer.valueOf(i4);
        return String.format("?%s%08X", objArr);
    }

    public static void s0(k.e.a.o oVar, k.e.a.r rVar) {
        switch (rVar.f8917j) {
            case 1:
                oVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                break;
            case 2:
                oVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                break;
            case 3:
                oVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                break;
            case 4:
                oVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                break;
            case 5:
                oVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                break;
            case 6:
                oVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                break;
            case 7:
                oVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                break;
            case 8:
                oVar.o(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                break;
        }
    }

    public static float s1(int i2, int i3, int i4, int i5) {
        int i6 = i2 - i4;
        int i7 = i3 - i5;
        return (float) Math.sqrt((i7 * i7) + (i6 * i6));
    }

    public static String s2(Document document, String str, String str2, String str3, String str4, String str5) {
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS(str, str2);
        for (int i2 = 0; i2 < elementsByTagNameNS.getLength(); i2++) {
            Element element = (Element) elementsByTagNameNS.item(i2);
            if (str4.equalsIgnoreCase(element.getAttribute(str3)) && D3(element.getAttribute(str5))) {
                return element.getAttribute(str5);
            }
        }
        return null;
    }

    public static final boolean s3(@NotNull Uri uri) {
        f.c0.c.j.e(uri, "<this>");
        return f.c0.c.j.a(uri.getScheme(), "content");
    }

    @Nullable
    public static QueryTTF s4(@NotNull JsExtensions jsExtensions, @Nullable String str) {
        f.c0.c.j.e(jsExtensions, "this");
        byte[] bArrBase64DecodeToByteArray = jsExtensions.base64DecodeToByteArray(str);
        if (bArrBase64DecodeToByteArray == null) {
            return null;
        }
        return new QueryTTF(bArrBase64DecodeToByteArray);
    }

    @Nullable
    public static final <T, R> Object s5(@NotNull g.b.g2.p<? super T> pVar, R r2, @NotNull f.c0.b.p<? super R, ? super f.z.d<? super T>, ? extends Object> pVar2) throws Throwable {
        Object sVar;
        Object objH;
        pVar.U();
        try {
        } catch (Throwable th) {
            sVar = new g.b.s(th, false, 2);
        }
        if (pVar2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        y.d(pVar2, 2);
        sVar = pVar2.invoke(r2, pVar);
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        if (sVar == aVar || (objH = pVar.H(sVar)) == l1.f6272b) {
            return aVar;
        }
        if (objH instanceof g.b.s) {
            throw ((g.b.s) objH).f6298b;
        }
        return l1.a(objH);
    }

    public static String t(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    @Nullable
    public static final Object t0(@NotNull Call call, @NotNull f.z.d<? super Response> dVar) {
        g.b.i iVar = new g.b.i(j3(dVar), 1);
        iVar.w();
        iVar.a(new j(call));
        call.enqueue(new k(iVar));
        Object objR = iVar.r();
        if (objR == f.z.i.a.COROUTINE_SUSPENDED) {
            f.c0.c.j.e(dVar, "frame");
        }
        return objR;
    }

    public static float t1(float f2, float f3, float f4, float f5, float f6, float f7) {
        float fQ1 = q1(f2, f3, f4, f5);
        float fQ12 = q1(f2, f3, f6, f5);
        float fQ13 = q1(f2, f3, f6, f7);
        float fQ14 = q1(f2, f3, f4, f7);
        return (fQ1 <= fQ12 || fQ1 <= fQ13 || fQ1 <= fQ14) ? (fQ12 <= fQ13 || fQ12 <= fQ14) ? fQ13 > fQ14 ? fQ13 : fQ14 : fQ12 : fQ1;
    }

    public static Element t2(Element element, String str, String str2) {
        NodeList elementsByTagNameNS = element.getElementsByTagNameNS(str, str2);
        if (elementsByTagNameNS.getLength() != 0) {
            return (Element) elementsByTagNameNS.item(0);
        }
        NodeList elementsByTagName = element.getElementsByTagName(str2);
        if (elementsByTagName.getLength() == 0) {
            return null;
        }
        return (Element) elementsByTagName.item(0);
    }

    public static final boolean t3(@Nullable String str) {
        return f.c0.c.j.a(str == null ? null : Boolean.valueOf(f.h0.k.K(str, "content://", false, 2)), Boolean.TRUE);
    }

    @Nullable
    public static QueryTTF t4(@NotNull JsExtensions jsExtensions, @Nullable String str) {
        byte[] bArrC;
        f.c0.c.j.e(jsExtensions, "this");
        if (str == null) {
            return null;
        }
        String strMd5Encode16 = jsExtensions.md5Encode16(str);
        e.a.a.d.i iVar = e.a.a.d.i.a;
        f.c0.c.j.e(strMd5Encode16, "key");
        f.g<Long, QueryTTF> gVar = e.a.a.d.i.f5537b.get(strMd5Encode16);
        QueryTTF second = (gVar != null && (gVar.getFirst().longValue() == 0 || gVar.getFirst().longValue() > System.currentTimeMillis())) ? gVar.getSecond() : null;
        if (second != null) {
            return second;
        }
        if (o3(str)) {
            bArrC = (byte[]) T4(null, new i(strMd5Encode16, str, null), 1, null);
        } else if (t3(str)) {
            Uri uri = Uri.parse(str);
            f.c0.c.j.d(uri, "parse(str)");
            bArrC = v4(uri, k.d.a.h.g());
        } else {
            bArrC = f.h0.k.K(str, "/storage", false, 2) ? f.b0.d.c(new File(str)) : jsExtensions.base64DecodeToByteArray(str);
        }
        if (bArrC == null) {
            return null;
        }
        QueryTTF queryTTF = new QueryTTF(bArrC);
        e.a.a.d.i.a(iVar, strMd5Encode16, queryTTF, 0, 4);
        return queryTTF;
    }

    public static String t5(String str, char c2) {
        if (w3(str)) {
            return str;
        }
        int iIndexOf = str.indexOf(c2);
        return iIndexOf < 0 ? "" : str.substring(iIndexOf + 1);
    }

    public static String u(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String u0(int i2) {
        if (i2 == 1) {
            return "SHA-256";
        }
        if (i2 == 2) {
            return "SHA-512";
        }
        if (i2 == 3) {
            return "SHA-256";
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i2)));
    }

    public static void u1(@NonNull View view, @NonNull c.e.a.b.q.m mVar) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new e(mVar, new c.e.a.b.q.n(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom())));
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new c.e.a.b.q.l());
        }
    }

    public static String u2(String str) {
        int length = str.length();
        char[] cArr = new char[length + 3];
        cArr[0] = 'g';
        cArr[1] = 'e';
        cArr[2] = 't';
        char cCharAt = str.charAt(0);
        if (cCharAt >= 'a' && cCharAt <= 'z') {
            cCharAt = (char) (cCharAt - ' ');
        }
        cArr[3] = cCharAt;
        for (int i2 = 1; i2 < length; i2++) {
            cArr[i2 + 3] = str.charAt(i2);
        }
        return new String(cArr);
    }

    public static final boolean u3(@NotNull Context context) {
        f.c0.c.j.e(context, "<this>");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        f.c0.c.j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        int color = Color.parseColor("#455A64");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorPrimary});
        f.c0.c.j.d(typedArrayObtainStyledAttributes, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes.getColor(0, color);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        int i2 = sharedPreferences.getInt("primary_color", color);
        return ((double) 1) - (((((double) Color.blue(i2)) * 0.114d) + ((((double) Color.green(i2)) * 0.587d) + (((double) Color.red(i2)) * 0.299d))) / ((double) 255)) < 0.4d;
    }

    @Nullable
    public static final Boolean u4(@NotNull ReadContext readContext, @NotNull String str) {
        f.c0.c.j.e(readContext, "<this>");
        f.c0.c.j.e(str, "path");
        return (Boolean) readContext.read(str, Boolean.TYPE, new Predicate[0]);
    }

    public static String u5(String str, char c2) {
        int iIndexOf;
        return (!w3(str) && (iIndexOf = str.indexOf(c2)) >= 0) ? str.substring(0, iIndexOf) : str;
    }

    public static ByteBuffer v(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i2 <= byteBuffer.remaining()) {
            return v0(byteBuffer, i2);
        }
        throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i2 + ", remaining: " + byteBuffer.remaining());
    }

    public static ByteBuffer v0(ByteBuffer byteBuffer, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i2)));
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i3 = i2 + iPosition;
        if (i3 < iPosition || i3 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i3);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i3);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    @NotNull
    public static String v1(@NotNull JsExtensions jsExtensions, @NotNull String str, @NotNull String str2) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "content");
        f.c0.c.j.e(str2, "url");
        String type = new AnalyzeUrl(str2, null, null, null, null, null, false, null, null, null, null, 2046, null).getType();
        if (type == null) {
            return "";
        }
        FileUtils fileUtils = FileUtils.a;
        String strO = fileUtils.o(fileUtils.e(fileUtils.k()), e.a.a.h.v.b(str2) + '.' + type);
        fileUtils.h(strO);
        File fileB = fileUtils.b(strO);
        e.a.a.h.b0 b0Var = e.a.a.h.b0.a;
        f.c0.c.j.e(str, "hexString");
        int length = f.h0.k.C(str, " ", "", false, 4).length();
        int i2 = length / 2;
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            bArr[i3 / 2] = (byte) (Character.digit(str.charAt(i3 + 1), 16) + (Character.digit(str.charAt(i3), 16) << 4));
        }
        if (!(i2 == 0)) {
            f.b0.d.e(fileB, bArr);
        }
        return strO;
    }

    @NotNull
    public static final String v2(@NotNull Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static boolean v3() {
        String str = Build.MANUFACTURER;
        Locale locale = Locale.ENGLISH;
        return str.toLowerCase(locale).equals("lge") || str.toLowerCase(locale).equals("samsung");
    }

    @Nullable
    public static final byte[] v4(@NotNull Uri uri, @NotNull Context context) {
        Boolean boolValueOf;
        f.c0.c.j.e(uri, "<this>");
        f.c0.c.j.e(context, com.umeng.analytics.pro.c.R);
        if (s3(uri)) {
            return e.a.a.h.j.e(context, uri);
        }
        String strB = e.a.a.h.a0.b(context, uri);
        if (strB == null) {
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(strB.length() > 0);
        }
        if (f.c0.c.j.a(boolValueOf, Boolean.TRUE)) {
            return f.b0.d.c(new File(strB));
        }
        return null;
    }

    public static String v5(String str, char c2) {
        int iLastIndexOf;
        return (!w3(str) && (iLastIndexOf = str.lastIndexOf(c2)) >= 0) ? str.substring(0, iLastIndexOf) : str;
    }

    public static void w() {
        c.c.a.l.c bVar;
        int i2 = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i2 >= 30 || (i2 == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
            bVar = new FlippedV2Impl();
        } else {
            if (i2 >= 28 || (i2 == 27 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                z = true;
            }
            bVar = z ? new c.c.a.l.b() : new c.c.a.l.a();
        }
        bVar.invokeHiddenApiRestrictions();
    }

    public static byte[] w0(ByteBuffer byteBuffer) throws IOException {
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new IOException("Negative length");
        }
        if (i2 <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i2];
            byteBuffer.get(bArr);
            return bArr;
        }
        throw new IOException("Underflow while reading length-prefixed value. Length: " + i2 + ", available: " + byteBuffer.remaining());
    }

    public static float w1(@NonNull Context context, @Dimension(unit = 0) int i2) {
        return TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    @NotNull
    public static final String w2(int i2) {
        String hexString = Integer.toHexString(i2);
        f.c0.c.j.d(hexString, "<get-hexString>");
        return hexString;
    }

    public static boolean w3(String str) {
        return str == null || str.length() == 0;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final byte[] w4(@NotNull InputStream inputStream) {
        f.c0.c.j.e(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        h1(inputStream, byteArrayOutputStream, 0, 2);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        f.c0.c.j.d(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    public static int w5(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        return i2;
    }

    public static void x(int i2, byte[] bArr) {
        bArr[1] = (byte) (i2 & 255);
        bArr[2] = (byte) ((i2 >>> 8) & 255);
        bArr[3] = (byte) ((i2 >>> 16) & 255);
        bArr[4] = (byte) ((i2 >>> 24) & 255);
    }

    @NotNull
    public static String x0(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        f.c0.c.j.e(str, "str");
        byte[] bArrDecode = Base64.decode(str, 2);
        f.c0.c.j.d(bArrDecode, "bytes");
        return new String(bArrDecode, f.h0.a.a);
    }

    public static int x1(Context context, float f2) {
        float fApplyDimension = TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
        int i2 = (int) (((double) fApplyDimension) + 0.5d);
        if (i2 != 0 || fApplyDimension <= 0.0f) {
            return i2;
        }
        return 1;
    }

    public static final int x2(@NotNull RadioGroup radioGroup, int i2) {
        f.c0.c.j.e(radioGroup, "<this>");
        int childCount = radioGroup.getChildCount();
        if (childCount > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i2 == ViewGroupKt.get(radioGroup, i3).getId()) {
                    return i3;
                }
                if (i4 >= childCount) {
                    break;
                }
                i3 = i4;
            }
        }
        return 0;
    }

    public static boolean x3(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    @NotNull
    public static byte[] x4(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "path");
        return f.b0.d.c(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006d A[PHI: r16
  0x006d: PHI (r16v2 long) = (r16v1 long), (r16v3 long) binds: [B:24:0x005f, B:28:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long x5(@org.jetbrains.annotations.NotNull java.lang.String r21, long r22, long r24, long r26) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.f.x5(java.lang.String, long, long, long):long");
    }

    public static void y(Activity activity, View view) {
        Object field;
        if (view == null) {
            return;
        }
        try {
            Object field2 = FieldUtils.readField(view, "mListenerInfo");
            if (field2 != null && (field = FieldUtils.readField(field2, "mOnClickListener")) != null) {
                String name = field.getClass().getName();
                if (name.startsWith(AppCompatViewInflater.class.getName()) || name.startsWith(View.class.getName())) {
                    view.setOnClickListener(new c.c.a.c.a(activity, view.getId(), (String) FieldUtils.readField(field, "mMethodName")));
                }
            }
        } catch (Exception e2) {
            ZeusLogger.e(ZeusLogger.TAG_ACTIVITY, "checkOnClickListener failed!".concat(String.valueOf(view)));
            e2.printStackTrace();
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i2 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            y(activity, viewGroup.getChildAt(i2));
            i2++;
        }
    }

    @NotNull
    public static String y0(@NotNull JsExtensions jsExtensions, @NotNull String str, int i2) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        f.c0.c.j.e(str, "str");
        byte[] bArrDecode = Base64.decode(str, i2);
        f.c0.c.j.d(bArrDecode, "bytes");
        return new String(bArrDecode, f.h0.a.a);
    }

    public static int y1(int i2) {
        if (i2 == 1) {
            return 32;
        }
        if (i2 == 2) {
            return 64;
        }
        if (i2 == 3) {
            return 32;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i2)));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @NotNull
    public static final <T> Class<T> y2(@NotNull f.f0.c<T> cVar) {
        f.c0.c.j.e(cVar, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((f.c0.c.c) cVar).a();
        if (!cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                }
                break;
            case 104431:
                if (name.equals("int")) {
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                }
                break;
        }
        return cls;
    }

    public static boolean y3(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    @Nullable
    public static final Integer y4(@NotNull ReadContext readContext, @NotNull String str) {
        f.c0.c.j.e(readContext, "<this>");
        f.c0.c.j.e(str, "path");
        return (Integer) readContext.read(str, Integer.TYPE, new Predicate[0]);
    }

    @Nullable
    public static final String y5(@NotNull String str) {
        int i2 = g.b.g2.r.a;
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static void z(LayoutInflater layoutInflater) {
        try {
            FieldUtils.writeField(layoutInflater, "mFactory", (Object) null);
        } catch (Throwable unused) {
            ZeusLogger.e(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
        try {
            FieldUtils.writeField(layoutInflater, "mFactory2", (Object) null);
        } catch (Throwable unused2) {
            ZeusLogger.e(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
    }

    @Nullable
    public static byte[] z0(@NotNull JsExtensions jsExtensions, @Nullable String str) {
        f.c0.c.j.e(jsExtensions, "this");
        if (str == null || f.h0.k.s(str)) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    @NotNull
    public static String z1(@NotNull JsExtensions jsExtensions, @NotNull String str) {
        f.c0.c.j.e(jsExtensions, "this");
        f.c0.c.j.e(str, "str");
        try {
            String strEncode = URLEncoder.encode(str, DataUtil.defaultCharset);
            f.c0.c.j.d(strEncode, "{\n            URLEncoder.encode(str, \"UTF-8\")\n        }");
            return strEncode;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final <T> int z2(@NotNull T[] tArr) {
        f.c0.c.j.e(tArr, "$this$lastIndex");
        return tArr.length - 1;
    }

    public static final boolean z3(@Nullable String str) {
        if (str == null) {
            return false;
        }
        String string = f.h0.k.R(str).toString();
        return (f.h0.k.K(string, "{", false, 2) && f.h0.k.h(string, "}", false, 2)) || (f.h0.k.K(string, "[", false, 2) && f.h0.k.h(string, "]", false, 2));
    }

    @Nullable
    public static final Long z4(@NotNull ReadContext readContext, @NotNull String str) {
        f.c0.c.j.e(readContext, "<this>");
        f.c0.c.j.e(str, "path");
        return (Long) readContext.read(str, Long.TYPE, new Predicate[0]);
    }

    public static int z5(String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return (int) x5(str, i2, i3, i4);
    }
}
