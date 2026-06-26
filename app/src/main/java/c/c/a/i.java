package c.c.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.c.a.g;
import c.c.a.m;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public interface i extends IInterface {

    public static abstract class a extends Binder implements i {
        public static final /* synthetic */ int a = 0;

        /* JADX INFO: renamed from: c.c.a.i$a$a, reason: collision with other inner class name */
        public static class C0031a implements i {
            public IBinder a;

            public C0031a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // c.c.a.i
            public final boolean a(Intent intent, m mVar, int i2, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    parcelObtain.writeInt(1);
                    intent.writeToParcel(parcelObtain, 0);
                    parcelObtain.writeStrongBinder(mVar != null ? mVar.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (!this.a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i3 = a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }

            @Override // c.c.a.i
            public final ComponentName b(Intent intent, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (!this.a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i2 = a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // c.c.a.i
            public final boolean c(Intent intent, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (!this.a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i2 = a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // c.c.a.i
            public final void d(m mVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    parcelObtain.writeStrongBinder(mVar != null ? mVar.asBinder() : null);
                    if (!this.a.transact(4, parcelObtain, parcelObtain2, 0)) {
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
            attachInterface(this, "com.bytedance.pangle.IServiceManager");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                ComponentName componentNameB = ((c.c.a.w.a.a) this).b(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                if (componentNameB != null) {
                    parcel2.writeInt(1);
                    componentNameB.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                ((c.c.a.w.a.a) this).c(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(1);
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                ((c.c.a.w.a.a) this).a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, m.a.f(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(1);
                return true;
            }
            if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.bytedance.pangle.IServiceManager");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
            ((c.c.a.w.a.a) this).d(m.a.f(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    public class c extends g.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static volatile c f756b;

        @Override // c.c.a.g
        public final boolean a(String str) {
            return PluginManager.getInstance().checkPluginInstalled(str);
        }

        @Override // c.c.a.g
        public final int b(String str) {
            return PluginManager.getInstance().getPlugin(str).getVersion();
        }

        @Override // c.c.a.g
        public final boolean c(String str) {
            return PluginManager.getInstance().syncInstall(new File(str));
        }
    }

    boolean a(Intent intent, m mVar, int i2, String str);

    ComponentName b(Intent intent, String str);

    boolean c(Intent intent, String str);

    void d(m mVar);
}
