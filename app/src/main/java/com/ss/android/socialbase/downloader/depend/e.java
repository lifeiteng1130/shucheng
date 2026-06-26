package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: IChunkCntAidlCalculator.java */
/* JADX INFO: loaded from: classes.dex */
public interface e extends IInterface {
    int a(long j2);

    /* JADX INFO: compiled from: IChunkCntAidlCalculator.java */
    public static abstract class a extends Binder implements e {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IChunkCntAidlCalculator.java */
        public static class C0099a implements e {
            public static e a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3530b;

            public C0099a(IBinder iBinder) {
                this.f3530b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.e
            public int a(long j2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    parcelObtain.writeLong(j2);
                    if (!this.f3530b.transact(1, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().a(j2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3530b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new C0099a(iBinder) : (e) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            int iA = a(parcel.readLong());
            parcel2.writeNoException();
            parcel2.writeInt(iA);
            return true;
        }

        public static e a() {
            return C0099a.a;
        }
    }
}
