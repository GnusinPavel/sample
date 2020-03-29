package org.sample.functions;

import java.util.concurrent.Future;
import java.util.function.Function;

@FunctionalInterface
public interface Computing<K, V> {
    Future<V> compute(K key, Function<K, V> fn);
}
