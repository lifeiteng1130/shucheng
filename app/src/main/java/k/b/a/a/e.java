package k.b.a.a;

import h.a.a.a.w;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Objects;
import k.b.a.a.i.a.i;
import k.b.a.a.i.a.j;

/* JADX INFO: compiled from: StringEscapeUtils.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class e {
    public static final k.b.a.a.i.a.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k.b.a.a.i.a.b f8541b;

    /* JADX INFO: compiled from: StringEscapeUtils.java */
    public static class a extends k.b.a.a.i.a.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f8542b = String.valueOf('\"');

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final char[] f8543c = {',', '\"', '\r', '\n'};

        @Override // k.b.a.a.i.a.b
        public int a(CharSequence charSequence, int i2, Writer writer) throws IOException {
            if (i2 != 0) {
                throw new IllegalStateException("CsvEscaper should never reach the [1] index");
            }
            if (f.b(charSequence.toString(), f8543c)) {
                writer.write(charSequence.toString());
            } else {
                writer.write(34);
                String string = charSequence.toString();
                String str = f8542b;
                writer.write(f.j(string, str, str + str));
                writer.write(34);
            }
            return Character.codePointCount(charSequence, 0, charSequence.length());
        }
    }

    /* JADX INFO: compiled from: StringEscapeUtils.java */
    public static class b extends k.b.a.a.i.a.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f8544b = String.valueOf('\"');

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final char[] f8545c = {',', '\"', '\r', '\n'};

        @Override // k.b.a.a.i.a.b
        public int a(CharSequence charSequence, int i2, Writer writer) throws IOException {
            if (i2 != 0) {
                throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
            }
            if (charSequence.charAt(0) != '\"' || charSequence.charAt(charSequence.length() - 1) != '\"') {
                writer.write(charSequence.toString());
                return Character.codePointCount(charSequence, 0, charSequence.length());
            }
            String string = charSequence.subSequence(1, charSequence.length() - 1).toString();
            if (f.a(string, f8545c)) {
                StringBuilder sb = new StringBuilder();
                String str = f8544b;
                sb.append(str);
                sb.append(str);
                writer.write(f.j(string, sb.toString(), str));
            } else {
                writer.write(charSequence.toString());
            }
            return Character.codePointCount(charSequence, 0, charSequence.length());
        }
    }

    static {
        new k.b.a.a.i.a.f(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}).b(new k.b.a.a.i.a.f(k.b.a.a.i.a.d.d())).b(k.b.a.a.i.a.e.d(32, 127));
        a = new k.b.a.a.i.a.a(new k.b.a.a.i.a.f(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{w.DEFAULT_PATH_SEPARATOR, "\\/"}), new k.b.a.a.i.a.f(k.b.a.a.i.a.d.d()), k.b.a.a.i.a.e.d(32, 127));
        String[][] strArr = k.b.a.a.i.a.d.a;
        f8541b = new k.b.a.a.i.a.a(new i(), new j(), new k.b.a.a.i.a.f((String[][]) k.b.a.a.i.a.d.f8558j.clone()), new k.b.a.a.i.a.f(new String[]{"\\\\", "\\"}, new String[]{"\\\"", "\""}, new String[]{"\\'", "'"}, new String[]{"\\", ""}));
        String[][] strArr2 = k.b.a.a.i.a.d.f8550b;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final String a(String str) {
        k.b.a.a.i.a.b bVar = a;
        Objects.requireNonNull(bVar);
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(str.length() * 2);
            int length = str.length();
            int iCharCount = 0;
            while (iCharCount < length) {
                int iA = bVar.a(str, iCharCount, stringWriter);
                if (iA == 0) {
                    char cCharAt = str.charAt(iCharCount);
                    stringWriter.write(cCharAt);
                    iCharCount++;
                    if (Character.isHighSurrogate(cCharAt) && iCharCount < length) {
                        char cCharAt2 = str.charAt(iCharCount);
                        if (Character.isLowSurrogate(cCharAt2)) {
                            stringWriter.write(cCharAt2);
                            iCharCount++;
                        }
                    }
                } else {
                    for (int i2 = 0; i2 < iA; i2++) {
                        iCharCount += Character.charCount(Character.codePointAt(str, iCharCount));
                    }
                }
            }
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
