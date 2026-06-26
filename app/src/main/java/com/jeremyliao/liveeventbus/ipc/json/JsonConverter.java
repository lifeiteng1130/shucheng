package com.jeremyliao.liveeventbus.ipc.json;

/* JADX INFO: loaded from: classes.dex */
public interface JsonConverter {
    <T> T fromJson(String str, Class<T> cls);

    String toJson(Object obj);
}
