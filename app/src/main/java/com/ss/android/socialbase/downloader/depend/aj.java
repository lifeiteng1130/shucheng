package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: ProcessAidlCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface aj extends IInterface {
    void a(int i2, int i3);

    /* JADX INFO: compiled from: ProcessAidlCallback.java */
    public static abstract class a extends Binder implements aj {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.aj$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProcessAidlCallback.java */
        public static class C0098a implements aj {
            public static aj a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3529b;

            public C0098a(IBinder iBinder) {
                this.f3529b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.aj
            public void a(int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (this.f3529b.transact(1, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().a(i2, i3);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3529b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static aj a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof aj)) ? new C0098a(iBinder) : (aj) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            a(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static aj a() {
            return C0098a.a;
        }
    }
}
