package androidx.media2.session;

import androidx.core.util.ObjectsCompat;
import androidx.media2.common.Rating;
import c.a.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class HeartRating implements Rating {
    public boolean mHasHeart;
    public boolean mIsRated = false;

    public HeartRating() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HeartRating)) {
            return false;
        }
        HeartRating heartRating = (HeartRating) obj;
        return this.mHasHeart == heartRating.mHasHeart && this.mIsRated == heartRating.mIsRated;
    }

    public boolean hasHeart() {
        return this.mHasHeart;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Boolean.valueOf(this.mIsRated), Boolean.valueOf(this.mHasHeart));
    }

    @Override // androidx.media2.common.Rating
    public boolean isRated() {
        return this.mIsRated;
    }

    public String toString() {
        String string;
        StringBuilder sbR = a.r("HeartRating: ");
        if (this.mIsRated) {
            StringBuilder sbR2 = a.r("hasHeart=");
            sbR2.append(this.mHasHeart);
            string = sbR2.toString();
        } else {
            string = "unrated";
        }
        sbR.append(string);
        return sbR.toString();
    }

    public HeartRating(boolean z) {
        this.mHasHeart = z;
    }
}
