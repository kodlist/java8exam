package Concurrency;

/**
 * Created by mkoduri on 8/26/2018.
 */
public class ThreadStartJoin implements  Runnable{
    public ThreadStartJoin(String name) {
    }

    @Override
    public void run() {

        System.out.println(" thread :" + this.toString()+"  : "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        ThreadStartJoin  tx = new ThreadStartJoin("xyz thread");
        ThreadStartJoin  tx2 = new ThreadStartJoin("abc thread");
        Thread t1 = new Thread(tx);t1.setName(" xyz ");
        t1.start();
        Thread t2 = new Thread(tx2); t2.setName(" abc ");

        t2.start();


        while (true) {
            try {
                t1.join();  //The main thread that is calling t1.join() will stop running and wait for the t1 thread to finish.
                           // The t2 thread is running in parallel and is not affected by t1 or the t1.join() call at all.
                            //an important point to note down, t1 and t2 themselves can run in parallel irrespective of the join call sequence on t1 and t2.
                            // It is the main/daemon thread that has to wait.
                t2.join();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
