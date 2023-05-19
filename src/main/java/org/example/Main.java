package org.example;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        //defaultExecutor();
        virtualThreadExecutor();
    }

    static void defaultExecutor() {
        VirtualThreads virtualThreads = new VirtualThreads();

        int nThreads = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads); // empilha até 100 threads em paralelo

        Instant start = Instant.now();
        virtualThreads.executeTask(1000, executorService);
        Instant end = Instant.now();

        long seconds = ChronoUnit.SECONDS.between(start, end);
        System.out.println(String.format("Done in %d seconds with %d threads", seconds, nThreads));
    }

    static void virtualThreadExecutor() {
        VirtualThreads virtualThreads = new VirtualThreads();


        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        // nao se faz pool de threads, pois é um recurso barato. O sistema será gerenciado pela JVM

        Instant start = Instant.now();
        virtualThreads.executeTask(1000, executorService);
        Instant end = Instant.now();

        long seconds = ChronoUnit.SECONDS.between(start, end);
        System.out.println(String.format("Done in %d seconds with VirtualThreads", seconds));
    }
}