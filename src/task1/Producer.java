package task1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {


    private final BlockingQueue<ObjectToPass> queue;
    private int id;
    private int fibMax;
    private int queueCapacity;
    private Object sharedLock;

    public Producer(BlockingQueue<ObjectToPass> queue, int id, int fibMax, int queueCapacity, Object sharedLock) {
        this.queue = queue;
        this.id = id;
        this.fibMax = fibMax;
        this.queueCapacity = queueCapacity;
        this.sharedLock = sharedLock;
    }


    @Override
    public void run() {

        //System.out.println("I'm running producer" + id);

        while (true) {

            //* Getting the random number in range <1, fibMax>

            synchronized (sharedLock) {

                while (queue.size() == queueCapacity) {
                    try {
                        sharedLock.wait(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("PROD -" + id + "  TIMEOUT - Task refused");
                }

                Random random = new Random();
                int randomInt = random.nextInt(fibMax - 1) + 1;
                long startTime = System.currentTimeMillis();

                ObjectToPass o = new ObjectToPass(startTime, randomInt);

                queue.add(o);
                System.out.println("PROD - " + id + " Task enquened");
                sharedLock.notify();

            }

        }
    }
}

