package c.e.a.b.l;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.MonthsPagerAdapter;
import java.util.Iterator;

/* JADX INFO: compiled from: MonthsPagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    public final /* synthetic */ MaterialCalendarGridView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MonthsPagerAdapter f1040b;

    public p(MonthsPagerAdapter monthsPagerAdapter, MaterialCalendarGridView materialCalendarGridView) {
        this.f1040b = monthsPagerAdapter;
        this.a = materialCalendarGridView;
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
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        o adapter = this.a.getAdapter();
        if (i2 >= adapter.b() && i2 <= adapter.d()) {
            MaterialCalendar.f fVar = this.f1040b.f2219d;
            long jLongValue = this.a.getAdapter().getItem(i2).longValue();
            MaterialCalendar.d dVar = (MaterialCalendar.d) fVar;
            if (MaterialCalendar.this.f2186e.f2171c.c(jLongValue)) {
                MaterialCalendar.this.f2185d.L(jLongValue);
                Iterator it = MaterialCalendar.this.a.iterator();
                while (it.hasNext()) {
                    ((q) it.next()).b(MaterialCalendar.this.f2185d.H());
                }
                MaterialCalendar.this.f2191j.getAdapter().notifyDataSetChanged();
                RecyclerView recyclerView = MaterialCalendar.this.f2190i;
                if (recyclerView != null) {
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}
