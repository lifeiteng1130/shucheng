package com.ss.android.socialbase.downloader.depend;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: IDownloadAidlFileProvider.java */
/* JADX INFO: loaded from: classes.dex */
public interface g extends IInterface {
    Uri a(String str, String str2);

    /* JADX INFO: compiled from: IDownloadAidlFileProvider.java */
    public static abstract class a extends Binder implements g {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDownloadAidlFileProvider.java */
        public static class C0101a implements g {
            public static g a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3532b;

            public C0101a(IBinder iBinder) {
                this.f3532b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public Uri a(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f3532b.transact(1, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().a(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3532b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof g)) ? new C0101a(iBinder) : (g) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            Uri uriA = a(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            if (uriA != null) {
                parcel2.writeInt(1);
                uriA.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        public static g a() {
            return C0101a.a;
        }
    }
}
