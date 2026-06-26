package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: IDownloadAidlInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public interface h extends IInterface {

    /* JADX INFO: compiled from: IDownloadAidlInterceptor.java */
    public static abstract class a extends Binder implements h {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDownloadAidlInterceptor.java */
        public static class C0102a implements h {
            public static h a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3533b;

            public C0102a(IBinder iBinder) {
                this.f3533b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.h
            public boolean a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                    if (!this.f3533b.transact(1, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3533b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
        }

        public static h a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof h)) ? new C0102a(iBinder) : (h) iInterfaceQueryLocalInterface;
        }

        public static h b() {
            return C0102a.a;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            boolean zA = a();
            parcel2.writeNoException();
            parcel2.writeInt(zA ? 1 : 0);
            return true;
        }
    }

    boolean a();
}
