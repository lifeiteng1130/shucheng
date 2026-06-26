package org.mozilla.javascript.tools.idswitch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.tools.ToolErrorReporter;

/* JADX INFO: loaded from: classes3.dex */
public class Main {
    private static final int GENERATED_TAG = 2;
    private static final String GENERATED_TAG_STR = "generated";
    private static final int NORMAL_LINE = 0;
    private static final int STRING_TAG = 3;
    private static final String STRING_TAG_STR = "string";
    private static final int SWITCH_TAG = 1;
    private static final String SWITCH_TAG_STR = "string_id_map";
    private CodePrinter P;
    private ToolErrorReporter R;
    private final List<IdValuePair> all_pairs = new ArrayList();
    private FileBody body;
    private String source_file;
    private int tag_definition_end;
    private int tag_value_end;
    private int tag_value_start;

    private void add_id(char[] cArr, int i2, int i3, int i4, int i5) {
        IdValuePair idValuePair = new IdValuePair(new String(cArr, i4, i5 - i4), new String(cArr, i2, i3 - i2));
        idValuePair.setLineNumber(this.body.getLineNumber());
        this.all_pairs.add(idValuePair);
    }

    private static boolean equals(String str, char[] cArr, int i2, int i3) {
        if (str.length() != i3 - i2) {
            return false;
        }
        int i4 = 0;
        while (i2 != i3) {
            if (cArr[i2] != str.charAt(i4)) {
                return false;
            }
            i2++;
            i4++;
        }
        return true;
    }

    private int exec(String[] strArr) {
        this.R = new ToolErrorReporter(true, System.err);
        int iProcess_options = process_options(strArr);
        if (iProcess_options == 0) {
            option_error(ToolErrorReporter.getMessage("msg.idswitch.no_file_argument"));
            return -1;
        }
        if (iProcess_options > 1) {
            option_error(ToolErrorReporter.getMessage("msg.idswitch.too_many_arguments"));
            return -1;
        }
        CodePrinter codePrinter = new CodePrinter();
        this.P = codePrinter;
        codePrinter.setIndentStep(4);
        this.P.setIndentTabSize(0);
        try {
            process_file(strArr[0]);
            return 0;
        } catch (IOException e2) {
            print_error(ToolErrorReporter.getMessage("msg.idswitch.io_error", e2.toString()));
            return -1;
        } catch (EvaluatorException unused) {
            return -1;
        }
    }

    private int extract_line_tag_id(char[] cArr, int i2, int i3) {
        boolean z;
        int iSkip_white_space;
        char c2;
        char c3;
        int iSkip_white_space2 = skip_white_space(cArr, i2, i3);
        int iLook_for_slash_slash = look_for_slash_slash(cArr, iSkip_white_space2, i3);
        int iExtract_tag_value = 0;
        if (iLook_for_slash_slash != i3) {
            boolean z2 = iSkip_white_space2 + 2 == iLook_for_slash_slash;
            int iSkip_white_space3 = skip_white_space(cArr, iLook_for_slash_slash, i3);
            if (iSkip_white_space3 != i3 && cArr[iSkip_white_space3] == '#') {
                int i4 = iSkip_white_space3 + 1;
                if (i4 == i3 || cArr[i4] != '/') {
                    z = false;
                } else {
                    i4++;
                    z = true;
                }
                int i5 = i4;
                while (i5 != i3 && (c3 = cArr[i5]) != '#' && c3 != '=' && !is_white_space(c3)) {
                    i5++;
                }
                if (i5 != i3 && (iSkip_white_space = skip_white_space(cArr, i5, i3)) != i3 && (((c2 = cArr[iSkip_white_space]) == '=' || c2 == '#') && (iExtract_tag_value = get_tag_id(cArr, i4, i5, z2)) != 0)) {
                    String str = null;
                    if (c2 == '#') {
                        if (z) {
                            iExtract_tag_value = -iExtract_tag_value;
                            if (is_value_type(iExtract_tag_value)) {
                                str = "msg.idswitch.no_end_usage";
                            }
                        }
                        this.tag_definition_end = iSkip_white_space + 1;
                    } else {
                        if (z) {
                            str = "msg.idswitch.no_end_with_value";
                        } else if (!is_value_type(iExtract_tag_value)) {
                            str = "msg.idswitch.no_value_allowed";
                        }
                        iExtract_tag_value = extract_tag_value(cArr, iSkip_white_space + 1, i3, iExtract_tag_value);
                    }
                    if (str != null) {
                        throw this.R.runtimeError(ToolErrorReporter.getMessage(str, tag_name(iExtract_tag_value)), this.source_file, this.body.getLineNumber(), null, 0);
                    }
                }
            }
        }
        return iExtract_tag_value;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int extract_tag_value(char[] r7, int r8, int r9, int r10) {
        /*
            r6 = this;
            int r8 = skip_white_space(r7, r8, r9)
            r0 = 0
            r1 = 1
            if (r8 == r9) goto L3a
            r2 = r8
        L9:
            if (r2 == r9) goto L2f
            char r3 = r7[r2]
            boolean r4 = is_white_space(r3)
            r5 = 35
            if (r4 == 0) goto L28
            int r3 = r2 + 1
            int r3 = skip_white_space(r7, r3, r9)
            if (r3 == r9) goto L24
            char r4 = r7[r3]
            if (r4 != r5) goto L24
            r7 = r2
            r2 = r3
            goto L30
        L24:
            int r3 = r3 + 1
            r2 = r3
            goto L9
        L28:
            if (r3 != r5) goto L2c
            r7 = r2
            goto L30
        L2c:
            int r2 = r2 + 1
            goto L9
        L2f:
            r7 = r8
        L30:
            if (r2 == r9) goto L3a
            r6.tag_value_start = r8
            r6.tag_value_end = r7
            int r2 = r2 + r1
            r6.tag_definition_end = r2
            goto L3b
        L3a:
            r1 = 0
        L3b:
            if (r1 == 0) goto L3e
            goto L3f
        L3e:
            r10 = 0
        L3f:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.idswitch.Main.extract_tag_value(char[], int, int, int):int");
    }

    private void generate_java_code() {
        this.P.clear();
        IdValuePair[] idValuePairArr = new IdValuePair[this.all_pairs.size()];
        this.all_pairs.toArray(idValuePairArr);
        SwitchGenerator switchGenerator = new SwitchGenerator();
        switchGenerator.char_tail_test_threshold = 2;
        switchGenerator.setReporter(this.R);
        switchGenerator.setCodePrinter(this.P);
        switchGenerator.generateSwitch(idValuePairArr, "0");
    }

    private int get_tag_id(char[] cArr, int i2, int i3, boolean z) {
        if (z) {
            if (equals(SWITCH_TAG_STR, cArr, i2, i3)) {
                return 1;
            }
            if (equals(GENERATED_TAG_STR, cArr, i2, i3)) {
                return 2;
            }
        }
        return equals(STRING_TAG_STR, cArr, i2, i3) ? 3 : 0;
    }

    private String get_time_stamp() {
        return new SimpleDateFormat(" 'Last update:' yyyy-MM-dd HH:mm:ss z").format(new Date());
    }

    private static boolean is_value_type(int i2) {
        return i2 == 3;
    }

    private static boolean is_white_space(int i2) {
        return i2 == 32 || i2 == 9;
    }

    private void look_for_id_definitions(char[] cArr, int i2, int i3, boolean z) {
        int iSkip_name_char;
        int iSkip_white_space;
        int i4;
        int i5;
        int iSkip_white_space2 = skip_white_space(cArr, i2, i3);
        int iSkip_matched_prefix = skip_matched_prefix("Id_", cArr, iSkip_white_space2, i3);
        if (iSkip_matched_prefix < 0 || iSkip_matched_prefix == (iSkip_name_char = skip_name_char(cArr, iSkip_matched_prefix, i3)) || (iSkip_white_space = skip_white_space(cArr, iSkip_name_char, i3)) == i3 || cArr[iSkip_white_space] != '=') {
            return;
        }
        if (z) {
            i4 = this.tag_value_start;
            i5 = this.tag_value_end;
        } else {
            i4 = iSkip_matched_prefix;
            i5 = iSkip_name_char;
        }
        add_id(cArr, iSkip_white_space2, iSkip_name_char, i4, i5);
    }

    private int look_for_slash_slash(char[] cArr, int i2, int i3) {
        while (i2 + 2 <= i3) {
            int i4 = i2 + 1;
            if (cArr[i2] == '/') {
                i2 = i4 + 1;
                if (cArr[i4] == '/') {
                    return i2;
                }
            } else {
                i2 = i4;
            }
        }
        return i3;
    }

    public static void main(String[] strArr) {
        System.exit(new Main().exec(strArr));
    }

    private void option_error(String str) {
        print_error(ToolErrorReporter.getMessage("msg.idswitch.bad_invocation", str));
    }

    private void print_error(String str) {
        System.err.println(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        r5 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075 A[PHI: r5
  0x0075: PHI (r5v3 int) = (r5v2 int), (r5v4 int) binds: [B:29:0x0067, B:32:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int process_options(java.lang.String[] r14) {
        /*
            r13 = this;
            int r0 = r14.length
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
        L5:
            r5 = -1
            r6 = 1
            if (r2 == r0) goto L66
            r7 = r14[r2]
            int r8 = r7.length()
            r9 = 2
            if (r8 < r9) goto L63
            char r10 = r7.charAt(r1)
            r11 = 45
            if (r10 != r11) goto L63
            char r10 = r7.charAt(r6)
            r12 = 0
            if (r10 != r11) goto L44
            if (r8 != r9) goto L26
            r14[r2] = r12
            goto L66
        L26:
            java.lang.String r8 = "--help"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L30
            r3 = 1
            goto L61
        L30:
            java.lang.String r8 = "--version"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L3a
            r4 = 1
            goto L61
        L3a:
            java.lang.String r0 = "msg.idswitch.bad_option"
            java.lang.String r0 = org.mozilla.javascript.tools.ToolErrorReporter.getMessage(r0, r7)
            r13.option_error(r0)
            goto L67
        L44:
            r9 = 1
        L45:
            if (r9 == r8) goto L61
            char r10 = r7.charAt(r9)
            r11 = 104(0x68, float:1.46E-43)
            if (r10 == r11) goto L5d
            java.lang.String r0 = java.lang.String.valueOf(r10)
            java.lang.String r2 = "msg.idswitch.bad_option_char"
            java.lang.String r0 = org.mozilla.javascript.tools.ToolErrorReporter.getMessage(r2, r0)
            r13.option_error(r0)
            goto L67
        L5d:
            int r9 = r9 + 1
            r3 = 1
            goto L45
        L61:
            r14[r2] = r12
        L63:
            int r2 = r2 + 1
            goto L5
        L66:
            r5 = 1
        L67:
            if (r5 != r6) goto L75
            if (r3 == 0) goto L6f
            r13.show_usage()
            r5 = 0
        L6f:
            if (r4 == 0) goto L75
            r13.show_version()
            goto L76
        L75:
            r1 = r5
        L76:
            if (r1 == r6) goto L7b
            java.lang.System.exit(r1)
        L7b:
            int r14 = r13.remove_nulls(r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.idswitch.Main.process_options(java.lang.String[]):int");
    }

    private int remove_nulls(String[] strArr) {
        int length = strArr.length;
        int i2 = 0;
        while (i2 != length && strArr[i2] != null) {
            i2++;
        }
        if (i2 != length) {
            for (int i3 = i2 + 1; i3 != length; i3++) {
                String str = strArr[i3];
                if (str != null) {
                    strArr[i2] = str;
                    i2++;
                }
            }
        }
        return i2;
    }

    private void show_usage() {
        System.out.println(ToolErrorReporter.getMessage("msg.idswitch.usage"));
        System.out.println();
    }

    private void show_version() {
        System.out.println(ToolErrorReporter.getMessage("msg.idswitch.version"));
    }

    private static int skip_matched_prefix(String str, char[] cArr, int i2, int i3) {
        int length = str.length();
        if (length > i3 - i2) {
            return -1;
        }
        int i4 = 0;
        while (i4 != length) {
            if (str.charAt(i4) != cArr[i2]) {
                return -1;
            }
            i4++;
            i2++;
        }
        return i2;
    }

    private static int skip_name_char(char[] cArr, int i2, int i3) {
        while (i2 != i3) {
            char c2 = cArr[i2];
            if (('a' > c2 || c2 > 'z') && (('A' > c2 || c2 > 'Z') && (('0' > c2 || c2 > '9') && c2 != '_'))) {
                break;
            }
            i2++;
        }
        return i2;
    }

    private static int skip_white_space(char[] cArr, int i2, int i3) {
        while (i2 != i3 && is_white_space(cArr[i2])) {
            i2++;
        }
        return i2;
    }

    private static String tag_name(int i2) {
        return i2 != -2 ? i2 != -1 ? i2 != 1 ? i2 != 2 ? "" : GENERATED_TAG_STR : SWITCH_TAG_STR : "/string_id_map" : "/generated";
    }

    public void process_file(String str) throws IOException {
        this.source_file = str;
        this.body = new FileBody();
        InputStream fileInputStream = str.equals("-") ? System.in : new FileInputStream(str);
        try {
            this.body.readData(new InputStreamReader(fileInputStream, "ASCII"));
            fileInputStream.close();
            process_file();
            if (this.body.wasModified()) {
                OutputStream fileOutputStream = str.equals("-") ? System.out : new FileOutputStream(str);
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    this.body.writeData(outputStreamWriter);
                    outputStreamWriter.flush();
                } finally {
                    fileOutputStream.close();
                }
            }
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    private void process_file() {
        char[] buffer = this.body.getBuffer();
        this.body.startLineLoop();
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        while (this.body.nextLine()) {
            int lineBegin = this.body.getLineBegin();
            int lineEnd = this.body.getLineEnd();
            int iExtract_line_tag_id = extract_line_tag_id(buffer, lineBegin, lineEnd);
            boolean z = true;
            if (i2 == 0) {
                if (iExtract_line_tag_id == 1) {
                    this.all_pairs.clear();
                    i2 = 1;
                    i3 = -1;
                } else if (iExtract_line_tag_id == -1) {
                }
                z = false;
            } else if (i2 == 1) {
                if (iExtract_line_tag_id == 0) {
                    look_for_id_definitions(buffer, lineBegin, lineEnd, false);
                } else if (iExtract_line_tag_id == 3) {
                    look_for_id_definitions(buffer, lineBegin, lineEnd, true);
                } else if (iExtract_line_tag_id == 2) {
                    if (i3 < 0) {
                        i5 = this.tag_definition_end;
                        i6 = lineEnd;
                        i2 = 2;
                    }
                } else if (iExtract_line_tag_id == -1) {
                    if (i3 >= 0 && !this.all_pairs.isEmpty()) {
                        generate_java_code();
                        if (this.body.setReplacement(i3, i4, this.P.toString())) {
                            this.body.setReplacement(i5, i6, get_time_stamp());
                        }
                    }
                    i2 = 0;
                }
                z = false;
            } else if (i2 == 2) {
                if (iExtract_line_tag_id == 0) {
                    if (i3 < 0) {
                        i3 = lineBegin;
                    }
                } else if (iExtract_line_tag_id == -2) {
                    if (i3 < 0) {
                        i3 = lineBegin;
                    }
                    i4 = lineBegin;
                    i2 = 1;
                }
                z = false;
            } else {
                z = false;
            }
            if (z) {
                throw this.R.runtimeError(ToolErrorReporter.getMessage("msg.idswitch.bad_tag_order", tag_name(iExtract_line_tag_id)), this.source_file, this.body.getLineNumber(), null, 0);
            }
        }
        if (i2 == 0) {
            return;
        }
        throw this.R.runtimeError(ToolErrorReporter.getMessage("msg.idswitch.file_end_in_switch", tag_name(i2)), this.source_file, this.body.getLineNumber(), null, 0);
    }
}
