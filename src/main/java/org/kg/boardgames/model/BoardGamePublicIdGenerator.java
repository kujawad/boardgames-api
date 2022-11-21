package org.kg.boardgames.model;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class BoardGamePublicIdGenerator {

    private static final int VERSION = 1;

    static String generate() {
        return IntStream.range(0, 3)
                        .mapToObj(idx -> String.valueOf(ThreadLocalRandom.current()
                                                                         .nextInt(100, 999)))
                        .collect(Collectors.joining("", "BG" + VERSION, ""));
    }
}
