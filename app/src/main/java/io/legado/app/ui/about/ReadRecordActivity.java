package io.legado.app.ui.about;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.u;
import f.h0.k;
import f.v;
import f.x.e;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import g.b.g2.m;
import g.b.k0;
import g.b.o1;
import io.legado.app.base.BaseActivity;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.ReadRecordShow;
import io.legado.app.databinding.ActivityReadRecordBinding;
import io.legado.app.databinding.ItemReadRecordBinding;
import io.legado.app.ui.about.ReadRecordActivity;
import io.legado.app.ui.widget.TitleBar;
import io.wenyuange.app.release.R;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ReadRecordActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b$\u0010\u0017J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR&\u0010#\u001a\u00060\u001cR\u00020\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lio/legado/app/ui/about/ReadRecordActivity;", "Lio/legado/app/base/BaseActivity;", "Lio/legado/app/databinding/ActivityReadRecordBinding;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "", "mss", "", "T0", "(J)Ljava/lang/String;", "U0", "()V", "", ai.aA, OptRuntime.GeneratorState.resumptionPoint_TYPE, "sortMode", "Lio/legado/app/ui/about/ReadRecordActivity$RecordAdapter;", "h", "Lio/legado/app/ui/about/ReadRecordActivity$RecordAdapter;", "getAdapter", "()Lio/legado/app/ui/about/ReadRecordActivity$RecordAdapter;", "setAdapter", "(Lio/legado/app/ui/about/ReadRecordActivity$RecordAdapter;)V", "adapter", "<init>", "RecordAdapter", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReadRecordActivity extends BaseActivity<ActivityReadRecordBinding> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f6976g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public RecordAdapter adapter;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int sortMode;

    /* JADX INFO: compiled from: ReadRecordActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/legado/app/ui/about/ReadRecordActivity$RecordAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/ReadRecordShow;", "Lio/legado/app/databinding/ItemReadRecordBinding;", "Landroid/content/Context;", c.R, "<init>", "(Lio/legado/app/ui/about/ReadRecordActivity;Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public final class RecordAdapter extends RecyclerAdapter<ReadRecordShow, ItemReadRecordBinding> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ReadRecordActivity f6979f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecordAdapter(@NotNull ReadRecordActivity readRecordActivity, Context context) {
            super(context);
            j.e(readRecordActivity, "this$0");
            j.e(context, c.R);
            this.f6979f = readRecordActivity;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, ReadRecordShow readRecordShow, List list, int i2) {
            ItemReadRecordBinding itemReadRecordBinding = (ItemReadRecordBinding) viewBinding;
            ReadRecordShow readRecordShow2 = readRecordShow;
            j.e(itemViewHolder, "holder");
            j.e(itemReadRecordBinding, "binding");
            j.e(readRecordShow2, "item");
            j.e(list, "payloads");
            ReadRecordActivity readRecordActivity = this.f6979f;
            itemReadRecordBinding.f6812b.setText(readRecordShow2.getBookName());
            itemReadRecordBinding.f6813c.setText(readRecordActivity.T0(readRecordShow2.getReadTime()));
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public ViewBinding q(ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            ItemReadRecordBinding itemReadRecordBindingA = ItemReadRecordBinding.a(this.inflater.inflate(R.layout.item_read_record, viewGroup, false));
            j.d(itemReadRecordBindingA, "inflate(inflater, parent, false)");
            return itemReadRecordBindingA;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
            ItemReadRecordBinding itemReadRecordBinding = (ItemReadRecordBinding) viewBinding;
            j.e(itemViewHolder, "holder");
            j.e(itemReadRecordBinding, "binding");
            final ReadRecordActivity readRecordActivity = this.f6979f;
            itemReadRecordBinding.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.a.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadRecordActivity.RecordAdapter recordAdapter = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    ReadRecordActivity readRecordActivity2 = readRecordActivity;
                    j.e(recordAdapter, "this$0");
                    j.e(itemViewHolder2, "$holder");
                    j.e(readRecordActivity2, "this$1");
                    ReadRecordShow item = recordAdapter.getItem(itemViewHolder2.getLayoutPosition());
                    if (item == null) {
                        return;
                    }
                    c.b.a.m.f.L3(readRecordActivity2, null, null, new g(readRecordActivity2, item, null), 3, null);
                }
            });
            itemReadRecordBinding.f6814d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.a.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadRecordActivity.RecordAdapter recordAdapter = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    j.e(recordAdapter, "this$0");
                    j.e(itemViewHolder2, "$holder");
                    ReadRecordShow item = recordAdapter.getItem(itemViewHolder2.getLayoutPosition());
                    if (item == null) {
                        return;
                    }
                    ((e.a.a.e.a.i) c.b.a.m.f.j0(recordAdapter.f6979f, Integer.valueOf(R.string.delete), null, new h(recordAdapter.f6979f, item), 2)).p();
                }
            });
        }
    }

    /* JADX INFO: compiled from: ReadRecordActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.about.ReadRecordActivity$initData$1", f = "ReadRecordActivity.kt", i = {}, l = {79, 91}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public int label;

        /* JADX INFO: renamed from: io.legado.app.ui.about.ReadRecordActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ReadRecordActivity.kt */
        @DebugMetadata(c = "io.legado.app.ui.about.ReadRecordActivity$initData$1$1", f = "ReadRecordActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0189a extends g implements p<a0, d<? super v>, Object> {
            public final /* synthetic */ long $allTime;
            public int label;
            public final /* synthetic */ ReadRecordActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0189a(ReadRecordActivity readRecordActivity, long j2, d<? super C0189a> dVar) {
                super(2, dVar);
                this.this$0 = readRecordActivity;
                this.$allTime = j2;
            }

            @Override // f.z.j.a.a
            @NotNull
            public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new C0189a(this.this$0, this.$allTime, dVar);
            }

            @Override // f.c0.b.p
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
                return ((C0189a) create(a0Var, dVar)).invokeSuspend(v.a);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
                ReadRecordActivity readRecordActivity = this.this$0;
                int i2 = ReadRecordActivity.f6976g;
                readRecordActivity.K0().f6524b.f6813c.setText(this.this$0.T0(this.$allTime));
                return v.a;
            }
        }

        /* JADX INFO: compiled from: ReadRecordActivity.kt */
        @DebugMetadata(c = "io.legado.app.ui.about.ReadRecordActivity$initData$1$4", f = "ReadRecordActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends g implements p<a0, d<? super v>, Object> {
            public final /* synthetic */ u<List<ReadRecordShow>> $readRecords;
            public int label;
            public final /* synthetic */ ReadRecordActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ReadRecordActivity readRecordActivity, u<List<ReadRecordShow>> uVar, d<? super b> dVar) {
                super(2, dVar);
                this.this$0 = readRecordActivity;
                this.$readRecords = uVar;
            }

            @Override // f.z.j.a.a
            @NotNull
            public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new b(this.this$0, this.$readRecords, dVar);
            }

            @Override // f.c0.b.p
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
                return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
                RecordAdapter recordAdapter = this.this$0.adapter;
                if (recordAdapter != null) {
                    recordAdapter.x(this.$readRecords.element);
                    return v.a;
                }
                j.m("adapter");
                throw null;
            }
        }

        /* JADX INFO: compiled from: Comparisons.kt */
        public static final class c<T> implements Comparator<T>, j$.util.Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator, j$.util.Comparator
            public final int compare(T t, T t2) {
                return f.V0(Long.valueOf(((ReadRecordShow) t).getReadTime()), Long.valueOf(((ReadRecordShow) t2).getReadTime()));
            }

            @Override // java.util.Comparator, j$.util.Comparator
            public /* synthetic */ Comparator reversed() {
                return Collections.reverseOrder(this);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ Comparator thenComparing(Function function) {
                return Comparator.CC.$default$thenComparing(this, function);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
                return Comparator.CC.$default$thenComparing(this, function, comparator);
            }

            @Override // java.util.Comparator, j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
                return Comparator.CC.$default$thenComparing(this, comparator);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
                return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
                return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
                return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
            }
        }

        public a(d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return ReadRecordActivity.this.new a(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v4, types: [T, java.util.List] */
        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                long allTime = AppDatabaseKt.getAppDb().getReadRecordDao().getAllTime();
                k0 k0Var = k0.f6264c;
                o1 o1Var = m.f6207b;
                C0189a c0189a = new C0189a(ReadRecordActivity.this, allTime, null);
                this.label = 1;
                if (f.f6(o1Var, c0189a, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f.E5(obj);
                    return v.a;
                }
                f.E5(obj);
            }
            u uVar = new u();
            ?? allShow = AppDatabaseKt.getAppDb().getReadRecordDao().getAllShow();
            uVar.element = allShow;
            uVar.element = ReadRecordActivity.this.sortMode == 1 ? e.B((Iterable) allShow, new c()) : e.B((Iterable) allShow, e.a.a.g.a.c.a);
            k0 k0Var2 = k0.f6264c;
            o1 o1Var2 = m.f6207b;
            b bVar = new b(ReadRecordActivity.this, uVar, null);
            this.label = 2;
            if (f.f6(o1Var2, bVar, this) == aVar) {
                return aVar;
            }
            return v.a;
        }
    }

    public ReadRecordActivity() {
        super(false, null, null, false, false, 31);
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_read_record, (ViewGroup) null, false);
        int i2 = R.id.read_record;
        View viewFindViewById = viewInflate.findViewById(R.id.read_record);
        if (viewFindViewById != null) {
            ItemReadRecordBinding itemReadRecordBindingA = ItemReadRecordBinding.a(viewFindViewById);
            RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                if (titleBar != null) {
                    ActivityReadRecordBinding activityReadRecordBinding = new ActivityReadRecordBinding((LinearLayout) viewInflate, itemReadRecordBindingA, recyclerView, titleBar);
                    j.d(activityReadRecordBinding, "inflate(layoutInflater)");
                    return activityReadRecordBinding;
                }
                i2 = R.id.title_bar;
            } else {
                i2 = R.id.recycler_view;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        ActivityReadRecordBinding activityReadRecordBindingK0 = K0();
        activityReadRecordBindingK0.f6524b.f6812b.setText(R.string.all_read_time);
        RecordAdapter recordAdapter = new RecordAdapter(this, this);
        j.e(recordAdapter, "<set-?>");
        this.adapter = recordAdapter;
        activityReadRecordBindingK0.f6525c.setAdapter(recordAdapter);
        activityReadRecordBindingK0.f6524b.f6814d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.a.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadRecordActivity readRecordActivity = this.a;
                int i2 = ReadRecordActivity.f6976g;
                j.e(readRecordActivity, "this$0");
                ((e.a.a.e.a.i) c.b.a.m.f.h0(readRecordActivity, Integer.valueOf(R.string.delete), Integer.valueOf(R.string.sure_del), new i(readRecordActivity))).p();
            }
        });
        U0();
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.book_read_record, menu);
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        switch (item.getItemId()) {
            case R.id.menu_sort_name /* 2131296886 */:
                this.sortMode = 0;
                U0();
                break;
            case R.id.menu_sort_time /* 2131296887 */:
                this.sortMode = 1;
                U0();
                break;
        }
        return super.Q0(item);
    }

    @NotNull
    public final String T0(long mss) {
        String string;
        String str;
        String str2;
        long j2 = BaseConstants.Time.DAY;
        long j3 = mss / j2;
        long j4 = BaseConstants.Time.HOUR;
        long j5 = (mss % j2) / j4;
        long j6 = BaseConstants.Time.MINUTE;
        long j7 = (mss % j4) / j6;
        long j8 = (mss % j6) / ((long) 1000);
        String string2 = "";
        if (j3 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(j3);
            sb.append((char) 22825);
            string = sb.toString();
        } else {
            string = "";
        }
        if (j5 > 0) {
            str = j5 + "小时";
        } else {
            str = "";
        }
        if (j7 > 0) {
            str2 = j7 + "分钟";
        } else {
            str2 = "";
        }
        if (j8 > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j8);
            sb2.append((char) 31186);
            string2 = sb2.toString();
        }
        String str3 = string + str + str2 + string2;
        return k.s(str3) ? "0秒" : str3;
    }

    public final void U0() {
        k0 k0Var = k0.f6264c;
        f.L3(this, k0.f6263b, null, new a(null), 2, null);
    }
}
