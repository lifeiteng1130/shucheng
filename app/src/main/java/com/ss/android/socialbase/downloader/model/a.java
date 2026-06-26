package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.y;

/* JADX INFO: compiled from: DownloadAidlTask.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    int a(int i2);

    i a(int i2, int i3);

    DownloadInfo a();

    com.ss.android.socialbase.downloader.depend.e b();

    i b(int i2);

    l c(int i2);

    y c();

    ae d();

    h e();

    f f();

    u g();

    ah h();

    p i();

    j j();

    g k();

    int l();

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.model.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadAidlTask.java */
    public static abstract class AbstractBinderC0116a extends Binder implements a {
        public AbstractBinderC0116a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0117a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a m() {
            return C0117a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    DownloadInfo downloadInfoA = a();
                    parcel2.writeNoException();
                    if (downloadInfoA != null) {
                        parcel2.writeInt(1);
                        downloadInfoA.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    com.ss.android.socialbase.downloader.depend.e eVarB = b();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(eVarB != null ? eVarB.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iA = a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iA);
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    i iVarA = a(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iVarA != null ? iVarA.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    i iVarB = b(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iVarB != null ? iVarB.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    y yVarC = c();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(yVarC != null ? yVarC.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    ae aeVarD = d();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(aeVarD != null ? aeVarD.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    h hVarE = e();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(hVarE != null ? hVarE.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    f fVarF = f();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(fVarF != null ? fVarF.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    u uVarG = g();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(uVarG != null ? uVarG.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    ah ahVarH = h();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(ahVarH != null ? ahVarH.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    p pVarI = i();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(pVarI != null ? pVarI.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    j jVarJ = j();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(jVarJ != null ? jVarJ.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    g gVarK = k();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(gVarK != null ? gVarK.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iL = l();
                    parcel2.writeNoException();
                    parcel2.writeInt(iL);
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    l lVarC = c(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(lVarC != null ? lVarC.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.model.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DownloadAidlTask.java */
        public static class C0117a implements a {
            public static a a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f3837b;

            public C0117a(IBinder iBinder) {
                this.f3837b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public DownloadInfo a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f3837b.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3837b;
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.e b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f3837b.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().b();
                    }
                    parcelObtain2.readException();
                    return e.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public y c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f3837b.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().c();
                    }
                    parcelObtain2.readException();
                    return y.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ae d() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f3837b.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().d();
                    }
                    parcelObtain2.readException();
                    return ae.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public h e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f3837b.transact(8, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().e();
                    }
                    parcelObtain2.readException();
                    return h.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public f f() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f3837b.transact(9, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().f();
                    }
                    parcelObtain2.readException();
                    return f.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public u g() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f3837b.transact(10, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().g();
                    }
                    parcelObtain2.readException();
                    return u.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ah h() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f3837b.transact(11, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().h();
                    }
                    parcelObtain2.readException();
                    return ah.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public p i() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f3837b.transact(12, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().i();
                    }
                    parcelObtain2.readException();
                    return p.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public j j() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f3837b.transact(13, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().j();
                    }
                    parcelObtain2.readException();
                    return j.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public g k() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f3837b.transact(14, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().k();
                    }
                    parcelObtain2.readException();
                    return g.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int l() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f3837b.transact(15, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().l();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public i b(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i2);
                    if (!this.f3837b.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().b(i2);
                    }
                    parcelObtain2.readException();
                    return i.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public l c(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i2);
                    if (!this.f3837b.transact(16, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().c(i2);
                    }
                    parcelObtain2.readException();
                    return l.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int a(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i2);
                    if (!this.f3837b.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().a(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public i a(int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (!this.f3837b.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0116a.m() != null) {
                        return AbstractBinderC0116a.m().a(i2, i3);
                    }
                    parcelObtain2.readException();
                    return i.a.a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
