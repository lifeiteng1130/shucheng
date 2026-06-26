package c.b.a.m;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: Key.java */
/* JADX INFO: loaded from: classes.dex */
public interface j {
    public static final Charset a = Charset.forName(DataUtil.defaultCharset);

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(@NonNull MessageDigest messageDigest);
}
