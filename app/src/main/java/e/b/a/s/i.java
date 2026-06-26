package e.b.a.s;

import androidx.annotation.Nullable;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: ImageSize.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f6116b;

    /* JADX INFO: compiled from: ImageSize.java */
    public static class a {
        public final float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f6117b;

        public a(float f2, @Nullable String str) {
            this.a = f2;
            this.f6117b = str;
        }

        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("Dimension{value=");
            sbR.append(this.a);
            sbR.append(", unit='");
            sbR.append(this.f6117b);
            sbR.append('\'');
            sbR.append(MessageFormatter.DELIM_STOP);
            return sbR.toString();
        }
    }

    public i(@Nullable a aVar, @Nullable a aVar2) {
        this.a = aVar;
        this.f6116b = aVar2;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("ImageSize{width=");
        sbR.append(this.a);
        sbR.append(", height=");
        sbR.append(this.f6116b);
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }
}
