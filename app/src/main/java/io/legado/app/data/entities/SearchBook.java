package io.legado.app.data.entities;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import c.a.a.a.a;
import c.b.a.m.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.a.a.h.n;
import f.c0.c.j;
import f.e;
import io.legado.app.data.entities.BaseBook;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: SearchBook.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"origin"}, entity = BookSource.class, onDelete = 5, parentColumns = {"bookSourceUrl"})}, indices = {@Index(unique = true, value = {"bookUrl"}), @Index(unique = false, value = {"origin"})}, tableName = "searchBooks")
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B©\u0001\u0012\b\b\u0002\u0010-\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010.\u001a\u00020\u000e\u0012\b\b\u0002\u0010/\u001a\u00020\t\u0012\b\b\u0002\u00100\u001a\u00020\u000e\u0012\b\b\u0002\u00101\u001a\u00020\u000e\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u00107\u001a\u00020\u000e\u0012\b\b\u0002\u00108\u001a\u00020(\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010:\u001a\u00020\t¢\u0006\u0004\b~\u0010\u007fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0018J\u0010\u0010\u001d\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0018J\u0010\u0010\u001e\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u000bJ\u0010\u0010 \u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b \u0010\u0018J\u0010\u0010!\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b!\u0010\u0018J\u0012\u0010\"\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\"\u0010\u0018J\u0012\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b#\u0010\u0018J\u0012\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b$\u0010\u0018J\u0012\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b%\u0010\u0018J\u0012\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b&\u0010\u0018J\u0010\u0010'\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b'\u0010\u0018J\u0010\u0010)\u001a\u00020(HÆ\u0003¢\u0006\u0004\b)\u0010*J\u0012\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b+\u0010\u0018J\u0010\u0010,\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b,\u0010\u000bJ²\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\t2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000e2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u00107\u001a\u00020\u000e2\b\b\u0002\u00108\u001a\u00020(2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010:\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b=\u0010\u0018J\u0010\u0010>\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b>\u0010\u000bJ \u0010B\u001a\u00020\u00112\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020\tHÖ\u0001¢\u0006\u0004\bB\u0010CR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010D\u001a\u0004\bE\u0010\u0018\"\u0004\bF\u0010\u0016R\"\u0010/\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010G\u001a\u0004\bH\u0010\u000b\"\u0004\bI\u0010JR3\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u000e0Kj\b\u0012\u0004\u0012\u00020\u000e`L8F@\u0007X\u0087\u0084\u0002¢\u0006\u0012\n\u0004\bM\u0010N\u0012\u0004\bQ\u0010R\u001a\u0004\bO\u0010PR\"\u0010:\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010G\u001a\u0004\bT\u0010\u000b\"\u0004\bU\u0010JR$\u00105\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u0010D\u001a\u0004\bV\u0010\u0018\"\u0004\bW\u0010\u0016R$\u00106\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010D\u001a\u0004\bX\u0010\u0018\"\u0004\bY\u0010\u0016R\"\u00107\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010D\u001a\u0004\bZ\u0010\u0018\"\u0004\b[\u0010\u0016R*\u0010\\\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0004\b\\\u0010D\u0012\u0004\b_\u0010R\u001a\u0004\b]\u0010\u0018\"\u0004\b^\u0010\u0016R$\u00103\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010D\u001a\u0004\b`\u0010\u0018\"\u0004\ba\u0010\u0016R\"\u00108\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010b\u001a\u0004\bc\u0010*\"\u0004\bd\u0010eR$\u00102\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b2\u0010D\u001a\u0004\bf\u0010\u0018\"\u0004\bg\u0010\u0016R*\u0010h\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0004\bh\u0010D\u0012\u0004\bk\u0010R\u001a\u0004\bi\u0010\u0018\"\u0004\bj\u0010\u0016R$\u00109\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010D\u001a\u0004\bl\u0010\u0018\"\u0004\bm\u0010\u0016R/\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0n8V@\u0017X\u0097\u0084\u0002¢\u0006\u0012\n\u0004\bo\u0010N\u0012\u0004\br\u0010R\u001a\u0004\bp\u0010qR$\u00104\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010D\u001a\u0004\bt\u0010\u0018\"\u0004\bu\u0010\u0016R\"\u00101\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b1\u0010D\u001a\u0004\bv\u0010\u0018\"\u0004\bw\u0010\u0016R\"\u0010-\u001a\u00020\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b-\u0010D\u001a\u0004\bx\u0010\u0018\"\u0004\by\u0010\u0016R\"\u0010.\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010D\u001a\u0004\bz\u0010\u0018\"\u0004\b{\u0010\u0016R\"\u00100\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b0\u0010D\u001a\u0004\b|\u0010\u0018\"\u0004\b}\u0010\u0016¨\u0006\u0080\u0001"}, d2 = {"Lio/legado/app/data/entities/SearchBook;", "Landroid/os/Parcelable;", "Lio/legado/app/data/entities/BaseBook;", "", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "compareTo", "(Lio/legado/app/data/entities/SearchBook;)I", "", "key", ES6Iterator.VALUE_PROPERTY, "Lf/v;", "putVariable", "(Ljava/lang/String;Ljava/lang/String;)V", "origin", "addOrigin", "(Ljava/lang/String;)V", "getDisplayLastChapterTitle", "()Ljava/lang/String;", "Lio/legado/app/data/entities/Book;", "toBook", "()Lio/legado/app/data/entities/Book;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "", "component13", "()J", "component14", "component15", "bookUrl", "originName", "type", "name", "author", "kind", "coverUrl", "intro", "wordCount", "latestChapterTitle", "tocUrl", "time", "variable", "originOrder", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;I)Lio/legado/app/data/entities/SearchBook;", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getOrigin", "setOrigin", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getType", "setType", "(I)V", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "origins$delegate", "Lf/e;", "getOrigins", "()Ljava/util/LinkedHashSet;", "getOrigins$annotations", "()V", "origins", "getOriginOrder", "setOriginOrder", "getWordCount", "setWordCount", "getLatestChapterTitle", "setLatestChapterTitle", "getTocUrl", "setTocUrl", "tocHtml", "getTocHtml", "setTocHtml", "getTocHtml$annotations", "getCoverUrl", "setCoverUrl", "J", "getTime", "setTime", "(J)V", "getKind", "setKind", "infoHtml", "getInfoHtml", "setInfoHtml", "getInfoHtml$annotations", "getVariable", "setVariable", "Ljava/util/HashMap;", "variableMap$delegate", "getVariableMap", "()Ljava/util/HashMap;", "getVariableMap$annotations", "variableMap", "getIntro", "setIntro", "getAuthor", "setAuthor", "getBookUrl", "setBookUrl", "getOriginName", "setOriginName", "getName", "setName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;I)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class SearchBook implements Parcelable, BaseBook, Comparable<SearchBook> {

    @NotNull
    public static final Parcelable.Creator<SearchBook> CREATOR = new Creator();

    @NotNull
    private String author;

    @PrimaryKey
    @NotNull
    private String bookUrl;

    @Nullable
    private String coverUrl;

    @Ignore
    @Nullable
    private String infoHtml;

    @Nullable
    private String intro;

    @Nullable
    private String kind;

    @Nullable
    private String latestChapterTitle;

    @NotNull
    private String name;

    @NotNull
    private String origin;

    @NotNull
    private String originName;
    private int originOrder;

    /* JADX INFO: renamed from: origins$delegate, reason: from kotlin metadata */
    @Ignore
    @NotNull
    private final transient e origins;
    private long time;

    @Ignore
    @Nullable
    private String tocHtml;

    @NotNull
    private String tocUrl;
    private int type;

    @Nullable
    private String variable;

    /* JADX INFO: renamed from: variableMap$delegate, reason: from kotlin metadata */
    @Ignore
    @NotNull
    private final transient e variableMap;

    @Nullable
    private String wordCount;

    /* JADX INFO: compiled from: SearchBook.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<SearchBook> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SearchBook createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new SearchBook(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SearchBook[] newArray(int i2) {
            return new SearchBook[i2];
        }
    }

    public SearchBook() {
        this(null, null, null, 0, null, null, null, null, null, null, null, null, 0L, null, 0, 32767, null);
    }

    public SearchBook(@NotNull String str, @NotNull String str2, @NotNull String str3, int i2, @NotNull String str4, @NotNull String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @NotNull String str11, long j2, @Nullable String str12, int i3) {
        j.e(str, "bookUrl");
        j.e(str2, "origin");
        j.e(str3, "originName");
        j.e(str4, "name");
        j.e(str5, "author");
        j.e(str11, "tocUrl");
        this.bookUrl = str;
        this.origin = str2;
        this.originName = str3;
        this.type = i2;
        this.name = str4;
        this.author = str5;
        this.kind = str6;
        this.coverUrl = str7;
        this.intro = str8;
        this.wordCount = str9;
        this.latestChapterTitle = str10;
        this.tocUrl = str11;
        this.time = j2;
        this.variable = str12;
        this.originOrder = i3;
        this.variableMap = f.N3(new SearchBook$variableMap$2(this));
        this.origins = f.N3(new SearchBook$origins$2(this));
    }

    public static /* synthetic */ void getInfoHtml$annotations() {
    }

    public static /* synthetic */ void getOrigins$annotations() {
    }

    public static /* synthetic */ void getTocHtml$annotations() {
    }

    public static /* synthetic */ void getVariableMap$annotations() {
    }

    public final void addOrigin(@NotNull String origin) {
        j.e(origin, "origin");
        getOrigins().add(origin);
    }

    @NotNull
    public final String component1() {
        return getBookUrl();
    }

    @Nullable
    public final String component10() {
        return getWordCount();
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getLatestChapterTitle() {
        return this.latestChapterTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTocUrl() {
        return this.tocUrl;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getVariable() {
        return this.variable;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getOriginOrder() {
        return this.originOrder;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOrigin() {
        return this.origin;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOriginName() {
        return this.originName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String component5() {
        return getName();
    }

    @NotNull
    public final String component6() {
        return getAuthor();
    }

    @Nullable
    public final String component7() {
        return getKind();
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getIntro() {
        return this.intro;
    }

    @NotNull
    public final SearchBook copy(@NotNull String bookUrl, @NotNull String origin, @NotNull String originName, int type, @NotNull String name, @NotNull String author, @Nullable String kind, @Nullable String coverUrl, @Nullable String intro, @Nullable String wordCount, @Nullable String latestChapterTitle, @NotNull String tocUrl, long time, @Nullable String variable, int originOrder) {
        j.e(bookUrl, "bookUrl");
        j.e(origin, "origin");
        j.e(originName, "originName");
        j.e(name, "name");
        j.e(author, "author");
        j.e(tocUrl, "tocUrl");
        return new SearchBook(bookUrl, origin, originName, type, name, author, kind, coverUrl, intro, wordCount, latestChapterTitle, tocUrl, time, variable, originOrder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof SearchBook) && j.a(((SearchBook) other).getBookUrl(), getBookUrl());
    }

    @Override // io.legado.app.data.entities.BaseBook
    @NotNull
    public String getAuthor() {
        return this.author;
    }

    @Override // io.legado.app.data.entities.BaseBook
    @NotNull
    public String getBookUrl() {
        return this.bookUrl;
    }

    @Nullable
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final String getDisplayLastChapterTitle() {
        String str = this.latestChapterTitle;
        if (str == null) {
            return "无最新章节";
        }
        return str.length() > 0 ? str : "无最新章节";
    }

    @Override // io.legado.app.data.entities.BaseBook
    @Nullable
    public String getInfoHtml() {
        return this.infoHtml;
    }

    @Nullable
    public final String getIntro() {
        return this.intro;
    }

    @Override // io.legado.app.data.entities.BaseBook
    @Nullable
    public String getKind() {
        return this.kind;
    }

    @Override // io.legado.app.data.entities.BaseBook
    @NotNull
    public List<String> getKindList() {
        return BaseBook.DefaultImpls.getKindList(this);
    }

    @Nullable
    public final String getLatestChapterTitle() {
        return this.latestChapterTitle;
    }

    @Override // io.legado.app.data.entities.BaseBook
    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public final String getOrigin() {
        return this.origin;
    }

    @NotNull
    public final String getOriginName() {
        return this.originName;
    }

    public final int getOriginOrder() {
        return this.originOrder;
    }

    @NotNull
    public final LinkedHashSet<String> getOrigins() {
        return (LinkedHashSet) this.origins.getValue();
    }

    public final long getTime() {
        return this.time;
    }

    @Override // io.legado.app.data.entities.BaseBook
    @Nullable
    public String getTocHtml() {
        return this.tocHtml;
    }

    @NotNull
    public final String getTocUrl() {
        return this.tocUrl;
    }

    public final int getType() {
        return this.type;
    }

    @Nullable
    public final String getVariable() {
        return this.variable;
    }

    @Override // io.legado.app.model.analyzeRule.RuleDataInterface
    @NotNull
    public HashMap<String, String> getVariableMap() {
        return (HashMap) this.variableMap.getValue();
    }

    @Override // io.legado.app.data.entities.BaseBook
    @Nullable
    public String getWordCount() {
        return this.wordCount;
    }

    public int hashCode() {
        return getBookUrl().hashCode();
    }

    @Override // io.legado.app.model.analyzeRule.RuleDataInterface
    public void putVariable(@NotNull String key, @NotNull String value) {
        j.e(key, "key");
        j.e(value, ES6Iterator.VALUE_PROPERTY);
        getVariableMap().put(key, value);
        this.variable = n.a().toJson(getVariableMap());
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setAuthor(@NotNull String str) {
        j.e(str, "<set-?>");
        this.author = str;
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setBookUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.bookUrl = str;
    }

    public final void setCoverUrl(@Nullable String str) {
        this.coverUrl = str;
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setInfoHtml(@Nullable String str) {
        this.infoHtml = str;
    }

    public final void setIntro(@Nullable String str) {
        this.intro = str;
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setKind(@Nullable String str) {
        this.kind = str;
    }

    public final void setLatestChapterTitle(@Nullable String str) {
        this.latestChapterTitle = str;
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.name = str;
    }

    public final void setOrigin(@NotNull String str) {
        j.e(str, "<set-?>");
        this.origin = str;
    }

    public final void setOriginName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.originName = str;
    }

    public final void setOriginOrder(int i2) {
        this.originOrder = i2;
    }

    public final void setTime(long j2) {
        this.time = j2;
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setTocHtml(@Nullable String str) {
        this.tocHtml = str;
    }

    public final void setTocUrl(@NotNull String str) {
        j.e(str, "<set-?>");
        this.tocUrl = str;
    }

    public final void setType(int i2) {
        this.type = i2;
    }

    public final void setVariable(@Nullable String str) {
        this.variable = str;
    }

    @Override // io.legado.app.data.entities.BaseBook
    public void setWordCount(@Nullable String str) {
        this.wordCount = str;
    }

    @NotNull
    public final Book toBook() {
        String name = getName();
        String author = getAuthor();
        String kind = getKind();
        String bookUrl = getBookUrl();
        String str = this.origin;
        String str2 = this.originName;
        int i2 = this.type;
        String wordCount = getWordCount();
        String str3 = this.latestChapterTitle;
        String str4 = null;
        String str5 = null;
        Book book = new Book(bookUrl, this.tocUrl, str, str2, name, author, kind, str4, this.coverUrl, str5, this.intro, null, null, i2, 0L, str3, 0L, 0L, 0, 0, null, 0, 0, 0L, wordCount, false, 0, this.originOrder, this.variable, null, 654269056, null);
        book.setInfoHtml(getInfoHtml());
        book.setTocUrl(getTocUrl());
        return book;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("SearchBook(bookUrl=");
        sbR.append(getBookUrl());
        sbR.append(", origin=");
        sbR.append(this.origin);
        sbR.append(", originName=");
        sbR.append(this.originName);
        sbR.append(", type=");
        sbR.append(this.type);
        sbR.append(", name=");
        sbR.append(getName());
        sbR.append(", author=");
        sbR.append(getAuthor());
        sbR.append(", kind=");
        sbR.append((Object) getKind());
        sbR.append(", coverUrl=");
        sbR.append((Object) this.coverUrl);
        sbR.append(", intro=");
        sbR.append((Object) this.intro);
        sbR.append(", wordCount=");
        sbR.append((Object) getWordCount());
        sbR.append(", latestChapterTitle=");
        sbR.append((Object) this.latestChapterTitle);
        sbR.append(", tocUrl=");
        sbR.append(this.tocUrl);
        sbR.append(", time=");
        sbR.append(this.time);
        sbR.append(", variable=");
        sbR.append((Object) this.variable);
        sbR.append(", originOrder=");
        return a.n(sbR, this.originOrder, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        j.e(parcel, "out");
        parcel.writeString(this.bookUrl);
        parcel.writeString(this.origin);
        parcel.writeString(this.originName);
        parcel.writeInt(this.type);
        parcel.writeString(this.name);
        parcel.writeString(this.author);
        parcel.writeString(this.kind);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.intro);
        parcel.writeString(this.wordCount);
        parcel.writeString(this.latestChapterTitle);
        parcel.writeString(this.tocUrl);
        parcel.writeLong(this.time);
        parcel.writeString(this.variable);
        parcel.writeInt(this.originOrder);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull SearchBook other) {
        j.e(other, "other");
        return other.originOrder - this.originOrder;
    }

    public /* synthetic */ SearchBook(String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j2, String str12, int i3, int i4, f.c0.c.f fVar) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? "" : str4, (i4 & 32) != 0 ? "" : str5, (i4 & 64) != 0 ? null : str6, (i4 & 128) != 0 ? null : str7, (i4 & 256) != 0 ? null : str8, (i4 & 512) != 0 ? null : str9, (i4 & 1024) != 0 ? null : str10, (i4 & 2048) == 0 ? str11 : "", (i4 & 4096) != 0 ? System.currentTimeMillis() : j2, (i4 & 8192) == 0 ? str12 : null, (i4 & 16384) != 0 ? 0 : i3);
    }
}
