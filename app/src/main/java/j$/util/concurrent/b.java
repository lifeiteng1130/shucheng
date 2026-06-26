package j$.util.concurrent;

import j$.util.Map;
import j$.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public interface b<K, V> extends Map<K, V> {
    @Override // j$.util.Map
    void forEach(BiConsumer biConsumer);
}
