package io.legado.app.help;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import c.b.a.m.f;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import e.a.a.d.m;
import e.a.a.d.u.b;
import e.a.a.h.n;
import e.a.a.h.y;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.x.e;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.utils.FileUtils;
import io.wenyuange.app.release.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import k.d.a.h;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ReadBookConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bZ\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002©\u0001B\n\b\u0002¢\u0006\u0005\b¨\u0001\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004J\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0004J\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u00020\u000e8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010R\u0019\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR*\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010%R$\u0010+\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R$\u0010.\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u0016\u0010/\u001a\u00020\u001b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010\u001dR$\u00102\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R*\u00103\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0014\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\u0018R$\u00109\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0012\"\u0004\b7\u00108R)\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u00070:j\b\u0012\u0004\u0012\u00020\u0007`;8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R*\u0010@\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0014\u001a\u0004\bA\u0010\u0016\"\u0004\bB\u0010\u0018R\u0013\u0010D\u001a\u00020\u000e8F@\u0006¢\u0006\u0006\u001a\u0004\bC\u0010\u0010R$\u0010G\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u0016\"\u0004\bF\u0010\u0018R$\u0010M\u001a\u00020H2\u0006\u0010 \u001a\u00020H8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0013\u0010O\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\bN\u0010\u0016R$\u0010Q\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010Y\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010\u0010\"\u0004\bX\u0010%R$\u0010\\\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010\u0016\"\u0004\b[\u0010\u0018R$\u0010_\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010\u0016\"\u0004\b^\u0010\u0018R$\u0010b\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010\u0016\"\u0004\ba\u0010\u0018R\"\u0010c\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010\"\u001a\u0004\bd\u0010\u0010\"\u0004\be\u0010%R$\u0010h\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bf\u0010\u0016\"\u0004\bg\u0010\u0018R\u0013\u0010i\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\u0012R$\u0010l\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bj\u0010\u0016\"\u0004\bk\u0010\u0018R\u0019\u0010m\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bm\u0010\u001d\u001a\u0004\bn\u0010\u001fR$\u0010r\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010\u001f\"\u0004\bp\u0010qR$\u0010u\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bs\u0010\u0016\"\u0004\bt\u0010\u0018R$\u0010x\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bv\u0010\u0016\"\u0004\bw\u0010\u0018R\"\u0010y\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010\"\u001a\u0004\bz\u0010\u0010\"\u0004\b{\u0010%R$\u0010~\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b|\u0010\u0016\"\u0004\b}\u0010\u0018R&\u0010\u0081\u0001\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\r\u001a\u0004\b\u007f\u0010\u0016\"\u0005\b\u0080\u0001\u0010\u0018R'\u0010\u0084\u0001\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0082\u0001\u0010\u0016\"\u0005\b\u0083\u0001\u0010\u0018R'\u0010\u0085\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086.¢\u0006\u0016\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0005\b\u0087\u0001\u0010\u0012\"\u0005\b\u0088\u0001\u00108R\u0018\u0010\u0089\u0001\u001a\u00020\u001b8\u0006@\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010\u001dR'\u0010\u008c\u0001\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008a\u0001\u0010\u0016\"\u0005\b\u008b\u0001\u0010\u0018R'\u0010\u008f\u0001\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008d\u0001\u0010\u0010\"\u0005\b\u008e\u0001\u0010%R'\u0010\u0092\u0001\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0090\u0001\u0010\u001f\"\u0005\b\u0091\u0001\u0010qR'\u0010\u0095\u0001\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0093\u0001\u0010\u0016\"\u0005\b\u0094\u0001\u0010\u0018R'\u0010\u0098\u0001\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0096\u0001\u0010\u0016\"\u0005\b\u0097\u0001\u0010\u0018R&\u0010\u0099\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010\"\u001a\u0005\b\u009a\u0001\u0010\u0010\"\u0005\b\u009b\u0001\u0010%R'\u0010\u009e\u0001\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009c\u0001\u0010\u0016\"\u0005\b\u009d\u0001\u0010\u0018R'\u0010¡\u0001\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009f\u0001\u0010\u0016\"\u0005\b \u0001\u0010\u0018R'\u0010¤\u0001\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¢\u0001\u0010\u0016\"\u0005\b£\u0001\u0010\u0018R'\u0010§\u0001\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¥\u0001\u0010\u0016\"\u0005\b¦\u0001\u0010\u0018¨\u0006ª\u0001"}, d2 = {"Lio/legado/app/help/ReadBookConfig;", "", "Lf/v;", "resetAll", "()V", "", "index", "Lio/legado/app/help/ReadBookConfig$Config;", "getConfig", "(I)Lio/legado/app/help/ReadBookConfig$Config;", "initConfigs", "initShareConfig", "upBg", "save", "", "deleteDur", "()Z", "getExportConfig", "()Lio/legado/app/help/ReadBookConfig$Config;", "bgMeanColor", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getBgMeanColor", "()I", "setBgMeanColor", "(I)V", "getTextFullJustify", "textFullJustify", "", "configFilePath", "Ljava/lang/String;", "getConfigFilePath", "()Ljava/lang/String;", ES6Iterator.VALUE_PROPERTY, "shareLayout", "Z", "getShareLayout", "setShareLayout", "(Z)V", "useZhLayout", "getUseZhLayout", "setUseZhLayout", "getFooterPaddingTop", "setFooterPaddingTop", "footerPaddingTop", "getFooterPaddingLeft", "setFooterPaddingLeft", "footerPaddingLeft", "configFileName", "getParagraphSpacing", "setParagraphSpacing", "paragraphSpacing", "autoReadSpeed", "getAutoReadSpeed", "setAutoReadSpeed", "getDurConfig", "setDurConfig", "(Lio/legado/app/help/ReadBookConfig$Config;)V", "durConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "configList", "Ljava/util/ArrayList;", "getConfigList", "()Ljava/util/ArrayList;", "styleSelect", "getStyleSelect", "setStyleSelect", "getTextBottomJustify", "textBottomJustify", "getTitleSize", "setTitleSize", "titleSize", "", "getLetterSpacing", "()F", "setLetterSpacing", "(F)V", "letterSpacing", "getTextColor", "textColor", "Landroid/graphics/drawable/Drawable;", "bg", "Landroid/graphics/drawable/Drawable;", "getBg", "()Landroid/graphics/drawable/Drawable;", "setBg", "(Landroid/graphics/drawable/Drawable;)V", "getShowHeaderLine", "setShowHeaderLine", "showHeaderLine", "getPageAnim", "setPageAnim", "pageAnim", "getTitleTopSpacing", "setTitleTopSpacing", "titleTopSpacing", "getHeaderPaddingTop", "setHeaderPaddingTop", "headerPaddingTop", "hideNavigationBar", "getHideNavigationBar", "setHideNavigationBar", "getFooterPaddingRight", "setFooterPaddingRight", "footerPaddingRight", "config", "getLineSpacingExtra", "setLineSpacingExtra", "lineSpacingExtra", "shareConfigFilePath", "getShareConfigFilePath", "getTextFont", "setTextFont", "(Ljava/lang/String;)V", "textFont", "getTextSize", "setTextSize", "textSize", "getPaddingLeft", "setPaddingLeft", "paddingLeft", "readBodyToLh", "getReadBodyToLh", "setReadBodyToLh", "getFooterPaddingBottom", "setFooterPaddingBottom", "footerPaddingBottom", "getTitleMode", "setTitleMode", "titleMode", "getHeaderPaddingBottom", "setHeaderPaddingBottom", "headerPaddingBottom", "shareConfig", "Lio/legado/app/help/ReadBookConfig$Config;", "getShareConfig", "setShareConfig", "shareConfigFileName", "getTitleBottomSpacing", "setTitleBottomSpacing", "titleBottomSpacing", "getShowFooterLine", "setShowFooterLine", "showFooterLine", "getParagraphIndent", "setParagraphIndent", "paragraphIndent", "getTextBold", "setTextBold", "textBold", "getPaddingRight", "setPaddingRight", "paddingRight", "hideStatusBar", "getHideStatusBar", "setHideStatusBar", "getPaddingBottom", "setPaddingBottom", "paddingBottom", "getPaddingTop", "setPaddingTop", "paddingTop", "getHeaderPaddingLeft", "setHeaderPaddingLeft", "headerPaddingLeft", "getHeaderPaddingRight", "setHeaderPaddingRight", "headerPaddingRight", "<init>", "Config", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReadBookConfig {

    @NotNull
    public static final ReadBookConfig INSTANCE;
    private static int autoReadSpeed = 0;

    @Nullable
    private static Drawable bg = null;
    private static int bgMeanColor = 0;

    @NotNull
    public static final String configFileName = "readConfig.json";

    @NotNull
    private static final String configFilePath;

    @NotNull
    private static final ArrayList<Config> configList;
    private static boolean hideNavigationBar = false;
    private static boolean hideStatusBar = false;
    private static boolean readBodyToLh = false;
    public static Config shareConfig = null;

    @NotNull
    public static final String shareConfigFileName = "shareReadConfig.json";

    @NotNull
    private static final String shareConfigFilePath;
    private static boolean shareLayout;
    private static int styleSelect;
    private static boolean useZhLayout;

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<Config> {
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class b extends TypeToken<Config> {
    }

    /* JADX INFO: compiled from: ReadBookConfig.kt */
    @DebugMetadata(c = "io.legado.app.help.ReadBookConfig$save$1", f = "ReadBookConfig.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements p<a0, d<? super v>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public c(d<? super c> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            c cVar = new c(dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((c) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            v vVar;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            synchronized (((a0) this.L$0)) {
                Gson gsonA = n.a();
                ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
                String json = gsonA.toJson(readBookConfig.getConfigList());
                FileUtils fileUtils = FileUtils.a;
                fileUtils.h(readBookConfig.getConfigFilePath());
                File fileB = fileUtils.b(readBookConfig.getConfigFilePath());
                j.d(json, "it");
                f.b0.d.f(fileB, json, null, 2);
                String json2 = n.a().toJson(readBookConfig.getShareConfig());
                fileUtils.h(readBookConfig.getShareConfigFilePath());
                File fileB2 = fileUtils.b(readBookConfig.getShareConfigFilePath());
                j.d(json2, "it");
                f.b0.d.f(fileB2, json2, null, 2);
                vVar = v.a;
            }
            return vVar;
        }
    }

    static {
        ReadBookConfig readBookConfig = new ReadBookConfig();
        INSTANCE = readBookConfig;
        FileUtils fileUtils = FileUtils.a;
        File filesDir = h.g().getFilesDir();
        j.d(filesDir, "appCtx.filesDir");
        configFilePath = fileUtils.o(filesDir, configFileName);
        File filesDir2 = h.g().getFilesDir();
        j.d(filesDir2, "appCtx.filesDir");
        shareConfigFilePath = fileUtils.o(filesDir2, shareConfigFileName);
        configList = new ArrayList<>();
        readBookConfig.initConfigs();
        readBookConfig.initShareConfig();
        readBodyToLh = f.J2(h.g(), "readBodyToLh", true);
        autoReadSpeed = f.L2(h.g(), "autoReadSpeed", 46);
        styleSelect = f.M2(h.g(), "readStyleSelect", 0, 2);
        shareLayout = f.K2(h.g(), "shareLayout", false, 2);
        hideStatusBar = f.K2(h.g(), "hideStatusBar", false, 2);
        hideNavigationBar = f.K2(h.g(), "hideNavigationBar", false, 2);
        useZhLayout = f.K2(h.g(), "useZhLayout", false, 2);
    }

    private ReadBookConfig() {
    }

    private final void resetAll() {
        m mVar = m.a;
        List<Config> listA = m.a();
        ReadBookConfig readBookConfig = INSTANCE;
        readBookConfig.getConfigList().clear();
        readBookConfig.getConfigList().addAll(listA);
        readBookConfig.save();
    }

    public final boolean deleteDur() {
        ArrayList<Config> arrayList = configList;
        if (arrayList.size() <= 5) {
            return false;
        }
        arrayList.remove(styleSelect);
        int i2 = styleSelect;
        if (i2 > 0) {
            setStyleSelect(i2 - 1);
        }
        upBg();
        return true;
    }

    public final int getAutoReadSpeed() {
        return autoReadSpeed;
    }

    @Nullable
    public final Drawable getBg() {
        return bg;
    }

    public final int getBgMeanColor() {
        return bgMeanColor;
    }

    @NotNull
    public final synchronized Config getConfig(int index) {
        Config config;
        ArrayList<Config> arrayList = configList;
        if (arrayList.size() < 5) {
            resetAll();
        }
        config = (Config) e.n(arrayList, index);
        if (config == null) {
            Config config2 = arrayList.get(0);
            j.d(config2, "configList[0]");
            config = config2;
        }
        return config;
    }

    @NotNull
    public final String getConfigFilePath() {
        return configFilePath;
    }

    @NotNull
    public final ArrayList<Config> getConfigList() {
        return configList;
    }

    @NotNull
    public final Config getDurConfig() {
        return getConfig(styleSelect);
    }

    @NotNull
    public final Config getExportConfig() {
        Object objM11constructorimpl;
        Gson gsonA = n.a();
        String json = n.a().toJson(getDurConfig());
        try {
            Type type = new a().getType();
            j.d(type, "object : TypeToken<T>() {}.type");
            Object objFromJson = gsonA.fromJson(json, type);
            if (!(objFromJson instanceof Config)) {
                objFromJson = null;
            }
            objM11constructorimpl = f.h.m11constructorimpl((Config) objFromJson);
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(f.m1(th));
        }
        Config config = (Config) (f.h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
        j.c(config);
        if (shareLayout) {
            config.setTextFont(getShareConfig().getTextFont());
            config.setTextBold(getShareConfig().getTextBold());
            config.setTextSize(getShareConfig().getTextSize());
            config.setLetterSpacing(getShareConfig().getLetterSpacing());
            config.setLineSpacingExtra(getShareConfig().getLineSpacingExtra());
            config.setParagraphSpacing(getShareConfig().getParagraphSpacing());
            config.setTitleMode(getShareConfig().getTitleMode());
            config.setTitleSize(getShareConfig().getTitleSize());
            config.setTitleTopSpacing(getShareConfig().getTitleTopSpacing());
            config.setTitleBottomSpacing(getShareConfig().getTitleBottomSpacing());
            config.setPaddingBottom(getShareConfig().getPaddingBottom());
            config.setPaddingLeft(getShareConfig().getPaddingLeft());
            config.setPaddingRight(getShareConfig().getPaddingRight());
            config.setPaddingTop(getShareConfig().getPaddingTop());
            config.setHeaderPaddingBottom(getShareConfig().getHeaderPaddingBottom());
            config.setHeaderPaddingLeft(getShareConfig().getHeaderPaddingLeft());
            config.setHeaderPaddingRight(getShareConfig().getHeaderPaddingRight());
            config.setHeaderPaddingTop(getShareConfig().getHeaderPaddingTop());
            config.setFooterPaddingBottom(getShareConfig().getFooterPaddingBottom());
            config.setFooterPaddingLeft(getShareConfig().getFooterPaddingLeft());
            config.setFooterPaddingRight(getShareConfig().getFooterPaddingRight());
            config.setFooterPaddingTop(getShareConfig().getFooterPaddingTop());
            config.setShowHeaderLine(getShareConfig().getShowHeaderLine());
            config.setShowFooterLine(getShareConfig().getShowFooterLine());
            config.setTipHeaderLeft(getShareConfig().getTipHeaderLeft());
            config.setTipHeaderMiddle(getShareConfig().getTipHeaderMiddle());
            config.setTipHeaderRight(getShareConfig().getTipHeaderRight());
            config.setTipFooterLeft(getShareConfig().getTipFooterLeft());
            config.setTipFooterMiddle(getShareConfig().getTipFooterMiddle());
            config.setTipFooterRight(getShareConfig().getTipFooterRight());
            config.setTipColor(getShareConfig().getTipColor());
            config.setHeaderMode(getShareConfig().getHeaderMode());
            config.setFooterMode(getShareConfig().getFooterMode());
        }
        return config;
    }

    public final int getFooterPaddingBottom() {
        return getConfig().getFooterPaddingBottom();
    }

    public final int getFooterPaddingLeft() {
        return getConfig().getFooterPaddingLeft();
    }

    public final int getFooterPaddingRight() {
        return getConfig().getFooterPaddingRight();
    }

    public final int getFooterPaddingTop() {
        return getConfig().getFooterPaddingTop();
    }

    public final int getHeaderPaddingBottom() {
        return getConfig().getHeaderPaddingBottom();
    }

    public final int getHeaderPaddingLeft() {
        return getConfig().getHeaderPaddingLeft();
    }

    public final int getHeaderPaddingRight() {
        return getConfig().getHeaderPaddingRight();
    }

    public final int getHeaderPaddingTop() {
        return getConfig().getHeaderPaddingTop();
    }

    public final boolean getHideNavigationBar() {
        return hideNavigationBar;
    }

    public final boolean getHideStatusBar() {
        return hideStatusBar;
    }

    public final float getLetterSpacing() {
        return getConfig().getLetterSpacing();
    }

    public final int getLineSpacingExtra() {
        return getConfig().getLineSpacingExtra();
    }

    public final int getPaddingBottom() {
        return getConfig().getPaddingBottom();
    }

    public final int getPaddingLeft() {
        return getConfig().getPaddingLeft();
    }

    public final int getPaddingRight() {
        return getConfig().getPaddingRight();
    }

    public final int getPaddingTop() {
        return getConfig().getPaddingTop();
    }

    public final int getPageAnim() {
        return getConfig().curPageAnim();
    }

    @NotNull
    public final String getParagraphIndent() {
        return getConfig().getParagraphIndent();
    }

    public final int getParagraphSpacing() {
        return getConfig().getParagraphSpacing();
    }

    public final boolean getReadBodyToLh() {
        return readBodyToLh;
    }

    @NotNull
    public final Config getShareConfig() {
        Config config = shareConfig;
        if (config != null) {
            return config;
        }
        j.m("shareConfig");
        throw null;
    }

    @NotNull
    public final String getShareConfigFilePath() {
        return shareConfigFilePath;
    }

    public final boolean getShareLayout() {
        return shareLayout;
    }

    public final boolean getShowFooterLine() {
        return getConfig().getShowFooterLine();
    }

    public final boolean getShowHeaderLine() {
        return getConfig().getShowHeaderLine();
    }

    public final int getStyleSelect() {
        return styleSelect;
    }

    public final int getTextBold() {
        return getConfig().getTextBold();
    }

    public final boolean getTextBottomJustify() {
        return f.J2(h.g(), "textBottomJustify", true);
    }

    public final int getTextColor() {
        return getDurConfig().curTextColor();
    }

    @NotNull
    public final String getTextFont() {
        return getConfig().getTextFont();
    }

    public final boolean getTextFullJustify() {
        return f.J2(h.g(), "textFullJustify", true);
    }

    public final int getTextSize() {
        return getConfig().getTextSize();
    }

    public final int getTitleBottomSpacing() {
        return getConfig().getTitleBottomSpacing();
    }

    public final int getTitleMode() {
        return getConfig().getTitleMode();
    }

    public final int getTitleSize() {
        return getConfig().getTitleSize();
    }

    public final int getTitleTopSpacing() {
        return getConfig().getTitleTopSpacing();
    }

    public final boolean getUseZhLayout() {
        return useZhLayout;
    }

    public final void initConfigs() {
        Object objM11constructorimpl;
        File file = new File(configFilePath);
        List<Config> listA = null;
        if (file.exists()) {
            try {
                try {
                    Object objFromJson = n.a().fromJson(f.b0.d.d(file, null, 1), new y(Config.class));
                    objM11constructorimpl = f.h.m11constructorimpl(objFromJson instanceof List ? (List) objFromJson : null);
                } catch (Throwable th) {
                    objM11constructorimpl = f.h.m11constructorimpl(f.m1(th));
                }
                if (f.h.m16isFailureimpl(objM11constructorimpl)) {
                    objM11constructorimpl = null;
                }
                listA = (List) objM11constructorimpl;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (listA == null) {
            m mVar = m.a;
            listA = m.a();
        }
        ReadBookConfig readBookConfig = INSTANCE;
        readBookConfig.getConfigList().clear();
        readBookConfig.getConfigList().addAll(listA);
    }

    public final void initShareConfig() {
        Object objM11constructorimpl;
        File file = new File(shareConfigFilePath);
        Config config = null;
        if (file.exists()) {
            try {
                String strD = f.b0.d.d(file, null, 1);
                Gson gsonA = n.a();
                try {
                    Type type = new b().getType();
                    j.d(type, "object : TypeToken<T>() {}.type");
                    Object objFromJson = gsonA.fromJson(strD, type);
                    if (!(objFromJson instanceof Config)) {
                        objFromJson = null;
                    }
                    objM11constructorimpl = f.h.m11constructorimpl((Config) objFromJson);
                } catch (Throwable th) {
                    objM11constructorimpl = f.h.m11constructorimpl(f.m1(th));
                }
                if (f.h.m16isFailureimpl(objM11constructorimpl)) {
                    objM11constructorimpl = null;
                }
                config = (Config) objM11constructorimpl;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (config == null && (config = (Config) e.n(configList, 5)) == null) {
            config = new Config(null, null, null, null, 0, 0, 0, false, false, false, null, null, null, 0, 0, null, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 131071, null);
        }
        setShareConfig(config);
    }

    public final void save() {
        b.C0148b.b(e.a.a.d.u.b.a, null, null, new c(null), 3);
    }

    public final void setAutoReadSpeed(int i2) {
        autoReadSpeed = i2;
        f.p4(h.g(), "autoReadSpeed", i2);
    }

    public final void setBg(@Nullable Drawable drawable) {
        bg = drawable;
    }

    public final void setBgMeanColor(int i2) {
        bgMeanColor = i2;
    }

    public final void setDurConfig(@NotNull Config config) {
        j.e(config, ES6Iterator.VALUE_PROPERTY);
        configList.set(styleSelect, config);
        if (shareLayout) {
            setShareConfig(config);
        }
        upBg();
    }

    public final void setFooterPaddingBottom(int i2) {
        getConfig().setFooterPaddingBottom(i2);
    }

    public final void setFooterPaddingLeft(int i2) {
        getConfig().setFooterPaddingLeft(i2);
    }

    public final void setFooterPaddingRight(int i2) {
        getConfig().setFooterPaddingRight(i2);
    }

    public final void setFooterPaddingTop(int i2) {
        getConfig().setFooterPaddingTop(i2);
    }

    public final void setHeaderPaddingBottom(int i2) {
        getConfig().setHeaderPaddingBottom(i2);
    }

    public final void setHeaderPaddingLeft(int i2) {
        getConfig().setHeaderPaddingLeft(i2);
    }

    public final void setHeaderPaddingRight(int i2) {
        getConfig().setHeaderPaddingRight(i2);
    }

    public final void setHeaderPaddingTop(int i2) {
        getConfig().setHeaderPaddingTop(i2);
    }

    public final void setHideNavigationBar(boolean z) {
        hideNavigationBar = z;
    }

    public final void setHideStatusBar(boolean z) {
        hideStatusBar = z;
    }

    public final void setLetterSpacing(float f2) {
        getConfig().setLetterSpacing(f2);
    }

    public final void setLineSpacingExtra(int i2) {
        getConfig().setLineSpacingExtra(i2);
    }

    public final void setPaddingBottom(int i2) {
        getConfig().setPaddingBottom(i2);
    }

    public final void setPaddingLeft(int i2) {
        getConfig().setPaddingLeft(i2);
    }

    public final void setPaddingRight(int i2) {
        getConfig().setPaddingRight(i2);
    }

    public final void setPaddingTop(int i2) {
        getConfig().setPaddingTop(i2);
    }

    public final void setPageAnim(int i2) {
        getConfig().setCurPageAnim(i2);
    }

    public final void setParagraphIndent(@NotNull String str) {
        j.e(str, ES6Iterator.VALUE_PROPERTY);
        getConfig().setParagraphIndent(str);
    }

    public final void setParagraphSpacing(int i2) {
        getConfig().setParagraphSpacing(i2);
    }

    public final void setReadBodyToLh(boolean z) {
        readBodyToLh = z;
    }

    public final void setShareConfig(@NotNull Config config) {
        j.e(config, "<set-?>");
        shareConfig = config;
    }

    public final void setShareLayout(boolean z) {
        shareLayout = z;
        if (f.K2(h.g(), "shareLayout", false, 2) != z) {
            f.o4(h.g(), "shareLayout", z);
        }
    }

    public final void setShowFooterLine(boolean z) {
        getConfig().setShowFooterLine(z);
    }

    public final void setShowHeaderLine(boolean z) {
        getConfig().setShowHeaderLine(z);
    }

    public final void setStyleSelect(int i2) {
        styleSelect = i2;
        if (f.M2(h.g(), "readStyleSelect", 0, 2) != i2) {
            f.p4(h.g(), "readStyleSelect", i2);
        }
    }

    public final void setTextBold(int i2) {
        getConfig().setTextBold(i2);
    }

    public final void setTextFont(@NotNull String str) {
        j.e(str, ES6Iterator.VALUE_PROPERTY);
        getConfig().setTextFont(str);
    }

    public final void setTextSize(int i2) {
        getConfig().setTextSize(i2);
    }

    public final void setTitleBottomSpacing(int i2) {
        getConfig().setTitleBottomSpacing(i2);
    }

    public final void setTitleMode(int i2) {
        getConfig().setTitleMode(i2);
    }

    public final void setTitleSize(int i2) {
        getConfig().setTitleSize(i2);
    }

    public final void setTitleTopSpacing(int i2) {
        getConfig().setTitleTopSpacing(i2);
    }

    public final void setUseZhLayout(boolean z) {
        useZhLayout = z;
    }

    public final void upBg() {
        DisplayMetrics displayMetrics = h.g().getResources().getDisplayMetrics();
        Drawable drawableCurBgDrawable = getDurConfig().curBgDrawable(displayMetrics.widthPixels, displayMetrics.heightPixels);
        if (drawableCurBgDrawable instanceof BitmapDrawable) {
            ReadBookConfig readBookConfig = INSTANCE;
            Bitmap bitmap = ((BitmapDrawable) drawableCurBgDrawable).getBitmap();
            j.d(bitmap, "bitmap");
            j.e(bitmap, "bitmap");
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i2 = 0;
            int iRed = 0;
            int iBlue = 0;
            int iGreen = 0;
            while (true) {
                int i3 = i2 + 1;
                int i4 = 70;
                while (true) {
                    int i5 = i4 + 1;
                    int pixel = bitmap.getPixel(f.S4((i2 * width) / 100.0f), f.S4((i4 * height) / 100.0f));
                    iRed += Color.red(pixel);
                    iGreen += Color.green(pixel);
                    iBlue += Color.blue(pixel);
                    if (i5 > 99) {
                        break;
                    } else {
                        i4 = i5;
                    }
                }
                if (i3 > 99) {
                    break;
                } else {
                    i2 = i3;
                }
            }
            readBookConfig.setBgMeanColor(Color.rgb((iRed / 3000) + 3, (iGreen / 3000) + 3, (iBlue / 3000) + 3));
        } else if (drawableCurBgDrawable instanceof ColorDrawable) {
            INSTANCE.setBgMeanColor(((ColorDrawable) drawableCurBgDrawable).getColor());
        }
        bg = drawableCurBgDrawable;
    }

    @NotNull
    public final Config getConfig() {
        return shareLayout ? getShareConfig() : getDurConfig();
    }

    /* JADX INFO: compiled from: ReadBookConfig.kt */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0007\n\u0002\be\b\u0007\u0018\u00002\u00020\u0001B\u0083\u0004\u0012\b\b\u0002\u0010@\u001a\u00020\u0013\u0012\b\b\u0002\u0010P\u001a\u00020\u0013\u0012\t\b\u0002\u0010£\u0001\u001a\u00020\u0013\u0012\b\b\u0002\u0010/\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010x\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u009f\u0001\u001a\u00020\t\u0012\b\b\u0002\u0010w\u001a\u00020\t\u0012\b\b\u0002\u0010p\u001a\u00020\t\u0012\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u0013\u0012\b\b\u0002\u0010S\u001a\u00020\u0013\u0012\t\b\u0002\u0010\u0092\u0001\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0013\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010T\u001a\u00020\u0002\u0012\b\b\u0002\u0010G\u001a\u00020F\u0012\t\b\u0002\u0010\u008f\u0001\u001a\u00020\u0002\u0012\b\b\u0002\u0010C\u001a\u00020\u0002\u0012\t\b\u0002\u0010 \u0001\u001a\u00020\u0002\u0012\b\b\u0002\u0010M\u001a\u00020\u0002\u0012\b\b\u0002\u0010W\u001a\u00020\u0002\u0012\b\b\u0002\u0010j\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0013\u0012\b\b\u0002\u0010g\u001a\u00020\u0002\u0012\b\b\u0002\u0010~\u001a\u00020\u0002\u0012\b\b\u0002\u0010:\u001a\u00020\u0002\u0012\b\b\u0002\u0010=\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u009c\u0001\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u0096\u0001\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010m\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u0002\u0012\b\b\u0002\u0010q\u001a\u00020\t\u0012\b\b\u0002\u0010`\u001a\u00020\t\u0012\b\b\u0002\u0010{\u001a\u00020\u0002\u0012\b\b\u0002\u0010d\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u0012\b\b\u0002\u0010Z\u001a\u00020\u0002\u0012\t\b\u0002\u0010¦\u0001\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u0099\u0001\u001a\u00020\u0002\u0012\b\b\u0002\u0010]\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u0002\u0012\b\b\u0002\u0010t\u001a\u00020\u0002¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\r\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u001d\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\bJ\u001d\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010 \u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\u0006R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\b\"\u0004\b&\u0010\u0006R\"\u0010'\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010 \u001a\u0004\b-\u0010\b\"\u0004\b.\u0010\u0006R\"\u0010/\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010(\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010+R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010 \u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\u0006R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010 \u001a\u0004\b6\u0010\b\"\u0004\b7\u0010\u0006R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010 \u001a\u0004\b8\u0010\b\"\u0004\b9\u0010\u0006R\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010 \u001a\u0004\b;\u0010\b\"\u0004\b<\u0010\u0006R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010 \u001a\u0004\b>\u0010\b\"\u0004\b?\u0010\u0006R\"\u0010@\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010(\u001a\u0004\bA\u0010\u0018\"\u0004\bB\u0010+R\"\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010 \u001a\u0004\bD\u0010\b\"\u0004\bE\u0010\u0006R\"\u0010G\u001a\u00020F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010 \u001a\u0004\bN\u0010\b\"\u0004\bO\u0010\u0006R\"\u0010P\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010(\u001a\u0004\bQ\u0010\u0018\"\u0004\bR\u0010+R\u0016\u0010S\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010(R\"\u0010T\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010 \u001a\u0004\bU\u0010\b\"\u0004\bV\u0010\u0006R\"\u0010W\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010 \u001a\u0004\bX\u0010\b\"\u0004\bY\u0010\u0006R\"\u0010Z\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010 \u001a\u0004\b[\u0010\b\"\u0004\b\\\u0010\u0006R\"\u0010]\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010 \u001a\u0004\b^\u0010\b\"\u0004\b_\u0010\u0006R\"\u0010`\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010\u000e\"\u0004\bc\u0010\fR\"\u0010d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010 \u001a\u0004\be\u0010\b\"\u0004\bf\u0010\u0006R\"\u0010g\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010 \u001a\u0004\bh\u0010\b\"\u0004\bi\u0010\u0006R\"\u0010j\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010 \u001a\u0004\bk\u0010\b\"\u0004\bl\u0010\u0006R\"\u0010m\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010 \u001a\u0004\bn\u0010\b\"\u0004\bo\u0010\u0006R\u0016\u0010p\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010aR\"\u0010q\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010a\u001a\u0004\br\u0010\u000e\"\u0004\bs\u0010\fR\"\u0010t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010 \u001a\u0004\bu\u0010\b\"\u0004\bv\u0010\u0006R\u0016\u0010w\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010aR\"\u0010x\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010 \u001a\u0004\by\u0010\b\"\u0004\bz\u0010\u0006R\"\u0010{\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010 \u001a\u0004\b|\u0010\b\"\u0004\b}\u0010\u0006R#\u0010~\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010 \u001a\u0004\b\u007f\u0010\b\"\u0005\b\u0080\u0001\u0010\u0006R&\u0010\u0081\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010 \u001a\u0005\b\u0082\u0001\u0010\b\"\u0005\b\u0083\u0001\u0010\u0006R\u0018\u0010\u0084\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010(R&\u0010\u0085\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010 \u001a\u0005\b\u0086\u0001\u0010\b\"\u0005\b\u0087\u0001\u0010\u0006R&\u0010\u0088\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010(\u001a\u0005\b\u0089\u0001\u0010\u0018\"\u0005\b\u008a\u0001\u0010+R&\u0010\u008b\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010 \u001a\u0005\b\u008c\u0001\u0010\b\"\u0005\b\u008d\u0001\u0010\u0006R\u0018\u0010\u008e\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010 R&\u0010\u008f\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010 \u001a\u0005\b\u0090\u0001\u0010\b\"\u0005\b\u0091\u0001\u0010\u0006R\u0018\u0010\u0092\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010(R&\u0010\u0093\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010 \u001a\u0005\b\u0094\u0001\u0010\b\"\u0005\b\u0095\u0001\u0010\u0006R&\u0010\u0096\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010 \u001a\u0005\b\u0097\u0001\u0010\b\"\u0005\b\u0098\u0001\u0010\u0006R&\u0010\u0099\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010 \u001a\u0005\b\u009a\u0001\u0010\b\"\u0005\b\u009b\u0001\u0010\u0006R&\u0010\u009c\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010 \u001a\u0005\b\u009d\u0001\u0010\b\"\u0005\b\u009e\u0001\u0010\u0006R\u0018\u0010\u009f\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010aR&\u0010 \u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b \u0001\u0010 \u001a\u0005\b¡\u0001\u0010\b\"\u0005\b¢\u0001\u0010\u0006R&\u0010£\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010(\u001a\u0005\b¤\u0001\u0010\u0018\"\u0005\b¥\u0001\u0010+R&\u0010¦\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¦\u0001\u0010 \u001a\u0005\b§\u0001\u0010\b\"\u0005\b¨\u0001\u0010\u0006¨\u0006«\u0001"}, d2 = {"Lio/legado/app/help/ReadBookConfig$Config;", "", "", "color", "Lf/v;", "setCurTextColor", "(I)V", "curTextColor", "()I", "", "isDark", "setCurStatusIconDark", "(Z)V", "curStatusIconDark", "()Z", "anim", "setCurPageAnim", "curPageAnim", "bgType", "", "bg", "setCurBg", "(ILjava/lang/String;)V", "curBgStr", "()Ljava/lang/String;", "curBgType", "width", "height", "Landroid/graphics/drawable/Drawable;", "curBgDrawable", "(II)Landroid/graphics/drawable/Drawable;", "pageAnim", OptRuntime.GeneratorState.resumptionPoint_TYPE, "footerPaddingLeft", "getFooterPaddingLeft", "setFooterPaddingLeft", "textBold", "getTextBold", "setTextBold", "paragraphIndent", "Ljava/lang/String;", "getParagraphIndent", "setParagraphIndent", "(Ljava/lang/String;)V", "headerPaddingTop", "getHeaderPaddingTop", "setHeaderPaddingTop", "bgStrEInk", "getBgStrEInk", "setBgStrEInk", "tipHeaderRight", "getTipHeaderRight", "setTipHeaderRight", "bgTypeEInk", "getBgTypeEInk", "setBgTypeEInk", "getBgType", "setBgType", "paddingRight", "getPaddingRight", "setPaddingRight", "paddingTop", "getPaddingTop", "setPaddingTop", "name", "getName", "setName", "paragraphSpacing", "getParagraphSpacing", "setParagraphSpacing", "", "letterSpacing", "F", "getLetterSpacing", "()F", "setLetterSpacing", "(F)V", "titleSize", "getTitleSize", "setTitleSize", "bgStr", "getBgStr", "setBgStr", "textColorNight", "textSize", "getTextSize", "setTextSize", "titleTopSpacing", "getTitleTopSpacing", "setTitleTopSpacing", "tipFooterLeft", "getTipFooterLeft", "setTipFooterLeft", "tipColor", "getTipColor", "setTipColor", "showFooterLine", "Z", "getShowFooterLine", "setShowFooterLine", "tipHeaderMiddle", "getTipHeaderMiddle", "setTipHeaderMiddle", "paddingBottom", "getPaddingBottom", "setPaddingBottom", "titleBottomSpacing", "getTitleBottomSpacing", "setTitleBottomSpacing", "footerPaddingBottom", "getFooterPaddingBottom", "setFooterPaddingBottom", "darkStatusIconEInk", "showHeaderLine", "getShowHeaderLine", "setShowHeaderLine", "footerMode", "getFooterMode", "setFooterMode", "darkStatusIconNight", "bgTypeNight", "getBgTypeNight", "setBgTypeNight", "tipHeaderLeft", "getTipHeaderLeft", "setTipHeaderLeft", "paddingLeft", "getPaddingLeft", "setPaddingLeft", "headerMode", "getHeaderMode", "setHeaderMode", "textColor", "headerPaddingRight", "getHeaderPaddingRight", "setHeaderPaddingRight", "textFont", "getTextFont", "setTextFont", "footerPaddingRight", "getFooterPaddingRight", "setFooterPaddingRight", "pageAnimEInk", "lineSpacingExtra", "getLineSpacingExtra", "setLineSpacingExtra", "textColorEInk", "footerPaddingTop", "getFooterPaddingTop", "setFooterPaddingTop", "headerPaddingLeft", "getHeaderPaddingLeft", "setHeaderPaddingLeft", "tipFooterRight", "getTipFooterRight", "setTipFooterRight", "headerPaddingBottom", "getHeaderPaddingBottom", "setHeaderPaddingBottom", "darkStatusIcon", "titleMode", "getTitleMode", "setTitleMode", "bgStrNight", "getBgStrNight", "setBgStrNight", "tipFooterMiddle", "getTipFooterMiddle", "setTipFooterMiddle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;IIFIIIIIILjava/lang/String;IIIIIIIIIIIIZZIIIIIIIII)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Config {

        @NotNull
        private String bgStr;

        @NotNull
        private String bgStrEInk;

        @NotNull
        private String bgStrNight;
        private int bgType;
        private int bgTypeEInk;
        private int bgTypeNight;
        private boolean darkStatusIcon;
        private boolean darkStatusIconEInk;
        private boolean darkStatusIconNight;
        private int footerMode;
        private int footerPaddingBottom;
        private int footerPaddingLeft;
        private int footerPaddingRight;
        private int footerPaddingTop;
        private int headerMode;
        private int headerPaddingBottom;
        private int headerPaddingLeft;
        private int headerPaddingRight;
        private int headerPaddingTop;
        private float letterSpacing;
        private int lineSpacingExtra;

        @NotNull
        private String name;
        private int paddingBottom;
        private int paddingLeft;
        private int paddingRight;
        private int paddingTop;
        private int pageAnim;
        private int pageAnimEInk;

        @NotNull
        private String paragraphIndent;
        private int paragraphSpacing;
        private boolean showFooterLine;
        private boolean showHeaderLine;
        private int textBold;

        @NotNull
        private String textColor;

        @NotNull
        private String textColorEInk;

        @NotNull
        private String textColorNight;

        @NotNull
        private String textFont;
        private int textSize;
        private int tipColor;
        private int tipFooterLeft;
        private int tipFooterMiddle;
        private int tipFooterRight;
        private int tipHeaderLeft;
        private int tipHeaderMiddle;
        private int tipHeaderRight;
        private int titleBottomSpacing;
        private int titleMode;
        private int titleSize;
        private int titleTopSpacing;

        public Config() {
            this(null, null, null, null, 0, 0, 0, false, false, false, null, null, null, 0, 0, null, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 131071, null);
        }

        public Config(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, @NotNull String str5, @NotNull String str6, @NotNull String str7, int i5, int i6, @NotNull String str8, int i7, int i8, float f2, int i9, int i10, int i11, int i12, int i13, int i14, @NotNull String str9, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, boolean z4, boolean z5, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35) {
            j.e(str, "name");
            j.e(str2, "bgStr");
            j.e(str3, "bgStrNight");
            j.e(str4, "bgStrEInk");
            j.e(str5, "textColor");
            j.e(str6, "textColorNight");
            j.e(str7, "textColorEInk");
            j.e(str8, "textFont");
            j.e(str9, "paragraphIndent");
            this.name = str;
            this.bgStr = str2;
            this.bgStrNight = str3;
            this.bgStrEInk = str4;
            this.bgType = i2;
            this.bgTypeNight = i3;
            this.bgTypeEInk = i4;
            this.darkStatusIcon = z;
            this.darkStatusIconNight = z2;
            this.darkStatusIconEInk = z3;
            this.textColor = str5;
            this.textColorNight = str6;
            this.textColorEInk = str7;
            this.pageAnim = i5;
            this.pageAnimEInk = i6;
            this.textFont = str8;
            this.textBold = i7;
            this.textSize = i8;
            this.letterSpacing = f2;
            this.lineSpacingExtra = i9;
            this.paragraphSpacing = i10;
            this.titleMode = i11;
            this.titleSize = i12;
            this.titleTopSpacing = i13;
            this.titleBottomSpacing = i14;
            this.paragraphIndent = str9;
            this.paddingBottom = i15;
            this.paddingLeft = i16;
            this.paddingRight = i17;
            this.paddingTop = i18;
            this.headerPaddingBottom = i19;
            this.headerPaddingLeft = i20;
            this.headerPaddingRight = i21;
            this.headerPaddingTop = i22;
            this.footerPaddingBottom = i23;
            this.footerPaddingLeft = i24;
            this.footerPaddingRight = i25;
            this.footerPaddingTop = i26;
            this.showHeaderLine = z4;
            this.showFooterLine = z5;
            this.tipHeaderLeft = i27;
            this.tipHeaderMiddle = i28;
            this.tipHeaderRight = i29;
            this.tipFooterLeft = i30;
            this.tipFooterMiddle = i31;
            this.tipFooterRight = i32;
            this.tipColor = i33;
            this.headerMode = i34;
            this.footerMode = i35;
        }

        @NotNull
        public final Drawable curBgDrawable(int width, int height) {
            BitmapDrawable bitmapDrawable;
            Resources resources = h.g().getResources();
            Drawable colorDrawable = null;
            try {
                int iCurBgType = curBgType();
                if (iCurBgType != 0) {
                    if (iCurBgType != 1) {
                        String strCurBgStr = curBgStr();
                        j.e(strCurBgStr, "path");
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        FileInputStream fileInputStream = new FileInputStream(strCurBgStr);
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, options);
                        int iCeil = (int) Math.ceil(options.outWidth / width);
                        int iCeil2 = (int) Math.ceil(options.outHeight / height);
                        if (iCeil > 1 && iCeil2 > 1) {
                            if (iCeil > iCeil2) {
                                options.inSampleSize = iCeil;
                            } else {
                                options.inSampleSize = iCeil2;
                            }
                        }
                        options.inJustDecodeBounds = false;
                        bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, options));
                    } else {
                        Context contextG = h.g();
                        String str = "bg" + ((Object) File.separator) + curBgStr();
                        j.e(contextG, com.umeng.analytics.pro.c.R);
                        j.e(str, "fileNameInAssets");
                        InputStream inputStreamOpen = contextG.getAssets().open(str);
                        j.d(inputStreamOpen, "context.assets.open(fileNameInAssets)");
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(inputStreamOpen, null, options2);
                        int iCeil3 = (int) Math.ceil(options2.outWidth / width);
                        int iCeil4 = (int) Math.ceil(options2.outHeight / height);
                        if (iCeil3 > 1 && iCeil4 > 1) {
                            if (iCeil3 > iCeil4) {
                                options2.inSampleSize = iCeil3;
                            } else {
                                options2.inSampleSize = iCeil4;
                            }
                        }
                        InputStream inputStreamOpen2 = contextG.getAssets().open(str);
                        j.d(inputStreamOpen2, "context.assets.open(fileNameInAssets)");
                        options2.inJustDecodeBounds = false;
                        bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeStream(inputStreamOpen2, null, options2));
                    }
                    colorDrawable = bitmapDrawable;
                } else {
                    colorDrawable = new ColorDrawable(Color.parseColor(curBgStr()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return colorDrawable == null ? new ColorDrawable(f.c2(h.g(), R.color.background)) : colorDrawable;
        }

        @NotNull
        public final String curBgStr() {
            return e.a.a.d.e.f5519d ? this.bgStrEInk : e.a.a.d.e.a.m() ? this.bgStrNight : this.bgStr;
        }

        public final int curBgType() {
            return e.a.a.d.e.f5519d ? this.bgTypeEInk : e.a.a.d.e.a.m() ? this.bgTypeNight : this.bgType;
        }

        public final int curPageAnim() {
            e.a.a.d.e eVar = e.a.a.d.e.a;
            return e.a.a.d.e.f5519d ? this.pageAnimEInk : this.pageAnim;
        }

        public final boolean curStatusIconDark() {
            return e.a.a.d.e.f5519d ? this.darkStatusIconEInk : e.a.a.d.e.a.m() ? this.darkStatusIconNight : this.darkStatusIcon;
        }

        public final int curTextColor() {
            return e.a.a.d.e.f5519d ? Color.parseColor(this.textColorEInk) : e.a.a.d.e.a.m() ? Color.parseColor(this.textColorNight) : Color.parseColor(this.textColor);
        }

        @NotNull
        public final String getBgStr() {
            return this.bgStr;
        }

        @NotNull
        public final String getBgStrEInk() {
            return this.bgStrEInk;
        }

        @NotNull
        public final String getBgStrNight() {
            return this.bgStrNight;
        }

        public final int getBgType() {
            return this.bgType;
        }

        public final int getBgTypeEInk() {
            return this.bgTypeEInk;
        }

        public final int getBgTypeNight() {
            return this.bgTypeNight;
        }

        public final int getFooterMode() {
            return this.footerMode;
        }

        public final int getFooterPaddingBottom() {
            return this.footerPaddingBottom;
        }

        public final int getFooterPaddingLeft() {
            return this.footerPaddingLeft;
        }

        public final int getFooterPaddingRight() {
            return this.footerPaddingRight;
        }

        public final int getFooterPaddingTop() {
            return this.footerPaddingTop;
        }

        public final int getHeaderMode() {
            return this.headerMode;
        }

        public final int getHeaderPaddingBottom() {
            return this.headerPaddingBottom;
        }

        public final int getHeaderPaddingLeft() {
            return this.headerPaddingLeft;
        }

        public final int getHeaderPaddingRight() {
            return this.headerPaddingRight;
        }

        public final int getHeaderPaddingTop() {
            return this.headerPaddingTop;
        }

        public final float getLetterSpacing() {
            return this.letterSpacing;
        }

        public final int getLineSpacingExtra() {
            return this.lineSpacingExtra;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public final int getPaddingBottom() {
            return this.paddingBottom;
        }

        public final int getPaddingLeft() {
            return this.paddingLeft;
        }

        public final int getPaddingRight() {
            return this.paddingRight;
        }

        public final int getPaddingTop() {
            return this.paddingTop;
        }

        @NotNull
        public final String getParagraphIndent() {
            return this.paragraphIndent;
        }

        public final int getParagraphSpacing() {
            return this.paragraphSpacing;
        }

        public final boolean getShowFooterLine() {
            return this.showFooterLine;
        }

        public final boolean getShowHeaderLine() {
            return this.showHeaderLine;
        }

        public final int getTextBold() {
            return this.textBold;
        }

        @NotNull
        public final String getTextFont() {
            return this.textFont;
        }

        public final int getTextSize() {
            return this.textSize;
        }

        public final int getTipColor() {
            return this.tipColor;
        }

        public final int getTipFooterLeft() {
            return this.tipFooterLeft;
        }

        public final int getTipFooterMiddle() {
            return this.tipFooterMiddle;
        }

        public final int getTipFooterRight() {
            return this.tipFooterRight;
        }

        public final int getTipHeaderLeft() {
            return this.tipHeaderLeft;
        }

        public final int getTipHeaderMiddle() {
            return this.tipHeaderMiddle;
        }

        public final int getTipHeaderRight() {
            return this.tipHeaderRight;
        }

        public final int getTitleBottomSpacing() {
            return this.titleBottomSpacing;
        }

        public final int getTitleMode() {
            return this.titleMode;
        }

        public final int getTitleSize() {
            return this.titleSize;
        }

        public final int getTitleTopSpacing() {
            return this.titleTopSpacing;
        }

        public final void setBgStr(@NotNull String str) {
            j.e(str, "<set-?>");
            this.bgStr = str;
        }

        public final void setBgStrEInk(@NotNull String str) {
            j.e(str, "<set-?>");
            this.bgStrEInk = str;
        }

        public final void setBgStrNight(@NotNull String str) {
            j.e(str, "<set-?>");
            this.bgStrNight = str;
        }

        public final void setBgType(int i2) {
            this.bgType = i2;
        }

        public final void setBgTypeEInk(int i2) {
            this.bgTypeEInk = i2;
        }

        public final void setBgTypeNight(int i2) {
            this.bgTypeNight = i2;
        }

        public final void setCurBg(int bgType, @NotNull String bg) {
            j.e(bg, "bg");
            e.a.a.d.e eVar = e.a.a.d.e.a;
            if (e.a.a.d.e.f5519d) {
                this.bgTypeEInk = bgType;
                this.bgStrEInk = bg;
            } else if (eVar.m()) {
                this.bgTypeNight = bgType;
                this.bgStrNight = bg;
            } else {
                this.bgType = bgType;
                this.bgStr = bg;
            }
        }

        public final void setCurPageAnim(int anim) {
            e.a.a.d.e eVar = e.a.a.d.e.a;
            if (e.a.a.d.e.f5519d) {
                this.pageAnimEInk = anim;
            } else {
                this.pageAnim = anim;
            }
        }

        public final void setCurStatusIconDark(boolean isDark) {
            e.a.a.d.e eVar = e.a.a.d.e.a;
            if (e.a.a.d.e.f5519d) {
                this.darkStatusIconEInk = isDark;
            } else if (eVar.m()) {
                this.darkStatusIconNight = isDark;
            } else {
                this.darkStatusIcon = isDark;
            }
        }

        public final void setCurTextColor(int color) {
            e.a.a.d.e eVar = e.a.a.d.e.a;
            if (e.a.a.d.e.f5519d) {
                this.textColorEInk = j.k("#", f.w2(color));
            } else if (eVar.m()) {
                this.textColorNight = j.k("#", f.w2(color));
            } else {
                this.textColor = j.k("#", f.w2(color));
            }
            e.a.a.g.d.i.s1.h.a.a.i();
        }

        public final void setFooterMode(int i2) {
            this.footerMode = i2;
        }

        public final void setFooterPaddingBottom(int i2) {
            this.footerPaddingBottom = i2;
        }

        public final void setFooterPaddingLeft(int i2) {
            this.footerPaddingLeft = i2;
        }

        public final void setFooterPaddingRight(int i2) {
            this.footerPaddingRight = i2;
        }

        public final void setFooterPaddingTop(int i2) {
            this.footerPaddingTop = i2;
        }

        public final void setHeaderMode(int i2) {
            this.headerMode = i2;
        }

        public final void setHeaderPaddingBottom(int i2) {
            this.headerPaddingBottom = i2;
        }

        public final void setHeaderPaddingLeft(int i2) {
            this.headerPaddingLeft = i2;
        }

        public final void setHeaderPaddingRight(int i2) {
            this.headerPaddingRight = i2;
        }

        public final void setHeaderPaddingTop(int i2) {
            this.headerPaddingTop = i2;
        }

        public final void setLetterSpacing(float f2) {
            this.letterSpacing = f2;
        }

        public final void setLineSpacingExtra(int i2) {
            this.lineSpacingExtra = i2;
        }

        public final void setName(@NotNull String str) {
            j.e(str, "<set-?>");
            this.name = str;
        }

        public final void setPaddingBottom(int i2) {
            this.paddingBottom = i2;
        }

        public final void setPaddingLeft(int i2) {
            this.paddingLeft = i2;
        }

        public final void setPaddingRight(int i2) {
            this.paddingRight = i2;
        }

        public final void setPaddingTop(int i2) {
            this.paddingTop = i2;
        }

        public final void setParagraphIndent(@NotNull String str) {
            j.e(str, "<set-?>");
            this.paragraphIndent = str;
        }

        public final void setParagraphSpacing(int i2) {
            this.paragraphSpacing = i2;
        }

        public final void setShowFooterLine(boolean z) {
            this.showFooterLine = z;
        }

        public final void setShowHeaderLine(boolean z) {
            this.showHeaderLine = z;
        }

        public final void setTextBold(int i2) {
            this.textBold = i2;
        }

        public final void setTextFont(@NotNull String str) {
            j.e(str, "<set-?>");
            this.textFont = str;
        }

        public final void setTextSize(int i2) {
            this.textSize = i2;
        }

        public final void setTipColor(int i2) {
            this.tipColor = i2;
        }

        public final void setTipFooterLeft(int i2) {
            this.tipFooterLeft = i2;
        }

        public final void setTipFooterMiddle(int i2) {
            this.tipFooterMiddle = i2;
        }

        public final void setTipFooterRight(int i2) {
            this.tipFooterRight = i2;
        }

        public final void setTipHeaderLeft(int i2) {
            this.tipHeaderLeft = i2;
        }

        public final void setTipHeaderMiddle(int i2) {
            this.tipHeaderMiddle = i2;
        }

        public final void setTipHeaderRight(int i2) {
            this.tipHeaderRight = i2;
        }

        public final void setTitleBottomSpacing(int i2) {
            this.titleBottomSpacing = i2;
        }

        public final void setTitleMode(int i2) {
            this.titleMode = i2;
        }

        public final void setTitleSize(int i2) {
            this.titleSize = i2;
        }

        public final void setTitleTopSpacing(int i2) {
            this.titleTopSpacing = i2;
        }

        public /* synthetic */ Config(String str, String str2, String str3, String str4, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, String str5, String str6, String str7, int i5, int i6, String str8, int i7, int i8, float f2, int i9, int i10, int i11, int i12, int i13, int i14, String str9, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, boolean z4, boolean z5, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, f.c0.c.f fVar) {
            this((i36 & 1) != 0 ? "" : str, (i36 & 2) != 0 ? "#EEEEEE" : str2, (i36 & 4) != 0 ? "#000000" : str3, (i36 & 8) != 0 ? "#FFFFFF" : str4, (i36 & 16) != 0 ? 0 : i2, (i36 & 32) != 0 ? 0 : i3, (i36 & 64) != 0 ? 0 : i4, (i36 & 128) != 0 ? true : z, (i36 & 256) != 0 ? false : z2, (i36 & 512) != 0 ? true : z3, (i36 & 1024) != 0 ? "#3E3D3B" : str5, (i36 & 2048) != 0 ? "#ADADAD" : str6, (i36 & 4096) == 0 ? str7 : "#000000", (i36 & 8192) != 0 ? 2 : i5, (i36 & 16384) != 0 ? 2 : i6, (i36 & 32768) != 0 ? "" : str8, (i36 & 65536) != 0 ? 0 : i7, (i36 & 131072) != 0 ? 20 : i8, (i36 & 262144) != 0 ? 0.1f : f2, (i36 & 524288) != 0 ? 12 : i9, (i36 & 1048576) != 0 ? 2 : i10, (i36 & 2097152) != 0 ? 0 : i11, (i36 & 4194304) != 0 ? 0 : i12, (i36 & 8388608) != 0 ? 0 : i13, (i36 & 16777216) != 0 ? 0 : i14, (i36 & 33554432) != 0 ? "\u3000\u3000" : str9, (i36 & 67108864) != 0 ? 6 : i15, (i36 & 134217728) != 0 ? 16 : i16, (i36 & 268435456) != 0 ? 16 : i17, (i36 & 536870912) != 0 ? 6 : i18, (i36 & BasicMeasure.EXACTLY) != 0 ? 0 : i19, (i36 & Integer.MIN_VALUE) != 0 ? 16 : i20, (i37 & 1) != 0 ? 16 : i21, (i37 & 2) != 0 ? 0 : i22, (i37 & 4) != 0 ? 6 : i23, (i37 & 8) != 0 ? 16 : i24, (i37 & 16) == 0 ? i25 : 16, (i37 & 32) != 0 ? 6 : i26, (i37 & 64) != 0 ? false : z4, (i37 & 128) != 0 ? true : z5, (i37 & 256) == 0 ? i27 : 2, (i37 & 512) != 0 ? 0 : i28, (i37 & 1024) != 0 ? 3 : i29, (i37 & 2048) != 0 ? 1 : i30, (i37 & 4096) != 0 ? 0 : i31, (i37 & 8192) == 0 ? i32 : 6, (i37 & 16384) != 0 ? 0 : i33, (i37 & 32768) != 0 ? 0 : i34, (i37 & 65536) != 0 ? 0 : i35);
        }
    }
}
