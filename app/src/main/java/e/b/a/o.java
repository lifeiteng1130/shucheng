package e.b.a;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SpannableBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class o implements Appendable, CharSequence {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deque<a> f5987b = new ArrayDeque(8);
    public final StringBuilder a = new StringBuilder((CharSequence) "");

    /* JADX INFO: compiled from: SpannableBuilder.java */
    public static class a {
        public final Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f5990d;

        public a(@NonNull Object obj, int i2, int i3, int i4) {
            this.a = obj;
            this.f5988b = i2;
            this.f5989c = i3;
            this.f5990d = i4;
        }
    }

    /* JADX INFO: compiled from: SpannableBuilder.java */
    public static class b extends SpannableStringBuilder {
        public b(CharSequence charSequence) {
            super(charSequence);
        }
    }

    public o() {
        a(0, "");
    }

    public static void c(@NonNull o oVar, @Nullable Object obj, int i2, int i3) {
        if (obj != null) {
            if (i3 > i2 && i2 >= 0 && i3 <= oVar.length()) {
                d(oVar, obj, i2, i3);
            }
        }
    }

    public static void d(@NonNull o oVar, @Nullable Object obj, int i2, int i3) {
        if (obj != null) {
            if (!obj.getClass().isArray()) {
                oVar.f5987b.push(new a(obj, i2, i3, 33));
                return;
            }
            for (Object obj2 : (Object[]) obj) {
                d(oVar, obj2, i2, i3);
            }
        }
    }

    public final void a(int i2, @Nullable CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            boolean z = spanned instanceof b;
            Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
            int length = spans != null ? spans.length : 0;
            if (length > 0) {
                if (!z) {
                    for (int i3 = 0; i3 < length; i3++) {
                        Object obj = spans[i3];
                        b(obj, spanned.getSpanStart(obj) + i2, spanned.getSpanEnd(obj) + i2, spanned.getSpanFlags(obj));
                    }
                    return;
                }
                for (int i4 = length - 1; i4 >= 0; i4--) {
                    Object obj2 = spans[i4];
                    b(obj2, spanned.getSpanStart(obj2) + i2, spanned.getSpanEnd(obj2) + i2, spanned.getSpanFlags(obj2));
                }
            }
        }
    }

    @Override // java.lang.Appendable
    @NonNull
    public Appendable append(char c2) {
        this.a.append(c2);
        return this;
    }

    @NonNull
    public o b(@NonNull Object obj, int i2, int i3, int i4) {
        this.f5987b.push(new a(obj, i2, i3, i4));
        return this;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.a.charAt(i2);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.a.length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        List<a> listUnmodifiableList;
        int i4;
        int length = length();
        if (!(i3 > i2 && i2 >= 0 && i3 <= length)) {
            listUnmodifiableList = Collections.emptyList();
        } else if (i2 == 0 && length == i3) {
            ArrayList arrayList = new ArrayList(this.f5987b);
            Collections.reverse(arrayList);
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
        } else {
            ArrayList arrayList2 = new ArrayList(0);
            Iterator<a> itDescendingIterator = this.f5987b.descendingIterator();
            while (itDescendingIterator.hasNext()) {
                a next = itDescendingIterator.next();
                int i5 = next.f5988b;
                if ((i5 >= i2 && i5 < i3) || (((i4 = next.f5989c) <= i3 && i4 > i2) || (i5 < i2 && i4 > i3))) {
                    arrayList2.add(next);
                }
            }
            listUnmodifiableList = Collections.unmodifiableList(arrayList2);
        }
        if (listUnmodifiableList.isEmpty()) {
            return this.a.subSequence(i2, i3);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.a.subSequence(i2, i3));
        int length2 = spannableStringBuilder.length();
        for (a aVar : listUnmodifiableList) {
            int iMax = Math.max(0, aVar.f5988b - i2);
            spannableStringBuilder.setSpan(aVar.a, iMax, Math.min(length2, (aVar.f5989c - aVar.f5988b) + iMax), aVar.f5990d);
        }
        return spannableStringBuilder;
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.a.toString();
    }

    @Override // java.lang.Appendable
    @NonNull
    public Appendable append(@NonNull CharSequence charSequence) {
        a(length(), charSequence);
        this.a.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    @NonNull
    public Appendable append(CharSequence charSequence, int i2, int i3) {
        CharSequence charSequenceSubSequence = charSequence.subSequence(i2, i3);
        a(length(), charSequenceSubSequence);
        this.a.append(charSequenceSubSequence);
        return this;
    }
}
