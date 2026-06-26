package androidx.media2.session;

import android.content.ComponentName;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.media2.session.SessionToken;
import androidx.versionedparcelable.CustomVersionedParcelable;
import androidx.versionedparcelable.VersionedParcelable;
import c.a.a.a.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class SessionTokenImplLegacy extends CustomVersionedParcelable implements SessionToken.SessionTokenImpl {
    public ComponentName mComponentName;
    public Bundle mExtras;
    private MediaSessionCompat.Token mLegacyToken;
    public Bundle mLegacyTokenBundle;
    public String mPackageName;
    public int mType;
    public int mUid;

    public SessionTokenImplLegacy(MediaSessionCompat.Token token, String str, int i2, Bundle bundle) {
        Objects.requireNonNull(token, "token shouldn't be null");
        Objects.requireNonNull(str, "packageName shouldn't be null");
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName shouldn't be empty");
        }
        this.mLegacyToken = token;
        this.mUid = i2;
        this.mPackageName = str;
        this.mComponentName = null;
        this.mType = 100;
        this.mExtras = bundle;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SessionTokenImplLegacy)) {
            return false;
        }
        SessionTokenImplLegacy sessionTokenImplLegacy = (SessionTokenImplLegacy) obj;
        int i2 = this.mType;
        if (i2 != sessionTokenImplLegacy.mType) {
            return false;
        }
        if (i2 == 100) {
            return ObjectsCompat.equals(this.mLegacyToken, sessionTokenImplLegacy.mLegacyToken);
        }
        if (i2 != 101) {
            return false;
        }
        return ObjectsCompat.equals(this.mComponentName, sessionTokenImplLegacy.mComponentName);
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public Object getBinder() {
        return this.mLegacyToken;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
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
        ComponentName componentName = this.mComponentName;
        if (componentName == null) {
            return null;
        }
        return componentName.getClassName();
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public int getType() {
        return this.mType != 101 ? 0 : 2;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public int getUid() {
        return this.mUid;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Integer.valueOf(this.mType), this.mComponentName, this.mLegacyToken);
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public boolean isLegacySession() {
        return true;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        this.mLegacyToken = MediaSessionCompat.Token.fromBundle(this.mLegacyTokenBundle);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean z) {
        MediaSessionCompat.Token token = this.mLegacyToken;
        if (token == null) {
            this.mLegacyTokenBundle = null;
            return;
        }
        synchronized (token) {
            VersionedParcelable session2Token = this.mLegacyToken.getSession2Token();
            this.mLegacyToken.setSession2Token(null);
            this.mLegacyTokenBundle = this.mLegacyToken.toBundle();
            this.mLegacyToken.setSession2Token(session2Token);
        }
    }

    public String toString() {
        StringBuilder sbR = a.r("SessionToken {legacyToken=");
        sbR.append(this.mLegacyToken);
        sbR.append("}");
        return sbR.toString();
    }

    public SessionTokenImplLegacy(ComponentName componentName, int i2) {
        Objects.requireNonNull(componentName, "serviceComponent shouldn't be null");
        this.mLegacyToken = null;
        this.mUid = i2;
        this.mType = 101;
        this.mPackageName = componentName.getPackageName();
        this.mComponentName = componentName;
        this.mExtras = null;
    }

    public SessionTokenImplLegacy() {
    }
}
