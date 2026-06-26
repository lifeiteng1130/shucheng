package org.mozilla.javascript.v8dtoa;

import c.a.a.a.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class FastDtoaBuilder {
    public static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public final char[] chars = new char[25];
    public int end = 0;
    public boolean formatted = false;
    public int point;

    private void toExponentialFormat(int i2, int i3) {
        int i4 = this.end;
        if (i4 - i2 > 1) {
            int i5 = i2 + 1;
            char[] cArr = this.chars;
            System.arraycopy(cArr, i5, cArr, i5 + 1, i4 - i5);
            this.chars[i5] = '.';
            this.end++;
        }
        char[] cArr2 = this.chars;
        int i6 = this.end;
        int i7 = i6 + 1;
        this.end = i7;
        cArr2[i6] = 'e';
        char c2 = '+';
        int i8 = i3 - 1;
        if (i8 < 0) {
            c2 = '-';
            i8 = -i8;
        }
        int i9 = i7 + 1;
        this.end = i9;
        cArr2[i7] = c2;
        if (i8 > 99) {
            i9 += 2;
        } else if (i8 > 9) {
            i9++;
        }
        this.end = i9 + 1;
        while (true) {
            int i10 = i9 - 1;
            this.chars[i9] = digits[i8 % 10];
            i8 /= 10;
            if (i8 == 0) {
                return;
            } else {
                i9 = i10;
            }
        }
    }

    private void toFixedFormat(int i2, int i3) {
        int i4 = this.point;
        int i5 = this.end;
        if (i4 >= i5) {
            if (i4 > i5) {
                Arrays.fill(this.chars, i5, i4, '0');
                int i6 = this.end;
                this.end = (this.point - i6) + i6;
                return;
            }
            return;
        }
        if (i3 > 0) {
            char[] cArr = this.chars;
            System.arraycopy(cArr, i4, cArr, i4 + 1, i5 - i4);
            this.chars[this.point] = '.';
            this.end++;
            return;
        }
        int i7 = i2 + 2;
        int i8 = i7 - i3;
        char[] cArr2 = this.chars;
        System.arraycopy(cArr2, i2, cArr2, i8, i5 - i2);
        char[] cArr3 = this.chars;
        cArr3[i2] = '0';
        cArr3[i2 + 1] = '.';
        if (i3 < 0) {
            Arrays.fill(cArr3, i7, i8, '0');
        }
        this.end = (2 - i3) + this.end;
    }

    public void append(char c2) {
        char[] cArr = this.chars;
        int i2 = this.end;
        this.end = i2 + 1;
        cArr[i2] = c2;
    }

    public void decreaseLast() {
        this.chars[this.end - 1] = (char) (r0[r1] - 1);
    }

    public String format() {
        if (!this.formatted) {
            int i2 = this.chars[0] == '-' ? 1 : 0;
            int i3 = this.point - i2;
            if (i3 < -5 || i3 > 21) {
                toExponentialFormat(i2, i3);
            } else {
                toFixedFormat(i2, i3);
            }
            this.formatted = true;
        }
        return new String(this.chars, 0, this.end);
    }

    public void reset() {
        this.end = 0;
        this.formatted = false;
    }

    public String toString() {
        StringBuilder sbR = a.r("[chars:");
        sbR.append(new String(this.chars, 0, this.end));
        sbR.append(", point:");
        return a.o(sbR, this.point, "]");
    }
}
