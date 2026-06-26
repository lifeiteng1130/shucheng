package c.e.a.b.l;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$string;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.util.Date;

/* JADX INFO: compiled from: DateFormatTextWatcher.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends c.e.a.b.q.f {

    @NonNull
    public final TextInputLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateFormat f1019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CalendarConstraints f1020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f1022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f1023f;

    /* JADX INFO: compiled from: DateFormatTextWatcher.java */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            TextInputLayout textInputLayout = cVar.a;
            DateFormat dateFormat = cVar.f1019b;
            Context context = textInputLayout.getContext();
            textInputLayout.setError(context.getString(R$string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_use), this.a) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(u.h().getTimeInMillis()))));
            c.this.a();
        }
    }

    public c(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f1019b = dateFormat;
        this.a = textInputLayout;
        this.f1020c = calendarConstraints;
        this.f1021d = textInputLayout.getContext().getString(R$string.mtrl_picker_out_of_range);
        this.f1022e = new a(str);
    }

    public abstract void a();

    public abstract void b(@Nullable Long l2);

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    @Override // c.e.a.b.q.f, android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onTextChanged(@androidx.annotation.NonNull java.lang.CharSequence r7, int r8, int r9, int r10) {
        /*
            r6 = this;
            com.google.android.material.textfield.TextInputLayout r8 = r6.a
            java.lang.Runnable r9 = r6.f1022e
            r8.removeCallbacks(r9)
            com.google.android.material.textfield.TextInputLayout r8 = r6.a
            java.lang.Runnable r9 = r6.f1023f
            r8.removeCallbacks(r9)
            com.google.android.material.textfield.TextInputLayout r8 = r6.a
            r9 = 0
            r8.setError(r9)
            r6.b(r9)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L1e
            return
        L1e:
            r0 = 1000(0x3e8, double:4.94E-321)
            java.text.DateFormat r8 = r6.f1019b     // Catch: java.text.ParseException -> L73
            java.lang.String r7 = r7.toString()     // Catch: java.text.ParseException -> L73
            java.util.Date r7 = r8.parse(r7)     // Catch: java.text.ParseException -> L73
            com.google.android.material.textfield.TextInputLayout r8 = r6.a     // Catch: java.text.ParseException -> L73
            r8.setError(r9)     // Catch: java.text.ParseException -> L73
            long r8 = r7.getTime()     // Catch: java.text.ParseException -> L73
            com.google.android.material.datepicker.CalendarConstraints r10 = r6.f1020c     // Catch: java.text.ParseException -> L73
            com.google.android.material.datepicker.CalendarConstraints$DateValidator r10 = r10.f2171c     // Catch: java.text.ParseException -> L73
            boolean r10 = r10.c(r8)     // Catch: java.text.ParseException -> L73
            if (r10 == 0) goto L66
            com.google.android.material.datepicker.CalendarConstraints r10 = r6.f1020c     // Catch: java.text.ParseException -> L73
            com.google.android.material.datepicker.Month r2 = r10.a     // Catch: java.text.ParseException -> L73
            r3 = 1
            long r4 = r2.g(r3)     // Catch: java.text.ParseException -> L73
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 > 0) goto L57
            com.google.android.material.datepicker.Month r10 = r10.f2170b     // Catch: java.text.ParseException -> L73
            int r2 = r10.f2214e     // Catch: java.text.ParseException -> L73
            long r4 = r10.g(r2)     // Catch: java.text.ParseException -> L73
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 > 0) goto L57
            goto L58
        L57:
            r3 = 0
        L58:
            if (r3 == 0) goto L66
            long r7 = r7.getTime()     // Catch: java.text.ParseException -> L73
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.text.ParseException -> L73
            r6.b(r7)     // Catch: java.text.ParseException -> L73
            return
        L66:
            c.e.a.b.l.d r7 = new c.e.a.b.l.d     // Catch: java.text.ParseException -> L73
            r7.<init>(r6, r8)     // Catch: java.text.ParseException -> L73
            r6.f1023f = r7     // Catch: java.text.ParseException -> L73
            com.google.android.material.textfield.TextInputLayout r8 = r6.a     // Catch: java.text.ParseException -> L73
            r8.postDelayed(r7, r0)     // Catch: java.text.ParseException -> L73
            goto L7a
        L73:
            com.google.android.material.textfield.TextInputLayout r7 = r6.a
            java.lang.Runnable r8 = r6.f1022e
            r7.postDelayed(r8, r0)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.a.b.l.c.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }
}
