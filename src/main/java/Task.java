import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task {

    private int counter; // just counter, threads will write to this variable

    private final Lock lock = new ReentrantLock(); // new lock object for locking variable 'counter' öðó one thread write it

    private void increment() {
        for (int i = 0; i < 10000; i++) { // increment variable 'counter' for 0 to 10000
            counter++;
        }
    }

    // call first thread
    public void firstThread() {
        lock.lock(); // first thread lock variable 'counter' and write it
        System.out.println("First thread begin write variable 'counter'...");
        increment();
        System.out.println("First thread end write variable 'counter'...");
        lock.unlock(); // then the first thread unlocks that variable
    }

    public void secondThread() {
        lock.lock(); // second thread lock variable 'counter' and write it
        System.out.println("Second thread begin write variable 'counter'...");
        increment();
        System.out.println("Second thread end write variable 'counter'...");
        lock.unlock(); // then the second thread unlocks that variable
    }

    public void showCounter() {
        System.out.println("Value of variable 'counter' is : " + counter); // show value of variable 'counter'
    }
}
