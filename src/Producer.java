public class Producer extends Thread {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int count = 0;
        try {
            while (true) {
                Thread.sleep(50);
                buffer.addProduct(++ count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
