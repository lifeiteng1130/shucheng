package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: IDownloadNotificationEventAidlListener.java */
/* JADX INFO: loaded from: classes.dex */
public interface y extends IInterface {
    String a();

    void a(int i2, DownloadInfo downloadInfo, String str, String str2);

    boolean a(boolean z);

    /* JADX INFO: compiled from: IDownloadNotificationEventAidlListener.java */
    public static abstract class a extends Binder implements y {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
        }

        public static y a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof y)) ? new C0110a(iBinder) : (y) iInterfaceQueryLocalInterface;
        }

        public static y b() {
            return C0110a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                a(parcel.readInt(), parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                boolean zA = a(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            String strA = a();
            parcel2.writeNoException();
            parcel2.writeString(strA);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.y$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDownloadNotificationEventAidlListener.java */
        public static class C0110a implements y {
            public static y a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3541b;

            public C0110a(IBinder iBinder) {
                this.f3541b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.y
            public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    parcelObtain.writeInt(i2);
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.f3541b.transact(1, parcelObtain, parcelObtain2, 0) || a.b() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.b().a(i2, downloadInfo, str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3541b;
            }

            @Override // com.ss.android.socialbase.downloader.depend.y
            public boolean a(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f3541b.transact(2, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().a(z);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.y
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    if (!this.f3541b.transact(3, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().a();
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
