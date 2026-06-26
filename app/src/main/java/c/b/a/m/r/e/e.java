package c.b.a.m.r.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.l;
import c.b.a.m.n;
import c.b.a.m.q.w;
import java.util.List;

/* JADX INFO: compiled from: ResourceDrawableDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements n<Uri, Drawable> {
    public final Context a;

    public e(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // c.b.a.m.n
    public boolean a(@NonNull Uri uri, @NonNull l lVar) {
        return uri.getScheme().equals("android.resource");
    }

    @Override // c.b.a.m.n
    @Nullable
    public /* bridge */ /* synthetic */ w<Drawable> b(@NonNull Uri uri, int i2, int i3, @NonNull l lVar) {
        return c(uri);
    }

    @Nullable
    public w c(@NonNull Uri uri) {
        Context contextCreatePackageContext;
        int identifier;
        String authority = uri.getAuthority();
        if (authority.equals(this.a.getPackageName())) {
            contextCreatePackageContext = this.a;
        } else {
            try {
                contextCreatePackageContext = this.a.createPackageContext(authority, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                if (!authority.contains(this.a.getPackageName())) {
                    throw new IllegalArgumentException(c.a.a.a.a.g("Failed to obtain context or unrecognized Uri format for: ", uri), e2);
                }
                contextCreatePackageContext = this.a;
            }
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            List<String> pathSegments2 = uri.getPathSegments();
            String authority2 = uri.getAuthority();
            String str = pathSegments2.get(0);
            String str2 = pathSegments2.get(1);
            identifier = contextCreatePackageContext.getResources().getIdentifier(str2, str, authority2);
            if (identifier == 0) {
                identifier = Resources.getSystem().getIdentifier(str2, str, "android");
            }
            if (identifier == 0) {
                throw new IllegalArgumentException(c.a.a.a.a.g("Failed to find resource id for: ", uri));
            }
        } else {
            if (pathSegments.size() != 1) {
                throw new IllegalArgumentException(c.a.a.a.a.g("Unrecognized Uri format: ", uri));
            }
            try {
                identifier = Integer.parseInt(uri.getPathSegments().get(0));
            } catch (NumberFormatException e3) {
                throw new IllegalArgumentException(c.a.a.a.a.g("Unrecognized Uri format: ", uri), e3);
            }
        }
        Drawable drawableA = a.a(this.a, contextCreatePackageContext, identifier, null);
        if (drawableA != null) {
            return new d(drawableA);
        }
        return null;
    }
}
