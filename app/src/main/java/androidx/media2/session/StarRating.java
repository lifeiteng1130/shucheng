package androidx.media2.session;

import androidx.annotation.IntRange;
import androidx.core.util.ObjectsCompat;
import androidx.media2.common.Rating;
import c.a.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class StarRating implements Rating {
    private static final float RATING_NOT_RATED = -1.0f;
    public int mMaxStars;
    public float mStarRating;

    public StarRating() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StarRating)) {
            return false;
        }
        StarRating starRating = (StarRating) obj;
        return this.mMaxStars == starRating.mMaxStars && this.mStarRating == starRating.mStarRating;
    }

    public int getMaxStars() {
        return this.mMaxStars;
    }

    public float getStarRating() {
        return this.mStarRating;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Integer.valueOf(this.mMaxStars), Float.valueOf(this.mStarRating));
    }

    @Override // androidx.media2.common.Rating
    public boolean isRated() {
        return this.mStarRating >= 0.0f;
    }

    public String toString() {
        String string;
        StringBuilder sbR = a.r("StarRating: maxStars=");
        sbR.append(this.mMaxStars);
        if (isRated()) {
            StringBuilder sbR2 = a.r(", starRating=");
            sbR2.append(this.mStarRating);
            string = sbR2.toString();
        } else {
            string = ", unrated";
        }
        sbR.append(string);
        return sbR.toString();
    }

    public StarRating(@IntRange(from = 1) int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxStars should be a positive integer");
        }
        this.mMaxStars = i2;
        this.mStarRating = -1.0f;
    }

    public StarRating(@IntRange(from = 1) int i2, float f2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxStars should be a positive integer");
        }
        if (f2 >= 0.0f && f2 <= i2) {
            this.mMaxStars = i2;
            this.mStarRating = f2;
            return;
        }
        throw new IllegalArgumentException("starRating is out of range [0, maxStars]");
    }
}
