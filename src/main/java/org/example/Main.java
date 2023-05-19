package org.example;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        VirtualThreads virtualThreads = new VirtualThreads();

        int nThreads = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads); // empilha até 100 threads em paralelo

        Instant start = Instant.now();
        virtualThreads.executeTask(1000, executorService);
        Instant end = Instant.now();

        long seconds = ChronoUnit.SECONDS.between(start, end);
        System.out.println(String.format("Done in %d seconds with %d threads", seconds, nThreads));
    }
}