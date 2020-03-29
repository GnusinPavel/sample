package org.sample.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class CacheComputerTest {

    private CacheComputer<String, Integer> computer;

    @BeforeEach
    void setUp() {
        computer = new CacheComputer<>();
    }

    @Test
    void cacheComputingTest() throws ExecutionException, InterruptedException {
        final String key = "my_key";
        computer.compute(key, s -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            return 123;
        });
        final Future<Integer> actual = computer.compute(key, s -> 0);

        Assertions.assertEquals(123, actual.get());
    }
}