package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        VirtualThreads virtualThreads = new VirtualThreads();

        ExecutorService executorService = Executors.newFixedThreadPool(100); // empilha até 100 threads em paralelo
        virtualThreads.executeTask(1000, executorService);
    }
}