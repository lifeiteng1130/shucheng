package androidx.media2.common;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.ParcelImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelImplListSlice implements Parcelable {
    public static final Parcelable.Creator<ParcelImplListSlice> CREATOR = new Parcelable.Creator<ParcelImplListSlice>() { // from class: androidx.media2.common.ParcelImplListSlice.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelImplListSlice createFromParcel(Parcel parcel) {
            return new ParcelImplListSlice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelImplListSlice[] newArray(int i2) {
            return new ParcelImplListSlice[i2];
        }
    };
    private static final boolean DEBUG = false;
    private static final int INLINE_COUNT_LIMIT = 1;
    private static final int MAX_IPC_SIZE = 65536;
    private static final String TAG = "ParcelImplListSlice";
    public final List<ParcelImpl> mList;

    public ParcelImplListSlice(@NonNull List<ParcelImpl> list) {
        Objects.requireNonNull(list, "list shouldn't be null");
        this.mList = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public List<ParcelImpl> getList() {
        return this.mList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        final int size = this.mList.size();
        parcel.writeInt(size);
        if (size > 0) {
            int i3 = 0;
            while (i3 < size && i3 < 1 && parcel.dataSize() < 65536) {
                parcel.writeInt(1);
                parcel.writeParcelable(this.mList.get(i3), i2);
                i3++;
            }
            if (i3 < size) {
                parcel.writeInt(0);
                parcel.writeStrongBinder(new Binder() { // from class: androidx.media2.common.ParcelImplListSlice.1
                    @Override // android.os.Binder
                    public boolean onTransact(int i4, Parcel parcel2, Parcel parcel3, int i5) {
                        if (i4 != 1) {
                            return super.onTransact(i4, parcel2, parcel3, i5);
                        }
                        int i6 = parcel2.readInt();
                        while (i6 < size && parcel3.dataSize() < 65536) {
                            parcel3.writeInt(1);
                            parcel3.writeParcelable(ParcelImplListSlice.this.mList.get(i6), i5);
                            i6++;
                        }
                        if (i6 < size) {
                            parcel3.writeInt(0);
                        }
                        return true;
                    }
                });
            }
        }
    }

    public ParcelImplListSlice(Parcel parcel) {
        int i2 = parcel.readInt();
        this.mList = new ArrayList(i2);
        if (i2 <= 0) {
            return;
        }
        int i3 = 0;
        while (i3 < i2 && parcel.readInt() != 0) {
            this.mList.add((ParcelImpl) parcel.readParcelable(ParcelImpl.class.getClassLoader()));
            i3++;
        }
        if (i3 >= i2) {
            return;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        while (i3 < i2) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i3);
                try {
                    strongBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (i3 < i2 && parcelObtain2.readInt() != 0) {
                        this.mList.add((ParcelImpl) parcelObtain2.readParcelable(ParcelImpl.class.getClassLoader()));
                        i3++;
                    }
                } catch (RemoteException unused) {
                    return;
                }
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
