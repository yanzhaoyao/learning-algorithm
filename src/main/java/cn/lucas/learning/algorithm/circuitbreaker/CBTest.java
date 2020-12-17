package cn.lucas.learning.algorithm.circuitbreaker;

/**
 * @author lucas
 * @date 2020-11-24
 *
 * <p>
 * 单机接口QPS以万计，设计一个熔断
 * 器，每当最近10秒内的接口错误率
 * 超过50%，则强制进入5秒的熔断状态，
 * 5秒后恢复正常；
 * <p>
 * public void handle() {
 * if (cb.check()) {
 * boolean result = doBusiness();
 * cb.update(result);
 * }
 * }
 * public interface CB {
 * boolean check();
 * void update(boolean result);
 * }
 * </p>
 */
public class CBTest {

    private CB cb = new CBImpl();

    public void handle() {
        if (cb.check()) {
            boolean result = doBusiness();
            cb.update(result);
        }
    }

    /**
     * 模拟错误
     *
     * @return false 为错误请求 true为成功请求
     */
    private boolean doBusiness() {
        return Math.random() > 0.46;
    }

    public static void main(String[] args) throws InterruptedException {
        CBTest CBTest = new CBTest();
        while (true) {
            CBTest.handle();
            Thread.sleep(200L);
        }
    }

}
