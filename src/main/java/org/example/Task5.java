package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Task5 {

    public static void executeTask() throws InterruptedException {
        Queue<String> queue = new LinkedList<>();
        queue.add("First element");
        queue.add("Second element");
        queue.add("Third element");
        queue.add("Fourth element");
        queue.add("Fifth element");
        var processor = new QueueProcessor<>(queue);
        var thread = new Thread(processor::start);
        thread.start();
        Thread.sleep(2500);
        processor.stop();
    }

    private static class QueueProcessor<T> implements Task {

        public QueueProcessor(Queue<T> queue) {
            this.queue = queue;
        }

        private final Queue<T> queue;
        private boolean isStopped;
        @Override
        public void start() {
            isStopped = false;
            while (!isStopped && !queue.isEmpty()) {
                var curr = queue.poll();
                System.out.println("Processed element " + curr);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        @Override
        public void stop() {
            isStopped = true;
        }
    }

    private interface Task {

        /**
         * Запускает задачу
         */
        void start();
        /**
         * Останавливает задачу
         */
        void stop();
    }
}
