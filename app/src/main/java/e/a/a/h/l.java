package e.a.a.h;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import e.a.a.e.b.a;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EncodingDetect.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    @NotNull
    public static final String a(@NotNull File file) {
        f.c0.c.j.e(file, "file");
        byte[] bArr = new byte[RecyclerView.MAX_SCROLL_DURATION];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
        } catch (Exception e2) {
            System.err.println(f.c0.c.j.k("Error: ", e2));
        }
        return b(bArr);
    }

    @NotNull
    public static final String b(@NotNull byte[] bArr) {
        e.a.a.e.b.b bVarC;
        f.c0.c.j.e(bArr, "bytes");
        e.a.a.e.b.a aVar = new e.a.a.e.b.a();
        aVar.f5605f = bArr;
        aVar.f5606g = bArr.length;
        ArrayList arrayList = new ArrayList();
        int i2 = aVar.f5606g;
        if (i2 > 8000) {
            i2 = 8000;
        }
        int i3 = 0;
        while (i3 < i2) {
            aVar.f5601b[i3] = aVar.f5605f[i3];
            i3++;
        }
        aVar.f5602c = i3;
        Arrays.fill(aVar.f5603d, (short) 0);
        for (int i4 = 0; i4 < aVar.f5602c; i4++) {
            int i5 = aVar.f5601b[i4] & ExifInterface.MARKER;
            short[] sArr = aVar.f5603d;
            sArr[i5] = (short) (sArr[i5] + 1);
        }
        aVar.f5604e = false;
        int i6 = 128;
        while (true) {
            if (i6 > 159) {
                break;
            }
            if (aVar.f5603d[i6] != 0) {
                aVar.f5604e = true;
                break;
            }
            i6++;
        }
        int i7 = 0;
        while (true) {
            List<a.C0152a> list = e.a.a.e.b.a.a;
            if (i7 >= list.size()) {
                break;
            }
            a.C0152a c0152a = list.get(i7);
            if (c0152a.f5607b && (bVarC = c0152a.a.c(aVar)) != null) {
                arrayList.add(bVarC);
            }
            i7++;
        }
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        e.a.a.e.b.b[] bVarArr = (e.a.a.e.b.b[]) arrayList.toArray(new e.a.a.e.b.b[arrayList.size()]);
        String str = ((bVarArr == null || bVarArr.length == 0) ? null : bVarArr[0]).f5608b;
        f.c0.c.j.d(str, "match.name");
        return str;
    }
}
