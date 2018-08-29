package Concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Created by mkoduri on 8/26/2018.
 */



class ProcessingThread implements Runnable {
    private int count;

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count++;
        }
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class AtomicOperations {

    public static void main(String[] args) throws InterruptedException {

        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Processing count=" + pt.getCount());


        AtomicInteger ai = new AtomicInteger();


        Stream<Integer> stream = Stream.of(11, 11, 22,12, 33).parallel();

        int i =        stream.filter( e->{     ai.incrementAndGet();
                            return e%2==0; }).findAny().get();
        System.out.println(i);



    }

}
