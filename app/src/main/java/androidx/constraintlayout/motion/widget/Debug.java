package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import c.a.a.a.a;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public class Debug {
    public static void dumpLayoutParams(ViewGroup viewGroup, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbR = a.r(".(");
        sbR.append(stackTraceElement.getFileName());
        sbR.append(":");
        sbR.append(stackTraceElement.getLineNumber());
        sbR.append(") ");
        sbR.append(str);
        sbR.append("  ");
        String string = sbR.toString();
        int childCount = viewGroup.getChildCount();
        System.out.println(str + " children " + childCount);
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            PrintStream printStream = System.out;
            StringBuilder sbT = a.t(string, "     ");
            sbT.append(getName(childAt));
            printStream.println(sbT.toString());
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            for (Field field : layoutParams.getClass().getFields()) {
                try {
                    Object obj = field.get(layoutParams);
                    if (field.getName().contains("To") && !obj.toString().equals("-1")) {
                        System.out.println(string + "       " + field.getName() + " " + obj);
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public static void dumpPoc(Object obj) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbR = a.r(".(");
        sbR.append(stackTraceElement.getFileName());
        sbR.append(":");
        sbR.append(stackTraceElement.getLineNumber());
        sbR.append(")");
        String string = sbR.toString();
        Class<?> cls = obj.getClass();
        PrintStream printStream = System.out;
        StringBuilder sbT = a.t(string, "------------- ");
        sbT.append(cls.getName());
        sbT.append(" --------------------");
        printStream.println(sbT.toString());
        for (Field field : cls.getFields()) {
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint") && ((!(obj2 instanceof Integer) || !obj2.toString().equals("-1")) && ((!(obj2 instanceof Integer) || !obj2.toString().equals("0")) && ((!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) && (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")))))) {
                    System.out.println(string + "    " + field.getName() + " " + obj2);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        PrintStream printStream2 = System.out;
        StringBuilder sbT2 = a.t(string, "------------- ");
        sbT2.append(cls.getSimpleName());
        sbT2.append(" --------------------");
        printStream2.println(sbT2.toString());
    }

    public static String getActionType(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        for (Field field : MotionEvent.class.getFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt(null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "---";
    }

    public static String getCallFrom(int i2) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i2 + 2];
        StringBuilder sbR = a.r(".(");
        sbR.append(stackTraceElement.getFileName());
        sbR.append(":");
        sbR.append(stackTraceElement.getLineNumber());
        sbR.append(")");
        return sbR.toString();
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbR = a.r(".(");
        sbR.append(stackTraceElement.getFileName());
        sbR.append(":");
        sbR.append(stackTraceElement.getLineNumber());
        sbR.append(") ");
        sbR.append(stackTraceElement.getMethodName());
        sbR.append("()");
        return sbR.toString();
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbR = a.r(".(");
        sbR.append(stackTraceElement.getFileName());
        sbR.append(":");
        sbR.append(stackTraceElement.getLineNumber());
        sbR.append(")");
        return sbR.toString();
    }

    public static String getLocation2() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        StringBuilder sbR = a.r(".(");
        sbR.append(stackTraceElement.getFileName());
        sbR.append(":");
        sbR.append(stackTraceElement.getLineNumber());
        sbR.append(")");
        return sbR.toString();
    }

    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getState(MotionLayout motionLayout, int i2) {
        return i2 == -1 ? "UNDEFINED" : motionLayout.getContext().getResources().getResourceEntryName(i2);
    }

    public static void logStack(String str, String str2, int i2) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(i2, stackTrace.length - 1);
        String str3 = " ";
        for (int i3 = 1; i3 <= iMin; i3++) {
            StackTraceElement stackTraceElement = stackTrace[i3];
            StringBuilder sbR = a.r(".(");
            sbR.append(stackTrace[i3].getFileName());
            sbR.append(":");
            sbR.append(stackTrace[i3].getLineNumber());
            sbR.append(") ");
            sbR.append(stackTrace[i3].getMethodName());
            sbR.toString();
            str3 = str3 + " ";
        }
    }

    public static void printStack(String str, int i2) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(i2, stackTrace.length - 1);
        String strI = " ";
        for (int i3 = 1; i3 <= iMin; i3++) {
            StackTraceElement stackTraceElement = stackTrace[i3];
            StringBuilder sbR = a.r(".(");
            sbR.append(stackTrace[i3].getFileName());
            sbR.append(":");
            sbR.append(stackTrace[i3].getLineNumber());
            sbR.append(") ");
            String string = sbR.toString();
            strI = a.i(strI, " ");
            System.out.println(str + strI + string + strI);
        }
    }

    public static String getName(Context context, int i2) {
        if (i2 == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i2);
        } catch (Exception unused) {
            return a.G("?", i2);
        }
    }

    public static String getName(Context context, int[] iArr) {
        String resourceEntryName;
        try {
            String str = iArr.length + "[";
            int i2 = 0;
            while (i2 < iArr.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(i2 == 0 ? "" : " ");
                String string = sb.toString();
                try {
                    resourceEntryName = context.getResources().getResourceEntryName(iArr[i2]);
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = "? " + iArr[i2] + " ";
                }
                str = string + resourceEntryName;
                i2++;
            }
            return str + "]";
        } catch (Exception e2) {
            e2.toString();
            return "UNKNOWN";
        }
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams layoutParams, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbR = a.r(".(");
        sbR.append(stackTraceElement.getFileName());
        sbR.append(":");
        sbR.append(stackTraceElement.getLineNumber());
        sbR.append(") ");
        sbR.append(str);
        sbR.append("  ");
        String string = sbR.toString();
        PrintStream printStream = System.out;
        StringBuilder sbU = a.u(" >>>>>>>>>>>>>>>>>>. dump ", string, "  ");
        sbU.append(layoutParams.getClass().getName());
        printStream.println(sbU.toString());
        for (Field field : layoutParams.getClass().getFields()) {
            try {
                Object obj = field.get(layoutParams);
                String name = field.getName();
                if (name.contains("To") && !obj.toString().equals("-1")) {
                    System.out.println(string + "       " + name + " " + obj);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + string);
    }
}
