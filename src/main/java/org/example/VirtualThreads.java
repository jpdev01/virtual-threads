package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreads {

    private AtomicInteger counter = new AtomicInteger(0);

    public Runnable createTask() {
        return () -> {
            int taskId = counter.incrementAndGet();
            // simula IO (entrada e saida), nao usa somente cpu
            long timeout = (long) Math.random() * 1000 + 100;

            System.out.println(String.format("Task com id %d executing for %s", taskId, timeout));

            try {
                Thread.sleep(timeout);
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }

            System.out.println("Task done!");
        };
    }

    public void executeTask(int quantidadeTarefas, ExecutorService executor) {
        for (int i = 0; i < quantidadeTarefas; i++) {
            executor.execute(createTask());
        }

        executor.shutdown(); // nao receber mais nenhum agendamento
        try {
            executor.awaitTermination(180, TimeUnit.MINUTES);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}