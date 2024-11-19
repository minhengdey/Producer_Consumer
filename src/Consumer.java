import java.util.concurrent.ThreadLocalRandom;

public class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(ThreadLocalRandom.current().nextInt(50, 300));
                buffer.takeProduct();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
