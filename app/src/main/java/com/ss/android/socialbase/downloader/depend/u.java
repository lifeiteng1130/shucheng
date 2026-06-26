package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.t;

/* JADX INFO: compiled from: IDownloadForbiddenAidlHandler.java */
/* JADX INFO: loaded from: classes.dex */
public interface u extends IInterface {
    boolean a(t tVar);

    /* JADX INFO: compiled from: IDownloadForbiddenAidlHandler.java */
    public static abstract class a extends Binder implements u {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.u$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDownloadForbiddenAidlHandler.java */
        public static class C0109a implements u {
            public static u a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3540b;

            public C0109a(IBinder iBinder) {
                this.f3540b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.u
            public boolean a(t tVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    parcelObtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    if (!this.f3540b.transact(1, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().a(tVar);
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
                return this.f3540b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static u a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof u)) ? new C0109a(iBinder) : (u) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean zA = a(t.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(zA ? 1 : 0);
            return true;
        }

        public static u a() {
            return C0109a.a;
        }
    }
}
