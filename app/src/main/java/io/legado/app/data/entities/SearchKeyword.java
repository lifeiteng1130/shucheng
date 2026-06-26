package io.legado.app.data.entities;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.a.a.c.b;
import f.c0.c.f;
import f.c0.c.j;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: SearchKeyword.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(indices = {@Index(unique = true, value = {"word"})}, tableName = "search_keywords")
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010!R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010%R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010&\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lio/legado/app/data/entities/SearchKeyword;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "component3", "()J", "word", "usage", "lastUseTime", "copy", "(Ljava/lang/String;IJ)Lio/legado/app/data/entities/SearchKeyword;", "toString", TTDownloadField.TT_HASHCODE, "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lf/v;", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getLastUseTime", "setLastUseTime", "(J)V", "Ljava/lang/String;", "getWord", "setWord", "(Ljava/lang/String;)V", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getUsage", "setUsage", "(I)V", "<init>", "(Ljava/lang/String;IJ)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class SearchKeyword implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SearchKeyword> CREATOR = new Creator();
    private long lastUseTime;
    private int usage;

    @PrimaryKey
    @NotNull
    private String word;

    /* JADX INFO: compiled from: SearchKeyword.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<SearchKeyword> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SearchKeyword createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new SearchKeyword(parcel.readString(), parcel.readInt(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SearchKeyword[] newArray(int i2) {
            return new SearchKeyword[i2];
        }
    }

    public SearchKeyword() {
        this(null, 0, 0L, 7, null);
    }

    public SearchKeyword(@NotNull String str, int i2, long j2) {
        j.e(str, "word");
        this.word = str;
        this.usage = i2;
        this.lastUseTime = j2;
    }

    public static /* synthetic */ SearchKeyword copy$default(SearchKeyword searchKeyword, String str, int i2, long j2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = searchKeyword.word;
        }
        if ((i3 & 2) != 0) {
            i2 = searchKeyword.usage;
        }
        if ((i3 & 4) != 0) {
            j2 = searchKeyword.lastUseTime;
        }
        return searchKeyword.copy(str, i2, j2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getWord() {
        return this.word;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getUsage() {
        return this.usage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getLastUseTime() {
        return this.lastUseTime;
    }

    @NotNull
    public final SearchKeyword copy(@NotNull String word, int usage, long lastUseTime) {
        j.e(word, "word");
        return new SearchKeyword(word, usage, lastUseTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchKeyword)) {
            return false;
        }
        SearchKeyword searchKeyword = (SearchKeyword) other;
        return j.a(this.word, searchKeyword.word) && this.usage == searchKeyword.usage && this.lastUseTime == searchKeyword.lastUseTime;
    }

    public final long getLastUseTime() {
        return this.lastUseTime;
    }

    public final int getUsage() {
        return this.usage;
    }

    @NotNull
    public final String getWord() {
        return this.word;
    }

    public int hashCode() {
        return b.a(this.lastUseTime) + (((this.word.hashCode() * 31) + this.usage) * 31);
    }

    public final void setLastUseTime(long j2) {
        this.lastUseTime = j2;
    }

    public final void setUsage(int i2) {
        this.usage = i2;
    }

    public final void setWord(@NotNull String str) {
        j.e(str, "<set-?>");
        this.word = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("SearchKeyword(word=");
        sbR.append(this.word);
        sbR.append(", usage=");
        sbR.append(this.usage);
        sbR.append(", lastUseTime=");
        sbR.append(this.lastUseTime);
        sbR.append(')');
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        j.e(parcel, "out");
        parcel.writeString(this.word);
        parcel.writeInt(this.usage);
        parcel.writeLong(this.lastUseTime);
    }

    public /* synthetic */ SearchKeyword(String str, int i2, long j2, int i3, f fVar) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 1 : i2, (i3 & 4) != 0 ? System.currentTimeMillis() : j2);
    }
}
