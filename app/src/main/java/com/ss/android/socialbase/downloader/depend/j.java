package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: IDownloadAidlMonitorDepend.java */
/* JADX INFO: loaded from: classes.dex */
public interface j extends IInterface {
    String a();

    void a(String str);

    int[] b();

    /* JADX INFO: compiled from: IDownloadAidlMonitorDepend.java */
    public static abstract class a extends Binder implements j {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        public static j a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof j)) ? new C0104a(iBinder) : (j) iInterfaceQueryLocalInterface;
        }

        public static j c() {
            return C0104a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            int[] iArrB = b();
            parcel2.writeNoException();
            parcel2.writeIntArray(iArrB);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDownloadAidlMonitorDepend.java */
        public static class C0104a implements j {
            public static j a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3535b;

            public C0104a(IBinder iBinder) {
                this.f3535b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public void a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    parcelObtain.writeString(str);
                    if (this.f3535b.transact(1, parcelObtain, parcelObtain2, 0) || a.c() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.c().a(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3535b;
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public int[] b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.f3535b.transact(3, parcelObtain, parcelObtain2, 0) && a.c() != null) {
                        return a.c().b();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createIntArray();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.f3535b.transact(2, parcelObtain, parcelObtain2, 0) && a.c() != null) {
                        return a.c().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
