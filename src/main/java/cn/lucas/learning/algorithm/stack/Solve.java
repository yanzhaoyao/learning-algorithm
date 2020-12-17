package cn.lucas.learning.algorithm.stack;

import java.util.Stack;

/**
 * @author lucas@ximalaya.com
 * @date 2020-11-20
 */
public class Solve {

    public static void main(String[] args) {
        String param = "(())()((()))";
        // ()()()
        System.out.println(slove(param));
    }


    public static String slove(String param) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < param.length(); i++) {
            if (stack.isEmpty() || stack.peek() != param.charAt(i)) {
                stack.push(param.charAt(i));
            }
        }
        char[] resultChar = new char[stack.size()];
        for (int i = resultChar.length - 1; i >= 0; i--) {
            resultChar[i] = stack.pop();
        }
        return new String(resultChar);
    }
}
