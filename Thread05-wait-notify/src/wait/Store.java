package wait;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-17 22:49
 */
public class Store {
    // 仓库的最大容量
    private int capacity;
    // 仓库的现有容量
    private int size;

    public Store(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 生产
     * @param count 一次生产的个数
     * @throws InterruptedException
     */
    public synchronized void produce(int count) throws InterruptedException {
        while (count > 0) {
            if (size >= capacity) {
                System.out.println("仓库满了!");
                this.wait();
            }
            // 计算能生产多少个
            int actAmount = (size + count) > capacity ? capacity-size : count;
            size += actAmount;
            System.out.println(Thread.currentThread().getName() + " 此次生产了" + actAmount + ", 本来应该生产: " + count);
            // 这次生产不了的等下次消费
            count -= actAmount;
            this.notifyAll();
        }
    }

    /**
     * 消费
     * @param count 消费数量
     */
    public synchronized void consume(int count) throws InterruptedException {
        while (count > 0) {
            if (size <= 0) {
                System.out.println("仓库没东西了");
                this.wait();
            }
            // 计算此次真实消费了多少个
            int actCount = count > size ? size : count;
            size -= actCount;
            System.out.println(Thread.currentThread() + " 此次消费了" + actCount + ", 本来应该消费: " + count);
            count -= actCount;
            // 通知生产者生产
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        Store store = new Store(100);
        new Thread(() -> {
            while(true) {
                // 先睡眠1s

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 在生产20个
                try {
                    store.produce(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者").start();

        new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    store.consume(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "消费者").start();
    }
}

