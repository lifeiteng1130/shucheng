package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: IRetryDelayTimeAidlCalculator.java */
/* JADX INFO: loaded from: classes.dex */
public interface ah extends IInterface {
    long a(int i2, int i3);

    /* JADX INFO: compiled from: IRetryDelayTimeAidlCalculator.java */
    public static abstract class a extends Binder implements ah {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.ah$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IRetryDelayTimeAidlCalculator.java */
        public static class C0097a implements ah {
            public static ah a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3528b;

            public C0097a(IBinder iBinder) {
                this.f3528b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ah
            public long a(int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (!this.f3528b.transact(1, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().a(i2, i3);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3528b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        public static ah a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ah)) ? new C0097a(iBinder) : (ah) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            long jA = a(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(jA);
            return true;
        }

        public static ah a() {
            return C0097a.a;
        }
    }
}
