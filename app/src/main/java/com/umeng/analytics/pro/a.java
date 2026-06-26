package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: IDeviceIdService.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    String a();

    String a(String str);

    String b(String str);

    /* JADX INFO: renamed from: com.umeng.analytics.pro.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IDeviceIdService.java */
    public static abstract class AbstractBinderC0123a extends Binder implements a {
        public static final int a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f4636b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f4637c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f4638d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public AbstractBinderC0123a() {
            attachInterface(this, f4638d);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f4638d);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0124a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface(f4638d);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f4638d);
                String strA2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strA2);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f4638d);
                return true;
            }
            parcel.enforceInterface(f4638d);
            String strB = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strB);
            return true;
        }

        /* JADX INFO: renamed from: com.umeng.analytics.pro.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDeviceIdService.java */
        public static class C0124a implements a {
            private IBinder a;

            public C0124a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.umeng.analytics.pro.a
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0123a.f4638d);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            public String b() {
                return AbstractBinderC0123a.f4638d;
            }

            @Override // com.umeng.analytics.pro.a
            public String b(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0123a.f4638d);
                    parcelObtain.writeString(str);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0123a.f4638d);
                    parcelObtain.writeString(str);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
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
