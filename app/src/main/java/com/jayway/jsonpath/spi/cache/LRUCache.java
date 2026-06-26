package com.jayway.jsonpath.spi.cache;

import com.jayway.jsonpath.JsonPath;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class LRUCache implements Cache {
    private final int limit;
    private final ReentrantLock lock = new ReentrantLock();
    private final Map<String, JsonPath> map = new ConcurrentHashMap();
    private final Deque<String> queue = new LinkedList();

    public LRUCache(int i2) {
        this.limit = i2;
    }

    private void addKey(String str) {
        this.lock.lock();
        try {
            this.queue.addFirst(str);
        } finally {
            this.lock.unlock();
        }
    }

    private void removeFirstOccurrence(String str) {
        this.lock.lock();
        try {
            this.queue.removeFirstOccurrence(str);
        } finally {
            this.lock.unlock();
        }
    }

    private String removeLast() {
        this.lock.lock();
        try {
            return this.queue.removeLast();
        } finally {
            this.lock.unlock();
        }
    }

    private void removeThenAddKey(String str) {
        this.lock.lock();
        try {
            this.queue.removeFirstOccurrence(str);
            this.queue.addFirst(str);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.jayway.jsonpath.spi.cache.Cache
    public JsonPath get(String str) {
        JsonPath jsonPath = this.map.get(str);
        if (jsonPath != null) {
            removeThenAddKey(str);
        }
        return jsonPath;
    }

    public JsonPath getSilent(String str) {
        return this.map.get(str);
    }

    @Override // com.jayway.jsonpath.spi.cache.Cache
    public void put(String str, JsonPath jsonPath) {
        if (this.map.put(str, jsonPath) != null) {
            removeThenAddKey(str);
        } else {
            addKey(str);
        }
        if (this.map.size() > this.limit) {
            this.map.remove(removeLast());
        }
    }

    public void remove(String str) {
        removeFirstOccurrence(str);
        this.map.remove(str);
    }

    public int size() {
        return this.map.size();
    }

    public String toString() {
        return this.map.toString();
    }
}
