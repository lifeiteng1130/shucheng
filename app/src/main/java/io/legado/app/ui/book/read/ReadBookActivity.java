package io.legado.app.ui.book.read;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.media2.session.MediaConstants;
import androidx.view.Observer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.Gson;
import com.ifmvo.togetherad.core.helper.AdHelperInter;
import com.ifmvo.togetherad.core.helper.AdHelperReward;
import com.ifmvo.togetherad.core.listener.RewardListener;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.ai;
import e.a.a.d.w.c;
import e.a.a.e.d.b;
import e.a.a.f.s.k;
import e.a.a.g.d.i.i0;
import e.a.a.g.d.i.l0;
import e.a.a.g.d.i.m0;
import e.a.a.g.d.i.n0;
import e.a.a.g.d.i.o0;
import e.a.a.g.d.i.p0;
import e.a.a.g.d.i.q0;
import e.a.a.g.d.i.s0;
import e.a.a.g.d.i.t0;
import e.a.a.g.d.i.u0;
import e.a.a.g.d.i.v0;
import f.v;
import g.b.a0;
import g.b.k0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookProgress;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.Bookmark;
import io.legado.app.databinding.ActivityBookReadBinding;
import io.legado.app.help.ReadBookConfig;
import io.legado.app.lib.theme.ATH;
import io.legado.app.model.AdsConfig;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.receiver.TimeBatteryReceiver;
import io.legado.app.service.BaseReadAloudService;
import io.legado.app.ui.book.changesource.ChangeSourceDialog;
import io.legado.app.ui.book.info.BookInfoActivity;
import io.legado.app.ui.book.read.ReadBookActivity;
import io.legado.app.ui.book.read.ReadBookViewModel;
import io.legado.app.ui.book.read.ReadMenu;
import io.legado.app.ui.book.read.TextActionMenu;
import io.legado.app.ui.book.read.config.AutoReadDialog;
import io.legado.app.ui.book.read.config.MoreConfigDialog;
import io.legado.app.ui.book.read.config.ReadAloudDialog;
import io.legado.app.ui.book.read.config.ReadStyleDialog;
import io.legado.app.ui.book.read.config.TocRegexDialog;
import io.legado.app.ui.book.read.page.ContentTextView;
import io.legado.app.ui.book.read.page.PageView;
import io.legado.app.ui.book.read.page.ReadView;
import io.legado.app.ui.book.searchContent.SearchContentActivity;
import io.legado.app.ui.book.toc.TocActivityResult;
import io.legado.app.ui.login.SourceLoginActivity;
import io.legado.app.ui.replace.ReplaceRuleActivity;
import io.legado.app.ui.replace.edit.ReplaceEditActivity;
import io.legado.app.ui.widget.BatteryView;
import io.legado.app.ui.widget.dialog.BottomTipsDialog;
import io.legado.app.ui.widget.dialog.TextDialog;
import io.legado.app.ui.widget.text.AccentBgTextView;
import io.legado.app.utils.EventBusExtensionsKt$observeEvent$o$1;
import io.legado.app.utils.EventBusExtensionsKt$observeEventSticky$o$1;
import io.wenyuange.app.release.R;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ReadBookActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\fB\b¢\u0006\u0005\b½\u0001\u0010\u000fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u000fJ\u0019\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010$\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0014¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\rH\u0014¢\u0006\u0004\b&\u0010\u000fJ\u000f\u0010'\u001a\u00020\rH\u0014¢\u0006\u0004\b'\u0010\u000fJ\u0017\u0010*\u001a\u00020\u00122\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b,\u0010+J\u0017\u0010/\u001a\u00020\u00122\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u0019\u00103\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104J!\u00107\u001a\u00020\u00122\u0006\u00106\u001a\u0002052\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b7\u00108J!\u00109\u001a\u00020\u00122\u0006\u00106\u001a\u0002052\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b9\u00108J!\u0010:\u001a\u00020\u00122\u0006\u00106\u001a\u0002052\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b:\u00108J\u001f\u0010>\u001a\u00020\u00122\u0006\u0010<\u001a\u00020;2\u0006\u00102\u001a\u00020=H\u0017¢\u0006\u0004\b>\u0010?J'\u0010D\u001a\u00020\r2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020@2\u0006\u0010C\u001a\u00020@H\u0016¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020\r2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020@H\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\rH\u0016¢\u0006\u0004\bH\u0010\u000fJ\u000f\u0010I\u001a\u00020\rH\u0016¢\u0006\u0004\bI\u0010\u000fJ\u0017\u0010K\u001a\u00020\u00122\u0006\u0010J\u001a\u000205H\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\rH\u0016¢\u0006\u0004\bM\u0010\u000fJ\u0017\u0010P\u001a\u00020\r2\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\rH\u0016¢\u0006\u0004\bR\u0010\u000fJ/\u0010W\u001a\u00020\r2\u0006\u0010S\u001a\u0002052\u0006\u0010T\u001a\u00020\u00122\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010UH\u0016¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\rH\u0016¢\u0006\u0004\bY\u0010\u000fJ\u000f\u0010Z\u001a\u00020\rH\u0016¢\u0006\u0004\bZ\u0010\u000fJ\u000f\u0010[\u001a\u00020\rH\u0016¢\u0006\u0004\b[\u0010\u000fJ\u000f\u0010\\\u001a\u00020\rH\u0016¢\u0006\u0004\b\\\u0010\u000fJ\u0017\u0010]\u001a\u00020\r2\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\b]\u0010QJ\u000f\u0010^\u001a\u00020\rH\u0016¢\u0006\u0004\b^\u0010\u000fJ\u000f\u0010_\u001a\u00020\rH\u0016¢\u0006\u0004\b_\u0010\u000fJ\u000f\u0010`\u001a\u00020\rH\u0016¢\u0006\u0004\b`\u0010\u000fJ\u000f\u0010a\u001a\u00020\rH\u0016¢\u0006\u0004\ba\u0010\u000fJ\u000f\u0010b\u001a\u00020\rH\u0016¢\u0006\u0004\bb\u0010\u000fJ\u000f\u0010B\u001a\u00020\rH\u0016¢\u0006\u0004\bB\u0010\u000fJ\u000f\u0010c\u001a\u00020\rH\u0016¢\u0006\u0004\bc\u0010\u000fJ\u000f\u0010d\u001a\u00020\rH\u0016¢\u0006\u0004\bd\u0010\u000fJ\u0019\u0010g\u001a\u00020\r2\b\u0010f\u001a\u0004\u0018\u00010eH\u0016¢\u0006\u0004\bg\u0010hJ\u000f\u0010<\u001a\u00020\rH\u0016¢\u0006\u0004\b<\u0010\u000fJ\u000f\u0010i\u001a\u00020\rH\u0016¢\u0006\u0004\bi\u0010\u000fJ\u000f\u0010j\u001a\u00020\rH\u0016¢\u0006\u0004\bj\u0010\u000fJ\u000f\u0010k\u001a\u00020\rH\u0016¢\u0006\u0004\bk\u0010\u000fJ\u000f\u0010A\u001a\u00020\rH\u0016¢\u0006\u0004\bA\u0010\u000fJ\u000f\u0010l\u001a\u00020\rH\u0016¢\u0006\u0004\bl\u0010\u000fJ\u000f\u0010m\u001a\u00020\rH\u0016¢\u0006\u0004\bm\u0010\u000fJ\u001f\u0010p\u001a\u00020\r2\u0006\u0010n\u001a\u0002052\u0006\u0010o\u001a\u000205H\u0016¢\u0006\u0004\bp\u0010qJ\u0017\u0010r\u001a\u00020\r2\u0006\u0010n\u001a\u000205H\u0016¢\u0006\u0004\br\u0010sJ\u0017\u0010u\u001a\u00020\r2\u0006\u0010t\u001a\u00020eH\u0016¢\u0006\u0004\bu\u0010hJ\u000f\u0010v\u001a\u00020\rH\u0016¢\u0006\u0004\bv\u0010\u000fJ\u000f\u0010w\u001a\u00020\rH\u0014¢\u0006\u0004\bw\u0010\u000fJ\u000f\u0010x\u001a\u00020\rH\u0016¢\u0006\u0004\bx\u0010\u000fJ\u000f\u0010y\u001a\u00020\rH\u0016¢\u0006\u0004\by\u0010\u000fJ\r\u0010z\u001a\u00020\r¢\u0006\u0004\bz\u0010\u000fR\u0016\u0010}\u001a\u00020{8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010|R\u0017\u0010\u0080\u0001\u001a\u0002058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u001b\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bB\u0010\u0082\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010_R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R'\u0010\u008d\u0001\u001a\u00020\u00128\u0016@\u0016X\u0096\u000e¢\u0006\u0016\n\u0005\b\u008a\u0001\u0010I\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0005\b\u008c\u0001\u0010\u001dR\u001a\u0010\u0091\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001a\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001a\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u0010\u009b\u0001\u001a\u00030\u0098\u00018V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009d\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010_R(\u0010¡\u0001\u001a\u0012\u0012\r\u0012\u000b \u009f\u0001*\u0004\u0018\u00010e0e0\u009e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\\\u0010 \u0001R\u0019\u0010£\u0001\u001a\u00020\u00128V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010\u008b\u0001R\u0019\u0010¥\u0001\u001a\u00020\u00128V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010\u008b\u0001R)\u0010§\u0001\u001a\u0012\u0012\r\u0012\u000b \u009f\u0001*\u0004\u0018\u00010\"0\"0\u009e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010 \u0001R\u0019\u0010ª\u0001\u001a\u00020e8V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b¨\u0001\u0010©\u0001R\u001b\u0010\u00ad\u0001\u001a\u0004\u0018\u00010N8V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001R)\u0010¯\u0001\u001a\u0012\u0012\r\u0012\u000b \u009f\u0001*\u0004\u0018\u00010\"0\"0\u009e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0001\u0010 \u0001R&\u0010³\u0001\u001a\u0002058\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b<\u0010°\u0001\u001a\u0005\b±\u0001\u0010\u007f\"\u0005\b²\u0001\u0010sR\u0018\u0010µ\u0001\u001a\u00020{8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b´\u0001\u0010|R#\u0010»\u0001\u001a\u00030¶\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001R\u0017\u0010¼\u0001\u001a\u00020{8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010|¨\u0006¾\u0001"}, d2 = {"Lio/legado/app/ui/book/read/ReadBookActivity;", "Lio/legado/app/ui/book/read/ReadBookBaseActivity;", "Landroid/view/View$OnTouchListener;", "Lio/legado/app/ui/book/read/page/ReadView$a;", "Lio/legado/app/ui/book/read/TextActionMenu$a;", "Lio/legado/app/ui/book/read/page/ContentTextView$a;", "Lio/legado/app/ui/book/read/ReadMenu$a;", "Lio/legado/app/ui/book/read/config/ReadAloudDialog$a;", "Lio/legado/app/ui/book/changesource/ChangeSourceDialog$a;", "Le/a/a/f/s/k$a;", "Lio/legado/app/ui/book/read/config/AutoReadDialog$a;", "Lio/legado/app/ui/book/read/config/TocRegexDialog$a;", "Lc/f/a/a/f;", "Lf/v;", "c1", "()V", "Le/a/a/g/d/i/s1/g/a;", "direction", "", "e1", "(Le/a/a/g/d/i/s1/g/a;)Z", "Z0", "d1", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "hasFocus", "onWindowFocusChanged", "(Z)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onResume", "onPause", "Landroid/view/Menu;", "menu", "P0", "(Landroid/view/Menu;)Z", "onPrepareOptionsMenu", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "", "keyCode", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onKeyLongPress", "onKeyUp", "Landroid/view/View;", ai.aC, "Landroid/view/MotionEvent;", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "", "x", "y", "top", "v0", "(FFF)V", ExifInterface.LONGITUDE_EAST, "(FF)V", ai.aF, "Z", "itemId", "a0", "(I)Z", "M", "Lio/legado/app/data/entities/Book;", "book", "O", "(Lio/legado/app/data/entities/Book;)V", "F0", "relativePosition", "resetPageOffset", "Lkotlin/Function0;", "success", ai.aE, "(IZLf/c0/b/a;)V", "w0", "D", "A0", "m", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "C", "J", ExifInterface.LATITUDE_SOUTH, "N", ai.aA, ExifInterface.LONGITUDE_WEST, ai.aD, "", "searchWord", "k0", "(Ljava/lang/String;)V", "z0", "l0", "h0", "refresh", "f", "dialogId", "color", "i0", "(II)V", "d0", "(I)V", "tocRegex", "H0", "finish", "onDestroy", "N0", "B0", "b1", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "backupRunnable", "j0", "()I", "headerHeight", "Lio/legado/app/receiver/TimeBatteryReceiver;", "Lio/legado/app/receiver/TimeBatteryReceiver;", "timeBatteryReceiver", "", "screenTimeOut", "Lcom/ifmvo/togetherad/core/helper/AdHelperInter;", Constants.LANDSCAPE, "Lcom/ifmvo/togetherad/core/helper/AdHelperInter;", "adHelperInter", "w", "()Z", "setAutoPage", "isAutoPage", "Lcom/ifmvo/togetherad/core/helper/AdHelperReward;", "k", "Lcom/ifmvo/togetherad/core/helper/AdHelperReward;", "adHelperReward", "p", "Landroid/view/Menu;", "Landroid/os/Handler;", "r", "Landroid/os/Handler;", "mHandler", "Le/a/a/g/d/i/s1/h/c;", "H", "()Le/a/a/g/d/i/s1/h/c;", "pageFactory", "j", "readStartTime", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "Landroidx/activity/result/ActivityResultLauncher;", "tocActivity", "y0", "isInitFinish", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isScroll", "o", "searchContentActivity", "U", "()Ljava/lang/String;", "selectedText", "c0", "()Lio/legado/app/data/entities/Book;", "oldBook", "n", "replaceActivity", OptRuntime.GeneratorState.resumptionPoint_TYPE, "x0", "setAutoPageProgress", "autoPageProgress", ai.az, "keepScreenRunnable", "Lio/legado/app/ui/book/read/TextActionMenu;", "q", "Lf/e;", "a1", "()Lio/legado/app/ui/book/read/TextActionMenu;", "textActionMenu", "autoPageRunnable", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReadBookActivity extends ReadBookBaseActivity implements View.OnTouchListener, ReadView.a, TextActionMenu.a, ContentTextView.a, ReadMenu.a, ReadAloudDialog.a, ChangeSourceDialog.a, k.a, AutoReadDialog.a, TocRegexDialog.a, c.f.a.a.f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f7136i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public long readStartTime;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public AdHelperReward adHelperReward;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public AdHelperInter adHelperInter;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<String> tocActivity;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<Intent> replaceActivity;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<Intent> searchContentActivity;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @Nullable
    public Menu menu;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final f.e textActionMenu;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public final Handler mHandler;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @NotNull
    public final Runnable keepScreenRunnable;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @NotNull
    public final Runnable autoPageRunnable;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    @NotNull
    public final Runnable backupRunnable;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public int autoPageProgress;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public boolean isAutoPage;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public long screenTimeOut;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    @Nullable
    public TimeBatteryReceiver timeBatteryReceiver;

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<e.a.a.e.a.h<? extends DialogInterface>, v> {
        public final /* synthetic */ Book $it;

        /* JADX INFO: renamed from: io.legado.app.ui.book.read.ReadBookActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ReadBookActivity.kt */
        public static final class C0199a extends f.c0.c.k implements f.c0.b.l<DialogInterface, v> {
            public final /* synthetic */ ReadBookActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0199a(ReadBookActivity readBookActivity) {
                super(1);
                this.this$0 = readBookActivity;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                f.c0.c.j.e(dialogInterface, "it");
                e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
                e.a.a.f.s.k.f5679e = true;
                this.this$0.setResult(-1);
            }
        }

        /* JADX INFO: compiled from: ReadBookActivity.kt */
        public static final class b extends f.c0.c.k implements f.c0.b.l<DialogInterface, v> {
            public final /* synthetic */ ReadBookActivity this$0;

            /* JADX INFO: renamed from: io.legado.app.ui.book.read.ReadBookActivity$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ReadBookActivity.kt */
            public static final class C0200a extends f.c0.c.k implements f.c0.b.a<v> {
                public final /* synthetic */ ReadBookActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0200a(ReadBookActivity readBookActivity) {
                    super(0);
                    this.this$0 = readBookActivity;
                }

                @Override // f.c0.b.a
                public /* bridge */ /* synthetic */ v invoke() {
                    invoke2();
                    return v.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ReadBookActivity.super.finish();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ReadBookActivity readBookActivity) {
                super(1);
                this.this$0 = readBookActivity;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                f.c0.c.j.e(dialogInterface, "it");
                ReadBookViewModel readBookViewModelT0 = this.this$0.T0();
                C0200a c0200a = new C0200a(this.this$0);
                Objects.requireNonNull(readBookViewModelT0);
                BaseViewModel.a(readBookViewModelT0, null, null, new s0(null), 3, null).d(null, new t0(c0200a, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Book book) {
            super(1);
            this.$it = book;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
            f.c0.c.j.e(hVar, "$this$alert");
            String string = ReadBookActivity.this.getString(R.string.check_add_bookshelf, new Object[]{this.$it.getName()});
            f.c0.c.j.d(string, "getString(R.string.check_add_bookshelf, it.name)");
            hVar.h(string);
            hVar.m(new C0199a(ReadBookActivity.this));
            hVar.k(new b(ReadBookActivity.this));
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<String, v> {
        public final /* synthetic */ ActivityBookReadBinding $this_with;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ActivityBookReadBinding activityBookReadBinding) {
            super(1);
            this.$this_with = activityBookReadBinding;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            f.c0.c.j.e(str, "it");
            this.$this_with.f6485d.i();
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class c extends f.c0.c.k implements f.c0.b.l<String, v> {
        public final /* synthetic */ ActivityBookReadBinding $this_with;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ActivityBookReadBinding activityBookReadBinding) {
            super(1);
            this.$this_with = activityBookReadBinding;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            f.c0.c.j.e(str, "it");
            ReadView readView = this.$this_with.f6486e;
            readView.curPage.o();
            readView.prevPage.o();
            readView.nextPage.o();
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class d extends f.c0.c.k implements f.c0.b.l<Integer, v> {
        public final /* synthetic */ ActivityBookReadBinding $this_with;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ActivityBookReadBinding activityBookReadBinding) {
            super(1);
            this.$this_with = activityBookReadBinding;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            ReadView readView = this.$this_with.f6486e;
            PageView pageView = readView.curPage;
            pageView.battery = i2;
            BatteryView batteryView = pageView.tvBattery;
            if (batteryView != null) {
                batteryView.setBattery(i2);
            }
            pageView.p();
            PageView pageView2 = readView.prevPage;
            pageView2.battery = i2;
            BatteryView batteryView2 = pageView2.tvBattery;
            if (batteryView2 != null) {
                batteryView2.setBattery(i2);
            }
            pageView2.p();
            PageView pageView3 = readView.nextPage;
            pageView3.battery = i2;
            BatteryView batteryView3 = pageView3.tvBattery;
            if (batteryView3 != null) {
                batteryView3.setBattery(i2);
            }
            pageView3.p();
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class e extends f.c0.c.k implements f.c0.b.l<BookChapter, v> {
        public final /* synthetic */ ActivityBookReadBinding $this_with;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ActivityBookReadBinding activityBookReadBinding) {
            super(1);
            this.$this_with = activityBookReadBinding;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(BookChapter bookChapter) {
            invoke2(bookChapter);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BookChapter bookChapter) {
            f.c0.c.j.e(bookChapter, "it");
            ReadBookViewModel readBookViewModelT0 = ReadBookActivity.this.T0();
            int index = bookChapter.getIndex();
            e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
            ReadBookViewModel.l(readBookViewModelT0, index, e.a.a.f.s.k.f5682h, null, 4);
            ReadView readView = this.$this_with.f6486e;
            f.c0.c.j.d(readView, "readView");
            c.b.a.m.f.W5(readView, 0, false, 3, null);
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class f extends f.c0.c.k implements f.c0.b.l<Boolean, v> {
        public f() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Boolean bool) throws IllegalAccessException, InvocationTargetException {
            invoke(bool.booleanValue());
            return v.a;
        }

        public final void invoke(boolean z) throws IllegalAccessException, InvocationTargetException {
            if (z) {
                ReadBookActivity.this.f();
            } else {
                e.a.a.f.s.k.a.o(!BaseReadAloudService.f6929d);
            }
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class g extends f.c0.c.k implements f.c0.b.l<Boolean, v> {
        public final /* synthetic */ ActivityBookReadBinding $this_with;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ActivityBookReadBinding activityBookReadBinding) {
            super(1);
            this.$this_with = activityBookReadBinding;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return v.a;
        }

        public final void invoke(boolean z) {
            ReadBookActivity.this.l0();
            this.$this_with.f6486e.j();
            ReadView readView = this.$this_with.f6486e;
            Objects.requireNonNull(readView);
            e.a.a.g.d.i.s1.h.a.a.i();
            readView.curPage.n();
            readView.prevPage.n();
            readView.nextPage.n();
            if (z) {
                e.a.a.f.s.k.a.i(false, null);
                return;
            }
            ReadView readView2 = this.$this_with.f6486e;
            f.c0.c.j.d(readView2, "readView");
            c.b.a.m.f.W5(readView2, 0, false, 1, null);
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class h extends f.c0.c.k implements f.c0.b.l<Integer, v> {
        public final /* synthetic */ ActivityBookReadBinding $this_with;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ActivityBookReadBinding activityBookReadBinding) {
            super(1);
            this.$this_with = activityBookReadBinding;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            if (i2 == 0 || i2 == 3) {
                e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
                e.a.a.g.d.i.s1.g.b bVar = e.a.a.f.s.k.f5686l;
                if (bVar == null) {
                    return;
                }
                ActivityBookReadBinding activityBookReadBinding = this.$this_with;
                e.a.a.g.d.i.s1.g.e eVarD = bVar.d(bVar.a(e.a.a.f.s.k.f5682h));
                if (eVarD != null) {
                    eVarD.e();
                    ReadView readView = activityBookReadBinding.f6486e;
                    f.c0.c.j.d(readView, "readView");
                    c.b.a.m.f.W5(readView, 0, false, 1, null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class i extends f.c0.c.k implements f.c0.b.l<Integer, v> {

        /* JADX INFO: compiled from: ReadBookActivity.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookActivity$observeLiveBus$1$7$1", f = "ReadBookActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
            public final /* synthetic */ int $chapterStart;
            public int label;
            public final /* synthetic */ ReadBookActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(int i2, ReadBookActivity readBookActivity, f.z.d<? super a> dVar) {
                super(2, dVar);
                this.$chapterStart = i2;
                this.this$0 = readBookActivity;
            }

            @Override // f.z.j.a.a
            @NotNull
            public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                return new a(this.$chapterStart, this.this$0, dVar);
            }

            @Override // f.c0.b.p
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
                return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
                if (BaseReadAloudService.d()) {
                    e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
                    e.a.a.g.d.i.s1.g.b bVar = e.a.a.f.s.k.f5686l;
                    if (bVar != null) {
                        int i2 = this.$chapterStart;
                        ReadBookActivity readBookActivity = this.this$0;
                        int i3 = e.a.a.f.s.k.f5682h;
                        int i4 = i2 - i3;
                        e.a.a.g.d.i.s1.g.e eVarD = bVar.d(bVar.a(i3));
                        if (eVarD != null) {
                            eVarD.e();
                            Iterator<e.a.a.g.d.i.s1.g.d> it = eVarD.f5783d.iterator();
                            int i5 = 0;
                            int length = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                int i6 = i5 + 1;
                                e.a.a.g.d.i.s1.g.d next = it.next();
                                if (i4 <= length || i4 >= next.a.length() + length) {
                                    length += next.a.length();
                                    i5 = i6;
                                } else {
                                    int i7 = i5 - 1;
                                    if (i7 >= 0) {
                                        while (true) {
                                            int i8 = i7 - 1;
                                            if (f.h0.k.h(eVarD.f5783d.get(i7).a, "\n", false, 2)) {
                                                break;
                                            }
                                            eVarD.f5783d.get(i7).f5779g = true;
                                            if (i8 < 0) {
                                                break;
                                            }
                                            i7 = i8;
                                        }
                                    }
                                    int size = eVarD.f5783d.size();
                                    if (i5 < size) {
                                        while (true) {
                                            int i9 = i5 + 1;
                                            if (f.h0.k.h(eVarD.f5783d.get(i5).a, "\n", false, 2)) {
                                                eVarD.f5783d.get(i5).f5779g = true;
                                                break;
                                            }
                                            eVarD.f5783d.get(i5).f5779g = true;
                                            if (i9 >= size) {
                                                break;
                                            }
                                            i5 = i9;
                                        }
                                    }
                                }
                            }
                        }
                        c.b.a.m.f.V5(readBookActivity, 0, false, null, 7, null);
                    }
                }
                return v.a;
            }
        }

        public i() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Integer num) {
            invoke(num.intValue());
            return v.a;
        }

        public final void invoke(int i2) {
            ReadBookActivity readBookActivity = ReadBookActivity.this;
            k0 k0Var = k0.f6264c;
            c.b.a.m.f.L3(readBookActivity, k0.f6263b, null, new a(i2, readBookActivity, null), 2, null);
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class j extends f.c0.c.k implements f.c0.b.l<Boolean, v> {
        public j() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return v.a;
        }

        public final void invoke(boolean z) {
            ReadBookActivity readBookActivity = ReadBookActivity.this;
            int i2 = ReadBookActivity.f7136i;
            readBookActivity.d1();
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class k extends f.c0.c.k implements f.c0.b.l<Boolean, v> {
        public final /* synthetic */ ActivityBookReadBinding $this_with;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ActivityBookReadBinding activityBookReadBinding) {
            super(1);
            this.$this_with = activityBookReadBinding;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return v.a;
        }

        public final void invoke(boolean z) {
            this.$this_with.f6486e.getCurPage().binding.f6870f.setSelectAble(z);
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class l extends f.c0.c.k implements f.c0.b.l<BookProgress, v> {
        public l() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(BookProgress bookProgress) {
            invoke2(bookProgress);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BookProgress bookProgress) {
            f.c0.c.j.e(bookProgress, "progress");
            ReadBookActivity readBookActivity = ReadBookActivity.this;
            int i2 = ReadBookActivity.f7136i;
            Objects.requireNonNull(readBookActivity);
            ((e.a.a.e.a.i) c.b.a.m.f.j0(readBookActivity, Integer.valueOf(R.string.get_book_progress), null, new l0(bookProgress), 2)).p();
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class m extends f.c0.c.k implements f.c0.b.a<v> {
        public m() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ReadBookActivity.Y0(ReadBookActivity.this).f6486e.k();
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class n extends f.c0.c.k implements f.c0.b.p<DialogInterface, Integer, v> {
        public final /* synthetic */ ArrayList<String> $imgStyles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ArrayList<String> arrayList) {
            super(2);
            this.$imgStyles = arrayList;
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ v invoke(DialogInterface dialogInterface, Integer num) {
            invoke(dialogInterface, num.intValue());
            return v.a;
        }

        public final void invoke(@NotNull DialogInterface dialogInterface, int i2) {
            f.c0.c.j.e(dialogInterface, "$noName_0");
            e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
            Book book = e.a.a.f.s.k.f5677c;
            if (book != null) {
                book.setImageStyle(this.$imgStyles.get(i2));
            }
            kVar.i(false, null);
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookActivity$pageChanged$1", f = "ReadBookActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class o extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public int label;

        public o(f.z.d<? super o> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return ReadBookActivity.this.new o(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((o) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            ReadBookActivity.Y0(ReadBookActivity.this).f6485d.setSeekPage(e.a.a.f.s.k.a.h());
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class p implements BottomTipsDialog.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdsConfig f7140b;

        /* JADX INFO: compiled from: ReadBookActivity.kt */
        public static final class a implements RewardListener {
            public final /* synthetic */ ReadBookActivity a;

            public a(ReadBookActivity readBookActivity) {
                this.a = readBookActivity;
            }

            @Override // com.ifmvo.togetherad.core.listener.RewardListener
            public void onAdClicked(@NotNull String str) {
                f.c0.c.j.e(str, "providerType");
                // AD REMOVED: MobclickAgent.onEvent(this.a, "rewardAdsClick");
            }

            @Override // com.ifmvo.togetherad.core.listener.RewardListener
            public void onAdClose(@NotNull String str) {
                f.c0.c.j.e(str, "providerType");
            }

            @Override // com.ifmvo.togetherad.core.listener.RewardListener
            public void onAdExpose(@NotNull String str) {
                f.c0.c.j.e(str, "providerType");
                // AD REMOVED: MobclickAgent.onEvent(this.a, "rewardAdsExpose");
            }

            @Override // com.ifmvo.togetherad.core.listener.BaseListener
            public void onAdFailed(@NotNull String str, @Nullable String str2) {
                f.c0.c.j.e(str, "providerType");
                // AD REMOVED: MobclickAgent.onEvent(this.a, "rewardAdsFaild");
                // AD REMOVED: MobclickAgent.onEvent(this.a, "rewardAdsFaildMsg", str + Attributes.InternalPrefix + ((Object) str2));
            }

            @Override // com.ifmvo.togetherad.core.listener.BaseListener
            public void onAdFailedAll(@Nullable String str) {
                // AD REMOVED: MobclickAgent.onEvent(this.a, "rewardAdsFaildAll");
                // AD REMOVED: MobclickAgent.onEvent(this.a, "rewardAdsFaildMsg", str);
                this.a.readStartTime = System.currentTimeMillis();
                c.b.a.m.f.q4(this.a, "rewardAdsTime", 0L);
            }

            @Override // com.ifmvo.togetherad.core.listener.RewardListener
            public void onAdLoaded(@NotNull String str) {
                f.c0.c.j.e(str, "providerType");
                AdHelperReward adHelperReward = this.a.adHelperReward;
                if (adHelperReward != null) {
                    adHelperReward.show();
                } else {
                    f.c0.c.j.m("adHelperReward");
                    throw null;
                }
            }

            @Override // com.ifmvo.togetherad.core.listener.RewardListener
            public void onAdRewardVerify(@NotNull String str) {
                f.c0.c.j.e(str, "providerType");
                this.a.readStartTime = System.currentTimeMillis();
                c.b.a.m.f.q4(this.a, "rewardAdsTime", 0L);
            }

            @Override // com.ifmvo.togetherad.core.listener.RewardListener
            public void onAdShow(@NotNull String str) {
                f.c0.c.j.e(str, "providerType");
                // AD REMOVED: MobclickAgent.onEvent(this.a, "rewardAdsShow");
            }

            @Override // com.ifmvo.togetherad.core.listener.BaseListener
            public void onAdStartRequest(@NotNull String str) {
                f.c0.c.j.e(str, "providerType");
            }

            @Override // com.ifmvo.togetherad.core.listener.RewardListener
            public void onAdVideoCached(@NotNull String str) {
                f.c0.c.j.e(str, "providerType");
            }

            @Override // com.ifmvo.togetherad.core.listener.RewardListener
            public void onAdVideoComplete(@NotNull String str) {
                f.c0.c.j.e(str, "providerType");
            }
        }

        public p(AdsConfig adsConfig) {
            this.f7140b = adsConfig;
        }

        @Override // io.legado.app.ui.widget.dialog.BottomTipsDialog.b
        public void a() {
            AdHelperReward adHelperReward = new AdHelperReward(ReadBookActivity.this, "ad_reward", this.f7140b.getRewardWeight(), new a(ReadBookActivity.this));
            ReadBookActivity.this.adHelperReward = adHelperReward;
            adHelperReward.load();
        }

        @Override // io.legado.app.ui.widget.dialog.BottomTipsDialog.b
        public void b() {
            if (this.f7140b.getMustReward()) {
                FrameLayout frameLayout = ReadBookActivity.Y0(ReadBookActivity.this).a;
                final ReadBookActivity readBookActivity = ReadBookActivity.this;
                frameLayout.postDelayed(new Runnable() { // from class: e.a.a.g.d.i.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReadBookActivity readBookActivity2 = readBookActivity;
                        f.c0.c.j.e(readBookActivity2, "this$0");
                        readBookActivity2.finish();
                    }
                }, 500L);
            } else {
                ReadBookActivity.this.readStartTime = System.currentTimeMillis();
                c.b.a.m.f.q4(ReadBookActivity.this, "rewardAdsTime", 0L);
            }
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    public static final class q extends f.c0.c.k implements f.c0.b.a<TextActionMenu> {
        public q() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final TextActionMenu invoke() {
            ReadBookActivity readBookActivity = ReadBookActivity.this;
            return new TextActionMenu(readBookActivity, readBookActivity);
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookActivity$upContent$1", f = "ReadBookActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class r extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ int $relativePosition;
        public final /* synthetic */ boolean $resetPageOffset;
        public final /* synthetic */ f.c0.b.a<v> $success;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(int i2, boolean z, f.c0.b.a<v> aVar, f.z.d<? super r> dVar) {
            super(2, dVar);
            this.$relativePosition = i2;
            this.$resetPageOffset = z;
            this.$success = aVar;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return ReadBookActivity.this.new r(this.$relativePosition, this.$resetPageOffset, this.$success, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((r) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            ReadBookActivity readBookActivity = ReadBookActivity.this;
            readBookActivity.autoPageProgress = 0;
            ReadBookActivity.Y0(readBookActivity).f6486e.b(this.$relativePosition, this.$resetPageOffset);
            ReadBookActivity.Y0(ReadBookActivity.this).f6485d.setSeekPage(e.a.a.f.s.k.a.h());
            Objects.requireNonNull(ReadBookActivity.this);
            f.c0.b.a<v> aVar = this.$success;
            if (aVar != null) {
                aVar.invoke();
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookActivity$upPageAnim$1", f = "ReadBookActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class s extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public int label;

        public s(f.z.d<? super s> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return ReadBookActivity.this.new s(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((s) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            ReadBookActivity.Y0(ReadBookActivity.this).f6486e.k();
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookActivity$upView$1", f = "ReadBookActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class t extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
        public int label;

        public t(f.z.d<? super t> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return ReadBookActivity.this.new t(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((t) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            BookSource bookSource;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            ReadMenu readMenu = ReadBookActivity.Y0(ReadBookActivity.this).f6485d;
            AccentBgTextView accentBgTextView = readMenu.binding.I;
            f.c0.c.j.d(accentBgTextView, "binding.tvLogin");
            e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
            WebBook webBook = e.a.a.f.s.k.o;
            v vVar = null;
            String loginUrl = (webBook == null || (bookSource = webBook.getBookSource()) == null) ? null : bookSource.getLoginUrl();
            accentBgTextView.setVisibility(loginUrl == null || loginUrl.length() == 0 ? 8 : 0);
            e.a.a.g.d.i.s1.g.b bVar = e.a.a.f.s.k.f5686l;
            if (bVar != null) {
                readMenu.binding.F.setText(bVar.f5766b);
                TextView textView = readMenu.binding.F;
                f.c0.c.j.d(textView, "binding.tvChapterName");
                c.b.a.m.f.c6(textView);
                if (e.a.a.f.s.k.f5683i) {
                    TextView textView2 = readMenu.binding.G;
                    f.c0.c.j.d(textView2, "binding.tvChapterUrl");
                    c.b.a.m.f.e3(textView2);
                } else {
                    readMenu.binding.G.setText(bVar.f5767c);
                    TextView textView3 = readMenu.binding.G;
                    f.c0.c.j.d(textView3, "binding.tvChapterUrl");
                    c.b.a.m.f.c6(textView3);
                }
                readMenu.binding.A.setMax(bVar.b() - 1);
                readMenu.binding.A.setProgress(kVar.h());
                readMenu.binding.L.setEnabled(e.a.a.f.s.k.f5681g != 0);
                readMenu.binding.K.setEnabled(e.a.a.f.s.k.f5681g != e.a.a.f.s.k.f5680f - 1);
                vVar = v.a;
            }
            if (vVar == null) {
                TextView textView4 = readMenu.binding.F;
                f.c0.c.j.d(textView4, "binding.tvChapterName");
                c.b.a.m.f.e3(textView4);
                TextView textView5 = readMenu.binding.G;
                f.c0.c.j.d(textView5, "binding.tvChapterUrl");
                c.b.a.m.f.e3(textView5);
            }
            return v.a;
        }
    }

    public ReadBookActivity() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new TocActivityResult(), new ActivityResultCallback() { // from class: e.a.a.g.d.i.d
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ReadBookActivity readBookActivity = this.a;
                f.g gVar = (f.g) obj;
                int i2 = ReadBookActivity.f7136i;
                f.c0.c.j.e(readBookActivity, "this$0");
                if (gVar == null) {
                    return;
                }
                ReadBookViewModel.l(readBookActivity.T0(), ((Number) gVar.getFirst()).intValue(), ((Number) gVar.getSecond()).intValue(), null, 4);
            }
        });
        f.c0.c.j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(TocActivityResult()) {\n            it?.let {\n                viewModel.openChapter(it.first, it.second)\n            }\n        }");
        this.tocActivity = activityResultLauncherRegisterForActivityResult;
        f.c0.c.j.d(registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.a.a.g.d.i.f
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ReadBookActivity readBookActivity = this.a;
                ActivityResult activityResult = (ActivityResult) obj;
                int i2 = ReadBookActivity.f7136i;
                f.c0.c.j.e(readBookActivity, "this$0");
                if (activityResult != null && activityResult.getResultCode() == -1) {
                    ReadBookViewModel readBookViewModelT0 = readBookActivity.T0();
                    k0 k0Var = new k0(readBookActivity);
                    Objects.requireNonNull(readBookViewModelT0);
                    BaseViewModel.a(readBookViewModelT0, null, null, new y0(null), 3, null).d(null, new z0(k0Var, null));
                }
            }
        }), "registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {\n            it ?: return@registerForActivityResult\n            if (it.resultCode == RESULT_OK) {\n                viewModel.upBookSource {\n                    upView()\n                }\n            }\n        }");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.a.a.g.d.i.h
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ReadBookActivity readBookActivity = this.a;
                ActivityResult activityResult = (ActivityResult) obj;
                int i2 = ReadBookActivity.f7136i;
                f.c0.c.j.e(readBookActivity, "this$0");
                if (activityResult != null && activityResult.getResultCode() == -1) {
                    ReadBookViewModel readBookViewModelT0 = readBookActivity.T0();
                    Objects.requireNonNull(readBookViewModelT0);
                    BaseViewModel.a(readBookViewModelT0, null, null, new u0(null), 3, null);
                }
            }
        });
        f.c0.c.j.d(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {\n            it ?: return@registerForActivityResult\n            if (it.resultCode == RESULT_OK) {\n                viewModel.replaceRuleChanged()\n            }\n        }");
        this.replaceActivity = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.a.a.g.d.i.e
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intent data;
                ReadBookActivity readBookActivity = this.a;
                ActivityResult activityResult = (ActivityResult) obj;
                int i2 = ReadBookActivity.f7136i;
                f.c0.c.j.e(readBookActivity, "this$0");
                if (activityResult == null || (data = activityResult.getData()) == null) {
                    return;
                }
                e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
                int intExtra = data.getIntExtra("index", e.a.a.f.s.k.f5681g);
                ReadBookViewModel readBookViewModelT0 = readBookActivity.T0();
                String stringExtra = data.getStringExtra(MediaConstants.MEDIA_URI_QUERY_QUERY);
                if (stringExtra == null) {
                    stringExtra = "";
                }
                Objects.requireNonNull(readBookViewModelT0);
                f.c0.c.j.e(stringExtra, "<set-?>");
                readBookViewModelT0.searchContentQuery = stringExtra;
                ReadBookViewModel.l(readBookActivity.T0(), intExtra, 0, new j0(data.getIntExtra("indexWithinChapter", 0), readBookActivity), 2);
            }
        });
        f.c0.c.j.d(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {\n            it ?: return@registerForActivityResult\n            it.data?.let { data ->\n                data.getIntExtra(\"index\", ReadBook.durChapterIndex).let { index ->\n                    viewModel.searchContentQuery = data.getStringExtra(\"query\") ?: \"\"\n                    val indexWithinChapter = data.getIntExtra(\"indexWithinChapter\", 0)\n                    skipToSearch(index, indexWithinChapter)\n                }\n            }\n        }");
        this.searchContentActivity = activityResultLauncherRegisterForActivityResult3;
        this.textActionMenu = c.b.a.m.f.N3(new q());
        this.mHandler = new Handler(Looper.getMainLooper());
        this.keepScreenRunnable = new Runnable() { // from class: e.a.a.g.d.i.a
            @Override // java.lang.Runnable
            public final void run() {
                ReadBookActivity readBookActivity = this.a;
                int i2 = ReadBookActivity.f7136i;
                f.c0.c.j.e(readBookActivity, "this$0");
                Window window = readBookActivity.getWindow();
                f.c0.c.j.d(window, "window");
                readBookActivity.U0(window, false);
            }
        };
        this.autoPageRunnable = new Runnable() { // from class: e.a.a.g.d.i.g
            @Override // java.lang.Runnable
            public final void run() {
                ReadBookActivity readBookActivity = this.a;
                int i2 = ReadBookActivity.f7136i;
                f.c0.c.j.e(readBookActivity, "this$0");
                readBookActivity.Z0();
            }
        };
        this.backupRunnable = new Runnable() { // from class: e.a.a.g.d.i.b
            @Override // java.lang.Runnable
            public final void run() {
                ReadBookActivity readBookActivity = this.a;
                int i2 = ReadBookActivity.f7136i;
                f.c0.c.j.e(readBookActivity, "this$0");
                e.a.a.f.s.k.w(e.a.a.f.s.k.a, false, 1);
                e.a.a.d.w.i.a.c(readBookActivity);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivityBookReadBinding Y0(ReadBookActivity readBookActivity) {
        return (ActivityBookReadBinding) readBookActivity.K0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.page.ContentTextView.a
    public boolean A() {
        return ((ActivityBookReadBinding) K0()).f6486e.isScroll;
    }

    @Override // e.a.a.f.s.k.a
    public void A0() {
        b1();
        this.autoPageProgress = 0;
        c.b.a.m.f.L3(this, null, null, new o(null), 3, null);
        this.mHandler.postDelayed(this.backupRunnable, TTAdConstant.AD_MAX_EVENT_TIME);
    }

    @Override // io.legado.app.ui.book.read.page.ReadView.a
    public void B0() {
        int i2;
        long j2 = this.screenTimeOut;
        if (j2 < 0) {
            Window window = getWindow();
            f.c0.c.j.d(window, "window");
            U0(window, true);
            return;
        }
        f.c0.c.j.e(this, "<this>");
        try {
            i2 = Settings.System.getInt(getContentResolver(), "screen_off_timeout");
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (j2 - ((long) i2) <= 0) {
            Window window2 = getWindow();
            f.c0.c.j.d(window2, "window");
            U0(window2, false);
        } else {
            this.mHandler.removeCallbacks(this.keepScreenRunnable);
            Window window3 = getWindow();
            f.c0.c.j.d(window3, "window");
            U0(window3, true);
            this.mHandler.postDelayed(this.keepScreenRunnable, this.screenTimeOut);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.page.ReadView.a
    public void C() {
        if (BaseReadAloudService.f6927b) {
            ReadAloudDialog readAloudDialog = new ReadAloudDialog();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
            readAloudDialog.show(supportFragmentManager, "readAloud");
            return;
        }
        if (!this.isAutoPage) {
            ((ActivityBookReadBinding) K0()).f6485d.g();
            return;
        }
        AutoReadDialog autoReadDialog = new AutoReadDialog();
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        f.c0.c.j.d(supportFragmentManager2, "supportFragmentManager");
        autoReadDialog.show(supportFragmentManager2, "autoRead");
    }

    @Override // e.a.a.f.s.k.a
    public void D() {
        c.b.a.m.f.L3(this, null, null, new s(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.page.ContentTextView.a
    public void E(float x, float y) {
        ActivityBookReadBinding activityBookReadBinding = (ActivityBookReadBinding) K0();
        activityBookReadBinding.f6484c.setX(x);
        activityBookReadBinding.f6484c.setY(y);
        ImageView imageView = activityBookReadBinding.f6484c;
        f.c0.c.j.d(imageView, "cursorRight");
        c.b.a.m.f.d6(imageView, true);
    }

    @Override // e.a.a.f.s.k.a
    public void F0() throws IllegalAccessException, InvocationTargetException {
        if (getIntent().getBooleanExtra("readAloud", false)) {
            getIntent().removeExtra("readAloud");
            e.a.a.f.s.k.a.o(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.page.ContentTextView.a
    @NotNull
    public e.a.a.g.d.i.s1.h.c H() {
        return ((ActivityBookReadBinding) K0()).f6486e.getPageFactory();
    }

    @Override // io.legado.app.ui.book.read.config.TocRegexDialog.a
    public void H0(@NotNull String tocRegex) {
        f.c0.c.j.e(tocRegex, "tocRegex");
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        Book book = e.a.a.f.s.k.f5677c;
        if (book == null) {
            return;
        }
        book.setTocUrl(tocRegex);
        ReadBookViewModel.k(T0(), book, null, 2);
    }

    @Override // io.legado.app.ui.book.read.ReadMenu.a
    public void J() throws IOException {
        InputStream inputStreamOpen = getAssets().open("help/readMenuHelp.md");
        f.c0.c.j.d(inputStreamOpen, "assets.open(\"help/readMenuHelp.md\")");
        String str = new String(c.b.a.m.f.w4(inputStreamOpen), f.h0.a.a);
        TextDialog.Companion aVar = TextDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
        TextDialog.Companion.a(aVar, supportFragmentManager, str, 1, 0L, false, 24);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.TextActionMenu.a
    public void M() {
        ActivityBookReadBinding activityBookReadBinding = (ActivityBookReadBinding) K0();
        a1().dismiss();
        activityBookReadBinding.f6486e.getCurPage().a();
        activityBookReadBinding.f6486e.setTextSelected(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.ReadMenu.a
    public void N() {
        e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
        e.a.a.f.s.j.f(this);
        if (this.isAutoPage) {
            i();
            return;
        }
        this.isAutoPage = true;
        ReadView readView = ((ActivityBookReadBinding) K0()).f6486e;
        f.c0.c.j.d(readView, "binding.readView");
        c.b.a.m.f.W5(readView, 0, false, 3, null);
        ReadView readView2 = ((ActivityBookReadBinding) K0()).f6486e;
        f.c0.c.j.d(readView2, "binding.readView");
        c.b.a.m.f.W5(readView2, 1, false, 2, null);
        Z0();
        ((ActivityBookReadBinding) K0()).f6485d.setAutoPage(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void N0() {
        ActivityBookReadBinding activityBookReadBinding = (ActivityBookReadBinding) K0();
        String[] strArr = {"timeChanged"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$1 = new EventBusExtensionsKt$observeEvent$o$1(new c(activityBookReadBinding));
        for (int i2 = 0; i2 < 1; i2++) {
            Observable observable = LiveEventBus.get(strArr[i2], String.class);
            f.c0.c.j.d(observable, "get(tag, EVENT::class.java)");
            observable.observe(this, eventBusExtensionsKt$observeEvent$o$1);
        }
        String[] strArr2 = {"batteryChanged"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$12 = new EventBusExtensionsKt$observeEvent$o$1(new d(activityBookReadBinding));
        for (int i3 = 0; i3 < 1; i3++) {
            Observable observable2 = LiveEventBus.get(strArr2[i3], Integer.class);
            f.c0.c.j.d(observable2, "get(tag, EVENT::class.java)");
            observable2.observe(this, eventBusExtensionsKt$observeEvent$o$12);
        }
        String[] strArr3 = {"openChapter"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$13 = new EventBusExtensionsKt$observeEvent$o$1(new e(activityBookReadBinding));
        for (int i4 = 0; i4 < 1; i4++) {
            Observable observable3 = LiveEventBus.get(strArr3[i4], BookChapter.class);
            f.c0.c.j.d(observable3, "get(tag, EVENT::class.java)");
            observable3.observe(this, eventBusExtensionsKt$observeEvent$o$13);
        }
        String[] strArr4 = {"mediaButton"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$14 = new EventBusExtensionsKt$observeEvent$o$1(new f());
        for (int i5 = 0; i5 < 1; i5++) {
            Observable observable4 = LiveEventBus.get(strArr4[i5], Boolean.class);
            f.c0.c.j.d(observable4, "get(tag, EVENT::class.java)");
            observable4.observe(this, eventBusExtensionsKt$observeEvent$o$14);
        }
        String[] strArr5 = {"upConfig"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$15 = new EventBusExtensionsKt$observeEvent$o$1(new g(activityBookReadBinding));
        for (int i6 = 0; i6 < 1; i6++) {
            Observable observable5 = LiveEventBus.get(strArr5[i6], Boolean.class);
            f.c0.c.j.d(observable5, "get(tag, EVENT::class.java)");
            observable5.observe(this, eventBusExtensionsKt$observeEvent$o$15);
        }
        String[] strArr6 = {"aloud_state"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$16 = new EventBusExtensionsKt$observeEvent$o$1(new h(activityBookReadBinding));
        for (int i7 = 0; i7 < 1; i7++) {
            Observable observable6 = LiveEventBus.get(strArr6[i7], Integer.class);
            f.c0.c.j.d(observable6, "get(tag, EVENT::class.java)");
            observable6.observe(this, eventBusExtensionsKt$observeEvent$o$16);
        }
        String[] strArr7 = {"ttsStart"};
        EventBusExtensionsKt$observeEventSticky$o$1 eventBusExtensionsKt$observeEventSticky$o$1 = new EventBusExtensionsKt$observeEventSticky$o$1(new i());
        for (int i8 = 0; i8 < 1; i8++) {
            Observable observable7 = LiveEventBus.get(strArr7[i8], Integer.class);
            f.c0.c.j.d(observable7, "get(tag, EVENT::class.java)");
            observable7.observeSticky(this, eventBusExtensionsKt$observeEventSticky$o$1);
        }
        String[] strArr8 = {"keep_light"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$17 = new EventBusExtensionsKt$observeEvent$o$1(new j());
        for (int i9 = 0; i9 < 1; i9++) {
            Observable observable8 = LiveEventBus.get(strArr8[i9], Boolean.class);
            f.c0.c.j.d(observable8, "get(tag, EVENT::class.java)");
            observable8.observe(this, eventBusExtensionsKt$observeEvent$o$17);
        }
        String[] strArr9 = {"selectText"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$18 = new EventBusExtensionsKt$observeEvent$o$1(new k(activityBookReadBinding));
        for (int i10 = 0; i10 < 1; i10++) {
            Observable observable9 = LiveEventBus.get(strArr9[i10], Boolean.class);
            f.c0.c.j.d(observable9, "get(tag, EVENT::class.java)");
            observable9.observe(this, eventBusExtensionsKt$observeEvent$o$18);
        }
        String[] strArr10 = {"showBrightnessView"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$19 = new EventBusExtensionsKt$observeEvent$o$1(new b(activityBookReadBinding));
        for (int i11 = 0; i11 < 1; i11++) {
            Observable observable10 = LiveEventBus.get(strArr10[i11], String.class);
            f.c0.c.j.d(observable10, "get(tag, EVENT::class.java)");
            observable10.observe(this, eventBusExtensionsKt$observeEvent$o$19);
        }
    }

    @Override // e.a.a.f.s.k.a
    public void O(@NotNull Book book) {
        f.c0.c.j.e(book, "book");
        e.a.a.f.s.k.a.u(getString(R.string.toc_updateing));
        ReadBookViewModel.k(T0(), book, null, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.ReadBookBaseActivity, io.legado.app.base.BaseActivity
    @SuppressLint({"ClickableViewAccessibility"})
    public void O0(@Nullable Bundle savedInstanceState) {
        super.O0(savedInstanceState);
        ((ActivityBookReadBinding) K0()).f6483b.setColorFilter(c.b.a.m.f.M1(this));
        ((ActivityBookReadBinding) K0()).f6484c.setColorFilter(c.b.a.m.f.M1(this));
        ((ActivityBookReadBinding) K0()).f6483b.setOnTouchListener(this);
        ((ActivityBookReadBinding) K0()).f6484c.setOnTouchListener(this);
        this.readStartTime = System.currentTimeMillis();
        b1();
        d1();
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        e.a.a.f.s.k.f5684j = this;
        e.a.a.f.s.k.f5676b.observe(this, new Observer() { // from class: e.a.a.g.d.i.c
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ReadBookActivity readBookActivity = this.a;
                String str = (String) obj;
                int i2 = ReadBookActivity.f7136i;
                f.c0.c.j.e(readBookActivity, "this$0");
                ReadMenu readMenu = ((ActivityBookReadBinding) readBookActivity.K0()).f6485d;
                f.c0.c.j.d(str, "it");
                readMenu.setTitle(str);
                readBookActivity.c1();
                readBookActivity.w0();
            }
        });
        ReadBookViewModel readBookViewModelT0 = T0();
        Intent intent = getIntent();
        f.c0.c.j.d(intent, "intent");
        Objects.requireNonNull(readBookViewModelT0);
        f.c0.c.j.e(intent, "intent");
        e.a.a.d.u.b.c(BaseViewModel.a(readBookViewModelT0, null, null, new p0(intent, readBookViewModelT0, null), 3, null), null, new q0(null), 1);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        f.c0.c.j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.book_read, menu);
        return super.P0(menu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        f.c0.c.j.e(item, "item");
        String string = null;
        switch (item.getItemId()) {
            case R.id.menu_add_bookmark /* 2131296780 */:
                e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
                Book book = e.a.a.f.s.k.f5677c;
                e.a.a.g.d.i.s1.g.b bVar = e.a.a.f.s.k.f5686l;
                e.a.a.g.d.i.s1.g.e eVarD = bVar != null ? bVar.d(kVar.h()) : null;
                if (book != null && eVarD != null) {
                    String bookUrl = book.getBookUrl();
                    String name = book.getName();
                    int i2 = e.a.a.f.s.k.f5681g;
                    int i3 = e.a.a.f.s.k.f5682h;
                    String str = eVarD.f5782c;
                    String str2 = eVarD.f5781b;
                    Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
                    W0(new Bookmark(0L, bookUrl, name, null, i2, i3, str, f.h0.k.R(str2).toString(), null, 265, null));
                }
                break;
            case R.id.menu_book_info /* 2131296789 */:
                e.a.a.f.s.k kVar2 = e.a.a.f.s.k.a;
                Book book2 = e.a.a.f.s.k.f5677c;
                if (book2 != null) {
                    Intent intent = new Intent(this, (Class<?>) BookInfoActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("name", book2.getName());
                    intent.putExtra("author", book2.getAuthor());
                    startActivity(intent);
                }
                break;
            case R.id.menu_change_source /* 2131296797 */:
                ReadMenu readMenu = ((ActivityBookReadBinding) K0()).f6485d;
                f.c0.c.j.d(readMenu, "binding.readMenu");
                int i4 = ReadMenu.a;
                readMenu.h(null);
                e.a.a.f.s.k kVar3 = e.a.a.f.s.k.a;
                Book book3 = e.a.a.f.s.k.f5677c;
                if (book3 != null) {
                    ChangeSourceDialog.Companion bVar2 = ChangeSourceDialog.INSTANCE;
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
                    bVar2.a(supportFragmentManager, book3.getName(), book3.getAuthor());
                }
                break;
            case R.id.menu_copy_text /* 2131296806 */:
                TextDialog.Companion aVar = TextDialog.INSTANCE;
                FragmentManager supportFragmentManager2 = getSupportFragmentManager();
                f.c0.c.j.d(supportFragmentManager2, "supportFragmentManager");
                e.a.a.f.s.k kVar4 = e.a.a.f.s.k.a;
                e.a.a.g.d.i.s1.g.b bVar3 = e.a.a.f.s.k.f5686l;
                if (bVar3 != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<T> it = bVar3.f5768d.iterator();
                    while (it.hasNext()) {
                        sb.append(((e.a.a.g.d.i.s1.g.e) it.next()).f5781b);
                    }
                    string = sb.toString();
                    f.c0.c.j.d(string, "stringBuilder.toString()");
                }
                TextDialog.Companion.a(aVar, supportFragmentManager2, string, 0, 0L, false, 28);
                break;
            case R.id.menu_download /* 2131296817 */:
                AdsConfig adsConfigC = e.a.a.d.w.c.c(this);
                if (adsConfigC.getEnableAds() && adsConfigC.getEnableCache() && e.a.a.d.w.c.a(adsConfigC)) {
                    if (this.adHelperInter == null) {
                        this.adHelperInter = new AdHelperInter(this, "ad_inter", adsConfigC.getCacheWeight(), new i0(this));
                    }
                    AdHelperInter adHelperInter = this.adHelperInter;
                    if (adHelperInter != null) {
                        adHelperInter.load();
                    }
                }
                // AD REMOVED: MobclickAgent.onEvent(this, "cacheCount");
                e.a.a.f.s.k kVar5 = e.a.a.f.s.k.a;
                Book book4 = e.a.a.f.s.k.f5677c;
                if (book4 != null) {
                    ((e.a.a.e.a.i) c.b.a.m.f.j0(this, Integer.valueOf(R.string.offline_cache), null, new n0(this, book4), 2)).p();
                }
                break;
            case R.id.menu_enable_replace /* 2131296821 */:
                e.a.a.f.s.k kVar6 = e.a.a.f.s.k.a;
                Book book5 = e.a.a.f.s.k.f5677c;
                if (book5 != null) {
                    book5.setUseReplaceRule(!book5.getUseReplaceRule());
                    Menu menu = this.menu;
                    MenuItem menuItemFindItem = menu == null ? null : menu.findItem(R.id.menu_enable_replace);
                    if (menuItemFindItem != null) {
                        menuItemFindItem.setChecked(book5.getUseReplaceRule());
                    }
                    ReadBookViewModel readBookViewModelT0 = T0();
                    Objects.requireNonNull(readBookViewModelT0);
                    BaseViewModel.a(readBookViewModelT0, null, null, new u0(null), 3, null);
                }
                break;
            case R.id.menu_get_progress /* 2131296832 */:
                e.a.a.f.s.k kVar7 = e.a.a.f.s.k.a;
                Book book6 = e.a.a.f.s.k.f5677c;
                if (book6 != null) {
                    ReadBookViewModel.n(T0(), book6, false, new l(), 2);
                }
                break;
            case R.id.menu_image_style /* 2131296841 */:
                ArrayList arrayListA = f.x.e.a(Book.imgStyleDefault, Book.imgStyleFull, "TEXT");
                c.b.a.m.f.a5(this, Integer.valueOf(R.string.image_style), arrayListA, new n(arrayListA));
                break;
            case R.id.menu_page_anim /* 2131296857 */:
                m mVar = new m();
                f.c0.c.j.e(mVar, "success");
                ArrayList arrayList = new ArrayList();
                arrayList.add(getString(R.string.btn_default_s));
                arrayList.add(getString(R.string.page_anim_cover));
                arrayList.add(getString(R.string.page_anim_slide));
                arrayList.add(getString(R.string.page_anim_simulation));
                arrayList.add(getString(R.string.page_anim_scroll));
                arrayList.add(getString(R.string.page_anim_none));
                c.b.a.m.f.a5(this, Integer.valueOf(R.string.page_anim), arrayList, new o0(mVar));
                break;
            case R.id.menu_re_segment /* 2131296861 */:
                e.a.a.f.s.k kVar8 = e.a.a.f.s.k.a;
                Book book7 = e.a.a.f.s.k.f5677c;
                if (book7 != null) {
                    book7.setReSegment(!book7.getReSegment());
                    Menu menu2 = this.menu;
                    MenuItem menuItemFindItem2 = menu2 == null ? null : menu2.findItem(R.id.menu_re_segment);
                    if (menuItemFindItem2 != null) {
                        menuItemFindItem2.setChecked(book7.getReSegment());
                    }
                    kVar8.i(false, null);
                }
                break;
            case R.id.menu_refresh /* 2131296862 */:
                e.a.a.f.s.k kVar9 = e.a.a.f.s.k.a;
                if (e.a.a.f.s.k.n != null) {
                    Book book8 = e.a.a.f.s.k.f5677c;
                    if (book8 != null) {
                        e.a.a.f.s.k.f5686l = null;
                        ReadView readView = ((ActivityBookReadBinding) K0()).f6486e;
                        f.c0.c.j.d(readView, "binding.readView");
                        c.b.a.m.f.W5(readView, 0, false, 3, null);
                        T0().m(book8);
                    }
                } else {
                    c.b.a.m.f.V5(this, 0, false, null, 7, null);
                }
                break;
            case R.id.menu_reverse_content /* 2131296865 */:
                e.a.a.f.s.k kVar10 = e.a.a.f.s.k.a;
                Book book9 = e.a.a.f.s.k.f5677c;
                if (book9 != null) {
                    ReadBookViewModel readBookViewModelT02 = T0();
                    Objects.requireNonNull(readBookViewModelT02);
                    f.c0.c.j.e(book9, "book");
                    BaseViewModel.a(readBookViewModelT02, null, null, new v0(book9, null), 3, null);
                }
                break;
            case R.id.menu_set_charset /* 2131296878 */:
                ((e.a.a.e.a.i) c.b.a.m.f.j0(this, Integer.valueOf(R.string.set_charset), null, new m0(this), 2)).p();
                break;
            case R.id.menu_toc_regex /* 2131296894 */:
                TocRegexDialog.Companion bVar4 = TocRegexDialog.INSTANCE;
                FragmentManager supportFragmentManager3 = getSupportFragmentManager();
                f.c0.c.j.d(supportFragmentManager3, "supportFragmentManager");
                e.a.a.f.s.k kVar11 = e.a.a.f.s.k.a;
                Book book10 = e.a.a.f.s.k.f5677c;
                String tocUrl = book10 != null ? book10.getTocUrl() : null;
                Objects.requireNonNull(bVar4);
                f.c0.c.j.e(supportFragmentManager3, "fragmentManager");
                TocRegexDialog tocRegexDialog = new TocRegexDialog();
                Bundle bundle = new Bundle();
                bundle.putString("tocRegex", tocUrl);
                tocRegexDialog.setArguments(bundle);
                tocRegexDialog.show(supportFragmentManager3, "tocRegexDialog");
                break;
            case R.id.menu_update_toc /* 2131296900 */:
                e.a.a.f.s.k kVar12 = e.a.a.f.s.k.a;
                Book book11 = e.a.a.f.s.k.f5677c;
                if (book11 != null) {
                    O(book11);
                }
                break;
        }
        return super.Q0(item);
    }

    @Override // io.legado.app.ui.book.read.ReadMenu.a
    public void S() {
        ReadAloudDialog readAloudDialog = new ReadAloudDialog();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
        readAloudDialog.show(supportFragmentManager, "readAloud");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.TextActionMenu.a
    @NotNull
    public String U() {
        return ((ActivityBookReadBinding) K0()).f6486e.getCurPage().getSelectedText();
    }

    @Override // io.legado.app.ui.book.changesource.ChangeSourceDialog.a
    public void V(@NotNull Book book) {
        f.c0.c.j.e(book, "book");
        T0().h(book);
    }

    @Override // io.legado.app.ui.book.read.ReadMenu.a
    public void W() {
        this.replaceActivity.launch(new Intent(this, (Class<?>) ReplaceRuleActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.page.ReadView.a
    public void Z() {
        ActivityBookReadBinding activityBookReadBinding = (ActivityBookReadBinding) K0();
        a1().getContentView().measure(0, 0);
        int measuredHeight = a1().getContentView().getMeasuredHeight();
        int x = (int) activityBookReadBinding.f6487f.getX();
        int y = ((int) activityBookReadBinding.f6487f.getY()) - measuredHeight;
        if (y < c.b.a.m.f.X2(this)) {
            y = (int) (activityBookReadBinding.f6483b.getY() + activityBookReadBinding.f6483b.getHeight());
        }
        if (activityBookReadBinding.f6484c.getY() > y && activityBookReadBinding.f6484c.getY() < measuredHeight + y) {
            y = (int) (activityBookReadBinding.f6484c.getY() + activityBookReadBinding.f6484c.getHeight());
        }
        if (a1().isShowing()) {
            a1().update(x, y, -2, -2);
        } else {
            a1().showAtLocation(activityBookReadBinding.f6487f, 8388659, x, y);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z0() {
        int i2;
        long autoReadSpeed = (((long) ReadBookConfig.INSTANCE.getAutoReadSpeed()) * 1000) / ((long) ((ActivityBookReadBinding) K0()).f6486e.getHeight());
        if (autoReadSpeed < 20) {
            i2 = 20 / ((int) autoReadSpeed);
            autoReadSpeed = 20;
        } else {
            i2 = 1;
        }
        this.mHandler.removeCallbacks(this.autoPageRunnable);
        if (((ActivityBookReadBinding) K0()).f6486e.isScroll) {
            ((ActivityBookReadBinding) K0()).f6486e.getCurPage().binding.f6870f.d(-i2);
        } else {
            int i3 = this.autoPageProgress + i2;
            this.autoPageProgress = i3;
            if (i3 >= ((ActivityBookReadBinding) K0()).f6486e.getHeight()) {
                this.autoPageProgress = 0;
                if (!((ActivityBookReadBinding) K0()).f6486e.f(e.a.a.g.d.i.s1.g.a.NEXT)) {
                    i();
                }
            } else {
                ((ActivityBookReadBinding) K0()).f6486e.invalidate();
            }
        }
        this.mHandler.postDelayed(this.autoPageRunnable, autoReadSpeed);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.TextActionMenu.a
    public boolean a0(int itemId) throws IOException {
        String bookSourceUrl;
        String name;
        int i2 = 0;
        if (itemId != R.id.menu_bookmark) {
            if (itemId != R.id.menu_replace) {
                if (itemId != R.id.menu_search_content) {
                    return false;
                }
                ReadBookViewModel readBookViewModelT0 = T0();
                String strU = U();
                Objects.requireNonNull(readBookViewModelT0);
                f.c0.c.j.e(strU, "<set-?>");
                readBookViewModelT0.searchContentQuery = strU;
                k0(U());
                return true;
            }
            ArrayList arrayList = new ArrayList();
            e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
            Book book = e.a.a.f.s.k.f5677c;
            if (book != null && (name = book.getName()) != null) {
                arrayList.add(name);
            }
            BookSource bookSource = e.a.a.f.s.k.n;
            if (bookSource != null && (bookSourceUrl = bookSource.getBookSourceUrl()) != null) {
                arrayList.add(bookSourceUrl);
            }
            ActivityResultLauncher<Intent> activityResultLauncher = this.replaceActivity;
            String strU2 = U();
            String strQ = f.x.e.q(arrayList, ";", null, null, 0, null, null, 62);
            f.c0.c.j.e(this, com.umeng.analytics.pro.c.R);
            Intent intent = new Intent(this, (Class<?>) ReplaceEditActivity.class);
            intent.putExtra("id", -1L);
            intent.putExtra("pattern", strU2);
            intent.putExtra("isRegex", false);
            intent.putExtra("scope", strQ);
            activityResultLauncher.launch(intent);
            return true;
        }
        ContentTextView contentTextView = ((ActivityBookReadBinding) K0()).f6486e.getCurPage().binding.f6870f;
        e.a.a.g.d.i.s1.g.e eVarC = contentTextView.c(contentTextView.selectStart[0].intValue());
        Objects.requireNonNull(eVarC);
        e.a.a.f.s.k kVar2 = e.a.a.f.s.k.a;
        e.a.a.g.d.i.s1.g.b bVar = e.a.a.f.s.k.f5686l;
        Bookmark bookmark = null;
        if ((bVar == null || bVar.a != eVarC.f5786g) && (((bVar = e.a.a.f.s.k.m) == null || bVar.a != eVarC.f5786g) && ((bVar = e.a.a.f.s.k.f5685k) == null || bVar.a != eVarC.f5786g))) {
            bVar = null;
        }
        if (bVar != null) {
            int iC = bVar.c(eVarC.a);
            int iIntValue = contentTextView.selectStart[1].intValue();
            int iIntValue2 = contentTextView.selectStart[2].intValue();
            int iMin = Math.min(iIntValue, eVarC.c());
            if (iMin > 0) {
                int size = 0;
                while (true) {
                    int i3 = i2 + 1;
                    size += eVarC.f5783d.get(i2).f5774b.size();
                    if (i3 >= iMin) {
                        break;
                    }
                    i2 = i3;
                }
                i2 = size;
            }
            int i4 = i2 + iIntValue2 + iC;
            e.a.a.f.s.k kVar3 = e.a.a.f.s.k.a;
            Book book2 = e.a.a.f.s.k.f5677c;
            if (book2 != null) {
                bookmark = new Bookmark(0L, book2.getBookUrl(), book2.getName(), null, eVarC.f5786g, i4, bVar.f5766b, contentTextView.getSelectedText(), null, 265, null);
            }
        }
        if (bookmark == null) {
            c.b.a.m.f.Q5(this, R.string.create_bookmark_error);
        } else {
            W0(bookmark);
        }
        return true;
    }

    public final TextActionMenu a1() {
        return (TextActionMenu) this.textActionMenu.getValue();
    }

    public final void b1() {
        Object objM11constructorimpl;
        AdsConfig adsConfig;
        f.c0.c.j.e(this, com.umeng.analytics.pro.c.R);
        String strO2 = c.b.a.m.f.O2(this, "adsConfig", null, 2);
        if (strO2 == null) {
            adsConfig = new AdsConfig();
        } else {
            Gson gsonA = e.a.a.h.n.a();
            try {
                Type type = new c.a().getType();
                f.c0.c.j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(strO2, type);
                if (!(objFromJson instanceof AdsConfig)) {
                    objFromJson = null;
                }
                objM11constructorimpl = f.h.m11constructorimpl((AdsConfig) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            if (f.h.m16isFailureimpl(objM11constructorimpl)) {
                objM11constructorimpl = null;
            }
            adsConfig = (AdsConfig) objM11constructorimpl;
            if (adsConfig == null) {
                adsConfig = new AdsConfig();
            } else {
                adsConfig.getEnableAds();
            }
        }
        if (adsConfig.getEnableAds() && adsConfig.getEnableReward()) {
            f.c0.c.j.e(adsConfig, "adsConfig");
            long j2 = 1000;
            if (System.currentTimeMillis() - e.a.a.d.q.a.a() > adsConfig.getInstallRewardTime() * j2) {
                if ((System.currentTimeMillis() - this.readStartTime) + c.b.a.m.f.N2(this, "rewardAdsTime", 0L, 2) < adsConfig.getRewardTime() * j2) {
                    return;
                }
                BottomTipsDialog.Companion aVar = BottomTipsDialog.INSTANCE;
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
                String rewardContent = adsConfig.getRewardContent();
                p pVar = new p(adsConfig);
                Objects.requireNonNull(aVar);
                f.c0.c.j.e(supportFragmentManager, "fragmentManager");
                BottomTipsDialog bottomTipsDialog = new BottomTipsDialog();
                Bundle bundle = new Bundle();
                bundle.putString("content", rewardContent);
                bundle.putString("title", null);
                bundle.putLong("time", bottomTipsDialog.time);
                bottomTipsDialog.setArguments(bundle);
                bottomTipsDialog.setCancelable(false);
                bottomTipsDialog.callBack = pVar;
                bottomTipsDialog.showCancel = true;
                bottomTipsDialog.show(supportFragmentManager, "bottomTipsDialog");
            }
        }
    }

    @Override // io.legado.app.ui.book.read.ReadMenu.a, io.legado.app.ui.book.read.config.ReadAloudDialog.a, io.legado.app.ui.book.read.config.AutoReadDialog.a
    public void c() {
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        Book book = e.a.a.f.s.k.f5677c;
        if (book == null) {
            return;
        }
        this.tocActivity.launch(book.getBookUrl());
    }

    @Override // io.legado.app.ui.book.changesource.ChangeSourceDialog.a
    @Nullable
    /* JADX INFO: renamed from: c0 */
    public Book getOldbook() {
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        return e.a.a.f.s.k.f5677c;
    }

    public final void c1() {
        Menu menu = this.menu;
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        Book book = e.a.a.f.s.k.f5677c;
        if (menu == null || book == null) {
            return;
        }
        boolean z = !book.isLocalBook();
        int i2 = 0;
        int size = menu.size();
        if (size <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            MenuItem item = menu.getItem(i2);
            f.c0.c.j.b(item, "getItem(index)");
            switch (item.getGroupId()) {
                case R.id.menu_group_local /* 2131296834 */:
                    item.setVisible(!z);
                    break;
                case R.id.menu_group_manage /* 2131296835 */:
                case R.id.menu_group_sort /* 2131296838 */:
                default:
                    int itemId = item.getItemId();
                    if (itemId == R.id.menu_enable_replace) {
                        item.setChecked(book.getUseReplaceRule());
                    } else if (itemId == R.id.menu_re_segment) {
                        item.setChecked(book.getReSegment());
                    } else if (itemId == R.id.menu_reverse_content) {
                        item.setVisible(z);
                    }
                    break;
                case R.id.menu_group_on_line /* 2131296836 */:
                case R.id.menu_group_on_line_ns /* 2131296837 */:
                    item.setVisible(z);
                    break;
                case R.id.menu_group_text /* 2131296839 */:
                    item.setVisible(book.isLocalTxt());
                    break;
            }
            if (i3 >= size) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    @Override // c.f.a.a.f
    public void d0(int dialogId) {
    }

    public final void d1() {
        String strO2 = c.b.a.m.f.O2(this, "keep_light", null, 2);
        if (strO2 != null) {
            this.screenTimeOut = Long.parseLong(strO2) * ((long) 1000);
        }
        B0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(@Nullable KeyEvent event) {
        Integer numValueOf = event == null ? null : Integer.valueOf(event.getKeyCode());
        Integer numValueOf2 = event != null ? Integer.valueOf(event.getAction()) : null;
        boolean z = numValueOf2 != null && numValueOf2.intValue() == 0;
        if (numValueOf != null && numValueOf.intValue() == 82) {
            if (z && !((ActivityBookReadBinding) K0()).f6485d.getCnaShowMenu()) {
                ((ActivityBookReadBinding) K0()).f6485d.g();
                return true;
            }
            if (!z && !((ActivityBookReadBinding) K0()).f6485d.getCnaShowMenu()) {
                ((ActivityBookReadBinding) K0()).f6485d.setCnaShowMenu(true);
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean e1(e.a.a.g.d.i.s1.g.a direction) {
        ReadMenu readMenu = ((ActivityBookReadBinding) K0()).f6485d;
        f.c0.c.j.d(readMenu, "binding.readMenu");
        if ((readMenu.getVisibility() == 0) || !c.b.a.m.f.J2(this, "volumeKeyPage", true) || (!c.b.a.m.f.K2(this, "volumeKeyPageOnPlay", false, 2) && !BaseReadAloudService.f6929d)) {
            return false;
        }
        e.a.a.g.d.i.s1.f.e pageDelegate = ((ActivityBookReadBinding) K0()).f6486e.getPageDelegate();
        if (pageDelegate != null) {
            pageDelegate.f5762i = false;
        }
        e.a.a.g.d.i.s1.f.e pageDelegate2 = ((ActivityBookReadBinding) K0()).f6486e.getPageDelegate();
        if (pageDelegate2 != null) {
            pageDelegate2.j(direction);
        }
        return true;
    }

    @Override // io.legado.app.ui.book.read.ReadMenu.a, io.legado.app.ui.book.read.config.ReadAloudDialog.a
    public void f() throws IllegalAccessException, InvocationTargetException {
        i();
        if (!BaseReadAloudService.f6927b) {
            e.a.a.f.s.k.a.o(true);
        } else if (BaseReadAloudService.f6929d) {
            e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
            e.a.a.f.s.j.e(this);
        } else {
            e.a.a.f.s.j jVar2 = e.a.a.f.s.j.a;
            e.a.a.f.s.j.c(this);
        }
    }

    @Override // io.legado.app.base.BaseActivity, android.app.Activity
    public void finish() {
        Object objP;
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        Book book = e.a.a.f.s.k.f5677c;
        Object obj = null;
        if (book != null) {
            if (e.a.a.f.s.k.f5679e) {
                super.finish();
                objP = v.a;
            } else {
                objP = ((e.a.a.e.a.i) c.b.a.m.f.i0(this, getString(R.string.add_to_shelf), null, new a(book), 2)).p();
            }
            obj = objP;
        }
        if (obj == null) {
            super.finish();
        }
    }

    @Override // io.legado.app.ui.book.read.ReadMenu.a
    public void h0() {
        BookSource bookSource;
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        WebBook webBook = e.a.a.f.s.k.o;
        if (webBook == null || (bookSource = webBook.getBookSource()) == null) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) SourceLoginActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("sourceUrl", bookSource.getBookSourceUrl());
        intent.putExtra("loginUrl", bookSource.getLoginUrl());
        intent.putExtra(TTDownloadField.TT_USERAGENT, bookSource.getHeaderMap().get("User-Agent"));
        startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.page.ReadView.a, io.legado.app.ui.book.read.config.AutoReadDialog.a
    public void i() {
        this.isAutoPage = false;
        this.mHandler.removeCallbacks(this.autoPageRunnable);
        ReadView readView = ((ActivityBookReadBinding) K0()).f6486e;
        f.c0.c.j.d(readView, "binding.readView");
        c.b.a.m.f.W5(readView, 0, false, 3, null);
        ((ActivityBookReadBinding) K0()).f6485d.setAutoPage(false);
    }

    @Override // c.f.a.a.f
    public void i0(int dialogId, int color) {
        ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
        ReadBookConfig.Config durConfig = readBookConfig.getDurConfig();
        if (dialogId == 121) {
            durConfig.setCurTextColor(color);
            LiveEventBus.get("upConfig").post(Boolean.FALSE);
        } else {
            if (dialogId == 122) {
                durConfig.setCurBg(0, f.c0.c.j.k("#", c.b.a.m.f.w2(color)));
                readBookConfig.upBg();
                LiveEventBus.get("upConfig").post(Boolean.FALSE);
                return;
            }
            if (dialogId != 7897) {
                return;
            }
            e.a.a.d.r rVar = e.a.a.d.r.a;
            readBookConfig.getConfig().setTipColor(color);
            LiveEventBus.get("tipColor").post("");
            LiveEventBus.get("upConfig").post(Boolean.TRUE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.page.ContentTextView.a
    public int j0() {
        return ((ActivityBookReadBinding) K0()).f6486e.getCurPage().getHeaderHeight();
    }

    @Override // io.legado.app.ui.book.read.ReadMenu.a
    public void k0(@Nullable String searchWord) {
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        Book book = e.a.a.f.s.k.f5677c;
        if (book == null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.searchContentActivity;
        Intent intent = new Intent(this, (Class<?>) SearchContentActivity.class);
        intent.putExtra("bookUrl", book.getBookUrl());
        if (searchWord == null) {
            searchWord = T0().searchContentQuery;
        }
        intent.putExtra("searchWord", searchWord);
        activityResultLauncher.launch(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.ReadMenu.a
    public void l0() {
        WindowInsetsController insetsController;
        boolean zM0 = M0();
        ReadMenu readMenu = ((ActivityBookReadBinding) K0()).f6485d;
        f.c0.c.j.d(readMenu, "binding.readMenu");
        boolean z = !(readMenu.getVisibility() == 0);
        if (Build.VERSION.SDK_INT >= 30 && (insetsController = getWindow().getInsetsController()) != null) {
            if (z) {
                ReadBookConfig readBookConfig = ReadBookConfig.INSTANCE;
                if (readBookConfig.getHideStatusBar()) {
                    insetsController.hide(WindowInsets.Type.statusBars());
                }
                if (readBookConfig.getHideNavigationBar()) {
                    insetsController.hide(WindowInsets.Type.navigationBars());
                }
            } else {
                insetsController.show(WindowInsets.Type.statusBars());
                insetsController.show(WindowInsets.Type.navigationBars());
            }
        }
        int i2 = (!zM0 ? 7424 : 6400) | 512;
        if (z) {
            ReadBookConfig readBookConfig2 = ReadBookConfig.INSTANCE;
            if (readBookConfig2.getHideStatusBar()) {
                i2 |= 4;
            }
            if (readBookConfig2.getHideNavigationBar()) {
                i2 |= 2;
            }
        }
        getWindow().getDecorView().setSystemUiVisibility(i2);
        if (z) {
            ATH.a.e(this, ReadBookConfig.INSTANCE.getDurConfig().curStatusIconDark());
        } else {
            ATH ath = ATH.a;
            b.a aVar = e.a.a.e.d.b.a;
            e.a.a.d.e eVar = e.a.a.d.e.a;
            ath.f(this, aVar.f(this, c.b.a.m.f.J2(k.d.a.h.g(), "transparentStatusBar", true)));
        }
        S0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.config.ReadAloudDialog.a, io.legado.app.ui.book.read.config.AutoReadDialog.a
    public void m() {
        ((ActivityBookReadBinding) K0()).f6485d.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        f.c0.c.j.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        ReadView readView = ((ActivityBookReadBinding) K0()).f6486e;
        readView.curPage.m();
        readView.prevPage.m();
        readView.nextPage.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.keepScreenRunnable);
        a1().dismiss();
        ReadView readView = ((ActivityBookReadBinding) K0()).f6486e;
        e.a.a.g.d.i.s1.f.e eVar = readView.pageDelegate;
        if (eVar != null) {
            eVar.n();
        }
        readView.curPage.a();
        readView.curPage.c();
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        e.a.a.f.s.k.p = null;
        e.a.a.d.w.i.a.c(this);
        AdHelperInter adHelperInter = this.adHelperInter;
        if (adHelperInter != null) {
            adHelperInter.destroy();
        }
        this.adHelperInter = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event) {
        String strO2 = c.b.a.m.f.O2(this, "prevKeyCodes", null, 2);
        List listF = strO2 == null ? null : f.h0.k.F(strO2, new String[]{","}, false, 0, 6);
        if (!(listF == null ? false : listF.contains(String.valueOf(keyCode)))) {
            String strO22 = c.b.a.m.f.O2(this, "nextKeyCodes", null, 2);
            List listF2 = strO22 != null ? f.h0.k.F(strO22, new String[]{","}, false, 0, 6) : null;
            if (listF2 != null ? listF2.contains(String.valueOf(keyCode)) : false) {
                if (keyCode != 0) {
                    e.a.a.g.d.i.s1.f.e pageDelegate = ((ActivityBookReadBinding) K0()).f6486e.getPageDelegate();
                    if (pageDelegate != null) {
                        pageDelegate.j(e.a.a.g.d.i.s1.g.a.NEXT);
                    }
                    return true;
                }
            } else if (keyCode == 24) {
                if (e1(e.a.a.g.d.i.s1.g.a.PREV)) {
                    return true;
                }
            } else if (keyCode == 25) {
                if (e1(e.a.a.g.d.i.s1.g.a.NEXT)) {
                    return true;
                }
            } else {
                if (keyCode == 92) {
                    e.a.a.g.d.i.s1.f.e pageDelegate2 = ((ActivityBookReadBinding) K0()).f6486e.getPageDelegate();
                    if (pageDelegate2 != null) {
                        pageDelegate2.j(e.a.a.g.d.i.s1.g.a.PREV);
                    }
                    return true;
                }
                if (keyCode == 93) {
                    e.a.a.g.d.i.s1.f.e pageDelegate3 = ((ActivityBookReadBinding) K0()).f6486e.getPageDelegate();
                    if (pageDelegate3 != null) {
                        pageDelegate3.j(e.a.a.g.d.i.s1.g.a.NEXT);
                    }
                    return true;
                }
                if (keyCode == 62) {
                    e.a.a.g.d.i.s1.f.e pageDelegate4 = ((ActivityBookReadBinding) K0()).f6486e.getPageDelegate();
                    if (pageDelegate4 != null) {
                        pageDelegate4.j(e.a.a.g.d.i.s1.g.a.NEXT);
                    }
                    return true;
                }
            }
        } else if (keyCode != 0) {
            e.a.a.g.d.i.s1.f.e pageDelegate5 = ((ActivityBookReadBinding) K0()).f6486e.getPageDelegate();
            if (pageDelegate5 != null) {
                pageDelegate5.j(e.a.a.g.d.i.s1.g.a.PREV);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int keyCode, @Nullable KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyLongPress(keyCode, event);
        }
        finish();
        return true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, @Nullable KeyEvent event) {
        if (keyCode != 4) {
            if ((keyCode == 24 || keyCode == 25) && e1(e.a.a.g.d.i.s1.g.a.NONE)) {
                return true;
            }
        } else if (event != null && (event.getFlags() & 256) == 0 && event.isTracking() && !event.isCanceled()) {
            if (BaseReadAloudService.d()) {
                e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
                e.a.a.f.s.j.c(this);
                c.b.a.m.f.Q5(this, R.string.read_aloud_pause);
                return true;
            }
            if (this.isAutoPage) {
                i();
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        setIntent(intent);
        super.onNewIntent(intent);
    }

    @Override // io.legado.app.base.VMBaseActivity, io.legado.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacks(this.backupRunnable);
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        kVar.q();
        TimeBatteryReceiver timeBatteryReceiver = this.timeBatteryReceiver;
        if (timeBatteryReceiver != null) {
            unregisterReceiver(timeBatteryReceiver);
            this.timeBatteryReceiver = null;
        }
        l0();
        e.a.a.f.s.k.w(kVar, false, 1);
        e.a.a.d.w.i.a.c(this);
        c.b.a.m.f.q4(this, "rewardAdsTime", c.b.a.m.f.N2(this, "rewardAdsTime", 0L, 2) + (System.currentTimeMillis() - this.readStartTime));
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@Nullable Menu menu) {
        this.menu = menu;
        c1();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // io.legado.app.base.VMBaseActivity, io.legado.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        String stringExtra;
        super.onResume();
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        e.a.a.f.s.k.s = System.currentTimeMillis();
        l0();
        f.c0.c.j.e(this, com.umeng.analytics.pro.c.R);
        TimeBatteryReceiver timeBatteryReceiver = new TimeBatteryReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        registerReceiver(timeBatteryReceiver, intentFilter);
        this.timeBatteryReceiver = timeBatteryReceiver;
        ReadView readView = ((ActivityBookReadBinding) K0()).f6486e;
        readView.curPage.o();
        readView.prevPage.o();
        readView.nextPage.o();
        this.readStartTime = System.currentTimeMillis();
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("newBook")) == null) {
            return;
        }
        Book book = (Book) new Gson().fromJson(stringExtra, Book.class);
        f.c0.c.j.d(book, "newBook");
        f.c0.c.j.e(book, "book");
        T0().h(book);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0185  */
    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(@org.jetbrains.annotations.NotNull android.view.View r17, @org.jetbrains.annotations.NotNull android.view.MotionEvent r18) {
        /*
            Method dump skipped, instruction units count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.read.ReadBookActivity.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // io.legado.app.base.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        l0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.ReadMenu.a
    public void refresh() {
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        if (e.a.a.f.s.k.n == null) {
            c.b.a.m.f.V5(this, 0, false, null, 7, null);
            return;
        }
        Book book = e.a.a.f.s.k.f5677c;
        if (book == null) {
            return;
        }
        e.a.a.f.s.k.f5686l = null;
        ReadView readView = ((ActivityBookReadBinding) K0()).f6486e;
        f.c0.c.j.d(readView, "binding.readView");
        c.b.a.m.f.W5(readView, 0, false, 3, null);
        T0().m(book);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.page.ContentTextView.a
    public void t() {
        ActivityBookReadBinding activityBookReadBinding = (ActivityBookReadBinding) K0();
        ImageView imageView = activityBookReadBinding.f6483b;
        f.c0.c.j.d(imageView, "cursorLeft");
        c.b.a.m.f.l3(imageView);
        ImageView imageView2 = activityBookReadBinding.f6484c;
        f.c0.c.j.d(imageView2, "cursorRight");
        c.b.a.m.f.l3(imageView2);
        a1().dismiss();
    }

    @Override // e.a.a.f.s.k.a
    public void u(int relativePosition, boolean resetPageOffset, @Nullable f.c0.b.a<v> success) {
        c.b.a.m.f.L3(this, null, null, new r(relativePosition, resetPageOffset, success, null), 3, null);
    }

    @Override // io.legado.app.ui.book.read.ReadMenu.a
    public void v() {
        ReadStyleDialog readStyleDialog = new ReadStyleDialog();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
        readStyleDialog.show(supportFragmentManager, "readStyle");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.page.ContentTextView.a
    public void v0(float x, float y, float top) {
        ActivityBookReadBinding activityBookReadBinding = (ActivityBookReadBinding) K0();
        activityBookReadBinding.f6483b.setX(x - r1.getWidth());
        activityBookReadBinding.f6483b.setY(y);
        ImageView imageView = activityBookReadBinding.f6483b;
        f.c0.c.j.d(imageView, "cursorLeft");
        c.b.a.m.f.d6(imageView, true);
        activityBookReadBinding.f6487f.setX(x);
        activityBookReadBinding.f6487f.setY(top);
    }

    @Override // io.legado.app.ui.book.read.page.ReadView.a
    /* JADX INFO: renamed from: w, reason: from getter */
    public boolean getIsAutoPage() {
        return this.isAutoPage;
    }

    @Override // e.a.a.f.s.k.a
    public void w0() {
        c.b.a.m.f.L3(this, null, null, new t(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.ui.book.read.ReadMenu.a
    public void x() {
        ReadMenu readMenu = ((ActivityBookReadBinding) K0()).f6485d;
        f.c0.c.j.d(readMenu, "binding.readMenu");
        int i2 = ReadMenu.a;
        readMenu.h(null);
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        Book book = e.a.a.f.s.k.f5677c;
        if (book == null) {
            return;
        }
        ChangeSourceDialog.Companion bVar = ChangeSourceDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        f.c0.c.j.d(supportFragmentManager, "supportFragmentManager");
        bVar.a(supportFragmentManager, book.getName(), book.getAuthor());
    }

    @Override // io.legado.app.ui.book.read.page.ReadView.a
    /* JADX INFO: renamed from: x0, reason: from getter */
    public int getAutoPageProgress() {
        return this.autoPageProgress;
    }

    @Override // io.legado.app.ui.book.read.ReadMenu.a
    public void y() {
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        WebBook webBook = e.a.a.f.s.k.o;
    }

    @Override // io.legado.app.ui.book.read.page.ReadView.a
    public boolean y0() {
        return T0().isInitFinish;
    }

    @Override // io.legado.app.ui.book.read.ReadMenu.a
    public void z0() {
        new MoreConfigDialog().show(getSupportFragmentManager(), "moreConfig");
    }
}
