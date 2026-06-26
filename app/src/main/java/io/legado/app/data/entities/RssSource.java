package io.legado.app.data.entities;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.ai;
import e.a.a.c.c;
import e.a.a.d.e;
import e.a.a.d.i;
import e.a.a.d.v.f;
import e.a.a.d.v.l;
import e.a.a.h.n;
import f.c0.c.j;
import f.h;
import f.h0.k;
import io.legado.app.help.JsExtensions;
import io.legado.app.model.analyzeRule.QueryTTF;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import javax.script.SimpleBindings;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Connection;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: RssSource.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index(unique = false, value = {"sourceUrl"})}, tableName = "rssSources")
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b7\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bÿ\u0001\u0012\b\b\u0002\u00103\u001a\u00020\u0003\u0012\b\b\u0002\u00104\u001a\u00020\u0003\u0012\b\b\u0002\u00105\u001a\u00020\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00108\u001a\u00020\n\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010:\u001a\u00020\n\u0012\b\b\u0002\u0010;\u001a\u00020\u0010\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010F\u001a\u00020\n\u0012\b\b\u0002\u0010G\u001a\u00020\n\u0012\b\b\u0002\u0010H\u001a\u00020\u0010¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\u0017J\u0019\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001cJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001cJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b \u0010\u001cJ\u0010\u0010!\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b#\u0010\u001cJ\u0010\u0010$\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b$\u0010\"J\u0010\u0010%\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b%\u0010\u0012J\u0012\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b&\u0010\u001cJ\u0012\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b'\u0010\u001cJ\u0012\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b(\u0010\u001cJ\u0012\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b)\u0010\u001cJ\u0012\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b*\u0010\u001cJ\u0012\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b+\u0010\u001cJ\u0012\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b,\u0010\u001cJ\u0012\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b-\u0010\u001cJ\u0012\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b.\u0010\u001cJ\u0012\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b/\u0010\u001cJ\u0010\u00100\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b0\u0010\"J\u0010\u00101\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b1\u0010\"J\u0010\u00102\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b2\u0010\u0012J\u0086\u0002\u0010I\u001a\u00020\u00002\b\b\u0002\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00108\u001a\u00020\n2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010:\u001a\u00020\n2\b\b\u0002\u0010;\u001a\u00020\u00102\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010F\u001a\u00020\n2\b\b\u0002\u0010G\u001a\u00020\n2\b\b\u0002\u0010H\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\bK\u0010\u001cJ\u0010\u0010L\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\bL\u0010\u0012J \u0010Q\u001a\u00020P2\u0006\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\bQ\u0010RR$\u0010A\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010S\u001a\u0004\bT\u0010\u001c\"\u0004\bU\u0010VR\"\u0010G\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010W\u001a\u0004\bX\u0010\"\"\u0004\bY\u0010ZR\"\u00105\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010S\u001a\u0004\b[\u0010\u001c\"\u0004\b\\\u0010VR$\u0010@\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010S\u001a\u0004\b]\u0010\u001c\"\u0004\b^\u0010VR\"\u0010;\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010_\u001a\u0004\b`\u0010\u0012\"\u0004\ba\u0010bR\"\u00104\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010S\u001a\u0004\bc\u0010\u001c\"\u0004\bd\u0010VR$\u00107\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010S\u001a\u0004\be\u0010\u001c\"\u0004\bf\u0010VR$\u00109\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010S\u001a\u0004\bg\u0010\u001c\"\u0004\bh\u0010VR$\u0010C\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010S\u001a\u0004\bi\u0010\u001c\"\u0004\bj\u0010VR$\u0010E\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010S\u001a\u0004\bk\u0010\u001c\"\u0004\bl\u0010VR$\u0010?\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010S\u001a\u0004\bm\u0010\u001c\"\u0004\bn\u0010VR$\u00106\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010S\u001a\u0004\bo\u0010\u001c\"\u0004\bp\u0010VR$\u0010D\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010S\u001a\u0004\bq\u0010\u001c\"\u0004\br\u0010VR$\u0010B\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010S\u001a\u0004\bs\u0010\u001c\"\u0004\bt\u0010VR\"\u0010F\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010W\u001a\u0004\bu\u0010\"\"\u0004\bv\u0010ZR\"\u00103\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010S\u001a\u0004\bw\u0010\u001c\"\u0004\bx\u0010VR$\u0010<\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010S\u001a\u0004\by\u0010\u001c\"\u0004\bz\u0010VR\"\u00108\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010W\u001a\u0004\b{\u0010\"\"\u0004\b|\u0010ZR\"\u0010:\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010W\u001a\u0004\b}\u0010\"\"\u0004\b~\u0010ZR%\u0010=\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b=\u0010S\u001a\u0004\b\u007f\u0010\u001c\"\u0005\b\u0080\u0001\u0010VR&\u0010>\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b>\u0010S\u001a\u0005\b\u0081\u0001\u0010\u001c\"\u0005\b\u0082\u0001\u0010VR$\u0010H\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bH\u0010_\u001a\u0005\b\u0083\u0001\u0010\u0012\"\u0005\b\u0084\u0001\u0010b¨\u0006\u0087\u0001"}, d2 = {"Lio/legado/app/data/entities/RssSource;", "Landroid/os/Parcelable;", "Lio/legado/app/help/JsExtensions;", "", "jsStr", "", "evalJS", "(Ljava/lang/String;)Ljava/lang/Object;", ai.at, "b", "", "equal", "(Ljava/lang/String;Ljava/lang/String;)Z", "other", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "Ljava/util/HashMap;", "getHeaderMap", "()Ljava/util/HashMap;", "source", "(Lio/legado/app/data/entities/RssSource;)Z", "Ljava/util/LinkedHashMap;", "sortUrls", "()Ljava/util/LinkedHashMap;", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "()Z", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "sourceUrl", "sourceName", "sourceIcon", "sourceGroup", "sourceComment", "enabled", "sortUrl", "singleUrl", "articleStyle", "ruleArticles", "ruleNextPage", "ruleTitle", "rulePubDate", "ruleDescription", "ruleImage", "ruleLink", "ruleContent", "style", "header", "enableJs", "loadWithBaseUrl", "customOrder", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZI)Lio/legado/app/data/entities/RssSource;", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lf/v;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getRuleImage", "setRuleImage", "(Ljava/lang/String;)V", "Z", "getLoadWithBaseUrl", "setLoadWithBaseUrl", "(Z)V", "getSourceIcon", "setSourceIcon", "getRuleDescription", "setRuleDescription", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getArticleStyle", "setArticleStyle", "(I)V", "getSourceName", "setSourceName", "getSourceComment", "setSourceComment", "getSortUrl", "setSortUrl", "getRuleContent", "setRuleContent", "getHeader", "setHeader", "getRulePubDate", "setRulePubDate", "getSourceGroup", "setSourceGroup", "getStyle", "setStyle", "getRuleLink", "setRuleLink", "getEnableJs", "setEnableJs", "getSourceUrl", "setSourceUrl", "getRuleArticles", "setRuleArticles", "getEnabled", "setEnabled", "getSingleUrl", "setSingleUrl", "getRuleNextPage", "setRuleNextPage", "getRuleTitle", "setRuleTitle", "getCustomOrder", "setCustomOrder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZI)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class RssSource implements Parcelable, JsExtensions {

    @NotNull
    public static final Parcelable.Creator<RssSource> CREATOR = new Creator();
    private int articleStyle;
    private int customOrder;
    private boolean enableJs;
    private boolean enabled;

    @Nullable
    private String header;
    private boolean loadWithBaseUrl;

    @Nullable
    private String ruleArticles;

    @Nullable
    private String ruleContent;

    @Nullable
    private String ruleDescription;

    @Nullable
    private String ruleImage;

    @Nullable
    private String ruleLink;

    @Nullable
    private String ruleNextPage;

    @Nullable
    private String rulePubDate;

    @Nullable
    private String ruleTitle;
    private boolean singleUrl;

    @Nullable
    private String sortUrl;

    @Nullable
    private String sourceComment;

    @Nullable
    private String sourceGroup;

    @NotNull
    private String sourceIcon;

    @NotNull
    private String sourceName;

    @PrimaryKey
    @NotNull
    private String sourceUrl;

    @Nullable
    private String style;

    /* JADX INFO: compiled from: RssSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<RssSource> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RssSource createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new RssSource(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RssSource[] newArray(int i2) {
            return new RssSource[i2];
        }
    }

    public RssSource() {
        this(null, null, null, null, null, false, null, false, 0, null, null, null, null, null, null, null, null, null, null, false, false, 0, 4194303, null);
    }

    public RssSource(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, boolean z, @Nullable String str6, boolean z2, int i2, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, boolean z3, boolean z4, int i3) {
        j.e(str, "sourceUrl");
        j.e(str2, "sourceName");
        j.e(str3, "sourceIcon");
        this.sourceUrl = str;
        this.sourceName = str2;
        this.sourceIcon = str3;
        this.sourceGroup = str4;
        this.sourceComment = str5;
        this.enabled = z;
        this.sortUrl = str6;
        this.singleUrl = z2;
        this.articleStyle = i2;
        this.ruleArticles = str7;
        this.ruleNextPage = str8;
        this.ruleTitle = str9;
        this.rulePubDate = str10;
        this.ruleDescription = str11;
        this.ruleImage = str12;
        this.ruleLink = str13;
        this.ruleContent = str14;
        this.style = str15;
        this.header = str16;
        this.enableJs = z3;
        this.loadWithBaseUrl = z4;
        this.customOrder = i3;
    }

    private final Object evalJS(String jsStr) {
        SimpleBindings simpleBindings = new SimpleBindings();
        simpleBindings.put(LogType.JAVA_TYPE, this);
        simpleBindings.put("cookie", f.a);
        simpleBindings.put("cache", i.a);
        c cVar = c.a;
        return c.c().eval(jsStr, simpleBindings);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesBase64DecodeToByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.W(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesBase64DecodeToString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.X(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesDecodeToByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.Y(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesDecodeToString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.Z(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesEncodeToBase64ByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.a0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesEncodeToBase64String(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.b0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] aesEncodeToByteArray(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.c0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String aesEncodeToString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        return c.b.a.m.f.d0(this, str, str2, str3, str4);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String ajax(@NotNull String str) {
        return c.b.a.m.f.e0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public l[] ajaxAll(@NotNull String[] strArr) {
        return c.b.a.m.f.f0(this, strArr);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String base64Decode(@NotNull String str) {
        return c.b.a.m.f.x0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public byte[] base64DecodeToByteArray(@Nullable String str) {
        return c.b.a.m.f.z0(this, str);
    }

    @Override // io.legado.app.help.JsExtensions
    @Nullable
    public String base64Encode(@NotNull String str) {
        return c.b.a.m.f.B0(this, str);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getRuleArticles() {
        return this.ruleArticles;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getRuleNextPage() {
        return this.ruleNextPage;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getRuleTitle() {
        return this.ruleTitle;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getRulePubDate() {
        return this.rulePubDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getRuleDescription() {
        return this.ruleDescription;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getRuleImage() {
        return this.ruleImage;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getRuleLink() {
        return this.ruleLink;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getRuleContent() {
        return this.ruleContent;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getStyle() {
        return this.style;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final boolean getEnableJs() {
        return this.enableJs;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getLoadWithBaseUrl() {
        return this.loadWithBaseUrl;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getCustomOrder() {
        return this.customOrder;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSourceIcon() {
        return this.sourceIcon;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSourceGroup() {
        return this.sourceGroup;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSourceComment() {
        return this.sourceComment;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSortUrl() {
        return this.sortUrl;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getSingleUrl() {
        return this.singleUrl;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getArticleStyle() {
        return this.articleStyle;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public Object connect(@NotNull String str) {
        return c.b.a.m.f.X0(this, str);
    }

    @NotNull
    public final RssSource copy(@NotNull String sourceUrl, @NotNull String sourceName, @NotNull String sourceIcon, @Nullable String sourceGroup, @Nullable String sourceComment, boolean enabled, @Nullable String sortUrl, boolean singleUrl, int articleStyle, @Nullable String ruleArticles, @Nullable String ruleNextPage, @Nullable String ruleTitle, @Nullable String rulePubDate, @Nullable String ruleDescription, @Nullable String ruleImage, @Nullable String ruleLink, @Nullable String ruleContent, @Nullable String style, @Nullable String header, boolean enableJs, boolean loadWithBaseUrl, int customOrder) {
        j.e(sourceUrl, "sourceUrl");
        j.e(sourceName, "sourceName");
        j.e(sourceIcon, "sourceIcon");
        return new RssSource(sourceUrl, sourceName, sourceIcon, sourceGroup, sourceComment, enabled, sortUrl, singleUrl, articleStyle, ruleArticles, ruleNextPage, ruleTitle, rulePubDate, ruleDescription, ruleImage, ruleLink, ruleContent, style, header, enableJs, loadWithBaseUrl, customOrder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String downloadFile(@NotNull String str, @NotNull String str2) {
        return c.b.a.m.f.v1(this, str, str2);
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String encodeURI(@NotNull String str) {
        return c.b.a.m.f.z1(this, str);
    }

    public final boolean equal(@NotNull RssSource source) {
        j.e(source, "source");
        return equal(this.sourceUrl, source.sourceUrl) && equal(this.sourceIcon, source.sourceIcon) && this.enabled == source.enabled && equal(this.sourceGroup, source.sourceGroup) && equal(this.ruleArticles, source.ruleArticles) && equal(this.ruleNextPage, source.ruleNextPage) && equal(this.ruleTitle, source.ruleTitle) && equal(this.rulePubDate, source.rulePubDate) && equal(this.ruleDescription, source.ruleDescription) && equal(this.ruleLink, source.ruleLink) && equal(this.ruleContent, source.ruleContent) && this.enableJs == source.enableJs && this.loadWithBaseUrl == source.loadWithBaseUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof RssSource) {
            return j.a(((RssSource) other).sourceUrl, this.sourceUrl);
        }
        return false;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public Connection.Response get(@NotNull String str, @NotNull Map<String, String> map) {
        return c.b.a.m.f.K1(this, str, map);
    }

    public final int getArticleStyle() {
        return this.articleStyle;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String getCookie(@NotNull String str, @Nullable String str2) {
        return c.b.a.m.f.f2(this, str, str2);
    }

    public final int getCustomOrder() {
        return this.customOrder;
    }

    public final boolean getEnableJs() {
        return this.enableJs;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final String getHeader() {
        return this.header;
    }

    @NotNull
    public final HashMap<String, String> getHeaderMap() {
        Object objM11constructorimpl;
        HashMap<String, String> map = new HashMap<>();
        e eVar = e.a;
        map.put("User-Agent", e.f5518c);
        String header = getHeader();
        if (header != null) {
            Gson gsonA = n.a();
            if (k.H(header, "@js:", true)) {
                String strSubstring = header.substring(4);
                j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                header = String.valueOf(evalJS(strSubstring));
            } else if (k.H(header, "<js>", true)) {
                String strSubstring2 = header.substring(4, k.u(header, "<", 0, false, 6));
                j.d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                header = String.valueOf(evalJS(strSubstring2));
            }
            try {
                Type type = new TypeToken<Map<String, ? extends String>>() { // from class: io.legado.app.data.entities.RssSource$getHeaderMap$lambda-2$lambda-1$$inlined$fromJsonObject$1
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
            Map<? extends String, ? extends String> map2 = (Map) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
            if (map2 != null) {
                map.putAll(map2);
            }
        }
        return map;
    }

    public final boolean getLoadWithBaseUrl() {
        return this.loadWithBaseUrl;
    }

    @Nullable
    public final String getRuleArticles() {
        return this.ruleArticles;
    }

    @Nullable
    public final String getRuleContent() {
        return this.ruleContent;
    }

    @Nullable
    public final String getRuleDescription() {
        return this.ruleDescription;
    }

    @Nullable
    public final String getRuleImage() {
        return this.ruleImage;
    }

    @Nullable
    public final String getRuleLink() {
        return this.ruleLink;
    }

    @Nullable
    public final String getRuleNextPage() {
        return this.ruleNextPage;
    }

    @Nullable
    public final String getRulePubDate() {
        return this.rulePubDate;
    }

    @Nullable
    public final String getRuleTitle() {
        return this.ruleTitle;
    }

    public final boolean getSingleUrl() {
        return this.singleUrl;
    }

    @Nullable
    public final String getSortUrl() {
        return this.sortUrl;
    }

    @Nullable
    public final String getSourceComment() {
        return this.sourceComment;
    }

    @Nullable
    public final String getSourceGroup() {
        return this.sourceGroup;
    }

    @NotNull
    public final String getSourceIcon() {
        return this.sourceIcon;
    }

    @NotNull
    public final String getSourceName() {
        return this.sourceName;
    }

    @NotNull
    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    @Nullable
    public final String getStyle() {
        return this.style;
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String getTxtInFolder(@NotNull String str) {
        return c.b.a.m.f.a3(this, str);
    }

    public int hashCode() {
        return this.sourceUrl.hashCode();
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

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String replaceFont(@NotNull String str, @Nullable QueryTTF queryTTF, @Nullable QueryTTF queryTTF2) {
        return c.b.a.m.f.I4(this, str, queryTTF, queryTTF2);
    }

    public final void setArticleStyle(int i2) {
        this.articleStyle = i2;
    }

    public final void setCustomOrder(int i2) {
        this.customOrder = i2;
    }

    public final void setEnableJs(boolean z) {
        this.enableJs = z;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setHeader(@Nullable String str) {
        this.header = str;
    }

    public final void setLoadWithBaseUrl(boolean z) {
        this.loadWithBaseUrl = z;
    }

    public final void setRuleArticles(@Nullable String str) {
        this.ruleArticles = str;
    }

    public final void setRuleContent(@Nullable String str) {
        this.ruleContent = str;
    }

    public final void setRuleDescription(@Nullable String str) {
        this.ruleDescription = str;
    }

    public final void setRuleImage(@Nullable String str) {
        this.ruleImage = str;
    }

    public final void setRuleLink(@Nullable String str) {
        this.ruleLink = str;
    }

    public final void setRuleNextPage(@Nullable String str) {
        this.ruleNextPage = str;
    }

    public final void setRulePubDate(@Nullable String str) {
        this.rulePubDate = str;
    }

    public final void setRuleTitle(@Nullable String str) {
        this.ruleTitle = str;
    }

    public final void setSingleUrl(boolean z) {
        this.singleUrl = z;
    }

    public final void setSortUrl(@Nullable String str) {
        this.sortUrl = str;
    }

    public final void setSourceComment(@Nullable String str) {
        this.sourceComment = str;
    }

    public final void setSourceGroup(@Nullable String str) {
        this.sourceGroup = str;
    }

    public final void setSourceIcon(@NotNull String str) {
        j.e(str, "<set-?>");
        this.sourceIcon = str;
    }

    public final void setSourceName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.sourceName = str;
    }

    public final void setSourceUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.sourceUrl = str;
    }

    public final void setStyle(@Nullable String str) {
        this.style = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f A[Catch: all -> 0x012a, TryCatch #0 {all -> 0x012a, blocks: (B:3:0x0005, B:7:0x001d, B:10:0x0028, B:14:0x0039, B:38:0x0117, B:40:0x011d, B:41:0x0124, B:29:0x00dc, B:32:0x00ea, B:33:0x00ee, B:35:0x00f4, B:37:0x010b, B:13:0x002f, B:16:0x003f, B:19:0x005c, B:21:0x0062, B:23:0x0093, B:25:0x00c3, B:24:0x00a5, B:6:0x0013), top: B:46:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f4 A[Catch: all -> 0x012a, TryCatch #0 {all -> 0x012a, blocks: (B:3:0x0005, B:7:0x001d, B:10:0x0028, B:14:0x0039, B:38:0x0117, B:40:0x011d, B:41:0x0124, B:29:0x00dc, B:32:0x00ea, B:33:0x00ee, B:35:0x00f4, B:37:0x010b, B:13:0x002f, B:16:0x003f, B:19:0x005c, B:21:0x0062, B:23:0x0093, B:25:0x00c3, B:24:0x00a5, B:6:0x0013), top: B:46:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011d A[Catch: all -> 0x012a, TryCatch #0 {all -> 0x012a, blocks: (B:3:0x0005, B:7:0x001d, B:10:0x0028, B:14:0x0039, B:38:0x0117, B:40:0x011d, B:41:0x0124, B:29:0x00dc, B:32:0x00ea, B:33:0x00ee, B:35:0x00f4, B:37:0x010b, B:13:0x002f, B:16:0x003f, B:19:0x005c, B:21:0x0062, B:23:0x0093, B:25:0x00c3, B:24:0x00a5, B:6:0x0013), top: B:46:0x0005 }] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.LinkedHashMap<java.lang.String, java.lang.String> sortUrls() {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.data.entities.RssSource.sortUrls():java.util.LinkedHashMap");
    }

    @Override // io.legado.app.help.JsExtensions
    @NotNull
    public String timeFormat(long j2) {
        return c.b.a.m.f.F5(this, j2);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("RssSource(sourceUrl=");
        sbR.append(this.sourceUrl);
        sbR.append(", sourceName=");
        sbR.append(this.sourceName);
        sbR.append(", sourceIcon=");
        sbR.append(this.sourceIcon);
        sbR.append(", sourceGroup=");
        sbR.append((Object) this.sourceGroup);
        sbR.append(", sourceComment=");
        sbR.append((Object) this.sourceComment);
        sbR.append(", enabled=");
        sbR.append(this.enabled);
        sbR.append(", sortUrl=");
        sbR.append((Object) this.sortUrl);
        sbR.append(", singleUrl=");
        sbR.append(this.singleUrl);
        sbR.append(", articleStyle=");
        sbR.append(this.articleStyle);
        sbR.append(", ruleArticles=");
        sbR.append((Object) this.ruleArticles);
        sbR.append(", ruleNextPage=");
        sbR.append((Object) this.ruleNextPage);
        sbR.append(", ruleTitle=");
        sbR.append((Object) this.ruleTitle);
        sbR.append(", rulePubDate=");
        sbR.append((Object) this.rulePubDate);
        sbR.append(", ruleDescription=");
        sbR.append((Object) this.ruleDescription);
        sbR.append(", ruleImage=");
        sbR.append((Object) this.ruleImage);
        sbR.append(", ruleLink=");
        sbR.append((Object) this.ruleLink);
        sbR.append(", ruleContent=");
        sbR.append((Object) this.ruleContent);
        sbR.append(", style=");
        sbR.append((Object) this.style);
        sbR.append(", header=");
        sbR.append((Object) this.header);
        sbR.append(", enableJs=");
        sbR.append(this.enableJs);
        sbR.append(", loadWithBaseUrl=");
        sbR.append(this.loadWithBaseUrl);
        sbR.append(", customOrder=");
        return a.n(sbR, this.customOrder, ')');
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
        parcel.writeString(this.sourceUrl);
        parcel.writeString(this.sourceName);
        parcel.writeString(this.sourceIcon);
        parcel.writeString(this.sourceGroup);
        parcel.writeString(this.sourceComment);
        parcel.writeInt(this.enabled ? 1 : 0);
        parcel.writeString(this.sortUrl);
        parcel.writeInt(this.singleUrl ? 1 : 0);
        parcel.writeInt(this.articleStyle);
        parcel.writeString(this.ruleArticles);
        parcel.writeString(this.ruleNextPage);
        parcel.writeString(this.ruleTitle);
        parcel.writeString(this.rulePubDate);
        parcel.writeString(this.ruleDescription);
        parcel.writeString(this.ruleImage);
        parcel.writeString(this.ruleLink);
        parcel.writeString(this.ruleContent);
        parcel.writeString(this.style);
        parcel.writeString(this.header);
        parcel.writeInt(this.enableJs ? 1 : 0);
        parcel.writeInt(this.loadWithBaseUrl ? 1 : 0);
        parcel.writeInt(this.customOrder);
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

    public /* synthetic */ RssSource(String str, String str2, String str3, String str4, String str5, boolean z, String str6, boolean z2, int i2, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, boolean z3, boolean z4, int i3, int i4, f.c0.c.f fVar) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) == 0 ? str3 : "", (i4 & 8) != 0 ? null : str4, (i4 & 16) != 0 ? null : str5, (i4 & 32) != 0 ? true : z, (i4 & 64) != 0 ? null : str6, (i4 & 128) != 0 ? false : z2, (i4 & 256) != 0 ? 0 : i2, (i4 & 512) != 0 ? null : str7, (i4 & 1024) != 0 ? null : str8, (i4 & 2048) != 0 ? null : str9, (i4 & 4096) != 0 ? null : str10, (i4 & 8192) != 0 ? null : str11, (i4 & 16384) != 0 ? null : str12, (i4 & 32768) != 0 ? null : str13, (i4 & 65536) != 0 ? null : str14, (i4 & 131072) != 0 ? null : str15, (i4 & 262144) != 0 ? null : str16, (i4 & 524288) != 0 ? false : z3, (i4 & 1048576) != 0 ? false : z4, (i4 & 2097152) != 0 ? 0 : i3);
    }
}
