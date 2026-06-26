package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: IDownloadDiskSpaceAidlCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface o extends IInterface {

    /* JADX INFO: compiled from: IDownloadDiskSpaceAidlCallback.java */
    public static abstract class a extends Binder implements o {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDownloadDiskSpaceAidlCallback.java */
        public static class C0106a implements o {
            public static o a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3537b;

            public C0106a(IBinder iBinder) {
                this.f3537b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.o
            public void a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                    if (this.f3537b.transact(1, parcelObtain, parcelObtain2, 0) || a.b() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.b().a();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3537b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        public static o a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof o)) ? new C0106a(iBinder) : (o) iInterfaceQueryLocalInterface;
        }

        public static o b() {
            return C0106a.a;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            a();
            parcel2.writeNoException();
            return true;
        }
    }

    void a();
}
