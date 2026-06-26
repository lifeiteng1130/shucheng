package androidx.media2.session;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.media2.session.SessionToken;
import c.a.a.a.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class SessionTokenImplBase implements SessionToken.SessionTokenImpl {
    public ComponentName mComponentName;
    public Bundle mExtras;
    public IBinder mISession;
    public String mPackageName;
    public String mServiceName;
    public int mType;
    public int mUid;

    public SessionTokenImplBase(@NonNull ComponentName componentName, int i2, int i3) {
        Objects.requireNonNull(componentName, "serviceComponent shouldn't be null");
        this.mComponentName = componentName;
        this.mPackageName = componentName.getPackageName();
        this.mServiceName = componentName.getClassName();
        this.mUid = i2;
        this.mType = i3;
        this.mISession = null;
        this.mExtras = null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SessionTokenImplBase)) {
            return false;
        }
        SessionTokenImplBase sessionTokenImplBase = (SessionTokenImplBase) obj;
        return this.mUid == sessionTokenImplBase.mUid && TextUtils.equals(this.mPackageName, sessionTokenImplBase.mPackageName) && TextUtils.equals(this.mServiceName, sessionTokenImplBase.mServiceName) && this.mType == sessionTokenImplBase.mType && ObjectsCompat.equals(this.mISession, sessionTokenImplBase.mISession);
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public Object getBinder() {
        return this.mISession;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    @Nullable
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    @NonNull
    public String getPackageName() {
        return this.mPackageName;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    @Nullable
    public String getServiceName() {
        return this.mServiceName;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public int getType() {
        return this.mType;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public int getUid() {
        return this.mUid;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Integer.valueOf(this.mType), Integer.valueOf(this.mUid), this.mPackageName, this.mServiceName);
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public boolean isLegacySession() {
        return false;
    }

    public String toString() {
        StringBuilder sbR = a.r("SessionToken {pkg=");
        sbR.append(this.mPackageName);
        sbR.append(" type=");
        sbR.append(this.mType);
        sbR.append(" service=");
        sbR.append(this.mServiceName);
        sbR.append(" IMediaSession=");
        sbR.append(this.mISession);
        sbR.append(" extras=");
        sbR.append(this.mExtras);
        sbR.append("}");
        return sbR.toString();
    }

    public SessionTokenImplBase(int i2, int i3, String str, IMediaSession iMediaSession, Bundle bundle) {
        this.mUid = i2;
        this.mType = i3;
        this.mPackageName = str;
        this.mServiceName = null;
        this.mComponentName = null;
        this.mISession = iMediaSession.asBinder();
        this.mExtras = bundle;
    }

    public SessionTokenImplBase() {
    }
}
