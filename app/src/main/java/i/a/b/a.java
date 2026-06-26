package i.a.b;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: JSONArray.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends ArrayList<Object> implements List<Object>, c, f, j$.util.List {
    private static final long serialVersionUID = 9106884089231309568L;

    public static String toJSONString(List<? extends Object> list) {
        return toJSONString(list, i.a);
    }

    public static void writeJSONString(Iterable<? extends Object> iterable, Appendable appendable, g gVar) throws IOException {
        if (iterable == null) {
            appendable.append("null");
            return;
        }
        Objects.requireNonNull(gVar);
        appendable.append('[');
        boolean z = true;
        for (Object obj : iterable) {
            if (z) {
                z = false;
            } else {
                appendable.append(',');
            }
            if (obj == null) {
                appendable.append("null");
            } else {
                i.b(obj, appendable, gVar);
            }
        }
        appendable.append(']');
    }

    public a appendElement(Object obj) {
        add(obj);
        return this;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public void merge(Object obj) {
        d.merge(this, obj);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Q1.v(j$.time.a.A(this), true);
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // java.util.ArrayList, java.util.List, j$.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        List.CC.$default$sort(this, comparator);
    }

    @Override // java.util.ArrayList, java.util.Collection, java.lang.Iterable, java.util.List, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream stream() {
        return Q1.v(j$.time.a.A(this), false);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return toJSONString();
    }

    public static String toJSONString(java.util.List<? extends Object> list, g gVar) {
        StringBuilder sb = new StringBuilder();
        try {
            writeJSONString(list, sb, gVar);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public String toString(g gVar) {
        return toJSONString(gVar);
    }

    @Override // i.a.b.b
    public String toJSONString() {
        return toJSONString(this, i.a);
    }

    @Override // i.a.b.c
    public String toJSONString(g gVar) {
        return toJSONString(this, gVar);
    }

    public static void writeJSONString(java.util.List<? extends Object> list, Appendable appendable) throws IOException {
        writeJSONString(list, appendable, i.a);
    }

    @Override // i.a.b.e
    public void writeJSONString(Appendable appendable) throws IOException {
        writeJSONString(this, appendable, i.a);
    }

    @Override // i.a.b.f
    public void writeJSONString(Appendable appendable, g gVar) throws IOException {
        writeJSONString(this, appendable, gVar);
    }
}
