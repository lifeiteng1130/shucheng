package k.f.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/* JADX INFO: compiled from: IOpenID.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: k.f.a.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IOpenID.java */
    public static abstract class AbstractBinderC0231a extends Binder implements a {
        public static final /* synthetic */ int a = 0;

        /* JADX INFO: renamed from: k.f.a.a.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IOpenID.java */
        public static class C0232a implements a {
            public IBinder a;

            public C0232a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }
    }

    /* JADX INFO: compiled from: OpenIDHelper.java */
    public class b {
        public a a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8921b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8922c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f8923d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ServiceConnection f8924e = new ServiceConnectionC0233a();

        /* JADX INFO: renamed from: k.f.a.a.a.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpenIDHelper.java */
        public class ServiceConnectionC0233a implements ServiceConnection {
            public ServiceConnectionC0233a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a c0232a;
                b bVar = b.this;
                int i2 = AbstractBinderC0231a.a;
                if (iBinder == null) {
                    c0232a = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                    c0232a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new AbstractBinderC0231a.C0232a(iBinder) : (a) iInterfaceQueryLocalInterface;
                }
                bVar.a = c0232a;
                synchronized (b.this.f8923d) {
                    b.this.f8923d.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                b.this.a = null;
            }
        }

        /* JADX INFO: renamed from: k.f.a.a.a.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpenIDHelper.java */
        public static class C0234b {
            public static final b a = new b();
        }

        public final String a(Context context, String str) {
            Signature[] signatureArr;
            if (TextUtils.isEmpty(this.f8921b)) {
                this.f8921b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.f8922c)) {
                String string = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.f8921b, 64).signatures;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                        if (messageDigest != null) {
                            byte[] bArrDigest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b2 : bArrDigest) {
                                sb.append(Integer.toHexString((b2 & ExifInterface.MARKER) | 256).substring(1, 3));
                            }
                            string = sb.toString();
                        }
                    } catch (NoSuchAlgorithmException e3) {
                        e3.printStackTrace();
                    }
                }
                this.f8922c = string;
            }
            a aVar = this.a;
            String str2 = this.f8921b;
            String str3 = this.f8922c;
            AbstractBinderC0231a.C0232a c0232a = (AbstractBinderC0231a.C0232a) aVar;
            Objects.requireNonNull(c0232a);
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str3);
                parcelObtain.writeString(str);
                c0232a.a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                String string2 = parcelObtain2.readString();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return TextUtils.isEmpty(string2) ? "" : string2;
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
    }
}
