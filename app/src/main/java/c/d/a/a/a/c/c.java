package c.d.a.a.a.c;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: DictionaryFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static a a(String str, boolean z) throws Throwable {
        Exception e2;
        BufferedReader bufferedReader;
        int iMax;
        String line;
        HashMap map = new HashMap(8192);
        c.d.a.a.a.a aVar = new c.d.a.a.a.a();
        int i2 = 2;
        BufferedReader bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                InputStream resourceAsStream = c.class.getClassLoader().getResourceAsStream(str);
                Objects.requireNonNull(resourceAsStream);
                bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(resourceAsStream), StandardCharsets.UTF_8));
                iMax = 2;
                while (true) {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            try {
                                break;
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                bufferedReader2 = line;
                            }
                        } else if (line.length() != 0 && !line.startsWith("#")) {
                            String[] strArrC = c(line, "=");
                            if (strArrC.length >= 2) {
                                if (z) {
                                    if (strArrC[0].length() == 1 && strArrC[1].length() == 1) {
                                        map.put(Character.valueOf(strArrC[1].charAt(0)), Character.valueOf(strArrC[0].charAt(0)));
                                    } else {
                                        iMax = Math.max(strArrC[0].length(), iMax);
                                        aVar.a(strArrC[1], strArrC[0]);
                                    }
                                } else if (strArrC[0].length() == 1 && strArrC[1].length() == 1) {
                                    map.put(Character.valueOf(strArrC[0].charAt(0)), Character.valueOf(strArrC[1].charAt(0)));
                                } else {
                                    iMax = Math.max(strArrC[0].length(), iMax);
                                    aVar.a(strArrC[0], strArrC[1]);
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        i2 = iMax;
                        bufferedReader3 = bufferedReader;
                        e2.printStackTrace();
                        if (bufferedReader3 != null) {
                            try {
                                bufferedReader3.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        iMax = i2;
                        bufferedReader2 = bufferedReader3;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                bufferedReader2 = line;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
            }
        } catch (Exception e7) {
            e2 = e7;
        }
        return new a(map, aVar, iMax);
    }

    public static d b(a aVar, String str, boolean z) throws Throwable {
        a aVarA = a(str, z);
        return new d(aVar, aVarA.a, aVarA.f818b, aVarA.f819c);
    }

    public static String[] c(String str, String str2) {
        int iIndexOf = str.indexOf(str2);
        return iIndexOf < 0 ? new String[]{str} : new String[]{str.substring(0, iIndexOf), str.substring(iIndexOf + 1)};
    }
}
