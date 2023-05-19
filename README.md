# Virtual threads
Serve para otimizar processos que envolvem entrada e saída.

Se fosse algo envolvendo apenas CPU, não haveria ganhos de desempenho. Ela não melhora desempenho de processamento. Apenas gerencia a utilização do recurso computacional, deixa a cargo da JVM.


## Como executar?

O Arquivo VirtualThreads contém exemplo de uso comparando o uso de Threads comuns e Virtual Threads. Para comparar basta trocar a instância do ExecutorService:

```java
ExecutorService executor = Executors.newFixedThreadPool(400); // Com pool de Threds
ExecutorService executorVirtual = Executors.newVirtualThreadPerTaskExecutor(); // Com Virtual Threads
```
Vídeo explicativo: https://youtu.be/6zr4h7a7ALA