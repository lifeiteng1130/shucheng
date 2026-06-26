package androidx.media2.session;

import androidx.core.util.ObjectsCompat;
import androidx.media2.common.Rating;
import c.a.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class ThumbRating implements Rating {
    public boolean mIsRated = false;
    public boolean mThumbUp;

    public ThumbRating() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ThumbRating)) {
            return false;
        }
        ThumbRating thumbRating = (ThumbRating) obj;
        return this.mThumbUp == thumbRating.mThumbUp && this.mIsRated == thumbRating.mIsRated;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Boolean.valueOf(this.mIsRated), Boolean.valueOf(this.mThumbUp));
    }

    @Override // androidx.media2.common.Rating
    public boolean isRated() {
        return this.mIsRated;
    }

    public boolean isThumbUp() {
        return this.mThumbUp;
    }

    public String toString() {
        String string;
        StringBuilder sbR = a.r("ThumbRating: ");
        if (this.mIsRated) {
            StringBuilder sbR2 = a.r("isThumbUp=");
            sbR2.append(this.mThumbUp);
            string = sbR2.toString();
        } else {
            string = "unrated";
        }
        sbR.append(string);
        return sbR.toString();
    }

    public ThumbRating(boolean z) {
        this.mThumbUp = z;
    }
}
