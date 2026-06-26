package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.o;

/* JADX INFO: compiled from: IDownloadDiskSpaceAidlHandler.java */
/* JADX INFO: loaded from: classes.dex */
public interface p extends IInterface {
    boolean a(long j2, long j3, o oVar);

    /* JADX INFO: compiled from: IDownloadDiskSpaceAidlHandler.java */
    public static abstract class a extends Binder implements p {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDownloadDiskSpaceAidlHandler.java */
        public static class C0107a implements p {
            public static p a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3538b;

            public C0107a(IBinder iBinder) {
                this.f3538b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.p
            public boolean a(long j2, long j3, o oVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
                    if (!this.f3538b.transact(1, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().a(j2, j3, oVar);
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
                return this.f3538b;
            }
        }

        public a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static p a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof p)) ? new C0107a(iBinder) : (p) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean zA = a(parcel.readLong(), parcel.readLong(), o.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(zA ? 1 : 0);
            return true;
        }

        public static p a() {
            return C0107a.a;
        }
    }
}
