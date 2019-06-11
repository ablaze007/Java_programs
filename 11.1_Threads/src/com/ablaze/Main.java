/*
DESCRIPTION:
 * Create a producer and a consumer class that implements Runnable
 * Producer will writer some numbers to a buffer
 * Consumer will read the numbers from the same buffer
 * Buffer will be an ArrayList<String>
 * Instantiate a producer and two consumers, and start them
 * Synchronize the program using synchronized blocks
 *
 * Now use Reentrant lock to synchronize the program
 *
 * Use a ExecutorService to manage the threads
 */

package com.ablaze;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        List<Integer> buffer = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();

        ExecutorService service = Executors.newFixedThreadPool(3);

        Producer producer = new Producer(buffer, lock);
        Consumer consumer1 = new Consumer(buffer, Color.ANSI_GREEN, lock);
        Consumer consumer2 = new Consumer(buffer, Color.ANSI_BLUE, lock);
        Consumer consumer3 = new Consumer(buffer, Color.ANSI_RED, lock);

        service.execute(producer);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);
        service.shutdown();
    }
}

class Producer implements Runnable{
    List<Integer> buffer;
    ReentrantLock lock;

    Producer(List<Integer> buffer, ReentrantLock lock)
    {
        this.buffer = buffer;
        this.lock = lock;
    }

    @Override
    public void run() {
        int[] numbers = new int[]{1,2,3,4,5,-1};

        for(int num : numbers) {
            try {
                lock.lock();
                buffer.add(num);
                System.out.println(Color.ANSI_RESET + "Wrote - " + num);
                lock.unlock();
                Thread.sleep(new Random().nextInt(1500));
            } catch (InterruptedException e) {

            }
        }
    }
}

class Consumer implements Runnable{
    List<Integer> buffer;
    String color;
    ReentrantLock lock;

    Consumer(List<Integer> buffer, String color, ReentrantLock lock){
        this.buffer = buffer;
        this.color = color;
        this.lock = lock;
    }

    @Override
    public void run(){
        while(true)
        {
            lock.lock();
            try{
                if(buffer.isEmpty())
                    continue;
                try{
                    Thread.sleep(new Random().nextInt(500));
                }catch(InterruptedException e) {

                }
                if(buffer.get(0) == -1)
                    break;
                System.out.println(color+"Read - "+buffer.remove(0));
            } finally{
                lock.unlock();
            }
        }
        System.out.println(color+"Exiting...");
    }
}
