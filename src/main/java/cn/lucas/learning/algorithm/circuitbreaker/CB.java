package cn.lucas.learning.algorithm.circuitbreaker;

/**
 * @author lucas
 * @date 2020-11-24
 */
public interface CB {

    boolean check();

    void update(boolean result);
}
