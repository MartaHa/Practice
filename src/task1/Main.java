package task1;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        //*getting necessary information form the console;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the maximum Fibbonacci number: ");
        int fibMax = scanner.nextInt();

        System.out.println("Enter the maximum queue size: ");
        int queueCapacity = scanner.nextInt();

        System.out.println("Enter the max number of producer threads: ");
        int prodCount = scanner.nextInt();

        System.out.println("Enter the max number of consumer threads: ");
        int conCount = scanner.nextInt();


        //*creating shared queue
        BlockingQueue<ObjectToPass> queue = new ArrayBlockingQueue<ObjectToPass>(queueCapacity);

        //*creating shared lock
        Object sharedLock = new Object();



        //*creating Threads - producer

        ExecutorService executor = Executors.newFixedThreadPool(prodCount);
        try {
            for (int i = 1; i <= prodCount; i++) {
                executor.execute(new Producer(queue,i, fibMax, queueCapacity, sharedLock));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdown();


        ExecutorService executor2 = Executors.newFixedThreadPool(conCount);
        try {

            for (int j = 1; j <= conCount; j++) {
                executor2.execute(new Consumer(queue,j, fibMax, queueCapacity, sharedLock));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        executor2.shutdown();
        // shutting down the ExecutorService


    }

}


