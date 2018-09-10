import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<ObjectToPass> queue;
    private int id;
    private int fibMax;
    private int queueCapacity;
    private Object sharedLock;

    public Consumer(BlockingQueue<ObjectToPass> queue, int id, int fibMax, int queueCapacity, Object sharedLock) {
        this.queue = queue;
        this.id = id;
        this.fibMax = fibMax;
        this.queueCapacity = queueCapacity;
        this.sharedLock = sharedLock;
    }

    public int fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }


    @Override
    public void run() {
        System.out.println("I'm running consumer" + id);

        while (true) {

            synchronized (sharedLock) {

                while (queue.size() == 0) {
                    try {
                        sharedLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Object o = queue.remove();

                //* getting the startTime value and calculating the seconds

                long startTime = ((ObjectToPass) o).getStartTime();
                long timeTaskWasAquired = System.currentTimeMillis();
                long timeSpendAquiring = timeTaskWasAquired - startTime;

                System.out.println("KONS - " + id + " .Acquired task produced " + timeSpendAquiring + " seconds ago.");

                //* calculating Fibonacci using recursion

                int maxFib = ((ObjectToPass) o).getFib();
                int answer = fibonacci(maxFib);

                //* time spend calculating

                long timeSpendCalculating = timeTaskWasAquired - System.currentTimeMillis();

                System.out.println("KONS - " + id + " .Finished task produced " + timeSpendCalculating + " seconds ago. Calculated " + maxFib + "Fibonacci number equals" + answer + " in " + timeSpendCalculating + " miliseconds.");
                sharedLock.notify();
            }
        }


    }
}


