package cn.lucas.learning.algorithm;

import cn.lucas.learning.algorithm.node.Node;

/**
 * @author lucas
 * @date 2020-11-24
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Node node3 = new Node(3, null);
        Node node2 = new Node(2, node3);
        Node head = new Node(1, node2);
        print4(head);
    }

    public static void print2(Node head) {
        if (head != null) {
            print2(head.next);
            System.out.println(head.val);
        }
    }

    public static void print3(Node head) {
        if (head == null) {
            return;
        }
        Node tmpHead = head;
        Node waitChange = head.next;

        while (waitChange != null) {
            head.next = waitChange.next;
            waitChange.next = tmpHead;
            tmpHead = waitChange;
            waitChange = head.next;
        }
        while (tmpHead != null) {
            System.out.println(tmpHead.val);
            tmpHead = tmpHead.next;
        }

        // todo 翻转回去
    }

    public static void print4(Node head) {
        if (head == null) {
            return;
        }
        Node prev = head;
        Node current = head.next;
        prev.next = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        while (prev != null) {
            System.out.println(prev.val);
            prev = prev.next;
        }
    }

}

