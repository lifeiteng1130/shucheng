package io.legado.app.data.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.media.AudioAttributesCompat;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import c.a.a.a.a;
import c.b.a.m.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.ai;
import e.a.a.c.c;
import e.a.a.d.e;
import e.a.a.d.i;
import e.a.a.d.v.l;
import e.a.a.h.f;
import e.a.a.h.n;
import f.c0.c.j;
import f.h;
import f.h0.g;
import f.h0.k;
import f.v;
import io.legado.app.data.entities.rule.BookInfoRule;
import io.legado.app.data.entities.rule.ContentRule;
import io.legado.app.data.entities.rule.ExploreRule;
import io.legado.app.data.entities.rule.SearchRule;
import io.legado.app.data.entities.rule.TocRule;
import io.legado.app.help.JsExtensions;
import io.legado.app.model.analyzeRule.QueryTTF;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.script.SimpleBindings;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Connection;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: BookSource.kt */
/* JADX INFO: loaded from: classes3.dex */
@TypeConverters({Converters.class})
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\bB\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0004¡\u0001¢\u0001Bé\u0001\u0012\b\b\u0002\u0010I\u001a\u00020\u0003\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010K\u001a\u00020\u0003\u0012\b\b\u0002\u0010L\u001a\u00020\r\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010N\u001a\u00020\r\u0012\b\b\u0002\u0010O\u001a\u00020\n\u0012\b\b\u0002\u0010P\u001a\u00020\n\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010T\u001a\u00020>\u0012\b\b\u0002\u0010U\u001a\u00020\r\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\"¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0003¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0003¢\u0006\u0004\b)\u0010(J\u001d\u0010-\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,¢\u0006\u0004\b-\u0010.J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u00100J\u0010\u00101\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b1\u00102J\u0012\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b3\u00102J\u0010\u00104\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b4\u00102J\u0010\u00105\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b5\u0010\u000fJ\u0012\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b6\u00102J\u0010\u00107\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b7\u0010\u000fJ\u0010\u00108\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b:\u00109J\u0012\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b;\u00102J\u0012\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b<\u00102J\u0012\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b=\u00102J\u0010\u0010?\u001a\u00020>HÆ\u0003¢\u0006\u0004\b?\u0010@J\u0010\u0010A\u001a\u00020\rHÆ\u0003¢\u0006\u0004\bA\u0010\u000fJ\u0012\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\bB\u00102J\u0012\u0010C\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\bC\u0010\u001bJ\u0012\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\bD\u00102J\u0012\u0010E\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\bE\u0010\u0018J\u0012\u0010F\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\bF\u0010\u001eJ\u0012\u0010G\u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\bG\u0010!J\u0012\u0010H\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\bH\u0010$Jð\u0001\u0010]\u001a\u00020\u00002\b\b\u0002\u0010I\u001a\u00020\u00032\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010K\u001a\u00020\u00032\b\b\u0002\u0010L\u001a\u00020\r2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010N\u001a\u00020\r2\b\b\u0002\u0010O\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010T\u001a\u00020>2\b\b\u0002\u0010U\u001a\u00020\r2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\"HÆ\u0001¢\u0006\u0004\b]\u0010^J\u0010\u0010_\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b_\u00102J\u0010\u0010`\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b`\u0010\u000fJ \u0010d\u001a\u00020&2\u0006\u0010b\u001a\u00020a2\u0006\u0010c\u001a\u00020\rHÖ\u0001¢\u0006\u0004\bd\u0010eR$\u0010Y\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010f\u001a\u0004\bg\u0010\u0018\"\u0004\bh\u0010iR\"\u0010I\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010j\u001a\u0004\bk\u00102\"\u0004\bl\u0010(R\"\u0010O\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010m\u001a\u0004\bn\u00109\"\u0004\bo\u0010pR$\u0010J\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010j\u001a\u0004\bq\u00102\"\u0004\br\u0010(R$\u0010S\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010j\u001a\u0004\bs\u00102\"\u0004\bt\u0010(R$\u0010V\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010j\u001a\u0004\bu\u00102\"\u0004\bv\u0010(R\"\u0010L\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010w\u001a\u0004\bx\u0010\u000f\"\u0004\by\u0010zR$\u0010\\\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010{\u001a\u0004\b|\u0010$\"\u0004\b}\u0010~R#\u0010U\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\bU\u0010w\u001a\u0004\b\u007f\u0010\u000f\"\u0005\b\u0080\u0001\u0010zR&\u0010R\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bR\u0010j\u001a\u0005\b\u0081\u0001\u00102\"\u0005\b\u0082\u0001\u0010(R(\u0010[\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b[\u0010\u0083\u0001\u001a\u0005\b\u0084\u0001\u0010!\"\u0006\b\u0085\u0001\u0010\u0086\u0001R$\u0010N\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bN\u0010w\u001a\u0005\b\u0087\u0001\u0010\u000f\"\u0005\b\u0088\u0001\u0010zR&\u0010X\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bX\u0010j\u001a\u0005\b\u0089\u0001\u00102\"\u0005\b\u008a\u0001\u0010(R(\u0010W\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bW\u0010\u008b\u0001\u001a\u0005\b\u008c\u0001\u0010\u001b\"\u0006\b\u008d\u0001\u0010\u008e\u0001R(\u0010Z\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bZ\u0010\u008f\u0001\u001a\u0005\b\u0090\u0001\u0010\u001e\"\u0006\b\u0091\u0001\u0010\u0092\u0001R&\u0010M\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bM\u0010j\u001a\u0005\b\u0093\u0001\u00102\"\u0005\b\u0094\u0001\u0010(R$\u0010P\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bP\u0010m\u001a\u0005\b\u0095\u0001\u00109\"\u0005\b\u0096\u0001\u0010pR$\u0010K\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bK\u0010j\u001a\u0005\b\u0097\u0001\u00102\"\u0005\b\u0098\u0001\u0010(R&\u0010T\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bT\u0010\u0099\u0001\u001a\u0005\b\u009a\u0001\u0010@\"\u0006\b\u009b\u0001\u0010\u009c\u0001R&\u0010Q\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bQ\u0010j\u001a\u0005\b\u009d\u0001\u00102\"\u0005\b\u009e\u0001\u0010(¨\u0006£\u0001"}, d2 = {"Lio/legado/app/data/entities/BookSource;", "Landroid/os/Parcelable;", "Lio/legado/app/help/JsExtensions;", "", "jsStr", "", "evalJS", "(Ljava/lang/String;)Ljava/lang/Object;", ai.at, "b", "", "equal", "(Ljava/lang/String;Ljava/lang/String;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "other", "equals", "(Ljava/lang/Object;)Z", "", "getHeaderMap", "()Ljava/util/Map;", "Lio/legado/app/data/entities/rule/SearchRule;", "getSearchRule", "()Lio/legado/app/data/entities/rule/SearchRule;", "Lio/legado/app/data/entities/rule/ExploreRule;", "getExploreRule", "()Lio/legado/app/data/entities/rule/ExploreRule;", "Lio/legado/app/data/entities/rule/BookInfoRule;", "getBookInfoRule", "()Lio/legado/app/data/entities/rule/BookInfoRule;", "Lio/legado/app/data/entities/rule/TocRule;", "getTocRule", "()Lio/legado/app/data/entities/rule/TocRule;", "Lio/legado/app/data/entities/rule/ContentRule;", "getContentRule", "()Lio/legado/app/data/entities/rule/ContentRule;", "group", "Lf/v;", "addGroup", "(Ljava/lang/String;)V", "removeGroup", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/BookSource$ExploreKind;", "Lkotlin/collections/ArrayList;", "getExploreKinds", "()Ljava/util/ArrayList;", "source", "(Lio/legado/app/data/entities/BookSource;)Z", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "()Z", "component8", "component9", "component10", "component11", "", "component12", "()J", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "bookSourceName", "bookSourceGroup", "bookSourceUrl", "bookSourceType", "bookUrlPattern", "customOrder", "enabled", "enabledExplore", "header", "loginUrl", "bookSourceComment", "lastUpdateTime", ActivityChooserModel.ATTRIBUTE_WEIGHT, "exploreUrl", "ruleExplore", "searchUrl", "ruleSearch", "ruleBookInfo", "ruleToc", "ruleContent", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Lio/legado/app/data/entities/rule/ExploreRule;Ljava/lang/String;Lio/legado/app/data/entities/rule/SearchRule;Lio/legado/app/data/entities/rule/BookInfoRule;Lio/legado/app/data/entities/rule/TocRule;Lio/legado/app/data/entities/rule/ContentRule;)Lio/legado/app/data/entities/BookSource;", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lio/legado/app/data/entities/rule/SearchRule;", "getRuleSearch", "setRuleSearch", "(Lio/legado/app/data/entities/rule/SearchRule;)V", "Ljava/lang/String;", "getBookSourceName", "setBookSourceName", "Z", "getEnabled", "setEnabled", "(Z)V", "getBookSourceGroup", "setBookSourceGroup", "getBookSourceComment", "setBookSourceComment", "getExploreUrl", "setExploreUrl", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getBookSourceType", "setBookSourceType", "(I)V", "Lio/legado/app/data/entities/rule/ContentRule;", "getRuleContent", "setRuleContent", "(Lio/legado/app/data/entities/rule/ContentRule;)V", "getWeight", "setWeight", "getLoginUrl", "setLoginUrl", "Lio/legado/app/data/entities/rule/TocRule;", "getRuleToc", "setRuleToc", "(Lio/legado/app/data/entities/rule/TocRule;)V", "getCustomOrder", "setCustomOrder", "getSearchUrl", "setSearchUrl", "Lio/legado/app/data/entities/rule/ExploreRule;", "getRuleExplore", "setRuleExplore", "(Lio/legado/app/data/entities/rule/ExploreRule;)V", "Lio/legado/app/data/entities/rule/BookInfoRule;", "getRuleBookInfo", "setRuleBookInfo", "(Lio/legado/app/data/entities/rule/BookInfoRule;)V", "getBookUrlPattern", "setBookUrlPattern", "getEnabledExplore", "setEnabledExplore", "getBookSourceUrl", "setBookSourceUrl", "J", "getLastUpdateTime", "setLastUpdateTime", "(J)V", "getHeader", "setHeader", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Lio/legado/app/data/entities/rule/ExploreRule;Ljava/lang/String;Lio/legado/app/data/entities/rule/SearchRule;Lio/legado/app/data/entities/rule/BookInfoRule;Lio/legado/app/data/entities/rule/TocRule;Lio/legado/app/data/entities/rule/ContentRule;)V", "Converters", "ExploreKind", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
@Entity(indices = {@Index(unique = false, value = {"bookSourceUrl"})}, tableName = "book_sources")
public final /* data */ class BookSource implements Parcelable, JsExtensions {

    @NotNull
    public static final Parcelable.Creator<BookSource> CREATOR = new Creator();

    @Nullable
    private String bookSourceComment;

    @Nullable
    private String bookSourceGroup;

    @NotNull
    private String bookSourceName;
    private int bookSourceType;

    @PrimaryKey
    @NotNull
    private String bookSourceUrl;

    @Nullable
    private String bookUrlPattern;
    private int customOrder;
    private boolean enabled;
    private boolean enabledExplore;

    @Nullable
    private String exploreUrl;

    @Nullable
    private String header;
    private long lastUpdateTime;

    @Nullable
    private String loginUrl;

    @Nullable
    private BookInfoRule ruleBookInfo;

    @Nullable
    private ContentRule ruleContent;

    @Nullable
    private ExploreRule ruleExplore;

    @Nullable
    private SearchRule ruleSearch;

    @Nullable
    private TocRule ruleToc;

    @Nullable
    private String searchUrl;
    private int weight;

    /* JADX INFO: compiled from: BookSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010 \u001a\u0004\u0018\u00010\u001c2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b \u0010!¨\u0006$"}, d2 = {"Lio/legado/app/data/entities/BookSource$Converters;", "", "Lio/legado/app/data/entities/rule/ExploreRule;", "exploreRule", "", "exploreRuleToString", "(Lio/legado/app/data/entities/rule/ExploreRule;)Ljava/lang/String;", "json", "stringToExploreRule", "(Ljava/lang/String;)Lio/legado/app/data/entities/rule/ExploreRule;", "Lio/legado/app/data/entities/rule/SearchRule;", "searchRule", "searchRuleToString", "(Lio/legado/app/data/entities/rule/SearchRule;)Ljava/lang/String;", "stringToSearchRule", "(Ljava/lang/String;)Lio/legado/app/data/entities/rule/SearchRule;", "Lio/legado/app/data/entities/rule/BookInfoRule;", "bookInfoRule", "bookInfoRuleToString", "(Lio/legado/app/data/entities/rule/BookInfoRule;)Ljava/lang/String;", "stringToBookInfoRule", "(Ljava/lang/String;)Lio/legado/app/data/entities/rule/BookInfoRule;", "Lio/legado/app/data/entities/rule/TocRule;", "tocRule", "tocRuleToString", "(Lio/legado/app/data/entities/rule/TocRule;)Ljava/lang/String;", "stringToTocRule", "(Ljava/lang/String;)Lio/legado/app/data/entities/rule/TocRule;", "Lio/legado/app/data/entities/rule/ContentRule;", "contentRule", "contentRuleToString", "(Lio/legado/app/data/entities/rule/ContentRule;)Ljava/lang/String;", "stringToContentRule", "(Ljava/lang/String;)Lio/legado/app/data/entities/rule/ContentRule;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Converters {
        @TypeConverter
        @NotNull
        public final String bookInfoRuleToString(@Nullable BookInfoRule bookInfoRule) {
            String json = n.a().toJson(bookInfoRule);
            j.d(json, "GSON.toJson(bookInfoRule)");
            return json;
        }

        @TypeConverter
        @NotNull
        public final String contentRuleToString(@Nullable ContentRule contentRule) {
            String json = n.a().toJson(contentRule);
            j.d(json, "GSON.toJson(contentRule)");
            return json;
        }

        @TypeConverter
        @NotNull
        public final String exploreRuleToString(@Nullable ExploreRule exploreRule) {
            String json = n.a().toJson(exploreRule);
            j.d(json, "GSON.toJson(exploreRule)");
            return json;
        }

        @TypeConverter
        @NotNull
        public final String searchRuleToString(@Nullable SearchRule searchRule) {
            String json = n.a().toJson(searchRule);
            j.d(json, "GSON.toJson(searchRule)");
            return json;
        }

        @TypeConverter
        @Nullable
        public final BookInfoRule stringToBookInfoRule(@Nullable String json) {
            Object objM11constructorimpl;
            Gson gsonA = n.a();
            try {
                Type type = new TypeToken<BookInfoRule>() { // from class: io.legado.app.data.entities.BookSource$Converters$stringToBookInfoRule$$inlined$fromJsonObject$1
                }.getType();
                j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(json, type);
                if (!(objFromJson instanceof BookInfoRule)) {
                    objFromJson = null;
                }
                objM11constructorimpl = h.m11constructorimpl((BookInfoRule) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(f.m1(th));
            }
            return (BookInfoRule) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
        }

        @TypeConverter
        @Nullable
        public final ContentRule stringToContentRule(@Nullable String json) {
            Object objM11constructorimpl;
            Gson gsonA = n.a();
            try {
                Type type = new TypeToken<ContentRule>() { // from class: io.legado.app.data.entities.BookSource$Converters$stringToContentRule$$inlined$fromJsonObject$1
                }.getType();
                j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(json, type);
                if (!(objFromJson instanceof ContentRule)) {
                    objFromJson = null;
                }
                objM11constructorimpl = h.m11constructorimpl((ContentRule) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(f.m1(th));
            }
            return (ContentRule) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
        }

        @TypeConverter
        @Nullable
        public final ExploreRule stringToExploreRule(@Nullable String json) {
            Object objM11constructorimpl;
            Gson gsonA = n.a();
            try {
                Type type = new TypeToken<ExploreRule>() { // from class: io.legado.app.data.entities.BookSource$Converters$stringToExploreRule$$inlined$fromJsonObject$1
                }.getType();
                j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(json, type);
                if (!(objFromJson instanceof ExploreRule)) {
                    objFromJson = null;
                }
                objM11constructorimpl = h.m11constructorimpl((ExploreRule) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(f.m1(th));
            }
            return (ExploreRule) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
        }

        @TypeConverter
        @Nullable
        public final SearchRule stringToSearchRule(@Nullable String json) {
            Object objM11constructorimpl;
            Gson gsonA = n.a();
            try {
                Type type = new TypeToken<SearchRule>() { // from class: io.legado.app.data.entities.BookSource$Converters$stringToSearchRule$$inlined$fromJsonObject$1
                }.getType();
                j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(json, type);
                if (!(objFromJson instanceof SearchRule)) {
                    objFromJson = null;
                }
                objM11constructorimpl = h.m11constructorimpl((SearchRule) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(f.m1(th));
            }
            return (SearchRule) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
        }

        @TypeConverter
        @Nullable
        public final TocRule stringToTocRule(@Nullable String json) {
            Object objM11constructorimpl;
            Gson gsonA = n.a();
            try {
                Type type = new TypeToken<TocRule>() { // from class: io.legado.app.data.entities.BookSource$Converters$stringToTocRule$$inlined$fromJsonObject$1
                }.getType();
                j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(json, type);
                if (!(objFromJson instanceof TocRule)) {
                    objFromJson = null;
                }
                objM11constructorimpl = h.m11constructorimpl((TocRule) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(f.m1(th));
            }
            return (TocRule) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
        }

        @TypeConverter
        @NotNull
        public final String tocRuleToString(@Nullable TocRule tocRule) {
            String json = n.a().toJson(tocRule);
            j.d(json, "GSON.toJson(tocRule)");
            return json;
        }
    }

    /* JADX INFO: compiled from: BookSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<BookSource> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookSource createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new BookSource(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? null : ExploreRule.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : SearchRule.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : BookInfoRule.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TocRule.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? ContentRule.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookSource[] newArray(int i2) {
            return new BookSource[i2];
        }
    }

    public BookSource() {
        this(null, null, null, 0, null, 0, false, false, null, null, null, 0L, 0, null, null, null, null, null, null, null, 1048575, null);
    }

    public BookSource(@NotNull String str, @Nullable String str2, @NotNull String str3, int i2, @Nullable String str4, int i3, boolean z, boolean z2, @Nullable String str5, @Nullable String str6, @Nullable String str7, long j2, int i4, @Nullable String str8, @Nullable ExploreRule exploreRule, @Nullable String str9, @Nullable SearchRule searchRule, @Nullable BookInfoRule bookInfoRule, @Nullable TocRule tocRule, @Nullable ContentRule contentRule) {
        j.e(str, "bookSourceName");
        j.e(str3, "bookSourceUrl");
        this.bookSourceName = str;
        this.bookSourceGroup = str2;
        this.bookSourceUrl = str3;
        this.bookSourceType = i2;
        this.bookUrlPattern = str4;
        this.customOrder = i3;
        this.enabled = z;
        this.enabledExplore = z2;
        this.header = str5;
        this.loginUrl = str6;
        this.bookSourceComment = str7;
        this.lastUpdateTime = j2;
        this.weight = i4;
        this.exploreUrl = str8;
        this.ruleExplore = exploreRule;
        this.searchUrl = str9;
        this.ruleSearch = searchRule;
        this.ruleBookInfo = bookInfoRule;
        this.ruleToc = tocRule;
        this.ruleContent = contentRule;
    }

    private final Object evalJS(String jsStr) {
        SimpleBindings simpleBindings = new SimpleBindings();
        simpleBindings.put(LogType.JAVA_TYPE, this);
        simpleBindings.put("cookie", e.a.a.d.v.f.a);
        simpleBindings.put("cache", i.a);
        c cVar = c.a;
        Object objEval = c.c().eval(jsStr, simpleBindings);
        j.d(objEval, "AppConst.SCRIPT_ENGINE.eval(jsStr, bindings)");
        return objEval;
    }

    public final void addGroup(@NotNull String group) {
        v vVar;
        j.e(group, "group");
        String str = this.bookSourceGroup;
        if (str == null) {
            vVar = null;
        } else {
            if (!k.d(str, group, false, 2)) {
                setBookSourceGroup(str + ',' + group);
            }
            vVar = v.a;
        }
        if (vVar == null) {
            setBookSourceGroup(group);
        }
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesBase64DecodeToByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.W(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesBase64DecodeToString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.X(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesDecodeToByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.Y(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesDecodeToString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.Z(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesEncodeToBase64ByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.a0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesEncodeToBase64String(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.b0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesEncodeToByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.c0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesEncodeToString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return f.d0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String ajax(@NotNull String str) {
        return f.e0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public l[] ajaxAll(@NotNull String[] strArr) {
        return f.f0(this, strArr);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String base64Decode(@NotNull String str) {
        return f.x0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] base64DecodeToByteArray(@Nullable String str) {
        return f.z0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String base64Encode(@NotNull String str) {
        return f.B0(this, str);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBookSourceName() {
        return this.bookSourceName;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getLoginUrl() {
        return this.loginUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getBookSourceComment() {
        return this.bookSourceComment;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getWeight() {
        return this.weight;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getExploreUrl() {
        return this.exploreUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final ExploreRule getRuleExplore() {
        return this.ruleExplore;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getSearchUrl() {
        return this.searchUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final SearchRule getRuleSearch() {
        return this.ruleSearch;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final BookInfoRule getRuleBookInfo() {
        return this.ruleBookInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final TocRule getRuleToc() {
        return this.ruleToc;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBookSourceGroup() {
        return this.bookSourceGroup;
    }

    @Nullable
    /* JADX INFO: renamed from: component20, reason: from getter */
    public final ContentRule getRuleContent() {
        return this.ruleContent;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBookSourceUrl() {
        return this.bookSourceUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBookSourceType() {
        return this.bookSourceType;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBookUrlPattern() {
        return this.bookUrlPattern;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getCustomOrder() {
        return this.customOrder;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getEnabledExplore() {
        return this.enabledExplore;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public Object connect(@NotNull String str) {
        return f.X0(this, str);
    }

    @NotNull
    public final BookSource copy(@NotNull String bookSourceName, @Nullable String bookSourceGroup, @NotNull String bookSourceUrl, int bookSourceType, @Nullable String bookUrlPattern, int customOrder, boolean enabled, boolean enabledExplore, @Nullable String header, @Nullable String loginUrl, @Nullable String bookSourceComment, long lastUpdateTime, int weight, @Nullable String exploreUrl, @Nullable ExploreRule ruleExplore, @Nullable String searchUrl, @Nullable SearchRule ruleSearch, @Nullable BookInfoRule ruleBookInfo, @Nullable TocRule ruleToc, @Nullable ContentRule ruleContent) {
        j.e(bookSourceName, "bookSourceName");
        j.e(bookSourceUrl, "bookSourceUrl");
        return new BookSource(bookSourceName, bookSourceGroup, bookSourceUrl, bookSourceType, bookUrlPattern, customOrder, enabled, enabledExplore, header, loginUrl, bookSourceComment, lastUpdateTime, weight, exploreUrl, ruleExplore, searchUrl, ruleSearch, ruleBookInfo, ruleToc, ruleContent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String downloadFile(@NotNull String str, @NotNull String str2) {
        return f.v1(this, str, str2);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String encodeURI(@NotNull String str) {
        return f.z1(this, str);
    }

    public final boolean equal(@NotNull BookSource source) {
        j.e(source, "source");
        return equal(this.bookSourceName, source.bookSourceName) && equal(this.bookSourceUrl, source.bookSourceUrl) && equal(this.bookSourceGroup, source.bookSourceGroup) && this.bookSourceType == source.bookSourceType && equal(this.bookUrlPattern, source.bookUrlPattern) && equal(this.bookSourceComment, source.bookSourceComment) && this.enabled == source.enabled && this.enabledExplore == source.enabledExplore && equal(this.header, source.header) && equal(this.loginUrl, source.loginUrl) && equal(this.exploreUrl, source.exploreUrl) && equal(this.searchUrl, source.searchUrl) && j.a(getSearchRule(), source.getSearchRule()) && j.a(getExploreRule(), source.getExploreRule()) && j.a(getBookInfoRule(), source.getBookInfoRule()) && j.a(getTocRule(), source.getTocRule()) && j.a(getContentRule(), source.getContentRule());
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof BookSource) {
            return j.a(((BookSource) other).bookSourceUrl, this.bookSourceUrl);
        }
        return false;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public Connection.Response get(@NotNull String str, @NotNull Map<String, String> map) {
        return f.K1(this, str, map);
    }

    @NotNull
    public final BookInfoRule getBookInfoRule() {
        BookInfoRule bookInfoRule = this.ruleBookInfo;
        return bookInfoRule == null ? new BookInfoRule(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : bookInfoRule;
    }

    @Nullable
    public final String getBookSourceComment() {
        return this.bookSourceComment;
    }

    @Nullable
    public final String getBookSourceGroup() {
        return this.bookSourceGroup;
    }

    @NotNull
    public final String getBookSourceName() {
        return this.bookSourceName;
    }

    public final int getBookSourceType() {
        return this.bookSourceType;
    }

    @NotNull
    public final String getBookSourceUrl() {
        return this.bookSourceUrl;
    }

    @Nullable
    public final String getBookUrlPattern() {
        return this.bookUrlPattern;
    }

    @NotNull
    public final ContentRule getContentRule() {
        ContentRule contentRule = this.ruleContent;
        return contentRule == null ? new ContentRule(null, null, null, null, null, null, 63, null) : contentRule;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String getCookie(@NotNull String str, @Nullable String str2) {
        return f.f2(this, str, str2);
    }

    public final int getCustomOrder() {
        return this.customOrder;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getEnabledExplore() {
        return this.enabledExplore;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final ArrayList<ExploreKind> getExploreKinds() {
        Object objM11constructorimpl;
        String strSubstring;
        ArrayList<ExploreKind> arrayList = new ArrayList<>();
        String exploreUrl = getExploreUrl();
        if (exploreUrl != null && (!k.s(exploreUrl))) {
            int i2 = 2;
            try {
                if (k.H(exploreUrl, "<js>", false) || k.H(exploreUrl, "@js", false)) {
                    e.a.a.h.f fVarA = f.b.a(e.a.a.h.f.a, k.d.a.h.g(), "explore", 0L, 0, false, 28);
                    String strA = fVarA.a(getBookSourceUrl());
                    if (strA == null) {
                        strA = "";
                    }
                    if (k.s(strA)) {
                        SimpleBindings simpleBindings = new SimpleBindings();
                        simpleBindings.put("baseUrl", getBookSourceUrl());
                        simpleBindings.put(LogType.JAVA_TYPE, arrayList);
                        simpleBindings.put("cookie", e.a.a.d.v.f.a);
                        simpleBindings.put("cache", i.a);
                        if (k.K(exploreUrl, "@", false, 2)) {
                            strSubstring = exploreUrl.substring(3);
                            j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                        } else {
                            strSubstring = exploreUrl.substring(4, k.u(exploreUrl, "<", 0, false, 6));
                            j.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        }
                        c cVar = c.a;
                        exploreUrl = c.c().eval(strSubstring, simpleBindings).toString();
                        fVarA.b(getBookSourceUrl(), exploreUrl);
                    } else {
                        exploreUrl = strA;
                    }
                }
                Iterator<T> it = new g("(&&|\n)+").split(exploreUrl, 0).iterator();
                while (it.hasNext()) {
                    List listF = k.F((String) it.next(), new String[]{"::"}, false, 0, 6);
                    if (listF.size() > 1) {
                        arrayList.add(new ExploreKind((String) listF.get(0), (String) listF.get(1)));
                    }
                }
                objM11constructorimpl = h.m11constructorimpl(v.a);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            Throwable thM14exceptionOrNullimpl = h.m14exceptionOrNullimpl(objM11constructorimpl);
            if (thM14exceptionOrNullimpl != null) {
                String localizedMessage = thM14exceptionOrNullimpl.getLocalizedMessage();
                arrayList.add(new ExploreKind(localizedMessage != null ? localizedMessage : "", null, i2, 0 == true ? 1 : 0));
            }
        }
        return arrayList;
    }

    @NotNull
    public final ExploreRule getExploreRule() {
        ExploreRule exploreRule = this.ruleExplore;
        return exploreRule == null ? new ExploreRule(null, null, null, null, null, null, null, null, null, null, AudioAttributesCompat.FLAG_ALL, null) : exploreRule;
    }

    @Nullable
    public final String getExploreUrl() {
        return this.exploreUrl;
    }

    @Nullable
    public final String getHeader() {
        return this.header;
    }

    @NotNull
    public final Map<String, String> getHeaderMap() {
        Object objM11constructorimpl;
        HashMap map = new HashMap();
        e eVar = e.a;
        map.put("User-Agent", e.f5518c);
        String header = getHeader();
        if (header != null) {
            Gson gsonA = n.a();
            if (k.H(header, "@js:", true)) {
                String strSubstring = header.substring(4);
                j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                header = evalJS(strSubstring).toString();
            } else if (k.H(header, "<js>", true)) {
                String strSubstring2 = header.substring(4, k.u(header, "<", 0, false, 6));
                j.d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                header = evalJS(strSubstring2).toString();
            }
            try {
                Type type = new TypeToken<Map<String, ? extends String>>() { // from class: io.legado.app.data.entities.BookSource$getHeaderMap$lambda-2$lambda-1$$inlined$fromJsonObject$1
                }.getType();
                j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(header, type);
                if (!(objFromJson instanceof Map)) {
                    objFromJson = null;
                }
                objM11constructorimpl = h.m11constructorimpl((Map) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(c.b.a.m.f.m1(th));
            }
            Map map2 = (Map) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
            if (map2 != null) {
                map.putAll(map2);
            }
        }
        return map;
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    @Nullable
    public final String getLoginUrl() {
        return this.loginUrl;
    }

    @Nullable
    public final BookInfoRule getRuleBookInfo() {
        return this.ruleBookInfo;
    }

    @Nullable
    public final ContentRule getRuleContent() {
        return this.ruleContent;
    }

    @Nullable
    public final ExploreRule getRuleExplore() {
        return this.ruleExplore;
    }

    @Nullable
    public final SearchRule getRuleSearch() {
        return this.ruleSearch;
    }

    @Nullable
    public final TocRule getRuleToc() {
        return this.ruleToc;
    }

    @NotNull
    public final SearchRule getSearchRule() {
        SearchRule searchRule = this.ruleSearch;
        return searchRule == null ? new SearchRule(null, null, null, null, null, null, null, null, null, null, AudioAttributesCompat.FLAG_ALL, null) : searchRule;
    }

    @Nullable
    public final String getSearchUrl() {
        return this.searchUrl;
    }

    @NotNull
    public final TocRule getTocRule() {
        TocRule tocRule = this.ruleToc;
        return tocRule == null ? new TocRule(null, null, null, null, null, null, 63, null) : tocRule;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String getTxtInFolder(@NotNull String str) {
        return c.b.a.m.f.a3(this, str);
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return this.bookSourceUrl.hashCode();
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String htmlFormat(@NotNull String str) {
        return c.b.a.m.f.i3(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String log(@NotNull String str) {
        c.b.a.m.f.Q3(this, str);
        return str;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String md5Encode(@NotNull String str) {
        return c.b.a.m.f.V3(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String md5Encode16(@NotNull String str) {
        return c.b.a.m.f.W3(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public Connection.Response post(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        return c.b.a.m.f.l4(this, str, str2, map);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public QueryTTF queryBase64TTF(@Nullable String str) {
        return c.b.a.m.f.s4(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public QueryTTF queryTTF(@Nullable String str) {
        return c.b.a.m.f.t4(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public byte[] readFile(@NotNull String str) {
        return c.b.a.m.f.x4(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String readTxtFile(@NotNull String str) {
        return c.b.a.m.f.D4(this, str);
    }

    public final void removeGroup(@NotNull String group) {
        j.e(group, "group");
        String str = this.bookSourceGroup;
        String[] strArrO5 = str == null ? null : c.b.a.m.f.o5(str, new g("[,;，；]"), 0, 2);
        if (strArrO5 == null) {
            return;
        }
        HashSet hashSetI5 = c.b.a.m.f.I5(strArrO5);
        hashSetI5.remove(group);
        setBookSourceGroup(TextUtils.join(",", hashSetI5));
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String replaceFont(@NotNull String str, @Nullable QueryTTF queryTTF, @Nullable QueryTTF queryTTF2) {
        return c.b.a.m.f.I4(this, str, queryTTF, queryTTF2);
    }

    public final void setBookSourceComment(@Nullable String str) {
        this.bookSourceComment = str;
    }

    public final void setBookSourceGroup(@Nullable String str) {
        this.bookSourceGroup = str;
    }

    public final void setBookSourceName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.bookSourceName = str;
    }

    public final void setBookSourceType(int i2) {
        this.bookSourceType = i2;
    }

    public final void setBookSourceUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.bookSourceUrl = str;
    }

    public final void setBookUrlPattern(@Nullable String str) {
        this.bookUrlPattern = str;
    }

    public final void setCustomOrder(int i2) {
        this.customOrder = i2;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setEnabledExplore(boolean z) {
        this.enabledExplore = z;
    }

    public final void setExploreUrl(@Nullable String str) {
        this.exploreUrl = str;
    }

    public final void setHeader(@Nullable String str) {
        this.header = str;
    }

    public final void setLastUpdateTime(long j2) {
        this.lastUpdateTime = j2;
    }

    public final void setLoginUrl(@Nullable String str) {
        this.loginUrl = str;
    }

    public final void setRuleBookInfo(@Nullable BookInfoRule bookInfoRule) {
        this.ruleBookInfo = bookInfoRule;
    }

    public final void setRuleContent(@Nullable ContentRule contentRule) {
        this.ruleContent = contentRule;
    }

    public final void setRuleExplore(@Nullable ExploreRule exploreRule) {
        this.ruleExplore = exploreRule;
    }

    public final void setRuleSearch(@Nullable SearchRule searchRule) {
        this.ruleSearch = searchRule;
    }

    public final void setRuleToc(@Nullable TocRule tocRule) {
        this.ruleToc = tocRule;
    }

    public final void setSearchUrl(@Nullable String str) {
        this.searchUrl = str;
    }

    public final void setWeight(int i2) {
        this.weight = i2;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String timeFormat(long j2) {
        return c.b.a.m.f.F5(this, j2);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("BookSource(bookSourceName=");
        sbR.append(this.bookSourceName);
        sbR.append(", bookSourceGroup=");
        sbR.append((Object) this.bookSourceGroup);
        sbR.append(", bookSourceUrl=");
        sbR.append(this.bookSourceUrl);
        sbR.append(", bookSourceType=");
        sbR.append(this.bookSourceType);
        sbR.append(", bookUrlPattern=");
        sbR.append((Object) this.bookUrlPattern);
        sbR.append(", customOrder=");
        sbR.append(this.customOrder);
        sbR.append(", enabled=");
        sbR.append(this.enabled);
        sbR.append(", enabledExplore=");
        sbR.append(this.enabledExplore);
        sbR.append(", header=");
        sbR.append((Object) this.header);
        sbR.append(", loginUrl=");
        sbR.append((Object) this.loginUrl);
        sbR.append(", bookSourceComment=");
        sbR.append((Object) this.bookSourceComment);
        sbR.append(", lastUpdateTime=");
        sbR.append(this.lastUpdateTime);
        sbR.append(", weight=");
        sbR.append(this.weight);
        sbR.append(", exploreUrl=");
        sbR.append((Object) this.exploreUrl);
        sbR.append(", ruleExplore=");
        sbR.append(this.ruleExplore);
        sbR.append(", searchUrl=");
        sbR.append((Object) this.searchUrl);
        sbR.append(", ruleSearch=");
        sbR.append(this.ruleSearch);
        sbR.append(", ruleBookInfo=");
        sbR.append(this.ruleBookInfo);
        sbR.append(", ruleToc=");
        sbR.append(this.ruleToc);
        sbR.append(", ruleContent=");
        sbR.append(this.ruleContent);
        sbR.append(')');
        return sbR.toString();
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String unzipFile(@NotNull String str) {
        return c.b.a.m.f.U5(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String utf8ToGbk(@NotNull String str) {
        return c.b.a.m.f.a6(this, str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        j.e(parcel, "out");
        parcel.writeString(this.bookSourceName);
        parcel.writeString(this.bookSourceGroup);
        parcel.writeString(this.bookSourceUrl);
        parcel.writeInt(this.bookSourceType);
        parcel.writeString(this.bookUrlPattern);
        parcel.writeInt(this.customOrder);
        parcel.writeInt(this.enabled ? 1 : 0);
        parcel.writeInt(this.enabledExplore ? 1 : 0);
        parcel.writeString(this.header);
        parcel.writeString(this.loginUrl);
        parcel.writeString(this.bookSourceComment);
        parcel.writeLong(this.lastUpdateTime);
        parcel.writeInt(this.weight);
        parcel.writeString(this.exploreUrl);
        ExploreRule exploreRule = this.ruleExplore;
        if (exploreRule == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            exploreRule.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.searchUrl);
        SearchRule searchRule = this.ruleSearch;
        if (searchRule == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            searchRule.writeToParcel(parcel, flags);
        }
        BookInfoRule bookInfoRule = this.ruleBookInfo;
        if (bookInfoRule == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bookInfoRule.writeToParcel(parcel, flags);
        }
        TocRule tocRule = this.ruleToc;
        if (tocRule == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            tocRule.writeToParcel(parcel, flags);
        }
        ContentRule contentRule = this.ruleContent;
        if (contentRule == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            contentRule.writeToParcel(parcel, flags);
        }
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String base64Decode(@NotNull String str, int i2) {
        return c.b.a.m.f.y0(this, str, i2);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] base64DecodeToByteArray(@Nullable String str, int i2) {
        return c.b.a.m.f.A0(this, str, i2);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String base64Encode(@NotNull String str, int i2) {
        return c.b.a.m.f.C0(this, str, i2);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String encodeURI(@NotNull String str, @NotNull String str2) {
        return c.b.a.m.f.A1(this, str, str2);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String readTxtFile(@NotNull String str, @NotNull String str2) {
        return c.b.a.m.f.E4(this, str, str2);
    }

    /* JADX INFO: compiled from: BookSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J&\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0015¨\u0006\u001a"}, d2 = {"Lio/legado/app/data/entities/BookSource$ExploreKind;", "", "", "component1", "()Ljava/lang/String;", "component2", "title", "url", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lio/legado/app/data/entities/BookSource$ExploreKind;", "toString", "", TTDownloadField.TT_HASHCODE, "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "setTitle", "(Ljava/lang/String;)V", "getUrl", "setUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public static final /* data */ class ExploreKind {

        @NotNull
        private String title;

        @Nullable
        private String url;

        public ExploreKind(@NotNull String str, @Nullable String str2) {
            j.e(str, "title");
            this.title = str;
            this.url = str2;
        }

        public static /* synthetic */ ExploreKind copy$default(ExploreKind exploreKind, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = exploreKind.title;
            }
            if ((i2 & 2) != 0) {
                str2 = exploreKind.url;
            }
            return exploreKind.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final ExploreKind copy(@NotNull String title, @Nullable String url) {
            j.e(title, "title");
            return new ExploreKind(title, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExploreKind)) {
                return false;
            }
            ExploreKind exploreKind = (ExploreKind) other;
            return j.a(this.title, exploreKind.title) && j.a(this.url, exploreKind.url);
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int iHashCode = this.title.hashCode() * 31;
            String str = this.url;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final void setTitle(@NotNull String str) {
            j.e(str, "<set-?>");
            this.title = str;
        }

        public final void setUrl(@Nullable String str) {
            this.url = str;
        }

        @NotNull
        public String toString() {
            StringBuilder sbR = a.r("ExploreKind(title=");
            sbR.append(this.title);
            sbR.append(", url=");
            sbR.append((Object) this.url);
            sbR.append(')');
            return sbR.toString();
        }

        public /* synthetic */ ExploreKind(String str, String str2, int i2, f.c0.c.f fVar) {
            this(str, (i2 & 2) != 0 ? null : str2);
        }
    }

    private final boolean equal(String a, String b2) {
        if (!j.a(a, b2)) {
            if (!(a == null || a.length() == 0)) {
                return false;
            }
            if (!(b2 == null || b2.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ BookSource(String str, String str2, String str3, int i2, String str4, int i3, boolean z, boolean z2, String str5, String str6, String str7, long j2, int i4, String str8, ExploreRule exploreRule, String str9, SearchRule searchRule, BookInfoRule bookInfoRule, TocRule tocRule, ContentRule contentRule, int i5, f.c0.c.f fVar) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? null : str2, (i5 & 4) == 0 ? str3 : "", (i5 & 8) != 0 ? 0 : i2, (i5 & 16) != 0 ? null : str4, (i5 & 32) != 0 ? 0 : i3, (i5 & 64) != 0 ? true : z, (i5 & 128) == 0 ? z2 : true, (i5 & 256) != 0 ? null : str5, (i5 & 512) != 0 ? null : str6, (i5 & 1024) != 0 ? null : str7, (i5 & 2048) != 0 ? 0L : j2, (i5 & 4096) == 0 ? i4 : 0, (i5 & 8192) != 0 ? null : str8, (i5 & 16384) != 0 ? null : exploreRule, (i5 & 32768) != 0 ? null : str9, (i5 & 65536) != 0 ? null : searchRule, (i5 & 131072) != 0 ? null : bookInfoRule, (i5 & 262144) != 0 ? null : tocRule, (i5 & 524288) != 0 ? null : contentRule);
    }
}
