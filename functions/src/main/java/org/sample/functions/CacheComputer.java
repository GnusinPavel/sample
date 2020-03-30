package org.sample.functions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.function.Function;

public class CacheComputer<K, V> implements Computing<K, V> {

    private final ConcurrentMap<K, Future<V>> cache = new ConcurrentHashMap<>();

    @Override
    public Future<V> compute(K key, Function<K, V> fn) {
        return cache.putIfAbsent(key, CompletableFuture.supplyAsync(() -> fn.apply(key)));
    }
}
