package io.legado.app.data.entities;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import c.a.a.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.c;
import e.a.a.c.b;
import f.c0.c.f;
import f.c0.c.j;
import io.wenyuange.app.release.R;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: BookGroup.kt */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = "book_groups")
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b3\u00104J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\tJ\u0010\u0010\u0015\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J8\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0013J\u0010\u0010\u001e\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001e\u0010\tJ \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0017\u001a\u00020\u000f8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b&\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010*R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010+\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010.R\"\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u0010\t\"\u0004\b1\u00102¨\u00065"}, d2 = {"Lio/legado/app/data/entities/BookGroup;", "Landroid/os/Parcelable;", "Landroid/content/Context;", c.R, "", "getManageName", "(Landroid/content/Context;)Ljava/lang/String;", "", TTDownloadField.TT_HASHCODE, "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "component1", "()J", "component2", "()Ljava/lang/String;", "component3", "component4", "()Z", "groupId", "groupName", "order", "show", "copy", "(JLjava/lang/String;IZ)Lio/legado/app/data/entities/BookGroup;", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lf/v;", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getGroupId", "Ljava/lang/String;", "getGroupName", "setGroupName", "(Ljava/lang/String;)V", "Z", "getShow", "setShow", "(Z)V", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getOrder", "setOrder", "(I)V", "<init>", "(JLjava/lang/String;IZ)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final /* data */ class BookGroup implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BookGroup> CREATOR = new Creator();

    @PrimaryKey
    private final long groupId;

    @NotNull
    private String groupName;
    private int order;
    private boolean show;

    /* JADX INFO: compiled from: BookGroup.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class Creator implements Parcelable.Creator<BookGroup> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookGroup createFromParcel(@NotNull Parcel parcel) {
            j.e(parcel, "parcel");
            return new BookGroup(parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookGroup[] newArray(int i2) {
            return new BookGroup[i2];
        }
    }

    public BookGroup(long j2, @NotNull String str, int i2, boolean z) {
        j.e(str, "groupName");
        this.groupId = j2;
        this.groupName = str;
        this.order = i2;
        this.show = z;
    }

    public static /* synthetic */ BookGroup copy$default(BookGroup bookGroup, long j2, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j2 = bookGroup.groupId;
        }
        long j3 = j2;
        if ((i3 & 2) != 0) {
            str = bookGroup.groupName;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            i2 = bookGroup.order;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            z = bookGroup.show;
        }
        return bookGroup.copy(j3, str2, i4, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGroupId() {
        return this.groupId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    @NotNull
    public final BookGroup copy(long groupId, @NotNull String groupName, int order, boolean show) {
        j.e(groupName, "groupName");
        return new BookGroup(groupId, groupName, order, show);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof BookGroup)) {
            return false;
        }
        BookGroup bookGroup = (BookGroup) other;
        return bookGroup.groupId == this.groupId && j.a(bookGroup.groupName, this.groupName) && bookGroup.order == this.order && bookGroup.show == this.show;
    }

    public final long getGroupId() {
        return this.groupId;
    }

    @NotNull
    public final String getGroupName() {
        return this.groupName;
    }

    @NotNull
    public final String getManageName(@NotNull Context context) {
        j.e(context, c.R);
        long j2 = this.groupId;
        if (j2 == -1) {
            return this.groupName + '(' + context.getString(R.string.all) + ')';
        }
        if (j2 == -3) {
            return this.groupName + '(' + context.getString(R.string.audio) + ')';
        }
        if (j2 == -2) {
            return this.groupName + '(' + context.getString(R.string.local) + ')';
        }
        if (j2 != -4) {
            return this.groupName;
        }
        return this.groupName + '(' + context.getString(R.string.no_group) + ')';
    }

    public final int getOrder() {
        return this.order;
    }

    public final boolean getShow() {
        return this.show;
    }

    public int hashCode() {
        return b.a(this.groupId);
    }

    public final void setGroupName(@NotNull String str) {
        j.e(str, "<set-?>");
        this.groupName = str;
    }

    public final void setOrder(int i2) {
        this.order = i2;
    }

    public final void setShow(boolean z) {
        this.show = z;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = a.r("BookGroup(groupId=");
        sbR.append(this.groupId);
        sbR.append(", groupName=");
        sbR.append(this.groupName);
        sbR.append(", order=");
        sbR.append(this.order);
        sbR.append(", show=");
        sbR.append(this.show);
        sbR.append(')');
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        j.e(parcel, "out");
        parcel.writeLong(this.groupId);
        parcel.writeString(this.groupName);
        parcel.writeInt(this.order);
        parcel.writeInt(this.show ? 1 : 0);
    }

    public /* synthetic */ BookGroup(long j2, String str, int i2, boolean z, int i3, f fVar) {
        this((i3 & 1) != 0 ? 1L : j2, str, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? true : z);
    }
}
