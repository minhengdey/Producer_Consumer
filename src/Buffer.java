import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private int capacity;
    private Queue<Integer> queue;

    public Buffer(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public synchronized void addProduct (int value) throws InterruptedException {
        while (this.queue.size() == capacity) {
            System.out.println("Buffer is full");
            System.out.println("----------------------------------");
            wait();
        }
        this.queue.add(value);
        System.out.println(">>> Produced: " + value);
        System.out.println("Number of products remaining: " + this.queue.size());
        System.out.println("----------------------------------");
        notifyAll();
    }

    public synchronized void takeProduct () throws InterruptedException {
        while (this.queue.isEmpty()) {
            System.out.println("Buffer is empty");
            System.out.println("----------------------------------");
            wait();
        }
        int value = this.queue.poll();
        System.out.println("<<< Consumed: " + value);
        System.out.println("Number of products remaining: " + this.queue.size());
        System.out.println("----------------------------------");
        notifyAll();
    }
}
