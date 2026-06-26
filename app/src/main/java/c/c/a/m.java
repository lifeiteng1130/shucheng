package c.c.a;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.pangle.service.client.ServiceManagerNative;

/* JADX INFO: loaded from: classes.dex */
public interface m extends IInterface {

    public static abstract class a extends Binder implements m {
        public static final /* synthetic */ int a = 0;

        /* JADX INFO: renamed from: c.c.a.m$a$a, reason: collision with other inner class name */
        public static class C0033a implements m {
            public IBinder a;

            public C0033a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // c.c.a.m
            public final int a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (!this.a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i2 = a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }

            @Override // c.c.a.m
            public final void e(ComponentName componentName, IBinder iBinder) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (componentName != null) {
                        parcelObtain.writeInt(1);
                        componentName.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBinder);
                    if (!this.a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i2 = a.a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.bytedance.pangle.ServiceConnection");
        }

        public static m f(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.ServiceConnection");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof m)) ? new C0033a(iBinder) : (m) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                ((ServiceManagerNative.a) this).f1620b.onServiceConnected(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 2) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.bytedance.pangle.ServiceConnection");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
            int iA = ((ServiceManagerNative.a) this).a();
            parcel2.writeNoException();
            parcel2.writeInt(iA);
            return true;
        }
    }

    int a();

    void e(ComponentName componentName, IBinder iBinder);
}
