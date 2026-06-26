package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import c.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TransitionValues {
    public View view;
    public final Map<String, Object> values = new HashMap();
    public final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sbR = a.r("TransitionValues@");
        sbR.append(Integer.toHexString(hashCode()));
        sbR.append(":\n");
        StringBuilder sbT = a.t(sbR.toString(), "    view = ");
        sbT.append(this.view);
        sbT.append("\n");
        String strI = a.i(sbT.toString(), "    values:");
        for (String str : this.values.keySet()) {
            strI = strI + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return strI;
    }

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }
}
