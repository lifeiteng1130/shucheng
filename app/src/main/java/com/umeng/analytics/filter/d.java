package com.umeng.analytics.filter;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SmartDict.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4632b = "Ă";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MessageDigest f4633c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4635e;
    private final String a = "MD5";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<Object> f4634d = new HashSet();

    public d(boolean z, String str) {
        int i2 = 0;
        this.f4635e = false;
        this.f4635e = z;
        try {
            this.f4633c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        if (str != null) {
            if (!z) {
                String[] strArrSplit = str.split(f4632b);
                int length = strArrSplit.length;
                while (i2 < length) {
                    this.f4634d.add(strArrSplit[i2]);
                    i2++;
                }
                return;
            }
            try {
                byte[] bArrDecode = Base64.decode(str.getBytes(), 0);
                while (i2 < bArrDecode.length / 4) {
                    int i3 = i2 * 4;
                    this.f4634d.add(Integer.valueOf(((bArrDecode[i3 + 0] & ExifInterface.MARKER) << 24) + ((bArrDecode[i3 + 1] & ExifInterface.MARKER) << 16) + ((bArrDecode[i3 + 2] & ExifInterface.MARKER) << 8) + (bArrDecode[i3 + 3] & ExifInterface.MARKER)));
                    i2++;
                }
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            }
        }
    }

    private Integer c(String str) {
        try {
            this.f4633c.update(str.getBytes());
            byte[] bArrDigest = this.f4633c.digest();
            return Integer.valueOf(((bArrDigest[0] & ExifInterface.MARKER) << 24) + ((bArrDigest[1] & ExifInterface.MARKER) << 16) + ((bArrDigest[2] & ExifInterface.MARKER) << 8) + (bArrDigest[3] & ExifInterface.MARKER));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean a(String str) {
        return this.f4635e ? this.f4634d.contains(c(str)) : this.f4634d.contains(str);
    }

    public void b(String str) {
        if (this.f4635e) {
            this.f4634d.add(c(str));
        } else {
            this.f4634d.add(str);
        }
    }

    public String toString() {
        if (!this.f4635e) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : this.f4634d) {
                if (sb.length() > 0) {
                    sb.append(f4632b);
                }
                sb.append(obj.toString());
            }
            return sb.toString();
        }
        byte[] bArr = new byte[this.f4634d.size() * 4];
        Iterator<Object> it = this.f4634d.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            int i3 = i2 + 1;
            bArr[i2] = (byte) (((-16777216) & iIntValue) >> 24);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((16711680 & iIntValue) >> 16);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((65280 & iIntValue) >> 8);
            i2 = i5 + 1;
            bArr[i5] = (byte) (iIntValue & 255);
        }
        return new String(Base64.encode(bArr, 0));
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = this.f4634d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}
