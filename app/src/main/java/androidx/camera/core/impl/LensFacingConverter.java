package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a.a.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class LensFacingConverter {
    private LensFacingConverter() {
    }

    @NonNull
    public static String nameOf(int i2) {
        if (i2 == 0) {
            return "FRONT";
        }
        if (i2 == 1) {
            return "BACK";
        }
        throw new IllegalArgumentException(a.G("Unknown lens facing ", i2));
    }

    public static int valueOf(@Nullable String str) {
        Objects.requireNonNull(str, "name cannot be null");
        if (str.equals("BACK")) {
            return 1;
        }
        if (str.equals("FRONT")) {
            return 0;
        }
        throw new IllegalArgumentException(a.i("Unknown len facing name ", str));
    }

    @NonNull
    public static Integer[] values() {
        return new Integer[]{0, 1};
    }
}
