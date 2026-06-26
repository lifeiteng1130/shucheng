package androidx.media2.session;

import androidx.core.util.ObjectsCompat;
import androidx.media2.common.Rating;
import c.a.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class PercentageRating implements Rating {
    private static final float RATING_NOT_RATED = -1.0f;
    public float mPercent;

    public PercentageRating() {
        this.mPercent = -1.0f;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PercentageRating) && this.mPercent == ((PercentageRating) obj).mPercent;
    }

    public float getPercentRating() {
        return this.mPercent;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Float.valueOf(this.mPercent));
    }

    @Override // androidx.media2.common.Rating
    public boolean isRated() {
        return this.mPercent != -1.0f;
    }

    public String toString() {
        String string;
        StringBuilder sbR = a.r("PercentageRating: ");
        if (isRated()) {
            StringBuilder sbR2 = a.r("percentage=");
            sbR2.append(this.mPercent);
            string = sbR2.toString();
        } else {
            string = "unrated";
        }
        sbR.append(string);
        return sbR.toString();
    }

    public PercentageRating(float f2) {
        if (f2 >= 0.0f && f2 <= 100.0f) {
            this.mPercent = f2;
            return;
        }
        throw new IllegalArgumentException("percent should be in the rage of [0, 100]");
    }
}
