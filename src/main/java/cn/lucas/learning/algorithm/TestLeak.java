package cn.lucas.learning.algorithm;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <>https://bugs.java.com/bugdatabase/view_bug.do?bug_id=8137184</>
 *
 * @author zhaoyao.yan@ximalaya.com
 * @date 2020-12-01
 */
public class TestLeak {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();
        queue.add(new Object()); //Required for the leak to appear.
        Object object = new Object();
        int loops = 0;
        Runtime rt = Runtime.getRuntime();
        long last = System.currentTimeMillis();
        while (true) {
            if (loops % 10000 == 0) {
                long now = System.currentTimeMillis();
                long duration = now - last;
                last = now;
                System.err.printf("duration=%d q.size=%d memory max=%d free=%d total=%d%n", duration, queue.size(), rt.maxMemory(), rt.freeMemory(), rt.totalMemory());
            }
            queue.add(object);
            queue.remove(object);
            ++loops;
        }
    }
}
