package androidx.media2.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.versionedparcelable.ParcelImpl;
import c.a.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public interface IMediaSessionService extends IInterface {

    public static class Default implements IMediaSessionService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.media2.session.IMediaSessionService
        public void connect(IMediaController iMediaController, ParcelImpl parcelImpl) {
        }
    }

    public static abstract class Stub extends Binder implements IMediaSessionService {
        private static final String DESCRIPTOR = "androidx.media2.session.IMediaSessionService";
        public static final int TRANSACTION_connect = 1;

        public static class Proxy implements IMediaSessionService {
            public static IMediaSessionService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // androidx.media2.session.IMediaSessionService
            public void connect(IMediaController iMediaController, ParcelImpl parcelImpl) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                    if (parcelImpl != null) {
                        parcelObtain.writeInt(1);
                        parcelImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().connect(iMediaController, parcelImpl);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaSessionService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaSessionService)) ? new Proxy(iBinder) : (IMediaSessionService) iInterfaceQueryLocalInterface;
        }

        public static IMediaSessionService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMediaSessionService iMediaSessionService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMediaSessionService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMediaSessionService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                connect(a.C(parcel, DESCRIPTOR), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void connect(IMediaController iMediaController, ParcelImpl parcelImpl);
}
