package learn.other;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class LatchDemo {

    private Sync sync = new Sync();

    //如果闭锁关闭那么等待
    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    //打开闭锁
    public void signal(){
        sync.release(0);
    }

    public static void main(String[] args) throws InterruptedException {
        final LatchDemo latchDemo = new LatchDemo();
        latchDemo.await();
//        latchDemo.signal();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latchDemo.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        a.join();
        System.out.println("finish");
    }


    private class Sync extends AbstractQueuedSynchronizer{

        @Override
        protected int tryAcquireShared(int arg) {
            return (getState() == 1) ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1);
            return true;
        }
    }

}
