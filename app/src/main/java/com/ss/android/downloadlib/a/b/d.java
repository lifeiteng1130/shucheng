package com.ss.android.downloadlib.a.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.j;
import com.umeng.analytics.pro.ai;
import org.json.JSONObject;

/* JADX INFO: compiled from: ICallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface d extends IInterface {

    /* JADX INFO: compiled from: ICallback.java */
    public static abstract class a extends Binder implements d {
        private static String a = "";

        /* JADX INFO: renamed from: com.ss.android.downloadlib.a.b.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ICallback.java */
        public static class C0078a implements d {
            private IBinder a;

            public C0078a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.a)) {
                    JSONObject jSONObjectI = j.i();
                    String unused = a.a = com.ss.android.socialbase.appdownloader.f.c.a(jSONObjectI.optString(ai.aF), jSONObjectI.optString(ai.az));
                }
                this.a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.b.d
            public void a(b bVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.a);
                    if (bVar != null) {
                        parcelObtain.writeInt(1);
                        bVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface(a);
                a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString(a);
            return true;
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof d)) {
                return (d) iInterfaceQueryLocalInterface;
            }
            return new C0078a(iBinder);
        }
    }

    void a(b bVar);
}
