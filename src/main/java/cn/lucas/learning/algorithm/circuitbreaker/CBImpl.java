package cn.lucas.learning.algorithm.circuitbreaker;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author lucas
 * @date 2020-11-24
 */
public class CBImpl implements CB {
    // 滑动窗口，单位毫秒
    private long slidingWindowMillis;
    // 错误率，范围0-100
    private BigDecimal errorRatio;
    // 熔断开关
    private AtomicBoolean isBreaked = new AtomicBoolean(false);
    // 统计队列（全部请求）
    private Queue<Long> total = new ConcurrentLinkedDeque<>();
    // 统计队列（错误请求）
    private Queue<Long> error = new ConcurrentLinkedDeque<>();

    public CBImpl() {
        this(10 * 1000L, new BigDecimal("0.5"));
    }

    public CBImpl(long slidingWindowMillis, BigDecimal errorRatio) {
        this.slidingWindowMillis = slidingWindowMillis;
        this.errorRatio = errorRatio;
        new Thread(() -> {
            while (true) {
                Long current = System.currentTimeMillis();
                Long before = current - slidingWindowMillis;
                if (!total.isEmpty() && total.peek() < before) {
                    total.poll();
                }
                if (!error.isEmpty() && error.peek() < before) {
                    error.poll();
                }
            }
        }).start();
    }

    @Override
    public boolean check() {
        if (isBreaked.get()) {
            return false;
        }
        System.out.println("当前错误率：" + errorRatio);
        if (errorRatio().compareTo(errorRatio) > 0) {
            breaked();
            return false;
        }
        System.out.println("------正常请求------");
        return true;
    }

    @Override
    public void update(boolean result) {
        Long current = System.currentTimeMillis();
        total.offer(current);
        if (!result) {
            error.offer(current);
        }
    }

    /**
     * 熔断
     */
    private void breaked() {
        System.out.println("------错误率超过" + errorRatio + "------");
        System.out.println("------熔断开始------" + new Date());
        isBreaked.set(true);
        total.clear();
        error.clear();
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isBreaked.set(false);
                timer.cancel();
                System.out.println("------熔断结束------" + new Date());
            }
        }, 5000L);
    }

    /**
     * 错误率
     *
     * @return
     */
    public BigDecimal errorRatio() {
        if (error.size() == 0 || total.size() == 0) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(error.size()).divide(new BigDecimal(total.size()), 4, BigDecimal.ROUND_HALF_UP);
    }
}
