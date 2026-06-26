package c.b.a.m.q;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: GlideException.java */
/* JADX INFO: loaded from: classes.dex */
public final class r extends Exception {
    public static final StackTraceElement[] a = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private c.b.a.m.a dataSource;
    private String detailMessage;

    @Nullable
    private Exception exception;
    private c.b.a.m.j key;

    public r(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    public static void b(List<Throwable> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void c(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof r) {
                ((r) th).e(appendable);
            } else {
                d(th, appendable);
            }
            i2 = i3;
        }
    }

    public static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public final void a(Throwable th, List<Throwable> list) {
        if (!(th instanceof r)) {
            list.add(th);
            return;
        }
        Iterator<Throwable> it = ((r) th).getCauses().iterator();
        while (it.hasNext()) {
            a(it.next(), list);
        }
    }

    public final void e(Appendable appendable) {
        d(this, appendable);
        b(getCauses(), new a(appendable));
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String string;
        String string2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        String string3 = "";
        if (this.dataClass != null) {
            StringBuilder sbR = c.a.a.a.a.r(", ");
            sbR.append(this.dataClass);
            string = sbR.toString();
        } else {
            string = "";
        }
        sb.append(string);
        if (this.dataSource != null) {
            StringBuilder sbR2 = c.a.a.a.a.r(", ");
            sbR2.append(this.dataSource);
            string2 = sbR2.toString();
        } else {
            string2 = "";
        }
        sb.append(string2);
        if (this.key != null) {
            StringBuilder sbR3 = c.a.a.a.a.r(", ");
            sbR3.append(this.key);
            string3 = sbR3.toString();
        }
        sb.append(string3);
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            sb.append(" root causes:");
        }
        for (Throwable th : rootCauses) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Nullable
    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            rootCauses.get(i2);
            i2 = i3;
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void setLoggingDetails(c.b.a.m.j jVar, c.b.a.m.a aVar) {
        setLoggingDetails(jVar, aVar, null);
    }

    public void setOrigin(@Nullable Exception exc) {
        this.exception = exc;
    }

    public r(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        e(printStream);
    }

    public void setLoggingDetails(c.b.a.m.j jVar, c.b.a.m.a aVar, Class<?> cls) {
        this.key = jVar;
        this.dataSource = aVar;
        this.dataClass = cls;
    }

    public r(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(a);
        this.causes = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        e(printWriter);
    }

    /* JADX INFO: compiled from: GlideException.java */
    public static final class a implements Appendable {
        public final Appendable a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f470b = true;

        public a(Appendable appendable) {
            this.a = appendable;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c2) throws IOException {
            if (this.f470b) {
                this.f470b = false;
                this.a.append("  ");
            }
            this.f470b = c2 == '\n';
            this.a.append(c2);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            append(charSequence, 0, charSequence.length());
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence, int i2, int i3) throws IOException {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z = false;
            if (this.f470b) {
                this.f470b = false;
                this.a.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i3 - 1) == '\n') {
                z = true;
            }
            this.f470b = z;
            this.a.append(charSequence, i2, i3);
            return this;
        }
    }
}
