package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new a();

    @NonNull
    public final SimpleArrayMap<String, Bundle> a;

    public static class a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        @Override // android.os.Parcelable.ClassLoaderCreator
        @NonNull
        public ExtendableSavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public Object[] newArray(int i2) {
            return new ExtendableSavedState[i2];
        }

        @Override // android.os.Parcelable.Creator
        @Nullable
        public Object createFromParcel(@NonNull Parcel parcel) {
            return new ExtendableSavedState(parcel, null, null);
        }
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.a = new SimpleArrayMap<>();
    }

    @NonNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("ExtendableSavedState{");
        sbR.append(Integer.toHexString(System.identityHashCode(this)));
        sbR.append(" states=");
        sbR.append(this.a);
        sbR.append("}");
        return sbR.toString();
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        int size = this.a.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = this.a.keyAt(i3);
            bundleArr[i3] = this.a.valueAt(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcel parcel, ClassLoader classLoader, a aVar) {
        super(parcel, classLoader);
        int i2 = parcel.readInt();
        String[] strArr = new String[i2];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i2];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.a = new SimpleArrayMap<>(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            this.a.put(strArr[i3], bundleArr[i3]);
        }
    }
}
