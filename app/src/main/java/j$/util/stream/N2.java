package j$.util.stream;

import j$.util.List;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class N2<T> extends F2<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList f8060d;

    N2(A2 a2, Comparator comparator) {
        super(a2, comparator);
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        this.f8060d.add(obj);
    }

    @Override // j$.util.stream.A2.d, j$.util.stream.A2
    public void l() {
        List.EL.sort(this.f8060d, this.f8043b);
        this.a.m(this.f8060d.size());
        if (this.f8044c) {
            for (Object obj : this.f8060d) {
                if (this.a.o()) {
                    break;
                } else {
                    this.a.accept(obj);
                }
            }
        } else {
            ArrayList arrayList = this.f8060d;
            final A2 a2 = this.a;
            Objects.requireNonNull(a2);
            j$.time.a.v(arrayList, new Consumer() { // from class: j$.util.stream.b
                @Override // j$.util.function.Consumer
                public final void accept(Object obj2) {
                    a2.accept(obj2);
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.$default$andThen(this, consumer);
                }
            });
        }
        this.a.l();
        this.f8060d = null;
    }

    @Override // j$.util.stream.A2.d, j$.util.stream.A2
    public void m(long j2) {
        if (j2 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f8060d = j2 >= 0 ? new ArrayList((int) j2) : new ArrayList();
    }
}
