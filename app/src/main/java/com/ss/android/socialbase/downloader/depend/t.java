package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: compiled from: IDownloadForbiddenAidlCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface t extends IInterface {
    void a(List<String> list);

    boolean a();

    /* JADX INFO: compiled from: IDownloadForbiddenAidlCallback.java */
    public static abstract class a extends Binder implements t {
        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
        }

        public static t a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof t)) ? new C0108a(iBinder) : (t) iInterfaceQueryLocalInterface;
        }

        public static t b() {
            return C0108a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                a(parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 2) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            boolean zA = a();
            parcel2.writeNoException();
            parcel2.writeInt(zA ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDownloadForbiddenAidlCallback.java */
        public static class C0108a implements t {
            public static t a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3539b;

            public C0108a(IBinder iBinder) {
                this.f3539b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.t
            public void a(List<String> list) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    parcelObtain.writeStringList(list);
                    if (this.f3539b.transact(1, parcelObtain, parcelObtain2, 0) || a.b() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.b().a(list);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3539b;
            }

            @Override // com.ss.android.socialbase.downloader.depend.t
            public boolean a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    if (!this.f3539b.transact(2, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
